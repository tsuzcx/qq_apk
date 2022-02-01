package com.tencent.mm.plugin.recordvideo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.nf;
import com.tencent.mm.autogen.mmdata.rpt.oo;
import com.tencent.mm.autogen.mmdata.rpt.oz;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.o;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.d;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.systemservicecache.NetworkCache;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "controller", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController;", "isLargeScreen", "", "mediaGenerateCallback", "Lcom/tencent/mm/plugin/recordvideo/biz/MediaGenerateShareCallback;", "root", "Landroid/view/ViewGroup;", "uiRouter", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "checkScreenSize", "", "finish", "finishWithCancel", "getForceOrientation", "", "getLayoutId", "initIntentData", "Lkotlin/Pair;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "setWindowStyle", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public class MMRecordUI
  extends MMActivity
{
  public static final MMRecordUI.a NDg;
  private com.tencent.mm.plugin.recordvideo.b.b NDh;
  private com.tencent.mm.plugin.recordvideo.activity.a.a NDi;
  private com.tencent.mm.plugin.recordvideo.activity.a.b NDj;
  private boolean NDk;
  private ViewGroup mJe;
  private RecordConfigProvider oaV;
  
  static
  {
    AppMethodBeat.i(75063);
    NDg = new MMRecordUI.a((byte)0);
    AppMethodBeat.o(75063);
  }
  
  public MMRecordUI()
  {
    AppMethodBeat.i(75062);
    this.NDi = new com.tencent.mm.plugin.recordvideo.activity.a.a();
    AppMethodBeat.o(75062);
  }
  
  private final void gGA()
  {
    Object localObject2 = null;
    int i = 1;
    AppMethodBeat.i(75054);
    if (aw.jkQ())
    {
      localObject1 = this.oaV;
      int j;
      if ((localObject1 != null) && (((RecordConfigProvider)localObject1).NIm == true))
      {
        if (i == 0) {
          break label193;
        }
        getContext().getWindow().getDecorView().setBackgroundColor(com.tencent.mm.cd.a.w((Context)getContext(), b.b.black));
        i = bf.bf((Context)getContext()).y;
        j = (int)(i * 0.5625F);
        localObject1 = this.mJe;
        if (localObject1 != null)
        {
          localObject1 = ((ViewGroup)localObject1).getLayoutParams();
          if (localObject1 != null)
          {
            ((ViewGroup.LayoutParams)localObject1).width = j;
            ((ViewGroup.LayoutParams)localObject1).height = i;
            if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
              break label155;
            }
            ((LinearLayout.LayoutParams)localObject1).gravity = 17;
          }
        }
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.plugin.recordvideo.model.a.NIt;
        com.tencent.mm.plugin.recordvideo.model.a.agw(j);
        localObject1 = com.tencent.mm.plugin.recordvideo.model.a.NIt;
        com.tencent.mm.plugin.recordvideo.model.a.FE(i);
        AppMethodBeat.o(75054);
        return;
        i = 0;
        break;
        label155:
        if ((localObject1 instanceof FrameLayout.LayoutParams)) {
          ((FrameLayout.LayoutParams)localObject1).gravity = 17;
        } else if ((localObject1 instanceof RelativeLayout.LayoutParams)) {
          ((RelativeLayout.LayoutParams)localObject1).addRule(13);
        }
      }
    }
    label193:
    Object localObject1 = this.mJe;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((ViewGroup.LayoutParams)localObject1).width = -1;
      }
      localObject1 = this.mJe;
      if (localObject1 != null) {
        break label288;
      }
    }
    label288:
    for (localObject1 = localObject2;; localObject1 = ((ViewGroup)localObject1).getLayoutParams())
    {
      if (localObject1 != null) {
        ((ViewGroup.LayoutParams)localObject1).height = -1;
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.model.a.NIt;
      com.tencent.mm.plugin.recordvideo.model.a.agw(bf.bf((Context)getContext()).x);
      localObject1 = com.tencent.mm.plugin.recordvideo.model.a.NIt;
      com.tencent.mm.plugin.recordvideo.model.a.FE(bf.bf((Context)getContext()).y);
      AppMethodBeat.o(75054);
      return;
      localObject1 = ((ViewGroup)localObject1).getLayoutParams();
      break;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(75061);
    Log.i("MicroMsg.MMRecordUI", s.X("finish  ", Integer.valueOf(hashCode())));
    super.finish();
    Object localObject = com.tencent.mm.plugin.recordvideo.util.h.Obz;
    com.tencent.mm.plugin.recordvideo.util.h.gLj();
    CaptureDataManager.NHH.NHG = null;
    localObject = com.tencent.mm.plugin.recordvideo.c.h.NHb;
    com.tencent.mm.plugin.recordvideo.c.h.unInit();
    localObject = com.tencent.mm.plugin.recordvideo.background.f.NDY;
    com.tencent.mm.plugin.recordvideo.background.f.gGS();
    localObject = this.NDj;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).finish();
    }
    if ((getIntent() != null) && (getIntent().getIntExtra("KEY_PARAMS_EXIT_ANIM", -1) != -1)) {
      overridePendingTransition(-1, getIntent().getIntExtra("KEY_PARAMS_EXIT_ANIM", -1));
    }
    AppMethodBeat.o(75061);
  }
  
  public final void gGB()
  {
    AppMethodBeat.i(279437);
    Object localObject = new Intent();
    com.tencent.mm.plugin.recordvideo.f.c localc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    ((Intent)localObject).putExtra("report", (Parcelable)com.tencent.mm.plugin.recordvideo.f.c.gJe());
    setResult(0, (Intent)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.f.g.NRB;
    com.tencent.mm.plugin.recordvideo.f.g.aQ(2, 3L);
    finish();
    AppMethodBeat.o(279437);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.f.record_ui_layout;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(75060);
    Log.i("MicroMsg.MMRecordUI", "requestCode : " + paramInt1 + " resultCode:" + paramInt2 + "  " + hashCode());
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null))
    {
      localObject1 = this.NDh;
      if (localObject1 != null)
      {
        Context localContext = (Context)this;
        String str = paramIntent.getStringExtra("Select_Conv_User");
        Log.d("MicroMsg.MMRecordUI", "select %s for sending imagePath:%s", new Object[] { str, ((com.tencent.mm.plugin.recordvideo.b.b)localObject1).NGk });
        w localw = k.a(localContext, localContext.getResources().getString(b.h.photo_edit_forward_tips), false, null);
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        Object localObject2 = t.a(t.d.oNd).wg(4);
        ((t.e)localObject2).hQQ = z.bAM();
        ((t.e)localObject2).toUser = str;
        ((t.e)localObject2).oIx = ((com.tencent.mm.plugin.recordvideo.b.b)localObject1).NGk;
        ((t.e)localObject2).oGu = 0;
        ((t.e)localObject2).oNk = null;
        ((t.e)localObject2).hOX = 0;
        ((t.e)localObject2).oGC = "";
        ((t.e)localObject2).thumbPath = "";
        ((t.e)localObject2).oNn = true;
        ((t.e)localObject2).oNm = b.d.chat_img_template;
        ((t.e)localObject2).oNj = 11;
        Object localObject3 = ((t.e)localObject2).bKW();
        localObject2 = (o)((t.b)localObject3).oNb;
        ((t.b)localObject3).aXz();
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVP, true))
        {
          localObject3 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
          com.tencent.mm.plugin.recordvideo.util.f.ln(String.valueOf(((o)localObject2).bJM().field_msgId), ((com.tencent.mm.plugin.recordvideo.b.b)localObject1).NGk);
        }
        com.tencent.mm.plugin.messenger.a.g.gaI().ke(paramIntent, str);
        if (localw != null) {
          localw.dismiss();
        }
        ((Activity)localContext).finish();
        AppMethodBeat.o(75060);
      }
    }
    else
    {
      localObject1 = this.NDj;
      if (localObject1 != null)
      {
        Log.i("MicroMsg.RecordUIRouter", "onActivityResult " + paramInt1 + ' ' + paramInt2 + ' ' + paramIntent);
        localObject1 = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).NDp;
        if (localObject1 != null) {
          ((BasePluginLayout)localObject1).onActivityResult(paramInt1, paramInt2, paramIntent);
        }
      }
    }
    AppMethodBeat.o(75060);
  }
  
  public void onBackPressed()
  {
    int j = 0;
    AppMethodBeat.i(75059);
    Log.i("MicroMsg.MMRecordUI", s.X("onBackPressed  ", Integer.valueOf(hashCode())));
    Object localObject = this.NDj;
    int i = j;
    RecordConfigProvider localRecordConfigProvider;
    if (localObject != null)
    {
      localRecordConfigProvider = this.oaV;
      if (localRecordConfigProvider != null) {
        break label129;
      }
      i = 0;
      Log.i("MicroMsg.RecordUIRouter", s.X("onBackPressed ", Integer.valueOf(i)));
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).NDp;
      if (localObject != null) {
        break label138;
      }
    }
    label129:
    label138:
    for (boolean bool = false;; bool = ((BasePluginLayout)localObject).onBackPress())
    {
      if (!bool)
      {
        localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.agH(14);
        localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.agJ(i);
      }
      i = j;
      if (bool == true) {
        i = 1;
      }
      if (i == 0) {
        gGB();
      }
      AppMethodBeat.o(75059);
      return;
      i = localRecordConfigProvider.scene;
      break;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(75055);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if (((paramConfiguration.screenLayout & 0x3) != 0) && ((paramConfiguration.screenLayout & 0x10) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool != this.NDk)
      {
        this.NDk = bool;
        gGA();
      }
      AppMethodBeat.o(75055);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(75053);
    Log.i("MicroMsg.MMRecordUI", s.X("MMRecordUI onCreate  ", Integer.valueOf(hashCode())));
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.ys(true);
    getWindow().setFormat(-3);
    setLightNavigationbarIcon();
    this.mJe = ((ViewGroup)findViewById(b.e.record_ui_root));
    paramBundle = com.tencent.mm.plugin.recordvideo.util.h.Obz;
    com.tencent.mm.plugin.recordvideo.util.h.gLj();
    Object localObject1 = (RecordConfigProvider)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    int i = getIntent().getIntExtra("KEY_PARAMS_TO_WHERE", -1);
    int j = getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1);
    label176:
    int k;
    if (localObject1 == null)
    {
      paramBundle = null;
      switch (j)
      {
      default: 
        Log.i("MicroMsg.MMRecordUI", "onCreate configProvider : " + localObject1 + "    toWhere:" + i);
        localObject1 = new r(localObject1, Integer.valueOf(i));
        paramBundle = (RecordConfigProvider)((r)localObject1).bsC;
        k = ((Number)((r)localObject1).bsD).intValue();
        if (paramBundle == null) {
          i = 2000;
        }
        break;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MMRecordUI", s.X(" checkConfigProvider:  ", Integer.valueOf(i)));
      if (i == 999) {
        break label425;
      }
      setResult(i);
      finish();
      AppMethodBeat.o(75053);
      return;
      paramBundle = Integer.valueOf(((RecordConfigProvider)localObject1).scene);
      break;
      if (paramBundle == null) {}
      for (;;)
      {
        CaptureDataManager.NHH.NHG = ((CaptureDataManager.b)new com.tencent.mm.plugin.recordvideo.b.a());
        break;
        if (paramBundle.intValue() == 11) {
          break;
        }
      }
      this.NDh = new com.tencent.mm.plugin.recordvideo.b.b();
      CaptureDataManager.NHH.NHG = ((CaptureDataManager.b)this.NDh);
      break label176;
      if (k == 2)
      {
        j = com.tencent.mm.plugin.recordvideo.activity.a.a.aSM(paramBundle.NId);
        i = j;
        if (j == 999)
        {
          localObject1 = paramBundle.NId;
          s.s(localObject1, "configProvider.inputVideoPath");
          j = com.tencent.mm.plugin.recordvideo.activity.a.a.aSN((String)localObject1);
          i = j;
          if (j != 999) {}
        }
      }
      else
      {
        i = 999;
      }
    }
    label425:
    localObject1 = (Context)this;
    Object localObject2 = this.mJe;
    if (localObject2 == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(75053);
      throw paramBundle;
    }
    s.checkNotNull(paramBundle);
    this.NDj = new com.tencent.mm.plugin.recordvideo.activity.a.b((Context)localObject1, (ViewGroup)localObject2, paramBundle, k);
    this.oaV = paramBundle;
    localObject1 = com.tencent.mm.plugin.recordvideo.util.g.Obu;
    com.tencent.mm.plugin.recordvideo.util.g.q(paramBundle);
    boolean bool;
    if ((getResources().getConfiguration() != null) && ((getResources().getConfiguration().screenLayout & 0x3) != 0) && ((getResources().getConfiguration().screenLayout & 0x10) != 0))
    {
      bool = true;
      this.NDk = bool;
      gGA();
      localObject1 = this.NDj;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject1).a(k, com.tencent.mm.plugin.recordvideo.activity.a.a.g(paramBundle));
      }
      Log.i("MicroMsg.MMRecordUI", "MMRecordUI onCreate finish");
      CaptureDataManager.NHH.rnY.clear();
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.a(paramBundle.NIi);
      localObject1 = e.xfd;
      s.u("RecordMediaReporter", "sessionId");
      s.u("moment_sessionid_", "key");
      localObject1 = Locale.getDefault();
      s.s(localObject1, "getDefault()");
      localObject1 = "moment_sessionid_".toLowerCase((Locale)localObject1);
      s.s(localObject1, "(this as java.lang.String).toLowerCase(locale)");
      localObject1 = e.a.amr("RecordMediaReporter").xfa.get(localObject1);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("moment_sessionid_", localObject1);
      }
      localObject1 = e.xfd;
      e.a.aft("RecordMediaReporter");
      long l3 = NetworkCache.INSTANCE.getIOSNetTypeFromCache((Context)getContext());
      long l2 = System.currentTimeMillis();
      localObject1 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
      com.tencent.mm.plugin.recordvideo.util.f.gLg();
      localObject1 = com.tencent.mm.plugin.recordvideo.util.f.Obq;
      l1 = com.tencent.mm.plugin.recordvideo.util.f.eMf.decodeLong("clean_file_timestamp_long", 0L);
      localObject1 = i.agtt;
      i = i.a(b.a.agrL, 0);
      if ((System.currentTimeMillis() - l1 >= 1209600000L) || (i != 0)) {
        break label1120;
      }
      Log.i("MicroMsg.MediaFileUtil", "interval not reached");
      label786:
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_NET_TYPE_INT", Long.valueOf(l3));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_ENTER_TIME_MS_LONG", Long.valueOf(l2));
      localObject1 = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      localObject1 = paramBundle.NIi;
      if (localObject1 != null) {
        break label1281;
      }
      i = 0;
      label836:
      com.tencent.mm.plugin.recordvideo.f.g.agL(i);
      localObject1 = com.tencent.mm.plugin.recordvideo.f.g.NRB;
      com.tencent.mm.plugin.recordvideo.f.g.agK((int)l3);
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJf().itb = l3;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.gJf();
      ((oo)localObject1).jju = ((oo)localObject1).F("PublishObjectId", String.valueOf(l2), true);
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.gJf();
      localObject2 = paramBundle.NIi;
      if (localObject2 != null) {
        break label1290;
      }
      l1 = 0L;
      label917:
      ((oo)localObject1).izg = l1;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJf().iuE = l2;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.gJf();
      localObject2 = paramBundle.NIi;
      if (localObject2 != null) {
        break label1301;
      }
      l1 = 0L;
      label961:
      ((oo)localObject1).jjE = l1;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJg().itb = l3;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.gJg();
      ((oz)localObject1).jju = ((oz)localObject1).F("PublishObjectId", com.tencent.mm.kernel.h.baE().ban().d(2, null) + l2, true);
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.gJg();
      localObject2 = paramBundle.NIi;
      if (localObject2 != null) {
        break label1311;
      }
      l1 = 0L;
      label1058:
      ((oz)localObject1).izg = l1;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJg().iuE = l2;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.gJg();
      paramBundle = paramBundle.NIi;
      if (paramBundle != null) {
        break label1322;
      }
    }
    label1281:
    label1290:
    label1301:
    label1311:
    label1322:
    for (long l1 = 0L;; l1 = paramBundle.NIs)
    {
      ((oz)localObject1).jjE = l1;
      AppMethodBeat.o(75053);
      return;
      bool = false;
      break;
      label1120:
      com.tencent.mm.plugin.recordvideo.util.f.eMf.encode("clean_file_timestamp_long", System.currentTimeMillis());
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIX, 14);
      Log.i("MicroMsg.MediaFileUtil", "deleteExpiredFile " + i + " days");
      if (i < 0) {
        break label786;
      }
      l1 = com.tencent.mm.plugin.music.cache.b.hrJ.longValue() * i;
      v.bOg();
      localObject1 = y.bEo(v.getAccVideoPath());
      s.checkNotNull(localObject1);
      com.tencent.mm.plugin.recordvideo.util.f.q((String)localObject1, "videovsg", l1);
      v.bOg();
      localObject1 = v.getAccVideoPath();
      s.s(localObject1, "getCore().accVideoPath");
      com.tencent.mm.plugin.recordvideo.util.f.q((String)localObject1, "vsg", l1);
      v.bOg();
      localObject1 = v.getAccVideoPath();
      s.s(localObject1, "getCore().accVideoPath");
      com.tencent.mm.plugin.recordvideo.util.f.q((String)localObject1, "send", l1);
      break label786;
      i = ((VideoCaptureReportInfo)localObject1).ybL;
      break label836;
      l1 = ((VideoCaptureReportInfo)localObject2).xYX;
      break label917;
      l1 = ((VideoCaptureReportInfo)localObject2).NIs;
      break label961;
      l1 = ((VideoCaptureReportInfo)localObject2).xYX;
      break label1058;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(75058);
    Log.i("MicroMsg.MMRecordUI", s.X("MMRecordUI onDestroy ", Integer.valueOf(hashCode())));
    super.onDestroy();
    Object localObject = this.NDj;
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).onDestroy();
    }
    localObject = com.tencent.mm.plugin.recordvideo.util.h.Obz;
    com.tencent.mm.plugin.recordvideo.util.h.gLj();
    if (getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1) == 2) {
      ac.hdY.aAA().aAz();
    }
    localObject = com.tencent.mm.plugin.recordvideo.f.g.NRB;
    Log.i("MicroMsg.VideoWidgetReporter", "videoWidgetReporter doReport");
    com.tencent.mm.plugin.recordvideo.f.g.NRC.vz(com.tencent.mm.plugin.recordvideo.f.g.gJo());
    if ((com.tencent.mm.plugin.recordvideo.f.g.NRC.jem != 0L) && (com.tencent.mm.plugin.recordvideo.f.g.NRD != 0L)) {
      com.tencent.mm.plugin.recordvideo.f.g.NRC.bMH();
    }
    com.tencent.mm.plugin.recordvideo.f.g.NRD = 0L;
    com.tencent.mm.media.g.c.nAB.bpx();
    localObject = com.tencent.mm.media.camera.e.a.nvP;
    com.tencent.mm.media.camera.e.a.boo();
    localObject = com.tencent.mm.media.camera.e.a.nvP;
    com.tencent.mm.media.camera.e.a.bor();
    AppMethodBeat.o(75058);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(75057);
    Log.i("MicroMsg.MMRecordUI", "MMRecordUI onPause  isFinishing  : " + isFinishing() + "  " + hashCode() + "  ");
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    if (isFinishing())
    {
      AppMethodBeat.o(75057);
      return;
    }
    Object localObject = this.NDj;
    if (localObject != null)
    {
      Log.i("MicroMsg.RecordUIRouter", s.X("onPause ", ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).NDp));
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).NDp;
      if (localObject != null) {
        ((BasePluginLayout)localObject).onPause();
      }
    }
    AppMethodBeat.o(75057);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(279447);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    Log.i("MicroMsg.MMRecordUI", s.X("onRequestPermissionsResult, requestCode:", Integer.valueOf(paramInt)));
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    Object localObject = this.NDj;
    if (localObject != null)
    {
      s.u(paramArrayOfString, "permissions");
      s.u(paramArrayOfInt, "grantResults");
      Log.i("MicroMsg.RecordUIRouter", s.X("onRequestPermissionsResult ", Integer.valueOf(paramInt)));
      localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).NDp;
      if (localObject != null) {
        ((BasePluginLayout)localObject).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
    }
    AppMethodBeat.o(279447);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(75056);
    try
    {
      super.onResume();
      com.tencent.mm.plugin.ball.f.f.d(true, true, true);
      Object localObject = this.NDj;
      if (localObject != null)
      {
        Log.i("MicroMsg.RecordUIRouter", s.X("onResume ", ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).NDp));
        localObject = ((com.tencent.mm.plugin.recordvideo.activity.a.b)localObject).NDp;
        if (localObject != null) {
          ((BasePluginLayout)localObject).onResume();
        }
      }
      Log.i("MicroMsg.MMRecordUI", "MMRecordUI onResume " + hashCode() + "  ");
      AppMethodBeat.o(75056);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMRecordUI", s.X("MMRecordUI onResume ", Integer.valueOf(hashCode())));
      Log.printErrStackTrace("MicroMsg.MMRecordUI", (Throwable)localException, "", new Object[0]);
      finish();
      AppMethodBeat.o(75056);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(279452);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.recordvideo.a.b.class);
    paramHashSet.add(com.tencent.mm.plugin.recordvideo.a.a.class);
    paramHashSet.addAll((Collection)((com.tencent.mm.plugin.recordvideo.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.recordvideo.a.class)).getAccessibilityConfigSet());
    AppMethodBeat.o(279452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.MMRecordUI
 * JD-Core Version:    0.7.0.1
 */