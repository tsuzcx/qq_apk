package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class JSONException
  extends RuntimeException
{
  private static final long serialVersionUID = 0L;
  private Throwable cause;
  
  public JSONException(String paramString)
  {
    super(paramString);
  }
  
  public JSONException(Throwable paramThrowable)
  {
    super(paramThrowable.getMessage());
    AppMethodBeat.i(50106);
    this.cause = paramThrowable;
    AppMethodBeat.o(50106);
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.json.JSONException
 * JD-Core Version:    0.7.0.1
 */