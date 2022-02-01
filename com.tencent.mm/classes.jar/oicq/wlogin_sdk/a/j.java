package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends a
{
  int Kjm = 0;
  
  public j()
  {
    this.Kik = 264;
  }
  
  public final byte[] dd(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88132);
    this.Kjm = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.Kjm];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.agp(this.Kik);
    super.af(arrayOfByte, this.Kjm);
    super.fMH();
    paramArrayOfByte = super.fMD();
    AppMethodBeat.o(88132);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.j
 * JD-Core Version:    0.7.0.1
 */