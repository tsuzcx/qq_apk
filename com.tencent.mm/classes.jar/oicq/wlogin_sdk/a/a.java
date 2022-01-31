package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public class a
{
  int xqY = 0;
  public int xqZ = 4;
  public int xqe = 128;
  public int xqf = 0;
  public byte[] xqk = new byte[this.xqe];
  public int xqq = 0;
  public int xra = 0;
  
  private static int A(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = paramArrayOfByte.length;
    for (;;)
    {
      if (paramInt1 >= j) {}
      do
      {
        int i = -1;
        do
        {
          return i;
          if (paramInt1 + 2 > j) {
            break;
          }
          i = paramInt1;
        } while (util.ad(paramArrayOfByte, paramInt1) == paramInt2);
        paramInt1 += 2;
      } while (paramInt1 + 2 > j);
      paramInt1 += util.ad(paramArrayOfByte, paramInt1) + 2;
    }
  }
  
  public final int B(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = A(paramArrayOfByte, paramInt1, this.xqq);
    if (i < 0) {}
    do
    {
      do
      {
        return -1;
        paramInt1 = paramInt2 - (i - paramInt1);
      } while (this.xqZ >= paramInt1);
      this.xra = util.ad(paramArrayOfByte, i + 2);
    } while (this.xqZ + this.xra > paramInt1);
    paramInt1 = this.xqZ + this.xra;
    if (paramInt1 > this.xqe)
    {
      this.xqe = (paramInt1 + 128);
      this.xqk = new byte[this.xqe];
    }
    this.xqf = paramInt1;
    System.arraycopy(paramArrayOfByte, i, this.xqk, 0, paramInt1);
    this.xqq = util.ad(paramArrayOfByte, i);
    this.xra = (paramInt1 - this.xqZ);
    if (!cUG().booleanValue()) {
      return -1005;
    }
    return this.xqZ + i + this.xra;
  }
  
  public final void KP(int paramInt)
  {
    util.D(this.xqk, this.xqf, paramInt);
    this.xqf += 2;
    util.D(this.xqk, this.xqf, 0);
    this.xqf += 2;
  }
  
  public final void aa(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > this.xqe - this.xqZ)
    {
      this.xqe = (this.xqZ + paramInt + 64);
      byte[] arrayOfByte = new byte[this.xqe];
      System.arraycopy(this.xqk, 0, arrayOfByte, 0, this.xqf);
      this.xqk = arrayOfByte;
    }
    this.xra = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.xqk, this.xqf, paramInt);
    this.xqf += paramInt;
  }
  
  public final int b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    int i = A(paramArrayOfByte1, paramInt1, this.xqq);
    if (i < 0) {}
    byte[] arrayOfByte;
    do
    {
      do
      {
        return -1;
        paramInt1 = paramInt2 - (i - paramInt1);
        arrayOfByte = new byte[paramInt1];
        System.arraycopy(paramArrayOfByte1, i, arrayOfByte, 0, paramInt1);
      } while (this.xqZ >= paramInt1);
      this.xra = util.ad(arrayOfByte, 2);
    } while (this.xqZ + this.xra > paramInt1);
    paramArrayOfByte1 = d.decrypt(arrayOfByte, this.xqZ, this.xra, paramArrayOfByte2);
    if (paramArrayOfByte1 == null) {
      return -1015;
    }
    if (this.xqZ + paramArrayOfByte1.length > this.xqe)
    {
      this.xqe = (this.xqZ + paramArrayOfByte1.length);
      this.xqk = new byte[this.xqe];
    }
    this.xqf = 0;
    System.arraycopy(arrayOfByte, 0, this.xqk, 0, this.xqZ);
    this.xqf += this.xqZ;
    System.arraycopy(paramArrayOfByte1, 0, this.xqk, this.xqf, paramArrayOfByte1.length);
    this.xqf += paramArrayOfByte1.length;
    this.xra = paramArrayOfByte1.length;
    if (!cUG().booleanValue()) {
      return -1005;
    }
    return 0;
  }
  
  public final byte[] cUB()
  {
    byte[] arrayOfByte = new byte[this.xqf];
    System.arraycopy(this.xqk, 0, arrayOfByte, 0, this.xqf);
    return arrayOfByte;
  }
  
  public final byte[] cUE()
  {
    byte[] arrayOfByte = new byte[this.xra];
    System.arraycopy(this.xqk, this.xqZ, arrayOfByte, 0, this.xra);
    return arrayOfByte;
  }
  
  public final void cUF()
  {
    util.D(this.xqk, 2, this.xqf - this.xqZ);
  }
  
  public Boolean cUG()
  {
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.a
 * JD-Core Version:    0.7.0.1
 */