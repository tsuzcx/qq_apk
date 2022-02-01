package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends a
{
  int ajHT = 0;
  
  public k()
  {
    this.ajGQ = 265;
  }
  
  public final byte[] dS(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88141);
    this.ajHT = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.ajHT];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.aMR(this.ajGQ);
    super.an(arrayOfByte, this.ajHT);
    super.kGk();
    paramArrayOfByte = super.kGg();
    AppMethodBeat.o(88141);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.k
 * JD-Core Version:    0.7.0.1
 */