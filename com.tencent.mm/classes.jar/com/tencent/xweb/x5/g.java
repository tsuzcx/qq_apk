package com.tencent.xweb.x5;

import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.xweb.m;
import com.tencent.xweb.s;

@JgClassChecked(author=30, fComment="checked", lastDate="20171020", reviewer=30, vComment={com.jg.EType.JSEXECUTECHECK})
public final class g
{
  public static s a(WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(84834);
    if (paramWebResourceResponse == null)
    {
      AppMethodBeat.o(84834);
      return null;
    }
    paramWebResourceResponse = new s(paramWebResourceResponse.getMimeType(), paramWebResourceResponse.getEncoding(), paramWebResourceResponse.getStatusCode(), paramWebResourceResponse.getReasonPhrase(), paramWebResourceResponse.getResponseHeaders(), paramWebResourceResponse.getData());
    AppMethodBeat.o(84834);
    return paramWebResourceResponse;
  }
  
  public static final class a
    implements m
  {
    SslErrorHandler BHX;
    
    public a(SslErrorHandler paramSslErrorHandler)
    {
      this.BHX = paramSslErrorHandler;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(84823);
      this.BHX.cancel();
      AppMethodBeat.o(84823);
    }
    
    public final void proceed()
    {
      AppMethodBeat.i(84822);
      this.BHX.proceed();
      AppMethodBeat.o(84822);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.x5.g
 * JD-Core Version:    0.7.0.1
 */