package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.cs;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class x
{
  private final Account Iy;
  private final Set<Scope> Ji;
  private final int Jk;
  private final View Jl;
  private final String Jm;
  private final String Jn;
  private final Set<Scope> LF;
  private final Map<a<?>, y> LG;
  private final cs LH;
  private Integer LI;
  
  public x(Account paramAccount, Set<Scope> paramSet, Map<a<?>, y> paramMap, int paramInt, View paramView, String paramString1, String paramString2, cs paramcs)
  {
    this.Iy = paramAccount;
    if (paramSet == null) {}
    for (paramAccount = Collections.EMPTY_SET;; paramAccount = Collections.unmodifiableSet(paramSet))
    {
      this.Ji = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null) {
        paramAccount = Collections.EMPTY_MAP;
      }
      this.LG = paramAccount;
      this.Jl = paramView;
      this.Jk = paramInt;
      this.Jm = paramString1;
      this.Jn = paramString2;
      this.LH = paramcs;
      paramAccount = new HashSet(this.Ji);
      paramSet = this.LG.values().iterator();
      while (paramSet.hasNext()) {
        paramAccount.addAll(((y)paramSet.next()).IG);
      }
    }
    this.LF = Collections.unmodifiableSet(paramAccount);
  }
  
  public final void a(Integer paramInteger)
  {
    this.LI = paramInteger;
  }
  
  public final Account gi()
  {
    return this.Iy;
  }
  
  public final String hA()
  {
    return this.Jm;
  }
  
  public final String hB()
  {
    return this.Jn;
  }
  
  public final cs hC()
  {
    return this.LH;
  }
  
  public final Integer hD()
  {
    return this.LI;
  }
  
  public final Account hw()
  {
    if (this.Iy != null) {
      return this.Iy;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  public final Set<Scope> hx()
  {
    return this.Ji;
  }
  
  public final Set<Scope> hy()
  {
    return this.LF;
  }
  
  public final Map<a<?>, y> hz()
  {
    return this.LG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.x
 * JD-Core Version:    0.7.0.1
 */