package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class j
  implements f, l
{
  int cs = 1;
  private Bundle gl;
  final b iA;
  k iB;
  private String iC;
  final Bundle is;
  final a it = new a(this);
  private final android.support.v4.b.a<String, n> iu = new android.support.v4.b.a();
  m iw;
  Messenger ix;
  private MediaSessionCompat.Token iy;
  final ComponentName iz;
  final Context mContext;
  
  public j(Context paramContext, ComponentName paramComponentName, b paramb, Bundle paramBundle)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context must not be null");
    }
    if (paramComponentName == null) {
      throw new IllegalArgumentException("service component must not be null");
    }
    if (paramb == null) {
      throw new IllegalArgumentException("connection callback must not be null");
    }
    this.mContext = paramContext;
    this.iz = paramComponentName;
    this.iA = paramb;
    this.is = null;
  }
  
  private boolean a(Messenger paramMessenger, String paramString)
  {
    boolean bool = true;
    if ((this.ix != paramMessenger) || (this.cs == 0) || (this.cs == 1))
    {
      if ((this.cs != 0) && (this.cs != 1)) {
        Log.i("MediaBrowserCompat", paramString + " for " + this.iz + " with mCallbacksMessenger=" + this.ix + " this=" + this);
      }
      bool = false;
    }
    return bool;
  }
  
  private static String u(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN/".concat(String.valueOf(paramInt));
    case 0: 
      return "CONNECT_STATE_DISCONNECTING";
    case 1: 
      return "CONNECT_STATE_DISCONNECTED";
    case 2: 
      return "CONNECT_STATE_CONNECTING";
    case 3: 
      return "CONNECT_STATE_CONNECTED";
    }
    return "CONNECT_STATE_SUSPENDED";
  }
  
  public final void a(Messenger paramMessenger, String paramString, Bundle paramBundle)
  {
    if (!a(paramMessenger, "onLoadChildren")) {}
    do
    {
      return;
      if (MediaBrowserCompat.DEBUG) {
        Log.d("MediaBrowserCompat", "onLoadChildren for " + this.iz + " id=" + paramString);
      }
      paramMessenger = (n)this.iu.get(paramString);
      if (paramMessenger != null) {
        break;
      }
    } while (!MediaBrowserCompat.DEBUG);
    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=".concat(String.valueOf(paramString)));
    return;
    paramMessenger.a(this.mContext, paramBundle);
  }
  
  public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
  {
    if (!a(paramMessenger, "onConnect")) {}
    for (;;)
    {
      return;
      if (this.cs != 2)
      {
        Log.w("MediaBrowserCompat", "onConnect from service while mState=" + u(this.cs) + "... ignoring");
        return;
      }
      this.iC = paramString;
      this.iy = paramToken;
      this.gl = paramBundle;
      this.cs = 3;
      if (MediaBrowserCompat.DEBUG)
      {
        Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
        dump();
      }
      this.iA.onConnected();
      try
      {
        paramMessenger = this.iu.entrySet().iterator();
        while (paramMessenger.hasNext())
        {
          paramToken = (Map.Entry)paramMessenger.next();
          paramString = (String)paramToken.getKey();
          paramBundle = (n)paramToken.getValue();
          paramToken = paramBundle.aZ();
          paramBundle = paramBundle.aY();
          int i = 0;
          while (i < paramToken.size())
          {
            this.iw.a(paramString, o.a((o)paramToken.get(i)), (Bundle)paramBundle.get(i), this.ix);
            i += 1;
          }
        }
        return;
      }
      catch (RemoteException paramMessenger)
      {
        Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
      }
    }
  }
  
  public final MediaSessionCompat.Token aW()
  {
    if (this.cs == 3) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.cs + ")");
    }
    return this.iy;
  }
  
  final void aX()
  {
    if (this.iB != null) {
      this.mContext.unbindService(this.iB);
    }
    this.cs = 1;
    this.iB = null;
    this.iw = null;
    this.ix = null;
    this.it.a(null);
    this.iC = null;
    this.iy = null;
  }
  
  public final void b(Messenger paramMessenger)
  {
    Log.e("MediaBrowserCompat", "onConnectFailed for " + this.iz);
    if (!a(paramMessenger, "onConnectFailed")) {
      return;
    }
    if (this.cs != 2)
    {
      Log.w("MediaBrowserCompat", "onConnect from service while mState=" + u(this.cs) + "... ignoring");
      return;
    }
    aX();
    this.iA.onConnectionFailed();
  }
  
  public final void connect()
  {
    if ((this.cs != 0) && (this.cs != 1)) {
      throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + u(this.cs) + ")");
    }
    this.cs = 2;
    this.it.post(new Runnable()
    {
      public final void run()
      {
        if (j.this.cs == 0) {}
        do
        {
          return;
          j.this.cs = 2;
          if ((MediaBrowserCompat.DEBUG) && (j.this.iB != null)) {
            throw new RuntimeException("mServiceConnection should be null. Instead it is " + j.this.iB);
          }
          if (j.this.iw != null) {
            throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + j.this.iw);
          }
          if (j.this.ix != null) {
            throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + j.this.ix);
          }
          Intent localIntent = new Intent("android.media.browse.MediaBrowserService");
          localIntent.setComponent(j.this.iz);
          j.this.iB = new k(j.this);
          int i = 0;
          try
          {
            boolean bool = j.this.mContext.bindService(localIntent, j.this.iB, 1);
            i = bool;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("MediaBrowserCompat", "Failed binding to service " + j.this.iz);
            }
          }
          if (i == 0)
          {
            j.this.aX();
            j.this.iA.onConnectionFailed();
          }
        } while (!MediaBrowserCompat.DEBUG);
        Log.d("MediaBrowserCompat", "connect...");
        j.this.dump();
      }
    });
  }
  
  public final void disconnect()
  {
    this.cs = 0;
    this.it.post(new Runnable()
    {
      public final void run()
      {
        if (j.this.ix != null) {}
        try
        {
          j.this.iw.c(j.this.ix);
          int i = j.this.cs;
          j.this.aX();
          if (i != 0) {
            j.this.cs = i;
          }
          if (MediaBrowserCompat.DEBUG)
          {
            Log.d("MediaBrowserCompat", "disconnect...");
            j.this.dump();
          }
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            Log.w("MediaBrowserCompat", "RemoteException during connect for " + j.this.iz);
          }
        }
      }
    });
  }
  
  final void dump()
  {
    Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
    Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.iz);
    Log.d("MediaBrowserCompat", "  mCallback=" + this.iA);
    Log.d("MediaBrowserCompat", "  mRootHints=" + this.is);
    Log.d("MediaBrowserCompat", "  mState=" + u(this.cs));
    Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.iB);
    Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.iw);
    Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.ix);
    Log.d("MediaBrowserCompat", "  mRootId=" + this.iC);
    Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.iy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.j
 * JD-Core Version:    0.7.0.1
 */