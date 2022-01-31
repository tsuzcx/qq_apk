package com.tencent.mm.plugin.websearch.widget.c.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements a
{
  private boolean b(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(91469);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(91469);
      return false;
    }
    try
    {
      paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
      if (paramString != null)
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          paramString.putExtra((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
      com.tencent.mm.ch.a.post(new c.1(this, paramContext, paramString));
    }
    catch (Exception paramContext)
    {
      ab.e("OpenAppNativeApp", bo.l(paramContext));
      AppMethodBeat.o(91469);
      return false;
    }
    AppMethodBeat.o(91469);
    return true;
  }
  
  public final boolean agF(String paramString)
  {
    AppMethodBeat.i(91467);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(91467);
      return false;
    }
    boolean bool = paramString.startsWith("app://");
    AppMethodBeat.o(91467);
    return bool;
  }
  
  public final boolean agG(String paramString)
  {
    AppMethodBeat.i(91468);
    if (!agF(paramString))
    {
      AppMethodBeat.o(91468);
      return false;
    }
    Object localObject = Uri.parse(paramString);
    paramString = ((Uri)localObject).getQueryParameter("pkgName");
    String str1 = ((Uri)localObject).getQueryParameter("extra");
    String str2 = ((Uri)localObject).getQueryParameter("extraIntentKey");
    localObject = ((Uri)localObject).getQueryParameter("fallbackUrl");
    HashMap localHashMap = new HashMap();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      localHashMap.put(str2, str1);
    }
    if (!b(ah.getContext(), paramString, localHashMap))
    {
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      paramString.putExtra("useJs", true);
      d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", paramString);
    }
    AppMethodBeat.o(91468);
    return true;
  }
  
  public final boolean nm(long paramLong)
  {
    AppMethodBeat.i(91466);
    boolean bool = com.tencent.mm.plugin.websearch.widget.c.c.J(paramLong, 1);
    AppMethodBeat.o(91466);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.c
 * JD-Core Version:    0.7.0.1
 */