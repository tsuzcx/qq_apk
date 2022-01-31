package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.b.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.internal.x;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class t
  implements av
{
  private final Looper HE;
  private final aq HZ;
  private final com.google.android.gms.common.h Ju;
  private final x Kf;
  private final Lock MT;
  private final Map<com.google.android.gms.common.api.h<?>, s<?>> MY = new HashMap();
  private final Map<com.google.android.gms.common.api.h<?>, s<?>> MZ = new HashMap();
  private final Map<a<?>, Boolean> Na;
  private final ai Nb;
  private final Condition Nc;
  private final boolean Nd;
  private final boolean Ne;
  private final Queue<g<?, ?>> Nf = new LinkedList();
  private boolean Ng;
  private Map<ef<?>, ConnectionResult> Nh;
  private Map<ef<?>, ConnectionResult> Ni;
  private v Nj;
  private ConnectionResult Nk;
  
  public t(Context paramContext, Lock paramLock, Looper paramLooper, com.google.android.gms.common.h paramh, Map<com.google.android.gms.common.api.h<?>, j> paramMap, x paramx, Map<a<?>, Boolean> paramMap1, f<? extends cr, cs> paramf, ArrayList<n> paramArrayList, ai paramai, boolean paramBoolean)
  {
    this.MT = paramLock;
    this.HE = paramLooper;
    this.Nc = paramLock.newCondition();
    this.Ju = paramh;
    this.Nb = paramai;
    this.Na = paramMap1;
    this.Kf = paramx;
    this.Nd = paramBoolean;
    paramLock = new HashMap();
    paramh = paramMap1.keySet().iterator();
    while (paramh.hasNext())
    {
      paramMap1 = (a)paramh.next();
      paramLock.put(paramMap1.gr(), paramMap1);
    }
    paramh = new HashMap();
    paramMap1 = paramArrayList.iterator();
    while (paramMap1.hasNext())
    {
      paramArrayList = (n)paramMap1.next();
      paramh.put(paramArrayList.HU, paramArrayList);
    }
    int i = 0;
    int j = 1;
    int k = 0;
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext())
    {
      paramMap1 = (Map.Entry)paramMap.next();
      paramai = (a)paramLock.get(paramMap1.getKey());
      paramArrayList = (j)paramMap1.getValue();
      if (paramArrayList.gt())
      {
        if (((Boolean)this.Na.get(paramai)).booleanValue()) {
          break label475;
        }
        i = 1;
        k = 1;
      }
    }
    for (;;)
    {
      paramai = new s(paramContext, paramai, paramLooper, paramArrayList, (n)paramh.get(paramai), paramx, paramf);
      this.MY.put((com.google.android.gms.common.api.h)paramMap1.getKey(), paramai);
      if (paramArrayList.gs()) {
        this.MZ.put((com.google.android.gms.common.api.h)paramMap1.getKey(), paramai);
      }
      int m = k;
      k = i;
      i = m;
      break;
      j = k;
      m = 0;
      k = i;
      i = j;
      j = m;
      continue;
      if ((k != 0) && (j == 0) && (i == 0)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.Ne = paramBoolean;
        this.HZ = aq.iH();
        return;
      }
      label475:
      m = 1;
      k = i;
      i = m;
    }
  }
  
  private ConnectionResult a(com.google.android.gms.common.api.h<?> paramh)
  {
    this.MT.lock();
    try
    {
      paramh = (s)this.MY.get(paramh);
      if ((this.Nh != null) && (paramh != null))
      {
        paramh = (ConnectionResult)this.Nh.get(paramh.gJ());
        return paramh;
      }
      return null;
    }
    finally
    {
      this.MT.unlock();
    }
  }
  
  private <T extends g<? extends w, ? extends com.google.android.gms.common.api.g>> boolean f(T paramT)
  {
    com.google.android.gms.common.api.h localh = paramT.gr();
    ConnectionResult localConnectionResult = a(localh);
    if ((localConnectionResult != null) && (localConnectionResult.getErrorCode() == 4))
    {
      paramT.a(new Status(4, null, this.HZ.a(((s)this.MY.get(localh)).gJ(), System.identityHashCode(this.Nb))));
      return true;
    }
    return false;
  }
  
  /* Error */
  private boolean isConnecting()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/google/android/gms/internal/t:MT	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 173 1 0
    //   9: aload_0
    //   10: getfield 175	com/google/android/gms/internal/t:Nh	Ljava/util/Map;
    //   13: ifnonnull +25 -> 38
    //   16: aload_0
    //   17: getfield 221	com/google/android/gms/internal/t:Ng	Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +16 -> 38
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 59	com/google/android/gms/internal/t:MT	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 184 1 0
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -13 -> 27
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 59	com/google/android/gms/internal/t:MT	Ljava/util/concurrent/locks/Lock;
    //   48: invokeinterface 184 1 0
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	t
    //   20	20	1	bool	boolean
    //   43	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	43	finally
  }
  
  public final <A extends com.google.android.gms.common.api.g, R extends w, T extends g<R, A>> T a(T paramT)
  {
    if ((this.Nd) && (f(paramT))) {
      return paramT;
    }
    if (!isConnected())
    {
      this.Nf.add(paramT);
      return paramT;
    }
    this.Nb.Od.b(paramT);
    return ((s)this.MY.get(paramT.gr())).c(paramT);
  }
  
  public final ConnectionResult b(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(30L); isConnecting(); paramLong = this.Nc.awaitNanos(paramLong))
    {
      if (paramLong <= 0L) {}
      try
      {
        disconnect();
        return new ConnectionResult(14, null);
      }
      catch (InterruptedException paramTimeUnit)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected()) {
      return ConnectionResult.Hb;
    }
    if (this.Nk != null) {
      return this.Nk;
    }
    return new ConnectionResult(13, null);
  }
  
  public final <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT)
  {
    com.google.android.gms.common.api.h localh = paramT.gr();
    if ((this.Nd) && (f(paramT))) {
      return paramT;
    }
    this.Nb.Od.b(paramT);
    return ((s)this.MY.get(localh)).d(paramT);
  }
  
  public final void connect()
  {
    this.MT.lock();
    try
    {
      boolean bool = this.Ng;
      if (bool) {
        return;
      }
      this.Ng = true;
      this.Nh = null;
      this.Ni = null;
      this.Nj = null;
      this.Nk = null;
      this.HZ.hY();
      this.HZ.b(this.MY.values()).a(new cd(this.HE), new u(this, (byte)0));
      return;
    }
    finally
    {
      this.MT.unlock();
    }
  }
  
  public final void disconnect()
  {
    this.MT.lock();
    try
    {
      this.Ng = false;
      this.Nh = null;
      this.Ni = null;
      if (this.Nj != null) {
        this.Nj = null;
      }
      this.Nk = null;
      while (!this.Nf.isEmpty())
      {
        g localg = (g)this.Nf.remove();
        localg.a(null);
        localg.cancel();
      }
      this.Nc.signalAll();
    }
    finally
    {
      this.MT.unlock();
    }
    this.MT.unlock();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final void ik() {}
  
  /* Error */
  public final boolean isConnected()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/google/android/gms/internal/t:MT	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 173 1 0
    //   9: aload_0
    //   10: getfield 175	com/google/android/gms/internal/t:Nh	Ljava/util/Map;
    //   13: ifnull +25 -> 38
    //   16: aload_0
    //   17: getfield 188	com/google/android/gms/internal/t:Nk	Lcom/google/android/gms/common/ConnectionResult;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +16 -> 38
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 59	com/google/android/gms/internal/t:MT	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 184 1 0
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -13 -> 27
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 59	com/google/android/gms/internal/t:MT	Ljava/util/concurrent/locks/Lock;
    //   48: invokeinterface 184 1 0
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	t
    //   26	14	1	bool	boolean
    //   20	2	2	localConnectionResult	ConnectionResult
    //   43	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	43	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.t
 * JD-Core Version:    0.7.0.1
 */