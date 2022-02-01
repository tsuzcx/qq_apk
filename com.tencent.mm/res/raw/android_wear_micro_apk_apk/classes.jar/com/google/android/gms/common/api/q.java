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
  private Account Iy;
  private final Set<Scope> Ji = new HashSet();
  private final Set<Scope> Jj = new HashSet();
  private int Jk;
  private View Jl;
  private String Jm;
  private String Jn;
  private final Map<a<?>, y> Jo = new android.support.v4.b.a();
  private final Map<a<?>, b> Jp = new android.support.v4.b.a();
  private ax Jq;
  private int Jr = -1;
  private s Js;
  private Looper Jt;
  private com.google.android.gms.common.b Ju = com.google.android.gms.common.b.gz();
  private f<? extends cr, cs> Jv = cp.Sj;
  private final ArrayList<r> Jw = new ArrayList();
  private final ArrayList<s> Jx = new ArrayList();
  private boolean Jy = false;
  private final Context mContext;
  
  public q(Context paramContext)
  {
    this.mContext = paramContext;
    this.Jt = paramContext.getMainLooper();
    this.Jm = paramContext.getPackageName();
    this.Jn = paramContext.getClass().getName();
  }
  
  public final q a(Account paramAccount)
  {
    this.Iy = paramAccount;
    return this;
  }
  
  public final q a(a<? extends d> parama)
  {
    com.google.android.gms.common.internal.d.g(parama, "Api must not be null");
    this.Jp.put(parama, null);
    parama = Collections.emptyList();
    this.Jj.addAll(parama);
    this.Ji.addAll(parama);
    return this;
  }
  
  public final x gJ()
  {
    cs localcs = cs.So;
    if (this.Jp.containsKey(cp.Sl)) {
      localcs = (cs)this.Jp.get(cp.Sl);
    }
    return new x(this.Iy, this.Ji, this.Jo, this.Jk, this.Jl, this.Jm, this.Jn, localcs);
  }
  
  public final p gK()
  {
    android.support.v4.b.a locala1;
    android.support.v4.b.a locala2;
    ArrayList localArrayList;
    label74:
    a locala;
    Object localObject4;
    if (!this.Jp.isEmpty())
    {
      bool = true;
      com.google.android.gms.common.internal.d.b(bool, "must call addApi() to add at least one API");
      ??? = gJ();
      localObject2 = ((x)???).hz();
      locala1 = new android.support.v4.b.a();
      locala2 = new android.support.v4.b.a();
      localArrayList = new ArrayList();
      Iterator localIterator = this.Jp.keySet().iterator();
      if (!localIterator.hasNext()) {
        break label210;
      }
      locala = (a)localIterator.next();
      localObject4 = this.Jp.get(locala);
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
      localObject4 = locala.gA().a(this.mContext, this.Jt, (x)???, localObject4, localn, localn);
      locala2.put(locala.gB(), localObject4);
      break label74;
      bool = false;
      break;
    }
    label210:
    int i = ai.a(locala2.values());
    Object localObject2 = new ai(this.mContext, new ReentrantLock(), this.Jt, (x)???, this.Ju, this.Jv, locala1, this.Jw, this.Jx, locala2, this.Jr, i, localArrayList);
    synchronized (p.gI())
    {
      p.gI().add(localObject2);
      if (this.Jr >= 0) {
        com.google.android.gms.internal.a.a(this.Jq).a(this.Jr, (p)localObject2, this.Js);
      }
      return localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.q
 * JD-Core Version:    0.7.0.1
 */