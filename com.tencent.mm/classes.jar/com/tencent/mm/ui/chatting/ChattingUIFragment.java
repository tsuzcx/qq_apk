package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.api.c.b;
import com.tencent.mm.autogen.a.br;
import com.tencent.mm.autogen.a.bs;
import com.tencent.mm.autogen.a.gg;
import com.tencent.mm.autogen.a.ow;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.tw;
import com.tencent.mm.autogen.mmdata.rpt.tx;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment;
import com.tencent.mm.chatting.a.d;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.brandservice.api.h.a;
import com.tencent.mm.plugin.expt.hellhound.ext.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.e;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.location.model.SubCoreLocation;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ab;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.component.api.ad;
import com.tencent.mm.ui.chatting.component.api.af;
import com.tencent.mm.ui.chatting.component.api.ah;
import com.tencent.mm.ui.chatting.component.api.ap;
import com.tencent.mm.ui.chatting.component.api.ba;
import com.tencent.mm.ui.chatting.component.api.n;
import com.tencent.mm.ui.chatting.component.api.r;
import com.tencent.mm.ui.chatting.component.api.u;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.chatting.component.s;
import com.tencent.mm.ui.chatting.f.b.a;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.k.a.g;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.OpenImKefuServiceChattingUI;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;
import com.tencent.mm.ui.widget.pulldown.f.a;
import java.util.LinkedList;
import java.util.List;

public class ChattingUIFragment
  extends BaseChattingUIFragment
{
  public static String acGe;
  private IListener Akp;
  private com.tencent.mm.plugin.expt.hellhound.ext.a.b.c RDc;
  private final com.tencent.mm.plugin.expt.hellhound.ext.a.b.d RDd;
  public com.tencent.mm.ui.chatting.a.a aekk;
  public ListView aekl;
  private Runnable aekm;
  private com.tencent.mm.ui.tools.q aekn;
  private MMChattingListView aeko;
  private boolean aekp;
  protected boolean aekq;
  private boolean aekr;
  private com.tencent.mm.ui.chatting.k.a.a aeks;
  private View.OnLayoutChangeListener aekt;
  private int mScrollState;
  private IListener rDF;
  private w tipDialog;
  private boolean vIl;
  private int vIt;
  private final int vIu;
  
  public ChattingUIFragment()
  {
    AppMethodBeat.i(254058);
    this.tipDialog = null;
    this.aekp = true;
    this.aekq = true;
    this.mScrollState = 0;
    this.vIl = false;
    this.aekr = false;
    this.vIt = 0;
    this.vIu = 10;
    this.aekt = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(34706);
        if ((paramAnonymousInt8 > 0) && (paramAnonymousInt8 > paramAnonymousInt4) && (((x)ChattingUIFragment.this.iNh().cm(x.class)).jsd().HDO)) {
          ChattingUIFragment.this.r(true, false, false);
        }
        AppMethodBeat.o(34706);
      }
    };
    this.RDd = new com.tencent.mm.plugin.expt.hellhound.ext.a.b.d()
    {
      public final void b(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(254377);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(254377);
          return;
        }
        if ((paramAnonymousInt1 < 0) || (paramAnonymousInt2 <= 0))
        {
          AppMethodBeat.o(254377);
          return;
        }
        paramAnonymousAbsListView = ChattingUIFragment.this.aekk;
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(254377);
          return;
        }
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).report21053(ChattingUIFragment.b(ChattingUIFragment.this), paramAnonymousAbsListView, c.e.zHn.state, paramAnonymousInt1, paramAnonymousInt2, 2L, "temp_6", 1, false);
        AppMethodBeat.o(254377);
      }
      
      public final void c(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(254381);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(254381);
          return;
        }
        paramAnonymousAbsListView = ChattingUIFragment.this.aekk;
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(254381);
          return;
        }
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).report21053(ChattingUIFragment.b(ChattingUIFragment.this), paramAnonymousAbsListView, c.e.zHn.state, paramAnonymousInt1, paramAnonymousInt2, 2L, "temp_6", 1, false);
        AppMethodBeat.o(254381);
      }
    };
    this.rDF = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Akp = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(254058);
  }
  
  public ChattingUIFragment(byte paramByte)
  {
    super(true);
    AppMethodBeat.i(254063);
    this.tipDialog = null;
    this.aekp = true;
    this.aekq = true;
    this.mScrollState = 0;
    this.vIl = false;
    this.aekr = false;
    this.vIt = 0;
    this.vIu = 10;
    this.aekt = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(34706);
        if ((paramAnonymousInt8 > 0) && (paramAnonymousInt8 > paramAnonymousInt4) && (((x)ChattingUIFragment.this.iNh().cm(x.class)).jsd().HDO)) {
          ChattingUIFragment.this.r(true, false, false);
        }
        AppMethodBeat.o(34706);
      }
    };
    this.RDd = new com.tencent.mm.plugin.expt.hellhound.ext.a.b.d()
    {
      public final void b(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(254377);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(254377);
          return;
        }
        if ((paramAnonymousInt1 < 0) || (paramAnonymousInt2 <= 0))
        {
          AppMethodBeat.o(254377);
          return;
        }
        paramAnonymousAbsListView = ChattingUIFragment.this.aekk;
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(254377);
          return;
        }
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).report21053(ChattingUIFragment.b(ChattingUIFragment.this), paramAnonymousAbsListView, c.e.zHn.state, paramAnonymousInt1, paramAnonymousInt2, 2L, "temp_6", 1, false);
        AppMethodBeat.o(254377);
      }
      
      public final void c(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(254381);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(254381);
          return;
        }
        paramAnonymousAbsListView = ChattingUIFragment.this.aekk;
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(254381);
          return;
        }
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).report21053(ChattingUIFragment.b(ChattingUIFragment.this), paramAnonymousAbsListView, c.e.zHn.state, paramAnonymousInt1, paramAnonymousInt2, 2L, "temp_6", 1, false);
        AppMethodBeat.o(254381);
      }
    };
    this.rDF = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Akp = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(254063);
  }
  
  private void bO(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    boolean bool1 = true;
    AppMethodBeat.i(254066);
    final int i = this.aekl.getLastVisiblePosition();
    int k = this.aekl.getFirstVisiblePosition();
    final int j = this.aekl.getCount();
    if (Log.getLogLevel() <= 1)
    {
      boolean bool2 = this.aekp;
      if (Looper.getMainLooper() == Looper.myLooper()) {
        Log.i("MicroMsg.ChattingUIFragment", "[scrollToLastImpl] isFirstScroll:%s [%s:%s] count:%s force:%s isMain:%s stack:%s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool1), Util.getStack() });
      }
    }
    else
    {
      this.aekp = false;
      if ((!paramBoolean1) || (i != k) || (i < j - 1) || (this.aekl.getChildCount() <= 0)) {
        break label216;
      }
      i = this.aekl.getChildAt(this.aekl.getChildCount() - 1).getHeight();
    }
    for (;;)
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        if ((paramBoolean1) && (this.aeko.dsq()))
        {
          Log.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom");
          AppMethodBeat.o(254066);
          return;
          bool1 = false;
          break;
          label216:
          i = 0;
          continue;
        }
        com.tencent.mm.pluginsdk.ui.tools.q.a(this.aekl, j - 1, -i, paramBoolean2, false);
        AppMethodBeat.o(254066);
        return;
      }
    }
    this.aekl.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34709);
        if ((paramBoolean1) && (ChattingUIFragment.a(ChattingUIFragment.this).dsq()))
        {
          Log.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom in post");
          AppMethodBeat.o(34709);
          return;
        }
        com.tencent.mm.pluginsdk.ui.tools.q.a(ChattingUIFragment.b(ChattingUIFragment.this), j - 1, -i, paramBoolean2, false);
        AppMethodBeat.o(34709);
      }
    });
    AppMethodBeat.o(254066);
  }
  
  private boolean jpV()
  {
    AppMethodBeat.i(34769);
    n localn = (n)iNh().cm(n.class);
    com.tencent.mm.ui.chatting.component.api.au localau = (com.tencent.mm.ui.chatting.component.api.au)iNh().cm(com.tencent.mm.ui.chatting.component.api.au.class);
    if (localn.jrJ())
    {
      if (localau.jtw())
      {
        localau.jtv();
        localn.jrK();
      }
      for (;;)
      {
        AppMethodBeat.o(34769);
        return true;
        localn.jrH();
      }
    }
    AppMethodBeat.o(34769);
    return false;
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(254300);
    if (this.aekk == null)
    {
      AppMethodBeat.o(254300);
      return;
    }
    com.tencent.mm.ui.chatting.a.a locala = this.aekk;
    if (locala.aenb != null) {
      locala.aenb.a(parama, false, null);
    }
    AppMethodBeat.o(254300);
  }
  
  public final void aBP(int paramInt)
  {
    AppMethodBeat.i(254200);
    try
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.aeko.getLayoutParams();
      localLayoutParams.topMargin = paramInt;
      this.aeko.setLayoutParams(localLayoutParams);
      Log.d("MicroMsg.ChattingUIFragment", "setTopMarginHeight height:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(254200);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ChattingUIFragment", "setTopMarginHeight height:%s, %s, %s", new Object[] { Integer.valueOf(paramInt), localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(254200);
    }
  }
  
  public final void aBQ(int paramInt)
  {
    AppMethodBeat.i(34747);
    this.aekl.setVisibility(paramInt);
    if (Log.getLogLevel() == 2) {
      Log.i("MicroMsg.ChattingUIFragment", "[setListViewVisibility] visibility:" + paramInt + " stack:" + Util.getStack().toString());
    }
    AppMethodBeat.o(34747);
  }
  
  public final void aDM()
  {
    AppMethodBeat.i(34735);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(34735);
  }
  
  protected final void aE(com.tencent.mm.storage.au paramau)
  {
    AppMethodBeat.i(34752);
    super.aE(paramau);
    acGe = paramau.field_username;
    AppMethodBeat.o(34752);
  }
  
  public final void b(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    AppMethodBeat.i(254148);
    iNh();
    com.tencent.mm.ui.chatting.d.a.juI().removeCallbacks(this.aekm);
    Log.i("MicroMsg.ChattingUIFragment", "[setSelection] pos:%d isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1) });
    ListView localListView = this.aekl;
    if ((localListView != null) && ((!com.tencent.mm.pluginsdk.ui.tools.q.d(localListView, paramInt1)) || (!paramBoolean2)))
    {
      Log.i("MicroMsg.ChattingUI.ScrollController", "setSelection position %s smooth %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1) });
      localListView.setItemChecked(paramInt1, true);
      if ((paramBoolean1) && (!com.tencent.mm.pluginsdk.ui.tools.q.c(localListView, paramInt1)))
      {
        localListView.smoothScrollToPositionFromTop(paramInt1, paramInt2, 200);
        AppMethodBeat.o(254148);
        return;
      }
      localListView.setSelectionFromTop(paramInt1, paramInt2);
    }
    AppMethodBeat.o(254148);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(254162);
    aDM();
    this.tipDialog = com.tencent.mm.ui.base.k.a(paramContext, paramString2, true, paramOnCancelListener);
    AppMethodBeat.o(254162);
  }
  
  public final void bV(Bundle paramBundle)
  {
    AppMethodBeat.i(34742);
    this.aeko.bV(paramBundle);
    AppMethodBeat.o(34742);
  }
  
  public final void bW(Bundle paramBundle)
  {
    AppMethodBeat.i(34744);
    this.aeko.c(true, paramBundle);
    AppMethodBeat.o(34744);
  }
  
  public final void dcZ()
  {
    AppMethodBeat.i(34724);
    if (this.aekk == null)
    {
      AppMethodBeat.o(34724);
      return;
    }
    this.aekk.notifyDataSetChanged();
    AppMethodBeat.o(34724);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(34718);
    super.dealContentView(paramView);
    ((ad)iNh().cm(ad.class)).lk(paramView);
    AppMethodBeat.o(34718);
  }
  
  public void doPause()
  {
    AppMethodBeat.i(34756);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V", this);
    super.doPause();
    if (t.isEnable()) {
      t.dismiss();
    }
    Log.i("MicroMsg.ChattingUIFragment", "on chatting ui pause  rawuser:%s", new Object[] { iNh().getTalkerUserName() });
    if (iNh().getTalkerUserName() == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V");
      AppMethodBeat.o(34756);
      return;
    }
    this.rDF.dead();
    this.Akp.dead();
    this.aekk.pause();
    hideVKB();
    Log.d("MicroMsg.ChattingUIFragment", "chattingui cancel pause auto download logic");
    com.tencent.mm.ui.chatting.a.a locala = this.aekk;
    if (locala != null) {
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).report21053(this.aekl, locala, c.e.zHq.state, -1, -1, 2L, "temp_6", 3, false);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V");
    AppMethodBeat.o(34756);
  }
  
  public void doResume()
  {
    AppMethodBeat.i(34755);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V", this);
    super.doResume();
    if (getWindow() != null) {
      getWindow().setBackgroundDrawableResource(R.e.fkX);
    }
    boolean bool1;
    boolean bool2;
    if (getContentView() != null)
    {
      bool1 = getContentView().isShown();
      if (getView() == null) {
        break label153;
      }
      bool2 = getView().isShown();
      label73:
      if (this.aekl.getVisibility() != 0) {
        break label158;
      }
    }
    label153:
    label158:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (isForeground()) {
        break label163;
      }
      Log.i("MicroMsg.ChattingUIFragment", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b listviewShow:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
      AppMethodBeat.o(34755);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label73;
    }
    label163:
    if (!bh.baz())
    {
      Log.w("MicroMsg.ChattingUIFragment", "account not ready, mabey not call onDestroy!!!");
      finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
      AppMethodBeat.o(34755);
      return;
    }
    this.rDF.alive();
    this.Akp.alive();
    this.aekk.resume();
    com.tencent.mm.ui.chatting.a.a locala = this.aekk;
    if (locala != null) {
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).report21053(this.aekl, locala, c.e.zHp.state, -1, -1, 2L, "temp_6", 2, false);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
    AppMethodBeat.o(34755);
  }
  
  public void finish()
  {
    AppMethodBeat.i(34770);
    iNh().aezN.onFinish();
    Object localObject = (x)iNh().cm(x.class);
    if ((localObject != null) && (((x)localObject).jsd() != null)) {
      ((x)localObject).jsd().Kb(true);
    }
    if (!hideVKB()) {}
    for (int i = 0;; i = 100)
    {
      localObject = new Runnable()
      {
        public final void run()
        {
          boolean bool2 = true;
          boolean bool1 = true;
          int i = 0;
          AppMethodBeat.i(34715);
          Log.i("MicroMsg.ChattingUIFragment", "[finish] isCurrentActivity:%s", new Object[] { Boolean.valueOf(ChattingUIFragment.this.isCurrentActivity) });
          if (ChattingUIFragment.this.isCurrentActivity)
          {
            ChattingUIFragment.h(ChattingUIFragment.this);
            AppMethodBeat.o(34715);
            return;
          }
          Object localObject;
          if ((ChattingUIFragment.this.thisActivity() instanceof LauncherUI))
          {
            localObject = (LauncherUI)ChattingUIFragment.this.thisActivity();
            if (localObject != null)
            {
              if (!ChattingUIFragment.this.isSupportNavigationSwipeBack()) {}
              for (;;)
              {
                ((LauncherUI)localObject).closeChatting(bool1);
                AppMethodBeat.o(34715);
                return;
                bool1 = false;
              }
            }
            Log.e("MicroMsg.ChattingUIFragment", "LauncherUI is null!???");
            AppMethodBeat.o(34715);
            return;
          }
          if ((ChattingUIFragment.this.thisActivity() instanceof BaseConversationUI))
          {
            localObject = (BaseConversationUI)ChattingUIFragment.this.thisActivity();
            if (localObject != null) {
              if (ChattingUIFragment.this.isSupportNavigationSwipeBack()) {
                break label182;
              }
            }
            label182:
            for (bool1 = bool2;; bool1 = false)
            {
              ((BaseConversationUI)localObject).closeChatting(bool1);
              AppMethodBeat.o(34715);
              return;
            }
          }
          if ((ChattingUIFragment.this.thisActivity() instanceof a.d))
          {
            ((a.d)ChattingUIFragment.this.thisActivity()).aNY();
            AppMethodBeat.o(34715);
            return;
          }
          if (ChattingUIFragment.this.thisActivity().getSupportFragmentManager().getFragments().size() > 0)
          {
            localObject = ChattingUIFragment.this.thisActivity().getSupportFragmentManager().getFragments();
            while (i < ((List)localObject).size())
            {
              Fragment localFragment = (Fragment)((List)localObject).get(i);
              if ((localFragment instanceof BasePrivateMsgConvListFragment))
              {
                ((BasePrivateMsgConvListFragment)localFragment).lPD.aNY();
                AppMethodBeat.o(34715);
                return;
              }
              i += 1;
            }
          }
          AppMethodBeat.o(34715);
        }
      };
      if (i == 0)
      {
        ((Runnable)localObject).run();
        AppMethodBeat.o(34770);
        return;
      }
      MMHandlerThread.postToMainThreadDelayed((Runnable)localObject, 100L);
      AppMethodBeat.o(34770);
      return;
    }
  }
  
  public void gDP()
  {
    AppMethodBeat.i(34773);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      ah aekx;
      String username;
      
      public final void run()
      {
        AppMethodBeat.i(34708);
        long l = System.currentTimeMillis();
        if (this.aekx == null)
        {
          Log.e("MicroMsg.ChattingUIFragment", "messBoxComponent == null! without writeOpLogAndMarkRead!");
          AppMethodBeat.o(34708);
          return;
        }
        this.aekx.bAR(this.username);
        Log.i("MicroMsg.ChattingUIFragment", "ChattingUI writeOpLogAndMarkRead last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(34708);
      }
    }, "MicroMsg.ChattingUIFragment");
    AppMethodBeat.o(34773);
  }
  
  public final boolean gPQ()
  {
    AppMethodBeat.i(254170);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      AppMethodBeat.o(254170);
      return true;
    }
    AppMethodBeat.o(254170);
    return false;
  }
  
  public int getCustomBounceId()
  {
    return R.h.fyt;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(34749);
    int i = this.aekl.getFirstVisiblePosition();
    AppMethodBeat.o(34749);
    return i;
  }
  
  public int getLayoutId()
  {
    return R.i.chatting;
  }
  
  public final ListView getListView()
  {
    return this.aekl;
  }
  
  public boolean getUserVisibleHint()
  {
    AppMethodBeat.i(254219);
    boolean bool = iNh().ffv;
    AppMethodBeat.o(254219);
    return bool;
  }
  
  public final void h(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(254154);
    iNh();
    com.tencent.mm.ui.chatting.d.a.juI().removeCallbacks(this.aekm);
    Log.i("MicroMsg.ChattingUIFragment", "[setSelectionFromTop] pos:%d offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1) });
    if (!iNh().aezS)
    {
      com.tencent.mm.pluginsdk.ui.tools.q.a(this.aekl, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(254154);
      return;
    }
    ListView localListView = this.aekl;
    if ((localListView != null) && (!com.tencent.mm.pluginsdk.ui.tools.q.d(localListView, paramInt1)))
    {
      Log.i("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop position %s smooth %s", new Object[] { Integer.valueOf(paramInt1), Boolean.TRUE });
      localListView.setItemChecked(paramInt1, true);
      if ((com.tencent.mm.compatible.util.d.rd(11)) && (!com.tencent.mm.pluginsdk.ui.tools.q.c(localListView, paramInt1)))
      {
        localListView.smoothScrollToPositionFromTop(paramInt1, paramInt2, 200);
        AppMethodBeat.o(254154);
        return;
      }
      localListView.setSelectionFromTop(paramInt1, paramInt2);
    }
    AppMethodBeat.o(254154);
  }
  
  public boolean hideVKB()
  {
    AppMethodBeat.i(34733);
    ChatFooter localChatFooter = ((x)iNh().cm(x.class)).jsd();
    if (localChatFooter != null)
    {
      bool = localChatFooter.hideVKB();
      AppMethodBeat.o(34733);
      return bool;
    }
    boolean bool = super.hideVKB();
    AppMethodBeat.o(34733);
    return bool;
  }
  
  public final void iKP()
  {
    AppMethodBeat.i(254251);
    super.iKP();
    AppMethodBeat.o(254251);
  }
  
  public boolean isSupportCustomActionBar()
  {
    AppMethodBeat.i(34751);
    boolean bool = isSupportNavigationSwipeBack();
    AppMethodBeat.o(34751);
    return bool;
  }
  
  public final void joO()
  {
    AppMethodBeat.i(34757);
    super.joO();
    if (iNh().getTalkerUserName() == null)
    {
      AppMethodBeat.o(34757);
      return;
    }
    AppMethodBeat.o(34757);
  }
  
  public final ab joS()
  {
    AppMethodBeat.i(34750);
    if (iNh().cm(ad.class) == null)
    {
      AppMethodBeat.o(34750);
      return null;
    }
    ab localab = ((ad)iNh().cm(ad.class)).joS();
    AppMethodBeat.o(34750);
    return localab;
  }
  
  public final boolean joU()
  {
    AppMethodBeat.i(34763);
    if (!isScreenEnable())
    {
      Log.w("MicroMsg.ChattingUIFragment", "Actionbar customView onclick screen not enable");
      AppMethodBeat.o(34763);
      return true;
    }
    hideVKB();
    if (getActivity() != null)
    {
      View localView = getActivity().findViewById(R.h.fMr);
      if (localView == null) {
        break label82;
      }
      localView.setVisibility(0);
      localView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34713);
          ChattingUIFragment.this.jpT();
          AppMethodBeat.o(34713);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(34763);
      return true;
      label82:
      jpT();
    }
  }
  
  public final com.tencent.mm.ui.chatting.k.a.a joV()
  {
    return this.aeks;
  }
  
  public final void joW()
  {
    AppMethodBeat.i(34771);
    if ((this.aeko == null) || (this.aekk == null))
    {
      AppMethodBeat.o(34771);
      return;
    }
    Object localObject1 = iNh();
    Object localObject2 = new com.tencent.mm.ui.chatting.f.a(iNh(), this.aekk.aemP);
    com.tencent.mm.ui.chatting.f.b localb = new com.tencent.mm.ui.chatting.f.b(iNh(), this.aeko);
    localObject2 = new com.tencent.mm.ui.chatting.f.e(localb, (com.tencent.mm.ui.chatting.f.c)localObject2);
    if (((com.tencent.mm.ui.chatting.component.api.e)((com.tencent.mm.ui.chatting.d.a)localObject1).cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqV()) {
      localObject1 = new com.tencent.mm.ui.chatting.k.a.b((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.f.e)localObject2);
    }
    for (;;)
    {
      localb.aeHP = ((b.a)localObject1);
      Log.i("MicroMsg.ChattingLoader.ChattingDataPresenterFactory", "[ChattingDataPresenterFactory] executor:%s", new Object[] { ((com.tencent.mm.ui.chatting.k.a.a)localObject1).toString() });
      this.aeks = ((com.tencent.mm.ui.chatting.k.a.a)localObject1);
      this.aekk.aenb = this.aeks;
      this.aeko.setLoadExecutor(this.aeks);
      AppMethodBeat.o(34771);
      return;
      if (((com.tencent.mm.ui.chatting.component.api.y)((com.tencent.mm.ui.chatting.d.a)localObject1).cm(com.tencent.mm.ui.chatting.component.api.y.class)).jss()) {
        localObject1 = new com.tencent.mm.ui.chatting.k.a.d((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.f.d)localObject2);
      } else if ((((com.tencent.mm.ui.chatting.component.api.au)((com.tencent.mm.ui.chatting.d.a)localObject1).cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtA()) || (((com.tencent.mm.ui.chatting.component.api.au)((com.tencent.mm.ui.chatting.d.a)localObject1).cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtB()) || (((com.tencent.mm.ui.chatting.component.api.au)((com.tencent.mm.ui.chatting.d.a)localObject1).cm(com.tencent.mm.ui.chatting.component.api.au.class)).jty()) || ((((com.tencent.mm.ui.chatting.component.api.au)((com.tencent.mm.ui.chatting.d.a)localObject1).cm(com.tencent.mm.ui.chatting.component.api.au.class)).jtD()) && (!((com.tencent.mm.ui.chatting.component.api.q)((com.tencent.mm.ui.chatting.d.a)localObject1).cm(com.tencent.mm.ui.chatting.component.api.q.class)).jrP())) || (((ap)((com.tencent.mm.ui.chatting.d.a)localObject1).cm(ap.class)).jtn())) {
        localObject1 = new com.tencent.mm.ui.chatting.k.a.f((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.f.d)localObject2);
      } else if ((((com.tencent.mm.ui.chatting.component.api.i)((com.tencent.mm.ui.chatting.d.a)localObject1).cm(com.tencent.mm.ui.chatting.component.api.i.class)).jrA()) || (((r)((com.tencent.mm.ui.chatting.d.a)localObject1).cm(r.class)).jrT()) || (((com.tencent.mm.ui.chatting.component.api.k)((com.tencent.mm.ui.chatting.d.a)localObject1).cm(com.tencent.mm.ui.chatting.component.api.k.class)).jrF())) {
        localObject1 = new com.tencent.mm.ui.chatting.k.a.c((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.f.e)localObject2);
      } else if (((com.tencent.mm.ui.chatting.component.api.q)((com.tencent.mm.ui.chatting.d.a)localObject1).cm(com.tencent.mm.ui.chatting.component.api.q.class)).jrP()) {
        localObject1 = new com.tencent.mm.ui.chatting.k.a.h((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.f.d)localObject2);
      } else if (((com.tencent.mm.ui.chatting.component.api.q)((com.tencent.mm.ui.chatting.d.a)localObject1).cm(com.tencent.mm.ui.chatting.component.api.q.class)).jrQ()) {
        localObject1 = new g((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.f.e)localObject2);
      } else {
        localObject1 = new com.tencent.mm.ui.chatting.k.a.e((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.f.e)localObject2);
      }
    }
  }
  
  public void jou()
  {
    AppMethodBeat.i(34754);
    this.aekr = false;
    this.aekp = true;
    this.aekq = true;
    Log.d("MicroMsg.ChattingUIFragment", "isFromSearch  " + getBooleanExtra("finish_direct", false));
    int i;
    String str;
    Object localObject2;
    int j;
    label137:
    Object localObject1;
    if (iNh().Uxa == null)
    {
      i = 1;
      Log.i("MicroMsg.ChattingUIFragment", "[doCreate] rawUserName from :%s to :%s ", new Object[] { iNh().getTalkerUserName(), getStringExtra("Chat_User") });
      bAy(getStringExtra("Chat_Self"));
      str = getStringExtra("Chat_User");
      bh.bCz();
      localObject2 = com.tencent.mm.model.c.bzA().JE(str);
      if (localObject2 != null) {
        break label383;
      }
      j = -1;
      if (localObject2 != null) {
        break label393;
      }
      localObject1 = "null";
      label146:
      Log.w("MicroMsg.ChattingUIFragment", "protectContactNotExist raw:%s contact:%d username:%s", new Object[] { str, Integer.valueOf(j), localObject1 });
      if ((localObject2 != null) && ((int)((com.tencent.mm.contact.d)localObject2).maN != 0) && (!Util.isNullOrNil(((az)localObject2).field_username))) {
        break label402;
      }
      localObject2 = new com.tencent.mm.storage.au();
      ((com.tencent.mm.storage.au)localObject2).setUsername(str);
      ((com.tencent.mm.storage.au)localObject2).adie = str;
      ((com.tencent.mm.storage.au)localObject2).aRL();
      ((com.tencent.mm.storage.au)localObject2).pu(3);
      bh.bCz();
      com.tencent.mm.model.c.bzA().aA((com.tencent.mm.storage.au)localObject2);
      bh.bCz();
      com.tencent.mm.storage.au localau = com.tencent.mm.model.c.bzA().JE(str);
      localObject1 = localau;
      if (localau != null) {
        break label405;
      }
      Log.e("MicroMsg.ChattingUIFragment", "protectContactNotExist contact get from db is null!");
    }
    for (;;)
    {
      aE((com.tencent.mm.storage.au)localObject2);
      ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiA(iNh().getTalkerUserName());
      super.jou();
      if (isSupportNavigationSwipeBack())
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().init();
      }
      if (i != 0)
      {
        iNh();
        com.tencent.mm.ui.chatting.d.a.juI().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34710);
            ((ad)ChattingUIFragment.this.iNh().cm(ad.class)).jsG();
            ((ad)ChattingUIFragment.this.iNh().cm(ad.class)).jrB();
            AppMethodBeat.o(34710);
          }
        });
      }
      jow();
      com.tencent.mm.plugin.groupsolitaire.b.b.aHM(iNh().getTalkerUserName());
      AppMethodBeat.o(34754);
      return;
      i = 0;
      break;
      label383:
      j = (int)((com.tencent.mm.contact.d)localObject2).maN;
      break label137;
      label393:
      localObject1 = ((az)localObject2).field_username;
      break label146;
      label402:
      localObject1 = localObject2;
      label405:
      if (com.tencent.mm.storage.au.bwS(str))
      {
        Log.i("MicroMsg.ChattingUIFragment", "[protectContactNotExist] isBottleContact userName:".concat(String.valueOf(str)));
        ((com.tencent.mm.storage.au)localObject1).adie = str;
        ((com.tencent.mm.storage.au)localObject1).setUsername(str);
      }
      if (com.tencent.mm.storage.au.bxf(str))
      {
        localObject2 = new tx();
        ((tx)localObject2).jvV = 1L;
        ((tx)localObject2).bMH();
      }
      localObject2 = localObject1;
      if (com.tencent.mm.storage.au.bxh(str))
      {
        localObject2 = new tw();
        ((tw)localObject2).jvV = 1L;
        ((tw)localObject2).bMH();
        localObject2 = localObject1;
      }
    }
  }
  
  protected void jow()
  {
    AppMethodBeat.i(34772);
    this.RDc = new com.tencent.mm.plugin.expt.hellhound.ext.a.b.c(this.RDd, "ChattingUIFragment", c.a.zEw);
    this.mScrollState = 0;
    this.aeko = ((MMChattingListView)findViewById(R.h.fyt));
    this.aeko.setIsReturnSuperDispatchWhenCancel(true);
    this.aekl = this.aeko.getListView();
    this.aekl.setVisibility(0);
    ((ad)iNh().cm(ad.class)).jsB();
    if (this.aeko.getBaseAdapter() == null)
    {
      this.aekk = new com.tencent.mm.ui.chatting.a.a(iNh(), this.aekl);
      this.aeko.setAdapter(this.aekk);
    }
    Object localObject = this.aeko;
    ((MMChattingListView)localObject).LC(false);
    ((MMChattingListView)localObject).LC(false);
    joW();
    this.aeks.a(d.a.aeHT, true, null);
    this.aekl.setOverScrollMode(2);
    ((com.tencent.mm.ui.chatting.component.api.au)iNh().cm(com.tencent.mm.ui.chatting.component.api.au.class)).jty();
    this.aekl.setOnTouchListener(new View.OnTouchListener()
    {
      boolean RXF = false;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(253744);
        ChattingUIFragment.i(ChattingUIFragment.this);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          Log.i("MicroMsg.ChattingUIFragment", "onTouch: touch down");
          this.RXF = true;
        }
        while ((!this.RXF) || (!ChattingUIFragment.this.aekq))
        {
          AppMethodBeat.o(253744);
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1)
          {
            Log.i("MicroMsg.ChattingUIFragment", "onTouch: touch up");
            this.RXF = false;
          }
        }
        paramAnonymousView = (x)ChattingUIFragment.this.iNh().cm(x.class);
        if ((paramAnonymousView == null) || (paramAnonymousView.jsd() == null))
        {
          AppMethodBeat.o(253744);
          return false;
        }
        paramAnonymousView.jsd().Kb(true);
        AppMethodBeat.o(253744);
        return false;
      }
    });
    localObject = getBounceView();
    if ((localObject != null) && (iNh() != null)) {
      ((com.tencent.mm.ui.widget.pulldown.f)localObject).a((f.a)iNh().cm(u.class));
    }
    this.aekl.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      private boolean aekw = false;
      
      private void jpW()
      {
        AppMethodBeat.i(253630);
        Object localObject = ChattingUIFragment.b(ChattingUIFragment.this).getChildAt(0);
        int i;
        if (localObject != null)
        {
          if (((View)localObject).getTop() != 0) {
            break label105;
          }
          Log.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load top more!");
          if ((ChattingUIFragment.this.getBounceView() == null) || (ChattingUIFragment.this.getBounceView().getOffset() == 0)) {
            break label93;
          }
          i = 1;
          localObject = ChattingUIFragment.a(ChattingUIFragment.this);
          if (i == 0) {
            break label98;
          }
          i = 0;
          label76:
          ((MMChattingListView)localObject).as(true, i);
        }
        for (;;)
        {
          this.aekw = false;
          AppMethodBeat.o(253630);
          return;
          label93:
          i = 0;
          break;
          label98:
          i = 200;
          break label76;
          label105:
          if (((View)localObject).getTop() < 0)
          {
            Log.w("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] exception auto load top more wit reset adapter!");
            ChattingUIFragment.a(ChattingUIFragment.this).setAdapter(ChattingUIFragment.this.aekk);
          }
        }
      }
      
      /* Error */
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: ldc 95
        //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: aload_0
        //   8: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:aekv	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
        //   11: invokevirtual 99	com/tencent/mm/ui/chatting/ChattingUIFragment:joP	()Lcom/tencent/mm/ui/chatting/component/s;
        //   14: aload_1
        //   15: iload_2
        //   16: iload_3
        //   17: iload 4
        //   19: invokevirtual 103	com/tencent/mm/ui/chatting/component/s:onScroll	(Landroid/widget/AbsListView;III)V
        //   22: aload_0
        //   23: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:aekv	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
        //   26: invokestatic 107	com/tencent/mm/ui/chatting/ChattingUIFragment:d	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)I
        //   29: ifne +27 -> 56
        //   32: aload_0
        //   33: getfield 23	com/tencent/mm/ui/chatting/ChattingUIFragment$2:aekw	Z
        //   36: ifeq +20 -> 56
        //   39: aload_0
        //   40: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:aekv	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
        //   43: invokestatic 36	com/tencent/mm/ui/chatting/ChattingUIFragment:b	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Landroid/widget/ListView;
        //   46: invokevirtual 110	android/widget/ListView:getFirstVisiblePosition	()I
        //   49: ifne +7 -> 56
        //   52: aload_0
        //   53: invokespecial 112	com/tencent/mm/ui/chatting/ChattingUIFragment$2:jpW	()V
        //   56: aload_0
        //   57: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:aekv	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
        //   60: invokestatic 116	com/tencent/mm/ui/chatting/ChattingUIFragment:j	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
        //   63: ifeq +36 -> 99
        //   66: aload_0
        //   67: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:aekv	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
        //   70: invokestatic 36	com/tencent/mm/ui/chatting/ChattingUIFragment:b	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Landroid/widget/ListView;
        //   73: invokevirtual 119	android/widget/ListView:getLastVisiblePosition	()I
        //   76: iload 4
        //   78: iconst_1
        //   79: isub
        //   80: if_icmpeq +11 -> 91
        //   83: ldc 95
        //   85: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   88: aload_0
        //   89: monitorexit
        //   90: return
        //   91: aload_0
        //   92: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:aekv	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
        //   95: invokestatic 122	com/tencent/mm/ui/chatting/ChattingUIFragment:k	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
        //   98: pop
        //   99: aload_0
        //   100: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:aekv	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
        //   103: aload_1
        //   104: iload_2
        //   105: iload_3
        //   106: invokestatic 125	com/tencent/mm/ui/chatting/ChattingUIFragment:a	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;Landroid/widget/AbsListView;II)V
        //   109: ldc 95
        //   111: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   114: goto -26 -> 88
        //   117: astore_1
        //   118: aload_0
        //   119: monitorexit
        //   120: aload_1
        //   121: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	122	0	this	2
        //   0	122	1	paramAnonymousAbsListView	AbsListView
        //   0	122	2	paramAnonymousInt1	int
        //   0	122	3	paramAnonymousInt2	int
        //   0	122	4	paramAnonymousInt3	int
        // Exception table:
        //   from	to	target	type
        //   2	56	117	finally
        //   56	88	117	finally
        //   91	99	117	finally
        //   99	114	117	finally
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(253640);
        ChattingUIFragment.this.joP().onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
        ChattingUIFragment.a(ChattingUIFragment.this, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          Log.d("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] [%s:%s]", new Object[] { Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition()), Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition()) });
          int i;
          LinkedList localLinkedList;
          label220:
          Object localObject2;
          if (ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() == 0)
          {
            jpW();
            ChattingUIFragment.this.aekk.gt(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
            com.tencent.mm.ui.chatting.a.a locala = ChattingUIFragment.this.aekk;
            i = ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition();
            int k = ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount();
            int j = ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition();
            if (locala.adHw == null) {
              break label561;
            }
            localObject1 = locala.adHw.Uxa;
            if ((localObject1 == null) || (((com.tencent.mm.storage.au)localObject1).iZC())) {
              break label561;
            }
            localLinkedList = new LinkedList();
            i -= k;
            if (i > j) {
              break label500;
            }
            localObject1 = locala.aBY(i);
            if (localObject1 != null)
            {
              localObject2 = ((fi)localObject1).field_content;
              if (localObject2 != null)
              {
                localObject1 = k.b.aP((String)localObject2, ((fi)localObject1).field_reserved);
                if ((localObject1 != null) && (((k.b)localObject1).type == 5) && (!TextUtils.isEmpty(((k.b)localObject1).url)))
                {
                  localObject2 = new h.a();
                  ((h.a)localObject2).url = ((k.b)localObject1).url;
                  ((h.a)localObject2).vAZ = 1;
                  ((h.a)localObject2).appId = ((k.b)localObject1).appId;
                  ((h.a)localObject2).title = ((k.b)localObject1).title;
                  ((h.a)localObject2).desc = ((k.b)localObject1).description;
                  if (!locala.adHw.juG()) {
                    break label492;
                  }
                }
              }
            }
          }
          label492:
          for (Object localObject1 = "groupmessage";; localObject1 = "singlemessage")
          {
            ((h.a)localObject2).from = ((String)localObject1);
            localLinkedList.add(localObject2);
            i += 1;
            break label220;
            if (ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition() == ChattingUIFragment.b(ChattingUIFragment.this).getCount() - 1)
            {
              localObject1 = ChattingUIFragment.b(ChattingUIFragment.this).getChildAt(ChattingUIFragment.b(ChattingUIFragment.this).getChildCount() - 1);
              if ((localObject1 == null) || (ChattingUIFragment.b(ChattingUIFragment.this).getBottom() - ChattingUIFragment.a(ChattingUIFragment.this).getBottomHeight() < ((View)localObject1).getBottom())) {
                break;
              }
              Log.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load bottom more!");
              ChattingUIFragment.a(ChattingUIFragment.this).LC(true);
              break;
            }
            this.aekw = true;
            break;
          }
          label500:
          if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class) != null) && (localLinkedList.size() > 0))
          {
            Log.v("MicroMsg.ChattingDataAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
            ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).z(localLinkedList, 2);
          }
        }
        label561:
        ChattingUIFragment.a(ChattingUIFragment.this, paramAnonymousAbsListView, paramAnonymousInt);
        AppMethodBeat.o(253640);
      }
    });
    this.aekl.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(253617);
        ChattingUIFragment.this.aekk.gt(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
        ChattingUIFragment.b(ChattingUIFragment.this).removeOnLayoutChangeListener(this);
        AppMethodBeat.o(253617);
      }
    });
    this.aeko.addOnLayoutChangeListener(this.aekt);
    if ((this.nCq) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(2)))
    {
      localObject = iNh();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).Uxa;
        if ((localObject != null) && (((com.tencent.mm.storage.au)localObject).iZC())) {
          ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GW(0);
        }
      }
    }
    registerForContextMenu(this.aekl);
    AppMethodBeat.o(34772);
  }
  
  public final void jpJ()
  {
    AppMethodBeat.i(34725);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      r(false, bool, true);
      AppMethodBeat.o(34725);
      return;
    }
  }
  
  public final void jpK()
  {
    AppMethodBeat.i(254136);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      r(true, bool, true);
      AppMethodBeat.o(254136);
      return;
    }
  }
  
  public final void jpL()
  {
    AppMethodBeat.i(34730);
    Log.i("MicroMsg.ChattingUIFragment", "[smoothScrollBy] dis:%d duration:%d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.aekl.smoothScrollBy(0, 0);
    AppMethodBeat.o(34730);
  }
  
  public final void jpM()
  {
    AppMethodBeat.i(254181);
    this.aeko.setBottomViewVisible(true);
    AppMethodBeat.o(254181);
  }
  
  public final void jpN()
  {
    AppMethodBeat.i(34738);
    this.aeko.setTopViewVisible(true);
    AppMethodBeat.o(34738);
  }
  
  public final void jpO()
  {
    AppMethodBeat.i(34739);
    this.aeko.setIsTopShowAll(false);
    AppMethodBeat.o(34739);
  }
  
  public final void jpP()
  {
    AppMethodBeat.i(254206);
    this.aeko.LC(true);
    AppMethodBeat.o(254206);
  }
  
  public final void jpQ()
  {
    AppMethodBeat.i(34748);
    this.aekl.setTranscriptMode(0);
    AppMethodBeat.o(34748);
  }
  
  public final MMChattingListView jpR()
  {
    return this.aeko;
  }
  
  public final void jpS()
  {
    AppMethodBeat.i(34761);
    Object localObject1 = (com.tencent.mm.ui.chatting.component.api.au)iNh().cm(com.tencent.mm.ui.chatting.component.api.au.class);
    Object localObject2 = (ap)iNh().cm(ap.class);
    if ((!((com.tencent.mm.ui.chatting.component.api.au)localObject1).jty()) && (!((com.tencent.mm.ui.chatting.component.api.au)localObject1).jtA()) && (!((com.tencent.mm.ui.chatting.component.api.au)localObject1).jtB()) && (!((ap)localObject2).jtm()) && (!((com.tencent.mm.ui.chatting.component.api.au)localObject1).jtD()))
    {
      int i = this.vIt;
      this.vIt = (i + 1);
      if ((i < 10) && (((thisActivity() instanceof ChattingUI)) || ((thisActivity() instanceof AppBrandServiceChattingUI)) || ((thisActivity() instanceof OpenImKefuServiceChattingUI))))
      {
        localObject1 = this.aekl;
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34711);
            if ((ChattingUIFragment.c(ChattingUIFragment.this)) || (ChattingUIFragment.d(ChattingUIFragment.this) != 0))
            {
              ChattingUIFragment.e(ChattingUIFragment.this);
              Log.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect userTouched: %s state: %s", new Object[] { Boolean.valueOf(ChattingUIFragment.c(ChattingUIFragment.this)), Integer.valueOf(ChattingUIFragment.d(ChattingUIFragment.this)) });
              AppMethodBeat.o(34711);
              return;
            }
            int i = ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition();
            int j = ChattingUIFragment.b(ChattingUIFragment.this).getCount() - 1;
            Log.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", new Object[] { Integer.valueOf(ChattingUIFragment.f(ChattingUIFragment.this)), Integer.valueOf(i), Integer.valueOf(j) });
            if (i < j)
            {
              ChattingUIFragment.g(ChattingUIFragment.this);
              ChattingUIFragment.this.jpS();
              AppMethodBeat.o(34711);
              return;
            }
            ChattingUIFragment.e(ChattingUIFragment.this);
            AppMethodBeat.o(34711);
          }
        };
        if (this.vIt == 1) {}
        for (i = 10;; i = 100)
        {
          ((ListView)localObject1).postDelayed((Runnable)localObject2, i);
          AppMethodBeat.o(34761);
          return;
        }
      }
    }
    Log.d("MicroMsg.ChattingUIFragment", "scrollToLastProtect:%s, %s ,%s", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.component.api.au)localObject1).jty()), Boolean.valueOf(((com.tencent.mm.ui.chatting.component.api.au)localObject1).jtA()), Integer.valueOf(this.vIt) });
    AppMethodBeat.o(34761);
  }
  
  protected final void jpT()
  {
    AppMethodBeat.i(34764);
    ((ba)iNh().cm(ba.class)).ba(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34714);
        ChattingUIFragment.this.onExitBegin();
        if ((ChattingUIFragment.this.thisActivity() instanceof a.d)) {
          ((a.d)ChattingUIFragment.this.thisActivity()).aNX();
        }
        if ((ChattingUIFragment.this.isCurrentActivity) || (!ChattingUIFragment.this.isSupportNavigationSwipeBack()))
        {
          ChattingUIFragment.this.jpU();
          AppMethodBeat.o(34714);
          return;
        }
        SwipeBackLayout localSwipeBackLayout = ChattingUIFragment.this.getSwipeBackLayout();
        Log.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", new Object[] { Boolean.valueOf(localSwipeBackLayout.mqz), Boolean.valueOf(localSwipeBackLayout.mqx), Boolean.valueOf(localSwipeBackLayout.mqy) });
        if (!localSwipeBackLayout.aXg())
        {
          com.tencent.mm.ui.widget.l.bk(0.0F);
          localSwipeBackLayout.mqz = true;
          localSwipeBackLayout.mqy = false;
          int i = localSwipeBackLayout.mContentView.getWidth();
          int j = localSwipeBackLayout.mqu.getIntrinsicWidth();
          localSwipeBackLayout.afVp.b(localSwipeBackLayout.mContentView, i + j + 10, 260L);
          localSwipeBackLayout.invalidate();
          if (localSwipeBackLayout.afVs != null) {
            localSwipeBackLayout.afVs.onDrag();
          }
          com.tencent.mm.ui.widget.l.g(true, 0);
        }
        AppMethodBeat.o(34714);
      }
    });
    AppMethodBeat.o(34764);
  }
  
  protected final void jpU()
  {
    AppMethodBeat.i(34768);
    if (getBooleanExtra("MainUI_FromFinderNotification", false).booleanValue())
    {
      localObject = (com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class);
      if ((localObject != null) && ((thisActivity() instanceof LauncherUI))) {
        ((com.tencent.mm.plugin.l)localObject).R(thisActivity(), 2);
      }
      if (getArguments() != null) {
        getArguments().remove("MainUI_FromFinderNotification");
      }
    }
    jpV();
    Object localObject = (com.tencent.mm.ui.chatting.component.api.e)iNh().cm(com.tencent.mm.ui.chatting.component.api.e.class);
    if (com.tencent.mm.storage.au.bwL(iNh().getTalkerUserName()))
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      com.tencent.mm.br.c.b(getContext(), "tmessage", ".ui.TConversationUI", (Intent)localObject);
    }
    do
    {
      for (;;)
      {
        finish();
        AppMethodBeat.o(34768);
        return;
        if (getIntExtra("chat_from_scene", 0) == 4)
        {
          finish();
          AppMethodBeat.o(34768);
          return;
        }
        if (((getIntExtra("chat_from_scene", 0) == 1) || (getIntExtra("chat_from_scene", 0) == 3)) && (iNh().Uxa != null) && (iNh().Uxa.iZC()) && (((com.tencent.mm.ui.chatting.component.api.e)localObject).jqS() != null) && (((com.tencent.mm.ui.chatting.component.api.e)localObject).jqS().aAQ()) && (((com.tencent.mm.ui.chatting.component.api.e)localObject).jqS().dO(false) != null) && (((com.tencent.mm.ui.chatting.component.api.e)localObject).jqS().dO(false).aBr() != null) && (!Util.isNullOrNil(((com.tencent.mm.ui.chatting.component.api.e)localObject).jqS().aAX())))
        {
          finish();
          AppMethodBeat.o(34768);
          return;
        }
        if (!((af)iNh().cm(af.class)).jtc()) {
          break;
        }
        finish();
      }
    } while (getBooleanExtra("finish_direct", false).booleanValue());
    if (!this.isCurrentActivity)
    {
      finish();
      AppMethodBeat.o(34768);
      return;
    }
    localObject = new Intent(getContext(), LauncherUI.class);
    ((Intent)localObject).addFlags(67108864);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    overridePendingTransition(MMFragmentActivity.a.upW, MMFragmentActivity.a.upX);
    finish();
    AppMethodBeat.o(34768);
  }
  
  public final void nj(Context paramContext)
  {
    AppMethodBeat.i(34753);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramContext);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doAttach", "(Landroid/content/Context;)V", this, localb.aYj());
    super.nj(paramContext);
    Log.i("MicroMsg.ChattingUIFragment", "[doAttach]:%s#0x%x task:%s hc:%d", new Object[] { thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), Util.getActivityTaskInfo(thisActivity()), Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.cD(3, true);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doAttach", "(Landroid/content/Context;)V");
    AppMethodBeat.o(34753);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34774);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 30763) || (paramInt1 == 30762))
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(34774);
        return;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getBundleExtra("result_data");
          if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
          {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acXn, Boolean.TRUE);
            if (paramInt1 == 30763)
            {
              com.tencent.mm.pluginsdk.permission.b.a(getActivity(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 67);
              AppMethodBeat.o(34774);
              return;
            }
            com.tencent.mm.pluginsdk.permission.b.a(getActivity(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 68);
          }
        }
      }
    }
    AppMethodBeat.o(34774);
  }
  
  public void onCancelDrag()
  {
    AppMethodBeat.i(34767);
    if ((isSupportNavigationSwipeBack()) && (this.aekk != null)) {
      this.aekq = true;
    }
    AppMethodBeat.o(34767);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    AppMethodBeat.i(34717);
    if (!isForeground())
    {
      AppMethodBeat.o(34717);
      return;
    }
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    AppMethodBeat.o(34717);
  }
  
  public void onDragBegin()
  {
    AppMethodBeat.i(34766);
    super.onDragBegin();
    if ((isSupportNavigationSwipeBack()) && (this.aekk != null)) {
      this.aekq = false;
    }
    AppMethodBeat.o(34766);
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34758);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onEnterBegin", "()V", this);
    super.onEnterBegin();
    gDP();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onEnterBegin", "()V");
    AppMethodBeat.o(34758);
  }
  
  public final void onExitBegin()
  {
    AppMethodBeat.i(34759);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitBegin", "()V", this);
    super.onExitBegin();
    Object localObject = this.aekk;
    ((com.tencent.mm.ui.chatting.a.a)localObject).aemS = -1L;
    ((com.tencent.mm.ui.chatting.a.a)localObject).aemR.clear();
    this.aeks.aeJO.cancel();
    gDP();
    new br().publish();
    new bs().publish();
    localObject = com.tencent.mm.ui.report.d.afBU;
    com.tencent.mm.ui.report.d.jCr();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitBegin", "()V");
    AppMethodBeat.o(34759);
  }
  
  public final void onExitEnd()
  {
    AppMethodBeat.i(34760);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitEnd", "()V", this);
    super.onExitEnd();
    aDM();
    ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).cancelCirculationFillingActivityIconOfSourceType(2);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitEnd", "()V");
    AppMethodBeat.o(34760);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(34762);
    if (keyboardState() == 1) {
      this.aekl.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34712);
          ChattingUIFragment.this.r(true, false, true);
          AppMethodBeat.o(34712);
        }
      });
    }
    AppMethodBeat.o(34762);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(34775);
    super.onMultiWindowModeChanged(paramBoolean);
    Log.i("MicroMsg.ChattingUIFragment", "onMultiWindowModeChanged: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ChatFooter localChatFooter = ((x)iNh().cm(x.class)).jsd();
    if (localChatFooter != null) {
      localChatFooter.setIsMultiWindow(paramBoolean);
    }
    AppMethodBeat.o(34775);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(34765);
    Log.w("MicroMsg.ChattingUIFragment", "onSwipeBack");
    jpU();
    if (SubCoreLocation.fUB().fUG())
    {
      gg localgg = new gg();
      localgg.hGt.username = com.tencent.mm.bd.d.oXO.bNG();
      localgg.publish();
    }
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    AppMethodBeat.o(34765);
  }
  
  public final void r(final boolean paramBoolean1, boolean paramBoolean2, final boolean paramBoolean3)
  {
    AppMethodBeat.i(254138);
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.ChattingUIFragment", "scrollToLast() called with: force = [" + paramBoolean1 + "], needRunnable = [" + paramBoolean2 + "] isSmooth:" + paramBoolean3 + ",stack:" + Util.getStack());
    }
    if (paramBoolean2)
    {
      iNh();
      com.tencent.mm.ui.chatting.d.a.juI().removeCallbacks(this.aekm);
      iNh();
      MMHandler localMMHandler = com.tencent.mm.ui.chatting.d.a.juI();
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34702);
          ChattingUIFragment.a(ChattingUIFragment.this, paramBoolean1, paramBoolean3);
          AppMethodBeat.o(34702);
        }
      };
      this.aekm = local1;
      localMMHandler.post(local1);
      AppMethodBeat.o(254138);
      return;
    }
    bO(paramBoolean1, paramBoolean3);
    AppMethodBeat.o(254138);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(34729);
    iNh();
    com.tencent.mm.ui.chatting.d.a.juI().removeCallbacks(this.aekm);
    Log.i("MicroMsg.ChattingUIFragment", "[scrollToPosition] scroll to pos:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.aekn == null) {
      this.aekn = new com.tencent.mm.ui.tools.q(this.aekl);
    }
    com.tencent.mm.ui.tools.q localq = this.aekn;
    int i = paramInt + this.aekl.getHeaderViewsCount();
    localq.bEw.removeCallbacks(localq);
    localq.afKm = System.currentTimeMillis();
    localq.afKr = 0;
    paramInt = localq.bEw.getFirstVisiblePosition();
    int j = localq.bEw.getChildCount() + paramInt - 1;
    if (i <= paramInt)
    {
      paramInt = paramInt - i + 1;
      localq.mMode = 2;
      if (paramInt <= 0) {
        break label213;
      }
    }
    label213:
    for (localq.afKp = (1000 / paramInt);; localq.afKp = 1000)
    {
      localq.afKn = i;
      localq.afKo = -1;
      localq.bEw.post(localq);
      AppMethodBeat.o(34729);
      return;
      if (i >= j)
      {
        paramInt = i - j + 1;
        localq.mMode = 1;
        break;
      }
      AppMethodBeat.o(34729);
      return;
    }
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(34723);
    ((ad)iNh().cm(ad.class)).setBackBtn(paramOnMenuItemClickListener);
    AppMethodBeat.o(34723);
  }
  
  public final void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(34740);
    this.aeko.setIsBottomShowAll(paramBoolean);
    AppMethodBeat.o(34740);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(34736);
    if (this.aekl != null) {
      this.aekl.setKeepScreenOn(paramBoolean);
    }
    AppMethodBeat.o(34736);
  }
  
  public void setMMSubTitle(int paramInt)
  {
    AppMethodBeat.i(34722);
    setMMSubTitle(getMMString(paramInt));
    AppMethodBeat.o(34722);
  }
  
  public void setMMSubTitle(String paramString)
  {
    AppMethodBeat.i(34721);
    ((ad)iNh().cm(ad.class)).setMMSubTitle(paramString);
    AppMethodBeat.o(34721);
  }
  
  public void setMMTitle(int paramInt)
  {
    AppMethodBeat.i(34719);
    setMMTitle(getMMString(paramInt));
    AppMethodBeat.o(34719);
  }
  
  public void setMMTitle(String paramString)
  {
    AppMethodBeat.i(34720);
    ((ad)iNh().cm(ad.class)).setMMTitle(paramString);
    AppMethodBeat.o(34720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */