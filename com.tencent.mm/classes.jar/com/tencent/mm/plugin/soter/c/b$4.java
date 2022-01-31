package com.tencent.mm.plugin.soter.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class b$4
  implements com.tencent.soter.a.d.b
{
  b$4(b paramb) {}
  
  public final void bzy()
  {
    AppMethodBeat.i(73869);
    ab.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
    this.soc.snT = true;
    AppMethodBeat.o(73869);
  }
  
  public final void bzz()
  {
    AppMethodBeat.i(73871);
    ab.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
    this.soc.snT = false;
    this.soc.mGl = null;
    b localb = this.soc;
    localb.iuP.removeCallbacks(localb.sob);
    localb.snV.setImageResource(2130838876);
    localb.iuP.setTextColor(localb.iuP.getResources().getColor(2131690557));
    localb.iuP.setText(localb.iuP.getResources().getString(2131304071));
    AppMethodBeat.o(73871);
  }
  
  public final void onAuthenticationCancelled()
  {
    AppMethodBeat.i(73873);
    ab.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
    this.soc.mGl = null;
    AppMethodBeat.o(73873);
  }
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(73874);
    ab.e("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    AppMethodBeat.o(73874);
  }
  
  public final void onAuthenticationFailed()
  {
    AppMethodBeat.i(73872);
    ab.w("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
    b localb = this.soc;
    String str = ah.getContext().getString(2131304067);
    if (localb.snZ == null) {
      localb.snZ = b.eY(localb.snV.getContext());
    }
    if (localb.soa == null) {
      localb.soa = b.eY(localb.snV.getContext());
    }
    localb.snZ.setAnimationListener(new b.8(localb, str));
    localb.iuP.startAnimation(localb.snZ);
    localb.snV.startAnimation(localb.soa);
    this.soc.mMainHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(73868);
        b.4.this.soc.snT = false;
        b.a(b.4.this.soc, true);
        AppMethodBeat.o(73868);
      }
    }, 500L);
    AppMethodBeat.o(73872);
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(73870);
    ab.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    AppMethodBeat.o(73870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b.4
 * JD-Core Version:    0.7.0.1
 */