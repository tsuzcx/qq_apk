package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.app.i;
import java.lang.ref.WeakReference;

class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver
  extends ResultReceiver
{
  private WeakReference<MediaControllerCompat.MediaControllerImplApi21> kd;
  
  public MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver(MediaControllerCompat.MediaControllerImplApi21 paramMediaControllerImplApi21, Handler paramHandler)
  {
    super(paramHandler);
    this.kd = new WeakReference(paramMediaControllerImplApi21);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    MediaControllerCompat.MediaControllerImplApi21 localMediaControllerImplApi21 = (MediaControllerCompat.MediaControllerImplApi21)this.kd.get();
    if ((localMediaControllerImplApi21 == null) || (paramBundle == null)) {
      return;
    }
    MediaControllerCompat.MediaControllerImplApi21.a(localMediaControllerImplApi21, e.b(i.a(paramBundle, "android.support.v4.media.session.EXTRA_BINDER")));
    MediaControllerCompat.MediaControllerImplApi21.a(localMediaControllerImplApi21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.ExtraBinderRequestResultReceiver
 * JD-Core Version:    0.7.0.1
 */