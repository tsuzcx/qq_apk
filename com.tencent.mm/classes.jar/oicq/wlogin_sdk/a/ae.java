package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ae
  extends a
{
  int LXg = 0;
  int LXh = 0;
  
  public ae()
  {
    this.LVT = 322;
  }
  
  public final byte[] df(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88133);
    this.LXh = (paramArrayOfByte.length + 4);
    byte[] arrayOfByte = new byte[this.LXh];
    util.V(arrayOfByte, 0, this.LXg);
    util.V(arrayOfByte, 2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    super.ajl(this.LVT);
    super.ae(arrayOfByte, arrayOfByte.length);
    super.gfx();
    paramArrayOfByte = super.gft();
    AppMethodBeat.o(88133);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ae
 * JD-Core Version:    0.7.0.1
 */