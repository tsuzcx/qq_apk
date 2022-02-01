package com.tencent.mm.plugin.vlog.ui.thumb;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.q;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$onFinishInflate$3", "Landroid/support/v7/widget/RecyclerView$SimpleOnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroid/support/v7/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "plugin-vlog_release"})
public final class MultiTrackCropView$d
  extends RecyclerView.q
{
  public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192101);
    p.h(paramRecyclerView, "rv");
    p.h(paramMotionEvent, "e");
    AppMethodBeat.o(192101);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView.d
 * JD-Core Version:    0.7.0.1
 */