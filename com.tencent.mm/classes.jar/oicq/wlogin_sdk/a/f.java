package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends a
{
  int NRl = 0;
  
  public f()
  {
    this.NQs = 260;
  }
  
  public final byte[] dj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88119);
    this.NRl = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.NRl];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.alW(this.NQs);
    super.af(arrayOfByte, this.NRl);
    super.gxV();
    paramArrayOfByte = super.gxR();
    AppMethodBeat.o(88119);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.f
 * JD-Core Version:    0.7.0.1
 */