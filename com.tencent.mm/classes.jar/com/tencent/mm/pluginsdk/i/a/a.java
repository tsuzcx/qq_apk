package com.tencent.mm.pluginsdk.i.a;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a
{
  public static final String[] BTV = { "LDPI", "HDPI", "MDPI" };
  public String BTO;
  public boolean BTP;
  public boolean BTQ;
  public int BTR;
  public Rect BTS;
  public Rect BTT;
  public Map<String, String> BTU;
  public String desc;
  public String gPJ;
  public String gPK;
  public String id;
  public String platform;
  public String title;
  public int uYc;
  public String url;
  
  private a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.id = paramString1;
    this.platform = paramString2;
    this.BTO = paramString3;
    this.BTP = paramBoolean1;
    this.BTQ = paramBoolean2;
  }
  
  public static String aBu(String paramString)
  {
    AppMethodBeat.i(31155);
    Object localObject = aBv(paramString);
    if (localObject == a.BTW)
    {
      AppMethodBeat.o(31155);
      return paramString;
    }
    if (localObject == a.BTX)
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
      az.arV();
      paramString = c.apW() + paramString;
      AppMethodBeat.o(31155);
      return paramString;
    }
    AppMethodBeat.o(31155);
    return null;
  }
  
  public static a aBv(String paramString)
  {
    AppMethodBeat.i(31156);
    if (paramString.indexOf("tips/") == 0)
    {
      paramString = a.BTW;
      AppMethodBeat.o(31156);
      return paramString;
    }
    if (paramString.indexOf("weixin://") == 0)
    {
      paramString = a.BTX;
      AppMethodBeat.o(31156);
      return paramString;
    }
    paramString = a.BTY;
    AppMethodBeat.o(31156);
    return paramString;
  }
  
  public static ArrayList<a> bM(Context paramContext, String paramString)
  {
    AppMethodBeat.i(31157);
    if ((paramString == null) || (paramString.length() < 0))
    {
      AppMethodBeat.o(31157);
      return null;
    }
    Object localObject2 = BackwardSupportUtil.b.id(paramContext);
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
      paramContext = BackwardSupportUtil.b.ic(paramContext);
      ad.d("MicroMsg.PushMessage", "getDisplaySizeType :".concat(String.valueOf(paramContext)));
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
    Object localObject1 = bw.K(paramString, "tips");
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
        ad.d("MicroMsg.PushMessage", "parseMessages id:".concat(String.valueOf(paramString)));
        localObject4 = (String)((Map)localObject1).get((String)localObject3 + ".$platform");
        if (!((String)localObject4).equals("android")) {
          break label1316;
        }
        localObject4 = new a(paramString, (String)localObject4, (String)((Map)localObject1).get((String)localObject3 + ".$device"), bt.k(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$enableclose"))), bt.k(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$transparentclose"))));
        j = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$x"), 0);
        int k = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$y"), 0);
        int m = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$width"), 0);
        int n = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$font"), 0);
        int i1 = bt.fH((String)((Map)localObject1).get((String)localObject3 + ".title.$color"), 0);
        ((a)localObject4).title = ((String)((Map)localObject1).get((String)localObject3 + ".title"));
        ((a)localObject4).BTR = i1;
        ((a)localObject4).BTS = new Rect(j, k, m + j, n + k);
        j = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$x"), 0);
        k = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$y"), 0);
        m = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$width"), 0);
        n = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$font"), 0);
        i1 = bt.fH((String)((Map)localObject1).get((String)localObject3 + ".description.$color"), 0);
        ((a)localObject4).desc = ((String)((Map)localObject1).get((String)localObject3 + ".description"));
        ((a)localObject4).uYc = i1;
        ((a)localObject4).BTT = new Rect(j, k, m + j, n + k);
        ((a)localObject4).url = ((String)((Map)localObject1).get((String)localObject3 + ".url"));
        ((a)localObject4).gPJ = ((String)((Map)localObject1).get((String)localObject3 + ".time.start"));
        ((a)localObject4).gPK = ((String)((Map)localObject1).get((String)localObject3 + ".time.end"));
        ad.d("MicroMsg.PushMessage", "parseMessages id:" + ((a)localObject4).id + " start:" + ((a)localObject4).gPJ + " end:" + ((a)localObject4).gPK);
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
        ad.d("MicroMsg.PushMessage", " img res:".concat(String.valueOf(paramString)));
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
        ((a)localObject4).BTU = localHashMap;
      }
      ad.d("MicroMsg.PushMessage", "msgid :" + ((a)localObject4).id);
      ((ArrayList)localObject2).add(localObject4);
      label1316:
      i += 1;
    }
    ad.d("MicroMsg.PushMessage", "msgs size: " + ((ArrayList)localObject2).size());
    if (((ArrayList)localObject2).size() > 0)
    {
      AppMethodBeat.o(31157);
      return localObject2;
    }
    AppMethodBeat.o(31157);
    return null;
  }
  
  private boolean ewP()
  {
    AppMethodBeat.i(31153);
    long l3 = bt.eGO();
    long l1 = 9223372036854775807L;
    long l2 = 0L;
    try
    {
      if (this.gPK != null) {
        l1 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.gPK).getTime();
      }
      if (this.gPJ != null) {
        l2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.gPJ).getTime();
      }
      ad.d("MicroMsg.PushMessage", "CHECKTIME : [" + l2 + "," + l1 + "]");
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
  
  public static void ewQ()
  {
    AppMethodBeat.i(31158);
    az.arV();
    c.afk().set(8193, "");
    az.arV();
    c.afk().set(8449, Long.valueOf(0L));
    AppMethodBeat.o(31158);
  }
  
  public static a hh(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(31159);
    az.arV();
    long l1 = bt.i(c.afk().get(8449, null), 0);
    long l2 = bt.aGK();
    if ((l1 > 0L) && (l2 - l1 >= 86400L)) {
      ewQ();
    }
    for (;;)
    {
      AppMethodBeat.o(31159);
      return null;
      az.arV();
      localObject = (String)c.afk().get(8193, null);
      if (!bt.isNullOrNil((String)localObject)) {
        if (((String)localObject).contains("id=\"setavatar\""))
        {
          ewQ();
        }
        else
        {
          if (bt.isNullOrNil((String)localObject)) {
            break label190;
          }
          paramContext = bM(paramContext, (String)localObject);
          if ((paramContext != null) && (paramContext.size() == 1)) {
            break;
          }
          paramContext = null;
          if (paramContext != null) {
            break label200;
          }
          ewQ();
        }
      }
    }
    Object localObject = (a)paramContext.get(0);
    if ((((a)localObject).BTU != null) && (((a)localObject).BTU.size() > 0)) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext = (Context)localObject;
        if (((a)localObject).ewP()) {
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
    StringBuilder localStringBuilder = new StringBuilder("ad.id=").append(this.id).append(", platform=").append(this.platform).append(", device=").append(this.BTO);
    if (this.BTP)
    {
      str = ", closable";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.BTQ) {
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
      BTW = new a("ASSET", 0);
      BTX = new a("DOWNLOAD", 1);
      BTY = new a("ERROR", 2);
      BTZ = new a[] { BTW, BTX, BTY };
      AppMethodBeat.o(31152);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.a.a
 * JD-Core Version:    0.7.0.1
 */