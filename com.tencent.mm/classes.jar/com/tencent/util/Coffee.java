package com.tencent.util;

public class Coffee
{
  public static String cRi()
  {
    return getDESSignKey();
  }
  
  private static native String getDESSignKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.util.Coffee
 * JD-Core Version:    0.7.0.1
 */