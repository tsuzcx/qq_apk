package com.tencent.mm.plugin.story.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "()V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "taskId", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "set", "Companion", "plugin-story_release"})
public final class c
  implements a
{
  private static final c ARg;
  public static final c.a ARh;
  private static final String TAG = "MicroMsg.StoryProxy";
  
  static
  {
    AppMethodBeat.i(119383);
    ARh = new c.a((byte)0);
    TAG = "MicroMsg.StoryProxy";
    ARg = new c();
    AppMethodBeat.o(119383);
  }
  
  public static int commitStory(String paramString1, String paramString2, csd paramcsd, aal paramaal, djk paramdjk, int paramInt, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(119382);
    p.h(paramString1, "taskId");
    p.h(paramString2, "thumbPath");
    p.h(paramcsd, "location");
    p.h(paramaal, "captureInfo");
    p.h(paramdjk, "editorInfo");
    p.h(paramList1, "groupList");
    p.h(paramList2, "blackList");
    if (aj.cnC())
    {
      localObject = new com.tencent.mm.plugin.story.f.g.d();
      bxm localbxm = new bxm();
      StoryCaptureProxy.a locala = StoryCaptureProxy.AQK;
      ad.i(StoryCaptureProxy.access$getTAG$cp(), "storyEditorData " + paramString1 + " isCaptureVideo:" + paramaal.htP + " scope:" + paramInt);
      localbxm.GRA = paramaal.htP;
      ((com.tencent.mm.plugin.story.f.g.d)localObject).ke(paramString1, paramString2);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).a(paramdjk);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).b(paramcsd);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).a(localbxm);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).Sg(paramInt);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).gn(paramList1);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).go(paramList2);
      ((com.tencent.mm.plugin.story.f.g.d)localObject).sm(paramaal.xwT);
      paramInt = ((com.tencent.mm.plugin.story.f.g.d)localObject).commit();
      paramString1 = j.AKb;
      j.b.ehZ().checkPost();
      AppMethodBeat.o(119382);
      return paramInt;
    }
    Object localObject = StoryCaptureProxy.AQK;
    paramInt = StoryCaptureProxy.a.ejz().commitStory(paramString1, paramString2, paramcsd, paramaal, paramdjk, paramInt, paramList1, paramList2);
    AppMethodBeat.o(119382);
    return paramInt;
  }
  
  public static VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(119380);
    if (aj.cnC())
    {
      localObject = com.tencent.mm.modelcontrol.d.aGQ();
      p.g(localObject, "SubCoreVideoControl.getCore()");
      localObject = ((com.tencent.mm.modelcontrol.d)localObject).aGU();
      p.g(localObject, "SubCoreVideoControl.getCore().storyRecordVideoPara");
      AppMethodBeat.o(119380);
      return localObject;
    }
    Object localObject = StoryCaptureProxy.AQK;
    localObject = StoryCaptureProxy.a.ejz().getVideoPara();
    AppMethodBeat.o(119380);
    return localObject;
  }
  
  public final int commitStory(String paramString1, String paramString2, String paramString3, csd paramcsd, boolean paramBoolean, djk paramdjk, int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(119381);
    p.h(paramString1, "videoPath");
    p.h(paramString2, "thumbPath");
    p.h(paramString3, "mediaDes");
    p.h(paramcsd, "location");
    p.h(paramdjk, "editorInfo");
    p.h(paramList1, "groupList");
    p.h(paramList2, "blackList");
    if (aj.cnC())
    {
      localObject = g.getMD5(paramString1);
      com.tencent.mm.plugin.story.f.g.d locald = new com.tencent.mm.plugin.story.f.g.d();
      bxm localbxm = new bxm();
      StoryCaptureProxy.a locala = StoryCaptureProxy.AQK;
      ad.i(StoryCaptureProxy.access$getTAG$cp(), "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + (String)localObject + " isCaptureVideo:" + paramBoolean + " scope:" + paramInt1);
      localbxm.GRA = paramBoolean;
      p.g(localObject, "md5");
      locald.aK(paramString1, paramString2, (String)localObject);
      locald.b(paramcsd);
      locald.a(paramdjk);
      locald.a(localbxm);
      locald.Sg(paramInt1);
      locald.gn(paramList1);
      locald.go(paramList2);
      paramInt1 = locald.commit();
      paramString1 = j.AKb;
      j.b.ehZ().checkPost();
      AppMethodBeat.o(119381);
      return paramInt1;
    }
    Object localObject = StoryCaptureProxy.AQK;
    paramInt1 = a.a.a(StoryCaptureProxy.a.ejz(), paramString1, paramString2, paramString3, paramcsd, paramBoolean, paramdjk, paramInt1, paramList1, paramList2);
    AppMethodBeat.o(119381);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.c
 * JD-Core Version:    0.7.0.1
 */