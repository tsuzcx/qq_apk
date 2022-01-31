package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.editor.item.g;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorView$12
  implements View.OnClickListener
{
  EditorView$12(EditorView paramEditorView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110578);
    Object localObject1 = this.sQi;
    if (!(paramView instanceof g)) {
      paramView = null;
    }
    for (;;)
    {
      EditorView.a((EditorView)localObject1, (g)paramView);
      Object localObject2 = EditorView.j(this.sQi);
      if (localObject2 != null)
      {
        ((g)localObject2).setVisibility(8);
        paramView = this.sQi;
        localObject1 = ((g)localObject2).getText();
        int i = ((g)localObject2).getColor();
        int j = ((g)localObject2).getTextBg();
        localObject2 = EditorInputView.sPo;
        paramView.a(true, (CharSequence)localObject1, i, j, EditorInputView.cFJ());
        AppMethodBeat.o(110578);
        return;
      }
      AppMethodBeat.o(110578);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView.12
 * JD-Core Version:    0.7.0.1
 */