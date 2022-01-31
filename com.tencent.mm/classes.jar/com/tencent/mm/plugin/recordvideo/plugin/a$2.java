package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin$2", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-recordvideo_release"})
public final class a$2
  implements t.a
{
  public final void a(k paramk)
  {
    AppMethodBeat.i(150584);
    j.q(paramk, "emojiInfo");
    ab.i("MicroMsg.EditorVideoPluginLayoutNew", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramk });
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("PARAM_EDIT_EMOJI_INFO", (Parcelable)paramk);
    this.qbJ.qbI.a(d.c.qex, localBundle);
    onHide();
    AppMethodBeat.o(150584);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(150585);
    a.a(this.qbJ).setShow(false);
    AppMethodBeat.o(150585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a.2
 * JD-Core Version:    0.7.0.1
 */