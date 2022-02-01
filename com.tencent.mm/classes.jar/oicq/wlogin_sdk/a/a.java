package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public int Ucl;
  public int Ucm;
  public byte[] Ucr;
  public int Ucx;
  int Udf;
  public int Udg;
  public int Udh;
  
  public a()
  {
    AppMethodBeat.i(88120);
    this.Ucl = 128;
    this.Ucm = 0;
    this.Udf = 0;
    this.Udg = 4;
    this.Udh = 0;
    this.Ucr = new byte[this.Ucl];
    this.Ucx = 0;
    AppMethodBeat.o(88120);
  }
  
  private void ad(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88123);
    if (paramInt2 > this.Ucl)
    {
      this.Ucl = (paramInt2 + 128);
      this.Ucr = new byte[this.Ucl];
    }
    this.Ucm = paramInt2;
    System.arraycopy(paramArrayOfByte, paramInt1, this.Ucr, 0, paramInt2);
    this.Ucx = util.an(paramArrayOfByte, paramInt1);
    this.Udh = (paramInt2 - this.Udg);
    AppMethodBeat.o(88123);
  }
  
  private static int ae(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
        } while (util.an(paramArrayOfByte, paramInt1) == paramInt2);
        paramInt1 += 2;
      } while (paramInt1 + 2 > j);
      paramInt1 += util.an(paramArrayOfByte, paramInt1) + 2;
    }
  }
  
  private int d(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88129);
    if (this.Udg >= paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    this.Udh = util.an(paramArrayOfByte1, 2);
    if (this.Udg + this.Udh > paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    paramArrayOfByte2 = d.decrypt(paramArrayOfByte1, this.Udg, this.Udh, paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      AppMethodBeat.o(88129);
      return -1015;
    }
    if (this.Udg + paramArrayOfByte2.length > this.Ucl)
    {
      this.Ucl = (this.Udg + paramArrayOfByte2.length);
      this.Ucr = new byte[this.Ucl];
    }
    this.Ucm = 0;
    System.arraycopy(paramArrayOfByte1, 0, this.Ucr, 0, this.Udg);
    this.Ucm += this.Udg;
    System.arraycopy(paramArrayOfByte2, 0, this.Ucr, this.Ucm, paramArrayOfByte2.length);
    this.Ucm += paramArrayOfByte2.length;
    this.Udh = paramArrayOfByte2.length;
    if (!hPC().booleanValue())
    {
      AppMethodBeat.o(88129);
      return -1005;
    }
    AppMethodBeat.o(88129);
    return 0;
  }
  
  public final int af(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88128);
    int i = ae(paramArrayOfByte, paramInt1, this.Ucx);
    if (i < 0)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    paramInt1 = paramInt2 - (i - paramInt1);
    if (this.Udg >= paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    this.Udh = util.an(paramArrayOfByte, i + 2);
    if (this.Udg + this.Udh > paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    ad(paramArrayOfByte, i, this.Udg + this.Udh);
    if (!hPC().booleanValue())
    {
      AppMethodBeat.o(88128);
      return -1005;
    }
    paramInt1 = this.Udg;
    paramInt2 = this.Udh;
    AppMethodBeat.o(88128);
    return paramInt1 + i + paramInt2;
  }
  
  public final void ak(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(88126);
    if (paramInt > this.Ucl - this.Udg)
    {
      this.Ucl = (this.Udg + paramInt + 64);
      byte[] arrayOfByte = new byte[this.Ucl];
      System.arraycopy(this.Ucr, 0, arrayOfByte, 0, this.Ucm);
      this.Ucr = arrayOfByte;
    }
    this.Udh = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.Ucr, this.Ucm, paramInt);
    this.Ucm += paramInt;
    AppMethodBeat.o(88126);
  }
  
  public final void awj(int paramInt)
  {
    AppMethodBeat.i(88124);
    util.ah(this.Ucr, this.Ucm, paramInt);
    this.Ucm += 2;
    util.ah(this.Ucr, this.Ucm, 0);
    this.Ucm += 2;
    AppMethodBeat.o(88124);
  }
  
  public final int c(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88130);
    int i = ae(paramArrayOfByte1, paramInt1, this.Ucx);
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
  
  public final byte[] hPA()
  {
    AppMethodBeat.i(88122);
    byte[] arrayOfByte = new byte[this.Udh];
    System.arraycopy(this.Ucr, this.Udg, arrayOfByte, 0, this.Udh);
    AppMethodBeat.o(88122);
    return arrayOfByte;
  }
  
  public final void hPB()
  {
    AppMethodBeat.i(88125);
    util.ah(this.Ucr, 2, this.Ucm - this.Udg);
    AppMethodBeat.o(88125);
  }
  
  public Boolean hPC()
  {
    return Boolean.TRUE;
  }
  
  public final byte[] hPx()
  {
    AppMethodBeat.i(88121);
    byte[] arrayOfByte = new byte[this.Ucm];
    System.arraycopy(this.Ucr, 0, arrayOfByte, 0, this.Ucm);
    AppMethodBeat.o(88121);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.a
 * JD-Core Version:    0.7.0.1
 */