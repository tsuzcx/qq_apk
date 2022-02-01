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
  private boolean IA;
  private boolean IB;
  private String IC;
  private String ID;
  private Set<Scope> IG = new HashSet();
  private Map<Integer, zzg> IH = new HashMap();
  private Account Iy;
  private boolean Iz;
  
  public final a a(Scope paramScope, Scope... paramVarArgs)
  {
    this.IG.add(paramScope);
    this.IG.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public final a gp()
  {
    this.IG.add(GoogleSignInOptions.It);
    return this;
  }
  
  public final a gq()
  {
    this.IG.add(GoogleSignInOptions.Ir);
    return this;
  }
  
  public final GoogleSignInOptions gr()
  {
    if ((this.Iz) && ((this.Iy == null) || (!this.IG.isEmpty()))) {
      gp();
    }
    return new GoogleSignInOptions(new ArrayList(this.IG), this.Iy, this.Iz, this.IA, this.IB, this.IC, this.ID, this.IH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.a
 * JD-Core Version:    0.7.0.1
 */