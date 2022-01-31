package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.core.a.a.d;
import java.security.Signature;
import java.security.SignatureException;

final class SoterTestUI$8
  implements View.OnClickListener
{
  SoterTestUI$8(SoterTestUI paramSoterTestUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = com.tencent.soter.core.a.afS("sample_auth_key_name");
    if (paramView != null) {}
    try
    {
      paramView.update("challenge".getBytes());
      paramView.sign();
      y.e("MicroMsg.SoterTestUI", "hy: should NOT happen if no exception");
      SoterTestUI.a(this.psO).setText("not passed: signature success without fingerprint authentication");
      return;
    }
    catch (SignatureException localSignatureException)
    {
      y.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + localSignatureException.toString());
      com.tencent.soter.core.a.a locala = com.tencent.soter.core.a.a.hK(this.psO);
      if ((!locala.isHardwareDetected()) || (!locala.hasEnrolledFingerprints())) {
        break label122;
      }
      locala.a(new a.d(paramView), null, new SoterTestUI.8.1(this, paramView));
      return;
      label122:
      y.e("MicroMsg.SoterTestUI", "hy: no hardware detected or no fingerprint registered");
    }
    y.e("MicroMsg.SoterTestUI", "hy: signature is null. do sign failed");
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI.8
 * JD-Core Version:    0.7.0.1
 */