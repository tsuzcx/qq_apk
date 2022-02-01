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
  private final ef<O> JL;
  private final j OL;
  private boolean PH;
  private final Queue<ea> Qr = new LinkedList();
  private final g Qs;
  private final w Qt;
  private final Set<c> Qu = new HashSet();
  private final Map<bd<?>, bi> Qv = new HashMap();
  private final int Qw;
  private final bl Qx;
  private ConnectionResult Qy = null;
  
  public ar(ad<O> paramad)
  {
    Object localObject;
    this.OL = localObject.a(aq.a(paramad).getLooper(), this);
    if ((this.OL instanceof i)) {}
    for (this.Qs = ((i)this.OL).hm();; this.Qs = this.OL)
    {
      this.JL = localObject.gT();
      this.Qt = new w();
      this.Qw = localObject.getInstanceId();
      if (!this.OL.gC()) {
        break;
      }
      this.Qx = localObject.a(aq.b(paramad), aq.a(paramad));
      return;
    }
    this.Qx = null;
  }
  
  private void b(ea paramea)
  {
    paramea.a(this.Qt, gC());
    try
    {
      paramea.c(this);
      return;
    }
    catch (DeadObjectException paramea)
    {
      bx(1);
      this.OL.disconnect();
    }
  }
  
  private void iU()
  {
    iZ();
    m(ConnectionResult.IQ);
    jb();
    Iterator localIterator = this.Qv.values().iterator();
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
        bx(1);
        this.OL.disconnect();
        iW();
        jd();
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
  }
  
  private void iV()
  {
    iZ();
    this.PH = true;
    this.Qt.iz();
    aq.a(this.Qq).sendMessageDelayed(Message.obtain(aq.a(this.Qq), 9, this.JL), aq.c(this.Qq));
    aq.a(this.Qq).sendMessageDelayed(Message.obtain(aq.a(this.Qq), 11, this.JL), aq.d(this.Qq));
    aq.a(this.Qq, -1);
  }
  
  private void iW()
  {
    while ((this.OL.isConnected()) && (!this.Qr.isEmpty())) {
      b((ea)this.Qr.remove());
    }
  }
  
  private void jb()
  {
    if (this.PH)
    {
      aq.a(this.Qq).removeMessages(11, this.JL);
      aq.a(this.Qq).removeMessages(9, this.JL);
      this.PH = false;
    }
  }
  
  private void jd()
  {
    aq.a(this.Qq).removeMessages(12, this.JL);
    aq.a(this.Qq).sendMessageDelayed(aq.a(this.Qq).obtainMessage(12, this.JL), aq.h(this.Qq));
  }
  
  private void m(ConnectionResult paramConnectionResult)
  {
    Iterator localIterator = this.Qu.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a(this.JL, paramConnectionResult);
    }
    this.Qu.clear();
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    d.a(aq.a(this.Qq));
    if (this.Qx != null) {
      this.Qx.jn();
    }
    iZ();
    aq.a(this.Qq, -1);
    m(paramConnectionResult);
    if (paramConnectionResult.getErrorCode() == 4) {
      d(aq.iS());
    }
    do
    {
      return;
      if (this.Qr.isEmpty())
      {
        this.Qy = paramConnectionResult;
        return;
      }
      synchronized (aq.iT())
      {
        if ((aq.e(this.Qq) != null) && (aq.f(this.Qq).contains(this.JL)))
        {
          aq.e(this.Qq).b(paramConnectionResult, this.Qw);
          return;
        }
      }
    } while (this.Qq.c(paramConnectionResult, this.Qw));
    if (paramConnectionResult.getErrorCode() == 18) {
      this.PH = true;
    }
    if (this.PH)
    {
      aq.a(this.Qq).sendMessageDelayed(Message.obtain(aq.a(this.Qq), 9, this.JL), aq.c(this.Qq));
      return;
    }
    paramConnectionResult = String.valueOf(this.JL.kt());
    d(new Status(17, String.valueOf(paramConnectionResult).length() + 38 + "API: " + paramConnectionResult + " is not available on this device."));
  }
  
  public final void a(final ConnectionResult paramConnectionResult, a<?> parama, boolean paramBoolean)
  {
    if (Looper.myLooper() == aq.a(this.Qq).getLooper())
    {
      a(paramConnectionResult);
      return;
    }
    aq.a(this.Qq).post(new Runnable()
    {
      public final void run()
      {
        ar.this.a(paramConnectionResult);
      }
    });
  }
  
  public final void a(c paramc)
  {
    d.a(aq.a(this.Qq));
    this.Qu.add(paramc);
  }
  
  public final void a(ea paramea)
  {
    d.a(aq.a(this.Qq));
    if (this.OL.isConnected())
    {
      b(paramea);
      jd();
      return;
    }
    this.Qr.add(paramea);
    if ((this.Qy != null) && (this.Qy.gv()))
    {
      a(this.Qy);
      return;
    }
    connect();
  }
  
  public final void bx(int paramInt)
  {
    if (Looper.myLooper() == aq.a(this.Qq).getLooper())
    {
      iV();
      return;
    }
    aq.a(this.Qq).post(new Runnable()
    {
      public final void run()
      {
        ar.b(ar.this);
      }
    });
  }
  
  public final void connect()
  {
    d.a(aq.a(this.Qq));
    if ((this.OL.isConnected()) || (this.OL.isConnecting())) {
      return;
    }
    if ((this.OL.gD()) && (aq.i(this.Qq) != 0))
    {
      aq.a(this.Qq, aq.g(this.Qq).d(aq.b(this.Qq)));
      if (aq.i(this.Qq) != 0)
      {
        a(new ConnectionResult(aq.i(this.Qq), null));
        return;
      }
    }
    as localas = new as(this.Qq, this.OL, this.JL);
    if (this.OL.gC()) {
      this.Qx.a(localas);
    }
    this.OL.a(localas);
  }
  
  public final void d(Status paramStatus)
  {
    d.a(aq.a(this.Qq));
    Iterator localIterator = this.Qr.iterator();
    while (localIterator.hasNext()) {
      ((ea)localIterator.next()).i(paramStatus);
    }
    this.Qr.clear();
  }
  
  public final boolean gC()
  {
    return this.OL.gC();
  }
  
  public final int getInstanceId()
  {
    return this.Qw;
  }
  
  public final void h(Bundle paramBundle)
  {
    if (Looper.myLooper() == aq.a(this.Qq).getLooper())
    {
      iU();
      return;
    }
    aq.a(this.Qq).post(new Runnable()
    {
      public final void run()
      {
        ar.a(ar.this);
      }
    });
  }
  
  public final void iX()
  {
    d.a(aq.a(this.Qq));
    d(aq.Qg);
    this.Qt.iy();
    Iterator localIterator = this.Qv.keySet().iterator();
    while (localIterator.hasNext()) {
      a(new ed((bd)localIterator.next(), new com.google.android.gms.b.c()));
    }
    m(new ConnectionResult(4));
    this.OL.disconnect();
  }
  
  public final Map<bd<?>, bi> iY()
  {
    return this.Qv;
  }
  
  public final void iZ()
  {
    d.a(aq.a(this.Qq));
    this.Qy = null;
  }
  
  final boolean isConnected()
  {
    return this.OL.isConnected();
  }
  
  public final j iw()
  {
    return this.OL;
  }
  
  public final ConnectionResult ja()
  {
    d.a(aq.a(this.Qq));
    return this.Qy;
  }
  
  public final void jc()
  {
    d.a(aq.a(this.Qq));
    if (this.PH)
    {
      jb();
      if (aq.g(this.Qq).d(aq.b(this.Qq)) != 18) {
        break label71;
      }
    }
    label71:
    for (Status localStatus = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");; localStatus = new Status(8, "API failed to connect while resuming due to an unknown error."))
    {
      d(localStatus);
      this.OL.disconnect();
      return;
    }
  }
  
  public final void je()
  {
    d.a(aq.a(this.Qq));
    if ((this.OL.isConnected()) && (this.Qv.size() == 0))
    {
      if (this.Qt.ix()) {
        jd();
      }
    }
    else {
      return;
    }
    this.OL.disconnect();
  }
  
  final cr jf()
  {
    if (this.Qx == null) {
      return null;
    }
    return this.Qx.jf();
  }
  
  public final void l(ConnectionResult paramConnectionResult)
  {
    d.a(aq.a(this.Qq));
    this.OL.disconnect();
    a(paramConnectionResult);
  }
  
  public final void resume()
  {
    d.a(aq.a(this.Qq));
    if (this.PH) {
      connect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ar
 * JD-Core Version:    0.7.0.1
 */