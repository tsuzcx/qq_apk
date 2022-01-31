package com.tencent.mm.pluginsdk.g.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class f
  extends IOException
{
  public final int httpStatusCode;
  public final IOException vOc;
  
  public f(int paramInt, IOException paramIOException)
  {
    this.httpStatusCode = paramInt;
    this.vOc = paramIOException;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(79566);
    String str = "UnknownConnectionError{httpStatusCode=" + this.httpStatusCode + ", realException=" + this.vOc + '}';
    AppMethodBeat.o(79566);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.b.f
 * JD-Core Version:    0.7.0.1
 */