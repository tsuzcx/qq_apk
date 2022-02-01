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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.b.a.ji;
import com.tencent.mm.g.b.a.jj;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.j.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.ap;
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
  public static String IJd;
  public com.tencent.mm.ui.chatting.a.a JYa;
  private ListView JYb;
  private Runnable JYc;
  private com.tencent.mm.ui.tools.q JYd;
  private MMChattingListView JYe;
  private boolean JYf = true;
  protected boolean JYg = true;
  private boolean JYh = false;
  private boolean JYi = false;
  private int JYj = 0;
  private final int JYk = 10;
  private com.tencent.mm.ui.chatting.n.a.a JYl;
  private int mScrollState = 0;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment() {}
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment(byte paramByte)
  {
    super((byte)0);
  }
  
  private boolean fGc()
  {
    AppMethodBeat.i(34769);
    l locall = (l)this.cXJ.bh(l.class);
    com.tencent.mm.ui.chatting.d.b.aj localaj = (com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class);
    if (locall.fHv())
    {
      if (localaj.fIN())
      {
        localaj.fIM();
        locall.fHw();
      }
      for (;;)
      {
        AppMethodBeat.o(34769);
        return true;
        locall.fHt();
      }
    }
    AppMethodBeat.o(34769);
    return false;
  }
  
  private void xZ(final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(34728);
    int m = this.JYb.getLastVisiblePosition();
    int n = this.JYb.getFirstVisiblePosition();
    final int k = this.JYb.getCount();
    ae.i("MicroMsg.ChattingUIFragment", "[scrollToLastImpl] isFirstScroll:%s [%s:%s] count:%s force:%s", new Object[] { Boolean.valueOf(this.JYf), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
    this.JYf = false;
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
          if (this.JYb.getChildCount() > 0) {
            i = this.JYb.getChildAt(this.JYb.getChildCount() - 1).getHeight();
          }
        }
      }
    }
    if ((paramBoolean) && (this.JYe.ccr())) {
      ae.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom");
    }
    for (;;)
    {
      this.JYb.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34709);
          if ((paramBoolean) && (ChattingUIFragment.a(ChattingUIFragment.this).ccr()))
          {
            ae.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom in post");
            AppMethodBeat.o(34709);
            return;
          }
          com.tencent.mm.pluginsdk.ui.tools.n.a(ChattingUIFragment.b(ChattingUIFragment.this), k - 1, -i, true);
          AppMethodBeat.o(34709);
        }
      });
      AppMethodBeat.o(34728);
      return;
      com.tencent.mm.pluginsdk.ui.tools.n.a(this.JYb, k - 1, -i, true);
    }
  }
  
  public final void a(com.tencent.mm.ui.chatting.h.d.a parama)
  {
    AppMethodBeat.i(187170);
    if (this.JYa == null)
    {
      AppMethodBeat.o(187170);
      return;
    }
    com.tencent.mm.ui.chatting.a.a locala = this.JYa;
    if (locala.Kat != null) {
      locala.Kat.a(parama, false, null);
    }
    AppMethodBeat.o(187170);
  }
  
  @Deprecated
  public final void aV(final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(34727);
    if (paramBoolean2)
    {
      com.tencent.mm.ui.chatting.e.a.fJE().removeCallbacks(this.JYc);
      aq localaq = com.tencent.mm.ui.chatting.e.a.fJE();
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34702);
          ChattingUIFragment.a(ChattingUIFragment.this, paramBoolean1);
          AppMethodBeat.o(34702);
        }
      };
      this.JYc = local1;
      localaq.post(local1);
      AppMethodBeat.o(34727);
      return;
    }
    xZ(paramBoolean1);
    AppMethodBeat.o(34727);
  }
  
  public final void adC(int paramInt)
  {
    AppMethodBeat.i(34731);
    com.tencent.mm.ui.chatting.e.a.fJE().removeCallbacks(this.JYc);
    ae.i("MicroMsg.ChattingUIFragment", "[setSelection] pos:%d isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    ListView localListView = this.JYb;
    if (localListView != null)
    {
      ae.i("MicroMsg.ChattingUI.ScrollController", "setSelection position %s smooth %s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
      localListView.setItemChecked(paramInt, true);
      localListView.setSelection(paramInt);
    }
    AppMethodBeat.o(34731);
  }
  
  public final void adD(int paramInt)
  {
    AppMethodBeat.i(187169);
    try
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.JYe.getLayoutParams();
      localLayoutParams.topMargin = paramInt;
      this.JYe.setLayoutParams(localLayoutParams);
      ae.d("MicroMsg.ChattingUIFragment", "setTopMarginHeight height:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(187169);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ChattingUIFragment", "setTopMarginHeight height:%s, %s, %s", new Object[] { Integer.valueOf(paramInt), localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(187169);
    }
  }
  
  public final void adE(int paramInt)
  {
    AppMethodBeat.i(34747);
    this.JYb.setVisibility(paramInt);
    if (ae.getLogLevel() == 2) {
      ae.i("MicroMsg.ChattingUIFragment", "[setListViewVisibility] visibility:" + paramInt + " stack:" + bu.fpN().toString());
    }
    AppMethodBeat.o(34747);
  }
  
  protected final void aq(an paraman)
  {
    AppMethodBeat.i(34752);
    super.aq(paraman);
    IJd = paraman.field_username;
    AppMethodBeat.o(34752);
  }
  
  public final void b(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(34734);
    dismissDialog();
    this.tipDialog = com.tencent.mm.ui.base.h.b(paramContext, paramString, true, paramOnCancelListener);
    AppMethodBeat.o(34734);
  }
  
  public final void bPl()
  {
    AppMethodBeat.i(34724);
    if (this.JYa == null)
    {
      AppMethodBeat.o(34724);
      return;
    }
    this.JYa.notifyDataSetChanged();
    AppMethodBeat.o(34724);
  }
  
  public final void bf(Bundle paramBundle)
  {
    AppMethodBeat.i(34742);
    this.JYe.bf(paramBundle);
    AppMethodBeat.o(34742);
  }
  
  public final void bg(Bundle paramBundle)
  {
    AppMethodBeat.i(34744);
    this.JYe.b(true, paramBundle);
    AppMethodBeat.o(34744);
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(34729);
    com.tencent.mm.ui.chatting.e.a.fJE().removeCallbacks(this.JYc);
    ae.i("MicroMsg.ChattingUIFragment", "[scrollToPosition] scroll to pos:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.JYd == null) {
      this.JYd = new com.tencent.mm.ui.tools.q(this.JYb);
    }
    com.tencent.mm.ui.tools.q localq = this.JYd;
    int i = paramInt + this.JYb.getHeaderViewsCount();
    localq.GF.removeCallbacks(localq);
    localq.LgY = System.currentTimeMillis();
    localq.Lhd = 0;
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
    for (localq.Lhb = (1000 / paramInt);; localq.Lhb = 1000)
    {
      localq.LgZ = i;
      localq.Lha = -1;
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
  
  public void dFr()
  {
    AppMethodBeat.i(34773);
    com.tencent.mm.model.bc.ajU().aw(new Runnable()
    {
      ac JYn;
      String username;
      
      public final void run()
      {
        AppMethodBeat.i(187167);
        long l = System.currentTimeMillis();
        if (this.JYn == null)
        {
          ae.e("MicroMsg.ChattingUIFragment", "messBoxComponent == null! without writeOpLogAndMarkRead!");
          AppMethodBeat.o(187167);
          return;
        }
        this.JYn.aXI(this.username);
        ae.i("MicroMsg.ChattingUIFragment", "ChattingUI writeOpLogAndMarkRead last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(187167);
      }
    });
    AppMethodBeat.o(34773);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(34718);
    super.dealContentView(paramView);
    ((y)this.cXJ.bh(y.class)).gk(paramView);
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
  
  public void ehQ()
  {
    AppMethodBeat.i(34756);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V", this);
    super.ehQ();
    r.dismiss();
    ae.i("MicroMsg.ChattingUIFragment", "on chatting ui pause  rawuser:%s", new Object[] { this.cXJ.getTalkerUserName() });
    if (this.cXJ.getTalkerUserName() == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V");
      AppMethodBeat.o(34756);
      return;
    }
    this.JYa.pause();
    hideVKB();
    ae.d("MicroMsg.ChattingUIFragment", "chattingui cancel pause auto download logic");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doPause", "()V");
    AppMethodBeat.o(34756);
  }
  
  public void fEB()
  {
    AppMethodBeat.i(34754);
    this.JYi = false;
    this.JYf = true;
    this.JYg = true;
    ae.d("MicroMsg.ChattingUIFragment", "isFromSearch  " + getBooleanExtra("finish_direct", false));
    int i;
    Object localObject1;
    String str;
    Object localObject2;
    int j;
    if (this.cXJ.Cqh == null)
    {
      i = 1;
      ae.i("MicroMsg.ChattingUIFragment", "[doCreate] rawUserName from :%s to :%s ", new Object[] { this.cXJ.getTalkerUserName(), getStringExtra("Chat_User") });
      localObject1 = getStringExtra("Chat_Self");
      this.cXJ.Kkc = ((String)localObject1);
      str = getStringExtra("Chat_User");
      com.tencent.mm.model.bc.aCg();
      localObject2 = com.tencent.mm.model.c.azF().BH(str);
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
      ae.w("MicroMsg.ChattingUIFragment", "protectContactNotExist raw:%s contact:%d username:%s", new Object[] { str, Integer.valueOf(j), localObject1 });
      if ((localObject2 != null) && ((int)((com.tencent.mm.contact.c)localObject2).ght != 0) && (!bu.isNullOrNil(((aw)localObject2).field_username))) {
        break label402;
      }
      localObject2 = new an();
      ((an)localObject2).setUsername(str);
      ((an)localObject2).JeD = str;
      ((an)localObject2).acT();
      ((an)localObject2).kg(3);
      com.tencent.mm.model.bc.aCg();
      com.tencent.mm.model.c.azF().am((an)localObject2);
      com.tencent.mm.model.bc.aCg();
      an localan = com.tencent.mm.model.c.azF().BH(str);
      localObject1 = localan;
      if (localan != null) {
        break label405;
      }
      ae.e("MicroMsg.ChattingUIFragment", "protectContactNotExist contact get from db is null!");
    }
    for (;;)
    {
      aq((an)localObject2);
      ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).XA(this.cXJ.getTalkerUserName());
      super.fEB();
      if (isSupportNavigationSwipeBack())
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().init();
      }
      if (i != 0) {
        com.tencent.mm.ui.chatting.e.a.fJE().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34710);
            ((y)ChattingUIFragment.this.cXJ.bh(y.class)).fId();
            ((y)ChattingUIFragment.this.cXJ.bh(y.class)).fHr();
            AppMethodBeat.o(34710);
          }
        });
      }
      fEE();
      com.tencent.mm.plugin.groupsolitaire.b.b.anO(this.cXJ.getTalkerUserName());
      AppMethodBeat.o(34754);
      return;
      i = 0;
      break;
      label383:
      j = (int)((com.tencent.mm.contact.c)localObject2).ght;
      break label142;
      label393:
      localObject1 = ((aw)localObject2).field_username;
      break label151;
      label402:
      localObject1 = localObject2;
      label405:
      if (an.Ac(str))
      {
        ae.i("MicroMsg.ChattingUIFragment", "[protectContactNotExist] isBottleContact userName:".concat(String.valueOf(str)));
        ((an)localObject1).JeD = str;
        ((an)localObject1).setUsername(str);
      }
      if (x.Ag(str))
      {
        localObject2 = new jj();
        ((jj)localObject2).etA = 1L;
        ((jj)localObject2).aLH();
      }
      localObject2 = localObject1;
      if (x.Ah(str))
      {
        localObject2 = new ji();
        ((ji)localObject2).etA = 1L;
        ((ji)localObject2).aLH();
        localObject2 = localObject1;
      }
    }
  }
  
  public void fED()
  {
    AppMethodBeat.i(34755);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V", this);
    super.fED();
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
      if (this.JYb.getVisibility() != 0) {
        break label161;
      }
    }
    label156:
    label161:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (this.cXJ.cCq) {
        break label166;
      }
      ae.i("MicroMsg.ChattingUIFragment", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b listviewShow:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
      AppMethodBeat.o(34755);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label73;
    }
    label166:
    if (!com.tencent.mm.model.bc.ajM())
    {
      ae.w("MicroMsg.ChattingUIFragment", "account not ready, mabey not call onDestroy!!!");
      finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
      AppMethodBeat.o(34755);
      return;
    }
    this.JYa.resume();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doResume", "()V");
    AppMethodBeat.o(34755);
  }
  
  protected void fEE()
  {
    AppMethodBeat.i(34772);
    this.mScrollState = 0;
    this.JYe = ((MMChattingListView)findViewById(2131298103));
    this.JYe.setIsReturnSuperDispatchWhenCancel(true);
    this.JYb = this.JYe.getListView();
    this.JYb.setVisibility(0);
    ((y)this.cXJ.bh(y.class)).fIb();
    if (this.JYe.getBaseAdapter() == null)
    {
      this.JYa = new com.tencent.mm.ui.chatting.a.a(this.cXJ, this.JYb);
      this.JYe.setAdapter(this.JYa);
    }
    Object localObject = this.JYe;
    ((MMChattingListView)localObject).xJ(false);
    ((MMChattingListView)localObject).xJ(false);
    fFb();
    this.JYl.a(com.tencent.mm.ui.chatting.h.d.a.Kry, true, null);
    this.JYb.setOverScrollMode(2);
    if (!((com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class)).fIP()) {
      this.JYb.setTranscriptMode(1);
    }
    for (;;)
    {
      this.JYb.setOnTouchListener(new View.OnTouchListener()
      {
        boolean naw = false;
        
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(187168);
          ChattingUIFragment.h(ChattingUIFragment.this);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            ae.i("MicroMsg.ChattingUIFragment", "onTouch: touch down");
            this.naw = true;
          }
          while ((!this.naw) || (!ChattingUIFragment.this.JYg))
          {
            AppMethodBeat.o(187168);
            return false;
            if (paramAnonymousMotionEvent.getAction() == 1)
            {
              ae.i("MicroMsg.ChattingUIFragment", "onTouch: touch up");
              this.naw = false;
            }
          }
          paramAnonymousView = (com.tencent.mm.ui.chatting.d.b.s)ChattingUIFragment.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.s.class);
          if ((paramAnonymousView == null) || (paramAnonymousView.fHF() == null))
          {
            AppMethodBeat.o(187168);
            return false;
          }
          paramAnonymousView.fHF().g(0, true, -1);
          AppMethodBeat.o(187168);
          return false;
        }
      });
      this.JYb.setOnScrollListener(new AbsListView.OnScrollListener()
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
          //   8: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:JYm	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   11: getfield 35	com/tencent/mm/ui/chatting/BaseChattingUIFragment:cXJ	Lcom/tencent/mm/ui/chatting/e/a;
          //   14: getfield 41	com/tencent/mm/ui/chatting/e/a:Kkb	Lcom/tencent/mm/ui/chatting/d/p;
          //   17: aload_1
          //   18: iload_2
          //   19: iload_3
          //   20: iload 4
          //   22: invokevirtual 45	com/tencent/mm/ui/chatting/d/p:onScroll	(Landroid/widget/AbsListView;III)V
          //   25: aload_0
          //   26: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:JYm	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   29: invokestatic 48	com/tencent/mm/ui/chatting/ChattingUIFragment:i	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
          //   32: ifeq +36 -> 68
          //   35: aload_0
          //   36: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:JYm	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
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
          //   61: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:JYm	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
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
          AppMethodBeat.i(187163);
          ChattingUIFragment.this.cXJ.Kkb.onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
          ChattingUIFragment.a(ChattingUIFragment.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            ae.d("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] [%s:%s]", new Object[] { Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition()), Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition()) });
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
                  ae.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load top more!");
                  ChattingUIFragment.a(ChattingUIFragment.this).xI(true);
                }
              }
              else
              {
                ChattingUIFragment.this.JYa.eP(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
                com.tencent.mm.ui.chatting.a.a locala = ChattingUIFragment.this.JYa;
                paramAnonymousInt = ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition();
                int j = ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount();
                int i = ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition();
                if (locala.Jyf == null) {
                  break label600;
                }
                paramAnonymousAbsListView = locala.Jyf.Cqh;
                if ((paramAnonymousAbsListView == null) || (paramAnonymousAbsListView.fug())) {
                  break label600;
                }
                localLinkedList = new LinkedList();
                paramAnonymousInt -= j;
                if (paramAnonymousInt > i) {
                  break label542;
                }
                paramAnonymousAbsListView = locala.adL(paramAnonymousInt);
                if (paramAnonymousAbsListView != null)
                {
                  localObject = paramAnonymousAbsListView.field_content;
                  if (localObject != null)
                  {
                    paramAnonymousAbsListView = k.b.aB((String)localObject, paramAnonymousAbsListView.field_reserved);
                    if ((paramAnonymousAbsListView != null) && (paramAnonymousAbsListView.type == 5) && (!TextUtils.isEmpty(paramAnonymousAbsListView.url)))
                    {
                      localObject = new com.tencent.mm.plugin.brandservice.a.d.a();
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).url = paramAnonymousAbsListView.url;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).obQ = 1;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).appId = paramAnonymousAbsListView.appId;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).title = paramAnonymousAbsListView.title;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).desc = paramAnonymousAbsListView.description;
                      if (!locala.Jyf.fJC()) {
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
              ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).dFY = paramAnonymousAbsListView;
              localLinkedList.add(localObject);
              paramAnonymousInt += 1;
              break label256;
              if (paramAnonymousAbsListView.getTop() >= 0) {
                break;
              }
              ae.w("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] exception auto load top more wit reset adapter!");
              ChattingUIFragment.a(ChattingUIFragment.this).setAdapter(ChattingUIFragment.this.JYa);
              break;
              if (ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition() != ChattingUIFragment.b(ChattingUIFragment.this).getCount() - 1) {
                break;
              }
              paramAnonymousAbsListView = ChattingUIFragment.b(ChattingUIFragment.this).getChildAt(ChattingUIFragment.b(ChattingUIFragment.this).getChildCount() - 1);
              if ((paramAnonymousAbsListView == null) || (ChattingUIFragment.b(ChattingUIFragment.this).getBottom() - ChattingUIFragment.a(ChattingUIFragment.this).getBottomHeight() < paramAnonymousAbsListView.getBottom())) {
                break;
              }
              ae.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load bottom more!");
              ChattingUIFragment.a(ChattingUIFragment.this).xJ(true);
              break;
            }
            label542:
            if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class) != null) && (localLinkedList.size() > 0))
            {
              ae.v("MicroMsg.ChattingDataAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
              ((com.tencent.mm.plugin.brandservice.a.d)g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).m(localLinkedList, 2);
            }
          }
          label600:
          AppMethodBeat.o(187163);
        }
      });
      this.JYb.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(187165);
          ChattingUIFragment.this.JYa.eP(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
          ChattingUIFragment.b(ChattingUIFragment.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(187165);
        }
      });
      if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(2))
      {
        localObject = this.cXJ;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.ui.chatting.e.a)localObject).Cqh;
          if ((localObject != null) && (((an)localObject).fug())) {
            ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zm(0);
          }
        }
      }
      registerForContextMenu(this.JYb);
      aV(false, true);
      AppMethodBeat.o(34772);
      return;
      this.JYb.setTranscriptMode(0);
    }
  }
  
  public final void fEV()
  {
    AppMethodBeat.i(34757);
    super.fEV();
    if (this.cXJ.getTalkerUserName() == null)
    {
      AppMethodBeat.o(34757);
      return;
    }
    AppMethodBeat.o(34757);
  }
  
  public final v fEY()
  {
    AppMethodBeat.i(34750);
    if (this.cXJ.bh(y.class) == null)
    {
      AppMethodBeat.o(34750);
      return null;
    }
    v localv = ((y)this.cXJ.bh(y.class)).fEY();
    AppMethodBeat.o(34750);
    return localv;
  }
  
  public final boolean fEZ()
  {
    AppMethodBeat.i(34763);
    if (!isScreenEnable())
    {
      ae.w("MicroMsg.ChattingUIFragment", "Actionbar customView onclick screen not enable");
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
          ChattingUIFragment.this.fGa();
          AppMethodBeat.o(34713);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(34763);
      return true;
      label82:
      fGa();
    }
  }
  
  public final void fFS()
  {
    AppMethodBeat.i(34725);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      aV(false, bool);
      AppMethodBeat.o(34725);
      return;
    }
  }
  
  public final void fFT()
  {
    AppMethodBeat.i(34730);
    ae.i("MicroMsg.ChattingUIFragment", "[smoothScrollBy] dis:%d duration:%d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.JYb.smoothScrollBy(0, 0);
    AppMethodBeat.o(34730);
  }
  
  public final void fFU()
  {
    AppMethodBeat.i(34738);
    this.JYe.setTopViewVisible(true);
    AppMethodBeat.o(34738);
  }
  
  public final void fFV()
  {
    AppMethodBeat.i(34739);
    this.JYe.setIsTopShowAll(false);
    AppMethodBeat.o(34739);
  }
  
  public final void fFW()
  {
    AppMethodBeat.i(34743);
    this.JYe.xI(false);
    AppMethodBeat.o(34743);
  }
  
  public final void fFX()
  {
    AppMethodBeat.i(34748);
    this.JYb.setTranscriptMode(0);
    AppMethodBeat.o(34748);
  }
  
  public final MMChattingListView fFY()
  {
    return this.JYe;
  }
  
  public final void fFZ()
  {
    AppMethodBeat.i(34761);
    Object localObject1 = (com.tencent.mm.ui.chatting.d.b.aj)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.aj.class);
    Object localObject2 = (af)this.cXJ.bh(af.class);
    if ((!((com.tencent.mm.ui.chatting.d.b.aj)localObject1).fIP()) && (!((com.tencent.mm.ui.chatting.d.b.aj)localObject1).fIR()) && (!((com.tencent.mm.ui.chatting.d.b.aj)localObject1).fIS()) && (!((af)localObject2).fID()))
    {
      int i = this.JYj;
      this.JYj = (i + 1);
      if ((i < 10) && (((thisActivity() instanceof ChattingUI)) || ((thisActivity() instanceof AppBrandServiceChattingUI))))
      {
        localObject1 = this.JYb;
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34711);
            if ((ChattingUIFragment.c(ChattingUIFragment.this)) || (ChattingUIFragment.d(ChattingUIFragment.this) != 0))
            {
              ChattingUIFragment.e(ChattingUIFragment.this);
              ae.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect userTouched: %s state: %s", new Object[] { Boolean.valueOf(ChattingUIFragment.c(ChattingUIFragment.this)), Integer.valueOf(ChattingUIFragment.d(ChattingUIFragment.this)) });
              AppMethodBeat.o(34711);
              return;
            }
            int i = ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition();
            int j = ChattingUIFragment.b(ChattingUIFragment.this).getCount() - 1;
            ae.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", new Object[] { Integer.valueOf(ChattingUIFragment.f(ChattingUIFragment.this)), Integer.valueOf(i), Integer.valueOf(j) });
            if (i < j)
            {
              ChattingUIFragment.a(ChattingUIFragment.this, true);
              ChattingUIFragment.this.fFZ();
              AppMethodBeat.o(34711);
              return;
            }
            ChattingUIFragment.e(ChattingUIFragment.this);
            AppMethodBeat.o(34711);
          }
        };
        if (this.JYj == 1) {}
        for (i = 10;; i = 100)
        {
          ((ListView)localObject1).postDelayed((Runnable)localObject2, i);
          AppMethodBeat.o(34761);
          return;
        }
      }
    }
    ae.d("MicroMsg.ChattingUIFragment", "scrollToLastProtect:%s, %s ,%s", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.d.b.aj)localObject1).fIP()), Boolean.valueOf(((com.tencent.mm.ui.chatting.d.b.aj)localObject1).fIR()), Integer.valueOf(this.JYj) });
    AppMethodBeat.o(34761);
  }
  
  public final com.tencent.mm.ui.chatting.n.a.a fFa()
  {
    return this.JYl;
  }
  
  public final void fFb()
  {
    AppMethodBeat.i(34771);
    if ((this.JYe == null) || (this.JYa == null))
    {
      AppMethodBeat.o(34771);
      return;
    }
    Object localObject1 = this.cXJ;
    Object localObject2 = new com.tencent.mm.ui.chatting.h.a(this.cXJ, this.JYa.Kah);
    com.tencent.mm.ui.chatting.h.b localb = new com.tencent.mm.ui.chatting.h.b(this.cXJ, this.JYe);
    localObject2 = new com.tencent.mm.ui.chatting.h.e(localb, (com.tencent.mm.ui.chatting.h.c)localObject2);
    if (((com.tencent.mm.ui.chatting.d.b.d)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ()) {
      localObject1 = new com.tencent.mm.ui.chatting.n.a.b((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.e)localObject2);
    }
    for (;;)
    {
      localb.Kru = ((b.a)localObject1);
      ae.i("MicroMsg.ChattingLoader.ChattingDataPresenterFactory", "[ChattingDataPresenterFactory] executor:%s", new Object[] { ((com.tencent.mm.ui.chatting.n.a.a)localObject1).toString() });
      this.JYl = ((com.tencent.mm.ui.chatting.n.a.a)localObject1);
      this.JYa.Kat = this.JYl;
      this.JYe.setLoadExecutor(this.JYl);
      AppMethodBeat.o(34771);
      return;
      if (((t)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(t.class)).fHS()) {
        localObject1 = new com.tencent.mm.ui.chatting.n.a.d((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.d)localObject2);
      } else if ((((com.tencent.mm.ui.chatting.d.b.aj)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(com.tencent.mm.ui.chatting.d.b.aj.class)).fIR()) || (((com.tencent.mm.ui.chatting.d.b.aj)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(com.tencent.mm.ui.chatting.d.b.aj.class)).fIS()) || (((com.tencent.mm.ui.chatting.d.b.aj)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(com.tencent.mm.ui.chatting.d.b.aj.class)).fIP()) || (((af)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(af.class)).fIE())) {
        localObject1 = new f((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.d)localObject2);
      } else if ((((com.tencent.mm.ui.chatting.d.b.h)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(com.tencent.mm.ui.chatting.d.b.h.class)).fHo()) || (((i)((com.tencent.mm.ui.chatting.e.a)localObject1).bh(i.class)).fHq())) {
        localObject1 = new com.tencent.mm.ui.chatting.n.a.c((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.e)localObject2);
      } else {
        localObject1 = new com.tencent.mm.ui.chatting.n.a.e((com.tencent.mm.ui.chatting.e.a)localObject1, (com.tencent.mm.ui.chatting.h.e)localObject2);
      }
    }
  }
  
  protected final void fGa()
  {
    AppMethodBeat.i(34764);
    ((ap)this.cXJ.bh(ap.class)).aE(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34714);
        ChattingUIFragment.this.onExitBegin();
        if ((ChattingUIFragment.this.thisActivity() instanceof a.d)) {
          ((a.d)ChattingUIFragment.this.thisActivity()).ZM();
        }
        if ((ChattingUIFragment.this.isCurrentActivity) || (!ChattingUIFragment.this.isSupportNavigationSwipeBack()))
        {
          ChattingUIFragment.this.fGb();
          AppMethodBeat.o(34714);
          return;
        }
        SwipeBackLayout localSwipeBackLayout = ChattingUIFragment.this.getSwipeBackLayout();
        ae.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", new Object[] { Boolean.valueOf(localSwipeBackLayout.Lqa), Boolean.valueOf(localSwipeBackLayout.LpY), Boolean.valueOf(localSwipeBackLayout.LpZ) });
        if (!localSwipeBackLayout.fQc())
        {
          com.tencent.mm.ui.widget.h.bV(0.0F);
          localSwipeBackLayout.Lqa = true;
          localSwipeBackLayout.LpZ = false;
          int i = localSwipeBackLayout.mContentView.getWidth();
          int j = localSwipeBackLayout.LpV.getIntrinsicWidth();
          com.tencent.mm.ui.mogic.a locala = localSwipeBackLayout.LpT;
          locala.Wy = localSwipeBackLayout.mContentView;
          locala.mActivePointerId = -1;
          locala.b(i + j + 10, 0, 0, 0, 260L);
          localSwipeBackLayout.invalidate();
          if (localSwipeBackLayout.Lqg != null) {
            localSwipeBackLayout.Lqg.onDrag();
          }
          com.tencent.mm.ui.widget.h.ad(true, 0);
        }
        AppMethodBeat.o(34714);
      }
    });
    AppMethodBeat.o(34764);
  }
  
  protected final void fGb()
  {
    AppMethodBeat.i(34768);
    fGc();
    Object localObject = (com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    if (an.aUn(this.cXJ.getTalkerUserName()))
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      com.tencent.mm.br.d.b(getContext(), "tmessage", ".ui.TConversationUI", (Intent)localObject);
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
        if (((getIntExtra("chat_from_scene", 0) == 1) || (getIntExtra("chat_from_scene", 0) == 3)) && (this.cXJ.Cqh != null) && (this.cXJ.Cqh.fug()) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).fGG() != null) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).fGG().Kw()) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).fGG().bX(false) != null) && (((com.tencent.mm.ui.chatting.d.b.d)localObject).fGG().bX(false).KX() != null) && (!bu.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.d)localObject).fGG().KD())))
        {
          finish();
          AppMethodBeat.o(34768);
          return;
        }
        if (!((aa)this.cXJ.bh(aa.class)).fIw()) {
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
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    overridePendingTransition(MMFragmentActivity.a.mTk, MMFragmentActivity.a.mTl);
    finish();
    AppMethodBeat.o(34768);
  }
  
  public void finish()
  {
    AppMethodBeat.i(34770);
    this.cXJ.Kkb.onFinish();
    Object localObject = (com.tencent.mm.ui.chatting.d.b.s)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.s.class);
    if ((localObject != null) && (((com.tencent.mm.ui.chatting.d.b.s)localObject).fHF() != null)) {
      ((com.tencent.mm.ui.chatting.d.b.s)localObject).fHF().g(0, true, -1);
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
          ae.i("MicroMsg.ChattingUIFragment", "[finish] isCurrentActivity:%s", new Object[] { Boolean.valueOf(ChattingUIFragment.this.isCurrentActivity) });
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
            ae.e("MicroMsg.ChattingUIFragment", "LauncherUI is null!???");
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
            ((a.d)ChattingUIFragment.this.thisActivity()).ZN();
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
      ar.o((Runnable)localObject, 100L);
      AppMethodBeat.o(34770);
      return;
    }
  }
  
  public final int getBottomHeight()
  {
    AppMethodBeat.i(34745);
    if (this.JYe == null)
    {
      AppMethodBeat.o(34745);
      return 0;
    }
    int i = this.JYe.getBottomHeight();
    AppMethodBeat.o(34745);
    return i;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(34749);
    int i = this.JYb.getFirstVisiblePosition();
    AppMethodBeat.o(34749);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131493382;
  }
  
  public final ListView getListView()
  {
    return this.JYb;
  }
  
  public final int getTopHeight()
  {
    AppMethodBeat.i(34746);
    int i = this.JYe.getTopHeight();
    AppMethodBeat.o(34746);
    return i;
  }
  
  public boolean getUserVisibleHint()
  {
    return this.cXJ.cCq;
  }
  
  public boolean hideVKB()
  {
    AppMethodBeat.i(34733);
    ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.d.b.s)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.s.class)).fHF();
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
  
  public final void jV(int paramInt1, int paramInt2)
  {
    int j = 1;
    AppMethodBeat.i(34732);
    com.tencent.mm.ui.chatting.e.a.fJE().removeCallbacks(this.JYc);
    ae.i("MicroMsg.ChattingUIFragment", "[setSelectionFromTop] pos:%d offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    if (!this.cXJ.Kkh)
    {
      com.tencent.mm.pluginsdk.ui.tools.n.a(this.JYb, paramInt1, paramInt2, false);
      AppMethodBeat.o(34732);
      return;
    }
    ListView localListView = this.JYb;
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
        ae.i("MicroMsg.ChattingUI.ScrollController", "setSelectionFromTop position %s smooth %s", new Object[] { Integer.valueOf(paramInt1), Boolean.TRUE });
        localListView.setItemChecked(paramInt1, true);
        if (!com.tencent.mm.compatible.util.d.lC(11)) {
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
  
  public final void kp(Context paramContext)
  {
    AppMethodBeat.i(34753);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramContext);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "doAttach", "(Landroid/content/Context;)V", this, localb.ahF());
    super.kp(paramContext);
    ae.i("MicroMsg.ChattingUIFragment", "[doAttach]:%s#0x%x task:%s hc:%d", new Object[] { thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), bu.jr(thisActivity()), Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.bk(3, true);
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
            g.ajR().ajA().set(am.a.IYR, Boolean.TRUE);
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
    if ((isSupportNavigationSwipeBack()) && (this.JYa != null)) {
      this.JYg = true;
    }
    AppMethodBeat.o(34767);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    AppMethodBeat.i(34717);
    if (!this.cXJ.cCq)
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
    if ((isSupportNavigationSwipeBack()) && (this.JYa != null)) {
      this.JYg = false;
    }
    AppMethodBeat.o(34766);
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34758);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onEnterBegin", "()V", this);
    super.onEnterBegin();
    dFr();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onEnterBegin", "()V");
    AppMethodBeat.o(34758);
  }
  
  public final void onExitBegin()
  {
    AppMethodBeat.i(34759);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingUIFragment", "com/tencent/mm/ui/chatting/ChattingUIFragment", "onExitBegin", "()V", this);
    super.onExitBegin();
    com.tencent.mm.ui.chatting.a.a locala = this.JYa;
    locala.Kak = -1L;
    locala.Kaj.clear();
    this.JYl.Ktg.cancel();
    dFr();
    com.tencent.mm.sdk.b.a.IvT.l(new com.tencent.mm.g.a.bc());
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
      this.JYb.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34712);
          ChattingUIFragment.this.aV(true, false);
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
    ae.i("MicroMsg.ChattingUIFragment", "onMultiWindowModeChanged: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.d.b.s)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.s.class)).fHF();
    if (localChatFooter != null) {
      localChatFooter.setIsMultiWindow(paramBoolean);
    }
    AppMethodBeat.o(34775);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(34765);
    ae.w("MicroMsg.ChattingUIFragment", "onSwipeBack");
    fGb();
    if (com.tencent.mm.plugin.location.model.n.djg().djk())
    {
      fl localfl = new fl();
      localfl.drB.username = com.tencent.mm.bi.d.iup.aMK();
      com.tencent.mm.sdk.b.a.IvT.l(localfl);
    }
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    AppMethodBeat.o(34765);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(34723);
    ((y)this.cXJ.bh(y.class)).setBackBtn(paramOnMenuItemClickListener);
    AppMethodBeat.o(34723);
  }
  
  public final void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(34737);
    this.JYe.setBottomViewVisible(paramBoolean);
    AppMethodBeat.o(34737);
  }
  
  public final void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(34740);
    this.JYe.setIsBottomShowAll(paramBoolean);
    AppMethodBeat.o(34740);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(34736);
    if (this.JYb != null) {
      this.JYb.setKeepScreenOn(paramBoolean);
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
    ((y)this.cXJ.bh(y.class)).setMMSubTitle(paramString);
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
    ((y)this.cXJ.bh(y.class)).setMMTitle(paramString);
    AppMethodBeat.o(34720);
  }
  
  public final void xJ(boolean paramBoolean)
  {
    AppMethodBeat.i(34741);
    this.JYe.xJ(paramBoolean);
    AppMethodBeat.o(34741);
  }
  
  public final void xY(boolean paramBoolean)
  {
    AppMethodBeat.i(34726);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      aV(paramBoolean, bool);
      AppMethodBeat.o(34726);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */