package com.tencent.mm.plugin.sns.ui.picker;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerGridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mHorizonSpan", "", "mVerticalSpan", "mDividerColor", "mShowLastLine", "", "mIgnoreItemViewTypeSet", "", "(IIIZLjava/util/Set;)V", "mDivider", "Landroid/graphics/drawable/Drawable;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "Builder", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.h
{
  public static final b RRm;
  private final boolean HNS;
  private final int HNT;
  private final int HNU;
  private final Set<Integer> RRn;
  private Drawable tP;
  private final int uOk;
  
  static
  {
    AppMethodBeat.i(308767);
    RRm = new b((byte)0);
    AppMethodBeat.o(308767);
  }
  
  public b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, Set<Integer> paramSet)
  {
    AppMethodBeat.i(308752);
    this.HNT = paramInt1;
    this.HNU = paramInt2;
    this.uOk = paramInt3;
    this.HNS = paramBoolean;
    this.RRn = paramSet;
    this.tP = ((Drawable)new ColorDrawable(this.uOk));
    AppMethodBeat.o(308752);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(308779);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    if (paramRecyclerView.getAdapter() != null)
    {
      params = paramRecyclerView.getAdapter();
      s.checkNotNull(params);
    }
    for (int i = params.getItemCount();; i = 0)
    {
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        AppMethodBeat.o(308779);
        throw paramRect;
      }
      int j = ((RecyclerView.LayoutParams)paramView).bXh.KI();
      if ((j < 0) || (i <= 0))
      {
        AppMethodBeat.o(308779);
        return;
      }
      if (paramRecyclerView.getAdapter() != null)
      {
        paramView = paramRecyclerView.getAdapter();
        s.checkNotNull(paramView);
      }
      for (i = paramView.getItemViewType(j);; i = -1)
      {
        if ((i == -1) || (this.RRn.contains(Integer.valueOf(i))))
        {
          paramRect.set(0, 0, 0, 0);
          AppMethodBeat.o(308779);
          return;
        }
        i = this.HNT / 2;
        j = this.HNT / 2;
        paramRect.set(i, this.HNU / 2, j, this.HNU / 2);
        AppMethodBeat.o(308779);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerGridItemDecoration$Companion;", "", "()V", "TAG", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.picker.b
 * JD-Core Version:    0.7.0.1
 */