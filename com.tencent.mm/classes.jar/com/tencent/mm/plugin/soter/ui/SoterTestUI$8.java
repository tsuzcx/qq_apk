package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.a.a.b;
import com.tencent.soter.core.a.a.d;
import com.tencent.soter.core.a.a.e;
import com.tencent.soter.core.c.j;
import java.security.Signature;
import java.security.SignatureException;

final class SoterTestUI$8
  implements View.OnClickListener
{
  SoterTestUI$8(SoterTestUI paramSoterTestUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(130917);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = com.tencent.soter.core.a.bqk("sample_auth_key_name");
    if (paramView != null) {}
    com.tencent.soter.core.a.a locala;
    try
    {
      paramView.update("challenge".getBytes());
      paramView.sign();
      Log.e("MicroMsg.SoterTestUI", "hy: should NOT happen if no exception");
      SoterTestUI.a(this.FiH).setText("not passed: signature success without fingerprint authentication");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(130917);
      return;
    }
    catch (SignatureException localSignatureException)
    {
      Log.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + localSignatureException.toString());
      locala = com.tencent.soter.core.a.a.lf(this.FiH);
      if (!com.tencent.soter.core.a.a.RPk.isHardwareDetected(locala.mContext)) {
        break label215;
      }
    }
    Log.e("MicroMsg.SoterTestUI", "hy: signature is null. do sign failed");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(130917);
    return;
    if (locala.hasEnrolledFingerprints()) {
      locala.a(new a.d(paramView), null, new a.b()
      {
        public final void fme()
        {
          AppMethodBeat.i(130914);
          Log.i("MicroMsg.SoterTestUI", "hy: onAuthenticationSucceeded");
          try
          {
            paramView.update("challenge".getBytes());
            Object localObject = com.tencent.soter.core.a.cY(paramView.sign());
            TextView localTextView = SoterTestUI.a(SoterTestUI.8.this.FiH);
            if (localObject == null) {}
            for (localObject = "not pass: exception occurs";; localObject = ((j)localObject).toString())
            {
              localTextView.setText((CharSequence)localObject);
              AppMethodBeat.o(130914);
              return;
            }
            return;
          }
          catch (SignatureException localSignatureException)
          {
            Log.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + localSignatureException.toString());
            AppMethodBeat.o(130914);
          }
        }
        
        public final void onAuthenticationCancelled()
        {
          AppMethodBeat.i(130916);
          super.onAuthenticationCancelled();
          AppMethodBeat.o(130916);
        }
        
        public final void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(130912);
          Log.i("MicroMsg.SoterTestUI", "hy: onAuthenticationError");
          AppMethodBeat.o(130912);
        }
        
        public final void onAuthenticationFailed()
        {
          AppMethodBeat.i(130915);
          Log.i("MicroMsg.SoterTestUI", "hy: onAuthenticationFailed");
          AppMethodBeat.o(130915);
        }
        
        public final void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(130913);
          Log.i("MicroMsg.SoterTestUI", "hy: onAuthenticationHelp");
          AppMethodBeat.o(130913);
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/soter/ui/SoterTestUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(130917);
      return;
      label215:
      Log.e("MicroMsg.SoterTestUI", "hy: no hardware detected or no fingerprint registered");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.ui.SoterTestUI.8
 * JD-Core Version:    0.7.0.1
 */