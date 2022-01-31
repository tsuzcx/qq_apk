package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
    if (paramContext == null)
    {
      super.a(paramContext, parame1, parame2, paramString);
      return;
    }
    parame1 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=1&style=2", new Object[] { "MicroMessager", Double.valueOf(parame2.latitude), Double.valueOf(parame2.longitude) })));
    parame1.addCategory("android.intent.category.DEFAULT");
    parame1.setPackage(a.a.rTg.getPackage());
    paramContext.startActivity(parame1);
  }
  
  protected final String getPackageName()
  {
    return a.a.rTg.getPackage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.j.b
 * JD-Core Version:    0.7.0.1
 */