package com.tencent.mm.search.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.j;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/search/logic/SimilarEmojiListenerInstance;", "", "()V", "listener", "Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "create", "", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "destroy", "getInstance", "plugin-emojisdk_release"})
public final class a
{
  private static c Gws;
  public static final a Gwt;
  
  static
  {
    AppMethodBeat.i(105835);
    Gwt = new a();
    AppMethodBeat.o(105835);
  }
  
  public static void a(j paramj)
  {
    AppMethodBeat.i(105834);
    k.h(paramj, "emojiCallback");
    Gws = null;
    c localc = new c(ChatFooterPanel.Dnk);
    Gws = localc;
    localc.fTJ = paramj;
    AppMethodBeat.o(105834);
  }
  
  public static void destroy()
  {
    c localc = Gws;
    if (localc != null) {
      localc.fTJ = null;
    }
    Gws = null;
  }
  
  public static c eWQ()
  {
    return Gws;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.b.a
 * JD-Core Version:    0.7.0.1
 */