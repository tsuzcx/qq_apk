package com.tencent.xweb.x5;

import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.xweb.e;

public final class g$g
  extends e
{
  public JsPromptResult xkx;
  
  public g$g(JsPromptResult paramJsPromptResult)
  {
    this.xkx = paramJsPromptResult;
  }
  
  public final void cancel()
  {
    this.xkx.cancel();
  }
  
  public final void confirm()
  {
    this.xkx.confirm();
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.x5.g.g
 * JD-Core Version:    0.7.0.1
 */