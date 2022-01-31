package com.tencent.mm.plugin.story.ui.album;

import a.l;
import android.support.v7.widget.GridLayoutManager.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$init$1", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-story_release"})
public final class StoryFavoritePanel$h
  extends GridLayoutManager.b
{
  public final int bF(int paramInt)
  {
    AppMethodBeat.i(138884);
    if (StoryFavoritePanel.e(this.sJT).getItemViewType(paramInt) == StoryFavoritePanel.b(this.sJT))
    {
      paramInt = StoryFavoritePanel.f(this.sJT);
      AppMethodBeat.o(138884);
      return paramInt;
    }
    AppMethodBeat.o(138884);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel.h
 * JD-Core Version:    0.7.0.1
 */