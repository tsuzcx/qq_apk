package com.tencent.mm.remoteservice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private Context context;
  private ServiceConnection kDI;
  List<Runnable> yiu;
  c yiv;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(80231);
    this.yiu = new LinkedList();
    this.kDI = new d.1(this);
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = ah.getContext();
    }
    this.context = localContext;
    AppMethodBeat.o(80231);
  }
  
  final void a(b paramb, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(80235);
    if (isConnected()) {
      try
      {
        this.yiv.a(paramb.getClass().getName(), paramString, paramBundle, paramb);
        AppMethodBeat.o(80235);
        return;
      }
      catch (RemoteException paramb)
      {
        ab.e("MicroMsg.RemoteServiceProxy", "exception:%s", new Object[] { bo.l(paramb) });
      }
    }
    AppMethodBeat.o(80235);
  }
  
  public final void connect(Runnable paramRunnable)
  {
    AppMethodBeat.i(80232);
    new StringBuilder("RemoteServiceProxy construct, thread id:").append(Thread.currentThread().getId());
    if (isConnected())
    {
      paramRunnable.run();
      AppMethodBeat.o(80232);
      return;
    }
    if (this.context == null)
    {
      AppMethodBeat.o(80232);
      return;
    }
    this.yiu.add(paramRunnable);
    paramRunnable = new Intent(this.context, RemoteService.class);
    this.context.bindService(paramRunnable, this.kDI, 1);
    AppMethodBeat.o(80232);
  }
  
  public final boolean isConnected()
  {
    AppMethodBeat.i(80233);
    if ((this.yiv != null) && (this.yiv.asBinder().isBinderAlive()))
    {
      AppMethodBeat.o(80233);
      return true;
    }
    AppMethodBeat.o(80233);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(80234);
    if ((this.yiv != null) && (this.kDI != null))
    {
      this.context.unbindService(this.kDI);
      this.yiv = null;
    }
    this.context = null;
    AppMethodBeat.o(80234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.remoteservice.d
 * JD-Core Version:    0.7.0.1
 */