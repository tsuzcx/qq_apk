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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  List<Runnable> Gji;
  c Gjj;
  private Context context;
  private ServiceConnection onI;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(152748);
    this.Gji = new LinkedList();
    this.onI = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(152747);
        d.this.Gjj = c.a.K(paramAnonymousIBinder);
        paramAnonymousComponentName = (Runnable[])d.this.Gji.toArray(new Runnable[d.this.Gji.size()]);
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
        d.this.Gji.clear();
        AppMethodBeat.o(152747);
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        d.this.Gjj = null;
      }
    };
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = ai.getContext();
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
        this.Gjj.a(paramb.getClass().getName(), paramString, paramBundle, paramb);
        AppMethodBeat.o(152752);
        return;
      }
      catch (RemoteException paramb)
      {
        ac.e("MicroMsg.RemoteServiceProxy", "exception:%s", new Object[] { bs.m(paramb) });
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
    this.Gji.add(paramRunnable);
    paramRunnable = new Intent(this.context, RemoteService.class);
    this.context.bindService(paramRunnable, this.onI, 1);
    AppMethodBeat.o(152749);
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(152750);
    if ((this.Gjj != null) && (this.Gjj.asBinder().isBinderAlive()))
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
    if ((this.Gjj != null) && (this.onI != null))
    {
      this.context.unbindService(this.onI);
      this.Gjj = null;
    }
    this.context = null;
    AppMethodBeat.o(152751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.remoteservice.d
 * JD-Core Version:    0.7.0.1
 */