package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/MultiTaskKeyUtil;", "", "()V", "TAG", "", "generateMultiImageCacheKey", "path", "imageLoaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "generateMultiTaskKeyForAppBrand", "appId", "versionType", "", "generateMultiTaskKeyForAppBrandLocation", "generateMultiTaskKeyForAppBrandVOIP", "generateMultiTaskKeyForFiles", "filePath", "generateMultiTaskKeyForGameDownload", "generateMultiTaskKeyForHome", "generateMultiTaskKeyForLive", "generateMultiTaskKeyForMinusScreen", "generateMultiTaskKeyForMoreWebPage", "rawUrl", "generateMultiTaskKeyForMusic", "songName", "singer", "album", "generateMultiTaskKeyForSnapShotMinusScreen", "generateMultiTaskKeyForTopStoryHorizontal", "generateMultiTaskKeyForTopStoryVertical", "generateMultiTaskKeyForVOIP", "generateMultiTaskKeyForWebPage", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g LBa;
  
  static
  {
    AppMethodBeat.i(303789);
    LBa = new g();
    AppMethodBeat.o(303789);
  }
  
  public static final String aI(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(303712);
    am localam = am.aixg;
    paramString1 = String.format("%s_%s_%s", Arrays.copyOf(new Object[] { paramString1, paramString2, paramString3 }, 3));
    s.s(paramString1, "java.lang.String.format(format, *args)");
    paramString1 = MD5Util.getMD5String(paramString1);
    s.s(paramString1, "getMD5String(String.form…songName, singer, album))");
    AppMethodBeat.o(303712);
    return paramString1;
  }
  
  public static final String aNM(String paramString)
  {
    AppMethodBeat.i(303718);
    am localam = am.aixg;
    paramString = String.format("%s", Arrays.copyOf(new Object[] { paramString }, 1));
    s.s(paramString, "java.lang.String.format(format, *args)");
    paramString = MD5Util.getMD5String(paramString);
    s.s(paramString, "getMD5String(String.format(\"%s\", rawUrl))");
    AppMethodBeat.o(303718);
    return paramString;
  }
  
  public static final String aNN(String paramString)
  {
    AppMethodBeat.i(303728);
    am localam = am.aixg;
    paramString = String.format("%s#%s", Arrays.copyOf(new Object[] { Long.valueOf(System.currentTimeMillis()), paramString }, 2));
    s.s(paramString, "java.lang.String.format(format, *args)");
    paramString = MD5Util.getMD5String(paramString);
    s.s(paramString, "getMD5String(String.form…entTimeMillis(), rawUrl))");
    AppMethodBeat.o(303728);
    return paramString;
  }
  
  public static final String aNO(String paramString)
  {
    AppMethodBeat.i(303748);
    am localam = am.aixg;
    paramString = String.format("%s", Arrays.copyOf(new Object[] { paramString }, 1));
    s.s(paramString, "java.lang.String.format(format, *args)");
    paramString = MD5Util.getMD5String(paramString);
    s.s(paramString, "getMD5String(String.format(\"%s\", filePath))");
    AppMethodBeat.o(303748);
    return paramString;
  }
  
  public static String e(String paramString, c paramc)
  {
    AppMethodBeat.i(303775);
    s.u(paramString, "path");
    s.u(paramc, "imageLoaderOptions");
    String str = paramString;
    if (paramc.nrc) {
      str = paramString + "round" + paramc.oKI;
    }
    paramString = str;
    if (!Util.isNullOrNil(paramc.oKG)) {
      paramString = s.X(str, paramc.oKG);
    }
    paramString = paramString + "size" + paramc.npU + paramc.npV;
    AppMethodBeat.o(303775);
    return paramString;
  }
  
  public static final String gj(String paramString, int paramInt)
  {
    AppMethodBeat.i(303736);
    am localam = am.aixg;
    paramString = String.format(Locale.US, "%s#%d", Arrays.copyOf(new Object[] { paramString, Integer.valueOf(paramInt) }, 2));
    s.s(paramString, "java.lang.String.format(locale, format, *args)");
    AppMethodBeat.o(303736);
    return paramString;
  }
  
  public static String gjr()
  {
    return "MultiTaskForMinusScreen";
  }
  
  public static String gjs()
  {
    return "MultiTaskForSnapshotMinusScreen";
  }
  
  public static String gjt()
  {
    return "Home";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.g
 * JD-Core Version:    0.7.0.1
 */