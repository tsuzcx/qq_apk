package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryVideoLogic;", "", "()V", "STORY_VIDEO_PREFIX", "", "TAG", "createForFake", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "createForPost", "", "storyId", "", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "genCdnMediaId", "createTime", "", "url", "genFileName", "snsLocalId", "getOrCreate", "getStoryVideoDir", "getStoryVideoPath", "getStoryVideoTmpPath", "plugin-story_release"})
public final class s
{
  private static final String TAG = "MicroMsg.StoryVideoLogic";
  private static final String ygi = "STORY_";
  public static final s ygj;
  
  static
  {
    AppMethodBeat.i(118795);
    ygj = new s();
    TAG = "MicroMsg.StoryVideoLogic";
    ygi = "STORY_";
    AppMethodBeat.o(118795);
  }
  
  public static n a(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(118793);
    k.h(paramj, "videoItem");
    if (paramj.dHW())
    {
      paramj = b(paramj);
      AppMethodBeat.o(118793);
      return paramj;
    }
    String str = a(paramj.yhP, paramj.username);
    Object localObject = l.yfu;
    if (str == null) {}
    for (localObject = "";; localObject = str)
    {
      l.alY((String)localObject);
      localObject = j.yfh;
      localObject = j.b.dHh().tY(paramj.dAu);
      if (localObject == null)
      {
        localObject = new n();
        ((n)localObject).field_storyId = paramj.dAu;
        ((n)localObject).field_url = paramj.yhP.Url;
        ((n)localObject).field_cacheSize = 0;
        ((n)localObject).field_totalSize = 0;
        ((n)localObject).field_filePath = str;
        paramj = j.yfh;
        j.b.dHh().a((n)localObject);
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
  
  public static String a(cym paramcym)
  {
    AppMethodBeat.i(118792);
    if (paramcym == null)
    {
      AppMethodBeat.o(118792);
      return null;
    }
    l locall = l.yfu;
    paramcym = l.art(paramcym.Id);
    AppMethodBeat.o(118792);
    return paramcym;
  }
  
  public static String a(cym paramcym, String paramString)
  {
    AppMethodBeat.i(118791);
    if (paramcym == null)
    {
      AppMethodBeat.o(118791);
      return null;
    }
    l locall = l.yfu;
    paramcym = l.jq(paramcym.Url, paramString);
    ad.i(TAG, "get story video path %s", new Object[] { paramcym });
    AppMethodBeat.o(118791);
    return paramcym;
  }
  
  public static String arB(String paramString)
  {
    AppMethodBeat.i(118790);
    Object localObject = l.yfu;
    localObject = i.k(l.arr(paramString) + "video/", true);
    k.g(localObject, "VFSFileOp.exportExternal…rname) + VIDEOFILE, true)");
    ad.i(TAG, "get story video dir %s username %s", new Object[] { localObject, paramString });
    AppMethodBeat.o(118790);
    return localObject;
  }
  
  private static n b(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    n localn = null;
    AppMethodBeat.i(118794);
    k.h(paramj, "videoItem");
    Object localObject3 = (a)new acq();
    Object localObject1 = paramj.yhQ;
    if (localObject1 != null) {}
    for (localObject1 = ((d)localObject1).field_baseItemData;; localObject1 = null)
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
          ad.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
      localObject3 = (acq)localObject1;
      localObject1 = localn;
      if (localObject3 != null) {
        localObject1 = ((acq)localObject3).videoPath;
      }
      i = (int)i.aMN((String)localObject1);
      localn = new n();
      localn.field_storyId = paramj.dAu;
      localn.field_url = "";
      localn.field_cacheSize = i;
      localn.field_totalSize = i;
      localn.field_filePath = ((String)localObject1);
      AppMethodBeat.o(118794);
      return localn;
    }
  }
  
  public static String bQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(118789);
    if (paramString == null) {}
    for (paramString = "story_local_video_".concat(String.valueOf(paramInt)); bt.isNullOrNil(paramString); paramString = c.a("storyvideo", paramInt, "story", paramString))
    {
      AppMethodBeat.o(118789);
      return null;
    }
    AppMethodBeat.o(118789);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.s
 * JD-Core Version:    0.7.0.1
 */