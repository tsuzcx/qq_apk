package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends a
{
  int abGP = 0;
  
  public k()
  {
    this.abFM = 265;
  }
  
  public final byte[] dP(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88141);
    this.abGP = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.abGP];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.aGe(this.abFM);
    super.am(arrayOfByte, this.abGP);
    super.iUJ();
    paramArrayOfByte = super.iUF();
    AppMethodBeat.o(88141);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.k
 * JD-Core Version:    0.7.0.1
 */