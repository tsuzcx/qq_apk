package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.Locale;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/MultiTaskKeyUtil;", "", "()V", "TAG", "", "generateMultiImageCacheKey", "path", "imageLoaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "generateMultiTaskKeyForAppBrand", "appId", "versionType", "", "generateMultiTaskKeyForAppBrandLocation", "generateMultiTaskKeyForAppBrandVOIP", "generateMultiTaskKeyForFiles", "filePath", "generateMultiTaskKeyForGameDownload", "generateMultiTaskKeyForHome", "generateMultiTaskKeyForLive", "generateMultiTaskKeyForMinusScreen", "generateMultiTaskKeyForMoreWebPage", "rawUrl", "generateMultiTaskKeyForMusic", "songName", "singer", "album", "generateMultiTaskKeyForSnapShotMinusScreen", "generateMultiTaskKeyForTopStoryHorizontal", "generateMultiTaskKeyForTopStoryVertical", "generateMultiTaskKeyForVOIP", "generateMultiTaskKeyForWebPage", "plugin-multitask_release"})
public final class g
{
  public static final g zZj;
  
  static
  {
    AppMethodBeat.i(200296);
    zZj = new g();
    AppMethodBeat.o(200296);
  }
  
  public static final String aGG(String paramString)
  {
    AppMethodBeat.i(200291);
    ae localae = ae.SYK;
    paramString = String.format("%s", Arrays.copyOf(new Object[] { paramString }, 1));
    p.g(paramString, "java.lang.String.format(format, *args)");
    paramString = MD5Util.getMD5String(paramString);
    p.g(paramString, "MD5Util.getMD5String(String.format(\"%s\", rawUrl))");
    AppMethodBeat.o(200291);
    return paramString;
  }
  
  public static final String aGH(String paramString)
  {
    AppMethodBeat.i(200292);
    ae localae = ae.SYK;
    paramString = String.format("%s#%s", Arrays.copyOf(new Object[] { Long.valueOf(System.currentTimeMillis()), paramString }, 2));
    p.g(paramString, "java.lang.String.format(format, *args)");
    paramString = MD5Util.getMD5String(paramString);
    p.g(paramString, "MD5Util.getMD5String(Str…entTimeMillis(), rawUrl))");
    AppMethodBeat.o(200292);
    return paramString;
  }
  
  public static final String aGI(String paramString)
  {
    AppMethodBeat.i(200294);
    ae localae = ae.SYK;
    paramString = String.format("%s", Arrays.copyOf(new Object[] { paramString }, 1));
    p.g(paramString, "java.lang.String.format(format, *args)");
    paramString = MD5Util.getMD5String(paramString);
    p.g(paramString, "MD5Util.getMD5String(Str…g.format(\"%s\", filePath))");
    AppMethodBeat.o(200294);
    return paramString;
  }
  
  public static final String az(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(200290);
    ae localae = ae.SYK;
    paramString1 = String.format("%s_%s_%s", Arrays.copyOf(new Object[] { paramString1, paramString2, paramString3 }, 3));
    p.g(paramString1, "java.lang.String.format(format, *args)");
    paramString1 = MD5Util.getMD5String(paramString1);
    p.g(paramString1, "MD5Util.getMD5String(Str…songName, singer, album))");
    AppMethodBeat.o(200290);
    return paramString1;
  }
  
  public static String e(String paramString, c paramc)
  {
    AppMethodBeat.i(200295);
    p.h(paramString, "path");
    p.h(paramc, "imageLoaderOptions");
    String str = paramString;
    if (paramc.bdl()) {
      str = paramString + "round" + paramc.bdm();
    }
    paramString = str;
    if (!Util.isNullOrNil(paramc.bdn())) {
      paramString = str + paramc.bdn();
    }
    paramString = paramString + "size" + paramc.bdj() + paramc.bdk();
    AppMethodBeat.o(200295);
    return paramString;
  }
  
  public static final String eP(String paramString, int paramInt)
  {
    AppMethodBeat.i(200293);
    Object localObject = ae.SYK;
    localObject = Locale.US;
    p.g(localObject, "Locale.US");
    paramString = String.format((Locale)localObject, "%s#%d", Arrays.copyOf(new Object[] { paramString, Integer.valueOf(paramInt) }, 2));
    p.g(paramString, "java.lang.String.format(locale, format, *args)");
    AppMethodBeat.o(200293);
    return paramString;
  }
  
  public static String eqw()
  {
    return "MultiTaskForMinusScreen";
  }
  
  public static String eqx()
  {
    return "MultiTaskForSnapshotMinusScreen";
  }
  
  public static String eqy()
  {
    return "Home";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.g
 * JD-Core Version:    0.7.0.1
 */