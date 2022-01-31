package com.tencent.tinker.loader.hotplug;

import java.util.HashMap;
import java.util.Map;

public class ActivityStubManager
{
  private static Map<String, String> Bua = new HashMap();
  private static final int[] Bub = { 10, 3 };
  private static final int[] Buc = { 10, 3 };
  private static final int[] Bud = { 10, 3 };
  private static final int[] Bue = { 10, 3 };
  private static final int[] Buf = { 0, 0 };
  private static final int[] Bug = { 0, 0 };
  private static final int[] Buh = { 0, 0 };
  private static final int[] Bui = { 0, 0 };
  
  private ActivityStubManager()
  {
    throw new UnsupportedOperationException();
  }
  
  public static String y(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = (String)Bua.get(paramString);
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
      str = ActivityStubs.Buk;
      arrayOfInt2 = Buf;
      arrayOfInt1 = Bub;
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
      Bua.put(paramString, str);
      return str;
      str = ActivityStubs.Bul;
      arrayOfInt2 = Bug;
      arrayOfInt1 = Buc;
      break;
      str = ActivityStubs.Bum;
      arrayOfInt2 = Buh;
      arrayOfInt1 = Bud;
      break;
      str = ActivityStubs.Bun;
      arrayOfInt2 = Bui;
      arrayOfInt1 = Bue;
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