package com.tencent.tinker.a.b.b;

public final class a
{
  public static String SJ(int paramInt)
  {
    char[] arrayOfChar = new char[8];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 8)
    {
      arrayOfChar[(7 - paramInt)] = Character.forDigit(i & 0xF, 16);
      i >>= 4;
      paramInt += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String SK(int paramInt)
  {
    char[] arrayOfChar = new char[4];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 4)
    {
      arrayOfChar[(3 - paramInt)] = Character.forDigit(i & 0xF, 16);
      i >>= 4;
      paramInt += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String SL(int paramInt)
  {
    if (paramInt == (char)paramInt) {
      return SK(paramInt);
    }
    return SJ(paramInt);
  }
  
  public static String SM(int paramInt)
  {
    int i = 0;
    char[] arrayOfChar = new char[9];
    if (paramInt < 0)
    {
      arrayOfChar[0] = '-';
      paramInt = -paramInt;
    }
    while (i < 8)
    {
      arrayOfChar[(8 - i)] = Character.forDigit(paramInt & 0xF, 16);
      paramInt >>= 4;
      i += 1;
      continue;
      arrayOfChar[0] = '+';
    }
    return new String(arrayOfChar);
  }
  
  public static String pc(long paramLong)
  {
    char[] arrayOfChar = new char[16];
    int i = 0;
    while (i < 16)
    {
      arrayOfChar[(15 - i)] = Character.forDigit((int)paramLong & 0xF, 16);
      paramLong >>= 4;
      i += 1;
    }
    return new String(arrayOfChar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */