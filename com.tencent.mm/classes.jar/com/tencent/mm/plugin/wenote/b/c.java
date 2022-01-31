package com.tencent.mm.plugin.wenote.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
{
  public static HashMap<String, String> vBI;
  public static HashMap<String, r> vBJ;
  public static c vBK;
  private static com.tencent.mm.a.f<String, Integer> vBL;
  
  static
  {
    AppMethodBeat.i(26993);
    vBI = new HashMap();
    vBJ = new HashMap();
    vBK = null;
    vBL = new com.tencent.mm.memory.a.c(30);
    AppMethodBeat.o(26993);
  }
  
  private static int A(char paramChar)
  {
    if (paramChar <= '') {
      return 1;
    }
    return 2;
  }
  
  public static String a(Context paramContext, com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    AppMethodBeat.i(26991);
    if (paramc == null)
    {
      AppMethodBeat.o(26991);
      return "";
    }
    int i = paramc.getType();
    if (i == 1)
    {
      paramContext = ((i)paramc).content;
      AppMethodBeat.o(26991);
      return paramContext;
    }
    if (i == 3)
    {
      paramContext = paramContext.getString(2131305970);
      AppMethodBeat.o(26991);
      return paramContext;
    }
    if (i == 2)
    {
      paramContext = paramContext.getString(2131305969);
      AppMethodBeat.o(26991);
      return paramContext;
    }
    if (i == 6)
    {
      paramContext = paramContext.getString(2131305971);
      AppMethodBeat.o(26991);
      return paramContext;
    }
    if (i == 4)
    {
      paramContext = paramContext.getString(2131305972);
      AppMethodBeat.o(26991);
      return paramContext;
    }
    if (i == 5)
    {
      paramContext = paramContext.getString(2131305968);
      AppMethodBeat.o(26991);
      return paramContext;
    }
    AppMethodBeat.o(26991);
    return "";
  }
  
  public static Bitmap ajT(String paramString)
  {
    AppMethodBeat.i(26983);
    paramString = com.tencent.mm.plugin.fav.ui.c.aO(paramString, false);
    if (paramString != null)
    {
      AppMethodBeat.o(26983);
      return paramString;
    }
    if (bo.isNullOrNil(null))
    {
      AppMethodBeat.o(26983);
      return null;
    }
    paramString = com.tencent.mm.plugin.fav.ui.c.aO(null, false);
    AppMethodBeat.o(26983);
    return paramString;
  }
  
  public static int ajU(String paramString)
  {
    AppMethodBeat.i(26987);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26987);
      return 0;
    }
    int i = ajW(b.ajQ(paramString));
    AppMethodBeat.o(26987);
    return i;
  }
  
  public static int ajV(String paramString)
  {
    AppMethodBeat.i(26989);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26989);
      return 0;
    }
    if (vBL.Z(paramString))
    {
      i = ((Integer)vBL.get(paramString)).intValue();
      AppMethodBeat.o(26989);
      return i;
    }
    int i = ajW(paramString);
    vBL.put(paramString, Integer.valueOf(i));
    AppMethodBeat.o(26989);
    return i;
  }
  
  private static int ajW(String paramString)
  {
    AppMethodBeat.i(26990);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26990);
      return 0;
    }
    int j = 0;
    int k;
    for (int i = 0; j < paramString.length(); i = k + i)
    {
      k = A(paramString.charAt(j));
      j += 1;
    }
    AppMethodBeat.o(26990);
    return i;
  }
  
  public static String ajX(String paramString)
  {
    AppMethodBeat.i(26992);
    paramString = Pattern.compile("wx-b>", 2).matcher(paramString).replaceAll("wa-b>");
    paramString = Pattern.compile("</wx-li>", 2).matcher(paramString).replaceAll("<br/>");
    paramString = Pattern.compile("</wn-todo>", 2).matcher(paramString).replaceAll("<br/>");
    paramString = Pattern.compile("<[/]?w(x|n)-[^>]*>", 2).matcher(paramString).replaceAll("");
    paramString = Pattern.compile("wa-b>", 2).matcher(paramString).replaceAll("wx-b>");
    AppMethodBeat.o(26992);
    return paramString;
  }
  
  public static int c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(26988);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26988);
      return 0;
    }
    paramString = a.ajK(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(26988);
      return 0;
    }
    if (paramBoolean) {
      paramInt2 = paramString.length();
    }
    if ((paramInt1 < 0) || (paramInt1 > paramString.length()) || (paramInt2 < 0) || (paramInt2 > paramString.length()) || (paramInt1 > paramInt2))
    {
      AppMethodBeat.o(26988);
      return 0;
    }
    paramString = (Spanned)paramString.subSequence(paramInt1, paramInt2);
    if (paramString == null)
    {
      AppMethodBeat.o(26988);
      return 0;
    }
    paramInt1 = ajW(paramString.toString());
    AppMethodBeat.o(26988);
    return paramInt1;
  }
  
  public static com.tencent.mm.plugin.wenote.model.a.c c(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    AppMethodBeat.i(26984);
    if (paramc == null)
    {
      AppMethodBeat.o(26984);
      return null;
    }
    Object localObject1;
    switch (paramc.getType())
    {
    case 0: 
    default: 
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(26984);
      return null;
      localObject1 = new i();
      ((i)localObject1).content = ((i)paramc).content;
      continue;
      localObject1 = new com.tencent.mm.plugin.wenote.model.a.g();
      Object localObject2 = (com.tencent.mm.plugin.wenote.model.a.g)localObject1;
      Object localObject3 = (com.tencent.mm.plugin.wenote.model.a.g)paramc;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).lat = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).lat;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).lng = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).lng;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).scale = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).scale;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).fBq = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).fBq;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).eSM = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).eSM;
      continue;
      localObject1 = new com.tencent.mm.plugin.wenote.model.a.f();
      ((com.tencent.mm.plugin.wenote.model.a.f)localObject1).vxt = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).vxt;
      continue;
      localObject1 = new k();
      localObject2 = (k)localObject1;
      localObject3 = (k)paramc;
      ((k)localObject2).thumbPath = ((k)localObject3).thumbPath;
      ((k)localObject2).duration = ((k)localObject3).duration;
      ((k)localObject2).vxi = ((k)localObject3).vxi;
      continue;
      localObject1 = new l();
      localObject2 = (l)localObject1;
      localObject3 = (l)paramc;
      ((l)localObject2).vxG = ((l)localObject3).vxG;
      ((l)localObject2).length = ((l)localObject3).length;
      ((l)localObject2).vxF = ((l)localObject3).vxF;
      ((l)localObject2).hPe = ((l)localObject3).hPe;
      ((l)localObject2).cvf = ((l)localObject3).cvf;
      ((l)localObject2).cve = ((l)localObject3).cve;
      ((l)localObject2).vxi = ((l)localObject3).vxi;
      continue;
      localObject1 = new com.tencent.mm.plugin.wenote.model.a.d();
      localObject2 = (com.tencent.mm.plugin.wenote.model.a.d)localObject1;
      localObject3 = (com.tencent.mm.plugin.wenote.model.a.d)paramc;
      ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).title = ((com.tencent.mm.plugin.wenote.model.a.d)localObject3).title;
      ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).content = ((com.tencent.mm.plugin.wenote.model.a.d)localObject3).content;
      ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).hPe = ((com.tencent.mm.plugin.wenote.model.a.d)localObject3).hPe;
      ((com.tencent.mm.plugin.wenote.model.a.d)localObject2).vxi = ((com.tencent.mm.plugin.wenote.model.a.d)localObject3).vxi;
      continue;
      localObject1 = new h();
    }
    ((o)localObject1).type = ((o)paramc).type;
    ((o)localObject1).vxs = ((o)paramc).vxs;
    ((o)localObject1).cBD = ((o)paramc).cBD;
    AppMethodBeat.o(26984);
    return localObject1;
  }
  
  public static String d(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    AppMethodBeat.i(26985);
    if (paramc == null)
    {
      AppMethodBeat.o(26985);
      return "";
    }
    if (paramc.getType() == 2)
    {
      paramc = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).vxt;
      AppMethodBeat.o(26985);
      return paramc;
    }
    paramc = ((o)paramc).cBD;
    AppMethodBeat.o(26985);
    return paramc;
  }
  
  public static String e(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    AppMethodBeat.i(26986);
    if (paramc == null)
    {
      AppMethodBeat.o(26986);
      return "";
    }
    if (paramc.getType() == 2)
    {
      paramc = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).cBD;
      AppMethodBeat.o(26986);
      return paramc;
    }
    if (paramc.getType() == 6)
    {
      paramc = ((k)paramc).thumbPath;
      AppMethodBeat.o(26986);
      return paramc;
    }
    AppMethodBeat.o(26986);
    return "";
  }
  
  public static String hI(String paramString1, String paramString2)
  {
    int j = 1280;
    AppMethodBeat.i(26981);
    if (bo.isNullOrNil(paramString2))
    {
      paramString2 = com.tencent.mm.a.g.w(new StringBuilder().append(paramString1).append(System.currentTimeMillis()).toString().getBytes()) + "_HD";
      paramString2 = an.bxd() + "/" + paramString2;
    }
    for (;;)
    {
      BitmapFactory.Options localOptions;
      int k;
      int i;
      if (!e.cN(paramString2))
      {
        localOptions = com.tencent.mm.sdk.platformtools.d.aoT(paramString1);
        if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
        {
          ab.e("MicroMsg.WNNoteUtil", "GetImageOptions Error");
          AppMethodBeat.o(26981);
          return null;
        }
        k = localOptions.outHeight;
        int m = localOptions.outWidth;
        i = m;
        if (m > 1280) {
          i = 1280;
        }
        if (k <= 1280) {
          break label242;
        }
      }
      for (;;)
      {
        if (localOptions.outHeight < localOptions.outWidth)
        {
          k = i;
          i = j;
          j = k;
        }
        for (;;)
        {
          if (ad.api(paramString1) > 0)
          {
            j = localOptions.outHeight;
            i = localOptions.outWidth;
          }
          com.tencent.mm.sdk.platformtools.d.c(paramString1, j, i, Bitmap.CompressFormat.JPEG, 95, paramString2);
          AppMethodBeat.o(26981);
          return paramString2;
        }
        label242:
        j = k;
      }
    }
  }
  
  public static String hJ(String paramString1, String paramString2)
  {
    int m = 800;
    AppMethodBeat.i(26982);
    if (bo.isNullOrNil(paramString2))
    {
      paramString2 = com.tencent.mm.a.g.w(new StringBuilder().append(paramString1).append(System.currentTimeMillis()).toString().getBytes()) + "_TH";
      paramString2 = an.bxd() + "/" + paramString2;
    }
    for (;;)
    {
      BitmapFactory.Options localOptions;
      int j;
      int k;
      int i;
      if (!e.cN(paramString2))
      {
        localOptions = com.tencent.mm.sdk.platformtools.d.aoT(paramString1);
        if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
        {
          ab.e("MicroMsg.WNNoteUtil", "GetImageOptions Error,use orignal file");
          AppMethodBeat.o(26982);
          return null;
        }
        j = localOptions.outHeight;
        k = localOptions.outWidth;
        while (k * j > 2764800)
        {
          k >>= 1;
          j >>= 1;
        }
        i = k;
        if (k > 800) {
          i = 800;
        }
        if (j <= 800) {
          break label249;
        }
        j = m;
      }
      label249:
      for (;;)
      {
        if (localOptions.outHeight < localOptions.outWidth)
        {
          k = j;
          j = i;
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.d.c(paramString1, j, k, Bitmap.CompressFormat.JPEG, 95, paramString2);
          AppMethodBeat.o(26982);
          return paramString2;
          k = i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.c
 * JD-Core Version:    0.7.0.1
 */