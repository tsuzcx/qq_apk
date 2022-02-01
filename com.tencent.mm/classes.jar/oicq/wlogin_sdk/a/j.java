package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends a
{
  int ajHS = 0;
  
  public j()
  {
    this.ajGQ = 264;
  }
  
  public final byte[] dR(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88132);
    this.ajHS = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.ajHS];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.aMR(this.ajGQ);
    super.an(arrayOfByte, this.ajHS);
    super.kGk();
    paramArrayOfByte = super.kGg();
    AppMethodBeat.o(88132);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.j
 * JD-Core Version:    0.7.0.1
 */