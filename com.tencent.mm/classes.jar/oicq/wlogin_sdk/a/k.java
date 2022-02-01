package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends a
{
  int OoB = 0;
  
  public k()
  {
    this.Ony = 265;
  }
  
  public final byte[] jdMethod_do(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88141);
    this.OoB = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.OoB];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.amG(this.Ony);
    super.aj(arrayOfByte, this.OoB);
    super.gCx();
    paramArrayOfByte = super.gCt();
    AppMethodBeat.o(88141);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.k
 * JD-Core Version:    0.7.0.1
 */