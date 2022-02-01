package com.tencent.mm.plugin.story.ui.album;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryFavoritePanel$e$d
  implements View.OnClickListener
{
  StoryFavoritePanel$e$d(RecyclerView.v paramv) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119888);
    if (!((StoryFavoritePanel.d)this.qwC).ysv.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      ((StoryFavoritePanel.d)this.qwC).ysv.setChecked(bool);
      AppMethodBeat.o(119888);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.e.d
 * JD-Core Version:    0.7.0.1
 */