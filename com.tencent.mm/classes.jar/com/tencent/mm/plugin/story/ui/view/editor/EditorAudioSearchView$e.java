package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bm;
import com.tencent.mm.plugin.story.model.audio.c;
import com.tencent.mm.plugin.story.model.audio.c.a;
import com.tencent.mm.plugin.story.ui.a.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorAudioSearchView$e
  implements View.OnClickListener
{
  EditorAudioSearchView$e(EditorAudioSearchView paramEditorAudioSearchView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110478);
    paramView = EditorAudioSearchView.c(this.sOb);
    if (paramView != null)
    {
      if ((EditorAudioSearchView.d(this.sOb) == -1) || (EditorAudioSearchView.d(this.sOb) >= paramView.getItemCount())) {
        break label126;
      }
      EditorAudioSearchView.a locala = this.sOb.getCallback();
      if (locala != null) {
        locala.d(paramView.Gd(EditorAudioSearchView.d(this.sOb)));
      }
      EditorAudioSearchView.f(this.sOb);
      paramView = c.swQ;
      c.cBD().dI(0L);
      paramView = c.swQ;
      c.a.cBE();
    }
    for (;;)
    {
      this.sOb.reset();
      paramView = EditorAudioSearchView.a(this.sOb);
      if (paramView == null) {
        break;
      }
      paramView.clearFocus();
      AppMethodBeat.o(110478);
      return;
      label126:
      paramView = this.sOb.getCallback();
      if (paramView != null) {
        paramView.d(null);
      }
      EditorAudioSearchView.f(this.sOb);
      paramView = c.swQ;
      c.cBD().dI(1L);
      paramView = c.swQ;
      c.a.cBE();
    }
    AppMethodBeat.o(110478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView.e
 * JD-Core Version:    0.7.0.1
 */