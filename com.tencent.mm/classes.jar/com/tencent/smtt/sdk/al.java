package com.tencent.smtt.sdk;

import android.os.HandlerThread;

class al
  extends HandlerThread
{
  private static al a;
  
  public al(String paramString)
  {
    super(paramString);
  }
  
  public static al a()
  {
    try
    {
      if (a == null)
      {
        localal = new al("TbsHandlerThread");
        a = localal;
        localal.start();
      }
      al localal = a;
      return localal;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.al
 * JD-Core Version:    0.7.0.1
 */