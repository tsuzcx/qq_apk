package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends a
{
  int LWM = 0;
  
  public f()
  {
    this.LVT = 260;
  }
  
  public final byte[] dc(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88119);
    this.LWM = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.LWM];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.ajl(this.LVT);
    super.ae(arrayOfByte, this.LWM);
    super.gfx();
    paramArrayOfByte = super.gft();
    AppMethodBeat.o(88119);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.f
 * JD-Core Version:    0.7.0.1
 */