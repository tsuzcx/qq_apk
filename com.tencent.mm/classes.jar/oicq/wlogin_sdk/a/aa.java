package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class aa
  extends a
{
  int ajIa = 0;
  
  public aa()
  {
    this.ajGQ = 296;
  }
  
  private static int ao(byte[] paramArrayOfByte, int paramInt)
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
    int j = ao(paramArrayOfByte1, 32);
    int i = ao(paramArrayOfByte2, 16);
    this.ajIa = (j + 11 + 2 + i + 2);
    byte[] arrayOfByte = new byte[this.ajIa];
    util.ag(arrayOfByte, 0, 0);
    util.af(arrayOfByte, 2, paramInt1);
    util.af(arrayOfByte, 3, paramInt2);
    util.af(arrayOfByte, 4, paramInt3);
    util.ah(arrayOfByte, 5, 0);
    util.ag(arrayOfByte, 9, j);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 11, j);
    paramInt1 = j + 11;
    util.ag(arrayOfByte, paramInt1, i);
    paramInt1 += 2;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, i);
    util.ag(arrayOfByte, paramInt1 + i, 0);
    super.aMR(this.ajGQ);
    super.an(arrayOfByte, this.ajIa);
    super.kGk();
    paramArrayOfByte1 = super.kGg();
    AppMethodBeat.o(88134);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.aa
 * JD-Core Version:    0.7.0.1
 */