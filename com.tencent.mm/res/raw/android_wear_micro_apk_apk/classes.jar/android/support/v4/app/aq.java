package android.support.v4.app;

import android.os.Build.VERSION;

public final class aq
  extends bc
{
  private CharSequence eB;
  
  public final aq a(CharSequence paramCharSequence)
  {
    this.eB = ar.e(paramCharSequence);
    return this;
  }
  
  public final void a(an paraman)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      bo.a(paraman, this.fp, this.fr, this.fq, this.eB);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.aq
 * JD-Core Version:    0.7.0.1
 */