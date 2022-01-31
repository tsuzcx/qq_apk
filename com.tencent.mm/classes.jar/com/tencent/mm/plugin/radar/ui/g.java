package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mm.protocal.c.bil;
import com.tencent.mm.protocal.c.bio;

public final class g
{
  public static final g nnt = new g();
  
  public static String a(bil parambil)
  {
    if (parambil != null)
    {
      String str = parambil.sUr;
      Object localObject = str;
      if (str == null)
      {
        parambil = parambil.hPY;
        localObject = parambil;
        if (parambil == null) {
          localObject = "";
        }
      }
      parambil = (bil)localObject;
      if (localObject != null) {}
    }
    else
    {
      parambil = "";
    }
    return parambil;
  }
  
  public static String b(bio parambio)
  {
    a.d.b.g.k(parambio, "member");
    String str = parambio.hPY;
    Object localObject = str;
    if (str == null)
    {
      parambio = parambio.sUr;
      localObject = parambio;
      if (parambio == null) {
        localObject = "";
      }
    }
    return localObject;
  }
  
  public static String c(bio parambio)
  {
    if (parambio != null)
    {
      String str = parambio.sUr;
      Object localObject = str;
      if (str == null)
      {
        parambio = parambio.hPY;
        localObject = parambio;
        if (parambio == null) {
          localObject = "";
        }
      }
      parambio = (bio)localObject;
      if (localObject != null) {}
    }
    else
    {
      parambio = "";
    }
    return parambio;
  }
  
  public static boolean dY(Context paramContext)
  {
    a.d.b.g.k(paramContext, "context");
    paramContext = paramContext.getResources();
    a.d.b.g.j(paramContext, "context.resources");
    return paramContext.getDisplayMetrics().densityDpi <= 240;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.g
 * JD-Core Version:    0.7.0.1
 */