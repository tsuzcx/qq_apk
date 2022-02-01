package com.tencent.thumbplayer.c;

final class c
{
  private static int ZBA = 0;
  private static int ZBB = 0;
  private static int ZBC = 0;
  public static String ZBz = "base_video";
  
  static int aAZ(int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = ZBC;
      ZBC = paramInt + 1;
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramInt = ZBA;
      ZBA = paramInt + 1;
      return paramInt;
    }
    if (paramInt == 3)
    {
      paramInt = ZBB;
      ZBB = paramInt + 1;
      return paramInt;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.c.c
 * JD-Core Version:    0.7.0.1
 */