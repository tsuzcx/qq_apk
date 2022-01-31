package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class aa
  extends a
{
  int CNN = 0;
  
  public aa()
  {
    this.CMD = 296;
  }
  
  private static int ac(byte[] paramArrayOfByte, int paramInt)
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
    AppMethodBeat.i(96495);
    int j = ac(paramArrayOfByte1, 32);
    int i = ac(paramArrayOfByte2, 16);
    this.CNN = (j + 11 + 2 + i + 2);
    byte[] arrayOfByte = new byte[this.CNN];
    util.O(arrayOfByte, 0, 0);
    util.N(arrayOfByte, 2, paramInt1);
    util.N(arrayOfByte, 3, paramInt2);
    util.N(arrayOfByte, 4, paramInt3);
    util.P(arrayOfByte, 5, 0);
    util.O(arrayOfByte, 9, j);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 11, j);
    paramInt1 = j + 11;
    util.O(arrayOfByte, paramInt1, i);
    paramInt1 += 2;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, i);
    util.O(arrayOfByte, paramInt1 + i, 0);
    super.Wr(this.CMD);
    super.ab(arrayOfByte, this.CNN);
    super.ere();
    paramArrayOfByte1 = super.era();
    AppMethodBeat.o(96495);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.aa
 * JD-Core Version:    0.7.0.1
 */