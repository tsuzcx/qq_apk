package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.mm.an.i;
import com.tencent.mm.f.a.yz;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.radar.a.a;
import com.tencent.mm.plugin.radar.a.b;
import com.tencent.mm.plugin.radar.a.d;
import com.tencent.mm.plugin.radar.a.e;
import com.tencent.mm.plugin.radar.a.g;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.plugin.radar.b.d.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import java.util.Arrays;
import kotlin.g;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.k;
import kotlin.l;

@com.tencent.mm.ui.base.a(19)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/ui/RadarSearchUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "()V", "REQUEST_CODE_GDPR_LOCATION_USE_SCENE", "", "mRadarViewController", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "getMRadarViewController", "()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "mRadarViewController$delegate", "Lkotlin/Lazy;", "shouldCheckPermission", "", "getSystemService", "", "name", "", "hideTalkRoomeStatusBar", "", "isHide", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onResumeAfterMPermissionGranted", "radarUsagePlusOne", "Companion", "plugin-radar_release"})
public final class RadarSearchUI
  extends MMBaseActivity
{
  public static final RadarSearchUI.a Hvq;
  private static final String TAG = "MicroMsg.RadarSearchUI";
  private final kotlin.f Hvo;
  private final int Hvp;
  private boolean mXU;
  
  static
  {
    AppMethodBeat.i(138637);
    Hvq = new RadarSearchUI.a((byte)0);
    TAG = "MicroMsg.RadarSearchUI";
    AppMethodBeat.o(138637);
  }
  
  public RadarSearchUI()
  {
    AppMethodBeat.i(138649);
    int i = a.d.HsT;
    p.k(this, "$this$bind");
    kotlin.g.a.a locala = (kotlin.g.a.a)new i.a(this, i);
    this.Hvo = g.a(k.aazD, locala);
    this.mXU = true;
    this.Hvp = 30764;
    AppMethodBeat.o(138649);
  }
  
  private final RadarViewController ftv()
  {
    AppMethodBeat.i(138638);
    RadarViewController localRadarViewController = (RadarViewController)this.Hvo.getValue();
    AppMethodBeat.o(138638);
    return localRadarViewController;
  }
  
  private final void ftw()
  {
    AppMethodBeat.i(138641);
    wq(true);
    c localc = c.Hue;
    c.ftk();
    localc = c.Hue;
    c.ftl();
    if ((ftv().getRadarStatus() == d.e.Huz) || (ftv().getRadarStatus() == d.e.HuA))
    {
      ftv().onResume();
      ftv().ftn();
      ftv().getWaveView().ftI();
    }
    AppMethodBeat.o(138641);
  }
  
  private static void wq(boolean paramBoolean)
  {
    AppMethodBeat.i(138647);
    yz localyz = new yz();
    localyz.fYo.fYp = paramBoolean;
    EventCenter.instance.publish((IEvent)localyz);
    AppMethodBeat.o(138647);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(138648);
    p.k(paramString, "name");
    Object localObject = super.getSystemService(paramString);
    if ((localObject != null) && (p.h("layout_inflater", paramString)))
    {
      paramString = ad.b((LayoutInflater)localObject);
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
    if (paramInt1 == this.Hvp)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvE, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this, "android.permission.ACCESS_FINE_LOCATION", 64);
          this.mXU = false;
          AppMethodBeat.o(138645);
          return;
        }
        this.mXU = true;
        finish();
        AppMethodBeat.o(138645);
        return;
      }
      this.mXU = true;
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
    setContentView(a.e.Htk);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle.getDecorView().setBackgroundColor(com.tencent.mm.ci.a.w((Context)this, a.b.black));
    paramBundle = ftv();
    Object localObject1 = paramBundle.findViewById(a.d.HsL);
    p.j(localObject1, "findViewById(R.id.radar_main_layer)");
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
    p.j(localObject3, "(context as Activity).windowManager");
    ((WindowManager)localObject3).getDefaultDisplay().getMetrics(localDisplayMetrics);
    ((RelativeLayout.LayoutParams)localObject2).width = localDisplayMetrics.widthPixels;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = paramBundle.getRadarTips();
    ((RadarTipsView)localObject1).getNoviceEducationTips().setOnClickListener((View.OnClickListener)new RadarTipsView.c((RadarTipsView)localObject1));
    localObject1 = paramBundle.getRadarTips();
    ((RadarTipsView)localObject1).Hwk = RadarTipsView.Hwn;
    localObject2 = d.Hvn;
    int i = d.ftu();
    ((RadarTipsView)localObject1).Hwc.sendEmptyMessageDelayed(((RadarTipsView)localObject1).HvZ, i);
    ((RadarTipsView)localObject1).Hwc.sendEmptyMessageDelayed(((RadarTipsView)localObject1).HvY, i + 8000);
    paramBundle.getRadarTips().setPressingDown(true);
    paramBundle.getQuitBtn().setOnClickListener(paramBundle.HwH);
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
    if (ar.aN(paramBundle.getContext())) {
      i = j + ar.aM(paramBundle.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, i, ((RelativeLayout.LayoutParams)localObject1).rightMargin, ((RelativeLayout.LayoutParams)localObject1).bottomMargin);
    paramBundle.getQuitBtn().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = paramBundle.getWaveView();
    ((RadarWaveView)localObject1).Hxh = ((RadarWaveView)localObject1).findViewById(a.d.HsZ);
    ((RadarWaveView)localObject1).Hxi = AnimationUtils.loadAnimation(((RadarWaveView)localObject1).getContext(), a.a.HsC);
    localObject1 = ((RadarWaveView)localObject1).Hxi;
    if (localObject1 == null) {
      p.iCn();
    }
    ((Animation)localObject1).setInterpolator((Interpolator)new LinearInterpolator());
    localObject1 = b.a.HuQ;
    localObject1 = paramBundle.findViewById(a.d.Hth);
    p.j(localObject1, "findViewById(R.id.self_round_avatar)");
    localObject1 = (ImageView)localObject1;
    localObject2 = z.bcZ();
    p.j(localObject2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    b.a.c((ImageView)localObject1, (String)localObject2);
    paramBundle.getMemberDetailView().setListener((RadarMemberView.b)new RadarViewController.e(paramBundle));
    localObject1 = paramBundle.getGrid();
    localObject2 = paramBundle.getContext();
    p.j(localObject2, "context");
    paramBundle.HwE = new RadarViewController.c(paramBundle, (RadarSpecialGridView)localObject1, (Context)localObject2);
    paramBundle.getGrid().setOnItemClickListener((RadarSpecialGridView.a)new RadarViewController.h(paramBundle));
    paramBundle = ftv();
    localObject1 = paramBundle.HwD;
    localObject2 = com.tencent.mm.kernel.h.ae(n.class);
    p.j(localObject2, "service(IMessengerStorage::class.java)");
    ((n)localObject2).bbL().add((MStorageEx.IOnStorageChange)localObject1);
    EventCenter.instance.addListener((IListener)((com.tencent.mm.plugin.radar.b.b)localObject1).HtE);
    localObject2 = com.tencent.mm.kernel.h.ag(v.class);
    p.j(localObject2, "plugin(IPluginMessengerFoundation::class.java)");
    ((v)localObject2).getSysCmdMsgExtension().a("addcontact", (ck.a)((com.tencent.mm.plugin.radar.b.b)localObject1).HtF, true);
    paramBundle = paramBundle.HwC;
    if (paramBundle == null) {
      p.bGy("radarManager");
    }
    com.tencent.mm.kernel.h.aGY().a(425, (i)paramBundle);
    com.tencent.mm.kernel.h.aGY().a(602, (i)paramBundle);
    paramBundle = com.tencent.mm.kernel.h.aHG().aHp().b(229377, Integer.valueOf(0));
    if (paramBundle == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    i = ((Integer)paramBundle).intValue();
    com.tencent.mm.kernel.h.aHG().aHp().i(229377, Integer.valueOf(i + 1));
    AppMethodBeat.o(138639);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(138644);
    localObject1 = ftv();
    Object localObject2 = ((RadarViewController)localObject1).HwD;
    Object localObject3 = com.tencent.mm.kernel.h.ae(n.class);
    p.j(localObject3, "service(IMessengerStorage::class.java)");
    ((n)localObject3).bbL().remove((MStorageEx.IOnStorageChange)localObject2);
    EventCenter.instance.removeListener((IListener)((com.tencent.mm.plugin.radar.b.b)localObject2).HtE);
    localObject3 = com.tencent.mm.kernel.h.ag(v.class);
    p.j(localObject3, "plugin(IPluginMessengerFoundation::class.java)");
    ((v)localObject3).getSysCmdMsgExtension().b("addcontact", (ck.a)((com.tencent.mm.plugin.radar.b.b)localObject2).HtF, true);
    localObject2 = ((RadarViewController)localObject1).HwC;
    if (localObject2 == null) {
      p.bGy("radarManager");
    }
    com.tencent.mm.kernel.h.aGY().b(425, (i)localObject2);
    com.tencent.mm.kernel.h.aGY().b(602, (i)localObject2);
    ((com.tencent.mm.plugin.radar.b.d)localObject2).stop();
    localObject3 = ((com.tencent.mm.plugin.radar.b.d)localObject2).lEL;
    if (localObject3 != null) {
      ((com.tencent.mm.modelgeo.d)localObject3).b(((com.tencent.mm.plugin.radar.b.d)localObject2).iQJ);
    }
    localObject1 = ((RadarViewController)localObject1).getWaveView();
    try
    {
      localObject2 = ((RadarWaveView)localObject1).Hxg;
      if (localObject2 != null)
      {
        ((MediaPlayer)localObject2).stop();
        ((MediaPlayer)localObject2).release();
      }
      ((RadarWaveView)localObject1).Hxg = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(RadarWaveView.TAG, (Throwable)localException, "", new Object[0]);
        Log.e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
        ((RadarWaveView)localObject1).Hxg = null;
      }
    }
    super.onDestroy();
    AppMethodBeat.o(138644);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(138646);
    p.k(paramKeyEvent, "event");
    boolean bool = ftv().onKeyDown(paramInt, paramKeyEvent);
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
    wq(false);
    Object localObject1 = c.Hue;
    long l1;
    if (c.Hua != 0L)
    {
      l1 = c.ftm() - c.Hua;
      localObject1 = d.Hvn;
      if (d.Pj(l1)) {
        break label446;
      }
    }
    label446:
    for (int i = 1;; i = 0)
    {
      Object localObject2;
      if (i != 0)
      {
        i = c.fLk;
        Log.d(c.TAG, "FoundFriendsCnt %d", new Object[] { Integer.valueOf(i) });
        localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
        localObject2 = af.aaBG;
        localObject2 = String.format("%d", Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
        p.j(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.h)localObject1).kvStat(10679, (String)localObject2);
        c.HtX += 1;
        c.HtY = l1 + c.HtY;
        c.Hua = 0L;
      }
      localObject1 = c.Hue;
      if (c.HtZ != 0L)
      {
        l1 = System.currentTimeMillis();
        long l2 = c.HtZ;
        i = c.HtX;
        float f1 = (float)c.HtY * 1.0F / 1000.0F;
        int j = c.Hub;
        float f2 = (float)(l1 - l2) * 1.0F / 1000.0F;
        Log.d(c.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) });
        localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
        localObject2 = af.aaBG;
        localObject2 = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) }, 5));
        p.j(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.h)localObject1).kvStat(10676, (String)localObject2);
      }
      if ((ftv().getRadarStatus() == d.e.Huz) || (ftv().getRadarStatus() == d.e.HuA))
      {
        localObject1 = ftv().HwC;
        if (localObject1 == null) {
          p.bGy("radarManager");
        }
        ((com.tencent.mm.plugin.radar.b.d)localObject1).fto();
        localObject1 = ftv().HwC;
        if (localObject1 == null) {
          p.bGy("radarManager");
        }
        localObject2 = ((com.tencent.mm.plugin.radar.b.d)localObject1).lEL;
        if (localObject2 != null) {
          ((com.tencent.mm.modelgeo.d)localObject2).b(((com.tencent.mm.plugin.radar.b.d)localObject1).iQJ);
        }
        ftv().getWaveView().ftJ();
      }
      AppMethodBeat.o(138643);
      return;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(138642);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length <= 0)
    {
      paramArrayOfString = TAG;
      paramArrayOfInt = Thread.currentThread();
      p.j(paramArrayOfInt, "Thread.currentThread()");
      Log.i(paramArrayOfString, "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfInt.getId()) });
      AppMethodBeat.o(138642);
      return;
    }
    paramArrayOfString = TAG;
    int i = paramArrayOfInt[0];
    Thread localThread = Thread.currentThread();
    p.j(localThread, "Thread.currentThread()");
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
        ftw();
        AppMethodBeat.o(138642);
        return;
      }
      this.mXU = false;
      com.tencent.mm.ui.base.h.a((Context)this, getString(a.g.permission_location_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.permission_cancel), false, (DialogInterface.OnClickListener)new b(this), (DialogInterface.OnClickListener)new c(this));
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138640);
    super.onResume();
    if (this.mXU)
    {
      Object localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      Object localObject2 = ((com.tencent.mm.kernel.f)localObject1).aHp().get(274436);
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = null;
      }
      if (com.tencent.mm.az.b.WF((String)localObject1))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.o((Context)this, "android.permission.ACCESS_FINE_LOCATION"))
        {
          localObject1 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject1, "MMKernel.storage()");
          localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHp().get(ar.a.VvE, Boolean.FALSE);
          if (localObject1 == null)
          {
            localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(138640);
            throw ((Throwable)localObject1);
          }
          if (!((Boolean)localObject1).booleanValue())
          {
            com.tencent.mm.plugin.account.sdk.b.a.b((Context)this, getString(a.g.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), this.Hvp, true);
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
      ftw();
    }
    AppMethodBeat.o(138640);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(RadarSearchUI paramRadarSearchUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138635);
      paramDialogInterface = this.Hvr;
      Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/radar/ui/RadarSearchUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/plugin/radar/ui/RadarSearchUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      RadarSearchUI.a(this.Hvr);
      this.Hvr.finish();
      AppMethodBeat.o(138635);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(RadarSearchUI paramRadarSearchUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138636);
      RadarSearchUI.a(this.Hvr);
      this.Hvr.finish();
      AppMethodBeat.o(138636);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSearchUI
 * JD-Core Version:    0.7.0.1
 */