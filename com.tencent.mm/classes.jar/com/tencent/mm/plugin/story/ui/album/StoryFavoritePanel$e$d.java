package com.tencent.mm.plugin.story.ui.album;

import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryFavoritePanel$e$d
  implements View.OnClickListener
{
  StoryFavoritePanel$e$d(RecyclerView.v paramv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151147);
    if (!((StoryFavoritePanel.d)this.sJW).sJU.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      ((StoryFavoritePanel.d)this.sJW).sJU.setChecked(bool);
      AppMethodBeat.o(151147);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.e.d
 * JD-Core Version:    0.7.0.1
 */