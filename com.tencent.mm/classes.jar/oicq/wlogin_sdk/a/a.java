package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public int Onm;
  public int Onn;
  public byte[] Ons;
  public int Ony;
  int Oog;
  public int Ooh;
  public int Ooi;
  
  public a()
  {
    AppMethodBeat.i(88120);
    this.Onm = 128;
    this.Onn = 0;
    this.Oog = 0;
    this.Ooh = 4;
    this.Ooi = 0;
    this.Ons = new byte[this.Onm];
    this.Ony = 0;
    AppMethodBeat.o(88120);
  }
  
  private void T(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88123);
    if (paramInt2 > this.Onm)
    {
      this.Onm = (paramInt2 + 128);
      this.Ons = new byte[this.Onm];
    }
    this.Onn = paramInt2;
    System.arraycopy(paramArrayOfByte, paramInt1, this.Ons, 0, paramInt2);
    this.Ony = util.am(paramArrayOfByte, paramInt1);
    this.Ooi = (paramInt2 - this.Ooh);
    AppMethodBeat.o(88123);
  }
  
  private static int U(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
        } while (util.am(paramArrayOfByte, paramInt1) == paramInt2);
        paramInt1 += 2;
      } while (paramInt1 + 2 > j);
      paramInt1 += util.am(paramArrayOfByte, paramInt1) + 2;
    }
  }
  
  private int d(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88129);
    if (this.Ooh >= paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    this.Ooi = util.am(paramArrayOfByte1, 2);
    if (this.Ooh + this.Ooi > paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    paramArrayOfByte2 = d.decrypt(paramArrayOfByte1, this.Ooh, this.Ooi, paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      AppMethodBeat.o(88129);
      return -1015;
    }
    if (this.Ooh + paramArrayOfByte2.length > this.Onm)
    {
      this.Onm = (this.Ooh + paramArrayOfByte2.length);
      this.Ons = new byte[this.Onm];
    }
    this.Onn = 0;
    System.arraycopy(paramArrayOfByte1, 0, this.Ons, 0, this.Ooh);
    this.Onn += this.Ooh;
    System.arraycopy(paramArrayOfByte2, 0, this.Ons, this.Onn, paramArrayOfByte2.length);
    this.Onn += paramArrayOfByte2.length;
    this.Ooi = paramArrayOfByte2.length;
    if (!gCy().booleanValue())
    {
      AppMethodBeat.o(88129);
      return -1005;
    }
    AppMethodBeat.o(88129);
    return 0;
  }
  
  public final int V(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88128);
    int i = U(paramArrayOfByte, paramInt1, this.Ony);
    if (i < 0)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    paramInt1 = paramInt2 - (i - paramInt1);
    if (this.Ooh >= paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    this.Ooi = util.am(paramArrayOfByte, i + 2);
    if (this.Ooh + this.Ooi > paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    T(paramArrayOfByte, i, this.Ooh + this.Ooi);
    if (!gCy().booleanValue())
    {
      AppMethodBeat.o(88128);
      return -1005;
    }
    paramInt1 = this.Ooh;
    paramInt2 = this.Ooi;
    AppMethodBeat.o(88128);
    return paramInt1 + i + paramInt2;
  }
  
  public final void aj(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(88126);
    if (paramInt > this.Onm - this.Ooh)
    {
      this.Onm = (this.Ooh + paramInt + 64);
      byte[] arrayOfByte = new byte[this.Onm];
      System.arraycopy(this.Ons, 0, arrayOfByte, 0, this.Onn);
      this.Ons = arrayOfByte;
    }
    this.Ooi = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.Ons, this.Onn, paramInt);
    this.Onn += paramInt;
    AppMethodBeat.o(88126);
  }
  
  public final void amG(int paramInt)
  {
    AppMethodBeat.i(88124);
    util.X(this.Ons, this.Onn, paramInt);
    this.Onn += 2;
    util.X(this.Ons, this.Onn, 0);
    this.Onn += 2;
    AppMethodBeat.o(88124);
  }
  
  public final int b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88130);
    int i = U(paramArrayOfByte1, paramInt1, this.Ony);
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
  
  public final byte[] gCt()
  {
    AppMethodBeat.i(88121);
    byte[] arrayOfByte = new byte[this.Onn];
    System.arraycopy(this.Ons, 0, arrayOfByte, 0, this.Onn);
    AppMethodBeat.o(88121);
    return arrayOfByte;
  }
  
  public final byte[] gCw()
  {
    AppMethodBeat.i(88122);
    byte[] arrayOfByte = new byte[this.Ooi];
    System.arraycopy(this.Ons, this.Ooh, arrayOfByte, 0, this.Ooi);
    AppMethodBeat.o(88122);
    return arrayOfByte;
  }
  
  public final void gCx()
  {
    AppMethodBeat.i(88125);
    util.X(this.Ons, 2, this.Onn - this.Ooh);
    AppMethodBeat.o(88125);
  }
  
  public Boolean gCy()
  {
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.a
 * JD-Core Version:    0.7.0.1
 */