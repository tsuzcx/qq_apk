package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;

final class j$h
  extends j.f
{
  private j$h()
  {
    super((byte)0);
  }
  
  protected final void a(Context paramContext, j.e parame1, j.e parame2, String paramString)
  {
    AppMethodBeat.i(9834);
    if (paramContext == null)
    {
      super.a(paramContext, parame1, parame2, paramString);
      AppMethodBeat.o(9834);
      return;
    }
    String str2 = String.format("sosomap://type=nav&tocoord=%f,%f", new Object[] { Double.valueOf(parame2.longitude), Double.valueOf(parame2.latitude) });
    String str1 = str2;
    if (parame1 != null)
    {
      str2 = str2 + String.format("fromcoord=%f,%f", new Object[] { Double.valueOf(parame1.longitude), Double.valueOf(parame1.latitude) });
      str1 = str2;
      if (!bo.isNullOrNil(parame1.vse)) {
        str1 = str2 + String.format("&from=%s", new Object[] { URLEncoder.encode(parame1.vse) });
      }
    }
    parame1 = paramString;
    if (bo.isNullOrNil(paramString)) {
      if (bo.isNullOrNil(parame2.vse)) {
        break label283;
      }
    }
    label283:
    for (parame1 = parame2.vse;; parame1 = "地图选点")
    {
      parame1 = str1 + String.format("&to=%s", new Object[] { URLEncoder.encode(parame1) });
      parame1 = new Intent("android.intent.action.VIEW", Uri.parse(parame1 + "&referer=wx_client"));
      parame1.setPackage(a.a.vKa.getPackage());
      paramContext.startActivity(parame1);
      AppMethodBeat.o(9834);
      return;
    }
  }
  
  protected final String getPackageName()
  {
    AppMethodBeat.i(156887);
    String str = a.a.vKa.getPackage();
    AppMethodBeat.o(156887);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.j.h
 * JD-Core Version:    0.7.0.1
 */