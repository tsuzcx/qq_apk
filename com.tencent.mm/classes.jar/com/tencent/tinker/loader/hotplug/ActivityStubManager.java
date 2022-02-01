package com.tencent.tinker.loader.hotplug;

import java.util.HashMap;
import java.util.Map;

public class ActivityStubManager
{
  private static final int[] NEXT_SINGLEINSTANCE_STUB_IDX_SLOTS = { 0, 0 };
  private static final int[] NEXT_SINGLETASK_STUB_IDX_SLOTS;
  private static final int[] NEXT_SINGLETOP_STUB_IDX_SLOTS;
  private static final int[] NEXT_STANDARD_STUB_IDX_SLOTS;
  private static final int NOTRANSPARENT_SLOT_INDEX = 0;
  private static final int[] SINGLEINSTANCE_STUB_COUNT_SLOTS;
  private static final int[] SINGLETASK_STUB_COUNT_SLOTS;
  private static final int[] SINGLETOP_STUB_COUNT_SLOTS;
  private static final int[] STANDARD_STUB_COUNT_SLOTS;
  private static final String TAG = "Tinker.ActivityStubManager";
  private static final int TRANSPARENT_SLOT_INDEX = 1;
  private static Map<String, String> sTargetToStubClassNameMap = new HashMap();
  
  static
  {
    STANDARD_STUB_COUNT_SLOTS = new int[] { 10, 3 };
    SINGLETOP_STUB_COUNT_SLOTS = new int[] { 10, 3 };
    SINGLETASK_STUB_COUNT_SLOTS = new int[] { 10, 3 };
    SINGLEINSTANCE_STUB_COUNT_SLOTS = new int[] { 10, 3 };
    NEXT_STANDARD_STUB_IDX_SLOTS = new int[] { 0, 0 };
    NEXT_SINGLETOP_STUB_IDX_SLOTS = new int[] { 0, 0 };
    NEXT_SINGLETASK_STUB_IDX_SLOTS = new int[] { 0, 0 };
  }
  
  private ActivityStubManager()
  {
    throw new UnsupportedOperationException();
  }
  
  public static String assignStub(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = (String)sTargetToStubClassNameMap.get(paramString);
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
      str = ActivityStubs.STARDARD_STUB_CLASSNAME_FORMAT;
      arrayOfInt2 = NEXT_STANDARD_STUB_IDX_SLOTS;
      arrayOfInt1 = STANDARD_STUB_COUNT_SLOTS;
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
      sTargetToStubClassNameMap.put(paramString, str);
      return str;
      str = ActivityStubs.SINGLETOP_STUB_CLASSNAME_FORMAT;
      arrayOfInt2 = NEXT_SINGLETOP_STUB_IDX_SLOTS;
      arrayOfInt1 = SINGLETOP_STUB_COUNT_SLOTS;
      break;
      str = ActivityStubs.SINGLETASK_STUB_CLASSNAME_FORMAT;
      arrayOfInt2 = NEXT_SINGLETASK_STUB_IDX_SLOTS;
      arrayOfInt1 = SINGLETASK_STUB_COUNT_SLOTS;
      break;
      str = ActivityStubs.SINGLEINSTANCE_STUB_CLASSNAME_FORMAT;
      arrayOfInt2 = NEXT_SINGLEINSTANCE_STUB_IDX_SLOTS;
      arrayOfInt1 = SINGLEINSTANCE_STUB_COUNT_SLOTS;
      break;
      paramInt = 0;
      break label91;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.ActivityStubManager
 * JD-Core Version:    0.7.0.1
 */