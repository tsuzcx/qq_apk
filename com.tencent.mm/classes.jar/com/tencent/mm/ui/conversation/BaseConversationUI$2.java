package com.tencent.mm.ui.conversation;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class BaseConversationUI$2
  implements View.OnClickListener
{
  BaseConversationUI$2(BaseConversationUI paramBaseConversationUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34046);
    if (BaseConversationUI.access$800(this.AgT))
    {
      AppMethodBeat.o(34046);
      return;
    }
    al.ae(this.AgT.startChattingRunnable);
    this.AgT.finish();
    AppMethodBeat.o(34046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.2
 * JD-Core Version:    0.7.0.1
 */