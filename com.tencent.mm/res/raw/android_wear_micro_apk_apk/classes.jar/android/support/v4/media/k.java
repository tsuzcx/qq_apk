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
  
  private void c(Runnable paramRunnable)
  {
    if (Thread.currentThread() == this.iD.it.getLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    this.iD.it.post(paramRunnable);
  }
  
  final boolean d(String paramString)
  {
    boolean bool = true;
    if ((this.iD.iB != this) || (this.iD.cs == 0) || (this.iD.cs == 1))
    {
      if ((this.iD.cs != 0) && (this.iD.cs != 1)) {
        Log.i("MediaBrowserCompat", paramString + " for " + this.iD.iz + " with mServiceConnection=" + this.iD.iB + " this=" + this);
      }
      bool = false;
    }
    return bool;
  }
  
  public final void onServiceConnected(final ComponentName paramComponentName, final IBinder paramIBinder)
  {
    c(new Runnable()
    {
      public final void run()
      {
        if (MediaBrowserCompat.DEBUG)
        {
          Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + paramComponentName + " binder=" + paramIBinder);
          k.this.iD.dump();
        }
        if (!k.this.d("onServiceConnected")) {}
        do
        {
          return;
          k.this.iD.iw = new m(paramIBinder, k.this.iD.is);
          k.this.iD.ix = new Messenger(k.this.iD.it);
          k.this.iD.it.a(k.this.iD.ix);
          k.this.iD.cs = 2;
          try
          {
            if (MediaBrowserCompat.DEBUG)
            {
              Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
              k.this.iD.dump();
            }
            k.this.iD.iw.a(k.this.iD.mContext, k.this.iD.ix);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            Log.w("MediaBrowserCompat", "RemoteException during connect for " + k.this.iD.iz);
          }
        } while (!MediaBrowserCompat.DEBUG);
        Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
        k.this.iD.dump();
      }
    });
  }
  
  public final void onServiceDisconnected(final ComponentName paramComponentName)
  {
    c(new Runnable()
    {
      public final void run()
      {
        if (MediaBrowserCompat.DEBUG)
        {
          Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + paramComponentName + " this=" + this + " mServiceConnection=" + k.this.iD.iB);
          k.this.iD.dump();
        }
        if (!k.this.d("onServiceDisconnected")) {
          return;
        }
        k.this.iD.iw = null;
        k.this.iD.ix = null;
        k.this.iD.it.a(null);
        k.this.iD.cs = 4;
        k.this.iD.iA.onConnectionSuspended();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.k
 * JD-Core Version:    0.7.0.1
 */