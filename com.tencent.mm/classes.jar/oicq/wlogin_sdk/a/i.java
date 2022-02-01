package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class i
  extends a
{
  int abGN = 6;
  
  public i()
  {
    this.abFM = 263;
  }
  
  public final byte[] iUL()
  {
    AppMethodBeat.i(88131);
    byte[] arrayOfByte = new byte[this.abGN];
    util.ai(arrayOfByte, 0, 0);
    util.ah(arrayOfByte, 2, 1);
    util.ai(arrayOfByte, 3, 102400);
    util.ah(arrayOfByte, 5, 1);
    super.aGe(this.abFM);
    super.am(arrayOfByte, this.abGN);
    super.iUJ();
    arrayOfByte = super.iUF();
    AppMethodBeat.o(88131);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.i
 * JD-Core Version:    0.7.0.1
 */