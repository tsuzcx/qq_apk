package com.tencent.mm.pluginsdk.j.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class f
  extends IOException
{
  public final IOException EQu;
  public final int httpStatusCode;
  
  public f(int paramInt, IOException paramIOException)
  {
    this.httpStatusCode = paramInt;
    this.EQu = paramIOException;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(152010);
    String str = "UnknownConnectionError{httpStatusCode=" + this.httpStatusCode + ", realException=" + this.EQu + '}';
    AppMethodBeat.o(152010);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.b.f
 * JD-Core Version:    0.7.0.1
 */