package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.b.a;
import kotlin.g.b.p;
import kotlin.n.d;
import kotlin.o;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryFileNameUtil;", "", "()V", "MIX_AUDIO_FILE", "", "MIX_CP_DIR", "MIX_DIR", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PICFILE", "PIC_FILE", "TAG", "TMP_FILE", "UP_FILE", "VIDEOFILE", "VIDEO_FILE", "selfName", "getSelfName", "()Ljava/lang/String;", "setSelfName", "(Ljava/lang/String;)V", "accMixStoryPath", "accPath", "audioEnsurePath", "parentPath", "mediaId", "autoPath", "user", "cachePath", "checkSelfName", "checkToCreateDir", "", "newVideoPath", "noMedia", "", "cleanFiles", "copyCacheDir", "path", "dumpCacheDir", "Lkotlin/Pair;", "", "subDir", "getMixAudioPath", "localId", "getMixThumbPath", "getMixVideoPath", "init", "isNoMedia", "name", "isSelf", "userName", "primaryPathVideoPath", "username", "reset", "testCreateFiles", "thumbEnsurePath", "thumbPath", "url", "thumbPathInDownload", "thumbPathInUpload", "videoEnsurePath", "videoPath", "videoPathInDownload", "videoPathInUpload", "plugin-story_release"})
public final class l
{
  public static final l FmK;
  private static String gna;
  
  static
  {
    AppMethodBeat.i(118740);
    FmK = new l();
    gna = "";
    AppMethodBeat.o(118740);
  }
  
  public static void aLP(String paramString)
  {
    AppMethodBeat.i(118734);
    p.h(paramString, "newVideoPath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(118734);
      return;
    }
    paramString = s.boZ(paramString);
    s.boN(paramString);
    s.bpc(paramString);
    AppMethodBeat.o(118734);
  }
  
  public static String aRU(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(118727);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)gna;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label121;
        }
        i = 1;
        label53:
        if (i == 0) {
          break label131;
        }
        paramString = (CharSequence)gna;
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
          paramString = j.Fmy;
          gna = j.b.fau();
        }
      }
    }
    label95:
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label146;
      }
      paramString = j.Fmy;
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
      if (!p.j(gna, paramString)) {
        break label95;
      }
    }
    label131:
    label146:
    paramString = j.Fmy;
    paramString = j.b.getAccStoryCachePath();
    AppMethodBeat.o(118727);
    return paramString;
  }
  
  public static String aRV(String paramString)
  {
    AppMethodBeat.i(118732);
    if (paramString == null)
    {
      AppMethodBeat.o(118732);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    j.b localb = j.Fmy;
    paramString = jF(j.b.getAccStoryPath(), paramString) + ".u";
    AppMethodBeat.o(118732);
    return paramString;
  }
  
  public static String aRW(String paramString)
  {
    AppMethodBeat.i(118733);
    if (paramString == null)
    {
      AppMethodBeat.o(118733);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    j.b localb = j.Fmy;
    paramString = kW(j.b.getAccStoryPath(), paramString) + ".u";
    AppMethodBeat.o(118733);
    return paramString;
  }
  
  private static o<String, Long> aRY(String paramString)
  {
    AppMethodBeat.i(118738);
    c localc = new c("dumpCacheDir");
    Object localObject1 = new StringBuilder();
    Object localObject2 = j.Fmy;
    localObject1 = j.b.getAccStoryCachePath() + paramString;
    Log.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    localObject1 = s.dC((String)localObject1, true);
    long l1;
    long l2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = aa.c((Iterable)localObject1);
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
          kotlin.a.j.hxH();
        }
        localObject3 = (e)localObject3;
        l2 = l1;
        if (localObject3 != null)
        {
          Log.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir " + i + " filePath: " + ((e)localObject3).name + " time: " + ((e)localObject3).RbI + " size: " + Util.getSizeKB(((e)localObject3).size) + ' ' + ((e)localObject3).NGP);
          String str = ((e)localObject3).name;
          p.g(str, "fileEntry.name");
          if (awg(str)) {
            break label424;
          }
          l2 = l1 + ((e)localObject3).size;
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
  
  public static boolean awg(String paramString)
  {
    AppMethodBeat.i(118736);
    p.h(paramString, "name");
    if (p.j(".nomedia", paramString))
    {
      AppMethodBeat.o(118736);
      return true;
    }
    AppMethodBeat.o(118736);
    return false;
  }
  
  static String jdMethod_for()
  {
    AppMethodBeat.i(118725);
    Object localObject = j.Fmy;
    localObject = j.b.getAccStoryPath();
    AppMethodBeat.o(118725);
    return localObject;
  }
  
  static String fos()
  {
    AppMethodBeat.i(118726);
    Object localObject = j.Fmy;
    localObject = j.b.getAccStoryCachePath();
    AppMethodBeat.o(118726);
    return localObject;
  }
  
  public static String fot()
  {
    AppMethodBeat.i(118737);
    new c("dumpCacheDir");
    Object localObject = aRY("pic/");
    o localo = aRY("video/");
    StringBuilder localStringBuilder = new StringBuilder().append((String)((o)localObject).first).append("  ").append((String)localo.first).append(" total: ");
    long l = ((Number)((o)localObject).second).longValue();
    localObject = Util.getSizeMB(((Number)localo.second).longValue() + l);
    AppMethodBeat.o(118737);
    return localObject;
  }
  
  public static void fou()
  {
    AppMethodBeat.i(118739);
    Object localObject1 = j.Fmy;
    localObject1 = j.b.getAccStoryCachePath();
    Log.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    Iterable localIterable = s.dC((String)localObject1, true);
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
          kotlin.a.j.hxH();
        }
        localObject2 = (e)localObject2;
        String str = ((e)localObject2).name;
        p.g(str, "it.name");
        if (awg(str)) {
          break label191;
        }
        s.nw(((e)localObject2).NGP, ((e)localObject2).NGP + System.currentTimeMillis());
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
  
  public static String jF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118728);
    if (paramString2 == null)
    {
      AppMethodBeat.o(118728);
      return "";
    }
    paramString1 = s.k(paramString1 + paramString2 + ".p", true);
    if (paramString1 == null) {
      p.hyc();
    }
    AppMethodBeat.o(118728);
    return paramString1;
  }
  
  private static String kW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118729);
    if (paramString2 == null)
    {
      AppMethodBeat.o(118729);
      return "";
    }
    paramString1 = s.k(paramString1 + paramString2 + ".v", true);
    if (paramString1 == null) {
      p.hyc();
    }
    AppMethodBeat.o(118729);
    return paramString1;
  }
  
  public static void reset()
  {
    gna = "";
  }
  
  public final String kX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118730);
    if (paramString1 == null)
    {
      AppMethodBeat.o(118730);
      return "";
    }
    paramString2 = aRU(paramString2) + "pic/";
    paramString1 = paramString1.getBytes(d.UTF_8);
    p.g(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = jF(paramString2, g.getMessageDigest(paramString1));
    AppMethodBeat.o(118730);
    return paramString1;
  }
  
  public final String kY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118731);
    if (paramString1 == null)
    {
      AppMethodBeat.o(118731);
      return "";
    }
    paramString2 = aRU(paramString2) + "video/";
    paramString1 = paramString1.getBytes(d.UTF_8);
    p.g(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = kW(paramString2, g.getMessageDigest(paramString1));
    AppMethodBeat.o(118731);
    return paramString1;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118724);
      int i = a.a((Comparable)Long.valueOf(((e)paramT1).RbI), (Comparable)Long.valueOf(((e)paramT2).RbI));
      AppMethodBeat.o(118724);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.l
 * JD-Core Version:    0.7.0.1
 */