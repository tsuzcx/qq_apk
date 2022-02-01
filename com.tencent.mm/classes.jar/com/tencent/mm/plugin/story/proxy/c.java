package com.tencent.mm.plugin.story.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.xu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "()V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "taskId", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "set", "Companion", "plugin-story_release"})
public final class c
  implements a
{
  private static final String TAG = "MicroMsg.StoryProxy";
  private static final c ymi;
  public static final a ymj;
  
  static
  {
    AppMethodBeat.i(119383);
    ymj = new a((byte)0);
    TAG = "MicroMsg.StoryProxy";
    ymi = new c();
    AppMethodBeat.o(119383);
  }
  
  public static int commitStory(String paramString1, String paramString2, chx paramchx, xu paramxu, cyl paramcyl, int paramInt, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(119382);
    k.h(paramString1, "taskId");
    k.h(paramString2, "thumbPath");
    k.h(paramchx, "location");
    k.h(paramxu, "captureInfo");
    k.h(paramcyl, "editorInfo");
    k.h(paramList1, "groupList");
    k.h(paramList2, "blackList");
    if (aj.cbv())
    {
      localObject = new com.tencent.mm.plugin.story.f.g.d();
      boj localboj = new boj();
      StoryCaptureProxy.a locala = StoryCaptureProxy.ylM;
      ad.i(StoryCaptureProxy.access$getTAG$cp(), "storyEditorData " + paramString1 + " isCaptureVideo:" + paramxu.gBl + " scope:" + paramInt);
      localboj.DLK = paramxu.gBl;
      ((com.tencent.mm.plugin.story.f.g.d)localObject).jr(paramString1, paramString2);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).a(paramcyl);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).b(paramchx);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).a(localboj);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).Or(paramInt);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).fU(paramList1);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).fV(paramList2);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).qI(paramxu.vgr);
      paramInt = ((com.tencent.mm.plugin.story.f.g.d)localObject).commit();
      paramString1 = j.yfh;
      j.b.dHj().checkPost();
      AppMethodBeat.o(119382);
      return paramInt;
    }
    Object localObject = StoryCaptureProxy.ylM;
    paramInt = StoryCaptureProxy.a.dIJ().commitStory(paramString1, paramString2, paramchx, paramxu, paramcyl, paramInt, paramList1, paramList2);
    AppMethodBeat.o(119382);
    return paramInt;
  }
  
  public static VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(119380);
    if (aj.cbv())
    {
      localObject = com.tencent.mm.modelcontrol.d.awT();
      k.g(localObject, "SubCoreVideoControl.getCore()");
      localObject = ((com.tencent.mm.modelcontrol.d)localObject).awX();
      k.g(localObject, "SubCoreVideoControl.getCore().storyRecordVideoPara");
      AppMethodBeat.o(119380);
      return localObject;
    }
    Object localObject = StoryCaptureProxy.ylM;
    localObject = StoryCaptureProxy.a.dIJ().getVideoPara();
    AppMethodBeat.o(119380);
    return localObject;
  }
  
  public final int commitStory(String paramString1, String paramString2, String paramString3, chx paramchx, boolean paramBoolean, cyl paramcyl, int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(119381);
    k.h(paramString1, "videoPath");
    k.h(paramString2, "thumbPath");
    k.h(paramString3, "mediaDes");
    k.h(paramchx, "location");
    k.h(paramcyl, "editorInfo");
    k.h(paramList1, "groupList");
    k.h(paramList2, "blackList");
    if (aj.cbv())
    {
      localObject = g.getMD5(paramString1);
      com.tencent.mm.plugin.story.f.g.d locald = new com.tencent.mm.plugin.story.f.g.d();
      boj localboj = new boj();
      StoryCaptureProxy.a locala = StoryCaptureProxy.ylM;
      ad.i(StoryCaptureProxy.access$getTAG$cp(), "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + (String)localObject + " isCaptureVideo:" + paramBoolean + " scope:" + paramInt1);
      localboj.DLK = paramBoolean;
      k.g(localObject, "md5");
      locald.aB(paramString1, paramString2, (String)localObject);
      locald.b(paramchx);
      locald.a(paramcyl);
      locald.a(localboj);
      locald.Or(paramInt1);
      locald.fU(paramList1);
      locald.fV(paramList2);
      paramInt1 = locald.commit();
      paramString1 = j.yfh;
      j.b.dHj().checkPost();
      AppMethodBeat.o(119381);
      return paramInt1;
    }
    Object localObject = StoryCaptureProxy.ylM;
    paramInt1 = a.a.a(StoryCaptureProxy.a.dIJ(), paramString1, paramString2, paramString3, paramchx, paramBoolean, paramcyl, paramInt1, paramList1, paramList2);
    AppMethodBeat.o(119381);
    return paramInt1;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/proxy/StoryProxy$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.c
 * JD-Core Version:    0.7.0.1
 */