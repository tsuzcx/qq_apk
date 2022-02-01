package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryVideoLogic;", "", "()V", "STORY_VIDEO_PREFIX", "", "TAG", "createForFake", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "createForPost", "", "storyId", "", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "genCdnMediaId", "createTime", "", "url", "genFileName", "snsLocalId", "getOrCreate", "getStoryVideoDir", "getStoryVideoPath", "getStoryVideoTmpPath", "plugin-story_release"})
public final class s
{
  private static final String BcF = "STORY_";
  public static final s BcG;
  private static final String TAG = "MicroMsg.StoryVideoLogic";
  
  static
  {
    AppMethodBeat.i(118795);
    BcG = new s();
    TAG = "MicroMsg.StoryVideoLogic";
    BcF = "STORY_";
    AppMethodBeat.o(118795);
  }
  
  public static n a(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(118793);
    p.h(paramj, "videoItem");
    if (paramj.emu())
    {
      paramj = b(paramj);
      AppMethodBeat.o(118793);
      return paramj;
    }
    String str = a(paramj.Bem, paramj.username);
    Object localObject = l.BbR;
    if (str == null) {}
    for (localObject = "";; localObject = str)
    {
      l.axq((String)localObject);
      localObject = j.BbE;
      localObject = j.b.elF().Bx(paramj.dLI);
      if (localObject == null)
      {
        localObject = new n();
        ((n)localObject).field_storyId = paramj.dLI;
        ((n)localObject).field_url = paramj.Bem.Url;
        ((n)localObject).field_cacheSize = 0;
        ((n)localObject).field_totalSize = 0;
        ((n)localObject).field_filePath = str;
        paramj = j.BbE;
        j.b.elF().a((n)localObject);
      }
      for (paramj = (com.tencent.mm.plugin.story.f.d.j)localObject;; paramj = (com.tencent.mm.plugin.story.f.d.j)localObject)
      {
        localObject = (CharSequence)paramj.field_filePath;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            paramj.field_filePath = str;
          }
          AppMethodBeat.o(118793);
          return paramj;
        }
      }
    }
  }
  
  public static String a(dkg paramdkg)
  {
    AppMethodBeat.i(118792);
    if (paramdkg == null)
    {
      AppMethodBeat.o(118792);
      return null;
    }
    l locall = l.BbR;
    paramdkg = l.aDa(paramdkg.Id);
    AppMethodBeat.o(118792);
    return paramdkg;
  }
  
  public static String a(dkg paramdkg, String paramString)
  {
    AppMethodBeat.i(118791);
    if (paramdkg == null)
    {
      AppMethodBeat.o(118791);
      return null;
    }
    l locall = l.BbR;
    paramdkg = l.kk(paramdkg.Url, paramString);
    ae.i(TAG, "get story video path %s", new Object[] { paramdkg });
    AppMethodBeat.o(118791);
    return paramdkg;
  }
  
  public static String aDh(String paramString)
  {
    AppMethodBeat.i(118790);
    Object localObject = l.BbR;
    localObject = com.tencent.mm.vfs.o.k(l.aCY(paramString) + "video/", true);
    p.g(localObject, "VFSFileOp.exportExternal…rname) + VIDEOFILE, true)");
    ae.i(TAG, "get story video dir %s username %s", new Object[] { localObject, paramString });
    AppMethodBeat.o(118790);
    return localObject;
  }
  
  private static n b(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    n localn = null;
    AppMethodBeat.i(118794);
    p.h(paramj, "videoItem");
    Object localObject3 = (a)new agh();
    Object localObject1 = paramj.Ben;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject1).field_baseItemData;; localObject1 = null)
    {
      try
      {
        ((a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = localObject3;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          ae.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
      localObject3 = (agh)localObject1;
      localObject1 = localn;
      if (localObject3 != null) {
        localObject1 = ((agh)localObject3).videoPath;
      }
      i = (int)com.tencent.mm.vfs.o.aZR((String)localObject1);
      localn = new n();
      localn.field_storyId = paramj.dLI;
      localn.field_url = "";
      localn.field_cacheSize = i;
      localn.field_totalSize = i;
      localn.field_filePath = ((String)localObject1);
      AppMethodBeat.o(118794);
      return localn;
    }
  }
  
  public static String cb(int paramInt, String paramString)
  {
    AppMethodBeat.i(118789);
    if (paramString == null) {}
    for (paramString = "story_local_video_".concat(String.valueOf(paramInt)); bu.isNullOrNil(paramString); paramString = com.tencent.mm.an.c.a("storyvideo", paramInt, "story", paramString))
    {
      AppMethodBeat.o(118789);
      return null;
    }
    AppMethodBeat.o(118789);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.s
 * JD-Core Version:    0.7.0.1
 */