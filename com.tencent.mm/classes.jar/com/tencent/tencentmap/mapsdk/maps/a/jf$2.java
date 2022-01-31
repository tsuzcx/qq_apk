package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

class jf$2
  implements Runnable
{
  jf$2(jf paramjf, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    AppMethodBeat.i(148682);
    try
    {
      if (this.a == null) {
        jf.a(this.c).c(this.b);
      }
      jf.a(this.c).a(this.b, this.a);
      AppMethodBeat.o(148682);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(148682);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jf.2
 * JD-Core Version:    0.7.0.1
 */