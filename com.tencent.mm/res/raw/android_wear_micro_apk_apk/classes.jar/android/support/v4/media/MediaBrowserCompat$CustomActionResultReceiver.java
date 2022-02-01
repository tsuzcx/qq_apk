package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

class MediaBrowserCompat$CustomActionResultReceiver
  extends ResultReceiver
{
  private final Bundle gl;
  private final e iq;
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (this.iq == null) {
      return;
    }
    switch (paramInt)
    {
    }
    Log.w("MediaBrowserCompat", "Unknown result code: " + paramInt + " (extras=" + this.gl + ", resultData=" + paramBundle + ")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.CustomActionResultReceiver
 * JD-Core Version:    0.7.0.1
 */