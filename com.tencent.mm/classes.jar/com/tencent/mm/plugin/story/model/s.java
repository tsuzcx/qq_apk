package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryVideoLogic;", "", "()V", "STORY_VIDEO_PREFIX", "", "TAG", "createForFake", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "createForPost", "", "storyId", "", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "genCdnMediaId", "createTime", "", "url", "genFileName", "snsLocalId", "getOrCreate", "getStoryVideoDir", "getStoryVideoPath", "getStoryVideoTmpPath", "plugin-story_release"})
public final class s
{
  private static final String TAG = "MicroMsg.StoryVideoLogic";
  private static final String swj = "STORY_";
  public static final s swk;
  
  static
  {
    AppMethodBeat.i(109170);
    swk = new s();
    TAG = "MicroMsg.StoryVideoLogic";
    swj = "STORY_";
    AppMethodBeat.o(109170);
  }
  
  public static n a(i parami)
  {
    AppMethodBeat.i(109169);
    a.f.b.j.q(parami, "videoItem");
    int i;
    if (parami.cBM())
    {
      a.f.b.j.q(parami, "videoItem");
      localObject1 = parami.syD;
      if (localObject1 != null) {}
      for (localObject1 = ((chf)localObject1).videoPath;; localObject1 = null)
      {
        i = (int)e.avI((String)localObject1);
        localObject2 = new n();
        ((n)localObject2).field_storyId = parami.cJA;
        ((n)localObject2).field_url = "";
        ((n)localObject2).field_cacheSize = i;
        ((n)localObject2).field_totalSize = i;
        ((n)localObject2).field_filePath = ((String)localObject1);
        AppMethodBeat.o(109169);
        return localObject2;
      }
    }
    Object localObject2 = a(parami.syB, parami.username);
    Object localObject1 = l.svv;
    if (localObject2 == null) {}
    for (localObject1 = "";; localObject1 = localObject2)
    {
      l.adc((String)localObject1);
      localObject1 = j.svi;
      localObject1 = j.b.cAF().mX(parami.cJA);
      if (localObject1 == null)
      {
        localObject1 = new n();
        ((n)localObject1).field_storyId = parami.cJA;
        ((n)localObject1).field_url = parami.syB.Url;
        ((n)localObject1).field_cacheSize = 0;
        ((n)localObject1).field_totalSize = 0;
        ((n)localObject1).field_filePath = ((String)localObject2);
        parami = j.svi;
        j.b.cAF().a((n)localObject1);
      }
      for (parami = (i)localObject1;; parami = (i)localObject1)
      {
        localObject1 = (CharSequence)parami.field_filePath;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            parami.field_filePath = ((String)localObject2);
          }
          AppMethodBeat.o(109169);
          return parami;
        }
      }
    }
  }
  
  public static String a(chl paramchl)
  {
    AppMethodBeat.i(109168);
    if (paramchl == null)
    {
      AppMethodBeat.o(109168);
      return null;
    }
    l locall = l.svv;
    paramchl = l.acY(paramchl.Id);
    AppMethodBeat.o(109168);
    return paramchl;
  }
  
  public static String a(chl paramchl, String paramString)
  {
    AppMethodBeat.i(109167);
    if (paramchl == null)
    {
      AppMethodBeat.o(109167);
      return null;
    }
    l locall = l.svv;
    paramchl = l.gN(paramchl.Url, paramString);
    ab.i(TAG, "get story video path %s", new Object[] { paramchl });
    AppMethodBeat.o(109167);
    return paramchl;
  }
  
  public static String adj(String paramString)
  {
    AppMethodBeat.i(109166);
    Object localObject = l.svv;
    localObject = l.acW(paramString) + "/video/";
    ab.i(TAG, "get story video dir %s username %s", new Object[] { localObject, paramString });
    AppMethodBeat.o(109166);
    return localObject;
  }
  
  public static String be(int paramInt, String paramString)
  {
    AppMethodBeat.i(109165);
    if (paramString == null) {}
    for (paramString = "story_local_video_".concat(String.valueOf(paramInt)); bo.isNullOrNil(paramString); paramString = c.a("storyvideo", paramInt, "story", paramString))
    {
      AppMethodBeat.o(109165);
      return null;
    }
    AppMethodBeat.o(109165);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.s
 * JD-Core Version:    0.7.0.1
 */