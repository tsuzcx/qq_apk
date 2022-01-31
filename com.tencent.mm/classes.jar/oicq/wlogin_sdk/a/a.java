package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public int CMD;
  public int CMr;
  public int CMs;
  public byte[] CMx;
  int CNl;
  public int CNm;
  public int CNn;
  
  public a()
  {
    AppMethodBeat.i(96481);
    this.CMr = 128;
    this.CMs = 0;
    this.CNl = 0;
    this.CNm = 4;
    this.CNn = 0;
    this.CMx = new byte[this.CMr];
    this.CMD = 0;
    AppMethodBeat.o(96481);
  }
  
  private void K(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96484);
    if (paramInt2 > this.CMr)
    {
      this.CMr = (paramInt2 + 128);
      this.CMx = new byte[this.CMr];
    }
    this.CMs = paramInt2;
    System.arraycopy(paramArrayOfByte, paramInt1, this.CMx, 0, paramInt2);
    this.CMD = util.ae(paramArrayOfByte, paramInt1);
    this.CNn = (paramInt2 - this.CNm);
    AppMethodBeat.o(96484);
  }
  
  private static int L(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96488);
    int j = paramArrayOfByte.length;
    for (;;)
    {
      if (paramInt1 >= j) {}
      do
      {
        int i = -1;
        do
        {
          AppMethodBeat.o(96488);
          return i;
          if (paramInt1 + 2 > j) {
            break;
          }
          i = paramInt1;
        } while (util.ae(paramArrayOfByte, paramInt1) == paramInt2);
        paramInt1 += 2;
      } while (paramInt1 + 2 > j);
      paramInt1 += util.ae(paramArrayOfByte, paramInt1) + 2;
    }
  }
  
  private int d(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(96490);
    if (this.CNm >= paramInt)
    {
      AppMethodBeat.o(96490);
      return -1;
    }
    this.CNn = util.ae(paramArrayOfByte1, 2);
    if (this.CNm + this.CNn > paramInt)
    {
      AppMethodBeat.o(96490);
      return -1;
    }
    paramArrayOfByte2 = d.decrypt(paramArrayOfByte1, this.CNm, this.CNn, paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      AppMethodBeat.o(96490);
      return -1015;
    }
    if (this.CNm + paramArrayOfByte2.length > this.CMr)
    {
      this.CMr = (this.CNm + paramArrayOfByte2.length);
      this.CMx = new byte[this.CMr];
    }
    this.CMs = 0;
    System.arraycopy(paramArrayOfByte1, 0, this.CMx, 0, this.CNm);
    this.CMs += this.CNm;
    System.arraycopy(paramArrayOfByte2, 0, this.CMx, this.CMs, paramArrayOfByte2.length);
    this.CMs += paramArrayOfByte2.length;
    this.CNn = paramArrayOfByte2.length;
    if (!erf().booleanValue())
    {
      AppMethodBeat.o(96490);
      return -1005;
    }
    AppMethodBeat.o(96490);
    return 0;
  }
  
  public final int M(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96489);
    int i = L(paramArrayOfByte, paramInt1, this.CMD);
    if (i < 0)
    {
      AppMethodBeat.o(96489);
      return -1;
    }
    paramInt1 = paramInt2 - (i - paramInt1);
    if (this.CNm >= paramInt1)
    {
      AppMethodBeat.o(96489);
      return -1;
    }
    this.CNn = util.ae(paramArrayOfByte, i + 2);
    if (this.CNm + this.CNn > paramInt1)
    {
      AppMethodBeat.o(96489);
      return -1;
    }
    K(paramArrayOfByte, i, this.CNm + this.CNn);
    if (!erf().booleanValue())
    {
      AppMethodBeat.o(96489);
      return -1005;
    }
    paramInt1 = this.CNm;
    paramInt2 = this.CNn;
    AppMethodBeat.o(96489);
    return paramInt1 + i + paramInt2;
  }
  
  public final void Wr(int paramInt)
  {
    AppMethodBeat.i(96485);
    util.O(this.CMx, this.CMs, paramInt);
    this.CMs += 2;
    util.O(this.CMx, this.CMs, 0);
    this.CMs += 2;
    AppMethodBeat.o(96485);
  }
  
  public final void ab(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(96487);
    if (paramInt > this.CMr - this.CNm)
    {
      this.CMr = (this.CNm + paramInt + 64);
      byte[] arrayOfByte = new byte[this.CMr];
      System.arraycopy(this.CMx, 0, arrayOfByte, 0, this.CMs);
      this.CMx = arrayOfByte;
    }
    this.CNn = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.CMx, this.CMs, paramInt);
    this.CMs += paramInt;
    AppMethodBeat.o(96487);
  }
  
  public final int b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(96491);
    int i = L(paramArrayOfByte1, paramInt1, this.CMD);
    if (i < 0)
    {
      AppMethodBeat.o(96491);
      return -1;
    }
    paramInt1 = paramInt2 - (i - paramInt1);
    byte[] arrayOfByte = new byte[paramInt1];
    System.arraycopy(paramArrayOfByte1, i, arrayOfByte, 0, paramInt1);
    paramInt1 = d(arrayOfByte, paramInt1, paramArrayOfByte2);
    AppMethodBeat.o(96491);
    return paramInt1;
  }
  
  public final byte[] era()
  {
    AppMethodBeat.i(96482);
    byte[] arrayOfByte = new byte[this.CMs];
    System.arraycopy(this.CMx, 0, arrayOfByte, 0, this.CMs);
    AppMethodBeat.o(96482);
    return arrayOfByte;
  }
  
  public final byte[] erd()
  {
    AppMethodBeat.i(96483);
    byte[] arrayOfByte = new byte[this.CNn];
    System.arraycopy(this.CMx, this.CNm, arrayOfByte, 0, this.CNn);
    AppMethodBeat.o(96483);
    return arrayOfByte;
  }
  
  public final void ere()
  {
    AppMethodBeat.i(96486);
    util.O(this.CMx, 2, this.CMs - this.CNm);
    AppMethodBeat.o(96486);
  }
  
  public Boolean erf()
  {
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.a
 * JD-Core Version:    0.7.0.1
 */