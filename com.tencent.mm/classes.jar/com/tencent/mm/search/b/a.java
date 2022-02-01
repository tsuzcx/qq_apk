package com.tencent.mm.search.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/search/logic/SimilarEmojiListenerInstance;", "", "()V", "listener", "Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "create", "", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "destroy", "getInstance", "plugin-emojisdk_release"})
public final class a
{
  private static c UWS;
  public static final a UWT;
  
  static
  {
    AppMethodBeat.i(105835);
    UWT = new a();
    AppMethodBeat.o(105835);
  }
  
  public static void a(j paramj)
  {
    AppMethodBeat.i(105834);
    p.k(paramj, "emojiCallback");
    UWS = null;
    c localc = new c(ChatFooterPanel.Rch);
    UWS = localc;
    localc.jLH = paramj;
    AppMethodBeat.o(105834);
  }
  
  public static void destroy()
  {
    c localc = UWS;
    if (localc != null) {
      localc.jLH = null;
    }
    UWS = null;
  }
  
  public static c hto()
  {
    return UWS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.b.a
 * JD-Core Version:    0.7.0.1
 */