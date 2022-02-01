package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.d.j;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryVideoLogic;", "", "()V", "STORY_VIDEO_PREFIX", "", "TAG", "createForFake", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "createForPost", "", "storyId", "", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "genCdnMediaId", "createTime", "", "url", "genFileName", "snsLocalId", "getOrCreate", "getStoryVideoDir", "getStoryVideoPath", "getStoryVideoTmpPath", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r Slb;
  private static final String Slc;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(118795);
    Slb = new r();
    TAG = "MicroMsg.StoryVideoLogic";
    Slc = "STORY_";
    AppMethodBeat.o(118795);
  }
  
  public static n a(j paramj)
  {
    AppMethodBeat.i(118793);
    s.u(paramj, "videoItem");
    if (paramj.hwL())
    {
      paramj = b(paramj);
      AppMethodBeat.o(118793);
      return paramj;
    }
    String str = a(paramj.Smx, paramj.username);
    Object localObject = k.Skq;
    if (str == null)
    {
      localObject = "";
      k.aTB((String)localObject);
      localObject = StoryCore.SjP;
      localObject = StoryCore.b.hvV().wf(paramj.idH);
      if (localObject != null) {
        break label181;
      }
      localObject = new n();
      ((n)localObject).field_storyId = paramj.idH;
      ((n)localObject).field_url = paramj.Smx.Url;
      ((n)localObject).field_cacheSize = 0;
      ((n)localObject).field_totalSize = 0;
      ((n)localObject).field_filePath = str;
      paramj = StoryCore.SjP;
      StoryCore.b.hvV().a((n)localObject);
    }
    label181:
    for (paramj = (j)localObject;; paramj = (j)localObject)
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
        localObject = str;
        break;
      }
    }
  }
  
  public static String a(fis paramfis)
  {
    AppMethodBeat.i(118792);
    if (paramfis == null)
    {
      AppMethodBeat.o(118792);
      return null;
    }
    k localk = k.Skq;
    paramfis = k.bbN(paramfis.Id);
    AppMethodBeat.o(118792);
    return paramfis;
  }
  
  public static String a(fis paramfis, String paramString)
  {
    AppMethodBeat.i(118791);
    if (paramfis == null)
    {
      AppMethodBeat.o(118791);
      return null;
    }
    paramfis = k.Skq.nd(paramfis.Url, paramString);
    Log.i(TAG, "get story video path %s", new Object[] { paramfis });
    AppMethodBeat.o(118791);
    return paramfis;
  }
  
  private static n b(j paramj)
  {
    n localn = null;
    AppMethodBeat.i(118794);
    s.u(paramj, "videoItem");
    a locala = (a)new ami();
    Object localObject = paramj.Smy;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((c)localObject).field_baseItemData)
    {
      try
      {
        locala.parseFrom((byte[])localObject);
        localObject = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          String str = null;
          continue;
          str = str.videoPath;
        }
      }
      localObject = (ami)localObject;
      if (localObject != null) {
        break;
      }
      localObject = localn;
      i = (int)y.bEl((String)localObject);
      localn = new n();
      localn.field_storyId = paramj.idH;
      localn.field_url = "";
      localn.field_cacheSize = i;
      localn.field_totalSize = i;
      localn.field_filePath = ((String)localObject);
      AppMethodBeat.o(118794);
      return localn;
    }
  }
  
  public static String bbT(String paramString)
  {
    AppMethodBeat.i(118790);
    Object localObject = k.Skq;
    localObject = y.n(s.X(k.bbL(paramString), "video/"), true);
    s.checkNotNull(localObject);
    s.s(localObject, "exportExternalPath(autoP…ame) + VIDEOFILE, true)!!");
    Log.i(TAG, "get story video dir %s username %s", new Object[] { localObject, paramString });
    AppMethodBeat.o(118790);
    return localObject;
  }
  
  public static String de(int paramInt, String paramString)
  {
    AppMethodBeat.i(118789);
    if (paramString == null) {}
    for (paramString = s.X("story_local_video_", Integer.valueOf(paramInt)); Util.isNullOrNil(paramString); paramString = h.a("storyvideo", paramInt, "story", paramString))
    {
      AppMethodBeat.o(118789);
      return null;
    }
    AppMethodBeat.o(118789);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.r
 * JD-Core Version:    0.7.0.1
 */