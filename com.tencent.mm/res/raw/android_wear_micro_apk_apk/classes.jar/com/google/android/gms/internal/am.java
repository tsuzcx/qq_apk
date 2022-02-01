package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
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
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class am
  implements av, o
{
  final f<? extends cr, cs> Jv;
  final x LU;
  private final com.google.android.gms.common.h Lj;
  private final Lock OI;
  final Map<a<?>, Boolean> OP;
  final ai Oy;
  final Map<com.google.android.gms.common.api.h<?>, j> PM;
  private final Condition PW;
  private final ao PX;
  final Map<com.google.android.gms.common.api.h<?>, ConnectionResult> PY = new HashMap();
  private volatile al PZ;
  private ConnectionResult Qa = null;
  int Qb;
  final aw Qc;
  private final Context mContext;
  
  public am(Context paramContext, ai paramai, Lock paramLock, Looper paramLooper, com.google.android.gms.common.h paramh, Map<com.google.android.gms.common.api.h<?>, j> paramMap, x paramx, Map<a<?>, Boolean> paramMap1, f<? extends cr, cs> paramf, ArrayList<n> paramArrayList, aw paramaw)
  {
    this.mContext = paramContext;
    this.OI = paramLock;
    this.Lj = paramh;
    this.PM = paramMap;
    this.LU = paramx;
    this.OP = paramMap1;
    this.Jv = paramf;
    this.Oy = paramai;
    this.Qc = paramaw;
    paramContext = paramArrayList.iterator();
    while (paramContext.hasNext()) {
      ((n)paramContext.next()).a(this);
    }
    this.PX = new ao(this, paramLooper);
    this.PW = paramLock.newCondition();
    this.PZ = new ah(this);
  }
  
  public final <A extends com.google.android.gms.common.api.g, R extends w, T extends g<R, A>> T a(T paramT)
  {
    paramT.ip();
    return this.PZ.a(paramT);
  }
  
  public final void a(ConnectionResult paramConnectionResult, a<?> parama, boolean paramBoolean)
  {
    this.OI.lock();
    try
    {
      this.PZ.a(paramConnectionResult, parama, paramBoolean);
      return;
    }
    finally
    {
      this.OI.unlock();
    }
  }
  
  final void a(an paraman)
  {
    paraman = this.PX.obtainMessage(1, paraman);
    this.PX.sendMessage(paraman);
  }
  
  public final ConnectionResult b(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(30L); (this.PZ instanceof aa); paramLong = this.PW.awaitNanos(paramLong))
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
    if (this.Qa != null) {
      return this.Qa;
    }
    return new ConnectionResult(13, null);
  }
  
  public final <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT)
  {
    paramT.ip();
    return this.PZ.b(paramT);
  }
  
  final void b(RuntimeException paramRuntimeException)
  {
    paramRuntimeException = this.PX.obtainMessage(2, paramRuntimeException);
    this.PX.sendMessage(paramRuntimeException);
  }
  
  public final void bx(int paramInt)
  {
    this.OI.lock();
    try
    {
      this.PZ.bx(paramInt);
      return;
    }
    finally
    {
      this.OI.unlock();
    }
  }
  
  public final void connect()
  {
    this.PZ.connect();
  }
  
  public final void disconnect()
  {
    if (this.PZ.disconnect()) {
      this.PY.clear();
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramFileDescriptor = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(this.PZ);
    paramArrayOfString = this.OP.keySet().iterator();
    while (paramArrayOfString.hasNext())
    {
      a locala = (a)paramArrayOfString.next();
      paramPrintWriter.append(paramString).append(locala.getName()).println(":");
      ((j)this.PM.get(locala.gB())).a(paramFileDescriptor, paramPrintWriter);
    }
  }
  
  public final void h(Bundle paramBundle)
  {
    this.OI.lock();
    try
    {
      this.PZ.h(paramBundle);
      return;
    }
    finally
    {
      this.OI.unlock();
    }
  }
  
  final void iM()
  {
    this.OI.lock();
    try
    {
      this.PZ = new aa(this, this.LU, this.OP, this.Lj, this.Jv, this.OI, this.mContext);
      this.PZ.begin();
      this.PW.signalAll();
      return;
    }
    finally
    {
      this.OI.unlock();
    }
  }
  
  final void iN()
  {
    this.OI.lock();
    try
    {
      this.Oy.iJ();
      this.PZ = new z(this);
      this.PZ.begin();
      this.PW.signalAll();
      return;
    }
    finally
    {
      this.OI.unlock();
    }
  }
  
  public final void is()
  {
    if (isConnected()) {
      ((z)this.PZ).iB();
    }
  }
  
  public final boolean isConnected()
  {
    return this.PZ instanceof z;
  }
  
  final void k(ConnectionResult paramConnectionResult)
  {
    this.OI.lock();
    try
    {
      this.Qa = paramConnectionResult;
      this.PZ = new ah(this);
      this.PZ.begin();
      this.PW.signalAll();
      return;
    }
    finally
    {
      this.OI.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.am
 * JD-Core Version:    0.7.0.1
 */