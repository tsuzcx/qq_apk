package com.tencent.wework.api.utils;

class Log$WWAPILogger
  implements Log.ILogger
{
  Log.ILogger xgh;
  
  Log$WWAPILogger(Log.ILogger paramILogger)
  {
    this.xgh = paramILogger;
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    this.xgh.a(paramInt, "WWAPI-" + paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wework.api.utils.Log.WWAPILogger
 * JD-Core Version:    0.7.0.1
 */