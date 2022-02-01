package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends a
{
  int NRv = 0;
  
  public k()
  {
    this.NQs = 265;
  }
  
  public final byte[] dl(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88141);
    this.NRv = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.NRv];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.alW(this.NQs);
    super.af(arrayOfByte, this.NRv);
    super.gxV();
    paramArrayOfByte = super.gxR();
    AppMethodBeat.o(88141);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.k
 * JD-Core Version:    0.7.0.1
 */