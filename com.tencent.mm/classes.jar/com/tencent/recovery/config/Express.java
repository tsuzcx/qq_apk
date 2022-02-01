package com.tencent.recovery.config;

import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.util.AttributeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Express
{
  public List<List<ExpressItem>> expressConditionList = new ArrayList();
  
  private boolean checkCondition(List<ExpressItem> paramList, List<RecoveryStatusItem> paramList1)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ExpressItem localExpressItem = (ExpressItem)paramList.next();
      Iterator localIterator = paramList1.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        RecoveryStatusItem localRecoveryStatusItem = (RecoveryStatusItem)localIterator.next();
        if ((AttributeUtil.hasAttr(localExpressItem.getProcessStartFlag(), localRecoveryStatusItem.processStartFlag)) && (AttributeUtil.hasAttr(localExpressItem.getProcessStage(), localRecoveryStatusItem.processStage)) && (AttributeUtil.hasAttr(localExpressItem.getProcessStatus(), localRecoveryStatusItem.processStatus))) {
          i += 1;
        }
      }
      if (localExpressItem.getCount() > i) {
        return false;
      }
    }
    return true;
  }
  
  public void addCondition(List<ExpressItem> paramList)
  {
    this.expressConditionList.add(paramList);
  }
  
  public boolean getResult(List<RecoveryStatusItem> paramList)
  {
    Iterator localIterator = this.expressConditionList.iterator();
    while (localIterator.hasNext()) {
      if (checkCondition((List)localIterator.next(), paramList)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return this.expressConditionList.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.recovery.config.Express
 * JD-Core Version:    0.7.0.1
 */