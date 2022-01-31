package com.tencent.voip.mars.comm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

class Alarm$ComparatorAlarm
  implements Comparator<Object[]>
{
  public int compare(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    AppMethodBeat.i(92739);
    int i = (int)(((Long)paramArrayOfObject1[Alarm.TSetData.ID.ordinal()]).longValue() - ((Long)paramArrayOfObject2[Alarm.TSetData.ID.ordinal()]).longValue());
    AppMethodBeat.o(92739);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.voip.mars.comm.Alarm.ComparatorAlarm
 * JD-Core Version:    0.7.0.1
 */