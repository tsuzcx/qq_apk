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
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.c.a.g.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.ui.StoryCaptureUI;
import com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ao;
import d.g.b.k;
import d.v;
import d.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/mix/StoryMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "TAG", "", "remuxTaskMap", "Ljava/util/HashMap;", "", "getRemuxTaskMap", "()Ljava/util/HashMap;", "cleanNullData", "", "taskId", "cleanUnAvailableData", "data", "Lcom/tencent/mm/protocal/protobuf/EditorProtoData;", "commit", "storyEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "thumbPath", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "onFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "retId", "videoPath", "extraBundle", "Landroid/os/Bundle;", "mediaDes", "resId", "genStoryEditorReportInfo", "videoEditData", "getEditDataByLocalId", "localId", "getEditDataByTaskId", "getFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "context", "Landroid/content/Context;", "getImageFakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onFinishBtnClick", "extData", "controller", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onInit", "onMediaGenerated", "onRun", "runNum", "onWait", "remuxMedia", "startStoryCapture", "entranceScene", "videoObjectId", "", "updateByTaskId", "editorData", "plugin-story_release"})
public final class a
  implements com.tencent.mm.plugin.recordvideo.background.b, CaptureDataManager.b
{
  private static final HashMap<Integer, String> yhW;
  public static final a yhX;
  
  static
  {
    AppMethodBeat.i(118965);
    Object localObject = new a();
    yhX = (a)localObject;
    yhW = new HashMap();
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.vdo;
    com.tencent.mm.plugin.recordvideo.background.a.a(3, (com.tencent.mm.plugin.recordvideo.background.b)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.background.a.vdo;
    com.tencent.mm.plugin.recordvideo.background.a.a(6, (com.tencent.mm.plugin.recordvideo.background.b)b.yif);
    AppMethodBeat.o(118965);
  }
  
  public static com.tencent.mm.plugin.recordvideo.background.d Oq(int paramInt)
  {
    AppMethodBeat.i(118958);
    Object localObject2 = (String)yhW.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    k.g(localObject1, "remuxTaskMap[localId] ?: \"\"");
    localObject2 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    localObject1 = com.tencent.mm.plugin.recordvideo.background.f.alz((String)localObject1);
    AppMethodBeat.o(118958);
    return localObject1;
  }
  
  public static void a(com.tencent.mm.plugin.recordvideo.background.d paramd, final String paramString, final cyl paramcyl, final d.g.a.b<? super Integer, y> paramb)
  {
    AppMethodBeat.i(118955);
    k.h(paramd, "storyEditorData");
    k.h(paramString, "thumbPath");
    k.h(paramcyl, "editorInfo");
    k.h(paramb, "onFinish");
    com.tencent.mm.ad.c.b("StoryCapture_commit", (d.g.a.a)new a(paramd, paramString, paramcyl, paramb));
    AppMethodBeat.o(118955);
  }
  
  public static void alB(String paramString)
  {
    AppMethodBeat.i(118959);
    k.h(paramString, "taskId");
    ad.i("MicroMsg.StoryMixManager", "run cleanNullData data");
    com.tencent.mm.plugin.recordvideo.background.f localf = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    com.tencent.mm.plugin.recordvideo.background.f.alB(paramString);
    AppMethodBeat.o(118959);
  }
  
  public static void alC(String paramString)
  {
    AppMethodBeat.i(118960);
    k.h(paramString, "taskId");
    ad.i("MicroMsg.StoryMixManager", "run cleanUnAvailableData data");
    com.tencent.mm.plugin.recordvideo.background.f localf = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    com.tencent.mm.plugin.recordvideo.background.f.alC(paramString);
    AppMethodBeat.o(118960);
  }
  
  public static void arD(String paramString)
  {
    AppMethodBeat.i(118956);
    k.h(paramString, "taskId");
    com.tencent.mm.plugin.recordvideo.background.f localf = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    com.tencent.mm.plugin.recordvideo.background.f.alD(paramString);
    AppMethodBeat.o(118956);
  }
  
  private static cyl d(com.tencent.mm.plugin.recordvideo.background.d paramd)
  {
    AppMethodBeat.i(118954);
    cyl localcyl = new cyl();
    acq localacq = new acq();
    Object localObject1 = (com.tencent.mm.bx.a)localacq;
    paramd = paramd.field_baseItemData;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom(paramd);
      paramd = localacq.Dde;
      k.g(paramd, "editProtoData.baseItemData");
      paramd = ((Iterable)paramd).iterator();
      for (;;)
      {
        if (!paramd.hasNext()) {
          break label255;
        }
        localObject1 = (in)paramd.next();
        i = ((in)localObject1).dataType;
        if (i != com.tencent.mm.media.editor.a.e.goG.value) {
          break;
        }
        localObject2 = new dbn();
        ((dbn)localObject2).parseFrom(z.a(((in)localObject1).CEe));
        localcyl.EqC.add(((dbn)localObject2).text.toString());
      }
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        int i;
        Object localObject2;
        ad.l("safeParser", "", new Object[] { paramd });
        continue;
        if (i == com.tencent.mm.media.editor.a.e.goH.value)
        {
          localObject2 = new acu();
          ((acu)localObject2).parseFrom(z.a(((in)localObject1).CEe));
          localcyl.EqB.add(((acu)localObject2).md5);
        }
        else if (i == com.tencent.mm.media.editor.a.e.goJ.value)
        {
          localObject2 = new dbn();
          ((dbn)localObject2).parseFrom(z.a(((in)localObject1).CEe));
          localcyl.zVL = ((dbn)localObject2).text.toString();
        }
      }
    }
    label255:
    if (bt.isNullOrNil(localacq.gtC)) {
      localcyl.EqA = false;
    }
    for (;;)
    {
      AppMethodBeat.o(118954);
      return localcyl;
      localcyl.EqA = true;
      localcyl.viz = localacq.viz;
      localcyl.Ddh = localacq.Ddh;
      localcyl.Eqz = localacq.Ddi;
    }
  }
  
  public static HashMap<Integer, String> dIa()
  {
    return yhW;
  }
  
  public static void dIb()
  {
    AppMethodBeat.i(118957);
    com.tencent.mm.plugin.recordvideo.background.f localf = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    com.tencent.mm.plugin.recordvideo.background.f.dgO();
    AppMethodBeat.o(118957);
  }
  
  public static FakeVideoViewLayer gf(Context paramContext)
  {
    AppMethodBeat.i(118962);
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.vdo;
    paramContext = com.tencent.mm.plugin.recordvideo.background.a.fI(paramContext);
    AppMethodBeat.o(118962);
    return paramContext;
  }
  
  public static com.tencent.mm.plugin.recordvideo.ui.editor.d gg(Context paramContext)
  {
    AppMethodBeat.i(118963);
    com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.vdo;
    paramContext = com.tencent.mm.plugin.recordvideo.background.a.fJ(paramContext);
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
      paramCaptureVideoNormalModel = new aer().parseFrom(paramBundle.getByteArray("key_bg_generate_extra_config"));
      paramContext = (VideoMixer.MixConfig)paramBundle.getParcelable("key_bg_generate_mix_config");
      localObject = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      paramBundle = paramBundle.getByteArray("key_bg_generate_pb");
      k.g(paramBundle, "extData.getByteArray(KEY_BG_GENERATE_PB)");
      k.g(paramContext, "mixConfig");
      paramCaptureVideoNormalModel = paramCaptureVideoNormalModel.toByteArray();
      k.g(paramCaptureVideoNormalModel, "extraConfig.toByteArray()");
      com.tencent.mm.plugin.recordvideo.background.f.a(paramBundle, paramContext, paramCaptureVideoNormalModel);
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
      str = paramCaptureVideoNormalModel.anX();
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
    com.tencent.mm.ad.c.b("StoryCapture_commit", (d.g.a.a)new b(new Bundle(paramBundle), (String)localObject, paramCaptureVideoNormalModel, "", (d.g.a.b)a.d.yie));
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
    ad.i("MicroMsg.StoryMixManager", "onFinish, success:" + paramBoolean + " taskId:" + paramString);
    Object localObject1 = yhW.entrySet();
    k.g(localObject1, "remuxTaskMap.entries");
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (!bt.kU((String)((Map.Entry)localObject2).getValue(), paramString)) {
        break label381;
      }
      localObject2 = ((Map.Entry)localObject2).getKey();
      k.g(localObject2, "it.key");
      i = ((Number)localObject2).intValue();
      ad.i("MicroMsg.StoryMixManager", "found localId:".concat(String.valueOf(i)));
    }
    label378:
    label381:
    for (;;)
    {
      break;
      if (paramBoolean)
      {
        yhW.remove(Integer.valueOf(i));
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
          localObject2 = paramCaptureVideoNormalModel.anX();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localObject2 = com.tencent.mm.plugin.story.g.j.ylv;
        com.tencent.mm.plugin.story.g.j.d(i, paramString, (String)localObject1);
        paramString = com.tencent.mm.plugin.story.f.j.yfh;
        j.b.dHj().dIw();
        if (paramCaptureVideoNormalModel != null)
        {
          paramString = paramCaptureVideoNormalModel.dhD();
          if (paramString != null)
          {
            paramBoolean = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqz, true);
            paramCaptureVideoNormalModel = paramString.w("KEY_IS_CAPUTRE_BOOLEAN", Boolean.FALSE);
            k.g(paramCaptureVideoNormalModel, "getReportValue(RecordMed…IS_CAPUTRE_BOOLEAN,false)");
            if ((((Boolean)paramCaptureVideoNormalModel).booleanValue()) && (paramBoolean))
            {
              paramCaptureVideoNormalModel = com.tencent.mm.plugin.recordvideo.e.b.vtE;
              com.tencent.mm.plugin.recordvideo.e.b.aiz((String)paramString.w("KEY_CAPUTRE_VIDEO_PATH_STRING", ""));
              paramCaptureVideoNormalModel = com.tencent.mm.plugin.recordvideo.e.b.vtE;
              com.tencent.mm.plugin.recordvideo.e.b.aiz((String)paramString.w("KEY_CAPUTRE_THUMB_PATH_STRING", ""));
            }
            AppMethodBeat.o(118953);
            return;
          }
        }
        AppMethodBeat.o(118953);
        return;
        paramString = com.tencent.mm.plugin.story.h.f.ymW;
        com.tencent.mm.plugin.story.h.f.diD();
        paramString = com.tencent.mm.plugin.story.g.j.ylv;
        com.tencent.mm.plugin.story.g.j.Oy(i);
        AppMethodBeat.o(118953);
        return;
      }
    }
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final void acu(String paramString)
  {
    AppMethodBeat.i(118950);
    k.h(paramString, "taskId");
    ad.i("MicroMsg.StoryMixManager", "onInit, taskId:".concat(String.valueOf(paramString)));
    Object localObject = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    localObject = com.tencent.mm.plugin.recordvideo.background.f.alz(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(118950);
      return;
    }
    String str = ((com.tencent.mm.plugin.recordvideo.background.d)localObject).dgA().thumbPath;
    cyl localcyl = d((com.tencent.mm.plugin.recordvideo.background.d)localObject);
    final com.tencent.mm.media.j.a locala = new com.tencent.mm.media.j.a("runMixInBackground");
    k.g(str, "thumbPath");
    a((com.tencent.mm.plugin.recordvideo.background.d)localObject, str, localcyl, (d.g.a.b)new c(paramString, locala));
    AppMethodBeat.o(118950);
  }
  
  public final void acv(String paramString)
  {
    AppMethodBeat.i(118952);
    k.h(paramString, "taskId");
    ad.i("MicroMsg.StoryMixManager", "onWait, taskId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(118952);
  }
  
  public final void dr(String paramString, int paramInt)
  {
    AppMethodBeat.i(118951);
    k.h(paramString, "taskId");
    ad.i("MicroMsg.StoryMixManager", "onRun, taskId:" + paramString + " runNum:" + paramInt);
    AppMethodBeat.o(118951);
  }
  
  public final void startStoryCapture(Context paramContext, int paramInt, long paramLong)
  {
    AppMethodBeat.i(118961);
    if ((com.tencent.mm.plugin.voip.f.cd(paramContext)) || (com.tencent.mm.plugin.voip.f.ce(paramContext)) || (com.tencent.mm.bi.e.cc(paramContext)))
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
    ad.i("MicroMsg.StoryMixManager", "startStoryCapture %s", new Object[] { bt.eGN().toString() });
    boolean bool;
    if (com.tencent.mm.plugin.story.c.a.e.ydS.dGh())
    {
      localObject = g.afB();
      k.g(localObject, "storage()");
      bool = ((com.tencent.mm.kernel.e)localObject).afk().getBoolean(ae.a.FuS, false);
    }
    while (!bool)
    {
      localObject = new Intent(paramContext, StoryCaptureUI.class);
      ((Intent)localObject).putExtra("jump_page_from", paramInt);
      ((Intent)localObject).putExtra("video_object_id", paramLong);
      if (paramContext != null)
      {
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/story/model/mix/StoryMixManager", "startStoryCapture", "(Landroid/content/Context;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(118961);
        return;
        localObject = g.afB();
        k.g(localObject, "storage()");
        bool = ((com.tencent.mm.kernel.e)localObject).afk().getBoolean(ae.a.FuR, false);
      }
      else
      {
        AppMethodBeat.o(118961);
        return;
      }
    }
    RecordConfigProvider localRecordConfigProvider = RecordConfigProvider.a("", "", ((c.a)com.tencent.mm.plugin.story.c.a.c.ydE.ajp()).vhH, ((c.a)com.tencent.mm.plugin.story.c.a.c.ydE.ajp()).vhH.duration * 1000, 3);
    Object localObject = com.tencent.mm.plugin.story.f.j.yfh;
    if (j.b.dHn() == g.a.ydY)
    {
      bool = true;
      localRecordConfigProvider.vhO = Boolean.valueOf(bool);
      localRecordConfigProvider.vhR = true;
      UICustomParam.a locala = new UICustomParam.a();
      int i = ao.fromDPToPix(paramContext, 48);
      if (paramContext == null) {
        break label741;
      }
      localObject = paramContext.getString(2131764253);
      label450:
      locala.a(2131234264, 2131101185, (String)localObject, i);
      locala.cN(true);
      locala.li(Color.parseColor("#0E9CE6"));
      localRecordConfigProvider.vhI = locala.Yd();
      localRecordConfigProvider.vhP = Boolean.TRUE;
      localRecordConfigProvider.vhM = Boolean.FALSE;
      localRecordConfigProvider.vhZ = 86400000L;
      localRecordConfigProvider.vib = false;
      localRecordConfigProvider.vhK = 1;
      localRecordConfigProvider.vic = true;
      localRecordConfigProvider.vid = true;
      localObject = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject).pOf = 7;
      ((VideoCaptureReportInfo)localObject).oIw = paramInt;
      ((VideoCaptureReportInfo)localObject).vii = paramLong;
      localRecordConfigProvider.vhY = ((VideoCaptureReportInfo)localObject);
      localRecordConfigProvider.vhL = Boolean.TRUE;
      bool = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqP, false);
      localObject = g.afB();
      k.g(localObject, "storage()");
      if ((((com.tencent.mm.kernel.e)localObject).afk().getInt(ae.a.FsS, 0) != 1) && (!bool)) {
        break label747;
      }
      paramInt = 1;
      label642:
      localRecordConfigProvider.bx(1, Image2VideoPluginLayout.class.getName());
      if (paramInt == 0) {
        break label752;
      }
      localRecordConfigProvider.bx(3, VLogPreviewPluginLayout.class.getName());
      localRecordConfigProvider.bx(4, VLogPreviewPluginLayout.class.getName());
    }
    for (;;)
    {
      CaptureDataManager.vhw.a((CaptureDataManager.b)this);
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqd, true))
      {
        localObject = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(paramContext, 0, -1, -1, localRecordConfigProvider);
      }
      AppMethodBeat.o(118961);
      return;
      bool = false;
      break;
      label741:
      localObject = null;
      break label450;
      label747:
      paramInt = 0;
      break label642;
      label752:
      localRecordConfigProvider.bx(3, Image2VideoPluginLayout.class.getName());
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(com.tencent.mm.plugin.recordvideo.background.d paramd, String paramString, cyl paramcyl, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(Bundle paramBundle, String paramString1, String paramString2, String paramString3, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "storyLocalId", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.e.a
 * JD-Core Version:    0.7.0.1
 */