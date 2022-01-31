package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.y.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$1", "Lcom/tencent/mm/presenter/DrawingPresenter$onTextChangeListener;", "onTextChange", "", "item", "Lcom/tencent/mm/items/TextItem;", "onTextMove", "", "isMoving", "plugin-recordvideo_release"})
public final class f$c
  implements a.c
{
  public final boolean b(e parame)
  {
    AppMethodBeat.i(150618);
    j.q(parame, "item");
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)parame.eFO);
    localBundle.putInt("PARAM_EDIT_TEXT_COLOR", parame.mColor);
    localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", parame.mBgColor);
    this.qbZ.qbI.a(d.c.qez, localBundle);
    AppMethodBeat.o(150618);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.f.c
 * JD-Core Version:    0.7.0.1
 */