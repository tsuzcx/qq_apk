package android.support.v4.b;

import android.util.Log;
import java.io.Writer;

public final class e
  extends Writer
{
  private final String cQ;
  private StringBuilder lb = new StringBuilder(128);
  
  public e(String paramString)
  {
    this.cQ = paramString;
  }
  
  private void bA()
  {
    if (this.lb.length() > 0)
    {
      Log.d(this.cQ, this.lb.toString());
      this.lb.delete(0, this.lb.length());
    }
  }
  
  public final void close()
  {
    bA();
  }
  
  public final void flush()
  {
    bA();
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        bA();
      }
      for (;;)
      {
        i += 1;
        break;
        this.lb.append(c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.e
 * JD-Core Version:    0.7.0.1
 */