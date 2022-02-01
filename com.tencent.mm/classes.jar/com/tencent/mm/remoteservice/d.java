package com.tencent.mm.remoteservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  List<Runnable> HUV;
  c HUW;
  private Context context;
  private ServiceConnection oRd;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(152748);
    this.HUV = new LinkedList();
    this.oRd = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(152747);
        d.this.HUW = c.a.K(paramAnonymousIBinder);
        paramAnonymousComponentName = (Runnable[])d.this.HUV.toArray(new Runnable[d.this.HUV.size()]);
        int j = paramAnonymousComponentName.length;
        int i = 0;
        while (i < j)
        {
          paramAnonymousIBinder = paramAnonymousComponentName[i];
          if (paramAnonymousIBinder != null) {
            paramAnonymousIBinder.run();
          }
          i += 1;
        }
        d.this.HUV.clear();
        AppMethodBeat.o(152747);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        d.this.HUW = null;
      }
    };
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = aj.getContext();
    }
    this.context = localContext;
    AppMethodBeat.o(152748);
  }
  
  final void a(b paramb, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(152752);
    if (isConnected()) {
      try
      {
        this.HUW.a(paramb.getClass().getName(), paramString, paramBundle, paramb);
        AppMethodBeat.o(152752);
        return;
      }
      catch (RemoteException paramb)
      {
        ad.e("MicroMsg.RemoteServiceProxy", "exception:%s", new Object[] { bt.n(paramb) });
      }
    }
    AppMethodBeat.o(152752);
  }
  
  public final void connect(Runnable paramRunnable)
  {
    AppMethodBeat.i(152749);
    new StringBuilder("RemoteServiceProxy construct, thread id:").append(Thread.currentThread().getId());
    if (isConnected())
    {
      paramRunnable.run();
      AppMethodBeat.o(152749);
      return;
    }
    if (this.context == null)
    {
      AppMethodBeat.o(152749);
      return;
    }
    this.HUV.add(paramRunnable);
    paramRunnable = new Intent(this.context, RemoteService.class);
    this.context.bindService(paramRunnable, this.oRd, 1);
    AppMethodBeat.o(152749);
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(152750);
    if ((this.HUW != null) && (this.HUW.asBinder().isBinderAlive()))
    {
      AppMethodBeat.o(152750);
      return true;
    }
    AppMethodBeat.o(152750);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(152751);
    if ((this.HUW != null) && (this.oRd != null))
    {
      this.context.unbindService(this.oRd);
      this.HUW = null;
    }
    this.context = null;
    AppMethodBeat.o(152751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.remoteservice.d
 * JD-Core Version:    0.7.0.1
 */