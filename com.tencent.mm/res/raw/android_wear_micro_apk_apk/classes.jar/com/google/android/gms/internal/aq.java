package com.google.android.gms.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ad;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.util.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class aq
  implements Handler.Callback
{
  private static final Object KF = new Object();
  public static final Status Or = new Status(4, "Sign-out occurred while this API call was in progress.");
  private static final Status Os = new Status(4, "The user must be signed in to make this API call.");
  private static aq Ou;
  private final com.google.android.gms.common.b HF;
  private final Map<ef<?>, ar<?>> MY = new ConcurrentHashMap(5, 0.75F, 1);
  private long NT = 120000L;
  private long NU = 5000L;
  private final Set<ef<?>> OA = new a();
  private long Ot = 10000L;
  private int Ov = -1;
  private final AtomicInteger Ow = new AtomicInteger(1);
  private final AtomicInteger Ox = new AtomicInteger(0);
  private x Oy = null;
  private final Set<ef<?>> Oz = new a();
  private final Context mContext;
  private final Handler mHandler;
  
  private aq(Context paramContext, Looper paramLooper, com.google.android.gms.common.b paramb)
  {
    this.mContext = paramContext;
    this.mHandler = new Handler(paramLooper, this);
    this.HF = paramb;
    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
  }
  
  private void c(ad<?> paramad)
  {
    ef localef = paramad.gJ();
    ar localar2 = (ar)this.MY.get(localef);
    ar localar1 = localar2;
    if (localar2 == null)
    {
      localar1 = new ar(this, paramad);
      this.MY.put(localef, localar1);
    }
    if (localar1.gs()) {
      this.OA.add(localef);
    }
    localar1.connect();
  }
  
  public static aq iH()
  {
    synchronized (KF)
    {
      com.google.android.gms.common.internal.d.e(Ou, "Must guarantee manager is non-null before using getInstance");
      aq localaq = Ou;
      return localaq;
    }
  }
  
  private void iJ()
  {
    Iterator localIterator = this.OA.iterator();
    while (localIterator.hasNext())
    {
      ef localef = (ef)localIterator.next();
      ((ar)this.MY.remove(localef)).iO();
    }
    this.OA.clear();
  }
  
  public static aq s(Context paramContext)
  {
    synchronized (KF)
    {
      if (Ou == null)
      {
        Object localObject2 = new HandlerThread("GoogleApiHandler", 9);
        ((HandlerThread)localObject2).start();
        localObject2 = ((HandlerThread)localObject2).getLooper();
        Ou = new aq(paramContext.getApplicationContext(), (Looper)localObject2, com.google.android.gms.common.b.gp());
      }
      paramContext = Ou;
      return paramContext;
    }
  }
  
  final PendingIntent a(ef<?> paramef, int paramInt)
  {
    if ((ar)this.MY.get(paramef) == null) {
      return null;
    }
    paramef = ((ar)this.MY.get(paramef)).iW();
    if (paramef == null) {
      return null;
    }
    return PendingIntent.getActivity(this.mContext, paramInt, paramef.gu(), 134217728);
  }
  
  public final void a(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!c(paramConnectionResult, paramInt)) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(5, paramInt, 0, paramConnectionResult));
    }
  }
  
  public final <O extends com.google.android.gms.common.api.b> void a(ad<O> paramad, int paramInt, g<? extends w, com.google.android.gms.common.api.g> paramg)
  {
    paramg = new ec(paramInt, paramg);
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new bg(paramg, this.Ox.get(), paramad)));
  }
  
  public final void a(x paramx)
  {
    synchronized (KF)
    {
      if (this.Oy != paramx)
      {
        this.Oy = paramx;
        this.Oz.clear();
        this.Oz.addAll(paramx.is());
      }
      return;
    }
  }
  
  public final com.google.android.gms.b.b<Void> b(Iterable<? extends ad<?>> paramIterable)
  {
    c localc = new c(paramIterable);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = (ad)paramIterable.next();
      localObject = (ar)this.MY.get(((ad)localObject).gJ());
      if ((localObject == null) || (!((ar)localObject).isConnected()))
      {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, localc));
        return localc.ia();
      }
    }
    localc.ib();
    return localc.ia();
  }
  
  public final void b(ad<?> paramad)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(7, paramad));
  }
  
  final void b(x paramx)
  {
    synchronized (KF)
    {
      if (this.Oy == paramx)
      {
        this.Oy = null;
        this.Oz.clear();
      }
      return;
    }
  }
  
  final boolean c(ConnectionResult paramConnectionResult, int paramInt)
  {
    return this.HF.a(this.mContext, paramConnectionResult, paramInt);
  }
  
  public final void hY()
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    int i;
    Object localObject1;
    Object localObject2;
    ar localar;
    switch (paramMessage.what)
    {
    default: 
      i = paramMessage.what;
      Log.w("GoogleApiManager", 31 + "Unknown message id: " + i);
      return false;
    case 1: 
      if (((Boolean)paramMessage.obj).booleanValue()) {}
      for (long l = 10000L;; l = 300000L)
      {
        this.Ot = l;
        this.mHandler.removeMessages(12);
        paramMessage = this.MY.keySet().iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (ef)paramMessage.next();
          this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(12, localObject1), this.Ot);
        }
      }
    case 2: 
      paramMessage = (c)paramMessage.obj;
      localObject1 = paramMessage.hZ().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ef)((Iterator)localObject1).next();
        localar = (ar)this.MY.get(localObject2);
        if (localar != null) {
          break label286;
        }
        paramMessage.a((ef)localObject2, new ConnectionResult(13));
      }
    case 3: 
    case 4: 
    case 8: 
    case 13: 
      for (;;)
      {
        return true;
        if (localar.isConnected())
        {
          paramMessage.a((ef)localObject2, ConnectionResult.Hb);
          break;
        }
        if (localar.iR() != null)
        {
          paramMessage.a((ef)localObject2, localar.iR());
          break;
        }
        localar.a(paramMessage);
        break;
        paramMessage = this.MY.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (ar)paramMessage.next();
          ((ar)localObject1).iQ();
          ((ar)localObject1).connect();
        }
        localObject2 = (bg)paramMessage.obj;
        localObject1 = (ar)this.MY.get(((bg)localObject2).Pg.gJ());
        paramMessage = (Message)localObject1;
        if (localObject1 == null)
        {
          c(((bg)localObject2).Pg);
          paramMessage = (ar)this.MY.get(((bg)localObject2).Pg.gJ());
        }
        if ((paramMessage.gs()) && (this.Ox.get() != ((bg)localObject2).Pf))
        {
          ((bg)localObject2).Pe.i(Or);
          paramMessage.iO();
        }
        else
        {
          paramMessage.a(((bg)localObject2).Pe);
        }
      }
    case 5: 
      label286:
      i = paramMessage.arg1;
      localObject1 = (ConnectionResult)paramMessage.obj;
      localObject2 = this.MY.values().iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramMessage = (ar)((Iterator)localObject2).next();
      } while (paramMessage.getInstanceId() != i);
    }
    for (;;)
    {
      if (paramMessage != null)
      {
        localObject2 = String.valueOf(this.HF.bb(((ConnectionResult)localObject1).getErrorCode()));
        localObject1 = String.valueOf(((ConnectionResult)localObject1).go());
        paramMessage.d(new Status(17, String.valueOf(localObject2).length() + 69 + String.valueOf(localObject1).length() + "Error resolution was canceled by the user, original error message: " + (String)localObject2 + ": " + (String)localObject1));
        break;
      }
      Log.wtf("GoogleApiManager", 76 + "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
      break;
      i = Build.VERSION.SDK_INT;
      if (!(this.mContext.getApplicationContext() instanceof Application)) {
        break;
      }
      d.a((Application)this.mContext.getApplicationContext());
      d.ic().a(new e()
      {
        public final void x(boolean paramAnonymousBoolean)
        {
          aq.a(aq.this).sendMessage(aq.a(aq.this).obtainMessage(1, Boolean.valueOf(paramAnonymousBoolean)));
        }
      });
      if (d.ic().id()) {
        break;
      }
      this.Ot = 300000L;
      break;
      c((ad)paramMessage.obj);
      break;
      if (!this.MY.containsKey(paramMessage.obj)) {
        break;
      }
      ((ar)this.MY.get(paramMessage.obj)).resume();
      break;
      iJ();
      break;
      if (!this.MY.containsKey(paramMessage.obj)) {
        break;
      }
      ((ar)this.MY.get(paramMessage.obj)).iT();
      break;
      if (!this.MY.containsKey(paramMessage.obj)) {
        break;
      }
      ((ar)this.MY.get(paramMessage.obj)).iV();
      break;
      paramMessage = null;
    }
  }
  
  public final int iI()
  {
    return this.Ow.getAndIncrement();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.aq
 * JD-Core Version:    0.7.0.1
 */