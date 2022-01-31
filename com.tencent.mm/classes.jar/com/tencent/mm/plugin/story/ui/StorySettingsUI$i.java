package com.tencent.mm.plugin.story.ui;

import a.f.a.a;
import a.l;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$12", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
public final class StorySettingsUI$i
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110054);
    paramView = this.sHQ;
    Context localContext = (Context)this.sHQ.getContext();
    this.sHQ.getString(2131297087);
    StorySettingsUI.a(paramView, h.b(localContext, this.sHQ.getString(2131297112), true, (DialogInterface.OnCancelListener)new StorySettingsUI.i.a(this)));
    b.a("cpfiles", (a)new StorySettingsUI.i.b(this));
    AppMethodBeat.o(110054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.i
 * JD-Core Version:    0.7.0.1
 */