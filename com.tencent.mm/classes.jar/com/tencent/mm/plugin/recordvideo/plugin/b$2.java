package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.story.ui.view.editor.EditorInputView;
import com.tencent.mm.plugin.story.ui.view.editor.EditorInputView.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin$2", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView$AddTextCallback;", "onCancel", "", "textType", "", "onConfirm", "text", "", "color", "bgColor", "plugin-recordvideo_release"})
public final class b$2
  implements EditorInputView.a
{
  public final void Cp(int paramInt)
  {
    AppMethodBeat.i(150593);
    b.a(this.qbN).setShow(false);
    AppMethodBeat.o(150593);
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = 0;
    AppMethodBeat.i(150592);
    b.a(this.qbN).setShow(false);
    if (paramCharSequence != null)
    {
      if (paramCharSequence.length() == 0) {
        paramInt3 = 1;
      }
      if (paramInt3 == 0) {}
    }
    else
    {
      AppMethodBeat.o(150592);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", paramCharSequence);
    localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramInt1);
    localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramInt2);
    this.qbN.qbI.a(d.c.qey, localBundle);
    AppMethodBeat.o(150592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.b.2
 * JD-Core Version:    0.7.0.1
 */