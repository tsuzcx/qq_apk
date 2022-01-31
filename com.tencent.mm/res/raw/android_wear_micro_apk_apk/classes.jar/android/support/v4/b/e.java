package android.support.v4.b;

import android.util.Log;
import java.io.Writer;

public final class e
  extends Writer
{
  private final String bf;
  private StringBuilder je = new StringBuilder(128);
  
  public e(String paramString)
  {
    this.bf = paramString;
  }
  
  private void bj()
  {
    if (this.je.length() > 0)
    {
      Log.d(this.bf, this.je.toString());
      this.je.delete(0, this.je.length());
    }
  }
  
  public final void close()
  {
    bj();
  }
  
  public final void flush()
  {
    bj();
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        bj();
      }
      for (;;)
      {
        i += 1;
        break;
        this.je.append(c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.e
 * JD-Core Version:    0.7.0.1
 */