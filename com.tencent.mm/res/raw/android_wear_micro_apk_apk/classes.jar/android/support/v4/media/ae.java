package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat.Token;
import java.util.List;

abstract interface ae
{
  public abstract void a(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle);
  
  public abstract void a(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle);
  
  public abstract void aN();
  
  public abstract IBinder asBinder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.ae
 * JD-Core Version:    0.7.0.1
 */