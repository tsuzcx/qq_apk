package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/editor/EditorAudioSearchView$init$5", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "plugin-story_release"})
public final class EditorAudioSearchView$g
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(110480);
    int i;
    if (paramEditable != null) {
      i = paramEditable.length();
    }
    while (i > 0)
    {
      paramEditable = EditorAudioSearchView.g(this.sOb);
      if (paramEditable != null)
      {
        paramEditable.setVisibility(0);
        AppMethodBeat.o(110480);
        return;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(110480);
        return;
      }
    }
    paramEditable = EditorAudioSearchView.g(this.sOb);
    if (paramEditable != null)
    {
      paramEditable.setVisibility(8);
      AppMethodBeat.o(110480);
      return;
    }
    AppMethodBeat.o(110480);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView.g
 * JD-Core Version:    0.7.0.1
 */