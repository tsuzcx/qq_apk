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
  private final int HC;
  private final Looper HE;
  private final b HF;
  final f<? extends cr, cs> HG;
  private boolean HJ;
  final x Kf;
  private final Lock MT;
  private final ad NQ;
  private av NR = null;
  private volatile boolean NS;
  private long NT = 120000L;
  private long NU = 5000L;
  private final aj NV;
  zzaaz NW;
  final Map<h<?>, j> NX;
  Set<Scope> NY = new HashSet();
  private final bf NZ = new bf();
  final Map<a<?>, Boolean> Na;
  final Queue<g<?, ?>> Nf = new LinkedList();
  private final ArrayList<n> Oa;
  private Integer Ob = null;
  Set<bp> Oc = null;
  final br Od;
  private final ae Oe = new ae()
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
    this.MT = paramLock;
    this.HJ = false;
    this.NQ = new ad(paramLooper, this.Oe);
    this.HE = paramLooper;
    this.NV = new aj(this, paramLooper);
    this.HF = paramb;
    this.HC = paramInt1;
    if (this.HC >= 0) {
      this.Ob = Integer.valueOf(paramInt2);
    }
    this.Na = paramMap;
    this.NX = paramMap1;
    this.Oa = paramArrayList;
    this.Od = new br(this.NX);
    paramContext = paramList.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (r)paramContext.next();
      this.NQ.a(paramLock);
    }
    paramContext = paramList1.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (s)paramContext.next();
      this.NQ.a(paramLock);
    }
    this.Kf = paramx;
    this.HG = paramf;
  }
  
  public static int a(Iterable<j> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    int i = 0;
    if (paramIterable.hasNext())
    {
      if (!((j)paramIterable.next()).gs()) {
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
  
  private void bm(int paramInt)
  {
    if (this.Ob == null) {
      this.Ob = Integer.valueOf(paramInt);
    }
    while (this.NR != null)
    {
      return;
      if (this.Ob.intValue() != paramInt)
      {
        localObject = String.valueOf(bn(paramInt));
        String str = String.valueOf(bn(this.Ob.intValue()));
        throw new IllegalStateException(String.valueOf(localObject).length() + 51 + String.valueOf(str).length() + "Cannot use sign-in mode: " + (String)localObject + ". Mode was already set to " + str);
      }
    }
    Object localObject = this.NX.values().iterator();
    paramInt = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (!((j)((Iterator)localObject).next()).gs()) {
        break label420;
      }
      paramInt = 1;
    }
    label420:
    for (;;)
    {
      break;
      switch (this.Ob.intValue())
      {
      }
      while (this.HJ)
      {
        this.NR = new t(this.mContext, this.MT, this.HE, this.HF, this.NX, this.Kf, this.Na, this.HG, this.Oa, this, false);
        return;
        if (paramInt == 0)
        {
          throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
          if (paramInt != 0)
          {
            if (this.HJ)
            {
              this.NR = new t(this.mContext, this.MT, this.HE, this.HF, this.NX, this.Kf, this.Na, this.HG, this.Oa, this, true);
              return;
            }
            this.NR = p.a(this.mContext, this, this.MT, this.HE, this.HF, this.NX, this.Kf, this.Na, this.HG, this.Oa);
            return;
          }
        }
      }
      this.NR = new am(this.mContext, this, this.MT, this.HE, this.HF, this.NX, this.Kf, this.Na, this.HG, this.Oa, this);
      return;
    }
  }
  
  private static String bn(int paramInt)
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
  
  private void iA()
  {
    this.NQ.hw();
    this.NR.connect();
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
      d.e(paramTimeUnit, "TimeUnit must not be null");
      this.MT.lock();
      try
      {
        if (this.Ob == null) {
          this.Ob = Integer.valueOf(a(this.NX.values()));
        }
        while (this.Ob.intValue() != 2)
        {
          bm(this.Ob.intValue());
          this.NQ.hw();
          paramTimeUnit = this.NR.b(30L, paramTimeUnit);
          return paramTimeUnit;
          bool = false;
          break;
        }
        throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
      }
      finally
      {
        this.MT.unlock();
      }
    }
  }
  
  public final <A extends com.google.android.gms.common.api.g, R extends w, T extends g<R, A>> T a(T paramT)
  {
    boolean bool;
    if (paramT.gr() != null) {
      bool = true;
    }
    for (;;)
    {
      d.b(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
      bool = this.NX.containsKey(paramT.gr());
      String str;
      if (paramT.gI() != null)
      {
        str = paramT.gI().getName();
        label45:
        d.b(bool, String.valueOf(str).length() + 65 + "GoogleApiClient is not configured to use " + str + " required for this call.");
        this.MT.lock();
      }
      try
      {
        if (this.NR == null)
        {
          this.Nf.add(paramT);
          return paramT;
          bool = false;
          continue;
          str = "the API";
          break label45;
        }
        paramT = this.NR.a(paramT);
        return paramT;
      }
      finally
      {
        this.MT.unlock();
      }
    }
  }
  
  public final void a(s params)
  {
    this.NQ.a(params);
  }
  
  public final void a(bp parambp)
  {
    this.MT.lock();
    try
    {
      if (this.Oc == null) {
        this.Oc = new HashSet();
      }
      this.Oc.add(parambp);
      return;
    }
    finally
    {
      this.MT.unlock();
    }
  }
  
  public final <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT)
  {
    boolean bool;
    if (paramT.gr() != null)
    {
      bool = true;
      d.b(bool, "This task can not be executed (it's probably a Batch or malformed)");
      bool = this.NX.containsKey(paramT.gr());
      if (paramT.gI() == null) {
        break label129;
      }
    }
    label129:
    for (Object localObject = paramT.gI().getName();; localObject = "the API")
    {
      d.b(bool, String.valueOf(localObject).length() + 65 + "GoogleApiClient is not configured to use " + (String)localObject + " required for this call.");
      this.MT.lock();
      try
      {
        if (this.NR != null) {
          break label136;
        }
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
      }
      finally
      {
        this.MT.unlock();
      }
      bool = false;
      break;
    }
    label136:
    if (this.NS)
    {
      this.Nf.add(paramT);
      while (!this.Nf.isEmpty())
      {
        localObject = (g)this.Nf.remove();
        this.Od.b((k)localObject);
        ((g)localObject).a(Status.HN);
      }
      this.MT.unlock();
      return paramT;
    }
    paramT = this.NR.b(paramT);
    this.MT.unlock();
    return paramT;
  }
  
  public final void b(s params)
  {
    this.NQ.b(params);
  }
  
  public final void b(bp parambp)
  {
    this.MT.lock();
    for (;;)
    {
      try
      {
        if (this.Oc == null)
        {
          Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
          return;
        }
        if (!this.Oc.remove(parambp))
        {
          Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
          continue;
        }
        if (iC()) {
          continue;
        }
      }
      finally
      {
        this.MT.unlock();
      }
      this.NR.ik();
    }
  }
  
  public final void connect()
  {
    boolean bool2 = false;
    this.MT.lock();
    do
    {
      for (;;)
      {
        try
        {
          if (this.HC >= 0) {
            if (this.Ob != null)
            {
              bool1 = true;
              d.a(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
              i = this.Ob.intValue();
              this.MT.lock();
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
          this.MT.unlock();
        }
        try
        {
          d.b(bool1, 33 + "Illegal sign-in mode: " + i);
          bm(i);
          iA();
          this.MT.unlock();
          this.MT.unlock();
          return;
        }
        finally
        {
          this.MT.unlock();
        }
        bool1 = false;
        continue;
        if (this.Ob != null) {
          break;
        }
        this.Ob = Integer.valueOf(a(this.NX.values()));
      }
    } while (this.Ob.intValue() != 2);
    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
  }
  
  public final void disconnect()
  {
    this.MT.lock();
    try
    {
      this.Od.release();
      if (this.NR != null) {
        this.NR.disconnect();
      }
      this.NZ.release();
      Iterator localIterator = this.Nf.iterator();
      while (localIterator.hasNext())
      {
        g localg = (g)localIterator.next();
        localg.a(null);
        localg.cancel();
      }
      this.Nf.clear();
    }
    finally
    {
      this.MT.unlock();
    }
    av localav = this.NR;
    if (localav == null)
    {
      this.MT.unlock();
      return;
    }
    iB();
    this.NQ.hv();
    this.MT.unlock();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mContext=").println(this.mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(this.NS);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.Nf.size());
    br localbr = this.Od;
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(localbr.Pz.size());
    if (this.NR != null) {
      this.NR.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final void e(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1) && (!paramBoolean) && (!this.NS))
    {
      this.NS = true;
      if (this.NW == null) {
        this.NW = b.a(this.mContext.getApplicationContext(), new ak(this));
      }
      this.NV.sendMessageDelayed(this.NV.obtainMessage(1), this.NT);
      this.NV.sendMessageDelayed(this.NV.obtainMessage(2), this.NU);
    }
    this.Od.jh();
    this.NQ.bg(paramInt);
    this.NQ.hv();
    if (paramInt == 2) {
      iA();
    }
  }
  
  public final void g(ConnectionResult paramConnectionResult)
  {
    if (!this.HF.b(this.mContext, paramConnectionResult.getErrorCode())) {
      iB();
    }
    if (!this.NS)
    {
      this.NQ.d(paramConnectionResult);
      this.NQ.hv();
    }
  }
  
  public final Looper getLooper()
  {
    return this.HE;
  }
  
  final boolean iB()
  {
    if (!this.NS) {
      return false;
    }
    this.NS = false;
    this.NV.removeMessages(2);
    this.NV.removeMessages(1);
    if (this.NW != null)
    {
      this.NW.unregister();
      this.NW = null;
    }
    return true;
  }
  
  final boolean iC()
  {
    boolean bool1 = false;
    this.MT.lock();
    try
    {
      Set localSet = this.Oc;
      if (localSet == null) {
        return false;
      }
      boolean bool2 = this.Oc.isEmpty();
      if (!bool2) {
        bool1 = true;
      }
      return bool1;
    }
    finally
    {
      this.MT.unlock();
    }
  }
  
  final String iD()
  {
    StringWriter localStringWriter = new StringWriter();
    dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }
  
  public final boolean isConnected()
  {
    return (this.NR != null) && (this.NR.isConnected());
  }
  
  public final void j(Bundle paramBundle)
  {
    while (!this.Nf.isEmpty()) {
      b((g)this.Nf.remove());
    }
    this.NQ.i(paramBundle);
  }
  
  public final <L> bb<L> s(L paramL)
  {
    this.MT.lock();
    try
    {
      paramL = this.NZ.a(paramL, this.HE, "NO_TYPE");
      return paramL;
    }
    finally
    {
      this.MT.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ai
 * JD-Core Version:    0.7.0.1
 */