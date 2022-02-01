package com.tencent.mm.plugin.story.ui.view.gallery;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "orientation", "", "(I)V", "bounds", "Landroid/graphics/Rect;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerSize", "getOrientation", "()I", "drawHorizontal", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "drawVertical", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Companion", "plugin-story_release"})
public final class b
  extends RecyclerView.h
{
  public static final a yxI;
  private final Rect eT;
  private final Drawable ipA;
  private final int orientation;
  private int yxH;
  
  static
  {
    AppMethodBeat.i(120329);
    yxI = new a((byte)0);
    AppMethodBeat.o(120329);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(120328);
    this.orientation = paramInt;
    this.ipA = ((Drawable)new ColorDrawable(-16777216));
    this.eT = new Rect();
    this.yxH = a.fromDPToPix(aj.getContext(), 16);
    AppMethodBeat.o(120328);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(120326);
    k.h(paramCanvas, "c");
    k.h(paramRecyclerView, "parent");
    k.h(params, "state");
    if (paramRecyclerView.getLayoutManager() == null)
    {
      AppMethodBeat.o(120326);
      return;
    }
    int j;
    int i;
    int n;
    int i1;
    if (this.orientation == 1)
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
          RecyclerView.c(params, this.eT);
          n = this.eT.bottom;
          k.g(params, "child");
          n = Math.round(params.getTranslationY()) + n;
          i1 = this.yxH;
          this.ipA.setBounds(j, n - i1, i, n);
          this.ipA.draw(paramCanvas);
          k += 1;
        }
        i = paramRecyclerView.getWidth();
        j = 0;
      }
      paramCanvas.restore();
      AppMethodBeat.o(120326);
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
        if (paramRecyclerView.getLayoutManager() != null) {
          RecyclerView.i.c(params, this.eT);
        }
        m = this.eT.right;
        k.g(params, "child");
        m = Math.round(params.getTranslationX()) + m;
        i1 = this.yxH;
        this.ipA.setBounds(m - i1, j, m, i);
        this.ipA.draw(paramCanvas);
        k += 1;
      }
      i = paramRecyclerView.getHeight();
      j = 0;
    }
    paramCanvas.restore();
    AppMethodBeat.o(120326);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(120327);
    k.h(paramRect, "outRect");
    k.h(paramView, "view");
    k.h(paramRecyclerView, "parent");
    k.h(params, "state");
    int i;
    if (paramRecyclerView.getLayoutManager() != null)
    {
      i = RecyclerView.i.bB(paramView);
      paramView = paramRecyclerView.getLayoutManager();
      if (paramView == null) {
        break label75;
      }
    }
    label75:
    for (int j = paramView.getItemCount();; j = 0)
    {
      if (i >= 0) {
        break label81;
      }
      AppMethodBeat.o(120327);
      return;
      i = -1;
      break;
    }
    label81:
    if (j - 1 > i)
    {
      if (this.orientation == 0)
      {
        paramRect.set(0, 0, this.yxH, 0);
        AppMethodBeat.o(120327);
        return;
      }
      paramRect.set(0, 0, 0, this.yxH);
    }
    AppMethodBeat.o(120327);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration$Companion;", "", "()V", "Horizontal", "", "Vertical", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.b
 * JD-Core Version:    0.7.0.1
 */