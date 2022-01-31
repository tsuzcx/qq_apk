package com.tencent.tencentmap.mapsdk.a;

import com.qq.jutil.j4log.Logger;

public class bc
{
  static final Logger a = Logger.getLogger("jceClient");
  static int b = 15;
  
  public static void a(String paramString)
  {
    a.info(paramString);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    a.info(paramString, paramThrowable);
  }
  
  public static void b(String paramString)
  {
    a.error(paramString);
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    a.error(paramString, paramThrowable);
  }
  
  public static void c(String paramString)
  {
    a.debug(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bc
 * JD-Core Version:    0.7.0.1
 */