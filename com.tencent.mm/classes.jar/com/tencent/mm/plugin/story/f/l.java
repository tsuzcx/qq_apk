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
import d.g.b.p;
import d.n.d;
import d.o;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryFileNameUtil;", "", "()V", "MIX_AUDIO_FILE", "", "MIX_CP_DIR", "MIX_DIR", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PICFILE", "PIC_FILE", "TAG", "TMP_FILE", "UP_FILE", "VIDEOFILE", "VIDEO_FILE", "selfName", "getSelfName", "()Ljava/lang/String;", "setSelfName", "(Ljava/lang/String;)V", "accMixStoryPath", "accPath", "audioEnsurePath", "parentPath", "mediaId", "autoPath", "user", "cachePath", "checkSelfName", "checkToCreateDir", "", "newVideoPath", "noMedia", "", "cleanFiles", "copyCacheDir", "path", "dumpCacheDir", "Lkotlin/Pair;", "", "subDir", "getMixAudioPath", "localId", "getMixThumbPath", "getMixVideoPath", "init", "isNoMedia", "name", "isSelf", "userName", "primaryPathVideoPath", "username", "reset", "testCreateFiles", "thumbEnsurePath", "thumbPath", "url", "thumbPathInDownload", "thumbPathInUpload", "videoEnsurePath", "videoPath", "videoPathInDownload", "videoPathInUpload", "plugin-story_release"})
public final class l
{
  public static final l AKo;
  private static String fFK;
  
  static
  {
    AppMethodBeat.i(118740);
    AKo = new l();
    fFK = "";
    AppMethodBeat.o(118740);
  }
  
  public static String aBF(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(118727);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)fFK;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label121;
        }
        i = 1;
        label53:
        if (i == 0) {
          break label131;
        }
        paramString = (CharSequence)fFK;
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
          paramString = j.AKb;
          fFK = j.b.dTJ();
        }
      }
    }
    label95:
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label146;
      }
      paramString = j.AKb;
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
      if (!p.i(fFK, paramString)) {
        break label95;
      }
    }
    label131:
    label146:
    paramString = j.AKb;
    paramString = j.b.getAccStoryCachePath();
    AppMethodBeat.o(118727);
    return paramString;
  }
  
  public static String aBG(String paramString)
  {
    AppMethodBeat.i(118732);
    if (paramString == null)
    {
      AppMethodBeat.o(118732);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    j.b localb = j.AKb;
    paramString = iN(j.b.getAccStoryPath(), paramString) + ".u";
    AppMethodBeat.o(118732);
    return paramString;
  }
  
  public static String aBH(String paramString)
  {
    AppMethodBeat.i(118733);
    if (paramString == null)
    {
      AppMethodBeat.o(118733);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    j.b localb = j.AKb;
    paramString = kb(j.b.getAccStoryPath(), paramString) + ".u";
    AppMethodBeat.o(118733);
    return paramString;
  }
  
  public static boolean aBJ(String paramString)
  {
    AppMethodBeat.i(118736);
    p.h(paramString, "name");
    if (p.i(".nomedia", paramString))
    {
      AppMethodBeat.o(118736);
      return true;
    }
    AppMethodBeat.o(118736);
    return false;
  }
  
  private static o<String, Long> aBK(String paramString)
  {
    AppMethodBeat.i(118738);
    b localb = new b("dumpCacheDir");
    Object localObject1 = new StringBuilder();
    Object localObject2 = j.AKb;
    localObject1 = j.b.getAccStoryCachePath() + paramString;
    ad.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    localObject1 = i.de((String)localObject1, true);
    long l1;
    long l2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = q.b((Iterable)localObject1);
      if ((localObject1 != null) && (((List)localObject1).size() > 1)) {
        d.a.j.a((List)localObject1, (Comparator)new a());
      }
      l1 = 0L;
      l2 = l1;
      if (localObject1 == null) {
        break label312;
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
          d.a.j.gfB();
        }
        localObject3 = (FileSystem.a)localObject3;
        l2 = l1;
        if (localObject3 != null)
        {
          ad.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir " + i + " filePath: " + ((FileSystem.a)localObject3).name + " time: " + ((FileSystem.a)localObject3).LjK + " size: " + bt.sy(((FileSystem.a)localObject3).size) + ' ' + ((FileSystem.a)localObject3).HZk);
          String str = ((FileSystem.a)localObject3).name;
          p.g(str, "fileEntry.name");
          if (aBJ(str)) {
            break label422;
          }
          l2 = l1 + ((FileSystem.a)localObject3).size;
        }
        i = j;
        l1 = l2;
        continue;
        localObject1 = null;
        break;
      }
      label312:
      localObject2 = new StringBuilder("dumpCacheDir ").append(paramString).append(" totalSize ").append(bt.sy(l2)).append(" fileCounts ");
      if (localObject1 != null) {}
      for (paramString = Integer.valueOf(((List)localObject1).size());; paramString = null)
      {
        paramString = paramString + " cost:" + localb + " \n";
        ad.i("MicroMsg.StoryFileNameUtil", paramString);
        paramString = new o(paramString, Long.valueOf(l2));
        AppMethodBeat.o(118738);
        return paramString;
      }
      label422:
      i = j;
    }
  }
  
  public static void awb(String paramString)
  {
    AppMethodBeat.i(118734);
    p.h(paramString, "newVideoPath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(118734);
      return;
    }
    paramString = i.aYr(paramString);
    i.aYg(paramString);
    i.aYu(paramString);
    AppMethodBeat.o(118734);
  }
  
  public static String cLR()
  {
    AppMethodBeat.i(118737);
    new b("dumpCacheDir");
    Object localObject = aBK("pic/");
    o localo = aBK("video/");
    StringBuilder localStringBuilder = new StringBuilder().append((String)((o)localObject).first).append("  ").append((String)localo.first).append(" total: ");
    long l = ((Number)((o)localObject).second).longValue();
    localObject = bt.Dd(((Number)localo.second).longValue() + l);
    AppMethodBeat.o(118737);
    return localObject;
  }
  
  static String eii()
  {
    AppMethodBeat.i(118725);
    Object localObject = j.AKb;
    localObject = j.b.getAccStoryPath();
    AppMethodBeat.o(118725);
    return localObject;
  }
  
  static String eij()
  {
    AppMethodBeat.i(118726);
    Object localObject = j.AKb;
    localObject = j.b.getAccStoryCachePath();
    AppMethodBeat.o(118726);
    return localObject;
  }
  
  public static void eik()
  {
    AppMethodBeat.i(118739);
    Object localObject1 = j.AKb;
    localObject1 = j.b.getAccStoryCachePath();
    ad.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    Iterable localIterable = i.de((String)localObject1, true);
    int i = 0;
    Iterator localIterator;
    int j;
    if (i < 100)
    {
      p.g(localIterable, "files");
      localIterator = localIterable.iterator();
      j = 0;
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (j < 0) {
          d.a.j.gfB();
        }
        localObject2 = (FileSystem.a)localObject2;
        String str = ((FileSystem.a)localObject2).name;
        p.g(str, "it.name");
        if (!aBJ(str))
        {
          i.mz(((FileSystem.a)localObject2).HZk, ((FileSystem.a)localObject2).HZk + System.currentTimeMillis());
          if (j <= 2) {}
        }
      }
      else
      {
        i += 1;
        break;
        ad.i("MicroMsg.StoryFileNameUtil", "testCreateFiles done cache ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(118739);
        return;
      }
      j += 1;
    }
  }
  
  public static String iN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118728);
    if (paramString2 == null)
    {
      AppMethodBeat.o(118728);
      return "";
    }
    paramString1 = i.k(paramString1 + paramString2 + ".p", true);
    p.g(paramString1, "VFSFileOp.exportExternal…mediaId + PIC_FILE, true)");
    AppMethodBeat.o(118728);
    return paramString1;
  }
  
  private static String kb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118729);
    if (paramString2 == null)
    {
      AppMethodBeat.o(118729);
      return "";
    }
    paramString1 = i.k(paramString1 + paramString2 + ".v", true);
    p.g(paramString1, "VFSFileOp.exportExternal…diaId + VIDEO_FILE, true)");
    AppMethodBeat.o(118729);
    return paramString1;
  }
  
  public static String kc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118730);
    if (paramString1 == null)
    {
      AppMethodBeat.o(118730);
      return "";
    }
    paramString2 = aBF(paramString2) + "pic/";
    paramString1 = paramString1.getBytes(d.UTF_8);
    p.g(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = iN(paramString2, g.getMessageDigest(paramString1));
    AppMethodBeat.o(118730);
    return paramString1;
  }
  
  public static String kd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(118731);
    if (paramString1 == null)
    {
      AppMethodBeat.o(118731);
      return "";
    }
    paramString2 = aBF(paramString2) + "video/";
    paramString1 = paramString1.getBytes(d.UTF_8);
    p.g(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = kb(paramString2, g.getMessageDigest(paramString1));
    AppMethodBeat.o(118731);
    return paramString1;
  }
  
  public static void reset()
  {
    fFK = "";
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118724);
      int i = a.a((Comparable)Long.valueOf(((FileSystem.a)paramT1).LjK), (Comparable)Long.valueOf(((FileSystem.a)paramT2).LjK));
      AppMethodBeat.o(118724);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.l
 * JD-Core Version:    0.7.0.1
 */