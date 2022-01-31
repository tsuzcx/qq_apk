package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkV8;

final class h$1
  implements Runnable
{
  h$1(h paramh, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(85237);
    if (this.BJK.BJG != null)
    {
      AppMethodBeat.o(85237);
      return;
    }
    this.BJK.BJG = new XWalkV8();
    this.BJK.BJG.init(this.BJJ);
    AppMethodBeat.o(85237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.h.1
 * JD-Core Version:    0.7.0.1
 */