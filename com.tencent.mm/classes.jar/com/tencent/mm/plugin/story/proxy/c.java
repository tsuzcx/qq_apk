package com.tencent.mm.plugin.story.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.story.f.g.d;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.protocal.protobuf.ent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "()V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "taskId", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "srcMd5List", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "set", "Companion", "plugin-story_release"})
public final class c
  implements a
{
  private static final c LNx;
  public static final a LNy;
  private static final String TAG = "MicroMsg.StoryProxy";
  
  static
  {
    AppMethodBeat.i(119383);
    LNy = new a((byte)0);
    TAG = "MicroMsg.StoryProxy";
    LNx = new c();
    AppMethodBeat.o(119383);
  }
  
  public static VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(119380);
    if (MMApplicationContext.isMMProcess())
    {
      localObject = e.bkp();
      p.j(localObject, "SubCoreVideoControl.getCore()");
      localObject = ((e)localObject).bkt();
      p.j(localObject, "SubCoreVideoControl.getCore().storyRecordVideoPara");
      AppMethodBeat.o(119380);
      return localObject;
    }
    Object localObject = StoryCaptureProxy.LNb;
    localObject = StoryCaptureProxy.a.gec().getVideoPara();
    AppMethodBeat.o(119380);
    return localObject;
  }
  
  public final int commitStory(String paramString1, String paramString2, duy paramduy, acn paramacn, ent parament, int paramInt, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    AppMethodBeat.i(221190);
    p.k(paramString1, "taskId");
    p.k(paramString2, "thumbPath");
    p.k(paramduy, "location");
    p.k(paramacn, "captureInfo");
    p.k(parament, "editorInfo");
    p.k(paramList1, "groupList");
    p.k(paramList2, "blackList");
    p.k(paramList3, "srcMd5List");
    if (MMApplicationContext.isMMProcess())
    {
      d locald = new d();
      cuv localcuv = new cuv();
      StoryCaptureProxy.a locala = StoryCaptureProxy.LNb;
      Log.i(StoryCaptureProxy.access$getTAG$cp(), "storyEditorData " + paramString1 + " isCaptureVideo:" + paramacn.lfl + " scope:" + paramInt);
      localcuv.TCA = paramacn.lfl;
      locald.lw(paramString1, paramString2);
      locald.a(parament);
      locald.b(paramduy);
      locald.a(localcuv);
      locald.aie(paramInt);
      locald.ib(paramList1);
      locald.ic(paramList2);
      locald.id(paramList3);
      locald.zs(paramacn.HJC);
      paramInt = locald.in();
      paramString1 = j.LGA;
      j.b.gcC().checkPost();
      AppMethodBeat.o(221190);
      return paramInt;
    }
    paramList3 = StoryCaptureProxy.LNb;
    paramInt = StoryCaptureProxy.a.gec().commitStory(paramString1, paramString2, paramduy, paramacn, parament, paramInt, paramList1, paramList2, (List)new ArrayList());
    AppMethodBeat.o(221190);
    return paramInt;
  }
  
  public final int commitStory(String paramString1, String paramString2, String paramString3, duy paramduy, boolean paramBoolean, ent parament, int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    AppMethodBeat.i(221179);
    p.k(paramString1, "videoPath");
    p.k(paramString2, "thumbPath");
    p.k(paramString3, "mediaDes");
    p.k(paramduy, "location");
    p.k(parament, "editorInfo");
    p.k(paramList1, "groupList");
    p.k(paramList2, "blackList");
    p.k(paramList3, "srcMd5List");
    if (MMApplicationContext.isMMProcess())
    {
      String str = g.getMD5(paramString1);
      d locald = new d();
      cuv localcuv = new cuv();
      StoryCaptureProxy.a locala = StoryCaptureProxy.LNb;
      Log.i(StoryCaptureProxy.access$getTAG$cp(), "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + str + " isCaptureVideo:" + paramBoolean + " scope:" + paramInt1);
      localcuv.TCA = paramBoolean;
      p.j(str, "md5");
      locald.aP(paramString1, paramString2, str);
      locald.b(paramduy);
      locald.a(parament);
      locald.a(localcuv);
      locald.aie(paramInt1);
      locald.ib(paramList1);
      locald.ic(paramList2);
      locald.id(paramList3);
      paramInt1 = locald.in();
      paramString1 = j.LGA;
      j.b.gcC().checkPost();
      AppMethodBeat.o(221179);
      return paramInt1;
    }
    paramList3 = StoryCaptureProxy.LNb;
    paramInt1 = a.a.a(StoryCaptureProxy.a.gec(), paramString1, paramString2, paramString3, paramduy, paramBoolean, parament, paramInt1, paramList1, paramList2, null, 1152);
    AppMethodBeat.o(221179);
    return paramInt1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/proxy/StoryProxy$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.c
 * JD-Core Version:    0.7.0.1
 */