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
  private final Account GJ;
  private final Set<Scope> Ht;
  private final int Hv;
  private final View Hw;
  private final String Hx;
  private final String Hy;
  private final Set<Scope> JQ;
  private final Map<a<?>, y> JR;
  private final cs JS;
  private Integer JT;
  
  public x(Account paramAccount, Set<Scope> paramSet, Map<a<?>, y> paramMap, int paramInt, View paramView, String paramString1, String paramString2, cs paramcs)
  {
    this.GJ = paramAccount;
    if (paramSet == null) {}
    for (paramAccount = Collections.EMPTY_SET;; paramAccount = Collections.unmodifiableSet(paramSet))
    {
      this.Ht = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null) {
        paramAccount = Collections.EMPTY_MAP;
      }
      this.JR = paramAccount;
      this.Hw = paramView;
      this.Hv = paramInt;
      this.Hx = paramString1;
      this.Hy = paramString2;
      this.JS = paramcs;
      paramAccount = new HashSet(this.Ht);
      paramSet = this.JR.values().iterator();
      while (paramSet.hasNext()) {
        paramAccount.addAll(((y)paramSet.next()).GR);
      }
    }
    this.JQ = Collections.unmodifiableSet(paramAccount);
  }
  
  public final void a(Integer paramInteger)
  {
    this.JT = paramInteger;
  }
  
  public final Account fX()
  {
    return this.GJ;
  }
  
  public final Account hm()
  {
    if (this.GJ != null) {
      return this.GJ;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  public final Set<Scope> hn()
  {
    return this.Ht;
  }
  
  public final Set<Scope> ho()
  {
    return this.JQ;
  }
  
  public final Map<a<?>, y> hp()
  {
    return this.JR;
  }
  
  public final String hq()
  {
    return this.Hx;
  }
  
  public final String hr()
  {
    return this.Hy;
  }
  
  public final cs hs()
  {
    return this.JS;
  }
  
  public final Integer ht()
  {
    return this.JT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.x
 * JD-Core Version:    0.7.0.1
 */