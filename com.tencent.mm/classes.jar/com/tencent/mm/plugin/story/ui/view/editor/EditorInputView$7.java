package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorInputView$7
  implements View.OnClickListener
{
  EditorInputView$7(EditorInputView paramEditorInputView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151215);
    paramView = EditorInputView.i(this.sPp);
    if (!EditorInputView.i(this.sPp).isActivated()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setActivated(bool);
      this.sPp.setHasBackground(EditorInputView.i(this.sPp).isActivated());
      EditorInputView.j(this.sPp);
      AppMethodBeat.o(151215);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorInputView.7
 * JD-Core Version:    0.7.0.1
 */