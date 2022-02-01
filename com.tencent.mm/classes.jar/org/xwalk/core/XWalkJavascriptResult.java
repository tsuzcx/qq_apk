package org.xwalk.core;

public abstract interface XWalkJavascriptResult
{
  public abstract void cancel();
  
  public abstract void confirm();
  
  public abstract void confirmWithResult(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkJavascriptResult
 * JD-Core Version:    0.7.0.1
 */