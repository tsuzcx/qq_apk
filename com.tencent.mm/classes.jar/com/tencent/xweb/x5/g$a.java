package com.tencent.xweb.x5;

import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.xweb.h;

public final class g$a
  implements h
{
  SslErrorHandler xks;
  
  public g$a(SslErrorHandler paramSslErrorHandler)
  {
    this.xks = paramSslErrorHandler;
  }
  
  public final void cancel()
  {
    this.xks.cancel();
  }
  
  public final void proceed()
  {
    this.xks.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.x5.g.a
 * JD-Core Version:    0.7.0.1
 */