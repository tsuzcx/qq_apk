package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.x;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public final class ai
  extends com.google.android.gms.common.api.p
  implements aw
{
  private final int Jr;
  private final Looper Jt;
  private final b Ju;
  final f<? extends cr, cs> Jv;
  private boolean Jy;
  final x LU;
  private final Lock OI;
  final Map<a<?>, Boolean> OP;
  final Queue<g<?, ?>> OU = new LinkedList();
  private final ad PF;
  private av PG = null;
  private volatile boolean PH;
  private long PI = 120000L;
  private long PJ = 5000L;
  private final aj PK;
  zzaaz PL;
  final Map<h<?>, j> PM;
  Set<Scope> PN = new HashSet();
  private final bf PO = new bf();
  private final ArrayList<n> PP;
  private Integer PQ = null;
  Set<bp> PR = null;
  final br PS;
  private final ae PT = new ae()
  {
    public final boolean isConnected()
    {
      return ai.this.isConnected();
    }
  };
  private final Context mContext;
  
  public ai(Context paramContext, Lock paramLock, Looper paramLooper, x paramx, b paramb, f<? extends cr, cs> paramf, Map<a<?>, Boolean> paramMap, List<r> paramList, List<s> paramList1, Map<h<?>, j> paramMap1, int paramInt1, int paramInt2, ArrayList<n> paramArrayList)
  {
    this.mContext = paramContext;
    this.OI = paramLock;
    this.Jy = false;
    this.PF = new ad(paramLooper, this.PT);
    this.Jt = paramLooper;
    this.PK = new aj(this, paramLooper);
    this.Ju = paramb;
    this.Jr = paramInt1;
    if (this.Jr >= 0) {
      this.PQ = Integer.valueOf(paramInt2);
    }
    this.OP = paramMap;
    this.PM = paramMap1;
    this.PP = paramArrayList;
    this.PS = new br(this.PM);
    paramContext = paramList.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (r)paramContext.next();
      this.PF.a(paramLock);
    }
    paramContext = paramList1.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (s)paramContext.next();
      this.PF.a(paramLock);
    }
    this.LU = paramx;
    this.Jv = paramf;
  }
  
  public static int a(Iterable<j> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    int i = 0;
    if (paramIterable.hasNext())
    {
      if (!((j)paramIterable.next()).gC()) {
        break label48;
      }
      i = 1;
    }
    label48:
    for (;;)
    {
      break;
      if (i != 0) {
        return 1;
      }
      return 3;
    }
  }
  
  private void bG(int paramInt)
  {
    if (this.PQ == null) {
      this.PQ = Integer.valueOf(paramInt);
    }
    while (this.PG != null)
    {
      return;
      if (this.PQ.intValue() != paramInt)
      {
        localObject = String.valueOf(bH(paramInt));
        String str = String.valueOf(bH(this.PQ.intValue()));
        throw new IllegalStateException(String.valueOf(localObject).length() + 51 + String.valueOf(str).length() + "Cannot use sign-in mode: " + (String)localObject + ". Mode was already set to " + str);
      }
    }
    Object localObject = this.PM.values().iterator();
    paramInt = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (!((j)((Iterator)localObject).next()).gC()) {
        break label420;
      }
      paramInt = 1;
    }
    label420:
    for (;;)
    {
      break;
      switch (this.PQ.intValue())
      {
      }
      while (this.Jy)
      {
        this.PG = new t(this.mContext, this.OI, this.Jt, this.Ju, this.PM, this.LU, this.OP, this.Jv, this.PP, this, false);
        return;
        if (paramInt == 0)
        {
          throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
          if (paramInt != 0)
          {
            if (this.Jy)
            {
              this.PG = new t(this.mContext, this.OI, this.Jt, this.Ju, this.PM, this.LU, this.OP, this.Jv, this.PP, this, true);
              return;
            }
            this.PG = p.a(this.mContext, this, this.OI, this.Jt, this.Ju, this.PM, this.LU, this.OP, this.Jv, this.PP);
            return;
          }
        }
      }
      this.PG = new am(this.mContext, this, this.OI, this.Jt, this.Ju, this.PM, this.LU, this.OP, this.Jv, this.PP, this);
      return;
    }
  }
  
  private static String bH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 3: 
      return "SIGN_IN_MODE_NONE";
    case 1: 
      return "SIGN_IN_MODE_REQUIRED";
    }
    return "SIGN_IN_MODE_OPTIONAL";
  }
  
  private void iI()
  {
    this.PF.hG();
    this.PG.connect();
  }
  
  public final <L> bb<L> B(L paramL)
  {
    this.OI.lock();
    try
    {
      paramL = this.PO.a(paramL, this.Jt, "NO_TYPE");
      return paramL;
    }
    finally
    {
      this.OI.unlock();
    }
  }
  
  public final ConnectionResult a(TimeUnit paramTimeUnit)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    }
    for (;;)
    {
      d.a(bool, "blockingConnect must not be called on the UI thread");
      d.g(paramTimeUnit, "TimeUnit must not be null");
      this.OI.lock();
      try
      {
        if (this.PQ == null) {
          this.PQ = Integer.valueOf(a(this.PM.values()));
        }
        while (this.PQ.intValue() != 2)
        {
          bG(this.PQ.intValue());
          this.PF.hG();
          paramTimeUnit = this.PG.b(30L, paramTimeUnit);
          return paramTimeUnit;
          bool = false;
          break;
        }
        throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
      }
      finally
      {
        this.OI.unlock();
      }
    }
  }
  
  public final <A extends com.google.android.gms.common.api.g, R extends w, T extends g<R, A>> T a(T paramT)
  {
    boolean bool;
    if (paramT.gB() != null) {
      bool = true;
    }
    for (;;)
    {
      d.b(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
      bool = this.PM.containsKey(paramT.gB());
      String str;
      if (paramT.gS() != null)
      {
        str = paramT.gS().getName();
        label45:
        d.b(bool, String.valueOf(str).length() + 65 + "GoogleApiClient is not configured to use " + str + " required for this call.");
        this.OI.lock();
      }
      try
      {
        if (this.PG == null)
        {
          this.OU.add(paramT);
          return paramT;
          bool = false;
          continue;
          str = "the API";
          break label45;
        }
        paramT = this.PG.a(paramT);
        return paramT;
      }
      finally
      {
        this.OI.unlock();
      }
    }
  }
  
  public final void a(s params)
  {
    this.PF.a(params);
  }
  
  public final void a(bp parambp)
  {
    this.OI.lock();
    try
    {
      if (this.PR == null) {
        this.PR = new HashSet();
      }
      this.PR.add(parambp);
      return;
    }
    finally
    {
      this.OI.unlock();
    }
  }
  
  public final <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT)
  {
    boolean bool;
    if (paramT.gB() != null)
    {
      bool = true;
      d.b(bool, "This task can not be executed (it's probably a Batch or malformed)");
      bool = this.PM.containsKey(paramT.gB());
      if (paramT.gS() == null) {
        break label129;
      }
    }
    label129:
    for (Object localObject = paramT.gS().getName();; localObject = "the API")
    {
      d.b(bool, String.valueOf(localObject).length() + 65 + "GoogleApiClient is not configured to use " + (String)localObject + " required for this call.");
      this.OI.lock();
      try
      {
        if (this.PG != null) {
          break label136;
        }
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
      }
      finally
      {
        this.OI.unlock();
      }
      bool = false;
      break;
    }
    label136:
    if (this.PH)
    {
      this.OU.add(paramT);
      while (!this.OU.isEmpty())
      {
        localObject = (g)this.OU.remove();
        this.PS.b((k)localObject);
        ((g)localObject).a(Status.JC);
      }
      this.OI.unlock();
      return paramT;
    }
    paramT = this.PG.b(paramT);
    this.OI.unlock();
    return paramT;
  }
  
  public final void b(s params)
  {
    this.PF.b(params);
  }
  
  public final void b(bp parambp)
  {
    this.OI.lock();
    for (;;)
    {
      try
      {
        if (this.PR == null)
        {
          Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
          return;
        }
        if (!this.PR.remove(parambp))
        {
          Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
          continue;
        }
        if (iK()) {
          continue;
        }
      }
      finally
      {
        this.OI.unlock();
      }
      this.PG.is();
    }
  }
  
  public final void connect()
  {
    boolean bool2 = false;
    this.OI.lock();
    do
    {
      for (;;)
      {
        try
        {
          if (this.Jr >= 0) {
            if (this.PQ != null)
            {
              bool1 = true;
              d.a(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
              i = this.PQ.intValue();
              this.OI.lock();
              if ((i != 3) && (i != 1))
              {
                bool1 = bool2;
                if (i != 2) {}
              }
              else
              {
                bool1 = true;
              }
            }
          }
        }
        finally
        {
          boolean bool1;
          int i;
          this.OI.unlock();
        }
        try
        {
          d.b(bool1, 33 + "Illegal sign-in mode: " + i);
          bG(i);
          iI();
          this.OI.unlock();
          this.OI.unlock();
          return;
        }
        finally
        {
          this.OI.unlock();
        }
        bool1 = false;
        continue;
        if (this.PQ != null) {
          break;
        }
        this.PQ = Integer.valueOf(a(this.PM.values()));
      }
    } while (this.PQ.intValue() != 2);
    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
  }
  
  public final void disconnect()
  {
    this.OI.lock();
    try
    {
      this.PS.release();
      if (this.PG != null) {
        this.PG.disconnect();
      }
      this.PO.release();
      Iterator localIterator = this.OU.iterator();
      while (localIterator.hasNext())
      {
        g localg = (g)localIterator.next();
        localg.a(null);
        localg.cancel();
      }
      this.OU.clear();
    }
    finally
    {
      this.OI.unlock();
    }
    av localav = this.PG;
    if (localav == null)
    {
      this.OI.unlock();
      return;
    }
    iJ();
    this.PF.hF();
    this.OI.unlock();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mContext=").println(this.mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(this.PH);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.OU.size());
    this.PS.dump(paramPrintWriter);
    if (this.PG != null) {
      this.PG.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final void f(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1) && (!paramBoolean) && (!this.PH))
    {
      this.PH = true;
      if (this.PL == null) {
        this.PL = b.a(this.mContext.getApplicationContext(), new ak(this));
      }
      this.PK.sendMessageDelayed(this.PK.obtainMessage(1), this.PI);
      this.PK.sendMessageDelayed(this.PK.obtainMessage(2), this.PJ);
    }
    this.PS.jq();
    this.PF.bA(paramInt);
    this.PF.hF();
    if (paramInt == 2) {
      iI();
    }
  }
  
  public final void g(ConnectionResult paramConnectionResult)
  {
    if (!this.Ju.b(this.mContext, paramConnectionResult.getErrorCode())) {
      iJ();
    }
    if (!this.PH)
    {
      this.PF.d(paramConnectionResult);
      this.PF.hF();
    }
  }
  
  public final Looper getLooper()
  {
    return this.Jt;
  }
  
  final boolean iJ()
  {
    if (!this.PH) {
      return false;
    }
    this.PH = false;
    this.PK.removeMessages(2);
    this.PK.removeMessages(1);
    if (this.PL != null)
    {
      this.PL.unregister();
      this.PL = null;
    }
    return true;
  }
  
  final boolean iK()
  {
    boolean bool1 = false;
    this.OI.lock();
    try
    {
      Set localSet = this.PR;
      if (localSet == null) {
        return false;
      }
      boolean bool2 = this.PR.isEmpty();
      if (!bool2) {
        bool1 = true;
      }
      return bool1;
    }
    finally
    {
      this.OI.unlock();
    }
  }
  
  final String iL()
  {
    StringWriter localStringWriter = new StringWriter();
    dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }
  
  public final boolean isConnected()
  {
    return (this.PG != null) && (this.PG.isConnected());
  }
  
  public final void j(Bundle paramBundle)
  {
    while (!this.OU.isEmpty()) {
      b((g)this.OU.remove());
    }
    this.PF.i(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ai
 * JD-Core Version:    0.7.0.1
 */