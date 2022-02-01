package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class r
  extends a
{
  int UdB = 0;
  int UdC = 0;
  
  public r()
  {
    this.Ucx = 278;
  }
  
  public final byte[] nj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88140);
    this.UdB = 10;
    byte[] arrayOfByte = new byte[this.UdB];
    util.ag(arrayOfByte, 0, this.UdC);
    util.ai(arrayOfByte, 1, paramInt1);
    util.ai(arrayOfByte, 5, paramInt2);
    util.ag(arrayOfByte, 9, 0);
    super.awj(this.Ucx);
    super.ak(arrayOfByte, this.UdB);
    super.hPB();
    arrayOfByte = super.hPx();
    AppMethodBeat.o(88140);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.r
 * JD-Core Version:    0.7.0.1
 */