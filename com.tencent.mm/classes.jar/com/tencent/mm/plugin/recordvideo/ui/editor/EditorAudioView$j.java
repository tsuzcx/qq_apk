package com.tencent.mm.plugin.recordvideo.ui.editor;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditorAudioView$j
  extends RecyclerView.l
{
  EditorAudioView$j(EditorAudioView paramEditorAudioView) {}
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(279812);
    Object localObject = new b();
    ((b)localObject).cH(paramRecyclerView);
    ((b)localObject).sc(paramInt);
    a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((b)localObject).aYj());
    s.u(paramRecyclerView, "recyclerView");
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(279812);
        throw paramRecyclerView;
      }
      localObject = (LinearLayoutManager)localObject;
      paramInt = ((LinearLayoutManager)localObject).Jx();
      RecyclerView.a locala = paramRecyclerView.getAdapter();
      s.checkNotNull(locala);
      if (paramInt != locala.getItemCount() - 1) {
        break label155;
      }
      localObject = this.NVs;
      paramRecyclerView = paramRecyclerView.getAdapter();
      s.checkNotNull(paramRecyclerView);
      EditorAudioView.a((EditorAudioView)localObject, paramRecyclerView.getItemCount() - 1);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(279812);
      return;
      label155:
      paramInt = ((LinearLayoutManager)localObject).Ju();
      paramInt = (((LinearLayoutManager)localObject).Jw() + paramInt) / 2;
      EditorAudioView.a(this.NVs, paramInt);
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(279817);
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(279817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.j
 * JD-Core Version:    0.7.0.1
 */