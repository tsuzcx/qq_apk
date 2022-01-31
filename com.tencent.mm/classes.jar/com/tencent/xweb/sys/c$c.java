package com.tencent.xweb.sys;

import android.webkit.JsPromptResult;
import com.tencent.xweb.e;

public final class c$c
  extends e
{
  public JsPromptResult xjF;
  
  public c$c(JsPromptResult paramJsPromptResult)
  {
    this.xjF = paramJsPromptResult;
  }
  
  public final void cancel()
  {
    if (this.xjF != null) {
      this.xjF.cancel();
    }
  }
  
  public final void confirm()
  {
    if (this.xjF != null) {
      this.xjF.confirm();
    }
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.c.c
 * JD-Core Version:    0.7.0.1
 */