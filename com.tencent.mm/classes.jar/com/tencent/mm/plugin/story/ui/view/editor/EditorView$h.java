package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t.a;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/editor/EditorView$initSmileyPanel$2", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-story_release"})
public final class EditorView$h
  implements t.a
{
  public final void a(k paramk)
  {
    AppMethodBeat.i(110587);
    j.q(paramk, "emojiInfo");
    ab.i(EditorView.b(this.sQi), "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramk });
    EditorView.c(this.sQi).D((EmojiInfo)paramk);
    onHide();
    AppMethodBeat.o(110587);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(110588);
    this.sQi.gT(false);
    AppMethodBeat.o(110588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView.h
 * JD-Core Version:    0.7.0.1
 */