package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

public class JsError
{
  private final IX5JsError a;
  
  protected JsError(IX5JsError paramIX5JsError)
  {
    this.a = paramIX5JsError;
  }
  
  public String getMessage()
  {
    AppMethodBeat.i(54872);
    String str = this.a.getMessage();
    AppMethodBeat.o(54872);
    return str;
  }
  
  public String getStack()
  {
    AppMethodBeat.i(54873);
    String str = this.a.getStack();
    AppMethodBeat.o(54873);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsError
 * JD-Core Version:    0.7.0.1
 */