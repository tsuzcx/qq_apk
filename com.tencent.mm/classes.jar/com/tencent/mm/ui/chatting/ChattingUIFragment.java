package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.t;
import com.tencent.mm.ui.chatting.f.b.a;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.SwipeBackLayout;

@SuppressLint({"ValidFragment"})
public class ChattingUIFragment
  extends BaseChattingUIFragment
{
  public static String ywS;
  private int mScrollState = 0;
  private com.tencent.mm.ui.base.p tipDialog = null;
  private com.tencent.mm.ui.chatting.l.a.a zBA;
  public com.tencent.mm.ui.chatting.a.a zBq;
  ListView zBr;
  private Runnable zBs;
  private MMChattingListView zBt;
  private boolean zBu = true;
  protected boolean zBv = true;
  private boolean zBw = false;
  private boolean zBx = false;
  private int zBy = 0;
  private final int zBz = 10;
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment() {}
  
  @SuppressLint({"ValidFragment"})
  public ChattingUIFragment(byte paramByte)
  {
    super((byte)0);
  }
  
  private boolean dGR()
  {
    AppMethodBeat.i(30896);
    i locali = (i)this.caz.ay(i.class);
    com.tencent.mm.ui.chatting.c.b.z localz = (com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class);
    if (locali.dHW())
    {
      if (localz.dIZ())
      {
        localz.dIY();
        locali.dHX();
      }
      for (;;)
      {
        AppMethodBeat.o(30896);
        return true;
        locali.dHU();
      }
    }
    AppMethodBeat.o(30896);
    return false;
  }
  
  private void qU(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(30855);
    int m = this.zBr.getLastVisiblePosition();
    int n = this.zBr.getFirstVisiblePosition();
    int k = this.zBr.getCount();
    ab.i("MicroMsg.ChattingUIFragment", "[scrollToLastImpl] isFirstScroll:%s [%s:%s] count:%s force:%s", new Object[] { Boolean.valueOf(this.zBu), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(k), Boolean.valueOf(paramBoolean) });
    this.zBu = false;
    int i = j;
    if (paramBoolean)
    {
      i = j;
      if (m == n)
      {
        i = j;
        if (m >= k - 1)
        {
          i = j;
          if (this.zBr.getChildCount() > 0) {
            i = this.zBr.getChildAt(this.zBr.getChildCount() - 1).getHeight();
          }
        }
      }
    }
    if ((paramBoolean) && (this.zBt.bim())) {
      ab.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom");
    }
    for (;;)
    {
      this.zBr.post(new ChattingUIFragment.6(this, paramBoolean, k, i));
      AppMethodBeat.o(30855);
      return;
      k.a(this.zBr, k - 1, -i, true);
    }
  }
  
  public final void Pu(int paramInt)
  {
    AppMethodBeat.i(30858);
    com.tencent.mm.ui.chatting.d.a.dJI().removeCallbacks(this.zBs);
    ab.i("MicroMsg.ChattingUIFragment", "[setSelection] pos:%d isSmooth:%s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
    ListView localListView = this.zBr;
    if (localListView != null)
    {
      ab.i("MicroMsg.ChattingUI.ScrollController", "setSelection position %s smooth %s", new Object[] { Integer.valueOf(paramInt), Boolean.FALSE });
      localListView.setItemChecked(paramInt, true);
      localListView.setSelection(paramInt);
    }
    AppMethodBeat.o(30858);
  }
  
  public final void Pv(int paramInt)
  {
    AppMethodBeat.i(30874);
    this.zBr.setVisibility(paramInt);
    if (ab.getLogLevel() == 2) {
      ab.i("MicroMsg.ChattingUIFragment", "[setListViewVisibility] visibility:" + paramInt + " stack:" + bo.dtY().toString());
    }
    AppMethodBeat.o(30874);
  }
  
  public final void aF(Bundle paramBundle)
  {
    AppMethodBeat.i(30869);
    this.zBt.aF(paramBundle);
    AppMethodBeat.o(30869);
  }
  
  public final void aG(Bundle paramBundle)
  {
    AppMethodBeat.i(30871);
    this.zBt.a(true, paramBundle);
    AppMethodBeat.o(30871);
  }
  
  public final void aWN()
  {
    AppMethodBeat.i(30851);
    if (this.zBq == null)
    {
      AppMethodBeat.o(30851);
      return;
    }
    this.zBq.notifyDataSetChanged();
    AppMethodBeat.o(30851);
  }
  
  protected final void ab(ad paramad)
  {
    AppMethodBeat.i(30879);
    super.ab(paramad);
    ywS = paramad.field_username;
    AppMethodBeat.o(30879);
  }
  
  @Deprecated
  public final void ak(final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(30854);
    if (paramBoolean2)
    {
      com.tencent.mm.ui.chatting.d.a.dJI().removeCallbacks(this.zBs);
      ak localak = com.tencent.mm.ui.chatting.d.a.dJI();
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(30829);
          ChattingUIFragment.a(ChattingUIFragment.this, paramBoolean1);
          AppMethodBeat.o(30829);
        }
      };
      this.zBs = local1;
      localak.post(local1);
      AppMethodBeat.o(30854);
      return;
    }
    qU(paramBoolean1);
    AppMethodBeat.o(30854);
  }
  
  public final void bJ(int paramInt)
  {
    AppMethodBeat.i(30856);
    com.tencent.mm.ui.chatting.d.a.dJI().removeCallbacks(this.zBs);
    this.zBr.post(new ChattingUIFragment.7(this, paramInt));
    AppMethodBeat.o(30856);
  }
  
  public final void c(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(30861);
    dismissDialog();
    this.tipDialog = h.b(paramContext, paramString, true, paramOnCancelListener);
    AppMethodBeat.o(30861);
  }
  
  public void cdy()
  {
    AppMethodBeat.i(30900);
    aw.RO().ac(new ChattingUIFragment.5(this));
    AppMethodBeat.o(30900);
  }
  
  public void dFC()
  {
    AppMethodBeat.i(30881);
    this.zBx = false;
    this.zBu = true;
    this.zBv = true;
    ab.d("MicroMsg.ChattingUIFragment", "isFromSearch  " + getBooleanExtra("finish_direct", false));
    int i;
    String str;
    Object localObject2;
    int j;
    label126:
    Object localObject1;
    if (this.caz.txj == null)
    {
      i = 1;
      ab.i("MicroMsg.ChattingUIFragment", "[doCreate] rawUserName from :%s to :%s ", new Object[] { this.caz.getTalkerUserName(), getStringExtra("Chat_User") });
      str = getStringExtra("Chat_User");
      aw.aaz();
      localObject2 = com.tencent.mm.model.c.YA().arw(str);
      if (localObject2 != null) {
        break label357;
      }
      j = -1;
      if (localObject2 != null) {
        break label367;
      }
      localObject1 = "null";
      label135:
      ab.w("MicroMsg.ChattingUIFragment", "protectContactNotExist raw:%s contact:%d username:%s", new Object[] { str, Integer.valueOf(j), localObject1 });
      if ((localObject2 != null) && ((int)((com.tencent.mm.n.a)localObject2).euF != 0) && (!bo.isNullOrNil(((aq)localObject2).field_username))) {
        break label376;
      }
      localObject2 = new ad();
      ((ad)localObject2).setUsername(str);
      ((ad)localObject2).yMc = str;
      ((ad)localObject2).Ny();
      ((ad)localObject2).hx(3);
      aw.aaz();
      com.tencent.mm.model.c.YA().X((ad)localObject2);
      aw.aaz();
      ad localad = com.tencent.mm.model.c.YA().arw(str);
      localObject1 = localad;
      if (localad != null) {
        break label379;
      }
      ab.e("MicroMsg.ChattingUIFragment", "protectContactNotExist contact get from db is null!");
    }
    for (;;)
    {
      ab((ad)localObject2);
      ((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).GJ(this.caz.getTalkerUserName());
      super.dFC();
      if (isSupportNavigationSwipeBack())
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().init();
      }
      if (i != 0) {
        com.tencent.mm.ui.chatting.d.a.dJI().post(new ChattingUIFragment.8(this));
      }
      dFE();
      AppMethodBeat.o(30881);
      return;
      i = 0;
      break;
      label357:
      j = (int)((com.tencent.mm.n.a)localObject2).euF;
      break label126;
      label367:
      localObject1 = ((aq)localObject2).field_username;
      break label135;
      label376:
      localObject1 = localObject2;
      label379:
      localObject2 = localObject1;
      if (ad.nM(str))
      {
        ab.i("MicroMsg.ChattingUIFragment", "[protectContactNotExist] isBottleContact userName:".concat(String.valueOf(str)));
        ((ad)localObject1).yMc = str;
        ((ad)localObject1).setUsername(str);
        localObject2 = localObject1;
      }
    }
  }
  
  public void dFD()
  {
    AppMethodBeat.i(30882);
    super.dFD();
    if (getWindow() != null) {
      getWindow().setBackgroundDrawableResource(2131690402);
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
      if (this.zBr.getVisibility() != 0) {
        break label129;
      }
    }
    label129:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (this.caz.bSe) {
        break label134;
      }
      ab.i("MicroMsg.ChattingUIFragment", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b listviewShow:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(30882);
      return;
      bool1 = false;
      break;
      label124:
      bool2 = false;
      break label57;
    }
    label134:
    if (!aw.RG())
    {
      ab.w("MicroMsg.ChattingUIFragment", "account not ready, mabey not call onDestroy!!!");
      finish();
      AppMethodBeat.o(30882);
      return;
    }
    this.zBq.resume();
    AppMethodBeat.o(30882);
  }
  
  protected void dFE()
  {
    AppMethodBeat.i(30899);
    this.mScrollState = 0;
    this.zBt = ((MMChattingListView)findViewById(2131822441));
    this.zBr = this.zBt.getListView();
    this.zBr.setVisibility(0);
    ((r)this.caz.ay(r.class)).dIt();
    if (this.zBt.getBaseAdapter() == null)
    {
      this.zBq = new com.tencent.mm.ui.chatting.a.a(this.caz, this.zBr);
      this.zBt.setAdapter(this.zBq);
    }
    Object localObject = this.zBt;
    ((MMChattingListView)localObject).qE(false);
    ((MMChattingListView)localObject).qE(false);
    dGd();
    this.zBA.a(d.a.zOz, true, null);
    this.zBr.setOverScrollMode(2);
    if (!((com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class)).dJb()) {
      this.zBr.setTranscriptMode(1);
    }
    for (;;)
    {
      this.zBr.setOnTouchListener(new ChattingUIFragment.2(this));
      this.zBr.setOnScrollListener(new ChattingUIFragment.3(this));
      this.zBr.addOnLayoutChangeListener(new ChattingUIFragment.4(this));
      if (((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rU(2))
      {
        localObject = this.caz;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).txj;
          if ((localObject != null) && (((ad)localObject).dwz())) {
            ((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rV(0);
          }
        }
      }
      registerForContextMenu(this.zBr);
      ak(false, true);
      AppMethodBeat.o(30899);
      return;
      this.zBr.setTranscriptMode(0);
    }
  }
  
  public void dFF()
  {
    AppMethodBeat.i(30883);
    super.dFF();
    q.dismiss();
    ab.i("MicroMsg.ChattingUIFragment", "on chatting ui pause  rawuser:%s", new Object[] { this.caz.getTalkerUserName() });
    if (this.caz.getTalkerUserName() == null)
    {
      AppMethodBeat.o(30883);
      return;
    }
    this.zBq.pause();
    hideVKB();
    ab.d("MicroMsg.ChattingUIFragment", "chattingui cancel pause auto download logic");
    AppMethodBeat.o(30883);
  }
  
  public final void dFX()
  {
    AppMethodBeat.i(30884);
    super.dFX();
    if (this.caz.getTalkerUserName() == null)
    {
      AppMethodBeat.o(30884);
      return;
    }
    AppMethodBeat.o(30884);
  }
  
  public final void dGI()
  {
    AppMethodBeat.i(30852);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      ak(false, bool);
      AppMethodBeat.o(30852);
      return;
    }
  }
  
  public final void dGJ()
  {
    AppMethodBeat.i(30857);
    ab.i("MicroMsg.ChattingUIFragment", "[smoothScrollBy] dis:%d duration:%d", new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.zBr.smoothScrollBy(0, 0);
    AppMethodBeat.o(30857);
  }
  
  public final void dGK()
  {
    AppMethodBeat.i(30865);
    this.zBt.setTopViewVisible(true);
    AppMethodBeat.o(30865);
  }
  
  public final void dGL()
  {
    AppMethodBeat.i(30866);
    this.zBt.setIsTopShowAll(false);
    AppMethodBeat.o(30866);
  }
  
  public final void dGM()
  {
    AppMethodBeat.i(30870);
    this.zBt.qD(false);
    AppMethodBeat.o(30870);
  }
  
  public final void dGN()
  {
    AppMethodBeat.i(30875);
    this.zBr.setTranscriptMode(0);
    AppMethodBeat.o(30875);
  }
  
  public final void dGO()
  {
    AppMethodBeat.i(30888);
    Object localObject = (com.tencent.mm.ui.chatting.c.b.z)this.caz.ay(com.tencent.mm.ui.chatting.c.b.z.class);
    if ((!((com.tencent.mm.ui.chatting.c.b.z)localObject).dJb()) && (!((com.tencent.mm.ui.chatting.c.b.z)localObject).dJd()) && (!((com.tencent.mm.ui.chatting.c.b.z)localObject).dJe()))
    {
      int i = this.zBy;
      this.zBy = (i + 1);
      if ((i < 10) && (((thisActivity() instanceof ChattingUI)) || ((thisActivity() instanceof AppBrandServiceChattingUI))))
      {
        localObject = this.zBr;
        Runnable local9 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(30839);
            if ((ChattingUIFragment.c(ChattingUIFragment.this)) || (ChattingUIFragment.d(ChattingUIFragment.this) != 0))
            {
              ChattingUIFragment.e(ChattingUIFragment.this);
              ab.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect userTouched: %s state: %s", new Object[] { Boolean.valueOf(ChattingUIFragment.c(ChattingUIFragment.this)), Integer.valueOf(ChattingUIFragment.d(ChattingUIFragment.this)) });
              AppMethodBeat.o(30839);
              return;
            }
            int i = ChattingUIFragment.b(ChattingUIFragment.this).getLastVisiblePosition();
            int j = ChattingUIFragment.b(ChattingUIFragment.this).getCount() - 1;
            ab.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", new Object[] { Integer.valueOf(ChattingUIFragment.f(ChattingUIFragment.this)), Integer.valueOf(i), Integer.valueOf(j) });
            if (i < j)
            {
              ChattingUIFragment.a(ChattingUIFragment.this, true);
              ChattingUIFragment.this.dGO();
              AppMethodBeat.o(30839);
              return;
            }
            ChattingUIFragment.e(ChattingUIFragment.this);
            AppMethodBeat.o(30839);
          }
        };
        if (this.zBy == 1) {}
        for (i = 10;; i = 100)
        {
          ((ListView)localObject).postDelayed(local9, i);
          AppMethodBeat.o(30888);
          return;
        }
      }
    }
    ab.d("MicroMsg.ChattingUIFragment", "scrollToLastProtect:%s, %s ,%s", new Object[] { Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.z)localObject).dJb()), Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.z)localObject).dJd()), Integer.valueOf(this.zBy) });
    AppMethodBeat.o(30888);
  }
  
  protected final void dGP()
  {
    AppMethodBeat.i(30891);
    ((af)this.caz.ay(af.class)).aw(new ChattingUIFragment.12(this));
    AppMethodBeat.o(30891);
  }
  
  protected final void dGQ()
  {
    AppMethodBeat.i(30895);
    dGR();
    Object localObject = (com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class);
    if (ad.arc(this.caz.getTalkerUserName()))
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      com.tencent.mm.bq.d.b(getContext(), "tmessage", ".ui.TConversationUI", (Intent)localObject);
    }
    do
    {
      for (;;)
      {
        finish();
        AppMethodBeat.o(30895);
        return;
        if (getIntExtra("chat_from_scene", 0) == 4)
        {
          finish();
          AppMethodBeat.o(30895);
          return;
        }
        if (((getIntExtra("chat_from_scene", 0) == 1) || (getIntExtra("chat_from_scene", 0) == 3)) && (this.caz.txj != null) && (this.caz.txj.dwz()) && (((com.tencent.mm.ui.chatting.c.b.d)localObject).dHs() != null) && (((com.tencent.mm.ui.chatting.c.b.d)localObject).dHs().aeh()) && (((com.tencent.mm.ui.chatting.c.b.d)localObject).dHs().cU(false) != null) && (((com.tencent.mm.ui.chatting.c.b.d)localObject).dHs().cU(false).aeI() != null) && (!bo.isNullOrNil(((com.tencent.mm.ui.chatting.c.b.d)localObject).dHs().aeo())))
        {
          finish();
          AppMethodBeat.o(30895);
          return;
        }
        if (!((t)this.caz.ay(t.class)).dIO()) {
          break;
        }
        finish();
      }
    } while (getBooleanExtra("finish_direct", false).booleanValue());
    if (!this.isCurrentActivity)
    {
      finish();
      AppMethodBeat.o(30895);
      return;
    }
    localObject = new Intent(getContext(), LauncherUI.class);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    overridePendingTransition(MMFragmentActivity.a.zbZ, MMFragmentActivity.a.zca);
    finish();
    AppMethodBeat.o(30895);
  }
  
  public final s dGa()
  {
    AppMethodBeat.i(30877);
    if (this.caz.ay(r.class) == null)
    {
      AppMethodBeat.o(30877);
      return null;
    }
    s locals = ((r)this.caz.ay(r.class)).dGa();
    AppMethodBeat.o(30877);
    return locals;
  }
  
  public final boolean dGb()
  {
    AppMethodBeat.i(30890);
    if (!isScreenEnable())
    {
      ab.w("MicroMsg.ChattingUIFragment", "Actionbar customView onclick screen not enable");
      AppMethodBeat.o(30890);
      return true;
    }
    hideVKB();
    if (getActivity() != null)
    {
      View localView = getActivity().findViewById(2131820633);
      if (localView == null) {
        break label82;
      }
      localView.setVisibility(0);
      localView.post(new ChattingUIFragment.11(this));
    }
    for (;;)
    {
      AppMethodBeat.o(30890);
      return true;
      label82:
      dGP();
    }
  }
  
  public final com.tencent.mm.ui.chatting.l.a.a dGc()
  {
    return this.zBA;
  }
  
  public final void dGd()
  {
    AppMethodBeat.i(30898);
    if ((this.zBt == null) || (this.zBq == null))
    {
      AppMethodBeat.o(30898);
      return;
    }
    Object localObject1 = this.caz;
    Object localObject2 = new com.tencent.mm.ui.chatting.f.a(this.zBq.zDn);
    com.tencent.mm.ui.chatting.f.b localb = new com.tencent.mm.ui.chatting.f.b(this.caz, this.zBt);
    localObject2 = new com.tencent.mm.ui.chatting.f.e(localb, (com.tencent.mm.ui.chatting.f.c)localObject2);
    if (((com.tencent.mm.ui.chatting.c.b.d)((com.tencent.mm.ui.chatting.d.a)localObject1).ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv()) {
      localObject1 = new com.tencent.mm.ui.chatting.l.a.b((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.f.e)localObject2);
    }
    for (;;)
    {
      localb.zOv = ((b.a)localObject1);
      ab.i("MicroMsg.ChattingLoader.ChattingDataPresenterFactory", "[ChattingDataPresenterFactory] executor:%s", new Object[] { ((com.tencent.mm.ui.chatting.l.a.a)localObject1).toString() });
      this.zBA = ((com.tencent.mm.ui.chatting.l.a.a)localObject1);
      this.zBq.zDx = this.zBA;
      this.zBt.setLoadExecutor(this.zBA);
      AppMethodBeat.o(30898);
      return;
      if (((com.tencent.mm.ui.chatting.c.b.p)((com.tencent.mm.ui.chatting.d.a)localObject1).ay(com.tencent.mm.ui.chatting.c.b.p.class)).dIr()) {
        localObject1 = new com.tencent.mm.ui.chatting.l.a.c((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.f.d)localObject2);
      } else if ((((com.tencent.mm.ui.chatting.c.b.z)((com.tencent.mm.ui.chatting.d.a)localObject1).ay(com.tencent.mm.ui.chatting.c.b.z.class)).dJd()) || (((com.tencent.mm.ui.chatting.c.b.z)((com.tencent.mm.ui.chatting.d.a)localObject1).ay(com.tencent.mm.ui.chatting.c.b.z.class)).dJe()) || (((com.tencent.mm.ui.chatting.c.b.z)((com.tencent.mm.ui.chatting.d.a)localObject1).ay(com.tencent.mm.ui.chatting.c.b.z.class)).dJb())) {
        localObject1 = new com.tencent.mm.ui.chatting.l.a.e((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.f.d)localObject2);
      } else {
        localObject1 = new com.tencent.mm.ui.chatting.l.a.d((com.tencent.mm.ui.chatting.d.a)localObject1, (com.tencent.mm.ui.chatting.f.e)localObject2);
      }
    }
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(30845);
    super.dealContentView(paramView);
    ((r)this.caz.ay(r.class)).eS(paramView);
    AppMethodBeat.o(30845);
  }
  
  public final void dismissDialog()
  {
    AppMethodBeat.i(30862);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(30862);
  }
  
  public void finish()
  {
    AppMethodBeat.i(30897);
    Object localObject = (com.tencent.mm.ui.chatting.c.b.o)this.caz.ay(com.tencent.mm.ui.chatting.c.b.o.class);
    if ((localObject != null) && (((com.tencent.mm.ui.chatting.c.b.o)localObject).dIg() != null)) {
      ((com.tencent.mm.ui.chatting.c.b.o)localObject).dIg().aB(0, true);
    }
    if (!hideVKB()) {}
    for (int i = 0;; i = 100)
    {
      localObject = new ChattingUIFragment.13(this);
      if (i == 0)
      {
        ((Runnable)localObject).run();
        AppMethodBeat.o(30897);
        return;
      }
      al.p((Runnable)localObject, 100L);
      AppMethodBeat.o(30897);
      return;
    }
  }
  
  public final int getBottomHeight()
  {
    AppMethodBeat.i(30872);
    if (this.zBt == null)
    {
      AppMethodBeat.o(30872);
      return 0;
    }
    int i = this.zBt.getBottomHeight();
    AppMethodBeat.o(30872);
    return i;
  }
  
  public final int getFirstVisiblePosition()
  {
    AppMethodBeat.i(30876);
    int i = this.zBr.getFirstVisiblePosition();
    AppMethodBeat.o(30876);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2130969028;
  }
  
  public final ListView getListView()
  {
    return this.zBr;
  }
  
  public final int getTopHeight()
  {
    AppMethodBeat.i(30873);
    int i = this.zBt.getTopHeight();
    AppMethodBeat.o(30873);
    return i;
  }
  
  public boolean getUserVisibleHint()
  {
    return this.caz.bSe;
  }
  
  public final void hF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30859);
    com.tencent.mm.ui.chatting.d.a.dJI().removeCallbacks(this.zBs);
    ab.i("MicroMsg.ChattingUIFragment", "[setSelectionFromTop] pos:%d offset:%s isSmooth:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.FALSE });
    k.a(this.zBr, paramInt1, paramInt2, false);
    AppMethodBeat.o(30859);
  }
  
  public boolean hideVKB()
  {
    AppMethodBeat.i(30860);
    ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.c.b.o)this.caz.ay(com.tencent.mm.ui.chatting.c.b.o.class)).dIg();
    if (localChatFooter != null)
    {
      bool = localChatFooter.hideVKB();
      AppMethodBeat.o(30860);
      return bool;
    }
    boolean bool = super.hideVKB();
    AppMethodBeat.o(30860);
    return bool;
  }
  
  public final void ik(Context paramContext)
  {
    AppMethodBeat.i(30880);
    super.ik(paramContext);
    ab.i("MicroMsg.ChattingUIFragment", "[doAttach]:%s#0x%x task:%s hc:%d", new Object[] { thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), bo.hm(thisActivity()), Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.aF(3, true);
    }
    AppMethodBeat.o(30880);
  }
  
  public boolean isSupportCustomActionBar()
  {
    AppMethodBeat.i(30878);
    boolean bool = isSupportNavigationSwipeBack();
    AppMethodBeat.o(30878);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(30901);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 30763) || (paramInt1 == 30762))
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(30901);
        return;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getBundleExtra("result_data");
          if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
          {
            g.RL().Ru().set(ac.a.yKH, Boolean.TRUE);
            if (paramInt1 == 30763)
            {
              com.tencent.mm.pluginsdk.permission.b.a(getActivity(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 67);
              AppMethodBeat.o(30901);
              return;
            }
            com.tencent.mm.pluginsdk.permission.b.a(getActivity(), new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, 68);
          }
        }
      }
    }
    AppMethodBeat.o(30901);
  }
  
  public void onCancelDrag()
  {
    AppMethodBeat.i(30894);
    if ((isSupportNavigationSwipeBack()) && (this.zBq != null)) {
      this.zBv = true;
    }
    AppMethodBeat.o(30894);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    AppMethodBeat.i(30844);
    if (!this.caz.bSe)
    {
      AppMethodBeat.o(30844);
      return;
    }
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    AppMethodBeat.o(30844);
  }
  
  public void onDragBegin()
  {
    AppMethodBeat.i(30893);
    if ((isSupportNavigationSwipeBack()) && (this.zBq != null)) {
      this.zBv = false;
    }
    AppMethodBeat.o(30893);
  }
  
  public void onEnterBegin()
  {
    AppMethodBeat.i(30885);
    super.onEnterBegin();
    cdy();
    AppMethodBeat.o(30885);
  }
  
  public final void onExitBegin()
  {
    AppMethodBeat.i(30886);
    super.onExitBegin();
    com.tencent.mm.ui.chatting.a.a locala = this.zBq;
    locala.zDq = -1L;
    locala.zDp.clear();
    this.zBA.zQi.cancel();
    cdy();
    AppMethodBeat.o(30886);
  }
  
  public final void onExitEnd()
  {
    AppMethodBeat.i(30887);
    super.onExitEnd();
    dismissDialog();
    AppMethodBeat.o(30887);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(30889);
    if (keyboardState() == 1) {
      this.zBr.post(new ChattingUIFragment.10(this));
    }
    AppMethodBeat.o(30889);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(155490);
    super.onMultiWindowModeChanged(paramBoolean);
    ab.i("MicroMsg.ChattingUIFragment", "onMultiWindowModeChanged: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.c.b.o)this.caz.ay(com.tencent.mm.ui.chatting.c.b.o.class)).dIg();
    if (localChatFooter != null) {
      localChatFooter.setIsMultiWindow(paramBoolean);
    }
    AppMethodBeat.o(155490);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(30892);
    ab.w("MicroMsg.ChattingUIFragment", "onSwipeBack");
    dGQ();
    if (l.bLr().bLv())
    {
      fa localfa = new fa();
      localfa.csJ.username = com.tencent.mm.bh.d.fUP.alg();
      com.tencent.mm.sdk.b.a.ymk.l(localfa);
    }
    if (isSupportNavigationSwipeBack()) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    AppMethodBeat.o(30892);
  }
  
  public final void qE(boolean paramBoolean)
  {
    AppMethodBeat.i(30868);
    this.zBt.qE(paramBoolean);
    AppMethodBeat.o(30868);
  }
  
  public final void qT(boolean paramBoolean)
  {
    AppMethodBeat.i(30853);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      ak(paramBoolean, bool);
      AppMethodBeat.o(30853);
      return;
    }
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    AppMethodBeat.i(30850);
    ((r)this.caz.ay(r.class)).setBackBtn(paramOnMenuItemClickListener);
    AppMethodBeat.o(30850);
  }
  
  public final void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(30864);
    this.zBt.setBottomViewVisible(paramBoolean);
    AppMethodBeat.o(30864);
  }
  
  public final void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(30867);
    this.zBt.setIsBottomShowAll(paramBoolean);
    AppMethodBeat.o(30867);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(30863);
    if (this.zBr != null) {
      this.zBr.setKeepScreenOn(paramBoolean);
    }
    AppMethodBeat.o(30863);
  }
  
  public void setMMSubTitle(int paramInt)
  {
    AppMethodBeat.i(30849);
    setMMSubTitle(getMMString(paramInt));
    AppMethodBeat.o(30849);
  }
  
  public void setMMSubTitle(String paramString)
  {
    AppMethodBeat.i(30848);
    ((r)this.caz.ay(r.class)).setMMSubTitle(paramString);
    AppMethodBeat.o(30848);
  }
  
  public void setMMTitle(int paramInt)
  {
    AppMethodBeat.i(30846);
    setMMTitle(getMMString(paramInt));
    AppMethodBeat.o(30846);
  }
  
  public void setMMTitle(String paramString)
  {
    AppMethodBeat.i(30847);
    ((r)this.caz.ay(r.class)).setMMTitle(paramString);
    AppMethodBeat.o(30847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */