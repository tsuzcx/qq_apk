package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.su;
import com.tencent.mm.h.a.su.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelappbrand.o;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.protocal.c.bwq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class b
{
  public static String acZ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((c)g.r(c.class)).so(paramString);
    if ((paramString != null) && (paramString.aen() != null)) {
      return paramString.aen().fRh;
    }
    y.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    return null;
  }
  
  public static String ada(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((c)g.r(c.class)).so(paramString);
    if (paramString != null) {
      return paramString.field_nickname;
    }
    y.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    return null;
  }
  
  public static void i(Context paramContext, String paramString, boolean paramBoolean)
  {
    int j = 1;
    Object localObject1 = new su();
    ((su)localObject1).ccq.bFn = paramString;
    Object localObject2 = ((su)localObject1).ccq;
    if (paramBoolean)
    {
      i = 2;
      ((su.a)localObject2).action = i;
      ((su)localObject1).ccq.ccs = 2;
      a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new LinkedList();
      localObject2 = new bwq();
      ((bwq)localObject2).tMX = paramString;
      if (!paramBoolean) {
        break label153;
      }
    }
    label153:
    for (int i = j;; i = 0)
    {
      ((bwq)localObject2).tMW = i;
      ((bwq)localObject2).hQR = 3;
      ((LinkedList)localObject1).add(localObject2);
      au.Dk().a(1176, new b.1(paramContext, paramString, paramBoolean));
      paramContext = new o((LinkedList)localObject1);
      au.Dk().a(paramContext, 0);
      return;
      i = 1;
      break;
    }
  }
  
  public static String sv(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((c)g.r(c.class)).so(paramString);
    if ((paramString != null) && (paramString.aen() != null)) {
      return paramString.field_appId;
    }
    y.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.b
 * JD-Core Version:    0.7.0.1
 */