package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah
  extends a
{
  public int KjB = 0;
  
  public ah()
  {
    this.Kik = 325;
  }
  
  public final byte[] dg(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88118);
    if (paramArrayOfByte != null) {}
    for (int i = paramArrayOfByte.length + 0;; i = 0)
    {
      byte[] arrayOfByte = new byte[i];
      if (arrayOfByte.length > 0) {
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
      }
      this.KjB = arrayOfByte.length;
      super.agp(this.Kik);
      super.af(arrayOfByte, arrayOfByte.length);
      super.fMH();
      paramArrayOfByte = super.fMD();
      AppMethodBeat.o(88118);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ah
 * JD-Core Version:    0.7.0.1
 */