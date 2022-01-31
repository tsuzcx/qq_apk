package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.a.a;

final class j$b
  extends j.f
{
  private j$b()
  {
    super((byte)0);
  }
  
  protected final void a(Context paramContext, j.e parame1, j.e parame2, String paramString)
  {
    AppMethodBeat.i(9828);
    if (paramContext == null)
    {
      super.a(paramContext, parame1, parame2, paramString);
      AppMethodBeat.o(9828);
      return;
    }
    parame1 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=1&style=2", new Object[] { "MicroMessager", Double.valueOf(parame2.latitude), Double.valueOf(parame2.longitude) })));
    parame1.addCategory("android.intent.category.DEFAULT");
    parame1.setPackage(a.a.vKe.getPackage());
    paramContext.startActivity(parame1);
    AppMethodBeat.o(9828);
  }
  
  protected final String getPackageName()
  {
    AppMethodBeat.i(156885);
    String str = a.a.vKe.getPackage();
    AppMethodBeat.o(156885);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.j.b
 * JD-Core Version:    0.7.0.1
 */