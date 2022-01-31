package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "orientation", "", "(I)V", "bounds", "Landroid/graphics/Rect;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerSize", "getOrientation", "()I", "drawHorizontal", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "drawVertical", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Companion", "plugin-story_release"})
public final class b
  extends RecyclerView.h
{
  public static final a sRG;
  private final Drawable gCg;
  private final int orientation;
  private final Rect sRE;
  private int sRF;
  
  static
  {
    AppMethodBeat.i(110707);
    sRG = new a((byte)0);
    AppMethodBeat.o(110707);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(110706);
    this.orientation = paramInt;
    this.gCg = ((Drawable)new ColorDrawable(-16777216));
    this.sRE = new Rect();
    this.sRF = a.fromDPToPix(ah.getContext(), 16);
    AppMethodBeat.o(110706);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(110704);
    j.q(paramCanvas, "c");
    j.q(paramRecyclerView, "parent");
    if (paramRecyclerView.getLayoutManager() == null)
    {
      AppMethodBeat.o(110704);
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
          RecyclerView.d(params, this.sRE);
          n = this.sRE.bottom;
          j.p(params, "child");
          n = Math.round(params.getTranslationY()) + n;
          i1 = this.sRF;
          this.gCg.setBounds(j, n - i1, i, n);
          this.gCg.draw(paramCanvas);
          k += 1;
        }
        i = paramRecyclerView.getWidth();
        j = 0;
      }
      paramCanvas.restore();
      AppMethodBeat.o(110704);
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
        paramRecyclerView.getLayoutManager();
        RecyclerView.i.d(params, this.sRE);
        m = this.sRE.right;
        j.p(params, "child");
        m = Math.round(params.getTranslationX()) + m;
        i1 = this.sRF;
        this.gCg.setBounds(m - i1, j, m, i);
        this.gCg.draw(paramCanvas);
        k += 1;
      }
      i = paramRecyclerView.getHeight();
      j = 0;
    }
    paramCanvas.restore();
    AppMethodBeat.o(110704);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(110705);
    j.q(paramRect, "outRect");
    j.q(paramView, "view");
    j.q(paramRecyclerView, "parent");
    j.q(params, "state");
    int i;
    if (paramRecyclerView.getLayoutManager() != null)
    {
      i = RecyclerView.i.bv(paramView);
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
      AppMethodBeat.o(110705);
      return;
      i = -1;
      break;
    }
    label81:
    if (j - 1 > i)
    {
      if (this.orientation == 0)
      {
        paramRect.set(0, 0, this.sRF, 0);
        AppMethodBeat.o(110705);
        return;
      }
      paramRect.set(0, 0, 0, this.sRF);
    }
    AppMethodBeat.o(110705);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration$Companion;", "", "()V", "Horizontal", "", "Vertical", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.b
 * JD-Core Version:    0.7.0.1
 */