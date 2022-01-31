package com.tencent.mm.ui.g.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.w;

final class g$a
  extends w
{
  boolean Aon = true;
  
  private g$a(g paramg) {}
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(80334);
    super.a(paramWebView, paramInt, paramString1, paramString2);
    this.Aon = false;
    g.a(this.Aom).a(new b(paramString1, paramInt, paramString2));
    try
    {
      this.Aom.dismiss();
      g.b(this.Aom).dismiss();
      AppMethodBeat.o(80334);
      return;
    }
    catch (Exception paramWebView)
    {
      ab.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
      AppMethodBeat.o(80334);
    }
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(80333);
    ab.d("Facebook-WebView", "Redirect URL: ".concat(String.valueOf(paramString)));
    if (paramString.startsWith("fbconnect://success"))
    {
      Bundle localBundle = f.auL(paramString);
      paramString = localBundle.getString("error");
      paramWebView = paramString;
      if (paramString == null) {
        paramWebView = localBundle.getString("error_type");
      }
      if (paramWebView == null) {
        g.a(this.Aom).u(localBundle);
      }
      for (;;)
      {
        this.Aom.dismiss();
        AppMethodBeat.o(80333);
        return true;
        if ((paramWebView.equals("access_denied")) || (paramWebView.equals("OAuthAccessDeniedException"))) {
          g.a(this.Aom).onCancel();
        } else {
          g.a(this.Aom).a(new e(paramWebView));
        }
      }
    }
    if (paramString.startsWith("fbconnect://cancel"))
    {
      g.a(this.Aom).onCancel();
      try
      {
        this.Aom.dismiss();
        AppMethodBeat.o(80333);
        return true;
      }
      catch (Exception paramWebView)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
        }
      }
    }
    if (paramString.contains("touch"))
    {
      AppMethodBeat.o(80333);
      return false;
    }
    this.Aom.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
    AppMethodBeat.o(80333);
    return true;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(80336);
    super.b(paramWebView, paramString);
    this.Aon = false;
    try
    {
      g.b(this.Aom).dismiss();
      g.c(this.Aom).setBackgroundColor(0);
      g.d(this.Aom).setVisibility(0);
      g.e(this.Aom).setVisibility(0);
      AppMethodBeat.o(80336);
      return;
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
      }
    }
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(80335);
    ab.d("Facebook-WebView", "Webview loading URL: ".concat(String.valueOf(paramString)));
    super.b(paramWebView, paramString, paramBitmap);
    try
    {
      g.b(this.Aom).show();
      g.b(this.Aom).setOnDismissListener(new g.a.1(this));
      AppMethodBeat.o(80335);
      return;
    }
    catch (Exception paramWebView)
    {
      ab.printErrStackTrace("MicroMsg.FbDialog", paramWebView, "", new Object[0]);
      AppMethodBeat.o(80335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.g.a
 * JD-Core Version:    0.7.0.1
 */