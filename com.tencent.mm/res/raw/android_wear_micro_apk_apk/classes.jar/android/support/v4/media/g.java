package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.app.i;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.d;
import android.support.v4.media.session.e;
import android.util.Log;

class g
  implements c, f, l
{
  protected final Object ir;
  protected final Bundle is;
  protected final a it = new a(this);
  private final android.support.v4.b.a<String, n> iu = new android.support.v4.b.a();
  protected int iv;
  protected m iw;
  protected Messenger ix;
  private MediaSessionCompat.Token iy;
  final Context mContext;
  
  g(Context paramContext, ComponentName paramComponentName, b paramb, Bundle paramBundle)
  {
    this.mContext = paramContext;
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("extra_client_version", 1);
    this.is = new Bundle(localBundle);
    paramb.io = this;
    paramb = paramb.in;
    paramBundle = this.is;
    this.ir = new MediaBrowser(paramContext, paramComponentName, (MediaBrowser.ConnectionCallback)paramb, paramBundle);
  }
  
  public final void a(Messenger paramMessenger, String paramString, Bundle paramBundle)
  {
    if (this.ix != paramMessenger) {}
    do
    {
      return;
      paramMessenger = (n)this.iu.get(paramString);
      if (paramMessenger != null) {
        break;
      }
    } while (!MediaBrowserCompat.DEBUG);
    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=".concat(String.valueOf(paramString)));
    return;
    paramMessenger.a(this.mContext, paramBundle);
  }
  
  public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle) {}
  
  public final MediaSessionCompat.Token aW()
  {
    if (this.iy == null) {
      this.iy = MediaSessionCompat.Token.m(((MediaBrowser)this.ir).getSessionToken());
    }
    return this.iy;
  }
  
  public final void b(Messenger paramMessenger) {}
  
  public final void connect()
  {
    ((MediaBrowser)this.ir).connect();
  }
  
  public final void disconnect()
  {
    if ((this.iw != null) && (this.ix != null)) {}
    try
    {
      this.iw.e(this.ix);
      ((MediaBrowser)this.ir).disconnect();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
      }
    }
  }
  
  public final void onConnected()
  {
    Object localObject = ((MediaBrowser)this.ir).getExtras();
    if (localObject == null) {}
    for (;;)
    {
      return;
      this.iv = ((Bundle)localObject).getInt("extra_service_version", 0);
      IBinder localIBinder = i.a((Bundle)localObject, "extra_messenger");
      if (localIBinder != null)
      {
        this.iw = new m(localIBinder, this.is);
        this.ix = new Messenger(this.it);
        this.it.a(this.ix);
      }
      try
      {
        this.iw.d(this.ix);
        localObject = e.b(i.a((Bundle)localObject, "extra_session_binder"));
        if (localObject == null) {
          continue;
        }
        this.iy = MediaSessionCompat.Token.a(((MediaBrowser)this.ir).getSessionToken(), (d)localObject);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
        }
      }
    }
  }
  
  public final void onConnectionSuspended()
  {
    this.iw = null;
    this.ix = null;
    this.iy = null;
    this.it.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.g
 * JD-Core Version:    0.7.0.1
 */