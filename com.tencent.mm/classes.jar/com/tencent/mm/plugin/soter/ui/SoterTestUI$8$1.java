package com.tencent.mm.plugin.soter.ui;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.core.a;
import com.tencent.soter.core.a.a.b;
import com.tencent.soter.core.c.j;
import java.security.Signature;
import java.security.SignatureException;

final class SoterTestUI$8$1
  extends a.b
{
  SoterTestUI$8$1(SoterTestUI.8 param8, Signature paramSignature) {}
  
  public final void bKW()
  {
    y.i("MicroMsg.SoterTestUI", "hy: onAuthenticationSucceeded");
    try
    {
      this.psP.update("challenge".getBytes());
      Object localObject = a.bR(this.psP.sign());
      TextView localTextView = SoterTestUI.a(this.psQ.psO);
      if (localObject == null) {}
      for (localObject = "not pass: exception occurs";; localObject = ((j)localObject).toString())
      {
        localTextView.setText((CharSequence)localObject);
        return;
      }
      return;
    }
    catch (SignatureException localSignatureException)
    {
      y.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + localSignatureException.toString());
    }
  }
  
  public final void onAuthenticationCancelled()
  {
    super.onAuthenticationCancelled();
  }
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    y.i("MicroMsg.SoterTestUI", "hy: onAuthenticationError");
  }
  
  public final void onAuthenticationFailed()
  {
    y.i("MicroMsg.SoterTestUI", "hy: onAuthenticationFailed");
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    y.i("MicroMsg.SoterTestUI", "hy: onAuthenticationHelp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI.8.1
 * JD-Core Version:    0.7.0.1
 */