package com.tencent.mm.plugin.story.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.protocal.protobuf.ym;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "()V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "taskId", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "set", "Companion", "plugin-story_release"})
public final class c
  implements a
{
  private static final String TAG = "MicroMsg.StoryProxy";
  private static final c zzH;
  public static final c.a zzI;
  
  static
  {
    AppMethodBeat.i(119383);
    zzI = new c.a((byte)0);
    TAG = "MicroMsg.StoryProxy";
    zzH = new c();
    AppMethodBeat.o(119383);
  }
  
  public static int commitStory(String paramString1, String paramString2, cna paramcna, ym paramym, ddx paramddx, int paramInt, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(119382);
    k.h(paramString1, "taskId");
    k.h(paramString2, "thumbPath");
    k.h(paramcna, "location");
    k.h(paramym, "captureInfo");
    k.h(paramddx, "editorInfo");
    k.h(paramList1, "groupList");
    k.h(paramList2, "blackList");
    if (ai.ciE())
    {
      localObject = new com.tencent.mm.plugin.story.f.g.d();
      bsz localbsz = new bsz();
      StoryCaptureProxy.a locala = StoryCaptureProxy.zyL;
      ac.i(StoryCaptureProxy.access$getTAG$cp(), "storyEditorData " + paramString1 + " isCaptureVideo:" + paramym.hbH + " scope:" + paramInt);
      localbsz.FhZ = paramym.hbH;
      ((com.tencent.mm.plugin.story.f.g.d)localObject).jP(paramString1, paramString2);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).a(paramddx);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).b(paramcna);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).a(localbsz);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).Qx(paramInt);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).gc(paramList1);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).gd(paramList2);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).rG(paramym.wpd);
      paramInt = ((com.tencent.mm.plugin.story.f.g.d)localObject).commit();
      paramString1 = j.zsh;
      j.b.dVK().checkPost();
      AppMethodBeat.o(119382);
      return paramInt;
    }
    Object localObject = StoryCaptureProxy.zyL;
    paramInt = StoryCaptureProxy.a.dXk().commitStory(paramString1, paramString2, paramcna, paramym, paramddx, paramInt, paramList1, paramList2);
    AppMethodBeat.o(119382);
    return paramInt;
  }
  
  public static VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(119380);
    if (ai.ciE())
    {
      localObject = com.tencent.mm.modelcontrol.d.aDL();
      k.g(localObject, "SubCoreVideoControl.getCore()");
      localObject = ((com.tencent.mm.modelcontrol.d)localObject).aDP();
      k.g(localObject, "SubCoreVideoControl.getCore().storyRecordVideoPara");
      AppMethodBeat.o(119380);
      return localObject;
    }
    Object localObject = StoryCaptureProxy.zyL;
    localObject = StoryCaptureProxy.a.dXk().getVideoPara();
    AppMethodBeat.o(119380);
    return localObject;
  }
  
  public final int commitStory(String paramString1, String paramString2, String paramString3, cna paramcna, boolean paramBoolean, ddx paramddx, int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(119381);
    k.h(paramString1, "videoPath");
    k.h(paramString2, "thumbPath");
    k.h(paramString3, "mediaDes");
    k.h(paramcna, "location");
    k.h(paramddx, "editorInfo");
    k.h(paramList1, "groupList");
    k.h(paramList2, "blackList");
    if (ai.ciE())
    {
      localObject = g.getMD5(paramString1);
      com.tencent.mm.plugin.story.f.g.d locald = new com.tencent.mm.plugin.story.f.g.d();
      bsz localbsz = new bsz();
      StoryCaptureProxy.a locala = StoryCaptureProxy.zyL;
      ac.i(StoryCaptureProxy.access$getTAG$cp(), "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + (String)localObject + " isCaptureVideo:" + paramBoolean + " scope:" + paramInt1);
      localbsz.FhZ = paramBoolean;
      k.g(localObject, "md5");
      locald.aD(paramString1, paramString2, (String)localObject);
      locald.b(paramcna);
      locald.a(paramddx);
      locald.a(localbsz);
      locald.Qx(paramInt1);
      locald.gc(paramList1);
      locald.gd(paramList2);
      paramInt1 = locald.commit();
      paramString1 = j.zsh;
      j.b.dVK().checkPost();
      AppMethodBeat.o(119381);
      return paramInt1;
    }
    Object localObject = StoryCaptureProxy.zyL;
    paramInt1 = a.a.a(StoryCaptureProxy.a.dXk(), paramString1, paramString2, paramString3, paramcna, paramBoolean, paramddx, paramInt1, paramList1, paramList2);
    AppMethodBeat.o(119381);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.c
 * JD-Core Version:    0.7.0.1
 */