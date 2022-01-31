package com.tencent.mm.plugin.wenote.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.text.Spanned;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.model.a.d;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
{
  public static HashMap<String, String> rLe = new HashMap();
  public static HashMap<String, r> rLf = new HashMap();
  public static c rLg = null;
  private static com.tencent.mm.a.f<String, Integer> rLh = new com.tencent.mm.a.f(30);
  
  public static Bitmap UD(String paramString)
  {
    paramString = com.tencent.mm.plugin.fav.ui.c.aB(paramString, false);
    if (paramString != null) {
      return paramString;
    }
    if (bk.bl(null)) {
      return null;
    }
    return com.tencent.mm.plugin.fav.ui.c.aB(null, false);
  }
  
  public static int UE(String paramString)
  {
    if (bk.bl(paramString)) {
      return 0;
    }
    return UG(b.UB(paramString));
  }
  
  public static int UF(String paramString)
  {
    if (bk.bl(paramString)) {
      return 0;
    }
    if (rLh.aC(paramString)) {
      return ((Integer)rLh.get(paramString)).intValue();
    }
    int i = UG(paramString);
    rLh.put(paramString, Integer.valueOf(i));
    return i;
  }
  
  private static int UG(String paramString)
  {
    if (bk.bl(paramString)) {
      return 0;
    }
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      if (paramString.charAt(j) <= '') {}
      for (int k = 1;; k = 2)
      {
        j += 1;
        i = k + i;
        break;
      }
    }
    return i;
  }
  
  public static String UH(String paramString)
  {
    paramString = Pattern.compile("wx-b>", 2).matcher(paramString).replaceAll("wa-b>");
    paramString = Pattern.compile("</wx-li>", 2).matcher(paramString).replaceAll("<br/>");
    paramString = Pattern.compile("</wn-todo>", 2).matcher(paramString).replaceAll("<br/>");
    paramString = Pattern.compile("<[/]?w(x|n)-[^>]*>", 2).matcher(paramString).replaceAll("");
    return Pattern.compile("wa-b>", 2).matcher(paramString).replaceAll("wx-b>");
  }
  
  public static String a(Context paramContext, com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    if (paramc == null) {
      return "";
    }
    int i = paramc.getType();
    if (i == 1) {
      return ((i)paramc).content;
    }
    if (i == 3) {
      return paramContext.getString(R.l.wenote_placeholder_location);
    }
    if (i == 2) {
      return paramContext.getString(R.l.wenote_placeholder_image);
    }
    if (i == 6) {
      return paramContext.getString(R.l.wenote_placeholder_video);
    }
    if (i == 4) {
      return paramContext.getString(R.l.wenote_placeholder_voice);
    }
    if (i == 5) {
      return paramContext.getString(R.l.wenote_placeholder_file);
    }
    return "";
  }
  
  public static com.tencent.mm.plugin.wenote.model.a.c c(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    if (paramc == null) {
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
      return null;
      localObject1 = new i();
      ((i)localObject1).content = ((i)paramc).content;
      continue;
      localObject1 = new com.tencent.mm.plugin.wenote.model.a.g();
      Object localObject2 = (com.tencent.mm.plugin.wenote.model.a.g)localObject1;
      Object localObject3 = (com.tencent.mm.plugin.wenote.model.a.g)paramc;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).lat = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).lat;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).lng = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).lng;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).rGV = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).rGV;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).ekZ = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).ekZ;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).lFn = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).lFn;
      continue;
      localObject1 = new com.tencent.mm.plugin.wenote.model.a.f();
      ((com.tencent.mm.plugin.wenote.model.a.f)localObject1).rGK = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).rGK;
      continue;
      localObject1 = new k();
      localObject2 = (k)localObject1;
      localObject3 = (k)paramc;
      ((k)localObject2).thumbPath = ((k)localObject3).thumbPath;
      ((k)localObject2).duration = ((k)localObject3).duration;
      ((k)localObject2).rGz = ((k)localObject3).rGz;
      continue;
      localObject1 = new l();
      localObject2 = (l)localObject1;
      localObject3 = (l)paramc;
      ((l)localObject2).rGY = ((l)localObject3).rGY;
      ((l)localObject2).length = ((l)localObject3).length;
      ((l)localObject2).rGX = ((l)localObject3).rGX;
      ((l)localObject2).gum = ((l)localObject3).gum;
      ((l)localObject2).bNN = ((l)localObject3).bNN;
      ((l)localObject2).bNM = ((l)localObject3).bNM;
      ((l)localObject2).rGz = ((l)localObject3).rGz;
      continue;
      localObject1 = new d();
      localObject2 = (d)localObject1;
      localObject3 = (d)paramc;
      ((d)localObject2).title = ((d)localObject3).title;
      ((d)localObject2).content = ((d)localObject3).content;
      ((d)localObject2).gum = ((d)localObject3).gum;
      ((d)localObject2).rGz = ((d)localObject3).rGz;
      continue;
      localObject1 = new h();
    }
    ((o)localObject1).type = ((o)paramc).type;
    ((o)localObject1).rGJ = ((o)paramc).rGJ;
    ((o)localObject1).bTY = ((o)paramc).bTY;
    return localObject1;
  }
  
  public static int d(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (bk.bl(paramString)) {
      return 0;
    }
    paramString = a.Uw(paramString);
    if (paramString == null) {
      return 0;
    }
    if (paramBoolean) {
      paramInt2 = paramString.length();
    }
    if ((paramInt1 < 0) || (paramInt1 > paramString.length()) || (paramInt2 < 0) || (paramInt2 > paramString.length()) || (paramInt1 > paramInt2)) {
      return 0;
    }
    paramString = (Spanned)paramString.subSequence(paramInt1, paramInt2);
    if (paramString == null) {
      return 0;
    }
    return UG(paramString.toString());
  }
  
  public static String d(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    if (paramc == null) {
      return "";
    }
    if (paramc.getType() == 2) {
      return ((com.tencent.mm.plugin.wenote.model.a.f)paramc).rGK;
    }
    return ((o)paramc).bTY;
  }
  
  public static String e(com.tencent.mm.plugin.wenote.model.a.c paramc)
  {
    if (paramc == null) {
      return "";
    }
    if (paramc.getType() == 2) {
      return ((com.tencent.mm.plugin.wenote.model.a.f)paramc).bTY;
    }
    if (paramc.getType() == 6) {
      return ((k)paramc).thumbPath;
    }
    return "";
  }
  
  public static String fH(String paramString1, String paramString2)
  {
    int j = 1280;
    if (bk.bl(paramString2))
    {
      paramString2 = com.tencent.mm.a.g.o(new StringBuilder().append(paramString1).append(System.currentTimeMillis()).toString().getBytes()) + "_HD";
      paramString2 = an.aQO() + "/" + paramString2;
    }
    for (;;)
    {
      Object localObject = paramString2;
      if (!e.bK(paramString2))
      {
        localObject = com.tencent.mm.sdk.platformtools.c.YU(paramString1);
        if ((localObject == null) || (((BitmapFactory.Options)localObject).outWidth <= 0) || (((BitmapFactory.Options)localObject).outHeight <= 0))
        {
          y.e("MicroMsg.WNNoteUtil", "GetImageOptions Error");
          localObject = null;
        }
      }
      else
      {
        return localObject;
      }
      int k = ((BitmapFactory.Options)localObject).outHeight;
      int m = ((BitmapFactory.Options)localObject).outWidth;
      int i = m;
      if (m > 1280) {
        i = 1280;
      }
      if (k > 1280) {}
      for (;;)
      {
        if (((BitmapFactory.Options)localObject).outHeight < ((BitmapFactory.Options)localObject).outWidth) {}
        for (;;)
        {
          if (aa.Zk(paramString1) > 0)
          {
            i = ((BitmapFactory.Options)localObject).outHeight;
            j = ((BitmapFactory.Options)localObject).outWidth;
          }
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.c.c(paramString1, i, j, Bitmap.CompressFormat.JPEG, 95, paramString2);
            return paramString2;
          }
          k = i;
          i = j;
          j = k;
        }
        j = k;
      }
    }
  }
  
  public static String fI(String paramString1, String paramString2)
  {
    int m = 800;
    if (bk.bl(paramString2))
    {
      paramString2 = com.tencent.mm.a.g.o(new StringBuilder().append(paramString1).append(System.currentTimeMillis()).toString().getBytes()) + "_TH";
      paramString2 = an.aQO() + "/" + paramString2;
    }
    for (;;)
    {
      Object localObject = paramString2;
      if (!e.bK(paramString2))
      {
        localObject = com.tencent.mm.sdk.platformtools.c.YU(paramString1);
        if ((localObject == null) || (((BitmapFactory.Options)localObject).outWidth <= 0) || (((BitmapFactory.Options)localObject).outHeight <= 0))
        {
          y.e("MicroMsg.WNNoteUtil", "GetImageOptions Error,use orignal file");
          localObject = null;
        }
      }
      else
      {
        return localObject;
      }
      int j = ((BitmapFactory.Options)localObject).outHeight;
      int k = ((BitmapFactory.Options)localObject).outWidth;
      while (k * j > 2764800)
      {
        k >>= 1;
        j >>= 1;
      }
      int i = k;
      if (k > 800) {
        i = 800;
      }
      if (j > 800) {
        j = m;
      }
      for (;;)
      {
        if (((BitmapFactory.Options)localObject).outHeight < ((BitmapFactory.Options)localObject).outWidth) {}
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.c.c(paramString1, i, j, Bitmap.CompressFormat.JPEG, 95, paramString2);
          return paramString2;
          k = i;
          i = j;
          j = k;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.b.c
 * JD-Core Version:    0.7.0.1
 */