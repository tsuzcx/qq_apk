package com.tencent.xweb.sys;

import android.webkit.JsResult;
import com.tencent.xweb.f;

public final class c$d
  extends f
{
  public JsResult xjG;
  
  public c$d(JsResult paramJsResult)
  {
    this.xjG = paramJsResult;
  }
  
  public final void cancel()
  {
    if (this.xjG != null) {
      this.xjG.cancel();
    }
  }
  
  public final void confirm()
  {
    if (this.xjG != null) {
      this.xjG.confirm();
    }
  }
  
  public final void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.sys.c.d
 * JD-Core Version:    0.7.0.1
 */