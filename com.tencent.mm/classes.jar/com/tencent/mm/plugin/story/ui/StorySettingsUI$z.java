package com.tencent.mm.plugin.story.ui;

import a.f.b.k;
import a.l;
import a.y;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
public final class StorySettingsUI$z
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110072);
    paramView = com.tencent.mm.plugin.story.model.f.a.szc;
    com.tencent.mm.plugin.story.model.f.a.cBQ();
    b.a(5000L, (a.f.a.a)a.sIb);
    AppMethodBeat.o(110072);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class a
    extends k
    implements a.f.a.a<y>
  {
    public static final a sIb;
    
    static
    {
      AppMethodBeat.i(155330);
      sIb = new a();
      AppMethodBeat.o(155330);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.z
 * JD-Core Version:    0.7.0.1
 */