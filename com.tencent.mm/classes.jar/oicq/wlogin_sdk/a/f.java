package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends a
{
  int Udq = 0;
  
  public f()
  {
    this.Ucx = 260;
  }
  
  public final byte[] jdMethod_do(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88119);
    this.Udq = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.Udq];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.awj(this.Ucx);
    super.ak(arrayOfByte, this.Udq);
    super.hPB();
    paramArrayOfByte = super.hPx();
    AppMethodBeat.o(88119);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.f
 * JD-Core Version:    0.7.0.1
 */