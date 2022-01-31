package android.support.v4.media;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

final class k
  implements ServiceConnection
{
  k(j paramj) {}
  
  private void a(Runnable paramRunnable)
  {
    if (Thread.currentThread() == this.gF.gw.getLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    this.gF.gw.post(paramRunnable);
  }
  
  final boolean d(String paramString)
  {
    boolean bool = true;
    if ((this.gF.gD != this) || (this.gF.aJ == 0) || (this.gF.aJ == 1))
    {
      if ((this.gF.aJ != 0) && (this.gF.aJ != 1)) {
        Log.i("MediaBrowserCompat", paramString + " for " + this.gF.gB + " with mServiceConnection=" + this.gF.gD + " this=" + this);
      }
      bool = false;
    }
    return bool;
  }
  
  public final void onServiceConnected(final ComponentName paramComponentName, final IBinder paramIBinder)
  {
    a(new Runnable()
    {
      public final void run()
      {
        if (MediaBrowserCompat.DEBUG)
        {
          Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + paramComponentName + " binder=" + paramIBinder);
          k.this.gF.dump();
        }
        if (!k.this.d("onServiceConnected")) {}
        do
        {
          return;
          k.this.gF.gy = new m(paramIBinder, k.this.gF.gv);
          k.this.gF.gz = new Messenger(k.this.gF.gw);
          k.this.gF.gw.a(k.this.gF.gz);
          k.this.gF.aJ = 2;
          try
          {
            if (MediaBrowserCompat.DEBUG)
            {
              Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
              k.this.gF.dump();
            }
            k.this.gF.gy.a(k.this.gF.mContext, k.this.gF.gz);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            Log.w("MediaBrowserCompat", "RemoteException during connect for " + k.this.gF.gB);
          }
        } while (!MediaBrowserCompat.DEBUG);
        Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
        k.this.gF.dump();
      }
    });
  }
  
  public final void onServiceDisconnected(final ComponentName paramComponentName)
  {
    a(new Runnable()
    {
      public final void run()
      {
        if (MediaBrowserCompat.DEBUG)
        {
          Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + paramComponentName + " this=" + this + " mServiceConnection=" + k.this.gF.gD);
          k.this.gF.dump();
        }
        if (!k.this.d("onServiceDisconnected")) {
          return;
        }
        k.this.gF.gy = null;
        k.this.gF.gz = null;
        k.this.gF.gw.a(null);
        k.this.gF.aJ = 4;
        k.this.gF.gC.onConnectionSuspended();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.k
 * JD-Core Version:    0.7.0.1
 */