package a.a.a.a;

import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class e$b
  extends InflaterInputStream
{
  public d a;
  public long b = 0L;
  
  public e$b(InputStream paramInputStream, Inflater paramInflater, int paramInt, d paramd)
  {
    super(paramInputStream, paramInflater, paramInt);
    this.a = paramd;
  }
  
  public int available()
  {
    if (super.available() == 0) {
      return 0;
    }
    return (int)(this.a.c - this.b);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      this.b += paramInt1;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     a.a.a.a.e.b
 * JD-Core Version:    0.7.0.1
 */