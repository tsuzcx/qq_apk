package com.tencent.mm.plugin.zero.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;

class LoadProtocolJNITask$1
  implements Runnable
{
  LoadProtocolJNITask$1(LoadProtocolJNITask paramLoadProtocolJNITask) {}
  
  public void run()
  {
    AppMethodBeat.i(58781);
    MMProtocalJni.setClientPackVersion(d.whH);
    AppMethodBeat.o(58781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask.1
 * JD-Core Version:    0.7.0.1
 */