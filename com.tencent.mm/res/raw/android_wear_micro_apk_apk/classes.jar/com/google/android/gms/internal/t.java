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
  private final aq JO;
  private final Looper Jt;
  private final x LU;
  private final com.google.android.gms.common.h Lj;
  private final Lock OI;
  private final Map<com.google.android.gms.common.api.h<?>, s<?>> ON = new HashMap();
  private final Map<com.google.android.gms.common.api.h<?>, s<?>> OO = new HashMap();
  private final Map<a<?>, Boolean> OP;
  private final ai OQ;
  private final Condition OR;
  private final boolean OS;
  private final boolean OT;
  private final Queue<g<?, ?>> OU = new LinkedList();
  private boolean OV;
  private Map<ef<?>, ConnectionResult> OW;
  private Map<ef<?>, ConnectionResult> OX;
  private v OY;
  private ConnectionResult OZ;
  
  public t(Context paramContext, Lock paramLock, Looper paramLooper, com.google.android.gms.common.h paramh, Map<com.google.android.gms.common.api.h<?>, j> paramMap, x paramx, Map<a<?>, Boolean> paramMap1, f<? extends cr, cs> paramf, ArrayList<n> paramArrayList, ai paramai, boolean paramBoolean)
  {
    this.OI = paramLock;
    this.Jt = paramLooper;
    this.OR = paramLock.newCondition();
    this.Lj = paramh;
    this.OQ = paramai;
    this.OP = paramMap1;
    this.LU = paramx;
    this.OS = paramBoolean;
    paramLock = new HashMap();
    paramh = paramMap1.keySet().iterator();
    while (paramh.hasNext())
    {
      paramMap1 = (a)paramh.next();
      paramLock.put(paramMap1.gB(), paramMap1);
    }
    paramh = new HashMap();
    paramMap1 = paramArrayList.iterator();
    while (paramMap1.hasNext())
    {
      paramArrayList = (n)paramMap1.next();
      paramh.put(paramArrayList.JJ, paramArrayList);
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
      if (paramArrayList.gD())
      {
        if (((Boolean)this.OP.get(paramai)).booleanValue()) {
          break label475;
        }
        i = 1;
        k = 1;
      }
    }
    for (;;)
    {
      paramai = new s(paramContext, paramai, paramLooper, paramArrayList, (n)paramh.get(paramai), paramx, paramf);
      this.ON.put((com.google.android.gms.common.api.h)paramMap1.getKey(), paramai);
      if (paramArrayList.gC()) {
        this.OO.put((com.google.android.gms.common.api.h)paramMap1.getKey(), paramai);
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
        this.OT = paramBoolean;
        this.JO = aq.iP();
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
    this.OI.lock();
    try
    {
      paramh = (s)this.ON.get(paramh);
      if ((this.OW != null) && (paramh != null))
      {
        paramh = (ConnectionResult)this.OW.get(paramh.gT());
        return paramh;
      }
      return null;
    }
    finally
    {
      this.OI.unlock();
    }
  }
  
  private <T extends g<? extends w, ? extends com.google.android.gms.common.api.g>> boolean f(T paramT)
  {
    com.google.android.gms.common.api.h localh = paramT.gB();
    ConnectionResult localConnectionResult = a(localh);
    if ((localConnectionResult != null) && (localConnectionResult.getErrorCode() == 4))
    {
      paramT.a(new Status(4, null, this.JO.a(((s)this.ON.get(localh)).gT(), System.identityHashCode(this.OQ))));
      return true;
    }
    return false;
  }
  
  /* Error */
  private boolean isConnecting()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/google/android/gms/internal/t:OI	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 173 1 0
    //   9: aload_0
    //   10: getfield 175	com/google/android/gms/internal/t:OW	Ljava/util/Map;
    //   13: ifnonnull +25 -> 38
    //   16: aload_0
    //   17: getfield 221	com/google/android/gms/internal/t:OV	Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +16 -> 38
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 59	com/google/android/gms/internal/t:OI	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 184 1 0
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -13 -> 27
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 59	com/google/android/gms/internal/t:OI	Ljava/util/concurrent/locks/Lock;
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
    if ((this.OS) && (f(paramT))) {
      return paramT;
    }
    if (!isConnected())
    {
      this.OU.add(paramT);
      return paramT;
    }
    this.OQ.PS.b(paramT);
    return ((s)this.ON.get(paramT.gB())).c(paramT);
  }
  
  public final ConnectionResult b(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(30L); isConnecting(); paramLong = this.OR.awaitNanos(paramLong))
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
      return ConnectionResult.IQ;
    }
    if (this.OZ != null) {
      return this.OZ;
    }
    return new ConnectionResult(13, null);
  }
  
  public final <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT)
  {
    com.google.android.gms.common.api.h localh = paramT.gB();
    if ((this.OS) && (f(paramT))) {
      return paramT;
    }
    this.OQ.PS.b(paramT);
    return ((s)this.ON.get(localh)).d(paramT);
  }
  
  public final void connect()
  {
    this.OI.lock();
    try
    {
      boolean bool = this.OV;
      if (bool) {
        return;
      }
      this.OV = true;
      this.OW = null;
      this.OX = null;
      this.OY = null;
      this.OZ = null;
      this.JO.ig();
      this.JO.b(this.ON.values()).a(new cd(this.Jt), new u(this, (byte)0));
      return;
    }
    finally
    {
      this.OI.unlock();
    }
  }
  
  public final void disconnect()
  {
    this.OI.lock();
    try
    {
      this.OV = false;
      this.OW = null;
      this.OX = null;
      if (this.OY != null) {
        this.OY = null;
      }
      this.OZ = null;
      while (!this.OU.isEmpty())
      {
        g localg = (g)this.OU.remove();
        localg.a(null);
        localg.cancel();
      }
      this.OR.signalAll();
    }
    finally
    {
      this.OI.unlock();
    }
    this.OI.unlock();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final void is() {}
  
  /* Error */
  public final boolean isConnected()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/google/android/gms/internal/t:OI	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 173 1 0
    //   9: aload_0
    //   10: getfield 175	com/google/android/gms/internal/t:OW	Ljava/util/Map;
    //   13: ifnull +25 -> 38
    //   16: aload_0
    //   17: getfield 188	com/google/android/gms/internal/t:OZ	Lcom/google/android/gms/common/ConnectionResult;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +16 -> 38
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 59	com/google/android/gms/internal/t:OI	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 184 1 0
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -13 -> 27
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 59	com/google/android/gms/internal/t:OI	Ljava/util/concurrent/locks/Lock;
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