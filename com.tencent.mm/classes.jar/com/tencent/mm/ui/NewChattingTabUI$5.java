package com.tencent.mm.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.h;

final class NewChattingTabUI$5
  implements Runnable
{
  NewChattingTabUI$5(NewChattingTabUI paramNewChattingTabUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(29797);
    if (!NewChattingTabUI.k(this.zei))
    {
      ab.e("MicroMsg.LauncherUI.NewChattingTabUI", "start chatting but last chatting does't be close!");
      this.zei.qx(false);
    }
    if ((NewChattingTabUI.g(this.zei).isFinishing()) || (NewChattingTabUI.g(this.zei).isPaused()) || (!NewChattingTabUI.k(this.zei)))
    {
      ab.w("MicroMsg.LauncherUI.NewChattingTabUI", "[mStartChattingRunnable] pass! isPause:%s mChattingClosed:%s", new Object[] { Boolean.valueOf(NewChattingTabUI.g(this.zei).isPaused()), Boolean.valueOf(NewChattingTabUI.k(this.zei)) });
      NewChattingTabUI.l(this.zei);
      AppMethodBeat.o(29797);
      return;
    }
    NewChattingTabUI.m(this.zei);
    boolean bool;
    if (NewChattingTabUI.d(this.zei) == null)
    {
      bool = false;
      ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      Intent localIntent = new Intent().putExtra("Chat_User", NewChattingTabUI.n(this.zei));
      if (NewChattingTabUI.o(this.zei) != null) {
        localIntent.putExtras(NewChattingTabUI.o(this.zei));
      }
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", true);
      NewChattingTabUI.a(this.zei, localIntent, false);
      NewChattingTabUI.q(this.zei).setOnChattingLayoutChangedListener(NewChattingTabUI.p(this.zei));
      NewChattingTabUI.d(this.zei).setVisibility(0);
      if (NewChattingTabUI.g(this.zei).getWindow().getDecorView().getWidth() != 0) {
        break label358;
      }
    }
    label358:
    for (float f = NewChattingTabUI.g(this.zei).getResources().getDisplayMetrics().widthPixels;; f = NewChattingTabUI.g(this.zei).getWindow().getDecorView().getWidth())
    {
      NewChattingTabUI.d(this.zei).setTranslationX(f - 0.1F);
      NewChattingTabUI.a(this.zei, ah.aox());
      NewChattingTabUI.r(this.zei);
      if (NewChattingTabUI.s(this.zei)) {
        h.a(NewChattingTabUI.g(this.zei));
      }
      AppMethodBeat.o(29797);
      return;
      bool = NewChattingTabUI.d(this.zei).isShown();
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(29798);
    String str = super.toString() + "|startChattingRunnable";
    AppMethodBeat.o(29798);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI.5
 * JD-Core Version:    0.7.0.1
 */