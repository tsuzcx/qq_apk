package com.tencent.mm.ui.chatting;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/OpenImKefuServiceChattingUI;", "Lcom/tencent/mm/ui/chatting/ChattingUI;", "()V", "Companion", "app_release"})
public final class OpenImKefuServiceChattingUI
  extends ChattingUI
{
  public static final a WDF;
  
  static
  {
    AppMethodBeat.i(258911);
    WDF = new a((byte)0);
    AppMethodBeat.o(258911);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/OpenImKefuServiceChattingUI$Companion;", "", "()V", "TAG", "", "app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.OpenImKefuServiceChattingUI
 * JD-Core Version:    0.7.0.1
 */