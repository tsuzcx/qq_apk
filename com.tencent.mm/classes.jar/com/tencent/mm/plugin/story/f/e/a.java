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
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.c.a.g.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.ui.StoryCaptureUI;
import com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.at;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/mix/StoryMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "TAG", "", "remuxTaskMap", "Ljava/util/HashMap;", "", "getRemuxTaskMap", "()Ljava/util/HashMap;", "cleanNullData", "", "taskId", "cleanUnAvailableData", "data", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "commit", "storyEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "thumbPath", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "onFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "retId", "videoPath", "extraBundle", "Landroid/os/Bundle;", "mediaDes", "resId", "genStoryEditorReportInfo", "videoEditData", "getEditDataByLocalId", "localId", "getEditDataByTaskId", "getFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "context", "Landroid/content/Context;", "getImageFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "onEditFinish", "forward", "", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "extData", "success", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onFinishBtnClick", "controller", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onInit", "onMediaGenerated", "onRun", "runNum", "onWait", "remuxMedia", "startStoryCapture", "entranceScene", "videoObjectId", "", "updateByTaskId", "editorData", "plugin-story_release"})
public final class a
  implements com.tencent.mm.plugin.recordvideo.background.b, CaptureDataManager.b
{
  private static final HashMap<Integer, String> Fpk;
  public static final a Fpl;
  
  static
  {
    AppMethodBeat.i(118965);
    Object localObject = new a();
    Fpl = (a)localObject;
    Fpk = new HashMap();
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.BKb;
    com.tencent.mm.plugin.recordvideo.background.a.a(3, (com.tencent.mm.plugin.recordvideo.background.b)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.background.a.BKb;
    com.tencent.mm.plugin.recordvideo.background.a.a(6, (com.tencent.mm.plugin.recordvideo.background.b)b.Fps);
    AppMethodBeat.o(118965);
  }
  
  public static void a(com.tencent.mm.plugin.recordvideo.background.c paramc, final String paramString, final eds parameds, final kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(118955);
    p.h(paramc, "storyEditorData");
    p.h(paramString, "thumbPath");
    p.h(parameds, "editorInfo");
    p.h(paramb, "onFinish");
    com.tencent.mm.ac.d.b("StoryCapture_commit", (kotlin.g.a.a)new a(paramc, paramString, parameds, paramb));
    AppMethodBeat.o(118955);
  }
  
  public static void aLh(String paramString)
  {
    AppMethodBeat.i(118959);
    p.h(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "run cleanNullData data");
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.BKp;
    com.tencent.mm.plugin.recordvideo.background.e.aLh(paramString);
    AppMethodBeat.o(118959);
  }
  
  public static void aLi(String paramString)
  {
    AppMethodBeat.i(118960);
    p.h(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "run cleanUnAvailableData data");
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.BKp;
    com.tencent.mm.plugin.recordvideo.background.e.aLi(paramString);
    AppMethodBeat.o(118960);
  }
  
  public static void aSe(String paramString)
  {
    AppMethodBeat.i(118956);
    p.h(paramString, "taskId");
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.BKp;
    com.tencent.mm.plugin.recordvideo.background.e.aLj(paramString);
    AppMethodBeat.o(118956);
  }
  
  public static com.tencent.mm.plugin.recordvideo.background.c aaI(int paramInt)
  {
    AppMethodBeat.i(118958);
    Object localObject2 = (String)Fpk.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    p.g(localObject1, "remuxTaskMap[localId] ?: \"\"");
    localObject2 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
    localObject1 = com.tencent.mm.plugin.recordvideo.background.e.aLf((String)localObject1);
    AppMethodBeat.o(118958);
    return localObject1;
  }
  
  private static eds d(com.tencent.mm.plugin.recordvideo.background.c paramc)
  {
    AppMethodBeat.i(118954);
    eds localeds = new eds();
    aio localaio = new aio();
    Object localObject = (com.tencent.mm.bw.a)localaio;
    paramc = paramc.field_baseItemData;
    try
    {
      ((com.tencent.mm.bw.a)localObject).parseFrom(paramc);
      paramc = localaio.Lna;
      p.g(paramc, "editProtoData.baseItemData");
      paramc = ((Iterable)paramc).iterator();
      for (;;)
      {
        if (!paramc.hasNext()) {
          break label247;
        }
        localObject = (jn)paramc.next();
        i = ((jn)localObject).dataType;
        if (i != com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeK.value) {
          break;
        }
        LinkedList localLinkedList = localeds.Nec;
        p.g(localObject, "it");
        localLinkedList.add(String.valueOf(new com.tencent.mm.plugin.recordvideo.ui.editor.item.q((jn)localObject).text));
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        int i;
        Log.printDebugStack("safeParser", "", new Object[] { paramc });
        continue;
        if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeL.value)
        {
          p.g(localObject, "it");
          localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.item.e((jn)localObject).gWm;
          if (localObject != null) {
            localeds.Neb.add(((EmojiInfo)localObject).getMd5());
          }
        }
        else if (i == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeN.value)
        {
          p.g(localObject, "it");
          localeds.HIK = String.valueOf(new com.tencent.mm.plugin.recordvideo.ui.editor.item.q((jn)localObject).text);
        }
      }
    }
    label247:
    if (Util.isNullOrNil(localaio.iiv)) {
      localeds.Nea = false;
    }
    for (;;)
    {
      AppMethodBeat.o(118954);
      return localeds;
      localeds.Nea = true;
      localeds.BOX = localaio.BOX;
      localeds.Lsa = localaio.Lsa;
      localeds.NdZ = localaio.Lsb;
    }
  }
  
  public static HashMap<Integer, String> foZ()
  {
    return Fpk;
  }
  
  public static void fpa()
  {
    AppMethodBeat.i(118957);
    com.tencent.mm.plugin.recordvideo.background.e locale = com.tencent.mm.plugin.recordvideo.background.e.BKp;
    com.tencent.mm.plugin.recordvideo.background.e.eIW();
    AppMethodBeat.o(118957);
  }
  
  public static FakeVideoViewLayer hk(Context paramContext)
  {
    AppMethodBeat.i(118962);
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.BKb;
    paramContext = com.tencent.mm.plugin.recordvideo.background.a.gN(paramContext);
    AppMethodBeat.o(118962);
    return paramContext;
  }
  
  public static com.tencent.mm.plugin.recordvideo.ui.editor.f hl(Context paramContext)
  {
    AppMethodBeat.i(118963);
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.BKb;
    paramContext = com.tencent.mm.plugin.recordvideo.background.a.gO(paramContext);
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
      paramCaptureVideoNormalModel = new ald().parseFrom(paramBundle.getByteArray("key_bg_generate_extra_config"));
      paramContext = (VideoMixer.MixConfig)paramBundle.getParcelable("key_bg_generate_mix_config");
      localObject = com.tencent.mm.plugin.recordvideo.background.e.BKp;
      paramBundle = paramBundle.getByteArray("key_bg_generate_pb");
      if (paramBundle == null) {
        p.hyc();
      }
      p.g(paramBundle, "extData.getByteArray(KEY_BG_GENERATE_PB)!!");
      if (paramContext == null) {
        p.hyc();
      }
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
      str = paramCaptureVideoNormalModel.aQn();
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
    com.tencent.mm.ac.d.b("StoryCapture_commit", (kotlin.g.a.a)new b(new Bundle(paramBundle), (String)localObject, paramCaptureVideoNormalModel, "", (kotlin.g.a.b)a.d.Fpr));
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
    AppMethodBeat.i(222911);
    p.h(paramRecordMediaReportInfo, "reportInfo");
    p.h(paramBundle, "extData");
    AppMethodBeat.o(222911);
  }
  
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(118953);
    p.h(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "onFinish, success:" + paramBoolean + " taskId:" + paramString);
    Object localObject1 = Fpk.entrySet();
    p.g(localObject1, "remuxTaskMap.entries");
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (Util.isEqual((String)((Map.Entry)localObject2).getValue(), paramString))
      {
        localObject2 = ((Map.Entry)localObject2).getKey();
        p.g(localObject2, "it.key");
        i = ((Number)localObject2).intValue();
        Log.i("MicroMsg.StoryMixManager", "found localId:".concat(String.valueOf(i)));
      }
    }
    if (paramBoolean)
    {
      Fpk.remove(Integer.valueOf(i));
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
        localObject2 = paramCaptureVideoNormalModel.aQn();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = com.tencent.mm.plugin.story.g.j.FsI;
      com.tencent.mm.plugin.story.g.j.e(i, paramString, (String)localObject1);
      paramString = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.foi().fpv();
      if (paramCaptureVideoNormalModel != null)
      {
        paramString = paramCaptureVideoNormalModel.eJJ();
        if (paramString != null)
        {
          paramBoolean = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZl, true);
          paramCaptureVideoNormalModel = paramString.y("KEY_IS_CAPUTRE_BOOLEAN", Boolean.FALSE);
          p.g(paramCaptureVideoNormalModel, "getReportValue(RecordMed…IS_CAPUTRE_BOOLEAN,false)");
          if ((((Boolean)paramCaptureVideoNormalModel).booleanValue()) && (paramBoolean))
          {
            paramCaptureVideoNormalModel = com.tencent.mm.plugin.recordvideo.e.c.Cic;
            com.tencent.mm.plugin.recordvideo.e.c.aHD((String)paramString.y("KEY_CAPUTRE_VIDEO_PATH_STRING", ""));
            paramCaptureVideoNormalModel = com.tencent.mm.plugin.recordvideo.e.c.Cic;
            com.tencent.mm.plugin.recordvideo.e.c.aHD((String)paramString.y("KEY_CAPUTRE_THUMB_PATH_STRING", ""));
          }
          AppMethodBeat.o(118953);
          return;
        }
      }
      AppMethodBeat.o(118953);
      return;
      paramString = com.tencent.mm.plugin.story.h.f.Fui;
      com.tencent.mm.plugin.story.h.f.eLd();
      paramString = com.tencent.mm.plugin.story.g.j.FsI;
      com.tencent.mm.plugin.story.g.j.aaQ(i);
      AppMethodBeat.o(118953);
      return;
    }
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final void aAd(String paramString)
  {
    AppMethodBeat.i(118950);
    p.h(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "onInit, taskId:".concat(String.valueOf(paramString)));
    Object localObject = com.tencent.mm.plugin.recordvideo.background.e.BKp;
    localObject = com.tencent.mm.plugin.recordvideo.background.e.aLf(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(118950);
      return;
    }
    String str = ((com.tencent.mm.plugin.recordvideo.background.c)localObject).eII().thumbPath;
    eds localeds = d((com.tencent.mm.plugin.recordvideo.background.c)localObject);
    final com.tencent.mm.media.k.a locala = new com.tencent.mm.media.k.a("runMixInBackground");
    p.g(str, "thumbPath");
    a((com.tencent.mm.plugin.recordvideo.background.c)localObject, str, localeds, (kotlin.g.a.b)new c(paramString, locala));
    AppMethodBeat.o(118950);
  }
  
  public final void aAe(String paramString)
  {
    AppMethodBeat.i(118952);
    p.h(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "onWait, taskId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(118952);
  }
  
  public final void eh(String paramString, int paramInt)
  {
    AppMethodBeat.i(118951);
    p.h(paramString, "taskId");
    Log.i("MicroMsg.StoryMixManager", "onRun, taskId:" + paramString + " runNum:" + paramInt);
    AppMethodBeat.o(118951);
  }
  
  public final void startStoryCapture(Context paramContext, int paramInt, long paramLong)
  {
    AppMethodBeat.i(118961);
    if ((com.tencent.mm.plugin.voip.f.hy(paramContext)) || (com.tencent.mm.plugin.voip.f.cC(paramContext)) || (com.tencent.mm.bh.e.cA(paramContext)) || (com.tencent.mm.q.a.cE(paramContext)))
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
    if (com.tencent.mm.plugin.story.c.a.e.Fln.fng())
    {
      localObject = g.aAh();
      p.g(localObject, "storage()");
      bool = ((com.tencent.mm.kernel.e)localObject).azQ().getBoolean(ar.a.Oix, false);
    }
    while (!bool)
    {
      localObject = new Intent(paramContext, StoryCaptureUI.class);
      ((Intent)localObject).putExtra("jump_page_from", paramInt);
      ((Intent)localObject).putExtra("video_object_id", paramLong);
      if (paramContext != null)
      {
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(118961);
        return;
        localObject = g.aAh();
        p.g(localObject, "storage()");
        bool = ((com.tencent.mm.kernel.e)localObject).azQ().getBoolean(ar.a.Oiw, false);
      }
      else
      {
        AppMethodBeat.o(118961);
        return;
      }
    }
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.a("", "", ((c.a)com.tencent.mm.plugin.story.c.a.c.FkZ.aLT()).BOm, ((c.a)com.tencent.mm.plugin.story.c.a.c.FkZ.aLT()).BOm.duration * 1000, 3);
    Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    if (j.b.fom() == g.a.Flt)
    {
      bool = true;
      localRecordConfigProvider.BOt = Boolean.valueOf(bool);
      localRecordConfigProvider.BOx = true;
      UICustomParam.a locala = new UICustomParam.a();
      int i = at.fromDPToPix(paramContext, 48);
      if (paramContext == null) {
        break label735;
      }
      localObject = paramContext.getString(2131766510);
      label444:
      locala.a(2131235141, 2131101430, (String)localObject, i);
      locala.dy(true);
      locala.oG(Color.parseColor("#0E9CE6"));
      localRecordConfigProvider.BOn = locala.apG();
      localRecordConfigProvider.BOu = Boolean.TRUE;
      localRecordConfigProvider.BOr = Boolean.FALSE;
      localRecordConfigProvider.BOF = 86400000L;
      localRecordConfigProvider.BOG = false;
      localRecordConfigProvider.BOp = 1;
      localRecordConfigProvider.BOH = true;
      localRecordConfigProvider.BOI = true;
      localObject = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject).sQn = 7;
      ((VideoCaptureReportInfo)localObject).rna = paramInt;
      ((VideoCaptureReportInfo)localObject).twG = paramLong;
      localRecordConfigProvider.BOE = ((VideoCaptureReportInfo)localObject);
      localRecordConfigProvider.BOq = Boolean.TRUE;
      bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZC, false);
      localObject = g.aAh();
      p.g(localObject, "storage()");
      if ((((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.Ogd, 0) != 1) && (!bool)) {
        break label741;
      }
      paramInt = 1;
      label636:
      localRecordConfigProvider.F(1, Image2VideoPluginLayout.class.getName());
      if (paramInt == 0) {
        break label746;
      }
      localRecordConfigProvider.F(3, VLogPreviewPluginLayout.class.getName());
      localRecordConfigProvider.F(4, VLogPreviewPluginLayout.class.getName());
    }
    for (;;)
    {
      CaptureDataManager.BOb.a((CaptureDataManager.b)this);
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYM, true))
      {
        localObject = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(paramContext, 0, -1, -1, localRecordConfigProvider);
      }
      AppMethodBeat.o(118961);
      return;
      bool = false;
      break;
      label735:
      localObject = null;
      break label444;
      label741:
      paramInt = 0;
      break label636;
      label746:
      localRecordConfigProvider.F(3, Image2VideoPluginLayout.class.getName());
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    a(com.tencent.mm.plugin.recordvideo.background.c paramc, String paramString, eds parameds, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(Bundle paramBundle, String paramString1, String paramString2, String paramString3, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "storyLocalId", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
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