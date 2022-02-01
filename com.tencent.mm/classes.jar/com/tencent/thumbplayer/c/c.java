package com.tencent.thumbplayer.c;

final class c
{
  public static String ahGC = "base_video";
  private static int ahGD = 0;
  private static int ahGE = 0;
  private static int ahGF = 0;
  
  static int aHM(int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = ahGF;
      ahGF = paramInt + 1;
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramInt = ahGD;
      ahGD = paramInt + 1;
      return paramInt;
    }
    if (paramInt == 3)
    {
      paramInt = ahGE;
      ahGE = paramInt + 1;
      return paramInt;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.c.c
 * JD-Core Version:    0.7.0.1
 */