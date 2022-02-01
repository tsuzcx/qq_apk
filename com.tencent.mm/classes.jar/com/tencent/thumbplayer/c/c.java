package com.tencent.thumbplayer.c;

final class c
{
  public static String RYP = "base_video";
  private static int RYQ = 0;
  private static int RYR = 0;
  private static int RYS = 0;
  
  static int arm(int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = RYS;
      RYS = paramInt + 1;
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramInt = RYQ;
      RYQ = paramInt + 1;
      return paramInt;
    }
    if (paramInt == 3)
    {
      paramInt = RYR;
      RYR = paramInt + 1;
      return paramInt;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.c.c
 * JD-Core Version:    0.7.0.1
 */