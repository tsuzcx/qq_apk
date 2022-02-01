package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.internal.ak;
import com.google.android.gms.common.internal.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class aa
  implements al
{
  private final f<? extends cr, cs> Jv;
  private boolean KU;
  private final x LU;
  private final com.google.android.gms.common.h Lj;
  private final Lock OI;
  private final Map<a<?>, Boolean> OP;
  private ConnectionResult OZ;
  private final am Ph;
  private int Pk;
  private int Pl = 0;
  private int Pm;
  private final Bundle Pn = new Bundle();
  private final Set<com.google.android.gms.common.api.h> Po = new HashSet();
  private cr Pp;
  private boolean Pq;
  private boolean Pr;
  private boolean Ps;
  private ak Pt;
  private boolean Pu;
  private ArrayList<Future<?>> Pv = new ArrayList();
  private final Context mContext;
  
  public aa(am paramam, x paramx, Map<a<?>, Boolean> paramMap, com.google.android.gms.common.h paramh, f<? extends cr, cs> paramf, Lock paramLock, Context paramContext)
  {
    this.Ph = paramam;
    this.LU = paramx;
    this.OP = paramMap;
    this.Lj = paramh;
    this.Jv = paramf;
    this.OI = paramLock;
    this.mContext = paramContext;
  }
  
  private void B(boolean paramBoolean)
  {
    if (this.Pp != null)
    {
      if ((this.Pp.isConnected()) && (paramBoolean)) {
        this.Pp.jN();
      }
      this.Pp.disconnect();
      this.Pt = null;
    }
  }
  
  private boolean a(int paramInt, boolean paramBoolean, ConnectionResult paramConnectionResult)
  {
    if ((paramBoolean) && (!h(paramConnectionResult))) {}
    while ((this.OZ != null) && (2147483647 >= this.Pk)) {
      return false;
    }
    return true;
  }
  
  private void b(ConnectionResult paramConnectionResult, a<?> parama, boolean paramBoolean)
  {
    if (a(2147483647, paramBoolean, paramConnectionResult))
    {
      this.OZ = paramConnectionResult;
      this.Pk = 2147483647;
    }
    this.Ph.PY.put(parama.gB(), paramConnectionResult);
  }
  
  private boolean bE(int paramInt)
  {
    if (this.Pl != paramInt)
    {
      Log.w("GoogleApiClientConnecting", this.Ph.Oy.iL());
      String str1 = String.valueOf(this);
      Log.w("GoogleApiClientConnecting", String.valueOf(str1).length() + 23 + "Unexpected callback in " + str1);
      int i = this.Pm;
      Log.w("GoogleApiClientConnecting", 33 + "mRemainingConnections=" + i);
      str1 = String.valueOf(bF(this.Pl));
      String str2 = String.valueOf(bF(paramInt));
      Log.wtf("GoogleApiClientConnecting", String.valueOf(str1).length() + 70 + String.valueOf(str2).length() + "GoogleApiClient connecting is in step " + str1 + " but received callback for step " + str2, new Exception());
      j(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }
  
  private static String bF(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }
    return "STEP_GETTING_REMOTE_SERVICE";
  }
  
  private boolean h(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.gv()) {}
    while (this.Lj.bu(paramConnectionResult.getErrorCode()) != null) {
      return true;
    }
    return false;
  }
  
  private boolean i(ConnectionResult paramConnectionResult)
  {
    return (this.Pq) && (!paramConnectionResult.gv());
  }
  
  private boolean iD()
  {
    this.Pm -= 1;
    if (this.Pm > 0) {
      return false;
    }
    if (this.Pm < 0)
    {
      Log.w("GoogleApiClientConnecting", this.Ph.Oy.iL());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      j(new ConnectionResult(8, null));
      return false;
    }
    if (this.OZ != null)
    {
      this.Ph.Qb = this.Pk;
      j(this.OZ);
      return false;
    }
    return true;
  }
  
  private void iE()
  {
    if (this.Pm != 0) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while ((this.Pr) && (!this.Ps));
      localArrayList = new ArrayList();
      this.Pl = 1;
      this.Pm = this.Ph.PM.size();
      Iterator localIterator = this.Ph.PM.keySet().iterator();
      while (localIterator.hasNext())
      {
        com.google.android.gms.common.api.h localh = (com.google.android.gms.common.api.h)localIterator.next();
        if (this.Ph.PY.containsKey(localh))
        {
          if (iD()) {
            iF();
          }
        }
        else {
          localArrayList.add((j)this.Ph.PM.get(localh));
        }
      }
    } while (localArrayList.isEmpty());
    this.Pv.add(ap.iO().submit(new ad(this, localArrayList)));
  }
  
  private void iF()
  {
    this.Ph.iN();
    ap.iO().execute(new Runnable()
    {
      public final void run()
      {
        com.google.android.gms.common.h.m(aa.a(aa.this));
      }
    });
    if (this.Pp != null)
    {
      if (this.KU) {
        this.Pp.a(this.Pt, this.Pu);
      }
      B(false);
    }
    Object localObject = this.Ph.PY.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.google.android.gms.common.api.h localh = (com.google.android.gms.common.api.h)((Iterator)localObject).next();
      ((j)this.Ph.PM.get(localh)).disconnect();
    }
    if (this.Pn.isEmpty()) {}
    for (localObject = null;; localObject = this.Pn)
    {
      this.Ph.Qc.j((Bundle)localObject);
      return;
    }
  }
  
  private void iG()
  {
    this.Pr = false;
    this.Ph.Oy.PN = Collections.emptySet();
    Iterator localIterator = this.Po.iterator();
    while (localIterator.hasNext())
    {
      com.google.android.gms.common.api.h localh = (com.google.android.gms.common.api.h)localIterator.next();
      if (!this.Ph.PY.containsKey(localh)) {
        this.Ph.PY.put(localh, new ConnectionResult(17, null));
      }
    }
  }
  
  private void iH()
  {
    Iterator localIterator = this.Pv.iterator();
    while (localIterator.hasNext()) {
      ((Future)localIterator.next()).cancel(true);
    }
    this.Pv.clear();
  }
  
  private void j(ConnectionResult paramConnectionResult)
  {
    iH();
    if (!paramConnectionResult.gv()) {}
    for (boolean bool = true;; bool = false)
    {
      B(bool);
      this.Ph.k(paramConnectionResult);
      this.Ph.Qc.g(paramConnectionResult);
      return;
    }
  }
  
  public final <A extends com.google.android.gms.common.api.g, R extends w, T extends g<R, A>> T a(T paramT)
  {
    this.Ph.Oy.OU.add(paramT);
    return paramT;
  }
  
  public final void a(ConnectionResult paramConnectionResult, a<?> parama, boolean paramBoolean)
  {
    if (!bE(1)) {}
    do
    {
      return;
      b(paramConnectionResult, parama, paramBoolean);
    } while (!iD());
    iF();
  }
  
  public final <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final void begin()
  {
    this.Ph.PY.clear();
    this.Pr = false;
    this.OZ = null;
    this.Pl = 0;
    this.Pq = true;
    this.Ps = false;
    this.KU = false;
    HashMap localHashMap = new HashMap();
    Object localObject = this.OP.keySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      j localj = (j)this.Ph.PM.get(locala.gB());
      boolean bool = ((Boolean)this.OP.get(locala)).booleanValue();
      if (localj.gC())
      {
        this.Pr = true;
        if (!bool) {
          break label182;
        }
        this.Po.add(locala.gB());
      }
      for (;;)
      {
        localHashMap.put(localj, new ab(this, locala, bool));
        break;
        label182:
        this.Pq = false;
      }
    }
    if (this.Pr)
    {
      this.LU.a(Integer.valueOf(System.identityHashCode(this.Ph.Oy)));
      localObject = new af(this, (byte)0);
      this.Pp = ((cr)this.Jv.a(this.mContext, this.Ph.Oy.getLooper(), this.LU, this.LU.hC(), (r)localObject, (s)localObject));
    }
    this.Pm = this.Ph.PM.size();
    this.Pv.add(ap.iO().submit(new ac(this, localHashMap)));
  }
  
  public final void bx(int paramInt)
  {
    j(new ConnectionResult(8, null));
  }
  
  public final void connect() {}
  
  public final boolean disconnect()
  {
    iH();
    B(true);
    this.Ph.k(null);
    return true;
  }
  
  public final void h(Bundle paramBundle)
  {
    if (!bE(1)) {}
    do
    {
      return;
      if (paramBundle != null) {
        this.Pn.putAll(paramBundle);
      }
    } while (!iD());
    iF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.aa
 * JD-Core Version:    0.7.0.1
 */