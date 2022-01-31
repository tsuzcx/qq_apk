package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class SendDataToDeviceProgressBar$1
  implements Runnable
{
  SendDataToDeviceProgressBar$1(SendDataToDeviceProgressBar paramSendDataToDeviceProgressBar) {}
  
  public final void run()
  {
    AppMethodBeat.i(30998);
    this.zCl.invalidate();
    AppMethodBeat.o(30998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.SendDataToDeviceProgressBar.1
 * JD-Core Version:    0.7.0.1
 */