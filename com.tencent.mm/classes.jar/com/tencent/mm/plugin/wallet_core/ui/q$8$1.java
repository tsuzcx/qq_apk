package com.tencent.mm.plugin.wallet_core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class q$8$1
  implements Animation.AnimationListener
{
  q$8$1(q.8 param8) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(47599);
    ab.i("MicroMsg.WalletPwdDialog", "hy: on flash end");
    al.d(new q.8.1.2(this));
    AppMethodBeat.o(47599);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(47598);
    ab.i("MicroMsg.WalletPwdDialog", "hy: on flash start");
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47596);
        q.8.1.this.uts.utp.usV.setVisibility(0);
        AppMethodBeat.o(47596);
      }
    });
    AppMethodBeat.o(47598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q.8.1
 * JD-Core Version:    0.7.0.1
 */