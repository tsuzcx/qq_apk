package org.apache.commons.a.a;

import java.io.InputStream;

public abstract class a
  extends InputStream
{
  private long bytesRead = 0L;
  
  protected final void aNq(int paramInt)
  {
    long l = paramInt;
    if (l != -1L) {
      this.bytesRead = (l + this.bytesRead);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     org.apache.commons.a.a.a
 * JD-Core Version:    0.7.0.1
 */