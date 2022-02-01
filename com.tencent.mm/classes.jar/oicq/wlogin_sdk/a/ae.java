package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ae
  extends a
{
  int Kjx = 0;
  int Kjy = 0;
  
  public ae()
  {
    this.Kik = 322;
  }
  
  public final byte[] df(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88133);
    this.Kjy = (paramArrayOfByte.length + 4);
    byte[] arrayOfByte = new byte[this.Kjy];
    util.W(arrayOfByte, 0, this.Kjx);
    util.W(arrayOfByte, 2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    super.agp(this.Kik);
    super.af(arrayOfByte, arrayOfByte.length);
    super.fMH();
    paramArrayOfByte = super.fMD();
    AppMethodBeat.o(88133);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ae
 * JD-Core Version:    0.7.0.1
 */