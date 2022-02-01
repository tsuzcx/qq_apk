package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends a
{
  int Kjn = 0;
  
  public k()
  {
    this.Kik = 265;
  }
  
  public final byte[] de(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88141);
    this.Kjn = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.Kjn];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.agp(this.Kik);
    super.af(arrayOfByte, this.Kjn);
    super.fMH();
    paramArrayOfByte = super.fMD();
    AppMethodBeat.o(88141);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.k
 * JD-Core Version:    0.7.0.1
 */