package com.tencent.mm.plugin.zero.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.MMProtocalJni;

class LoadProtocolJNITask$3
  implements Runnable
{
  LoadProtocolJNITask$3(LoadProtocolJNITask paramLoadProtocolJNITask) {}
  
  public void run()
  {
    AppMethodBeat.i(58783);
    MMProtocalJni.setIsLite(false);
    AppMethodBeat.o(58783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask.3
 * JD-Core Version:    0.7.0.1
 */