package com.tencent.mm.ui.f.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

final class f$a
  extends p
{
  boolean vWf = true;
  
  private f$a(f paramf) {}
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    this.vWf = false;
    f.a(this.vWe).a(new b(paramString1, paramInt, paramString2));
    try
    {
      this.vWe.dismiss();
      f.b(this.vWe).dismiss();
      return;
    }
    catch (Exception paramWebView)
    {
      y.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
    }
  }
  
  public final void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    this.vWf = false;
    try
    {
      f.b(this.vWe).dismiss();
      f.c(this.vWe).setBackgroundColor(0);
      f.d(this.vWe).setVisibility(0);
      f.e(this.vWe).setVisibility(0);
      return;
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
      }
    }
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    y.d("Facebook-WebView", "Webview loading URL: " + paramString);
    super.b(paramWebView, paramString, paramBitmap);
    try
    {
      f.b(this.vWe).show();
      f.b(this.vWe).setOnDismissListener(new f.a.1(this));
      return;
    }
    catch (Exception paramWebView)
    {
      y.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
    }
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    y.d("Facebook-WebView", "Redirect URL: " + paramString);
    if (paramString.startsWith("fbconnect://success"))
    {
      Bundle localBundle = e.aed(paramString);
      paramString = localBundle.getString("error");
      paramWebView = paramString;
      if (paramString == null) {
        paramWebView = localBundle.getString("error_type");
      }
      if (paramWebView == null) {
        f.a(this.vWe).l(localBundle);
      }
      for (;;)
      {
        this.vWe.dismiss();
        return true;
        if ((paramWebView.equals("access_denied")) || (paramWebView.equals("OAuthAccessDeniedException"))) {
          f.a(this.vWe).onCancel();
        } else {
          f.a(this.vWe).a(new d(paramWebView));
        }
      }
    }
    if (paramString.startsWith("fbconnect://cancel"))
    {
      f.a(this.vWe).onCancel();
      try
      {
        this.vWe.dismiss();
        return true;
      }
      catch (Exception paramWebView)
      {
        y.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        return true;
      }
    }
    if (paramString.contains("touch")) {
      return false;
    }
    this.vWe.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.f.a.f.a
 * JD-Core Version:    0.7.0.1
 */