package android.support.v4.media;

import android.media.browse.MediaBrowser.ConnectionCallback;

final class t<T extends s>
  extends MediaBrowser.ConnectionCallback
{
  protected final T iP;
  
  public t(T paramT)
  {
    this.iP = paramT;
  }
  
  public final void onConnected()
  {
    this.iP.onConnected();
  }
  
  public final void onConnectionFailed()
  {
    this.iP.onConnectionFailed();
  }
  
  public final void onConnectionSuspended()
  {
    this.iP.onConnectionSuspended();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.t
 * JD-Core Version:    0.7.0.1
 */