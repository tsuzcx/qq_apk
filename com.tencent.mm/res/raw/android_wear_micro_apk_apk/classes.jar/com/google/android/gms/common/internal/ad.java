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
  private final ae LX;
  private final ArrayList<r> LY = new ArrayList();
  final ArrayList<r> LZ = new ArrayList();
  private final Object Lk = new Object();
  private final ArrayList<s> Ma = new ArrayList();
  private volatile boolean Mb = false;
  private final AtomicInteger Mc = new AtomicInteger(0);
  private boolean Md = false;
  private final Handler dG;
  
  public ad(Looper paramLooper, ae paramae)
  {
    this.LX = paramae;
    this.dG = new Handler(paramLooper, this);
  }
  
  public final void a(r paramr)
  {
    d.D(paramr);
    synchronized (this.Lk)
    {
      if (this.LY.contains(paramr))
      {
        String str = String.valueOf(paramr);
        Log.w("GmsClientEvents", String.valueOf(str).length() + 62 + "registerConnectionCallbacks(): listener " + str + " is already registered");
        if (this.LX.isConnected()) {
          this.dG.sendMessage(this.dG.obtainMessage(1, paramr));
        }
        return;
      }
      this.LY.add(paramr);
    }
  }
  
  public final void a(s params)
  {
    d.D(params);
    synchronized (this.Lk)
    {
      if (this.Ma.contains(params))
      {
        params = String.valueOf(params);
        Log.w("GmsClientEvents", String.valueOf(params).length() + 67 + "registerConnectionFailedListener(): listener " + params + " is already registered");
        return;
      }
      this.Ma.add(params);
    }
  }
  
  public final void b(s params)
  {
    d.D(params);
    synchronized (this.Lk)
    {
      if (!this.Ma.remove(params))
      {
        params = String.valueOf(params);
        Log.w("GmsClientEvents", String.valueOf(params).length() + 57 + "unregisterConnectionFailedListener(): listener " + params + " not found");
      }
      return;
    }
  }
  
  public final void bA(int paramInt)
  {
    boolean bool = false;
    if (Looper.myLooper() == this.dG.getLooper()) {
      bool = true;
    }
    d.a(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.dG.removeMessages(1);
    synchronized (this.Lk)
    {
      this.Md = true;
      Object localObject2 = new ArrayList(this.LY);
      int i = this.Mc.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        r localr = (r)((Iterator)localObject2).next();
        if ((this.Mb) && (this.Mc.get() == i)) {
          if (this.LY.contains(localr)) {
            localr.bx(paramInt);
          }
        }
      }
    }
    this.LZ.clear();
    this.Md = false;
  }
  
  public final void d(ConnectionResult paramConnectionResult)
  {
    if (Looper.myLooper() == this.dG.getLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      d.a(bool, "onConnectionFailure must only be called on the Handler thread");
      this.dG.removeMessages(1);
      synchronized (this.Lk)
      {
        Object localObject2 = new ArrayList(this.Ma);
        int i = this.Mc.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          s locals = (s)((Iterator)localObject2).next();
          if ((!this.Mb) || (this.Mc.get() != i)) {
            return;
          }
          if (this.Ma.contains(locals)) {
            locals.a(paramConnectionResult);
          }
        }
      }
      return;
    }
  }
  
  public final void hF()
  {
    this.Mb = false;
    this.Mc.incrementAndGet();
  }
  
  public final void hG()
  {
    this.Mb = true;
  }
  
  public final boolean handleMessage(Message arg1)
  {
    if (???.what == 1)
    {
      r localr = (r)???.obj;
      synchronized (this.Lk)
      {
        if ((this.Mb) && (this.LX.isConnected()) && (this.LY.contains(localr))) {
          localr.h(null);
        }
        return true;
      }
    }
    int i = ???.what;
    Log.wtf("GmsClientEvents", 45 + "Don't know how to handle message: " + i, new Exception());
    return false;
  }
  
  public final void i(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() == this.dG.getLooper())
    {
      bool1 = true;
      d.a(bool1, "onConnectionSuccess must only be called on the Handler thread");
    }
    for (;;)
    {
      synchronized (this.Lk)
      {
        if (this.Md) {
          break label190;
        }
        bool1 = true;
        d.y(bool1);
        this.dG.removeMessages(1);
        this.Md = true;
        if (this.LZ.size() != 0) {
          break label195;
        }
        bool1 = bool2;
        d.y(bool1);
        Object localObject2 = new ArrayList(this.LY);
        int i = this.Mc.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label200;
        }
        r localr = (r)((Iterator)localObject2).next();
        if ((!this.Mb) || (!this.LX.isConnected()) || (this.Mc.get() != i)) {
          break label200;
        }
        if (this.LZ.contains(localr)) {
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
    this.LZ.clear();
    this.Md = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ad
 * JD-Core Version:    0.7.0.1
 */