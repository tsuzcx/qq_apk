package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends a
{
  int abGF = 0;
  
  public f()
  {
    this.abFM = 260;
  }
  
  public final byte[] dN(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88119);
    this.abGF = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.abGF];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.aGe(this.abFM);
    super.am(arrayOfByte, this.abGF);
    super.iUJ();
    paramArrayOfByte = super.iUF();
    AppMethodBeat.o(88119);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.f
 * JD-Core Version:    0.7.0.1
 */