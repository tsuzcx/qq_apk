package com.tencent.xweb.x5;

import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.xweb.f;

public final class g$f
  extends f
{
  public JsResult xkw;
  
  public g$f(JsResult paramJsResult)
  {
    this.xkw = paramJsResult;
  }
  
  public final void cancel()
  {
    this.xkw.cancel();
  }
  
  public final void confirm()
  {
    this.xkw.confirm();
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.g.f
 * JD-Core Version:    0.7.0.1
 */