package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends a
{
  int CNF = 0;
  
  public j()
  {
    this.CMD = 264;
  }
  
  public final byte[] cL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96493);
    this.CNF = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.CNF];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.Wr(this.CMD);
    super.ab(arrayOfByte, this.CNF);
    super.ere();
    paramArrayOfByte = super.era();
    AppMethodBeat.o(96493);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.j
 * JD-Core Version:    0.7.0.1
 */