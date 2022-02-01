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
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.b.a.ic;
import com.tencent.mm.g.b.a.id;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.ak;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.y;
import com.tencent.mm.ui.chatting.g.b.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import java.util.LinkedList;

@SuppressLint({"ValidFragment"})
public class ChattingUIFragment
  extends BaseChattingUIFragment
{
  public static String GCx;
  private boolean HPA = true;
  protected boolean HPB = true;
  private boolean HPC = false;
  private boolean HPD = false;
  private int HPE = 0;
  private final int HPF = 10;
  private com.tencent.mm.ui.chatting.m.a.a HPG;
  public com.tencent.mm.ui.chatting.a.a HPv;
  private ListView HPw;
  private Runnable HPx;
  private com.tencent.mm.ui.tools.q HPy;
  private MMChattingListView HPz;
  private int mScrollState = 0;
  private p tipDialog = null;
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment() {}
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment(byte paramByte)
  {
    super((byte)0);
  }
  
  private boolean flJ()
  {
    AppMethodBeat.i(34769);
    j localj = (j)this.cLy.bf(j.class);
    com.tencent.mm.ui.chatting.c.b.ae localae = (com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class);
    if (localj.fmU())
    {
      if (localae.fog())
      {
        localae.fof();
        localj.fmV();
      }
      for (;;)
      {
        AppMethodBeat.o(34769);
        return true;
        localj.fmS();
      }
    }
    AppMethodBeat.o(34769);
    return false;
  }
  
  private void xh(final boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(34728);
    int m = this.HPw.getLastVisiblePosition();
    int n = this.HPw.getFirstVisiblePosition();
    final int k = this.HPw.getCount();
    ac.i("MicroMsg.ChattingUIFragment", "[scrollToLastImpl] isFirstScroll:%s [%s:%s] count:%s force:%s", new Object[] { Boolean.valueOf(this.HPA), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
    this.HPA = false;
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
          if (this.HPw.getChildCount() > 0) {
            i = this.HPw.getChildAt(this.HPw.getChildCount() - 1).getHeight();
          }
        }
      }
    }
    if ((paramBoolean) && (this.HPz.bWz())) {
      ac.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom");
    }
    for (;;)
    {
      this.HPw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34709);
          if ((paramBoolean) && (ChattingUIFragment.a(ChattingUIFragment.this).bWz()))
          {
            ac.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom in post");
            AppMethodBeat.o(34709);
            return;
          }
          com.tencent.mm.pluginsdk.ui.tools.n.a(ChattingUIFragment.b(ChattingUIFragment.this), k - 1, -i, true);
          AppMethodBeat.o(34709);
        }
      });
      AppMethodBeat.o(34728);
      return;
      com.tencent.mm.pluginsdk.ui.tools.n.a(this.HPw, k - 1, -i, true);
    }
  }
  
  public final void a(com.tencent.mm.ui.chatting.g.d.a parama)
  {
    AppMethodBeat.i(196436);
    if (this.HPv == null)
    {
      AppMethodBeat.o(196436);
      return;
    }
    com.tencent.mm.ui.chatting.a.a locala = this.HPv;
    if (locala.HRK != null) {
      locala.HRK.a(parama, false, null);
    }
    AppMethodBeat.o(196436);
  }
  
  @Deprecated
  public final void aO(final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(34727);
    if (paramBoolean2)
    {
      com.tencent.mm.ui.chatting.d.a.foS().removeCallbacks(this.HPx);
      ao localao = com.tencent.mm.ui.chatting.d.a.foS();
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34702);
          ChattingUIFragment.a(ChattingUIFragment.this, paramBoolean1);
          AppMethodBeat.o(34702);
        }
      };
      this.HPx = local1;
      localao.post(local1);
      AppMethodBeat.o(34727);
      return;
    }
    xh(paramBoolean1);
    AppMethodBeat.o(34727);
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(34742);
    this.HPz.aZ(paramBundle);
    AppMethodBeat.o(34742);
  }
  
  public final void aaK(int paramInt)
  {
    AppMethodBeat.i(34731);
    com.tencent.mm.ui.chatting.d.a.foS().removeCallbacks(this.HPx);
    ac.i("MicroMsg.ChattingUIFragment", "[setSelection] pos:%d isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    ListView localListView = this.HPw;
    if (localListView != null)
    {
      ac.i("MicroMsg.ChattingUI.ScrollController", "setSelection position %s smooth %s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
      localListView.setItemChecked(paramInt, true);
      localListView.setSelection(paramInt);
    }
    AppMethodBeat.o(34731);
  }
  
  public final void aaL(int paramInt)
  {
    AppMethodBeat.i(34747);
    this.HPw.setVisibility(paramInt);
    if (ac.getLogLevel() == 2) {
      ac.i("MicroMsg.ChattingUIFragment", "[setListViewVisibility] visibility:" + paramInt + " stack:" + bs.eWi().toString());
    }
    AppMethodBeat.o(34747);
  }
  
  protected final void aj(ai paramai)
  {
    AppMethodBeat.i(34752);
    super.aj(paramai);
    GCx = paramai.field_username;
    AppMethodBeat.o(34752);
  }
  
  public final void b(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(34734);
    dismissDialog();
    this.tipDialog = com.tencent.mm.ui.base.h.b(paramContext, paramString, true, paramOnCancelListener);
    AppMethodBeat.o(34734);
  }
  
  public final void bJU()
  {
    AppMethodBeat.i(34724);
    if (this.HPv == null)
    {
      AppMethodBeat.o(34724);
      return;
    }
    this.HPv.notifyDataSetChanged();
    AppMethodBeat.o(34724);
  }
  
  public final void ba(Bundle paramBundle)
  {
    AppMethodBeat.i(34744);
    this.HPz.a(true, paramBundle);
    AppMethodBeat.o(34744);
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(34729);
    com.tencent.mm.ui.chatting.d.a.foS().removeCallbacks(this.HPx);
    ac.i("MicroMsg.ChattingUIFragment", "[scrollToPosition] scroll to pos:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.HPy == null) {
      this.HPy = new com.tencent.mm.ui.tools.q(this.HPw);
    }
    com.tencent.mm.ui.tools.q localq = this.HPy;
    int i = paramInt + this.HPw.getHeaderViewsCount();
    localq.EO.removeCallbacks(localq);
    localq.ITA = System.currentTimeMillis();
    localq.ITF = 0;
    paramInt = localq.EO.getFirstVisiblePosition();
    int j = localq.EO.getChildCount() + paramInt - 1;
    if (i <= paramInt)
    {
      paramInt = paramInt - i + 1;
      localq.mMode = 2;
      if (paramInt <= 0) {
        break label208;
      }
    }
    label208:
    for (localq.ITD = (1000 / paramInt);; localq.ITD = 1000)
    {
      localq.ITB = i;
      localq.ITC = -1;
      localq.EO.post(localq);
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
  
  public void dRO()
  {
    AppMethodBeat.i(34756);
    super.dRO();
    q.dismiss();
    ac.i("MicroMsg.ChattingUIFragment", "on chatting ui pause  rawuser:%s", new Object[] { this.cLy.getTalkerUserName() });
    if (this.cLy.getTalkerUserName() == null)
    {
      AppMethodBeat.o(34756);
      return;
    }
    this.HPv.pause();
    hideVKB();
    ac.d("MicroMsg.ChattingUIFragment", "chattingui cancel pause auto download logic");
    AppMethodBeat.o(34756);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(34718);
    super.dealContentView(paramView);
    ((com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).fW(paramView);
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
  
  public void dry()
  {
    AppMethodBeat.i(34773);
    az.agU().az(new Runnable()
    {
      aa HPI;
      String username;
      
      public final void run()
      {
        AppMethodBeat.i(196434);
        long l = System.currentTimeMillis();
        if (this.HPI == null)
        {
          ac.e("MicroMsg.ChattingUIFragment", "messBoxComponent == null! without writeOpLogAndMarkRead!");
          AppMethodBeat.o(196434);
          return;
        }
        this.HPI.aQo(this.username);
        ac.i("MicroMsg.ChattingUIFragment", "ChattingUI writeOpLogAndMarkRead last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(196434);
      }
    });
    AppMethodBeat.o(34773);
  }
  
  public void finish()
  {
    AppMethodBeat.i(34770);
    this.cLy.HZD.onFinish();
    Object localObject = (com.tencent.mm.ui.chatting.c.b.q)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class);
    if ((localObject != null) && (((com.tencent.mm.ui.chatting.c.b.q)localObject).fne() != null)) {
      ((com.tencent.mm.ui.chatting.c.b.q)localObject).fne().g(0, true, -1);
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
          ac.i("MicroMsg.ChattingUIFragment", "[finish] isCurrentActivity:%s", new Object[] { Boolean.valueOf(ChattingUIFragment.this.isCurrentActivity) });
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
            ac.e("MicroMsg.ChattingUIFragment", "LauncherUI is null!???");
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
          }
          label174:
          for (bool1 = bool2;; bool1 = false)
          {
            ((BaseConversationUI)localObject).closeChatting(bool1);
            AppMethodBeat.o(34715);
            return;
          }
        }
      };
      if (i == 0)
      {
        ((Runnable)localObject).run();
        AppMethodBeat.o(34770);
        return;
      }
      ap.n((Runnable)localObject, 100L);
      AppMethodBeat.o(34770);
      return;
    }
  }
  
  public final void fkE()
  {
    AppMethodBeat.i(34757);
    super.fkE();
    if (this.cLy.getTalkerUserName() == null)
    {
      AppMethodBeat.o(34757);
      return;
    }
    AppMethodBeat.o(34757);
  }
  
  public final v fkH()
  {
    AppMethodBeat.i(34750);
    if (this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class) == null)
    {
      AppMethodBeat.o(34750);
      return null;
    }
    v localv = ((com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).fkH();
    AppMethodBeat.o(34750);
    return localv;
  }
  
  public final boolean fkI()
  {
    AppMethodBeat.i(34763);
    if (!isScreenEnable())
    {
      ac.w("MicroMsg.ChattingUIFragment", "Actionbar customView onclick screen not enable");
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
          ChattingUIFragment.this.flH();
          AppMethodBeat.o(34713);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(34763);
      return true;
      label82:
      flH();
    }
  }
  
  public final com.tencent.mm.ui.chatting.m.a.a fkJ()
  {
    return this.HPG;
  }
  
  public final void fkK()
  {
    AppMethodBeat.i(34771);
    if ((this.HPz == null) || (this.HPv == null))
    {
      AppMethodBeat.o(34771);
      return;
    }
    Object localObject1 = this.cLy;
    Object localObject2 = new com.tencent.mm.ui.chatting.g.a(this.cLy, this.HPv.HRA);
    com.tencent.mm.ui.chatting.g.b localb = new com.tencent.mm.ui.chatting.g.b(this.cLy, this.HPz);
    localObject2 = new com.tencent.mm.ui.chatting.g.e(localb, (com.tencent.mm.ui.chatting.g.c)localObject2);
    if (((com.tencent.mm.ui.chatting.c.b.d)((com.tencent.mm.ui.chatting.d.a)localObject1).bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo()) {
      localObject1 = new com.tencent.mm.ui.chatting.m.a.b((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.g.e)localObject2);
    }
    for (;;)
    {
      localb.IeP = ((b.a)localObject1);
      ac.i("MicroMsg.ChattingLoader.ChattingDataPresenterFactory", "[ChattingDataPresenterFactory] executor:%s", new Object[] { ((com.tencent.mm.ui.chatting.m.a.a)localObject1).toString() });
      this.HPG = ((com.tencent.mm.ui.chatting.m.a.a)localObject1);
      this.HPv.HRK = this.HPG;
      this.HPz.setLoadExecutor(this.HPG);
      AppMethodBeat.o(34771);
      return;
      if (((r)((com.tencent.mm.ui.chatting.d.a)localObject1).bf(r.class)).fnr()) {
        localObject1 = new com.tencent.mm.ui.chatting.m.a.c((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.g.d)localObject2);
      } else if ((((com.tencent.mm.ui.chatting.c.b.ae)((com.tencent.mm.ui.chatting.d.a)localObject1).bf(com.tencent.mm.ui.chatting.c.b.ae.class)).fok()) || (((com.tencent.mm.ui.chatting.c.b.ae)((com.tencent.mm.ui.chatting.d.a)localObject1).bf(com.tencent.mm.ui.chatting.c.b.ae.class)).fol()) || (((com.tencent.mm.ui.chatting.c.b.ae)((com.tencent.mm.ui.chatting.d.a)localObject1).bf(com.tencent.mm.ui.chatting.c.b.ae.class)).foi())) {
        localObject1 = new com.tencent.mm.ui.chatting.m.a.e((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.g.d)localObject2);
      } else {
        localObject1 = new com.tencent.mm.ui.chatting.m.a.d((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.g.e)localObject2);
      }
    }
  }
  
  public void fkk()
  {
    AppMethodBeat.i(34754);
    this.HPD = false;
    this.HPA = true;
    this.HPB = true;
    ac.d("MicroMsg.ChattingUIFragment", "isFromSearch  " + getBooleanExtra("finish_direct", false));
    int i;
    String str;
    Object localObject2;
    int j;
    label126:
    Object localObject1;
    if (this.cLy.AzG == null)
    {
      i = 1;
      ac.i("MicroMsg.ChattingUIFragment", "[doCreate] rawUserName from :%s to :%s ", new Object[] { this.cLy.getTalkerUserName(), getStringExtra("Chat_User") });
      str = getStringExtra("Chat_User");
      az.ayM();
      localObject2 = com.tencent.mm.model.c.awB().aNt(str);
      if (localObject2 != null) {
        break label367;
      }
      j = -1;
      if (localObject2 != null) {
        break label377;
      }
      localObject1 = "null";
      label135:
      ac.w("MicroMsg.ChattingUIFragment", "protectContactNotExist raw:%s contact:%d username:%s", new Object[] { str, Integer.valueOf(j), localObject1 });
      if ((localObject2 != null) && ((int)((com.tencent.mm.n.b)localObject2).fLJ != 0) && (!bs.isNullOrNil(((av)localObject2).field_username))) {
        break label386;
      }
      localObject2 = new ai();
      ((ai)localObject2).setUsername(str);
      ((ai)localObject2).GWJ = str;
      ((ai)localObject2).aag();
      ((ai)localObject2).jG(3);
      az.ayM();
      com.tencent.mm.model.c.awB().af((ai)localObject2);
      az.ayM();
      ai localai = com.tencent.mm.model.c.awB().aNt(str);
      localObject1 = localai;
      if (localai != null) {
        break label389;
      }
      ac.e("MicroMsg.ChattingUIFragment", "protectContactNotExist contact get from db is null!");
    }
    for (;;)
    {
      aj((ai)localObject2);
      ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Ti(this.cLy.getTalkerUserName());
      super.fkk();
      if (isSupportNavigationSwipeBack())
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().init();
      }
      if (i != 0) {
        com.tencent.mm.ui.chatting.d.a.foS().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34710);
            ((com.tencent.mm.ui.chatting.c.b.w)ChattingUIFragment.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).fnD();
            ((com.tencent.mm.ui.chatting.c.b.w)ChattingUIFragment.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).fnC();
            AppMethodBeat.o(34710);
          }
        });
      }
      fkn();
      com.tencent.mm.plugin.groupsolitaire.b.b.aia(this.cLy.getTalkerUserName());
      AppMethodBeat.o(34754);
      return;
      i = 0;
      break;
      label367:
      j = (int)((com.tencent.mm.n.b)localObject2).fLJ;
      break label126;
      label377:
      localObject1 = ((av)localObject2).field_username;
      break label135;
      label386:
      localObject1 = localObject2;
      label389:
      if (ai.ww(str))
      {
        ac.i("MicroMsg.ChattingUIFragment", "[protectContactNotExist] isBottleContact userName:".concat(String.valueOf(str)));
        ((ai)localObject1).GWJ = str;
        ((ai)localObject1).setUsername(str);
      }
      if (com.tencent.mm.model.w.wA(str))
      {
        localObject2 = new id();
        ((id)localObject2).ebn = 1L;
        ((id)localObject2).aHZ();
      }
      localObject2 = localObject1;
      if (com.tencent.mm.model.w.wB(str))
      {
        localObject2 = new ic();
        ((ic)localObject2).ebn = 1L;
        ((ic)localObject2).aHZ();
        localObject2 = localObject1;
      }
    }
  }
  
  public void fkm()
  {
    AppMethodBeat.i(34755);
    super.fkm();
    if (getWindow() != null) {
      getWindow().setBackgroundDrawableResource(2131100810);
    }
    boolean bool1;
    boolean bool2;
    if (getContentView() != null)
    {
      bool1 = getContentView().isShown();
      if (getView() == null) {
        break label124;
      }
      bool2 = getView().isShown();
      label57:
      if (this.HPw.getVisibility() != 0) {
        break label129;
      }
    }
    label129:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (this.cLy.cqM) {
        break label134;
      }
      ac.i("MicroMsg.ChattingUIFragment", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b listviewShow:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(34755);
      return;
      bool1 = false;
      break;
      label124:
      bool2 = false;
      break label57;
    }
    label134:
    if (!az.agM())
    {
      ac.w("MicroMsg.ChattingUIFragment", "account not ready, mabey not call onDestroy!!!");
      finish();
      AppMethodBeat.o(34755);
      return;
    }
    this.HPv.resume();
    AppMethodBeat.o(34755);
  }
  
  protected void fkn()
  {
    AppMethodBeat.i(34772);
    this.mScrollState = 0;
    this.HPz = ((MMChattingListView)findViewById(2131298103));
    this.HPz.setIsReturnSuperDispatchWhenCancel(true);
    this.HPw = this.HPz.getListView();
    this.HPw.setVisibility(0);
    ((com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).fnA();
    if (this.HPz.getBaseAdapter() == null)
    {
      this.HPv = new com.tencent.mm.ui.chatting.a.a(this.cLy, this.HPw);
      this.HPz.setAdapter(this.HPv);
    }
    Object localObject = this.HPz;
    ((MMChattingListView)localObject).wQ(false);
    ((MMChattingListView)localObject).wQ(false);
    fkK();
    this.HPG.a(com.tencent.mm.ui.chatting.g.d.a.IeT, true, null);
    this.HPw.setOverScrollMode(2);
    if (!((com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class)).foi()) {
      this.HPw.setTranscriptMode(1);
    }
    for (;;)
    {
      this.HPw.setOnTouchListener(new View.OnTouchListener()
      {
        boolean muJ = false;
        
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(196435);
          ChattingUIFragment.h(ChattingUIFragment.this);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            ac.i("MicroMsg.ChattingUIFragment", "onTouch: touch down");
            this.muJ = true;
          }
          while ((!this.muJ) || (!ChattingUIFragment.this.HPB))
          {
            AppMethodBeat.o(196435);
            return false;
            if (paramAnonymousMotionEvent.getAction() == 1)
            {
              ac.i("MicroMsg.ChattingUIFragment", "onTouch: touch up");
              this.muJ = false;
            }
          }
          paramAnonymousView = (com.tencent.mm.ui.chatting.c.b.q)ChattingUIFragment.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class);
          if ((paramAnonymousView == null) || (paramAnonymousView.fne() == null))
          {
            AppMethodBeat.o(196435);
            return false;
          }
          paramAnonymousView.fne().g(0, true, -1);
          AppMethodBeat.o(196435);
          return false;
        }
      });
      this.HPw.setOnScrollListener(new AbsListView.OnScrollListener()
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
          //   8: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:HPH	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   11: getfield 35	com/tencent/mm/ui/chatting/BaseChattingUIFragment:cLy	Lcom/tencent/mm/ui/chatting/d/a;
          //   14: getfield 41	com/tencent/mm/ui/chatting/d/a:HZD	Lcom/tencent/mm/ui/chatting/c/n;
          //   17: aload_1
          //   18: iload_2
          //   19: iload_3
          //   20: iload 4
          //   22: invokevirtual 45	com/tencent/mm/ui/chatting/c/n:onScroll	(Landroid/widget/AbsListView;III)V
          //   25: aload_0
          //   26: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:HPH	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
          //   29: invokestatic 48	com/tencent/mm/ui/chatting/ChattingUIFragment:i	(Lcom/tencent/mm/ui/chatting/ChattingUIFragment;)Z
          //   32: ifeq +36 -> 68
          //   35: aload_0
          //   36: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:HPH	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
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
          //   61: getfield 17	com/tencent/mm/ui/chatting/ChattingUIFragment$2:HPH	Lcom/tencent/mm/ui/chatting/ChattingUIFragment;
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
          AppMethodBeat.i(196430);
          ChattingUIFragment.this.cLy.HZD.onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
          ChattingUIFragment.a(ChattingUIFragment.this, paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            ac.d("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] [%s:%s]", new Object[] { Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition()), Integer.valueOf(ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition()) });
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
                  ac.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load top more!");
                  ChattingUIFragment.a(ChattingUIFragment.this).wP(true);
                }
              }
              else
              {
                ChattingUIFragment.this.HPv.eK(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
                com.tencent.mm.ui.chatting.a.a locala = ChattingUIFragment.this.HPv;
                paramAnonymousInt = ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition();
                int j = ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount();
                int i = ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition();
                if (locala.HpO == null) {
                  break label600;
                }
                paramAnonymousAbsListView = locala.HpO.AzG;
                if ((paramAnonymousAbsListView == null) || (paramAnonymousAbsListView.fad())) {
                  break label600;
                }
                localLinkedList = new LinkedList();
                paramAnonymousInt -= j;
                if (paramAnonymousInt > i) {
                  break label542;
                }
                paramAnonymousAbsListView = locala.aaS(paramAnonymousInt);
                if (paramAnonymousAbsListView != null)
                {
                  localObject = paramAnonymousAbsListView.field_content;
                  if (localObject != null)
                  {
                    paramAnonymousAbsListView = k.b.az((String)localObject, paramAnonymousAbsListView.field_reserved);
                    if ((paramAnonymousAbsListView != null) && (paramAnonymousAbsListView.type == 5) && (!TextUtils.isEmpty(paramAnonymousAbsListView.url)))
                    {
                      localObject = new com.tencent.mm.plugin.brandservice.a.d.a();
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).url = paramAnonymousAbsListView.url;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).nuJ = 1;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).appId = paramAnonymousAbsListView.appId;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).title = paramAnonymousAbsListView.title;
                      ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).desc = paramAnonymousAbsListView.description;
                      if (!locala.HpO.foQ()) {
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
              ((com.tencent.mm.plugin.brandservice.a.d.a)localObject).dsT = paramAnonymousAbsListView;
              localLinkedList.add(localObject);
              paramAnonymousInt += 1;
              break label256;
              if (paramAnonymousAbsListView.getTop() >= 0) {
                break;
              }
              ac.w("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] exception auto load top more wit reset adapter!");
              ChattingUIFragment.a(ChattingUIFragment.this).setAdapter(ChattingUIFragment.this.HPv);
              break;
              if (ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition() != ChattingUIFragment.b(ChattingUIFragment.this).getCount() - 1) {
                break;
              }
              paramAnonymousAbsListView = ChattingUIFragment.b(ChattingUIFragment.this).getChildAt(ChattingUIFragment.b(ChattingUIFragment.this).getChildCount() - 1);
              if ((paramAnonymousAbsListView == null) || (ChattingUIFragment.b(ChattingUIFragment.this).getBottom() - ChattingUIFragment.a(ChattingUIFragment.this).getBottomHeight() < paramAnonymousAbsListView.getBottom())) {
                break;
              }
              ac.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load bottom more!");
              ChattingUIFragment.a(ChattingUIFragment.this).wQ(true);
              break;
            }
            label542:
            if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class) != null) && (localLinkedList.size() > 0))
            {
              ac.v("MicroMsg.ChattingDataAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
              ((com.tencent.mm.plugin.brandservice.a.d)g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).l(localLinkedList, 2);
            }
          }
          label600:
          AppMethodBeat.o(196430);
        }
      });
      this.HPw.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(196432);
          ChattingUIFragment.this.HPv.eK(ChattingUIFragment.b(ChattingUIFragment.this).getFirstVisiblePosition() - ChattingUIFragment.b(ChattingUIFragment.this).getHeaderViewsCount(), ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition());
          ChattingUIFragment.b(ChattingUIFragment.this).removeOnLayoutChangeListener(this);
          AppMethodBeat.o(196432);
        }
      });
      if (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ys(2))
      {
        localObject = this.cLy;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).AzG;
          if ((localObject != null) && (((ai)localObject).fad())) {
            ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).yt(0);
          }
        }
      }
      registerForContextMenu(this.HPw);
      aO(false, true);
      AppMethodBeat.o(34772);
      return;
      this.HPw.setTranscriptMode(0);
    }
  }
  
  public final void flA()
  {
    AppMethodBeat.i(34725);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      aO(false, bool);
      AppMethodBeat.o(34725);
      return;
    }
  }
  
  public final void flB()
  {
    AppMethodBeat.i(34730);
    ac.i("MicroMsg.ChattingUIFragment", "[smoothScrollBy] dis:%d duration:%d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.HPw.smoothScrollBy(0, 0);
    AppMethodBeat.o(34730);
  }
  
  public final void flC()
  {
    AppMethodBeat.i(34738);
    this.HPz.setTopViewVisible(true);
    AppMethodBeat.o(34738);
  }
  
  public final void flD()
  {
    AppMethodBeat.i(34739);
    this.HPz.setIsTopShowAll(false);
    AppMethodBeat.o(34739);
  }
  
  public final void flE()
  {
    AppMethodBeat.i(34743);
    this.HPz.wP(false);
    AppMethodBeat.o(34743);
  }
  
  public final void flF()
  {
    AppMethodBeat.i(34748);
    this.HPw.setTranscriptMode(0);
    AppMethodBeat.o(34748);
  }
  
  public final void flG()
  {
    AppMethodBeat.i(34761);
    Object localObject = (com.tencent.mm.ui.chatting.c.b.ae)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.ae.class);
    if ((!((com.tencent.mm.ui.chatting.c.b.ae)localObject).foi()) && (!((com.tencent.mm.ui.chatting.c.b.ae)localObject).fok()) && (!((com.tencent.mm.ui.chatting.c.b.ae)localObject).fol()))
    {
      int i = this.HPE;
      this.HPE = (i + 1);
      if ((i < 10) && (((thisActivity() instanceof ChattingUI)) || ((thisActivity() instanceof AppBrandServiceChattingUI))))
      {
        localObject = this.HPw;
        Runnable local7 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34711);
            if ((ChattingUIFragment.c(ChattingUIFragment.this)) || (ChattingUIFragment.d(ChattingUIFragment.this) != 0))
            {
              ChattingUIFragment.e(ChattingUIFragment.this);
              ac.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect userTouched: %s state: %s", new Object[] { Boolean.valueOf(ChattingUIFragment.c(ChattingUIFragment.this)), Integer.valueOf(ChattingUIFragment.d(ChattingUIFragment.this)) });
              AppMethodBeat.o(34711);
              return;
            }
            int i = ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition();
            int j = ChattingUIFragment.b(ChattingUIFragment.this).getCount() - 1;
            ac.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", new Object[] { Integer.valueOf(ChattingUIFragment.f(ChattingUIFragment.this)), Integer.valueOf(i), Integer.valueOf(j) });
            if (i < j)
            {
              ChattingUIFragment.a(ChattingUIFragment.this, true);
              ChattingUIFragment.this.flG();
              AppMethodBeat.o(34711);
              return;
            }
            ChattingUIFragment.e(ChattingUIFragment.this);
            AppMethodBeat.o(34711);
          }
        };
        if (this.HPE == 1) {}
        for (i = 10;; i = 100)
        {
          ((ListView)localObject).postDelayed(local7, i);
          AppMethodBeat.o(34761);
          return;
        }
      }
    }
    ac.d("MicroMsg.ChattingUIFragment", "scrollToLastProtect:%s, %s ,%s", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.ae)localObject).foi()), Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.ae)localObject).fok()), Integer.valueOf(this.HPE) });
    AppMethodBeat.o(34761);
  }
  
  protected final void flH()
  {
    AppMethodBeat.i(34764);
    ((ak)this.cLy.bf(ak.class)).aI(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34714);
        ChattingUIFragment.this.onExitBegin();
        if ((ChattingUIFragment.this.isCurrentActivity) || (!ChattingUIFragment.this.isSupportNavigationSwipeBack()))
        {
          ChattingUIFragment.this.flI();
          AppMethodBeat.o(34714);
          return;
        }
        SwipeBackLayout localSwipeBackLayout = ChattingUIFragment.this.getSwipeBackLayout();
        ac.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", new Object[] { Boolean.valueOf(localSwipeBackLayout.Jcu), Boolean.valueOf(localSwipeBackLayout.Jcs), Boolean.valueOf(localSwipeBackLayout.Jct) });
        if (!localSwipeBackLayout.fuV())
        {
          com.tencent.mm.ui.widget.h.bS(0.0F);
          localSwipeBackLayout.Jcu = true;
          localSwipeBackLayout.Jct = false;
          int i = localSwipeBackLayout.mContentView.getWidth();
          int j = localSwipeBackLayout.Jcp.getIntrinsicWidth();
          com.tencent.mm.ui.mogic.a locala = localSwipeBackLayout.Jcn;
          locala.UI = localSwipeBackLayout.mContentView;
          locala.mActivePointerId = -1;
          locala.b(i + j + 10, 0, 0, 0, 260L);
          localSwipeBackLayout.invalidate();
          if (localSwipeBackLayout.JcA != null) {
            localSwipeBackLayout.JcA.onDrag();
          }
          com.tencent.mm.ui.widget.h.Y(true, 0);
        }
        AppMethodBeat.o(34714);
      }
    });
    AppMethodBeat.o(34764);
  }
  
  protected final void flI()
  {
    AppMethodBeat.i(34768);
    flJ();
    Object localObject = (com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class);
    if (ai.aMZ(this.cLy.getTalkerUserName()))
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
        if (((getIntExtra("chat_from_scene", 0) == 1) || (getIntExtra("chat_from_scene", 0) == 3)) && (this.cLy.AzG != null) && (this.cLy.AzG.fad()) && (((com.tencent.mm.ui.chatting.c.b.d)localObject).fml() != null) && (((com.tencent.mm.ui.chatting.c.b.d)localObject).fml().IO()) && (((com.tencent.mm.ui.chatting.c.b.d)localObject).fml().bV(false) != null) && (((com.tencent.mm.ui.chatting.c.b.d)localObject).fml().bV(false).Jq() != null) && (!bs.isNullOrNil(((com.tencent.mm.ui.chatting.c.b.d)localObject).fml().IV())))
        {
          finish();
          AppMethodBeat.o(34768);
          return;
        }
        if (!((y)this.cLy.bf(y.class)).fnV()) {
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingUIFragment", "goBackImpl", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    overridePendingTransition(MMFragmentActivity.a.mnE, MMFragmentActivity.a.mnF);
    finish();
    AppMethodBeat.o(34768);
  }
  
  public final int getBottomHeight()
  {
    AppMethodBeat.i(34745);
    if (this.HPz == null)
    {
      AppMethodBeat.o(34745);
      return 0;
    }
    int i = this.HPz.getBottomHeight();
    AppMethodBeat.o(34745);
    return i;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(34749);
    int i = this.HPw.getFirstVisiblePosition();
    AppMethodBeat.o(34749);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131493382;
  }
  
  public final ListView getListView()
  {
    return this.HPw;
  }
  
  public final int getTopHeight()
  {
    AppMethodBeat.i(34746);
    int i = this.HPz.getTopHeight();
    AppMethodBeat.o(34746);
    return i;
  }
  
  public boolean getUserVisibleHint()
  {
    return this.cLy.cqM;
  }
  
  public boolean hideVKB()
  {
    AppMethodBeat.i(34733);
    ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.c.b.q)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class)).fne();
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
  
  public final void jF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34732);
    com.tencent.mm.ui.chatting.d.a.foS().removeCallbacks(this.HPx);
    ac.i("MicroMsg.ChattingUIFragment", "[setSelectionFromTop] pos:%d offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    com.tencent.mm.pluginsdk.ui.tools.n.a(this.HPw, paramInt1, paramInt2, false);
    AppMethodBeat.o(34732);
  }
  
  public final void jX(Context paramContext)
  {
    AppMethodBeat.i(34753);
    super.jX(paramContext);
    ac.i("MicroMsg.ChattingUIFragment", "[doAttach]:%s#0x%x task:%s hc:%d", new Object[] { thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), bs.jb(thisActivity()), Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.aX(3, true);
    }
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
            g.agR().agA().set(ah.a.GRN, Boolean.TRUE);
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
    if ((isSupportNavigationSwipeBack()) && (this.HPv != null)) {
      this.HPB = true;
    }
    AppMethodBeat.o(34767);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    AppMethodBeat.i(34717);
    if (!this.cLy.cqM)
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
    if ((isSupportNavigationSwipeBack()) && (this.HPv != null)) {
      this.HPB = false;
    }
    AppMethodBeat.o(34766);
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(34758);
    super.onEnterBegin();
    dry();
    AppMethodBeat.o(34758);
  }
  
  public final void onExitBegin()
  {
    AppMethodBeat.i(34759);
    super.onExitBegin();
    com.tencent.mm.ui.chatting.a.a locala = this.HPv;
    locala.HRD = -1L;
    locala.HRC.clear();
    this.HPG.IgC.cancel();
    dry();
    AppMethodBeat.o(34759);
  }
  
  public final void onExitEnd()
  {
    AppMethodBeat.i(34760);
    super.onExitEnd();
    dismissDialog();
    AppMethodBeat.o(34760);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(34762);
    if (keyboardState() == 1) {
      this.HPw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34712);
          ChattingUIFragment.this.aO(true, false);
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
    ac.i("MicroMsg.ChattingUIFragment", "onMultiWindowModeChanged: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.c.b.q)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class)).fne();
    if (localChatFooter != null) {
      localChatFooter.setIsMultiWindow(paramBoolean);
    }
    AppMethodBeat.o(34775);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(34765);
    ac.w("MicroMsg.ChattingUIFragment", "onSwipeBack");
    flI();
    if (com.tencent.mm.plugin.location.model.n.cWV().cWZ())
    {
      fh localfh = new fh();
      localfh.dfa.username = com.tencent.mm.bi.d.hXZ.aJc();
      com.tencent.mm.sdk.b.a.GpY.l(localfh);
    }
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    AppMethodBeat.o(34765);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(34723);
    ((com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).setBackBtn(paramOnMenuItemClickListener);
    AppMethodBeat.o(34723);
  }
  
  public final void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(34737);
    this.HPz.setBottomViewVisible(paramBoolean);
    AppMethodBeat.o(34737);
  }
  
  public final void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(34740);
    this.HPz.setIsBottomShowAll(paramBoolean);
    AppMethodBeat.o(34740);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(34736);
    if (this.HPw != null) {
      this.HPw.setKeepScreenOn(paramBoolean);
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
    ((com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).setMMSubTitle(paramString);
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
    ((com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).setMMTitle(paramString);
    AppMethodBeat.o(34720);
  }
  
  public final void wQ(boolean paramBoolean)
  {
    AppMethodBeat.i(34741);
    this.HPz.wQ(paramBoolean);
    AppMethodBeat.o(34741);
  }
  
  public final void xg(boolean paramBoolean)
  {
    AppMethodBeat.i(34726);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      aO(paramBoolean, bool);
      AppMethodBeat.o(34726);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */