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
  int aJ = 1;
  private Bundle ew;
  private MediaSessionCompat.Token gA;
  final ComponentName gB;
  final b gC;
  k gD;
  private String gE;
  final Bundle gv;
  final a gw = new a(this);
  private final android.support.v4.b.a<String, n> gx = new android.support.v4.b.a();
  m gy;
  Messenger gz;
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
    this.gB = paramComponentName;
    this.gC = paramb;
    this.gv = null;
  }
  
  private boolean a(Messenger paramMessenger, String paramString)
  {
    boolean bool = true;
    if ((this.gz != paramMessenger) || (this.aJ == 0) || (this.aJ == 1))
    {
      if ((this.aJ != 0) && (this.aJ != 1)) {
        Log.i("MediaBrowserCompat", paramString + " for " + this.gB + " with mCallbacksMessenger=" + this.gz + " this=" + this);
      }
      bool = false;
    }
    return bool;
  }
  
  private static String k(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN/" + paramInt;
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
        Log.d("MediaBrowserCompat", "onLoadChildren for " + this.gB + " id=" + paramString);
      }
      paramMessenger = (n)this.gx.get(paramString);
      if (paramMessenger != null) {
        break;
      }
    } while (!MediaBrowserCompat.DEBUG);
    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + paramString);
    return;
    paramMessenger.a(this.mContext, paramBundle);
  }
  
  public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
  {
    if (!a(paramMessenger, "onConnect")) {}
    for (;;)
    {
      return;
      if (this.aJ != 2)
      {
        Log.w("MediaBrowserCompat", "onConnect from service while mState=" + k(this.aJ) + "... ignoring");
        return;
      }
      this.gE = paramString;
      this.gA = paramToken;
      this.ew = paramBundle;
      this.aJ = 3;
      if (MediaBrowserCompat.DEBUG)
      {
        Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
        dump();
      }
      this.gC.onConnected();
      try
      {
        paramMessenger = this.gx.entrySet().iterator();
        while (paramMessenger.hasNext())
        {
          paramToken = (Map.Entry)paramMessenger.next();
          paramString = (String)paramToken.getKey();
          paramBundle = (n)paramToken.getValue();
          paramToken = paramBundle.aJ();
          paramBundle = paramBundle.aI();
          int i = 0;
          while (i < paramToken.size())
          {
            this.gy.a(paramString, o.a((o)paramToken.get(i)), (Bundle)paramBundle.get(i), this.gz);
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
  
  public final MediaSessionCompat.Token aG()
  {
    if (this.aJ == 3) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.aJ + ")");
    }
    return this.gA;
  }
  
  final void aH()
  {
    if (this.gD != null) {
      this.mContext.unbindService(this.gD);
    }
    this.aJ = 1;
    this.gD = null;
    this.gy = null;
    this.gz = null;
    this.gw.a(null);
    this.gE = null;
    this.gA = null;
  }
  
  public final void b(Messenger paramMessenger)
  {
    Log.e("MediaBrowserCompat", "onConnectFailed for " + this.gB);
    if (!a(paramMessenger, "onConnectFailed")) {
      return;
    }
    if (this.aJ != 2)
    {
      Log.w("MediaBrowserCompat", "onConnect from service while mState=" + k(this.aJ) + "... ignoring");
      return;
    }
    aH();
    this.gC.onConnectionFailed();
  }
  
  public final void connect()
  {
    if ((this.aJ != 0) && (this.aJ != 1)) {
      throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + k(this.aJ) + ")");
    }
    this.aJ = 2;
    this.gw.post(new Runnable()
    {
      public final void run()
      {
        if (j.this.aJ == 0) {}
        do
        {
          return;
          j.this.aJ = 2;
          if ((MediaBrowserCompat.DEBUG) && (j.this.gD != null)) {
            throw new RuntimeException("mServiceConnection should be null. Instead it is " + j.this.gD);
          }
          if (j.this.gy != null) {
            throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + j.this.gy);
          }
          if (j.this.gz != null) {
            throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + j.this.gz);
          }
          Intent localIntent = new Intent("android.media.browse.MediaBrowserService");
          localIntent.setComponent(j.this.gB);
          j.this.gD = new k(j.this);
          int i = 0;
          try
          {
            boolean bool = j.this.mContext.bindService(localIntent, j.this.gD, 1);
            i = bool;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("MediaBrowserCompat", "Failed binding to service " + j.this.gB);
            }
          }
          if (i == 0)
          {
            j.this.aH();
            j.this.gC.onConnectionFailed();
          }
        } while (!MediaBrowserCompat.DEBUG);
        Log.d("MediaBrowserCompat", "connect...");
        j.this.dump();
      }
    });
  }
  
  public final void disconnect()
  {
    this.aJ = 0;
    this.gw.post(new Runnable()
    {
      public final void run()
      {
        if (j.this.gz != null) {}
        try
        {
          j.this.gy.c(j.this.gz);
          int i = j.this.aJ;
          j.this.aH();
          if (i != 0) {
            j.this.aJ = i;
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
            Log.w("MediaBrowserCompat", "RemoteException during connect for " + j.this.gB);
          }
        }
      }
    });
  }
  
  final void dump()
  {
    Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
    Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.gB);
    Log.d("MediaBrowserCompat", "  mCallback=" + this.gC);
    Log.d("MediaBrowserCompat", "  mRootHints=" + this.gv);
    Log.d("MediaBrowserCompat", "  mState=" + k(this.aJ));
    Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.gD);
    Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.gy);
    Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.gz);
    Log.d("MediaBrowserCompat", "  mRootId=" + this.gE);
    Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.gA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.j
 * JD-Core Version:    0.7.0.1
 */