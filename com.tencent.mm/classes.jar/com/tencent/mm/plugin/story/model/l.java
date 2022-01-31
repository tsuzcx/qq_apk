package com.tencent.mm.plugin.story.model;

import a.l.d;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.ab.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.e;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryFileNameUtil;", "", "()V", "MIX_AUDIO_FILE", "", "MIX_CP_DIR", "MIX_DIR", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PICFILE", "PIC_FILE", "TAG", "TMP_FILE", "UP_FILE", "VIDEOFILE", "VIDEO_FILE", "selfName", "getSelfName", "()Ljava/lang/String;", "setSelfName", "(Ljava/lang/String;)V", "accMixStoryPath", "accPath", "audioEnsurePath", "parentPath", "mediaId", "autoPath", "user", "cachePath", "checkSelfName", "checkToCreateDir", "", "newVideoPath", "noMedia", "", "cleanFiles", "copyCacheDir", "path", "dumpCacheDir", "Lkotlin/Pair;", "", "subDir", "getMixAudioPath", "localId", "getMixThumbPath", "getMixVideoPath", "init", "isNoMedia", "name", "isSelf", "userName", "primaryPathVideoPath", "username", "reset", "testCreateFiles", "thumbEnsurePath", "thumbPath", "url", "thumbPathInDownload", "thumbPathInUpload", "videoEnsurePath", "videoPath", "videoPathInDownload", "videoPathInUpload", "plugin-story_release"})
public final class l
{
  private static String dZZ;
  public static final l svv;
  
  static
  {
    AppMethodBeat.i(109117);
    svv = new l();
    dZZ = "";
    AppMethodBeat.o(109117);
  }
  
  public static String acW(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(109101);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)dZZ;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label121;
        }
        i = 1;
        label53:
        if (i == 0) {
          break label131;
        }
        paramString = (CharSequence)dZZ;
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
          paramString = j.svi;
          dZZ = j.b.coK();
        }
      }
    }
    label95:
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label146;
      }
      paramString = j.svi;
      paramString = j.b.getAccStoryPath();
      AppMethodBeat.o(109101);
      return paramString;
      i = 0;
      break;
      label121:
      i = 0;
      break label53;
      label126:
      i = 0;
      break label81;
      if (!a.f.b.j.e(dZZ, paramString)) {
        break label95;
      }
    }
    label131:
    label146:
    paramString = j.svi;
    paramString = j.b.getAccStoryCachePath();
    AppMethodBeat.o(109101);
    return paramString;
  }
  
  public static String acX(String paramString)
  {
    AppMethodBeat.i(109106);
    if (paramString == null)
    {
      AppMethodBeat.o(109106);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    j.b localb = j.svi;
    paramString = gK(j.b.getAccStoryPath(), paramString) + ".u";
    AppMethodBeat.o(109106);
    return paramString;
  }
  
  public static String acY(String paramString)
  {
    AppMethodBeat.i(109107);
    if (paramString == null)
    {
      AppMethodBeat.o(109107);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    j.b localb = j.svi;
    paramString = gL(j.b.getAccStoryPath(), paramString) + ".u";
    AppMethodBeat.o(109107);
    return paramString;
  }
  
  public static final String acZ(String paramString)
  {
    AppMethodBeat.i(109108);
    if (paramString == null)
    {
      AppMethodBeat.o(109108);
      return "";
    }
    paramString = gL(cAR(), paramString) + ".mixv";
    AppMethodBeat.o(109108);
    return paramString;
  }
  
  public static final String ada(String paramString)
  {
    AppMethodBeat.i(109109);
    if (paramString == null)
    {
      AppMethodBeat.o(109109);
      return "";
    }
    paramString = gK(cAR(), paramString) + ".mixt";
    AppMethodBeat.o(109109);
    return paramString;
  }
  
  public static final String adb(String paramString)
  {
    AppMethodBeat.i(109110);
    if (paramString == null)
    {
      AppMethodBeat.o(109110);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = cAR();
    if (paramString == null) {}
    for (paramString = "";; paramString = str + paramString + ".p")
    {
      paramString = paramString + ".mixa";
      AppMethodBeat.o(109110);
      return paramString;
    }
  }
  
  public static void adc(String paramString)
  {
    AppMethodBeat.i(109111);
    a.f.b.j.q(paramString, "newVideoPath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(109111);
      return;
    }
    paramString = e.avK(paramString);
    e.um(paramString);
    e.avN(paramString);
    AppMethodBeat.o(109111);
  }
  
  public static boolean ade(String paramString)
  {
    AppMethodBeat.i(109113);
    a.f.b.j.q(paramString, "name");
    if (a.f.b.j.e(".nomedia", paramString))
    {
      AppMethodBeat.o(109113);
      return true;
    }
    AppMethodBeat.o(109113);
    return false;
  }
  
  private static o<String, Long> adf(String paramString)
  {
    AppMethodBeat.i(109115);
    a locala = new a("dumpCacheDir");
    Object localObject1 = new StringBuilder();
    Object localObject2 = j.svi;
    localObject1 = j.b.getAccStoryCachePath() + paramString;
    ab.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    localObject1 = e.cs((String)localObject1, true);
    if ((localObject1 != null) && (((List)localObject1).size() > 1)) {
      a.a.j.a((List)localObject1, (Comparator)new l.a());
    }
    long l1 = 0L;
    long l2 = l1;
    if (localObject1 != null)
    {
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
          a.a.j.eaS();
        }
        localObject3 = (FileSystem.a)localObject3;
        l2 = l1;
        if (localObject3 != null)
        {
          ab.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir " + i + " filePath: " + ((FileSystem.a)localObject3).name + " time: " + ((FileSystem.a)localObject3).APt + " size: " + bo.hk(((FileSystem.a)localObject3).size) + ' ' + ((FileSystem.a)localObject3).APr);
          String str = ((FileSystem.a)localObject3).name;
          a.f.b.j.p(str, "fileEntry.name");
          l2 = l1;
          if (!ade(str)) {
            l2 = l1 + ((FileSystem.a)localObject3).size;
          }
        }
        i += 1;
        l1 = l2;
      }
    }
    localObject2 = new StringBuilder("dumpCacheDir ").append(paramString).append(" totalSize ").append(bo.hk(l2)).append(" fileCounts ");
    if (localObject1 != null) {}
    for (paramString = Integer.valueOf(((List)localObject1).size());; paramString = null)
    {
      paramString = paramString + " cost:" + locala + " \n";
      ab.i("MicroMsg.StoryFileNameUtil", paramString);
      paramString = new o(paramString, Long.valueOf(l2));
      AppMethodBeat.o(109115);
      return paramString;
    }
  }
  
  private static String cAR()
  {
    AppMethodBeat.i(109098);
    Object localObject = new StringBuilder();
    j.b localb = j.svi;
    localObject = j.b.getAccStoryPath() + "coming/";
    AppMethodBeat.o(109098);
    return localObject;
  }
  
  static String cAS()
  {
    AppMethodBeat.i(156826);
    Object localObject = j.svi;
    localObject = j.b.getAccStoryPath();
    AppMethodBeat.o(156826);
    return localObject;
  }
  
  static String cAT()
  {
    AppMethodBeat.i(109100);
    Object localObject = j.svi;
    localObject = j.b.getAccStoryCachePath();
    AppMethodBeat.o(109100);
    return localObject;
  }
  
  public static String cAU()
  {
    AppMethodBeat.i(109114);
    new a("dumpCacheDir");
    Object localObject = adf("/pic/");
    o localo = adf("/video/");
    StringBuilder localStringBuilder = new StringBuilder().append((String)((o)localObject).first).append("  ").append((String)localo.first).append(" total: ");
    long l = ((Number)((o)localObject).second).longValue();
    localObject = bo.nV(((Number)localo.second).longValue() + l);
    AppMethodBeat.o(109114);
    return localObject;
  }
  
  public static void cAV()
  {
    AppMethodBeat.i(109116);
    Object localObject1 = j.svi;
    localObject1 = j.b.getAccStoryCachePath();
    ab.i("MicroMsg.StoryFileNameUtil", "dumpCacheDir cache ".concat(String.valueOf(localObject1)));
    List localList = e.cs((String)localObject1, true);
    int i = 0;
    while (i < 100)
    {
      a.f.b.j.p(localList, "files");
      Iterator localIterator = ((Iterable)localList).iterator();
      int j = 0;
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (j < 0) {
          a.a.j.eaS();
        }
        localObject2 = (FileSystem.a)localObject2;
        String str = ((FileSystem.a)localObject2).name;
        a.f.b.j.p(str, "it.name");
        if (!ade(str))
        {
          e.C(((FileSystem.a)localObject2).APr, ((FileSystem.a)localObject2).APr + System.currentTimeMillis());
          if (j > 2) {
            break;
          }
        }
        j += 1;
      }
      i += 1;
    }
    ab.i("MicroMsg.StoryFileNameUtil", "testCreateFiles done cache ".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(109116);
  }
  
  public static String gK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(109102);
    if (paramString2 == null)
    {
      AppMethodBeat.o(109102);
      return "";
    }
    paramString1 = paramString1 + paramString2 + ".p";
    AppMethodBeat.o(109102);
    return paramString1;
  }
  
  private static String gL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(109103);
    if (paramString2 == null)
    {
      AppMethodBeat.o(109103);
      return "";
    }
    paramString1 = paramString1 + paramString2 + ".v";
    AppMethodBeat.o(109103);
    return paramString1;
  }
  
  public static String gM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(109104);
    if (paramString1 == null)
    {
      AppMethodBeat.o(109104);
      return "";
    }
    paramString2 = acW(paramString2) + "/pic/";
    paramString1 = paramString1.getBytes(d.UTF_8);
    a.f.b.j.p(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = gK(paramString2, g.w(paramString1));
    AppMethodBeat.o(109104);
    return paramString1;
  }
  
  public static String gN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(109105);
    if (paramString1 == null)
    {
      AppMethodBeat.o(109105);
      return "";
    }
    paramString2 = acW(paramString2) + "/video/";
    paramString1 = paramString1.getBytes(d.UTF_8);
    a.f.b.j.p(paramString1, "(this as java.lang.String).getBytes(charset)");
    paramString1 = gL(paramString2, g.w(paramString1));
    AppMethodBeat.o(109105);
    return paramString1;
  }
  
  public static void reset()
  {
    dZZ = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.l
 * JD-Core Version:    0.7.0.1
 */