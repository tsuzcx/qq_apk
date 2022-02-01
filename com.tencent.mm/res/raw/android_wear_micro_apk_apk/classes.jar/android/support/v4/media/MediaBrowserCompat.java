package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.util.Log;

public final class MediaBrowserCompat
{
  static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
  private final f ik;
  
  public MediaBrowserCompat(Context paramContext, ComponentName paramComponentName, b paramb)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.ik = new i(paramContext, paramComponentName, paramb, null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.ik = new h(paramContext, paramComponentName, paramb, null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.ik = new g(paramContext, paramComponentName, paramb, null);
      return;
    }
    this.ik = new j(paramContext, paramComponentName, paramb, null);
  }
  
  public final MediaSessionCompat.Token aW()
  {
    return this.ik.aW();
  }
  
  public final void connect()
  {
    this.ik.connect();
  }
  
  public final void disconnect()
  {
    this.ik.disconnect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat
 * JD-Core Version:    0.7.0.1
 */