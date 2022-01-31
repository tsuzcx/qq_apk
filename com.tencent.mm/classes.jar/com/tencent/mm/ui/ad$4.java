package com.tencent.mm.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.g;

final class ad$4
  implements Runnable
{
  ad$4(ad paramad) {}
  
  public final void run()
  {
    if ((this.uPW.ohK.isFinishing()) || (this.uPW.ohK.isPaused()) || (!this.uPW.mChattingClosed))
    {
      y.w("MicroMsg.LauncherUI.NewChattingTabUI", "[mStartChattingRunnable] pass! isPause:%s mChattingClosed:%s", new Object[] { Boolean.valueOf(this.uPW.ohK.isPaused()), Boolean.valueOf(this.uPW.mChattingClosed) });
      this.uPW.uPU = true;
      return;
    }
    this.uPW.mChattingClosed = false;
    boolean bool;
    if (this.uPW.uPK == null)
    {
      bool = false;
      label105:
      y.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      Intent localIntent = new Intent().putExtra("Chat_User", this.uPW.uPP);
      if (this.uPW.uPQ != null) {
        localIntent.putExtras(this.uPW.uPQ);
      }
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", true);
      ad.a(this.uPW, localIntent, false);
      this.uPW.uPN.setOnChattingLayoutChangedListener(this.uPW.onChattingLayoutChangedListener);
      this.uPW.uPK.setVisibility(0);
      if (this.uPW.ohK.getWindow().getDecorView().getWidth() != 0) {
        break label314;
      }
    }
    label314:
    for (float f = this.uPW.ohK.getResources().getDisplayMetrics().widthPixels;; f = this.uPW.ohK.getWindow().getDecorView().getWidth())
    {
      this.uPW.uPK.setTranslationX(f - 0.1F);
      this.uPW.uPJ = ah.UX();
      this.uPW.jdMethod_if(3);
      if (!this.uPW.cbo()) {
        break;
      }
      g.a(this.uPW.ohK);
      return;
      bool = this.uPW.uPK.isShown();
      break label105;
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|startChattingRunnable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.ad.4
 * JD-Core Version:    0.7.0.1
 */