package com.tencent.mm.plugin.story.model.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
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
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.c.a.g.a;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.ui.StoryCaptureUI;
import com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.fir;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.bd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/mix/StoryMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "TAG", "", "remuxTaskMap", "Ljava/util/HashMap;", "", "getRemuxTaskMap", "()Ljava/util/HashMap;", "cleanNullData", "", "taskId", "cleanUnAvailableData", "data", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "commit", "storyEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "thumbPath", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "onFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "retId", "videoPath", "extraBundle", "Landroid/os/Bundle;", "mediaDes", "resId", "genStoryEditorReportInfo", "videoEditData", "getEditDataByLocalId", "localId", "getEditDataByTaskId", "getFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "context", "Landroid/content/Context;", "getImageFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "onEditFinish", "forward", "", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "success", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onFinishBtnClick", "controller", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onInit", "onMediaGenerated", "onRun", "runNum", "onWait", "remuxMedia", "startStoryCapture", "entranceScene", "videoObjectId", "", "updateByTaskId", "editorData", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.recordvideo.background.b, CaptureDataManager.b
{
  public static final a SmE;
  private static final HashMap<Integer, String> SmF;
  
  static
  {
    AppMethodBeat.i(118965);
    SmE = new a();
    SmF = new HashMap();
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.NDM;
    com.tencent.mm.plugin.recordvideo.background.a.a(3, (com.tencent.mm.plugin.recordvideo.background.b)SmE);
    locala = com.tencent.mm.plugin.recordvideo.background.a.NDM;
    com.tencent.mm.plugin.recordvideo.background.a.a(6, (com.tencent.mm.plugin.recordvideo.background.b)b.SmN);
    AppMethodBeat.o(118965);
  }
  
  public static void a(com.tencent.mm.plugin.recordvideo.background.c paramc, final String paramString, final fir paramfir, final kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(118955);
    s.u(paramc, "storyEditorData");
    s.u(paramString, "thumbPath");
    s.u(paramfir, "editorInfo");
    s.u(paramb, "onFinish");
    com.tencent.mm.ae.d.d("StoryCapture_commit", (kotlin.g.a.a)new a(paramc, paramString, paramfir, paramb));
    AppMethodBeat.o(118955);
  }
  
  public static void aSR(String paramString)
  {
    AppMethodBeat.i(118959);
    s.u(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "run cleanNullData data");
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.NDU;
    com.tencent.mm.plugin.recordvideo.background.e.aSR(paramString);
    AppMethodBeat.o(118959);
  }
  
  public static void aSS(String paramString)
  {
    AppMethodBeat.i(118960);
    s.u(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "run cleanUnAvailableData data");
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.NDU;
    com.tencent.mm.plugin.recordvideo.background.e.aSS(paramString);
    AppMethodBeat.o(118960);
  }
  
  public static com.tencent.mm.plugin.recordvideo.background.c and(int paramInt)
  {
    AppMethodBeat.i(118958);
    Object localObject2 = (String)SmF.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
    localObject1 = com.tencent.mm.plugin.recordvideo.background.e.aSP((String)localObject1);
    AppMethodBeat.o(118958);
    return localObject1;
  }
  
  public static void bbV(String paramString)
  {
    AppMethodBeat.i(118956);
    s.u(paramString, "taskId");
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.NDU;
    com.tencent.mm.plugin.recordvideo.background.e.aST(paramString);
    AppMethodBeat.o(118956);
  }
  
  private static fir d(com.tencent.mm.plugin.recordvideo.background.c paramc)
  {
    AppMethodBeat.i(118954);
    fir localfir = new fir();
    ami localami = new ami();
    Object localObject = (com.tencent.mm.bx.a)localami;
    paramc = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bx.a)localObject).parseFrom(paramc);
      paramc = localami.Znd;
      s.s(paramc, "editProtoData.baseItemData");
      paramc = ((Iterable)paramc).iterator();
      for (;;)
      {
        if (!paramc.hasNext()) {
          break label247;
        }
        localObject = (jy)paramc.next();
        i = ((jy)localObject).dataType;
        if (i != com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYd.value) {
          break;
        }
        LinkedList localLinkedList = localfir.abJA;
        s.s(localObject, "it");
        localLinkedList.add(String.valueOf(new r((jy)localObject).bba));
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        int i;
        Log.printDebugStack("safeParser", "", new Object[] { paramc });
        continue;
        if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYe.value)
        {
          s.s(localObject, "it");
          localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jy)localObject).mgK;
          if (localObject != null) {
            localfir.abJz.add(((EmojiInfo)localObject).getMd5());
          }
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYg.value)
        {
          s.s(localObject, "it");
          localfir.VpP = String.valueOf(new r((jy)localObject).bba);
        }
      }
    }
    label247:
    if (Util.isNullOrNil(localami.nBT)) {
      localfir.abJy = false;
    }
    for (;;)
    {
      AppMethodBeat.o(118954);
      return localfir;
      localfir.abJy = true;
      localfir.NID = localami.NID;
      localfir.Ztm = localami.Ztm;
      localfir.abJx = localami.Ztn;
    }
  }
  
  public static HashMap<Integer, String> hwO()
  {
    return SmF;
  }
  
  public static void hwP()
  {
    AppMethodBeat.i(118957);
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.NDU;
    com.tencent.mm.plugin.recordvideo.background.e.gGQ();
    AppMethodBeat.o(118957);
  }
  
  public static FakeVideoViewLayer kb(Context paramContext)
  {
    AppMethodBeat.i(118962);
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.NDM;
    paramContext = com.tencent.mm.plugin.recordvideo.background.a.jo(paramContext);
    AppMethodBeat.o(118962);
    return paramContext;
  }
  
  public static com.tencent.mm.plugin.recordvideo.ui.editor.e kc(Context paramContext)
  {
    AppMethodBeat.i(118963);
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.NDM;
    paramContext = com.tencent.mm.plugin.recordvideo.background.a.jp(paramContext);
    AppMethodBeat.o(118963);
    return paramContext;
  }
  
  public final void a(Context paramContext, final CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(118964);
    Log.i("MicroMsg.StoryMixManager", "onMediaGenerated model:" + paramCaptureVideoNormalModel + ", extData:" + paramBundle);
    if ((paramBundle != null) && (paramBundle.getBoolean("key_bg_generate") == true)) {}
    Object localObject;
    while ((i != 0) && (paramBundle.getByteArray("key_bg_generate_pb") != null))
    {
      paramCaptureVideoNormalModel = new apw().parseFrom(paramBundle.getByteArray("key_bg_generate_extra_config"));
      paramContext = (VideoMixer.MixConfig)paramBundle.getParcelable("key_bg_generate_mix_config");
      localObject = com.tencent.mm.plugin.recordvideo.background.e.NDU;
      paramBundle = paramBundle.getByteArray("key_bg_generate_pb");
      s.checkNotNull(paramBundle);
      s.s(paramBundle, "extData.getByteArray(KEY_BG_GENERATE_PB)!!");
      s.checkNotNull(paramContext);
      paramCaptureVideoNormalModel = paramCaptureVideoNormalModel.toByteArray();
      s.s(paramCaptureVideoNormalModel, "extraConfig.toByteArray()");
      com.tencent.mm.plugin.recordvideo.background.e.a(paramBundle, paramContext, paramCaptureVideoNormalModel);
      AppMethodBeat.o(118964);
      return;
      i = 0;
    }
    if (paramCaptureVideoNormalModel == null)
    {
      localObject = "";
      if (paramCaptureVideoNormalModel != null) {
        break label208;
      }
      paramCaptureVideoNormalModel = "";
    }
    for (;;)
    {
      if (paramBundle != null) {
        break label228;
      }
      AppMethodBeat.o(118964);
      return;
      String str = paramCaptureVideoNormalModel.videoPath;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label208:
      str = paramCaptureVideoNormalModel.thumbPath;
      paramCaptureVideoNormalModel = str;
      if (str == null) {
        paramCaptureVideoNormalModel = "";
      }
    }
    label228:
    com.tencent.mm.ae.d.d("StoryCapture_commit", (kotlin.g.a.a)new b(new Bundle(paramBundle), (String)localObject, paramCaptureVideoNormalModel, "", (kotlin.g.a.b)a.d.SmM));
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(118964);
      throw paramContext;
    }
    ((Activity)paramContext).setResult(-1);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(118964);
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle)
  {
    AppMethodBeat.i(367164);
    s.u(paramRecordMediaReportInfo, "reportInfo");
    s.u(paramBundle, "extData");
    AppMethodBeat.o(367164);
  }
  
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(118953);
    s.u(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "onFinish, success:" + paramBoolean + " taskId:" + paramString);
    Object localObject1 = SmF.entrySet();
    s.s(localObject1, "remuxTaskMap.entries");
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (Util.isEqual((String)((Map.Entry)localObject2).getValue(), paramString))
      {
        localObject2 = ((Map.Entry)localObject2).getKey();
        s.s(localObject2, "it.key");
        i = ((Number)localObject2).intValue();
        Log.i("MicroMsg.StoryMixManager", s.X("found localId:", Integer.valueOf(i)));
      }
    }
    if (paramBoolean)
    {
      SmF.remove(Integer.valueOf(i));
      if (paramCaptureVideoNormalModel == null)
      {
        paramString = "";
        if (paramCaptureVideoNormalModel != null) {
          break label342;
        }
        localObject1 = "";
      }
      for (;;)
      {
        localObject2 = j.SpD;
        j.h(i, paramString, (String)localObject1);
        paramString = StoryCore.SjP;
        StoryCore.b.hvX().hxj();
        if (paramCaptureVideoNormalModel == null) {
          break label380;
        }
        paramString = paramCaptureVideoNormalModel.gHE();
        if (paramString == null) {
          break label380;
        }
        paramBoolean = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVR, true);
        paramCaptureVideoNormalModel = paramString.J("KEY_IS_CAPUTRE_BOOLEAN", Boolean.FALSE);
        s.s(paramCaptureVideoNormalModel, "getReportValue(RecordMed…IS_CAPUTRE_BOOLEAN,false)");
        if ((((Boolean)paramCaptureVideoNormalModel).booleanValue()) && (paramBoolean))
        {
          paramCaptureVideoNormalModel = com.tencent.mm.plugin.recordvideo.util.f.Obq;
          com.tencent.mm.plugin.recordvideo.util.f.aOJ((String)paramString.J("KEY_CAPUTRE_VIDEO_PATH_STRING", ""));
          paramCaptureVideoNormalModel = com.tencent.mm.plugin.recordvideo.util.f.Obq;
          com.tencent.mm.plugin.recordvideo.util.f.aOJ((String)paramString.J("KEY_CAPUTRE_THUMB_PATH_STRING", ""));
        }
        AppMethodBeat.o(118953);
        return;
        paramString = paramCaptureVideoNormalModel.videoPath;
        if (paramString == null)
        {
          paramString = "";
          break;
        }
        break;
        label342:
        localObject2 = paramCaptureVideoNormalModel.thumbPath;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
    paramString = com.tencent.mm.plugin.story.g.f.SqX;
    com.tencent.mm.plugin.story.g.f.gJl();
    paramString = j.SpD;
    j.anl(i);
    label380:
    AppMethodBeat.o(118953);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final void aGD(String paramString)
  {
    AppMethodBeat.i(118950);
    s.u(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", s.X("onInit, taskId:", paramString));
    Object localObject = com.tencent.mm.plugin.recordvideo.background.e.NDU;
    localObject = com.tencent.mm.plugin.recordvideo.background.e.aSP(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(118950);
      return;
    }
    String str = ((com.tencent.mm.plugin.recordvideo.background.c)localObject).gGD().thumbPath;
    fir localfir = d((com.tencent.mm.plugin.recordvideo.background.c)localObject);
    final com.tencent.mm.media.util.a locala = new com.tencent.mm.media.util.a("runMixInBackground");
    s.s(str, "thumbPath");
    a((com.tencent.mm.plugin.recordvideo.background.c)localObject, str, localfir, (kotlin.g.a.b)new c(paramString, locala));
    AppMethodBeat.o(118950);
  }
  
  public final void aGE(String paramString)
  {
    AppMethodBeat.i(118952);
    s.u(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", s.X("onWait, taskId:", paramString));
    AppMethodBeat.o(118952);
  }
  
  public final void fv(String paramString, int paramInt)
  {
    AppMethodBeat.i(118951);
    s.u(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "onRun, taskId:" + paramString + " runNum:" + paramInt);
    AppMethodBeat.o(118951);
  }
  
  public final void startStoryCapture(Context paramContext, int paramInt, long paramLong)
  {
    AppMethodBeat.i(118961);
    if ((com.tencent.mm.n.a.p(paramContext, true)) || (com.tencent.mm.n.a.dm(paramContext)) || (com.tencent.mm.n.a.dl(paramContext)) || (com.tencent.mm.n.a.dp(paramContext)))
    {
      Log.i("MicroMsg.StoryMixManager", "startStoryCapture, voip or multitalk running");
      AppMethodBeat.o(118961);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)paramContext, "android.permission.CAMERA", 24, ""))
      {
        AppMethodBeat.o(118961);
        return;
      }
      if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)paramContext, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 78, ""))
      {
        AppMethodBeat.o(118961);
        return;
      }
    }
    Log.i("MicroMsg.StoryMixManager", "startStoryCapture %s", new Object[] { Util.getStack().toString() });
    if (com.tencent.mm.plugin.story.c.a.e.Sjb.huS()) {}
    for (boolean bool = h.baE().ban().getBoolean(at.a.acYy, false); !bool; bool = h.baE().ban().getBoolean(at.a.acYx, false))
    {
      localObject = new Intent(paramContext, StoryCaptureUI.class);
      ((Intent)localObject).putExtra("jump_page_from", paramInt);
      ((Intent)localObject).putExtra("video_object_id", paramLong);
      if (paramContext == null) {
        break label678;
      }
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(118961);
      return;
    }
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.a("", "", ((com.tencent.mm.plugin.story.c.a.c.a)com.tencent.mm.plugin.story.c.a.c.SiN.boF()).oXZ, ((com.tencent.mm.plugin.story.c.a.c.a)com.tencent.mm.plugin.story.c.a.c.SiN.boF()).oXZ.duration * 1000, 3);
    Object localObject = StoryCore.SjP;
    if (StoryCore.b.hwb() == g.a.Sjh)
    {
      bool = true;
      localRecordConfigProvider.NHX = Boolean.valueOf(bool);
      localRecordConfigProvider.NIb = true;
      UICustomParam.a locala = new UICustomParam.a();
      int i = bd.fromDPToPix(paramContext, 48);
      int j = com.tencent.mm.plugin.story.a.c.ScZ;
      int k = com.tencent.mm.plugin.story.a.a.white_text_color_selector;
      if (paramContext != null) {
        break label691;
      }
      localObject = null;
      label414:
      locala.a(j, k, (String)localObject, i);
      locala.eK(true);
      locala.re(Color.parseColor("#0E9CE6"));
      localRecordConfigProvider.NHR = locala.lZB;
      localRecordConfigProvider.NHY = Boolean.TRUE;
      localRecordConfigProvider.NHV = Boolean.FALSE;
      localRecordConfigProvider.NIj = 86400000L;
      localRecordConfigProvider.NIk = false;
      localRecordConfigProvider.NHT = 1;
      localRecordConfigProvider.NIl = true;
      localRecordConfigProvider.NIm = true;
      localObject = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject).ybL = 7;
      ((VideoCaptureReportInfo)localObject).xYX = paramInt;
      ((VideoCaptureReportInfo)localObject).NIs = paramLong;
      localRecordConfigProvider.NIi = ((VideoCaptureReportInfo)localObject);
      localRecordConfigProvider.NHU = Boolean.TRUE;
      bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yWx, false);
      if ((h.baE().ban().getInt(at.a.acWc, 0) != 1) && (!bool)) {
        break label703;
      }
      paramInt = 1;
      label592:
      localRecordConfigProvider.cD(1, Image2VideoPluginLayout.class.getName());
      if (paramInt == 0) {
        break label708;
      }
      localRecordConfigProvider.cD(3, VLogPreviewPluginLayout.class.getName());
      localRecordConfigProvider.cD(4, VLogPreviewPluginLayout.class.getName());
    }
    for (;;)
    {
      CaptureDataManager.NHH.NHG = ((CaptureDataManager.b)this);
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVi, true))
      {
        localObject = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(paramContext, 0, -1, -1, localRecordConfigProvider);
      }
      label678:
      AppMethodBeat.o(118961);
      return;
      bool = false;
      break;
      label691:
      localObject = paramContext.getString(a.g.ShB);
      break label414;
      label703:
      paramInt = 0;
      break label592;
      label708:
      localRecordConfigProvider.cD(3, Image2VideoPluginLayout.class.getName());
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(com.tencent.mm.plugin.recordvideo.background.c paramc, String paramString, fir paramfir, kotlin.g.a.b<? super Integer, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(Bundle paramBundle, String paramString1, String paramString2, String paramString3, kotlin.g.a.b<? super Integer, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "storyLocalId", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    c(String paramString, com.tencent.mm.media.util.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.e.a
 * JD-Core Version:    0.7.0.1
 */