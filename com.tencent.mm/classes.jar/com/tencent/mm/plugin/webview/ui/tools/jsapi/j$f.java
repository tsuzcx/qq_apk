package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

abstract class j$f
{
  protected void a(Context paramContext, j.e parame1, j.e parame2, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    parame1 = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + parame2.latitude + "," + parame2.longitude));
    parame1.setPackage(getPackageName());
    parame1.addFlags(268435456);
    paramContext.startActivity(parame1);
  }
  
  protected abstract String getPackageName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.j.f
 * JD-Core Version:    0.7.0.1
 */