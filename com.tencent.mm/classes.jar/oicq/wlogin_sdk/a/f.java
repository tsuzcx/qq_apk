package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends a
{
  int Oor = 0;
  
  public f()
  {
    this.Ony = 260;
  }
  
  public final byte[] dm(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88119);
    this.Oor = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.Oor];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.amG(this.Ony);
    super.aj(arrayOfByte, this.Oor);
    super.gCx();
    paramArrayOfByte = super.gCt();
    AppMethodBeat.o(88119);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.f
 * JD-Core Version:    0.7.0.1
 */