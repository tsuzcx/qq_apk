package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryVideoLogic;", "", "()V", "STORY_VIDEO_PREFIX", "", "TAG", "createForFake", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "createForPost", "", "storyId", "", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "genCdnMediaId", "createTime", "", "url", "genFileName", "snsLocalId", "getOrCreate", "getStoryVideoDir", "getStoryVideoPath", "getStoryVideoTmpPath", "plugin-story_release"})
public final class s
{
  public static final s LHA;
  private static final String LHz = "STORY_";
  private static final String TAG = "MicroMsg.StoryVideoLogic";
  
  static
  {
    AppMethodBeat.i(118795);
    LHA = new s();
    TAG = "MicroMsg.StoryVideoLogic";
    LHz = "STORY_";
    AppMethodBeat.o(118795);
  }
  
  public static n a(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    AppMethodBeat.i(118793);
    p.k(paramj, "videoItem");
    if (paramj.gdp())
    {
      paramj = b(paramj);
      AppMethodBeat.o(118793);
      return paramj;
    }
    String str = a(paramj.LJf, paramj.username);
    Object localObject = l.LGM;
    if (str == null) {}
    for (localObject = "";; localObject = str)
    {
      l.aWs((String)localObject);
      localObject = j.LGA;
      localObject = j.b.gcA().RW(paramj.fXG);
      if (localObject == null)
      {
        localObject = new n();
        ((n)localObject).field_storyId = paramj.fXG;
        ((n)localObject).field_url = paramj.LJf.Url;
        ((n)localObject).field_cacheSize = 0;
        ((n)localObject).field_totalSize = 0;
        ((n)localObject).field_filePath = str;
        paramj = j.LGA;
        j.b.gcA().a((n)localObject);
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
  
  public static String a(enu paramenu)
  {
    AppMethodBeat.i(118792);
    if (paramenu == null)
    {
      AppMethodBeat.o(118792);
      return null;
    }
    l locall = l.LGM;
    paramenu = l.bda(paramenu.Id);
    AppMethodBeat.o(118792);
    return paramenu;
  }
  
  public static String a(enu paramenu, String paramString)
  {
    AppMethodBeat.i(118791);
    if (paramenu == null)
    {
      AppMethodBeat.o(118791);
      return null;
    }
    paramenu = l.LGM.lv(paramenu.Url, paramString);
    Log.i(TAG, "get story video path %s", new Object[] { paramenu });
    AppMethodBeat.o(118791);
    return paramenu;
  }
  
  private static n b(com.tencent.mm.plugin.story.f.d.j paramj)
  {
    n localn = null;
    AppMethodBeat.i(118794);
    p.k(paramj, "videoItem");
    Object localObject3 = (a)new ajd();
    Object localObject1 = paramj.LJg;
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
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
      localObject3 = (ajd)localObject1;
      localObject1 = localn;
      if (localObject3 != null) {
        localObject1 = ((ajd)localObject3).videoPath;
      }
      i = (int)u.bBQ((String)localObject1);
      localn = new n();
      localn.field_storyId = paramj.fXG;
      localn.field_url = "";
      localn.field_cacheSize = i;
      localn.field_totalSize = i;
      localn.field_filePath = ((String)localObject1);
      AppMethodBeat.o(118794);
      return localn;
    }
  }
  
  public static String bdg(String paramString)
  {
    AppMethodBeat.i(118790);
    Object localObject = l.LGM;
    localObject = u.n(l.bcY(paramString) + "video/", true);
    if (localObject == null) {
      p.iCn();
    }
    Log.i(TAG, "get story video dir %s username %s", new Object[] { localObject, paramString });
    AppMethodBeat.o(118790);
    return localObject;
  }
  
  public static String cs(int paramInt, String paramString)
  {
    AppMethodBeat.i(118789);
    if (paramString == null) {}
    for (paramString = "story_local_video_".concat(String.valueOf(paramInt)); Util.isNullOrNil(paramString); paramString = com.tencent.mm.aq.c.a("storyvideo", paramInt, "story", paramString))
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