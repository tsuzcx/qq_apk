package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.a;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.rb;
import com.tencent.mm.h.a.ro;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.AbstractTabChildActivity.a;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.s;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class k
  extends AbstractTabChildActivity.a
  implements j.a
{
  public Context mContext;
  private int[] pam = new int[2];
  private h vPG;
  private a vTi = new a();
  public ConversationWithAppBrandListView vTt;
  private TextView vTu;
  private j vTv = new j();
  private d vTw = new d();
  private n vTx = new n();
  private l vTy = new l();
  private k.a vTz;
  
  public final void A(long paramLong, int paramInt)
  {
    if (this.vTt != null) {
      this.vTt.A(paramLong, paramInt);
    }
  }
  
  public final void cHo()
  {
    if (this.vPG != null) {
      this.vPG.cHo();
    }
  }
  
  public final void cIo()
  {
    if (this.vPG != null) {
      this.vPG.lGE = true;
    }
  }
  
  public final void cIp()
  {
    if (this.vPG != null)
    {
      this.vPG.lGE = false;
      this.vPG.cIf();
      if (thisActivity() != null) {
        this.vTw.ad(getActivity());
      }
    }
  }
  
  public final void cIq()
  {
    if (this.vPG != null) {
      this.vPG.onResume();
    }
  }
  
  public final void cIr()
  {
    if (this.vPG != null) {
      this.vPG.onPause();
    }
  }
  
  protected final void cxD()
  {
    y.i("MicroMsg.MainUI", "onTabCreate, %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.mController != null) {
      this.mController.ap(4, false);
    }
    y.i("MicroMsg.MainUI", "mainUIOnCreate");
    long l = System.currentTimeMillis();
    setMenuVisibility(true);
    au.DS().cre();
    y.i("MicroMsg.MainUI", "main ui init view");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.vTt != null)
    {
      localObject1 = this.vTi;
      if (((a)localObject1).vPc != null)
      {
        ((a)localObject1).ep(((a)localObject1).vOV);
        ((a)localObject1).ep(((a)localObject1).vOW);
        ((a)localObject1).ep(((a)localObject1).vOX);
        ((a)localObject1).ep(((a)localObject1).vOY);
        localObject2 = ((a)localObject1).vOZ.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView() != null)) {
            ((a)localObject1).vPc.removeFooterView(((com.tencent.mm.pluginsdk.ui.b.b)localObject3).getView());
          }
        }
      }
    }
    this.vTu = ((TextView)findViewById(R.h.empty_conversation_tv));
    this.vTt = ((ConversationWithAppBrandListView)findViewById(R.h.main_chatting_lv));
    this.vTt.setDrawingCacheEnabled(false);
    this.vTt.setScrollingCacheEnabled(false);
    this.vPG = new h(getContext(), new k.3(this));
    this.vPG.setGetViewPositionCallback(new k.4(this));
    this.vPG.setPerformItemClickListener(new k.5(this));
    if (com.tencent.mm.compatible.util.d.gH(18))
    {
      com.tencent.mm.blink.b.vG().k(new k.6(this));
      localObject1 = this.vTy;
      localObject2 = this.vTt;
      localObject3 = this.vPG;
      ((l)localObject1).vPc = ((ListView)localObject2);
      ((l)localObject1).vPG = ((h)localObject3);
      ((ListView)localObject2).setOnScrollListener(((l)localObject1).dnR);
      ((h)localObject3).vPR = ((l)localObject1).dnR;
      ai.d(new l.2((l)localObject1));
      this.vTw.ad(getActivity());
      this.vTt.setAdapter(this.vPG);
      this.vTt.setContext(this.mContext);
      this.vTt.setOnItemClickListener(new f(this.vPG, this.vTt, getActivity()));
      this.vTt.setOnItemLongClickListener(new g(this.vPG, this.vTt, getActivity(), this.pam));
      this.vTt.setOnTouchListener(new k.7(this));
      if (this.vTz != null) {
        i(this.vTz.bHj, this.vTz.vTC, this.vTz.vTD);
      }
      this.vTt.setSelection(0);
      localObject1 = this.vTv;
      localObject2 = getActivity();
      localObject3 = this.vTi;
      ((j)localObject1).bMV = ((Activity)localObject2);
      ((j)localObject1).vTi = ((a)localObject3);
      ((j)localObject1).vTj = this;
      ((j)localObject1).wakeLock = ((PowerManager)((Activity)localObject2).getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
      au.Dk().a(-1, (com.tencent.mm.ah.f)localObject1);
      ((j)localObject1).vTf = false;
      com.tencent.mm.sdk.b.a.udP.c(((j)localObject1).vTk);
      com.tencent.mm.sdk.b.a.udP.c(((j)localObject1).vTl);
      localObject2 = new File(ae.getContext().getFilesDir(), "DBRecoverStarted");
      if (((File)localObject2).exists())
      {
        com.tencent.mm.plugin.report.f.nEG.d("DBRepair", "Last recovery interrupted.", null);
        ((File)localObject2).delete();
      }
      ((j)localObject1).vTm = new FLock(new File(ae.getContext().getFilesDir(), "MMStarted"));
      if (!((j)localObject1).vTm.cqt()) {
        break label1243;
      }
      ((j)localObject1).vTm.unlock();
      y.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
    }
    for (;;)
    {
      ((j)localObject1).vTm.lockRead();
      localObject1 = this.vTw;
      localObject2 = this.vPG;
      localObject3 = this.vTt;
      FragmentActivity localFragmentActivity = getActivity();
      ((d)localObject1).vPG = ((h)localObject2);
      ((d)localObject1).vPc = ((ListView)localObject3);
      ((d)localObject1).activity = localFragmentActivity;
      com.tencent.mm.sdk.b.a.udP.c(((d)localObject1).vPJ);
      com.tencent.mm.sdk.b.a.udP.c(((d)localObject1).vPH);
      com.tencent.mm.sdk.b.a.udP.c(((d)localObject1).vPI);
      localObject1 = this.vTx;
      localObject2 = this.vPG;
      localObject3 = this.vTt;
      localFragmentActivity = getActivity();
      ((n)localObject1).vPG = ((h)localObject2);
      ((n)localObject1).bMV = localFragmentActivity;
      ((n)localObject1).vTt = ((ConversationWithAppBrandListView)localObject3);
      if (((n)localObject1).iWp == null) {
        ((n)localObject1).iWp = new n.3((n)localObject1, new n.1((n)localObject1));
      }
      if (((n)localObject1).vTT == null) {
        ((n)localObject1).vTT = new n.4((n)localObject1);
      }
      if (((n)localObject1).vTU == null) {
        ((n)localObject1).vTU = new n.5((n)localObject1, (ConversationWithAppBrandListView)localObject3);
      }
      com.tencent.mm.sdk.b.a.udP.c(((n)localObject1).iWp);
      com.tencent.mm.sdk.b.a.udP.c(((n)localObject1).vTT);
      com.tencent.mm.sdk.b.a.udP.c(((n)localObject1).vTU);
      ((n)localObject1).uKq = new n.6((n)localObject1);
      Looper.myQueue().addIdleHandler(((n)localObject1).uKq);
      ((ConversationWithAppBrandListView)localObject3).post(new n.7((n)localObject1));
      localObject1 = com.tencent.mm.as.o.OL();
      int i = R.g.chat_img_template;
      y.d("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + ((com.tencent.mm.as.b)localObject1).emN + " to " + i);
      ((com.tencent.mm.as.b)localObject1).emN = i;
      com.tencent.mm.as.o.OL().start();
      au.Hs();
      au.Hx();
      com.tencent.mm.model.c.FB().a(this.vPG);
      au.Hx();
      com.tencent.mm.model.c.Fw().a(this.vPG);
      localObject1 = this.vPG;
      if (((h)localObject1).vPX == null) {
        ((h)localObject1).vPX = new h.2((h)localObject1);
      }
      com.tencent.mm.sdk.b.a.udP.c(((h)localObject1).vPX);
      this.vPG.vSg = new k.1(this);
      l = ah.co(l);
      au.Hx();
      y.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.model.c.CK()), Integer.valueOf(com.tencent.mm.protocal.d.spa) });
      this.vTt.postDelayed(new k.8(this), 200L);
      return;
      this.vTi.a(getContext(), this.vTt, this.vTu);
      break;
      label1243:
      y.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
      com.tencent.mm.plugin.report.f.nEG.a(579L, 0L, 1L, true);
    }
  }
  
  protected final void cxE()
  {
    y.i("MicroMsg.MainUI", "onTabResume");
    long l = ah.UY();
    Object localObject = this.vTw;
    if (((d)localObject).vPF < 0)
    {
      y.d("MicroMsg.ConvUnreadHelper", "onTabResume totalUnReadCount %d", new Object[] { Integer.valueOf(((d)localObject).vPF) });
      if (((d)localObject).vPG != null) {
        ((d)localObject).vPG.cIf();
      }
    }
    cIq();
    com.tencent.mm.blink.b.vG().k(new k.9(this));
    y.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", new Object[] { Long.valueOf(ah.co(l)) });
    localObject = this.vTx;
    if (com.tencent.mm.bf.g.eEV != null) {
      com.tencent.mm.bf.g.eEV.a((com.tencent.mm.bf.a)localObject);
    }
    ai.d(new n.8((n)localObject));
    m.gW(((n)localObject).bMV);
    if ((((n)localObject).bMV != null) && (((n)localObject).bMV.getIntent() != null) && (((n)localObject).bMV.getIntent().getBooleanExtra("resend_fail_messages", false)))
    {
      ai.l(new n.9((n)localObject), 500L);
      ((n)localObject).bMV.getIntent().putExtra("resend_fail_messages", false);
    }
    LauncherUI localLauncherUI = (LauncherUI)((n)localObject).bMV;
    if (localLauncherUI != null) {
      localLauncherUI.uKP.setTitleBarDoubleClickListener(((n)localObject).vJr);
    }
    if ((t.a(((n)localObject).bMV.getIntent(), "Main_ListToTop", false)) && (((n)localObject).vTt != null)) {
      ((n)localObject).vTt.post(new n.2((n)localObject));
    }
    t.b(((n)localObject).bMV.getIntent(), "Main_ListToTop", false);
    localObject = this.vTv;
    int i;
    if (((j)localObject).dnm == null) {
      i = -1;
    }
    for (;;)
    {
      y.i("MicroMsg.InitHelper", "onTabResume tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((j)localObject).cIm()) });
      ((j)localObject).cIk();
      ai.l(new j.6((j)localObject), 100L);
      if ((au.DK()) && (!this.vTv.cIn()))
      {
        com.tencent.mm.sdk.b.a.udP.a(new ro(), Looper.getMainLooper());
        localObject = new rb();
        ((rb)localObject).cap.action = 4;
        com.tencent.mm.sdk.b.a.udP.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
      }
      return;
      if (((j)localObject).dnm.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  protected final void cxF()
  {
    y.i("MicroMsg.MainUI", "onTabStart");
  }
  
  protected final void cxG()
  {
    y.i("MicroMsg.MainUI", "onTabPause");
    com.tencent.mm.blink.b.vG().k(new Runnable()
    {
      public final void run()
      {
        a locala = k.c(k.this);
        y.i("MicroMsg.BannerHelper", "releaseBanner");
        a.er(locala.vOV);
        a.er(locala.vOW);
        a.er(locala.vOX);
        a.er(locala.vOY);
        Iterator localIterator = locala.vOZ.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)localIterator.next();
          if (localb != null) {
            localb.release();
          }
        }
        if (au.DK()) {
          com.tencent.mm.ag.o.JQ().e(locala);
        }
        if (au.DK())
        {
          au.Hx();
          com.tencent.mm.model.c.Dz().b(locala);
        }
      }
    });
    Object localObject = this.vTv;
    if (((j)localObject).wakeLock.isHeld())
    {
      y.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
      ((j)localObject).wakeLock.release();
    }
    hideVKB();
    localObject = this.vTx;
    if (com.tencent.mm.bf.g.eEV != null) {
      com.tencent.mm.bf.g.eEV.b((com.tencent.mm.bf.a)localObject);
    }
    m.cIt();
    LauncherUI localLauncherUI = (LauncherUI)((n)localObject).bMV;
    if (localLauncherUI != null) {
      localLauncherUI.uKP.ah(((n)localObject).vJr);
    }
    cIr();
  }
  
  protected final void cxH()
  {
    y.i("MicroMsg.MainUI", "onTabStop");
  }
  
  protected final void cxI()
  {
    y.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", new Object[] { Boolean.valueOf(au.DK()) });
    com.tencent.mm.blink.b.vG().k(new k.2(this));
    Object localObject = this.vTv;
    ((j)localObject).vTm.unlock();
    au.Dk().b(-1, (com.tencent.mm.ah.f)localObject);
    if (((j)localObject).dnm != null)
    {
      ((j)localObject).dnm.dismiss();
      ((j)localObject).dnm = null;
    }
    com.tencent.mm.sdk.b.a.udP.d(((j)localObject).vTk);
    com.tencent.mm.sdk.b.a.udP.d(((j)localObject).vTl);
    localObject = this.vTx;
    if (((n)localObject).iWp != null)
    {
      com.tencent.mm.sdk.b.a.udP.d(((n)localObject).iWp);
      ((n)localObject).iWp = null;
    }
    com.tencent.mm.sdk.b.a.udP.d(((n)localObject).vTT);
    com.tencent.mm.sdk.b.a.udP.d(((n)localObject).vTU);
    if (com.tencent.mm.bf.g.eEV != null) {
      com.tencent.mm.bf.g.eEV.b((com.tencent.mm.bf.a)localObject);
    }
    if (au.DK()) {
      ah.Va();
    }
    localObject = this.vTw;
    com.tencent.mm.sdk.b.a.udP.d(((d)localObject).vPJ);
    com.tencent.mm.sdk.b.a.udP.d(((d)localObject).vPH);
    com.tencent.mm.sdk.b.a.udP.d(((d)localObject).vPI);
    ((d)localObject).activity = null;
    if ((au.DK()) && (this.vPG != null))
    {
      au.Hx();
      com.tencent.mm.model.c.FB().b(this.vPG);
      au.Hx();
      com.tencent.mm.model.c.Fw().b(this.vPG);
    }
    if (this.vPG != null)
    {
      localObject = this.vPG;
      if (((h)localObject).vPX != null)
      {
        com.tencent.mm.sdk.b.a.udP.d(((h)localObject).vPX);
        ((h)localObject).vPX = null;
      }
      this.vPG.vSg = null;
      localObject = this.vPG;
      ((h)localObject).vSg = null;
      if (((h)localObject).veF != null)
      {
        ((h)localObject).veF.clear();
        ((h)localObject).veF = null;
      }
      ((com.tencent.mm.ui.f)localObject).mK(true);
      ((h)localObject).cxZ();
      ((h)localObject).vSj.clear();
      y.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    }
  }
  
  public final void cxJ() {}
  
  public final void cxK()
  {
    y.i("MicroMsg.MainUI", "turn to bg");
  }
  
  public final void cxL()
  {
    y.i("MicroMsg.MainUI", "turn to fg");
  }
  
  public final void cyy()
  {
    y.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
    j localj = this.vTv;
    int i;
    if (localj.dnm == null) {
      i = -1;
    }
    for (;;)
    {
      y.i("MicroMsg.InitHelper", "onTabSwitchIn tip:%d initscene:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localj.cIm()) });
      if (localj.wakeLock != null) {
        localj.cIk();
      }
      if (this.mController != null) {
        this.mController.onResume();
      }
      return;
      if (localj.dnm.isShowing()) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public final void cyz()
  {
    y.i("MicroMsg.MainUI", "onTabSwitchOut");
    A(0L, 8);
  }
  
  protected int getLayoutId()
  {
    return R.i.main;
  }
  
  protected View getLayoutView()
  {
    return com.tencent.mm.kiss.a.b.ED().a(getContext(), "R.layout.main", R.i.main);
  }
  
  public final void i(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.vTt instanceof ConversationWithAppBrandListView))
    {
      ConversationWithAppBrandListView localConversationWithAppBrandListView = this.vTt;
      if (!localConversationWithAppBrandListView.nG(false))
      {
        y.w("MicroMsg.ConversationWithAppBrandListView", "[showAppBrandHeader] AppBrandHeader is disable! ");
        return;
      }
      y.i("MicroMsg.ConversationWithAppBrandListView", "[showAppBrandHeader] isShow:%s isScrollFirst:%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3) });
      localConversationWithAppBrandListView.nC(true);
      if ((localConversationWithAppBrandListView.vRk != null) && (!paramBoolean1)) {
        localConversationWithAppBrandListView.vRk.setVisibility(8);
      }
      for (;;)
      {
        localConversationWithAppBrandListView.post(new ConversationWithAppBrandListView.7(localConversationWithAppBrandListView, paramBoolean2));
        return;
        if ((localConversationWithAppBrandListView.vRk != null) && (localConversationWithAppBrandListView.vRl != null) && (localConversationWithAppBrandListView.vRl.getAdapter().getItemCount() > 1))
        {
          localConversationWithAppBrandListView.vRk.setVisibility(0);
          if (paramBoolean3) {
            localConversationWithAppBrandListView.vRl.smoothScrollToPosition(0);
          }
        }
      }
    }
    this.vTz = new k.a(this, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.vTi.cHT();
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.MainUI", "onDestroy");
    this.vTy.cIs();
    if (this.vTt != null)
    {
      ConversationWithAppBrandListView localConversationWithAppBrandListView = this.vTt;
      if (localConversationWithAppBrandListView.vRA != null) {
        localConversationWithAppBrandListView.removeCallbacks(localConversationWithAppBrandListView.vRA);
      }
      if (localConversationWithAppBrandListView.vRl != null) {
        localConversationWithAppBrandListView.vRl.release();
      }
      if (localConversationWithAppBrandListView.vRr != null) {
        localConversationWithAppBrandListView.vRr.onDestroy();
      }
      localConversationWithAppBrandListView.vRE.dead();
      localConversationWithAppBrandListView.vRB.dead();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      if (this.vTt != null)
      {
        ConversationWithAppBrandListView localConversationWithAppBrandListView = this.vTt;
        if ((localConversationWithAppBrandListView.vRN) && (localConversationWithAppBrandListView.getFirstVisiblePosition() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          this.vTt.A(10L, 11);
          return true;
        }
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    y.i("MicroMsg.MainUI", "onPause");
    super.onPause();
    if (this.vTt != null)
    {
      ConversationWithAppBrandListView localConversationWithAppBrandListView = this.vTt;
      y.i("MicroMsg.ConversationWithAppBrandListView", "[onPause]");
      localConversationWithAppBrandListView.bNW = true;
      if (localConversationWithAppBrandListView.vRj != null) {
        localConversationWithAppBrandListView.vRj.onPause();
      }
    }
  }
  
  public void onResume()
  {
    int i = 0;
    y.i("MicroMsg.MainUI", "onResume");
    super.onResume();
    ConversationWithAppBrandListView localConversationWithAppBrandListView;
    if (this.vTt != null)
    {
      localConversationWithAppBrandListView = this.vTt;
      y.i("MicroMsg.ConversationWithAppBrandListView", "[onResume]");
      localConversationWithAppBrandListView.bNW = false;
      if (localConversationWithAppBrandListView.vRl != null) {
        localConversationWithAppBrandListView.vRl.setLayoutFrozen(false);
      }
      if (localConversationWithAppBrandListView.vRj != null) {
        localConversationWithAppBrandListView.vRj.onResume();
      }
      if (localConversationWithAppBrandListView.getAdapter() != null) {
        break label103;
      }
    }
    for (;;)
    {
      if (localConversationWithAppBrandListView.HQ(i) > 0.0F) {
        localConversationWithAppBrandListView.postDelayed(new ConversationWithAppBrandListView.17(localConversationWithAppBrandListView), 300L);
      }
      return;
      label103:
      i = localConversationWithAppBrandListView.getAdapter().getCount();
    }
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k
 * JD-Core Version:    0.7.0.1
 */