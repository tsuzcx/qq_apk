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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "orientation", "", "(I)V", "bounds", "Landroid/graphics/Rect;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerSize", "getOrientation", "()I", "drawHorizontal", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "drawVertical", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.h
{
  public static final b.a SAh;
  private int SAi;
  private final Rect bounds;
  private final int orientation;
  private final Drawable pYO;
  
  static
  {
    AppMethodBeat.i(120329);
    SAh = new b.a((byte)0);
    AppMethodBeat.o(120329);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(120328);
    this.orientation = paramInt;
    this.pYO = ((Drawable)new ColorDrawable(-16777216));
    this.bounds = new Rect();
    this.SAi = a.fromDPToPix(MMApplicationContext.getContext(), 16);
    AppMethodBeat.o(120328);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(367694);
    s.u(paramCanvas, "c");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    if (paramRecyclerView.getLayoutManager() == null)
    {
      AppMethodBeat.o(367694);
      return;
    }
    int j;
    int i;
    int n;
    if (this.orientation == 1)
    {
      paramCanvas.save();
      if (paramRecyclerView.getClipToPadding())
      {
        j = paramRecyclerView.getPaddingLeft();
        i = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
        paramCanvas.clipRect(j, paramRecyclerView.getPaddingTop(), i, paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
        n = paramRecyclerView.getChildCount();
        if (n <= 0) {}
      }
    }
    for (;;)
    {
      m = k + 1;
      params = paramRecyclerView.getChildAt(k);
      RecyclerView.getDecoratedBoundsWithMargins(params, this.bounds);
      k = this.bounds.bottom;
      k = Math.round(params.getTranslationY()) + k;
      int i1 = this.SAi;
      this.pYO.setBounds(j, k - i1, i, k);
      this.pYO.draw(paramCanvas);
      if (m >= n)
      {
        paramCanvas.restore();
        AppMethodBeat.o(367694);
        return;
        i = paramRecyclerView.getWidth();
        j = 0;
        break;
        paramCanvas.save();
        if (paramRecyclerView.getClipToPadding())
        {
          j = paramRecyclerView.getPaddingTop();
          i = paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom();
          paramCanvas.clipRect(paramRecyclerView.getPaddingLeft(), j, paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight(), i);
          n = paramRecyclerView.getChildCount();
          if (n <= 0) {}
        }
        for (k = m;; k = m)
        {
          m = k + 1;
          params = paramRecyclerView.getChildAt(k);
          RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
          if (localLayoutManager != null) {
            localLayoutManager.getDecoratedBoundsWithMargins(params, this.bounds);
          }
          k = this.bounds.right;
          k = Math.round(params.getTranslationX()) + k;
          i1 = this.SAi;
          this.pYO.setBounds(k - i1, j, k, i);
          this.pYO.draw(paramCanvas);
          if (m >= n)
          {
            paramCanvas.restore();
            AppMethodBeat.o(367694);
            return;
            i = paramRecyclerView.getHeight();
            j = 0;
            break;
          }
        }
      }
      k = m;
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(367701);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    params = paramRecyclerView.getLayoutManager();
    int i;
    int j;
    if (params == null)
    {
      i = -1;
      paramView = paramRecyclerView.getLayoutManager();
      if (paramView != null) {
        break label113;
      }
      j = 0;
      label56:
      if (i < 0) {
        break label128;
      }
      if (i >= j - 1) {
        break label122;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.orientation == 0)
        {
          paramRect.set(0, 0, this.SAi, 0);
          AppMethodBeat.o(367701);
          return;
          i = params.getPosition(paramView);
          break;
          label113:
          j = paramView.getItemCount();
          break label56;
          label122:
          i = 0;
          continue;
          label128:
          i = 0;
          continue;
        }
        paramRect.set(0, 0, 0, this.SAi);
      }
    }
    AppMethodBeat.o(367701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.b
 * JD-Core Version:    0.7.0.1
 */