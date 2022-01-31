package com.tencent.xweb.xwalk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.i;
import com.tencent.xweb.m;
import org.xwalk.core.XWalkJavascriptResult;

public final class f
{
  public static final class e
    extends i
  {
    public XWalkJavascriptResult BJA;
    
    public e(XWalkJavascriptResult paramXWalkJavascriptResult)
    {
      this.BJA = paramXWalkJavascriptResult;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(85224);
      this.BJA.cancel();
      AppMethodBeat.o(85224);
    }
    
    public final void confirm()
    {
      AppMethodBeat.i(85223);
      this.BJA.confirm();
      AppMethodBeat.o(85223);
    }
    
    public final void confirmWithResult(String paramString)
    {
      AppMethodBeat.i(85222);
      this.BJA.confirmWithResult(paramString);
      AppMethodBeat.o(85222);
    }
  }
  
  public static final class h
    implements m
  {
    ValueCallback<Boolean> BJC;
    
    public h(ValueCallback<Boolean> paramValueCallback)
    {
      this.BJC = paramValueCallback;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(85228);
      this.BJC.onReceiveValue(Boolean.FALSE);
      AppMethodBeat.o(85228);
    }
    
    public final void proceed()
    {
      AppMethodBeat.i(85227);
      this.BJC.onReceiveValue(Boolean.TRUE);
      AppMethodBeat.o(85227);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.f
 * JD-Core Version:    0.7.0.1
 */