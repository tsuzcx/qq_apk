package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.api.c.b;
import com.tencent.mm.f.a.bi;
import com.tencent.mm.f.a.bj;
import com.tencent.mm.f.a.fv;
import com.tencent.mm.f.a.no;
import com.tencent.mm.f.a.np;
import com.tencent.mm.f.b.a.qd;
import com.tencent.mm.f.b.a.qe;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.j.a.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.brandservice.a.f.a;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.e;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.d.b.o;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.d.b.v;
import com.tencent.mm.ui.chatting.h.b.a;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.o.a.g;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mm.ui.widget.j;
import com.tencent.mm.ui.widget.pulldown.e.a;
import com.tencent.mm.ui.z;
import java.util.LinkedList;

@SuppressLint({"ValidFragment"})
public class ChattingUIFragment
  extends BaseChattingUIFragment
{
  public static String VeI;
  private com.tencent.mm.plugin.expt.hellhound.a.a.b.c LcU;
  private final com.tencent.mm.plugin.expt.hellhound.a.a.b.e LcV;
  public com.tencent.mm.ui.chatting.a.a WCR;
  public ListView WCS;
  private Runnable WCT;
  private com.tencent.mm.ui.tools.r WCU;
  private MMChattingListView WCV;
  private boolean WCW;
  protected boolean WCX;
  private boolean WCY;
  private com.tencent.mm.ui.chatting.o.a.a WCZ;
  private int mScrollState;
  private IListener ozM;
  private final int sCA;
  private boolean sCt;
  private int sCz;
  private s tipDialog;
  private IListener wNM;
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment()
  {
    AppMethodBeat.i(284006);
    this.tipDialog = null;
    this.WCW = true;
    this.WCX = true;
    this.mScrollState = 0;
    this.sCt = false;
    this.WCY = false;
    this.sCz = 0;
    this.sCA = 10;
    this.LcV = new com.tencent.mm.plugin.expt.hellhound.a.a.b.e()
    {
      public final void b(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(287541);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(287541);
          return;
        }
        if ((paramAnonymousInt1 < 0) || (paramAnonymousInt2 <= 0))
        {
          AppMethodBeat.o(287541);
          return;
        }
        paramAnonymousAbsListView = ChattingUIFragment.this.WCR;
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(287541);
          return;
        }
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).report21053(ChattingUIFragment.b(ChattingUIFragment.this), paramAnonymousAbsListView, c.e.wli.state, paramAnonymousInt1, paramAnonymousInt2, 2L, "temp_6", 1, false);
        AppMethodBeat.o(287541);
      }
      
      public final void c(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(287542);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(287542);
          return;
        }
        paramAnonymousAbsListView = ChattingUIFragment.this.WCR;
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(287542);
          return;
        }
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).report21053(ChattingUIFragment.b(ChattingUIFragment.this), paramAnonymousAbsListView, c.e.wli.state, paramAnonymousInt1, paramAnonymousInt2, 2L, "temp_6", 1, false);
        AppMethodBeat.o(287542);
      }
    };
    this.ozM = new IListener() {};
    this.wNM = new IListener() {};
    AppMethodBeat.o(284006);
  }
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment(byte paramByte)
  {
    super(true);
    AppMethodBeat.i(284007);
    this.tipDialog = null;
    this.WCW = true;
    this.WCX = true;
    this.mScrollState = 0;
    this.sCt = false;
    this.WCY = false;
    this.sCz = 0;
    this.sCA = 10;
    this.LcV = new com.tencent.mm.plugin.expt.hellhound.a.a.b.e()
    {
      public final void b(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(287541);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(287541);
          return;
        }
        if ((paramAnonymousInt1 < 0) || (paramAnonymousInt2 <= 0))
        {
          AppMethodBeat.o(287541);
          return;
        }
        paramAnonymousAbsListView = ChattingUIFragment.this.WCR;
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(287541);
          return;
        }
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).report21053(ChattingUIFragment.b(ChattingUIFragment.this), paramAnonymousAbsListView, c.e.wli.state, paramAnonymousInt1, paramAnonymousInt2, 2L, "temp_6", 1, false);
        AppMethodBeat.o(287541);
      }
      
      public final void c(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(287542);
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(287542);
          return;
        }
        paramAnonymousAbsListView = ChattingUIFragment.this.WCR;
        if (paramAnonymousAbsListView == null)
        {
          AppMethodBeat.o(287542);
          return;
        }
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).report21053(ChattingUIFragment.b(ChattingUIFragment.this), paramAnonymousAbsListView, c.e.wli.state, paramAnonymousInt1, paramAnonymousInt2, 2L, "temp_6", 1, false);
        AppMethodBeat.o(287542);
      }
    };
    this.ozM = new IListener() {};
    this.wNM = new IListener() {};
    AppMethodBeat.o(284007);
  }
  
  private void Gj(final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(34728);
    int m = this.WCS.getLastVisiblePosition();
    int n = this.WCS.getFirstVisiblePosition();
    final int k = this.WCS.getCount();
    Log.i("MicroMsg.ChattingUIFragment", "[scrollToLastImpl] isFirstScroll:%s [%s:%s] count:%s force:%s", new Object[] { Boolean.valueOf(this.WCW), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
    this.WCW = false;
    final int i = j;
    if (paramBoolean)
    {
      i = j;
      if (m == n)
      {
        i = j;
        if (m >= k - 1)
        {
          i = j;
          if (this.WCS.getChildCount() > 0) {
            i = this.WCS.getChildAt(this.WCS.getChildCount() - 1).getHeight();
          }
        }
      }
    }
    if ((paramBoolean) && (this.WCV.cOL())) {
      Log.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom");
    }
    for (;;)
    {
      this.WCS.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34709);
          if ((paramBoolean) && (ChattingUIFragment.a(ChattingUIFragment.this).cOL()))
          {
            Log.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom in post");
            AppMethodBeat.o(34709);
            return;
          }
          com.tencent.mm.pluginsdk.ui.tools.r.a(ChattingUIFragment.b(ChattingUIFragment.this), k - 1, -i, true);
          AppMethodBeat.o(34709);
        }
      });
      AppMethodBeat.o(34728);
      return;
      com.tencent.mm.pluginsdk.ui.tools.r.a(this.WCS, k - 1, -i, true);
    }
  }
  
  private boolean hNr()
  {
    AppMethodBeat.i(34769);
    l locall = (l)this.fgR.bC(l.class);
    an localan = (an)this.fgR.bC(an.class);
    if (locall.hOT())
    {
      if (localan.hQu())
      {
        localan.hQt();
        locall.hOU();
      }
      for (;;)
      {
        AppMethodBeat.o(34769);
        return true;
        locall.hOR();
      }
    }
    AppMethodBeat.o(34769);
    return false;
  }
  
  public final void Gi(boolean paramBoolean)
  {
    AppMethodBeat.i(34726);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      bp(paramBoolean, bool);
      AppMethodBeat.o(34726);
      return;
    }
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(284029);
    if (this.WCR == null)
    {
      AppMethodBeat.o(284029);
      return;
    }
    com.tencent.mm.ui.chatting.a.a locala = this.WCR;
    if (locala.WFB != null) {
      locala.WFB.a(parama, false, null);
    }
    AppMethodBeat.o(284029);
  }
  
  public final void avn(int paramInt)
  {
    AppMethodBeat.i(34731);
    com.tencent.mm.ui.chatting.e.a.hRl().removeCallbacks(this.WCT);
    Log.i("MicroMsg.ChattingUIFragment", "[setSelection] pos:%d isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    ListView localListView = this.WCS;
    if (localListView != null)
    {
      Log.i("MicroMsg.ChattingUI.ScrollController", "setSelection position %s smooth %s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
      localListView.setItemChecked(paramInt, true);
      localListView.setSelection(paramInt);
    }
    AppMethodBeat.o(34731);
  }
  
  public final void avo(int paramInt)
  {
    AppMethodBeat.i(284016);
    try
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.WCV.getLayoutParams();
      localLayoutParams.topMargin = paramInt;
      this.WCV.setLayoutParams(localLayoutParams);
      Log.d("MicroMsg.ChattingUIFragment", "setTopMarginHeight height:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(284016);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ChattingUIFragment", "setTopMarginHeight height:%s, %s, %s", new Object[] { Integer.valueOf(paramInt), localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(284016);
    }
  }
  
  public final void avp(int paramInt)
  {
    AppMethodBeat.i(34747);
    this.WCS.setVisibility(paramInt);
    if (Log.getLogLevel() == 2) {
      Log.i("MicroMsg.ChattingUIFragment", "[setListViewVisibility] visibility:" + paramInt + " stack:" + Util.getStack().toString());
    }
    AppMethodBeat.o(34747);
  }
  
  protected final void ay(as paramas)
  {
    AppMethodBeat.i(34752);
    super.ay(paramas);
    VeI = paramas.field_username;
    AppMethodBeat.o(34752);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(284010);
    dismissDialog();
    this.tipDialog = com.tencent.mm.ui.base.h.a(paramContext, paramString2, true, paramOnCancelListener);
    AppMethodBeat.o(284010);
  }
  
  public final void bp(Bundle paramBundle)
  {
    AppMethodBeat.i(34742);
    this.WCV.bp(paramBundle);
    AppMethodBeat.o(34742);
  }
  
  @Deprecated
  public final void bp(final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(34727);
    if (paramBoolean2)
    {
      com.tencent.mm.ui.chatting.e.a.hRl().removeCallbacks(this.WCT);
      MMHandler localMMHandler = com.tencent.mm.ui.chatting.e.a.hRl();
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34702);
          ChattingUIFragment.a(ChattingUIFragment.this, paramBoolean1);
          AppMethodBeat.o(34702);
        }
      };
      this.WCT = local1;
      localMMHandler.post(local1);
      AppMethodBeat.o(34727);
      return;
    }
    Gj(paramBoolean1);
    AppMethodBeat.o(34727);
  }
  
  public final void bq(Bundle paramBundle)
  {
    AppMethodBeat.i(34744);
    this.WCV.c(true, paramBundle);
    AppMethodBeat.o(34744);
  }
  
  public final void cAe()
  {
    AppMethodBeat.i(34724);
    if (this.WCR == null)
    {
      AppMethodBeat.o(34724);
      return;
    }
    this.WCR.notifyDataSetChanged();
    AppMethodBeat.o(34724);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(34718);
    super.dealContentView(paramView);
    ((aa)this.fgR.bC(aa.class)).hN(paramView);
    AppMethodBeat.o(34718);
  }
  
  public final void dismissDialog()
  {
    AppMethodBeat.i(34735);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(34735);
  }
  
  public void doPause()
  {
    AppMethodBeat.i(34756);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V", this);
    super.doPause();
    if (r.isEnable()) {
      r.dismiss();
    }
    Log.i("MicroMsg.ChattingUIFragment", "on chatting ui pause  rawuser:%s", new Object[] { this.fgR.getTalkerUserName() });
    if (this.fgR.getTalkerUserName() == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V");
      AppMethodBeat.o(34756);
      return;
    }
    this.ozM.dead();
    this.wNM.dead();
    this.WCR.pause();
    hideVKB();
    Log.d("MicroMsg.ChattingUIFragment", "chattingui cancel pause auto download logic");
    com.tencent.mm.ui.chatting.a.a locala = this.WCR;
    if (locala != null) {
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).report21053(this.WCS, locala, c.e.wll.state, -1, -1, 2L, "temp_6", 3, false);
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
      getWindow().setBackgroundDrawableResource(R.e.dkI);
    }
    boolean bool1;
    boolean bool2;
    if (getContentView() != null)
    {
      bool1 = getContentView().isShown();
      if (getView() == null) {
        break label156;
      }
      bool2 = getView().isShown();
      label73:
      if (this.WCS.getVisibility() != 0) {
        break label161;
      }
    }
    label156:
    label161:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (this.fgR.dgo) {
        break label166;
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
    label166:
    if (!bh.aHB())
    {
      Log.w("MicroMsg.ChattingUIFragment", "account not ready, mabey not call onDestroy!!!");
      finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
      AppMethodBeat.o(34755);
      return;
    }
    this.ozM.alive();
    this.wNM.alive();
    this.WCR.resume();
    com.tencent.mm.ui.chatting.a.a locala = this.WCR;
    if (locala != null) {
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).report21053(this.WCS, locala, c.e.wlk.state, -1, -1, 2L, "temp_6", 2, false);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
    AppMethodBeat.o(34755);
  }
  
  public void finish()
  {
    AppMethodBeat.i(34770);
    this.fgR.WQu.onFinish();
    Object localObject = (u)this.fgR.bC(u.class);
    if ((localObject != null) && (((u)localObject).hPj() != null)) {
      ((u)localObject).hPj().Eq(true);
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
          AppMethodBeat.i(34715);
          Log.i("MicroMsg.ChattingUIFragment", "[finish] isCurrentActivity:%s", new Object[] { Boolean.valueOf(ChattingUIFragment.this.isCurrentActivity) });
          if (ChattingUIFragment.this.isCurrentActivity)
          {
            ChattingUIFragment.g(ChattingUIFragment.this);
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
                break label174;
              }
            }
            label174:
            for (bool1 = bool2;; bool1 = false)
            {
              ((BaseConversationUI)localObject).closeChatting(bool1);
              AppMethodBeat.o(34715);
              return;
            }
          }
          if ((ChattingUIFragment.this.thisActivity() instanceof a.d)) {
            ((a.d)ChattingUIFragment.this.thisActivity()).atB();
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
  
  public void fsh()
  {
    AppMethodBeat.i(34773);
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      ae WDb;
      String username;
      
      public final void run()
      {
        AppMethodBeat.i(272609);
        long l = System.currentTimeMillis();
        if (this.WDb == null)
        {
          Log.e("MicroMsg.ChattingUIFragment", "messBoxComponent == null! without writeOpLogAndMarkRead!");
          AppMethodBeat.o(272609);
          return;
        }
        this.WDb.bzo(this.username);
        Log.i("MicroMsg.ChattingUIFragment", "ChattingUI writeOpLogAndMarkRead last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(272609);
      }
    }, "MicroMsg.ChattingUIFragment");
    AppMethodBeat.o(34773);
  }
  
  public int getCustomBounceId()
  {
    return R.h.dxL;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(34749);
    int i = this.WCS.getFirstVisiblePosition();
    AppMethodBeat.o(34749);
    return i;
  }
  
  public int getLayoutId()
  {
    return R.i.ech;
  }
  
  public final ListView getListView()
  {
    return this.WCS;
  }
  
  public boolean getUserVisibleHint()
  {
    return this.fgR.dgo;
  }
  
  public void hLS()
  {
    AppMethodBeat.i(34754);
    this.WCY = false;
    this.WCW = true;
    this.WCX = true;
    Log.d("MicroMsg.ChattingUIFragment", "isFromSearch  " + getBooleanExtra("finish_direct", false));
    int i;
    Object localObject1;
    String str;
    Object localObject2;
    int j;
    if (this.fgR.NKq == null)
    {
      i = 1;
      Log.i("MicroMsg.ChattingUIFragment", "[doCreate] rawUserName from :%s to :%s ", new Object[] { this.fgR.getTalkerUserName(), getStringExtra("Chat_User") });
      localObject1 = getStringExtra("Chat_Self");
      this.fgR.WEE = ((String)localObject1);
      str = getStringExtra("Chat_User");
      bh.beI();
      localObject2 = com.tencent.mm.model.c.bbL().RG(str);
      if (localObject2 != null) {
        break label383;
      }
      j = -1;
      label142:
      if (localObject2 != null) {
        break label393;
      }
      localObject1 = "null";
      label151:
      Log.w("MicroMsg.ChattingUIFragment", "protectContactNotExist raw:%s contact:%d username:%s", new Object[] { str, Integer.valueOf(j), localObject1 });
      if ((localObject2 != null) && ((int)((com.tencent.mm.contact.d)localObject2).jxt != 0) && (!Util.isNullOrNil(((ax)localObject2).field_username))) {
        break label402;
      }
      localObject2 = new as();
      ((as)localObject2).setUsername(str);
      ((as)localObject2).VEr = str;
      ((as)localObject2).axl();
      ((as)localObject2).pv(3);
      bh.beI();
      com.tencent.mm.model.c.bbL().au((as)localObject2);
      bh.beI();
      as localas = com.tencent.mm.model.c.bbL().RG(str);
      localObject1 = localas;
      if (localas != null) {
        break label405;
      }
      Log.e("MicroMsg.ChattingUIFragment", "protectContactNotExist contact get from db is null!");
    }
    for (;;)
    {
      ay((as)localObject2);
      ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apd(this.fgR.getTalkerUserName());
      super.hLS();
      if (isSupportNavigationSwipeBack())
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().init();
      }
      if (i != 0) {
        com.tencent.mm.ui.chatting.e.a.hRl().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34710);
            ((aa)ChattingUIFragment.this.fgR.bC(aa.class)).hPJ();
            ((aa)ChattingUIFragment.this.fgR.bC(aa.class)).hOL();
            AppMethodBeat.o(34710);
          }
        });
      }
      hLU();
      com.tencent.mm.plugin.groupsolitaire.b.b.aKV(this.fgR.getTalkerUserName());
      AppMethodBeat.o(34754);
      return;
      i = 0;
      break;
      label383:
      j = (int)((com.tencent.mm.contact.d)localObject2).jxt;
      break label142;
      label393:
      localObject1 = ((ax)localObject2).field_username;
      break label151;
      label402:
      localObject1 = localObject2;
      label405:
      if (as.PY(str))
      {
        Log.i("MicroMsg.ChattingUIFragment", "[protectContactNotExist] isBottleContact userName:".concat(String.valueOf(str)));
        ((as)localObject1).VEr = str;
        ((as)localObject1).setUsername(str);
      }
      if (ab.Qc(str))
      {
        localObject2 = new qe();
        ((qe)localObject2).hal = 1L;
        ((qe)localObject2).bpa();
      }
      localObject2 = localObject1;
      if (ab.Qe(str))
      {
        localObject2 = new qd();
        ((qd)localObject2).hal = 1L;
        ((qd)localObject2).bpa();
        localObject2 = localObject1;
      }
    }
  }
  
  protected void hLU()
  {
    AppMethodBeat.i(34772);
    this.LcU = new com.tencent.mm.plugin.expt.hellhound.a.a.b.c(this.LcV, "ChattingUIFragment", c.a.wis);
    this.mScrollState = 0;
    this.WCV = ((MMChattingListView)findViewById(R.h.dxL));
    this.WCV.setIsReturnSuperDispatchWhenCancel(true);
    this.WCS = this.WCV.getListView();
    this.WCS.setVisibility(0);
    ((aa)this.fgR.bC(aa.class)).hPF();
    if (this.WCV.getBaseAdapter() == null)
    {
      this.WCR = new com.tencent.mm.ui.chatting.a.a(this.fgR, this.WCS);
      this.WCV.setAdapter(this.WCR);
    }
    Object localObject = this.WCV;
    ((MMChattingListView)localObject).FQ(false);
    ((MMChattingListView)localObject).FQ(false);
    hMt();
    this.WCZ.a(d.a.WYt, true, null);
    this.WCS.setOverScrollMode(2);
    if (!((an)this.fgR.bC(an.class)).hQw()) {
      this.WCS.setTranscriptMode(1);
    }
    for (;;)
    {
      this.WCS.setOnTouchListener(new View.OnTouchListener()
      {
        boolean Lue = false;
        
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(273372);
          ChattingUIFragment.h(ChattingUIFragment.this);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            Log.i("MicroMsg.ChattingUIFragment", "onTouch: touch down");
            this.Lue = true;
          }
          while ((!this.Lue) || (!ChattingUIFragment.this.WCX))
          {
            AppMethodBeat.o(273372);
            return false;
            if (paramAnonymousMotionEvent.getAction() == 1)
            {
              Log.i("MicroMsg.ChattingUIFragment", "onTouch: touch up");
              this.Lue = false;
            }
          }
          paramAnonymousView = (u)ChattingUIFragment.this.fgR.bC(u.class);
          if ((paramAnonymousView == null) || (paramAnonymousView.hPj() == null))
          {
            AppMethodBeat.o(273372);
            return false;
          }
          paramAnonymousView.hPj().Eq(true);
          AppMethodBeat.o(273372);
          return false;
        }
      });
      localObject = getBounceView();
      if ((localObject != null) && (this.fgR != null)) {
        ((com.tencent.mm.ui.widget.pulldown.e)localObject).a((e.a)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.r.class));
      }
      this.WCS.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private boolean aadf = false;
        
        private void ifm()
        {
          AppMethodBeat.i(293340);
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
            ((MMChattingListView)localObject).am(true, i);
          }
          for (;;)
          {
            this.aadf = false;
            AppMethodBeat.o(293340);
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
              ChattingUIFragment.a(ChattingUIFragment.this).setAdapter(ChattingUIFragment.this.WCR);
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
          //   8: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:WDa	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   11: getfield 101	com/tencent/mm/ui/chatting/BaseChattingUIFragment:fgR	Lcom/tencent/mm/ui/chatting/e/a;
          //   14: getfield 107	com/tencent/mm/ui/chatting/e/a:WQu	Lcom/tencent/mm/ui/chatting/d/q;
          //   17: aload_1
          //   18: iload_2
          //   19: iload_3
          //   20: iload 4
          //   22: invokevirtual 111	com/tencent/mm/ui/chatting/d/q:onScroll	(Landroid/widget/AbsListView;III)V
          //   25: aload_0
          //   26: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:WDa	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   29: invokestatic 115	com/tencent/mm/ui/chatting/ChattingUIFragment:d	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)I
          //   32: ifne +27 -> 59
          //   35: aload_0
          //   36: getfield 23	com/tencent/mm/ui/chatting/ChattingUIFragment$2:aadf	Z
          //   39: ifeq +20 -> 59
          //   42: aload_0
          //   43: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:WDa	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   46: invokestatic 36	com/tencent/mm/ui/chatting/ChattingUIFragment:b	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Landroid/widget/ListView;
          //   49: invokevirtual 118	android/widget/ListView:getFirstVisiblePosition	()I
          //   52: ifne +7 -> 59
          //   55: aload_0
          //   56: invokespecial 120	com/tencent/mm/ui/chatting/ChattingUIFragment$2:ifm	()V
          //   59: aload_0
          //   60: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:WDa	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   63: invokestatic 123	com/tencent/mm/ui/chatting/ChattingUIFragment:i	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
          //   66: ifeq +36 -> 102
          //   69: aload_0
          //   70: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:WDa	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   73: invokestatic 36	com/tencent/mm/ui/chatting/ChattingUIFragment:b	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Landroid/widget/ListView;
          //   76: invokevirtual 126	android/widget/ListView:getLastVisiblePosition	()I
          //   79: iload 4
          //   81: iconst_1
          //   82: isub
          //   83: if_icmpeq +11 -> 94
          //   86: ldc 95
          //   88: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   91: aload_0
          //   92: monitorexit
          //   93: return
          //   94: aload_0
          //   95: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:WDa	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   98: invokestatic 129	com/tencent/mm/ui/chatting/ChattingUIFragment:j	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
          //   101: pop
          //   102: aload_0
          //   103: getfield 19	com/tencent/mm/ui/chatting/ChattingUIFragment$2:WDa	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   106: aload_1
          //   107: iload_2
          //   108: iload_3
          //   109: invokestatic 132	com/tencent/mm/ui/chatting/ChattingUIFragment:a	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;Landroid/widget/AbsListView;II)V
          //   112: ldc 95
          //   114: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   117: goto -26 -> 91
          //   120: astore_1
          //   121: aload_0
          //   122: monitorexit
          //   123: aload_1
          //   124: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	125	0	this	2
          //   0	125	1	paramAnonymousAbsListView	AbsListView
          //   0	125	2	paramAnonymousInt1	int
          //   0	125	3	paramAnonymousInt2	int
          //   0	125	4	paramAnonymousInt3	int
          // Exception table:
          //   from	to	target	type
          //   2	59	120	finally
          //   59	91	120	finally
          //   94	102	120	finally
          //   102	117	120	finally
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(281430);
          ChattingUIFragment.this.fgR.WQu.onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
          ChattingUIFragment.a(ChattingUIFragment.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            Log.d("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] [%s:%s]", new Object[] { Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition()), Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition()) });
            int i;
            LinkedList localLinkedList;
            label223:
            Object localObject2;
            if (ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() == 0)
            {
              ifm();
              ChattingUIFragment.this.WCR.fB(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
              com.tencent.mm.ui.chatting.a.a locala = ChattingUIFragment.this.WCR;
              i = ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition();
              int k = ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount();
              int j = ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition();
              if (locala.WbU == null) {
                break label565;
              }
              localObject1 = locala.WbU.NKq;
              if ((localObject1 == null) || (((as)localObject1).hxX())) {
                break label565;
              }
              localLinkedList = new LinkedList();
              i -= k;
              if (i > j) {
                break label504;
              }
              localObject1 = locala.avw(i);
              if (localObject1 != null)
              {
                localObject2 = ((et)localObject1).field_content;
                if (localObject2 != null)
                {
                  localObject1 = k.b.aG((String)localObject2, ((et)localObject1).field_reserved);
                  if ((localObject1 != null) && (((k.b)localObject1).type == 5) && (!TextUtils.isEmpty(((k.b)localObject1).url)))
                  {
                    localObject2 = new f.a();
                    ((f.a)localObject2).url = ((k.b)localObject1).url;
                    ((f.a)localObject2).svv = 1;
                    ((f.a)localObject2).appId = ((k.b)localObject1).appId;
                    ((f.a)localObject2).title = ((k.b)localObject1).title;
                    ((f.a)localObject2).desc = ((k.b)localObject1).description;
                    if (!locala.WbU.hRi()) {
                      break label496;
                    }
                  }
                }
              }
            }
            label496:
            for (Object localObject1 = "groupmessage";; localObject1 = "singlemessage")
            {
              ((f.a)localObject2).from = ((String)localObject1);
              localLinkedList.add(localObject2);
              i += 1;
              break label223;
              if (ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition() == ChattingUIFragment.b(ChattingUIFragment.this).getCount() - 1)
              {
                localObject1 = ChattingUIFragment.b(ChattingUIFragment.this).getChildAt(ChattingUIFragment.b(ChattingUIFragment.this).getChildCount() - 1);
                if ((localObject1 == null) || (ChattingUIFragment.b(ChattingUIFragment.this).getBottom() - ChattingUIFragment.a(ChattingUIFragment.this).getBottomHeight() < ((View)localObject1).getBottom())) {
                  break;
                }
                Log.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load bottom more!");
                ChattingUIFragment.a(ChattingUIFragment.this).FQ(true);
                break;
              }
              this.aadf = true;
              break;
            }
            label504:
            if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class) != null) && (localLinkedList.size() > 0))
            {
              Log.v("MicroMsg.ChattingDataAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
              ((com.tencent.mm.plugin.brandservice.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.f.class)).m(localLinkedList, 2);
            }
          }
          label565:
          ChattingUIFragment.a(ChattingUIFragment.this, paramAnonymousAbsListView, paramAnonymousInt);
          AppMethodBeat.o(281430);
        }
      });
      this.WCS.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(280443);
          ChattingUIFragment.this.WCR.fB(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
          ChattingUIFragment.b(ChattingUIFragment.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(280443);
        }
      });
      if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(2))
      {
        localObject = this.fgR;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).NKq;
          if ((localObject != null) && (((as)localObject).hxX())) {
            ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gx(0);
          }
        }
      }
      registerForContextMenu(this.WCS);
      bp(false, true);
      AppMethodBeat.o(34772);
      return;
      this.WCS.setTranscriptMode(0);
    }
  }
  
  public final void hMm()
  {
    AppMethodBeat.i(34757);
    super.hMm();
    if (this.fgR.getTalkerUserName() == null)
    {
      AppMethodBeat.o(34757);
      return;
    }
    AppMethodBeat.o(34757);
  }
  
  public final z hMp()
  {
    AppMethodBeat.i(34750);
    if (this.fgR.bC(aa.class) == null)
    {
      AppMethodBeat.o(34750);
      return null;
    }
    z localz = ((aa)this.fgR.bC(aa.class)).hMp();
    AppMethodBeat.o(34750);
    return localz;
  }
  
  public final boolean hMr()
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
      View localView = getActivity().findViewById(R.h.dKQ);
      if (localView == null) {
        break label82;
      }
      localView.setVisibility(0);
      localView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34713);
          ChattingUIFragment.this.hNp();
          AppMethodBeat.o(34713);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(34763);
      return true;
      label82:
      hNp();
    }
  }
  
  public final com.tencent.mm.ui.chatting.o.a.a hMs()
  {
    return this.WCZ;
  }
  
  public final void hMt()
  {
    AppMethodBeat.i(34771);
    if ((this.WCV == null) || (this.WCR == null))
    {
      AppMethodBeat.o(34771);
      return;
    }
    Object localObject1 = this.fgR;
    Object localObject2 = new com.tencent.mm.ui.chatting.h.a(this.fgR, this.WCR.WFp);
    com.tencent.mm.ui.chatting.h.b localb = new com.tencent.mm.ui.chatting.h.b(this.fgR, this.WCV);
    localObject2 = new com.tencent.mm.ui.chatting.h.e(localb, (com.tencent.mm.ui.chatting.h.c)localObject2);
    if (((com.tencent.mm.ui.chatting.d.b.d)((com.tencent.mm.ui.chatting.e.a)localObject1).bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe()) {
      localObject1 = new com.tencent.mm.ui.chatting.o.a.b((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.e)localObject2);
    }
    for (;;)
    {
      localb.WYp = ((b.a)localObject1);
      Log.i("MicroMsg.ChattingLoader.ChattingDataPresenterFactory", "[ChattingDataPresenterFactory] executor:%s", new Object[] { ((com.tencent.mm.ui.chatting.o.a.a)localObject1).toString() });
      this.WCZ = ((com.tencent.mm.ui.chatting.o.a.a)localObject1);
      this.WCR.WFB = this.WCZ;
      this.WCV.setLoadExecutor(this.WCZ);
      AppMethodBeat.o(34771);
      return;
      if (((v)((com.tencent.mm.ui.chatting.e.a)localObject1).bC(v.class)).hPw()) {
        localObject1 = new com.tencent.mm.ui.chatting.o.a.d((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.d)localObject2);
      } else if ((((an)((com.tencent.mm.ui.chatting.e.a)localObject1).bC(an.class)).hQy()) || (((an)((com.tencent.mm.ui.chatting.e.a)localObject1).bC(an.class)).hQz()) || (((an)((com.tencent.mm.ui.chatting.e.a)localObject1).bC(an.class)).hQw()) || (((ai)((com.tencent.mm.ui.chatting.e.a)localObject1).bC(ai.class)).hQl())) {
        localObject1 = new com.tencent.mm.ui.chatting.o.a.f((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.d)localObject2);
      } else if ((((com.tencent.mm.ui.chatting.d.b.h)((com.tencent.mm.ui.chatting.e.a)localObject1).bC(com.tencent.mm.ui.chatting.d.b.h.class)).hOK()) || (((com.tencent.mm.ui.chatting.d.b.i)((com.tencent.mm.ui.chatting.e.a)localObject1).bC(com.tencent.mm.ui.chatting.d.b.i.class)).hOP())) {
        localObject1 = new com.tencent.mm.ui.chatting.o.a.c((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.e)localObject2);
      } else if (((o)((com.tencent.mm.ui.chatting.e.a)localObject1).bC(o.class)).hOZ()) {
        localObject1 = new com.tencent.mm.ui.chatting.o.a.h((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.d)localObject2);
      } else if (((o)((com.tencent.mm.ui.chatting.e.a)localObject1).bC(o.class)).hPa()) {
        localObject1 = new g((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.e)localObject2);
      } else {
        localObject1 = new com.tencent.mm.ui.chatting.o.a.e((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.e)localObject2);
      }
    }
  }
  
  public final void hNg()
  {
    AppMethodBeat.i(34725);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      bp(false, bool);
      AppMethodBeat.o(34725);
      return;
    }
  }
  
  public final void hNh()
  {
    AppMethodBeat.i(34730);
    Log.i("MicroMsg.ChattingUIFragment", "[smoothScrollBy] dis:%d duration:%d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.WCS.smoothScrollBy(0, 0);
    AppMethodBeat.o(34730);
  }
  
  public final void hNi()
  {
    AppMethodBeat.i(284012);
    this.WCV.setBottomViewVisible(true);
    AppMethodBeat.o(284012);
  }
  
  public final void hNj()
  {
    AppMethodBeat.i(34738);
    this.WCV.setTopViewVisible(true);
    AppMethodBeat.o(34738);
  }
  
  public final void hNk()
  {
    AppMethodBeat.i(34739);
    this.WCV.setIsTopShowAll(false);
    AppMethodBeat.o(34739);
  }
  
  public final void hNl()
  {
    AppMethodBeat.i(284017);
    this.WCV.FQ(true);
    AppMethodBeat.o(284017);
  }
  
  public final void hNm()
  {
    AppMethodBeat.i(34748);
    this.WCS.setTranscriptMode(0);
    AppMethodBeat.o(34748);
  }
  
  public final MMChattingListView hNn()
  {
    return this.WCV;
  }
  
  public final void hNo()
  {
    AppMethodBeat.i(34761);
    Object localObject1 = (an)this.fgR.bC(an.class);
    Object localObject2 = (ai)this.fgR.bC(ai.class);
    if ((!((an)localObject1).hQw()) && (!((an)localObject1).hQy()) && (!((an)localObject1).hQz()) && (!((ai)localObject2).hQk()))
    {
      int i = this.sCz;
      this.sCz = (i + 1);
      if ((i < 10) && (((thisActivity() instanceof ChattingUI)) || ((thisActivity() instanceof AppBrandServiceChattingUI))))
      {
        localObject1 = this.WCS;
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
              ChattingUIFragment.a(ChattingUIFragment.this, true);
              ChattingUIFragment.this.hNo();
              AppMethodBeat.o(34711);
              return;
            }
            ChattingUIFragment.e(ChattingUIFragment.this);
            AppMethodBeat.o(34711);
          }
        };
        if (this.sCz == 1) {}
        for (i = 10;; i = 100)
        {
          ((ListView)localObject1).postDelayed((Runnable)localObject2, i);
          AppMethodBeat.o(34761);
          return;
        }
      }
    }
    Log.d("MicroMsg.ChattingUIFragment", "scrollToLastProtect:%s, %s ,%s", new Object[] { Boolean.valueOf(((an)localObject1).hQw()), Boolean.valueOf(((an)localObject1).hQy()), Integer.valueOf(this.sCz) });
    AppMethodBeat.o(34761);
  }
  
  protected final void hNp()
  {
    AppMethodBeat.i(34764);
    ((at)this.fgR.bC(at.class)).aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34714);
        ChattingUIFragment.this.onExitBegin();
        if ((ChattingUIFragment.this.thisActivity() instanceof a.d)) {
          ((a.d)ChattingUIFragment.this.thisActivity()).atA();
        }
        if ((ChattingUIFragment.this.isCurrentActivity) || (!ChattingUIFragment.this.isSupportNavigationSwipeBack()))
        {
          ChattingUIFragment.this.hNq();
          AppMethodBeat.o(34714);
          return;
        }
        SwipeBackLayout localSwipeBackLayout = ChattingUIFragment.this.getSwipeBackLayout();
        Log.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", new Object[] { Boolean.valueOf(localSwipeBackLayout.jRp), Boolean.valueOf(localSwipeBackLayout.jRn), Boolean.valueOf(localSwipeBackLayout.jRo) });
        if (!localSwipeBackLayout.aEc())
        {
          j.ap(0.0F);
          localSwipeBackLayout.jRp = true;
          localSwipeBackLayout.jRo = false;
          int i = localSwipeBackLayout.mContentView.getWidth();
          int j = localSwipeBackLayout.jRk.getIntrinsicWidth();
          localSwipeBackLayout.Ydy.b(localSwipeBackLayout.mContentView, i + j + 10, 260L);
          localSwipeBackLayout.invalidate();
          if (localSwipeBackLayout.Ydz != null) {
            localSwipeBackLayout.Ydz.onDrag();
          }
          j.j(true, 0);
        }
        AppMethodBeat.o(34714);
      }
    });
    AppMethodBeat.o(34764);
  }
  
  protected final void hNq()
  {
    AppMethodBeat.i(34768);
    hNr();
    Object localObject = (com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class);
    if (as.bvH(this.fgR.getTalkerUserName()))
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      com.tencent.mm.by.c.b(getContext(), "tmessage", ".ui.TConversationUI", (Intent)localObject);
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
        if (((getIntExtra("chat_from_scene", 0) == 1) || (getIntExtra("chat_from_scene", 0) == 3)) && (this.fgR.NKq != null) && (this.fgR.NKq.hxX()) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).hOb() != null) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).hOb().YY()) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).hOb().dc(false) != null) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).hOb().dc(false).Zz() != null) && (!Util.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.d)localObject).hOb().Zf())))
        {
          finish();
          AppMethodBeat.o(34768);
          return;
        }
        if (!((ac)this.fgR.bC(ac.class)).hQe()) {
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    overridePendingTransition(MMFragmentActivity.a.ria, MMFragmentActivity.a.rib);
    finish();
    AppMethodBeat.o(34768);
  }
  
  public boolean hideVKB()
  {
    AppMethodBeat.i(34733);
    ChatFooter localChatFooter = ((u)this.fgR.bC(u.class)).hPj();
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
  
  public final boolean isShowingDialog()
  {
    AppMethodBeat.i(284011);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      AppMethodBeat.o(284011);
      return true;
    }
    AppMethodBeat.o(284011);
    return false;
  }
  
  public boolean isSupportCustomActionBar()
  {
    AppMethodBeat.i(34751);
    boolean bool = isSupportNavigationSwipeBack();
    AppMethodBeat.o(34751);
    return bool;
  }
  
  public final void lf(Context paramContext)
  {
    AppMethodBeat.i(34753);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramContext);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doAttach", "(Landroid/content/Context;)V", this, localb.aFi());
    super.lf(paramContext);
    Log.i("MicroMsg.ChattingUIFragment", "[doAttach]:%s#0x%x task:%s hc:%d", new Object[] { thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), Util.getActivityTaskInfo(thisActivity()), Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.bS(3, true);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doAttach", "(Landroid/content/Context;)V");
    AppMethodBeat.o(34753);
  }
  
  public final void my(int paramInt1, int paramInt2)
  {
    int j = 1;
    AppMethodBeat.i(34732);
    com.tencent.mm.ui.chatting.e.a.hRl().removeCallbacks(this.WCT);
    Log.i("MicroMsg.ChattingUIFragment", "[setSelectionFromTop] pos:%d offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    if (!this.fgR.WQz)
    {
      com.tencent.mm.pluginsdk.ui.tools.r.a(this.WCS, paramInt1, paramInt2, false);
      AppMethodBeat.o(34732);
      return;
    }
    ListView localListView = this.WCS;
    if (localListView != null)
    {
      int i = localListView.getLastVisiblePosition();
      int k;
      if ((localListView.getFirstVisiblePosition() < paramInt1) && (paramInt1 < i))
      {
        i = 1;
        if (i != 0) {
          break label241;
        }
        Log.i("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop position %s smooth %s", new Object[] { Integer.valueOf(paramInt1), Boolean.TRUE });
        localListView.setItemChecked(paramInt1, true);
        if (!com.tencent.mm.compatible.util.d.qX(11)) {
          break label234;
        }
        k = localListView.getLastVisiblePosition();
        i = localListView.getFirstVisiblePosition();
        if ((paramInt1 >= i) || (i - paramInt1 < 20)) {
          break label211;
        }
        i = j;
      }
      for (;;)
      {
        if (i != 0) {
          break label234;
        }
        localListView.smoothScrollToPositionFromTop(paramInt1, paramInt2, 200);
        AppMethodBeat.o(34732);
        return;
        i = 0;
        break;
        label211:
        if (paramInt1 > k)
        {
          i = j;
          if (paramInt1 - k >= 20) {}
        }
        else
        {
          i = 0;
        }
      }
      label234:
      localListView.setSelectionFromTop(paramInt1, paramInt2);
    }
    label241:
    AppMethodBeat.o(34732);
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
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvE, Boolean.TRUE);
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
    if ((isSupportNavigationSwipeBack()) && (this.WCR != null)) {
      this.WCX = true;
    }
    AppMethodBeat.o(34767);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    AppMethodBeat.i(34717);
    if (!this.fgR.dgo)
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
    if ((isSupportNavigationSwipeBack()) && (this.WCR != null)) {
      this.WCX = false;
    }
    AppMethodBeat.o(34766);
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34758);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onEnterBegin", "()V", this);
    super.onEnterBegin();
    fsh();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onEnterBegin", "()V");
    AppMethodBeat.o(34758);
  }
  
  public final void onExitBegin()
  {
    AppMethodBeat.i(34759);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitBegin", "()V", this);
    super.onExitBegin();
    Object localObject = this.WCR;
    ((com.tencent.mm.ui.chatting.a.a)localObject).WFs = -1L;
    ((com.tencent.mm.ui.chatting.a.a)localObject).WFr.clear();
    this.WCZ.Xaj.cancel();
    fsh();
    EventCenter.instance.publish(new bi());
    EventCenter.instance.publish(new bj());
    localObject = com.tencent.mm.ui.report.b.XLO;
    com.tencent.mm.ui.report.b.hXK();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitBegin", "()V");
    AppMethodBeat.o(34759);
  }
  
  public final void onExitEnd()
  {
    AppMethodBeat.i(34760);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitEnd", "()V", this);
    super.onExitEnd();
    dismissDialog();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitEnd", "()V");
    AppMethodBeat.o(34760);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(34762);
    if (keyboardState() == 1) {
      this.WCS.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34712);
          ChattingUIFragment.this.bp(true, false);
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
    ChatFooter localChatFooter = ((u)this.fgR.bC(u.class)).hPj();
    if (localChatFooter != null) {
      localChatFooter.setIsMultiWindow(paramBoolean);
    }
    AppMethodBeat.o(34775);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(34765);
    Log.w("MicroMsg.ChattingUIFragment", "onSwipeBack");
    hNq();
    if (n.eMj().eMo())
    {
      fv localfv = new fv();
      localfv.fBE.username = com.tencent.mm.bk.d.meW.bqa();
      EventCenter.instance.publish(localfv);
    }
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    AppMethodBeat.o(34765);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(34729);
    com.tencent.mm.ui.chatting.e.a.hRl().removeCallbacks(this.WCT);
    Log.i("MicroMsg.ChattingUIFragment", "[scrollToPosition] scroll to pos:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.WCU == null) {
      this.WCU = new com.tencent.mm.ui.tools.r(this.WCS);
    }
    com.tencent.mm.ui.tools.r localr = this.WCU;
    int i = paramInt + this.WCS.getHeaderViewsCount();
    localr.Xc.removeCallbacks(localr);
    localr.XTY = System.currentTimeMillis();
    localr.XUd = 0;
    paramInt = localr.Xc.getFirstVisiblePosition();
    int j = localr.Xc.getChildCount() + paramInt - 1;
    if (i <= paramInt)
    {
      paramInt = paramInt - i + 1;
      localr.mMode = 2;
      if (paramInt <= 0) {
        break label208;
      }
    }
    label208:
    for (localr.XUb = (1000 / paramInt);; localr.XUb = 1000)
    {
      localr.XTZ = i;
      localr.XUa = -1;
      localr.Xc.post(localr);
      AppMethodBeat.o(34729);
      return;
      if (i >= j)
      {
        paramInt = i - j + 1;
        localr.mMode = 1;
        break;
      }
      AppMethodBeat.o(34729);
      return;
    }
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(34723);
    ((aa)this.fgR.bC(aa.class)).setBackBtn(paramOnMenuItemClickListener);
    AppMethodBeat.o(34723);
  }
  
  public final void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(34740);
    this.WCV.setIsBottomShowAll(paramBoolean);
    AppMethodBeat.o(34740);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(34736);
    if (this.WCS != null) {
      this.WCS.setKeepScreenOn(paramBoolean);
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
    ((aa)this.fgR.bC(aa.class)).setMMSubTitle(paramString);
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
    ((aa)this.fgR.bC(aa.class)).setMMTitle(paramString);
    AppMethodBeat.o(34720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */