package com.tencent.voip.mars.comm;

import java.util.Comparator;

class Alarm$ComparatorAlarm
  implements Comparator<Object[]>
{
  public int compare(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return (int)(((Long)paramArrayOfObject1[Alarm.TSetData.ID.ordinal()]).longValue() - ((Long)paramArrayOfObject2[Alarm.TSetData.ID.ordinal()]).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.voip.mars.comm.Alarm.ComparatorAlarm
 * JD-Core Version:    0.7.0.1
 */