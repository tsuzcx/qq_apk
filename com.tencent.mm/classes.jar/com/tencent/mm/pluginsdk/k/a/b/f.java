package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class f
  extends IOException
{
  public final IOException Ram;
  public final int httpStatusCode;
  
  public f(int paramInt, IOException paramIOException)
  {
    this.httpStatusCode = paramInt;
    this.Ram = paramIOException;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(152010);
    String str = "UnknownConnectionError{httpStatusCode=" + this.httpStatusCode + ", realException=" + this.Ram + '}';
    AppMethodBeat.o(152010);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.b.f
 * JD-Core Version:    0.7.0.1
 */