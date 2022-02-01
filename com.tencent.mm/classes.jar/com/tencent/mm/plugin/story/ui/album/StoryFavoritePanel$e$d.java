package com.tencent.mm.plugin.story.ui.album;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryFavoritePanel$e$d
  implements View.OnClickListener
{
  StoryFavoritePanel$e$d(RecyclerView.w paramw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119888);
    if (!((StoryFavoritePanel.d)this.rjq).zFS.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      ((StoryFavoritePanel.d)this.rjq).zFS.setChecked(bool);
      AppMethodBeat.o(119888);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.e.d
 * JD-Core Version:    0.7.0.1
 */