package com.tencent.tinker.loader.hotplug;

import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static Map<String, String> akY = new HashMap();
  private static final int[] akZ = { 10, 3 };
  private static final int[] ala = { 10, 3 };
  private static final int[] alb = { 10, 3 };
  private static final int[] alc = { 10, 3 };
  private static final int[] ald = { 0, 0 };
  private static final int[] ale = { 0, 0 };
  private static final int[] alf = { 0, 0 };
  private static final int[] alg = { 0, 0 };
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = (String)akY.get(paramString);
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
      str = ActivityStubs.ali;
      arrayOfInt2 = ald;
      arrayOfInt1 = akZ;
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
      akY.put(paramString, str);
      return str;
      str = ActivityStubs.alj;
      arrayOfInt2 = ale;
      arrayOfInt1 = ala;
      break;
      str = ActivityStubs.alk;
      arrayOfInt2 = alf;
      arrayOfInt1 = alb;
      break;
      str = ActivityStubs.all;
      arrayOfInt2 = alg;
      arrayOfInt1 = alc;
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