package com.tencent.mm.plugin.websearch.widget.c.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements a
{
  private boolean c(final Context paramContext, final String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(116664);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(116664);
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
      com.tencent.mm.ci.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(116660);
          h.b(paramContext, paramString, "");
          AppMethodBeat.o(116660);
        }
      });
    }
    catch (Exception paramContext)
    {
      Log.e("OpenAppNativeApp", Util.stackTraceToString(paramContext));
      AppMethodBeat.o(116664);
      return false;
    }
    AppMethodBeat.o(116664);
    return true;
  }
  
  public final boolean biQ(String paramString)
  {
    AppMethodBeat.i(116662);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(116662);
      return false;
    }
    boolean bool = paramString.startsWith("app://");
    AppMethodBeat.o(116662);
    return bool;
  }
  
  public final boolean biR(String paramString)
  {
    AppMethodBeat.i(116663);
    if (!biQ(paramString))
    {
      AppMethodBeat.o(116663);
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
    if (!c(MMApplicationContext.getContext(), paramString, localHashMap))
    {
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      paramString.putExtra("useJs", true);
      com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramString);
    }
    AppMethodBeat.o(116663);
    return true;
  }
  
  public final boolean xJ(long paramLong)
  {
    AppMethodBeat.i(116661);
    boolean bool = com.tencent.mm.plugin.websearch.widget.c.c.aJ(paramLong, 1);
    AppMethodBeat.o(116661);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.c
 * JD-Core Version:    0.7.0.1
 */