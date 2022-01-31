package com.tencent.mm.plugin.story;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.sns.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class PluginStory$d
  implements View.OnClickListener
{
  PluginStory$d(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108911);
    this.sqF.cancel();
    AppMethodBeat.o(108911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.PluginStory.d
 * JD-Core Version:    0.7.0.1
 */