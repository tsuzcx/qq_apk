package com.tencent.xweb.sys;

import android.webkit.SslErrorHandler;
import com.jg.JgClassChecked;
import com.tencent.xweb.h;

@JgClassChecked(author=30, fComment="checked", lastDate="20171024", reviewer=30, vComment={com.jg.EType.JSEXECUTECHECK})
public final class c$a
  implements h
{
  SslErrorHandler xjD;
  
  public c$a(SslErrorHandler paramSslErrorHandler)
  {
    this.xjD = paramSslErrorHandler;
  }
  
  public final void cancel()
  {
    this.xjD.cancel();
  }
  
  public final void proceed()
  {
    this.xjD.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.c.a
 * JD-Core Version:    0.7.0.1
 */