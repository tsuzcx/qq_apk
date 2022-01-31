package com.tencent.ttpic.util;

import com.tencent.ttpic.config.SimpleBeautyRealConfig.TYPE;
import com.tencent.ttpic.filter.SimpleBeautyParam;
import com.tencent.ttpic.model.DistortParam;
import com.tencent.ttpic.model.DistortionItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleBeautyRealUtil
{
  public static final SimpleBeautyParam EMPTY_PARAM = new SimpleBeautyParam(false);
  
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
      if (paramInt2 == SimpleBeautyRealConfig.TYPE.CHIN.value) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.SimpleBeautyRealUtil
 * JD-Core Version:    0.7.0.1
 */