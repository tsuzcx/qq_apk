package com.tencent.mm.plugin.story.proxy;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.story.model.g.c;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "()V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/GetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "isCaptureVideo", "", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "isImageVideo", "scope", "favorite", "videoPath", "mediaDes", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getRecommendMusic", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "callback", "getRecommendMusicCallback", "respBytes", "", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "set", "Companion", "plugin-story_release"})
public final class d
  implements a
{
  private static final String TAG = "MicroMsg.StoryProxy";
  private static final d sDA;
  public static final d.a sDB;
  
  static
  {
    AppMethodBeat.i(109760);
    sDB = new d.a((byte)0);
    TAG = "MicroMsg.StoryProxy";
    sDA = new d();
    AppMethodBeat.o(109760);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(109756);
    if (ah.brt())
    {
      localObject = com.tencent.mm.kernel.g.RL();
      a.f.b.j.p(localObject, "MMKernel.storage()");
      localObject = ((e)localObject).getAccPath();
      a.f.b.j.p(localObject, "MMKernel.storage().accPath");
      AppMethodBeat.o(109756);
      return localObject;
    }
    Object localObject = StoryCaptureProxy.sCS;
    localObject = StoryCaptureProxy.access$getInstance$cp().getAccPath();
    AppMethodBeat.o(109756);
    return localObject;
  }
  
  public static VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(109757);
    if (ah.brt())
    {
      localObject = com.tencent.mm.modelcontrol.d.afW();
      a.f.b.j.p(localObject, "SubCoreVideoControl.getCore()");
      localObject = ((com.tencent.mm.modelcontrol.d)localObject).aga();
      a.f.b.j.p(localObject, "SubCoreVideoControl.getCore().storyRecordVideoPara");
      AppMethodBeat.o(109757);
      return localObject;
    }
    Object localObject = StoryCaptureProxy.sCS;
    localObject = StoryCaptureProxy.access$getInstance$cp().getVideoPara();
    AppMethodBeat.o(109757);
    return localObject;
  }
  
  public final int commitStory(com.tencent.mm.plugin.story.h.d paramd, String paramString, chj paramchj, boolean paramBoolean1, chk paramchk, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155305);
    a.f.b.j.q(paramd, "storyEditorData");
    a.f.b.j.q(paramString, "thumbPath");
    a.f.b.j.q(paramchj, "location");
    a.f.b.j.q(paramchk, "editorInfo");
    if (ah.brt())
    {
      localObject = new com.tencent.mm.plugin.story.model.g.d();
      bby localbby = new bby();
      StoryCaptureProxy.a locala = StoryCaptureProxy.sCS;
      ab.i(StoryCaptureProxy.access$getTAG$cp(), "storyEditorData " + paramd.systemRowid + " isCaptureVideo:" + paramBoolean1 + " scope:" + paramInt1);
      localbby.xra = paramBoolean1;
      ((com.tencent.mm.plugin.story.model.g.d)localObject).a(paramd, paramString);
      ((com.tencent.mm.plugin.story.model.g.d)localObject).a(paramchk);
      ((com.tencent.mm.plugin.story.model.g.d)localObject).a(paramchj);
      ((com.tencent.mm.plugin.story.model.g.d)localObject).a(localbby);
      ((com.tencent.mm.plugin.story.model.g.d)localObject).FJ(paramInt1);
      ((com.tencent.mm.plugin.story.model.g.d)localObject).FK(paramInt2);
      ((com.tencent.mm.plugin.story.model.g.d)localObject).lV(paramBoolean2);
      paramInt1 = ((com.tencent.mm.plugin.story.model.g.d)localObject).commit();
      paramd = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAI().checkPost();
      AppMethodBeat.o(155305);
      return paramInt1;
    }
    Object localObject = StoryCaptureProxy.sCS;
    paramInt1 = StoryCaptureProxy.access$getInstance$cp().commitStory(paramd, paramString, paramchj, paramBoolean1, paramchk, paramBoolean2, paramInt1, 0);
    AppMethodBeat.o(155305);
    return paramInt1;
  }
  
  public final int commitStory(String paramString1, String paramString2, String paramString3, chj paramchj, boolean paramBoolean, chk paramchk, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138832);
    a.f.b.j.q(paramString1, "videoPath");
    a.f.b.j.q(paramString2, "thumbPath");
    a.f.b.j.q(paramString3, "mediaDes");
    a.f.b.j.q(paramchj, "location");
    a.f.b.j.q(paramchk, "editorInfo");
    if (ah.brt())
    {
      localObject = com.tencent.mm.c.g.getMD5(paramString1);
      com.tencent.mm.plugin.story.model.g.d locald = new com.tencent.mm.plugin.story.model.g.d();
      bby localbby = new bby();
      StoryCaptureProxy.a locala = StoryCaptureProxy.sCS;
      ab.i(StoryCaptureProxy.access$getTAG$cp(), "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + (String)localObject + " isCaptureVideo:" + paramBoolean + " scope:" + paramInt1);
      localbby.xra = paramBoolean;
      a.f.b.j.p(localObject, "md5");
      locald.aq(paramString1, paramString2, (String)localObject);
      locald.a(paramchj);
      locald.a(paramchk);
      locald.a(localbby);
      locald.FJ(paramInt1);
      locald.FK(paramInt2);
      paramInt1 = locald.commit();
      paramString1 = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAI().checkPost();
      AppMethodBeat.o(138832);
      return paramInt1;
    }
    Object localObject = StoryCaptureProxy.sCS;
    paramInt1 = StoryCaptureProxy.access$getInstance$cp().commitStory(paramString1, paramString2, paramString3, paramchj, paramBoolean, paramchk, paramInt1, 0);
    AppMethodBeat.o(138832);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.d
 * JD-Core Version:    0.7.0.1
 */