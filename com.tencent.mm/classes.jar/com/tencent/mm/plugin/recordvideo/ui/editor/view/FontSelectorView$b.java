package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$1$1"})
final class FontSelectorView$b
  implements View.OnClickListener
{
  FontSelectorView$b(FontSelectorView paramFontSelectorView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(224449);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    localObject = this.IeB;
    p.j(paramView, "it");
    paramView = paramView.getTag();
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(224449);
      throw paramView;
    }
    FontSelectorView.a((FontSelectorView)localObject, ((Integer)paramView).intValue());
    a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(224449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.view.FontSelectorView.b
 * JD-Core Version:    0.7.0.1
 */