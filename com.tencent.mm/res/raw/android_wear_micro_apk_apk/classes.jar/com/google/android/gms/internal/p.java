package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.x;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class p
  implements av
{
  private final Looper Jt;
  private final am OA;
  private final Map<com.google.android.gms.common.api.h<?>, am> OB;
  private final Set<Object> OC = Collections.newSetFromMap(new WeakHashMap());
  private final j OD;
  private Bundle OE;
  private ConnectionResult OF = null;
  private ConnectionResult OG = null;
  private boolean OH = false;
  private final Lock OI;
  private int OJ = 0;
  private final ai Oy;
  private final am Oz;
  private final Context mContext;
  
  private p(Context paramContext, ai paramai, Lock paramLock, Looper paramLooper, com.google.android.gms.common.h paramh, Map<com.google.android.gms.common.api.h<?>, j> paramMap1, Map<com.google.android.gms.common.api.h<?>, j> paramMap2, x paramx, f<? extends cr, cs> paramf, j paramj, ArrayList<n> paramArrayList1, ArrayList<n> paramArrayList2, Map<com.google.android.gms.common.api.a<?>, Boolean> paramMap3, Map<com.google.android.gms.common.api.a<?>, Boolean> paramMap4)
  {
    this.mContext = paramContext;
    this.Oy = paramai;
    this.OI = paramLock;
    this.Jt = paramLooper;
    this.OD = null;
    this.Oz = new am(paramContext, this.Oy, paramLock, paramLooper, paramh, paramMap2, null, paramMap4, null, paramArrayList2, new q(this, (byte)0));
    this.OA = new am(paramContext, this.Oy, paramLock, paramLooper, paramh, paramMap1, paramx, paramMap3, paramf, paramArrayList1, new r(this, (byte)0));
    paramContext = new android.support.v4.b.a();
    paramai = paramMap2.keySet().iterator();
    while (paramai.hasNext()) {
      paramContext.put((com.google.android.gms.common.api.h)paramai.next(), this.Oz);
    }
    paramai = paramMap1.keySet().iterator();
    while (paramai.hasNext()) {
      paramContext.put((com.google.android.gms.common.api.h)paramai.next(), this.OA);
    }
    this.OB = Collections.unmodifiableMap(paramContext);
  }
  
  public static p a(Context paramContext, ai paramai, Lock paramLock, Looper paramLooper, com.google.android.gms.common.h paramh, Map<com.google.android.gms.common.api.h<?>, j> paramMap, x paramx, Map<com.google.android.gms.common.api.a<?>, Boolean> paramMap1, f<? extends cr, cs> paramf, ArrayList<n> paramArrayList)
  {
    android.support.v4.b.a locala1 = new android.support.v4.b.a();
    android.support.v4.b.a locala2 = new android.support.v4.b.a();
    paramMap = paramMap.entrySet().iterator();
    Object localObject1;
    while (paramMap.hasNext())
    {
      localObject1 = (Map.Entry)paramMap.next();
      localObject2 = (j)((Map.Entry)localObject1).getValue();
      if (((j)localObject2).gC()) {
        locala1.put((com.google.android.gms.common.api.h)((Map.Entry)localObject1).getKey(), localObject2);
      } else {
        locala2.put((com.google.android.gms.common.api.h)((Map.Entry)localObject1).getKey(), localObject2);
      }
    }
    boolean bool;
    if (!locala1.isEmpty())
    {
      bool = true;
      d.a(bool, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
      paramMap = new android.support.v4.b.a();
      localObject1 = new android.support.v4.b.a();
      localObject2 = paramMap1.keySet().iterator();
    }
    Object localObject3;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (com.google.android.gms.common.api.a)((Iterator)localObject2).next();
        com.google.android.gms.common.api.h localh = ((com.google.android.gms.common.api.a)localObject3).gB();
        if (locala1.containsKey(localh))
        {
          paramMap.put(localObject3, (Boolean)paramMap1.get(localObject3));
          continue;
          bool = false;
          break;
        }
        if (locala2.containsKey(localh)) {
          ((Map)localObject1).put(localObject3, (Boolean)paramMap1.get(localObject3));
        } else {
          throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
        }
      }
    }
    paramMap1 = new ArrayList();
    Object localObject2 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject3 = (n)paramArrayList.next();
      if (paramMap.containsKey(((n)localObject3).JJ)) {
        paramMap1.add(localObject3);
      } else if (((Map)localObject1).containsKey(((n)localObject3).JJ)) {
        ((ArrayList)localObject2).add(localObject3);
      } else {
        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
      }
    }
    return new p(paramContext, paramai, paramLock, paramLooper, paramh, locala1, locala2, paramx, paramf, null, paramMap1, (ArrayList)localObject2, paramMap, (Map)localObject1);
  }
  
  private void e(ConnectionResult paramConnectionResult)
  {
    switch (this.OJ)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    }
    for (;;)
    {
      this.OJ = 0;
      return;
      this.Oy.g(paramConnectionResult);
      it();
    }
  }
  
  private boolean e(g<? extends w, ? extends com.google.android.gms.common.api.g> paramg)
  {
    paramg = paramg.gB();
    d.b(this.OB.containsKey(paramg), "GoogleApiClient is not configured to use the API required for this call.");
    return ((am)this.OB.get(paramg)).equals(this.OA);
  }
  
  private static boolean f(ConnectionResult paramConnectionResult)
  {
    return (paramConnectionResult != null) && (paramConnectionResult.gw());
  }
  
  private void it()
  {
    Iterator localIterator = this.OC.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    this.OC.clear();
  }
  
  private boolean iu()
  {
    return (this.OG != null) && (this.OG.getErrorCode() == 4);
  }
  
  private PendingIntent iv()
  {
    if (this.OD == null) {
      return null;
    }
    return PendingIntent.getActivity(this.mContext, System.identityHashCode(this.Oy), this.OD.gE(), 134217728);
  }
  
  public final <A extends com.google.android.gms.common.api.g, R extends w, T extends g<R, A>> T a(T paramT)
  {
    if (e(paramT))
    {
      if (iu())
      {
        paramT.a(new Status(4, null, iv()));
        return paramT;
      }
      return this.OA.a(paramT);
    }
    return this.Oz.a(paramT);
  }
  
  public final ConnectionResult b(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public final <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT)
  {
    if (e(paramT))
    {
      if (iu())
      {
        paramT.a(new Status(4, null, iv()));
        return paramT;
      }
      return this.OA.b(paramT);
    }
    return this.Oz.b(paramT);
  }
  
  public final void connect()
  {
    this.OJ = 2;
    this.OH = false;
    this.OG = null;
    this.OF = null;
    this.Oz.connect();
    this.OA.connect();
  }
  
  public final void disconnect()
  {
    this.OG = null;
    this.OF = null;
    this.OJ = 0;
    this.Oz.disconnect();
    this.OA.disconnect();
    it();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    this.OA.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    this.Oz.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final void is()
  {
    this.Oz.is();
    this.OA.is();
  }
  
  /* Error */
  public final boolean isConnected()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 64	com/google/android/gms/internal/p:OI	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 373 1 0
    //   11: aload_0
    //   12: getfield 80	com/google/android/gms/internal/p:Oz	Lcom/google/android/gms/internal/am;
    //   15: invokevirtual 375	com/google/android/gms/internal/am:isConnected	()Z
    //   18: ifeq +47 -> 65
    //   21: iload_3
    //   22: istore_2
    //   23: aload_0
    //   24: getfield 85	com/google/android/gms/internal/p:OA	Lcom/google/android/gms/internal/am;
    //   27: invokevirtual 375	com/google/android/gms/internal/am:isConnected	()Z
    //   30: ifne +24 -> 54
    //   33: iload_3
    //   34: istore_2
    //   35: aload_0
    //   36: invokespecial 222	com/google/android/gms/internal/p:iu	()Z
    //   39: ifne +15 -> 54
    //   42: aload_0
    //   43: getfield 58	com/google/android/gms/internal/p:OJ	I
    //   46: istore_1
    //   47: iload_1
    //   48: iconst_1
    //   49: if_icmpne +16 -> 65
    //   52: iload_3
    //   53: istore_2
    //   54: aload_0
    //   55: getfield 64	com/google/android/gms/internal/p:OI	Ljava/util/concurrent/locks/Lock;
    //   58: invokeinterface 378 1 0
    //   63: iload_2
    //   64: ireturn
    //   65: iconst_0
    //   66: istore_2
    //   67: goto -13 -> 54
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 64	com/google/android/gms/internal/p:OI	Ljava/util/concurrent/locks/Lock;
    //   76: invokeinterface 378 1 0
    //   81: aload 4
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	p
    //   46	4	1	i	int
    //   22	45	2	bool1	boolean
    //   1	52	3	bool2	boolean
    //   70	12	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	21	70	finally
    //   23	33	70	finally
    //   35	47	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.p
 * JD-Core Version:    0.7.0.1
 */