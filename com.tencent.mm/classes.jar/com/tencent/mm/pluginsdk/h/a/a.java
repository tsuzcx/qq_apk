package com.tencent.mm.pluginsdk.h.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.z;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a
{
  public static final String[] vOV = { "LDPI", "HDPI", "MDPI" };
  public String desc;
  public String device;
  public String fog;
  public String foh;
  public String id;
  public int pWi;
  public String platform;
  public String title;
  public String url;
  public boolean vOP;
  public boolean vOQ;
  public int vOR;
  public Rect vOS;
  public Rect vOT;
  public Map<String, String> vOU;
  
  private a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.id = paramString1;
    this.platform = paramString2;
    this.device = paramString3;
    this.vOP = paramBoolean1;
    this.vOQ = paramBoolean2;
  }
  
  public static String alU(String paramString)
  {
    AppMethodBeat.i(27453);
    Object localObject = alV(paramString);
    if (localObject == a.a.vOW)
    {
      AppMethodBeat.o(27453);
      return paramString;
    }
    if (localObject == a.a.vOX)
    {
      if (paramString == null) {
        paramString = null;
      }
      while (paramString == null)
      {
        AppMethodBeat.o(27453);
        return null;
        int i = paramString.lastIndexOf("/");
        if ((i < 0) || (i >= paramString.length() - 1)) {
          paramString = null;
        } else {
          paramString = paramString.substring(i + 1);
        }
      }
      localObject = new StringBuilder();
      aw.aaz();
      paramString = c.YK() + paramString;
      AppMethodBeat.o(27453);
      return paramString;
    }
    AppMethodBeat.o(27453);
    return null;
  }
  
  public static a.a alV(String paramString)
  {
    AppMethodBeat.i(27454);
    if (paramString.indexOf("tips/") == 0)
    {
      paramString = a.a.vOW;
      AppMethodBeat.o(27454);
      return paramString;
    }
    if (paramString.indexOf("weixin://") == 0)
    {
      paramString = a.a.vOX;
      AppMethodBeat.o(27454);
      return paramString;
    }
    paramString = a.a.vOY;
    AppMethodBeat.o(27454);
    return paramString;
  }
  
  public static ArrayList<a> by(Context paramContext, String paramString)
  {
    AppMethodBeat.i(27455);
    if ((paramString == null) || (paramString.length() < 0))
    {
      AppMethodBeat.o(27455);
      return null;
    }
    Object localObject1 = paramContext.getResources().getDisplayMetrics();
    Object localObject2 = ((DisplayMetrics)localObject1).heightPixels + "x" + ((DisplayMetrics)localObject1).widthPixels;
    if (localObject2 == null)
    {
      paramContext = null;
      if ((paramContext == null) || (paramContext.size() <= 0))
      {
        AppMethodBeat.o(27455);
        return null;
      }
    }
    else
    {
      localObject1 = new HashSet();
      ((HashSet)localObject1).add(localObject2);
      paramContext = BackwardSupportUtil.b.gB(paramContext);
      ab.d("MicroMsg.PushMessage", "getDisplaySizeType :".concat(String.valueOf(paramContext)));
      if (paramContext != null)
      {
        paramContext = paramContext.split("_");
        if ((paramContext != null) && (paramContext.length >= 2)) {
          break label208;
        }
      }
      label208:
      for (paramContext = null;; paramContext = paramContext[0])
      {
        ((HashSet)localObject1).add(paramContext + "_L");
        ((HashSet)localObject1).add(paramContext + "_P");
        paramContext = (Context)localObject1;
        break;
      }
    }
    localObject1 = br.F(paramString, "tips");
    if (localObject1 == null)
    {
      AppMethodBeat.o(27455);
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
      label1162:
      Object localObject5;
      if (i > 0)
      {
        paramString = Integer.valueOf(i);
        localObject3 = paramString;
        if (((Map)localObject1).get(localObject3) == null) {
          break;
        }
        paramString = (String)((Map)localObject1).get((String)localObject3 + ".$id");
        ab.d("MicroMsg.PushMessage", "parseMessages id:".concat(String.valueOf(paramString)));
        localObject4 = (String)((Map)localObject1).get((String)localObject3 + ".$platform");
        if (!((String)localObject4).equals("android")) {
          break label1355;
        }
        localObject4 = new a(paramString, (String)localObject4, (String)((Map)localObject1).get((String)localObject3 + ".$device"), bo.d(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$enableclose"))), bo.d(Boolean.valueOf((String)((Map)localObject1).get((String)localObject3 + ".$transparentclose"))));
        j = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$x"), 0);
        int k = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$y"), 0);
        int m = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$width"), 0);
        int n = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".title.$font"), 0);
        int i1 = bo.apN((String)((Map)localObject1).get((String)localObject3 + ".title.$color"));
        ((a)localObject4).title = ((String)((Map)localObject1).get((String)localObject3 + ".title"));
        ((a)localObject4).vOR = i1;
        ((a)localObject4).vOS = new Rect(j, k, m + j, n + k);
        j = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$x"), 0);
        k = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$y"), 0);
        m = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$width"), 0);
        n = bo.getInt((String)((Map)localObject1).get((String)localObject3 + ".description.$font"), 0);
        i1 = bo.apN((String)((Map)localObject1).get((String)localObject3 + ".description.$color"));
        ((a)localObject4).desc = ((String)((Map)localObject1).get((String)localObject3 + ".description"));
        ((a)localObject4).pWi = i1;
        ((a)localObject4).vOT = new Rect(j, k, m + j, n + k);
        ((a)localObject4).url = ((String)((Map)localObject1).get((String)localObject3 + ".url"));
        ((a)localObject4).fog = ((String)((Map)localObject1).get((String)localObject3 + ".time.start"));
        ((a)localObject4).foh = ((String)((Map)localObject1).get((String)localObject3 + ".time.end"));
        ab.d("MicroMsg.PushMessage", "parseMessages id:" + ((a)localObject4).id + " start:" + ((a)localObject4).fog + " end:" + ((a)localObject4).foh);
        localHashMap = new HashMap();
        j = 0;
        localObject5 = new StringBuilder().append((String)localObject3).append(".images.image");
        if (j <= 0) {
          break label1299;
        }
      }
      label1299:
      for (paramString = Integer.valueOf(j);; paramString = "")
      {
        localObject5 = paramString;
        paramString = (String)((Map)localObject1).get(localObject5);
        ab.d("MicroMsg.PushMessage", " img res:".concat(String.valueOf(paramString)));
        if (paramString == null) {
          break label1306;
        }
        localObject5 = (String)((Map)localObject1).get((String)localObject5 + ".$type");
        if (paramContext.contains(localObject5)) {
          localHashMap.put(localObject5, paramString);
        }
        j += 1;
        break label1162;
        paramString = "";
        break;
      }
      label1306:
      if (localHashMap.size() > 0) {
        ((a)localObject4).vOU = localHashMap;
      }
      ab.d("MicroMsg.PushMessage", "msgid :" + ((a)localObject4).id);
      ((ArrayList)localObject2).add(localObject4);
      label1355:
      i += 1;
    }
    ab.d("MicroMsg.PushMessage", "msgs size: " + ((ArrayList)localObject2).size());
    if (((ArrayList)localObject2).size() > 0)
    {
      AppMethodBeat.o(27455);
      return localObject2;
    }
    AppMethodBeat.o(27455);
    return null;
  }
  
  private boolean dmD()
  {
    AppMethodBeat.i(27451);
    long l3 = bo.aoy();
    long l1 = 9223372036854775807L;
    long l2 = 0L;
    try
    {
      if (this.foh != null) {
        l1 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.foh).getTime();
      }
      if (this.fog != null) {
        l2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.fog).getTime();
      }
      ab.d("MicroMsg.PushMessage", "CHECKTIME : [" + l2 + "," + l1 + "]");
      if (l1 <= l3) {
        break label151;
      }
      if (l2 > l3)
      {
        AppMethodBeat.o(27451);
        return false;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(27451);
      return true;
    }
    AppMethodBeat.o(27451);
    return true;
    label151:
    AppMethodBeat.o(27451);
    return false;
  }
  
  public static void dmE()
  {
    AppMethodBeat.i(27456);
    aw.aaz();
    c.Ru().set(8193, "");
    aw.aaz();
    c.Ru().set(8449, Long.valueOf(0L));
    AppMethodBeat.o(27456);
  }
  
  public static a fV(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(27457);
    aw.aaz();
    long l1 = bo.f(c.Ru().get(8449, null), 0);
    long l2 = bo.aox();
    if ((l1 > 0L) && (l2 - l1 >= 86400L)) {
      dmE();
    }
    for (;;)
    {
      AppMethodBeat.o(27457);
      return null;
      aw.aaz();
      localObject = (String)c.Ru().get(8193, null);
      if (!bo.isNullOrNil((String)localObject)) {
        if (((String)localObject).contains("id=\"setavatar\""))
        {
          dmE();
        }
        else
        {
          if (bo.isNullOrNil((String)localObject)) {
            break label190;
          }
          paramContext = by(paramContext, (String)localObject);
          if ((paramContext != null) && (paramContext.size() == 1)) {
            break;
          }
          paramContext = null;
          if (paramContext != null) {
            break label200;
          }
          dmE();
        }
      }
    }
    Object localObject = (a)paramContext.get(0);
    if ((((a)localObject).vOU != null) && (((a)localObject).vOU.size() > 0)) {}
    for (;;)
    {
      if (i != 0)
      {
        paramContext = (Context)localObject;
        if (((a)localObject).dmD()) {
          break;
        }
      }
      label190:
      paramContext = null;
      break;
      i = 0;
    }
    label200:
    AppMethodBeat.o(27457);
    return paramContext;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(27452);
    StringBuilder localStringBuilder = new StringBuilder("ad.id=").append(this.id).append(", platform=").append(this.platform).append(", device=").append(this.device);
    if (this.vOP)
    {
      str = ", closable";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.vOQ) {
        break label102;
      }
    }
    label102:
    for (String str = ", trans-closable";; str = "")
    {
      str = str;
      AppMethodBeat.o(27452);
      return str;
      str = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a
 * JD-Core Version:    0.7.0.1
 */