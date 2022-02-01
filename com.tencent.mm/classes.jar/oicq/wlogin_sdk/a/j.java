package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends a
{
  int OoA = 0;
  
  public j()
  {
    this.Ony = 264;
  }
  
  public final byte[] dn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88132);
    this.OoA = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.OoA];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.amG(this.Ony);
    super.aj(arrayOfByte, this.OoA);
    super.gCx();
    paramArrayOfByte = super.gCt();
    AppMethodBeat.o(88132);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.j
 * JD-Core Version:    0.7.0.1
 */