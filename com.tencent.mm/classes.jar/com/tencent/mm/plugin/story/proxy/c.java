package com.tencent.mm.plugin.story.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.story.f.g.d;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "()V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "taskId", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "srcMd5List", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "set", "Companion", "plugin-story_release"})
public final class c
  implements a
{
  private static final c Ftu;
  public static final a Ftv;
  private static final String TAG = "MicroMsg.StoryProxy";
  
  static
  {
    AppMethodBeat.i(119383);
    Ftv = new a((byte)0);
    TAG = "MicroMsg.StoryProxy";
    Ftu = new c();
    AppMethodBeat.o(119383);
  }
  
  public static VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(119380);
    if (MMApplicationContext.isMMProcess())
    {
      localObject = e.baZ();
      p.g(localObject, "SubCoreVideoControl.getCore()");
      localObject = ((e)localObject).bbd();
      p.g(localObject, "SubCoreVideoControl.getCore().storyRecordVideoPara");
      AppMethodBeat.o(119380);
      return localObject;
    }
    Object localObject = StoryCaptureProxy.FsY;
    localObject = StoryCaptureProxy.a.fpI().getVideoPara();
    AppMethodBeat.o(119380);
    return localObject;
  }
  
  public final int commitStory(String paramString1, String paramString2, dlg paramdlg, acg paramacg, eds parameds, int paramInt, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    AppMethodBeat.i(222918);
    p.h(paramString1, "taskId");
    p.h(paramString2, "thumbPath");
    p.h(paramdlg, "location");
    p.h(paramacg, "captureInfo");
    p.h(parameds, "editorInfo");
    p.h(paramList1, "groupList");
    p.h(paramList2, "blackList");
    p.h(paramList3, "srcMd5List");
    if (MMApplicationContext.isMMProcess())
    {
      d locald = new d();
      cly localcly = new cly();
      StoryCaptureProxy.a locala = StoryCaptureProxy.FsY;
      Log.i(StoryCaptureProxy.access$getTAG$cp(), "storyEditorData " + paramString1 + " isCaptureVideo:" + paramacg.iqf + " scope:" + paramInt);
      localcly.Mrn = paramacg.iqf;
      locald.kZ(paramString1, paramString2);
      locald.a(parameds);
      locald.b(paramdlg);
      locald.a(localcly);
      locald.aaJ(paramInt);
      locald.hs(paramList1);
      locald.ht(paramList2);
      locald.hu(paramList3);
      locald.vO(paramacg.BMX);
      paramInt = locald.commit();
      paramString1 = j.Fmy;
      j.b.foi().checkPost();
      AppMethodBeat.o(222918);
      return paramInt;
    }
    paramList3 = StoryCaptureProxy.FsY;
    paramInt = StoryCaptureProxy.a.fpI().commitStory(paramString1, paramString2, paramdlg, paramacg, parameds, paramInt, paramList1, paramList2, (List)new ArrayList());
    AppMethodBeat.o(222918);
    return paramInt;
  }
  
  public final int commitStory(String paramString1, String paramString2, String paramString3, dlg paramdlg, boolean paramBoolean, eds parameds, int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    AppMethodBeat.i(222917);
    p.h(paramString1, "videoPath");
    p.h(paramString2, "thumbPath");
    p.h(paramString3, "mediaDes");
    p.h(paramdlg, "location");
    p.h(parameds, "editorInfo");
    p.h(paramList1, "groupList");
    p.h(paramList2, "blackList");
    p.h(paramList3, "srcMd5List");
    if (MMApplicationContext.isMMProcess())
    {
      String str = g.getMD5(paramString1);
      d locald = new d();
      cly localcly = new cly();
      StoryCaptureProxy.a locala = StoryCaptureProxy.FsY;
      Log.i(StoryCaptureProxy.access$getTAG$cp(), "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + str + " isCaptureVideo:" + paramBoolean + " scope:" + paramInt1);
      localcly.Mrn = paramBoolean;
      p.g(str, "md5");
      locald.aV(paramString1, paramString2, str);
      locald.b(paramdlg);
      locald.a(parameds);
      locald.a(localcly);
      locald.aaJ(paramInt1);
      locald.hs(paramList1);
      locald.ht(paramList2);
      locald.hu(paramList3);
      paramInt1 = locald.commit();
      paramString1 = j.Fmy;
      j.b.foi().checkPost();
      AppMethodBeat.o(222917);
      return paramInt1;
    }
    paramList3 = StoryCaptureProxy.FsY;
    paramInt1 = a.a.a(StoryCaptureProxy.a.fpI(), paramString1, paramString2, paramString3, paramdlg, paramBoolean, parameds, paramInt1, paramList1, paramList2, null, 1152);
    AppMethodBeat.o(222917);
    return paramInt1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/proxy/StoryProxy$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.c
 * JD-Core Version:    0.7.0.1
 */