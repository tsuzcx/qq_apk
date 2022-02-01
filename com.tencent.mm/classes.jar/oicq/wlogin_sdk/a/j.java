package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends a
{
  int abGO = 0;
  
  public j()
  {
    this.abFM = 264;
  }
  
  public final byte[] dO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88132);
    this.abGO = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.abGO];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.aGe(this.abFM);
    super.am(arrayOfByte, this.abGO);
    super.iUJ();
    paramArrayOfByte = super.iUF();
    AppMethodBeat.o(88132);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.j
 * JD-Core Version:    0.7.0.1
 */