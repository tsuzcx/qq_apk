package com.tencent.ttpic.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.model.MemRandomValue;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum RandomGroupManager
{
  private static final int HAND_RANDOM_INDEX = 0;
  private Map<Integer, MemRandomValue> mRandomGroupFaceValueMap;
  private Map<Integer, MemRandomValue> mRandomGroupHandValueMap;
  
  static
  {
    AppMethodBeat.i(83450);
    INSTANCE = new RandomGroupManager("INSTANCE", 0);
    $VALUES = new RandomGroupManager[] { INSTANCE };
    AppMethodBeat.o(83450);
  }
  
  private RandomGroupManager()
  {
    AppMethodBeat.i(83439);
    this.mRandomGroupFaceValueMap = new HashMap();
    this.mRandomGroupHandValueMap = new HashMap();
    clearAll();
    AppMethodBeat.o(83439);
  }
  
  private void clearFaceRandomGroupStatus()
  {
    AppMethodBeat.i(83446);
    Iterator localIterator = this.mRandomGroupFaceValueMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      MemRandomValue localMemRandomValue = (MemRandomValue)this.mRandomGroupFaceValueMap.get(Integer.valueOf(i));
      if (localMemRandomValue != null)
      {
        localMemRandomValue.curValue = -1;
        this.mRandomGroupFaceValueMap.put(Integer.valueOf(i), localMemRandomValue);
      }
    }
    AppMethodBeat.o(83446);
  }
  
  private void clearFaceRandomGroupStatus(List<Integer> paramList)
  {
    AppMethodBeat.i(83444);
    Iterator localIterator = this.mRandomGroupFaceValueMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (!faceExist(paramList, i))
      {
        MemRandomValue localMemRandomValue = (MemRandomValue)this.mRandomGroupFaceValueMap.get(Integer.valueOf(i));
        if (localMemRandomValue != null)
        {
          localMemRandomValue.curValue = -1;
          this.mRandomGroupFaceValueMap.put(Integer.valueOf(i), localMemRandomValue);
        }
      }
    }
    AppMethodBeat.o(83444);
  }
  
  private void clearHandRandomGroupStatus()
  {
    AppMethodBeat.i(83447);
    MemRandomValue localMemRandomValue = (MemRandomValue)this.mRandomGroupHandValueMap.get(Integer.valueOf(0));
    localMemRandomValue.curValue = -1;
    this.mRandomGroupHandValueMap.put(Integer.valueOf(0), localMemRandomValue);
    AppMethodBeat.o(83447);
  }
  
  private boolean faceExist(List<Integer> paramList, int paramInt)
  {
    AppMethodBeat.i(83445);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((Integer)paramList.next()).intValue() == paramInt)
      {
        AppMethodBeat.o(83445);
        return true;
      }
    }
    AppMethodBeat.o(83445);
    return false;
  }
  
  private void fillEmptyRandomGroupValue(List<Integer> paramList, int paramInt)
  {
    AppMethodBeat.i(83443);
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      i = ((Integer)((Iterator)localObject).next()).intValue();
      if (!this.mRandomGroupFaceValueMap.containsKey(Integer.valueOf(i))) {
        this.mRandomGroupFaceValueMap.put(Integer.valueOf(i), new MemRandomValue());
      }
    }
    int i = 1;
    while (i < paramList.size())
    {
      localObject = (MemRandomValue)this.mRandomGroupFaceValueMap.get(paramList.get(i));
      if ((localObject != null) && (((MemRandomValue)localObject).curValue < 0))
      {
        int j = AlgoUtils.randValueDiff(((MemRandomValue)localObject).lastValue, paramInt);
        ((MemRandomValue)localObject).curValue = j;
        ((MemRandomValue)localObject).lastValue = j;
      }
      this.mRandomGroupFaceValueMap.put(paramList.get(i), localObject);
      i += 1;
    }
    AppMethodBeat.o(83443);
  }
  
  public static RandomGroupManager getInstance()
  {
    return INSTANCE;
  }
  
  public final void clearAll()
  {
    AppMethodBeat.i(83449);
    this.mRandomGroupFaceValueMap.clear();
    this.mRandomGroupHandValueMap.put(Integer.valueOf(0), new MemRandomValue());
    AppMethodBeat.o(83449);
  }
  
  public final void clearCurValue()
  {
    AppMethodBeat.i(83448);
    clearFaceRandomGroupStatus();
    clearHandRandomGroupStatus();
    AppMethodBeat.o(83448);
  }
  
  public final int getFaceValue(int paramInt)
  {
    AppMethodBeat.i(83440);
    if (this.mRandomGroupFaceValueMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramInt = ((MemRandomValue)this.mRandomGroupFaceValueMap.get(Integer.valueOf(paramInt))).curValue;
      AppMethodBeat.o(83440);
      return paramInt;
    }
    AppMethodBeat.o(83440);
    return 0;
  }
  
  public final int getHandValue()
  {
    AppMethodBeat.i(83441);
    int i = ((MemRandomValue)this.mRandomGroupHandValueMap.get(Integer.valueOf(0))).curValue;
    AppMethodBeat.o(83441);
    return i;
  }
  
  public final void updateValue(List<Integer> paramList, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(83442);
    if (!paramBoolean) {
      clearHandRandomGroupStatus();
    }
    clearFaceRandomGroupStatus(paramList);
    fillEmptyRandomGroupValue(paramList, paramInt);
    MemRandomValue localMemRandomValue2 = (MemRandomValue)this.mRandomGroupHandValueMap.get(Integer.valueOf(0));
    MemRandomValue localMemRandomValue1;
    int i;
    if (!BaseUtils.isEmpty(paramList))
    {
      localMemRandomValue1 = (MemRandomValue)this.mRandomGroupFaceValueMap.get(paramList.get(0));
      if ((localMemRandomValue2 == null) || (localMemRandomValue1 == null) || (((localMemRandomValue2.curValue >= 0) || (!paramBoolean)) && ((localMemRandomValue1.curValue >= 0) || (BaseUtils.isEmpty(paramList))))) {
        break label222;
      }
      if (localMemRandomValue2.curValue >= 0) {
        break label146;
      }
      i = localMemRandomValue1.lastValue;
    }
    label122:
    for (paramInt = AlgoUtils.randValueDiff(i, paramInt);; paramInt = -1)
    {
      if (paramInt < 0)
      {
        AppMethodBeat.o(83442);
        return;
        localMemRandomValue1 = localMemRandomValue2;
        break;
        i = localMemRandomValue2.lastValue;
        break label122;
      }
      if (!BaseUtils.isEmpty(paramList)) {
        this.mRandomGroupFaceValueMap.put(paramList.get(0), new MemRandomValue(paramInt, paramInt));
      }
      if (paramBoolean) {
        this.mRandomGroupHandValueMap.put(Integer.valueOf(0), new MemRandomValue(paramInt, paramInt));
      }
      AppMethodBeat.o(83442);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.manager.RandomGroupManager
 * JD-Core Version:    0.7.0.1
 */