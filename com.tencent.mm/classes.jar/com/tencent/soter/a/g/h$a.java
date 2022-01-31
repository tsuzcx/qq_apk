package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import com.tencent.soter.core.a.a.b;
import com.tencent.soter.core.c.d;
import java.security.Signature;

final class h$a
  extends a.b
{
  long wPs;
  Signature wQx = null;
  
  private h$a(h paramh, Signature paramSignature)
  {
    this.wQx = paramSignature;
  }
  
  static String V(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return "unknown error";
    }
    return paramCharSequence.toString();
  }
  
  @SuppressLint({"NewApi"})
  private void cPN()
  {
    if (this.wQw.wQu)
    {
      this.wQw.wQp.ol(false);
      this.wQw.wQv = true;
    }
  }
  
  public final void bKW()
  {
    d.i("Soter.TaskAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
    g.cPK().H(new h.a.3(this));
    g.cPK().d(new h.a.4(this));
    cPN();
  }
  
  public final void onAuthenticationCancelled()
  {
    d.i("Soter.TaskAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
    if (this.wQw.wQv)
    {
      d.v("Soter.TaskAuthentication", "soter: during ignore cancel period", new Object[0]);
      return;
    }
    super.onAuthenticationCancelled();
    g.cPK().d(new h.a.6(this));
    this.wQw.b(new com.tencent.soter.a.b.a(24, "user cancelled authentication"));
    cPN();
  }
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    d.e("Soter.TaskAuthentication", "soter: on authentication fatal error: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    if (paramInt != 10308)
    {
      g.cPK().d(new h.a.1(this, paramInt, paramCharSequence));
      this.wQw.b(new com.tencent.soter.a.b.a(21, V(paramCharSequence)));
    }
    for (;;)
    {
      cPN();
      return;
      this.wQw.b(new com.tencent.soter.a.b.a(25, V(paramCharSequence)));
    }
  }
  
  public final void onAuthenticationFailed()
  {
    super.onAuthenticationFailed();
    d.w("Soter.TaskAuthentication", "soter: authentication failed once", new Object[0]);
    g.cPK().d(new h.a.5(this));
    if (this.wQw.wQt)
    {
      d.i("Soter.TaskAuthentication", "soter: should compat lower android version logic.", new Object[0]);
      this.wQw.wQp.ol(false);
      g.cPK().H(new h.a.7(this));
      g.cPK().m(new h.a.8(this), 1000L);
    }
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    d.w("Soter.TaskAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    g.cPK().d(new h.a.2(this, paramInt, paramCharSequence));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.soter.a.g.h.a
 * JD-Core Version:    0.7.0.1
 */