package com.tencent.mm.ui.i;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.JSEXECUTECHECK})
final class b$b
  extends p
{
  boolean vWf = true;
  
  private b$b(b paramb) {}
  
  private static Bundle aec(String paramString)
  {
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
    return localBundle;
  }
  
  private static Bundle aed(String paramString)
  {
    paramString = paramString.replace("wechatapp", "http");
    try
    {
      paramString = new URL(paramString);
      Bundle localBundle = aec(paramString.getQuery());
      localBundle.putAll(aec(paramString.getRef()));
      return localBundle;
    }
    catch (MalformedURLException paramString) {}
    return new Bundle();
  }
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    this.vWf = false;
    paramWebView = b.a(this.wiv);
    new com.tencent.mm.ui.f.a.b(paramString1, paramInt, paramString2);
    paramWebView.cJK();
    try
    {
      this.wiv.dismiss();
      b.b(this.wiv).dismiss();
      return;
    }
    catch (Exception paramWebView)
    {
      y.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
    }
  }
  
  public final void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    this.vWf = false;
    try
    {
      b.b(this.wiv).dismiss();
      b.c(this.wiv).setBackgroundColor(0);
      b.d(this.wiv).setVisibility(0);
      b.e(this.wiv).setVisibility(0);
      return;
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
      }
    }
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    y.d("Twitter-WebView", "Webview loading URL: " + paramString);
    super.b(paramWebView, paramString, paramBitmap);
    try
    {
      b.b(this.wiv).show();
      b.b(this.wiv).setOnDismissListener(new b.b.1(this));
      return;
    }
    catch (Exception paramWebView)
    {
      y.printErrStackTrace("MicroMsg.TwitterDialog", paramWebView, "", new Object[0]);
    }
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    y.d("Twitter-WebView", "Redirect URL: " + paramString);
    if (paramString.startsWith("wechatapp://sign-in-twitter.wechatapp.com/"))
    {
      paramWebView = aed(paramString);
      if (paramWebView.getString("denied") == null) {
        b.a(this.wiv).l(paramWebView);
      }
      for (;;)
      {
        this.wiv.dismiss();
        return true;
        b.a(this.wiv).onCancel();
      }
    }
    this.wiv.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.i.b.b
 * JD-Core Version:    0.7.0.1
 */