package com.tencent.tinker.loader.hotplug;

import java.util.HashMap;
import java.util.Map;

public class ActivityStubManager
{
  private static final int[] wXA = { 10, 3 };
  private static final int[] wXB = { 0, 0 };
  private static final int[] wXC = { 0, 0 };
  private static final int[] wXD = { 0, 0 };
  private static final int[] wXE = { 0, 0 };
  private static Map<String, String> wXw = new HashMap();
  private static final int[] wXx = { 10, 3 };
  private static final int[] wXy = { 10, 3 };
  private static final int[] wXz = { 10, 3 };
  
  private ActivityStubManager()
  {
    throw new UnsupportedOperationException();
  }
  
  public static String u(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = (String)wXw.get(paramString);
    if (str != null) {
      return str;
    }
    int[] arrayOfInt2;
    int[] arrayOfInt1;
    label91:
    int i;
    switch (paramInt)
    {
    default: 
      str = ActivityStubs.wXG;
      arrayOfInt2 = wXB;
      arrayOfInt1 = wXx;
      if (paramBoolean)
      {
        str = str + "_T";
        paramInt = 1;
        i = arrayOfInt2[paramInt];
        arrayOfInt2[paramInt] = (i + 1);
        if (i < arrayOfInt1[paramInt]) {
          break label210;
        }
        arrayOfInt2[paramInt] = 0;
      }
      break;
    }
    label210:
    for (paramInt = 0;; paramInt = i)
    {
      str = String.format(str, new Object[] { Integer.valueOf(paramInt) });
      wXw.put(paramString, str);
      return str;
      str = ActivityStubs.wXH;
      arrayOfInt2 = wXC;
      arrayOfInt1 = wXy;
      break;
      str = ActivityStubs.wXI;
      arrayOfInt2 = wXD;
      arrayOfInt1 = wXz;
      break;
      str = ActivityStubs.wXJ;
      arrayOfInt2 = wXE;
      arrayOfInt1 = wXA;
      break;
      paramInt = 0;
      break label91;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.ActivityStubManager
 * JD-Core Version:    0.7.0.1
 */