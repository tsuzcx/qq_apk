package com.tencent.mm.plugin.story.ui.view.gallery;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "orientation", "", "(I)V", "bounds", "Landroid/graphics/Rect;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerSize", "getOrientation", "()I", "drawHorizontal", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "drawVertical", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Companion", "plugin-story_release"})
public final class b
  extends RecyclerView.h
{
  public static final b.a Bcy;
  private int Bcx;
  private final Rect hL;
  private final Drawable jiP;
  private final int orientation;
  
  static
  {
    AppMethodBeat.i(120329);
    Bcy = new b.a((byte)0);
    AppMethodBeat.o(120329);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(120328);
    this.orientation = paramInt;
    this.jiP = ((Drawable)new ColorDrawable(-16777216));
    this.hL = new Rect();
    this.Bcx = a.fromDPToPix(aj.getContext(), 16);
    AppMethodBeat.o(120328);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(120326);
    p.h(paramCanvas, "c");
    p.h(paramRecyclerView, "parent");
    p.h(paramt, "state");
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
          paramt = paramRecyclerView.getChildAt(k);
          RecyclerView.c(paramt, this.hL);
          n = this.hL.bottom;
          p.g(paramt, "child");
          n = Math.round(paramt.getTranslationY()) + n;
          i1 = this.Bcx;
          this.jiP.setBounds(j, n - i1, i, n);
          this.jiP.draw(paramCanvas);
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
        paramt = paramRecyclerView.getChildAt(k);
        if (paramRecyclerView.getLayoutManager() != null) {
          RecyclerView.i.c(paramt, this.hL);
        }
        m = this.hL.right;
        p.g(paramt, "child");
        m = Math.round(paramt.getTranslationX()) + m;
        i1 = this.Bcx;
        this.jiP.setBounds(m - i1, j, m, i);
        this.jiP.draw(paramCanvas);
        k += 1;
      }
      i = paramRecyclerView.getHeight();
      j = 0;
    }
    paramCanvas.restore();
    AppMethodBeat.o(120326);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(120327);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(paramt, "state");
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
        paramRect.set(0, 0, this.Bcx, 0);
        AppMethodBeat.o(120327);
        return;
      }
      paramRect.set(0, 0, 0, this.Bcx);
    }
    AppMethodBeat.o(120327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.b
 * JD-Core Version:    0.7.0.1
 */