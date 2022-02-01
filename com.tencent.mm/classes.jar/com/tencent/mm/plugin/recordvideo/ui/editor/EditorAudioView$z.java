package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-recordvideo_release"})
public final class EditorAudioView$z
  extends RecyclerView.l
{
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(75950);
    Object localObject = new b();
    ((b)localObject).bm(paramRecyclerView);
    ((b)localObject).pH(paramInt);
    a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((b)localObject).axR());
    p.h(paramRecyclerView, "recyclerView");
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(75950);
        throw paramRecyclerView;
      }
      localObject = (LinearLayoutManager)localObject;
      paramInt = ((LinearLayoutManager)localObject).kv();
      RecyclerView.a locala = paramRecyclerView.getAdapter();
      if (locala == null) {
        p.hyc();
      }
      p.g(locala, "recyclerView.adapter!!");
      if (paramInt != locala.getItemCount() - 1) {
        break label174;
      }
      localObject = this.Ccs;
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView == null) {
        p.hyc();
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
      paramInt = ((LinearLayoutManager)localObject).ks();
      paramInt = (((LinearLayoutManager)localObject).ku() + paramInt) / 2;
      EditorAudioView.a(this.Ccs, paramInt);
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237646);
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt1);
    localb.pH(paramInt2);
    a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    AppMethodBeat.o(237646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.z
 * JD-Core Version:    0.7.0.1
 */