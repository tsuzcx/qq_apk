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
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.g.b.a.dn;
import com.tencent.mm.g.b.a.r;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.recordvideo.activity.a.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a.b.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;
import d.o;
import d.v;

@com.tencent.mm.ui.base.a(3)
@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "controller", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController;", "isLargeScreen", "", "mediaGenerateCallback", "Lcom/tencent/mm/plugin/recordvideo/biz/MediaGenerateShareCallback;", "root", "Landroid/view/ViewGroup;", "uiRouter", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "checkScreenSize", "", "finish", "finishWithCancel", "getForceOrientation", "", "getLayoutId", "initIntentData", "Lkotlin/Pair;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setWindowStyle", "Companion", "plugin-recordvideo_release"})
public class MMRecordUI
  extends MMActivity
{
  public static final a vcG;
  private ViewGroup pTc;
  private com.tencent.mm.plugin.recordvideo.a.b vcB;
  private RecordConfigProvider vcC;
  private com.tencent.mm.plugin.recordvideo.activity.a.a vcD;
  private com.tencent.mm.plugin.recordvideo.activity.a.b vcE;
  private boolean vcF;
  
  static
  {
    AppMethodBeat.i(75063);
    vcG = new a((byte)0);
    AppMethodBeat.o(75063);
  }
  
  public MMRecordUI()
  {
    AppMethodBeat.i(75062);
    this.vcD = new com.tencent.mm.plugin.recordvideo.activity.a.a();
    AppMethodBeat.o(75062);
  }
  
  private final void dgw()
  {
    AppMethodBeat.i(75054);
    if (ai.eRQ())
    {
      localObject = this.vcC;
      if ((localObject != null) && (((RecordConfigProvider)localObject).vid == true))
      {
        int i = ap.cf((Context)getContext()).y;
        int j = (int)(i * 0.5625F);
        localObject = this.pTc;
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
          localObject = com.tencent.mm.plugin.recordvideo.model.a.viq;
          com.tencent.mm.plugin.recordvideo.model.a.Ki(j);
          localObject = com.tencent.mm.plugin.recordvideo.model.a.viq;
          com.tencent.mm.plugin.recordvideo.model.a.wv(i);
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
    Object localObject = this.pTc;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).width = -1;
      }
    }
    localObject = this.pTc;
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getLayoutParams();
      if (localObject != null) {
        ((ViewGroup.LayoutParams)localObject).height = -1;
      }
    }
    localObject = com.tencent.mm.plugin.recordvideo.model.a.viq;
    com.tencent.mm.plugin.recordvideo.model.a.Ki(ap.cf((Context)getContext()).x);
    localObject = com.tencent.mm.plugin.recordvideo.model.a.viq;
    com.tencent.mm.plugin.recordvideo.model.a.wv(ap.cf((Context)getContext()).y);
    AppMethodBeat.o(75054);
  }
  
  public final void fXY()
  {
    AppMethodBeat.i(204068);
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.recordvideo.d.b localb = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    localIntent.putExtra("report", (Parcelable)com.tencent.mm.plugin.recordvideo.d.b.dix());
    setResult(0, localIntent);
    finish();
    AppMethodBeat.o(204068);
  }
  
  public void finish()
  {
    AppMethodBeat.i(75061);
    ad.i("MicroMsg.MMRecordUI", "finish  " + hashCode());
    super.finish();
    Object localObject = com.tencent.mm.plugin.recordvideo.e.d.vtR;
    com.tencent.mm.plugin.recordvideo.e.d.djg();
    CaptureDataManager.vhw.a(null);
    localObject = com.tencent.mm.plugin.recordvideo.b.g.vgS;
    com.tencent.mm.plugin.recordvideo.b.g.NX();
    localObject = com.tencent.mm.plugin.recordvideo.background.g.vdS;
    com.tencent.mm.plugin.recordvideo.background.g.dgQ();
    localObject = this.vcE;
    if (localObject != null)
    {
      ad.i("MicroMsg.RecordUIRouter", "finish " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).vcK);
      ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).isFinishing = true;
      aq.f((Runnable)new b.b((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject));
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
    ad.i("MicroMsg.MMRecordUI", "requestCode : " + paramInt1 + " resultCode:" + paramInt2 + "  " + hashCode());
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null))
    {
      localObject = this.vcB;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.recordvideo.a.b)localObject).L((Context)this, paramIntent);
        AppMethodBeat.o(75060);
        return;
      }
      AppMethodBeat.o(75060);
      return;
    }
    Object localObject = this.vcE;
    if (localObject != null)
    {
      ad.i("MicroMsg.RecordUIRouter", "onActivityResult " + paramInt1 + ' ' + paramInt2 + ' ' + paramIntent);
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).vcK;
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
    ad.i("MicroMsg.MMRecordUI", "onBackPressed  " + hashCode());
    Object localObject = this.vcE;
    RecordConfigProvider localRecordConfigProvider;
    if (localObject != null)
    {
      localRecordConfigProvider = this.vcC;
      if (localRecordConfigProvider == null) {
        break label126;
      }
    }
    label126:
    for (int i = localRecordConfigProvider.scene;; i = 0)
    {
      ad.i("MicroMsg.RecordUIRouter", "onBackPressed ".concat(String.valueOf(i)));
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).vcK;
      if (localObject != null) {
        bool = ((BasePluginLayout)localObject).dia();
      }
      if (!bool)
      {
        localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.Kp(14);
        localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.Kr(i);
      }
      if (bool != true) {
        fXY();
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
      if (bool != this.vcF)
      {
        this.vcF = bool;
        dgw();
      }
      AppMethodBeat.o(75055);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l2 = 0L;
    AppMethodBeat.i(75053);
    ad.i("MicroMsg.MMRecordUI", "MMRecordUI onCreate  " + hashCode());
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.ne(true);
    getWindow().setFormat(-3);
    setLightNavigationbarIcon();
    this.pTc = ((ViewGroup)findViewById(2131303905));
    paramBundle = com.tencent.mm.plugin.recordvideo.e.d.vtR;
    com.tencent.mm.plugin.recordvideo.e.d.djg();
    paramBundle = (RecordConfigProvider)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    int i = getIntent().getIntExtra("KEY_PARAMS_TO_WHERE", -1);
    int k;
    switch (getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1))
    {
    default: 
      ad.i("MicroMsg.MMRecordUI", "onCreate configProvider : " + paramBundle + "    toWhere:" + i);
      localObject1 = new o(paramBundle, Integer.valueOf(i));
      paramBundle = (RecordConfigProvider)((o)localObject1).first;
      k = ((Number)((o)localObject1).second).intValue();
      if (paramBundle == null) {
        i = 2000;
      }
      break;
    }
    for (;;)
    {
      ad.i("MicroMsg.MMRecordUI", " checkConfigProvider:  ".concat(String.valueOf(i)));
      if (i == 999) {
        break label395;
      }
      setResult(i);
      finish();
      AppMethodBeat.o(75053);
      return;
      CaptureDataManager.vhw.a((CaptureDataManager.b)new com.tencent.mm.plugin.recordvideo.a.a());
      break;
      this.vcB = new com.tencent.mm.plugin.recordvideo.a.b();
      CaptureDataManager.vhw.a((CaptureDataManager.b)this.vcB);
      break;
      if (k == 2)
      {
        int j = com.tencent.mm.plugin.recordvideo.activity.a.a.alw(paramBundle.vhT);
        i = j;
        if (j == 999)
        {
          localObject1 = paramBundle.vhT;
          k.g(localObject1, "configProvider.inputVideoPath");
          j = com.tencent.mm.plugin.recordvideo.activity.a.a.alx((String)localObject1);
          i = j;
          if (j != 999) {}
        }
      }
      else
      {
        i = 999;
      }
    }
    label395:
    Object localObject1 = (Context)this;
    Object localObject2 = this.pTc;
    if (localObject2 == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(75053);
      throw paramBundle;
    }
    if (paramBundle == null) {
      k.fvU();
    }
    this.vcE = new com.tencent.mm.plugin.recordvideo.activity.a.b((Context)localObject1, (ViewGroup)localObject2, paramBundle, k);
    this.vcC = paramBundle;
    localObject1 = com.tencent.mm.plugin.recordvideo.e.c.vtL;
    com.tencent.mm.plugin.recordvideo.e.c.g(paramBundle);
    localObject1 = getResources();
    k.g(localObject1, "resources");
    boolean bool;
    long l3;
    if (((Resources)localObject1).getConfiguration() != null)
    {
      localObject1 = getResources();
      k.g(localObject1, "resources");
      if ((((Resources)localObject1).getConfiguration().screenLayout & 0x3) != 0)
      {
        localObject1 = getResources();
        k.g(localObject1, "resources");
        if ((((Resources)localObject1).getConfiguration().screenLayout & 0x10) != 0)
        {
          bool = true;
          this.vcF = bool;
          dgw();
          localObject1 = this.vcE;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).a(k, com.tencent.mm.plugin.recordvideo.activity.a.a.b(paramBundle));
          }
          ad.i("MicroMsg.MMRecordUI", "MMRecordUI onCreate finish");
          CaptureDataManager.vhw.dhz();
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.a(paramBundle.vhY);
          l1 = ay.ix((Context)getContext());
          l3 = System.currentTimeMillis();
          localObject1 = com.tencent.mm.plugin.recordvideo.e.b.vtE;
          com.tencent.mm.plugin.recordvideo.e.b.fYv();
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_NET_TYPE_INT", Long.valueOf(l1));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ENTER_TIME_MS_LONG", Long.valueOf(l3));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.diy().fi(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.diy().jv(String.valueOf(l3));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.diy();
          localObject2 = paramBundle.vhY;
          if (localObject2 == null) {
            break label971;
          }
          l1 = ((VideoCaptureReportInfo)localObject2).oIw;
          label726:
          ((dc)localObject1).fj(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.diy().fk(l3);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.diy();
          localObject2 = paramBundle.vhY;
          if (localObject2 == null) {
            break label977;
          }
          l1 = ((VideoCaptureReportInfo)localObject2).vii;
          label776:
          ((dc)localObject1).ft(l1);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.diz().gp(ay.ix((Context)getContext()));
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.diz();
          localObject2 = new StringBuilder();
          e locale = com.tencent.mm.kernel.g.afB();
          k.g(locale, "MMKernel.storage()");
          ((dn)localObject1).jO(locale.afk().get(2).toString() + l3);
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          localObject1 = com.tencent.mm.plugin.recordvideo.d.b.diz();
          localObject2 = paramBundle.vhY;
          if (localObject2 == null) {
            break label983;
          }
        }
      }
    }
    label971:
    label977:
    label983:
    for (long l1 = ((VideoCaptureReportInfo)localObject2).oIw;; l1 = 0L)
    {
      ((dn)localObject1).gq(l1);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.diz().gr(l3);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.diz();
      paramBundle = paramBundle.vhY;
      l1 = l2;
      if (paramBundle != null) {
        l1 = paramBundle.vii;
      }
      ((dn)localObject1).gw(l1);
      AppMethodBeat.o(75053);
      return;
      bool = false;
      break;
      l1 = 0L;
      break label726;
      l1 = 0L;
      break label776;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(75058);
    ad.i("MicroMsg.MMRecordUI", "MMRecordUI onDestroy " + hashCode());
    super.onDestroy();
    Object localObject1 = this.vcE;
    if (localObject1 != null)
    {
      ad.i("MicroMsg.RecordUIRouter", "onDestroy " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).vcK);
      aq.f((Runnable)new b.c((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1));
      if ((((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).vcK instanceof RecordPluginLayout))
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      localObject1 = new r();
      Object localObject2 = com.tencent.mm.plugin.recordvideo.d.b.dix();
      Object localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_NET_TYPE_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_NET_TYPE_INT,-1)");
      ((r)localObject1).bt(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_FROM_SCENE_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_FROM_SCENE_INT,-1)");
      ((r)localObject1).bu(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_ENTER_TIME_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_ENTER_TIME_MS_LONG,-1)");
      ((r)localObject1).bv(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_EXIT_TIME_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_EXIT_TIME_MS_LONG,-1)");
      ((r)localObject1).bw(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_MEDIA_SOURCE_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_MEDIA_SOURCE_INT,-1)");
      ((r)localObject1).bx(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_MEDIA_TYPE_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_MEDIA_TYPE_INT,-1)");
      ((r)localObject1).by(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_START_RECORD_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_START_RECORD_MS_LONG,-1)");
      ((r)localObject1).bz(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_…EDIA_DURATION_MS_LONG,-1)");
      ((r)localObject1).bA(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_ORIGIN_MEDIA_WIDTH_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_ORIGIN_MEDIA_WIDTH_INT,-1)");
      ((r)localObject1).bB(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_ORIGIN_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_…IGIN_MEDIA_HEIGHT_INT,-1)");
      ((r)localObject1).bC(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
      ((r)localObject1).bD(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
      ((r)localObject1).bE(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_…DIT_PAGE_TIME_MS_LONG,-1)");
      ((r)localObject1).bF(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_CLICK_EMOJI_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_EMOJI_COUNT_INT,0)");
      ((r)localObject1).bG(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_ADD_EMOJI_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_ADD_EMOJI_COUNT_INT,0)");
      ((r)localObject1).bH(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_CLICK_TEXT_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_TEXT_COUNT_INT,0)");
      ((r)localObject1).bI(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_ADD_TEXT_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_ADD_TEXT_COUNT_INT,0)");
      ((r)localObject1).bJ(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_CLICK_DOODLE_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_DOODLE_COUNT_INT,0)");
      ((r)localObject1).bK(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_ADD_DOODLE_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_ADD_DOODLE_COUNT_INT,0)");
      ((r)localObject1).bL(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_ADD_DOODLE_COLOR_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_…DOODLE_COLOR_COUNT_INT,0)");
      ((r)localObject1).bM(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_CLICK_MOSAIC_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_MOSAIC_COUNT_INT,0)");
      ((r)localObject1).bN(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_CLICK_BRUSH_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_BRUSH_COUNT_INT,0)");
      ((r)localObject1).bO(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_ADD_MOSAIC_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_ADD_MOSAIC_COUNT_INT,0)");
      ((r)localObject1).bP(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_CLICK_CROP_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_CROP_COUNT_INT,0)");
      ((r)localObject1).bQ(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_CROP_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_CROP_MEDIA_HEIGHT_INT,-1)");
      ((r)localObject1).bS(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_CROP_MEDIA_WIDTH_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_CROP_MEDIA_WIDTH_INT,-1)");
      ((r)localObject1).bR(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_ROTATE_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_ROTATE_INT,-1)");
      ((r)localObject1).bT(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_CLICK_MUSIC_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_CLICK_MUSIC_COUNT_INT,0)");
      ((r)localObject1).bU(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_MUSIC_ID_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_MUSIC_ID_INT,-1)");
      ((r)localObject1).bV(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_MUSIC_INDEX_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_MUSIC_INDEX_INT,-1)");
      ((r)localObject1).bW(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_SELECT_MUSIC_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_SELECT_MUSIC_INT,-1)");
      ((r)localObject1).bX(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_SELECT_ORIGIN_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_SELECT_ORIGIN_INT,-1)");
      ((r)localObject1).bY(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_MUSIC_REQ_ID_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_MUSIC_REQ_ID_INT,-1)");
      ((r)localObject1).bZ(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_SEARCH_MUSIC_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_SEARCH_MUSIC_INT,-1)");
      ((r)localObject1).ca(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_CLICK_VIDEO_CROP_COUNT_INT", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_…K_VIDEO_CROP_COUNT_INT,0)");
      ((r)localObject1).cb(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_VIDEO_CROP_DURATION_MS_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_…_CROP_DURATION_MS_INT,-1)");
      ((r)localObject1).cc(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_AFTER_EDIT_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_AFTER_EDIT_INT,-1)");
      ((r)localObject1).cd(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_EDIT_PUBLISHID_INT", Long.valueOf(-1L));
      k.g(localObject3, "info.getReportValue(KEY_EDIT_PUBLISHID_INT,-1)");
      ((r)localObject1).ce(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_IS_SHOW_WESEE_BTN", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_IS_SHOW_WESEE_BTN, 0)");
      ((r)localObject1).cf(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_IS_CLICK_WESEE_BTN", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_IS_CLICK_WESEE_BTN, 0)");
      ((r)localObject1).cg(((Number)localObject3).longValue());
      localObject3 = ((RecordMediaReportInfo)localObject2).w("KEY_IS_INSTALL_WESEE", Long.valueOf(0L));
      k.g(localObject3, "info.getReportValue(KEY_IS_INSTALL_WESEE, 0)");
      ((r)localObject1).ch(((Number)localObject3).longValue());
      localObject2 = ((RecordMediaReportInfo)localObject2).w("KEY_WESEE_DIALOG_OPERATION", Long.valueOf(0L));
      k.g(localObject2, "info.getReportValue(KEY_WESEE_DIALOG_OPERATION, 0)");
      ((r)localObject1).ci(((Number)localObject2).longValue());
      ((r)localObject1).fW(com.tencent.mm.plugin.recordvideo.d.b.vpj.diw());
      ((r)localObject1).aBj();
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.e.d.vtR;
    com.tencent.mm.plugin.recordvideo.e.d.djg();
    if (getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1) == 2) {
      y.cJB.IO().IN();
    }
    com.tencent.mm.media.f.c.grn.ajW();
    AppMethodBeat.o(75058);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(75057);
    ad.i("MicroMsg.MMRecordUI", "MMRecordUI onPause  isFinishing  : " + isFinishing() + "  " + hashCode() + "  ");
    super.onPause();
    f.bAp();
    if (isFinishing())
    {
      AppMethodBeat.o(75057);
      return;
    }
    Object localObject = this.vcE;
    if (localObject != null)
    {
      ad.i("MicroMsg.RecordUIRouter", "onPause " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).vcK);
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).vcK;
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
  
  public void onResume()
  {
    AppMethodBeat.i(75056);
    try
    {
      super.onResume();
      f.bAq();
      Object localObject = this.vcE;
      if (localObject != null)
      {
        ad.i("MicroMsg.RecordUIRouter", "onResume " + ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).vcK);
        localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).vcK;
        if (localObject != null) {
          ((BasePluginLayout)localObject).onResume();
        }
      }
      ad.i("MicroMsg.MMRecordUI", "MMRecordUI onResume " + hashCode() + "  ");
      AppMethodBeat.o(75056);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MMRecordUI", "MMRecordUI onResume " + hashCode());
      ad.printErrStackTrace("MicroMsg.MMRecordUI", (Throwable)localException, "", new Object[0]);
      finish();
      AppMethodBeat.o(75056);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI$Companion;", "", "()V", "REQUEST_CODE_LABEL_SELECT", "", "REQUEST_CODE_LOCATION", "REQUEST_CODE_START", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.MMRecordUI
 * JD-Core Version:    0.7.0.1
 */