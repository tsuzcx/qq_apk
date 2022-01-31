package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback;
import com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationResult;
import com.tencent.soter.core.c.d;
import java.security.Signature;

final class i$a
  extends BiometricManagerCompat.AuthenticationCallback
{
  private long wPs;
  private Signature wQx = null;
  
  private i$a(i parami, Signature paramSignature)
  {
    this.wQx = paramSignature;
  }
  
  private static String V(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return "unknown error";
    }
    return paramCharSequence.toString();
  }
  
  @SuppressLint({"NewApi"})
  private void cPO()
  {
    if ((this.wQG.wQu) || (this.wQG.wPS == 2))
    {
      this.wQG.wQD.oj(false);
      this.wQG.wQv = true;
    }
  }
  
  public final void onAuthenticationCancelled()
  {
    d.i("Soter.TaskBiometricAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
    if (this.wQG.wQv)
    {
      d.v("Soter.TaskBiometricAuthentication", "soter: during ignore cancel period", new Object[0]);
      return;
    }
    g.cPK().d(new i.a.6(this));
    this.wQG.b(new com.tencent.soter.a.b.a(24, "user cancelled authentication"));
    cPO();
  }
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    d.e("Soter.TaskBiometricAuthentication", "soter: on authentication fatal error: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    g.cPK().d(new i.a.1(this, paramInt, paramCharSequence));
    if (paramInt == 10308) {
      this.wQG.b(new com.tencent.soter.a.b.a(25, V(paramCharSequence)));
    }
    for (;;)
    {
      cPO();
      return;
      this.wQG.b(new com.tencent.soter.a.b.a(21, V(paramCharSequence)));
    }
  }
  
  public final void onAuthenticationFailed()
  {
    d.w("Soter.TaskBiometricAuthentication", "soter: authentication failed once", new Object[0]);
    g.cPK().d(new i.a.5(this));
    if (this.wQG.wQt)
    {
      d.i("Soter.TaskBiometricAuthentication", "soter: should compat lower android version logic.", new Object[0]);
      this.wQG.wQD.oj(false);
      g.cPK().H(new i.a.7(this));
      g.cPK().m(new i.a.8(this), 1000L);
    }
    if (this.wQG.wPS == 2)
    {
      d.i("Soter.TaskBiometricAuthentication", "soter: should compat faceid logic.", new Object[0]);
      this.wQG.b(new com.tencent.soter.a.b.a(21, "faceid not match"));
    }
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    d.w("Soter.TaskBiometricAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    g.cPK().d(new i.a.2(this, paramInt, paramCharSequence));
  }
  
  public final void onAuthenticationSucceeded(BiometricManagerCompat.AuthenticationResult paramAuthenticationResult)
  {
    d.i("Soter.TaskBiometricAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
    g.cPK().d(new i.a.3(this));
    g.cPK().H(new i.a.4(this));
    cPO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.i.a
 * JD-Core Version:    0.7.0.1
 */