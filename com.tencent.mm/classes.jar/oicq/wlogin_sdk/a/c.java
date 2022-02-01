package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class c
  extends a
{
  int LWJ = 1;
  int LWK = util.LXP;
  int LWL = 22;
  
  public c()
  {
    this.LVT = 256;
  }
  
  public final byte[] ajm(int paramInt)
  {
    AppMethodBeat.i(88114);
    byte[] arrayOfByte = new byte[this.LWL];
    util.V(arrayOfByte, 0, this.LWJ);
    util.W(arrayOfByte, 2, this.LWK);
    util.W(arrayOfByte, 6, 522017402);
    util.W(arrayOfByte, 10, 1);
    util.W(arrayOfByte, 14, paramInt);
    util.W(arrayOfByte, 18, 8256);
    super.ajl(this.LVT);
    super.ae(arrayOfByte, this.LWL);
    super.gfx();
    arrayOfByte = super.gft();
    AppMethodBeat.o(88114);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.c
 * JD-Core Version:    0.7.0.1
 */