package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorAudioSearchView$c
  implements View.OnClickListener
{
  EditorAudioSearchView$c(EditorAudioSearchView paramEditorAudioSearchView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75905);
    paramView = EditorAudioSearchView.a(this.vqD);
    if (paramView != null)
    {
      paramView = paramView.getText();
      if (paramView != null)
      {
        if (((CharSequence)paramView).length() == 0) {}
        for (int i = 1; i == 0; i = 0)
        {
          paramView = EditorAudioSearchView.a(this.vqD);
          if (paramView == null) {
            break;
          }
          paramView.setText(null);
          AppMethodBeat.o(75905);
          return;
        }
      }
    }
    AppMethodBeat.o(75905);
    return;
    AppMethodBeat.o(75905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView.c
 * JD-Core Version:    0.7.0.1
 */