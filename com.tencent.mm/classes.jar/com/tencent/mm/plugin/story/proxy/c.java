package com.tencent.mm.plugin.story.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.protocal.protobuf.dkf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "()V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "taskId", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "set", "Companion", "plugin-story_release"})
public final class c
  implements a
{
  private static final c BiE;
  public static final c.a BiF;
  private static final String TAG = "MicroMsg.StoryProxy";
  
  static
  {
    AppMethodBeat.i(119383);
    BiF = new c.a((byte)0);
    TAG = "MicroMsg.StoryProxy";
    BiE = new c();
    AppMethodBeat.o(119383);
  }
  
  public static int commitStory(String paramString1, String paramString2, csx paramcsx, aao paramaao, dkf paramdkf, int paramInt, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(119382);
    p.h(paramString1, "taskId");
    p.h(paramString2, "thumbPath");
    p.h(paramcsx, "location");
    p.h(paramaao, "captureInfo");
    p.h(paramdkf, "editorInfo");
    p.h(paramList1, "groupList");
    p.h(paramList2, "blackList");
    if (ak.cpe())
    {
      localObject = new com.tencent.mm.plugin.story.f.g.d();
      byg localbyg = new byg();
      StoryCaptureProxy.a locala = StoryCaptureProxy.Bii;
      ae.i(StoryCaptureProxy.access$getTAG$cp(), "storyEditorData " + paramString1 + " isCaptureVideo:" + paramaao.hwD + " scope:" + paramInt);
      localbyg.Hlb = paramaao.hwD;
      ((com.tencent.mm.plugin.story.f.g.d)localObject).kl(paramString1, paramString2);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).a(paramdkf);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).b(paramcsx);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).a(localbyg);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).SN(paramInt);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).gw(paramList1);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).gx(paramList2);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).st(paramaao.xMQ);
      paramInt = ((com.tencent.mm.plugin.story.f.g.d)localObject).commit();
      paramString1 = j.BbE;
      j.b.elH().checkPost();
      AppMethodBeat.o(119382);
      return paramInt;
    }
    Object localObject = StoryCaptureProxy.Bii;
    paramInt = StoryCaptureProxy.a.eni().commitStory(paramString1, paramString2, paramcsx, paramaao, paramdkf, paramInt, paramList1, paramList2);
    AppMethodBeat.o(119382);
    return paramInt;
  }
  
  public static VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(119380);
    if (ak.cpe())
    {
      localObject = com.tencent.mm.modelcontrol.d.aHh();
      p.g(localObject, "SubCoreVideoControl.getCore()");
      localObject = ((com.tencent.mm.modelcontrol.d)localObject).aHl();
      p.g(localObject, "SubCoreVideoControl.getCore().storyRecordVideoPara");
      AppMethodBeat.o(119380);
      return localObject;
    }
    Object localObject = StoryCaptureProxy.Bii;
    localObject = StoryCaptureProxy.a.eni().getVideoPara();
    AppMethodBeat.o(119380);
    return localObject;
  }
  
  public final int commitStory(String paramString1, String paramString2, String paramString3, csx paramcsx, boolean paramBoolean, dkf paramdkf, int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(119381);
    p.h(paramString1, "videoPath");
    p.h(paramString2, "thumbPath");
    p.h(paramString3, "mediaDes");
    p.h(paramcsx, "location");
    p.h(paramdkf, "editorInfo");
    p.h(paramList1, "groupList");
    p.h(paramList2, "blackList");
    if (ak.cpe())
    {
      localObject = g.getMD5(paramString1);
      com.tencent.mm.plugin.story.f.g.d locald = new com.tencent.mm.plugin.story.f.g.d();
      byg localbyg = new byg();
      StoryCaptureProxy.a locala = StoryCaptureProxy.Bii;
      ae.i(StoryCaptureProxy.access$getTAG$cp(), "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + (String)localObject + " isCaptureVideo:" + paramBoolean + " scope:" + paramInt1);
      localbyg.Hlb = paramBoolean;
      p.g(localObject, "md5");
      locald.aK(paramString1, paramString2, (String)localObject);
      locald.b(paramcsx);
      locald.a(paramdkf);
      locald.a(localbyg);
      locald.SN(paramInt1);
      locald.gw(paramList1);
      locald.gx(paramList2);
      paramInt1 = locald.commit();
      paramString1 = j.BbE;
      j.b.elH().checkPost();
      AppMethodBeat.o(119381);
      return paramInt1;
    }
    Object localObject = StoryCaptureProxy.Bii;
    paramInt1 = a.a.a(StoryCaptureProxy.a.eni(), paramString1, paramString2, paramString3, paramcsx, paramBoolean, paramdkf, paramInt1, paramList1, paramList2);
    AppMethodBeat.o(119381);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.c
 * JD-Core Version:    0.7.0.1
 */