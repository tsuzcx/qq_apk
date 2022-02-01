package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.b;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import d.b.a;
import d.g.b.k;
import d.n.d;
import d.o;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryFileNameUtil;", "", "()V", "MIX_AUDIO_FILE", "", "MIX_CP_DIR", "MIX_DIR", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PICFILE", "PIC_FILE", "TAG", "TMP_FILE", "UP_FILE", "VIDEOFILE", "VIDEO_FILE", "selfName", "getSelfName", "()Ljava/lang/String;", "setSelfName", "(Ljava/lang/String;)V", "accMixStoryPath", "accPath", "audioEnsurePath", "parentPath", "mediaId", "autoPath", "user", "cachePath", "checkSelfName", "checkToCreateDir", "", "newVideoPath", "noMedia", "", "cleanFiles", "copyCacheDir", "path", "dumpCacheDir", "Lkotlin/Pair;", "", "subDir", "getMixAudioPath", "localId", "getMixThumbPath", "getMixVideoPath", "init", "isNoMedia", "name", "isSelf", "userName", "primaryPathVideoPath", "username", "reset", "testCreateFiles", "thumbEnsurePath", "thumbPath", "url", "thumbPathInDownload", "thumbPathInUpload", "videoEnsurePath", "videoPath", "videoPathInDownload", "videoPathInUpload", "plugin-story_release"})
public final class l
{
  private static String fki;
  public static final l yfu;
  
  static
  {
    AppMethodBeat.i(118740);
    yfu = new l();
    fki = "";
    AppMethodBeat.o(118740);
  }
  
  public static void alY(String paramString)
  {
    AppMethodBeat.i(118734);
    k.h(paramString, "newVideoPath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(118734);
      return;
    }
    paramString = i.aMQ(paramString);
    i.aMF(paramString);
    i.aMT(paramString);
    AppMethodBeat.o(118734);
  }
  
  public static String arr(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(118727);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)fki;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label121;
        }
        i = 1;
        label53:
        if (i == 0) {
          break label131;
        }
        paramString = (CharSequence)fki;
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
          paramString = j.yfh;
          fki = j.b.dta();
        }
      }
    }
    label95:
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label146;
      }
      paramString = j.yfh;
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
      if (!k.g(fki, paramString)) {
        break label95;
      }
    }
    label131:
    label146:
    paramString = j.yfh;
    paramString = j.b.getAccStoryCachePath();
    AppMethodBeat.o(118727);
    return paramString;
  }
  
  public static String ars(String paramString)
  {
    AppMethodBeat.i(118732);
    if (paramString == null)
    {
      AppMethodBeat.o(118732);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    j.b localb = j.yfh;
    paramString = ih(j.b.getAccStoryPath(), paramString) + ".u";
    AppMethodBeat.o(118732);
    return paramString;
  }
  
  public static String art(String paramString)
  {
    AppMethodBeat.i(118733);
    if (paramString == null)
    {
      AppMethodBeat.o(118733);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    j.b localb = j.yfh;
    paramString = jo(j.b.getAccStoryPath(), paramString) + ".u";
    AppMethodBeat.o(118733);
    return paramString;
  }
  
  public static boolean arv(String paramString)
  {
    AppMethodBeat.i(118736);
    k.h(paramString, "name");
    if (k.g(".nomedia", paramString))
    {
      AppMethodBeat.o(118736);
      return true;
    }
    AppMethodBeat.o(118736);
    return false;
  }
  
  private static o<String, Long> arw(String paramString)
  {
    AppMethodBeat.i(118738);
    b localb = new b("dumpCacheDir");
    Object localObject1 = new StringBuilder();
    Object localObject2 = j.yfh;
    localObject1 = j.b.getAccStoryCachePath() + paramString;
    ad.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    localObject1 = i.cT((String)localObject1, true);
    if (localObject1 != null) {}
    long l2;
    for (localObject1 = q.b((Iterable)localObject1);; localObject1 = null)
    {
      if ((localObject1 != null) && (((List)localObject1).size() > 1)) {
        d.a.j.a((List)localObject1, (Comparator)new a());
      }
      long l1 = 0L;
      l2 = l1;
      if (localObject1 == null) {
        break;
      }
      localObject2 = (Iterable)localObject1;
      int i = 0;
      localObject2 = ((Iterable)localObject2).iterator();
      for (;;)
      {
        l2 = l1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        Object localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          d.a.j.fvx();
        }
        localObject3 = (FileSystem.a)localObject3;
        l2 = l1;
        if (localObject3 != null)
        {
          ad.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir " + i + " filePath: " + ((FileSystem.a)localObject3).name + " time: " + ((FileSystem.a)localObject3).HRA + " size: " + bt.mK(((FileSystem.a)localObject3).size) + ' ' + ((FileSystem.a)localObject3).EQk);
          String str = ((FileSystem.a)localObject3).name;
          k.g(str, "fileEntry.name");
          l2 = l1;
          if (!arv(str)) {
            l2 = l1 + ((FileSystem.a)localObject3).size;
          }
        }
        i += 1;
        l1 = l2;
      }
    }
    localObject2 = new StringBuilder("dumpCacheDir ").append(paramString).append(" totalSize ").append(bt.mK(l2)).append(" fileCounts ");
    if (localObject1 != null) {}
    for (paramString = Integer.valueOf(((List)localObject1).size());; paramString = null)
    {
      paramString = paramString + " cost:" + localb + " \n";
      ad.i("MicroMsg.StoryFileNameUtil", paramString);
      paramString = new o(paramString, Long.valueOf(l2));
      AppMethodBeat.o(118738);
      return paramString;
    }
  }
  
  public static String cse()
  {
    AppMethodBeat.i(118737);
    new b("dumpCacheDir");
    Object localObject = arw("pic/");
    o localo = arw("video/");
    StringBuilder localStringBuilder = new StringBuilder().append((String)((o)localObject).first).append("  ").append((String)localo.first).append(" total: ");
    long l = ((Number)((o)localObject).second).longValue();
    localObject = bt.vK(((Number)localo.second).longValue() + l);
    AppMethodBeat.o(118737);
    return localObject;
  }
  
  static String dHs()
  {
    AppMethodBeat.i(118725);
    Object localObject = j.yfh;
    localObject = j.b.getAccStoryPath();
    AppMethodBeat.o(118725);
    return localObject;
  }
  
  static String dHt()
  {
    AppMethodBeat.i(118726);
    Object localObject = j.yfh;
    localObject = j.b.getAccStoryCachePath();
    AppMethodBeat.o(118726);
    return localObject;
  }
  
  public static void dHu()
  {
    AppMethodBeat.i(118739);
    Object localObject1 = j.yfh;
    localObject1 = j.b.getAccStoryCachePath();
    ad.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    Iterable localIterable = i.cT((String)localObject1, true);
    int i = 0;
    while (i < 100)
    {
      k.g(localIterable, "files");
      Iterator localIterator = localIterable.iterator();
      int j = 0;
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (j < 0) {
          d.a.j.fvx();
        }
        localObject2 = (FileSystem.a)localObject2;
        String str = ((FileSystem.a)localObject2).name;
        k.g(str, "it.name");
        if (!arv(str))
        {
          i.lC(((FileSystem.a)localObject2).EQk, ((FileSystem.a)localObject2).EQk + System.currentTimeMillis());
          if (j > 2) {
            break;
          }
        }
        j += 1;
      }
      i += 1;
    }
    ad.i("MicroMsg.StoryFileNameUtil", "testCreateFiles done cache ".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(118739);
  }
  
  public static String ih(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118728);
    if (paramString2 == null)
    {
      AppMethodBeat.o(118728);
      return "";
    }
    paramString1 = i.k(paramString1 + paramString2 + ".p", true);
    k.g(paramString1, "VFSFileOp.exportExternal…mediaId + PIC_FILE, true)");
    AppMethodBeat.o(118728);
    return paramString1;
  }
  
  private static String jo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118729);
    if (paramString2 == null)
    {
      AppMethodBeat.o(118729);
      return "";
    }
    paramString1 = i.k(paramString1 + paramString2 + ".v", true);
    k.g(paramString1, "VFSFileOp.exportExternal…diaId + VIDEO_FILE, true)");
    AppMethodBeat.o(118729);
    return paramString1;
  }
  
  public static String jp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118730);
    if (paramString1 == null)
    {
      AppMethodBeat.o(118730);
      return "";
    }
    paramString2 = arr(paramString2) + "pic/";
    paramString1 = paramString1.getBytes(d.UTF_8);
    k.g(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = ih(paramString2, g.getMessageDigest(paramString1));
    AppMethodBeat.o(118730);
    return paramString1;
  }
  
  public static String jq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118731);
    if (paramString1 == null)
    {
      AppMethodBeat.o(118731);
      return "";
    }
    paramString2 = arr(paramString2) + "video/";
    paramString1 = paramString1.getBytes(d.UTF_8);
    k.g(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = jo(paramString2, g.getMessageDigest(paramString1));
    AppMethodBeat.o(118731);
    return paramString1;
  }
  
  public static void reset()
  {
    fki = "";
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118724);
      int i = a.a((Comparable)Long.valueOf(((FileSystem.a)paramT1).HRA), (Comparable)Long.valueOf(((FileSystem.a)paramT2).HRA));
      AppMethodBeat.o(118724);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.l
 * JD-Core Version:    0.7.0.1
 */