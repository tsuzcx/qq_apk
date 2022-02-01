package com.tencent.mm.plugin.mv.ui.uic;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC$ItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC;)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvAlbumPreviewSelectedUIC$b
  extends RecyclerView.h
{
  public MusicMvAlbumPreviewSelectedUIC$b()
  {
    AppMethodBeat.i(287596);
    AppMethodBeat.o(287596);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(287607);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    int i = a.fromDPToPix(MMApplicationContext.getContext(), 6);
    paramRect.set(i, 0, i, 0);
    AppMethodBeat.o(287607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvAlbumPreviewSelectedUIC.b
 * JD-Core Version:    0.7.0.1
 */