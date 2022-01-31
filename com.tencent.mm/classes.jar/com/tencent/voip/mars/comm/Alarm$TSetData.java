package com.tencent.voip.mars.comm;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum Alarm$TSetData
{
  static
  {
    AppMethodBeat.i(92743);
    ID = new TSetData("ID", 0);
    WAITTIME = new TSetData("WAITTIME", 1);
    PENDINGINTENT = new TSetData("PENDINGINTENT", 2);
    $VALUES = new TSetData[] { ID, WAITTIME, PENDINGINTENT };
    AppMethodBeat.o(92743);
  }
  
  private Alarm$TSetData() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.voip.mars.comm.Alarm.TSetData
 * JD-Core Version:    0.7.0.1
 */