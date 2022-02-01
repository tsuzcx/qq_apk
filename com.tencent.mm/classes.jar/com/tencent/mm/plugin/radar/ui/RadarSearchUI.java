package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aas;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.radar.a.a;
import com.tencent.mm.plugin.radar.a.b;
import com.tencent.mm.plugin.radar.a.d;
import com.tencent.mm.plugin.radar.a.e;
import com.tencent.mm.plugin.radar.a.g;
import com.tencent.mm.plugin.radar.model.RadarAddContact.onFMsgInfoNotify.1;
import com.tencent.mm.plugin.radar.model.d.e;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.y;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.j;
import kotlin.o;

@com.tencent.mm.ui.base.a(19)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarSearchUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "()V", "REQUEST_CODE_GDPR_LOCATION_USE_SCENE", "", "mRadarViewController", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "getMRadarViewController", "()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "mRadarViewController$delegate", "Lkotlin/Lazy;", "shouldCheckPermission", "", "getSystemService", "", "name", "", "hideTalkRoomeStatusBar", "", "isHide", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onResumeAfterMPermissionGranted", "radarUsagePlusOne", "Companion", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RadarSearchUI
  extends MMBaseActivity
{
  public static final RadarSearchUI.a NsZ;
  private static final String TAG;
  private final j Nta;
  private final int Ntb;
  private boolean pUC;
  
  static
  {
    AppMethodBeat.i(138637);
    NsZ = new RadarSearchUI.a((byte)0);
    TAG = "MicroMsg.RadarSearchUI";
    AppMethodBeat.o(138637);
  }
  
  public RadarSearchUI()
  {
    AppMethodBeat.i(138649);
    Object localObject = (Activity)this;
    int i = a.d.NqI;
    kotlin.g.b.s.u(localObject, "<this>");
    localObject = (kotlin.g.a.a)new e.a((Activity)localObject, i);
    this.Nta = kotlin.k.a(o.aiuH, (kotlin.g.a.a)localObject);
    this.pUC = true;
    this.Ntb = 30764;
    AppMethodBeat.o(138649);
  }
  
  private static void AQ(boolean paramBoolean)
  {
    AppMethodBeat.i(138647);
    aas localaas = new aas();
    localaas.ieo.iep = paramBoolean;
    localaas.publish();
    AppMethodBeat.o(138647);
  }
  
  private static final void a(RadarSearchUI paramRadarSearchUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(267265);
    kotlin.g.b.s.u(paramRadarSearchUI, "this$0");
    com.tencent.mm.pluginsdk.permission.b.lx((Context)paramRadarSearchUI);
    paramRadarSearchUI.pUC = true;
    paramRadarSearchUI.finish();
    AppMethodBeat.o(267265);
  }
  
  private static final void b(RadarSearchUI paramRadarSearchUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(267267);
    kotlin.g.b.s.u(paramRadarSearchUI, "this$0");
    paramRadarSearchUI.pUC = true;
    paramRadarSearchUI.finish();
    AppMethodBeat.o(267267);
  }
  
  private final RadarViewController gFi()
  {
    AppMethodBeat.i(138638);
    RadarViewController localRadarViewController = (RadarViewController)this.Nta.getValue();
    AppMethodBeat.o(138638);
    return localRadarViewController;
  }
  
  private final void gFj()
  {
    AppMethodBeat.i(138641);
    AQ(true);
    com.tencent.mm.plugin.radar.model.c localc = com.tencent.mm.plugin.radar.model.c.NrL;
    com.tencent.mm.plugin.radar.model.c.gEW();
    localc = com.tencent.mm.plugin.radar.model.c.NrL;
    com.tencent.mm.plugin.radar.model.c.gEX();
    if ((gFi().getRadarStatus() == d.e.Nsn) || (gFi().getRadarStatus() == d.e.Nso))
    {
      gFi().onResume();
      gFi().gEZ();
      gFi().getWaveView().gFw();
    }
    l.kK(3, 10);
    AppMethodBeat.o(138641);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(138648);
    kotlin.g.b.s.u(paramString, "name");
    Object localObject = super.getSystemService(paramString);
    if ((localObject != null) && (kotlin.g.b.s.p("layout_inflater", paramString)))
    {
      paramString = af.b((LayoutInflater)localObject);
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
    if (paramInt1 == this.Ntb)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acXn, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this, "android.permission.ACCESS_FINE_LOCATION", 64);
          this.pUC = false;
          AppMethodBeat.o(138645);
          return;
        }
        this.pUC = true;
        finish();
        AppMethodBeat.o(138645);
        return;
      }
      this.pUC = true;
      finish();
    }
    AppMethodBeat.o(138645);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(138639);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramBundle = getWindow().getAttributes();
      kotlin.g.b.s.s(paramBundle, "window.getAttributes()");
      paramBundle.layoutInDisplayCutoutMode = 1;
      getWindow().setAttributes(paramBundle);
    }
    paramBundle = getWindow().getDecorView();
    kotlin.g.b.s.s(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x406);
    setContentView(a.e.NqZ);
    getWindow().getDecorView().setBackgroundColor(com.tencent.mm.cd.a.w((Context)this, a.b.black));
    getWindow().setStatusBarColor(com.tencent.mm.cd.a.w((Context)this, a.b.black));
    if ((Build.VERSION.SDK_INT >= 26) && (!y.jjW())) {
      getWindow().setNavigationBarColor(com.tencent.mm.cd.a.w((Context)this, a.b.black));
    }
    paramBundle = gFi();
    Object localObject1 = paramBundle.findViewById(a.d.NqA);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.radar_main_layer)");
    localObject1 = (RelativeLayout)localObject1;
    Object localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Context localContext = paramBundle.getContext();
    if (localContext == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    ((Activity)localContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    ((RelativeLayout.LayoutParams)localObject2).width = localDisplayMetrics.widthPixels;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramBundle.getRadarTips().init();
    localObject1 = paramBundle.getRadarTips();
    ((RadarTipsView)localObject1).NtT = RadarTipsView.NtW;
    localObject2 = c.NsW;
    int i = c.gFh();
    ((RadarTipsView)localObject1).NtL.sendEmptyMessageDelayed(((RadarTipsView)localObject1).NtI, i);
    ((RadarTipsView)localObject1).NtL.sendEmptyMessageDelayed(((RadarTipsView)localObject1).NtH, i + 8000);
    paramBundle.getRadarTips().setPressingDown(true);
    paramBundle.getQuitBtn().setOnClickListener(paramBundle.Nup);
    localObject1 = paramBundle.getQuitBtn().getLayoutParams();
    if (localObject1 == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    int j = ((RelativeLayout.LayoutParams)localObject1).topMargin;
    i = j;
    if (aw.bx(paramBundle.getContext())) {
      i = j + aw.bw(paramBundle.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, i, ((RelativeLayout.LayoutParams)localObject1).rightMargin, ((RelativeLayout.LayoutParams)localObject1).bottomMargin);
    paramBundle.getQuitBtn().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = paramBundle.getWaveView();
    ((RadarWaveView)localObject1).NuN = ((RadarWaveView)localObject1).findViewById(a.d.NqO);
    ((RadarWaveView)localObject1).NuO = AnimationUtils.loadAnimation(((RadarWaveView)localObject1).getContext(), a.a.Nqr);
    localObject1 = ((RadarWaveView)localObject1).NuO;
    kotlin.g.b.s.checkNotNull(localObject1);
    ((Animation)localObject1).setInterpolator((Interpolator)new LinearInterpolator());
    localObject1 = b.a.NsB;
    localObject1 = paramBundle.findViewById(a.d.NqW);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.self_round_avatar)");
    localObject1 = (ImageView)localObject1;
    localObject2 = z.bAM();
    kotlin.g.b.s.s(localObject2, "getUsernameFromUserInfo()");
    b.a.g((ImageView)localObject1, (String)localObject2);
    paramBundle.getMemberDetailView().setListener((RadarMemberView.b)new RadarViewController.f(paramBundle));
    localObject1 = paramBundle.getGrid();
    localObject2 = paramBundle.getContext();
    kotlin.g.b.s.s(localObject2, "context");
    paramBundle.Num = new RadarViewController.c(paramBundle, (RadarSpecialGridView)localObject1, (Context)localObject2);
    paramBundle.getGrid().setOnItemClickListener((RadarSpecialGridView.a)new RadarViewController.g(paramBundle));
    paramBundle = gFi();
    localObject1 = paramBundle.Nul;
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().add((MStorageEx.IOnStorageChange)localObject1);
    ((com.tencent.mm.plugin.radar.model.b)localObject1).Nrw.alive();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("addcontact", (cl.a)((com.tencent.mm.plugin.radar.model.b)localObject1).Nrx, true);
    localObject1 = paramBundle.Nuk;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("radarManager");
      paramBundle = null;
    }
    com.tencent.mm.kernel.h.aZW().a(425, (com.tencent.mm.am.h)paramBundle);
    com.tencent.mm.kernel.h.aZW().a(602, (com.tencent.mm.am.h)paramBundle);
    paramBundle = com.tencent.mm.kernel.h.baE().ban().d(229377, Integer.valueOf(0));
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    i = ((Integer)paramBundle).intValue();
    com.tencent.mm.kernel.h.baE().ban().B(229377, Integer.valueOf(i + 1));
    AppMethodBeat.o(138639);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(138644);
    RadarViewController localRadarViewController = gFi();
    localObject1 = localRadarViewController.Nul;
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().remove((MStorageEx.IOnStorageChange)localObject1);
    ((com.tencent.mm.plugin.radar.model.b)localObject1).Nrw.dead();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("addcontact", (cl.a)((com.tencent.mm.plugin.radar.model.b)localObject1).Nrx, true);
    Object localObject2 = localRadarViewController.Nuk;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("radarManager");
      localObject1 = null;
    }
    com.tencent.mm.kernel.h.aZW().b(425, (com.tencent.mm.am.h)localObject1);
    com.tencent.mm.kernel.h.aZW().b(602, (com.tencent.mm.am.h)localObject1);
    ((com.tencent.mm.plugin.radar.model.d)localObject1).stop();
    localObject2 = ((com.tencent.mm.plugin.radar.model.d)localObject1).owr;
    if (localObject2 != null) {
      ((com.tencent.mm.modelgeo.d)localObject2).a(((com.tencent.mm.plugin.radar.model.d)localObject1).lsF);
    }
    localObject1 = localRadarViewController.getWaveView();
    try
    {
      localObject2 = ((RadarWaveView)localObject1).NuM;
      if (localObject2 != null)
      {
        ((MediaPlayer)localObject2).stop();
        ((MediaPlayer)localObject2).release();
      }
      ((RadarWaveView)localObject1).NuM = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(RadarWaveView.TAG, (Throwable)localException, "", new Object[0]);
        Log.e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
        ((RadarWaveView)localObject1).NuM = null;
      }
    }
    super.onDestroy();
    AppMethodBeat.o(138644);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(138646);
    kotlin.g.b.s.u(paramKeyEvent, "event");
    boolean bool = gFi().onKeyDown(paramInt, paramKeyEvent);
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
    AQ(false);
    Object localObject1 = com.tencent.mm.plugin.radar.model.c.NrL;
    long l1;
    if (com.tencent.mm.plugin.radar.model.c.NrP != 0L)
    {
      l1 = com.tencent.mm.plugin.radar.model.c.gEY() - com.tencent.mm.plugin.radar.model.c.NrP;
      localObject1 = c.NsW;
      if (c.tj(l1)) {
        break label460;
      }
    }
    label460:
    for (int i = 1;; i = 0)
    {
      Object localObject2;
      if (i != 0)
      {
        i = com.tencent.mm.plugin.radar.model.c.hQS;
        Log.d(com.tencent.mm.plugin.radar.model.c.TAG, "FoundFriendsCnt %d", new Object[] { Integer.valueOf(i) });
        localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
        localObject2 = am.aixg;
        localObject2 = String.format("%d", Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
        kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.h)localObject1).kvStat(10679, (String)localObject2);
        com.tencent.mm.plugin.radar.model.c.NrM += 1;
        com.tencent.mm.plugin.radar.model.c.NrN = l1 + com.tencent.mm.plugin.radar.model.c.NrN;
        com.tencent.mm.plugin.radar.model.c.NrP = 0L;
      }
      localObject1 = com.tencent.mm.plugin.radar.model.c.NrL;
      if (com.tencent.mm.plugin.radar.model.c.NrO != 0L)
      {
        l1 = System.currentTimeMillis();
        long l2 = com.tencent.mm.plugin.radar.model.c.NrO;
        i = com.tencent.mm.plugin.radar.model.c.NrM;
        float f1 = (float)com.tencent.mm.plugin.radar.model.c.NrN * 1.0F / 1000.0F;
        int j = com.tencent.mm.plugin.radar.model.c.NrQ;
        float f2 = (float)(l1 - l2) * 1.0F / 1000.0F;
        Log.d(com.tencent.mm.plugin.radar.model.c.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) });
        localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
        localObject2 = am.aixg;
        localObject2 = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) }, 5));
        kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.h)localObject1).kvStat(10676, (String)localObject2);
      }
      if ((gFi().getRadarStatus() == d.e.Nsn) || (gFi().getRadarStatus() == d.e.Nso))
      {
        localObject2 = gFi().Nuk;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("radarManager");
          localObject1 = null;
        }
        ((com.tencent.mm.plugin.radar.model.d)localObject1).gFa();
        localObject2 = gFi().Nuk;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("radarManager");
          localObject1 = null;
        }
        localObject2 = ((com.tencent.mm.plugin.radar.model.d)localObject1).owr;
        if (localObject2 != null) {
          ((com.tencent.mm.modelgeo.d)localObject2).a(((com.tencent.mm.plugin.radar.model.d)localObject1).lsF);
        }
        gFi().getWaveView().gFx();
      }
      AppMethodBeat.o(138643);
      return;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(138642);
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length <= 0)
    {
      Log.i(TAG, "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(138642);
      return;
    }
    Log.i(TAG, "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    if (paramInt == 64)
    {
      if (paramArrayOfInt[0] == 0)
      {
        gFj();
        AppMethodBeat.o(138642);
        return;
      }
      this.pUC = false;
      com.tencent.mm.ui.base.k.a((Context)this, getString(a.g.permission_location_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.permission_cancel), false, new RadarSearchUI..ExternalSyntheticLambda1(this), new RadarSearchUI..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(138642);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138640);
    super.onResume();
    if (this.pUC)
    {
      Object localObject = com.tencent.mm.kernel.h.baE().ban().d(274436, null);
      if ((localObject instanceof String)) {
        localObject = (String)localObject;
      }
      while (com.tencent.mm.au.b.OE((String)localObject))
      {
        if (com.tencent.mm.pluginsdk.permission.b.s((Context)this, "android.permission.ACCESS_FINE_LOCATION")) {
          break label223;
        }
        localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acXn, Boolean.FALSE);
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(138640);
          throw ((Throwable)localObject);
          localObject = null;
        }
        else
        {
          if (!((Boolean)localObject).booleanValue())
          {
            com.tencent.mm.plugin.account.sdk.c.a.b((Context)this, getString(a.g.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), this.Ntb, true);
            AppMethodBeat.o(138640);
            return;
          }
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this, "android.permission.ACCESS_FINE_LOCATION", 64);
          AppMethodBeat.o(138640);
          return;
        }
      }
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this, "android.permission.ACCESS_FINE_LOCATION", 64, getString(a.g.Nre));
      Log.i(TAG, "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(138640);
        return;
      }
      label223:
      gFj();
    }
    AppMethodBeat.o(138640);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSearchUI
 * JD-Core Version:    0.7.0.1
 */