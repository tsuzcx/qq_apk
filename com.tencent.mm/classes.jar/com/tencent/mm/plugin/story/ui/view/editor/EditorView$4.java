package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.a.a;
import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorView$4
  implements View.OnClickListener
{
  EditorView$4(EditorView paramEditorView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151226);
    paramView = EditorView.p(this.sQi);
    if (paramView != null) {
      paramView.dismiss();
    }
    EditorView.a(this.sQi, new c(this.hEq));
    paramView = EditorView.p(this.sQi);
    if (paramView != null) {
      paramView.sPy = EditorView.m(this.sQi);
    }
    paramView = EditorView.p(this.sQi);
    if (paramView != null) {
      paramView.sAB = EditorView.o(this.sQi);
    }
    paramView = EditorView.p(this.sQi);
    if (paramView != null) {
      paramView.sPx = ((a)new EditorView.4.1(this));
    }
    paramView = EditorView.p(this.sQi);
    if (paramView != null) {
      paramView.sPw = ((a)new EditorView.4.2(this));
    }
    paramView = EditorView.p(this.sQi);
    if (paramView != null)
    {
      paramView.show();
      AppMethodBeat.o(151226);
      return;
    }
    AppMethodBeat.o(151226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView.4
 * JD-Core Version:    0.7.0.1
 */