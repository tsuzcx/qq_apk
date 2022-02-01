package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class BackwardSupportUtil$b
{
  public static Bitmap a(InputStream paramInputStream, float paramFloat)
  {
    AppMethodBeat.i(156064);
    paramInputStream = b(paramInputStream, paramFloat);
    AppMethodBeat.o(156064);
    return paramInputStream;
  }
  
  public static Bitmap b(InputStream paramInputStream, float paramFloat)
  {
    AppMethodBeat.i(156065);
    paramInputStream = f.a(paramInputStream, paramFloat, 0, 0);
    if (paramInputStream != null) {
      paramInputStream.setDensity((int)(160.0F * paramFloat));
    }
    AppMethodBeat.o(156065);
    return paramInputStream;
  }
  
  public static int g(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(156063);
    int i = Math.round(paramContext.getResources().getDisplayMetrics().densityDpi * paramFloat / 160.0F);
    AppMethodBeat.o(156063);
    return i;
  }
  
  public static String in(Context paramContext)
  {
    AppMethodBeat.i(156066);
    Object localObject = paramContext.getResources().getDisplayMetrics();
    Configuration localConfiguration = paramContext.getResources().getConfiguration();
    if (((DisplayMetrics)localObject).density < 1.0F)
    {
      paramContext = "" + "LDPI";
      localObject = new StringBuilder().append(paramContext);
      if (localConfiguration.orientation != 2) {
        break label148;
      }
    }
    label148:
    for (paramContext = "_L";; paramContext = "_P")
    {
      paramContext = paramContext;
      AppMethodBeat.o(156066);
      return paramContext;
      if (((DisplayMetrics)localObject).density >= 1.5F)
      {
        paramContext = "" + "HDPI";
        break;
      }
      paramContext = "" + "MDPI";
      break;
    }
  }
  
  public static String io(Context paramContext)
  {
    AppMethodBeat.i(175899);
    paramContext = paramContext.getResources().getDisplayMetrics();
    paramContext = paramContext.heightPixels + "x" + paramContext.widthPixels;
    AppMethodBeat.o(175899);
    return paramContext;
  }
  
  public static Bitmap n(String paramString, float paramFloat)
  {
    AppMethodBeat.i(156062);
    paramString = f.o(paramString, paramFloat);
    if (paramString != null) {
      paramString.setDensity((int)(160.0F * paramFloat));
    }
    AppMethodBeat.o(156062);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b
 * JD-Core Version:    0.7.0.1
 */