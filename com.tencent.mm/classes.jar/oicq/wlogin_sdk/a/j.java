package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends a
{
  int LWV = 0;
  
  public j()
  {
    this.LVT = 264;
  }
  
  public final byte[] dd(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88132);
    this.LWV = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.LWV];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.ajl(this.LVT);
    super.ae(arrayOfByte, this.LWV);
    super.gfx();
    paramArrayOfByte = super.gft();
    AppMethodBeat.o(88132);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.j
 * JD-Core Version:    0.7.0.1
 */