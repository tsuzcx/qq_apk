package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class SystemWebViewClient$b
  implements com.tencent.smtt.export.external.interfaces.HttpAuthHandler
{
  private android.webkit.HttpAuthHandler a;
  
  SystemWebViewClient$b(android.webkit.HttpAuthHandler paramHttpAuthHandler)
  {
    this.a = paramHttpAuthHandler;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(54323);
    this.a.cancel();
    AppMethodBeat.o(54323);
  }
  
  public void proceed(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54322);
    this.a.proceed(paramString1, paramString2);
    AppMethodBeat.o(54322);
  }
  
  public boolean useHttpAuthUsernamePassword()
  {
    AppMethodBeat.i(54324);
    boolean bool = this.a.useHttpAuthUsernamePassword();
    AppMethodBeat.o(54324);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.b
 * JD-Core Version:    0.7.0.1
 */