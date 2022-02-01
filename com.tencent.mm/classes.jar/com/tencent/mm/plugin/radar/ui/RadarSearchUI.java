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
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.wo;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.z;
import d.g.b.p;
import d.k;
import d.v;
import java.util.Arrays;

@com.tencent.mm.ui.base.a(19)
@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/RadarSearchUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "()V", "REQUEST_CODE_GDPR_LOCATION_USE_SCENE", "", "mRadarViewController", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "getMRadarViewController", "()Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "mRadarViewController$delegate", "Lkotlin/Lazy;", "shouldCheckPermission", "", "getSystemService", "", "name", "", "hideTalkRoomeStatusBar", "", "isHide", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onResumeAfterMPermissionGranted", "radarUsagePlusOne", "Companion", "plugin-radar_release"})
public final class RadarSearchUI
  extends MMBaseActivity
{
  private static final String TAG = "MicroMsg.RadarSearchUI";
  public static final RadarSearchUI.a xjX;
  private boolean jfA;
  private final d.f xjV;
  private final int xjW;
  
  static
  {
    AppMethodBeat.i(138637);
    xjX = new RadarSearchUI.a((byte)0);
    TAG = "MicroMsg.RadarSearchUI";
    AppMethodBeat.o(138637);
  }
  
  public RadarSearchUI()
  {
    AppMethodBeat.i(138649);
    p.h(this, "$this$bind");
    d.g.a.a locala = (d.g.a.a)new i.a(this);
    this.xjV = d.g.a(k.MKc, locala);
    this.jfA = true;
    this.xjW = 30764;
    AppMethodBeat.o(138649);
  }
  
  private final RadarViewController dDm()
  {
    AppMethodBeat.i(138638);
    RadarViewController localRadarViewController = (RadarViewController)this.xjV.getValue();
    AppMethodBeat.o(138638);
    return localRadarViewController;
  }
  
  private final void dDn()
  {
    AppMethodBeat.i(138641);
    pD(true);
    com.tencent.mm.plugin.radar.b.d locald = com.tencent.mm.plugin.radar.b.d.xiJ;
    com.tencent.mm.plugin.radar.b.d.dDb();
    locald = com.tencent.mm.plugin.radar.b.d.xiJ;
    com.tencent.mm.plugin.radar.b.d.dDc();
    if ((dDm().getRadarStatus() == e.e.xjf) || (dDm().getRadarStatus() == e.e.xjg))
    {
      dDm().onResume();
      dDm().dDe();
      dDm().getWaveView().dDy();
    }
    AppMethodBeat.o(138641);
  }
  
  private static void pD(boolean paramBoolean)
  {
    AppMethodBeat.i(138647);
    wo localwo = new wo();
    localwo.dKV.dKW = paramBoolean;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localwo);
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
    if (paramInt1 == this.xjW)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEr, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 64);
          this.jfA = false;
          AppMethodBeat.o(138645);
          return;
        }
        this.jfA = true;
        finish();
        AppMethodBeat.o(138645);
        return;
      }
      this.jfA = true;
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
    paramBundle = dDm();
    Object localObject1 = paramBundle.findViewById(2131303682);
    p.g(localObject1, "findViewById(R.id.radar_main_layer)");
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
    p.g(localObject3, "(context as Activity).windowManager");
    ((WindowManager)localObject3).getDefaultDisplay().getMetrics(localDisplayMetrics);
    ((RelativeLayout.LayoutParams)localObject2).width = localDisplayMetrics.widthPixels;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = paramBundle.getRadarTips();
    ((RadarTipsView)localObject1).getNoviceEducationTips().setOnClickListener((View.OnClickListener)new RadarTipsView.c((RadarTipsView)localObject1));
    localObject1 = paramBundle.getRadarTips();
    ((RadarTipsView)localObject1).xkR = RadarTipsView.xkU;
    localObject2 = d.xjU;
    int i = d.dDl();
    ((RadarTipsView)localObject1).xkJ.sendEmptyMessageDelayed(((RadarTipsView)localObject1).xkG, i);
    ((RadarTipsView)localObject1).xkJ.sendEmptyMessageDelayed(((RadarTipsView)localObject1).xkF, i + 8000);
    paramBundle.getRadarTips().setPressingDown(true);
    paramBundle.getQuitBtn().setOnClickListener(paramBundle.xlo);
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
    if (al.aG(paramBundle.getContext())) {
      i = j + al.aF(paramBundle.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, i, ((RelativeLayout.LayoutParams)localObject1).rightMargin, ((RelativeLayout.LayoutParams)localObject1).bottomMargin);
    paramBundle.getQuitBtn().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = paramBundle.getWaveView();
    ((RadarWaveView)localObject1).xlP = ((RadarWaveView)localObject1).findViewById(2131303696);
    ((RadarWaveView)localObject1).xlQ = AnimationUtils.loadAnimation(((RadarWaveView)localObject1).getContext(), 2130772118);
    localObject1 = ((RadarWaveView)localObject1).xlQ;
    if (localObject1 == null) {
      p.gfZ();
    }
    ((Animation)localObject1).setInterpolator((Interpolator)new LinearInterpolator());
    localObject1 = b.a.xjw;
    localObject1 = paramBundle.findViewById(2131304559);
    p.g(localObject1, "findViewById(R.id.self_round_avatar)");
    localObject1 = (ImageView)localObject1;
    localObject2 = u.aAm();
    p.g(localObject2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    b.a.c((ImageView)localObject1, (String)localObject2);
    paramBundle.getMemberDetailView().setListener((RadarMemberView.b)new RadarViewController.e(paramBundle));
    localObject1 = paramBundle.getGrid();
    localObject2 = paramBundle.getContext();
    p.g(localObject2, "context");
    paramBundle.xll = new RadarViewController.c(paramBundle, (RadarSpecialGridView)localObject1, (Context)localObject2);
    paramBundle.getGrid().setOnItemClickListener((RadarSpecialGridView.a)new RadarViewController.h(paramBundle));
    paramBundle = dDm();
    localObject1 = paramBundle.xlk;
    localObject2 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject2, "service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).azp().a((n.b)localObject1);
    com.tencent.mm.sdk.b.a.IbL.c((com.tencent.mm.sdk.b.c)((com.tencent.mm.plugin.radar.b.c)localObject1).xii);
    localObject2 = com.tencent.mm.kernel.g.ad(r.class);
    p.g(localObject2, "plugin(IPluginMessengerFoundation::class.java)");
    ((r)localObject2).getSysCmdMsgExtension().a("addcontact", (cd.a)((com.tencent.mm.plugin.radar.b.c)localObject1).xij, true);
    paramBundle = paramBundle.xlj;
    if (paramBundle == null) {
      p.bcb("radarManager");
    }
    com.tencent.mm.kernel.g.aiU().a(425, (com.tencent.mm.al.f)paramBundle);
    com.tencent.mm.kernel.g.aiU().a(602, (com.tencent.mm.al.f)paramBundle);
    paramBundle = com.tencent.mm.kernel.g.ajC().ajl().get(229377, Integer.valueOf(0));
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(138639);
      throw paramBundle;
    }
    i = ((Integer)paramBundle).intValue();
    com.tencent.mm.kernel.g.ajC().ajl().set(229377, Integer.valueOf(i + 1));
    AppMethodBeat.o(138639);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(138644);
    localObject1 = dDm();
    Object localObject2 = ((RadarViewController)localObject1).xlk;
    Object localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject3, "service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject3).azp().b((n.b)localObject2);
    com.tencent.mm.sdk.b.a.IbL.d((com.tencent.mm.sdk.b.c)((com.tencent.mm.plugin.radar.b.c)localObject2).xii);
    localObject3 = com.tencent.mm.kernel.g.ad(r.class);
    p.g(localObject3, "plugin(IPluginMessengerFoundation::class.java)");
    ((r)localObject3).getSysCmdMsgExtension().b("addcontact", (cd.a)((com.tencent.mm.plugin.radar.b.c)localObject2).xij, true);
    localObject2 = ((RadarViewController)localObject1).xlj;
    if (localObject2 == null) {
      p.bcb("radarManager");
    }
    com.tencent.mm.kernel.g.aiU().b(425, (com.tencent.mm.al.f)localObject2);
    com.tencent.mm.kernel.g.aiU().b(602, (com.tencent.mm.al.f)localObject2);
    ((com.tencent.mm.plugin.radar.b.e)localObject2).stop();
    localObject3 = ((com.tencent.mm.plugin.radar.b.e)localObject2).hQo;
    if (localObject3 != null) {
      ((com.tencent.mm.modelgeo.d)localObject3).c(((com.tencent.mm.plugin.radar.b.e)localObject2).fFl);
    }
    localObject1 = ((RadarViewController)localObject1).getWaveView();
    try
    {
      localObject2 = ((RadarWaveView)localObject1).xlO;
      if (localObject2 != null)
      {
        ((MediaPlayer)localObject2).stop();
        ((MediaPlayer)localObject2).release();
      }
      ((RadarWaveView)localObject1).xlO = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace(RadarWaveView.TAG, (Throwable)localException, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ad.e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
        ((RadarWaveView)localObject1).xlO = null;
      }
    }
    super.onDestroy();
    AppMethodBeat.o(138644);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(138646);
    p.h(paramKeyEvent, "event");
    boolean bool = dDm().onKeyDown(paramInt, paramKeyEvent);
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
    pD(false);
    Object localObject1 = com.tencent.mm.plugin.radar.b.d.xiJ;
    long l1;
    if (com.tencent.mm.plugin.radar.b.d.xiF != 0L)
    {
      l1 = com.tencent.mm.plugin.radar.b.d.dDd() - com.tencent.mm.plugin.radar.b.d.xiF;
      localObject1 = d.xjU;
      if (d.yz(l1)) {
        break label446;
      }
    }
    label446:
    for (int i = 1;; i = 0)
    {
      Object localObject2;
      if (i != 0)
      {
        i = com.tencent.mm.plugin.radar.b.d.dyW;
        com.tencent.mm.sdk.platformtools.ad.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFriendsCnt %d", new Object[] { Integer.valueOf(i) });
        localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
        localObject2 = d.g.b.ad.MLZ;
        localObject2 = String.format("%d", Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.g)localObject1).kvStat(10679, (String)localObject2);
        com.tencent.mm.plugin.radar.b.d.xiC += 1;
        com.tencent.mm.plugin.radar.b.d.xiD = l1 + com.tencent.mm.plugin.radar.b.d.xiD;
        com.tencent.mm.plugin.radar.b.d.xiF = 0L;
      }
      localObject1 = com.tencent.mm.plugin.radar.b.d.xiJ;
      if (com.tencent.mm.plugin.radar.b.d.xiE != 0L)
      {
        l1 = System.currentTimeMillis();
        long l2 = com.tencent.mm.plugin.radar.b.d.xiE;
        i = com.tencent.mm.plugin.radar.b.d.xiC;
        float f1 = (float)com.tencent.mm.plugin.radar.b.d.xiD * 1.0F / 1000.0F;
        int j = com.tencent.mm.plugin.radar.b.d.xiG;
        float f2 = (float)(l1 - l2) * 1.0F / 1000.0F;
        com.tencent.mm.sdk.platformtools.ad.d(com.tencent.mm.plugin.radar.b.d.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) });
        localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
        localObject2 = d.g.b.ad.MLZ;
        localObject2 = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) }, 5));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.g)localObject1).kvStat(10676, (String)localObject2);
      }
      if ((dDm().getRadarStatus() == e.e.xjf) || (dDm().getRadarStatus() == e.e.xjg))
      {
        localObject1 = dDm().xlj;
        if (localObject1 == null) {
          p.bcb("radarManager");
        }
        ((com.tencent.mm.plugin.radar.b.e)localObject1).dDf();
        localObject1 = dDm().xlj;
        if (localObject1 == null) {
          p.bcb("radarManager");
        }
        localObject2 = ((com.tencent.mm.plugin.radar.b.e)localObject1).hQo;
        if (localObject2 != null) {
          ((com.tencent.mm.modelgeo.d)localObject2).c(((com.tencent.mm.plugin.radar.b.e)localObject1).fFl);
        }
        dDm().getWaveView().dDz();
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
      com.tencent.mm.sdk.platformtools.ad.i(paramArrayOfString, "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfInt.getId()) });
      AppMethodBeat.o(138642);
      return;
    }
    paramArrayOfString = TAG;
    int i = paramArrayOfInt[0];
    Thread localThread = Thread.currentThread();
    p.g(localThread, "Thread.currentThread()");
    com.tencent.mm.sdk.platformtools.ad.i(paramArrayOfString, "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(localThread.getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138642);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        dDn();
        AppMethodBeat.o(138642);
        return;
      }
      this.jfA = false;
      h.a((Context)this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131761861), false, (DialogInterface.OnClickListener)new b(this), (DialogInterface.OnClickListener)new c(this));
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138640);
    super.onResume();
    if (this.jfA)
    {
      Object localObject1 = com.tencent.mm.kernel.g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      Object localObject2 = ((com.tencent.mm.kernel.e)localObject1).ajl().get(274436);
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = null;
      }
      if (com.tencent.mm.ax.b.FU((String)localObject1))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.n((Context)this, "android.permission.ACCESS_COARSE_LOCATION"))
        {
          localObject1 = com.tencent.mm.kernel.g.ajC();
          p.g(localObject1, "MMKernel.storage()");
          localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajl().get(al.a.IEr, Boolean.FALSE);
          if (localObject1 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(138640);
            throw ((Throwable)localObject1);
          }
          if (!((Boolean)localObject1).booleanValue())
          {
            com.tencent.mm.plugin.account.a.b.a.b((Context)this, getString(2131760740, new Object[] { ac.fks() }), this.xjW, true);
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
        com.tencent.mm.sdk.platformtools.ad.i(TAG, "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(138640);
          return;
        }
      }
      dDn();
    }
    AppMethodBeat.o(138640);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(RadarSearchUI paramRadarSearchUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138635);
      paramDialogInterface = this.xjY;
      Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/radar/ui/RadarSearchUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/radar/ui/RadarSearchUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      RadarSearchUI.a(this.xjY);
      this.xjY.finish();
      AppMethodBeat.o(138635);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(RadarSearchUI paramRadarSearchUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138636);
      RadarSearchUI.a(this.xjY);
      this.xjY.finish();
      AppMethodBeat.o(138636);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSearchUI
 * JD-Core Version:    0.7.0.1
 */