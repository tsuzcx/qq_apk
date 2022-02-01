package com.tencent.mm.plugin.textstatus.ui;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$handleDeleteOrClear$2", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "p0", "onTouchEvent", "p1", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusLikeListFragment$h
  implements RecyclerView.k
{
  TextStatusLikeListFragment$h(TextStatusLikeListFragment paramTextStatusLikeListFragment) {}
  
  public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(291431);
    s.u(paramRecyclerView, "rv");
    s.u(paramMotionEvent, "motionEvent");
    TextStatusLikeListFragment.c(this.TzB)[0] = ((int)paramMotionEvent.getRawX());
    TextStatusLikeListFragment.c(this.TzB)[1] = ((int)paramMotionEvent.getRawY());
    AppMethodBeat.o(291431);
    return false;
  }
  
  public final void aX(boolean paramBoolean) {}
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(291421);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$handleDeleteOrClear$2", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aYj());
    s.u(paramRecyclerView, "p0");
    s.u(paramMotionEvent, "p1");
    a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$handleDeleteOrClear$2", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(291421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListFragment.h
 * JD-Core Version:    0.7.0.1
 */