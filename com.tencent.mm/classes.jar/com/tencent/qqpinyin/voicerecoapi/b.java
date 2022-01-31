package com.tencent.qqpinyin.voicerecoapi;

public final class b
  extends Exception
{
  private String gio = "";
  private int mErrorCode;
  
  public b(int paramInt)
  {
    this.mErrorCode = paramInt;
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknown error";
    }
    for (;;)
    {
      this.gio = str;
      new StringBuilder("errorCode: ").append(this.mErrorCode).append("\t msg: ").append(this.gio);
      return;
      str = "speex engine error";
      continue;
      str = "out of memory";
      continue;
      str = "should init at first";
      continue;
      str = "already init";
      continue;
      str = "null param or 0 length";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.b
 * JD-Core Version:    0.7.0.1
 */