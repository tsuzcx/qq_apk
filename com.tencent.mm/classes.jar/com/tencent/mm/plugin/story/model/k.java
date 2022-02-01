package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.c;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.d;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryFileNameUtil;", "", "()V", "MIX_AUDIO_FILE", "", "MIX_CP_DIR", "MIX_DIR", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PICFILE", "PIC_FILE", "TAG", "TMP_FILE", "UP_FILE", "VIDEOFILE", "VIDEO_FILE", "selfName", "getSelfName", "()Ljava/lang/String;", "setSelfName", "(Ljava/lang/String;)V", "accMixStoryPath", "accPath", "audioEnsurePath", "parentPath", "mediaId", "autoPath", "user", "cachePath", "checkSelfName", "checkToCreateDir", "", "newVideoPath", "noMedia", "", "cleanFiles", "copyCacheDir", "path", "dumpCacheDir", "Lkotlin/Pair;", "", "subDir", "getMixAudioPath", "localId", "getMixThumbPath", "getMixVideoPath", "init", "isNoMedia", "name", "isSelf", "userName", "primaryPathVideoPath", "username", "reset", "testCreateFiles", "thumbEnsurePath", "thumbPath", "url", "thumbPathInDownload", "thumbPathInUpload", "videoEnsurePath", "videoPath", "videoPathInDownload", "videoPathInUpload", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k Skq;
  private static String ltf;
  
  static
  {
    AppMethodBeat.i(118740);
    Skq = new k();
    ltf = "";
    AppMethodBeat.o(118740);
  }
  
  public static boolean aBw(String paramString)
  {
    AppMethodBeat.i(118736);
    s.u(paramString, "name");
    if (s.p(".nomedia", paramString))
    {
      AppMethodBeat.o(118736);
      return true;
    }
    AppMethodBeat.o(118736);
    return false;
  }
  
  public static void aTB(String paramString)
  {
    AppMethodBeat.i(118734);
    s.u(paramString, "newVideoPath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(118734);
      return;
    }
    paramString = y.bEo(paramString);
    y.bDX(paramString);
    y.bEr(paramString);
    AppMethodBeat.o(118734);
  }
  
  public static String bbL(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(118727);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)ltf;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label121;
        }
        i = 1;
        label53:
        if (i == 0) {
          break label131;
        }
        paramString = (CharSequence)ltf;
        i = j;
        if (paramString != null)
        {
          if (paramString.length() != 0) {
            break label126;
          }
          i = j;
        }
        label81:
        if (i != 0)
        {
          paramString = StoryCore.SjP;
          ltf = StoryCore.b.hgg();
        }
      }
    }
    label95:
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label146;
      }
      paramString = StoryCore.SjP;
      paramString = StoryCore.b.getAccStoryPath();
      AppMethodBeat.o(118727);
      return paramString;
      i = 0;
      break;
      label121:
      i = 0;
      break label53;
      label126:
      i = 0;
      break label81;
      if (!s.p(ltf, paramString)) {
        break label95;
      }
    }
    label131:
    label146:
    paramString = StoryCore.SjP;
    paramString = StoryCore.b.getAccStoryCachePath();
    AppMethodBeat.o(118727);
    return paramString;
  }
  
  public static String bbM(String paramString)
  {
    AppMethodBeat.i(118732);
    if (paramString == null)
    {
      AppMethodBeat.o(118732);
      return "";
    }
    StoryCore.b localb = StoryCore.SjP;
    paramString = s.X(lp(StoryCore.b.getAccStoryPath(), paramString), ".u");
    AppMethodBeat.o(118732);
    return paramString;
  }
  
  public static String bbN(String paramString)
  {
    AppMethodBeat.i(118733);
    if (paramString == null)
    {
      AppMethodBeat.o(118733);
      return "";
    }
    StoryCore.b localb = StoryCore.SjP;
    paramString = s.X(nb(StoryCore.b.getAccStoryPath(), paramString), ".u");
    AppMethodBeat.o(118733);
    return paramString;
  }
  
  private static r<String, Long> bbP(String paramString)
  {
    AppMethodBeat.i(118738);
    c localc = new c("dumpCacheDir");
    Object localObject1 = StoryCore.SjP;
    localObject1 = s.X(StoryCore.b.getAccStoryCachePath(), paramString);
    Log.i("MicroMsg.StoryFileNameUtil", s.X("dumpCacheDir cache ", localObject1));
    localObject1 = y.eB((String)localObject1, true);
    long l1;
    long l2;
    Object localObject2;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 != null) && (((List)localObject1).size() > 1)) {
        p.a((List)localObject1, (Comparator)new k.a());
      }
      l1 = 0L;
      l2 = l1;
      if (localObject1 == null) {
        break label292;
      }
      localObject2 = (Iterable)localObject1;
      i = 0;
      localObject2 = ((Iterable)localObject2).iterator();
    }
    for (;;)
    {
      l2 = l1;
      int j;
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        j = i + 1;
        if (i < 0) {
          p.kkW();
        }
        localObject3 = (j)localObject3;
        l2 = l1;
        if (localObject3 != null)
        {
          Log.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir " + i + " filePath: " + ((j)localObject3).name + " time: " + ((j)localObject3).agxg + " size: " + Util.getSizeKB(((j)localObject3).size) + ' ' + ((j)localObject3).acpB);
          String str = ((j)localObject3).name;
          s.s(str, "fileEntry.name");
          if (aBw(str)) {
            break label402;
          }
          l2 = l1 + ((j)localObject3).size;
        }
        i = j;
        l1 = l2;
        continue;
        localObject1 = ah.c((Iterable)localObject1);
        break;
      }
      label292:
      localObject2 = new StringBuilder("dumpCacheDir ").append(paramString).append(" totalSize ").append(Util.getSizeKB(l2)).append(" fileCounts ");
      if (localObject1 == null) {}
      for (paramString = null;; paramString = Integer.valueOf(((List)localObject1).size()))
      {
        paramString = paramString + " cost:" + localc + " \n";
        Log.i("MicroMsg.StoryFileNameUtil", paramString);
        paramString = new r(paramString, Long.valueOf(l2));
        AppMethodBeat.o(118738);
        return paramString;
      }
      label402:
      i = j;
    }
  }
  
  static String hwf()
  {
    AppMethodBeat.i(118725);
    Object localObject = StoryCore.SjP;
    localObject = StoryCore.b.getAccStoryPath();
    AppMethodBeat.o(118725);
    return localObject;
  }
  
  static String hwg()
  {
    AppMethodBeat.i(118726);
    Object localObject = StoryCore.SjP;
    localObject = StoryCore.b.getAccStoryCachePath();
    AppMethodBeat.o(118726);
    return localObject;
  }
  
  public static String hwh()
  {
    AppMethodBeat.i(118737);
    new c("dumpCacheDir");
    Object localObject = bbP("pic/");
    r localr = bbP("video/");
    StringBuilder localStringBuilder = new StringBuilder().append((String)((r)localObject).bsC).append("  ").append((String)localr.bsC).append(" total: ");
    long l = ((Number)((r)localObject).bsD).longValue();
    localObject = Util.getSizeMB(((Number)localr.bsD).longValue() + l);
    AppMethodBeat.o(118737);
    return localObject;
  }
  
  public static void hwi()
  {
    AppMethodBeat.i(118739);
    Object localObject1 = StoryCore.SjP;
    localObject1 = StoryCore.b.getAccStoryCachePath();
    Log.i("MicroMsg.StoryFileNameUtil", s.X("dumpCacheDir cache ", localObject1));
    Iterable localIterable = y.eB((String)localObject1, true);
    int i = 0;
    int j = i + 1;
    Iterator localIterator;
    if (localIterable != null)
    {
      localIterator = localIterable.iterator();
      i = 0;
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (i < 0) {
          p.kkW();
        }
        localObject2 = (j)localObject2;
        String str = ((j)localObject2).name;
        s.s(str, "it.name");
        if (!aBw(str))
        {
          y.O(((j)localObject2).acpB, s.X(((j)localObject2).acpB, Long.valueOf(System.currentTimeMillis())), false);
          if (i <= 2) {}
        }
      }
      else
      {
        if (j >= 100)
        {
          Log.i("MicroMsg.StoryFileNameUtil", s.X("testCreateFiles done cache ", localObject1));
          AppMethodBeat.o(118739);
          return;
        }
        i = j;
        break;
      }
      i += 1;
    }
  }
  
  public static String lp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118728);
    if (paramString2 == null)
    {
      AppMethodBeat.o(118728);
      return "";
    }
    paramString1 = y.n(paramString1 + paramString2 + ".p", true);
    s.checkNotNull(paramString1);
    s.s(paramString1, "exportExternalPath(paren…diaId + PIC_FILE, true)!!");
    AppMethodBeat.o(118728);
    return paramString1;
  }
  
  private static String nb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118729);
    if (paramString2 == null)
    {
      AppMethodBeat.o(118729);
      return "";
    }
    paramString1 = y.n(paramString1 + paramString2 + ".v", true);
    s.checkNotNull(paramString1);
    s.s(paramString1, "exportExternalPath(paren…aId + VIDEO_FILE, true)!!");
    AppMethodBeat.o(118729);
    return paramString1;
  }
  
  public static void reset()
  {
    ltf = "";
  }
  
  public final String nc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118730);
    if (paramString1 == null)
    {
      AppMethodBeat.o(118730);
      return "";
    }
    paramString2 = s.X(bbL(paramString2), "pic/");
    paramString1 = paramString1.getBytes(d.UTF_8);
    s.s(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = lp(paramString2, g.getMessageDigest(paramString1));
    AppMethodBeat.o(118730);
    return paramString1;
  }
  
  public final String nd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118731);
    if (paramString1 == null)
    {
      AppMethodBeat.o(118731);
      return "";
    }
    paramString2 = s.X(bbL(paramString2), "video/");
    paramString1 = paramString1.getBytes(d.UTF_8);
    s.s(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = nb(paramString2, g.getMessageDigest(paramString1));
    AppMethodBeat.o(118731);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.k
 * JD-Core Version:    0.7.0.1
 */