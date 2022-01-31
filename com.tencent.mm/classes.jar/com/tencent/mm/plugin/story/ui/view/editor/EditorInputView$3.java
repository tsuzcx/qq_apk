package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMTextView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/editor/EditorInputView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-story_release"})
public final class EditorInputView$3
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(151213);
    if (paramEditable != null)
    {
      int i = ((CharSequence)paramEditable).length();
      i = EditorInputView.a(this.sPp) - i;
      paramEditable = this.sPp.getConfirm();
      if ((i >= 0) && (EditorInputView.b(this.sPp).getLineCount() <= EditorInputView.c(this.sPp))) {}
      for (boolean bool = true;; bool = false)
      {
        paramEditable.setEnabled(bool);
        if (i >= 0) {
          break;
        }
        EditorInputView.d(this.sPp).setVisibility(0);
        EditorInputView.d(this.sPp).setText((CharSequence)String.valueOf(i));
        AppMethodBeat.o(151213);
        return;
      }
      EditorInputView.d(this.sPp).setVisibility(8);
      AppMethodBeat.o(151213);
      return;
    }
    EditorInputView.d(this.sPp).setVisibility(8);
    AppMethodBeat.o(151213);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorInputView.3
 * JD-Core Version:    0.7.0.1
 */