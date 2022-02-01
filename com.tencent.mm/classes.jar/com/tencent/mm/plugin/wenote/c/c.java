package com.tencent.mm.plugin.wenote.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.fav.a.aq;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.wenote.model.a.d;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
{
  public static HashMap<String, String> XCi;
  public static HashMap<String, r> XCj;
  public static c XCk;
  private static com.tencent.mm.b.f<String, Integer> xvR;
  
  static
  {
    AppMethodBeat.i(30687);
    XCi = new HashMap();
    XCj = new HashMap();
    XCk = null;
    xvR = new com.tencent.mm.memory.a.c(30);
    AppMethodBeat.o(30687);
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
    AppMethodBeat.i(30685);
    if (paramc == null)
    {
      AppMethodBeat.o(30685);
      return "";
    }
    int i = paramc.getType();
    if (i == 1)
    {
      paramContext = ((i)paramc).content;
      AppMethodBeat.o(30685);
      return paramContext;
    }
    if (i == 3)
    {
      paramContext = paramContext.getString(R.l.gZh);
      AppMethodBeat.o(30685);
      return paramContext;
    }
    if (i == 2)
    {
      paramContext = paramContext.getString(R.l.gZg);
      AppMethodBeat.o(30685);
      return paramContext;
    }
    if (i == 6)
    {
      paramContext = paramContext.getString(R.l.gZi);
      AppMethodBeat.o(30685);
      return paramContext;
    }
    if (i == 4)
    {
      paramContext = paramContext.getString(R.l.gZj);
      AppMethodBeat.o(30685);
      return paramContext;
    }
    if (i == 5)
    {
      paramContext = paramContext.getString(R.l.gZf);
      AppMethodBeat.o(30685);
      return paramContext;
    }
    AppMethodBeat.o(30685);
    return "";
  }
  
  private static HashMap<String, String> a(String paramString1, String paramString2, boolean paramBoolean, Context paramContext)
  {
    AppMethodBeat.i(275144);
    new ArrayList();
    paramString2 = Pattern.compile(paramString2).matcher(paramString1);
    HashMap localHashMap = new HashMap();
    while (paramString2.find())
    {
      String str = paramString2.group(1);
      if (!Util.isNullOrNil(str))
      {
        Matcher localMatcher = Pattern.compile("<wx-li>(.*?)</wx-li>").matcher(str);
        paramString1 = "";
        int i = 1;
        if (localMatcher.find())
        {
          if (paramBoolean) {}
          for (paramString1 = paramString1 + paramContext.getString(R.l.gZl) + i + localMatcher.group(1);; paramString1 = paramString1 + paramContext.getString(R.l.gSE) + localMatcher.group(1))
          {
            i += 1;
            break;
          }
        }
        localHashMap.put(str, paramString1);
      }
    }
    AppMethodBeat.o(275144);
    return localHashMap;
  }
  
  public static Bitmap anq(String paramString)
  {
    AppMethodBeat.i(30677);
    paramString = e.bs(paramString, false);
    if (paramString != null)
    {
      AppMethodBeat.o(30677);
      return paramString;
    }
    if (Util.isNullOrNil(null))
    {
      AppMethodBeat.o(30677);
      return null;
    }
    paramString = e.bs(null, false);
    AppMethodBeat.o(30677);
    return paramString;
  }
  
  public static int anr(String paramString)
  {
    AppMethodBeat.i(30681);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30681);
      return 0;
    }
    int i = ant(b.anw(paramString));
    AppMethodBeat.o(30681);
    return i;
  }
  
  public static int ans(String paramString)
  {
    AppMethodBeat.i(30683);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30683);
      return 0;
    }
    if (xvR.check(paramString))
    {
      i = ((Integer)xvR.get(paramString)).intValue();
      AppMethodBeat.o(30683);
      return i;
    }
    int i = ant(paramString);
    xvR.put(paramString, Integer.valueOf(i));
    AppMethodBeat.o(30683);
    return i;
  }
  
  private static int ant(String paramString)
  {
    AppMethodBeat.i(30684);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30684);
      return 0;
    }
    int j = 0;
    int k;
    for (int i = 0; j < paramString.length(); i = k + i)
    {
      k = A(paramString.charAt(j));
      j += 1;
    }
    AppMethodBeat.o(30684);
    return i;
  }
  
  public static String anu(String paramString)
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
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30682);
      return 0;
    }
    paramString = com.tencent.mm.plugin.wenote.model.nativenote.a.a.anA(paramString);
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
    paramInt1 = ant(paramString.toString());
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
      localObject1 = new i();
      ((i)localObject1).content = ((i)paramc).content;
      continue;
      localObject1 = new com.tencent.mm.plugin.wenote.model.a.g();
      Object localObject2 = (com.tencent.mm.plugin.wenote.model.a.g)localObject1;
      Object localObject3 = (com.tencent.mm.plugin.wenote.model.a.g)paramc;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).lat = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).lat;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).lng = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).lng;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).XAR = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).XAR;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).oDI = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).oDI;
      ((com.tencent.mm.plugin.wenote.model.a.g)localObject2).poiName = ((com.tencent.mm.plugin.wenote.model.a.g)localObject3).poiName;
      continue;
      localObject1 = new com.tencent.mm.plugin.wenote.model.a.f();
      ((com.tencent.mm.plugin.wenote.model.a.f)localObject1).xym = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).xym;
      continue;
      localObject1 = new k();
      localObject2 = (k)localObject1;
      localObject3 = (k)paramc;
      ((k)localObject2).thumbPath = ((k)localObject3).thumbPath;
      ((k)localObject2).duration = ((k)localObject3).duration;
      ((k)localObject2).xyq = ((k)localObject3).xyq;
      continue;
      localObject1 = new l();
      localObject2 = (l)localObject1;
      localObject3 = (l)paramc;
      ((l)localObject2).xyu = ((l)localObject3).xyu;
      ((l)localObject2).length = ((l)localObject3).length;
      ((l)localObject2).xyt = ((l)localObject3).xyt;
      ((l)localObject2).sdM = ((l)localObject3).sdM;
      ((l)localObject2).hIZ = ((l)localObject3).hIZ;
      ((l)localObject2).hIY = ((l)localObject3).hIY;
      ((l)localObject2).xyq = ((l)localObject3).xyq;
      continue;
      localObject1 = new d();
      localObject2 = (d)localObject1;
      localObject3 = (d)paramc;
      ((d)localObject2).title = ((d)localObject3).title;
      ((d)localObject2).content = ((d)localObject3).content;
      ((d)localObject2).sdM = ((d)localObject3).sdM;
      ((d)localObject2).xyq = ((d)localObject3).xyq;
      continue;
      localObject1 = new h();
    }
    ((o)localObject1).type = ((o)paramc).type;
    ((o)localObject1).xyp = ((o)paramc).xyp;
    ((o)localObject1).hTM = ((o)paramc).hTM;
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
      paramc = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).xym;
      AppMethodBeat.o(30679);
      return paramc;
    }
    paramc = ((o)paramc).hTM;
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
      paramc = ((com.tencent.mm.plugin.wenote.model.a.f)paramc).hTM;
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
  
  public static String gA(String paramString1, String paramString2)
  {
    int j = 1280;
    AppMethodBeat.i(30675);
    if (Util.isNullOrNil(paramString2))
    {
      paramString2 = com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(paramString1).append(System.currentTimeMillis()).toString().getBytes()) + "_HD";
      paramString2 = aq.dRc() + "/" + paramString2;
    }
    for (;;)
    {
      BitmapFactory.Options localOptions;
      int k;
      int i;
      if (!y.ZC(paramString2))
      {
        localOptions = BitmapUtil.getImageOptions(paramString1);
        if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
        {
          Log.e("MicroMsg.WNNoteUtil", "GetImageOptions Error");
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
          break label243;
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
          if (LongBitmapHandler.isLongPicture(paramString1) > 0)
          {
            j = localOptions.outHeight;
            i = localOptions.outWidth;
          }
          BitmapUtil.createThumbNail(paramString1, j, i, Bitmap.CompressFormat.JPEG, 95, paramString2, true);
          AppMethodBeat.o(30675);
          return paramString2;
        }
        label243:
        j = k;
      }
    }
  }
  
  public static String gB(String paramString1, String paramString2)
  {
    int m = 800;
    AppMethodBeat.i(30676);
    if (Util.isNullOrNil(paramString2))
    {
      paramString2 = com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(paramString1).append(System.currentTimeMillis()).toString().getBytes()) + "_TH";
      paramString2 = aq.dRc() + "/" + paramString2;
    }
    for (;;)
    {
      BitmapFactory.Options localOptions;
      int j;
      int k;
      int i;
      if (!y.ZC(paramString2))
      {
        localOptions = BitmapUtil.getImageOptions(paramString1);
        if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
        {
          Log.e("MicroMsg.WNNoteUtil", "GetImageOptions Error,use orignal file");
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
          break label250;
        }
        j = m;
      }
      label250:
      for (;;)
      {
        if (localOptions.outHeight < localOptions.outWidth)
        {
          k = j;
          j = i;
        }
        for (;;)
        {
          BitmapUtil.createThumbNail(paramString1, j, k, Bitmap.CompressFormat.JPEG, 95, paramString2, true);
          AppMethodBeat.o(30676);
          return paramString2;
          k = i;
        }
      }
    }
  }
  
  public static String l(String paramString, Context paramContext)
  {
    AppMethodBeat.i(275139);
    Log.i("MicroMsg.WNNoteUtil", "start, html = " + paramString + ", isAccessibilityEnable = " + a.a.jlv().jls());
    if ((Util.isNullOrNil(paramString)) || (!a.a.jlv().jls()))
    {
      AppMethodBeat.o(275139);
      return paramString;
    }
    str1 = paramString;
    try
    {
      paramString = paramString.replaceAll("<wn-todo checked=\"0\" >", paramContext.getString(R.l.gYB));
      str1 = paramString;
      paramString = paramString.replaceAll("<wn-todo checked=\"1\" >", paramContext.getString(R.l.gYA));
      str1 = paramString;
      paramString = paramString.replaceAll("</wn-todo>", "");
      str1 = paramString;
      Object localObject1 = a(paramString, "<wx-ul>(.*?)</wx-ul>", false, paramContext);
      str1 = paramString;
      Object localObject2 = ((HashMap)localObject1).keySet().iterator();
      for (;;)
      {
        str1 = paramString;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        str1 = paramString;
        String str2 = (String)((Iterator)localObject2).next();
        str1 = paramString;
        paramString = paramString.replaceAll("<wx-ul>" + str2 + "</wx-ul>", (String)((HashMap)localObject1).get(str2));
      }
      str1 = paramString;
      paramContext = a(paramString, "<wx-ol>(.*?)</wx-ol>", true, paramContext);
      str1 = paramString;
      localObject1 = paramContext.keySet().iterator();
      for (;;)
      {
        str1 = paramString;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        str1 = paramString;
        localObject2 = (String)((Iterator)localObject1).next();
        str1 = paramString;
        paramString = paramString.replaceAll("<wx-ol>" + (String)localObject2 + "</wx-ol>", (String)paramContext.get(localObject2));
      }
      str1 = paramString;
      paramString = paramString.replaceAll("</wx-ul>", "");
      str1 = paramString;
      paramString = paramString.replaceAll("</wx-li>", "");
      str1 = paramString;
      paramString = paramString.replaceAll("</wn-todo>", "");
      str1 = paramString;
      paramString = paramString.replaceAll("</wn-todo>", "");
      str1 = paramString;
      paramString = paramString.replaceAll("</wx-ol>", "");
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.WNNoteUtil", "e = ".concat(String.valueOf(paramString)));
        paramString = str1;
      }
    }
    Log.i("MicroMsg.WNNoteUtil", "end htmlStr = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(275139);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.c.c
 * JD-Core Version:    0.7.0.1
 */