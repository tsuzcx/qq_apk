package com.tencent.mm.plugin.websearch.widget.c.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements a
{
  private boolean a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
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
      return false;
    }
    catch (Exception paramContext)
    {
      y.e("OpenAppNativeApp", bk.j(paramContext));
    }
    com.tencent.mm.cg.a.post(new c.1(this, paramContext, paramString));
    return true;
  }
  
  public final boolean RE(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("app://");
  }
  
  public final boolean RF(String paramString)
  {
    boolean bool = true;
    if (!RE(paramString)) {
      bool = false;
    }
    Object localObject;
    HashMap localHashMap;
    do
    {
      return bool;
      localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getQueryParameter("pkgName");
      String str1 = ((Uri)localObject).getQueryParameter("extra");
      String str2 = ((Uri)localObject).getQueryParameter("extraIntentKey");
      localObject = ((Uri)localObject).getQueryParameter("fallbackUrl");
      localHashMap = new HashMap();
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        localHashMap.put(str2, str1);
      }
    } while (a(ae.getContext(), paramString, localHashMap));
    paramString = new Intent();
    paramString.putExtra("rawUrl", (String)localObject);
    paramString.putExtra("useJs", true);
    d.b(ae.getContext(), "webview", ".ui.tools.WebViewUI", paramString);
    return true;
  }
  
  public final boolean gQ(long paramLong)
  {
    return com.tencent.mm.plugin.websearch.widget.c.c.z(paramLong, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.c
 * JD-Core Version:    0.7.0.1
 */