package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends a
{
  int Kjd = 0;
  
  public f()
  {
    this.Kik = 260;
  }
  
  public final byte[] dc(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88119);
    this.Kjd = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.Kjd];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.agp(this.Kik);
    super.af(arrayOfByte, this.Kjd);
    super.fMH();
    paramArrayOfByte = super.fMD();
    AppMethodBeat.o(88119);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.f
 * JD-Core Version:    0.7.0.1
 */