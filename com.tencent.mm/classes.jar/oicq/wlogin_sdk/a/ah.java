package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah
  extends a
{
  public int NRJ = 0;
  
  public ah()
  {
    this.NQs = 325;
  }
  
  public final byte[] dn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88118);
    if (paramArrayOfByte != null) {}
    for (int i = paramArrayOfByte.length + 0;; i = 0)
    {
      byte[] arrayOfByte = new byte[i];
      if (arrayOfByte.length > 0) {
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
      }
      this.NRJ = arrayOfByte.length;
      super.alW(this.NQs);
      super.af(arrayOfByte, arrayOfByte.length);
      super.gxV();
      paramArrayOfByte = super.gxR();
      AppMethodBeat.o(88118);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ah
 * JD-Core Version:    0.7.0.1
 */