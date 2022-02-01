package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.Locale;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/MultiTaskKeyUtil;", "", "()V", "TAG", "", "generateMultiImageCacheKey", "path", "imageLoaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "generateMultiTaskKeyForAppBrand", "appId", "versionType", "", "generateMultiTaskKeyForAppBrandLocation", "generateMultiTaskKeyForAppBrandVOIP", "generateMultiTaskKeyForFiles", "filePath", "generateMultiTaskKeyForGameDownload", "generateMultiTaskKeyForHome", "generateMultiTaskKeyForLive", "generateMultiTaskKeyForMinusScreen", "generateMultiTaskKeyForMoreWebPage", "rawUrl", "generateMultiTaskKeyForMusic", "songName", "singer", "album", "generateMultiTaskKeyForSnapShotMinusScreen", "generateMultiTaskKeyForTopStoryHorizontal", "generateMultiTaskKeyForTopStoryVertical", "generateMultiTaskKeyForVOIP", "generateMultiTaskKeyForWebPage", "plugin-multitask_release"})
public final class g
{
  public static final g FEX;
  
  static
  {
    AppMethodBeat.i(247884);
    FEX = new g();
    AppMethodBeat.o(247884);
  }
  
  public static final String aQU(String paramString)
  {
    AppMethodBeat.i(247874);
    af localaf = af.aaBG;
    paramString = String.format("%s", Arrays.copyOf(new Object[] { paramString }, 1));
    p.j(paramString, "java.lang.String.format(format, *args)");
    paramString = MD5Util.getMD5String(paramString);
    p.j(paramString, "MD5Util.getMD5String(String.format(\"%s\", rawUrl))");
    AppMethodBeat.o(247874);
    return paramString;
  }
  
  public static final String aQV(String paramString)
  {
    AppMethodBeat.i(247875);
    af localaf = af.aaBG;
    paramString = String.format("%s#%s", Arrays.copyOf(new Object[] { Long.valueOf(System.currentTimeMillis()), paramString }, 2));
    p.j(paramString, "java.lang.String.format(format, *args)");
    paramString = MD5Util.getMD5String(paramString);
    p.j(paramString, "MD5Util.getMD5String(Str…entTimeMillis(), rawUrl))");
    AppMethodBeat.o(247875);
    return paramString;
  }
  
  public static final String aQW(String paramString)
  {
    AppMethodBeat.i(247879);
    af localaf = af.aaBG;
    paramString = String.format("%s", Arrays.copyOf(new Object[] { paramString }, 1));
    p.j(paramString, "java.lang.String.format(format, *args)");
    paramString = MD5Util.getMD5String(paramString);
    p.j(paramString, "MD5Util.getMD5String(Str…g.format(\"%s\", filePath))");
    AppMethodBeat.o(247879);
    return paramString;
  }
  
  public static final String au(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(247873);
    af localaf = af.aaBG;
    paramString1 = String.format("%s_%s_%s", Arrays.copyOf(new Object[] { paramString1, paramString2, paramString3 }, 3));
    p.j(paramString1, "java.lang.String.format(format, *args)");
    paramString1 = MD5Util.getMD5String(paramString1);
    p.j(paramString1, "MD5Util.getMD5String(Str…songName, singer, album))");
    AppMethodBeat.o(247873);
    return paramString1;
  }
  
  public static String e(String paramString, c paramc)
  {
    AppMethodBeat.i(247882);
    p.k(paramString, "path");
    p.k(paramc, "imageLoaderOptions");
    String str = paramString;
    if (paramc.bmC()) {
      str = paramString + "round" + paramc.bmD();
    }
    paramString = str;
    if (!Util.isNullOrNil(paramc.bmE())) {
      paramString = str + paramc.bmE();
    }
    paramString = paramString + "size" + paramc.bmA() + paramc.bmB();
    AppMethodBeat.o(247882);
    return paramString;
  }
  
  public static String fam()
  {
    return "MultiTaskForMinusScreen";
  }
  
  public static String fan()
  {
    return "MultiTaskForSnapshotMinusScreen";
  }
  
  public static String fao()
  {
    return "Home";
  }
  
  public static final String fq(String paramString, int paramInt)
  {
    AppMethodBeat.i(247877);
    Object localObject = af.aaBG;
    localObject = Locale.US;
    p.j(localObject, "Locale.US");
    paramString = String.format((Locale)localObject, "%s#%d", Arrays.copyOf(new Object[] { paramString, Integer.valueOf(paramInt) }, 2));
    p.j(paramString, "java.lang.String.format(locale, format, *args)");
    AppMethodBeat.o(247877);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.g
 * JD-Core Version:    0.7.0.1
 */