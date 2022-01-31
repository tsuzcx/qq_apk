package com.tencent.voip.mars.comm;

import com.tencent.matrix.trace.core.AppMethodBeat;

class WakerLock$1
  implements Runnable
{
  WakerLock$1(WakerLock paramWakerLock) {}
  
  public void run()
  {
    AppMethodBeat.i(92745);
    this.this$0.unLock();
    AppMethodBeat.o(92745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.voip.mars.comm.WakerLock.1
 * JD-Core Version:    0.7.0.1
 */