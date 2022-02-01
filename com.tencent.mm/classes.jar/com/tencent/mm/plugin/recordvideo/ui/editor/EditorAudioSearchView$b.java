package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$5", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditorAudioSearchView$b
  implements TextWatcher
{
  EditorAudioSearchView$b(EditorAudioSearchView paramEditorAudioSearchView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(75909);
    if (paramEditable == null) {}
    for (int i = 0; i > 0; i = paramEditable.length())
    {
      paramEditable = EditorAudioSearchView.b(this.NUC);
      if (paramEditable == null) {
        break label66;
      }
      paramEditable.setVisibility(0);
      AppMethodBeat.o(75909);
      return;
    }
    paramEditable = EditorAudioSearchView.b(this.NUC);
    if (paramEditable != null) {
      paramEditable.setVisibility(8);
    }
    label66:
    AppMethodBeat.o(75909);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView.b
 * JD-Core Version:    0.7.0.1
 */