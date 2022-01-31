package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.common.internal.y;
import com.google.android.gms.internal.ai;
import com.google.android.gms.internal.ax;
import com.google.android.gms.internal.cp;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public final class q
{
  private Account GJ;
  private final Map<a<?>, b> HA = new android.support.v4.b.a();
  private ax HB;
  private int HC = -1;
  private s HD;
  private Looper HE;
  private com.google.android.gms.common.b HF = com.google.android.gms.common.b.gp();
  private f<? extends cr, cs> HG = cp.Qu;
  private final ArrayList<r> HH = new ArrayList();
  private final ArrayList<s> HI = new ArrayList();
  private boolean HJ = false;
  private final Set<Scope> Ht = new HashSet();
  private final Set<Scope> Hu = new HashSet();
  private int Hv;
  private View Hw;
  private String Hx;
  private String Hy;
  private final Map<a<?>, y> Hz = new android.support.v4.b.a();
  private final Context mContext;
  
  public q(Context paramContext)
  {
    this.mContext = paramContext;
    this.HE = paramContext.getMainLooper();
    this.Hx = paramContext.getPackageName();
    this.Hy = paramContext.getClass().getName();
  }
  
  public final q a(Account paramAccount)
  {
    this.GJ = paramAccount;
    return this;
  }
  
  public final q a(a<? extends d> parama)
  {
    com.google.android.gms.common.internal.d.e(parama, "Api must not be null");
    this.HA.put(parama, null);
    parama = Collections.emptyList();
    this.Hu.addAll(parama);
    this.Ht.addAll(parama);
    return this;
  }
  
  public final p gA()
  {
    android.support.v4.b.a locala1;
    android.support.v4.b.a locala2;
    ArrayList localArrayList;
    label74:
    a locala;
    Object localObject4;
    if (!this.HA.isEmpty())
    {
      bool = true;
      com.google.android.gms.common.internal.d.b(bool, "must call addApi() to add at least one API");
      ??? = gz();
      localObject2 = ((x)???).hp();
      locala1 = new android.support.v4.b.a();
      locala2 = new android.support.v4.b.a();
      localArrayList = new ArrayList();
      Iterator localIterator = this.HA.keySet().iterator();
      if (!localIterator.hasNext()) {
        break label210;
      }
      locala = (a)localIterator.next();
      localObject4 = this.HA.get(locala);
      if (((Map)localObject2).get(locala) == null) {
        break label205;
      }
    }
    label205:
    for (boolean bool = true;; bool = false)
    {
      locala1.put(locala, Boolean.valueOf(bool));
      n localn = new n(locala, bool);
      localArrayList.add(localn);
      localObject4 = locala.gq().a(this.mContext, this.HE, (x)???, localObject4, localn, localn);
      locala2.put(locala.gr(), localObject4);
      break label74;
      bool = false;
      break;
    }
    label210:
    int i = ai.a(locala2.values());
    Object localObject2 = new ai(this.mContext, new ReentrantLock(), this.HE, (x)???, this.HF, this.HG, locala1, this.HH, this.HI, locala2, this.HC, i, localArrayList);
    synchronized (p.gy())
    {
      p.gy().add(localObject2);
      if (this.HC >= 0) {
        com.google.android.gms.internal.a.a(this.HB).a(this.HC, (p)localObject2, this.HD);
      }
      return localObject2;
    }
  }
  
  public final x gz()
  {
    cs localcs = cs.Qz;
    if (this.HA.containsKey(cp.Qw)) {
      localcs = (cs)this.HA.get(cp.Qw);
    }
    return new x(this.GJ, this.Ht, this.Hz, this.Hv, this.Hw, this.Hx, this.Hy, localcs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.q
 * JD-Core Version:    0.7.0.1
 */