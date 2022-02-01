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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private List<Runnable> acla;
  private c aclb;
  private Context context;
  private ServiceConnection wOI;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(152748);
    this.acla = new LinkedList();
    this.wOI = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(152747);
        d.a(d.this, c.a.U(paramAnonymousIBinder));
        paramAnonymousComponentName = (Runnable[])d.a(d.this).toArray(new Runnable[d.a(d.this).size()]);
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
        d.a(d.this).clear();
        AppMethodBeat.o(152747);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(235613);
        d.a(d.this, null);
        AppMethodBeat.o(235613);
      }
    };
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = MMApplicationContext.getContext();
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
        this.aclb.a(paramb.getClass().getName(), paramString, paramBundle, paramb);
        AppMethodBeat.o(152752);
        return;
      }
      catch (RemoteException paramb)
      {
        Log.e("MicroMsg.RemoteServiceProxy", "exception:%s", new Object[] { Util.stackTraceToString(paramb) });
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
    this.acla.add(paramRunnable);
    paramRunnable = new Intent(this.context, RemoteService.class);
    this.context.bindService(paramRunnable, this.wOI, 1);
    AppMethodBeat.o(152749);
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(152750);
    if ((this.aclb != null) && (this.aclb.asBinder().isBinderAlive()))
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
    if ((this.aclb != null) && (this.wOI != null))
    {
      this.context.unbindService(this.wOI);
      this.aclb = null;
    }
    this.context = null;
    AppMethodBeat.o(152751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.remoteservice.d
 * JD-Core Version:    0.7.0.1
 */