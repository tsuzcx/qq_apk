package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;

final class ReadMailProxy$5
  implements Runnable
{
  ReadMailProxy$5(ReadMailProxy paramReadMailProxy, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(68094);
    ac.cdQ().cancel(this.pKP);
    AppMethodBeat.o(68094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.5
 * JD-Core Version:    0.7.0.1
 */