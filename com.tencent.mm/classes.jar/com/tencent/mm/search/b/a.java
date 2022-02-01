package com.tencent.mm.search.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/search/logic/SimilarEmojiListenerInstance;", "", "()V", "listener", "Lcom/tencent/mm/search/logic/SosSimilarEmojiPanelClickListener;", "create", "", "emojiCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "destroy", "getInstance", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a acse;
  private static c acsf;
  
  static
  {
    AppMethodBeat.i(105835);
    acse = new a();
    AppMethodBeat.o(105835);
  }
  
  public static void a(j paramj)
  {
    AppMethodBeat.i(105834);
    s.u(paramj, "emojiCallback");
    acsf = null;
    c localc = new c(ChatFooterPanel.XYm);
    acsf = localc;
    localc.mkP = paramj;
    AppMethodBeat.o(105834);
  }
  
  public static void destroy()
  {
    c localc = acsf;
    if (localc != null) {
      localc.mkP = null;
    }
    acsf = null;
  }
  
  public static c iTv()
  {
    return acsf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.search.b.a
 * JD-Core Version:    0.7.0.1
 */