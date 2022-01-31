package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.un;
import com.tencent.mm.g.a.un.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelappbrand.o;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class b
{
  public static String Aq(String paramString)
  {
    AppMethodBeat.i(29956);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(29956);
      return null;
    }
    paramString = ((i)g.E(i.class)).Ae(paramString);
    if ((paramString != null) && (paramString.ayC() != null))
    {
      paramString = paramString.field_appId;
      AppMethodBeat.o(29956);
      return paramString;
    }
    ab.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(29956);
    return null;
  }
  
  public static String ats(String paramString)
  {
    AppMethodBeat.i(29955);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(29955);
      return null;
    }
    paramString = ((i)g.E(i.class)).Ae(paramString);
    if ((paramString != null) && (paramString.ayC() != null))
    {
      paramString = paramString.ayC().hjT;
      AppMethodBeat.o(29955);
      return paramString;
    }
    ab.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(29955);
    return null;
  }
  
  public static String att(String paramString)
  {
    AppMethodBeat.i(29957);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(29957);
      return null;
    }
    paramString = ((i)g.E(i.class)).Ae(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_nickname;
      AppMethodBeat.o(29957);
      return paramString;
    }
    ab.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(29957);
    return null;
  }
  
  public static void j(Context paramContext, String paramString, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(29954);
    Object localObject1 = new un();
    ((un)localObject1).cLa.cmx = paramString;
    Object localObject2 = ((un)localObject1).cLa;
    if (paramBoolean)
    {
      i = 2;
      ((un.a)localObject2).action = i;
      ((un)localObject1).cLa.option = 2;
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new LinkedList();
      localObject2 = new ciy();
      ((ciy)localObject2).xTh = paramString;
      if (!paramBoolean) {
        break label165;
      }
    }
    label165:
    for (int i = j;; i = 0)
    {
      ((ciy)localObject2).xTg = i;
      ((ciy)localObject2).jKs = 3;
      ((LinkedList)localObject1).add(localObject2);
      aw.Rc().a(1176, new b.1(paramContext, paramString, paramBoolean));
      paramContext = new o((LinkedList)localObject1);
      aw.Rc().a(paramContext, 0);
      AppMethodBeat.o(29954);
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.b
 * JD-Core Version:    0.7.0.1
 */