package com.tencent.mm.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class NewChattingTabUI$6
  implements OnLayoutChangedLinearLayout.a
{
  long start = 0L;
  
  NewChattingTabUI$6(NewChattingTabUI paramNewChattingTabUI) {}
  
  public final void dDb()
  {
    AppMethodBeat.i(29802);
    if (NewChattingTabUI.t(this.zei) == null)
    {
      NewChattingTabUI.a(this.zei, AnimationUtils.loadAnimation(NewChattingTabUI.g(this.zei), MMFragmentActivity.a.zbX));
      NewChattingTabUI.t(this.zei).setAnimationListener(new NewChattingTabUI.6.1(this));
    }
    if (NewChattingTabUI.w(this.zei))
    {
      NewChattingTabUI.d(this.zei).setOndispatchDraw(new NewChattingTabUI.6.2(this));
      NewChattingTabUI.x(this.zei);
    }
    for (;;)
    {
      NewChattingTabUI.q(this.zei).zpz = null;
      ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem CHATTING ONLAYOUT ");
      AppMethodBeat.o(29802);
      return;
      NewChattingTabUI.u(this.zei);
      NewChattingTabUI.v(this.zei);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI.6
 * JD-Core Version:    0.7.0.1
 */