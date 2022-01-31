package com.tencent.xweb.sys;

import android.webkit.SslErrorHandler;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.m;

@JgClassChecked(author=30, fComment="checked", lastDate="20171024", reviewer=30, vComment={com.jg.EType.JSEXECUTECHECK})
public final class c$a
  implements m
{
  SslErrorHandler BHi;
  
  public c$a(SslErrorHandler paramSslErrorHandler)
  {
    this.BHi = paramSslErrorHandler;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(84650);
    this.BHi.cancel();
    AppMethodBeat.o(84650);
  }
  
  public final void proceed()
  {
    AppMethodBeat.i(84649);
    this.BHi.proceed();
    AppMethodBeat.o(84649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.sys.c.a
 * JD-Core Version:    0.7.0.1
 */