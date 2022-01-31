package android.support.v4.media.session;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;

final class p
  implements l
{
  private d ig;
  
  public p(MediaSessionCompat.Token paramToken)
  {
    this.ig = e.b((IBinder)paramToken.bc());
  }
  
  public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent == null) {
      throw new IllegalArgumentException("event may not be null.");
    }
    try
    {
      this.ig.a(paramKeyEvent);
      return false;
    }
    catch (RemoteException paramKeyEvent)
    {
      for (;;)
      {
        Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", paramKeyEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.p
 * JD-Core Version:    0.7.0.1
 */