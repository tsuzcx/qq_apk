package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.ui.sns.c;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryHeaderTipView$3$a
  implements View.OnClickListener
{
  StoryHeaderTipView$3$a(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(120186);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3$entranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.AZq.cancel();
    a.a(this, "com/tencent/mm/plugin/story/ui/view/StoryHeaderTipView$3$entranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(120186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryHeaderTipView.3.a
 * JD-Core Version:    0.7.0.1
 */