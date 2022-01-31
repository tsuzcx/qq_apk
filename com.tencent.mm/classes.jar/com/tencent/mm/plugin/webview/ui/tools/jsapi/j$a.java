package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URISyntaxException;

final class j$a
  extends j.f
{
  private j$a()
  {
    super((byte)0);
  }
  
  protected final void a(Context paramContext, j.e parame1, j.e parame2, String paramString)
  {
    AppMethodBeat.i(9826);
    if (paramContext == null)
    {
      super.a(paramContext, parame1, parame2, paramString);
      AppMethodBeat.o(9826);
      return;
    }
    paramString = String.format("baidumap://map/direction?destination=%f,%f&mode=driving", new Object[] { Double.valueOf(parame2.latitude), Double.valueOf(parame2.longitude) });
    parame2 = paramString;
    if (parame1 != null) {
      parame2 = paramString + String.format("origin=%f,%f", new Object[] { Double.valueOf(parame1.latitude), Double.valueOf(parame1.longitude) });
    }
    ab.d("MicroMsg.OpenMapNavigator", "url ".concat(String.valueOf(parame2)));
    try
    {
      paramContext.startActivity(Intent.parseUri(parame2 + "&src=webapp.car.carroutelistmappg.weixindrivenav", 0));
      AppMethodBeat.o(9826);
      return;
    }
    catch (URISyntaxException paramContext)
    {
      ab.printErrStackTrace("MicroMsg.OpenMapNavigator", paramContext, "", new Object[0]);
      AppMethodBeat.o(9826);
    }
  }
  
  protected final String getPackageName()
  {
    AppMethodBeat.i(9827);
    String str = a.a.vKd.getPackage();
    AppMethodBeat.o(9827);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.j.a
 * JD-Core Version:    0.7.0.1
 */