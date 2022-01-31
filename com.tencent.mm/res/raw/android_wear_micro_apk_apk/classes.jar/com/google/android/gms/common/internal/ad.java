package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class ad
  implements Handler.Callback
{
  private final Object Jv = new Object();
  private final ae Ki;
  private final ArrayList<r> Kj = new ArrayList();
  final ArrayList<r> Kk = new ArrayList();
  private final ArrayList<s> Kl = new ArrayList();
  private volatile boolean Km = false;
  private final AtomicInteger Kn = new AtomicInteger(0);
  private boolean Ko = false;
  private final Handler mHandler;
  
  public ad(Looper paramLooper, ae paramae)
  {
    this.Ki = paramae;
    this.mHandler = new Handler(paramLooper, this);
  }
  
  public final void a(r paramr)
  {
    d.u(paramr);
    synchronized (this.Jv)
    {
      if (this.Kj.contains(paramr))
      {
        String str = String.valueOf(paramr);
        Log.w("GmsClientEvents", String.valueOf(str).length() + 62 + "registerConnectionCallbacks(): listener " + str + " is already registered");
        if (this.Ki.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramr));
        }
        return;
      }
      this.Kj.add(paramr);
    }
  }
  
  public final void a(s params)
  {
    d.u(params);
    synchronized (this.Jv)
    {
      if (this.Kl.contains(params))
      {
        params = String.valueOf(params);
        Log.w("GmsClientEvents", String.valueOf(params).length() + 67 + "registerConnectionFailedListener(): listener " + params + " is already registered");
        return;
      }
      this.Kl.add(params);
    }
  }
  
  public final void b(s params)
  {
    d.u(params);
    synchronized (this.Jv)
    {
      if (!this.Kl.remove(params))
      {
        params = String.valueOf(params);
        Log.w("GmsClientEvents", String.valueOf(params).length() + 57 + "unregisterConnectionFailedListener(): listener " + params + " not found");
      }
      return;
    }
  }
  
  public final void bg(int paramInt)
  {
    boolean bool = false;
    if (Looper.myLooper() == this.mHandler.getLooper()) {
      bool = true;
    }
    d.a(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.mHandler.removeMessages(1);
    synchronized (this.Jv)
    {
      this.Ko = true;
      Object localObject2 = new ArrayList(this.Kj);
      int i = this.Kn.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        r localr = (r)((Iterator)localObject2).next();
        if ((this.Km) && (this.Kn.get() == i)) {
          if (this.Kj.contains(localr)) {
            localr.bd(paramInt);
          }
        }
      }
    }
    this.Kk.clear();
    this.Ko = false;
  }
  
  public final void d(ConnectionResult paramConnectionResult)
  {
    if (Looper.myLooper() == this.mHandler.getLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      d.a(bool, "onConnectionFailure must only be called on the Handler thread");
      this.mHandler.removeMessages(1);
      synchronized (this.Jv)
      {
        Object localObject2 = new ArrayList(this.Kl);
        int i = this.Kn.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          s locals = (s)((Iterator)localObject2).next();
          if ((!this.Km) || (this.Kn.get() != i)) {
            return;
          }
          if (this.Kl.contains(locals)) {
            locals.a(paramConnectionResult);
          }
        }
      }
      return;
    }
  }
  
  public final boolean handleMessage(Message arg1)
  {
    if (???.what == 1)
    {
      r localr = (r)???.obj;
      synchronized (this.Jv)
      {
        if ((this.Km) && (this.Ki.isConnected()) && (this.Kj.contains(localr))) {
          localr.h(null);
        }
        return true;
      }
    }
    int i = ???.what;
    Log.wtf("GmsClientEvents", 45 + "Don't know how to handle message: " + i, new Exception());
    return false;
  }
  
  public final void hv()
  {
    this.Km = false;
    this.Kn.incrementAndGet();
  }
  
  public final void hw()
  {
    this.Km = true;
  }
  
  public final void i(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() == this.mHandler.getLooper())
    {
      bool1 = true;
      d.a(bool1, "onConnectionSuccess must only be called on the Handler thread");
    }
    for (;;)
    {
      synchronized (this.Jv)
      {
        if (this.Ko) {
          break label190;
        }
        bool1 = true;
        d.v(bool1);
        this.mHandler.removeMessages(1);
        this.Ko = true;
        if (this.Kk.size() != 0) {
          break label195;
        }
        bool1 = bool2;
        d.v(bool1);
        Object localObject2 = new ArrayList(this.Kj);
        int i = this.Kn.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label200;
        }
        r localr = (r)((Iterator)localObject2).next();
        if ((!this.Km) || (!this.Ki.isConnected()) || (this.Kn.get() != i)) {
          break label200;
        }
        if (this.Kk.contains(localr)) {
          continue;
        }
        localr.h(paramBundle);
      }
      bool1 = false;
      break;
      label190:
      bool1 = false;
      continue;
      label195:
      bool1 = false;
    }
    label200:
    this.Kk.clear();
    this.Ko = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ad
 * JD-Core Version:    0.7.0.1
 */