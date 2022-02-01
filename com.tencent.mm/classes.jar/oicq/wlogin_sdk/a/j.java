package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends a
{
  int Udz = 0;
  
  public j()
  {
    this.Ucx = 264;
  }
  
  public final byte[] dp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88132);
    this.Udz = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.Udz];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.awj(this.Ucx);
    super.ak(arrayOfByte, this.Udz);
    super.hPB();
    paramArrayOfByte = super.hPx();
    AppMethodBeat.o(88132);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.j
 * JD-Core Version:    0.7.0.1
 */