package com.tencent.ttpic.util;

import com.tencent.ttpic.config.BeautyRealConfig;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.filter.BeautyParam;
import com.tencent.ttpic.model.DistortParam;
import com.tencent.ttpic.model.DistortionItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BeautyRealUtil
{
  public static final BeautyParam EMPTY_PARAM = new BeautyParam(false);
  
  public static Map<BeautyRealConfig.TYPE, Integer> getBeautyLevels(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BeautyRealConfig.TYPE.BEAUTY, Integer.valueOf(60));
    BeautyRealConfig.TYPE[] arrayOfTYPE;
    int i;
    if (paramInt == BeautyRealConfig.TYPE.NONE.value)
    {
      localHashMap.put(BeautyRealConfig.TYPE.BEAUTY, Integer.valueOf(0));
      arrayOfTYPE = BeautyRealConfig.SINGLE_TRANS_TYPE;
      i = arrayOfTYPE.length;
      paramInt = 0;
      while (paramInt < i)
      {
        localHashMap.put(arrayOfTYPE[paramInt], Integer.valueOf(0));
        paramInt += 1;
      }
    }
    if (paramInt == BeautyRealConfig.TYPE.NATURE.value)
    {
      localHashMap.put(BeautyRealConfig.TYPE.FACE_SHORTEN, Integer.valueOf(20));
      localHashMap.put(BeautyRealConfig.TYPE.FACE_V, Integer.valueOf(40));
      localHashMap.put(BeautyRealConfig.TYPE.FACE_THIN, Integer.valueOf(40));
      localHashMap.put(BeautyRealConfig.TYPE.EYE, Integer.valueOf(50));
    }
    for (;;)
    {
      arrayOfTYPE = BeautyRealConfig.SINGLE_TRANS_TYPE;
      i = arrayOfTYPE.length;
      paramInt = 0;
      while (paramInt < i)
      {
        BeautyRealConfig.TYPE localTYPE = arrayOfTYPE[paramInt];
        if (!localHashMap.containsKey(localTYPE)) {
          localHashMap.put(localTYPE, Integer.valueOf(0));
        }
        paramInt += 1;
      }
      if (paramInt == BeautyRealConfig.TYPE.CUTE.value)
      {
        localHashMap.put(BeautyRealConfig.TYPE.FACE_SHORTEN, Integer.valueOf(80));
        localHashMap.put(BeautyRealConfig.TYPE.CHIN, Integer.valueOf(-20));
        localHashMap.put(BeautyRealConfig.TYPE.FACE_V, Integer.valueOf(50));
        localHashMap.put(BeautyRealConfig.TYPE.EYE, Integer.valueOf(100));
        localHashMap.put(BeautyRealConfig.TYPE.NOSE, Integer.valueOf(40));
      }
      else if (paramInt == BeautyRealConfig.TYPE.MELON.value)
      {
        localHashMap.put(BeautyRealConfig.TYPE.CHIN, Integer.valueOf(10));
        localHashMap.put(BeautyRealConfig.TYPE.FACE_V, Integer.valueOf(80));
        localHashMap.put(BeautyRealConfig.TYPE.FACE_THIN, Integer.valueOf(80));
        localHashMap.put(BeautyRealConfig.TYPE.EYE, Integer.valueOf(60));
        localHashMap.put(BeautyRealConfig.TYPE.NOSE, Integer.valueOf(40));
      }
      else
      {
        paramInt = BeautyRealConfig.TYPE.MELON.value;
      }
    }
    return localHashMap;
  }
  
  public static DistortParam getDistortParam(DistortParam paramDistortParam, int paramInt1, int paramInt2)
  {
    DistortParam localDistortParam = new DistortParam();
    if (paramDistortParam == null) {
      return localDistortParam;
    }
    ArrayList localArrayList = new ArrayList();
    float f = paramInt1 / 100.0F;
    paramDistortParam = paramDistortParam.getItems().iterator();
    if (paramDistortParam.hasNext())
    {
      DistortionItem localDistortionItem = ((DistortionItem)paramDistortParam.next()).clone();
      if (paramInt2 == BeautyRealConfig.TYPE.CHIN.value) {
        if (paramInt1 < 0)
        {
          localDistortionItem.strength *= -f;
          localDistortionItem.direction = 2;
        }
      }
      for (;;)
      {
        localArrayList.add(localDistortionItem);
        break;
        localDistortionItem.strength *= f;
        localDistortionItem.direction = 4;
        continue;
        localDistortionItem.strength *= f;
      }
    }
    localDistortParam.setLevel(paramInt1);
    localDistortParam.setItems(localArrayList);
    return localDistortParam;
  }
  
  public static boolean isCombinedType(int paramInt)
  {
    boolean bool2 = false;
    BeautyRealConfig.TYPE[] arrayOfTYPE = BeautyRealConfig.COMBINED_TYPE;
    int j = arrayOfTYPE.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfTYPE[i].value == paramInt) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.BeautyRealUtil
 * JD-Core Version:    0.7.0.1
 */