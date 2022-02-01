package a.a.a.a;

import java.io.InputStream;
import java.io.RandomAccessFile;

public class e$a
  extends InputStream
{
  public RandomAccessFile a;
  public long b;
  public long c;
  
  public e$a(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    this.a = paramRandomAccessFile;
    this.b = paramLong;
    this.c = paramRandomAccessFile.length();
  }
  
  public int available()
  {
    if (this.b < this.c) {
      return 1;
    }
    return 0;
  }
  
  public int read()
  {
    byte[] arrayOfByte = new byte[1];
    int j = read(arrayOfByte, 0, 1);
    int i = -1;
    if (j != -1) {
      i = arrayOfByte[0] & 0xFF;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    synchronized (this.a)
    {
      this.a.seek(this.b);
      int i = paramInt2;
      if (paramInt2 > this.c - this.b) {
        i = (int)(this.c - this.b);
      }
      paramInt1 = this.a.read(paramArrayOfByte, paramInt1, i);
      if (paramInt1 > 0)
      {
        this.b += paramInt1;
        return paramInt1;
      }
      return -1;
    }
  }
  
  public long skip(long paramLong)
  {
    long l2 = this.c - this.b;
    long l1 = paramLong;
    if (paramLong > l2) {
      l1 = l2;
    }
    this.b += l1;
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     a.a.a.a.e.a
 * JD-Core Version:    0.7.0.1
 */