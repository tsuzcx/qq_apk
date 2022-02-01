package com.tencent.mm.plugin.story.ui.sns;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$c
  implements View.OnClickListener
{
  b$c(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119942);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (this.AXI.isShowing()) {
      this.AXI.cancel();
    }
    a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(119942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.b.c
 * JD-Core Version:    0.7.0.1
 */