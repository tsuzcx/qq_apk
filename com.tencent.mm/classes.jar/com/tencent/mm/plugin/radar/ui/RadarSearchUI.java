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
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.xs;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.aa;
import java.util.Arrays;
import kotlin.f;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.k;

@com.tencent.mm.ui.base.a(19)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarSearchUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "()V", "REQUEST_CODE_GDPR_LOCATION_USE_SCENE", "", "mRadarViewController", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "getMRadarViewController", "()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "mRadarViewController$delegate", "Lkotlin/Lazy;", "shouldCheckPermission", "", "getSystemService", "", "name", "", "hideTalkRoomeStatusBar", "", "isHide", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onResumeAfterMPermissionGranted", "radarUsagePlusOne", "Companion", "plugin-radar_release"})
public final class RadarSearchUI
  extends MMBaseActivity
{
  public static final RadarSearchUI.a BzV;
  private static final String TAG = "MicroMsg.RadarSearchUI";
  private final f BzT;
  private final int BzU;
  private boolean kgv;
  
  static
  {
    AppMethodBeat.i(138637);
    BzV = new RadarSearchUI.a((byte)0);
    TAG = "MicroMsg.RadarSearchUI";
    AppMethodBeat.o(138637);
  }
  
  public RadarSearchUI()
  {
    AppMethodBeat.i(138649);
    p.h(this, "$this$bind");
    kotlin.g.a.a locala = (kotlin.g.a.a)new i.a(this);
    this.BzT = kotlin.g.a(k.SWR, locala);
    this.kgv = true;
    this.BzU = 30764;
    AppMethodBeat.o(138649);
  }
  
  private final RadarViewController eHr()
  {
    AppMethodBeat.i(138638);
    RadarViewController localRadarViewController = (RadarViewController)this.BzT.getValue();
    AppMethodBeat.o(138638);
    return localRadarViewController;
  }
  
  private final void eHs()
  {
    AppMethodBeat.i(138641);
    sW(true);
    com.tencent.mm.plugin.radar.b.d locald = com.tencent.mm.plugin.radar.b.d.ByH;
    com.tencent.mm.plugin.radar.b.d.eHg();
    locald = com.tencent.mm.plugin.radar.b.d.ByH;
    com.tencent.mm.plugin.radar.b.d.eHh();
    if ((eHr().getRadarStatus() == e.e.Bzd) || (eHr().getRadarStatus() == e.e.Bze))
    {
      eHr().onResume();
      eHr().eHj();
      eHr().getWaveView().eHD();
    }
    AppMethodBeat.o(138641);
  }
  
  private static void sW(boolean paramBoolean)
  {
    AppMethodBeat.i(138647);
    xs localxs = new xs();
    localxs.edZ.eea = paramBoolean;
    EventCenter.instance.publish((IEvent)localxs);
    AppMethodBeat.o(138647);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(138648);
    p.h(paramString, "name");
    Object localObject = super.getSystemService(paramString);
    if ((localObject != null) && (p.j("layout_inflater", paramString)))
    {
      paramString = aa.b((LayoutInflater)localObject);
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
    if (paramInt1 == this.BzU)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oho, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this, "android.permission.ACCESS_FINE_LOCATION", 64);
          this.kgv = false;
          AppMethodBeat.o(138645);
          return;
        }
        this.kgv = true;
        finish();
        AppMethodBeat.o(138645);
        return;
      }
      this.kgv = true;
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
    setContentView(2131496015);
    paramBundle = eHr();
    Object localObject1 = paramBundle.findViewById(2131306461);
    p.g(localObject1, "findViewById(R.id.radar_main_layer)");
    localObject1 = (RelativeLayout)localObject1;
    Object localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Object localObject3 = paramBundle.getContext();
    if (localObject3 == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
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
    ((RadarTipsView)localObject1).BAP = RadarTipsView.BAS;
    localObject2 = d.BzS;
    int i = d.eHq();
    ((RadarTipsView)localObject1).BAH.sendEmptyMessageDelayed(((RadarTipsView)localObject1).BAE, i);
    ((RadarTipsView)localObject1).BAH.sendEmptyMessageDelayed(((RadarTipsView)localObject1).BAD, i + 8000);
    paramBundle.getRadarTips().setPressingDown(true);
    paramBundle.getQuitBtn().setOnClickListener(paramBundle.BBm);
    localObject1 = paramBundle.getQuitBtn().getLayoutParams();
    if (localObject1 == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    int j = ((RelativeLayout.LayoutParams)localObject1).topMargin;
    i = j;
    if (com.tencent.mm.ui.ao.aQ(paramBundle.getContext())) {
      i = j + com.tencent.mm.ui.ao.aP(paramBundle.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, i, ((RelativeLayout.LayoutParams)localObject1).rightMargin, ((RelativeLayout.LayoutParams)localObject1).bottomMargin);
    paramBundle.getQuitBtn().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = paramBundle.getWaveView();
    ((RadarWaveView)localObject1).BBM = ((RadarWaveView)localObject1).findViewById(2131306475);
    ((RadarWaveView)localObject1).BBN = AnimationUtils.loadAnimation(((RadarWaveView)localObject1).getContext(), 2130772142);
    localObject1 = ((RadarWaveView)localObject1).BBN;
    if (localObject1 == null) {
      p.hyc();
    }
    ((Animation)localObject1).setInterpolator((Interpolator)new LinearInterpolator());
    localObject1 = b.a.Bzu;
    localObject1 = paramBundle.findViewById(2131307597);
    p.g(localObject1, "findViewById(R.id.self_round_avatar)");
    localObject1 = (ImageView)localObject1;
    localObject2 = z.aTY();
    p.g(localObject2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    b.a.c((ImageView)localObject1, (String)localObject2);
    paramBundle.getMemberDetailView().setListener((RadarMemberView.b)new RadarViewController.e(paramBundle));
    localObject1 = paramBundle.getGrid();
    localObject2 = paramBundle.getContext();
    p.g(localObject2, "context");
    paramBundle.BBj = new RadarViewController.c(paramBundle, (RadarSpecialGridView)localObject1, (Context)localObject2);
    paramBundle.getGrid().setOnItemClickListener((RadarSpecialGridView.a)new RadarViewController.h(paramBundle));
    paramBundle = eHr();
    localObject1 = paramBundle.BBi;
    localObject2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject2, "service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).aSN().add((MStorageEx.IOnStorageChange)localObject1);
    EventCenter.instance.addListener((IListener)((c)localObject1).Byh);
    localObject2 = com.tencent.mm.kernel.g.ah(s.class);
    p.g(localObject2, "plugin(IPluginMessengerFoundation::class.java)");
    ((s)localObject2).getSysCmdMsgExtension().a("addcontact", (cj.a)((c)localObject1).Byi, true);
    paramBundle = paramBundle.BBh;
    if (paramBundle == null) {
      p.btv("radarManager");
    }
    com.tencent.mm.kernel.g.azz().a(425, (i)paramBundle);
    com.tencent.mm.kernel.g.azz().a(602, (i)paramBundle);
    paramBundle = com.tencent.mm.kernel.g.aAh().azQ().get(229377, Integer.valueOf(0));
    if (paramBundle == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    i = ((Integer)paramBundle).intValue();
    com.tencent.mm.kernel.g.aAh().azQ().set(229377, Integer.valueOf(i + 1));
    AppMethodBeat.o(138639);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(138644);
    localObject1 = eHr();
    Object localObject2 = ((RadarViewController)localObject1).BBi;
    Object localObject3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject3, "service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject3).aSN().remove((MStorageEx.IOnStorageChange)localObject2);
    EventCenter.instance.removeListener((IListener)((c)localObject2).Byh);
    localObject3 = com.tencent.mm.kernel.g.ah(s.class);
    p.g(localObject3, "plugin(IPluginMessengerFoundation::class.java)");
    ((s)localObject3).getSysCmdMsgExtension().b("addcontact", (cj.a)((c)localObject2).Byi, true);
    localObject2 = ((RadarViewController)localObject1).BBh;
    if (localObject2 == null) {
      p.btv("radarManager");
    }
    com.tencent.mm.kernel.g.azz().b(425, (i)localObject2);
    com.tencent.mm.kernel.g.azz().b(602, (i)localObject2);
    ((com.tencent.mm.plugin.radar.b.e)localObject2).stop();
    localObject3 = ((com.tencent.mm.plugin.radar.b.e)localObject2).iOv;
    if (localObject3 != null) {
      ((com.tencent.mm.modelgeo.d)localObject3).c(((com.tencent.mm.plugin.radar.b.e)localObject2).gmA);
    }
    localObject1 = ((RadarViewController)localObject1).getWaveView();
    try
    {
      localObject2 = ((RadarWaveView)localObject1).BBL;
      if (localObject2 != null)
      {
        ((MediaPlayer)localObject2).stop();
        ((MediaPlayer)localObject2).release();
      }
      ((RadarWaveView)localObject1).BBL = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(RadarWaveView.TAG, (Throwable)localException, "", new Object[0]);
        Log.e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
        ((RadarWaveView)localObject1).BBL = null;
      }
    }
    super.onDestroy();
    AppMethodBeat.o(138644);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(138646);
    p.h(paramKeyEvent, "event");
    boolean bool = eHr().onKeyDown(paramInt, paramKeyEvent);
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
    sW(false);
    Object localObject1 = com.tencent.mm.plugin.radar.b.d.ByH;
    long l1;
    if (com.tencent.mm.plugin.radar.b.d.ByD != 0L)
    {
      l1 = com.tencent.mm.plugin.radar.b.d.eHi() - com.tencent.mm.plugin.radar.b.d.ByD;
      localObject1 = d.BzS;
      if (d.HO(l1)) {
        break label446;
      }
    }
    label446:
    for (int i = 1;; i = 0)
    {
      Object localObject2;
      if (i != 0)
      {
        i = com.tencent.mm.plugin.radar.b.d.dRN;
        Log.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFriendsCnt %d", new Object[] { Integer.valueOf(i) });
        localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
        localObject2 = ae.SYK;
        localObject2 = String.format("%d", Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.h)localObject1).kvStat(10679, (String)localObject2);
        com.tencent.mm.plugin.radar.b.d.ByA += 1;
        com.tencent.mm.plugin.radar.b.d.ByB = l1 + com.tencent.mm.plugin.radar.b.d.ByB;
        com.tencent.mm.plugin.radar.b.d.ByD = 0L;
      }
      localObject1 = com.tencent.mm.plugin.radar.b.d.ByH;
      if (com.tencent.mm.plugin.radar.b.d.ByC != 0L)
      {
        l1 = System.currentTimeMillis();
        long l2 = com.tencent.mm.plugin.radar.b.d.ByC;
        i = com.tencent.mm.plugin.radar.b.d.ByA;
        float f1 = (float)com.tencent.mm.plugin.radar.b.d.ByB * 1.0F / 1000.0F;
        int j = com.tencent.mm.plugin.radar.b.d.ByE;
        float f2 = (float)(l1 - l2) * 1.0F / 1000.0F;
        Log.d(com.tencent.mm.plugin.radar.b.d.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) });
        localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
        localObject2 = ae.SYK;
        localObject2 = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) }, 5));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.h)localObject1).kvStat(10676, (String)localObject2);
      }
      if ((eHr().getRadarStatus() == e.e.Bzd) || (eHr().getRadarStatus() == e.e.Bze))
      {
        localObject1 = eHr().BBh;
        if (localObject1 == null) {
          p.btv("radarManager");
        }
        ((com.tencent.mm.plugin.radar.b.e)localObject1).eHk();
        localObject1 = eHr().BBh;
        if (localObject1 == null) {
          p.btv("radarManager");
        }
        localObject2 = ((com.tencent.mm.plugin.radar.b.e)localObject1).iOv;
        if (localObject2 != null) {
          ((com.tencent.mm.modelgeo.d)localObject2).c(((com.tencent.mm.plugin.radar.b.e)localObject1).gmA);
        }
        eHr().getWaveView().eHE();
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
      Log.i(paramArrayOfString, "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfInt.getId()) });
      AppMethodBeat.o(138642);
      return;
    }
    paramArrayOfString = TAG;
    int i = paramArrayOfInt[0];
    Thread localThread = Thread.currentThread();
    p.g(localThread, "Thread.currentThread()");
    Log.i(paramArrayOfString, "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(localThread.getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138642);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        eHs();
        AppMethodBeat.o(138642);
        return;
      }
      this.kgv = false;
      com.tencent.mm.ui.base.h.a((Context)this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131763865), false, (DialogInterface.OnClickListener)new RadarSearchUI.b(this), (DialogInterface.OnClickListener)new RadarSearchUI.c(this));
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138640);
    super.onResume();
    if (this.kgv)
    {
      Object localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject2 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(274436);
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = null;
      }
      if (com.tencent.mm.aw.b.Pi((String)localObject1))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.n((Context)this, "android.permission.ACCESS_FINE_LOCATION"))
        {
          localObject1 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject1, "MMKernel.storage()");
          localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.Oho, Boolean.FALSE);
          if (localObject1 == null)
          {
            localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(138640);
            throw ((Throwable)localObject1);
          }
          if (!((Boolean)localObject1).booleanValue())
          {
            com.tencent.mm.plugin.account.a.b.a.b((Context)this, getString(2131762481, new Object[] { LocaleUtil.getApplicationLanguage() }), this.BzU, true);
            AppMethodBeat.o(138640);
            return;
          }
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this, "android.permission.ACCESS_FINE_LOCATION", 64);
          AppMethodBeat.o(138640);
        }
      }
      else
      {
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this, "android.permission.ACCESS_FINE_LOCATION", 64, null, null);
        Log.i(TAG, "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(138640);
          return;
        }
      }
      eHs();
    }
    AppMethodBeat.o(138640);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSearchUI
 * JD-Core Version:    0.7.0.1
 */