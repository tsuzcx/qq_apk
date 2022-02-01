package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public int LVH;
  public int LVI;
  public byte[] LVN;
  public int LVT;
  int LWB;
  public int LWC;
  public int LWD;
  
  public a()
  {
    AppMethodBeat.i(88120);
    this.LVH = 128;
    this.LVI = 0;
    this.LWB = 0;
    this.LWC = 4;
    this.LWD = 0;
    this.LVN = new byte[this.LVH];
    this.LVT = 0;
    AppMethodBeat.o(88120);
  }
  
  private void R(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88123);
    if (paramInt2 > this.LVH)
    {
      this.LVH = (paramInt2 + 128);
      this.LVN = new byte[this.LVH];
    }
    this.LVI = paramInt2;
    System.arraycopy(paramArrayOfByte, paramInt1, this.LVN, 0, paramInt2);
    this.LVT = util.ah(paramArrayOfByte, paramInt1);
    this.LWD = (paramInt2 - this.LWC);
    AppMethodBeat.o(88123);
  }
  
  private static int S(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
        } while (util.ah(paramArrayOfByte, paramInt1) == paramInt2);
        paramInt1 += 2;
      } while (paramInt1 + 2 > j);
      paramInt1 += util.ah(paramArrayOfByte, paramInt1) + 2;
    }
  }
  
  private int d(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88129);
    if (this.LWC >= paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    this.LWD = util.ah(paramArrayOfByte1, 2);
    if (this.LWC + this.LWD > paramInt)
    {
      AppMethodBeat.o(88129);
      return -1;
    }
    paramArrayOfByte2 = d.decrypt(paramArrayOfByte1, this.LWC, this.LWD, paramArrayOfByte2);
    if (paramArrayOfByte2 == null)
    {
      AppMethodBeat.o(88129);
      return -1015;
    }
    if (this.LWC + paramArrayOfByte2.length > this.LVH)
    {
      this.LVH = (this.LWC + paramArrayOfByte2.length);
      this.LVN = new byte[this.LVH];
    }
    this.LVI = 0;
    System.arraycopy(paramArrayOfByte1, 0, this.LVN, 0, this.LWC);
    this.LVI += this.LWC;
    System.arraycopy(paramArrayOfByte2, 0, this.LVN, this.LVI, paramArrayOfByte2.length);
    this.LVI += paramArrayOfByte2.length;
    this.LWD = paramArrayOfByte2.length;
    if (!gfy().booleanValue())
    {
      AppMethodBeat.o(88129);
      return -1005;
    }
    AppMethodBeat.o(88129);
    return 0;
  }
  
  public final int T(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88128);
    int i = S(paramArrayOfByte, paramInt1, this.LVT);
    if (i < 0)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    paramInt1 = paramInt2 - (i - paramInt1);
    if (this.LWC >= paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    this.LWD = util.ah(paramArrayOfByte, i + 2);
    if (this.LWC + this.LWD > paramInt1)
    {
      AppMethodBeat.o(88128);
      return -1;
    }
    R(paramArrayOfByte, i, this.LWC + this.LWD);
    if (!gfy().booleanValue())
    {
      AppMethodBeat.o(88128);
      return -1005;
    }
    paramInt1 = this.LWC;
    paramInt2 = this.LWD;
    AppMethodBeat.o(88128);
    return paramInt1 + i + paramInt2;
  }
  
  public final void ae(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(88126);
    if (paramInt > this.LVH - this.LWC)
    {
      this.LVH = (this.LWC + paramInt + 64);
      byte[] arrayOfByte = new byte[this.LVH];
      System.arraycopy(this.LVN, 0, arrayOfByte, 0, this.LVI);
      this.LVN = arrayOfByte;
    }
    this.LWD = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.LVN, this.LVI, paramInt);
    this.LVI += paramInt;
    AppMethodBeat.o(88126);
  }
  
  public final void ajl(int paramInt)
  {
    AppMethodBeat.i(88124);
    util.V(this.LVN, this.LVI, paramInt);
    this.LVI += 2;
    util.V(this.LVN, this.LVI, 0);
    this.LVI += 2;
    AppMethodBeat.o(88124);
  }
  
  public final int b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88130);
    int i = S(paramArrayOfByte1, paramInt1, this.LVT);
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
  
  public final byte[] gft()
  {
    AppMethodBeat.i(88121);
    byte[] arrayOfByte = new byte[this.LVI];
    System.arraycopy(this.LVN, 0, arrayOfByte, 0, this.LVI);
    AppMethodBeat.o(88121);
    return arrayOfByte;
  }
  
  public final byte[] gfw()
  {
    AppMethodBeat.i(88122);
    byte[] arrayOfByte = new byte[this.LWD];
    System.arraycopy(this.LVN, this.LWC, arrayOfByte, 0, this.LWD);
    AppMethodBeat.o(88122);
    return arrayOfByte;
  }
  
  public final void gfx()
  {
    AppMethodBeat.i(88125);
    util.V(this.LVN, 2, this.LVI - this.LWC);
    AppMethodBeat.o(88125);
  }
  
  public Boolean gfy()
  {
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.a
 * JD-Core Version:    0.7.0.1
 */