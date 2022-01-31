package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.a.b;
import com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback;
import com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationResult;
import com.tencent.soter.core.c.d;
import java.security.Signature;

final class i$a
  extends BiometricManagerCompat.AuthenticationCallback
{
  private long BmR;
  private Signature BnX = null;
  
  private i$a(i parami, Signature paramSignature)
  {
    this.BnX = paramSignature;
  }
  
  private static String am(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(10533);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(10533);
      return "unknown error";
    }
    paramCharSequence = paramCharSequence.toString();
    AppMethodBeat.o(10533);
    return paramCharSequence;
  }
  
  @SuppressLint({"NewApi"})
  private void dVK()
  {
    AppMethodBeat.i(10539);
    if ((this.Bog.BnU) || (this.Bog.Bns == 2))
    {
      this.Bog.Bod.rV(false);
      this.Bog.BnV = true;
    }
    AppMethodBeat.o(10539);
  }
  
  public final void onAuthenticationCancelled()
  {
    AppMethodBeat.i(10538);
    d.i("Soter.TaskBiometricAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
    if (this.Bog.BnV)
    {
      d.v("Soter.TaskBiometricAuthentication", "soter: during ignore cancel period", new Object[0]);
      AppMethodBeat.o(10538);
      return;
    }
    g.dVG().d(new i.a.6(this));
    this.Bog.b(new com.tencent.soter.a.b.a(24, "user cancelled authentication"));
    dVK();
    AppMethodBeat.o(10538);
  }
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(10534);
    d.e("Soter.TaskBiometricAuthentication", "soter: on authentication fatal error: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    g.dVG().d(new i.a.1(this, paramInt, paramCharSequence));
    if (paramInt == 10308) {
      this.Bog.b(new com.tencent.soter.a.b.a(25, am(paramCharSequence)));
    }
    for (;;)
    {
      dVK();
      AppMethodBeat.o(10534);
      return;
      this.Bog.b(new com.tencent.soter.a.b.a(21, am(paramCharSequence)));
    }
  }
  
  public final void onAuthenticationFailed()
  {
    AppMethodBeat.i(10537);
    d.w("Soter.TaskBiometricAuthentication", "soter: authentication failed once", new Object[0]);
    g.dVG().d(new i.a.5(this));
    if (this.Bog.BnT)
    {
      d.i("Soter.TaskBiometricAuthentication", "soter: should compat lower android version logic.", new Object[0]);
      this.Bog.Bod.rV(false);
      g.dVG().O(new i.a.7(this));
      g.dVG().t(new i.a.8(this), 1000L);
    }
    if (this.Bog.Bns == 2)
    {
      d.i("Soter.TaskBiometricAuthentication", "soter: should compat faceid logic.", new Object[0]);
      this.Bog.b(new com.tencent.soter.a.b.a(21, "faceid not match"));
    }
    AppMethodBeat.o(10537);
  }
  
  public final void onAuthenticationHelp(final int paramInt, final CharSequence paramCharSequence)
  {
    AppMethodBeat.i(10535);
    d.w("Soter.TaskBiometricAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    g.dVG().d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(10526);
        if (i.a.this.Bog.Boe != null) {
          i.a.this.Bog.Boe.onAuthenticationHelp(paramInt, i.a.an(paramCharSequence));
        }
        AppMethodBeat.o(10526);
      }
    });
    AppMethodBeat.o(10535);
  }
  
  public final void onAuthenticationSucceeded(BiometricManagerCompat.AuthenticationResult paramAuthenticationResult)
  {
    AppMethodBeat.i(10536);
    d.i("Soter.TaskBiometricAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
    g.dVG().d(new i.a.3(this));
    g.dVG().O(new i.a.4(this));
    dVK();
    AppMethodBeat.o(10536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.i.a
 * JD-Core Version:    0.7.0.1
 */