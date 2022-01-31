package com.tencent.mm.pluginsdk.h.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a
{
  public static final String[] rYe = { "LDPI", "HDPI", "MDPI" };
  public String dYc;
  public String dYd;
  public String desc;
  public String device;
  public String id;
  public int nqU;
  public String platform;
  public boolean rXY;
  public boolean rXZ;
  public int rYa;
  public Rect rYb;
  public Rect rYc;
  public Map<String, String> rYd;
  public String title;
  public String url;
  
  private a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.id = paramString1;
    this.platform = paramString2;
    this.device = paramString3;
    this.rXY = paramBoolean1;
    this.rXZ = paramBoolean2;
  }
  
  public static String Wq(String paramString)
  {
    Object localObject = Wr(paramString);
    if (localObject == a.a.rYf) {
      return paramString;
    }
    if (localObject == a.a.rYg)
    {
      if (paramString == null) {
        paramString = null;
      }
      while (paramString == null)
      {
        return null;
        int i = paramString.lastIndexOf("/");
        if ((i < 0) || (i >= paramString.length() - 1)) {
          paramString = null;
        } else {
          paramString = paramString.substring(i + 1);
        }
      }
      localObject = new StringBuilder();
      au.Hx();
      return c.FG() + paramString;
    }
    return null;
  }
  
  public static a.a Wr(String paramString)
  {
    if (paramString.indexOf("tips/") == 0) {
      return a.a.rYf;
    }
    if (paramString.indexOf("weixin://") == 0) {
      return a.a.rYg;
    }
    return a.a.rYh;
  }
  
  public static ArrayList<a> bm(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() < 0)) {
      return null;
    }
    Object localObject1 = paramContext.getResources().getDisplayMetrics();
    Object localObject2 = ((DisplayMetrics)localObject1).heightPixels + "x" + ((DisplayMetrics)localObject1).widthPixels;
    if (localObject2 == null)
    {
      paramContext = null;
      if ((paramContext == null) || (paramContext.size() <= 0)) {
        return null;
      }
    }
    else
    {
      localObject1 = new HashSet();
      ((HashSet)localObject1).add(localObject2);
      paramContext = BackwardSupportUtil.b.fo(paramContext);
      y.d("MicroMsg.PushMessage", "getDisplaySizeType :" + paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.split("_");
        if ((paramContext != null) && (paramContext.length >= 2)) {
          break label197;
        }
      }
      label197:
      for (paramContext = null;; paramContext = paramContext[0])
      {
        ((HashSet)localObject1).add(paramContext + "_L");
        ((HashSet)localObject1).add(paramContext + "_P");
        paramContext = (Context)localObject1;
        break;
      }
    }
    localObject1 = bn.s(paramString, "tips");
    if (localObject1 == null) {
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
      label1148:
      Object localObject5;
      if (i > 0)
      {
        paramString = Integer.valueOf(i);
        localObject3 = paramString;
        if (((Map)localObject1).get(localObject3) == null) {
          break;
        }
        paramString = (String)((Map)localObject1).get((String)localObject3 + ".$id");
        y.d("MicroMsg.PushMessage", "parseMessages id:" + paramString);
        localObject4 = (String)((Map)localObject1).get((String)localObject3 + ".$platform");
        if (!((String)localObject4).equals("android")) {
          break label1348;
        }
        localObject4 = new a(paramString, (String)localObject4, (String)((Map)localObject1).get((String)localObject3 + ".$device"), bk.c(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$enableclose"))), bk.c(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$transparentclose"))));
        j = bk.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$x"), 0);
        int k = bk.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$y"), 0);
        int m = bk.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$width"), 0);
        int n = bk.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$font"), 0);
        int i1 = bk.ZJ((String)((Map)localObject1).get((String)localObject3 + ".title.$color"));
        ((a)localObject4).title = ((String)((Map)localObject1).get((String)localObject3 + ".title"));
        ((a)localObject4).rYa = i1;
        ((a)localObject4).rYb = new Rect(j, k, m + j, n + k);
        j = bk.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$x"), 0);
        k = bk.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$y"), 0);
        m = bk.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$width"), 0);
        n = bk.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$font"), 0);
        i1 = bk.ZJ((String)((Map)localObject1).get((String)localObject3 + ".description.$color"));
        ((a)localObject4).desc = ((String)((Map)localObject1).get((String)localObject3 + ".description"));
        ((a)localObject4).nqU = i1;
        ((a)localObject4).rYc = new Rect(j, k, m + j, n + k);
        ((a)localObject4).url = ((String)((Map)localObject1).get((String)localObject3 + ".url"));
        ((a)localObject4).dYc = ((String)((Map)localObject1).get((String)localObject3 + ".time.start"));
        ((a)localObject4).dYd = ((String)((Map)localObject1).get((String)localObject3 + ".time.end"));
        y.d("MicroMsg.PushMessage", "parseMessages id:" + ((a)localObject4).id + " start:" + ((a)localObject4).dYc + " end:" + ((a)localObject4).dYd);
        localHashMap = new HashMap();
        j = 0;
        localObject5 = new StringBuilder().append((String)localObject3).append(".images.image");
        if (j <= 0) {
          break label1292;
        }
      }
      label1292:
      for (paramString = Integer.valueOf(j);; paramString = "")
      {
        localObject5 = paramString;
        paramString = (String)((Map)localObject1).get(localObject5);
        y.d("MicroMsg.PushMessage", " img res:" + paramString);
        if (paramString == null) {
          break label1299;
        }
        localObject5 = (String)((Map)localObject1).get((String)localObject5 + ".$type");
        if (paramContext.contains(localObject5)) {
          localHashMap.put(localObject5, paramString);
        }
        j += 1;
        break label1148;
        paramString = "";
        break;
      }
      label1299:
      if (localHashMap.size() > 0) {
        ((a)localObject4).rYd = localHashMap;
      }
      y.d("MicroMsg.PushMessage", "msgid :" + ((a)localObject4).id);
      ((ArrayList)localObject2).add(localObject4);
      label1348:
      i += 1;
    }
    y.d("MicroMsg.PushMessage", "msgs size: " + ((ArrayList)localObject2).size());
    if (((ArrayList)localObject2).size() > 0) {
      return localObject2;
    }
    return null;
  }
  
  private boolean clP()
  {
    long l3 = bk.UY();
    long l1 = 9223372036854775807L;
    long l2 = 0L;
    try
    {
      if (this.dYd != null) {
        l1 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.dYd).getTime();
      }
      if (this.dYc != null) {
        l2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.dYc).getTime();
      }
      y.d("MicroMsg.PushMessage", "CHECKTIME : [" + l2 + "," + l1 + "]");
      if ((l1 <= l3) || (l2 > l3)) {
        return false;
      }
    }
    catch (Exception localException)
    {
      return true;
    }
    return true;
  }
  
  public static void clQ()
  {
    au.Hx();
    c.Dz().o(8193, "");
    au.Hx();
    c.Dz().o(8449, Long.valueOf(0L));
  }
  
  public static a eW(Context paramContext)
  {
    int i = 1;
    au.Hx();
    long l1 = bk.e(c.Dz().get(8449, null), 0);
    long l2 = bk.UX();
    if ((l1 > 0L) && (l2 - l1 >= 86400L)) {
      clQ();
    }
    for (;;)
    {
      localObject = null;
      do
      {
        return localObject;
        au.Hx();
        localObject = (String)c.Dz().get(8193, null);
        if (bk.bl((String)localObject)) {
          break;
        }
        if (((String)localObject).contains("id=\"setavatar\""))
        {
          clQ();
          break;
        }
        if (bk.bl((String)localObject)) {
          break label185;
        }
        paramContext = bm(paramContext, (String)localObject);
        if ((paramContext != null) && (paramContext.size() == 1)) {
          break label139;
        }
        paramContext = null;
        localObject = paramContext;
      } while (paramContext != null);
      clQ();
    }
    label139:
    Object localObject = (a)paramContext.get(0);
    if ((((a)localObject).rYd != null) && (((a)localObject).rYd.size() > 0)) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext = (Context)localObject;
        if (((a)localObject).clP()) {
          break;
        }
      }
      label185:
      paramContext = null;
      break;
      i = 0;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ad.id=").append(this.id).append(", platform=").append(this.platform).append(", device=").append(this.device);
    if (this.rXY)
    {
      str = ", closable";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.rXZ) {
        break label88;
      }
    }
    label88:
    for (String str = ", trans-closable";; str = "")
    {
      return str;
      str = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a
 * JD-Core Version:    0.7.0.1
 */