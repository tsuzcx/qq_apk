package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-recordvideo_release"})
public final class EditorAudioView$y
  extends RecyclerView.m
{
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200563);
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt1);
    localb.mr(paramInt2);
    a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(200563);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(75950);
    Object localObject = new b();
    ((b)localObject).bd(paramRecyclerView);
    ((b)localObject).mr(paramInt);
    a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((b)localObject).ahq());
    p.h(paramRecyclerView, "recyclerView");
    super.b(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(75950);
        throw paramRecyclerView;
      }
      localObject = (LinearLayoutManager)localObject;
      paramInt = ((LinearLayoutManager)localObject).kp();
      RecyclerView.a locala = paramRecyclerView.getAdapter();
      if (locala == null) {
        p.gfZ();
      }
      p.g(locala, "recyclerView.adapter!!");
      if (paramInt != locala.getItemCount() - 1) {
        break label174;
      }
      localObject = this.xLw;
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView == null) {
        p.gfZ();
      }
      p.g(paramRecyclerView, "recyclerView.adapter!!");
      EditorAudioView.a((EditorAudioView)localObject, paramRecyclerView.getItemCount() - 1);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(75950);
      return;
      label174:
      paramInt = ((LinearLayoutManager)localObject).km();
      paramInt = (((LinearLayoutManager)localObject).ko() + paramInt) / 2;
      EditorAudioView.a(this.xLw, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.y
 * JD-Core Version:    0.7.0.1
 */