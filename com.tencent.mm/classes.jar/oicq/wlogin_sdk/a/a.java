package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public int ajGE;
  public int ajGF;
  public byte[] ajGK;
  public int ajGQ;
  public int ajHA;
  int ajHy;
  public int ajHz;
  
  public a()
  {
    AppMethodBeat.i(88120);
    this.ajGE = 128;
    this.ajGF = 0;
    this.ajHy = 0;
    this.ajHz = 4;
    this.ajHA = 0;
    this.ajGK = new byte[this.ajGE];
    this.ajGQ = 0;
    AppMethodBeat.o(88120);
  }
  
  private void ac(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88123);
    if (paramInt2 > this.ajGE)
    {
      this.ajGE = (paramInt2 + 128);
      this.ajGK = new byte[this.ajGE];
    }
    this.ajGF = paramInt2;
    System.arraycopy(paramArrayOfByte, paramInt1, this.ajGK, 0, paramInt2);
    this.ajGQ = util.aq(paramArrayOfByte, paramInt1);
    this.ajHA = (paramInt2 - this.ajHz);
    AppMethodBeat.o(88123);
  }
  
  private static int ad(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88127);
    int j = paramArrayOfByte.length;
    for (;;)
    {
      if (paramInt1 >= j) {}
      do
      {
        int i = -1;
        do
        {
          AppMethodBeat.o(88127);
          return i;
          if (paramInt1 + 2 > j) {
            break;
          }
          i = paramInt1;
        } while (util.aq(paramArrayOfByte, paramInt1) == paramInt2);
        paramInt1 += 2;
      } while (paramInt1 + 2 > j);
      paramInt1 += util.aq(paramArrayOfByte, paramInt1) + 2;
    }
  }
  
  private int e(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88129);
    if (this.ajHz >= paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    this.ajHA = util.aq(paramArrayOfByte1, 2);
    if (this.ajHz + this.ajHA > paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    paramArrayOfByte2 = d.decrypt(paramArrayOfByte1, this.ajHz, this.ajHA, paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      AppMethodBeat.o(88129);
      return -1015;
    }
    if (this.ajHz + paramArrayOfByte2.length > this.ajGE)
    {
      this.ajGE = (this.ajHz + paramArrayOfByte2.length);
      this.ajGK = new byte[this.ajGE];
    }
    this.ajGF = 0;
    System.arraycopy(paramArrayOfByte1, 0, this.ajGK, 0, this.ajHz);
    this.ajGF += this.ajHz;
    System.arraycopy(paramArrayOfByte2, 0, this.ajGK, this.ajGF, paramArrayOfByte2.length);
    this.ajGF += paramArrayOfByte2.length;
    this.ajHA = paramArrayOfByte2.length;
    if (!kGl().booleanValue())
    {
      AppMethodBeat.o(88129);
      return -1005;
    }
    AppMethodBeat.o(88129);
    return 0;
  }
  
  public final void aMR(int paramInt)
  {
    AppMethodBeat.i(88124);
    util.ag(this.ajGK, this.ajGF, paramInt);
    this.ajGF += 2;
    util.ag(this.ajGK, this.ajGF, 0);
    this.ajGF += 2;
    AppMethodBeat.o(88124);
  }
  
  public final int ae(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88128);
    int i = ad(paramArrayOfByte, paramInt1, this.ajGQ);
    if (i < 0)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    paramInt1 = paramInt2 - (i - paramInt1);
    if (this.ajHz >= paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    this.ajHA = util.aq(paramArrayOfByte, i + 2);
    if (this.ajHz + this.ajHA > paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    ac(paramArrayOfByte, i, this.ajHz + this.ajHA);
    if (!kGl().booleanValue())
    {
      AppMethodBeat.o(88128);
      return -1005;
    }
    paramInt1 = this.ajHz;
    paramInt2 = this.ajHA;
    AppMethodBeat.o(88128);
    return paramInt1 + i + paramInt2;
  }
  
  public final void an(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(88126);
    if (paramInt > this.ajGE - this.ajHz)
    {
      this.ajGE = (this.ajHz + paramInt + 64);
      byte[] arrayOfByte = new byte[this.ajGE];
      System.arraycopy(this.ajGK, 0, arrayOfByte, 0, this.ajGF);
      this.ajGK = arrayOfByte;
    }
    this.ajHA = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.ajGK, this.ajGF, paramInt);
    this.ajGF += paramInt;
    AppMethodBeat.o(88126);
  }
  
  public final int c(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88130);
    int i = ad(paramArrayOfByte1, paramInt1, this.ajGQ);
    if (i < 0)
    {
      AppMethodBeat.o(88130);
      return -1;
    }
    paramInt1 = paramInt2 - (i - paramInt1);
    byte[] arrayOfByte = new byte[paramInt1];
    System.arraycopy(paramArrayOfByte1, i, arrayOfByte, 0, paramInt1);
    paramInt1 = e(arrayOfByte, paramInt1, paramArrayOfByte2);
    AppMethodBeat.o(88130);
    return paramInt1;
  }
  
  public final byte[] kGg()
  {
    AppMethodBeat.i(88121);
    byte[] arrayOfByte = new byte[this.ajGF];
    System.arraycopy(this.ajGK, 0, arrayOfByte, 0, this.ajGF);
    AppMethodBeat.o(88121);
    return arrayOfByte;
  }
  
  public final byte[] kGj()
  {
    AppMethodBeat.i(88122);
    byte[] arrayOfByte = new byte[this.ajHA];
    System.arraycopy(this.ajGK, this.ajHz, arrayOfByte, 0, this.ajHA);
    AppMethodBeat.o(88122);
    return arrayOfByte;
  }
  
  public final void kGk()
  {
    AppMethodBeat.i(88125);
    util.ag(this.ajGK, 2, this.ajGF - this.ajHz);
    AppMethodBeat.o(88125);
  }
  
  public Boolean kGl()
  {
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.a
 * JD-Core Version:    0.7.0.1
 */