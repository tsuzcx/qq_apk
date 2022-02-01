package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah
  extends a
{
  public int ajIh = 0;
  
  public ah()
  {
    this.ajGQ = 325;
  }
  
  public final byte[] dU(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88118);
    if (paramArrayOfByte != null) {}
    for (int i = paramArrayOfByte.length + 0;; i = 0)
    {
      byte[] arrayOfByte = new byte[i];
      if (arrayOfByte.length > 0) {
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
      }
      this.ajIh = arrayOfByte.length;
      super.aMR(this.ajGQ);
      super.an(arrayOfByte, arrayOfByte.length);
      super.kGk();
      paramArrayOfByte = super.kGg();
      AppMethodBeat.o(88118);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ah
 * JD-Core Version:    0.7.0.1
 */