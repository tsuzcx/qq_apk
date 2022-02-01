package com.tencent.mm.ui.conversation;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI;", "Lcom/tencent/mm/ui/conversation/BaseConversationUI;", "()V", "Companion", "app_release"})
public final class OpenImKefuServiceConversationUI
  extends BaseConversationUI
{
  public static final a XEa;
  
  static
  {
    AppMethodBeat.i(288034);
    XEa = new a((byte)0);
    AppMethodBeat.o(288034);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/conversation/OpenImKefuServiceConversationUI$Companion;", "", "()V", "TAG", "", "app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.OpenImKefuServiceConversationUI
 * JD-Core Version:    0.7.0.1
 */