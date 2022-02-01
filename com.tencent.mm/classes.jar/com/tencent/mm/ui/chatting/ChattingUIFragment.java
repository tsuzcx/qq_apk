package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.be;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.b.a.ne;
import com.tencent.mm.g.b.a.nf;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.j.a.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.brandservice.a.e.a;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.e;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.d.b.o;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.d.b.v;
import com.tencent.mm.ui.chatting.h.b.a;
import com.tencent.mm.ui.chatting.h.d.a;
import com.tencent.mm.ui.chatting.n.a.f;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import java.util.LinkedList;

@SuppressLint({"ValidFragment"})
public class ChattingUIFragment
  extends BaseChattingUIFragment
{
  public static String NQL;
  private com.tencent.mm.plugin.expt.hellhound.a.a.b.c EOZ;
  private final com.tencent.mm.plugin.expt.hellhound.a.a.b.e EPa;
  public com.tencent.mm.ui.chatting.a.a Pjp;
  public ListView Pjq;
  private Runnable Pjr;
  private com.tencent.mm.ui.tools.q Pjs;
  private MMChattingListView Pjt;
  private boolean Pju;
  protected boolean Pjv;
  private boolean Pjw;
  private com.tencent.mm.ui.chatting.n.a.a Pjx;
  private int mScrollState;
  private boolean ptd;
  private int ptj;
  private final int ptk;
  private com.tencent.mm.ui.base.q tipDialog;
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment()
  {
    AppMethodBeat.i(232895);
    this.tipDialog = null;
    this.Pju = true;
    this.Pjv = true;
    this.mScrollState = 0;
    this.ptd = false;
    this.Pjw = false;
    this.ptj = 0;
    this.ptk = 10;
    this.EPa = new ChattingUIFragment.5(this);
    AppMethodBeat.o(232895);
  }
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment(byte paramByte)
  {
    super(true);
    AppMethodBeat.i(232896);
    this.tipDialog = null;
    this.Pju = true;
    this.Pjv = true;
    this.mScrollState = 0;
    this.ptd = false;
    this.Pjw = false;
    this.ptj = 0;
    this.ptk = 10;
    this.EPa = new ChattingUIFragment.5(this);
    AppMethodBeat.o(232896);
  }
  
  private void BO(final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(34728);
    int m = this.Pjq.getLastVisiblePosition();
    int n = this.Pjq.getFirstVisiblePosition();
    final int k = this.Pjq.getCount();
    Log.i("MicroMsg.ChattingUIFragment", "[scrollToLastImpl] isFirstScroll:%s [%s:%s] count:%s force:%s", new Object[] { Boolean.valueOf(this.Pju), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
    this.Pju = false;
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
          if (this.Pjq.getChildCount() > 0) {
            i = this.Pjq.getChildAt(this.Pjq.getChildCount() - 1).getHeight();
          }
        }
      }
    }
    if ((paramBoolean) && (this.Pjt.cAl())) {
      Log.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom");
    }
    for (;;)
    {
      this.Pjq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34709);
          if ((paramBoolean) && (ChattingUIFragment.a(ChattingUIFragment.this).cAl()))
          {
            Log.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom in post");
            AppMethodBeat.o(34709);
            return;
          }
          com.tencent.mm.pluginsdk.ui.tools.p.a(ChattingUIFragment.b(ChattingUIFragment.this), k - 1, -i, true);
          AppMethodBeat.o(34709);
        }
      });
      AppMethodBeat.o(34728);
      return;
      com.tencent.mm.pluginsdk.ui.tools.p.a(this.Pjq, k - 1, -i, true);
    }
  }
  
  private boolean gOh()
  {
    AppMethodBeat.i(34769);
    l locall = (l)this.dom.bh(l.class);
    am localam = (am)this.dom.bh(am.class);
    if (locall.gPB())
    {
      if (localam.gQX())
      {
        localam.gQW();
        locall.gPC();
      }
      for (;;)
      {
        AppMethodBeat.o(34769);
        return true;
        locall.gPz();
      }
    }
    AppMethodBeat.o(34769);
    return false;
  }
  
  public final void BN(boolean paramBoolean)
  {
    AppMethodBeat.i(34726);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      bf(paramBoolean, bool);
      AppMethodBeat.o(34726);
      return;
    }
  }
  
  public final void By(boolean paramBoolean)
  {
    AppMethodBeat.i(34741);
    this.Pjt.By(paramBoolean);
    AppMethodBeat.o(34741);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(232899);
    if (this.Pjp == null)
    {
      AppMethodBeat.o(232899);
      return;
    }
    com.tencent.mm.ui.chatting.a.a locala = this.Pjp;
    if (locala.PlQ != null) {
      locala.PlQ.a(parama, false, null);
    }
    AppMethodBeat.o(232899);
  }
  
  public final void amm(int paramInt)
  {
    AppMethodBeat.i(34731);
    com.tencent.mm.ui.chatting.e.a.gRP().removeCallbacks(this.Pjr);
    Log.i("MicroMsg.ChattingUIFragment", "[setSelection] pos:%d isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    ListView localListView = this.Pjq;
    if (localListView != null)
    {
      Log.i("MicroMsg.ChattingUI.ScrollController", "setSelection position %s smooth %s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
      localListView.setItemChecked(paramInt, true);
      localListView.setSelection(paramInt);
    }
    AppMethodBeat.o(34731);
  }
  
  public final void amn(int paramInt)
  {
    AppMethodBeat.i(232898);
    try
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.Pjt.getLayoutParams();
      localLayoutParams.topMargin = paramInt;
      this.Pjt.setLayoutParams(localLayoutParams);
      Log.d("MicroMsg.ChattingUIFragment", "setTopMarginHeight height:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(232898);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ChattingUIFragment", "setTopMarginHeight height:%s, %s, %s", new Object[] { Integer.valueOf(paramInt), localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(232898);
    }
  }
  
  public final void amo(int paramInt)
  {
    AppMethodBeat.i(34747);
    this.Pjq.setVisibility(paramInt);
    if (Log.getLogLevel() == 2) {
      Log.i("MicroMsg.ChattingUIFragment", "[setListViewVisibility] visibility:" + paramInt + " stack:" + Util.getStack().toString());
    }
    AppMethodBeat.o(34747);
  }
  
  protected final void as(com.tencent.mm.storage.as paramas)
  {
    AppMethodBeat.i(34752);
    super.as(paramas);
    NQL = paramas.field_username;
    AppMethodBeat.o(34752);
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(232897);
    dismissDialog();
    this.tipDialog = com.tencent.mm.ui.base.h.a(paramContext, paramString2, true, paramOnCancelListener);
    AppMethodBeat.o(232897);
  }
  
  @Deprecated
  public final void bf(final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(34727);
    if (paramBoolean2)
    {
      com.tencent.mm.ui.chatting.e.a.gRP().removeCallbacks(this.Pjr);
      MMHandler localMMHandler = com.tencent.mm.ui.chatting.e.a.gRP();
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34702);
          ChattingUIFragment.a(ChattingUIFragment.this, paramBoolean1);
          AppMethodBeat.o(34702);
        }
      };
      this.Pjr = local1;
      localMMHandler.post(local1);
      AppMethodBeat.o(34727);
      return;
    }
    BO(paramBoolean1);
    AppMethodBeat.o(34727);
  }
  
  public final void bs(Bundle paramBundle)
  {
    AppMethodBeat.i(34742);
    this.Pjt.bs(paramBundle);
    AppMethodBeat.o(34742);
  }
  
  public final void bt(Bundle paramBundle)
  {
    AppMethodBeat.i(34744);
    this.Pjt.c(true, paramBundle);
    AppMethodBeat.o(34744);
  }
  
  public final void cmy()
  {
    AppMethodBeat.i(34724);
    if (this.Pjp == null)
    {
      AppMethodBeat.o(34724);
      return;
    }
    this.Pjp.notifyDataSetChanged();
    AppMethodBeat.o(34724);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(34718);
    super.dealContentView(paramView);
    ((aa)this.dom.bh(aa.class)).gC(paramView);
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
    r.dismiss();
    Log.i("MicroMsg.ChattingUIFragment", "on chatting ui pause  rawuser:%s", new Object[] { this.dom.getTalkerUserName() });
    if (this.dom.getTalkerUserName() == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V");
      AppMethodBeat.o(34756);
      return;
    }
    this.Pjp.pause();
    hideVKB();
    Log.d("MicroMsg.ChattingUIFragment", "chattingui cancel pause auto download logic");
    com.tencent.mm.ui.chatting.a.a locala = this.Pjp;
    if (locala != null) {
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).report21053(this.Pjq, locala, c.e.sFq.state, -1, -1, 2L, "temp_6", 3, false);
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
      getWindow().setBackgroundDrawableResource(2131101007);
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
      if (this.Pjq.getVisibility() != 0) {
        break label161;
      }
    }
    label156:
    label161:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (this.dom.cQp) {
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
    if (!bg.aAc())
    {
      Log.w("MicroMsg.ChattingUIFragment", "account not ready, mabey not call onDestroy!!!");
      finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
      AppMethodBeat.o(34755);
      return;
    }
    this.Pjp.resume();
    com.tencent.mm.ui.chatting.a.a locala = this.Pjp;
    if (locala != null) {
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).report21053(this.Pjq, locala, c.e.sFp.state, -1, -1, 2L, "temp_6", 2, false);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
    AppMethodBeat.o(34755);
  }
  
  public void eGg()
  {
    AppMethodBeat.i(34773);
    com.tencent.f.h.RTc.b(new Runnable()
    {
      ae Pjz;
      String username;
      
      public final void run()
      {
        AppMethodBeat.i(232891);
        long l = System.currentTimeMillis();
        if (this.Pjz == null)
        {
          Log.e("MicroMsg.ChattingUIFragment", "messBoxComponent == null! without writeOpLogAndMarkRead!");
          AppMethodBeat.o(232891);
          return;
        }
        this.Pjz.bmN(this.username);
        Log.i("MicroMsg.ChattingUIFragment", "ChattingUI writeOpLogAndMarkRead last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(232891);
      }
    }, "MicroMsg.ChattingUIFragment");
    AppMethodBeat.o(34773);
  }
  
  public void finish()
  {
    AppMethodBeat.i(34770);
    this.dom.Pwb.onFinish();
    Object localObject = (u)this.dom.bh(u.class);
    if ((localObject != null) && (((u)localObject).gPO() != null)) {
      ((u)localObject).gPO().Ak(true);
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
            ((a.d)ChattingUIFragment.this.thisActivity()).anA();
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
  
  public void gMJ()
  {
    AppMethodBeat.i(34754);
    this.Pjw = false;
    this.Pju = true;
    this.Pjv = true;
    Log.d("MicroMsg.ChattingUIFragment", "isFromSearch  " + getBooleanExtra("finish_direct", false));
    int i;
    Object localObject1;
    String str;
    Object localObject2;
    int j;
    if (this.dom.GUe == null)
    {
      i = 1;
      Log.i("MicroMsg.ChattingUIFragment", "[doCreate] rawUserName from :%s to :%s ", new Object[] { this.dom.getTalkerUserName(), getStringExtra("Chat_User") });
      localObject1 = getStringExtra("Chat_Self");
      this.dom.PkU = ((String)localObject1);
      str = getStringExtra("Chat_User");
      bg.aVF();
      localObject2 = com.tencent.mm.model.c.aSN().Kn(str);
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
      if ((localObject2 != null) && ((int)((com.tencent.mm.contact.c)localObject2).gMZ != 0) && (!Util.isNullOrNil(((ax)localObject2).field_username))) {
        break label402;
      }
      localObject2 = new com.tencent.mm.storage.as();
      ((com.tencent.mm.storage.as)localObject2).setUsername(str);
      ((com.tencent.mm.storage.as)localObject2).Ooy = str;
      ((com.tencent.mm.storage.as)localObject2).aqR();
      ((com.tencent.mm.storage.as)localObject2).ni(3);
      bg.aVF();
      com.tencent.mm.model.c.aSN().ao((com.tencent.mm.storage.as)localObject2);
      bg.aVF();
      com.tencent.mm.storage.as localas = com.tencent.mm.model.c.aSN().Kn(str);
      localObject1 = localas;
      if (localas != null) {
        break label405;
      }
      Log.e("MicroMsg.ChattingUIFragment", "protectContactNotExist contact get from db is null!");
    }
    for (;;)
    {
      as((com.tencent.mm.storage.as)localObject2);
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahx(this.dom.getTalkerUserName());
      super.gMJ();
      if (isSupportNavigationSwipeBack())
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().init();
      }
      if (i != 0) {
        com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34710);
            ((aa)ChattingUIFragment.this.dom.bh(aa.class)).gQn();
            ((aa)ChattingUIFragment.this.dom.bh(aa.class)).gPx();
            AppMethodBeat.o(34710);
          }
        });
      }
      gML();
      com.tencent.mm.plugin.groupsolitaire.b.b.aBh(this.dom.getTalkerUserName());
      AppMethodBeat.o(34754);
      return;
      i = 0;
      break;
      label383:
      j = (int)((com.tencent.mm.contact.c)localObject2).gMZ;
      break label142;
      label393:
      localObject1 = ((ax)localObject2).field_username;
      break label151;
      label402:
      localObject1 = localObject2;
      label405:
      if (com.tencent.mm.storage.as.IG(str))
      {
        Log.i("MicroMsg.ChattingUIFragment", "[protectContactNotExist] isBottleContact userName:".concat(String.valueOf(str)));
        ((com.tencent.mm.storage.as)localObject1).Ooy = str;
        ((com.tencent.mm.storage.as)localObject1).setUsername(str);
      }
      if (ab.IK(str))
      {
        localObject2 = new nf();
        ((nf)localObject2).eXG = 1L;
        ((nf)localObject2).bfK();
      }
      localObject2 = localObject1;
      if (ab.IL(str))
      {
        localObject2 = new ne();
        ((ne)localObject2).eXG = 1L;
        ((ne)localObject2).bfK();
        localObject2 = localObject1;
      }
    }
  }
  
  protected void gML()
  {
    AppMethodBeat.i(34772);
    this.EOZ = new com.tencent.mm.plugin.expt.hellhound.a.a.b.c(this.EPa, "ChattingUIFragment", c.a.sCy);
    this.mScrollState = 0;
    this.Pjt = ((MMChattingListView)findViewById(2131298453));
    this.Pjt.setIsReturnSuperDispatchWhenCancel(true);
    this.Pjq = this.Pjt.getListView();
    this.Pjq.setVisibility(0);
    ((aa)this.dom.bh(aa.class)).gQk();
    if (this.Pjt.getBaseAdapter() == null)
    {
      this.Pjp = new com.tencent.mm.ui.chatting.a.a(this.dom, this.Pjq);
      this.Pjt.setAdapter(this.Pjp);
    }
    Object localObject = this.Pjt;
    ((MMChattingListView)localObject).By(false);
    ((MMChattingListView)localObject).By(false);
    gNj();
    this.Pjx.a(d.a.PDG, true, null);
    this.Pjq.setOverScrollMode(2);
    if (!((am)this.dom.bh(am.class)).gQZ()) {
      this.Pjq.setTranscriptMode(1);
    }
    for (;;)
    {
      this.Pjq.setOnTouchListener(new View.OnTouchListener()
      {
        boolean pJi = false;
        
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(232894);
          ChattingUIFragment.h(ChattingUIFragment.this);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            Log.i("MicroMsg.ChattingUIFragment", "onTouch: touch down");
            this.pJi = true;
          }
          while ((!this.pJi) || (!ChattingUIFragment.this.Pjv))
          {
            AppMethodBeat.o(232894);
            return false;
            if (paramAnonymousMotionEvent.getAction() == 1)
            {
              Log.i("MicroMsg.ChattingUIFragment", "onTouch: touch up");
              this.pJi = false;
            }
          }
          paramAnonymousView = (u)ChattingUIFragment.this.dom.bh(u.class);
          if ((paramAnonymousView == null) || (paramAnonymousView.gPO() == null))
          {
            AppMethodBeat.o(232894);
            return false;
          }
          paramAnonymousView.gPO().Ak(true);
          AppMethodBeat.o(232894);
          return false;
        }
      });
      this.Pjq.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        /* Error */
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          // Byte code:
          //   0: aload_0
          //   1: monitorenter
          //   2: ldc 23
          //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   7: aload_0
          //   8: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:Pjy	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   11: getfield 35	com/tencent/mm/ui/chatting/BaseChattingUIFragment:dom	Lcom/tencent/mm/ui/chatting/e/a;
          //   14: getfield 41	com/tencent/mm/ui/chatting/e/a:Pwb	Lcom/tencent/mm/ui/chatting/d/p;
          //   17: aload_1
          //   18: iload_2
          //   19: iload_3
          //   20: iload 4
          //   22: invokevirtual 45	com/tencent/mm/ui/chatting/d/p:onScroll	(Landroid/widget/AbsListView;III)V
          //   25: aload_0
          //   26: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:Pjy	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   29: invokestatic 48	com/tencent/mm/ui/chatting/ChattingUIFragment:i	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
          //   32: ifeq +36 -> 68
          //   35: aload_0
          //   36: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:Pjy	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   39: invokestatic 52	com/tencent/mm/ui/chatting/ChattingUIFragment:b	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Landroid/widget/ListView;
          //   42: invokevirtual 58	android/widget/ListView:getLastVisiblePosition	()I
          //   45: iload 4
          //   47: iconst_1
          //   48: isub
          //   49: if_icmpeq +11 -> 60
          //   52: ldc 23
          //   54: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   57: aload_0
          //   58: monitorexit
          //   59: return
          //   60: aload_0
          //   61: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:Pjy	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   64: invokestatic 64	com/tencent/mm/ui/chatting/ChattingUIFragment:j	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
          //   67: pop
          //   68: aload_0
          //   69: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:Pjy	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   72: aload_1
          //   73: iload_2
          //   74: iload_3
          //   75: invokestatic 68	com/tencent/mm/ui/chatting/ChattingUIFragment:a	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;Landroid/widget/AbsListView;II)V
          //   78: ldc 23
          //   80: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   83: goto -26 -> 57
          //   86: astore_1
          //   87: aload_0
          //   88: monitorexit
          //   89: aload_1
          //   90: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	91	0	this	2
          //   0	91	1	paramAnonymousAbsListView	AbsListView
          //   0	91	2	paramAnonymousInt1	int
          //   0	91	3	paramAnonymousInt2	int
          //   0	91	4	paramAnonymousInt3	int
          // Exception table:
          //   from	to	target	type
          //   2	57	86	finally
          //   60	68	86	finally
          //   68	83	86	finally
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(232887);
          ChattingUIFragment.this.dom.Pwb.onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
          ChattingUIFragment.a(ChattingUIFragment.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            Log.d("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] [%s:%s]", new Object[] { Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition()), Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition()) });
            int i;
            LinkedList localLinkedList;
            label263:
            Object localObject2;
            if (ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() == 0)
            {
              localObject1 = ChattingUIFragment.b(ChattingUIFragment.this).getChildAt(0);
              if (localObject1 != null)
              {
                if (((View)localObject1).getTop() == 0)
                {
                  Log.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load top more!");
                  ChattingUIFragment.a(ChattingUIFragment.this).Bx(true);
                }
              }
              else
              {
                ChattingUIFragment.this.Pjp.fc(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
                com.tencent.mm.ui.chatting.a.a locala = ChattingUIFragment.this.Pjp;
                i = ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition();
                int k = ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount();
                int j = ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition();
                if (locala.OIz == null) {
                  break label628;
                }
                localObject1 = locala.OIz.GUe;
                if ((localObject1 == null) || (((com.tencent.mm.storage.as)localObject1).gBM())) {
                  break label628;
                }
                localLinkedList = new LinkedList();
                i -= k;
                if (i > j) {
                  break label569;
                }
                localObject1 = locala.amw(i);
                if (localObject1 != null)
                {
                  localObject2 = ((eo)localObject1).field_content;
                  if (localObject2 != null)
                  {
                    localObject1 = k.b.aD((String)localObject2, ((eo)localObject1).field_reserved);
                    if ((localObject1 != null) && (((k.b)localObject1).type == 5) && (!TextUtils.isEmpty(((k.b)localObject1).url)))
                    {
                      localObject2 = new e.a();
                      ((e.a)localObject2).url = ((k.b)localObject1).url;
                      ((e.a)localObject2).pmM = 1;
                      ((e.a)localObject2).appId = ((k.b)localObject1).appId;
                      ((e.a)localObject2).title = ((k.b)localObject1).title;
                      ((e.a)localObject2).desc = ((k.b)localObject1).description;
                      if (!locala.OIz.gRM()) {
                        break label562;
                      }
                    }
                  }
                }
              }
            }
            label562:
            for (Object localObject1 = "groupmessage";; localObject1 = "singlemessage")
            {
              ((e.a)localObject2).from = ((String)localObject1);
              localLinkedList.add(localObject2);
              i += 1;
              break label263;
              if (((View)localObject1).getTop() >= 0) {
                break;
              }
              Log.w("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] exception auto load top more wit reset adapter!");
              ChattingUIFragment.a(ChattingUIFragment.this).setAdapter(ChattingUIFragment.this.Pjp);
              break;
              if (ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition() != ChattingUIFragment.b(ChattingUIFragment.this).getCount() - 1) {
                break;
              }
              localObject1 = ChattingUIFragment.b(ChattingUIFragment.this).getChildAt(ChattingUIFragment.b(ChattingUIFragment.this).getChildCount() - 1);
              if ((localObject1 == null) || (ChattingUIFragment.b(ChattingUIFragment.this).getBottom() - ChattingUIFragment.a(ChattingUIFragment.this).getBottomHeight() < ((View)localObject1).getBottom())) {
                break;
              }
              Log.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load bottom more!");
              ChattingUIFragment.a(ChattingUIFragment.this).By(true);
              break;
            }
            label569:
            if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class) != null) && (localLinkedList.size() > 0))
            {
              Log.v("MicroMsg.ChattingDataAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
              ((com.tencent.mm.plugin.brandservice.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.e.class)).m(localLinkedList, 2);
            }
          }
          label628:
          ChattingUIFragment.a(ChattingUIFragment.this, paramAnonymousAbsListView, paramAnonymousInt);
          AppMethodBeat.o(232887);
        }
      });
      this.Pjq.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(232889);
          ChattingUIFragment.this.Pjp.fc(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
          ChattingUIFragment.b(ChattingUIFragment.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(232889);
        }
      });
      if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(2))
      {
        localObject = this.dom;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).GUe;
          if ((localObject != null) && (((com.tencent.mm.storage.as)localObject).gBM())) {
            ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CS(0);
          }
        }
      }
      registerForContextMenu(this.Pjq);
      bf(false, true);
      AppMethodBeat.o(34772);
      return;
      this.Pjq.setTranscriptMode(0);
    }
  }
  
  public final void gNX()
  {
    AppMethodBeat.i(34725);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      bf(false, bool);
      AppMethodBeat.o(34725);
      return;
    }
  }
  
  public final void gNY()
  {
    AppMethodBeat.i(34730);
    Log.i("MicroMsg.ChattingUIFragment", "[smoothScrollBy] dis:%d duration:%d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.Pjq.smoothScrollBy(0, 0);
    AppMethodBeat.o(34730);
  }
  
  public final void gNZ()
  {
    AppMethodBeat.i(34738);
    this.Pjt.setTopViewVisible(true);
    AppMethodBeat.o(34738);
  }
  
  public final void gNd()
  {
    AppMethodBeat.i(34757);
    super.gNd();
    if (this.dom.getTalkerUserName() == null)
    {
      AppMethodBeat.o(34757);
      return;
    }
    AppMethodBeat.o(34757);
  }
  
  public final w gNg()
  {
    AppMethodBeat.i(34750);
    if (this.dom.bh(aa.class) == null)
    {
      AppMethodBeat.o(34750);
      return null;
    }
    w localw = ((aa)this.dom.bh(aa.class)).gNg();
    AppMethodBeat.o(34750);
    return localw;
  }
  
  public final boolean gNh()
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
      View localView = getActivity().findViewById(2131303052);
      if (localView == null) {
        break label82;
      }
      localView.setVisibility(0);
      localView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34713);
          ChattingUIFragment.this.gOf();
          AppMethodBeat.o(34713);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(34763);
      return true;
      label82:
      gOf();
    }
  }
  
  public final com.tencent.mm.ui.chatting.n.a.a gNi()
  {
    return this.Pjx;
  }
  
  public final void gNj()
  {
    AppMethodBeat.i(34771);
    if ((this.Pjt == null) || (this.Pjp == null))
    {
      AppMethodBeat.o(34771);
      return;
    }
    Object localObject1 = this.dom;
    Object localObject2 = new com.tencent.mm.ui.chatting.h.a(this.dom, this.Pjp.PlE);
    com.tencent.mm.ui.chatting.h.b localb = new com.tencent.mm.ui.chatting.h.b(this.dom, this.Pjt);
    localObject2 = new com.tencent.mm.ui.chatting.h.e(localb, (com.tencent.mm.ui.chatting.h.c)localObject2);
    if (((com.tencent.mm.ui.chatting.d.b.d)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()) {
      localObject1 = new com.tencent.mm.ui.chatting.n.a.b((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.e)localObject2);
    }
    for (;;)
    {
      localb.PDC = ((b.a)localObject1);
      Log.i("MicroMsg.ChattingLoader.ChattingDataPresenterFactory", "[ChattingDataPresenterFactory] executor:%s", new Object[] { ((com.tencent.mm.ui.chatting.n.a.a)localObject1).toString() });
      this.Pjx = ((com.tencent.mm.ui.chatting.n.a.a)localObject1);
      this.Pjp.PlQ = this.Pjx;
      this.Pjt.setLoadExecutor(this.Pjx);
      AppMethodBeat.o(34771);
      return;
      if (((v)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(v.class)).gQb()) {
        localObject1 = new com.tencent.mm.ui.chatting.n.a.d((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.d)localObject2);
      } else if ((((am)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(am.class)).gRb()) || (((am)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(am.class)).gRc()) || (((am)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(am.class)).gQZ()) || (((ai)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(ai.class)).gQO())) {
        localObject1 = new f((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.d)localObject2);
      } else if ((((com.tencent.mm.ui.chatting.d.b.h)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(com.tencent.mm.ui.chatting.d.b.h.class)).gPu()) || (((com.tencent.mm.ui.chatting.d.b.i)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(com.tencent.mm.ui.chatting.d.b.i.class)).gPw())) {
        localObject1 = new com.tencent.mm.ui.chatting.n.a.c((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.e)localObject2);
      } else if (((o)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(o.class)).gPH()) {
        localObject1 = new com.tencent.mm.ui.chatting.n.a.g((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.d)localObject2);
      } else {
        localObject1 = new com.tencent.mm.ui.chatting.n.a.e((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.e)localObject2);
      }
    }
  }
  
  public final void gOa()
  {
    AppMethodBeat.i(34739);
    this.Pjt.setIsTopShowAll(false);
    AppMethodBeat.o(34739);
  }
  
  public final void gOb()
  {
    AppMethodBeat.i(34743);
    this.Pjt.Bx(false);
    AppMethodBeat.o(34743);
  }
  
  public final void gOc()
  {
    AppMethodBeat.i(34748);
    this.Pjq.setTranscriptMode(0);
    AppMethodBeat.o(34748);
  }
  
  public final MMChattingListView gOd()
  {
    return this.Pjt;
  }
  
  public final void gOe()
  {
    AppMethodBeat.i(34761);
    Object localObject1 = (am)this.dom.bh(am.class);
    Object localObject2 = (ai)this.dom.bh(ai.class);
    if ((!((am)localObject1).gQZ()) && (!((am)localObject1).gRb()) && (!((am)localObject1).gRc()) && (!((ai)localObject2).gQN()))
    {
      int i = this.ptj;
      this.ptj = (i + 1);
      if ((i < 10) && (((thisActivity() instanceof ChattingUI)) || ((thisActivity() instanceof AppBrandServiceChattingUI))))
      {
        localObject1 = this.Pjq;
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
              ChattingUIFragment.this.gOe();
              AppMethodBeat.o(34711);
              return;
            }
            ChattingUIFragment.e(ChattingUIFragment.this);
            AppMethodBeat.o(34711);
          }
        };
        if (this.ptj == 1) {}
        for (i = 10;; i = 100)
        {
          ((ListView)localObject1).postDelayed((Runnable)localObject2, i);
          AppMethodBeat.o(34761);
          return;
        }
      }
    }
    Log.d("MicroMsg.ChattingUIFragment", "scrollToLastProtect:%s, %s ,%s", new Object[] { Boolean.valueOf(((am)localObject1).gQZ()), Boolean.valueOf(((am)localObject1).gRb()), Integer.valueOf(this.ptj) });
    AppMethodBeat.o(34761);
  }
  
  protected final void gOf()
  {
    AppMethodBeat.i(34764);
    ((com.tencent.mm.ui.chatting.d.b.as)this.dom.bh(com.tencent.mm.ui.chatting.d.b.as.class)).aL(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34714);
        ChattingUIFragment.this.onExitBegin();
        if ((ChattingUIFragment.this.thisActivity() instanceof a.d)) {
          ((a.d)ChattingUIFragment.this.thisActivity()).anz();
        }
        if ((ChattingUIFragment.this.isCurrentActivity) || (!ChattingUIFragment.this.isSupportNavigationSwipeBack()))
        {
          ChattingUIFragment.this.gOg();
          AppMethodBeat.o(34714);
          return;
        }
        SwipeBackLayout localSwipeBackLayout = ChattingUIFragment.this.getSwipeBackLayout();
        Log.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", new Object[] { Boolean.valueOf(localSwipeBackLayout.hfx), Boolean.valueOf(localSwipeBackLayout.hfv), Boolean.valueOf(localSwipeBackLayout.hfw) });
        if (!localSwipeBackLayout.awK())
        {
          com.tencent.mm.ui.widget.h.aq(0.0F);
          localSwipeBackLayout.hfx = true;
          localSwipeBackLayout.hfw = false;
          int i = localSwipeBackLayout.mContentView.getWidth();
          int j = localSwipeBackLayout.hfs.getIntrinsicWidth();
          com.tencent.mm.ui.mogic.a locala = localSwipeBackLayout.QFb;
          locala.WL = localSwipeBackLayout.mContentView;
          locala.mActivePointerId = -1;
          locala.b(i + j + 10, 0, 0, 0, 260L);
          localSwipeBackLayout.invalidate();
          if (localSwipeBackLayout.QFc != null) {
            localSwipeBackLayout.QFc.onDrag();
          }
          com.tencent.mm.ui.widget.h.h(true, 0);
        }
        AppMethodBeat.o(34714);
      }
    });
    AppMethodBeat.o(34764);
  }
  
  protected final void gOg()
  {
    AppMethodBeat.i(34768);
    gOh();
    Object localObject = (com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    if (com.tencent.mm.storage.as.bjm(this.dom.getTalkerUserName()))
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
        if (((getIntExtra("chat_from_scene", 0) == 1) || (getIntExtra("chat_from_scene", 0) == 3)) && (this.dom.GUe != null) && (this.dom.GUe.gBM()) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).gOM() != null) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).gOM().UG()) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).gOM().cG(false) != null) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).gOM().cG(false).Vh() != null) && (!Util.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.d)localObject).gOM().UN())))
        {
          finish();
          AppMethodBeat.o(34768);
          return;
        }
        if (!((ac)this.dom.bh(ac.class)).gQH()) {
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
    finish();
    AppMethodBeat.o(34768);
  }
  
  public final int getBottomHeight()
  {
    AppMethodBeat.i(34745);
    if (this.Pjt == null)
    {
      AppMethodBeat.o(34745);
      return 0;
    }
    int i = this.Pjt.getBottomHeight();
    AppMethodBeat.o(34745);
    return i;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(34749);
    int i = this.Pjq.getFirstVisiblePosition();
    AppMethodBeat.o(34749);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131493476;
  }
  
  public final ListView getListView()
  {
    return this.Pjq;
  }
  
  public final int getTopHeight()
  {
    AppMethodBeat.i(34746);
    int i = this.Pjt.getTopHeight();
    AppMethodBeat.o(34746);
    return i;
  }
  
  public boolean getUserVisibleHint()
  {
    return this.dom.cQp;
  }
  
  public boolean hideVKB()
  {
    AppMethodBeat.i(34733);
    ChatFooter localChatFooter = ((u)this.dom.bh(u.class)).gPO();
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
  
  public boolean isSupportCustomActionBar()
  {
    AppMethodBeat.i(34751);
    boolean bool = isSupportNavigationSwipeBack();
    AppMethodBeat.o(34751);
    return bool;
  }
  
  public final void kh(Context paramContext)
  {
    AppMethodBeat.i(34753);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramContext);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doAttach", "(Landroid/content/Context;)V", this, localb.axR());
    super.kh(paramContext);
    Log.i("MicroMsg.ChattingUIFragment", "[doAttach]:%s#0x%x task:%s hc:%d", new Object[] { thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), Util.getActivityTaskInfo(thisActivity()), Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.bF(3, true);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doAttach", "(Landroid/content/Context;)V");
    AppMethodBeat.o(34753);
  }
  
  public final void lf(int paramInt1, int paramInt2)
  {
    int j = 1;
    AppMethodBeat.i(34732);
    com.tencent.mm.ui.chatting.e.a.gRP().removeCallbacks(this.Pjr);
    Log.i("MicroMsg.ChattingUIFragment", "[setSelectionFromTop] pos:%d offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    if (!this.dom.Pwg)
    {
      com.tencent.mm.pluginsdk.ui.tools.p.a(this.Pjq, paramInt1, paramInt2, false);
      AppMethodBeat.o(34732);
      return;
    }
    ListView localListView = this.Pjq;
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
        if (!com.tencent.mm.compatible.util.d.oF(11)) {
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
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oho, Boolean.TRUE);
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
    if ((isSupportNavigationSwipeBack()) && (this.Pjp != null)) {
      this.Pjv = true;
    }
    AppMethodBeat.o(34767);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    AppMethodBeat.i(34717);
    if (!this.dom.cQp)
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
    if ((isSupportNavigationSwipeBack()) && (this.Pjp != null)) {
      this.Pjv = false;
    }
    AppMethodBeat.o(34766);
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34758);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onEnterBegin", "()V", this);
    super.onEnterBegin();
    eGg();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onEnterBegin", "()V");
    AppMethodBeat.o(34758);
  }
  
  public final void onExitBegin()
  {
    AppMethodBeat.i(34759);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitBegin", "()V", this);
    super.onExitBegin();
    com.tencent.mm.ui.chatting.a.a locala = this.Pjp;
    locala.PlH = -1L;
    locala.PlG.clear();
    this.Pjx.PFv.cancel();
    eGg();
    EventCenter.instance.publish(new be());
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
      this.Pjq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34712);
          ChattingUIFragment.this.bf(true, false);
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
    ChatFooter localChatFooter = ((u)this.dom.bh(u.class)).gPO();
    if (localChatFooter != null) {
      localChatFooter.setIsMultiWindow(paramBoolean);
    }
    AppMethodBeat.o(34775);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(34765);
    Log.w("MicroMsg.ChattingUIFragment", "onSwipeBack");
    gOg();
    if (n.ecR().ecV())
    {
      fo localfo = new fo();
      localfo.dIN.username = com.tencent.mm.bi.d.jpB.bgL();
      EventCenter.instance.publish(localfo);
    }
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    AppMethodBeat.o(34765);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(34729);
    com.tencent.mm.ui.chatting.e.a.gRP().removeCallbacks(this.Pjr);
    Log.i("MicroMsg.ChattingUIFragment", "[scrollToPosition] scroll to pos:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.Pjs == null) {
      this.Pjs = new com.tencent.mm.ui.tools.q(this.Pjq);
    }
    com.tencent.mm.ui.tools.q localq = this.Pjs;
    int i = paramInt + this.Pjq.getHeaderViewsCount();
    localq.GP.removeCallbacks(localq);
    localq.QvV = System.currentTimeMillis();
    localq.Qwa = 0;
    paramInt = localq.GP.getFirstVisiblePosition();
    int j = localq.GP.getChildCount() + paramInt - 1;
    if (i <= paramInt)
    {
      paramInt = paramInt - i + 1;
      localq.mMode = 2;
      if (paramInt <= 0) {
        break label208;
      }
    }
    label208:
    for (localq.QvY = (1000 / paramInt);; localq.QvY = 1000)
    {
      localq.QvW = i;
      localq.QvX = -1;
      localq.GP.post(localq);
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
    ((aa)this.dom.bh(aa.class)).setBackBtn(paramOnMenuItemClickListener);
    AppMethodBeat.o(34723);
  }
  
  public final void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(34737);
    this.Pjt.setBottomViewVisible(paramBoolean);
    AppMethodBeat.o(34737);
  }
  
  public final void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(34740);
    this.Pjt.setIsBottomShowAll(paramBoolean);
    AppMethodBeat.o(34740);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(34736);
    if (this.Pjq != null) {
      this.Pjq.setKeepScreenOn(paramBoolean);
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
    ((aa)this.dom.bh(aa.class)).setMMSubTitle(paramString);
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
    ((aa)this.dom.bh(aa.class)).setMMTitle(paramString);
    AppMethodBeat.o(34720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */