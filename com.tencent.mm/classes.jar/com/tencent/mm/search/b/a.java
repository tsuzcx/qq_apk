package com.tencent.mm.search.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.j;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/search/logic/SimilarEmojiListenerInstance;", "", "()V", "listener", "Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "create", "", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "destroy", "getInstance", "plugin-emojisdk_release"})
public final class a
{
  private static c Iim;
  public static final a Iin;
  
  static
  {
    AppMethodBeat.i(105835);
    Iin = new a();
    AppMethodBeat.o(105835);
  }
  
  public static void a(j paramj)
  {
    AppMethodBeat.i(105834);
    p.h(paramj, "emojiCallback");
    Iim = null;
    c localc = new c(ChatFooterPanel.ESp);
    Iim = localc;
    localc.gnn = paramj;
    AppMethodBeat.o(105834);
  }
  
  public static void destroy()
  {
    c localc = Iim;
    if (localc != null) {
      localc.gnn = null;
    }
    Iim = null;
  }
  
  public static c fmA()
  {
    return Iim;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.search.b.a
 * JD-Core Version:    0.7.0.1
 */