package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.q;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
final class a$d
  extends q
  implements d.g.a.a<LinearLayout>
{
  a$d(a parama, Context paramContext)
  {
    super(0);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(a.d paramd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200497);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.xJO.xJN.getParent();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(200497);
        throw paramView;
      }
      ((ViewGroup)paramView).removeView((View)this.xJO.xJN);
      paramView = this.xJO.xJN.getClearCaptionListener();
      if (paramView != null) {
        paramView.invoke(this.xJO.xJN);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200497);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.a.d
 * JD-Core Version:    0.7.0.1
 */