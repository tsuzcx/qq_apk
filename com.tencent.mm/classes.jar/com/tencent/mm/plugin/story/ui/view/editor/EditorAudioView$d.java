package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.b.j;
import a.l;
import a.v;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-story_release"})
public final class EditorAudioView$d
  extends RecyclerView.m
{
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(110518);
    j.q(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      Object localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(110518);
        throw paramRecyclerView;
      }
      localObject = (LinearLayoutManager)localObject;
      paramInt = ((LinearLayoutManager)localObject).iw();
      RecyclerView.a locala = paramRecyclerView.getAdapter();
      j.p(locala, "recyclerView.adapter");
      if (paramInt == locala.getItemCount() - 1)
      {
        localObject = this.sOy;
        paramRecyclerView = paramRecyclerView.getAdapter();
        j.p(paramRecyclerView, "recyclerView.adapter");
        ((EditorAudioView)localObject).Gg(paramRecyclerView.getItemCount() - 1);
        AppMethodBeat.o(110518);
        return;
      }
      paramInt = ((LinearLayoutManager)localObject).it();
      paramInt = (((LinearLayoutManager)localObject).iv() + paramInt) / 2;
      this.sOy.Gg(paramInt);
    }
    AppMethodBeat.o(110518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorAudioView.d
 * JD-Core Version:    0.7.0.1
 */