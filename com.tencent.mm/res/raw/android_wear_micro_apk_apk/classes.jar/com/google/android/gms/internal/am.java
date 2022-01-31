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
  final f<? extends cr, cs> HG;
  private final com.google.android.gms.common.h Ju;
  final x Kf;
  final ai MJ;
  private final Lock MT;
  final Map<com.google.android.gms.common.api.h<?>, j> NX;
  final Map<a<?>, Boolean> Na;
  private final Condition Oh;
  private final ao Oi;
  final Map<com.google.android.gms.common.api.h<?>, ConnectionResult> Oj = new HashMap();
  private volatile al Ok;
  private ConnectionResult Ol = null;
  int Om;
  final aw On;
  private final Context mContext;
  
  public am(Context paramContext, ai paramai, Lock paramLock, Looper paramLooper, com.google.android.gms.common.h paramh, Map<com.google.android.gms.common.api.h<?>, j> paramMap, x paramx, Map<a<?>, Boolean> paramMap1, f<? extends cr, cs> paramf, ArrayList<n> paramArrayList, aw paramaw)
  {
    this.mContext = paramContext;
    this.MT = paramLock;
    this.Ju = paramh;
    this.NX = paramMap;
    this.Kf = paramx;
    this.Na = paramMap1;
    this.HG = paramf;
    this.MJ = paramai;
    this.On = paramaw;
    paramContext = paramArrayList.iterator();
    while (paramContext.hasNext()) {
      ((n)paramContext.next()).a(this);
    }
    this.Oi = new ao(this, paramLooper);
    this.Oh = paramLock.newCondition();
    this.Ok = new ah(this);
  }
  
  public final <A extends com.google.android.gms.common.api.g, R extends w, T extends g<R, A>> T a(T paramT)
  {
    paramT.ih();
    return this.Ok.a(paramT);
  }
  
  public final void a(ConnectionResult paramConnectionResult, a<?> parama, boolean paramBoolean)
  {
    this.MT.lock();
    try
    {
      this.Ok.a(paramConnectionResult, parama, paramBoolean);
      return;
    }
    finally
    {
      this.MT.unlock();
    }
  }
  
  final void a(an paraman)
  {
    paraman = this.Oi.obtainMessage(1, paraman);
    this.Oi.sendMessage(paraman);
  }
  
  public final ConnectionResult b(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    for (paramLong = paramTimeUnit.toNanos(30L); (this.Ok instanceof aa); paramLong = this.Oh.awaitNanos(paramLong))
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
    if (this.Ol != null) {
      return this.Ol;
    }
    return new ConnectionResult(13, null);
  }
  
  public final <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT)
  {
    paramT.ih();
    return this.Ok.b(paramT);
  }
  
  final void b(RuntimeException paramRuntimeException)
  {
    paramRuntimeException = this.Oi.obtainMessage(2, paramRuntimeException);
    this.Oi.sendMessage(paramRuntimeException);
  }
  
  public final void bd(int paramInt)
  {
    this.MT.lock();
    try
    {
      this.Ok.bd(paramInt);
      return;
    }
    finally
    {
      this.MT.unlock();
    }
  }
  
  public final void connect()
  {
    this.Ok.connect();
  }
  
  public final void disconnect()
  {
    if (this.Ok.disconnect()) {
      this.Oj.clear();
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramFileDescriptor = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(this.Ok);
    paramArrayOfString = this.Na.keySet().iterator();
    while (paramArrayOfString.hasNext())
    {
      a locala = (a)paramArrayOfString.next();
      paramPrintWriter.append(paramString).append(locala.getName()).println(":");
      ((j)this.NX.get(locala.gr())).a(paramFileDescriptor, paramPrintWriter);
    }
  }
  
  public final void h(Bundle paramBundle)
  {
    this.MT.lock();
    try
    {
      this.Ok.h(paramBundle);
      return;
    }
    finally
    {
      this.MT.unlock();
    }
  }
  
  final void iE()
  {
    this.MT.lock();
    try
    {
      this.Ok = new aa(this, this.Kf, this.Na, this.Ju, this.HG, this.MT, this.mContext);
      this.Ok.begin();
      this.Oh.signalAll();
      return;
    }
    finally
    {
      this.MT.unlock();
    }
  }
  
  final void iF()
  {
    this.MT.lock();
    try
    {
      this.MJ.iB();
      this.Ok = new z(this);
      this.Ok.begin();
      this.Oh.signalAll();
      return;
    }
    finally
    {
      this.MT.unlock();
    }
  }
  
  public final void ik()
  {
    if (isConnected()) {
      ((z)this.Ok).it();
    }
  }
  
  public final boolean isConnected()
  {
    return this.Ok instanceof z;
  }
  
  final void j(ConnectionResult paramConnectionResult)
  {
    this.MT.lock();
    try
    {
      this.Ol = paramConnectionResult;
      this.Ok = new ah(this);
      this.Ok.begin();
      this.Oh.signalAll();
      return;
    }
    finally
    {
      this.MT.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.am
 * JD-Core Version:    0.7.0.1
 */