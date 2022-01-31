package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.a.a.b;
import com.tencent.soter.core.c.d;
import java.security.Signature;

final class h$a
  extends a.b
{
  long BmR;
  Signature BnX = null;
  
  private h$a(h paramh, Signature paramSignature)
  {
    this.BnX = paramSignature;
  }
  
  static String am(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(10506);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(10506);
      return "unknown error";
    }
    paramCharSequence = paramCharSequence.toString();
    AppMethodBeat.o(10506);
    return paramCharSequence;
  }
  
  @SuppressLint({"NewApi"})
  private void dVJ()
  {
    AppMethodBeat.i(10512);
    if (this.BnW.BnU)
    {
      this.BnW.BnP.rX(false);
      this.BnW.BnV = true;
    }
    AppMethodBeat.o(10512);
  }
  
  public final void cys()
  {
    AppMethodBeat.i(10509);
    d.i("Soter.TaskAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
    g.dVG().O(new h.a.3(this));
    g.dVG().d(new h.a.4(this));
    dVJ();
    AppMethodBeat.o(10509);
  }
  
  public final void onAuthenticationCancelled()
  {
    AppMethodBeat.i(10511);
    d.i("Soter.TaskAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
    if (this.BnW.BnV)
    {
      d.v("Soter.TaskAuthentication", "soter: during ignore cancel period", new Object[0]);
      AppMethodBeat.o(10511);
      return;
    }
    super.onAuthenticationCancelled();
    g.dVG().d(new h.a.6(this));
    this.BnW.b(new com.tencent.soter.a.b.a(24, "user cancelled authentication"));
    dVJ();
    AppMethodBeat.o(10511);
  }
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(10507);
    d.e("Soter.TaskAuthentication", "soter: on authentication fatal error: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    if (paramInt != 10308)
    {
      g.dVG().d(new h.a.1(this, paramInt, paramCharSequence));
      this.BnW.b(new com.tencent.soter.a.b.a(21, am(paramCharSequence)));
    }
    for (;;)
    {
      dVJ();
      AppMethodBeat.o(10507);
      return;
      this.BnW.b(new com.tencent.soter.a.b.a(25, am(paramCharSequence)));
    }
  }
  
  public final void onAuthenticationFailed()
  {
    AppMethodBeat.i(10510);
    super.onAuthenticationFailed();
    d.w("Soter.TaskAuthentication", "soter: authentication failed once", new Object[0]);
    g.dVG().d(new h.a.5(this));
    if (this.BnW.BnT)
    {
      d.i("Soter.TaskAuthentication", "soter: should compat lower android version logic.", new Object[0]);
      this.BnW.BnP.rX(false);
      g.dVG().O(new h.a.7(this));
      g.dVG().t(new h.a.8(this), 1000L);
    }
    AppMethodBeat.o(10510);
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(10508);
    d.w("Soter.TaskAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    g.dVG().d(new h.a.2(this, paramInt, paramCharSequence));
    AppMethodBeat.o(10508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.soter.a.g.h.a
 * JD-Core Version:    0.7.0.1
 */