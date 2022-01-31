package com.tencent.mm.plugin.radar.ui;

import a.f.b.t;
import a.f.b.y;
import a.l;
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
import com.tencent.mm.g.a.tn;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.w;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarSearchUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "()V", "REQUEST_CODE_GDPR_LOCATION_USE_SCENE", "", "mRadarViewController", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "getMRadarViewController", "()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "mRadarViewController$delegate", "Lkotlin/Lazy;", "shouldCheckPermission", "", "getSystemService", "", "name", "", "hideTalkRoomeStatusBar", "", "isHide", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onResumeAfterMPermissionGranted", "radarUsagePlusOne", "Companion", "plugin-radar_release"})
@com.tencent.mm.ui.base.a(19)
public final class RadarSearchUI
  extends MMBaseActivity
{
  private static final String TAG = "MicroMsg.RadarSearchUI";
  public static final RadarSearchUI.a pRD;
  private boolean gzb;
  private final a.f pRB;
  private final int pRC;
  
  static
  {
    AppMethodBeat.i(102991);
    eOJ = new a.j.k[] { (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(RadarSearchUI.class), "mRadarViewController", "getMRadarViewController()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;")) };
    pRD = new RadarSearchUI.a((byte)0);
    TAG = "MicroMsg.RadarSearchUI";
    AppMethodBeat.o(102991);
  }
  
  public RadarSearchUI()
  {
    AppMethodBeat.i(103003);
    a.f.b.j.q(this, "receiver$0");
    a.f.a.a locala = (a.f.a.a)new i.a(this);
    this.pRB = a.g.a(a.k.BLV, locala);
    this.gzb = true;
    this.pRC = 30764;
    AppMethodBeat.o(103003);
  }
  
  private final RadarViewController ceU()
  {
    AppMethodBeat.i(102992);
    RadarViewController localRadarViewController = (RadarViewController)this.pRB.getValue();
    AppMethodBeat.o(102992);
    return localRadarViewController;
  }
  
  private final void ceV()
  {
    AppMethodBeat.i(102995);
    kp(true);
    com.tencent.mm.plugin.radar.b.d locald = com.tencent.mm.plugin.radar.b.d.pQo;
    com.tencent.mm.plugin.radar.b.d.ceJ();
    locald = com.tencent.mm.plugin.radar.b.d.pQo;
    com.tencent.mm.plugin.radar.b.d.ceK();
    if ((ceU().getRadarStatus() == e.e.pQK) || (ceU().getRadarStatus() == e.e.pQL))
    {
      ceU().onResume();
      ceU().ceM();
      ceU().getWaveView().cfg();
    }
    AppMethodBeat.o(102995);
  }
  
  private static void kp(boolean paramBoolean)
  {
    AppMethodBeat.i(103001);
    tn localtn = new tn();
    localtn.cKb.cKc = paramBoolean;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localtn);
    AppMethodBeat.o(103001);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(103002);
    a.f.b.j.q(paramString, "name");
    Object localObject = super.getSystemService(paramString);
    if ((localObject != null) && (a.f.b.j.e("layout_inflater", paramString)))
    {
      paramString = w.b((LayoutInflater)localObject);
      AppMethodBeat.o(103002);
      return paramString;
    }
    AppMethodBeat.o(103002);
    return localObject;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(102999);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.pRC)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKH, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 64);
          this.gzb = false;
          AppMethodBeat.o(102999);
          return;
        }
        this.gzb = true;
        finish();
        AppMethodBeat.o(102999);
        return;
      }
      this.gzb = true;
      finish();
    }
    AppMethodBeat.o(102999);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102993);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    requestWindowFeature(1);
    setContentView(2130970499);
    paramBundle = ceU();
    Object localObject1 = paramBundle.findViewById(2131827001);
    a.f.b.j.p(localObject1, "findViewById(R.id.radar_main_layer)");
    localObject1 = (RelativeLayout)localObject1;
    Object localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      paramBundle = new a.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(102993);
      throw paramBundle;
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Object localObject3 = paramBundle.getContext();
    if (localObject3 == null)
    {
      paramBundle = new a.v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(102993);
      throw paramBundle;
    }
    localObject3 = ((Activity)localObject3).getWindowManager();
    a.f.b.j.p(localObject3, "(context as Activity).windowManager");
    ((WindowManager)localObject3).getDefaultDisplay().getMetrics(localDisplayMetrics);
    ((RelativeLayout.LayoutParams)localObject2).width = localDisplayMetrics.widthPixels;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = paramBundle.getRadarTips();
    ((RadarTipsView)localObject1).getNoviceEducationTips().setOnClickListener((View.OnClickListener)new RadarTipsView.c((RadarTipsView)localObject1));
    localObject1 = paramBundle.getRadarTips();
    ((RadarTipsView)localObject1).pSy = RadarTipsView.pSB;
    localObject2 = d.pRA;
    int i = d.ceT();
    ((RadarTipsView)localObject1).pSq.sendEmptyMessageDelayed(((RadarTipsView)localObject1).pSn, i);
    ((RadarTipsView)localObject1).pSq.sendEmptyMessageDelayed(((RadarTipsView)localObject1).pSm, i + 8000);
    paramBundle.getRadarTips().setPressingDown(true);
    paramBundle.getQuitBtn().setOnClickListener(paramBundle.pSV);
    localObject1 = paramBundle.getQuitBtn().getLayoutParams();
    if (localObject1 == null)
    {
      paramBundle = new a.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(102993);
      throw paramBundle;
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    int j = ((RelativeLayout.LayoutParams)localObject1).topMargin;
    i = j;
    if (af.hW(paramBundle.getContext())) {
      i = j + af.hV(paramBundle.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, i, ((RelativeLayout.LayoutParams)localObject1).rightMargin, ((RelativeLayout.LayoutParams)localObject1).bottomMargin);
    paramBundle.getQuitBtn().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = paramBundle.getWaveView();
    ((RadarWaveView)localObject1).pTx = ((RadarWaveView)localObject1).findViewById(2131827000);
    ((RadarWaveView)localObject1).pTy = AnimationUtils.loadAnimation(((RadarWaveView)localObject1).getContext(), 2131034240);
    localObject1 = ((RadarWaveView)localObject1).pTy;
    if (localObject1 == null) {
      a.f.b.j.ebi();
    }
    ((Animation)localObject1).setInterpolator((Interpolator)new LinearInterpolator());
    localObject1 = b.a.pRb;
    localObject1 = paramBundle.findViewById(2131827005);
    a.f.b.j.p(localObject1, "findViewById(R.id.self_round_avatar)");
    localObject1 = (ImageView)localObject1;
    localObject2 = r.Zn();
    a.f.b.j.p(localObject2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    b.a.c((ImageView)localObject1, (String)localObject2);
    paramBundle.getMemberDetailView().setListener((RadarMemberView.b)new RadarViewController.e(paramBundle));
    localObject1 = paramBundle.getGrid();
    localObject2 = paramBundle.getContext();
    a.f.b.j.p(localObject2, "context");
    paramBundle.pSS = new RadarViewController.c(paramBundle, (RadarSpecialGridView)localObject1, (Context)localObject2);
    paramBundle.getGrid().setOnItemClickListener((RadarSpecialGridView.a)new RadarViewController.h(paramBundle));
    paramBundle = ceU();
    localObject1 = paramBundle.pSR;
    localObject2 = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(localObject2, "service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject2).YA().a((n.b)localObject1);
    com.tencent.mm.sdk.b.a.ymk.c((com.tencent.mm.sdk.b.c)((com.tencent.mm.plugin.radar.b.c)localObject1).pPM);
    localObject2 = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class);
    a.f.b.j.p(localObject2, "plugin(IPluginMessengerFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.p)localObject2).getSysCmdMsgExtension().a("addcontact", (bz.a)((com.tencent.mm.plugin.radar.b.c)localObject1).pPN, true);
    paramBundle = paramBundle.pSQ;
    if (paramBundle == null) {
      a.f.b.j.ays("radarManager");
    }
    com.tencent.mm.kernel.g.Rc().a(425, (com.tencent.mm.ai.f)paramBundle);
    com.tencent.mm.kernel.g.Rc().a(602, (com.tencent.mm.ai.f)paramBundle);
    paramBundle = com.tencent.mm.kernel.g.RL().Ru().get(229377, Integer.valueOf(0));
    if (paramBundle == null)
    {
      paramBundle = new a.v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(102993);
      throw paramBundle;
    }
    i = ((Integer)paramBundle).intValue();
    com.tencent.mm.kernel.g.RL().Ru().set(229377, Integer.valueOf(i + 1));
    AppMethodBeat.o(102993);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(102998);
    localObject1 = ceU();
    Object localObject2 = ((RadarViewController)localObject1).pSR;
    Object localObject3 = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(localObject3, "service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject3).YA().b((n.b)localObject2);
    com.tencent.mm.sdk.b.a.ymk.d((com.tencent.mm.sdk.b.c)((com.tencent.mm.plugin.radar.b.c)localObject2).pPM);
    localObject3 = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class);
    a.f.b.j.p(localObject3, "plugin(IPluginMessengerFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.p)localObject3).getSysCmdMsgExtension().b("addcontact", (bz.a)((com.tencent.mm.plugin.radar.b.c)localObject2).pPN, true);
    localObject2 = ((RadarViewController)localObject1).pSQ;
    if (localObject2 == null) {
      a.f.b.j.ays("radarManager");
    }
    com.tencent.mm.kernel.g.Rc().b(425, (com.tencent.mm.ai.f)localObject2);
    com.tencent.mm.kernel.g.Rc().b(602, (com.tencent.mm.ai.f)localObject2);
    ((com.tencent.mm.plugin.radar.b.e)localObject2).stop();
    localObject3 = ((com.tencent.mm.plugin.radar.b.e)localObject2).fwu;
    if (localObject3 != null) {
      ((com.tencent.mm.modelgeo.d)localObject3).c(((com.tencent.mm.plugin.radar.b.e)localObject2).dZA);
    }
    localObject1 = ((RadarViewController)localObject1).getWaveView();
    try
    {
      localObject2 = ((RadarWaveView)localObject1).pTw;
      if (localObject2 != null)
      {
        ((MediaPlayer)localObject2).stop();
        ((MediaPlayer)localObject2).release();
      }
      ((RadarWaveView)localObject1).pTw = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace(RadarWaveView.TAG, (Throwable)localException, "", new Object[0]);
        ab.e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
        ((RadarWaveView)localObject1).pTw = null;
      }
    }
    super.onDestroy();
    AppMethodBeat.o(102998);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(103000);
    a.f.b.j.q(paramKeyEvent, "event");
    boolean bool = ceU().onKeyDown(paramInt, paramKeyEvent);
    if (bool)
    {
      AppMethodBeat.o(103000);
      return bool;
    }
    bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(103000);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(102997);
    super.onPause();
    kp(false);
    Object localObject1 = com.tencent.mm.plugin.radar.b.d.pQo;
    long l1;
    if (com.tencent.mm.plugin.radar.b.d.pQk != 0L)
    {
      l1 = com.tencent.mm.plugin.radar.b.d.ceL() - com.tencent.mm.plugin.radar.b.d.pQk;
      localObject1 = d.pRA;
      if (d.kU(l1)) {
        break label446;
      }
    }
    label446:
    for (int i = 1;; i = 0)
    {
      Object localObject2;
      if (i != 0)
      {
        i = com.tencent.mm.plugin.radar.b.d.czr;
        ab.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFriendsCnt %d", new Object[] { Integer.valueOf(i) });
        localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
        localObject2 = y.BNt;
        localObject2 = String.format("%d", Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
        a.f.b.j.p(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.h)localObject1).kvStat(10679, (String)localObject2);
        com.tencent.mm.plugin.radar.b.d.pQh += 1;
        com.tencent.mm.plugin.radar.b.d.pQi = l1 + com.tencent.mm.plugin.radar.b.d.pQi;
        com.tencent.mm.plugin.radar.b.d.pQk = 0L;
      }
      localObject1 = com.tencent.mm.plugin.radar.b.d.pQo;
      if (com.tencent.mm.plugin.radar.b.d.pQj != 0L)
      {
        l1 = System.currentTimeMillis();
        long l2 = com.tencent.mm.plugin.radar.b.d.pQj;
        i = com.tencent.mm.plugin.radar.b.d.pQh;
        float f1 = (float)com.tencent.mm.plugin.radar.b.d.pQi * 1.0F / 1000.0F;
        int j = com.tencent.mm.plugin.radar.b.d.pQl;
        float f2 = (float)(l1 - l2) * 1.0F / 1000.0F;
        ab.d(com.tencent.mm.plugin.radar.b.d.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) });
        localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
        localObject2 = y.BNt;
        localObject2 = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) }, 5));
        a.f.b.j.p(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.h)localObject1).kvStat(10676, (String)localObject2);
      }
      if ((ceU().getRadarStatus() == e.e.pQK) || (ceU().getRadarStatus() == e.e.pQL))
      {
        localObject1 = ceU().pSQ;
        if (localObject1 == null) {
          a.f.b.j.ays("radarManager");
        }
        ((com.tencent.mm.plugin.radar.b.e)localObject1).ceN();
        localObject1 = ceU().pSQ;
        if (localObject1 == null) {
          a.f.b.j.ays("radarManager");
        }
        localObject2 = ((com.tencent.mm.plugin.radar.b.e)localObject1).fwu;
        if (localObject2 != null) {
          ((com.tencent.mm.modelgeo.d)localObject2).c(((com.tencent.mm.plugin.radar.b.e)localObject1).dZA);
        }
        ceU().getWaveView().cfh();
      }
      AppMethodBeat.o(102997);
      return;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(102996);
    a.f.b.j.q(paramArrayOfString, "permissions");
    a.f.b.j.q(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length <= 0)
    {
      paramArrayOfString = TAG;
      paramArrayOfInt = Thread.currentThread();
      a.f.b.j.p(paramArrayOfInt, "Thread.currentThread()");
      ab.i(paramArrayOfString, "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfInt.getId()) });
      AppMethodBeat.o(102996);
      return;
    }
    paramArrayOfString = TAG;
    int i = paramArrayOfInt[0];
    Thread localThread = Thread.currentThread();
    a.f.b.j.p(localThread, "Thread.currentThread()");
    ab.i(paramArrayOfString, "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(localThread.getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(102996);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ceV();
        AppMethodBeat.o(102996);
        return;
      }
      this.gzb = false;
      com.tencent.mm.ui.base.h.a((Context)this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131302068), false, (DialogInterface.OnClickListener)new RadarSearchUI.b(this), (DialogInterface.OnClickListener)new RadarSearchUI.c(this));
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(102994);
    super.onResume();
    if (this.gzb)
    {
      Object localObject1 = com.tencent.mm.kernel.g.RL();
      a.f.b.j.p(localObject1, "MMKernel.storage()");
      Object localObject2 = ((com.tencent.mm.kernel.e)localObject1).Ru().get(274436);
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = null;
      }
      if (com.tencent.mm.au.b.tM((String)localObject1))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.o((Context)this, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          localObject1 = com.tencent.mm.kernel.g.RL();
          a.f.b.j.p(localObject1, "MMKernel.storage()");
          localObject1 = ((com.tencent.mm.kernel.e)localObject1).Ru().get(ac.a.yKH, Boolean.FALSE);
          if (localObject1 == null)
          {
            localObject1 = new a.v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(102994);
            throw ((Throwable)localObject1);
          }
          if (!((Boolean)localObject1).booleanValue())
          {
            com.tencent.mm.plugin.account.a.b.a.b((Context)this, getString(2131306183, new Object[] { aa.dsG() }), this.pRC, true);
            AppMethodBeat.o(102994);
            return;
          }
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 64);
          AppMethodBeat.o(102994);
        }
      }
      else
      {
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
        ab.i(TAG, "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(102994);
          return;
        }
      }
      ceV();
    }
    AppMethodBeat.o(102994);
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