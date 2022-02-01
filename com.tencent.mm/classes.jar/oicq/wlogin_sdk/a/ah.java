package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah
  extends a
{
  public int OoP = 0;
  
  public ah()
  {
    this.Ony = 325;
  }
  
  public final byte[] dq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88118);
    if (paramArrayOfByte != null) {}
    for (int i = paramArrayOfByte.length + 0;; i = 0)
    {
      byte[] arrayOfByte = new byte[i];
      if (arrayOfByte.length > 0) {
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
      }
      this.OoP = arrayOfByte.length;
      super.amG(this.Ony);
      super.aj(arrayOfByte, arrayOfByte.length);
      super.gCx();
      paramArrayOfByte = super.gCt();
      AppMethodBeat.o(88118);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ah
 * JD-Core Version:    0.7.0.1
 */