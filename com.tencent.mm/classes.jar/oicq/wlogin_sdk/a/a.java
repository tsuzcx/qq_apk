package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public int abFA;
  public int abFB;
  public byte[] abFG;
  public int abFM;
  int abGu;
  public int abGv;
  public int abGw;
  
  public a()
  {
    AppMethodBeat.i(88120);
    this.abFA = 128;
    this.abFB = 0;
    this.abGu = 0;
    this.abGv = 4;
    this.abGw = 0;
    this.abFG = new byte[this.abFA];
    this.abFM = 0;
    AppMethodBeat.o(88120);
  }
  
  private void ae(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88123);
    if (paramInt2 > this.abFA)
    {
      this.abFA = (paramInt2 + 128);
      this.abFG = new byte[this.abFA];
    }
    this.abFB = paramInt2;
    System.arraycopy(paramArrayOfByte, paramInt1, this.abFG, 0, paramInt2);
    this.abFM = util.ap(paramArrayOfByte, paramInt1);
    this.abGw = (paramInt2 - this.abGv);
    AppMethodBeat.o(88123);
  }
  
  private static int af(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
        } while (util.ap(paramArrayOfByte, paramInt1) == paramInt2);
        paramInt1 += 2;
      } while (paramInt1 + 2 > j);
      paramInt1 += util.ap(paramArrayOfByte, paramInt1) + 2;
    }
  }
  
  private int d(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88129);
    if (this.abGv >= paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    this.abGw = util.ap(paramArrayOfByte1, 2);
    if (this.abGv + this.abGw > paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    paramArrayOfByte2 = d.decrypt(paramArrayOfByte1, this.abGv, this.abGw, paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      AppMethodBeat.o(88129);
      return -1015;
    }
    if (this.abGv + paramArrayOfByte2.length > this.abFA)
    {
      this.abFA = (this.abGv + paramArrayOfByte2.length);
      this.abFG = new byte[this.abFA];
    }
    this.abFB = 0;
    System.arraycopy(paramArrayOfByte1, 0, this.abFG, 0, this.abGv);
    this.abFB += this.abGv;
    System.arraycopy(paramArrayOfByte2, 0, this.abFG, this.abFB, paramArrayOfByte2.length);
    this.abFB += paramArrayOfByte2.length;
    this.abGw = paramArrayOfByte2.length;
    if (!iUK().booleanValue())
    {
      AppMethodBeat.o(88129);
      return -1005;
    }
    AppMethodBeat.o(88129);
    return 0;
  }
  
  public final void aGe(int paramInt)
  {
    AppMethodBeat.i(88124);
    util.ai(this.abFG, this.abFB, paramInt);
    this.abFB += 2;
    util.ai(this.abFG, this.abFB, 0);
    this.abFB += 2;
    AppMethodBeat.o(88124);
  }
  
  public final int ag(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88128);
    int i = af(paramArrayOfByte, paramInt1, this.abFM);
    if (i < 0)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    paramInt1 = paramInt2 - (i - paramInt1);
    if (this.abGv >= paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    this.abGw = util.ap(paramArrayOfByte, i + 2);
    if (this.abGv + this.abGw > paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    ae(paramArrayOfByte, i, this.abGv + this.abGw);
    if (!iUK().booleanValue())
    {
      AppMethodBeat.o(88128);
      return -1005;
    }
    paramInt1 = this.abGv;
    paramInt2 = this.abGw;
    AppMethodBeat.o(88128);
    return paramInt1 + i + paramInt2;
  }
  
  public final void am(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(88126);
    if (paramInt > this.abFA - this.abGv)
    {
      this.abFA = (this.abGv + paramInt + 64);
      byte[] arrayOfByte = new byte[this.abFA];
      System.arraycopy(this.abFG, 0, arrayOfByte, 0, this.abFB);
      this.abFG = arrayOfByte;
    }
    this.abGw = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.abFG, this.abFB, paramInt);
    this.abFB += paramInt;
    AppMethodBeat.o(88126);
  }
  
  public final int c(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88130);
    int i = af(paramArrayOfByte1, paramInt1, this.abFM);
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
  
  public final byte[] iUF()
  {
    AppMethodBeat.i(88121);
    byte[] arrayOfByte = new byte[this.abFB];
    System.arraycopy(this.abFG, 0, arrayOfByte, 0, this.abFB);
    AppMethodBeat.o(88121);
    return arrayOfByte;
  }
  
  public final byte[] iUI()
  {
    AppMethodBeat.i(88122);
    byte[] arrayOfByte = new byte[this.abGw];
    System.arraycopy(this.abFG, this.abGv, arrayOfByte, 0, this.abGw);
    AppMethodBeat.o(88122);
    return arrayOfByte;
  }
  
  public final void iUJ()
  {
    AppMethodBeat.i(88125);
    util.ai(this.abFG, 2, this.abFB - this.abGv);
    AppMethodBeat.o(88125);
  }
  
  public Boolean iUK()
  {
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.a
 * JD-Core Version:    0.7.0.1
 */