package com.tencent.xweb.x5;

import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.xweb.f;

public final class a$c
  implements JsResult
{
  public f xkk;
  
  public a$c(f paramf)
  {
    this.xkk = paramf;
  }
  
  public final void cancel()
  {
    this.xkk.cancel();
  }
  
  public final void confirm()
  {
    this.xkk.confirm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.x5.a.c
 * JD-Core Version:    0.7.0.1
 */