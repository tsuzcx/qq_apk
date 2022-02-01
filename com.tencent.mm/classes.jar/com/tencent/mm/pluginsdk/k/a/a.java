package com.tencent.mm.pluginsdk.k.a;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a
{
  public static final String[] FjI = { "LDPI", "HDPI", "MDPI" };
  public String FjB;
  public boolean FjC;
  public boolean FjD;
  public int FjE;
  public Rect FjF;
  public Rect FjG;
  public Map<String, String> FjH;
  public String desc;
  public String hLu;
  public String hLv;
  public String id;
  public String platform;
  public String title;
  public String url;
  public int xEw;
  
  private a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.id = paramString1;
    this.platform = paramString2;
    this.FjB = paramString3;
    this.FjC = paramBoolean1;
    this.FjD = paramBoolean2;
  }
  
  public static String aNI(String paramString)
  {
    AppMethodBeat.i(31155);
    Object localObject = aNJ(paramString);
    if (localObject == a.FjJ)
    {
      AppMethodBeat.o(31155);
      return paramString;
    }
    if (localObject == a.FjK)
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
      bc.aCg();
      paramString = c.azQ() + paramString;
      AppMethodBeat.o(31155);
      return paramString;
    }
    AppMethodBeat.o(31155);
    return null;
  }
  
  public static a aNJ(String paramString)
  {
    AppMethodBeat.i(31156);
    if (paramString.indexOf("tips/") == 0)
    {
      paramString = a.FjJ;
      AppMethodBeat.o(31156);
      return paramString;
    }
    if (paramString.indexOf("weixin://") == 0)
    {
      paramString = a.FjK;
      AppMethodBeat.o(31156);
      return paramString;
    }
    paramString = a.FjL;
    AppMethodBeat.o(31156);
    return paramString;
  }
  
  public static ArrayList<a> bS(Context paramContext, String paramString)
  {
    AppMethodBeat.i(31157);
    if ((paramString == null) || (paramString.length() < 0))
    {
      AppMethodBeat.o(31157);
      return null;
    }
    Object localObject2 = BackwardSupportUtil.b.iD(paramContext);
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
      paramContext = BackwardSupportUtil.b.iC(paramContext);
      ae.d("MicroMsg.PushMessage", "getDisplaySizeType :".concat(String.valueOf(paramContext)));
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
    Object localObject1 = bx.M(paramString, "tips");
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
      label1123:
      Object localObject5;
      if (i > 0)
      {
        paramString = Integer.valueOf(i);
        localObject3 = paramString;
        if (((Map)localObject1).get(localObject3) == null) {
          break;
        }
        paramString = (String)((Map)localObject1).get((String)localObject3 + ".$id");
        ae.d("MicroMsg.PushMessage", "parseMessages id:".concat(String.valueOf(paramString)));
        localObject4 = (String)((Map)localObject1).get((String)localObject3 + ".$platform");
        if (!((String)localObject4).equals("android")) {
          break label1316;
        }
        localObject4 = new a(paramString, (String)localObject4, (String)((Map)localObject1).get((String)localObject3 + ".$device"), bu.n(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$enableclose"))), bu.n(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$transparentclose"))));
        j = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$x"), 0);
        int k = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$y"), 0);
        int m = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$width"), 0);
        int n = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$font"), 0);
        int i1 = bu.gs((String)((Map)localObject1).get((String)localObject3 + ".title.$color"), 0);
        ((a)localObject4).title = ((String)((Map)localObject1).get((String)localObject3 + ".title"));
        ((a)localObject4).FjE = i1;
        ((a)localObject4).FjF = new Rect(j, k, m + j, n + k);
        j = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$x"), 0);
        k = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$y"), 0);
        m = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$width"), 0);
        n = bu.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$font"), 0);
        i1 = bu.gs((String)((Map)localObject1).get((String)localObject3 + ".description.$color"), 0);
        ((a)localObject4).desc = ((String)((Map)localObject1).get((String)localObject3 + ".description"));
        ((a)localObject4).xEw = i1;
        ((a)localObject4).FjG = new Rect(j, k, m + j, n + k);
        ((a)localObject4).url = ((String)((Map)localObject1).get((String)localObject3 + ".url"));
        ((a)localObject4).hLu = ((String)((Map)localObject1).get((String)localObject3 + ".time.start"));
        ((a)localObject4).hLv = ((String)((Map)localObject1).get((String)localObject3 + ".time.end"));
        ae.d("MicroMsg.PushMessage", "parseMessages id:" + ((a)localObject4).id + " start:" + ((a)localObject4).hLu + " end:" + ((a)localObject4).hLv);
        localHashMap = new HashMap();
        j = 0;
        localObject5 = new StringBuilder().append((String)localObject3).append(".images.image");
        if (j <= 0) {
          break label1260;
        }
      }
      label1260:
      for (paramString = Integer.valueOf(j);; paramString = "")
      {
        localObject5 = paramString;
        paramString = (String)((Map)localObject1).get(localObject5);
        ae.d("MicroMsg.PushMessage", " img res:".concat(String.valueOf(paramString)));
        if (paramString == null) {
          break label1267;
        }
        localObject5 = (String)((Map)localObject1).get((String)localObject5 + ".$type");
        if (paramContext.contains(localObject5)) {
          localHashMap.put(localObject5, paramString);
        }
        j += 1;
        break label1123;
        paramString = "";
        break;
      }
      label1267:
      if (localHashMap.size() > 0) {
        ((a)localObject4).FjH = localHashMap;
      }
      ae.d("MicroMsg.PushMessage", "msgid :" + ((a)localObject4).id);
      ((ArrayList)localObject2).add(localObject4);
      label1316:
      i += 1;
    }
    ae.d("MicroMsg.PushMessage", "msgs size: " + ((ArrayList)localObject2).size());
    if (((ArrayList)localObject2).size() > 0)
    {
      AppMethodBeat.o(31157);
      return localObject2;
    }
    AppMethodBeat.o(31157);
    return null;
  }
  
  private boolean feU()
  {
    AppMethodBeat.i(31153);
    long l3 = bu.fpO();
    long l1 = 9223372036854775807L;
    long l2 = 0L;
    try
    {
      if (this.hLv != null) {
        l1 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.hLv).getTime();
      }
      if (this.hLu != null) {
        l2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.hLu).getTime();
      }
      ae.d("MicroMsg.PushMessage", "CHECKTIME : [" + l2 + "," + l1 + "]");
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
  
  public static void feV()
  {
    AppMethodBeat.i(31158);
    bc.aCg();
    c.ajA().set(8193, "");
    bc.aCg();
    c.ajA().set(8449, Long.valueOf(0L));
    AppMethodBeat.o(31158);
  }
  
  public static a hD(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(31159);
    bc.aCg();
    long l1 = bu.m(c.ajA().get(8449, null), 0);
    long l2 = bu.aRi();
    if ((l1 > 0L) && (l2 - l1 >= 86400L)) {
      feV();
    }
    for (;;)
    {
      AppMethodBeat.o(31159);
      return null;
      bc.aCg();
      localObject = (String)c.ajA().get(8193, null);
      if (!bu.isNullOrNil((String)localObject)) {
        if (((String)localObject).contains("id=\"setavatar\""))
        {
          feV();
        }
        else
        {
          if (bu.isNullOrNil((String)localObject)) {
            break label190;
          }
          paramContext = bS(paramContext, (String)localObject);
          if ((paramContext != null) && (paramContext.size() == 1)) {
            break;
          }
          paramContext = null;
          if (paramContext != null) {
            break label200;
          }
          feV();
        }
      }
    }
    Object localObject = (a)paramContext.get(0);
    if ((((a)localObject).FjH != null) && (((a)localObject).FjH.size() > 0)) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext = (Context)localObject;
        if (((a)localObject).feU()) {
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
    StringBuilder localStringBuilder = new StringBuilder("ad.id=").append(this.id).append(", platform=").append(this.platform).append(", device=").append(this.FjB);
    if (this.FjC)
    {
      str = ", closable";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.FjD) {
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
      FjJ = new a("ASSET", 0);
      FjK = new a("DOWNLOAD", 1);
      FjL = new a("ERROR", 2);
      FjM = new a[] { FjJ, FjK, FjL };
      AppMethodBeat.o(31152);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a
 * JD-Core Version:    0.7.0.1
 */