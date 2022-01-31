package com.tencent.mm.plugin.recordvideo.activity;

import a.f.b.j;
import a.o;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.s;
import com.tencent.mm.api.s.b;
import com.tencent.mm.media.widget.camerarecordview.a.b.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/activity/MMRecordUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "()V", "alive", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "controller", "Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIController;", "currentView", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "editorPhotoPluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "editorVideoPluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "mediaGenerateCallback", "Lcom/tencent/mm/plugin/recordvideo/biz/MediaGenerateShareCallback;", "recordPluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/RecordPluginLayout;", "root", "Landroid/view/ViewGroup;", "toWhere", "", "checkAndLoadCurrentLayout", "", "directGo", "fileCheck", "path", "", "finish", "getForceOrientation", "getLayoutId", "initIntentData", "Lkotlin/Pair;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setCurrentView", "view", "setWindowStyle", "toEditPicturePage", "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "toEditVideoPage", "toEditVideoPageNew", "toRecordPage", "Companion", "plugin-recordvideo_release"})
@com.tencent.mm.ui.base.a(3)
public class MMRecordUI
  extends MMActivity
  implements a
{
  public static final MMRecordUI.a qaI;
  private boolean alive;
  private ViewGroup mmr;
  private com.tencent.mm.plugin.recordvideo.a.b qaA;
  private BasePluginLayout qaB;
  private RecordPluginLayout qaC;
  private EditorVideoPluginLayoutNew qaD;
  private EditPhotoPluginLayout qaE;
  private RecordConfigProvider qaF;
  private int qaG;
  private com.tencent.mm.plugin.recordvideo.activity.a.a qaH;
  
  static
  {
    AppMethodBeat.i(150555);
    qaI = new MMRecordUI.a((byte)0);
    AppMethodBeat.o(150555);
  }
  
  public MMRecordUI()
  {
    AppMethodBeat.i(150554);
    this.qaH = new com.tencent.mm.plugin.recordvideo.activity.a.a();
    this.alive = true;
    AppMethodBeat.o(150554);
  }
  
  private final boolean XV(String paramString)
  {
    AppMethodBeat.i(150550);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      ab.e("MicroMsg.MMRecordUI", "fileCheck path is null");
      paramString = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.VY();
      setResult(1000);
      finish();
      AppMethodBeat.o(150550);
      return false;
    }
    if (e.avI(paramString) < 1L)
    {
      ab.e("MicroMsg.MMRecordUI", "fileCheck file size is 0. path: ".concat(String.valueOf(paramString)));
      paramString = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.VY();
      setResult(1001);
      finish();
      AppMethodBeat.o(150550);
      return false;
    }
    AppMethodBeat.o(150550);
    return true;
  }
  
  private final void ab(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(150542);
    ab.i("MicroMsg.MMRecordUI", "toWhere :".concat(String.valueOf(paramInt)));
    Object localObject1 = this.qaF;
    if (localObject1 == null) {
      j.ebi();
    }
    if (this.mmr == null)
    {
      localObject2 = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.Vp();
    }
    Object localObject2 = com.tencent.mm.plugin.recordvideo.d.b.qfA;
    com.tencent.mm.plugin.recordvideo.d.b.e((RecordConfigProvider)localObject1);
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.MMRecordUI", "unknown code ");
    case 0: 
    case 1: 
    case 3: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  AppMethodBeat.o(150542);
                  return;
                } while (this.qaC != null);
                localObject2 = getContext();
                j.p(localObject2, "context");
                this.qaC = new RecordPluginLayout((Context)localObject2, null, 2);
                localObject2 = this.qaC;
                if (localObject2 != null) {
                  ((RecordPluginLayout)localObject2).a((a)this, (RecordConfigProvider)localObject1);
                }
                localObject1 = this.mmr;
                if (localObject1 != null) {
                  ((ViewGroup)localObject1).addView((View)this.qaC, new ViewGroup.LayoutParams(-1, -1));
                }
              } while (!paramBoolean);
              cgh();
              AppMethodBeat.o(150542);
              return;
            } while ((!XV(((RecordConfigProvider)localObject1).qbC)) || (this.qaE != null));
            localObject2 = getContext();
            j.p(localObject2, "context");
            this.qaE = new EditPhotoPluginLayout((Context)localObject2, null, 2);
            localObject2 = this.qaE;
            if (localObject2 != null) {
              ((EditPhotoPluginLayout)localObject2).a((a)this, (RecordConfigProvider)localObject1);
            }
            localObject2 = this.mmr;
            if (localObject2 != null) {
              ((ViewGroup)localObject2).addView((View)this.qaE, new ViewGroup.LayoutParams(-1, -1));
            }
          } while (!paramBoolean);
          localObject2 = com.tencent.mm.media.widget.camerarecordview.a.b.fbr;
          localObject1 = ((RecordConfigProvider)localObject1).qbC;
          j.p(localObject1, "configProvider.inputPhotoPath");
          c(b.a.mU((String)localObject1));
          AppMethodBeat.o(150542);
          return;
        } while ((!XV(((RecordConfigProvider)localObject1).qbA)) || (this.qaD != null));
        localObject2 = getContext();
        j.p(localObject2, "context");
        this.qaD = new EditorVideoPluginLayoutNew((Context)localObject2, null, 2);
        localObject2 = this.qaD;
        if (localObject2 != null) {
          ((EditorVideoPluginLayoutNew)localObject2).a((a)this, (RecordConfigProvider)localObject1);
        }
        localObject2 = this.mmr;
        if (localObject2 != null) {
          ((ViewGroup)localObject2).addView((View)this.qaD, new ViewGroup.LayoutParams(-1, -1));
        }
      } while (!paramBoolean);
      localObject2 = com.tencent.mm.plugin.sight.base.d.Zo(((RecordConfigProvider)localObject1).qbA);
      String str = ((RecordConfigProvider)localObject1).qbA;
      j.p(str, "configProvider.inputVideoPath");
      localObject1 = ((RecordConfigProvider)localObject1).thumbPath;
      j.p(localObject1, "configProvider.thumbPath");
      b(new com.tencent.mm.media.widget.camerarecordview.a.b(str, (String)localObject1, false, ((com.tencent.mm.plugin.sight.base.a)localObject2).eVA, null, 32));
      AppMethodBeat.o(150542);
      return;
    }
    AppMethodBeat.o(150542);
  }
  
  public final void b(com.tencent.mm.media.widget.camerarecordview.a.b paramb)
  {
    AppMethodBeat.i(150548);
    j.q(paramb, "model");
    ab.i("MicroMsg.MMRecordUI", "toEditVideoPage MediaCaptureInfo:" + paramb + "  " + hashCode());
    al.d((Runnable)new MMRecordUI.c(this, paramb));
    AppMethodBeat.o(150548);
  }
  
  public final void c(com.tencent.mm.media.widget.camerarecordview.a.b paramb)
  {
    AppMethodBeat.i(150549);
    j.q(paramb, "model");
    ab.i("MicroMsg.MMRecordUI", "toEditPicturePage " + paramb + "  " + hashCode());
    al.d((Runnable)new MMRecordUI.b(this, paramb));
    AppMethodBeat.o(150549);
  }
  
  public final void cgh()
  {
    AppMethodBeat.i(150547);
    StringBuilder localStringBuilder = new StringBuilder("toRecordPage, toWhere: ").append(this.qaG).append("   ,toWhere != KEY_TO_RECORD :");
    if (this.qaG != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.MMRecordUI", bool + "  " + hashCode());
      if (this.qaG == 0) {
        break;
      }
      setResult(3001);
      finish();
      AppMethodBeat.o(150547);
      return;
    }
    al.d((Runnable)new MMRecordUI.d(this));
    AppMethodBeat.o(150547);
  }
  
  public void finish()
  {
    AppMethodBeat.i(150553);
    ab.i("MicroMsg.MMRecordUI", "finish  " + hashCode());
    super.finish();
    Object localObject = this.qaC;
    if (localObject != null) {
      ((RecordPluginLayout)localObject).release();
    }
    CaptureDataManager.qbh.a(null);
    localObject = com.tencent.mm.plugin.recordvideo.b.c.qbf;
    com.tencent.mm.plugin.recordvideo.b.c.aoR();
    if ((getIntent() != null) && (getIntent().getIntExtra("KEY_PARAMS_EXIT_ANIM", -1) != -1)) {
      overridePendingTransition(-1, getIntent().getIntExtra("KEY_PARAMS_EXIT_ANIM", -1));
    }
    AppMethodBeat.o(150553);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(150552);
    ab.i("MicroMsg.MMRecordUI", "requestCode : " + paramInt1 + " resultCode:" + paramInt2 + "  " + hashCode());
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null))
    {
      com.tencent.mm.plugin.recordvideo.a.b localb = this.qaA;
      if (localb != null)
      {
        localb.z((Context)this, paramIntent);
        AppMethodBeat.o(150552);
        return;
      }
    }
    AppMethodBeat.o(150552);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(150551);
    ab.i("MicroMsg.MMRecordUI", "onBackPressed  " + hashCode());
    BasePluginLayout localBasePluginLayout = this.qaB;
    if (localBasePluginLayout != null)
    {
      if (!localBasePluginLayout.cgq()) {
        super.onBackPressed();
      }
      AppMethodBeat.o(150551);
      return;
    }
    AppMethodBeat.o(150551);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(150541);
    ab.i("MicroMsg.MMRecordUI", "MMRecordUI onCreate  " + hashCode());
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.jm(true);
    getWindow().setFormat(-3);
    this.mmr = ((ViewGroup)findViewById(16908290));
    paramBundle = (RecordConfigProvider)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    int i = getIntent().getIntExtra("KEY_PARAMS_TO_WHERE", 0);
    int k;
    switch (getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1))
    {
    default: 
      ab.i("MicroMsg.MMRecordUI", "onCreate configProvider : " + paramBundle + "    toWhere:" + i);
      localObject = new o(paramBundle, Integer.valueOf(i));
      paramBundle = (RecordConfigProvider)((o)localObject).first;
      k = ((Number)((o)localObject).second).intValue();
      if (paramBundle == null) {
        i = 2000;
      }
      break;
    }
    for (;;)
    {
      ab.i("MicroMsg.MMRecordUI", " checkConfigProvider:  ".concat(String.valueOf(i)));
      if (i == 999) {
        break label395;
      }
      setResult(i);
      finish();
      AppMethodBeat.o(150541);
      return;
      CaptureDataManager.qbh.a((CaptureDataManager.b)new com.tencent.mm.plugin.recordvideo.a.a());
      break;
      this.qaA = new com.tencent.mm.plugin.recordvideo.a.b((Context)this);
      CaptureDataManager.qbh.a((CaptureDataManager.b)this.qaA);
      break;
      if (k == 3)
      {
        localObject = paramBundle.qbA;
        j.p(localObject, "configProvider.inputVideoPath");
        int j = com.tencent.mm.plugin.recordvideo.activity.a.a.XW((String)localObject);
        i = j;
        if (j == 999)
        {
          localObject = paramBundle.qbA;
          j.p(localObject, "configProvider.inputVideoPath");
          j = com.tencent.mm.plugin.recordvideo.activity.a.a.XX((String)localObject);
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
    this.qaF = paramBundle;
    this.qaG = k;
    ab(k, true);
    ab.i("MicroMsg.MMRecordUI", "MMRecordUI onCreate finish");
    Object localObject = com.tencent.mm.plugin.recordvideo.c.b.qfu;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.qbE;; paramBundle = null)
    {
      com.tencent.mm.plugin.recordvideo.c.b.a(paramBundle);
      paramBundle = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_NET_TYPE_INT", Long.valueOf(at.gV((Context)getContext())));
      paramBundle = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ENTER_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(150541);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(150546);
    ab.i("MicroMsg.MMRecordUI", "MMRecordUI onDestroy " + hashCode());
    super.onDestroy();
    Object localObject1 = this.qaD;
    if (localObject1 != null) {
      ((EditorVideoPluginLayoutNew)localObject1).release();
    }
    localObject1 = this.qaE;
    if (localObject1 != null) {
      ((EditPhotoPluginLayout)localObject1).release();
    }
    localObject1 = this.qaC;
    if (localObject1 != null) {
      ((RecordPluginLayout)localObject1).release();
    }
    if ((this.qaB instanceof RecordPluginLayout))
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.c.b.qfu;
    localObject1 = new com.tencent.mm.g.b.a.l();
    Object localObject2 = com.tencent.mm.plugin.recordvideo.c.b.cgB();
    Object localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_NET_TYPE_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_NET_TYPE_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).aL(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_FROM_SCENE_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_FROM_SCENE_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).aM(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_ENTER_TIME_MS_LONG", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_ENTER_TIME_MS_LONG,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).aN(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_EXIT_TIME_MS_LONG", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_EXIT_TIME_MS_LONG,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).aO(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_MEDIA_SOURCE_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_MEDIA_SOURCE_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).aP(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_MEDIA_TYPE_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_MEDIA_TYPE_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).aQ(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_START_RECORD_MS_LONG", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_START_RECORD_MS_LONG,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).aR(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_…EDIA_DURATION_MS_LONG,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).aS(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_ORIGIN_MEDIA_WIDTH_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_ORIGIN_MEDIA_WIDTH_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).aT(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_ORIGIN_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_…IGIN_MEDIA_HEIGHT_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).aU(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_ENTER_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).aV(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_EXIT_CROP_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_…ROP_PAGE_TIME_MS_LONG,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).aW(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_…DIT_PAGE_TIME_MS_LONG,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).aX(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_CLICK_EMOJI_COUNT_INT", Long.valueOf(0L));
    j.p(localObject3, "info.getReportValue(KEY_CLICK_EMOJI_COUNT_INT,0)");
    ((com.tencent.mm.g.b.a.l)localObject1).aY(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_ADD_EMOJI_COUNT_INT", Long.valueOf(0L));
    j.p(localObject3, "info.getReportValue(KEY_ADD_EMOJI_COUNT_INT,0)");
    ((com.tencent.mm.g.b.a.l)localObject1).aZ(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_CLICK_TEXT_COUNT_INT", Long.valueOf(0L));
    j.p(localObject3, "info.getReportValue(KEY_CLICK_TEXT_COUNT_INT,0)");
    ((com.tencent.mm.g.b.a.l)localObject1).ba(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_ADD_TEXT_COUNT_INT", Long.valueOf(0L));
    j.p(localObject3, "info.getReportValue(KEY_ADD_TEXT_COUNT_INT,0)");
    ((com.tencent.mm.g.b.a.l)localObject1).bb(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_CLICK_DOODLE_COUNT_INT", Long.valueOf(0L));
    j.p(localObject3, "info.getReportValue(KEY_CLICK_DOODLE_COUNT_INT,0)");
    ((com.tencent.mm.g.b.a.l)localObject1).bc(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_ADD_DOODLE_COUNT_INT", Long.valueOf(0L));
    j.p(localObject3, "info.getReportValue(KEY_ADD_DOODLE_COUNT_INT,0)");
    ((com.tencent.mm.g.b.a.l)localObject1).bd(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_ADD_DOODLE_COLOR_COUNT_INT", Long.valueOf(0L));
    j.p(localObject3, "info.getReportValue(KEY_…DOODLE_COLOR_COUNT_INT,0)");
    ((com.tencent.mm.g.b.a.l)localObject1).be(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_CLICK_MOSAIC_COUNT_INT", Long.valueOf(0L));
    j.p(localObject3, "info.getReportValue(KEY_CLICK_MOSAIC_COUNT_INT,0)");
    ((com.tencent.mm.g.b.a.l)localObject1).bf(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_CLICK_BRUSH_COUNT_INT", Long.valueOf(0L));
    j.p(localObject3, "info.getReportValue(KEY_CLICK_BRUSH_COUNT_INT,0)");
    ((com.tencent.mm.g.b.a.l)localObject1).bg(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_ADD_MOSAIC_COUNT_INT", Long.valueOf(0L));
    j.p(localObject3, "info.getReportValue(KEY_ADD_MOSAIC_COUNT_INT,0)");
    ((com.tencent.mm.g.b.a.l)localObject1).bh(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_CLICK_CROP_COUNT_INT", Long.valueOf(0L));
    j.p(localObject3, "info.getReportValue(KEY_CLICK_CROP_COUNT_INT,0)");
    ((com.tencent.mm.g.b.a.l)localObject1).bi(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_CROP_MEDIA_HEIGHT_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_CROP_MEDIA_HEIGHT_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).bk(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_CROP_MEDIA_WIDTH_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_CROP_MEDIA_WIDTH_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).bj(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_ROTATE_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_ROTATE_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).bl(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_CLICK_MUSIC_COUNT_INT", Long.valueOf(0L));
    j.p(localObject3, "info.getReportValue(KEY_CLICK_MUSIC_COUNT_INT,0)");
    ((com.tencent.mm.g.b.a.l)localObject1).bm(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_MUSIC_ID_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_MUSIC_ID_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).bn(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_MUSIC_INDEX_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_MUSIC_INDEX_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).bo(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_SELECT_MUSIC_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_SELECT_MUSIC_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).bp(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_SELECT_ORIGIN_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_SELECT_ORIGIN_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).bq(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_MUSIC_REQ_ID_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_MUSIC_REQ_ID_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).br(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_SEARCH_MUSIC_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_SEARCH_MUSIC_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).bs(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_CLICK_VIDEO_CROP_COUNT_INT", Long.valueOf(0L));
    j.p(localObject3, "info.getReportValue(KEY_…K_VIDEO_CROP_COUNT_INT,0)");
    ((com.tencent.mm.g.b.a.l)localObject1).bt(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_VIDEO_CROP_DURATION_MS_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_…_CROP_DURATION_MS_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).bu(((Number)localObject3).longValue());
    localObject3 = ((RecordMediaReportInfo)localObject2).q("KEY_AFTER_EDIT_INT", Long.valueOf(-1L));
    j.p(localObject3, "info.getReportValue(KEY_AFTER_EDIT_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).bv(((Number)localObject3).longValue());
    localObject2 = ((RecordMediaReportInfo)localObject2).q("KEY_EDIT_PUBLISHID_INT", Long.valueOf(-1L));
    j.p(localObject2, "info.getReportValue(KEY_EDIT_PUBLISHID_INT,-1)");
    ((com.tencent.mm.g.b.a.l)localObject1).bw(((Number)localObject2).longValue());
    ((com.tencent.mm.g.b.a.l)localObject1).ff(com.tencent.mm.plugin.recordvideo.c.b.qft.cgA());
    ((com.tencent.mm.g.b.a.l)localObject1).ake();
    if (getIntent().getIntExtra("KEY_PARAMS_SELECTED_BIZ_INT", -1) == 2) {
      s.bWe.Ab().Aa();
    }
    AppMethodBeat.o(150546);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(150545);
    Object localObject = new StringBuilder("MMRecordUI onPause  isFinishing  : ").append(isFinishing()).append("  ").append(hashCode()).append("  currentView:");
    if (this.qaB == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.MMRecordUI", bool);
      super.onPause();
      this.alive = false;
      if (!isFinishing()) {
        break;
      }
      AppMethodBeat.o(150545);
      return;
    }
    localObject = this.qaB;
    if (localObject != null)
    {
      ((BasePluginLayout)localObject).onPause();
      AppMethodBeat.o(150545);
      return;
    }
    AppMethodBeat.o(150545);
  }
  
  public void onResume()
  {
    boolean bool = true;
    AppMethodBeat.i(150544);
    try
    {
      super.onResume();
      Object localObject = this.qaB;
      if (localObject != null) {
        ((BasePluginLayout)localObject).onResume();
      }
      this.alive = true;
      localObject = new StringBuilder("MMRecordUI onResume ").append(hashCode()).append("  currentView:");
      if (this.qaB == null) {}
      for (;;)
      {
        ab.i("MicroMsg.MMRecordUI", bool);
        AppMethodBeat.o(150544);
        return;
        bool = false;
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMRecordUI", "MMRecordUI onResume " + hashCode());
      ab.printErrStackTrace("MicroMsg.MMRecordUI", (Throwable)localException, "", new Object[0]);
      finish();
      AppMethodBeat.o(150544);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.activity.MMRecordUI
 * JD-Core Version:    0.7.0.1
 */