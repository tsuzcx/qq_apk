package com.tencent.xweb.xwalk;

import com.tencent.xweb.f;
import org.xwalk.core.XWalkJavascriptResult;

public final class e$c
  extends f
{
  public XWalkJavascriptResult xlS;
  
  public e$c(XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    this.xlS = paramXWalkJavascriptResult;
  }
  
  public final void cancel()
  {
    this.xlS.cancel();
  }
  
  public final void confirm()
  {
    this.xlS.confirm();
  }
  
  public final void confirmWithResult(String paramString)
  {
    this.xlS.confirmWithResult(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.e.c
 * JD-Core Version:    0.7.0.1
 */