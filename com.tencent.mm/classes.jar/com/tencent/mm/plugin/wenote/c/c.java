package com.tencent.mm.plugin.wenote.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.d;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
{
  public static HashMap<String, String> EBc;
  public static HashMap<String, r> EBd;
  public static c EBe;
  private static com.tencent.mm.b.f<String, Integer> psk;
  
  static
  {
    AppMethodBeat.i(30687);
    EBc = new HashMap();
    EBd = new HashMap();
    EBe = null;
    psk = new com.tencent.mm.memory.a.c(30);
    AppMethodBeat.o(30687);
  }
  
  public static String a(Context paramContext, com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    AppMethodBeat.i(30685);
    if (paramc == null)
    {
      AppMethodBeat.o(30685);
      return "";
    }
    int i = paramc.getType();
    if (i == 1)
    {
      paramContext = ((com.tencent.mm.plugin.wenote.model.a.i)paramc).content;
      AppMethodBeat.o(30685);
      return paramContext;
    }
    if (i == 3)
    {
      paramContext = paramContext.getString(2131766217);
      AppMethodBeat.o(30685);
      return paramContext;
    }
    if (i == 2)
    {
      paramContext = paramContext.getString(2131766216);
      AppMethodBeat.o(30685);
      return paramContext;
    }
    if (i == 6)
    {
      paramContext = paramContext.getString(2131766218);
      AppMethodBeat.o(30685);
      return paramContext;
    }
    if (i == 4)
    {
      paramContext = paramContext.getString(2131766219);
      AppMethodBeat.o(30685);
      return paramContext;
    }
    if (i == 5)
    {
      paramContext = paramContext.getString(2131766215);
      AppMethodBeat.o(30685);
      return paramContext;
    }
    AppMethodBeat.o(30685);
    return "";
  }
  
  public static Bitmap aaL(String paramString)
  {
    AppMethodBeat.i(30677);
    paramString = e.aZ(paramString, false);
    if (paramString != null)
    {
      AppMethodBeat.o(30677);
      return paramString;
    }
    if (bt.isNullOrNil(null))
    {
      AppMethodBeat.o(30677);
      return null;
    }
    paramString = e.aZ(null, false);
    AppMethodBeat.o(30677);
    return paramString;
  }
  
  public static int aaM(String paramString)
  {
    AppMethodBeat.i(30681);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30681);
      return 0;
    }
    int i = aaO(b.aaR(paramString));
    AppMethodBeat.o(30681);
    return i;
  }
  
  public static int aaN(String paramString)
  {
    AppMethodBeat.i(30683);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30683);
      return 0;
    }
    if (psk.aM(paramString))
    {
      i = ((Integer)psk.get(paramString)).intValue();
      AppMethodBeat.o(30683);
      return i;
    }
    int i = aaO(paramString);
    psk.put(paramString, Integer.valueOf(i));
    AppMethodBeat.o(30683);
    return i;
  }
  
  private static int aaO(String paramString)
  {
    AppMethodBeat.i(30684);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30684);
      return 0;
    }
    int j = 0;
    int k;
    for (int i = 0; j < paramString.length(); i = k + i)
    {
      k = z(paramString.charAt(j));
      j += 1;
    }
    AppMethodBeat.o(30684);
    return i;
  }
  
  public static String aaP(String paramString)
  {
    AppMethodBeat.i(30686);
    paramString = Pattern.compile("wx-b>", 2).matcher(paramString).replaceAll("wa-b>");
    paramString = Pattern.compile("</wx-li>", 2).matcher(paramString).replaceAll("<br/>");
    paramString = Pattern.compile("</wn-todo>", 2).matcher(paramString).replaceAll("<br/>");
    paramString = Pattern.compile("<[/]?w(x|n)-[^>]*>", 2).matcher(paramString).replaceAll("");
    paramString = Pattern.compile("wa-b>", 2).matcher(paramString).replaceAll("wx-b>");
    AppMethodBeat.o(30686);
    return paramString;
  }
  
  public static int b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(30682);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30682);
      return 0;
    }
    paramString = a.aaV(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(30682);
      return 0;
    }
    if (paramBoolean) {
      paramInt2 = paramString.length();
    }
    if ((paramInt1 < 0) || (paramInt1 > paramString.length()) || (paramInt2 < 0) || (paramInt2 > paramString.length()) || (paramInt1 > paramInt2))
    {
      AppMethodBeat.o(30682);
      return 0;
    }
    paramString = (Spanned)paramString.subSequence(paramInt1, paramInt2);
    if (paramString == null)
    {
      AppMethodBeat.o(30682);
      return 0;
    }
    paramInt1 = aaO(paramString.toString());
    AppMethodBeat.o(30682);
    return paramInt1;
  }
  
  public static com.tencent.mm.plugin.wenote.model.a.c c(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    AppMethodBeat.i(30678);
    if (paramc == null)
    {
      AppMethodBeat.o(30678);
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
      AppMethodBeat.o(30678);
      return null;
      localObject1 = new com.tencent.mm.plugin.wenote.model.a.i();
      ((com.tencent.mm.plugin.wenote.model.a.i)localObject1).content = ((com.tencent.mm.plugin.wenote.model.a.i)paramc).content;
      continue;
      localObject1 = new com.tencent.mm.plugin.wenote.model.a.g();
      Object localObject2 = (com.tencent.mm.plugin.wenote.model.a.g)localObject1;
      Object localObject3 = (com.tencent.mm.plugin.wenote.model.a.g)paramc;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).lat = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).lat;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).lng = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).lng;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).EzS = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).EzS;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).hWY = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).hWY;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).jDf = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).jDf;
      continue;
      localObject1 = new com.tencent.mm.plugin.wenote.model.a.f();
      ((com.tencent.mm.plugin.wenote.model.a.f)localObject1).ptQ = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).ptQ;
      continue;
      localObject1 = new k();
      localObject2 = (k)localObject1;
      localObject3 = (k)paramc;
      ((k)localObject2).thumbPath = ((k)localObject3).thumbPath;
      ((k)localObject2).duration = ((k)localObject3).duration;
      ((k)localObject2).ptU = ((k)localObject3).ptU;
      continue;
      localObject1 = new l();
      localObject2 = (l)localObject1;
      localObject3 = (l)paramc;
      ((l)localObject2).ptX = ((l)localObject3).ptX;
      ((l)localObject2).length = ((l)localObject3).length;
      ((l)localObject2).ptW = ((l)localObject3).ptW;
      ((l)localObject2).kRE = ((l)localObject3).kRE;
      ((l)localObject2).dtd = ((l)localObject3).dtd;
      ((l)localObject2).dtc = ((l)localObject3).dtc;
      ((l)localObject2).ptU = ((l)localObject3).ptU;
      continue;
      localObject1 = new d();
      localObject2 = (d)localObject1;
      localObject3 = (d)paramc;
      ((d)localObject2).title = ((d)localObject3).title;
      ((d)localObject2).content = ((d)localObject3).content;
      ((d)localObject2).kRE = ((d)localObject3).kRE;
      ((d)localObject2).ptU = ((d)localObject3).ptU;
      continue;
      localObject1 = new h();
    }
    ((o)localObject1).type = ((o)paramc).type;
    ((o)localObject1).ptT = ((o)paramc).ptT;
    ((o)localObject1).dBx = ((o)paramc).dBx;
    AppMethodBeat.o(30678);
    return localObject1;
  }
  
  public static String d(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    AppMethodBeat.i(30679);
    if (paramc == null)
    {
      AppMethodBeat.o(30679);
      return "";
    }
    if (paramc.getType() == 2)
    {
      paramc = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).ptQ;
      AppMethodBeat.o(30679);
      return paramc;
    }
    paramc = ((o)paramc).dBx;
    AppMethodBeat.o(30679);
    return paramc;
  }
  
  public static String e(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    AppMethodBeat.i(30680);
    if (paramc == null)
    {
      AppMethodBeat.o(30680);
      return "";
    }
    if (paramc.getType() == 2)
    {
      paramc = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).dBx;
      AppMethodBeat.o(30680);
      return paramc;
    }
    if (paramc.getType() == 6)
    {
      paramc = ((k)paramc).thumbPath;
      AppMethodBeat.o(30680);
      return paramc;
    }
    AppMethodBeat.o(30680);
    return "";
  }
  
  public static String fo(String paramString1, String paramString2)
  {
    int j = 1280;
    AppMethodBeat.i(30675);
    if (bt.isNullOrNil(paramString2))
    {
      paramString2 = com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(paramString1).append(System.currentTimeMillis()).toString().getBytes()) + "_HD";
      paramString2 = ao.cvF() + "/" + paramString2;
    }
    for (;;)
    {
      BitmapFactory.Options localOptions;
      int k;
      int i;
      if (!com.tencent.mm.vfs.i.fv(paramString2))
      {
        localOptions = com.tencent.mm.sdk.platformtools.g.aQc(paramString1);
        if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
        {
          ad.e("MicroMsg.WNNoteUtil", "GetImageOptions Error");
          AppMethodBeat.o(30675);
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
          if (af.aQs(paramString1) > 0)
          {
            j = localOptions.outHeight;
            i = localOptions.outWidth;
          }
          com.tencent.mm.sdk.platformtools.g.c(paramString1, j, i, Bitmap.CompressFormat.JPEG, 95, paramString2);
          AppMethodBeat.o(30675);
          return paramString2;
        }
        label242:
        j = k;
      }
    }
  }
  
  public static String fp(String paramString1, String paramString2)
  {
    int m = 800;
    AppMethodBeat.i(30676);
    if (bt.isNullOrNil(paramString2))
    {
      paramString2 = com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(paramString1).append(System.currentTimeMillis()).toString().getBytes()) + "_TH";
      paramString2 = ao.cvF() + "/" + paramString2;
    }
    for (;;)
    {
      BitmapFactory.Options localOptions;
      int j;
      int k;
      int i;
      if (!com.tencent.mm.vfs.i.fv(paramString2))
      {
        localOptions = com.tencent.mm.sdk.platformtools.g.aQc(paramString1);
        if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
        {
          ad.e("MicroMsg.WNNoteUtil", "GetImageOptions Error,use orignal file");
          AppMethodBeat.o(30676);
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
          com.tencent.mm.sdk.platformtools.g.c(paramString1, j, k, Bitmap.CompressFormat.JPEG, 95, paramString2);
          AppMethodBeat.o(30676);
          return paramString2;
          k = i;
        }
      }
    }
  }
  
  private static int z(char paramChar)
  {
    if (paramChar <= '') {
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.c.c
 * JD-Core Version:    0.7.0.1
 */