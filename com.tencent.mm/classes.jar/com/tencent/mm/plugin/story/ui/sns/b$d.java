package com.tencent.mm.plugin.story.ui.sns;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$d
  implements View.OnClickListener
{
  b$d(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119943);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$wrapSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = this.Bpg.Bpd;
    if (paramView != null) {
      paramView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryBigMouthGuideDialog$wrapSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(119943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.b.d
 * JD-Core Version:    0.7.0.1
 */