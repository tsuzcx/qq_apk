package okhttp3;

import j.f;
import j.h;
import java.io.Closeable;
import okhttp3.internal.c;

public abstract class aa
  implements Closeable
{
  public static aa ea(byte[] paramArrayOfByte)
  {
    f localf = new f().ed(paramArrayOfByte);
    long l = paramArrayOfByte.length;
    if (localf == null) {
      throw new NullPointerException("source == null");
    }
    new aa()
    {
      public final long kGA()
      {
        return this.ajNX;
      }
      
      public final h kGB()
      {
        return this.ajNY;
      }
      
      public final t kGz()
      {
        return this.ajNN;
      }
    };
  }
  
  public void close()
  {
    c.closeQuietly(kGB());
  }
  
  public abstract long kGA();
  
  public abstract h kGB();
  
  public abstract t kGz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.aa
 * JD-Core Version:    0.7.0.1
 */