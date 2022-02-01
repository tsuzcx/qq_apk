package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebViewDB;

public class WebViewDatabase
  extends x
{
  private static WebViewDatabase a;
  private Context b;
  
  protected WebViewDatabase(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private static WebViewDatabase a(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(54355);
      if (a == null) {
        a = new WebViewDatabase(paramContext);
      }
      paramContext = a;
      AppMethodBeat.o(54355);
      return paramContext;
    }
    finally {}
  }
  
  public static WebViewDatabase getInstance(Context paramContext)
  {
    AppMethodBeat.i(54354);
    paramContext = a(paramContext);
    AppMethodBeat.o(54354);
    return paramContext;
  }
  
  public void clearFormData()
  {
    AppMethodBeat.i(54361);
    if (isX5Core())
    {
      getWebViewDBImpl().clearFormData(this.b);
      AppMethodBeat.o(54361);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearFormData();
    AppMethodBeat.o(54361);
  }
  
  public void clearHttpAuthUsernamePassword()
  {
    AppMethodBeat.i(54359);
    if (isX5Core())
    {
      getWebViewDBImpl().clearHttpAuthUsernamePassword(this.b);
      AppMethodBeat.o(54359);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearHttpAuthUsernamePassword();
    AppMethodBeat.o(54359);
  }
  
  @Deprecated
  public void clearUsernamePassword()
  {
    AppMethodBeat.i(54357);
    if (isX5Core())
    {
      getWebViewDBImpl().clearUsernamePassword(this.b);
      AppMethodBeat.o(54357);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearUsernamePassword();
    AppMethodBeat.o(54357);
  }
  
  public boolean hasFormData()
  {
    AppMethodBeat.i(54360);
    if (isX5Core())
    {
      bool = getWebViewDBImpl().hasFormData(this.b);
      AppMethodBeat.o(54360);
      return bool;
    }
    boolean bool = android.webkit.WebViewDatabase.getInstance(this.b).hasFormData();
    AppMethodBeat.o(54360);
    return bool;
  }
  
  public boolean hasHttpAuthUsernamePassword()
  {
    AppMethodBeat.i(54358);
    if (isX5Core())
    {
      bool = getWebViewDBImpl().hasHttpAuthUsernamePassword(this.b);
      AppMethodBeat.o(54358);
      return bool;
    }
    boolean bool = android.webkit.WebViewDatabase.getInstance(this.b).hasHttpAuthUsernamePassword();
    AppMethodBeat.o(54358);
    return bool;
  }
  
  @Deprecated
  public boolean hasUsernamePassword()
  {
    AppMethodBeat.i(54356);
    if (isX5Core())
    {
      bool = getWebViewDBImpl().hasUsernamePassword(this.b);
      AppMethodBeat.o(54356);
      return bool;
    }
    boolean bool = android.webkit.WebViewDatabase.getInstance(this.b).hasUsernamePassword();
    AppMethodBeat.o(54356);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebViewDatabase
 * JD-Core Version:    0.7.0.1
 */