package com.tencent.mm.plugin.story.ui.view.gallery;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "orientation", "", "(I)V", "bounds", "Landroid/graphics/Rect;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerSize", "getOrientation", "()I", "drawHorizontal", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "drawVertical", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Companion", "plugin-story_release"})
public final class b
  extends RecyclerView.h
{
  public static final b.a FEJ;
  private int FEI;
  private final Rect hN;
  private final Drawable kjR;
  private final int orientation;
  
  static
  {
    AppMethodBeat.i(120329);
    FEJ = new b.a((byte)0);
    AppMethodBeat.o(120329);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(120328);
    this.orientation = paramInt;
    this.kjR = ((Drawable)new ColorDrawable(-16777216));
    this.hN = new Rect();
    this.FEI = a.fromDPToPix(MMApplicationContext.getContext(), 16);
    AppMethodBeat.o(120328);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(120326);
    p.h(paramCanvas, "c");
    p.h(paramRecyclerView, "parent");
    p.h(params, "state");
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
          RecyclerView.getDecoratedBoundsWithMargins(params, this.hN);
          n = this.hN.bottom;
          p.g(params, "child");
          n = Math.round(params.getTranslationY()) + n;
          i1 = this.FEI;
          this.kjR.setBounds(j, n - i1, i, n);
          this.kjR.draw(paramCanvas);
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
        RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
        if (localLayoutManager != null) {
          localLayoutManager.getDecoratedBoundsWithMargins(params, this.hN);
        }
        m = this.hN.right;
        p.g(params, "child");
        m = Math.round(params.getTranslationX()) + m;
        i1 = this.FEI;
        this.kjR.setBounds(m - i1, j, m, i);
        this.kjR.draw(paramCanvas);
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
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(params, "state");
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
      AppMethodBeat.o(120327);
      return;
      i = -1;
      break;
    }
    label87:
    if (j - 1 > i)
    {
      if (this.orientation == 0)
      {
        paramRect.set(0, 0, this.FEI, 0);
        AppMethodBeat.o(120327);
        return;
      }
      paramRect.set(0, 0, 0, this.FEI);
    }
    AppMethodBeat.o(120327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.b
 * JD-Core Version:    0.7.0.1
 */