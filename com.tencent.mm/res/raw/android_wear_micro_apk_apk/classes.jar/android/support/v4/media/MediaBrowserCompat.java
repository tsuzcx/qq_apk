package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.util.Log;

public final class MediaBrowserCompat
{
  static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
  private final f gn;
  
  public MediaBrowserCompat(Context paramContext, ComponentName paramComponentName, b paramb)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.gn = new i(paramContext, paramComponentName, paramb, null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.gn = new h(paramContext, paramComponentName, paramb, null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.gn = new g(paramContext, paramComponentName, paramb, null);
      return;
    }
    this.gn = new j(paramContext, paramComponentName, paramb, null);
  }
  
  public final MediaSessionCompat.Token aG()
  {
    return this.gn.aG();
  }
  
  public final void connect()
  {
    this.gn.connect();
  }
  
  public final void disconnect()
  {
    this.gn.disconnect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat
 * JD-Core Version:    0.7.0.1
 */