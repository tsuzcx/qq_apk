package android.support.v4.media;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.IBinder;
import java.lang.ref.WeakReference;

public abstract class o
{
  private final Object iL;
  private final IBinder iM = new Binder();
  WeakReference<n> iN;
  
  public o()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.iL = new y(new q(this));
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.iL = new v(new p(this));
      return;
    }
    this.iL = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.o
 * JD-Core Version:    0.7.0.1
 */