package com.tencent.mm.plugin.websearch.widget.c.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements a
{
  private boolean b(final Context paramContext, final String paramString, Map<String, String> paramMap)
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
      com.tencent.mm.cj.a.post(new Runnable()
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
      ad.e("OpenAppNativeApp", bt.m(paramContext));
      AppMethodBeat.o(116664);
      return false;
    }
    AppMethodBeat.o(116664);
    return true;
  }
  
  public final boolean avn(String paramString)
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
  
  public final boolean avo(String paramString)
  {
    AppMethodBeat.i(116663);
    if (!avn(paramString))
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
    if (!b(aj.getContext(), paramString, localHashMap))
    {
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject);
      paramString.putExtra("useJs", true);
      d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", paramString);
    }
    AppMethodBeat.o(116663);
    return true;
  }
  
  public final boolean uX(long paramLong)
  {
    AppMethodBeat.i(116661);
    boolean bool = com.tencent.mm.plugin.websearch.widget.c.c.Z(paramLong, 1);
    AppMethodBeat.o(116661);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.c
 * JD-Core Version:    0.7.0.1
 */