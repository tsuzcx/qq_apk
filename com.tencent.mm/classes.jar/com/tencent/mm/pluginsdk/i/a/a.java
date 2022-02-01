package com.tencent.mm.pluginsdk.i.a;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a
{
  public static final String[] Dml = { "LDPI", "HDPI", "MDPI" };
  public String Dme;
  public boolean Dmf;
  public boolean Dmg;
  public int Dmh;
  public Rect Dmi;
  public Rect Dmj;
  public Map<String, String> Dmk;
  public String desc;
  public String hqj;
  public String hqk;
  public String id;
  public String platform;
  public String title;
  public String url;
  public int wgR;
  
  private a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.id = paramString1;
    this.platform = paramString2;
    this.Dme = paramString3;
    this.Dmf = paramBoolean1;
    this.Dmg = paramBoolean2;
  }
  
  public static String aGM(String paramString)
  {
    AppMethodBeat.i(31155);
    Object localObject = aGN(paramString);
    if (localObject == a.Dmm)
    {
      AppMethodBeat.o(31155);
      return paramString;
    }
    if (localObject == a.Dmn)
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
      az.ayM();
      paramString = c.awL() + paramString;
      AppMethodBeat.o(31155);
      return paramString;
    }
    AppMethodBeat.o(31155);
    return null;
  }
  
  public static a aGN(String paramString)
  {
    AppMethodBeat.i(31156);
    if (paramString.indexOf("tips/") == 0)
    {
      paramString = a.Dmm;
      AppMethodBeat.o(31156);
      return paramString;
    }
    if (paramString.indexOf("weixin://") == 0)
    {
      paramString = a.Dmn;
      AppMethodBeat.o(31156);
      return paramString;
    }
    paramString = a.Dmo;
    AppMethodBeat.o(31156);
    return paramString;
  }
  
  public static ArrayList<a> bN(Context paramContext, String paramString)
  {
    AppMethodBeat.i(31157);
    if ((paramString == null) || (paramString.length() < 0))
    {
      AppMethodBeat.o(31157);
      return null;
    }
    Object localObject2 = BackwardSupportUtil.b.io(paramContext);
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
      paramContext = BackwardSupportUtil.b.in(paramContext);
      ac.d("MicroMsg.PushMessage", "getDisplaySizeType :".concat(String.valueOf(paramContext)));
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
    Object localObject1 = bv.L(paramString, "tips");
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
        ac.d("MicroMsg.PushMessage", "parseMessages id:".concat(String.valueOf(paramString)));
        localObject4 = (String)((Map)localObject1).get((String)localObject3 + ".$platform");
        if (!((String)localObject4).equals("android")) {
          break label1316;
        }
        localObject4 = new a(paramString, (String)localObject4, (String)((Map)localObject1).get((String)localObject3 + ".$device"), bs.k(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$enableclose"))), bs.k(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$transparentclose"))));
        j = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$x"), 0);
        int k = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$y"), 0);
        int m = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$width"), 0);
        int n = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$font"), 0);
        int i1 = bs.fM((String)((Map)localObject1).get((String)localObject3 + ".title.$color"), 0);
        ((a)localObject4).title = ((String)((Map)localObject1).get((String)localObject3 + ".title"));
        ((a)localObject4).Dmh = i1;
        ((a)localObject4).Dmi = new Rect(j, k, m + j, n + k);
        j = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$x"), 0);
        k = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$y"), 0);
        m = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$width"), 0);
        n = bs.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$font"), 0);
        i1 = bs.fM((String)((Map)localObject1).get((String)localObject3 + ".description.$color"), 0);
        ((a)localObject4).desc = ((String)((Map)localObject1).get((String)localObject3 + ".description"));
        ((a)localObject4).wgR = i1;
        ((a)localObject4).Dmj = new Rect(j, k, m + j, n + k);
        ((a)localObject4).url = ((String)((Map)localObject1).get((String)localObject3 + ".url"));
        ((a)localObject4).hqj = ((String)((Map)localObject1).get((String)localObject3 + ".time.start"));
        ((a)localObject4).hqk = ((String)((Map)localObject1).get((String)localObject3 + ".time.end"));
        ac.d("MicroMsg.PushMessage", "parseMessages id:" + ((a)localObject4).id + " start:" + ((a)localObject4).hqj + " end:" + ((a)localObject4).hqk);
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
        ac.d("MicroMsg.PushMessage", " img res:".concat(String.valueOf(paramString)));
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
        ((a)localObject4).Dmk = localHashMap;
      }
      ac.d("MicroMsg.PushMessage", "msgid :" + ((a)localObject4).id);
      ((ArrayList)localObject2).add(localObject4);
      label1316:
      i += 1;
    }
    ac.d("MicroMsg.PushMessage", "msgs size: " + ((ArrayList)localObject2).size());
    if (((ArrayList)localObject2).size() > 0)
    {
      AppMethodBeat.o(31157);
      return localObject2;
    }
    AppMethodBeat.o(31157);
    return null;
  }
  
  private boolean eMj()
  {
    AppMethodBeat.i(31153);
    long l3 = bs.eWj();
    long l1 = 9223372036854775807L;
    long l2 = 0L;
    try
    {
      if (this.hqk != null) {
        l1 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.hqk).getTime();
      }
      if (this.hqj != null) {
        l2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.hqj).getTime();
      }
      ac.d("MicroMsg.PushMessage", "CHECKTIME : [" + l2 + "," + l1 + "]");
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
  
  public static void eMk()
  {
    AppMethodBeat.i(31158);
    az.ayM();
    c.agA().set(8193, "");
    az.ayM();
    c.agA().set(8449, Long.valueOf(0L));
    AppMethodBeat.o(31158);
  }
  
  public static a hs(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(31159);
    az.ayM();
    long l1 = bs.l(c.agA().get(8449, null), 0);
    long l2 = bs.aNx();
    if ((l1 > 0L) && (l2 - l1 >= 86400L)) {
      eMk();
    }
    for (;;)
    {
      AppMethodBeat.o(31159);
      return null;
      az.ayM();
      localObject = (String)c.agA().get(8193, null);
      if (!bs.isNullOrNil((String)localObject)) {
        if (((String)localObject).contains("id=\"setavatar\""))
        {
          eMk();
        }
        else
        {
          if (bs.isNullOrNil((String)localObject)) {
            break label190;
          }
          paramContext = bN(paramContext, (String)localObject);
          if ((paramContext != null) && (paramContext.size() == 1)) {
            break;
          }
          paramContext = null;
          if (paramContext != null) {
            break label200;
          }
          eMk();
        }
      }
    }
    Object localObject = (a)paramContext.get(0);
    if ((((a)localObject).Dmk != null) && (((a)localObject).Dmk.size() > 0)) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext = (Context)localObject;
        if (((a)localObject).eMj()) {
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
    StringBuilder localStringBuilder = new StringBuilder("ad.id=").append(this.id).append(", platform=").append(this.platform).append(", device=").append(this.Dme);
    if (this.Dmf)
    {
      str = ", closable";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.Dmg) {
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
      Dmm = new a("ASSET", 0);
      Dmn = new a("DOWNLOAD", 1);
      Dmo = new a("ERROR", 2);
      Dmp = new a[] { Dmm, Dmn, Dmo };
      AppMethodBeat.o(31152);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.a.a
 * JD-Core Version:    0.7.0.1
 */