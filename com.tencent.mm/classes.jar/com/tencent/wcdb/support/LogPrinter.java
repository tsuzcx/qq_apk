package com.tencent.wcdb.support;

import android.util.Printer;

public class LogPrinter
  implements Printer
{
  private final int mPriority;
  private final String mTag;
  
  public LogPrinter(int paramInt, String paramString)
  {
    this.mPriority = paramInt;
    this.mTag = paramString;
  }
  
  public void println(String paramString)
  {
    Log.println(this.mPriority, this.mTag, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.LogPrinter
 * JD-Core Version:    0.7.0.1
 */