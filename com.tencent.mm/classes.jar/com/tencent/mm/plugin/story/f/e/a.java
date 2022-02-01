package com.tencent.mm.plugin.story.f.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.c.a.g.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.ui.StoryCaptureUI;
import com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aq;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/mix/StoryMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "TAG", "", "remuxTaskMap", "Ljava/util/HashMap;", "", "getRemuxTaskMap", "()Ljava/util/HashMap;", "cleanNullData", "", "taskId", "cleanUnAvailableData", "data", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "commit", "storyEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "thumbPath", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "onFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "retId", "videoPath", "extraBundle", "Landroid/os/Bundle;", "mediaDes", "resId", "genStoryEditorReportInfo", "videoEditData", "getEditDataByLocalId", "localId", "getEditDataByTaskId", "getFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "context", "Landroid/content/Context;", "getImageFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "onEditFinish", "forward", "", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "success", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onFinishBtnClick", "controller", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onInit", "onMediaGenerated", "onRun", "runNum", "onWait", "remuxMedia", "startStoryCapture", "entranceScene", "videoObjectId", "", "updateByTaskId", "editorData", "plugin-story_release"})
public final class a
  implements com.tencent.mm.plugin.recordvideo.background.b, CaptureDataManager.b
{
  private static final HashMap<Integer, String> AMS;
  public static final a AMT;
  
  static
  {
    AppMethodBeat.i(118965);
    Object localObject = new a();
    AMT = (a)localObject;
    AMS = new HashMap();
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.xua;
    com.tencent.mm.plugin.recordvideo.background.a.a(3, (com.tencent.mm.plugin.recordvideo.background.b)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.background.a.xua;
    com.tencent.mm.plugin.recordvideo.background.a.a(6, (com.tencent.mm.plugin.recordvideo.background.b)b.ANa);
    AppMethodBeat.o(118965);
  }
  
  public static com.tencent.mm.plugin.recordvideo.background.c Sf(int paramInt)
  {
    AppMethodBeat.i(118958);
    Object localObject2 = (String)AMS.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    p.g(localObject1, "remuxTaskMap[localId] ?: \"\"");
    localObject2 = com.tencent.mm.plugin.recordvideo.background.e.xuo;
    localObject1 = com.tencent.mm.plugin.recordvideo.background.e.avy((String)localObject1);
    AppMethodBeat.o(118958);
    return localObject1;
  }
  
  public static void a(com.tencent.mm.plugin.recordvideo.background.c paramc, final String paramString, final djk paramdjk, final d.g.a.b<? super Integer, z> paramb)
  {
    AppMethodBeat.i(118955);
    p.h(paramc, "storyEditorData");
    p.h(paramString, "thumbPath");
    p.h(paramdjk, "editorInfo");
    p.h(paramb, "onFinish");
    com.tencent.mm.ad.c.b("StoryCapture_commit", (d.g.a.a)new a(paramc, paramString, paramdjk, paramb));
    AppMethodBeat.o(118955);
  }
  
  public static void aBQ(String paramString)
  {
    AppMethodBeat.i(118956);
    p.h(paramString, "taskId");
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.xuo;
    com.tencent.mm.plugin.recordvideo.background.e.avC(paramString);
    AppMethodBeat.o(118956);
  }
  
  public static void avA(String paramString)
  {
    AppMethodBeat.i(118959);
    p.h(paramString, "taskId");
    ad.i("MicroMsg.StoryMixManager", "run cleanNullData data");
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.xuo;
    com.tencent.mm.plugin.recordvideo.background.e.avA(paramString);
    AppMethodBeat.o(118959);
  }
  
  public static void avB(String paramString)
  {
    AppMethodBeat.i(118960);
    p.h(paramString, "taskId");
    ad.i("MicroMsg.StoryMixManager", "run cleanUnAvailableData data");
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.xuo;
    com.tencent.mm.plugin.recordvideo.background.e.avB(paramString);
    AppMethodBeat.o(118960);
  }
  
  private static djk d(com.tencent.mm.plugin.recordvideo.background.c paramc)
  {
    AppMethodBeat.i(118954);
    djk localdjk = new djk();
    afy localafy = new afy();
    Object localObject = (com.tencent.mm.bx.a)localafy;
    paramc = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bx.a)localObject).parseFrom(paramc);
      paramc = localafy.FZr;
      p.g(paramc, "editProtoData.baseItemData");
      paramc = ((Iterable)paramc).iterator();
      for (;;)
      {
        if (!paramc.hasNext()) {
          break label247;
        }
        localObject = (ja)paramc.next();
        i = ((ja)localObject).dataType;
        if (i != d.xNP.value) {
          break;
        }
        LinkedList localLinkedList = localdjk.Hyp;
        p.g(localObject, "it");
        localLinkedList.add(String.valueOf(new com.tencent.mm.plugin.recordvideo.ui.editor.item.q((ja)localObject).text));
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        int i;
        ad.l("safeParser", "", new Object[] { paramc });
        continue;
        if (i == d.xNQ.value)
        {
          p.g(localObject, "it");
          localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((ja)localObject).gjb;
          if (localObject != null) {
            localdjk.Hyo.add(((EmojiInfo)localObject).Lb());
          }
        }
        else if (i == d.xNS.value)
        {
          p.g(localObject, "it");
          localdjk.COu = String.valueOf(new com.tencent.mm.plugin.recordvideo.ui.editor.item.q((ja)localObject).text);
        }
      }
    }
    label247:
    if (bt.isNullOrNil(localafy.hml)) {
      localdjk.Hyn = false;
    }
    for (;;)
    {
      AppMethodBeat.o(118954);
      return localdjk;
      localdjk.Hyn = true;
      localdjk.xyZ = localafy.xyZ;
      localdjk.GdN = localafy.GdN;
      localdjk.Hym = localafy.GdO;
    }
  }
  
  public static HashMap<Integer, String> eiQ()
  {
    return AMS;
  }
  
  public static void eiR()
  {
    AppMethodBeat.i(118957);
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.xuo;
    com.tencent.mm.plugin.recordvideo.background.e.dES();
    AppMethodBeat.o(118957);
  }
  
  public static FakeVideoViewLayer gu(Context paramContext)
  {
    AppMethodBeat.i(118962);
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.xua;
    paramContext = com.tencent.mm.plugin.recordvideo.background.a.fY(paramContext);
    AppMethodBeat.o(118962);
    return paramContext;
  }
  
  public static com.tencent.mm.plugin.recordvideo.ui.editor.f gv(Context paramContext)
  {
    AppMethodBeat.i(118963);
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.xua;
    paramContext = com.tencent.mm.plugin.recordvideo.background.a.fZ(paramContext);
    AppMethodBeat.o(118963);
    return paramContext;
  }
  
  public final void a(Context paramContext, final CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(118964);
    ad.i("MicroMsg.StoryMixManager", "onMediaGenerated model:" + paramCaptureVideoNormalModel + ", extData:" + paramBundle);
    Object localObject;
    if ((paramBundle != null) && (paramBundle.getBoolean("key_bg_generate") == true) && (paramBundle.getByteArray("key_bg_generate_pb") != null))
    {
      paramCaptureVideoNormalModel = new aif().parseFrom(paramBundle.getByteArray("key_bg_generate_extra_config"));
      paramContext = (VideoMixer.MixConfig)paramBundle.getParcelable("key_bg_generate_mix_config");
      localObject = com.tencent.mm.plugin.recordvideo.background.e.xuo;
      paramBundle = paramBundle.getByteArray("key_bg_generate_pb");
      p.g(paramBundle, "extData.getByteArray(KEY_BG_GENERATE_PB)");
      p.g(paramContext, "mixConfig");
      paramCaptureVideoNormalModel = paramCaptureVideoNormalModel.toByteArray();
      p.g(paramCaptureVideoNormalModel, "extraConfig.toByteArray()");
      com.tencent.mm.plugin.recordvideo.background.e.a(paramBundle, paramContext, paramCaptureVideoNormalModel);
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
      str = paramCaptureVideoNormalModel.axA();
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
    com.tencent.mm.ad.c.b("StoryCapture_commit", (d.g.a.a)new b(new Bundle(paramBundle), (String)localObject, paramCaptureVideoNormalModel, "", (d.g.a.b)a.d.AMZ));
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
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle)
  {
    AppMethodBeat.i(189776);
    p.h(paramRecordMediaReportInfo, "reportInfo");
    p.h(paramBundle, "extData");
    AppMethodBeat.o(189776);
  }
  
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(118953);
    p.h(paramString, "taskId");
    ad.i("MicroMsg.StoryMixManager", "onFinish, success:" + paramBoolean + " taskId:" + paramString);
    Object localObject1 = AMS.entrySet();
    p.g(localObject1, "remuxTaskMap.entries");
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (bt.lQ((String)((Map.Entry)localObject2).getValue(), paramString))
      {
        localObject2 = ((Map.Entry)localObject2).getKey();
        p.g(localObject2, "it.key");
        i = ((Number)localObject2).intValue();
        ad.i("MicroMsg.StoryMixManager", "found localId:".concat(String.valueOf(i)));
      }
    }
    if (paramBoolean)
    {
      AMS.remove(Integer.valueOf(i));
      if (paramCaptureVideoNormalModel != null)
      {
        paramString = paramCaptureVideoNormalModel.getVideoPath();
        if (paramString != null) {
          break label378;
        }
      }
      paramString = "";
    }
    label378:
    for (;;)
    {
      if (paramCaptureVideoNormalModel != null)
      {
        localObject2 = paramCaptureVideoNormalModel.axA();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = com.tencent.mm.plugin.story.g.j.AQt;
      com.tencent.mm.plugin.story.g.j.e(i, paramString, (String)localObject1);
      paramString = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.ehZ().ejm();
      if (paramCaptureVideoNormalModel != null)
      {
        paramString = paramCaptureVideoNormalModel.dFF();
        if (paramString != null)
        {
          paramBoolean = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyS, true);
          paramCaptureVideoNormalModel = paramString.v("KEY_IS_CAPUTRE_BOOLEAN", Boolean.FALSE);
          p.g(paramCaptureVideoNormalModel, "getReportValue(RecordMed…IS_CAPUTRE_BOOLEAN,false)");
          if ((((Boolean)paramCaptureVideoNormalModel).booleanValue()) && (paramBoolean))
          {
            paramCaptureVideoNormalModel = com.tencent.mm.plugin.recordvideo.e.b.xRl;
            com.tencent.mm.plugin.recordvideo.e.b.ast((String)paramString.v("KEY_CAPUTRE_VIDEO_PATH_STRING", ""));
            paramCaptureVideoNormalModel = com.tencent.mm.plugin.recordvideo.e.b.xRl;
            com.tencent.mm.plugin.recordvideo.e.b.ast((String)paramString.v("KEY_CAPUTRE_THUMB_PATH_STRING", ""));
          }
          AppMethodBeat.o(118953);
          return;
        }
      }
      AppMethodBeat.o(118953);
      return;
      paramString = com.tencent.mm.plugin.story.h.f.ARU;
      com.tencent.mm.plugin.story.h.f.dGQ();
      paramString = com.tencent.mm.plugin.story.g.j.AQt;
      com.tencent.mm.plugin.story.g.j.Sn(i);
      AppMethodBeat.o(118953);
      return;
    }
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final void alO(String paramString)
  {
    AppMethodBeat.i(118950);
    p.h(paramString, "taskId");
    ad.i("MicroMsg.StoryMixManager", "onInit, taskId:".concat(String.valueOf(paramString)));
    Object localObject = com.tencent.mm.plugin.recordvideo.background.e.xuo;
    localObject = com.tencent.mm.plugin.recordvideo.background.e.avy(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(118950);
      return;
    }
    String str = ((com.tencent.mm.plugin.recordvideo.background.c)localObject).dEE().thumbPath;
    djk localdjk = d((com.tencent.mm.plugin.recordvideo.background.c)localObject);
    final com.tencent.mm.media.k.a locala = new com.tencent.mm.media.k.a("runMixInBackground");
    p.g(str, "thumbPath");
    a((com.tencent.mm.plugin.recordvideo.background.c)localObject, str, localdjk, (d.g.a.b)new c(paramString, locala));
    AppMethodBeat.o(118950);
  }
  
  public final void alP(String paramString)
  {
    AppMethodBeat.i(118952);
    p.h(paramString, "taskId");
    ad.i("MicroMsg.StoryMixManager", "onWait, taskId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(118952);
  }
  
  public final void dO(String paramString, int paramInt)
  {
    AppMethodBeat.i(118951);
    p.h(paramString, "taskId");
    ad.i("MicroMsg.StoryMixManager", "onRun, taskId:" + paramString + " runNum:" + paramInt);
    AppMethodBeat.o(118951);
  }
  
  public final void startStoryCapture(Context paramContext, int paramInt, long paramLong)
  {
    AppMethodBeat.i(118961);
    if ((com.tencent.mm.plugin.voip.f.gA(paramContext)) || (com.tencent.mm.plugin.voip.f.cf(paramContext)) || (com.tencent.mm.bi.e.cd(paramContext)) || (com.tencent.mm.s.a.ch(paramContext)))
    {
      ad.i("MicroMsg.StoryMixManager", "startStoryCapture, voip or multitalk running");
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
    ad.i("MicroMsg.StoryMixManager", "startStoryCapture %s", new Object[] { bt.flS().toString() });
    boolean bool;
    if (com.tencent.mm.plugin.story.c.a.e.AIM.egX())
    {
      localObject = g.ajC();
      p.g(localObject, "storage()");
      bool = ((com.tencent.mm.kernel.e)localObject).ajl().getBoolean(al.a.IFr, false);
    }
    while (!bool)
    {
      localObject = new Intent(paramContext, StoryCaptureUI.class);
      ((Intent)localObject).putExtra("jump_page_from", paramInt);
      ((Intent)localObject).putExtra("video_object_id", paramLong);
      if (paramContext != null)
      {
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(118961);
        return;
        localObject = g.ajC();
        p.g(localObject, "storage()");
        bool = ((com.tencent.mm.kernel.e)localObject).ajl().getBoolean(al.a.IFq, false);
      }
      else
      {
        AppMethodBeat.o(118961);
        return;
      }
    }
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.a("", "", ((c.a)com.tencent.mm.plugin.story.c.a.c.AIy.ate()).xyj, ((c.a)com.tencent.mm.plugin.story.c.a.c.AIy.ate()).xyj.duration * 1000, 3);
    Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
    if (j.b.eid() == g.a.AIS)
    {
      bool = true;
      localRecordConfigProvider.xyq = Boolean.valueOf(bool);
      localRecordConfigProvider.xyu = true;
      UICustomParam.a locala = new UICustomParam.a();
      int i = aq.fromDPToPix(paramContext, 48);
      if (paramContext == null) {
        break label748;
      }
      localObject = paramContext.getString(2131764253);
      label457:
      locala.a(2131234264, 2131101185, (String)localObject, i);
      locala.cO(true);
      locala.lB(Color.parseColor("#0E9CE6"));
      localRecordConfigProvider.xyk = locala.abA();
      localRecordConfigProvider.xyr = Boolean.TRUE;
      localRecordConfigProvider.xyo = Boolean.FALSE;
      localRecordConfigProvider.xyC = 86400000L;
      localRecordConfigProvider.xyD = false;
      localRecordConfigProvider.xym = 1;
      localRecordConfigProvider.xyE = true;
      localRecordConfigProvider.xyF = true;
      localObject = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject).rgD = 7;
      ((VideoCaptureReportInfo)localObject).pPw = paramInt;
      ((VideoCaptureReportInfo)localObject).xyJ = paramLong;
      localRecordConfigProvider.xyB = ((VideoCaptureReportInfo)localObject);
      localRecordConfigProvider.xyn = Boolean.TRUE;
      bool = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzi, false);
      localObject = g.ajC();
      p.g(localObject, "storage()");
      if ((((com.tencent.mm.kernel.e)localObject).ajl().getInt(al.a.IDh, 0) != 1) && (!bool)) {
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
      CaptureDataManager.xxY.a((CaptureDataManager.b)this);
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyu, true))
      {
        localObject = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    a(com.tencent.mm.plugin.recordvideo.background.c paramc, String paramString, djk paramdjk, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(Bundle paramBundle, String paramString1, String paramString2, String paramString3, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "storyLocalId", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.b<Integer, z>
  {
    c(String paramString, com.tencent.mm.media.k.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.e.a
 * JD-Core Version:    0.7.0.1
 */