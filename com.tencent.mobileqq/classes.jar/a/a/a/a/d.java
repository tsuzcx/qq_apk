package a.a.a.a;

import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

public class d
  implements c, Cloneable
{
  public String a;
  public long b = -1L;
  public long c = -1L;
  public int d = -1;
  public byte[] e;
  public int f = -1;
  public long g = -1L;
  public int h = -1;
  public int i = -1;
  public byte[] j;
  
  public d(byte[] paramArrayOfByte, InputStream paramInputStream)
  {
    b.a(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = new a(paramArrayOfByte, 0, paramArrayOfByte.length, ByteOrder.LITTLE_ENDIAN);
    paramArrayOfByte.a();
    paramArrayOfByte.b();
    paramArrayOfByte.b();
    paramArrayOfByte.b();
    this.d = paramArrayOfByte.b();
    paramArrayOfByte.b();
    paramArrayOfByte.b();
    paramArrayOfByte.a();
    this.b = (paramArrayOfByte.a() & 0xFFFFFFFF);
    this.c = (paramArrayOfByte.a() & 0xFFFFFFFF);
    this.f = paramArrayOfByte.b();
    this.h = paramArrayOfByte.b();
    this.i = paramArrayOfByte.b();
    paramArrayOfByte.b();
    paramArrayOfByte.b();
    paramArrayOfByte.a();
    this.g = (paramArrayOfByte.a() & 0xFFFFFFFF);
    this.j = new byte[this.f];
    paramArrayOfByte = this.j;
    b.a(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = this.j;
    this.a = new String(paramArrayOfByte, 0, paramArrayOfByte.length, StandardCharsets.UTF_8);
    int k = this.i;
    if (k > 0)
    {
      paramArrayOfByte = new byte[k];
      b.a(paramInputStream, paramArrayOfByte, 0, k);
      new String(paramArrayOfByte, 0, paramArrayOfByte.length, StandardCharsets.UTF_8);
    }
    k = this.h;
    if (k > 0)
    {
      this.e = new byte[k];
      b.a(paramInputStream, this.e, 0, k);
    }
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     a.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */