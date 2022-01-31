package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class bs
  extends Thread
{
  bs(WebView paramWebView, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    AppMethodBeat.i(139427);
    this.a.tbsWebviewDestroy(false);
    AppMethodBeat.o(139427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.bs
 * JD-Core Version:    0.7.0.1
 */