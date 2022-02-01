package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class aa
  extends a
{
  int UdH = 0;
  
  public aa()
  {
    this.Ucx = 296;
  }
  
  private static int al(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length > paramInt) {
        return paramInt;
      }
      return paramArrayOfByte.length;
    }
    return 0;
  }
  
  public final byte[] a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88134);
    int j = al(paramArrayOfByte1, 32);
    int i = al(paramArrayOfByte2, 16);
    this.UdH = (j + 11 + 2 + i + 2);
    byte[] arrayOfByte = new byte[this.UdH];
    util.ah(arrayOfByte, 0, 0);
    util.ag(arrayOfByte, 2, paramInt1);
    util.ag(arrayOfByte, 3, paramInt2);
    util.ag(arrayOfByte, 4, paramInt3);
    util.ai(arrayOfByte, 5, 0);
    util.ah(arrayOfByte, 9, j);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 11, j);
    paramInt1 = j + 11;
    util.ah(arrayOfByte, paramInt1, i);
    paramInt1 += 2;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, i);
    util.ah(arrayOfByte, paramInt1 + i, 0);
    super.awj(this.Ucx);
    super.ak(arrayOfByte, this.UdH);
    super.hPB();
    paramArrayOfByte1 = super.hPx();
    AppMethodBeat.o(88134);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.aa
 * JD-Core Version:    0.7.0.1
 */