package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ws;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.z;
import d.g.b.p;
import d.k;
import java.util.Arrays;

@com.tencent.mm.ui.base.a(19)
@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/ui/RadarSearchUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "()V", "REQUEST_CODE_GDPR_LOCATION_USE_SCENE", "", "mRadarViewController", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "getMRadarViewController", "()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "mRadarViewController$delegate", "Lkotlin/Lazy;", "shouldCheckPermission", "", "getSystemService", "", "name", "", "hideTalkRoomeStatusBar", "", "isHide", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onResumeAfterMPermissionGranted", "radarUsagePlusOne", "Companion", "plugin-radar_release"})
public final class RadarSearchUI
  extends MMBaseActivity
{
  private static final String TAG = "MicroMsg.RadarSearchUI";
  public static final RadarSearchUI.a xzU;
  private boolean jit;
  private final d.f xzS;
  private final int xzT;
  
  static
  {
    AppMethodBeat.i(138637);
    xzU = new RadarSearchUI.a((byte)0);
    TAG = "MicroMsg.RadarSearchUI";
    AppMethodBeat.o(138637);
  }
  
  public RadarSearchUI()
  {
    AppMethodBeat.i(138649);
    p.h(this, "$this$bind");
    d.g.a.a locala = (d.g.a.a)new i.a(this);
    this.xzS = d.g.a(k.Nhf, locala);
    this.jit = true;
    this.xzT = 30764;
    AppMethodBeat.o(138649);
  }
  
  private final RadarViewController dGD()
  {
    AppMethodBeat.i(138638);
    RadarViewController localRadarViewController = (RadarViewController)this.xzS.getValue();
    AppMethodBeat.o(138638);
    return localRadarViewController;
  }
  
  private final void dGE()
  {
    AppMethodBeat.i(138641);
    pL(true);
    com.tencent.mm.plugin.radar.b.d locald = com.tencent.mm.plugin.radar.b.d.xyG;
    com.tencent.mm.plugin.radar.b.d.dGs();
    locald = com.tencent.mm.plugin.radar.b.d.xyG;
    com.tencent.mm.plugin.radar.b.d.dGt();
    if ((dGD().getRadarStatus() == e.e.xzc) || (dGD().getRadarStatus() == e.e.xzd))
    {
      dGD().onResume();
      dGD().dGv();
      dGD().getWaveView().dGP();
    }
    AppMethodBeat.o(138641);
  }
  
  private static void pL(boolean paramBoolean)
  {
    AppMethodBeat.i(138647);
    ws localws = new ws();
    localws.dMk.dMl = paramBoolean;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localws);
    AppMethodBeat.o(138647);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(138648);
    p.h(paramString, "name");
    Object localObject = super.getSystemService(paramString);
    if ((localObject != null) && (p.i("layout_inflater", paramString)))
    {
      paramString = z.b((LayoutInflater)localObject);
      AppMethodBeat.o(138648);
      return paramString;
    }
    AppMethodBeat.o(138648);
    return localObject;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(138645);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.xzT)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYR, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 64);
          this.jit = false;
          AppMethodBeat.o(138645);
          return;
        }
        this.jit = true;
        finish();
        AppMethodBeat.o(138645);
        return;
      }
      this.jit = true;
      finish();
    }
    AppMethodBeat.o(138645);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(138639);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    requestWindowFeature(1);
    setContentView(2131495172);
    paramBundle = dGD();
    Object localObject1 = paramBundle.findViewById(2131303682);
    p.g(localObject1, "findViewById(R.id.radar_main_layer)");
    localObject1 = (RelativeLayout)localObject1;
    Object localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      paramBundle = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Object localObject3 = paramBundle.getContext();
    if (localObject3 == null)
    {
      paramBundle = new d.v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    localObject3 = ((Activity)localObject3).getWindowManager();
    p.g(localObject3, "(context as Activity).windowManager");
    ((WindowManager)localObject3).getDefaultDisplay().getMetrics(localDisplayMetrics);
    ((RelativeLayout.LayoutParams)localObject2).width = localDisplayMetrics.widthPixels;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = paramBundle.getRadarTips();
    ((RadarTipsView)localObject1).getNoviceEducationTips().setOnClickListener((View.OnClickListener)new RadarTipsView.c((RadarTipsView)localObject1));
    localObject1 = paramBundle.getRadarTips();
    ((RadarTipsView)localObject1).xAO = RadarTipsView.xAR;
    localObject2 = d.xzR;
    int i = d.dGC();
    ((RadarTipsView)localObject1).xAG.sendEmptyMessageDelayed(((RadarTipsView)localObject1).xAD, i);
    ((RadarTipsView)localObject1).xAG.sendEmptyMessageDelayed(((RadarTipsView)localObject1).xAC, i + 8000);
    paramBundle.getRadarTips().setPressingDown(true);
    paramBundle.getQuitBtn().setOnClickListener(paramBundle.xBl);
    localObject1 = paramBundle.getQuitBtn().getLayoutParams();
    if (localObject1 == null)
    {
      paramBundle = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    int j = ((RelativeLayout.LayoutParams)localObject1).topMargin;
    i = j;
    if (al.aH(paramBundle.getContext())) {
      i = j + al.aG(paramBundle.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, i, ((RelativeLayout.LayoutParams)localObject1).rightMargin, ((RelativeLayout.LayoutParams)localObject1).bottomMargin);
    paramBundle.getQuitBtn().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = paramBundle.getWaveView();
    ((RadarWaveView)localObject1).xBM = ((RadarWaveView)localObject1).findViewById(2131303696);
    ((RadarWaveView)localObject1).xBN = AnimationUtils.loadAnimation(((RadarWaveView)localObject1).getContext(), 2130772118);
    localObject1 = ((RadarWaveView)localObject1).xBN;
    if (localObject1 == null) {
      p.gkB();
    }
    ((Animation)localObject1).setInterpolator((Interpolator)new LinearInterpolator());
    localObject1 = b.a.xzt;
    localObject1 = paramBundle.findViewById(2131304559);
    p.g(localObject1, "findViewById(R.id.self_round_avatar)");
    localObject1 = (ImageView)localObject1;
    localObject2 = com.tencent.mm.model.v.aAC();
    p.g(localObject2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    b.a.c((ImageView)localObject1, (String)localObject2);
    paramBundle.getMemberDetailView().setListener((RadarMemberView.b)new RadarViewController.e(paramBundle));
    localObject1 = paramBundle.getGrid();
    localObject2 = paramBundle.getContext();
    p.g(localObject2, "context");
    paramBundle.xBi = new RadarViewController.c(paramBundle, (RadarSpecialGridView)localObject1, (Context)localObject2);
    paramBundle.getGrid().setOnItemClickListener((RadarSpecialGridView.a)new RadarViewController.h(paramBundle));
    paramBundle = dGD();
    localObject1 = paramBundle.xBh;
    localObject2 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject2, "service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).azF().a((n.b)localObject1);
    com.tencent.mm.sdk.b.a.IvT.c((com.tencent.mm.sdk.b.c)((com.tencent.mm.plugin.radar.b.c)localObject1).xye);
    localObject2 = com.tencent.mm.kernel.g.ad(s.class);
    p.g(localObject2, "plugin(IPluginMessengerFoundation::class.java)");
    ((s)localObject2).getSysCmdMsgExtension().a("addcontact", (cf.a)((com.tencent.mm.plugin.radar.b.c)localObject1).xyf, true);
    paramBundle = paramBundle.xBg;
    if (paramBundle == null) {
      p.bdF("radarManager");
    }
    com.tencent.mm.kernel.g.ajj().a(425, (com.tencent.mm.ak.f)paramBundle);
    com.tencent.mm.kernel.g.ajj().a(602, (com.tencent.mm.ak.f)paramBundle);
    paramBundle = com.tencent.mm.kernel.g.ajR().ajA().get(229377, Integer.valueOf(0));
    if (paramBundle == null)
    {
      paramBundle = new d.v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    i = ((Integer)paramBundle).intValue();
    com.tencent.mm.kernel.g.ajR().ajA().set(229377, Integer.valueOf(i + 1));
    AppMethodBeat.o(138639);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(138644);
    localObject1 = dGD();
    Object localObject2 = ((RadarViewController)localObject1).xBh;
    Object localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject3, "service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject3).azF().b((n.b)localObject2);
    com.tencent.mm.sdk.b.a.IvT.d((com.tencent.mm.sdk.b.c)((com.tencent.mm.plugin.radar.b.c)localObject2).xye);
    localObject3 = com.tencent.mm.kernel.g.ad(s.class);
    p.g(localObject3, "plugin(IPluginMessengerFoundation::class.java)");
    ((s)localObject3).getSysCmdMsgExtension().b("addcontact", (cf.a)((com.tencent.mm.plugin.radar.b.c)localObject2).xyf, true);
    localObject2 = ((RadarViewController)localObject1).xBg;
    if (localObject2 == null) {
      p.bdF("radarManager");
    }
    com.tencent.mm.kernel.g.ajj().b(425, (com.tencent.mm.ak.f)localObject2);
    com.tencent.mm.kernel.g.ajj().b(602, (com.tencent.mm.ak.f)localObject2);
    ((com.tencent.mm.plugin.radar.b.e)localObject2).stop();
    localObject3 = ((com.tencent.mm.plugin.radar.b.e)localObject2).hTg;
    if (localObject3 != null) {
      ((com.tencent.mm.modelgeo.d)localObject3).c(((com.tencent.mm.plugin.radar.b.e)localObject2).fHp);
    }
    localObject1 = ((RadarViewController)localObject1).getWaveView();
    try
    {
      localObject2 = ((RadarWaveView)localObject1).xBL;
      if (localObject2 != null)
      {
        ((MediaPlayer)localObject2).stop();
        ((MediaPlayer)localObject2).release();
      }
      ((RadarWaveView)localObject1).xBL = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace(RadarWaveView.TAG, (Throwable)localException, "", new Object[0]);
        ae.e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
        ((RadarWaveView)localObject1).xBL = null;
      }
    }
    super.onDestroy();
    AppMethodBeat.o(138644);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(138646);
    p.h(paramKeyEvent, "event");
    boolean bool = dGD().onKeyDown(paramInt, paramKeyEvent);
    if (bool)
    {
      AppMethodBeat.o(138646);
      return bool;
    }
    bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(138646);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(138643);
    super.onPause();
    pL(false);
    Object localObject1 = com.tencent.mm.plugin.radar.b.d.xyG;
    long l1;
    if (com.tencent.mm.plugin.radar.b.d.xyC != 0L)
    {
      l1 = com.tencent.mm.plugin.radar.b.d.dGu() - com.tencent.mm.plugin.radar.b.d.xyC;
      localObject1 = d.xzR;
      if (d.yY(l1)) {
        break label446;
      }
    }
    label446:
    for (int i = 1;; i = 0)
    {
      Object localObject2;
      if (i != 0)
      {
        i = com.tencent.mm.plugin.radar.b.d.dAb;
        ae.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFriendsCnt %d", new Object[] { Integer.valueOf(i) });
        localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
        localObject2 = d.g.b.ad.Njc;
        localObject2 = String.format("%d", Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.g)localObject1).kvStat(10679, (String)localObject2);
        com.tencent.mm.plugin.radar.b.d.xyz += 1;
        com.tencent.mm.plugin.radar.b.d.xyA = l1 + com.tencent.mm.plugin.radar.b.d.xyA;
        com.tencent.mm.plugin.radar.b.d.xyC = 0L;
      }
      localObject1 = com.tencent.mm.plugin.radar.b.d.xyG;
      if (com.tencent.mm.plugin.radar.b.d.xyB != 0L)
      {
        l1 = System.currentTimeMillis();
        long l2 = com.tencent.mm.plugin.radar.b.d.xyB;
        i = com.tencent.mm.plugin.radar.b.d.xyz;
        float f1 = (float)com.tencent.mm.plugin.radar.b.d.xyA * 1.0F / 1000.0F;
        int j = com.tencent.mm.plugin.radar.b.d.xyD;
        float f2 = (float)(l1 - l2) * 1.0F / 1000.0F;
        ae.d(com.tencent.mm.plugin.radar.b.d.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) });
        localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
        localObject2 = d.g.b.ad.Njc;
        localObject2 = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) }, 5));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.g)localObject1).kvStat(10676, (String)localObject2);
      }
      if ((dGD().getRadarStatus() == e.e.xzc) || (dGD().getRadarStatus() == e.e.xzd))
      {
        localObject1 = dGD().xBg;
        if (localObject1 == null) {
          p.bdF("radarManager");
        }
        ((com.tencent.mm.plugin.radar.b.e)localObject1).dGw();
        localObject1 = dGD().xBg;
        if (localObject1 == null) {
          p.bdF("radarManager");
        }
        localObject2 = ((com.tencent.mm.plugin.radar.b.e)localObject1).hTg;
        if (localObject2 != null) {
          ((com.tencent.mm.modelgeo.d)localObject2).c(((com.tencent.mm.plugin.radar.b.e)localObject1).fHp);
        }
        dGD().getWaveView().dGQ();
      }
      AppMethodBeat.o(138643);
      return;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(138642);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length <= 0)
    {
      paramArrayOfString = TAG;
      paramArrayOfInt = Thread.currentThread();
      p.g(paramArrayOfInt, "Thread.currentThread()");
      ae.i(paramArrayOfString, "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfInt.getId()) });
      AppMethodBeat.o(138642);
      return;
    }
    paramArrayOfString = TAG;
    int i = paramArrayOfInt[0];
    Thread localThread = Thread.currentThread();
    p.g(localThread, "Thread.currentThread()");
    ae.i(paramArrayOfString, "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(localThread.getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138642);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        dGE();
        AppMethodBeat.o(138642);
        return;
      }
      this.jit = false;
      h.a((Context)this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131761861), false, (DialogInterface.OnClickListener)new RadarSearchUI.b(this), (DialogInterface.OnClickListener)new RadarSearchUI.c(this));
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138640);
    super.onResume();
    if (this.jit)
    {
      Object localObject1 = com.tencent.mm.kernel.g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject2 = ((com.tencent.mm.kernel.e)localObject1).ajA().get(274436);
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = null;
      }
      if (com.tencent.mm.aw.b.Gw((String)localObject1))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.n((Context)this, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          localObject1 = com.tencent.mm.kernel.g.ajR();
          p.g(localObject1, "MMKernel.storage()");
          localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajA().get(am.a.IYR, Boolean.FALSE);
          if (localObject1 == null)
          {
            localObject1 = new d.v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(138640);
            throw ((Throwable)localObject1);
          }
          if (!((Boolean)localObject1).booleanValue())
          {
            com.tencent.mm.plugin.account.a.b.a.b((Context)this, getString(2131760740, new Object[] { com.tencent.mm.sdk.platformtools.ad.fom() }), this.xzT, true);
            AppMethodBeat.o(138640);
            return;
          }
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 64);
          AppMethodBeat.o(138640);
        }
      }
      else
      {
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
        ae.i(TAG, "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(138640);
          return;
        }
      }
      dGE();
    }
    AppMethodBeat.o(138640);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSearchUI
 * JD-Core Version:    0.7.0.1
 */