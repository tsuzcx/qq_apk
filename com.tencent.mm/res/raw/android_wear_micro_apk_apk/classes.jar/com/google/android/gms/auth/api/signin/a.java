package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class a
{
  private Account GJ;
  private boolean GK;
  private boolean GL;
  private boolean GM;
  private String GN;
  private String GO;
  private Set<Scope> GR = new HashSet();
  private Map<Integer, zzg> GS = new HashMap();
  
  public final a a(Scope paramScope, Scope... paramVarArgs)
  {
    this.GR.add(paramScope);
    this.GR.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public final a gf()
  {
    this.GR.add(GoogleSignInOptions.GE);
    return this;
  }
  
  public final a gg()
  {
    this.GR.add(GoogleSignInOptions.GC);
    return this;
  }
  
  public final GoogleSignInOptions gh()
  {
    if ((this.GK) && ((this.GJ == null) || (!this.GR.isEmpty()))) {
      gf();
    }
    return new GoogleSignInOptions(new ArrayList(this.GR), this.GJ, this.GK, this.GL, this.GM, this.GN, this.GO, this.GS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.a
 * JD-Core Version:    0.7.0.1
 */