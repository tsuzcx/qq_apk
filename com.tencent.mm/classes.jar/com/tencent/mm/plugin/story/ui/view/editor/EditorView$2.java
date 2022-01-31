package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.story.d.b.a;
import com.tencent.mm.plugin.story.g.f;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorView$2
  implements View.OnClickListener
{
  EditorView$2(EditorView paramEditorView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151222);
    if (System.currentTimeMillis() - EditorView.l(this.sQi) <= EditorView.k(this.sQi))
    {
      ab.i(EditorView.b(this.sQi), "onclick pass " + EditorView.l(this.sQi) + " now: " + System.currentTimeMillis() + " notifySns:" + EditorView.m(this.sQi));
      AppMethodBeat.o(151222);
      return;
    }
    EditorView.e(this.sQi);
    paramView = new a("mixView");
    EditorView.a(this.sQi, System.currentTimeMillis());
    this.sQi.getPresenter().czM();
    this.sQi.getPresenter().bnC();
    EditorView.a(this.sQi, EditorView.n(this.sQi));
    f localf = f.sEx;
    f.lZ(EditorView.o(this.sQi));
    localf = f.sEx;
    f.mb(EditorView.m(this.sQi));
    ab.i(EditorView.b(this.sQi), "onclick " + paramView.eMo.Mm());
    AppMethodBeat.o(151222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView.2
 * JD-Core Version:    0.7.0.1
 */