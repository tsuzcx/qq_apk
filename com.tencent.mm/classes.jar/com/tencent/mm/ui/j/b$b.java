package com.tencent.mm.ui.j;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.w;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
final class b$b
  extends w
{
  boolean Aon = true;
  
  private b$b(b paramb) {}
  
  private static Bundle auK(String paramString)
  {
    AppMethodBeat.i(80365);
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        localBundle.putString(URLDecoder.decode(arrayOfString[0]), URLDecoder.decode(arrayOfString[1]));
        i += 1;
      }
    }
    AppMethodBeat.o(80365);
    return localBundle;
  }
  
  private static Bundle auL(String paramString)
  {
    AppMethodBeat.i(80366);
    paramString = paramString.replace("wechatapp", "http");
    try
    {
      paramString = new URL(paramString);
      Bundle localBundle = auK(paramString.getQuery());
      localBundle.putAll(auK(paramString.getRef()));
      AppMethodBeat.o(80366);
      return localBundle;
    }
    catch (MalformedURLException paramString)
    {
      paramString = new Bundle();
      AppMethodBeat.o(80366);
    }
    return paramString;
  }
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(80362);
    super.a(paramWebView, paramInt, paramString1, paramString2);
    this.Aon = false;
    paramWebView = b.a(this.ABp);
    new com.tencent.mm.ui.g.a.b(paramString1, paramInt, paramString2);
    paramWebView.dOz();
    try
    {
      this.ABp.dismiss();
      b.b(this.ABp).dismiss();
      AppMethodBeat.o(80362);
      return;
    }
    catch (Exception paramWebView)
    {
      ab.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
      AppMethodBeat.o(80362);
    }
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(80361);
    ab.d("Twitter-WebView", "Redirect URL: ".concat(String.valueOf(paramString)));
    if (paramString.startsWith("wechatapp://sign-in-twitter.wechatapp.com/"))
    {
      paramWebView = auL(paramString);
      if (paramWebView.getString("denied") == null) {
        b.a(this.ABp).u(paramWebView);
      }
      for (;;)
      {
        this.ABp.dismiss();
        AppMethodBeat.o(80361);
        return true;
        b.a(this.ABp).onCancel();
      }
    }
    this.ABp.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
    AppMethodBeat.o(80361);
    return true;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(80364);
    super.b(paramWebView, paramString);
    this.Aon = false;
    try
    {
      b.b(this.ABp).dismiss();
      b.c(this.ABp).setBackgroundColor(0);
      b.d(this.ABp).setVisibility(0);
      b.e(this.ABp).setVisibility(0);
      AppMethodBeat.o(80364);
      return;
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
      }
    }
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(80363);
    ab.d("Twitter-WebView", "Webview loading URL: ".concat(String.valueOf(paramString)));
    super.b(paramWebView, paramString, paramBitmap);
    try
    {
      b.b(this.ABp).show();
      b.b(this.ABp).setOnDismissListener(new b.b.1(this));
      AppMethodBeat.o(80363);
      return;
    }
    catch (Exception paramWebView)
    {
      ab.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
      AppMethodBeat.o(80363);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.j.b.b
 * JD-Core Version:    0.7.0.1
 */