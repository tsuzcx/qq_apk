package com.tencent.tinker.loader.hotplug;

import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static final int[] aoA = { 10, 3 };
  private static final int[] aoB = { 10, 3 };
  private static final int[] aoC = { 10, 3 };
  private static final int[] aoD = { 0, 0 };
  private static final int[] aoE = { 0, 0 };
  private static final int[] aoF = { 0, 0 };
  private static final int[] aoG = { 0, 0 };
  private static Map<String, String> aoy = new HashMap();
  private static final int[] aoz = { 10, 3 };
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = (String)aoy.get(paramString);
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
      str = ActivityStubs.aoI;
      arrayOfInt2 = aoD;
      arrayOfInt1 = aoz;
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
      aoy.put(paramString, str);
      return str;
      str = ActivityStubs.aoJ;
      arrayOfInt2 = aoE;
      arrayOfInt1 = aoA;
      break;
      str = ActivityStubs.aoK;
      arrayOfInt2 = aoF;
      arrayOfInt1 = aoB;
      break;
      str = ActivityStubs.aoL;
      arrayOfInt2 = aoG;
      arrayOfInt1 = aoC;
      break;
      paramInt = 0;
      break label91;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.a
 * JD-Core Version:    0.7.0.1
 */