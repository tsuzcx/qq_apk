package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class an
  extends a
{
  int LXp = 22;
  int LXq = 1;
  int LXr = 1536;
  
  public an()
  {
    this.LVT = 24;
  }
  
  public final byte[] aP(int paramInt, long paramLong)
  {
    AppMethodBeat.i(88143);
    byte[] arrayOfByte = new byte[this.LXp];
    util.V(arrayOfByte, 0, this.LXq);
    util.W(arrayOfByte, 2, this.LXr);
    util.W(arrayOfByte, 6, 522017402);
    util.W(arrayOfByte, 10, paramInt);
    util.W(arrayOfByte, 14, (int)paramLong);
    util.V(arrayOfByte, 18, 0);
    util.V(arrayOfByte, 20, 0);
    super.ajl(this.LVT);
    super.ae(arrayOfByte, this.LXp);
    super.gfx();
    arrayOfByte = super.gft();
    AppMethodBeat.o(88143);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.an
 * JD-Core Version:    0.7.0.1
 */