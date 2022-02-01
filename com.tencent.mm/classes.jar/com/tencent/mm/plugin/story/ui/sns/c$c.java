package com.tencent.mm.plugin.story.ui.sns;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$c
  implements View.OnClickListener
{
  c$c(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119953);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (this.FzV.isShowing()) {
      this.FzV.cancel();
    }
    a.a(this, "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(119953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.c.c
 * JD-Core Version:    0.7.0.1
 */