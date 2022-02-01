package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public int NQg;
  public int NQh;
  public byte[] NQm;
  public int NQs;
  int NRa;
  public int NRb;
  public int NRc;
  
  public a()
  {
    AppMethodBeat.i(88120);
    this.NQg = 128;
    this.NQh = 0;
    this.NRa = 0;
    this.NRb = 4;
    this.NRc = 0;
    this.NQm = new byte[this.NQg];
    this.NQs = 0;
    AppMethodBeat.o(88120);
  }
  
  private void S(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88123);
    if (paramInt2 > this.NQg)
    {
      this.NQg = (paramInt2 + 128);
      this.NQm = new byte[this.NQg];
    }
    this.NQh = paramInt2;
    System.arraycopy(paramArrayOfByte, paramInt1, this.NQm, 0, paramInt2);
    this.NQs = util.ai(paramArrayOfByte, paramInt1);
    this.NRc = (paramInt2 - this.NRb);
    AppMethodBeat.o(88123);
  }
  
  private static int T(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
        } while (util.ai(paramArrayOfByte, paramInt1) == paramInt2);
        paramInt1 += 2;
      } while (paramInt1 + 2 > j);
      paramInt1 += util.ai(paramArrayOfByte, paramInt1) + 2;
    }
  }
  
  private int d(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88129);
    if (this.NRb >= paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    this.NRc = util.ai(paramArrayOfByte1, 2);
    if (this.NRb + this.NRc > paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    paramArrayOfByte2 = d.decrypt(paramArrayOfByte1, this.NRb, this.NRc, paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      AppMethodBeat.o(88129);
      return -1015;
    }
    if (this.NRb + paramArrayOfByte2.length > this.NQg)
    {
      this.NQg = (this.NRb + paramArrayOfByte2.length);
      this.NQm = new byte[this.NQg];
    }
    this.NQh = 0;
    System.arraycopy(paramArrayOfByte1, 0, this.NQm, 0, this.NRb);
    this.NQh += this.NRb;
    System.arraycopy(paramArrayOfByte2, 0, this.NQm, this.NQh, paramArrayOfByte2.length);
    this.NQh += paramArrayOfByte2.length;
    this.NRc = paramArrayOfByte2.length;
    if (!gxW().booleanValue())
    {
      AppMethodBeat.o(88129);
      return -1005;
    }
    AppMethodBeat.o(88129);
    return 0;
  }
  
  public final int U(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88128);
    int i = T(paramArrayOfByte, paramInt1, this.NQs);
    if (i < 0)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    paramInt1 = paramInt2 - (i - paramInt1);
    if (this.NRb >= paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    this.NRc = util.ai(paramArrayOfByte, i + 2);
    if (this.NRb + this.NRc > paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    S(paramArrayOfByte, i, this.NRb + this.NRc);
    if (!gxW().booleanValue())
    {
      AppMethodBeat.o(88128);
      return -1005;
    }
    paramInt1 = this.NRb;
    paramInt2 = this.NRc;
    AppMethodBeat.o(88128);
    return paramInt1 + i + paramInt2;
  }
  
  public final void af(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(88126);
    if (paramInt > this.NQg - this.NRb)
    {
      this.NQg = (this.NRb + paramInt + 64);
      byte[] arrayOfByte = new byte[this.NQg];
      System.arraycopy(this.NQm, 0, arrayOfByte, 0, this.NQh);
      this.NQm = arrayOfByte;
    }
    this.NRc = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.NQm, this.NQh, paramInt);
    this.NQh += paramInt;
    AppMethodBeat.o(88126);
  }
  
  public final void alW(int paramInt)
  {
    AppMethodBeat.i(88124);
    util.W(this.NQm, this.NQh, paramInt);
    this.NQh += 2;
    util.W(this.NQm, this.NQh, 0);
    this.NQh += 2;
    AppMethodBeat.o(88124);
  }
  
  public final int b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88130);
    int i = T(paramArrayOfByte1, paramInt1, this.NQs);
    if (i < 0)
    {
      AppMethodBeat.o(88130);
      return -1;
    }
    paramInt1 = paramInt2 - (i - paramInt1);
    byte[] arrayOfByte = new byte[paramInt1];
    System.arraycopy(paramArrayOfByte1, i, arrayOfByte, 0, paramInt1);
    paramInt1 = d(arrayOfByte, paramInt1, paramArrayOfByte2);
    AppMethodBeat.o(88130);
    return paramInt1;
  }
  
  public final byte[] gxR()
  {
    AppMethodBeat.i(88121);
    byte[] arrayOfByte = new byte[this.NQh];
    System.arraycopy(this.NQm, 0, arrayOfByte, 0, this.NQh);
    AppMethodBeat.o(88121);
    return arrayOfByte;
  }
  
  public final byte[] gxU()
  {
    AppMethodBeat.i(88122);
    byte[] arrayOfByte = new byte[this.NRc];
    System.arraycopy(this.NQm, this.NRb, arrayOfByte, 0, this.NRc);
    AppMethodBeat.o(88122);
    return arrayOfByte;
  }
  
  public final void gxV()
  {
    AppMethodBeat.i(88125);
    util.W(this.NQm, 2, this.NQh - this.NRb);
    AppMethodBeat.o(88125);
  }
  
  public Boolean gxW()
  {
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.a
 * JD-Core Version:    0.7.0.1
 */