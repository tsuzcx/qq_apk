package com.tencent.mm.search.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.j;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/search/logic/SimilarEmojiListenerInstance;", "", "()V", "listener", "Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "create", "", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "destroy", "getInstance", "plugin-emojisdk_release"})
public final class a
{
  private static c ICx;
  public static final a ICy;
  
  static
  {
    AppMethodBeat.i(105835);
    ICy = new a();
    AppMethodBeat.o(105835);
  }
  
  public static void a(j paramj)
  {
    AppMethodBeat.i(105834);
    p.h(paramj, "emojiCallback");
    ICx = null;
    c localc = new c(ChatFooterPanel.FkK);
    ICx = localc;
    localc.gpJ = paramj;
    AppMethodBeat.o(105834);
  }
  
  public static void destroy()
  {
    c localc = ICx;
    if (localc != null) {
      localc.gpJ = null;
    }
    ICx = null;
  }
  
  public static c fqv()
  {
    return ICx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.b.a
 * JD-Core Version:    0.7.0.1
 */