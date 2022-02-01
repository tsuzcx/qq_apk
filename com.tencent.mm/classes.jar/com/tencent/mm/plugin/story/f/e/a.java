package com.tencent.mm.plugin.story.f.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.Image2VideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.recordvideo.ui.editor.d;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.c.a.g.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.ui.StoryCaptureUI;
import com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.ao;
import d.g.b.k;
import d.v;
import d.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/mix/StoryMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "TAG", "", "remuxTaskMap", "Ljava/util/HashMap;", "", "getRemuxTaskMap", "()Ljava/util/HashMap;", "cleanNullData", "", "taskId", "cleanUnAvailableData", "data", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "commit", "storyEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "thumbPath", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "onFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "retId", "videoPath", "extraBundle", "Landroid/os/Bundle;", "mediaDes", "resId", "genStoryEditorReportInfo", "videoEditData", "getEditDataByLocalId", "localId", "getEditDataByTaskId", "getFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "context", "Landroid/content/Context;", "getImageFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onFinishBtnClick", "extData", "controller", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onInit", "onMediaGenerated", "onRun", "runNum", "onWait", "remuxMedia", "startStoryCapture", "entranceScene", "videoObjectId", "", "updateByTaskId", "editorData", "plugin-story_release"})
public final class a
  implements com.tencent.mm.plugin.recordvideo.background.b, CaptureDataManager.b
{
  private static final HashMap<Integer, String> zuW;
  public static final a zuX;
  
  static
  {
    AppMethodBeat.i(118965);
    Object localObject = new a();
    zuX = (a)localObject;
    zuW = new HashMap();
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.wme;
    com.tencent.mm.plugin.recordvideo.background.a.a(3, (com.tencent.mm.plugin.recordvideo.background.b)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.background.a.wme;
    com.tencent.mm.plugin.recordvideo.background.a.a(6, (com.tencent.mm.plugin.recordvideo.background.b)b.zve);
    AppMethodBeat.o(118965);
  }
  
  public static com.tencent.mm.plugin.recordvideo.background.e Qw(int paramInt)
  {
    AppMethodBeat.i(118958);
    Object localObject2 = (String)zuW.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    k.g(localObject1, "remuxTaskMap[localId] ?: \"\"");
    localObject2 = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    localObject1 = com.tencent.mm.plugin.recordvideo.background.g.aqy((String)localObject1);
    AppMethodBeat.o(118958);
    return localObject1;
  }
  
  public static void a(com.tencent.mm.plugin.recordvideo.background.e parame, final String paramString, final ddx paramddx, final d.g.a.b<? super Integer, y> paramb)
  {
    AppMethodBeat.i(118955);
    k.h(parame, "storyEditorData");
    k.h(paramString, "thumbPath");
    k.h(paramddx, "editorInfo");
    k.h(paramb, "onFinish");
    com.tencent.mm.ac.c.b("StoryCapture_commit", (d.g.a.a)new a(parame, paramString, paramddx, paramb));
    AppMethodBeat.o(118955);
  }
  
  public static void aqA(String paramString)
  {
    AppMethodBeat.i(118959);
    k.h(paramString, "taskId");
    ac.i("MicroMsg.StoryMixManager", "run cleanNullData data");
    com.tencent.mm.plugin.recordvideo.background.g localg = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    com.tencent.mm.plugin.recordvideo.background.g.aqA(paramString);
    AppMethodBeat.o(118959);
  }
  
  public static void aqB(String paramString)
  {
    AppMethodBeat.i(118960);
    k.h(paramString, "taskId");
    ac.i("MicroMsg.StoryMixManager", "run cleanUnAvailableData data");
    com.tencent.mm.plugin.recordvideo.background.g localg = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    com.tencent.mm.plugin.recordvideo.background.g.aqB(paramString);
    AppMethodBeat.o(118960);
  }
  
  public static void awM(String paramString)
  {
    AppMethodBeat.i(118956);
    k.h(paramString, "taskId");
    com.tencent.mm.plugin.recordvideo.background.g localg = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    com.tencent.mm.plugin.recordvideo.background.g.aqC(paramString);
    AppMethodBeat.o(118956);
  }
  
  private static ddx d(com.tencent.mm.plugin.recordvideo.background.e parame)
  {
    AppMethodBeat.i(118954);
    ddx localddx = new ddx();
    adp localadp = new adp();
    Object localObject1 = (com.tencent.mm.bw.a)localadp;
    parame = parame.field_baseItemData;
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom(parame);
      parame = localadp.Esi;
      k.g(parame, "editProtoData.baseItemData");
      parame = ((Iterable)parame).iterator();
      for (;;)
      {
        if (!parame.hasNext()) {
          break label255;
        }
        localObject1 = (it)parame.next();
        i = ((it)localObject1).dataType;
        if (i != com.tencent.mm.media.editor.a.e.gPo.value) {
          break;
        }
        localObject2 = new dgz();
        ((dgz)localObject2).parseFrom(z.a(((it)localObject1).DWE));
        localddx.FNE.add(((dgz)localObject2).text.toString());
      }
    }
    catch (Exception parame)
    {
      for (;;)
      {
        int i;
        Object localObject2;
        ac.l("safeParser", "", new Object[] { parame });
        continue;
        if (i == com.tencent.mm.media.editor.a.e.gPp.value)
        {
          localObject2 = new adt();
          ((adt)localObject2).parseFrom(z.a(((it)localObject1).DWE));
          localddx.FND.add(((adt)localObject2).md5);
        }
        else if (i == com.tencent.mm.media.editor.a.e.gPr.value)
        {
          localObject2 = new dgz();
          ((dgz)localObject2).parseFrom(z.a(((it)localObject1).DWE));
          localddx.Bof = ((dgz)localObject2).text.toString();
        }
      }
    }
    label255:
    if (bs.isNullOrNil(localadp.gUk)) {
      localddx.FNC = false;
    }
    for (;;)
    {
      AppMethodBeat.o(118954);
      return localddx;
      localddx.FNC = true;
      localddx.wri = localadp.wri;
      localddx.Ewn = localadp.Ewn;
      localddx.FNB = localadp.Ewo;
    }
  }
  
  public static HashMap<Integer, String> dWB()
  {
    return zuW;
  }
  
  public static void dWC()
  {
    AppMethodBeat.i(118957);
    com.tencent.mm.plugin.recordvideo.background.g localg = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    com.tencent.mm.plugin.recordvideo.background.g.duw();
    AppMethodBeat.o(118957);
  }
  
  public static FakeVideoViewLayer gr(Context paramContext)
  {
    AppMethodBeat.i(118962);
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.wme;
    paramContext = com.tencent.mm.plugin.recordvideo.background.a.fT(paramContext);
    AppMethodBeat.o(118962);
    return paramContext;
  }
  
  public static d gs(Context paramContext)
  {
    AppMethodBeat.i(118963);
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.wme;
    paramContext = com.tencent.mm.plugin.recordvideo.background.a.fU(paramContext);
    AppMethodBeat.o(118963);
    return paramContext;
  }
  
  public final void a(Context paramContext, final CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(118964);
    ac.i("MicroMsg.StoryMixManager", "onMediaGenerated model:" + paramCaptureVideoNormalModel + ", extData:" + paramBundle);
    Object localObject;
    if ((paramBundle != null) && (paramBundle.getBoolean("key_bg_generate") == true) && (paramBundle.getByteArray("key_bg_generate_pb") != null))
    {
      paramCaptureVideoNormalModel = new afq().parseFrom(paramBundle.getByteArray("key_bg_generate_extra_config"));
      paramContext = (VideoMixer.MixConfig)paramBundle.getParcelable("key_bg_generate_mix_config");
      localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      paramBundle = paramBundle.getByteArray("key_bg_generate_pb");
      k.g(paramBundle, "extData.getByteArray(KEY_BG_GENERATE_PB)");
      k.g(paramContext, "mixConfig");
      paramCaptureVideoNormalModel = paramCaptureVideoNormalModel.toByteArray();
      k.g(paramCaptureVideoNormalModel, "extraConfig.toByteArray()");
      com.tencent.mm.plugin.recordvideo.background.g.a(paramBundle, paramContext, paramCaptureVideoNormalModel);
      AppMethodBeat.o(118964);
      return;
    }
    String str;
    if (paramCaptureVideoNormalModel != null)
    {
      str = paramCaptureVideoNormalModel.getVideoPath();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    if (paramCaptureVideoNormalModel != null)
    {
      str = paramCaptureVideoNormalModel.auN();
      paramCaptureVideoNormalModel = str;
      if (str != null) {}
    }
    else
    {
      paramCaptureVideoNormalModel = "";
    }
    if (paramBundle == null)
    {
      AppMethodBeat.o(118964);
      return;
    }
    com.tencent.mm.ac.c.b("StoryCapture_commit", (d.g.a.a)new b(new Bundle(paramBundle), (String)localObject, paramCaptureVideoNormalModel, "", (d.g.a.b)a.d.zvd));
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(118964);
      throw paramContext;
    }
    ((Activity)paramContext).setResult(-1);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(118964);
  }
  
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(118953);
    k.h(paramString, "taskId");
    ac.i("MicroMsg.StoryMixManager", "onFinish, success:" + paramBoolean + " taskId:" + paramString);
    Object localObject1 = zuW.entrySet();
    k.g(localObject1, "remuxTaskMap.entries");
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (!bs.lr((String)((Map.Entry)localObject2).getValue(), paramString)) {
        break label381;
      }
      localObject2 = ((Map.Entry)localObject2).getKey();
      k.g(localObject2, "it.key");
      i = ((Number)localObject2).intValue();
      ac.i("MicroMsg.StoryMixManager", "found localId:".concat(String.valueOf(i)));
    }
    label378:
    label381:
    for (;;)
    {
      break;
      if (paramBoolean)
      {
        zuW.remove(Integer.valueOf(i));
        if (paramCaptureVideoNormalModel != null)
        {
          paramString = paramCaptureVideoNormalModel.getVideoPath();
          if (paramString != null) {
            break label378;
          }
        }
        paramString = "";
      }
      for (;;)
      {
        if (paramCaptureVideoNormalModel != null)
        {
          localObject2 = paramCaptureVideoNormalModel.auN();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localObject2 = com.tencent.mm.plugin.story.g.j.zyu;
        com.tencent.mm.plugin.story.g.j.e(i, paramString, (String)localObject1);
        paramString = com.tencent.mm.plugin.story.f.j.zsh;
        j.b.dVK().dWX();
        if (paramCaptureVideoNormalModel != null)
        {
          paramString = paramCaptureVideoNormalModel.dvk();
          if (paramString != null)
          {
            paramBoolean = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUm, true);
            paramCaptureVideoNormalModel = paramString.x("KEY_IS_CAPUTRE_BOOLEAN", Boolean.FALSE);
            k.g(paramCaptureVideoNormalModel, "getReportValue(RecordMed…IS_CAPUTRE_BOOLEAN,false)");
            if ((((Boolean)paramCaptureVideoNormalModel).booleanValue()) && (paramBoolean))
            {
              paramCaptureVideoNormalModel = com.tencent.mm.plugin.recordvideo.e.b.wDE;
              com.tencent.mm.plugin.recordvideo.e.b.anu((String)paramString.x("KEY_CAPUTRE_VIDEO_PATH_STRING", ""));
              paramCaptureVideoNormalModel = com.tencent.mm.plugin.recordvideo.e.b.wDE;
              com.tencent.mm.plugin.recordvideo.e.b.anu((String)paramString.x("KEY_CAPUTRE_THUMB_PATH_STRING", ""));
            }
            AppMethodBeat.o(118953);
            return;
          }
        }
        AppMethodBeat.o(118953);
        return;
        paramString = com.tencent.mm.plugin.story.h.f.zAv;
        com.tencent.mm.plugin.story.h.f.dww();
        paramString = com.tencent.mm.plugin.story.g.j.zyu;
        com.tencent.mm.plugin.story.g.j.QE(i);
        AppMethodBeat.o(118953);
        return;
      }
    }
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final void ahm(String paramString)
  {
    AppMethodBeat.i(118950);
    k.h(paramString, "taskId");
    ac.i("MicroMsg.StoryMixManager", "onInit, taskId:".concat(String.valueOf(paramString)));
    Object localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    localObject = com.tencent.mm.plugin.recordvideo.background.g.aqy(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(118950);
      return;
    }
    String str = ((com.tencent.mm.plugin.recordvideo.background.e)localObject).dui().thumbPath;
    ddx localddx = d((com.tencent.mm.plugin.recordvideo.background.e)localObject);
    final com.tencent.mm.media.j.a locala = new com.tencent.mm.media.j.a("runMixInBackground");
    k.g(str, "thumbPath");
    a((com.tencent.mm.plugin.recordvideo.background.e)localObject, str, localddx, (d.g.a.b)new c(paramString, locala));
    AppMethodBeat.o(118950);
  }
  
  public final void ahn(String paramString)
  {
    AppMethodBeat.i(118952);
    k.h(paramString, "taskId");
    ac.i("MicroMsg.StoryMixManager", "onWait, taskId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(118952);
  }
  
  public final void dx(String paramString, int paramInt)
  {
    AppMethodBeat.i(118951);
    k.h(paramString, "taskId");
    ac.i("MicroMsg.StoryMixManager", "onRun, taskId:" + paramString + " runNum:" + paramInt);
    AppMethodBeat.o(118951);
  }
  
  public final void startStoryCapture(Context paramContext, int paramInt, long paramLong)
  {
    AppMethodBeat.i(118961);
    if ((com.tencent.mm.plugin.voip.f.cg(paramContext)) || (com.tencent.mm.plugin.voip.f.ci(paramContext)) || (com.tencent.mm.bh.e.cf(paramContext)) || (com.tencent.mm.r.a.ck(paramContext)))
    {
      ac.i("MicroMsg.StoryMixManager", "startStoryCapture, voip or multitalk running");
      AppMethodBeat.o(118961);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)paramContext, "android.permission.CAMERA", 24, "", ""))
      {
        AppMethodBeat.o(118961);
        return;
      }
      if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)paramContext, "android.permission.RECORD_AUDIO", 24, "", ""))
      {
        AppMethodBeat.o(118961);
        return;
      }
      if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)paramContext, "android.permission.ACCESS_COARSE_LOCATION", 78, "", ""))
      {
        AppMethodBeat.o(118961);
        return;
      }
    }
    ac.i("MicroMsg.StoryMixManager", "startStoryCapture %s", new Object[] { bs.eWi().toString() });
    boolean bool;
    if (com.tencent.mm.plugin.story.c.a.e.zqS.dUI())
    {
      localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "storage()");
      bool = ((com.tencent.mm.kernel.e)localObject).agA().getBoolean(ah.a.GSM, false);
    }
    while (!bool)
    {
      localObject = new Intent(paramContext, StoryCaptureUI.class);
      ((Intent)localObject).putExtra("jump_page_from", paramInt);
      ((Intent)localObject).putExtra("video_object_id", paramLong);
      if (paramContext != null)
      {
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(118961);
        return;
        localObject = com.tencent.mm.kernel.g.agR();
        k.g(localObject, "storage()");
        bool = ((com.tencent.mm.kernel.e)localObject).agA().getBoolean(ah.a.GSL, false);
      }
      else
      {
        AppMethodBeat.o(118961);
        return;
      }
    }
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.a("", "", ((c.a)com.tencent.mm.plugin.story.c.a.c.zqE.aqp()).wqt, ((c.a)com.tencent.mm.plugin.story.c.a.c.zqE.aqp()).wqt.duration * 1000, 3);
    Object localObject = com.tencent.mm.plugin.story.f.j.zsh;
    if (j.b.dVO() == g.a.zqY)
    {
      bool = true;
      localRecordConfigProvider.wqA = Boolean.valueOf(bool);
      localRecordConfigProvider.wqD = true;
      UICustomParam.a locala = new UICustomParam.a();
      int i = ao.fromDPToPix(paramContext, 48);
      if (paramContext == null) {
        break label748;
      }
      localObject = paramContext.getString(2131764253);
      label457:
      locala.a(2131234264, 2131101185, (String)localObject, i);
      locala.cM(true);
      locala.lc(Color.parseColor("#0E9CE6"));
      localRecordConfigProvider.wqu = locala.Za();
      localRecordConfigProvider.wqB = Boolean.TRUE;
      localRecordConfigProvider.wqy = Boolean.FALSE;
      localRecordConfigProvider.wqL = 86400000L;
      localRecordConfigProvider.wqM = false;
      localRecordConfigProvider.wqw = 1;
      localRecordConfigProvider.wqN = true;
      localRecordConfigProvider.wqO = true;
      localObject = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject).qwN = 7;
      ((VideoCaptureReportInfo)localObject).plW = paramInt;
      ((VideoCaptureReportInfo)localObject).wqS = paramLong;
      localRecordConfigProvider.wqK = ((VideoCaptureReportInfo)localObject);
      localRecordConfigProvider.wqx = Boolean.TRUE;
      bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUC, false);
      localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "storage()");
      if ((((com.tencent.mm.kernel.e)localObject).agA().getInt(ah.a.GQK, 0) != 1) && (!bool)) {
        break label754;
      }
      paramInt = 1;
      label649:
      localRecordConfigProvider.D(1, Image2VideoPluginLayout.class.getName());
      if (paramInt == 0) {
        break label759;
      }
      localRecordConfigProvider.D(3, VLogPreviewPluginLayout.class.getName());
      localRecordConfigProvider.D(4, VLogPreviewPluginLayout.class.getName());
    }
    for (;;)
    {
      CaptureDataManager.wqi.a((CaptureDataManager.b)this);
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTO, true))
      {
        localObject = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(paramContext, 0, -1, -1, localRecordConfigProvider);
      }
      AppMethodBeat.o(118961);
      return;
      bool = false;
      break;
      label748:
      localObject = null;
      break label457;
      label754:
      paramInt = 0;
      break label649;
      label759:
      localRecordConfigProvider.D(3, Image2VideoPluginLayout.class.getName());
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(com.tencent.mm.plugin.recordvideo.background.e parame, String paramString, ddx paramddx, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(Bundle paramBundle, String paramString1, String paramString2, String paramString3, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "storyLocalId", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Integer, y>
  {
    c(String paramString, com.tencent.mm.media.j.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.e.a
 * JD-Core Version:    0.7.0.1
 */