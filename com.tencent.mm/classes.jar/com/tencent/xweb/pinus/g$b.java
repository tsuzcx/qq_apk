package com.tencent.xweb.pinus;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.l;
import com.tencent.xweb.pinus.sdk.HttpAuthHandlerInterface;

public final class g$b
  implements l
{
  HttpAuthHandlerInterface aikw;
  
  public g$b(HttpAuthHandlerInterface paramHttpAuthHandlerInterface)
  {
    this.aikw = paramHttpAuthHandlerInterface;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(213287);
    this.aikw.cancel();
    AppMethodBeat.o(213287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.g.b
 * JD-Core Version:    0.7.0.1
 */