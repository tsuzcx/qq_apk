package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.a;
import java.util.HashMap;

final class ah
  extends af
  implements Handler.Callback
{
  private final Context Hj;
  private final HashMap<ag, ai> Ku = new HashMap();
  private final a Kv;
  private final long Kw;
  private final long Kx;
  private final Handler mHandler;
  
  ah(Context paramContext)
  {
    this.Hj = paramContext.getApplicationContext();
    this.mHandler = new Handler(paramContext.getMainLooper(), this);
    this.Kv = a.hR();
    this.Kw = 5000L;
    this.Kx = 300000L;
  }
  
  protected final void a(ag paramag, ServiceConnection paramServiceConnection)
  {
    d.e(paramServiceConnection, "ServiceConnection must not be null");
    ai localai;
    synchronized (this.Ku)
    {
      localai = (ai)this.Ku.get(paramag);
      if (localai == null)
      {
        paramag = String.valueOf(paramag);
        throw new IllegalStateException(String.valueOf(paramag).length() + 50 + "Nonexistent connection status for service config: " + paramag);
      }
    }
    if (!localai.c(paramServiceConnection))
    {
      paramag = String.valueOf(paramag);
      throw new IllegalStateException(String.valueOf(paramag).length() + 76 + "Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + paramag);
    }
    localai.b(paramServiceConnection);
    if (localai.hA())
    {
      paramag = this.mHandler.obtainMessage(0, paramag);
      this.mHandler.sendMessageDelayed(paramag, this.Kw);
    }
  }
  
  protected final boolean a(ag paramag, ServiceConnection paramServiceConnection, String paramString)
  {
    d.e(paramServiceConnection, "ServiceConnection must not be null");
    for (;;)
    {
      synchronized (this.Ku)
      {
        paramString = (ai)this.Ku.get(paramag);
        if (paramString == null)
        {
          paramString = new ai(this, paramag);
          paramString.a(paramServiceConnection);
          paramString.hy();
          this.Ku.put(paramag, paramString);
          paramag = paramString;
          boolean bool = paramag.isBound();
          return bool;
        }
        this.mHandler.removeMessages(0, paramag);
        if (paramString.c(paramServiceConnection))
        {
          paramag = String.valueOf(paramag);
          throw new IllegalStateException(String.valueOf(paramag).length() + 81 + "Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramag);
        }
      }
      paramString.a(paramServiceConnection);
      switch (paramString.getState())
      {
      case 1: 
        paramServiceConnection.onServiceConnected(paramString.getComponentName(), paramString.getBinder());
        paramag = paramString;
        break;
      case 2: 
        paramString.hy();
        paramag = paramString;
        break;
      default: 
        paramag = paramString;
      }
    }
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      synchronized (this.Ku)
      {
        paramMessage = (ag)paramMessage.obj;
        ??? = (ai)this.Ku.get(paramMessage);
        if ((??? != null) && (((ai)???).hA()))
        {
          if (((ai)???).isBound()) {
            ((ai)???).hz();
          }
          this.Ku.remove(paramMessage);
        }
        return true;
      }
    }
    for (;;)
    {
      synchronized (this.Ku)
      {
        ag localag = (ag)paramMessage.obj;
        ai localai = (ai)this.Ku.get(localag);
        if ((localai != null) && (localai.getState() == 3))
        {
          paramMessage = String.valueOf(localag);
          Log.wtf("GmsClientSupervisor", String.valueOf(paramMessage).length() + 47 + "Timeout waiting for ServiceConnection callback " + paramMessage, new Exception());
          ??? = localai.getComponentName();
          paramMessage = (Message)???;
          if (??? == null) {
            paramMessage = localag.getComponentName();
          }
          if (paramMessage == null)
          {
            paramMessage = new ComponentName(localag.getPackage(), "unknown");
            localai.onServiceDisconnected(paramMessage);
          }
        }
        else
        {
          return true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ah
 * JD-Core Version:    0.7.0.1
 */