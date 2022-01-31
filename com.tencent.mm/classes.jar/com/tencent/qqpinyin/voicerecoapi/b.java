package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends Exception
{
  private String hBF;
  private int mErrorCode;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(35441);
    this.hBF = "";
    this.mErrorCode = paramInt;
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknown error";
    }
    for (;;)
    {
      this.hBF = str;
      new StringBuilder("errorCode: ").append(this.mErrorCode).append("\t msg: ").append(this.hBF);
      AppMethodBeat.o(35441);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.b
 * JD-Core Version:    0.7.0.1
 */