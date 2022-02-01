package com.tencent.mm.pluginsdk.k.a;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a
{
  public static final String[] KaA = { "LDPI", "HDPI", "MDPI" };
  public boolean Kau;
  public boolean Kav;
  public int Kaw;
  public Rect Kax;
  public Rect Kay;
  public Map<String, String> Kaz;
  public String desc;
  public String device;
  public String endTime;
  public String iGx;
  public String id;
  public String platform;
  public String title;
  public String url;
  public int wnT;
  
  private a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.id = paramString1;
    this.platform = paramString2;
    this.device = paramString3;
    this.Kau = paramBoolean1;
    this.Kav = paramBoolean2;
  }
  
  public static String bek(String paramString)
  {
    AppMethodBeat.i(31155);
    Object localObject = bel(paramString);
    if (localObject == a.KaB)
    {
      AppMethodBeat.o(31155);
      return paramString;
    }
    if (localObject == a.KaC)
    {
      if (paramString == null) {
        paramString = null;
      }
      while (paramString == null)
      {
        AppMethodBeat.o(31155);
        return null;
        int i = paramString.lastIndexOf("/");
        if ((i < 0) || (i >= paramString.length() - 1)) {
          paramString = null;
        } else {
          paramString = paramString.substring(i + 1);
        }
      }
      localObject = new StringBuilder();
      bg.aVF();
      paramString = c.aSY() + paramString;
      AppMethodBeat.o(31155);
      return paramString;
    }
    AppMethodBeat.o(31155);
    return null;
  }
  
  public static a bel(String paramString)
  {
    AppMethodBeat.i(31156);
    if (paramString.indexOf("tips/") == 0)
    {
      paramString = a.KaB;
      AppMethodBeat.o(31156);
      return paramString;
    }
    if (paramString.indexOf("weixin://") == 0)
    {
      paramString = a.KaC;
      AppMethodBeat.o(31156);
      return paramString;
    }
    paramString = a.KaD;
    AppMethodBeat.o(31156);
    return paramString;
  }
  
  public static ArrayList<a> cm(Context paramContext, String paramString)
  {
    AppMethodBeat.i(31157);
    if ((paramString == null) || (paramString.length() < 0))
    {
      AppMethodBeat.o(31157);
      return null;
    }
    Object localObject2 = BackwardSupportUtil.BitmapFactory.getDisplaySizeType(paramContext);
    if (localObject2 == null)
    {
      paramContext = null;
      if ((paramContext == null) || (paramContext.size() <= 0))
      {
        AppMethodBeat.o(31157);
        return null;
      }
    }
    else
    {
      localObject1 = new HashSet();
      ((HashSet)localObject1).add(localObject2);
      paramContext = BackwardSupportUtil.BitmapFactory.getDisplayDensityType(paramContext);
      Log.d("MicroMsg.PushMessage", "getDisplaySizeType :".concat(String.valueOf(paramContext)));
      if (paramContext != null)
      {
        paramContext = paramContext.split("_");
        if ((paramContext != null) && (paramContext.length >= 2)) {
          break label172;
        }
      }
      label172:
      for (paramContext = null;; paramContext = paramContext[0])
      {
        ((HashSet)localObject1).add(paramContext + "_L");
        ((HashSet)localObject1).add(paramContext + "_P");
        paramContext = (Context)localObject1;
        break;
      }
    }
    Object localObject1 = XmlParser.parseXml(paramString, "tips", null);
    if (localObject1 == null)
    {
      AppMethodBeat.o(31157);
      return null;
    }
    localObject2 = new ArrayList();
    int i = 0;
    for (;;)
    {
      Object localObject3 = new StringBuilder(".tips.tip");
      Object localObject4;
      int j;
      HashMap localHashMap;
      label1124:
      Object localObject5;
      if (i > 0)
      {
        paramString = Integer.valueOf(i);
        localObject3 = paramString;
        if (((Map)localObject1).get(localObject3) == null) {
          break;
        }
        paramString = (String)((Map)localObject1).get((String)localObject3 + ".$id");
        Log.d("MicroMsg.PushMessage", "parseMessages id:".concat(String.valueOf(paramString)));
        localObject4 = (String)((Map)localObject1).get((String)localObject3 + ".$platform");
        if (!((String)localObject4).equals("android")) {
          break label1317;
        }
        localObject4 = new a(paramString, (String)localObject4, (String)((Map)localObject1).get((String)localObject3 + ".$device"), Util.nullAsTrue(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$enableclose"))), Util.nullAsTrue(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$transparentclose"))));
        j = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$x"), 0);
        int k = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$y"), 0);
        int m = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$width"), 0);
        int n = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$font"), 0);
        int i1 = Util.getHex((String)((Map)localObject1).get((String)localObject3 + ".title.$color"), 0);
        ((a)localObject4).title = ((String)((Map)localObject1).get((String)localObject3 + ".title"));
        ((a)localObject4).Kaw = i1;
        ((a)localObject4).Kax = new Rect(j, k, m + j, n + k);
        j = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$x"), 0);
        k = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$y"), 0);
        m = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$width"), 0);
        n = Util.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$font"), 0);
        i1 = Util.getHex((String)((Map)localObject1).get((String)localObject3 + ".description.$color"), 0);
        ((a)localObject4).desc = ((String)((Map)localObject1).get((String)localObject3 + ".description"));
        ((a)localObject4).wnT = i1;
        ((a)localObject4).Kay = new Rect(j, k, m + j, n + k);
        ((a)localObject4).url = ((String)((Map)localObject1).get((String)localObject3 + ".url"));
        ((a)localObject4).iGx = ((String)((Map)localObject1).get((String)localObject3 + ".time.start"));
        ((a)localObject4).endTime = ((String)((Map)localObject1).get((String)localObject3 + ".time.end"));
        Log.d("MicroMsg.PushMessage", "parseMessages id:" + ((a)localObject4).id + " start:" + ((a)localObject4).iGx + " end:" + ((a)localObject4).endTime);
        localHashMap = new HashMap();
        j = 0;
        localObject5 = new StringBuilder().append((String)localObject3).append(".images.image");
        if (j <= 0) {
          break label1261;
        }
      }
      label1261:
      for (paramString = Integer.valueOf(j);; paramString = "")
      {
        localObject5 = paramString;
        paramString = (String)((Map)localObject1).get(localObject5);
        Log.d("MicroMsg.PushMessage", " img res:".concat(String.valueOf(paramString)));
        if (paramString == null) {
          break label1268;
        }
        localObject5 = (String)((Map)localObject1).get((String)localObject5 + ".$type");
        if (paramContext.contains(localObject5)) {
          localHashMap.put(localObject5, paramString);
        }
        j += 1;
        break label1124;
        paramString = "";
        break;
      }
      label1268:
      if (localHashMap.size() > 0) {
        ((a)localObject4).Kaz = localHashMap;
      }
      Log.d("MicroMsg.PushMessage", "msgid :" + ((a)localObject4).id);
      ((ArrayList)localObject2).add(localObject4);
      label1317:
      i += 1;
    }
    Log.d("MicroMsg.PushMessage", "msgs size: " + ((ArrayList)localObject2).size());
    if (((ArrayList)localObject2).size() > 0)
    {
      AppMethodBeat.o(31157);
      return localObject2;
    }
    AppMethodBeat.o(31157);
    return null;
  }
  
  private boolean goe()
  {
    AppMethodBeat.i(31153);
    long l3 = Util.nowMilliSecond();
    long l1 = 9223372036854775807L;
    long l2 = 0L;
    try
    {
      if (this.endTime != null) {
        l1 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.endTime).getTime();
      }
      if (this.iGx != null) {
        l2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.iGx).getTime();
      }
      Log.d("MicroMsg.PushMessage", "CHECKTIME : [" + l2 + "," + l1 + "]");
      if (l1 <= l3) {
        break label151;
      }
      if (l2 > l3)
      {
        AppMethodBeat.o(31153);
        return false;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(31153);
      return true;
    }
    AppMethodBeat.o(31153);
    return true;
    label151:
    AppMethodBeat.o(31153);
    return false;
  }
  
  public static void gof()
  {
    AppMethodBeat.i(31158);
    bg.aVF();
    c.azQ().set(8193, "");
    bg.aVF();
    c.azQ().set(8449, Long.valueOf(0L));
    AppMethodBeat.o(31158);
  }
  
  public static a ix(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(31159);
    bg.aVF();
    long l1 = Util.nullAsInt(c.azQ().get(8449, null), 0);
    long l2 = Util.nowSecond();
    if ((l1 > 0L) && (l2 - l1 >= 86400L)) {
      gof();
    }
    for (;;)
    {
      AppMethodBeat.o(31159);
      return null;
      bg.aVF();
      localObject = (String)c.azQ().get(8193, null);
      if (!Util.isNullOrNil((String)localObject)) {
        if (((String)localObject).contains("id=\"setavatar\""))
        {
          gof();
        }
        else
        {
          if (Util.isNullOrNil((String)localObject)) {
            break label190;
          }
          paramContext = cm(paramContext, (String)localObject);
          if ((paramContext != null) && (paramContext.size() == 1)) {
            break;
          }
          paramContext = null;
          if (paramContext != null) {
            break label200;
          }
          gof();
        }
      }
    }
    Object localObject = (a)paramContext.get(0);
    if ((((a)localObject).Kaz != null) && (((a)localObject).Kaz.size() > 0)) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext = (Context)localObject;
        if (((a)localObject).goe()) {
          break;
        }
      }
      label190:
      paramContext = null;
      break;
      i = 0;
    }
    label200:
    AppMethodBeat.o(31159);
    return paramContext;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(31154);
    StringBuilder localStringBuilder = new StringBuilder("ad.id=").append(this.id).append(", platform=").append(this.platform).append(", device=").append(this.device);
    if (this.Kau)
    {
      str = ", closable";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.Kav) {
        break label102;
      }
    }
    label102:
    for (String str = ", trans-closable";; str = "")
    {
      str = str;
      AppMethodBeat.o(31154);
      return str;
      str = "";
      break;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(31152);
      KaB = new a("ASSET", 0);
      KaC = new a("DOWNLOAD", 1);
      KaD = new a("ERROR", 2);
      KaE = new a[] { KaB, KaC, KaD };
      AppMethodBeat.o(31152);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a
 * JD-Core Version:    0.7.0.1
 */