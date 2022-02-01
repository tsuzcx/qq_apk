package com.tencent.mm.search.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/search/logic/SimilarEmojiListenerInstance;", "", "()V", "listener", "Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "create", "", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "destroy", "getInstance", "plugin-emojisdk_release"})
public final class a
{
  private static c NJr;
  public static final a NJs;
  
  static
  {
    AppMethodBeat.i(105835);
    NJs = new a();
    AppMethodBeat.o(105835);
  }
  
  public static void a(j paramj)
  {
    AppMethodBeat.i(105834);
    p.h(paramj, "emojiCallback");
    NJr = null;
    c localc = new c(ChatFooterPanel.KbC);
    NJr = localc;
    localc.haC = paramj;
    AppMethodBeat.o(105834);
  }
  
  public static void destroy()
  {
    c localc = NJr;
    if (localc != null) {
      localc.haC = null;
    }
    NJr = null;
  }
  
  public static c gxq()
  {
    return NJr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.search.b.a
 * JD-Core Version:    0.7.0.1
 */