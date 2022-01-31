package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.editor.item.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorView$13
  implements View.OnClickListener
{
  EditorView$13(EditorView paramEditorView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110579);
    if (!(paramView instanceof h)) {
      paramView = null;
    }
    for (;;)
    {
      Object localObject = (h)paramView;
      if (localObject != null)
      {
        ((h)localObject).setVisibility(8);
        paramView = this.sQi;
        CharSequence localCharSequence = ((h)localObject).getText();
        int i = ((h)localObject).getColor();
        int j = ((h)localObject).getTextBg();
        localObject = EditorInputView.sPo;
        paramView.a(true, localCharSequence, i, j, EditorInputView.cFK());
        AppMethodBeat.o(110579);
        return;
      }
      AppMethodBeat.o(110579);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView.13
 * JD-Core Version:    0.7.0.1
 */