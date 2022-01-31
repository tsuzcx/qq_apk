package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.app.h;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.d;
import android.support.v4.media.session.e;
import android.util.Log;

class g
  implements c, f, l
{
  private MediaSessionCompat.Token gA;
  protected final Object gu;
  protected final Bundle gv;
  protected final a gw = new a(this);
  private final android.support.v4.b.a<String, n> gx = new android.support.v4.b.a();
  protected m gy;
  protected Messenger gz;
  final Context mContext;
  
  public g(Context paramContext, ComponentName paramComponentName, b paramb, Bundle paramBundle)
  {
    this.mContext = paramContext;
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("extra_client_version", 1);
    this.gv = new Bundle(localBundle);
    paramb.gr = this;
    paramb = paramb.gq;
    paramBundle = this.gv;
    this.gu = new MediaBrowser(paramContext, paramComponentName, (MediaBrowser.ConnectionCallback)paramb, paramBundle);
  }
  
  public final void a(Messenger paramMessenger, String paramString, Bundle paramBundle)
  {
    if (this.gz != paramMessenger) {}
    do
    {
      return;
      paramMessenger = (n)this.gx.get(paramString);
      if (paramMessenger != null) {
        break;
      }
    } while (!MediaBrowserCompat.DEBUG);
    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + paramString);
    return;
    paramMessenger.a(this.mContext, paramBundle);
  }
  
  public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle) {}
  
  public final MediaSessionCompat.Token aG()
  {
    if (this.gA == null) {
      this.gA = MediaSessionCompat.Token.g(((MediaBrowser)this.gu).getSessionToken());
    }
    return this.gA;
  }
  
  public final void b(Messenger paramMessenger) {}
  
  public final void connect()
  {
    ((MediaBrowser)this.gu).connect();
  }
  
  public final void disconnect()
  {
    if ((this.gy != null) && (this.gz != null)) {}
    try
    {
      this.gy.e(this.gz);
      ((MediaBrowser)this.gu).disconnect();
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
    Object localObject = ((MediaBrowser)this.gu).getExtras();
    if (localObject == null) {}
    for (;;)
    {
      return;
      IBinder localIBinder = h.a((Bundle)localObject, "extra_messenger");
      if (localIBinder != null)
      {
        this.gy = new m(localIBinder, this.gv);
        this.gz = new Messenger(this.gw);
        this.gw.a(this.gz);
      }
      try
      {
        this.gy.d(this.gz);
        localObject = e.b(h.a((Bundle)localObject, "extra_session_binder"));
        if (localObject == null) {
          continue;
        }
        this.gA = MediaSessionCompat.Token.a(((MediaBrowser)this.gu).getSessionToken(), (d)localObject);
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
    this.gy = null;
    this.gz = null;
    this.gA = null;
    this.gw.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.g
 * JD-Core Version:    0.7.0.1
 */