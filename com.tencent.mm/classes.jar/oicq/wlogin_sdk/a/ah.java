package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah
  extends a
{
  public int CNT = 0;
  
  public ah()
  {
    this.CMD = 325;
  }
  
  public final byte[] cO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96479);
    if (paramArrayOfByte != null) {}
    for (int i = paramArrayOfByte.length + 0;; i = 0)
    {
      byte[] arrayOfByte = new byte[i];
      if (arrayOfByte.length > 0) {
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
      }
      this.CNT = arrayOfByte.length;
      super.Wr(this.CMD);
      super.ab(arrayOfByte, arrayOfByte.length);
      super.ere();
      paramArrayOfByte = super.era();
      AppMethodBeat.o(96479);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ah
 * JD-Core Version:    0.7.0.1
 */