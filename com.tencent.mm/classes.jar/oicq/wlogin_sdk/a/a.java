package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public int KhY;
  public int KhZ;
  int KiS;
  public int KiT;
  public int KiU;
  public byte[] Kie;
  public int Kik;
  
  public a()
  {
    AppMethodBeat.i(88120);
    this.KhY = 128;
    this.KhZ = 0;
    this.KiS = 0;
    this.KiT = 4;
    this.KiU = 0;
    this.Kie = new byte[this.KhY];
    this.Kik = 0;
    AppMethodBeat.o(88120);
  }
  
  private void S(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88123);
    if (paramInt2 > this.KhY)
    {
      this.KhY = (paramInt2 + 128);
      this.Kie = new byte[this.KhY];
    }
    this.KhZ = paramInt2;
    System.arraycopy(paramArrayOfByte, paramInt1, this.Kie, 0, paramInt2);
    this.Kik = util.ai(paramArrayOfByte, paramInt1);
    this.KiU = (paramInt2 - this.KiT);
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
    if (this.KiT >= paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    this.KiU = util.ai(paramArrayOfByte1, 2);
    if (this.KiT + this.KiU > paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    paramArrayOfByte2 = d.decrypt(paramArrayOfByte1, this.KiT, this.KiU, paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      AppMethodBeat.o(88129);
      return -1015;
    }
    if (this.KiT + paramArrayOfByte2.length > this.KhY)
    {
      this.KhY = (this.KiT + paramArrayOfByte2.length);
      this.Kie = new byte[this.KhY];
    }
    this.KhZ = 0;
    System.arraycopy(paramArrayOfByte1, 0, this.Kie, 0, this.KiT);
    this.KhZ += this.KiT;
    System.arraycopy(paramArrayOfByte2, 0, this.Kie, this.KhZ, paramArrayOfByte2.length);
    this.KhZ += paramArrayOfByte2.length;
    this.KiU = paramArrayOfByte2.length;
    if (!fMI().booleanValue())
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
    int i = T(paramArrayOfByte, paramInt1, this.Kik);
    if (i < 0)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    paramInt1 = paramInt2 - (i - paramInt1);
    if (this.KiT >= paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    this.KiU = util.ai(paramArrayOfByte, i + 2);
    if (this.KiT + this.KiU > paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    S(paramArrayOfByte, i, this.KiT + this.KiU);
    if (!fMI().booleanValue())
    {
      AppMethodBeat.o(88128);
      return -1005;
    }
    paramInt1 = this.KiT;
    paramInt2 = this.KiU;
    AppMethodBeat.o(88128);
    return paramInt1 + i + paramInt2;
  }
  
  public final void af(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(88126);
    if (paramInt > this.KhY - this.KiT)
    {
      this.KhY = (this.KiT + paramInt + 64);
      byte[] arrayOfByte = new byte[this.KhY];
      System.arraycopy(this.Kie, 0, arrayOfByte, 0, this.KhZ);
      this.Kie = arrayOfByte;
    }
    this.KiU = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.Kie, this.KhZ, paramInt);
    this.KhZ += paramInt;
    AppMethodBeat.o(88126);
  }
  
  public final void agp(int paramInt)
  {
    AppMethodBeat.i(88124);
    util.W(this.Kie, this.KhZ, paramInt);
    this.KhZ += 2;
    util.W(this.Kie, this.KhZ, 0);
    this.KhZ += 2;
    AppMethodBeat.o(88124);
  }
  
  public final int b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88130);
    int i = T(paramArrayOfByte1, paramInt1, this.Kik);
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
  
  public final byte[] fMD()
  {
    AppMethodBeat.i(88121);
    byte[] arrayOfByte = new byte[this.KhZ];
    System.arraycopy(this.Kie, 0, arrayOfByte, 0, this.KhZ);
    AppMethodBeat.o(88121);
    return arrayOfByte;
  }
  
  public final byte[] fMG()
  {
    AppMethodBeat.i(88122);
    byte[] arrayOfByte = new byte[this.KiU];
    System.arraycopy(this.Kie, this.KiT, arrayOfByte, 0, this.KiU);
    AppMethodBeat.o(88122);
    return arrayOfByte;
  }
  
  public final void fMH()
  {
    AppMethodBeat.i(88125);
    util.W(this.Kie, 2, this.KhZ - this.KiT);
    AppMethodBeat.o(88125);
  }
  
  public Boolean fMI()
  {
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.a
 * JD-Core Version:    0.7.0.1
 */