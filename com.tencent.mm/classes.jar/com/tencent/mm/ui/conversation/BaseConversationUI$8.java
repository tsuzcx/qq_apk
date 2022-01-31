package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.g;

final class BaseConversationUI$8
  implements Runnable
{
  BaseConversationUI$8(BaseConversationUI paramBaseConversationUI) {}
  
  public final void run()
  {
    if ((this.vPi.isFinishing()) || (this.vPi.isPaused()) || (!this.vPi.mChattingClosed))
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BaseConversationUI", "[startChattingRunnable] pass! isPause:%s mChattingClosed:%s", new Object[] { Boolean.valueOf(this.vPi.isPaused()), Boolean.valueOf(this.vPi.mChattingClosed) });
      return;
    }
    this.vPi.mChattingClosed = false;
    boolean bool;
    if (BaseConversationUI.access$200(this.vPi) == null)
    {
      bool = false;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "ashutest::startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      Intent localIntent = new Intent().putExtra("Chat_User", this.vPi.pendingUser);
      if (this.vPi.pendingBundle != null) {
        localIntent.putExtras(this.vPi.pendingBundle);
      }
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", true);
      BaseConversationUI.access$300(this.vPi, localIntent, false);
      BaseConversationUI.access$1200(this.vPi).setOnChattingLayoutChangedListener(BaseConversationUI.access$1400(this.vPi));
      if (this.vPi.getWindow().getDecorView().getWidth() != 0) {
        break label304;
      }
    }
    label304:
    for (float f = this.vPi.getResources().getDisplayMetrics().widthPixels;; f = this.vPi.getWindow().getDecorView().getWidth())
    {
      BaseConversationUI.access$200(this.vPi).setTranslationX(f - 0.1F);
      BaseConversationUI.access$200(this.vPi).setVisibility(0);
      this.vPi.pauseMainFragment();
      if (BaseConversationUI.access$100(this.vPi).isSupportNavigationSwipeBack()) {
        g.a(this.vPi);
      }
      e.post(new BaseConversationUI.8.1(this), "directReport_startChattingRunnable");
      BaseConversationUI.access$402(this.vPi, bk.UX());
      return;
      bool = BaseConversationUI.access$200(this.vPi).isShown();
      break;
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|startChattingRunnable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.8
 * JD-Core Version:    0.7.0.1
 */