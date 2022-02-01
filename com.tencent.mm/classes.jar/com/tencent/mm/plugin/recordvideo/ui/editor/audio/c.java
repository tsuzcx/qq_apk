package com.tencent.mm.plugin.recordvideo.ui.editor.audio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.a;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/GridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mHorizonSpan", "", "mVerticalSpan", "color", "mShowLastLine", "", "(IIIZ)V", "mDivider", "Landroid/graphics/drawable/Drawable;", "drawHorizontal", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getResult", "pos", "spanCount", "childCount", "getSpanCount", "isLastRaw", "onDrawOver", "Builder", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.h
{
  public static final c.b NXO;
  private final boolean HNS;
  private final int HNT;
  private final int HNU;
  private final Drawable tP;
  
  static
  {
    AppMethodBeat.i(280153);
    NXO = new c.b((byte)0);
    AppMethodBeat.o(280153);
  }
  
  private c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(280123);
    this.HNT = paramInt1;
    this.HNU = paramInt2;
    this.HNS = paramBoolean;
    this.tP = ((Drawable)new ColorDrawable(paramInt3));
    AppMethodBeat.o(280123);
  }
  
  private static int I(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(280140);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      i = ((GridLayoutManager)paramRecyclerView).bWl;
    }
    for (;;)
    {
      AppMethodBeat.o(280140);
      return i;
      if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
        i = ((StaggeredGridLayoutManager)paramRecyclerView).bWl;
      } else {
        i = -1;
      }
    }
  }
  
  private static boolean aI(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 % paramInt2 == 0)
    {
      if (paramInt1 < paramInt3 - paramInt2) {}
    }
    else {
      while (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
        return true;
      }
    }
    return false;
  }
  
  private final void b(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(280134);
    int n = paramRecyclerView.getChildCount();
    if (n > 0) {}
    int m;
    for (int i = 0;; i = m)
    {
      m = i + 1;
      if ((i != n - 1) || (this.HNS))
      {
        View localView = paramRecyclerView.getChildAt(i);
        int i1 = I(paramRecyclerView);
        Object localObject = (GridLayoutManager)paramRecyclerView.getLayoutManager();
        if (localObject == null)
        {
          localObject = null;
          if (localObject != null) {
            break label213;
          }
          j = 0;
          label76:
          if (localObject != null) {
            break label236;
          }
          k = 0;
          label84:
          localObject = new StringBuilder("drawVertical ").append(i).append(' ').append(i1).append(' ').append(j).append(' ').append(k).append(' ');
          if ((j + k) % i1 != 0) {
            break label255;
          }
        }
        label213:
        label236:
        label255:
        for (boolean bool = true;; bool = false)
        {
          Log.d("WxIme.GridItemDecoration", bool);
          if ((k + j) % i1 == 0) {
            break label358;
          }
          localObject = localView.getLayoutParams();
          if (localObject != null) {
            break label261;
          }
          paramCanvas = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
          AppMethodBeat.o(280134);
          throw paramCanvas;
          localObject = ((GridLayoutManager)localObject).bWq;
          break;
          j = ((GridLayoutManager.b)localObject).bf(paramRecyclerView.bj(localView).KJ(), I(paramRecyclerView));
          break label76;
          k = ((GridLayoutManager.b)localObject).fJ(paramRecyclerView.bj(localView).KJ());
          break label84;
        }
        label261:
        localObject = (RecyclerView.LayoutParams)localObject;
        i = localView.getTop();
        int j = ((RecyclerView.LayoutParams)localObject).topMargin;
        int k = localView.getBottom();
        i1 = ((RecyclerView.LayoutParams)localObject).bottomMargin;
        int i2 = this.HNT;
        int i3 = localView.getRight();
        i3 = ((RecyclerView.LayoutParams)localObject).rightMargin + i3;
        int i4 = this.HNU;
        this.tP.setBounds(i3 - i4, i - j, i3, k + i1 + i2);
        this.tP.draw(paramCanvas);
      }
      label358:
      if (m >= n)
      {
        AppMethodBeat.o(280134);
        return;
      }
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(280172);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    int i = I(paramRecyclerView);
    params = paramRecyclerView.getAdapter();
    s.checkNotNull(params);
    int n = params.getItemCount();
    paramView = paramView.getLayoutParams();
    if (paramView == null)
    {
      paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
      AppMethodBeat.o(280172);
      throw paramRect;
    }
    int i1 = ((RecyclerView.LayoutParams)paramView).bXh.KI();
    if (i1 < 0)
    {
      AppMethodBeat.o(280172);
      return;
    }
    int m = i1 % i;
    int j = this.HNU * m / i;
    int k = this.HNU;
    m = (m + 1) * this.HNU / i;
    paramView = paramRecyclerView.getLayoutManager();
    boolean bool;
    if ((paramView instanceof GridLayoutManager))
    {
      bool = aI(i1, i, n);
      if ((!bool) || (this.HNS)) {
        break label254;
      }
    }
    label254:
    for (i = 0;; i = this.HNT)
    {
      paramRect.set(j, 0, k - m, i);
      AppMethodBeat.o(280172);
      return;
      if ((paramView instanceof StaggeredGridLayoutManager))
      {
        if (((StaggeredGridLayoutManager)paramView).mOrientation == 1)
        {
          bool = aI(i1, i, n);
          break;
        }
        if ((i1 + 1) % i == 0)
        {
          bool = true;
          break;
        }
      }
      bool = false;
      break;
    }
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(280162);
    s.u(paramCanvas, "c");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    int k = paramRecyclerView.getChildCount();
    int i = 0;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      params = paramRecyclerView.getChildAt(i);
      if ((i != k - 1) || (this.HNS))
      {
        Object localObject = params.getLayoutParams();
        if (localObject == null)
        {
          paramCanvas = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
          AppMethodBeat.o(280162);
          throw paramCanvas;
        }
        localObject = (RecyclerView.LayoutParams)localObject;
        i = params.getLeft();
        int m = ((RecyclerView.LayoutParams)localObject).leftMargin;
        int n = params.getRight();
        int i1 = ((RecyclerView.LayoutParams)localObject).rightMargin;
        int i2 = params.getBottom();
        i2 = ((RecyclerView.LayoutParams)localObject).bottomMargin + i2;
        int i3 = this.HNT;
        this.tP.setBounds(i - m, i2, n + i1, i3 + i2);
        this.tP.draw(paramCanvas);
      }
      if (j >= k)
      {
        b(paramCanvas, paramRecyclerView);
        AppMethodBeat.o(280162);
        return;
      }
      i = j;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/GridItemDecoration$Builder;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mColor", "", "mHorizonSpan", "mResources", "Landroid/content/res/Resources;", "mShowLastLine", "", "mVerticalSpan", "build", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/GridItemDecoration;", "setColor", "color", "setColorResource", "resource", "setHorizontalSpan", "horizontal", "", "setShowLastLine", "show", "setVerticalSpan", "mVertical", "vertical", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    boolean HNS;
    private int HNT;
    private int HNU;
    private int mColor;
    private final Context mContext;
    private final Resources mResources;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(280120);
      this.mContext = paramContext;
      paramContext = this.mContext.getResources();
      s.s(paramContext, "mContext.resources");
      this.mResources = paramContext;
      this.HNS = true;
      this.HNT = 0;
      this.HNU = 0;
      this.mColor = -1;
      AppMethodBeat.o(280120);
    }
    
    public final a agW(int paramInt)
    {
      AppMethodBeat.i(280122);
      this.mColor = a.w(this.mContext, paramInt);
      AppMethodBeat.o(280122);
      return this;
    }
    
    public final a agX(int paramInt)
    {
      AppMethodBeat.i(280126);
      this.HNU = this.mResources.getDimensionPixelSize(paramInt);
      AppMethodBeat.o(280126);
      return this;
    }
    
    public final a agY(int paramInt)
    {
      AppMethodBeat.i(280130);
      this.HNT = this.mResources.getDimensionPixelSize(paramInt);
      AppMethodBeat.o(280130);
      return this;
    }
    
    public final c gKo()
    {
      AppMethodBeat.i(280136);
      c localc = new c(this.HNT, this.HNU, this.mColor, this.HNS, (byte)0);
      AppMethodBeat.o(280136);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.audio.c
 * JD-Core Version:    0.7.0.1
 */