package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
final class a$d
  extends q
  implements kotlin.g.a.a<LinearLayout>
{
  a$d(a parama, Context paramContext)
  {
    super(0);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(a.d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237579);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.CaI.CaH.getParent();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(237579);
        throw paramView;
      }
      ((ViewGroup)paramView).removeView((View)this.CaI.CaH);
      paramView = this.CaI.CaH.getClearCaptionListener();
      if (paramView != null) {
        paramView.invoke(this.CaI.CaH);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237579);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.a.d
 * JD-Core Version:    0.7.0.1
 */