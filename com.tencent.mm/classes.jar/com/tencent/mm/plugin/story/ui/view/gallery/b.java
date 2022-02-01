package com.tencent.mm.plugin.story.ui.view.gallery;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "orientation", "", "(I)V", "bounds", "Landroid/graphics/Rect;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerSize", "getOrientation", "()I", "drawHorizontal", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "drawVertical", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Companion", "plugin-story_release"})
public final class b
  extends RecyclerView.h
{
  public static final a LYK;
  private final int FO;
  private int LYJ;
  private final Rect byi;
  private final Drawable nbH;
  
  static
  {
    AppMethodBeat.i(120329);
    LYK = new a((byte)0);
    AppMethodBeat.o(120329);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(120328);
    this.FO = paramInt;
    this.nbH = ((Drawable)new ColorDrawable(-16777216));
    this.byi = new Rect();
    this.LYJ = a.fromDPToPix(MMApplicationContext.getContext(), 16);
    AppMethodBeat.o(120328);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(228184);
    p.k(paramCanvas, "c");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    if (paramRecyclerView.getLayoutManager() == null)
    {
      AppMethodBeat.o(228184);
      return;
    }
    int j;
    int i;
    int n;
    int i1;
    if (this.FO == 1)
    {
      paramCanvas.save();
      if (paramRecyclerView.getClipToPadding())
      {
        j = paramRecyclerView.getPaddingLeft();
        i = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
        paramCanvas.clipRect(j, paramRecyclerView.getPaddingTop(), i, paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
      }
      for (;;)
      {
        m = paramRecyclerView.getChildCount();
        while (k < m)
        {
          params = paramRecyclerView.getChildAt(k);
          RecyclerView.getDecoratedBoundsWithMargins(params, this.byi);
          n = this.byi.bottom;
          p.j(params, "child");
          n = Math.round(params.getTranslationY()) + n;
          i1 = this.LYJ;
          this.nbH.setBounds(j, n - i1, i, n);
          this.nbH.draw(paramCanvas);
          k += 1;
        }
        i = paramRecyclerView.getWidth();
        j = 0;
      }
      paramCanvas.restore();
      AppMethodBeat.o(228184);
      return;
    }
    paramCanvas.save();
    if (paramRecyclerView.getClipToPadding())
    {
      j = paramRecyclerView.getPaddingTop();
      i = paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom();
      paramCanvas.clipRect(paramRecyclerView.getPaddingLeft(), j, paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight(), i);
    }
    for (;;)
    {
      n = paramRecyclerView.getChildCount();
      k = m;
      while (k < n)
      {
        params = paramRecyclerView.getChildAt(k);
        RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
        if (localLayoutManager != null) {
          localLayoutManager.getDecoratedBoundsWithMargins(params, this.byi);
        }
        m = this.byi.right;
        p.j(params, "child");
        m = Math.round(params.getTranslationX()) + m;
        i1 = this.LYJ;
        this.nbH.setBounds(m - i1, j, m, i);
        this.nbH.draw(paramCanvas);
        k += 1;
      }
      i = paramRecyclerView.getHeight();
      j = 0;
    }
    paramCanvas.restore();
    AppMethodBeat.o(228184);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(228190);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    params = paramRecyclerView.getLayoutManager();
    int i;
    if (params != null)
    {
      i = params.getPosition(paramView);
      paramView = paramRecyclerView.getLayoutManager();
      if (paramView == null) {
        break label81;
      }
    }
    label81:
    for (int j = paramView.getItemCount();; j = 0)
    {
      if (i >= 0) {
        break label87;
      }
      AppMethodBeat.o(228190);
      return;
      i = -1;
      break;
    }
    label87:
    if (j - 1 > i)
    {
      if (this.FO == 0)
      {
        paramRect.set(0, 0, this.LYJ, 0);
        AppMethodBeat.o(228190);
        return;
      }
      paramRect.set(0, 0, 0, this.LYJ);
    }
    AppMethodBeat.o(228190);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration$Companion;", "", "()V", "Horizontal", "", "Vertical", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.b
 * JD-Core Version:    0.7.0.1
 */