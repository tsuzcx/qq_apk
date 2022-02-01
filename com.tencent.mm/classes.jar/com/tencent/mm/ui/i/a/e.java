package com.tencent.mm.ui.i.a;

public final class e
  extends Throwable
{
  public String XHd;
  public int mErrorCode = 0;
  
  public e(String paramString)
  {
    super(paramString);
  }
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
    this.XHd = paramString2;
    this.mErrorCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.i.a.e
 * JD-Core Version:    0.7.0.1
 */