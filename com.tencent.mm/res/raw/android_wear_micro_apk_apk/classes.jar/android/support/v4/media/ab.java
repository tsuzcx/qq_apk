package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.support.v4.b.a;
import android.support.v4.b.m;
import java.util.HashMap;
import java.util.List;

final class ab
  implements IBinder.DeathRecipient
{
  String ja;
  Bundle jb;
  ae jc;
  aa jd;
  HashMap<String, List<m<IBinder, Bundle>>> je = new HashMap();
  
  ab(MediaBrowserServiceCompat paramMediaBrowserServiceCompat) {}
  
  public final void binderDied()
  {
    this.iY.iT.post(new Runnable()
    {
      public final void run()
      {
        ab.this.iY.iR.remove(ab.this.jc.asBinder());
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.ab
 * JD-Core Version:    0.7.0.1
 */