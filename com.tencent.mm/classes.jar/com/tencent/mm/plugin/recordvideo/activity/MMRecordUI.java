package com.tencent.mm.plugin.recordvideo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.y;
import com.tencent.mm.api.y.b;
import com.tencent.mm.g.b.a.fr;
import com.tencent.mm.g.b.a.gc;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.recordvideo.activity.a.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a.b.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import d.g.b.p;
import d.l;
import d.o;
import d.v;

@com.tencent.mm.ui.base.a(3)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "controller", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController;", "isLargeScreen", "", "mediaGenerateCallback", "Lcom/tencent/mm/plugin/recordvideo/biz/MediaGenerateShareCallback;", "root", "Landroid/view/ViewGroup;", "uiRouter", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "checkScreenSize", "", "finish", "finishWithCancel", "getForceOrientation", "", "getLayoutId", "initIntentData", "Lkotlin/Pair;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "setWindowStyle", "Companion", "plugin-recordvideo_release"})
public class MMRecordUI
  extends MMActivity
{
  public static final MMRecordUI.a xJr;
  private ViewGroup gJt;
  private RecordConfigProvider sYT;
  private com.tencent.mm.plugin.recordvideo.a.b xJn;
  private com.tencent.mm.plugin.recordvideo.activity.a.a xJo;
  private com.tencent.mm.plugin.recordvideo.activity.a.b xJp;
  private boolean xJq;
  
  static
  {
    AppMethodBeat.i(75063);
    xJr = new MMRecordUI.a((byte)0);
    AppMethodBeat.o(75063);
  }
  
  public MMRecordUI()
  {
    AppMethodBeat.i(75062);
    this.xJo = new com.tencent.mm.plugin.recordvideo.activity.a.a();
    AppMethodBeat.o(75062);
  }
  
  private final void dHR()
  {
    AppMethodBeat.i(75054);
    if (al.fBP())
    {
      localObject = this.sYT;
      if ((localObject != null) && (((RecordConfigProvider)localObject).xOB == true))
      {
        int i = com.tencent.mm.ui.ar.ck((Context)getContext()).y;
        int j = (int)(i * 0.5625F);
        localObject = this.gJt;
        if (localObject != null)
        {
          localObject = ((ViewGroup)localObject).getLayoutParams();
          if (localObject != null)
          {
            ((ViewGroup.LayoutParams)localObject).width = j;
            ((ViewGroup.LayoutParams)localObject).height = i;
            if (!(localObject instanceof LinearLayout.LayoutParams)) {
              break label115;
            }
            ((LinearLayout.LayoutParams)localObject).gravity = 17;
          }
        }
        for (;;)
        {
          localObject = com.tencent.mm.plugin.recordvideo.model.a.xON;
          com.tencent.mm.plugin.recordvideo.model.a.Ol(j);
          localObject = com.tencent.mm.plugin.recordvideo.model.a.xON;
          com.tencent.mm.plugin.recordvideo.model.a.xX(i);
          AppMethodBeat.o(75054);
          return;
          label115:
          if ((localObject instanceof FrameLayout.LayoutParams)) {
            ((FrameLayout.LayoutParams)localObject).gravity = 17;
          } else if ((localObject instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams)localObject).addRule(13);
          }
        }
      }
    }
    Object localObject = this.gJt;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).width = -1;
      }
    }
    localObject = this.gJt;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = -1;
      }
    }
    localObject = com.tencent.mm.plugin.recordvideo.model.a.xON;
    com.tencent.mm.plugin.recordvideo.model.a.Ol(com.tencent.mm.ui.ar.ck((Context)getContext()).x);
    localObject = com.tencent.mm.plugin.recordvideo.model.a.xON;
    com.tencent.mm.plugin.recordvideo.model.a.xX(com.tencent.mm.ui.ar.ck((Context)getContext()).y);
    AppMethodBeat.o(75054);
  }
  
  public final void dHS()
  {
    AppMethodBeat.i(206531);
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.recordvideo.d.c localc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
    localIntent.putExtra("report", (Parcelable)com.tencent.mm.plugin.recordvideo.d.c.dKb());
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(206531);
  }
  
  public void finish()
  {
    AppMethodBeat.i(75061);
    ae.i("MicroMsg.MMRecordUI", "finish  " + hashCode());
    super.finish();
    Object localObject = com.tencent.mm.plugin.recordvideo.e.d.yhu;
    com.tencent.mm.plugin.recordvideo.e.d.dLP();
    CaptureDataManager.xNV.a(null);
    localObject = com.tencent.mm.plugin.recordvideo.b.g.xNr;
    com.tencent.mm.plugin.recordvideo.b.g.unInit();
    localObject = com.tencent.mm.plugin.recordvideo.background.f.xKs;
    com.tencent.mm.plugin.recordvideo.background.f.dIl();
    localObject = this.xJp;
    if (localObject != null)
    {
      ae.i("MicroMsg.RecordUIRouter", "finish " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).xJt);
      ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).isFinishing = true;
      com.tencent.mm.sdk.platformtools.ar.f((Runnable)new b.b((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject));
    }
    if ((getIntent() != null) && (getIntent().getIntExtra("KEY_PARAMS_EXIT_ANIM", -1) != -1)) {
      overridePendingTransition(-1, getIntent().getIntExtra("KEY_PARAMS_EXIT_ANIM", -1));
    }
    AppMethodBeat.o(75061);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495225;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(75060);
    ae.i("MicroMsg.MMRecordUI", "requestCode : " + paramInt1 + " resultCode:" + paramInt2 + "  " + hashCode());
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null))
    {
      localObject = this.xJn;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.recordvideo.a.b)localObject).ab((Context)this, paramIntent);
        AppMethodBeat.o(75060);
        return;
      }
      AppMethodBeat.o(75060);
      return;
    }
    Object localObject = this.xJp;
    if (localObject != null)
    {
      ae.i("MicroMsg.RecordUIRouter", "onActivityResult " + paramInt1 + ' ' + paramInt2 + ' ' + paramIntent);
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).xJt;
      if (localObject != null)
      {
        ((BasePluginLayout)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(75060);
        return;
      }
      AppMethodBeat.o(75060);
      return;
    }
    AppMethodBeat.o(75060);
  }
  
  public void onBackPressed()
  {
    boolean bool = false;
    AppMethodBeat.i(75059);
    ae.i("MicroMsg.MMRecordUI", "onBackPressed  " + hashCode());
    Object localObject = this.xJp;
    RecordConfigProvider localRecordConfigProvider;
    if (localObject != null)
    {
      localRecordConfigProvider = this.sYT;
      if (localRecordConfigProvider == null) {
        break label126;
      }
    }
    label126:
    for (int i = localRecordConfigProvider.scene;; i = 0)
    {
      ae.i("MicroMsg.RecordUIRouter", "onBackPressed ".concat(String.valueOf(i)));
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).xJt;
      if (localObject != null) {
        bool = ((BasePluginLayout)localObject).aoQ();
      }
      if (!bool)
      {
        localObject = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.Ot(14);
        localObject = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.Ov(i);
      }
      if (bool != true) {
        dHS();
      }
      AppMethodBeat.o(75059);
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(75055);
    super.onConfigurationChanged(paramConfiguration);
    if ((paramConfiguration != null) && ((paramConfiguration.screenLayout & 0x3) != 0) && ((paramConfiguration.screenLayout & 0x10) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool != this.xJq)
      {
        this.xJq = bool;
        dHR();
      }
      AppMethodBeat.o(75055);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l2 = 0L;
    AppMethodBeat.i(75053);
    ae.i("MicroMsg.MMRecordUI", "MMRecordUI onCreate  " + hashCode());
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.ow(true);
    getWindow().setFormat(-3);
    setLightNavigationbarIcon();
    this.gJt = ((ViewGroup)findViewById(2131303905));
    paramBundle = com.tencent.mm.plugin.recordvideo.e.d.yhu;
    com.tencent.mm.plugin.recordvideo.e.d.dLP();
    Object localObject1 = (RecordConfigProvider)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    int i = getIntent().getIntExtra("KEY_PARAMS_TO_WHERE", -1);
    int j = getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1);
    label192:
    int k;
    if (localObject1 != null)
    {
      paramBundle = Integer.valueOf(((RecordConfigProvider)localObject1).scene);
      switch (j)
      {
      default: 
        ae.i("MicroMsg.MMRecordUI", "onCreate configProvider : " + localObject1 + "    toWhere:" + i);
        localObject1 = new o(localObject1, Integer.valueOf(i));
        paramBundle = (RecordConfigProvider)((o)localObject1).first;
        k = ((Number)((o)localObject1).second).intValue();
        if (paramBundle == null) {
          i = 2000;
        }
        break;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.MMRecordUI", " checkConfigProvider:  ".concat(String.valueOf(i)));
      if (i == 999) {
        break label434;
      }
      setResult(i);
      finish();
      AppMethodBeat.o(75053);
      return;
      paramBundle = null;
      break;
      if (paramBundle == null) {}
      for (;;)
      {
        CaptureDataManager.xNV.a((CaptureDataManager.b)new com.tencent.mm.plugin.recordvideo.a.a());
        break;
        if (paramBundle.intValue() == 11) {
          break;
        }
      }
      this.xJn = new com.tencent.mm.plugin.recordvideo.a.b();
      CaptureDataManager.xNV.a((CaptureDataManager.b)this.xJn);
      break label192;
      if (k == 2)
      {
        j = com.tencent.mm.plugin.recordvideo.activity.a.a.awK(paramBundle.xOs);
        i = j;
        if (j == 999)
        {
          localObject1 = paramBundle.xOs;
          p.g(localObject1, "configProvider.inputVideoPath");
          j = com.tencent.mm.plugin.recordvideo.activity.a.a.awL((String)localObject1);
          i = j;
          if (j != 999) {}
        }
      }
      else
      {
        i = 999;
      }
    }
    label434:
    localObject1 = (Context)this;
    Object localObject2 = this.gJt;
    if (localObject2 == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(75053);
      throw paramBundle;
    }
    if (paramBundle == null) {
      p.gkB();
    }
    this.xJp = new com.tencent.mm.plugin.recordvideo.activity.a.b((Context)localObject1, (ViewGroup)localObject2, paramBundle, k);
    this.sYT = paramBundle;
    localObject1 = com.tencent.mm.plugin.recordvideo.e.c.yho;
    com.tencent.mm.plugin.recordvideo.e.c.h(paramBundle);
    localObject1 = getResources();
    p.g(localObject1, "resources");
    boolean bool;
    long l3;
    if (((Resources)localObject1).getConfiguration() != null)
    {
      localObject1 = getResources();
      p.g(localObject1, "resources");
      if ((((Resources)localObject1).getConfiguration().screenLayout & 0x3) != 0)
      {
        localObject1 = getResources();
        p.g(localObject1, "resources");
        if ((((Resources)localObject1).getConfiguration().screenLayout & 0x10) != 0)
        {
          bool = true;
          this.xJq = bool;
          dHR();
          localObject1 = this.xJp;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).a(k, com.tencent.mm.plugin.recordvideo.activity.a.a.b(paramBundle));
          }
          ae.i("MicroMsg.MMRecordUI", "MMRecordUI onCreate finish");
          CaptureDataManager.xNV.dIS();
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.a(paramBundle.xOx);
          l1 = az.iX((Context)getContext());
          l3 = System.currentTimeMillis();
          localObject1 = com.tencent.mm.plugin.recordvideo.e.b.yhe;
          com.tencent.mm.plugin.recordvideo.e.b.dLJ();
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_NET_TYPE_INT", Long.valueOf(l1));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ENTER_TIME_MS_LONG", Long.valueOf(l3));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.dKc().ks(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.dKc().oT(String.valueOf(l3));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dKc();
          localObject2 = paramBundle.xOx;
          if (localObject2 == null) {
            break label1010;
          }
          l1 = ((VideoCaptureReportInfo)localObject2).pWb;
          label765:
          ((fr)localObject1).kt(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.dKc().ku(l3);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dKc();
          localObject2 = paramBundle.xOx;
          if (localObject2 == null) {
            break label1016;
          }
          l1 = ((VideoCaptureReportInfo)localObject2).xOF;
          label815:
          ((fr)localObject1).kD(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.dKd().lz(az.iX((Context)getContext()));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dKd();
          localObject2 = new StringBuilder();
          e locale = com.tencent.mm.kernel.g.ajR();
          p.g(locale, "MMKernel.storage()");
          ((gc)localObject1).pm(locale.ajA().get(2).toString() + l3);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dKd();
          localObject2 = paramBundle.xOx;
          if (localObject2 == null) {
            break label1022;
          }
        }
      }
    }
    label1010:
    label1016:
    label1022:
    for (long l1 = ((VideoCaptureReportInfo)localObject2).pWb;; l1 = 0L)
    {
      ((gc)localObject1).lA(l1);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.dKd().lB(l3);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dKd();
      paramBundle = paramBundle.xOx;
      l1 = l2;
      if (paramBundle != null) {
        l1 = paramBundle.xOF;
      }
      ((gc)localObject1).lG(l1);
      AppMethodBeat.o(75053);
      return;
      bool = false;
      break;
      l1 = 0L;
      break label765;
      l1 = 0L;
      break label815;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(75058);
    ae.i("MicroMsg.MMRecordUI", "MMRecordUI onDestroy " + hashCode());
    super.onDestroy();
    Object localObject1 = this.xJp;
    if (localObject1 != null)
    {
      ae.i("MicroMsg.RecordUIRouter", "onDestroy " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).xJt);
      com.tencent.mm.sdk.platformtools.ar.f((Runnable)new b.c((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1));
      if ((((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).xJt instanceof RecordPluginLayout))
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.u("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      localObject1 = new w();
      Object localObject2 = com.tencent.mm.plugin.recordvideo.d.c.dKb();
      Object localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_NET_TYPE_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_NET_TYPE_INT,-1)");
      ((w)localObject1).bv(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_FROM_SCENE_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_FROM_SCENE_INT,-1)");
      ((w)localObject1).bw(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_ENTER_TIME_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_ENTER_TIME_MS_LONG,-1)");
      ((w)localObject1).bx(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_EXIT_TIME_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_EXIT_TIME_MS_LONG,-1)");
      ((w)localObject1).by(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_MEDIA_SOURCE_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_MEDIA_SOURCE_INT,-1)");
      ((w)localObject1).bz(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_MEDIA_TYPE_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_MEDIA_TYPE_INT,-1)");
      ((w)localObject1).bA(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_START_RECORD_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_START_RECORD_MS_LONG,-1)");
      ((w)localObject1).bB(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_…EDIA_DURATION_MS_LONG,-1)");
      ((w)localObject1).bC(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_ORIGIN_MEDIA_WIDTH_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_ORIGIN_MEDIA_WIDTH_INT,-1)");
      ((w)localObject1).bD(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_ORIGIN_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_…IGIN_MEDIA_HEIGHT_INT,-1)");
      ((w)localObject1).bE(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
      ((w)localObject1).bF(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
      ((w)localObject1).bG(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_…DIT_PAGE_TIME_MS_LONG,-1)");
      ((w)localObject1).bH(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_CLICK_EMOJI_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_EMOJI_COUNT_INT,0)");
      ((w)localObject1).bI(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_ADD_EMOJI_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_ADD_EMOJI_COUNT_INT,0)");
      ((w)localObject1).bJ(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_CLICK_TEXT_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_TEXT_COUNT_INT,0)");
      ((w)localObject1).bK(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_ADD_TEXT_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_ADD_TEXT_COUNT_INT,0)");
      ((w)localObject1).bL(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_CLICK_DOODLE_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_DOODLE_COUNT_INT,0)");
      ((w)localObject1).bM(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_ADD_DOODLE_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_ADD_DOODLE_COUNT_INT,0)");
      ((w)localObject1).bN(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_ADD_DOODLE_COLOR_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_…DOODLE_COLOR_COUNT_INT,0)");
      ((w)localObject1).bO(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_CLICK_MOSAIC_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_MOSAIC_COUNT_INT,0)");
      ((w)localObject1).bP(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_CLICK_BRUSH_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_BRUSH_COUNT_INT,0)");
      ((w)localObject1).bQ(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_ADD_MOSAIC_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_ADD_MOSAIC_COUNT_INT,0)");
      ((w)localObject1).bR(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_CLICK_CROP_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_CROP_COUNT_INT,0)");
      ((w)localObject1).bS(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_CROP_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_CROP_MEDIA_HEIGHT_INT,-1)");
      ((w)localObject1).bU(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_CROP_MEDIA_WIDTH_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_CROP_MEDIA_WIDTH_INT,-1)");
      ((w)localObject1).bT(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_ROTATE_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_ROTATE_INT,-1)");
      ((w)localObject1).bV(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_CLICK_MUSIC_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_CLICK_MUSIC_COUNT_INT,0)");
      ((w)localObject1).bW(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_MUSIC_ID_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_MUSIC_ID_INT,-1)");
      ((w)localObject1).bX(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_MUSIC_INDEX_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_MUSIC_INDEX_INT,-1)");
      ((w)localObject1).bY(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_SELECT_MUSIC_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_SELECT_MUSIC_INT,-1)");
      ((w)localObject1).bZ(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_SELECT_ORIGIN_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_SELECT_ORIGIN_INT,-1)");
      ((w)localObject1).ca(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_MUSIC_REQ_ID_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_MUSIC_REQ_ID_INT,-1)");
      ((w)localObject1).cb(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_SEARCH_MUSIC_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_SEARCH_MUSIC_INT,-1)");
      ((w)localObject1).cc(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_CLICK_VIDEO_CROP_COUNT_INT", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_…K_VIDEO_CROP_COUNT_INT,0)");
      ((w)localObject1).cd(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_VIDEO_CROP_DURATION_MS_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_…_CROP_DURATION_MS_INT,-1)");
      ((w)localObject1).ce(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_AFTER_EDIT_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_AFTER_EDIT_INT,-1)");
      ((w)localObject1).cf(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_EDIT_PUBLISHID_INT", Long.valueOf(-1L));
      p.g(localObject3, "info.getReportValue(KEY_EDIT_PUBLISHID_INT,-1)");
      ((w)localObject1).cg(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_IS_SHOW_WESEE_BTN", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_IS_SHOW_WESEE_BTN, 0)");
      ((w)localObject1).ch(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_IS_CLICK_WESEE_BTN", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_IS_CLICK_WESEE_BTN, 0)");
      ((w)localObject1).ci(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).v("KEY_IS_INSTALL_WESEE", Long.valueOf(0L));
      p.g(localObject3, "info.getReportValue(KEY_IS_INSTALL_WESEE, 0)");
      ((w)localObject1).cj(((Number)localObject3).longValue());
      localObject2 = ((RecordMediaReportInfo)localObject2).v("KEY_WESEE_DIALOG_OPERATION", Long.valueOf(0L));
      p.g(localObject2, "info.getReportValue(KEY_WESEE_DIALOG_OPERATION, 0)");
      ((w)localObject1).ck(((Number)localObject2).longValue());
      ((w)localObject1).gV(com.tencent.mm.plugin.recordvideo.d.c.xWP.dKa());
      ((w)localObject1).aLH();
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.e.d.yhu;
    com.tencent.mm.plugin.recordvideo.e.d.dLP();
    if (getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1) == 2) {
      y.cSw.Kf().Ke();
    }
    com.tencent.mm.media.g.c.hnb.atY();
    AppMethodBeat.o(75058);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(75057);
    ae.i("MicroMsg.MMRecordUI", "MMRecordUI onPause  isFinishing  : " + isFinishing() + "  " + hashCode() + "  ");
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.bMs();
    if (isFinishing())
    {
      AppMethodBeat.o(75057);
      return;
    }
    Object localObject = this.xJp;
    if (localObject != null)
    {
      ae.i("MicroMsg.RecordUIRouter", "onPause " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).xJt);
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).xJt;
      if (localObject != null)
      {
        ((BasePluginLayout)localObject).onPause();
        AppMethodBeat.o(75057);
        return;
      }
      AppMethodBeat.o(75057);
      return;
    }
    AppMethodBeat.o(75057);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206532);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    ae.i("MicroMsg.MMRecordUI", "onRequestPermissionsResult, requestCode:".concat(String.valueOf(paramInt)));
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    Object localObject = this.xJp;
    if (localObject != null)
    {
      p.h(paramArrayOfString, "permissions");
      p.h(paramArrayOfInt, "grantResults");
      ae.i("MicroMsg.RecordUIRouter", "onRequestPermissionsResult ".concat(String.valueOf(paramInt)));
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).xJt;
      if (localObject != null)
      {
        ((BasePluginLayout)localObject).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        AppMethodBeat.o(206532);
        return;
      }
      AppMethodBeat.o(206532);
      return;
    }
    AppMethodBeat.o(206532);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(75056);
    try
    {
      super.onResume();
      com.tencent.mm.plugin.ball.f.f.bMt();
      Object localObject = this.xJp;
      if (localObject != null)
      {
        ae.i("MicroMsg.RecordUIRouter", "onResume " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).xJt);
        localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).xJt;
        if (localObject != null) {
          ((BasePluginLayout)localObject).onResume();
        }
      }
      ae.i("MicroMsg.MMRecordUI", "MMRecordUI onResume " + hashCode() + "  ");
      AppMethodBeat.o(75056);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.MMRecordUI", "MMRecordUI onResume " + hashCode());
      ae.printErrStackTrace("MicroMsg.MMRecordUI", (Throwable)localException, "", new Object[0]);
      finish();
      AppMethodBeat.o(75056);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.MMRecordUI
 * JD-Core Version:    0.7.0.1
 */