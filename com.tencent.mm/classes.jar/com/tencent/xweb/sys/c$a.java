package com.tencent.xweb.sys;

import android.webkit.SslErrorHandler;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.r;

@JgClassChecked(author=20001, fComment="checked", lastDate="20171024", reviewer=20001, vComment={com.jg.EType.JSEXECUTECHECK})
public final class c$a
  implements r
{
  SslErrorHandler SDW;
  
  public c$a(SslErrorHandler paramSslErrorHandler)
  {
    this.SDW = paramSslErrorHandler;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(153658);
    this.SDW.cancel();
    AppMethodBeat.o(153658);
  }
  
  public final void proceed()
  {
    AppMethodBeat.i(153657);
    this.SDW.proceed();
    AppMethodBeat.o(153657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.sys.c.a
 * JD-Core Version:    0.7.0.1
 */