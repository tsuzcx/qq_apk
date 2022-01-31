package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorInputView$4
  implements View.OnClickListener
{
  EditorInputView$4(EditorInputView paramEditorInputView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110553);
    paramView = this.sPp;
    EditorInputView.a locala = paramView.sPg;
    if (locala != null) {
      locala.Cp(paramView.mode);
    }
    paramView.sOU.clearFocus();
    paramView.sPa.clearFocus();
    AppMethodBeat.o(110553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorInputView.4
 * JD-Core Version:    0.7.0.1
 */