package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.h;

final class BaseConversationUI$8
  implements Runnable
{
  BaseConversationUI$8(BaseConversationUI paramBaseConversationUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(34058);
    if (!this.AgT.mChattingClosed)
    {
      ab.e("MicroMsg.BaseConversationUI", "start chatting but last chatting does't be close!");
      this.AgT.closeChatting(false);
    }
    if ((this.AgT.isFinishing()) || (this.AgT.isPaused()) || (!this.AgT.mChattingClosed))
    {
      ab.w("MicroMsg.BaseConversationUI", "[startChattingRunnable] pass! isPause:%s mChattingClosed:%s", new Object[] { Boolean.valueOf(this.AgT.isPaused()), Boolean.valueOf(this.AgT.mChattingClosed) });
      AppMethodBeat.o(34058);
      return;
    }
    this.AgT.mChattingClosed = false;
    boolean bool;
    if (BaseConversationUI.access$200(this.AgT) == null)
    {
      bool = false;
      ab.i("MicroMsg.BaseConversationUI", "ashutest::startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      Intent localIntent = new Intent().putExtra("Chat_User", this.AgT.pendingUser);
      if (this.AgT.pendingBundle != null) {
        localIntent.putExtras(this.AgT.pendingBundle);
      }
      localIntent.putExtra("img_gallery_enter_from_chatting_ui", true);
      BaseConversationUI.access$300(this.AgT, localIntent, false);
      BaseConversationUI.access$1200(this.AgT).setOnChattingLayoutChangedListener(BaseConversationUI.access$1400(this.AgT));
      if (this.AgT.getWindow().getDecorView().getWidth() != 0) {
        break label344;
      }
    }
    label344:
    for (float f = this.AgT.getResources().getDisplayMetrics().widthPixels;; f = this.AgT.getWindow().getDecorView().getWidth())
    {
      BaseConversationUI.access$200(this.AgT).setTranslationX(f - 0.1F);
      BaseConversationUI.access$200(this.AgT).setVisibility(0);
      this.AgT.pauseMainFragment();
      if (BaseConversationUI.access$100(this.AgT).isSupportNavigationSwipeBack()) {
        h.a(this.AgT);
      }
      d.post(new BaseConversationUI.8.1(this), "directReport_startChattingRunnable");
      BaseConversationUI.access$402(this.AgT, bo.aox());
      AppMethodBeat.o(34058);
      return;
      bool = BaseConversationUI.access$200(this.AgT).isShown();
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(34059);
    String str = super.toString() + "|startChattingRunnable";
    AppMethodBeat.o(34059);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.8
 * JD-Core Version:    0.7.0.1
 */