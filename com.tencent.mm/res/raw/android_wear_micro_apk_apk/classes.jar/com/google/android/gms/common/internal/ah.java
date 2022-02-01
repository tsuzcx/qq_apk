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
  private final Context IY;
  private final HashMap<ag, ai> Mj = new HashMap();
  private final a Mk;
  private final long Ml;
  private final long Mm;
  private final Handler dG;
  
  ah(Context paramContext)
  {
    this.IY = paramContext.getApplicationContext();
    this.dG = new Handler(paramContext.getMainLooper(), this);
    this.Mk = a.ib();
    this.Ml = 5000L;
    this.Mm = 300000L;
  }
  
  protected final void a(ag paramag, ServiceConnection paramServiceConnection)
  {
    d.g(paramServiceConnection, "ServiceConnection must not be null");
    ai localai;
    synchronized (this.Mj)
    {
      localai = (ai)this.Mj.get(paramag);
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
    if (localai.hK())
    {
      paramag = this.dG.obtainMessage(0, paramag);
      this.dG.sendMessageDelayed(paramag, this.Ml);
    }
  }
  
  protected final boolean a(ag paramag, ServiceConnection paramServiceConnection, String paramString)
  {
    d.g(paramServiceConnection, "ServiceConnection must not be null");
    for (;;)
    {
      synchronized (this.Mj)
      {
        paramString = (ai)this.Mj.get(paramag);
        if (paramString == null)
        {
          paramString = new ai(this, paramag);
          paramString.a(paramServiceConnection);
          paramString.hI();
          this.Mj.put(paramag, paramString);
          paramag = paramString;
          boolean bool = paramag.isBound();
          return bool;
        }
        this.dG.removeMessages(0, paramag);
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
        paramString.hI();
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
      synchronized (this.Mj)
      {
        paramMessage = (ag)paramMessage.obj;
        ??? = (ai)this.Mj.get(paramMessage);
        if ((??? != null) && (((ai)???).hK()))
        {
          if (((ai)???).isBound()) {
            ((ai)???).hJ();
          }
          this.Mj.remove(paramMessage);
        }
        return true;
      }
    }
    for (;;)
    {
      synchronized (this.Mj)
      {
        ag localag = (ag)paramMessage.obj;
        ai localai = (ai)this.Mj.get(localag);
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