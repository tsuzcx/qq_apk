package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebViewDatabase
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
      AppMethodBeat.i(65034);
      if (a == null) {
        a = new WebViewDatabase(paramContext);
      }
      paramContext = a;
      AppMethodBeat.o(65034);
      return paramContext;
    }
    finally {}
  }
  
  public static WebViewDatabase getInstance(Context paramContext)
  {
    AppMethodBeat.i(65033);
    paramContext = a(paramContext);
    AppMethodBeat.o(65033);
    return paramContext;
  }
  
  public void clearFormData()
  {
    AppMethodBeat.i(65040);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().g(this.b);
      AppMethodBeat.o(65040);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearFormData();
    AppMethodBeat.o(65040);
  }
  
  public void clearHttpAuthUsernamePassword()
  {
    AppMethodBeat.i(65038);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().e(this.b);
      AppMethodBeat.o(65038);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearHttpAuthUsernamePassword();
    AppMethodBeat.o(65038);
  }
  
  @Deprecated
  public void clearUsernamePassword()
  {
    AppMethodBeat.i(65036);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().c(this.b);
      AppMethodBeat.o(65036);
      return;
    }
    android.webkit.WebViewDatabase.getInstance(this.b).clearUsernamePassword();
    AppMethodBeat.o(65036);
  }
  
  public boolean hasFormData()
  {
    AppMethodBeat.i(65039);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().f(this.b);
      AppMethodBeat.o(65039);
      return bool;
    }
    boolean bool = android.webkit.WebViewDatabase.getInstance(this.b).hasFormData();
    AppMethodBeat.o(65039);
    return bool;
  }
  
  public boolean hasHttpAuthUsernamePassword()
  {
    AppMethodBeat.i(65037);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().d(this.b);
      AppMethodBeat.o(65037);
      return bool;
    }
    boolean bool = android.webkit.WebViewDatabase.getInstance(this.b).hasHttpAuthUsernamePassword();
    AppMethodBeat.o(65037);
    return bool;
  }
  
  @Deprecated
  public boolean hasUsernamePassword()
  {
    AppMethodBeat.i(65035);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      bool = localbz.c().b(this.b);
      AppMethodBeat.o(65035);
      return bool;
    }
    boolean bool = android.webkit.WebViewDatabase.getInstance(this.b).hasUsernamePassword();
    AppMethodBeat.o(65035);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebViewDatabase
 * JD-Core Version:    0.7.0.1
 */