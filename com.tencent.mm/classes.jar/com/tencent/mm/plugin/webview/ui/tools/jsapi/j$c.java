package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.a.a;

final class j$c
  extends j.f
{
  private j$c()
  {
    super((byte)0);
  }
  
  protected final void a(Context paramContext, j.e parame1, j.e parame2, String paramString)
  {
    AppMethodBeat.i(9830);
    if (paramContext == null)
    {
      super.a(paramContext, parame1, parame2, paramString);
      AppMethodBeat.o(9830);
      return;
    }
    paramString = String.format("http://maps.google.com/maps?f=d&daddr=%f,%f", new Object[] { Double.valueOf(parame2.latitude), Double.valueOf(parame2.longitude) });
    parame2 = paramString;
    if (parame1 != null) {
      parame2 = paramString + String.format("&saddr=%f,%f", new Object[] { Double.valueOf(parame1.latitude), Double.valueOf(parame1.longitude) });
    }
    parame1 = new Intent("android.intent.action.VIEW", Uri.parse(parame2));
    parame1.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
    paramContext.startActivity(parame1);
    AppMethodBeat.o(9830);
  }
  
  protected final String getPackageName()
  {
    AppMethodBeat.i(9831);
    String str = a.a.vKb.getPackage();
    AppMethodBeat.o(9831);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.j.c
 * JD-Core Version:    0.7.0.1
 */