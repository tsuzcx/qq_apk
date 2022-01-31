package com.tencent.soter.core.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

final class a$a$1
  extends b.a
{
  private boolean mMarkPermanentlyCallbacked = false;
  
  a$a$1(a.b paramb, Context paramContext) {}
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(72976);
    d.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationSucceeded", new Object[0]);
    if (this.mMarkPermanentlyCallbacked)
    {
      AppMethodBeat.o(72976);
      return;
    }
    a.b localb;
    if (!a.a.a(this, this.val$context))
    {
      if (!c.isSystemHasAntiBruteForce()) {
        c.unFreeze(this.val$context);
      }
      this.mMarkPermanentlyCallbacked = true;
      localb = this.BlR;
      paramb = paramb.BlU;
      if (paramb == null) {
        break label154;
      }
      if (paramb.mCipher == null) {
        break label110;
      }
      paramb = new a.d(paramb.mCipher);
    }
    label154:
    for (;;)
    {
      new a.c(paramb);
      localb.cys();
      AppMethodBeat.o(72976);
      return;
      label110:
      if (paramb.mSignature != null) {
        paramb = new a.d(paramb.mSignature);
      } else if (paramb.mMac != null) {
        paramb = new a.d(paramb.mMac);
      } else {
        paramb = null;
      }
    }
  }
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(72974);
    for (;;)
    {
      d.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationError", new Object[0]);
      if (this.mMarkPermanentlyCallbacked)
      {
        AppMethodBeat.o(72974);
        return;
      }
      this.mMarkPermanentlyCallbacked = true;
      if (paramInt == 5)
      {
        d.i("Soter.FingerprintManagerCompat", "soter: user cancelled fingerprint authen", new Object[0]);
        this.BlR.onAuthenticationCancelled();
        AppMethodBeat.o(72974);
        return;
      }
      if (paramInt != 7) {
        break;
      }
      d.i("Soter.FingerprintManagerCompat", "soter: system call too many trial.", new Object[0]);
      if ((!c.isCurrentFailTimeAvailable(this.val$context)) && (!c.isCurrentTweenTimeAvailable(this.val$context)) && (!c.isSystemHasAntiBruteForce())) {
        c.freeze(this.val$context);
      }
      this.mMarkPermanentlyCallbacked = false;
      paramInt = 10308;
      paramCharSequence = "Too many failed times";
    }
    this.BlR.onAuthenticationError(paramInt, paramCharSequence);
    AppMethodBeat.o(72974);
  }
  
  public final void onAuthenticationFailed()
  {
    AppMethodBeat.i(72977);
    d.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationFailed", new Object[0]);
    if (this.mMarkPermanentlyCallbacked)
    {
      AppMethodBeat.o(72977);
      return;
    }
    if (!a.a.a(this, this.val$context))
    {
      if (!c.isSystemHasAntiBruteForce())
      {
        Context localContext = this.val$context;
        c.setCurrentFailTime(localContext, Integer.valueOf(c.getCurrentFailTime(localContext)).intValue() + 1);
        if (!c.isCurrentFailTimeAvailable(this.val$context))
        {
          d.w("Soter.FingerprintManagerCompat", "soter: too many fail trials", new Object[0]);
          c.freeze(this.val$context);
          a.a.a(this);
          AppMethodBeat.o(72977);
          return;
        }
      }
      this.BlR.onAuthenticationFailed();
    }
    AppMethodBeat.o(72977);
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(72975);
    d.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationHelp", new Object[0]);
    if (this.mMarkPermanentlyCallbacked)
    {
      AppMethodBeat.o(72975);
      return;
    }
    if (!a.a.a(this, this.val$context)) {
      this.BlR.onAuthenticationHelp(paramInt, paramCharSequence);
    }
    AppMethodBeat.o(72975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.core.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */