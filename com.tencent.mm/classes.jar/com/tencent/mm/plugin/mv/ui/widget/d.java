package com.tencent.mm.plugin.mv.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.model.a.a;
import com.tencent.mm.plugin.vlog.a.c;
import com.tencent.mm.plugin.vlog.a.e;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTransitionMarkDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activeColorFilter", "Landroid/graphics/PorterDuffColorFilter;", "background", "Landroid/graphics/drawable/Drawable;", "bounds", "Landroid/graphics/Rect;", "getContext", "()Landroid/content/Context;", "icon", "Landroid/graphics/drawable/BitmapDrawable;", "iconSize", "", "isAvailable", "", "()Z", "isEnabled", "setEnabled", "(Z)V", "markRange", "", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTransitionMarkDecoration$Range;", "normalColorFilter", "offset", "padding", "showEnd", "getShowEnd", "setShowEnd", "touchExtend", "transMarkStatusList", "Ljava/util/LinkedList;", "getTransMarkStatusList", "()Ljava/util/LinkedList;", "findIndex", "x", "", "(F)Ljava/lang/Integer;", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "reset", "Range", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.h
{
  final List<a> Mls;
  private final int Mlt;
  private BitmapDrawable Mlu;
  private Drawable Mlv;
  private final PorterDuffColorFilter Mlw;
  private final PorterDuffColorFilter Mlx;
  public final LinkedList<Integer> Mly;
  boolean Mlz;
  private final Rect bounds;
  private final Context context;
  private final int iconSize;
  int offset;
  private final int padding;
  public boolean rKp;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(286665);
    this.context = paramContext;
    this.iconSize = com.tencent.mm.cd.a.fromDPToPix(this.context, 22);
    this.Mls = ((List)new ArrayList());
    this.Mlt = com.tencent.mm.cd.a.fromDPToPix(this.context, 16);
    this.padding = com.tencent.mm.cd.a.fromDPToPix(this.context, 3);
    this.bounds = new Rect();
    this.Mlu = new BitmapDrawable(this.context.getResources(), BitmapUtil.getBitmapNative(a.h.icons_filled_transform, this.context.getResources().getDisplayMetrics().density));
    paramContext = androidx.core.content.a.m(this.context, a.e.vlog_transition_mark_bg);
    s.checkNotNull(paramContext);
    s.s(paramContext, "getDrawable(context, R.d…log_transition_mark_bg)!!");
    this.Mlv = paramContext;
    this.Mlw = new PorterDuffColorFilter(androidx.core.content.a.w(this.context, a.c.Orange), PorterDuff.Mode.SRC_ATOP);
    this.Mlx = new PorterDuffColorFilter(androidx.core.content.a.w(this.context, a.c.BW_50), PorterDuff.Mode.SRC_ATOP);
    this.Mly = new LinkedList();
    this.rKp = true;
    this.Mlz = true;
    this.Mlv.setBounds(0, 0, this.iconSize, this.iconSize);
    this.Mlu.setBounds(this.padding, this.padding, this.iconSize - this.padding, this.iconSize - this.padding);
    AppMethodBeat.o(286665);
  }
  
  static boolean isAvailable()
  {
    AppMethodBeat.i(286671);
    a.a locala = com.tencent.mm.plugin.mv.model.a.LWK;
    if (!((Map)com.tencent.mm.plugin.mv.model.a.gpt()).isEmpty())
    {
      AppMethodBeat.o(286671);
      return true;
    }
    AppMethodBeat.o(286671);
    return false;
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(286687);
    s.u(paramCanvas, "canvas");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.b(paramCanvas, paramRecyclerView, params);
    if ((!this.rKp) || (!isAvailable()))
    {
      AppMethodBeat.o(286687);
      return;
    }
    params = paramRecyclerView.getAdapter();
    if (params == null)
    {
      paramCanvas = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.mv.ui.widget.MvTracksAdapter");
      AppMethodBeat.o(286687);
      throw paramCanvas;
    }
    int k = ((c)params).MkF.getTracks().size();
    this.offset = 0;
    int m = paramRecyclerView.getChildCount();
    if (m > 0) {}
    int j;
    label292:
    label427:
    label466:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      params = paramRecyclerView.getChildAt(i);
      int n = c.aeo(RecyclerView.bA(params));
      RecyclerView.getDecoratedBoundsWithMargins(params, this.bounds);
      float f1;
      float f2;
      if ((this.Mlz) || (n != k - 1))
      {
        if (n < 0) {
          break label410;
        }
        if (n >= k) {
          break label404;
        }
        i = 1;
        if (i != 0)
        {
          float f3 = (params.getTop() + params.getBottom() - this.iconSize) / 2.0F;
          i = this.bounds.right;
          f1 = (params.getRight() + i) / 2 - this.iconSize / 2.0F;
          f2 = this.iconSize + f1;
          paramCanvas.save();
          paramCanvas.translate(f1, f3);
          this.Mlv.draw(paramCanvas);
          boolean bool = this.Mly.contains(Integer.valueOf(n));
          BitmapDrawable localBitmapDrawable = this.Mlu;
          if (!bool) {
            break label416;
          }
          params = (ColorFilter)this.Mlw;
          localBitmapDrawable.setColorFilter(params);
          this.Mlu.draw(paramCanvas);
          paramCanvas.restore();
          if (this.offset >= this.Mls.size()) {
            break label427;
          }
          params = (a)this.Mls.get(this.offset);
          f3 = this.Mlt;
          float f4 = this.Mlt;
          params.index = n;
          params.left = (f1 - f3);
          params.right = (f2 + f4);
        }
      }
      for (;;)
      {
        this.offset += 1;
        if (j < m) {
          break label466;
        }
        AppMethodBeat.o(286687);
        return;
        i = 0;
        break;
        i = 0;
        break;
        params = (ColorFilter)this.Mlx;
        break label292;
        this.Mls.add(new a(n, f1 - this.Mlt, f2 + this.Mlt));
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTransitionMarkDecoration$Range;", "", "index", "", "left", "", "right", "(Lcom/tencent/mm/plugin/mv/ui/widget/MvTransitionMarkDecoration;IFF)V", "getIndex", "()I", "setIndex", "(I)V", "getLeft", "()F", "setLeft", "(F)V", "getRight", "setRight", "contains", "", "value", "set", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
  {
    int index;
    float left;
    float right;
    
    public a(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(286686);
      this.index = paramFloat1;
      this.left = paramFloat2;
      Object localObject;
      this.right = localObject;
      AppMethodBeat.o(286686);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */