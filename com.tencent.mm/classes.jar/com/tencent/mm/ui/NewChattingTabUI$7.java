package com.tencent.mm.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class NewChattingTabUI$7
  implements Animation.AnimationListener
{
  NewChattingTabUI$7(NewChattingTabUI paramNewChattingTabUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(29804);
    NewChattingTabUI.a(this.zei, false);
    NewChattingTabUI.d(this.zei).setVisibility(8);
    aw.RO().dtd();
    al.Nf(0);
    NewChattingTabUI.y(this.zei);
    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationEnd");
    AppMethodBeat.o(29804);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(29803);
    NewChattingTabUI.a(this.zei, true);
    aw.RO().dtb();
    al.Nf(-8);
    this.zei.H(true, 0);
    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationStart");
    AppMethodBeat.o(29803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI.7
 * JD-Core Version:    0.7.0.1
 */