package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ck
  implements Runnable
{
  ck(cj paramcj, String paramString, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(98641);
    String str = this.a;
    byte[] arrayOfByte2 = this.b;
    byte[] arrayOfByte1;
    if (!dd.a(str))
    {
      arrayOfByte1 = arrayOfByte2;
      if (!dd.a(arrayOfByte2)) {}
    }
    else
    {
      an.e();
      str = an.b();
      arrayOfByte1 = cj.a(this.c).a(str);
    }
    cl.c().d().a(str, arrayOfByte1, null);
    AppMethodBeat.o(98641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ck
 * JD-Core Version:    0.7.0.1
 */