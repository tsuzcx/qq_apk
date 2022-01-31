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
  private final f<? extends cr, cs> HG;
  private boolean Jf;
  private final com.google.android.gms.common.h Ju;
  private final x Kf;
  private final Lock MT;
  private cr NA;
  private boolean NB;
  private boolean NC;
  private boolean ND;
  private ak NE;
  private boolean NF;
  private ArrayList<Future<?>> NG = new ArrayList();
  private final Map<a<?>, Boolean> Na;
  private ConnectionResult Nk;
  private final am Ns;
  private int Nv;
  private int Nw = 0;
  private int Nx;
  private final Bundle Ny = new Bundle();
  private final Set<com.google.android.gms.common.api.h> Nz = new HashSet();
  private final Context mContext;
  
  public aa(am paramam, x paramx, Map<a<?>, Boolean> paramMap, com.google.android.gms.common.h paramh, f<? extends cr, cs> paramf, Lock paramLock, Context paramContext)
  {
    this.Ns = paramam;
    this.Kf = paramx;
    this.Na = paramMap;
    this.Ju = paramh;
    this.HG = paramf;
    this.MT = paramLock;
    this.mContext = paramContext;
  }
  
  private void b(ConnectionResult paramConnectionResult, a<?> parama, boolean paramBoolean)
  {
    int j = 1;
    if (paramBoolean)
    {
      if (paramConnectionResult.gl())
      {
        i = 1;
        if (i == 0) {
          break label107;
        }
      }
    }
    else
    {
      i = j;
      if (this.Nk != null) {
        if (2147483647 >= this.Nv) {
          break label107;
        }
      }
    }
    label107:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        this.Nk = paramConnectionResult;
        this.Nv = 2147483647;
      }
      this.Ns.Oj.put(parama.gr(), paramConnectionResult);
      return;
      if (this.Ju.ba(paramConnectionResult.getErrorCode()) != null)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
    }
  }
  
  private boolean bk(int paramInt)
  {
    if (this.Nw != paramInt)
    {
      Log.w("GoogleApiClientConnecting", this.Ns.MJ.iD());
      String str1 = String.valueOf(this);
      Log.w("GoogleApiClientConnecting", String.valueOf(str1).length() + 23 + "Unexpected callback in " + str1);
      int i = this.Nx;
      Log.w("GoogleApiClientConnecting", 33 + "mRemainingConnections=" + i);
      str1 = String.valueOf(bl(this.Nw));
      String str2 = String.valueOf(bl(paramInt));
      Log.wtf("GoogleApiClientConnecting", String.valueOf(str1).length() + 70 + String.valueOf(str2).length() + "GoogleApiClient connecting is in step " + str1 + " but received callback for step " + str2, new Exception());
      i(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }
  
  private static String bl(int paramInt)
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
    return (this.NB) && (!paramConnectionResult.gl());
  }
  
  private void i(ConnectionResult paramConnectionResult)
  {
    iz();
    if (!paramConnectionResult.gl()) {}
    for (boolean bool = true;; bool = false)
    {
      y(bool);
      this.Ns.j(paramConnectionResult);
      this.Ns.On.g(paramConnectionResult);
      return;
    }
  }
  
  private boolean iv()
  {
    this.Nx -= 1;
    if (this.Nx > 0) {
      return false;
    }
    if (this.Nx < 0)
    {
      Log.w("GoogleApiClientConnecting", this.Ns.MJ.iD());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      i(new ConnectionResult(8, null));
      return false;
    }
    if (this.Nk != null)
    {
      this.Ns.Om = this.Nv;
      i(this.Nk);
      return false;
    }
    return true;
  }
  
  private void iw()
  {
    if (this.Nx != 0) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while ((this.NC) && (!this.ND));
      localArrayList = new ArrayList();
      this.Nw = 1;
      this.Nx = this.Ns.NX.size();
      Iterator localIterator = this.Ns.NX.keySet().iterator();
      while (localIterator.hasNext())
      {
        com.google.android.gms.common.api.h localh = (com.google.android.gms.common.api.h)localIterator.next();
        if (this.Ns.Oj.containsKey(localh))
        {
          if (iv()) {
            ix();
          }
        }
        else {
          localArrayList.add((j)this.Ns.NX.get(localh));
        }
      }
    } while (localArrayList.isEmpty());
    this.NG.add(ap.iG().submit(new ad(this, localArrayList)));
  }
  
  private void ix()
  {
    this.Ns.iF();
    ap.iG().execute(new Runnable()
    {
      public final void run()
      {
        com.google.android.gms.common.h.l(aa.a(aa.this));
      }
    });
    if (this.NA != null)
    {
      if (this.Jf) {
        this.NA.a(this.NE, this.NF);
      }
      y(false);
    }
    Object localObject = this.Ns.Oj.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.google.android.gms.common.api.h localh = (com.google.android.gms.common.api.h)((Iterator)localObject).next();
      ((j)this.Ns.NX.get(localh)).disconnect();
    }
    if (this.Ny.isEmpty()) {}
    for (localObject = null;; localObject = this.Ny)
    {
      this.Ns.On.j((Bundle)localObject);
      return;
    }
  }
  
  private void iy()
  {
    this.NC = false;
    this.Ns.MJ.NY = Collections.emptySet();
    Iterator localIterator = this.Nz.iterator();
    while (localIterator.hasNext())
    {
      com.google.android.gms.common.api.h localh = (com.google.android.gms.common.api.h)localIterator.next();
      if (!this.Ns.Oj.containsKey(localh)) {
        this.Ns.Oj.put(localh, new ConnectionResult(17, null));
      }
    }
  }
  
  private void iz()
  {
    Iterator localIterator = this.NG.iterator();
    while (localIterator.hasNext()) {
      ((Future)localIterator.next()).cancel(true);
    }
    this.NG.clear();
  }
  
  private void y(boolean paramBoolean)
  {
    if (this.NA != null)
    {
      if ((this.NA.isConnected()) && (paramBoolean)) {
        this.NA.jE();
      }
      this.NA.disconnect();
      this.NE = null;
    }
  }
  
  public final <A extends com.google.android.gms.common.api.g, R extends w, T extends g<R, A>> T a(T paramT)
  {
    this.Ns.MJ.Nf.add(paramT);
    return paramT;
  }
  
  public final void a(ConnectionResult paramConnectionResult, a<?> parama, boolean paramBoolean)
  {
    if (!bk(1)) {}
    do
    {
      return;
      b(paramConnectionResult, parama, paramBoolean);
    } while (!iv());
    ix();
  }
  
  public final <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final void bd(int paramInt)
  {
    i(new ConnectionResult(8, null));
  }
  
  public final void begin()
  {
    this.Ns.Oj.clear();
    this.NC = false;
    this.Nk = null;
    this.Nw = 0;
    this.NB = true;
    this.ND = false;
    this.Jf = false;
    HashMap localHashMap = new HashMap();
    Object localObject = this.Na.keySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      j localj = (j)this.Ns.NX.get(locala.gr());
      boolean bool = ((Boolean)this.Na.get(locala)).booleanValue();
      if (localj.gs())
      {
        this.NC = true;
        if (!bool) {
          break label182;
        }
        this.Nz.add(locala.gr());
      }
      for (;;)
      {
        localHashMap.put(localj, new ab(this, locala, bool));
        break;
        label182:
        this.NB = false;
      }
    }
    if (this.NC)
    {
      this.Kf.a(Integer.valueOf(System.identityHashCode(this.Ns.MJ)));
      localObject = new af(this, (byte)0);
      this.NA = ((cr)this.HG.a(this.mContext, this.Ns.MJ.getLooper(), this.Kf, this.Kf.hs(), (r)localObject, (s)localObject));
    }
    this.Nx = this.Ns.NX.size();
    this.NG.add(ap.iG().submit(new ac(this, localHashMap)));
  }
  
  public final void connect() {}
  
  public final boolean disconnect()
  {
    iz();
    y(true);
    this.Ns.j(null);
    return true;
  }
  
  public final void h(Bundle paramBundle)
  {
    if (!bk(1)) {}
    do
    {
      return;
      if (paramBundle != null) {
        this.Ny.putAll(paramBundle);
      }
    } while (!iv());
    ix();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.aa
 * JD-Core Version:    0.7.0.1
 */