package com.tencent.mm.plugin.radar.ui;

import a.d.b.o;
import a.k;
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
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.rw;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.radar.a.a;
import com.tencent.mm.plugin.radar.a.c;
import com.tencent.mm.plugin.radar.a.d;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.b.e.e;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ak;
import java.util.Arrays;

@com.tencent.mm.ui.base.a(19)
public final class RadarSearchUI
  extends MMBaseActivity
{
  private static final String TAG = "MicroMsg.RadarSearchUI";
  public static final RadarSearchUI.a nmo = new RadarSearchUI.a((byte)0);
  private boolean fht;
  private final a.b nmm;
  private final int nmn;
  
  public RadarSearchUI()
  {
    int i = a.c.radar_play_container;
    a.d.b.g.k(this, "$receiver");
    this.nmm = i.e((a.d.a.a)new i.a(this, i));
    this.fht = true;
    this.nmn = 30764;
  }
  
  private final RadarViewController buI()
  {
    return (RadarViewController)this.nmm.getValue();
  }
  
  private final void buJ()
  {
    in(true);
    Object localObject = com.tencent.mm.plugin.radar.b.d.nkZ;
    com.tencent.mm.plugin.radar.b.d.bRQ = 0;
    com.tencent.mm.plugin.radar.b.d.nkV = 0L;
    com.tencent.mm.plugin.radar.b.d.nkV = com.tencent.mm.plugin.radar.b.d.bux();
    localObject = com.tencent.mm.plugin.radar.b.d.nkZ;
    com.tencent.mm.plugin.radar.b.d.nkW = 0;
    com.tencent.mm.plugin.radar.b.d.nkU = 0L;
    com.tencent.mm.plugin.radar.b.d.nkS = 0;
    com.tencent.mm.plugin.radar.b.d.nkT = 0L;
    com.tencent.mm.plugin.radar.b.d.nkU = com.tencent.mm.plugin.radar.b.d.bux();
    com.tencent.mm.plugin.report.service.h.nFQ.a(com.tencent.mm.plugin.radar.b.d.nkX, com.tencent.mm.plugin.radar.b.d.nkY, 1L, false);
    if ((buI().getRadarStatus() == e.e.nlv) || (buI().getRadarStatus() == e.e.nlw))
    {
      localObject = buI().nnC;
      if (localObject == null) {
        a.d.b.g.ahh("radarManager");
      }
      com.tencent.mm.modelgeo.c localc = ((com.tencent.mm.plugin.radar.b.e)localObject).egs;
      if (localc != null) {
        localc.b(((com.tencent.mm.plugin.radar.b.e)localObject).dig);
      }
      localObject = buI().nnC;
      if (localObject == null) {
        a.d.b.g.ahh("radarManager");
      }
      ((com.tencent.mm.plugin.radar.b.e)localObject).buy();
      buI().getWaveView().buU();
    }
  }
  
  private static void in(boolean paramBoolean)
  {
    rw localrw = new rw();
    localrw.cby.cbz = paramBoolean;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localrw);
  }
  
  public final Object getSystemService(String paramString)
  {
    a.d.b.g.k(paramString, "name");
    Object localObject2 = super.getSystemService(paramString);
    Object localObject1 = localObject2;
    if (a.d.b.g.e("layout_inflater", paramString))
    {
      if (localObject2 == null) {
        throw new k("null cannot be cast to non-null type android.view.LayoutInflater");
      }
      localObject1 = com.tencent.mm.ui.y.a((LayoutInflater)localObject2);
    }
    a.d.b.g.j(localObject1, "if (Context.LAYOUT_INFLA…r)\n        } else service");
    return localObject1;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.nmn)
    {
      if (paramIntent == null) {
        break label94;
      }
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
      {
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzP, Boolean.valueOf(true));
        com.tencent.mm.pluginsdk.permission.a.b((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 64);
        this.fht = false;
      }
    }
    else
    {
      return;
    }
    this.fht = true;
    finish();
    return;
    label94:
    this.fht = true;
    finish();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    requestWindowFeature(1);
    setContentView(a.d.radar_view);
    paramBundle = buI();
    Object localObject1 = paramBundle.findViewById(a.c.radar_main_layer);
    a.d.b.g.j(localObject1, "findViewById(R.id.radar_main_layer)");
    localObject1 = (RelativeLayout)localObject1;
    Object localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
    if (localObject2 == null) {
      throw new k("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Object localObject3 = paramBundle.getContext();
    if (localObject3 == null) {
      throw new k("null cannot be cast to non-null type android.app.Activity");
    }
    localObject3 = ((Activity)localObject3).getWindowManager();
    a.d.b.g.j(localObject3, "(context as Activity).windowManager");
    ((WindowManager)localObject3).getDefaultDisplay().getMetrics(localDisplayMetrics);
    ((RelativeLayout.LayoutParams)localObject2).width = localDisplayMetrics.widthPixels;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = paramBundle.getRadarTips();
    ((RadarTipsView)localObject1).getNoviceEducationTips().setOnClickListener((View.OnClickListener)new RadarTipsView.c((RadarTipsView)localObject1));
    localObject1 = paramBundle.getRadarTips();
    localObject2 = RadarTipsView.nnq;
    ((RadarTipsView)localObject1).nnk = RadarTipsView.buR();
    localObject2 = d.nml;
    int i = d.buH();
    ((RadarTipsView)localObject1).nnc.sendEmptyMessageDelayed(((RadarTipsView)localObject1).nmZ, i);
    ((RadarTipsView)localObject1).nnc.sendEmptyMessageDelayed(((RadarTipsView)localObject1).nmY, i + 8000);
    paramBundle.getRadarTips().setPressingDown(true);
    paramBundle.getQuitBtn().setOnClickListener(paramBundle.nnH);
    localObject1 = paramBundle.getQuitBtn().getLayoutParams();
    if (localObject1 == null) {
      throw new k("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    int j = ((RelativeLayout.LayoutParams)localObject1).topMargin;
    i = j;
    if (ak.gC(paramBundle.getContext())) {
      i = j + ak.gB(paramBundle.getContext());
    }
    ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, i, ((RelativeLayout.LayoutParams)localObject1).rightMargin, ((RelativeLayout.LayoutParams)localObject1).bottomMargin);
    paramBundle.getQuitBtn().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = paramBundle.getWaveView();
    ((RadarWaveView)localObject1).noj = ((RadarWaveView)localObject1).findViewById(a.c.radar_rotate_wave_iv);
    ((RadarWaveView)localObject1).nok = AnimationUtils.loadAnimation(((RadarWaveView)localObject1).getContext(), a.a.radar_wave_rotate);
    localObject1 = ((RadarWaveView)localObject1).nok;
    if (localObject1 == null) {
      a.d.b.g.cUk();
    }
    ((Animation)localObject1).setInterpolator((Interpolator)new LinearInterpolator());
    localObject1 = b.a.nlM;
    localObject1 = paramBundle.findViewById(a.c.self_round_avatar);
    a.d.b.g.j(localObject1, "findViewById(R.id.self_round_avatar)");
    localObject1 = (ImageView)localObject1;
    localObject2 = q.Gj();
    a.d.b.g.j(localObject2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    b.a.a((ImageView)localObject1, (String)localObject2);
    paramBundle.getMemberDetailView().setListener((RadarMemberView.b)new RadarViewController.e(paramBundle));
    localObject1 = paramBundle.getGrid();
    localObject2 = paramBundle.getContext();
    a.d.b.g.j(localObject2, "context");
    paramBundle.nnE = new RadarViewController.c(paramBundle, (RadarSpecialGridView)localObject1, (Context)localObject2);
    paramBundle.getGrid().setOnItemClickListener((RadarSpecialGridView.a)new RadarViewController.g(paramBundle));
    paramBundle = buI();
    localObject1 = paramBundle.nnD;
    localObject2 = com.tencent.mm.kernel.g.r(j.class);
    a.d.b.g.j(localObject2, "service(IMessengerStorage::class.java)");
    ((j)localObject2).Fw().a((m.b)localObject1);
    com.tencent.mm.sdk.b.a.udP.c((com.tencent.mm.sdk.b.c)((com.tencent.mm.plugin.radar.b.c)localObject1).nkw);
    localObject2 = com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class);
    a.d.b.g.j(localObject2, "plugin(IPluginMessengerFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.p)localObject2).getSysCmdMsgExtension().a("addcontact", (bx.a)((com.tencent.mm.plugin.radar.b.c)localObject1).nkx, true);
    paramBundle = paramBundle.nnC;
    if (paramBundle == null) {
      a.d.b.g.ahh("radarManager");
    }
    com.tencent.mm.kernel.g.Dk().a(425, (f)paramBundle);
    com.tencent.mm.kernel.g.Dk().a(602, (f)paramBundle);
    paramBundle = com.tencent.mm.kernel.g.DP().Dz().get(229377, Integer.valueOf(0));
    if (paramBundle == null) {
      throw new k("null cannot be cast to non-null type kotlin.Int");
    }
    i = ((Integer)paramBundle).intValue();
    com.tencent.mm.kernel.g.DP().Dz().set(229377, Integer.valueOf(i + 1));
  }
  
  public final void onDestroy()
  {
    localObject1 = buI();
    Object localObject2 = ((RadarViewController)localObject1).nnD;
    Object localObject3 = com.tencent.mm.kernel.g.r(j.class);
    a.d.b.g.j(localObject3, "service(IMessengerStorage::class.java)");
    ((j)localObject3).Fw().b((m.b)localObject2);
    com.tencent.mm.sdk.b.a.udP.d((com.tencent.mm.sdk.b.c)((com.tencent.mm.plugin.radar.b.c)localObject2).nkw);
    localObject3 = com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class);
    a.d.b.g.j(localObject3, "plugin(IPluginMessengerFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.p)localObject3).getSysCmdMsgExtension().b("addcontact", (bx.a)((com.tencent.mm.plugin.radar.b.c)localObject2).nkx, true);
    localObject2 = ((RadarViewController)localObject1).nnC;
    if (localObject2 == null) {
      a.d.b.g.ahh("radarManager");
    }
    com.tencent.mm.kernel.g.Dk().b(425, (f)localObject2);
    com.tencent.mm.kernel.g.Dk().b(602, (f)localObject2);
    ((com.tencent.mm.plugin.radar.b.e)localObject2).stop();
    localObject3 = ((com.tencent.mm.plugin.radar.b.e)localObject2).egs;
    if (localObject3 != null) {
      ((com.tencent.mm.modelgeo.c)localObject3).c(((com.tencent.mm.plugin.radar.b.e)localObject2).dig);
    }
    localObject1 = ((RadarViewController)localObject1).getWaveView();
    try
    {
      localObject2 = ((RadarWaveView)localObject1).noi;
      if (localObject2 != null)
      {
        ((MediaPlayer)localObject2).stop();
        ((MediaPlayer)localObject2).release();
      }
      ((RadarWaveView)localObject1).noi = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace(RadarWaveView.TAG, (Throwable)localException, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.y.e(RadarWaveView.TAG, "stop() crash, because of the native mediaplay is null.");
        ((RadarWaveView)localObject1).noi = null;
      }
    }
    super.onDestroy();
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    a.d.b.g.k(paramKeyEvent, "event");
    boolean bool = buI().onKeyDown(paramInt, paramKeyEvent);
    if (bool) {
      return bool;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void onPause()
  {
    super.onPause();
    in(false);
    Object localObject1 = com.tencent.mm.plugin.radar.b.d.nkZ;
    long l1;
    if (com.tencent.mm.plugin.radar.b.d.nkV != 0L)
    {
      l1 = com.tencent.mm.plugin.radar.b.d.bux() - com.tencent.mm.plugin.radar.b.d.nkV;
      localObject1 = d.nml;
      if (d.fs(l1)) {
        break label432;
      }
    }
    label432:
    for (int i = 1;; i = 0)
    {
      Object localObject2;
      if (i != 0)
      {
        i = com.tencent.mm.plugin.radar.b.d.bRQ;
        com.tencent.mm.sdk.platformtools.y.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFriendsCnt %d", new Object[] { Integer.valueOf(i) });
        localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
        localObject2 = o.xoy;
        localObject2 = String.format("%d", Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
        a.d.b.g.j(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.h)localObject1).aC(10679, (String)localObject2);
        com.tencent.mm.plugin.radar.b.d.nkS += 1;
        com.tencent.mm.plugin.radar.b.d.nkT = l1 + com.tencent.mm.plugin.radar.b.d.nkT;
        com.tencent.mm.plugin.radar.b.d.nkV = 0L;
      }
      localObject1 = com.tencent.mm.plugin.radar.b.d.nkZ;
      if (com.tencent.mm.plugin.radar.b.d.nkU != 0L)
      {
        l1 = System.currentTimeMillis();
        long l2 = com.tencent.mm.plugin.radar.b.d.nkU;
        i = com.tencent.mm.plugin.radar.b.d.nkS;
        float f1 = (float)com.tencent.mm.plugin.radar.b.d.nkT * 1.0F / 1000.0F;
        int j = com.tencent.mm.plugin.radar.b.d.nkW;
        float f2 = (float)(l1 - l2) * 1.0F / 1000.0F;
        com.tencent.mm.sdk.platformtools.y.d(com.tencent.mm.plugin.radar.b.d.TAG, "RadarAddFriendStat %d,%d,%s,%d,%s", new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) });
        localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
        localObject2 = o.xoy;
        localObject2 = String.format("%d,%d,%s,%d,%s", Arrays.copyOf(new Object[] { Integer.valueOf(1), Integer.valueOf(i), Float.valueOf(f1), Integer.valueOf(j), Float.valueOf(f2) }, 5));
        a.d.b.g.j(localObject2, "java.lang.String.format(format, *args)");
        ((com.tencent.mm.plugin.report.service.h)localObject1).aC(10676, (String)localObject2);
      }
      if ((buI().getRadarStatus() == e.e.nlv) || (buI().getRadarStatus() == e.e.nlw))
      {
        localObject1 = buI().nnC;
        if (localObject1 == null) {
          a.d.b.g.ahh("radarManager");
        }
        ((com.tencent.mm.plugin.radar.b.e)localObject1).buz();
        localObject1 = buI().nnC;
        if (localObject1 == null) {
          a.d.b.g.ahh("radarManager");
        }
        localObject2 = ((com.tencent.mm.plugin.radar.b.e)localObject1).egs;
        if (localObject2 != null) {
          ((com.tencent.mm.modelgeo.c)localObject2).c(((com.tencent.mm.plugin.radar.b.e)localObject1).dig);
        }
        buI().getWaveView().buV();
      }
      return;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    a.d.b.g.k(paramArrayOfString, "permissions");
    a.d.b.g.k(paramArrayOfInt, "grantResults");
    paramArrayOfString = TAG;
    int i = paramArrayOfInt[0];
    Thread localThread = Thread.currentThread();
    a.d.b.g.j(localThread, "Thread.currentThread()");
    com.tencent.mm.sdk.platformtools.y.i(paramArrayOfString, "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(localThread.getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      buJ();
      return;
    }
    this.fht = false;
    com.tencent.mm.ui.base.h.a((Context)this, getString(a.f.permission_location_request_again_msg), getString(a.f.permission_tips_title), getString(a.f.jump_to_settings), getString(a.f.permission_cancel), false, (DialogInterface.OnClickListener)new RadarSearchUI.b(this), (DialogInterface.OnClickListener)new RadarSearchUI.c(this));
  }
  
  public final void onResume()
  {
    super.onResume();
    if (this.fht)
    {
      Object localObject = com.tencent.mm.kernel.g.DP();
      a.d.b.g.j(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).Dz().ctW();
      if (localObject == null) {
        throw new k("null cannot be cast to non-null type kotlin.String");
      }
      if (!com.tencent.mm.at.b.mC((String)localObject)) {
        break label162;
      }
      if (com.tencent.mm.pluginsdk.permission.a.j((Context)this, "android.permission.ACCESS_COARSE_LOCATION")) {
        break label201;
      }
      localObject = com.tencent.mm.kernel.g.DP();
      a.d.b.g.j(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).Dz().get(ac.a.uzP, Boolean.valueOf(false));
      if (localObject == null) {
        throw new k("null cannot be cast to non-null type kotlin.Boolean");
      }
      if (((Boolean)localObject).booleanValue()) {
        break label149;
      }
      com.tencent.mm.plugin.account.a.b.a.b((Context)this, getString(a.f.location_use_scene_gdpr_url, new Object[] { x.cqJ() }), this.nmn, true);
    }
    label149:
    label162:
    boolean bool;
    do
    {
      return;
      com.tencent.mm.pluginsdk.permission.a.b((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 64);
      return;
      bool = com.tencent.mm.pluginsdk.permission.a.a((Activity)this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      com.tencent.mm.sdk.platformtools.y.i(TAG, "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    } while (!bool);
    label201:
    buJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSearchUI
 * JD-Core Version:    0.7.0.1
 */