package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends a
{
  int ajHJ = 0;
  
  public f()
  {
    this.ajGQ = 260;
  }
  
  public final byte[] dQ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88119);
    this.ajHJ = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.ajHJ];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.aMR(this.ajGQ);
    super.an(arrayOfByte, this.ajHJ);
    super.kGk();
    paramArrayOfByte = super.kGg();
    AppMethodBeat.o(88119);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.f
 * JD-Core Version:    0.7.0.1
 */