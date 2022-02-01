package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends a
{
  int NRu = 0;
  
  public j()
  {
    this.NQs = 264;
  }
  
  public final byte[] dk(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88132);
    this.NRu = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.NRu];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.alW(this.NQs);
    super.af(arrayOfByte, this.NRu);
    super.gxV();
    paramArrayOfByte = super.gxR();
    AppMethodBeat.o(88132);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.j
 * JD-Core Version:    0.7.0.1
 */