package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.h;
import com.google.android.gms.common.zzc;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class l<T extends IInterface>
{
  public static final String[] JI = { "service_esmobile", "service_googleme" };
  private final Looper HE;
  private final ArrayList<q<?>> JA = new ArrayList();
  private t JB;
  private int JC = 1;
  private final n JD;
  private final o JE;
  private final int JF;
  private final String JG;
  protected AtomicInteger JH = new AtomicInteger(0);
  private int Jo;
  private long Jp;
  private long Jq;
  private int Jr;
  private long Js;
  private final af Jt;
  private final h Ju;
  private final Object Jv = new Object();
  private final Object Jw = new Object();
  private at Jx;
  protected r Jy;
  private T Jz;
  private final Context mContext;
  final Handler mHandler;
  
  protected l(Context paramContext, Looper paramLooper, af paramaf, h paramh, int paramInt, n paramn, o paramo, String paramString)
  {
    this.mContext = ((Context)d.e(paramContext, "Context must not be null"));
    this.HE = ((Looper)d.e(paramLooper, "Looper must not be null"));
    this.Jt = ((af)d.e(paramaf, "Supervisor must not be null"));
    this.Ju = ((h)d.e(paramh, "API availability must not be null"));
    this.mHandler = new p(this, paramLooper);
    this.JF = paramInt;
    this.JD = paramn;
    this.JE = paramo;
    this.JG = paramString;
  }
  
  private void a(int paramInt, T paramT)
  {
    boolean bool = true;
    int i;
    int j;
    if (paramInt == 3)
    {
      i = 1;
      if (paramT == null) {
        break label383;
      }
      j = 1;
      label17:
      if (i != j) {
        break label389;
      }
    }
    for (;;)
    {
      d.w(bool);
      for (;;)
      {
        synchronized (this.Jv)
        {
          this.JC = paramInt;
          this.Jz = paramT;
          switch (paramInt)
          {
          case 2: 
            return;
            if (this.JB != null)
            {
              paramT = String.valueOf(gv());
              str = String.valueOf(hd());
              Log.e("GmsClient", String.valueOf(paramT).length() + 70 + String.valueOf(str).length() + "Calling connect() while still connected, missing disconnect() for " + paramT + " on " + str);
              this.Jt.b(gv(), hd(), this.JB, he());
              this.JH.incrementAndGet();
            }
            this.JB = new t(this, this.JH.get());
            if (this.Jt.a(gv(), hd(), this.JB, he())) {
              continue;
            }
            paramT = String.valueOf(gv());
            String str = String.valueOf(hd());
            Log.e("GmsClient", String.valueOf(paramT).length() + 34 + String.valueOf(str).length() + "unable to connect to service: " + paramT + " on " + str);
            Y(16, this.JH.get());
          }
        }
        this.Jq = System.currentTimeMillis();
        continue;
        if (this.JB != null)
        {
          this.Jt.b(gv(), hd(), this.JB, he());
          this.JB = null;
        }
      }
      i = 0;
      break;
      label383:
      j = 0;
      break label17;
      label389:
      bool = false;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (this.Jv)
    {
      if (this.JC != paramInt1) {
        return false;
      }
      a(paramInt2, paramT);
      return true;
    }
  }
  
  private String he()
  {
    if (this.JG == null) {
      return this.mContext.getClass().getName();
    }
    return this.JG;
  }
  
  protected final void Y(int paramInt1, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(5, paramInt2, -1, new w(this, paramInt1, null)));
  }
  
  protected void a(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramInt2, -1, new v(this, paramInt1, paramIBinder, paramBundle)));
  }
  
  protected final void a(ConnectionResult paramConnectionResult)
  {
    this.Jr = paramConnectionResult.getErrorCode();
    this.Js = System.currentTimeMillis();
  }
  
  /* Error */
  public final void a(ak arg1, Set<Scope> paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 279	com/google/android/gms/common/internal/l:hg	()Landroid/os/Bundle;
    //   4: astore 4
    //   6: new 281	com/google/android/gms/common/internal/zzj
    //   9: dup
    //   10: aload_0
    //   11: getfield 121	com/google/android/gms/common/internal/l:JF	I
    //   14: invokespecial 282	com/google/android/gms/common/internal/zzj:<init>	(I)V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: getfield 94	com/google/android/gms/common/internal/l:mContext	Landroid/content/Context;
    //   23: invokevirtual 285	android/content/Context:getPackageName	()Ljava/lang/String;
    //   26: putfield 288	com/google/android/gms/common/internal/zzj:JZ	Ljava/lang/String;
    //   29: aload_3
    //   30: aload 4
    //   32: putfield 292	com/google/android/gms/common/internal/zzj:Kc	Landroid/os/Bundle;
    //   35: aload_2
    //   36: ifnull +25 -> 61
    //   39: aload_3
    //   40: aload_2
    //   41: aload_2
    //   42: invokeinterface 297 1 0
    //   47: anewarray 299	com/google/android/gms/common/api/Scope
    //   50: invokeinterface 303 2 0
    //   55: checkcast 305	[Lcom/google/android/gms/common/api/Scope;
    //   58: putfield 308	com/google/android/gms/common/internal/zzj:Kb	[Lcom/google/android/gms/common/api/Scope;
    //   61: aload_0
    //   62: invokevirtual 312	com/google/android/gms/common/internal/l:gs	()Z
    //   65: ifeq +34 -> 99
    //   68: aload_0
    //   69: invokevirtual 316	com/google/android/gms/common/internal/l:fX	()Landroid/accounts/Account;
    //   72: ifnull +77 -> 149
    //   75: aload_0
    //   76: invokevirtual 316	com/google/android/gms/common/internal/l:fX	()Landroid/accounts/Account;
    //   79: astore_2
    //   80: aload_3
    //   81: aload_2
    //   82: putfield 320	com/google/android/gms/common/internal/zzj:Kd	Landroid/accounts/Account;
    //   85: aload_1
    //   86: ifnull +13 -> 99
    //   89: aload_3
    //   90: aload_1
    //   91: invokeinterface 326 1 0
    //   96: putfield 330	com/google/android/gms/common/internal/zzj:Ka	Landroid/os/IBinder;
    //   99: aload_3
    //   100: aload_0
    //   101: invokevirtual 334	com/google/android/gms/common/internal/l:hf	()[Lcom/google/android/gms/common/zzc;
    //   104: putfield 338	com/google/android/gms/common/internal/zzj:Ke	[Lcom/google/android/gms/common/zzc;
    //   107: aload_0
    //   108: getfield 68	com/google/android/gms/common/internal/l:Jw	Ljava/lang/Object;
    //   111: astore_1
    //   112: aload_1
    //   113: monitorenter
    //   114: aload_0
    //   115: getfield 131	com/google/android/gms/common/internal/l:Jx	Lcom/google/android/gms/common/internal/at;
    //   118: ifnull +48 -> 166
    //   121: aload_0
    //   122: getfield 131	com/google/android/gms/common/internal/l:Jx	Lcom/google/android/gms/common/internal/at;
    //   125: new 340	com/google/android/gms/common/internal/s
    //   128: dup
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 82	com/google/android/gms/common/internal/l:JH	Ljava/util/concurrent/atomic/AtomicInteger;
    //   134: invokevirtual 192	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   137: invokespecial 341	com/google/android/gms/common/internal/s:<init>	(Lcom/google/android/gms/common/internal/l;I)V
    //   140: aload_3
    //   141: invokeinterface 346 3 0
    //   146: aload_1
    //   147: monitorexit
    //   148: return
    //   149: new 348	android/accounts/Account
    //   152: dup
    //   153: ldc_w 350
    //   156: ldc_w 352
    //   159: invokespecial 355	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: astore_2
    //   163: goto -83 -> 80
    //   166: ldc 154
    //   168: ldc_w 357
    //   171: invokestatic 359	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   174: pop
    //   175: goto -29 -> 146
    //   178: astore_2
    //   179: aload_1
    //   180: monitorexit
    //   181: aload_2
    //   182: athrow
    //   183: astore_1
    //   184: ldc 154
    //   186: ldc_w 361
    //   189: aload_1
    //   190: invokestatic 364	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   193: pop
    //   194: aload_0
    //   195: getfield 119	com/google/android/gms/common/internal/l:mHandler	Landroid/os/Handler;
    //   198: aload_0
    //   199: getfield 119	com/google/android/gms/common/internal/l:mHandler	Landroid/os/Handler;
    //   202: iconst_4
    //   203: aload_0
    //   204: getfield 82	com/google/android/gms/common/internal/l:JH	Ljava/util/concurrent/atomic/AtomicInteger;
    //   207: invokevirtual 192	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   210: iconst_1
    //   211: invokevirtual 367	android/os/Handler:obtainMessage	(III)Landroid/os/Message;
    //   214: invokevirtual 250	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   217: pop
    //   218: return
    //   219: astore_1
    //   220: aload_1
    //   221: athrow
    //   222: astore_1
    //   223: ldc 154
    //   225: ldc_w 361
    //   228: aload_1
    //   229: invokestatic 364	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   232: pop
    //   233: aload_0
    //   234: bipush 8
    //   236: aconst_null
    //   237: aconst_null
    //   238: aload_0
    //   239: getfield 82	com/google/android/gms/common/internal/l:JH	Ljava/util/concurrent/atomic/AtomicInteger;
    //   242: invokevirtual 192	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   245: invokevirtual 369	com/google/android/gms/common/internal/l:a	(ILandroid/os/IBinder;Landroid/os/Bundle;I)V
    //   248: return
    //   249: astore_1
    //   250: goto -27 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	l
    //   0	253	2	paramSet	Set<Scope>
    //   17	124	3	localzzj	zzj
    //   4	27	4	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   114	146	178	finally
    //   146	148	178	finally
    //   166	175	178	finally
    //   179	181	178	finally
    //   107	114	183	android/os/DeadObjectException
    //   181	183	183	android/os/DeadObjectException
    //   107	114	219	java/lang/SecurityException
    //   181	183	219	java/lang/SecurityException
    //   107	114	222	android/os/RemoteException
    //   181	183	222	android/os/RemoteException
    //   107	114	249	java/lang/RuntimeException
    //   181	183	249	java/lang/RuntimeException
  }
  
  public void a(r paramr)
  {
    this.Jy = ((r)d.e(paramr, "Connection progress callbacks cannot be null."));
    a(2, null);
  }
  
  public final void a(r paramr, int paramInt, PendingIntent paramPendingIntent)
  {
    this.Jy = ((r)d.e(paramr, "Connection progress callbacks cannot be null."));
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.JH.get(), paramInt, paramPendingIntent));
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    int i;
    Object localObject1;
    synchronized (this.Jv)
    {
      i = this.JC;
      localObject1 = this.Jz;
    }
    for (;;)
    {
      Object localObject3;
      synchronized (this.Jw)
      {
        localObject3 = this.Jx;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i)
        {
        default: 
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (localObject1 != null) {
            break label531;
          }
          paramPrintWriter.append("null");
          paramPrintWriter.append(" mServiceBroker=");
          if (localObject3 != null) {
            break label565;
          }
          paramPrintWriter.println("null");
          localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
          long l;
          if (this.Jq > 0L)
          {
            ??? = paramPrintWriter.append(paramString).append("lastConnectedTime=");
            l = this.Jq;
            localObject3 = String.valueOf(((SimpleDateFormat)localObject1).format(new Date(this.Jq)));
            ((PrintWriter)???).println(String.valueOf(localObject3).length() + 21 + l + " " + (String)localObject3);
          }
          if (this.Jp > 0L) {
            paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          }
          switch (this.Jo)
          {
          default: 
            paramPrintWriter.append(String.valueOf(this.Jo));
            ??? = paramPrintWriter.append(" lastSuspendedTime=");
            l = this.Jp;
            localObject3 = String.valueOf(((SimpleDateFormat)localObject1).format(new Date(this.Jp)));
            ((PrintWriter)???).println(String.valueOf(localObject3).length() + 21 + l + " " + (String)localObject3);
            if (this.Js > 0L)
            {
              paramPrintWriter.append(paramString).append("lastFailedStatus=").append(com.google.android.gms.common.api.o.bc(this.Jr));
              paramString = paramPrintWriter.append(" lastFailedTime=");
              l = this.Js;
              paramPrintWriter = String.valueOf(((SimpleDateFormat)localObject1).format(new Date(this.Js)));
              paramString.println(String.valueOf(paramPrintWriter).length() + 21 + l + " " + paramPrintWriter);
            }
            return;
            paramString = finally;
            throw paramString;
          }
          break;
        }
      }
      paramPrintWriter.print("CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
      continue;
      label531:
      paramPrintWriter.append(gw()).append("@").append(Integer.toHexString(System.identityHashCode(((IInterface)localObject1).asBinder())));
      continue;
      label565:
      paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(((at)localObject3).asBinder())));
      continue;
      paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
      continue;
      paramPrintWriter.append("CAUSE_NETWORK_LOST");
    }
  }
  
  protected final void bd(int paramInt)
  {
    this.Jo = paramInt;
    this.Jp = System.currentTimeMillis();
  }
  
  public final void disconnect()
  {
    this.JH.incrementAndGet();
    synchronized (this.JA)
    {
      int j = this.JA.size();
      int i = 0;
      while (i < j)
      {
        ((q)this.JA.get(i)).hl();
        i += 1;
      }
      this.JA.clear();
    }
    synchronized (this.Jw)
    {
      this.Jx = null;
      a(1, null);
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  protected abstract T e(IBinder paramIBinder);
  
  public Account fX()
  {
    return null;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public boolean gs()
  {
    return false;
  }
  
  public boolean gt()
  {
    return true;
  }
  
  public final Intent gu()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  protected abstract String gv();
  
  protected abstract String gw();
  
  protected String hd()
  {
    return "com.google.android.gms";
  }
  
  public zzc[] hf()
  {
    return new zzc[0];
  }
  
  protected Bundle hg()
  {
    return new Bundle();
  }
  
  public final T hh()
  {
    synchronized (this.Jv)
    {
      if (this.JC == 4) {
        throw new DeadObjectException();
      }
    }
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
    if (this.Jz != null) {}
    for (boolean bool = true;; bool = false)
    {
      d.a(bool, "Client is connected but service is null");
      IInterface localIInterface = this.Jz;
      return localIInterface;
    }
  }
  
  protected Set<Scope> hi()
  {
    return Collections.EMPTY_SET;
  }
  
  public final boolean isConnected()
  {
    for (;;)
    {
      synchronized (this.Jv)
      {
        if (this.JC == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final boolean isConnecting()
  {
    for (;;)
    {
      synchronized (this.Jv)
      {
        if (this.JC == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.l
 * JD-Core Version:    0.7.0.1
 */