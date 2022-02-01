package com.tencent.mm.pluginsdk.k.a;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a
{
  public static final String[] ERn = { "LDPI", "HDPI", "MDPI" };
  public String ERg;
  public boolean ERh;
  public boolean ERi;
  public int ERj;
  public Rect ERk;
  public Rect ERl;
  public Map<String, String> ERm;
  public String desc;
  public String hIB;
  public String hIC;
  public String id;
  public String platform;
  public String title;
  public String url;
  public int xoz;
  
  private a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.id = paramString1;
    this.platform = paramString2;
    this.ERg = paramString3;
    this.ERh = paramBoolean1;
    this.ERi = paramBoolean2;
  }
  
  public static String aMm(String paramString)
  {
    AppMethodBeat.i(31155);
    Object localObject = aMn(paramString);
    if (localObject == a.a.ERo)
    {
      AppMethodBeat.o(31155);
      return paramString;
    }
    if (localObject == a.a.ERp)
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
      ba.aBQ();
      paramString = c.azA() + paramString;
      AppMethodBeat.o(31155);
      return paramString;
    }
    AppMethodBeat.o(31155);
    return null;
  }
  
  public static a.a aMn(String paramString)
  {
    AppMethodBeat.i(31156);
    if (paramString.indexOf("tips/") == 0)
    {
      paramString = a.a.ERo;
      AppMethodBeat.o(31156);
      return paramString;
    }
    if (paramString.indexOf("weixin://") == 0)
    {
      paramString = a.a.ERp;
      AppMethodBeat.o(31156);
      return paramString;
    }
    paramString = a.a.ERq;
    AppMethodBeat.o(31156);
    return paramString;
  }
  
  public static ArrayList<a> bR(Context paramContext, String paramString)
  {
    AppMethodBeat.i(31157);
    if ((paramString == null) || (paramString.length() < 0))
    {
      AppMethodBeat.o(31157);
      return null;
    }
    Object localObject2 = BackwardSupportUtil.b.iy(paramContext);
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
      paramContext = BackwardSupportUtil.b.ix(paramContext);
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
    Object localObject1 = bw.M(paramString, "tips");
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
        localObject4 = new a(paramString, (String)localObject4, (String)((Map)localObject1).get((String)localObject3 + ".$device"), bt.n(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$enableclose"))), bt.n(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$transparentclose"))));
        j = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$x"), 0);
        int k = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$y"), 0);
        int m = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$width"), 0);
        int n = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$font"), 0);
        int i1 = bt.gj((String)((Map)localObject1).get((String)localObject3 + ".title.$color"), 0);
        ((a)localObject4).title = ((String)((Map)localObject1).get((String)localObject3 + ".title"));
        ((a)localObject4).ERj = i1;
        ((a)localObject4).ERk = new Rect(j, k, m + j, n + k);
        j = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$x"), 0);
        k = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$y"), 0);
        m = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$width"), 0);
        n = bt.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$font"), 0);
        i1 = bt.gj((String)((Map)localObject1).get((String)localObject3 + ".description.$color"), 0);
        ((a)localObject4).desc = ((String)((Map)localObject1).get((String)localObject3 + ".description"));
        ((a)localObject4).xoz = i1;
        ((a)localObject4).ERl = new Rect(j, k, m + j, n + k);
        ((a)localObject4).url = ((String)((Map)localObject1).get((String)localObject3 + ".url"));
        ((a)localObject4).hIB = ((String)((Map)localObject1).get((String)localObject3 + ".time.start"));
        ((a)localObject4).hIC = ((String)((Map)localObject1).get((String)localObject3 + ".time.end"));
        ad.d("MicroMsg.PushMessage", "parseMessages id:" + ((a)localObject4).id + " start:" + ((a)localObject4).hIB + " end:" + ((a)localObject4).hIC);
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
        ((a)localObject4).ERm = localHashMap;
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
  
  private boolean fbg()
  {
    AppMethodBeat.i(31153);
    long l3 = bt.flT();
    long l1 = 9223372036854775807L;
    long l2 = 0L;
    try
    {
      if (this.hIC != null) {
        l1 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.hIC).getTime();
      }
      if (this.hIB != null) {
        l2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.hIB).getTime();
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
  
  public static void fbh()
  {
    AppMethodBeat.i(31158);
    ba.aBQ();
    c.ajl().set(8193, "");
    ba.aBQ();
    c.ajl().set(8449, Long.valueOf(0L));
    AppMethodBeat.o(31158);
  }
  
  public static a hx(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(31159);
    ba.aBQ();
    long l1 = bt.m(c.ajl().get(8449, null), 0);
    long l2 = bt.aQJ();
    if ((l1 > 0L) && (l2 - l1 >= 86400L)) {
      fbh();
    }
    for (;;)
    {
      AppMethodBeat.o(31159);
      return null;
      ba.aBQ();
      localObject = (String)c.ajl().get(8193, null);
      if (!bt.isNullOrNil((String)localObject)) {
        if (((String)localObject).contains("id=\"setavatar\""))
        {
          fbh();
        }
        else
        {
          if (bt.isNullOrNil((String)localObject)) {
            break label190;
          }
          paramContext = bR(paramContext, (String)localObject);
          if ((paramContext != null) && (paramContext.size() == 1)) {
            break;
          }
          paramContext = null;
          if (paramContext != null) {
            break label200;
          }
          fbh();
        }
      }
    }
    Object localObject = (a)paramContext.get(0);
    if ((((a)localObject).ERm != null) && (((a)localObject).ERm.size() > 0)) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext = (Context)localObject;
        if (((a)localObject).fbg()) {
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
    StringBuilder localStringBuilder = new StringBuilder("ad.id=").append(this.id).append(", platform=").append(this.platform).append(", device=").append(this.ERg);
    if (this.ERh)
    {
      str = ", closable";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.ERi) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a
 * JD-Core Version:    0.7.0.1
 */