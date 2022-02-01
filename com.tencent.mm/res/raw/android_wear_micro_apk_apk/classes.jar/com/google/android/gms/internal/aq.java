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
  private static final Object Mu = new Object();
  public static final Status Qg = new Status(4, "Sign-out occurred while this API call was in progress.");
  private static final Status Qh = new Status(4, "The user must be signed in to make this API call.");
  private static aq Qj;
  private final com.google.android.gms.common.b Ju;
  private final Map<ef<?>, ar<?>> ON = new ConcurrentHashMap(5, 0.75F, 1);
  private long PI = 120000L;
  private long PJ = 5000L;
  private long Qi = 10000L;
  private int Qk = -1;
  private final AtomicInteger Ql = new AtomicInteger(1);
  private final AtomicInteger Qm = new AtomicInteger(0);
  private x Qn = null;
  private final Set<ef<?>> Qo = new a();
  private final Set<ef<?>> Qp = new a();
  private final Handler dG;
  private final Context mContext;
  
  private aq(Context paramContext, Looper paramLooper, com.google.android.gms.common.b paramb)
  {
    this.mContext = paramContext;
    this.dG = new Handler(paramLooper, this);
    this.Ju = paramb;
    this.dG.sendMessage(this.dG.obtainMessage(6));
  }
  
  private void c(ad<?> paramad)
  {
    ef localef = paramad.gT();
    ar localar2 = (ar)this.ON.get(localef);
    ar localar1 = localar2;
    if (localar2 == null)
    {
      localar1 = new ar(this, paramad);
      this.ON.put(localef, localar1);
    }
    if (localar1.gC()) {
      this.Qp.add(localef);
    }
    localar1.connect();
  }
  
  public static aq iP()
  {
    synchronized (Mu)
    {
      com.google.android.gms.common.internal.d.g(Qj, "Must guarantee manager is non-null before using getInstance");
      aq localaq = Qj;
      return localaq;
    }
  }
  
  private void iR()
  {
    Iterator localIterator = this.Qp.iterator();
    while (localIterator.hasNext())
    {
      ef localef = (ef)localIterator.next();
      ((ar)this.ON.remove(localef)).iX();
    }
    this.Qp.clear();
  }
  
  public static aq t(Context paramContext)
  {
    synchronized (Mu)
    {
      if (Qj == null)
      {
        Object localObject2 = new HandlerThread("GoogleApiHandler", 9);
        ((HandlerThread)localObject2).start();
        localObject2 = ((HandlerThread)localObject2).getLooper();
        Qj = new aq(paramContext.getApplicationContext(), (Looper)localObject2, com.google.android.gms.common.b.gz());
      }
      paramContext = Qj;
      return paramContext;
    }
  }
  
  final PendingIntent a(ef<?> paramef, int paramInt)
  {
    if ((ar)this.ON.get(paramef) == null) {
      return null;
    }
    paramef = ((ar)this.ON.get(paramef)).jf();
    if (paramef == null) {
      return null;
    }
    return PendingIntent.getActivity(this.mContext, paramInt, paramef.gE(), 134217728);
  }
  
  public final void a(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!c(paramConnectionResult, paramInt)) {
      this.dG.sendMessage(this.dG.obtainMessage(5, paramInt, 0, paramConnectionResult));
    }
  }
  
  public final <O extends com.google.android.gms.common.api.b> void a(ad<O> paramad, int paramInt, g<? extends w, com.google.android.gms.common.api.g> paramg)
  {
    paramg = new ec(paramInt, paramg);
    this.dG.sendMessage(this.dG.obtainMessage(4, new bg(paramg, this.Qm.get(), paramad)));
  }
  
  public final void a(x paramx)
  {
    synchronized (Mu)
    {
      if (this.Qn != paramx)
      {
        this.Qn = paramx;
        this.Qo.clear();
        this.Qo.addAll(paramx.iA());
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
      localObject = (ar)this.ON.get(((ad)localObject).gT());
      if ((localObject == null) || (!((ar)localObject).isConnected()))
      {
        this.dG.sendMessage(this.dG.obtainMessage(2, localc));
        return localc.ii();
      }
    }
    localc.ij();
    return localc.ii();
  }
  
  public final void b(ad<?> paramad)
  {
    this.dG.sendMessage(this.dG.obtainMessage(7, paramad));
  }
  
  final void b(x paramx)
  {
    synchronized (Mu)
    {
      if (this.Qn == paramx)
      {
        this.Qn = null;
        this.Qo.clear();
      }
      return;
    }
  }
  
  final boolean c(ConnectionResult paramConnectionResult, int paramInt)
  {
    return this.Ju.a(this.mContext, paramConnectionResult, paramInt);
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
        this.Qi = l;
        this.dG.removeMessages(12);
        paramMessage = this.ON.keySet().iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (ef)paramMessage.next();
          this.dG.sendMessageDelayed(this.dG.obtainMessage(12, localObject1), this.Qi);
        }
      }
    case 2: 
      paramMessage = (c)paramMessage.obj;
      localObject1 = paramMessage.ih().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ef)((Iterator)localObject1).next();
        localar = (ar)this.ON.get(localObject2);
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
          paramMessage.a((ef)localObject2, ConnectionResult.IQ);
          break;
        }
        if (localar.ja() != null)
        {
          paramMessage.a((ef)localObject2, localar.ja());
          break;
        }
        localar.a(paramMessage);
        break;
        paramMessage = this.ON.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (ar)paramMessage.next();
          ((ar)localObject1).iZ();
          ((ar)localObject1).connect();
        }
        localObject2 = (bg)paramMessage.obj;
        localObject1 = (ar)this.ON.get(((bg)localObject2).QV.gT());
        paramMessage = (Message)localObject1;
        if (localObject1 == null)
        {
          c(((bg)localObject2).QV);
          paramMessage = (ar)this.ON.get(((bg)localObject2).QV.gT());
        }
        if ((paramMessage.gC()) && (this.Qm.get() != ((bg)localObject2).QU))
        {
          ((bg)localObject2).QT.i(Qg);
          paramMessage.iX();
        }
        else
        {
          paramMessage.a(((bg)localObject2).QT);
        }
      }
    case 5: 
      label286:
      i = paramMessage.arg1;
      localObject1 = (ConnectionResult)paramMessage.obj;
      localObject2 = this.ON.values().iterator();
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
        localObject2 = String.valueOf(this.Ju.bv(((ConnectionResult)localObject1).getErrorCode()));
        localObject1 = String.valueOf(((ConnectionResult)localObject1).gy());
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
      d.ik().a(new e()
      {
        public final void A(boolean paramAnonymousBoolean)
        {
          aq.a(aq.this).sendMessage(aq.a(aq.this).obtainMessage(1, Boolean.valueOf(paramAnonymousBoolean)));
        }
      });
      if (d.ik().il()) {
        break;
      }
      this.Qi = 300000L;
      break;
      c((ad)paramMessage.obj);
      break;
      if (!this.ON.containsKey(paramMessage.obj)) {
        break;
      }
      ((ar)this.ON.get(paramMessage.obj)).resume();
      break;
      iR();
      break;
      if (!this.ON.containsKey(paramMessage.obj)) {
        break;
      }
      ((ar)this.ON.get(paramMessage.obj)).jc();
      break;
      if (!this.ON.containsKey(paramMessage.obj)) {
        break;
      }
      ((ar)this.ON.get(paramMessage.obj)).je();
      break;
      paramMessage = null;
    }
  }
  
  public final int iQ()
  {
    return this.Ql.getAndIncrement();
  }
  
  public final void ig()
  {
    this.dG.sendMessage(this.dG.obtainMessage(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.aq
 * JD-Core Version:    0.7.0.1
 */