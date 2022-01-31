package android.support.v4.media;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.IBinder;
import java.lang.ref.WeakReference;

public abstract class o
{
  private final Object gN;
  private final IBinder gO;
  WeakReference<n> gP;
  
  public o()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.gN = new y(new q(this));
      this.gO = null;
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.gN = new v(new p(this));
      this.gO = new Binder();
      return;
    }
    this.gN = null;
    this.gO = new Binder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.o
 * JD-Core Version:    0.7.0.1
 */