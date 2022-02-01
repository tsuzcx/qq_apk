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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.b.a.jg;
import com.tencent.mm.g.b.a.jh;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.j.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.d.b.t;
import com.tencent.mm.ui.chatting.d.b.y;
import com.tencent.mm.ui.chatting.h.b.a;
import com.tencent.mm.ui.chatting.n.a.f;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import java.util.LinkedList;

@SuppressLint({"ValidFragment"})
public class ChattingUIFragment
  extends BaseChattingUIFragment
{
  public static String IoN;
  public com.tencent.mm.ui.chatting.a.a JDj;
  private ListView JDk;
  private Runnable JDl;
  private com.tencent.mm.ui.tools.q JDm;
  private MMChattingListView JDn;
  private boolean JDo = true;
  protected boolean JDp = true;
  private boolean JDq = false;
  private boolean JDr = false;
  private int JDs = 0;
  private final int JDt = 10;
  private com.tencent.mm.ui.chatting.n.a.a JDu;
  private int mScrollState = 0;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment() {}
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment(byte paramByte)
  {
    super((byte)0);
  }
  
  private boolean fCa()
  {
    AppMethodBeat.i(34769);
    l locall = (l)this.cWM.bh(l.class);
    com.tencent.mm.ui.chatting.d.b.ai localai = (com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class);
    if (locall.fDs())
    {
      if (localai.fEK())
      {
        localai.fEJ();
        locall.fDt();
      }
      for (;;)
      {
        AppMethodBeat.o(34769);
        return true;
        locall.fDq();
      }
    }
    AppMethodBeat.o(34769);
    return false;
  }
  
  private void xS(final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(34728);
    int m = this.JDk.getLastVisiblePosition();
    int n = this.JDk.getFirstVisiblePosition();
    final int k = this.JDk.getCount();
    ad.i("MicroMsg.ChattingUIFragment", "[scrollToLastImpl] isFirstScroll:%s [%s:%s] count:%s force:%s", new Object[] { Boolean.valueOf(this.JDo), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
    this.JDo = false;
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
          if (this.JDk.getChildCount() > 0) {
            i = this.JDk.getChildAt(this.JDk.getChildCount() - 1).getHeight();
          }
        }
      }
    }
    if ((paramBoolean) && (this.JDn.cbc())) {
      ad.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom");
    }
    for (;;)
    {
      this.JDk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34709);
          if ((paramBoolean) && (ChattingUIFragment.a(ChattingUIFragment.this).cbc()))
          {
            ad.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom in post");
            AppMethodBeat.o(34709);
            return;
          }
          com.tencent.mm.pluginsdk.ui.tools.n.a(ChattingUIFragment.b(ChattingUIFragment.this), k - 1, -i, true);
          AppMethodBeat.o(34709);
        }
      });
      AppMethodBeat.o(34728);
      return;
      com.tencent.mm.pluginsdk.ui.tools.n.a(this.JDk, k - 1, -i, true);
    }
  }
  
  public final void a(com.tencent.mm.ui.chatting.h.d.a parama)
  {
    AppMethodBeat.i(193864);
    if (this.JDj == null)
    {
      AppMethodBeat.o(193864);
      return;
    }
    com.tencent.mm.ui.chatting.a.a locala = this.JDj;
    if (locala.JFC != null) {
      locala.JFC.a(parama, false, null);
    }
    AppMethodBeat.o(193864);
  }
  
  @Deprecated
  public final void aW(final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(34727);
    if (paramBoolean2)
    {
      com.tencent.mm.ui.chatting.e.a.fFx().removeCallbacks(this.JDl);
      ap localap = com.tencent.mm.ui.chatting.e.a.fFx();
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34702);
          ChattingUIFragment.a(ChattingUIFragment.this, paramBoolean1);
          AppMethodBeat.o(34702);
        }
      };
      this.JDl = local1;
      localap.post(local1);
      AppMethodBeat.o(34727);
      return;
    }
    xS(paramBoolean1);
    AppMethodBeat.o(34727);
  }
  
  public final void acU(int paramInt)
  {
    AppMethodBeat.i(34731);
    com.tencent.mm.ui.chatting.e.a.fFx().removeCallbacks(this.JDl);
    ad.i("MicroMsg.ChattingUIFragment", "[setSelection] pos:%d isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    ListView localListView = this.JDk;
    if (localListView != null)
    {
      ad.i("MicroMsg.ChattingUI.ScrollController", "setSelection position %s smooth %s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
      localListView.setItemChecked(paramInt, true);
      localListView.setSelection(paramInt);
    }
    AppMethodBeat.o(34731);
  }
  
  public final void acV(int paramInt)
  {
    AppMethodBeat.i(193863);
    try
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.JDn.getLayoutParams();
      localLayoutParams.topMargin = paramInt;
      this.JDn.setLayoutParams(localLayoutParams);
      ad.d("MicroMsg.ChattingUIFragment", "setTopMarginHeight height:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(193863);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ChattingUIFragment", "setTopMarginHeight height:%s, %s, %s", new Object[] { Integer.valueOf(paramInt), localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(193863);
    }
  }
  
  public final void acW(int paramInt)
  {
    AppMethodBeat.i(34747);
    this.JDk.setVisibility(paramInt);
    if (ad.getLogLevel() == 2) {
      ad.i("MicroMsg.ChattingUIFragment", "[setListViewVisibility] visibility:" + paramInt + " stack:" + bt.flS().toString());
    }
    AppMethodBeat.o(34747);
  }
  
  protected final void aj(am paramam)
  {
    AppMethodBeat.i(34752);
    super.aj(paramam);
    IoN = paramam.field_username;
    AppMethodBeat.o(34752);
  }
  
  public final void b(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(34734);
    dismissDialog();
    this.tipDialog = com.tencent.mm.ui.base.h.b(paramContext, paramString, true, paramOnCancelListener);
    AppMethodBeat.o(34734);
  }
  
  public final void bOo()
  {
    AppMethodBeat.i(34724);
    if (this.JDj == null)
    {
      AppMethodBeat.o(34724);
      return;
    }
    this.JDj.notifyDataSetChanged();
    AppMethodBeat.o(34724);
  }
  
  public final void be(Bundle paramBundle)
  {
    AppMethodBeat.i(34742);
    this.JDn.be(paramBundle);
    AppMethodBeat.o(34742);
  }
  
  public final void bf(Bundle paramBundle)
  {
    AppMethodBeat.i(34744);
    this.JDn.b(true, paramBundle);
    AppMethodBeat.o(34744);
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(34729);
    com.tencent.mm.ui.chatting.e.a.fFx().removeCallbacks(this.JDl);
    ad.i("MicroMsg.ChattingUIFragment", "[scrollToPosition] scroll to pos:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.JDm == null) {
      this.JDm = new com.tencent.mm.ui.tools.q(this.JDk);
    }
    com.tencent.mm.ui.tools.q localq = this.JDm;
    int i = paramInt + this.JDk.getHeaderViewsCount();
    localq.GF.removeCallbacks(localq);
    localq.KKE = System.currentTimeMillis();
    localq.KKJ = 0;
    paramInt = localq.GF.getFirstVisiblePosition();
    int j = localq.GF.getChildCount() + paramInt - 1;
    if (i <= paramInt)
    {
      paramInt = paramInt - i + 1;
      localq.mMode = 2;
      if (paramInt <= 0) {
        break label208;
      }
    }
    label208:
    for (localq.KKH = (1000 / paramInt);; localq.KKH = 1000)
    {
      localq.KKF = i;
      localq.KKG = -1;
      localq.GF.post(localq);
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
  
  public void dCa()
  {
    AppMethodBeat.i(34773);
    ba.ajF().ay(new Runnable()
    {
      ac JDw;
      String username;
      
      public final void run()
      {
        AppMethodBeat.i(193861);
        long l = System.currentTimeMillis();
        if (this.JDw == null)
        {
          ad.e("MicroMsg.ChattingUIFragment", "messBoxComponent == null! without writeOpLogAndMarkRead!");
          AppMethodBeat.o(193861);
          return;
        }
        this.JDw.aWh(this.username);
        ad.i("MicroMsg.ChattingUIFragment", "ChattingUI writeOpLogAndMarkRead last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(193861);
      }
    });
    AppMethodBeat.o(34773);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(34718);
    super.dealContentView(paramView);
    ((y)this.cWM.bh(y.class)).gl(paramView);
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
  
  public void eei()
  {
    AppMethodBeat.i(34756);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V", this);
    super.eei();
    q.dismiss();
    ad.i("MicroMsg.ChattingUIFragment", "on chatting ui pause  rawuser:%s", new Object[] { this.cWM.getTalkerUserName() });
    if (this.cWM.getTalkerUserName() == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V");
      AppMethodBeat.o(34756);
      return;
    }
    this.JDj.pause();
    hideVKB();
    ad.d("MicroMsg.ChattingUIFragment", "chattingui cancel pause auto download logic");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V");
    AppMethodBeat.o(34756);
  }
  
  public void fAB()
  {
    AppMethodBeat.i(34755);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V", this);
    super.fAB();
    if (getWindow() != null) {
      getWindow().setBackgroundDrawableResource(2131100810);
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
      if (this.JDk.getVisibility() != 0) {
        break label161;
      }
    }
    label156:
    label161:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (this.cWM.cBJ) {
        break label166;
      }
      ad.i("MicroMsg.ChattingUIFragment", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b listviewShow:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
      AppMethodBeat.o(34755);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label73;
    }
    label166:
    if (!ba.ajx())
    {
      ad.w("MicroMsg.ChattingUIFragment", "account not ready, mabey not call onDestroy!!!");
      finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
      AppMethodBeat.o(34755);
      return;
    }
    this.JDj.resume();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
    AppMethodBeat.o(34755);
  }
  
  protected void fAC()
  {
    AppMethodBeat.i(34772);
    this.mScrollState = 0;
    this.JDn = ((MMChattingListView)findViewById(2131298103));
    this.JDn.setIsReturnSuperDispatchWhenCancel(true);
    this.JDk = this.JDn.getListView();
    this.JDk.setVisibility(0);
    ((y)this.cWM.bh(y.class)).fDY();
    if (this.JDn.getBaseAdapter() == null)
    {
      this.JDj = new com.tencent.mm.ui.chatting.a.a(this.cWM, this.JDk);
      this.JDn.setAdapter(this.JDj);
    }
    Object localObject = this.JDn;
    ((MMChattingListView)localObject).xB(false);
    ((MMChattingListView)localObject).xB(false);
    fAZ();
    this.JDu.a(com.tencent.mm.ui.chatting.h.d.a.JVg, true, null);
    this.JDk.setOverScrollMode(2);
    if (!((com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class)).fEM()) {
      this.JDk.setTranscriptMode(1);
    }
    for (;;)
    {
      this.JDk.setOnTouchListener(new View.OnTouchListener()
      {
        boolean mVq = false;
        
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(193862);
          ChattingUIFragment.h(ChattingUIFragment.this);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            ad.i("MicroMsg.ChattingUIFragment", "onTouch: touch down");
            this.mVq = true;
          }
          while ((!this.mVq) || (!ChattingUIFragment.this.JDp))
          {
            AppMethodBeat.o(193862);
            return false;
            if (paramAnonymousMotionEvent.getAction() == 1)
            {
              ad.i("MicroMsg.ChattingUIFragment", "onTouch: touch up");
              this.mVq = false;
            }
          }
          paramAnonymousView = (com.tencent.mm.ui.chatting.d.b.s)ChattingUIFragment.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.s.class);
          if ((paramAnonymousView == null) || (paramAnonymousView.fDC() == null))
          {
            AppMethodBeat.o(193862);
            return false;
          }
          paramAnonymousView.fDC().g(0, true, -1);
          AppMethodBeat.o(193862);
          return false;
        }
      });
      this.JDk.setOnScrollListener(new AbsListView.OnScrollListener()
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
          //   8: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:JDv	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   11: getfield 35	com/tencent/mm/ui/chatting/BaseChattingUIFragment:cWM	Lcom/tencent/mm/ui/chatting/e/a;
          //   14: getfield 41	com/tencent/mm/ui/chatting/e/a:JOP	Lcom/tencent/mm/ui/chatting/d/p;
          //   17: aload_1
          //   18: iload_2
          //   19: iload_3
          //   20: iload 4
          //   22: invokevirtual 45	com/tencent/mm/ui/chatting/d/p:onScroll	(Landroid/widget/AbsListView;III)V
          //   25: aload_0
          //   26: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:JDv	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   29: invokestatic 48	com/tencent/mm/ui/chatting/ChattingUIFragment:i	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
          //   32: ifeq +36 -> 68
          //   35: aload_0
          //   36: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:JDv	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
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
          //   61: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:JDv	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   64: invokestatic 64	com/tencent/mm/ui/chatting/ChattingUIFragment:j	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
          //   67: pop
          //   68: ldc 23
          //   70: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   73: goto -16 -> 57
          //   76: astore_1
          //   77: aload_0
          //   78: monitorexit
          //   79: aload_1
          //   80: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	81	0	this	2
          //   0	81	1	paramAnonymousAbsListView	AbsListView
          //   0	81	2	paramAnonymousInt1	int
          //   0	81	3	paramAnonymousInt2	int
          //   0	81	4	paramAnonymousInt3	int
          // Exception table:
          //   from	to	target	type
          //   2	57	76	finally
          //   60	68	76	finally
          //   68	73	76	finally
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(193857);
          ChattingUIFragment.this.cWM.JOP.onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
          ChattingUIFragment.a(ChattingUIFragment.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            ad.d("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] [%s:%s]", new Object[] { Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition()), Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition()) });
            LinkedList localLinkedList;
            label256:
            Object localObject;
            if (ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() == 0)
            {
              paramAnonymousAbsListView = ChattingUIFragment.b(ChattingUIFragment.this).getChildAt(0);
              if (paramAnonymousAbsListView != null)
              {
                if (paramAnonymousAbsListView.getTop() == 0)
                {
                  ad.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load top more!");
                  ChattingUIFragment.a(ChattingUIFragment.this).xA(true);
                }
              }
              else
              {
                ChattingUIFragment.this.JDj.eO(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
                com.tencent.mm.ui.chatting.a.a locala = ChattingUIFragment.this.JDj;
                paramAnonymousInt = ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition();
                int j = ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount();
                int i = ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition();
                if (locala.Jdu == null) {
                  break label600;
                }
                paramAnonymousAbsListView = locala.Jdu.BYG;
                if ((paramAnonymousAbsListView == null) || (paramAnonymousAbsListView.fqg())) {
                  break label600;
                }
                localLinkedList = new LinkedList();
                paramAnonymousInt -= j;
                if (paramAnonymousInt > i) {
                  break label542;
                }
                paramAnonymousAbsListView = locala.ade(paramAnonymousInt);
                if (paramAnonymousAbsListView != null)
                {
                  localObject = paramAnonymousAbsListView.field_content;
                  if (localObject != null)
                  {
                    paramAnonymousAbsListView = k.b.aA((String)localObject, paramAnonymousAbsListView.field_reserved);
                    if ((paramAnonymousAbsListView != null) && (paramAnonymousAbsListView.type == 5) && (!TextUtils.isEmpty(paramAnonymousAbsListView.url)))
                    {
                      localObject = new com.tencent.mm.plugin.brandservice.a.d.a();
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).url = paramAnonymousAbsListView.url;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).nWh = 1;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).appId = paramAnonymousAbsListView.appId;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).title = paramAnonymousAbsListView.title;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).desc = paramAnonymousAbsListView.description;
                      if (!locala.Jdu.fFv()) {
                        break label536;
                      }
                    }
                  }
                }
              }
            }
            label536:
            for (paramAnonymousAbsListView = "groupmessage";; paramAnonymousAbsListView = "singlemessage")
            {
              ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).dET = paramAnonymousAbsListView;
              localLinkedList.add(localObject);
              paramAnonymousInt += 1;
              break label256;
              if (paramAnonymousAbsListView.getTop() >= 0) {
                break;
              }
              ad.w("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] exception auto load top more wit reset adapter!");
              ChattingUIFragment.a(ChattingUIFragment.this).setAdapter(ChattingUIFragment.this.JDj);
              break;
              if (ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition() != ChattingUIFragment.b(ChattingUIFragment.this).getCount() - 1) {
                break;
              }
              paramAnonymousAbsListView = ChattingUIFragment.b(ChattingUIFragment.this).getChildAt(ChattingUIFragment.b(ChattingUIFragment.this).getChildCount() - 1);
              if ((paramAnonymousAbsListView == null) || (ChattingUIFragment.b(ChattingUIFragment.this).getBottom() - ChattingUIFragment.a(ChattingUIFragment.this).getBottomHeight() < paramAnonymousAbsListView.getBottom())) {
                break;
              }
              ad.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load bottom more!");
              ChattingUIFragment.a(ChattingUIFragment.this).xB(true);
              break;
            }
            label542:
            if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class) != null) && (localLinkedList.size() > 0))
            {
              ad.v("MicroMsg.ChattingDataAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
              ((com.tencent.mm.plugin.brandservice.a.d)g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).m(localLinkedList, 2);
            }
          }
          label600:
          AppMethodBeat.o(193857);
        }
      });
      this.JDk.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(193859);
          ChattingUIFragment.this.JDj.eO(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
          ChattingUIFragment.b(ChattingUIFragment.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(193859);
        }
      });
      if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(2))
      {
        localObject = this.cWM;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).BYG;
          if ((localObject != null) && (((am)localObject).fqg())) {
            ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zd(0);
          }
        }
      }
      registerForContextMenu(this.JDk);
      aW(false, true);
      AppMethodBeat.o(34772);
      return;
      this.JDk.setTranscriptMode(0);
    }
  }
  
  public final void fAT()
  {
    AppMethodBeat.i(34757);
    super.fAT();
    if (this.cWM.getTalkerUserName() == null)
    {
      AppMethodBeat.o(34757);
      return;
    }
    AppMethodBeat.o(34757);
  }
  
  public final v fAW()
  {
    AppMethodBeat.i(34750);
    if (this.cWM.bh(y.class) == null)
    {
      AppMethodBeat.o(34750);
      return null;
    }
    v localv = ((y)this.cWM.bh(y.class)).fAW();
    AppMethodBeat.o(34750);
    return localv;
  }
  
  public final boolean fAX()
  {
    AppMethodBeat.i(34763);
    if (!isScreenEnable())
    {
      ad.w("MicroMsg.ChattingUIFragment", "Actionbar customView onclick screen not enable");
      AppMethodBeat.o(34763);
      return true;
    }
    hideVKB();
    if (getActivity() != null)
    {
      View localView = getActivity().findViewById(2131301337);
      if (localView == null) {
        break label82;
      }
      localView.setVisibility(0);
      localView.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34713);
          ChattingUIFragment.this.fBY();
          AppMethodBeat.o(34713);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(34763);
      return true;
      label82:
      fBY();
    }
  }
  
  public final com.tencent.mm.ui.chatting.n.a.a fAY()
  {
    return this.JDu;
  }
  
  public final void fAZ()
  {
    AppMethodBeat.i(34771);
    if ((this.JDn == null) || (this.JDj == null))
    {
      AppMethodBeat.o(34771);
      return;
    }
    Object localObject1 = this.cWM;
    Object localObject2 = new com.tencent.mm.ui.chatting.h.a(this.cWM, this.JDj.JFq);
    com.tencent.mm.ui.chatting.h.b localb = new com.tencent.mm.ui.chatting.h.b(this.cWM, this.JDn);
    localObject2 = new com.tencent.mm.ui.chatting.h.e(localb, (com.tencent.mm.ui.chatting.h.c)localObject2);
    if (((com.tencent.mm.ui.chatting.d.b.d)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH()) {
      localObject1 = new com.tencent.mm.ui.chatting.n.a.b((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.e)localObject2);
    }
    for (;;)
    {
      localb.JVc = ((b.a)localObject1);
      ad.i("MicroMsg.ChattingLoader.ChattingDataPresenterFactory", "[ChattingDataPresenterFactory] executor:%s", new Object[] { ((com.tencent.mm.ui.chatting.n.a.a)localObject1).toString() });
      this.JDu = ((com.tencent.mm.ui.chatting.n.a.a)localObject1);
      this.JDj.JFC = this.JDu;
      this.JDn.setLoadExecutor(this.JDu);
      AppMethodBeat.o(34771);
      return;
      if (((t)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(t.class)).fDP()) {
        localObject1 = new com.tencent.mm.ui.chatting.n.a.d((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.d)localObject2);
      } else if ((((com.tencent.mm.ui.chatting.d.b.ai)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(com.tencent.mm.ui.chatting.d.b.ai.class)).fEO()) || (((com.tencent.mm.ui.chatting.d.b.ai)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(com.tencent.mm.ui.chatting.d.b.ai.class)).fEP()) || (((com.tencent.mm.ui.chatting.d.b.ai)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(com.tencent.mm.ui.chatting.d.b.ai.class)).fEM()) || (((af)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(af.class)).fEA())) {
        localObject1 = new f((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.d)localObject2);
      } else if ((((com.tencent.mm.ui.chatting.d.b.h)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(com.tencent.mm.ui.chatting.d.b.h.class)).fDl()) || (((i)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(i.class)).fDn())) {
        localObject1 = new com.tencent.mm.ui.chatting.n.a.c((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.e)localObject2);
      } else {
        localObject1 = new com.tencent.mm.ui.chatting.n.a.e((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.e)localObject2);
      }
    }
  }
  
  public void fAz()
  {
    AppMethodBeat.i(34754);
    this.JDr = false;
    this.JDo = true;
    this.JDp = true;
    ad.d("MicroMsg.ChattingUIFragment", "isFromSearch  " + getBooleanExtra("finish_direct", false));
    int i;
    Object localObject1;
    String str;
    Object localObject2;
    int j;
    if (this.cWM.BYG == null)
    {
      i = 1;
      ad.i("MicroMsg.ChattingUIFragment", "[doCreate] rawUserName from :%s to :%s ", new Object[] { this.cWM.getTalkerUserName(), getStringExtra("Chat_User") });
      localObject1 = getStringExtra("Chat_Self");
      this.cWM.JOQ = ((String)localObject1);
      str = getStringExtra("Chat_User");
      ba.aBQ();
      localObject2 = com.tencent.mm.model.c.azp().Bf(str);
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
      ad.w("MicroMsg.ChattingUIFragment", "protectContactNotExist raw:%s contact:%d username:%s", new Object[] { str, Integer.valueOf(j), localObject1 });
      if ((localObject2 != null) && ((int)((com.tencent.mm.o.b)localObject2).gfj != 0) && (!bt.isNullOrNil(((aw)localObject2).field_username))) {
        break label402;
      }
      localObject2 = new am();
      ((am)localObject2).setUsername(str);
      ((am)localObject2).IJW = str;
      ((am)localObject2).acI();
      ((am)localObject2).ke(3);
      ba.aBQ();
      com.tencent.mm.model.c.azp().af((am)localObject2);
      ba.aBQ();
      am localam = com.tencent.mm.model.c.azp().Bf(str);
      localObject1 = localam;
      if (localam != null) {
        break label405;
      }
      ad.e("MicroMsg.ChattingUIFragment", "protectContactNotExist contact get from db is null!");
    }
    for (;;)
    {
      aj((am)localObject2);
      ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WO(this.cWM.getTalkerUserName());
      super.fAz();
      if (isSupportNavigationSwipeBack())
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().init();
      }
      if (i != 0) {
        com.tencent.mm.ui.chatting.e.a.fFx().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34710);
            ((y)ChattingUIFragment.this.cWM.bh(y.class)).fEa();
            ((y)ChattingUIFragment.this.cWM.bh(y.class)).fDo();
            AppMethodBeat.o(34710);
          }
        });
      }
      fAC();
      com.tencent.mm.plugin.groupsolitaire.b.b.amN(this.cWM.getTalkerUserName());
      AppMethodBeat.o(34754);
      return;
      i = 0;
      break;
      label383:
      j = (int)((com.tencent.mm.o.b)localObject2).gfj;
      break label142;
      label393:
      localObject1 = ((aw)localObject2).field_username;
      break label151;
      label402:
      localObject1 = localObject2;
      label405:
      if (am.zs(str))
      {
        ad.i("MicroMsg.ChattingUIFragment", "[protectContactNotExist] isBottleContact userName:".concat(String.valueOf(str)));
        ((am)localObject1).IJW = str;
        ((am)localObject1).setUsername(str);
      }
      if (w.zw(str))
      {
        localObject2 = new jh();
        ((jh)localObject2).erT = 1L;
        ((jh)localObject2).aLk();
      }
      localObject2 = localObject1;
      if (w.zx(str))
      {
        localObject2 = new jg();
        ((jg)localObject2).erT = 1L;
        ((jg)localObject2).aLk();
        localObject2 = localObject1;
      }
    }
  }
  
  public final void fBQ()
  {
    AppMethodBeat.i(34725);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      aW(false, bool);
      AppMethodBeat.o(34725);
      return;
    }
  }
  
  public final void fBR()
  {
    AppMethodBeat.i(34730);
    ad.i("MicroMsg.ChattingUIFragment", "[smoothScrollBy] dis:%d duration:%d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.JDk.smoothScrollBy(0, 0);
    AppMethodBeat.o(34730);
  }
  
  public final void fBS()
  {
    AppMethodBeat.i(34738);
    this.JDn.setTopViewVisible(true);
    AppMethodBeat.o(34738);
  }
  
  public final void fBT()
  {
    AppMethodBeat.i(34739);
    this.JDn.setIsTopShowAll(false);
    AppMethodBeat.o(34739);
  }
  
  public final void fBU()
  {
    AppMethodBeat.i(34743);
    this.JDn.xA(false);
    AppMethodBeat.o(34743);
  }
  
  public final void fBV()
  {
    AppMethodBeat.i(34748);
    this.JDk.setTranscriptMode(0);
    AppMethodBeat.o(34748);
  }
  
  public final MMChattingListView fBW()
  {
    return this.JDn;
  }
  
  public final void fBX()
  {
    AppMethodBeat.i(34761);
    Object localObject1 = (com.tencent.mm.ui.chatting.d.b.ai)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.ai.class);
    Object localObject2 = (af)this.cWM.bh(af.class);
    if ((!((com.tencent.mm.ui.chatting.d.b.ai)localObject1).fEM()) && (!((com.tencent.mm.ui.chatting.d.b.ai)localObject1).fEO()) && (!((com.tencent.mm.ui.chatting.d.b.ai)localObject1).fEP()) && (!((af)localObject2).fEz()))
    {
      int i = this.JDs;
      this.JDs = (i + 1);
      if ((i < 10) && (((thisActivity() instanceof ChattingUI)) || ((thisActivity() instanceof AppBrandServiceChattingUI))))
      {
        localObject1 = this.JDk;
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34711);
            if ((ChattingUIFragment.c(ChattingUIFragment.this)) || (ChattingUIFragment.d(ChattingUIFragment.this) != 0))
            {
              ChattingUIFragment.e(ChattingUIFragment.this);
              ad.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect userTouched: %s state: %s", new Object[] { Boolean.valueOf(ChattingUIFragment.c(ChattingUIFragment.this)), Integer.valueOf(ChattingUIFragment.d(ChattingUIFragment.this)) });
              AppMethodBeat.o(34711);
              return;
            }
            int i = ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition();
            int j = ChattingUIFragment.b(ChattingUIFragment.this).getCount() - 1;
            ad.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", new Object[] { Integer.valueOf(ChattingUIFragment.f(ChattingUIFragment.this)), Integer.valueOf(i), Integer.valueOf(j) });
            if (i < j)
            {
              ChattingUIFragment.a(ChattingUIFragment.this, true);
              ChattingUIFragment.this.fBX();
              AppMethodBeat.o(34711);
              return;
            }
            ChattingUIFragment.e(ChattingUIFragment.this);
            AppMethodBeat.o(34711);
          }
        };
        if (this.JDs == 1) {}
        for (i = 10;; i = 100)
        {
          ((ListView)localObject1).postDelayed((Runnable)localObject2, i);
          AppMethodBeat.o(34761);
          return;
        }
      }
    }
    ad.d("MicroMsg.ChattingUIFragment", "scrollToLastProtect:%s, %s ,%s", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.d.b.ai)localObject1).fEM()), Boolean.valueOf(((com.tencent.mm.ui.chatting.d.b.ai)localObject1).fEO()), Integer.valueOf(this.JDs) });
    AppMethodBeat.o(34761);
  }
  
  protected final void fBY()
  {
    AppMethodBeat.i(34764);
    ((ao)this.cWM.bh(ao.class)).aG(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34714);
        ChattingUIFragment.this.onExitBegin();
        if ((ChattingUIFragment.this.thisActivity() instanceof a.d)) {
          ((a.d)ChattingUIFragment.this.thisActivity()).ZD();
        }
        if ((ChattingUIFragment.this.isCurrentActivity) || (!ChattingUIFragment.this.isSupportNavigationSwipeBack()))
        {
          ChattingUIFragment.this.fBZ();
          AppMethodBeat.o(34714);
          return;
        }
        SwipeBackLayout localSwipeBackLayout = ChattingUIFragment.this.getSwipeBackLayout();
        ad.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", new Object[] { Boolean.valueOf(localSwipeBackLayout.KTC), Boolean.valueOf(localSwipeBackLayout.KTA), Boolean.valueOf(localSwipeBackLayout.KTB) });
        if (!localSwipeBackLayout.fLI())
        {
          com.tencent.mm.ui.widget.h.bX(0.0F);
          localSwipeBackLayout.KTC = true;
          localSwipeBackLayout.KTB = false;
          int i = localSwipeBackLayout.mContentView.getWidth();
          int j = localSwipeBackLayout.KTx.getIntrinsicWidth();
          com.tencent.mm.ui.mogic.a locala = localSwipeBackLayout.KTv;
          locala.Wy = localSwipeBackLayout.mContentView;
          locala.mActivePointerId = -1;
          locala.b(i + j + 10, 0, 0, 0, 260L);
          localSwipeBackLayout.invalidate();
          if (localSwipeBackLayout.KTI != null) {
            localSwipeBackLayout.KTI.onDrag();
          }
          com.tencent.mm.ui.widget.h.Z(true, 0);
        }
        AppMethodBeat.o(34714);
      }
    });
    AppMethodBeat.o(34764);
  }
  
  protected final void fBZ()
  {
    AppMethodBeat.i(34768);
    fCa();
    Object localObject = (com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    if (am.aSN(this.cWM.getTalkerUserName()))
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      com.tencent.mm.bs.d.b(getContext(), "tmessage", ".ui.TConversationUI", (Intent)localObject);
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
        if (((getIntExtra("chat_from_scene", 0) == 1) || (getIntExtra("chat_from_scene", 0) == 3)) && (this.cWM.BYG != null) && (this.cWM.BYG.fqg()) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).fCE() != null) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).fCE().Ko()) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).fCE().bX(false) != null) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).fCE().bX(false).KP() != null) && (!bt.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.d)localObject).fCE().Kv())))
        {
          finish();
          AppMethodBeat.o(34768);
          return;
        }
        if (!((aa)this.cWM.bh(aa.class)).fEs()) {
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    overridePendingTransition(MMFragmentActivity.a.mOg, MMFragmentActivity.a.mOh);
    finish();
    AppMethodBeat.o(34768);
  }
  
  public void finish()
  {
    AppMethodBeat.i(34770);
    this.cWM.JOP.onFinish();
    Object localObject = (com.tencent.mm.ui.chatting.d.b.s)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.s.class);
    if ((localObject != null) && (((com.tencent.mm.ui.chatting.d.b.s)localObject).fDC() != null)) {
      ((com.tencent.mm.ui.chatting.d.b.s)localObject).fDC().g(0, true, -1);
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
          ad.i("MicroMsg.ChattingUIFragment", "[finish] isCurrentActivity:%s", new Object[] { Boolean.valueOf(ChattingUIFragment.this.isCurrentActivity) });
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
            ad.e("MicroMsg.ChattingUIFragment", "LauncherUI is null!???");
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
            ((a.d)ChattingUIFragment.this.thisActivity()).ZE();
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
      aq.o((Runnable)localObject, 100L);
      AppMethodBeat.o(34770);
      return;
    }
  }
  
  public final int getBottomHeight()
  {
    AppMethodBeat.i(34745);
    if (this.JDn == null)
    {
      AppMethodBeat.o(34745);
      return 0;
    }
    int i = this.JDn.getBottomHeight();
    AppMethodBeat.o(34745);
    return i;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(34749);
    int i = this.JDk.getFirstVisiblePosition();
    AppMethodBeat.o(34749);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131493382;
  }
  
  public final ListView getListView()
  {
    return this.JDk;
  }
  
  public final int getTopHeight()
  {
    AppMethodBeat.i(34746);
    int i = this.JDn.getTopHeight();
    AppMethodBeat.o(34746);
    return i;
  }
  
  public boolean getUserVisibleHint()
  {
    return this.cWM.cBJ;
  }
  
  public boolean hideVKB()
  {
    AppMethodBeat.i(34733);
    ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.d.b.s)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.s.class)).fDC();
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
  
  public final void jR(int paramInt1, int paramInt2)
  {
    int j = 1;
    AppMethodBeat.i(34732);
    com.tencent.mm.ui.chatting.e.a.fFx().removeCallbacks(this.JDl);
    ad.i("MicroMsg.ChattingUIFragment", "[setSelectionFromTop] pos:%d offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    if (!this.cWM.JOV)
    {
      com.tencent.mm.pluginsdk.ui.tools.n.a(this.JDk, paramInt1, paramInt2, false);
      AppMethodBeat.o(34732);
      return;
    }
    ListView localListView = this.JDk;
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
        ad.i("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop position %s smooth %s", new Object[] { Integer.valueOf(paramInt1), Boolean.TRUE });
        localListView.setItemChecked(paramInt1, true);
        if (!com.tencent.mm.compatible.util.d.lA(11)) {
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
  
  public final void ki(Context paramContext)
  {
    AppMethodBeat.i(34753);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramContext);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doAttach", "(Landroid/content/Context;)V", this, localb.ahq());
    super.ki(paramContext);
    ad.i("MicroMsg.ChattingUIFragment", "[doAttach]:%s#0x%x task:%s hc:%d", new Object[] { thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), bt.jl(thisActivity()), Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.be(3, true);
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
            g.ajC().ajl().set(al.a.IEr, Boolean.TRUE);
            if (paramInt1 == 30763)
            {
              com.tencent.mm.pluginsdk.permission.b.a(getActivity(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 67);
              AppMethodBeat.o(34774);
              return;
            }
            com.tencent.mm.pluginsdk.permission.b.a(getActivity(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68);
          }
        }
      }
    }
    AppMethodBeat.o(34774);
  }
  
  public void onCancelDrag()
  {
    AppMethodBeat.i(34767);
    if ((isSupportNavigationSwipeBack()) && (this.JDj != null)) {
      this.JDp = true;
    }
    AppMethodBeat.o(34767);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    AppMethodBeat.i(34717);
    if (!this.cWM.cBJ)
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
    if ((isSupportNavigationSwipeBack()) && (this.JDj != null)) {
      this.JDp = false;
    }
    AppMethodBeat.o(34766);
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34758);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onEnterBegin", "()V", this);
    super.onEnterBegin();
    dCa();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onEnterBegin", "()V");
    AppMethodBeat.o(34758);
  }
  
  public final void onExitBegin()
  {
    AppMethodBeat.i(34759);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitBegin", "()V", this);
    super.onExitBegin();
    com.tencent.mm.ui.chatting.a.a locala = this.JDj;
    locala.JFt = -1L;
    locala.JFs.clear();
    this.JDu.JWP.cancel();
    dCa();
    com.tencent.mm.sdk.b.a.IbL.l(new bc());
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
      this.JDk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34712);
          ChattingUIFragment.this.aW(true, false);
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
    ad.i("MicroMsg.ChattingUIFragment", "onMultiWindowModeChanged: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.d.b.s)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.s.class)).fDC();
    if (localChatFooter != null) {
      localChatFooter.setIsMultiWindow(paramBoolean);
    }
    AppMethodBeat.o(34775);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(34765);
    ad.w("MicroMsg.ChattingUIFragment", "onSwipeBack");
    fBZ();
    if (com.tencent.mm.plugin.location.model.n.dgh().dgl())
    {
      fk localfk = new fk();
      localfk.dqw.username = com.tencent.mm.bj.d.irv.aMm();
      com.tencent.mm.sdk.b.a.IbL.l(localfk);
    }
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    AppMethodBeat.o(34765);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(34723);
    ((y)this.cWM.bh(y.class)).setBackBtn(paramOnMenuItemClickListener);
    AppMethodBeat.o(34723);
  }
  
  public final void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(34737);
    this.JDn.setBottomViewVisible(paramBoolean);
    AppMethodBeat.o(34737);
  }
  
  public final void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(34740);
    this.JDn.setIsBottomShowAll(paramBoolean);
    AppMethodBeat.o(34740);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(34736);
    if (this.JDk != null) {
      this.JDk.setKeepScreenOn(paramBoolean);
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
    ((y)this.cWM.bh(y.class)).setMMSubTitle(paramString);
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
    ((y)this.cWM.bh(y.class)).setMMTitle(paramString);
    AppMethodBeat.o(34720);
  }
  
  public final void xB(boolean paramBoolean)
  {
    AppMethodBeat.i(34741);
    this.JDn.xB(paramBoolean);
    AppMethodBeat.o(34741);
  }
  
  public final void xR(boolean paramBoolean)
  {
    AppMethodBeat.i(34726);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      aW(paramBoolean, bool);
      AppMethodBeat.o(34726);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */