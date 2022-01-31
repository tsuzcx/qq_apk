package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class SystemWebChromeClient$a
  implements com.tencent.smtt.export.external.interfaces.ConsoleMessage
{
  private com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel a;
  private String b;
  private String c;
  private int d;
  
  SystemWebChromeClient$a(android.webkit.ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(64162);
    this.a = com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel.valueOf(paramConsoleMessage.messageLevel().name());
    this.b = paramConsoleMessage.message();
    this.c = paramConsoleMessage.sourceId();
    this.d = paramConsoleMessage.lineNumber();
    AppMethodBeat.o(64162);
  }
  
  SystemWebChromeClient$a(String paramString1, String paramString2, int paramInt)
  {
    this.a = com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel.LOG;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt;
  }
  
  public int lineNumber()
  {
    return this.d;
  }
  
  public String message()
  {
    return this.b;
  }
  
  public com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel messageLevel()
  {
    return this.a;
  }
  
  public String sourceId()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.a
 * JD-Core Version:    0.7.0.1
 */