package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$3
  implements com.tencent.mm.plugin.voip.model.b
{
  d$3(d paramd) {}
  
  public final int M(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(53907);
    if (this.oTf.oTd != null) {}
    for (paramInt = this.oTf.oTd.W(paramArrayOfByte, paramInt);; paramInt = 0)
    {
      if (paramInt < 0)
      {
        AppMethodBeat.o(53907);
        return -1;
      }
      AppMethodBeat.o(53907);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.d.3
 * JD-Core Version:    0.7.0.1
 */