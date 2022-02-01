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
  public static final String[] Lx = { "service_esmobile", "service_googleme" };
  private final Looper Jt;
  private int Ld;
  private long Le;
  private long Lf;
  private int Lg;
  private long Lh;
  private final af Li;
  private final h Lj;
  private final Object Lk = new Object();
  private final Object Ll = new Object();
  private at Lm;
  protected r Ln;
  private T Lo;
  private final ArrayList<q<?>> Lp = new ArrayList();
  private t Lq;
  private int Lr = 1;
  private final n Ls;
  private final o Lt;
  private final int Lu;
  private final String Lv;
  protected AtomicInteger Lw = new AtomicInteger(0);
  final Handler dG;
  private final Context mContext;
  
  protected l(Context paramContext, Looper paramLooper, af paramaf, h paramh, int paramInt, n paramn, o paramo, String paramString)
  {
    this.mContext = ((Context)d.g(paramContext, "Context must not be null"));
    this.Jt = ((Looper)d.g(paramLooper, "Looper must not be null"));
    this.Li = ((af)d.g(paramaf, "Supervisor must not be null"));
    this.Lj = ((h)d.g(paramh, "API availability must not be null"));
    this.dG = new p(this, paramLooper);
    this.Lu = paramInt;
    this.Ls = paramn;
    this.Lt = paramo;
    this.Lv = paramString;
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
      d.z(bool);
      for (;;)
      {
        synchronized (this.Lk)
        {
          this.Lr = paramInt;
          this.Lo = paramT;
          switch (paramInt)
          {
          case 2: 
            return;
            if (this.Lq != null)
            {
              paramT = String.valueOf(gF());
              str = String.valueOf(hn());
              Log.e("GmsClient", String.valueOf(paramT).length() + 70 + String.valueOf(str).length() + "Calling connect() while still connected, missing disconnect() for " + paramT + " on " + str);
              this.Li.b(gF(), hn(), this.Lq, ho());
              this.Lw.incrementAndGet();
            }
            this.Lq = new t(this, this.Lw.get());
            if (this.Li.a(gF(), hn(), this.Lq, ho())) {
              continue;
            }
            paramT = String.valueOf(gF());
            String str = String.valueOf(hn());
            Log.e("GmsClient", String.valueOf(paramT).length() + 34 + String.valueOf(str).length() + "unable to connect to service: " + paramT + " on " + str);
            aa(16, this.Lw.get());
          }
        }
        this.Lf = System.currentTimeMillis();
        continue;
        if (this.Lq != null)
        {
          this.Li.b(gF(), hn(), this.Lq, ho());
          this.Lq = null;
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
    synchronized (this.Lk)
    {
      if (this.Lr != paramInt1) {
        return false;
      }
      a(paramInt2, paramT);
      return true;
    }
  }
  
  private String ho()
  {
    if (this.Lv == null) {
      return this.mContext.getClass().getName();
    }
    return this.Lv;
  }
  
  protected void a(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    this.dG.sendMessage(this.dG.obtainMessage(1, paramInt2, -1, new v(this, paramInt1, paramIBinder, paramBundle)));
  }
  
  protected final void a(ConnectionResult paramConnectionResult)
  {
    this.Lg = paramConnectionResult.getErrorCode();
    this.Lh = System.currentTimeMillis();
  }
  
  /* Error */
  public final void a(ak arg1, Set<Scope> paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 275	com/google/android/gms/common/internal/l:hq	()Landroid/os/Bundle;
    //   4: astore 4
    //   6: new 277	com/google/android/gms/common/internal/zzj
    //   9: dup
    //   10: aload_0
    //   11: getfield 121	com/google/android/gms/common/internal/l:Lu	I
    //   14: invokespecial 278	com/google/android/gms/common/internal/zzj:<init>	(I)V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: getfield 94	com/google/android/gms/common/internal/l:mContext	Landroid/content/Context;
    //   23: invokevirtual 281	android/content/Context:getPackageName	()Ljava/lang/String;
    //   26: putfield 284	com/google/android/gms/common/internal/zzj:LO	Ljava/lang/String;
    //   29: aload_3
    //   30: aload 4
    //   32: putfield 288	com/google/android/gms/common/internal/zzj:LR	Landroid/os/Bundle;
    //   35: aload_2
    //   36: ifnull +25 -> 61
    //   39: aload_3
    //   40: aload_2
    //   41: aload_2
    //   42: invokeinterface 293 1 0
    //   47: anewarray 295	com/google/android/gms/common/api/Scope
    //   50: invokeinterface 299 2 0
    //   55: checkcast 301	[Lcom/google/android/gms/common/api/Scope;
    //   58: putfield 304	com/google/android/gms/common/internal/zzj:LQ	[Lcom/google/android/gms/common/api/Scope;
    //   61: aload_0
    //   62: invokevirtual 308	com/google/android/gms/common/internal/l:gC	()Z
    //   65: ifeq +34 -> 99
    //   68: aload_0
    //   69: invokevirtual 312	com/google/android/gms/common/internal/l:gi	()Landroid/accounts/Account;
    //   72: ifnull +77 -> 149
    //   75: aload_0
    //   76: invokevirtual 312	com/google/android/gms/common/internal/l:gi	()Landroid/accounts/Account;
    //   79: astore_2
    //   80: aload_3
    //   81: aload_2
    //   82: putfield 316	com/google/android/gms/common/internal/zzj:LS	Landroid/accounts/Account;
    //   85: aload_1
    //   86: ifnull +13 -> 99
    //   89: aload_3
    //   90: aload_1
    //   91: invokeinterface 322 1 0
    //   96: putfield 326	com/google/android/gms/common/internal/zzj:LP	Landroid/os/IBinder;
    //   99: aload_3
    //   100: aload_0
    //   101: invokevirtual 330	com/google/android/gms/common/internal/l:hp	()[Lcom/google/android/gms/common/zzc;
    //   104: putfield 334	com/google/android/gms/common/internal/zzj:LT	[Lcom/google/android/gms/common/zzc;
    //   107: aload_0
    //   108: getfield 68	com/google/android/gms/common/internal/l:Ll	Ljava/lang/Object;
    //   111: astore_1
    //   112: aload_1
    //   113: monitorenter
    //   114: aload_0
    //   115: getfield 131	com/google/android/gms/common/internal/l:Lm	Lcom/google/android/gms/common/internal/at;
    //   118: ifnull +48 -> 166
    //   121: aload_0
    //   122: getfield 131	com/google/android/gms/common/internal/l:Lm	Lcom/google/android/gms/common/internal/at;
    //   125: new 336	com/google/android/gms/common/internal/s
    //   128: dup
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 82	com/google/android/gms/common/internal/l:Lw	Ljava/util/concurrent/atomic/AtomicInteger;
    //   134: invokevirtual 193	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   137: invokespecial 337	com/google/android/gms/common/internal/s:<init>	(Lcom/google/android/gms/common/internal/l;I)V
    //   140: aload_3
    //   141: invokeinterface 342 3 0
    //   146: aload_1
    //   147: monitorexit
    //   148: return
    //   149: new 344	android/accounts/Account
    //   152: dup
    //   153: ldc_w 346
    //   156: ldc_w 348
    //   159: invokespecial 351	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: astore_2
    //   163: goto -83 -> 80
    //   166: ldc 154
    //   168: ldc_w 353
    //   171: invokestatic 356	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   174: pop
    //   175: goto -29 -> 146
    //   178: astore_2
    //   179: aload_1
    //   180: monitorexit
    //   181: aload_2
    //   182: athrow
    //   183: astore_1
    //   184: ldc 154
    //   186: ldc_w 358
    //   189: aload_1
    //   190: invokestatic 361	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   193: pop
    //   194: aload_0
    //   195: getfield 119	com/google/android/gms/common/internal/l:dG	Landroid/os/Handler;
    //   198: aload_0
    //   199: getfield 119	com/google/android/gms/common/internal/l:dG	Landroid/os/Handler;
    //   202: iconst_4
    //   203: aload_0
    //   204: getfield 82	com/google/android/gms/common/internal/l:Lw	Ljava/util/concurrent/atomic/AtomicInteger;
    //   207: invokevirtual 193	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   210: iconst_1
    //   211: invokevirtual 364	android/os/Handler:obtainMessage	(III)Landroid/os/Message;
    //   214: invokevirtual 252	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   217: pop
    //   218: return
    //   219: astore_1
    //   220: aload_1
    //   221: athrow
    //   222: astore_1
    //   223: ldc 154
    //   225: ldc_w 358
    //   228: aload_1
    //   229: invokestatic 361	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   232: pop
    //   233: aload_0
    //   234: bipush 8
    //   236: aconst_null
    //   237: aconst_null
    //   238: aload_0
    //   239: getfield 82	com/google/android/gms/common/internal/l:Lw	Ljava/util/concurrent/atomic/AtomicInteger;
    //   242: invokevirtual 193	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   245: invokevirtual 366	com/google/android/gms/common/internal/l:a	(ILandroid/os/IBinder;Landroid/os/Bundle;I)V
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
    this.Ln = ((r)d.g(paramr, "Connection progress callbacks cannot be null."));
    a(2, null);
  }
  
  public final void a(r paramr, int paramInt, PendingIntent paramPendingIntent)
  {
    this.Ln = ((r)d.g(paramr, "Connection progress callbacks cannot be null."));
    this.dG.sendMessage(this.dG.obtainMessage(3, this.Lw.get(), paramInt, paramPendingIntent));
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    int i;
    Object localObject1;
    synchronized (this.Lk)
    {
      i = this.Lr;
      localObject1 = this.Lo;
    }
    for (;;)
    {
      Object localObject3;
      synchronized (this.Ll)
      {
        localObject3 = this.Lm;
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
          if (this.Lf > 0L)
          {
            ??? = paramPrintWriter.append(paramString).append("lastConnectedTime=");
            l = this.Lf;
            localObject3 = String.valueOf(((SimpleDateFormat)localObject1).format(new Date(this.Lf)));
            ((PrintWriter)???).println(String.valueOf(localObject3).length() + 21 + l + " " + (String)localObject3);
          }
          if (this.Le > 0L) {
            paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          }
          switch (this.Ld)
          {
          default: 
            paramPrintWriter.append(String.valueOf(this.Ld));
            ??? = paramPrintWriter.append(" lastSuspendedTime=");
            l = this.Le;
            localObject3 = String.valueOf(((SimpleDateFormat)localObject1).format(new Date(this.Le)));
            ((PrintWriter)???).println(String.valueOf(localObject3).length() + 21 + l + " " + (String)localObject3);
            if (this.Lh > 0L)
            {
              paramPrintWriter.append(paramString).append("lastFailedStatus=").append(com.google.android.gms.common.api.o.bw(this.Lg));
              paramString = paramPrintWriter.append(" lastFailedTime=");
              l = this.Lh;
              paramPrintWriter = String.valueOf(((SimpleDateFormat)localObject1).format(new Date(this.Lh)));
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
      paramPrintWriter.append(gG()).append("@").append(Integer.toHexString(System.identityHashCode(((IInterface)localObject1).asBinder())));
      continue;
      label565:
      paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(((at)localObject3).asBinder())));
      continue;
      paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
      continue;
      paramPrintWriter.append("CAUSE_NETWORK_LOST");
    }
  }
  
  protected final void aa(int paramInt1, int paramInt2)
  {
    this.dG.sendMessage(this.dG.obtainMessage(5, paramInt2, -1, new w(this, paramInt1, null)));
  }
  
  protected final void bx(int paramInt)
  {
    this.Ld = paramInt;
    this.Le = System.currentTimeMillis();
  }
  
  public final void disconnect()
  {
    this.Lw.incrementAndGet();
    synchronized (this.Lp)
    {
      int j = this.Lp.size();
      int i = 0;
      while (i < j)
      {
        ((q)this.Lp.get(i)).hv();
        i += 1;
      }
      this.Lp.clear();
    }
    synchronized (this.Ll)
    {
      this.Lm = null;
      a(1, null);
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  protected abstract T e(IBinder paramIBinder);
  
  public boolean gC()
  {
    return false;
  }
  
  public boolean gD()
  {
    return true;
  }
  
  public final Intent gE()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  protected abstract String gF();
  
  protected abstract String gG();
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public Account gi()
  {
    return null;
  }
  
  protected String hn()
  {
    return "com.google.android.gms";
  }
  
  public zzc[] hp()
  {
    return new zzc[0];
  }
  
  protected Bundle hq()
  {
    return new Bundle();
  }
  
  public final T hr()
  {
    synchronized (this.Lk)
    {
      if (this.Lr == 4) {
        throw new DeadObjectException();
      }
    }
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
    if (this.Lo != null) {}
    for (boolean bool = true;; bool = false)
    {
      d.a(bool, "Client is connected but service is null");
      IInterface localIInterface = this.Lo;
      return localIInterface;
    }
  }
  
  protected Set<Scope> hs()
  {
    return Collections.EMPTY_SET;
  }
  
  public final boolean isConnected()
  {
    for (;;)
    {
      synchronized (this.Lk)
      {
        if (this.Lr == 3)
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
      synchronized (this.Lk)
      {
        if (this.Lr == 2)
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