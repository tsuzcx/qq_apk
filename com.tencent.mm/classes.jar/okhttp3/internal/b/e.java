package okhttp3.internal.b;

import java.io.IOException;

public final class e
  extends RuntimeException
{
  public IOException ajPt;
  public IOException ajPu;
  
  public e(IOException paramIOException)
  {
    super(paramIOException);
    this.ajPt = paramIOException;
    this.ajPu = paramIOException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.b.e
 * JD-Core Version:    0.7.0.1
 */