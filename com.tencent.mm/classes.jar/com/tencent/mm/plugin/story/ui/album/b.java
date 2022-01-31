package com.tencent.mm.plugin.story.ui.album;

import a.l;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumGridDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-story_release"})
public final class b
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(110157);
    super.a(paramRect, paramView, paramRecyclerView, params);
    if (paramRecyclerView != null) {}
    for (paramView = paramRecyclerView.getContext();; paramView = null)
    {
      int i = a.ap(paramView, 2131427496);
      if (paramRect == null) {
        break;
      }
      paramRect.set(i, i, i, i);
      AppMethodBeat.o(110157);
      return;
    }
    AppMethodBeat.o(110157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.b
 * JD-Core Version:    0.7.0.1
 */