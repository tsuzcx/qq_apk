package com.tencent.mm.remoteservice;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private Context context;
  private ServiceConnection iAC = new d.1(this);
  List<Runnable> uaE = new LinkedList();
  c uaF;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  final void a(b paramb, String paramString, Bundle paramBundle)
  {
    if (isConnected()) {}
    try
    {
      this.uaF.a(paramb.getClass().getName(), paramString, paramBundle, paramb);
      return;
    }
    catch (RemoteException paramb)
    {
      y.e("MicroMsg.RemoteServiceProxy", "exception:%s", new Object[] { bk.j(paramb) });
    }
  }
  
  public final void connect(Runnable paramRunnable)
  {
    new StringBuilder("RemoteServiceProxy construct, thread id:").append(Thread.currentThread().getId());
    if (isConnected()) {
      paramRunnable.run();
    }
    while (this.context == null) {
      return;
    }
    this.uaE.add(paramRunnable);
    paramRunnable = new Intent(this.context, RemoteService.class);
    this.context.bindService(paramRunnable, this.iAC, 1);
  }
  
  public final boolean isConnected()
  {
    return (this.uaF != null) && (this.uaF.asBinder().isBinderAlive());
  }
  
  public final void release()
  {
    if ((this.uaF != null) && (this.iAC != null))
    {
      this.context.unbindService(this.iAC);
      this.uaF = null;
    }
    this.context = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.remoteservice.d
 * JD-Core Version:    0.7.0.1
 */