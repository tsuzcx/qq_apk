package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends a
{
  int CNw = 0;
  
  public f()
  {
    this.CMD = 260;
  }
  
  public final byte[] cK(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96480);
    this.CNw = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.CNw];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.Wr(this.CMD);
    super.ab(arrayOfByte, this.CNw);
    super.ere();
    paramArrayOfByte = super.era();
    AppMethodBeat.o(96480);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.f
 * JD-Core Version:    0.7.0.1
 */