package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.ad;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.i;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class ar<O extends com.google.android.gms.common.api.b>
  implements r, s, o
{
  private final ef<O> HW;
  private final j MW;
  private boolean NS;
  private final Queue<ea> OC = new LinkedList();
  private final g OD;
  private final w OE;
  private final Set<c> OF = new HashSet();
  private final Map<bd<?>, bi> OG = new HashMap();
  private final int OH;
  private final bl OI;
  private ConnectionResult OJ = null;
  
  public ar(ad<O> paramad)
  {
    Object localObject;
    this.MW = localObject.a(aq.a(paramad).getLooper(), this);
    if ((this.MW instanceof i)) {}
    for (this.OD = ((i)this.MW).hc();; this.OD = this.MW)
    {
      this.HW = localObject.gJ();
      this.OE = new w();
      this.OH = localObject.getInstanceId();
      if (!this.MW.gs()) {
        break;
      }
      this.OI = localObject.a(aq.b(paramad), aq.a(paramad));
      return;
    }
    this.OI = null;
  }
  
  private void b(ea paramea)
  {
    paramea.a(this.OE, gs());
    try
    {
      paramea.c(this);
      return;
    }
    catch (DeadObjectException paramea)
    {
      bd(1);
      this.MW.disconnect();
    }
  }
  
  private void iM()
  {
    iQ();
    l(ConnectionResult.Hb);
    iS();
    Iterator localIterator = this.OG.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext()) {
        localIterator.next();
      }
      try
      {
        new com.google.android.gms.b.c();
      }
      catch (DeadObjectException localDeadObjectException)
      {
        bd(1);
        this.MW.disconnect();
        while ((this.MW.isConnected()) && (!this.OC.isEmpty())) {
          b((ea)this.OC.remove());
        }
        iU();
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
  }
  
  private void iN()
  {
    iQ();
    this.NS = true;
    this.OE.ir();
    aq.a(this.OB).sendMessageDelayed(Message.obtain(aq.a(this.OB), 9, this.HW), aq.c(this.OB));
    aq.a(this.OB).sendMessageDelayed(Message.obtain(aq.a(this.OB), 11, this.HW), aq.d(this.OB));
    aq.a(this.OB, -1);
  }
  
  private void iS()
  {
    if (this.NS)
    {
      aq.a(this.OB).removeMessages(11, this.HW);
      aq.a(this.OB).removeMessages(9, this.HW);
      this.NS = false;
    }
  }
  
  private void iU()
  {
    aq.a(this.OB).removeMessages(12, this.HW);
    aq.a(this.OB).sendMessageDelayed(aq.a(this.OB).obtainMessage(12, this.HW), aq.h(this.OB));
  }
  
  private void l(ConnectionResult paramConnectionResult)
  {
    Iterator localIterator = this.OF.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a(this.HW, paramConnectionResult);
    }
    this.OF.clear();
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    d.a(aq.a(this.OB));
    if (this.OI != null) {
      this.OI.je();
    }
    iQ();
    aq.a(this.OB, -1);
    l(paramConnectionResult);
    if (paramConnectionResult.getErrorCode() == 4) {
      d(aq.iK());
    }
    do
    {
      return;
      if (this.OC.isEmpty())
      {
        this.OJ = paramConnectionResult;
        return;
      }
      synchronized (aq.iL())
      {
        if ((aq.e(this.OB) != null) && (aq.f(this.OB).contains(this.HW)))
        {
          aq.e(this.OB).b(paramConnectionResult, this.OH);
          return;
        }
      }
    } while (this.OB.c(paramConnectionResult, this.OH));
    if (paramConnectionResult.getErrorCode() == 18) {
      this.NS = true;
    }
    if (this.NS)
    {
      aq.a(this.OB).sendMessageDelayed(Message.obtain(aq.a(this.OB), 9, this.HW), aq.c(this.OB));
      return;
    }
    paramConnectionResult = String.valueOf(this.HW.kk());
    d(new Status(17, String.valueOf(paramConnectionResult).length() + 38 + "API: " + paramConnectionResult + " is not available on this device."));
  }
  
  public final void a(final ConnectionResult paramConnectionResult, a<?> parama, boolean paramBoolean)
  {
    if (Looper.myLooper() == aq.a(this.OB).getLooper())
    {
      a(paramConnectionResult);
      return;
    }
    aq.a(this.OB).post(new Runnable()
    {
      public final void run()
      {
        ar.this.a(paramConnectionResult);
      }
    });
  }
  
  public final void a(c paramc)
  {
    d.a(aq.a(this.OB));
    this.OF.add(paramc);
  }
  
  public final void a(ea paramea)
  {
    d.a(aq.a(this.OB));
    if (this.MW.isConnected())
    {
      b(paramea);
      iU();
      return;
    }
    this.OC.add(paramea);
    if ((this.OJ != null) && (this.OJ.gl()))
    {
      a(this.OJ);
      return;
    }
    connect();
  }
  
  public final void bd(int paramInt)
  {
    if (Looper.myLooper() == aq.a(this.OB).getLooper())
    {
      iN();
      return;
    }
    aq.a(this.OB).post(new Runnable()
    {
      public final void run()
      {
        ar.b(ar.this);
      }
    });
  }
  
  public final void connect()
  {
    d.a(aq.a(this.OB));
    if ((this.MW.isConnected()) || (this.MW.isConnecting())) {
      return;
    }
    if ((this.MW.gt()) && (aq.i(this.OB) != 0))
    {
      aq.a(this.OB, aq.g(this.OB).d(aq.b(this.OB)));
      if (aq.i(this.OB) != 0)
      {
        a(new ConnectionResult(aq.i(this.OB), null));
        return;
      }
    }
    as localas = new as(this.OB, this.MW, this.HW);
    if (this.MW.gs()) {
      this.OI.a(localas);
    }
    this.MW.a(localas);
  }
  
  public final void d(Status paramStatus)
  {
    d.a(aq.a(this.OB));
    Iterator localIterator = this.OC.iterator();
    while (localIterator.hasNext()) {
      ((ea)localIterator.next()).i(paramStatus);
    }
    this.OC.clear();
  }
  
  public final int getInstanceId()
  {
    return this.OH;
  }
  
  public final boolean gs()
  {
    return this.MW.gs();
  }
  
  public final void h(Bundle paramBundle)
  {
    if (Looper.myLooper() == aq.a(this.OB).getLooper())
    {
      iM();
      return;
    }
    aq.a(this.OB).post(new Runnable()
    {
      public final void run()
      {
        ar.a(ar.this);
      }
    });
  }
  
  public final void iO()
  {
    d.a(aq.a(this.OB));
    d(aq.Or);
    this.OE.iq();
    Iterator localIterator = this.OG.keySet().iterator();
    while (localIterator.hasNext()) {
      a(new ed((bd)localIterator.next(), new com.google.android.gms.b.c()));
    }
    l(new ConnectionResult(4));
    this.MW.disconnect();
  }
  
  public final Map<bd<?>, bi> iP()
  {
    return this.OG;
  }
  
  public final void iQ()
  {
    d.a(aq.a(this.OB));
    this.OJ = null;
  }
  
  public final ConnectionResult iR()
  {
    d.a(aq.a(this.OB));
    return this.OJ;
  }
  
  public final void iT()
  {
    d.a(aq.a(this.OB));
    if (this.NS)
    {
      iS();
      if (aq.g(this.OB).d(aq.b(this.OB)) != 18) {
        break label71;
      }
    }
    label71:
    for (Status localStatus = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");; localStatus = new Status(8, "API failed to connect while resuming due to an unknown error."))
    {
      d(localStatus);
      this.MW.disconnect();
      return;
    }
  }
  
  public final void iV()
  {
    d.a(aq.a(this.OB));
    if ((this.MW.isConnected()) && (this.OG.size() == 0))
    {
      if (this.OE.ip()) {
        iU();
      }
    }
    else {
      return;
    }
    this.MW.disconnect();
  }
  
  final cr iW()
  {
    if (this.OI == null) {
      return null;
    }
    return this.OI.iW();
  }
  
  public final j io()
  {
    return this.MW;
  }
  
  final boolean isConnected()
  {
    return this.MW.isConnected();
  }
  
  public final void k(ConnectionResult paramConnectionResult)
  {
    d.a(aq.a(this.OB));
    this.MW.disconnect();
    a(paramConnectionResult);
  }
  
  public final void resume()
  {
    d.a(aq.a(this.OB));
    if (this.NS) {
      connect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ar
 * JD-Core Version:    0.7.0.1
 */