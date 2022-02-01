package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.c;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ad;
import com.tencent.mm.vfs.f;
import com.tencent.mm.vfs.u;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.b.a;
import kotlin.g.b.p;
import kotlin.n.d;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryFileNameUtil;", "", "()V", "MIX_AUDIO_FILE", "", "MIX_CP_DIR", "MIX_DIR", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PICFILE", "PIC_FILE", "TAG", "TMP_FILE", "UP_FILE", "VIDEOFILE", "VIDEO_FILE", "selfName", "getSelfName", "()Ljava/lang/String;", "setSelfName", "(Ljava/lang/String;)V", "accMixStoryPath", "accPath", "audioEnsurePath", "parentPath", "mediaId", "autoPath", "user", "cachePath", "checkSelfName", "checkToCreateDir", "", "newVideoPath", "noMedia", "", "cleanFiles", "copyCacheDir", "path", "dumpCacheDir", "Lkotlin/Pair;", "", "subDir", "getMixAudioPath", "localId", "getMixThumbPath", "getMixVideoPath", "init", "isNoMedia", "name", "isSelf", "userName", "primaryPathVideoPath", "username", "reset", "testCreateFiles", "thumbEnsurePath", "thumbPath", "url", "thumbPathInDownload", "thumbPathInUpload", "videoEnsurePath", "videoPath", "videoPathInDownload", "videoPathInUpload", "plugin-story_release"})
public final class l
{
  public static final l LGM;
  private static String iRj;
  
  static
  {
    AppMethodBeat.i(118740);
    LGM = new l();
    iRj = "";
    AppMethodBeat.o(118740);
  }
  
  public static boolean aFB(String paramString)
  {
    AppMethodBeat.i(118736);
    p.k(paramString, "name");
    if (p.h(".nomedia", paramString))
    {
      AppMethodBeat.o(118736);
      return true;
    }
    AppMethodBeat.o(118736);
    return false;
  }
  
  public static void aWs(String paramString)
  {
    AppMethodBeat.i(118734);
    p.k(paramString, "newVideoPath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(118734);
      return;
    }
    paramString = u.bBT(paramString);
    u.bBD(paramString);
    u.bBX(paramString);
    AppMethodBeat.o(118734);
  }
  
  public static String bcY(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(118727);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)iRj;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label121;
        }
        i = 1;
        label53:
        if (i == 0) {
          break label131;
        }
        paramString = (CharSequence)iRj;
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
          paramString = j.LGA;
          iRj = j.b.fOo();
        }
      }
    }
    label95:
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label146;
      }
      paramString = j.LGA;
      paramString = j.b.getAccStoryPath();
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
      if (!p.h(iRj, paramString)) {
        break label95;
      }
    }
    label131:
    label146:
    paramString = j.LGA;
    paramString = j.b.getAccStoryCachePath();
    AppMethodBeat.o(118727);
    return paramString;
  }
  
  public static String bcZ(String paramString)
  {
    AppMethodBeat.i(118732);
    if (paramString == null)
    {
      AppMethodBeat.o(118732);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    j.b localb = j.LGA;
    paramString = jT(j.b.getAccStoryPath(), paramString) + ".u";
    AppMethodBeat.o(118732);
    return paramString;
  }
  
  public static String bda(String paramString)
  {
    AppMethodBeat.i(118733);
    if (paramString == null)
    {
      AppMethodBeat.o(118733);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    j.b localb = j.LGA;
    paramString = lt(j.b.getAccStoryPath(), paramString) + ".u";
    AppMethodBeat.o(118733);
    return paramString;
  }
  
  private static o<String, Long> bdc(String paramString)
  {
    AppMethodBeat.i(118738);
    c localc = new c("dumpCacheDir");
    Object localObject1 = new StringBuilder();
    Object localObject2 = j.LGA;
    localObject1 = j.b.getAccStoryCachePath() + paramString;
    Log.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    localObject1 = u.dP((String)localObject1, true);
    long l1;
    long l2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ad.c((Iterable)localObject1);
      if ((localObject1 != null) && (((List)localObject1).size() > 1)) {
        kotlin.a.j.a((List)localObject1, (Comparator)new a());
      }
      l1 = 0L;
      l2 = l1;
      if (localObject1 == null) {
        break label314;
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
          kotlin.a.j.iBO();
        }
        localObject3 = (f)localObject3;
        l2 = l1;
        if (localObject3 != null)
        {
          Log.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir " + i + " filePath: " + ((f)localObject3).name + " time: " + ((f)localObject3).YCi + " size: " + Util.getSizeKB(((f)localObject3).size) + ' ' + ((f)localObject3).UUr);
          String str = ((f)localObject3).name;
          p.j(str, "fileEntry.name");
          if (aFB(str)) {
            break label424;
          }
          l2 = l1 + ((f)localObject3).size;
        }
        i = j;
        l1 = l2;
        continue;
        localObject1 = null;
        break;
      }
      label314:
      localObject2 = new StringBuilder("dumpCacheDir ").append(paramString).append(" totalSize ").append(Util.getSizeKB(l2)).append(" fileCounts ");
      if (localObject1 != null) {}
      for (paramString = Integer.valueOf(((List)localObject1).size());; paramString = null)
      {
        paramString = paramString + " cost:" + localc + " \n";
        Log.i("MicroMsg.StoryFileNameUtil", paramString);
        paramString = new o(paramString, Long.valueOf(l2));
        AppMethodBeat.o(118738);
        return paramString;
      }
      label424:
      i = j;
    }
  }
  
  static String gcL()
  {
    AppMethodBeat.i(118725);
    Object localObject = j.LGA;
    localObject = j.b.getAccStoryPath();
    AppMethodBeat.o(118725);
    return localObject;
  }
  
  static String gcM()
  {
    AppMethodBeat.i(118726);
    Object localObject = j.LGA;
    localObject = j.b.getAccStoryCachePath();
    AppMethodBeat.o(118726);
    return localObject;
  }
  
  public static String gcN()
  {
    AppMethodBeat.i(118737);
    new c("dumpCacheDir");
    Object localObject = bdc("pic/");
    o localo = bdc("video/");
    StringBuilder localStringBuilder = new StringBuilder().append((String)((o)localObject).Mx).append("  ").append((String)localo.Mx).append(" total: ");
    long l = ((Number)((o)localObject).My).longValue();
    localObject = Util.getSizeMB(((Number)localo.My).longValue() + l);
    AppMethodBeat.o(118737);
    return localObject;
  }
  
  public static void gcO()
  {
    AppMethodBeat.i(118739);
    Object localObject1 = j.LGA;
    localObject1 = j.b.getAccStoryCachePath();
    Log.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    Iterable localIterable = u.dP((String)localObject1, true);
    int j = 0;
    Iterator localIterator;
    int i;
    if (j < 100) {
      if (localIterable != null)
      {
        localIterator = localIterable.iterator();
        i = 0;
      }
    }
    for (;;)
    {
      int k;
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        k = i + 1;
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        localObject2 = (f)localObject2;
        String str = ((f)localObject2).name;
        p.j(str, "it.name");
        if (aFB(str)) {
          break label191;
        }
        u.on(((f)localObject2).UUr, ((f)localObject2).UUr + System.currentTimeMillis());
        if (i <= 2)
        {
          i = k;
          continue;
        }
      }
      j += 1;
      break;
      Log.i("MicroMsg.StoryFileNameUtil", "testCreateFiles done cache ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(118739);
      return;
      label191:
      i = k;
    }
  }
  
  public static String jT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118728);
    if (paramString2 == null)
    {
      AppMethodBeat.o(118728);
      return "";
    }
    paramString1 = u.n(paramString1 + paramString2 + ".p", true);
    if (paramString1 == null) {
      p.iCn();
    }
    AppMethodBeat.o(118728);
    return paramString1;
  }
  
  private static String lt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118729);
    if (paramString2 == null)
    {
      AppMethodBeat.o(118729);
      return "";
    }
    paramString1 = u.n(paramString1 + paramString2 + ".v", true);
    if (paramString1 == null) {
      p.iCn();
    }
    AppMethodBeat.o(118729);
    return paramString1;
  }
  
  public static void reset()
  {
    iRj = "";
  }
  
  public final String lu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118730);
    if (paramString1 == null)
    {
      AppMethodBeat.o(118730);
      return "";
    }
    paramString2 = bcY(paramString2) + "pic/";
    paramString1 = paramString1.getBytes(d.UTF_8);
    p.j(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = jT(paramString2, g.getMessageDigest(paramString1));
    AppMethodBeat.o(118730);
    return paramString1;
  }
  
  public final String lv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118731);
    if (paramString1 == null)
    {
      AppMethodBeat.o(118731);
      return "";
    }
    paramString2 = bcY(paramString2) + "video/";
    paramString1 = paramString1.getBytes(d.UTF_8);
    p.j(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = lt(paramString2, g.getMessageDigest(paramString1));
    AppMethodBeat.o(118731);
    return paramString1;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118724);
      int i = a.a((Comparable)Long.valueOf(((f)paramT1).YCi), (Comparable)Long.valueOf(((f)paramT2).YCi));
      AppMethodBeat.o(118724);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.l
 * JD-Core Version:    0.7.0.1
 */