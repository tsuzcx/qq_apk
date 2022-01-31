package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class bx
  extends Thread
{
  bx(WebView paramWebView, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    AppMethodBeat.i(139432);
    try
    {
      this.a.a();
      AppMethodBeat.o(139432);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(139432);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.bx
 * JD-Core Version:    0.7.0.1
 */