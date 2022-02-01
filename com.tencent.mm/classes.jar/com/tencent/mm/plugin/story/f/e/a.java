package com.tencent.mm.plugin.story.f.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.kernel.h;
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
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.c.a.g.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.ui.StoryCaptureUI;
import com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.ent;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aw;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/mix/StoryMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "TAG", "", "remuxTaskMap", "Ljava/util/HashMap;", "", "getRemuxTaskMap", "()Ljava/util/HashMap;", "cleanNullData", "", "taskId", "cleanUnAvailableData", "data", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "commit", "storyEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "thumbPath", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "onFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "retId", "videoPath", "extraBundle", "Landroid/os/Bundle;", "mediaDes", "resId", "genStoryEditorReportInfo", "videoEditData", "getEditDataByLocalId", "localId", "getEditDataByTaskId", "getFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "context", "Landroid/content/Context;", "getImageFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "onEditFinish", "forward", "", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "success", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onFinishBtnClick", "controller", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onInit", "onMediaGenerated", "onRun", "runNum", "onWait", "remuxMedia", "startStoryCapture", "entranceScene", "videoObjectId", "", "updateByTaskId", "editorData", "plugin-story_release"})
public final class a
  implements com.tencent.mm.plugin.recordvideo.background.b, CaptureDataManager.b
{
  private static final HashMap<Integer, String> LJm;
  public static final a LJn;
  
  static
  {
    AppMethodBeat.i(118965);
    Object localObject = new a();
    LJn = (a)localObject;
    LJm = new HashMap();
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.HGl;
    com.tencent.mm.plugin.recordvideo.background.a.a(3, (com.tencent.mm.plugin.recordvideo.background.b)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.background.a.HGl;
    com.tencent.mm.plugin.recordvideo.background.a.a(6, (com.tencent.mm.plugin.recordvideo.background.b)b.LJu);
    AppMethodBeat.o(118965);
  }
  
  public static void a(com.tencent.mm.plugin.recordvideo.background.c paramc, final String paramString, final ent parament, final kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(118955);
    p.k(paramc, "storyEditorData");
    p.k(paramString, "thumbPath");
    p.k(parament, "editorInfo");
    p.k(paramb, "onFinish");
    com.tencent.mm.ae.d.b("StoryCapture_commit", (kotlin.g.a.a)new a(paramc, paramString, parament, paramb));
    AppMethodBeat.o(118955);
  }
  
  public static void aVJ(String paramString)
  {
    AppMethodBeat.i(118959);
    p.k(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "run cleanNullData data");
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.HGz;
    com.tencent.mm.plugin.recordvideo.background.e.aVJ(paramString);
    AppMethodBeat.o(118959);
  }
  
  public static void aVK(String paramString)
  {
    AppMethodBeat.i(118960);
    p.k(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "run cleanUnAvailableData data");
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.HGz;
    com.tencent.mm.plugin.recordvideo.background.e.aVK(paramString);
    AppMethodBeat.o(118960);
  }
  
  public static com.tencent.mm.plugin.recordvideo.background.c aid(int paramInt)
  {
    AppMethodBeat.i(118958);
    Object localObject2 = (String)LJm.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    p.j(localObject1, "remuxTaskMap[localId] ?: \"\"");
    localObject2 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
    localObject1 = com.tencent.mm.plugin.recordvideo.background.e.aVH((String)localObject1);
    AppMethodBeat.o(118958);
    return localObject1;
  }
  
  public static void bdi(String paramString)
  {
    AppMethodBeat.i(118956);
    p.k(paramString, "taskId");
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.HGz;
    com.tencent.mm.plugin.recordvideo.background.e.aVL(paramString);
    AppMethodBeat.o(118956);
  }
  
  private static ent d(com.tencent.mm.plugin.recordvideo.background.c paramc)
  {
    AppMethodBeat.i(118954);
    ent localent = new ent();
    ajd localajd = new ajd();
    Object localObject = (com.tencent.mm.cd.a)localajd;
    paramc = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.cd.a)localObject).parseFrom(paramc);
      paramc = localajd.Sor;
      p.j(paramc, "editProtoData.baseItemData");
      paramc = ((Iterable)paramc).iterator();
      for (;;)
      {
        if (!paramc.hasNext()) {
          break label247;
        }
        localObject = (jc)paramc.next();
        i = ((jc)localObject).dataType;
        if (i != com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbG.value) {
          break;
        }
        LinkedList localLinkedList = localent.UqB;
        p.j(localObject, "it");
        localLinkedList.add(String.valueOf(new r((jc)localObject).LV));
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        int i;
        Log.printDebugStack("safeParser", "", new Object[] { paramc });
        continue;
        if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbH.value)
        {
          p.j(localObject, "it");
          localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jc)localObject).jHh;
          if (localObject != null) {
            localent.UqA.add(((EmojiInfo)localObject).getMd5());
          }
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbJ.value)
        {
          p.j(localObject, "it");
          localent.OAC = String.valueOf(new r((jc)localObject).LV);
        }
      }
    }
    label247:
    if (Util.isNullOrNil(localajd.kXi)) {
      localent.Uqz = false;
    }
    for (;;)
    {
      AppMethodBeat.o(118954);
      return localent;
      localent.Uqz = true;
      localent.HLC = localajd.HLC;
      localent.StC = localajd.StC;
      localent.Uqy = localajd.StD;
    }
  }
  
  public static HashMap<Integer, String> gdt()
  {
    return LJm;
  }
  
  public static void gdu()
  {
    AppMethodBeat.i(118957);
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.HGz;
    com.tencent.mm.plugin.recordvideo.background.e.fva();
    AppMethodBeat.o(118957);
  }
  
  public static FakeVideoViewLayer il(Context paramContext)
  {
    AppMethodBeat.i(118962);
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.HGl;
    paramContext = com.tencent.mm.plugin.recordvideo.background.a.hN(paramContext);
    AppMethodBeat.o(118962);
    return paramContext;
  }
  
  public static com.tencent.mm.plugin.recordvideo.ui.editor.f im(Context paramContext)
  {
    AppMethodBeat.i(118963);
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.HGl;
    paramContext = com.tencent.mm.plugin.recordvideo.background.a.hO(paramContext);
    AppMethodBeat.o(118963);
    return paramContext;
  }
  
  public final void a(Context paramContext, final CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(118964);
    Log.i("MicroMsg.StoryMixManager", "onMediaGenerated model:" + paramCaptureVideoNormalModel + ", extData:" + paramBundle);
    Object localObject;
    if ((paramBundle != null) && (paramBundle.getBoolean("key_bg_generate") == true) && (paramBundle.getByteArray("key_bg_generate_pb") != null))
    {
      paramCaptureVideoNormalModel = new ame().parseFrom(paramBundle.getByteArray("key_bg_generate_extra_config"));
      paramContext = (VideoMixer.MixConfig)paramBundle.getParcelable("key_bg_generate_mix_config");
      localObject = com.tencent.mm.plugin.recordvideo.background.e.HGz;
      paramBundle = paramBundle.getByteArray("key_bg_generate_pb");
      if (paramBundle == null) {
        p.iCn();
      }
      p.j(paramBundle, "extData.getByteArray(KEY_BG_GENERATE_PB)!!");
      if (paramContext == null) {
        p.iCn();
      }
      paramCaptureVideoNormalModel = paramCaptureVideoNormalModel.toByteArray();
      p.j(paramCaptureVideoNormalModel, "extraConfig.toByteArray()");
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
      str = paramCaptureVideoNormalModel.aZe();
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
    com.tencent.mm.ae.d.b("StoryCapture_commit", (kotlin.g.a.a)new b(new Bundle(paramBundle), (String)localObject, paramCaptureVideoNormalModel, "", (kotlin.g.a.b)a.d.LJt));
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(118964);
      throw paramContext;
    }
    ((Activity)paramContext).setResult(-1);
    ((Activity)paramContext).finish();
    AppMethodBeat.o(118964);
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle)
  {
    AppMethodBeat.i(230209);
    p.k(paramRecordMediaReportInfo, "reportInfo");
    p.k(paramBundle, "extData");
    AppMethodBeat.o(230209);
  }
  
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(118953);
    p.k(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "onFinish, success:" + paramBoolean + " taskId:" + paramString);
    Object localObject1 = LJm.entrySet();
    p.j(localObject1, "remuxTaskMap.entries");
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (Util.isEqual((String)((Map.Entry)localObject2).getValue(), paramString))
      {
        localObject2 = ((Map.Entry)localObject2).getKey();
        p.j(localObject2, "it.key");
        i = ((Number)localObject2).intValue();
        Log.i("MicroMsg.StoryMixManager", "found localId:".concat(String.valueOf(i)));
      }
    }
    if (paramBoolean)
    {
      LJm.remove(Integer.valueOf(i));
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
        localObject2 = paramCaptureVideoNormalModel.aZe();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = com.tencent.mm.plugin.story.g.j.LML;
      com.tencent.mm.plugin.story.g.j.g(i, paramString, (String)localObject1);
      paramString = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcC().gdP();
      if (paramCaptureVideoNormalModel != null)
      {
        paramString = paramCaptureVideoNormalModel.fvU();
        if (paramString != null)
        {
          paramBoolean = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGj, true);
          paramCaptureVideoNormalModel = paramString.x("KEY_IS_CAPUTRE_BOOLEAN", Boolean.FALSE);
          p.j(paramCaptureVideoNormalModel, "getReportValue(RecordMed…IS_CAPUTRE_BOOLEAN,false)");
          if ((((Boolean)paramCaptureVideoNormalModel).booleanValue()) && (paramBoolean))
          {
            paramCaptureVideoNormalModel = com.tencent.mm.plugin.recordvideo.e.d.IeU;
            com.tencent.mm.plugin.recordvideo.e.d.aRR((String)paramString.x("KEY_CAPUTRE_VIDEO_PATH_STRING", ""));
            paramCaptureVideoNormalModel = com.tencent.mm.plugin.recordvideo.e.d.IeU;
            com.tencent.mm.plugin.recordvideo.e.d.aRR((String)paramString.x("KEY_CAPUTRE_THUMB_PATH_STRING", ""));
          }
          AppMethodBeat.o(118953);
          return;
        }
      }
      AppMethodBeat.o(118953);
      return;
      paramString = com.tencent.mm.plugin.story.h.f.LOj;
      com.tencent.mm.plugin.story.h.f.fxw();
      paramString = com.tencent.mm.plugin.story.g.j.LML;
      com.tencent.mm.plugin.story.g.j.ail(i);
      AppMethodBeat.o(118953);
      return;
    }
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final void aJO(String paramString)
  {
    AppMethodBeat.i(118950);
    p.k(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "onInit, taskId:".concat(String.valueOf(paramString)));
    Object localObject = com.tencent.mm.plugin.recordvideo.background.e.HGz;
    localObject = com.tencent.mm.plugin.recordvideo.background.e.aVH(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(118950);
      return;
    }
    String str = ((com.tencent.mm.plugin.recordvideo.background.c)localObject).fuN().thumbPath;
    ent localent = d((com.tencent.mm.plugin.recordvideo.background.c)localObject);
    final com.tencent.mm.media.k.a locala = new com.tencent.mm.media.k.a("runMixInBackground");
    p.j(str, "thumbPath");
    a((com.tencent.mm.plugin.recordvideo.background.c)localObject, str, localent, (kotlin.g.a.b)new c(paramString, locala));
    AppMethodBeat.o(118950);
  }
  
  public final void aJP(String paramString)
  {
    AppMethodBeat.i(118952);
    p.k(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "onWait, taskId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(118952);
  }
  
  public final void eF(String paramString, int paramInt)
  {
    AppMethodBeat.i(118951);
    p.k(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "onRun, taskId:" + paramString + " runNum:" + paramInt);
    AppMethodBeat.o(118951);
  }
  
  public final void startStoryCapture(Context paramContext, int paramInt, long paramLong)
  {
    AppMethodBeat.i(118961);
    if ((com.tencent.mm.plugin.voip.f.iE(paramContext)) || (com.tencent.mm.plugin.voip.f.cy(paramContext)) || (com.tencent.mm.bj.e.cw(paramContext)) || (com.tencent.mm.q.a.cB(paramContext)))
    {
      Log.i("MicroMsg.StoryMixManager", "startStoryCapture, voip or multitalk running");
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
      if (!com.tencent.mm.pluginsdk.permission.b.a((Activity)paramContext, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 78, "", ""))
      {
        AppMethodBeat.o(118961);
        return;
      }
    }
    Log.i("MicroMsg.StoryMixManager", "startStoryCapture %s", new Object[] { Util.getStack().toString() });
    boolean bool;
    if (com.tencent.mm.plugin.story.c.a.e.LFp.gbz())
    {
      localObject = h.aHG();
      p.j(localObject, "storage()");
      bool = ((com.tencent.mm.kernel.f)localObject).aHp().getBoolean(ar.a.VwN, false);
    }
    while (!bool)
    {
      localObject = new Intent(paramContext, StoryCaptureUI.class);
      ((Intent)localObject).putExtra("jump_page_from", paramInt);
      ((Intent)localObject).putExtra("video_object_id", paramLong);
      if (paramContext != null)
      {
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(118961);
        return;
        localObject = h.aHG();
        p.j(localObject, "storage()");
        bool = ((com.tencent.mm.kernel.f)localObject).aHp().getBoolean(ar.a.VwM, false);
      }
      else
      {
        AppMethodBeat.o(118961);
        return;
      }
    }
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.a("", "", ((c.a)com.tencent.mm.plugin.story.c.a.c.LFb.aUb()).mfk, ((c.a)com.tencent.mm.plugin.story.c.a.c.LFb.aUb()).mfk.duration * 1000, 3);
    Object localObject = com.tencent.mm.plugin.story.f.j.LGA;
    if (j.b.gcG() == g.a.LFv)
    {
      bool = true;
      localRecordConfigProvider.HKZ = Boolean.valueOf(bool);
      localRecordConfigProvider.HLd = true;
      UICustomParam.a locala = new UICustomParam.a();
      int i = aw.fromDPToPix(paramContext, 48);
      int j = com.tencent.mm.plugin.story.a.c.Lzm;
      int k = com.tencent.mm.plugin.story.a.a.white_text_color_selector;
      if (paramContext == null) {
        break label743;
      }
      localObject = paramContext.getString(a.g.LDQ);
      label454:
      locala.a(j, k, (String)localObject, i);
      locala.dY(true);
      locala.qY(Color.parseColor("#0E9CE6"));
      localRecordConfigProvider.HKT = locala.avZ();
      localRecordConfigProvider.HLa = Boolean.TRUE;
      localRecordConfigProvider.HKX = Boolean.FALSE;
      localRecordConfigProvider.HLl = 86400000L;
      localRecordConfigProvider.HLm = false;
      localRecordConfigProvider.HKV = 1;
      localRecordConfigProvider.HLn = true;
      localRecordConfigProvider.HLo = true;
      localObject = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject).wwk = 7;
      ((VideoCaptureReportInfo)localObject).uQm = paramInt;
      ((VideoCaptureReportInfo)localObject).HLs = paramLong;
      localRecordConfigProvider.HLk = ((VideoCaptureReportInfo)localObject);
      localRecordConfigProvider.HKW = Boolean.TRUE;
      bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGC, false);
      localObject = h.aHG();
      p.j(localObject, "storage()");
      if ((((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.Vut, 0) != 1) && (!bool)) {
        break label749;
      }
      paramInt = 1;
      label644:
      localRecordConfigProvider.G(1, Image2VideoPluginLayout.class.getName());
      if (paramInt == 0) {
        break label754;
      }
      localRecordConfigProvider.G(3, VLogPreviewPluginLayout.class.getName());
      localRecordConfigProvider.G(4, VLogPreviewPluginLayout.class.getName());
    }
    for (;;)
    {
      CaptureDataManager.HKJ.a((CaptureDataManager.b)this);
      if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFJ, true))
      {
        localObject = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(paramContext, 0, -1, -1, localRecordConfigProvider);
      }
      AppMethodBeat.o(118961);
      return;
      bool = false;
      break;
      label743:
      localObject = null;
      break label454;
      label749:
      paramInt = 0;
      break label644;
      label754:
      localRecordConfigProvider.G(3, Image2VideoPluginLayout.class.getName());
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(com.tencent.mm.plugin.recordvideo.background.c paramc, String paramString, ent parament, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(Bundle paramBundle, String paramString1, String paramString2, String paramString3, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "storyLocalId", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    c(String paramString, com.tencent.mm.media.k.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.e.a
 * JD-Core Version:    0.7.0.1
 */