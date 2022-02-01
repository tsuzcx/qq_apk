package com.tencent.mm.search.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.j;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/logic/SimilarEmojiListenerInstance;", "", "()V", "listener", "Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "create", "", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "destroy", "getInstance", "plugin-emojisdk_release"})
public final class a
{
  private static c EZe;
  public static final a EZf;
  
  static
  {
    AppMethodBeat.i(105835);
    EZf = new a();
    AppMethodBeat.o(105835);
  }
  
  public static void a(j paramj)
  {
    AppMethodBeat.i(105834);
    k.h(paramj, "emojiCallback");
    EZe = null;
    c localc = new c(ChatFooterPanel.BUU);
    EZe = localc;
    localc.fPO = paramj;
    AppMethodBeat.o(105834);
  }
  
  public static void destroy()
  {
    c localc = EZe;
    if (localc != null) {
      localc.fPO = null;
    }
    EZe = null;
  }
  
  public static c eHv()
  {
    return EZe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.a.a
 * JD-Core Version:    0.7.0.1
 */