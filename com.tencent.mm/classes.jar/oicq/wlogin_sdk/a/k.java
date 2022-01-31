package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends a
{
  int CNG = 0;
  
  public k()
  {
    this.CMD = 265;
  }
  
  public final byte[] cM(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96502);
    this.CNG = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.CNG];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.Wr(this.CMD);
    super.ab(arrayOfByte, this.CNG);
    super.ere();
    paramArrayOfByte = super.era();
    AppMethodBeat.o(96502);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.k
 * JD-Core Version:    0.7.0.1
 */