package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public static final BeautyParam EMPTY_PARAM;
  
  static
  {
    AppMethodBeat.i(83808);
    EMPTY_PARAM = new BeautyParam(false);
    AppMethodBeat.o(83808);
  }
  
  public static Map<BeautyRealConfig.TYPE, Integer> getBeautyLevels(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(83806);
    HashMap localHashMap = new HashMap();
    localHashMap.put(BeautyRealConfig.TYPE.BEAUTY, Integer.valueOf(60));
    Object localObject1;
    int i;
    if (paramInt == BeautyRealConfig.TYPE.NONE.value)
    {
      if (paramBoolean)
      {
        localHashMap.put(BeautyRealConfig.TYPE.BEAUTY, Integer.valueOf(0));
        localHashMap.put(BeautyRealConfig.TYPE.BASIC3, Integer.valueOf(0));
      }
      for (;;)
      {
        localObject1 = BeautyRealConfig.SINGLE_TRANS_TYPE_574;
        i = localObject1.length;
        paramInt = 0;
        while (paramInt < i)
        {
          localHashMap.put(localObject1[paramInt], Integer.valueOf(0));
          paramInt += 1;
        }
        localHashMap.put(BeautyRealConfig.TYPE.BEAUTY, Integer.valueOf(50));
        localHashMap.put(BeautyRealConfig.TYPE.BASIC3, Integer.valueOf(65));
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
      localObject1 = BeautyRealConfig.SINGLE_TRANS_TYPE_574;
      i = localObject1.length;
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = localObject1[paramInt];
        if (!localHashMap.containsKey(localObject2)) {
          localHashMap.put(localObject2, Integer.valueOf(0));
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
        localObject1 = BeautyRealConfig.TYPE.MELON;
      }
    }
    AppMethodBeat.o(83806);
    return localHashMap;
  }
  
  public static Map<BeautyRealConfig.TYPE, Integer> getBeautyLevels573(int paramInt)
  {
    AppMethodBeat.i(83807);
    HashMap localHashMap = new HashMap();
    localHashMap.put(BeautyRealConfig.TYPE.BEAUTY, Integer.valueOf(60));
    Object localObject1;
    int i;
    if (paramInt == BeautyRealConfig.TYPE.NONE.value)
    {
      localHashMap.put(BeautyRealConfig.TYPE.BEAUTY, Integer.valueOf(0));
      localObject1 = BeautyRealConfig.SINGLE_TRANS_TYPE_573;
      i = localObject1.length;
      paramInt = 0;
      while (paramInt < i)
      {
        localHashMap.put(localObject1[paramInt], Integer.valueOf(0));
        paramInt += 1;
      }
      localHashMap.put(BeautyRealConfig.TYPE.EYE_LIGHTEN, Integer.valueOf(0));
      localHashMap.put(BeautyRealConfig.TYPE.REMOVE_POUNCH, Integer.valueOf(0));
    }
    for (;;)
    {
      localObject1 = BeautyRealConfig.SINGLE_TRANS_TYPE_573;
      i = localObject1.length;
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = localObject1[paramInt];
        if (!localHashMap.containsKey(localObject2)) {
          localHashMap.put(localObject2, Integer.valueOf(0));
        }
        paramInt += 1;
      }
      if (paramInt == BeautyRealConfig.TYPE.NATURE.value)
      {
        localHashMap.put(BeautyRealConfig.TYPE.FACE_SHORTEN, Integer.valueOf(20));
        localHashMap.put(BeautyRealConfig.TYPE.FACE_V, Integer.valueOf(40));
        localHashMap.put(BeautyRealConfig.TYPE.FACE_THIN, Integer.valueOf(40));
        localHashMap.put(BeautyRealConfig.TYPE.EYE, Integer.valueOf(50));
      }
      else if (paramInt == BeautyRealConfig.TYPE.CUTE.value)
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
        localObject1 = BeautyRealConfig.TYPE.MELON;
      }
    }
    AppMethodBeat.o(83807);
    return localHashMap;
  }
  
  public static DistortParam getDistortParam(DistortParam paramDistortParam, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(83805);
    DistortParam localDistortParam = new DistortParam();
    if (paramDistortParam == null)
    {
      AppMethodBeat.o(83805);
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
    AppMethodBeat.o(83805);
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