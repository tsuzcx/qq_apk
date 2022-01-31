package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class ae$b
  implements com.tencent.smtt.export.external.interfaces.HttpAuthHandler
{
  private android.webkit.HttpAuthHandler a;
  
  ae$b(android.webkit.HttpAuthHandler paramHttpAuthHandler)
  {
    this.a = paramHttpAuthHandler;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(139149);
    this.a.cancel();
    AppMethodBeat.o(139149);
  }
  
  public void proceed(String paramString1, String paramString2)
  {
    AppMethodBeat.i(139148);
    this.a.proceed(paramString1, paramString2);
    AppMethodBeat.o(139148);
  }
  
  public boolean useHttpAuthUsernamePassword()
  {
    AppMethodBeat.i(139150);
    boolean bool = this.a.useHttpAuthUsernamePassword();
    AppMethodBeat.o(139150);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.ae.b
 * JD-Core Version:    0.7.0.1
 */