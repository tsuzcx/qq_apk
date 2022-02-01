package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.g.a.yw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class e
{
  public static String Xw(String paramString)
  {
    AppMethodBeat.i(33813);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33813);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(paramString);
    if ((paramString != null) && (paramString.bAn() != null))
    {
      paramString = paramString.field_appId;
      AppMethodBeat.o(33813);
      return paramString;
    }
    Log.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33813);
    return null;
  }
  
  public static String blX(String paramString)
  {
    AppMethodBeat.i(33812);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33812);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(paramString);
    if ((paramString != null) && (paramString.bAn() != null))
    {
      paramString = paramString.bAn().lgA;
      AppMethodBeat.o(33812);
      return paramString;
    }
    Log.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33812);
    return null;
  }
  
  public static String blY(String paramString)
  {
    AppMethodBeat.i(33814);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33814);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.service.q)g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_nickname;
      AppMethodBeat.o(33814);
      return paramString;
    }
    Log.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33814);
    return null;
  }
  
  public static void l(Context paramContext, String paramString, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(33811);
    Object localObject1 = new yw();
    ((yw)localObject1).efe.dCl = paramString;
    Object localObject2 = ((yw)localObject1).efe;
    if (paramBoolean)
    {
      i = 2;
      ((yw.a)localObject2).action = i;
      ((yw)localObject1).efe.option = 2;
      EventCenter.instance.publish((IEvent)localObject1);
      localObject1 = new LinkedList();
      localObject2 = new eft();
      ((eft)localObject2).NfM = paramString;
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (int i = j;; i = 0)
    {
      ((eft)localObject2).NfL = i;
      ((eft)localObject2).oUv = 3;
      ((LinkedList)localObject1).add(localObject2);
      bg.azz().a(1176, new e.1(paramContext, paramString, paramBoolean));
      paramContext = new com.tencent.mm.modelappbrand.q((LinkedList)localObject1);
      bg.azz().a(paramContext, 0);
      AppMethodBeat.o(33811);
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.e
 * JD-Core Version:    0.7.0.1
 */