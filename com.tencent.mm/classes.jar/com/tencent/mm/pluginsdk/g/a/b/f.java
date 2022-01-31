package com.tencent.mm.pluginsdk.g.a.b;

import java.io.IOException;

public final class f
  extends IOException
{
  public final int httpStatusCode;
  public final IOException rXk;
  
  public f(int paramInt, IOException paramIOException)
  {
    this.httpStatusCode = paramInt;
    this.rXk = paramIOException;
  }
  
  public final String toString()
  {
    return "UnknownConnectionError{httpStatusCode=" + this.httpStatusCode + ", realException=" + this.rXk + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.b.f
 * JD-Core Version:    0.7.0.1
 */