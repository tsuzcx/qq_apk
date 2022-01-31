package com.tencent.ttpic.factory;

import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FabbyFilterFactory
{
  public static BaseFilter createFilter(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(81919);
    if (paramString == null)
    {
      AppMethodBeat.o(81919);
      return null;
    }
    FabbyFilterFactory.FILTER_MODEL[] arrayOfFILTER_MODEL = FabbyFilterFactory.FILTER_MODEL.values();
    int j = arrayOfFILTER_MODEL.length;
    int i = 0;
    while (i < j)
    {
      FabbyFilterFactory.FILTER_MODEL localFILTER_MODEL = arrayOfFILTER_MODEL[i];
      if (localFILTER_MODEL.name.equals(paramString))
      {
        BaseFilter localBaseFilter = TTPicFilterFactoryLocal.creatFilterById(localFILTER_MODEL.filterId);
        localObject = localBaseFilter;
        if (localBaseFilter != null)
        {
          localBaseFilter.setEffectIndex(localFILTER_MODEL.effectIndex);
          localObject = localBaseFilter;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(81919);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.factory.FabbyFilterFactory
 * JD-Core Version:    0.7.0.1
 */