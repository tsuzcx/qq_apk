package com.tencent.mm.plugin.story.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.io.File;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StorySettingsUI$aa
  implements View.OnClickListener
{
  StorySettingsUI$aa(StorySettingsUI paramStorySettingsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(178050);
    try
    {
      paramView = this.zDI.getContext();
      k.g(paramView, "context");
      paramView = paramView.getExternalCacheDir().toString();
      i.deleteDir(paramView + "/imgcache");
      AppMethodBeat.o(178050);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(178050);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.aa
 * JD-Core Version:    0.7.0.1
 */