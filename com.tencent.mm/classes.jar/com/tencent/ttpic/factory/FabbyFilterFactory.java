package com.tencent.ttpic.factory;

import com.tencent.filter.BaseFilter;

public class FabbyFilterFactory
{
  public static BaseFilter createFilter(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramString == null) {
      return localObject2;
    }
    FabbyFilterFactory.FILTER_MODEL[] arrayOfFILTER_MODEL = FabbyFilterFactory.FILTER_MODEL.values();
    int j = arrayOfFILTER_MODEL.length;
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= j) {
        break;
      }
      FabbyFilterFactory.FILTER_MODEL localFILTER_MODEL = arrayOfFILTER_MODEL[i];
      if (localFILTER_MODEL.name.equals(paramString))
      {
        localObject2 = TTPicFilterFactoryLocal.creatFilterById(localFILTER_MODEL.filterId);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((BaseFilter)localObject2).setEffectIndex(localFILTER_MODEL.effectIndex);
          localObject1 = localObject2;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.factory.FabbyFilterFactory
 * JD-Core Version:    0.7.0.1
 */