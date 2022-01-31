package com.tencent.mm.plugin.wallet_core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class p$5$1
  implements Animation.AnimationListener
{
  p$5$1(p.5 param5) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(47561);
    ab.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash end");
    al.d(new p.5.1.2(this));
    AppMethodBeat.o(47561);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(47560);
    ab.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash start");
    al.d(new p.5.1.1(this));
    AppMethodBeat.o(47560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.p.5.1
 * JD-Core Version:    0.7.0.1
 */