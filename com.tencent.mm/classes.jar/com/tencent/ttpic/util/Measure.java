package com.tencent.ttpic.util;

import android.os.SystemClock;

public class Measure
{
  private static long start;
  
  public static long cost()
  {
    return SystemClock.elapsedRealtime() - start;
  }
  
  public static boolean start()
  {
    start = SystemClock.elapsedRealtime();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.Measure
 * JD-Core Version:    0.7.0.1
 */