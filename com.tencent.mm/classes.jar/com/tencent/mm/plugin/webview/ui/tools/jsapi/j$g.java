package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;

final class j$g
  extends j.f
{
  private j$g()
  {
    super((byte)0);
  }
  
  protected final void a(Context paramContext, j.e parame1, j.e parame2, String paramString)
  {
    AppMethodBeat.i(9832);
    if (paramContext == null)
    {
      super.a(paramContext, parame1, parame2, paramString);
      AppMethodBeat.o(9832);
      return;
    }
    Object localObject = String.format("wechatnav://type=nav&tocoord=%f,%f", new Object[] { Double.valueOf(parame2.latitude), Double.valueOf(parame2.longitude) });
    if (parame1 != null)
    {
      String str = (String)localObject + String.format("&fromcoord=%f,%f", new Object[] { Double.valueOf(parame1.latitude), Double.valueOf(parame1.longitude) });
      localObject = str;
      if (!bo.isNullOrNil(parame1.vse)) {
        localObject = str + String.format("&from=%s", new Object[] { URLEncoder.encode(parame1.vse) });
      }
      parame1 = paramString;
      if (bo.isNullOrNil(paramString)) {
        if (bo.isNullOrNil(parame2.vse)) {
          break label293;
        }
      }
    }
    label293:
    for (parame1 = parame2.vse;; parame1 = "目的地")
    {
      parame1 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject + String.format("&to=%s", new Object[] { parame1 })));
      parame1.setPackage(a.a.vKc.getPackage());
      paramContext.startActivity(parame1);
      AppMethodBeat.o(9832);
      return;
      localObject = (String)localObject + String.format("&from=%s", new Object[] { "我的位置" });
      break;
    }
  }
  
  protected final String getPackageName()
  {
    AppMethodBeat.i(156886);
    String str = a.a.vKc.getPackage();
    AppMethodBeat.o(156886);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.j.g
 * JD-Core Version:    0.7.0.1
 */