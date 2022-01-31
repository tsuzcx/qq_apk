package com.tencent.ttpic;

public class SupportedFilters
{
  private static final int[] mIds = { 0, 289 };
  private static final String[] mNames = { "无", "清逸" };
  
  public static int getFilterByIndex(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= mIds.length)) {
      throw new IndexOutOfBoundsException("filter index " + paramInt + " out of bound (0~" + (mIds.length - 1) + ")");
    }
    return mIds[paramInt];
  }
  
  public static String getFilterNameById(int paramInt)
  {
    if (isSupportedFilterId(paramInt))
    {
      int i = 0;
      while (i < mIds.length)
      {
        if (paramInt == mIds[i]) {
          return mNames[i];
        }
        i += 1;
      }
      return "";
    }
    return "";
  }
  
  public static String getFilterNameByIndex(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= mNames.length)) {
      throw new IndexOutOfBoundsException("filter index " + paramInt + " out of bound (0~" + (mNames.length - 1) + ")");
    }
    return mNames[paramInt];
  }
  
  public static int getSupportedFilterNum()
  {
    return mIds.length;
  }
  
  public static boolean isSupportedFilterId(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = mIds;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.SupportedFilters
 * JD-Core Version:    0.7.0.1
 */