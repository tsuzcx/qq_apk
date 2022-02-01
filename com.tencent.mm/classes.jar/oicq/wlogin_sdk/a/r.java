package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class r
  extends a
{
  int abGQ = 0;
  int abGR = 0;
  
  public r()
  {
    this.abFM = 278;
  }
  
  public final byte[] oF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88140);
    this.abGQ = 10;
    byte[] arrayOfByte = new byte[this.abGQ];
    util.ah(arrayOfByte, 0, this.abGR);
    util.aj(arrayOfByte, 1, paramInt1);
    util.aj(arrayOfByte, 5, paramInt2);
    util.ah(arrayOfByte, 9, 0);
    super.aGe(this.abFM);
    super.am(arrayOfByte, this.abGQ);
    super.iUJ();
    arrayOfByte = super.iUF();
    AppMethodBeat.o(88140);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.r
 * JD-Core Version:    0.7.0.1
 */