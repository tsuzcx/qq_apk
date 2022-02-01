package android.support.v4.media.session;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.b;
import android.util.Log;
import android.view.KeyEvent;

final class g
  extends b
{
  private final Intent jO;
  private final BroadcastReceiver.PendingResult jP;
  private MediaBrowserCompat jQ;
  private final Context mContext;
  
  g(Context paramContext, Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult)
  {
    this.mContext = paramContext;
    this.jO = paramIntent;
    this.jP = paramPendingResult;
  }
  
  private void finish()
  {
    this.jQ.disconnect();
    this.jP.finish();
  }
  
  final void a(MediaBrowserCompat paramMediaBrowserCompat)
  {
    this.jQ = paramMediaBrowserCompat;
  }
  
  public final void onConnected()
  {
    try
    {
      new MediaControllerCompat(this.mContext, this.jQ.aW()).dispatchMediaButtonEvent((KeyEvent)this.jO.getParcelableExtra("android.intent.extra.KEY_EVENT"));
      finish();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("MediaButtonReceiver", "Failed to create a media controller", localRemoteException);
      }
    }
  }
  
  public final void onConnectionFailed()
  {
    finish();
  }
  
  public final void onConnectionSuspended()
  {
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.g
 * JD-Core Version:    0.7.0.1
 */