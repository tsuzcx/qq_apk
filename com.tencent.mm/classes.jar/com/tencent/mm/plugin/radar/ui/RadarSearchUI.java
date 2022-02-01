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
import com.tencent.mm.g.a.vl;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.y;
import d.f;
import d.g.b.w;
import d.g.b.z;
import d.l;
import d.v;
import java.util.Arrays;

@com.tencent.mm.ui.base.a(19)
@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarSearchUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "()V", "REQUEST_CODE_GDPR_LOCATION_USE_SCENE", "", "mRadarViewController", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "getMRadarViewController", "()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "mRadarViewController$delegate", "Lkotlin/Lazy;", "shouldCheckPermission", "", "getSystemService", "", "name", "", "hideTalkRoomeStatusBar", "", "isHide", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onResumeAfterMPermissionGranted", "radarUsagePlusOne", "Companion", "plugin-radar_release"})
public final class RadarSearchUI
  extends MMBaseActivity
{
  private static final String TAG = "MicroMsg.RadarSearchUI";
  public static final RadarSearchUI.a uTz;
  private boolean imk;
  private final f uTx;
  private final int uTy;
  
  static
  {
    AppMethodBeat.i(138637);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(RadarSearchUI.class), "mRadarViewController", "getMRadarViewController()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;")) };
    uTz = new RadarSearchUI.a((byte)0);
    TAG = "MicroMsg.RadarSearchUI";
    AppMethodBeat.o(138637);
  }
  
  public RadarSearchUI()
  {
    AppMethodBeat.i(138649);
    d.g.b.k.h(this, "$this$bind");
    d.g.a.a locala = (d.g.a.a)new i.a(this);
    this.uTx = d.g.a(d.k.JfK, locala);
    this.imk = true;
    this.uTy = 30764;
    AppMethodBeat.o(138649);
  }
  
  private final RadarViewController dfi()
  {
    AppMethodBeat.i(138638);
    RadarViewController localRadarViewController = (RadarViewController)this.uTx.getValue();
    AppMethodBeat.o(138638);
    return localRadarViewController;
  }
  
  private final void dfj()
  {
    AppMethodBeat.i(138641);
    om(true);
    com.tencent.mm.plugin.radar.b.d locald = com.tencent.mm.plugin.radar.b.d.uSl;
    com.tencent.mm.plugin.radar.b.d.deX();
    locald = com.tencent.mm.plugin.radar.b.d.uSl;
    com.tencent.mm.plugin.radar.b.d.deY();
    if ((dfi().getRadarStatus() == e.e.uSH) || (dfi().getRadarStatus() == e.e.uSI))
    {
      dfi().onResume();
      dfi().dfa();
      dfi().getWaveView().dfu();
    }
    AppMethodBeat.o(138641);
  }
  
  private static void om(boolean paramBoolean)
  {
    AppMethodBeat.i(138647);
    vl localvl = new vl();
    localvl.dAX.dAY = paramBoolean;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localvl);
    AppMethodBeat.o(138647);
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(138648);
    d.g.b.k.h(paramString, "name");
    Object localObject = super.getSystemService(paramString);
    if ((localObject != null) && (d.g.b.k.g("layout_inflater", paramString)))
    {
      paramString = y.b((LayoutInflater)localObject);
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
    if (paramInt1 == this.uTy)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtT, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 64);
          this.imk = false;
          AppMethodBeat.o(138645);
          return;
        }
        this.imk = true;
        finish();
        AppMethodBeat.o(138645);
        return;
      }
      this.imk = true;
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
    paramBundle = dfi();
    Object localObject1 = paramBundle.findViewById(2131303682);
    d.g.b.k.g(localObject1, "findViewById(R.id.radar_main_layer)");
    localObject1 = (RelativeLayout)localObject1;
    Object localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
    if (localObject2 == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Object localObject3 = paramBundle.getContext();
    if (localObject3 == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    localObject3 = ((Activity)localObject3).getWindowManager();
    d.g.b.k.g(localObject3, "(context as Activity).windowManager");
    ((WindowManager)localObject3).getDefaultDisplay().getMetrics(localDisplayMetrics);
    ((RelativeLayout.LayoutParams)localObject2).width = localDisplayMetrics.widthPixels;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = paramBundle.getRadarTips();
    ((RadarTipsView)localObject1).getNoviceEducationTips().setOnClickListener((View.OnClickListener)new RadarTipsView.c((RadarTipsView)localObject1));
    localObject1 = paramBundle.getRadarTips();
    ((RadarTipsView)localObject1).uUt = RadarTipsView.uUw;
    localObject2 = d.uTw;
    int i = d.dfh();
    ((RadarTipsView)localObject1).uUl.sendEmptyMessageDelayed(((RadarTipsView)localObject1).uUi, i);
    ((RadarTipsView)localObject1).uUl.sendEmptyMessageDelayed(((RadarTipsView)localObject1).uUh, i + 8000);
    paramBundle.getRadarTips().setPressingDown(true);
    paramBundle.getQuitBtn().setOnClickListener(paramBundle.uUQ);
    localObject1 = paramBundle.getQuitBtn().getLayoutParams();
    if (localObject1 == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    int j = ((RelativeLayout.LayoutParams)localObject1).topMargin;
    i = j;
    if (ai.aF(paramBundle.getContext())) {
      i = j + ai.aE(paramBundle.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, i, ((RelativeLayout.LayoutParams)localObject1).rightMargin, ((RelativeLayout.LayoutParams)localObject1).bottomMargin);
    paramBundle.getQuitBtn().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = paramBundle.getWaveView();
    ((RadarWaveView)localObject1).uVr = ((RadarWaveView)localObject1).findViewById(2131303696);
    ((RadarWaveView)localObject1).uVs = AnimationUtils.loadAnimation(((RadarWaveView)localObject1).getContext(), 2130772118);
    localObject1 = ((RadarWaveView)localObject1).uVs;
    if (localObject1 == null) {
      d.g.b.k.fvU();
    }
    ((Animation)localObject1).setInterpolator((Interpolator)new LinearInterpolator());
    localObject1 = b.a.uSY;
    localObject1 = paramBundle.findViewById(2131304559);
    d.g.b.k.g(localObject1, "findViewById(R.id.self_round_avatar)");
    localObject1 = (ImageView)localObject1;
    localObject2 = com.tencent.mm.model.u.aqG();
    d.g.b.k.g(localObject2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    b.a.c((ImageView)localObject1, (String)localObject2);
    paramBundle.getMemberDetailView().setListener((RadarMemberView.b)new RadarViewController.e(paramBundle));
    localObject1 = paramBundle.getGrid();
    localObject2 = paramBundle.getContext();
    d.g.b.k.g(localObject2, "context");
    paramBundle.uUN = new RadarViewController.c(paramBundle, (RadarSpecialGridView)localObject1, (Context)localObject2);
    paramBundle.getGrid().setOnItemClickListener((RadarSpecialGridView.a)new RadarViewController.h(paramBundle));
    paramBundle = dfi();
    localObject1 = paramBundle.uUM;
    localObject2 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject2, "service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).apM().a((n.b)localObject1);
    com.tencent.mm.sdk.b.a.ESL.c((com.tencent.mm.sdk.b.c)((com.tencent.mm.plugin.radar.b.c)localObject1).uRJ);
    localObject2 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    d.g.b.k.g(localObject2, "plugin(IPluginMessengerFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)localObject2).getSysCmdMsgExtension().a("addcontact", (cc.a)((com.tencent.mm.plugin.radar.b.c)localObject1).uRK, true);
    paramBundle = paramBundle.uUL;
    if (paramBundle == null) {
      d.g.b.k.aPZ("radarManager");
    }
    com.tencent.mm.kernel.g.aeS().a(425, (com.tencent.mm.al.g)paramBundle);
    com.tencent.mm.kernel.g.aeS().a(602, (com.tencent.mm.al.g)paramBundle);
    paramBundle = com.tencent.mm.kernel.g.afB().afk().get(229377, Integer.valueOf(0));
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    i = ((Integer)paramBundle).intValue();
    com.tencent.mm.kernel.g.afB().afk().set(229377, Integer.valueOf(i + 1));
    AppMethodBeat.o(138639);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(138644);
    localObject1 = dfi();
    Object localObject2 = ((RadarViewController)localObject1).uUM;
    Object localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject3, "service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject3).apM().b((n.b)localObject2);
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)((com.tencent.mm.plugin.radar.b.c)localObject2).uRJ);
    localObject3 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    d.g.b.k.g(localObject3, "plugin(IPluginMessengerFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)localObject3).getSysCmdMsgExtension().b("addcontact", (cc.a)((com.tencent.mm.plugin.radar.b.c)localObject2).uRK, true);
    localObject2 = ((RadarViewController)localObject1).uUL;
    if (localObject2 == null) {
      d.g.b.k.aPZ("radarManager");
    }
    com.tencent.mm.kernel.g.aeS().b(425, (com.tencent.mm.al.g)localObject2);
    com.tencent.mm.kernel.g.aeS().b(602, (com.tencent.mm.al.g)localObject2);
    ((com.tencent.mm.plugin.radar.b.e)localObject2).stop();
    localObject3 = ((com.tencent.mm.plugin.radar.b.e)localObject2).gXu;
    if (localObject3 != null) {
      ((com.tencent.mm.modelgeo.d)localObject3).c(((com.tencent.mm.plugin.radar.b.e)localObject2).fjJ);
    }
    localObject1 = ((RadarViewController)localObject1).getWaveView();
    try
    {
      localObject2 = ((RadarWaveView)localObject1).uVq;
      if (localObject2 != null)
      {
        ((MediaPlayer)localObject2).stop();
        ((MediaPlayer)localObject2).release();
      }
      ((RadarWaveView)localObject1).uVq = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace(RadarWaveView.TAG, (Throwable)localException, "", new Object[0]);
        ad.e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
        ((RadarWaveView)localObject1).uVq = null;
      }
    }
    super.onDestroy();
    AppMethodBeat.o(138644);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(138646);
    d.g.b.k.h(paramKeyEvent, "event");
    boolean bool = dfi().onKeyDown(paramInt, paramKeyEvent);
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
    om(false);
    Object localObject1 = com.tencent.mm.plugin.radar.b.d.uSl;
    long l1;
    if (com.tencent.mm.plugin.radar.b.d.uSh != 0L)
    {
      l1 = com.tencent.mm.plugin.radar.b.d.deZ() - com.tencent.mm.plugin.radar.b.d.uSh;
      localObject1 = d.uTw;
      if (d.rL(l1)) {
        break label446;
      }
    }
    label446:
    for (int i = 1;; i = 0)
    {
      Object localObject2;
      if (i != 0)
      {
        i = com.tencent.mm.plugin.radar.b.d.dpx;
        ad.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFriendsCnt %d", new Object[] { Integer.valueOf(i) });
        localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
        localObject2 = z.Jhz;
        localObject2 = String.format("%d", Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
        d.g.b.k.g(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.h)localObject1).kvStat(10679, (String)localObject2);
        com.tencent.mm.plugin.radar.b.d.uSe += 1;
        com.tencent.mm.plugin.radar.b.d.uSf = l1 + com.tencent.mm.plugin.radar.b.d.uSf;
        com.tencent.mm.plugin.radar.b.d.uSh = 0L;
      }
      localObject1 = com.tencent.mm.plugin.radar.b.d.uSl;
      if (com.tencent.mm.plugin.radar.b.d.uSg != 0L)
      {
        l1 = System.currentTimeMillis();
        long l2 = com.tencent.mm.plugin.radar.b.d.uSg;
        i = com.tencent.mm.plugin.radar.b.d.uSe;
        float f1 = (float)com.tencent.mm.plugin.radar.b.d.uSf * 1.0F / 1000.0F;
        int j = com.tencent.mm.plugin.radar.b.d.uSi;
        float f2 = (float)(l1 - l2) * 1.0F / 1000.0F;
        ad.d(com.tencent.mm.plugin.radar.b.d.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) });
        localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
        localObject2 = z.Jhz;
        localObject2 = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) }, 5));
        d.g.b.k.g(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.h)localObject1).kvStat(10676, (String)localObject2);
      }
      if ((dfi().getRadarStatus() == e.e.uSH) || (dfi().getRadarStatus() == e.e.uSI))
      {
        localObject1 = dfi().uUL;
        if (localObject1 == null) {
          d.g.b.k.aPZ("radarManager");
        }
        ((com.tencent.mm.plugin.radar.b.e)localObject1).dfb();
        localObject1 = dfi().uUL;
        if (localObject1 == null) {
          d.g.b.k.aPZ("radarManager");
        }
        localObject2 = ((com.tencent.mm.plugin.radar.b.e)localObject1).gXu;
        if (localObject2 != null) {
          ((com.tencent.mm.modelgeo.d)localObject2).c(((com.tencent.mm.plugin.radar.b.e)localObject1).fjJ);
        }
        dfi().getWaveView().dfv();
      }
      AppMethodBeat.o(138643);
      return;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(138642);
    d.g.b.k.h(paramArrayOfString, "permissions");
    d.g.b.k.h(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length <= 0)
    {
      paramArrayOfString = TAG;
      paramArrayOfInt = Thread.currentThread();
      d.g.b.k.g(paramArrayOfInt, "Thread.currentThread()");
      ad.i(paramArrayOfString, "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfInt.getId()) });
      AppMethodBeat.o(138642);
      return;
    }
    paramArrayOfString = TAG;
    int i = paramArrayOfInt[0];
    Thread localThread = Thread.currentThread();
    d.g.b.k.g(localThread, "Thread.currentThread()");
    ad.i(paramArrayOfString, "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(localThread.getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138642);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        dfj();
        AppMethodBeat.o(138642);
        return;
      }
      this.imk = false;
      com.tencent.mm.ui.base.h.a((Context)this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131761861), false, (DialogInterface.OnClickListener)new b(this), (DialogInterface.OnClickListener)new c(this));
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138640);
    super.onResume();
    if (this.imk)
    {
      Object localObject1 = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      Object localObject2 = ((com.tencent.mm.kernel.e)localObject1).afk().get(274436);
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = null;
      }
      if (com.tencent.mm.ax.b.yL((String)localObject1))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.o((Context)this, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          localObject1 = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(localObject1, "MMKernel.storage()");
          localObject1 = ((com.tencent.mm.kernel.e)localObject1).afk().get(ae.a.FtT, Boolean.FALSE);
          if (localObject1 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(138640);
            throw ((Throwable)localObject1);
          }
          if (!((Boolean)localObject1).booleanValue())
          {
            com.tencent.mm.plugin.account.a.b.a.b((Context)this, getString(2131760740, new Object[] { ac.eFu() }), this.uTy, true);
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
        ad.i(TAG, "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(138640);
          return;
        }
      }
      dfj();
    }
    AppMethodBeat.o(138640);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(RadarSearchUI paramRadarSearchUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138635);
      paramDialogInterface = this.uTA;
      Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/radar/ui/RadarSearchUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/radar/ui/RadarSearchUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      RadarSearchUI.a(this.uTA);
      this.uTA.finish();
      AppMethodBeat.o(138635);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(RadarSearchUI paramRadarSearchUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138636);
      RadarSearchUI.a(this.uTA);
      this.uTA.finish();
      AppMethodBeat.o(138636);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSearchUI
 * JD-Core Version:    0.7.0.1
 */