package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorInputView$6
  implements View.OnClickListener
{
  EditorInputView$6(EditorInputView paramEditorInputView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151214);
    if (!this.sPp.getConfirm().isEnabled())
    {
      AppMethodBeat.o(151214);
      return;
    }
    int i = EditorInputView.e(this.sPp);
    paramView = EditorInputView.sPo;
    EditorInputView.a locala;
    if (i == EditorInputView.cFJ())
    {
      paramView = EditorInputView.f(this.sPp).getText();
      locala = this.sPp.getCallback();
      if (locala != null) {
        locala.a((CharSequence)paramView, EditorInputView.g(this.sPp), EditorInputView.h(this.sPp), EditorInputView.e(this.sPp));
      }
      EditorInputView.f(this.sPp).clearFocus();
      AppMethodBeat.o(151214);
      return;
    }
    i = EditorInputView.e(this.sPp);
    paramView = EditorInputView.sPo;
    if (i == EditorInputView.cFK())
    {
      paramView = EditorInputView.b(this.sPp).getText();
      locala = this.sPp.getCallback();
      if (locala != null) {
        locala.a((CharSequence)paramView, -1, 0, EditorInputView.e(this.sPp));
      }
      EditorInputView.b(this.sPp).clearFocus();
    }
    AppMethodBeat.o(151214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorInputView.6
 * JD-Core Version:    0.7.0.1
 */