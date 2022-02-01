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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTransitionMarkDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activeColorFilter", "Landroid/graphics/PorterDuffColorFilter;", "background", "Landroid/graphics/drawable/Drawable;", "bounds", "Landroid/graphics/Rect;", "getContext", "()Landroid/content/Context;", "icon", "Landroid/graphics/drawable/BitmapDrawable;", "iconSize", "", "isAvailable", "", "()Z", "isEnabled", "setEnabled", "(Z)V", "markRange", "", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTransitionMarkDecoration$Range;", "normalColorFilter", "offset", "padding", "showEnd", "getShowEnd", "setShowEnd", "touchExtend", "transMarkStatusList", "Ljava/util/LinkedList;", "getTransMarkStatusList", "()Ljava/util/LinkedList;", "findIndex", "x", "", "(F)Ljava/lang/Integer;", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "reset", "Range", "plugin-mv_release"})
public final class d
  extends RecyclerView.h
{
  final List<a> Gro;
  private final int Grp;
  private BitmapDrawable Grq;
  private Drawable Grr;
  private final PorterDuffColorFilter Grs;
  private final PorterDuffColorFilter Grt;
  public final LinkedList<Integer> Gru;
  public boolean Grv;
  boolean Grw;
  private final Rect byi;
  private final Context context;
  private final int iconSize;
  int offset;
  private final int padding;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(243992);
    this.context = paramContext;
    this.iconSize = com.tencent.mm.ci.a.fromDPToPix(this.context, 22);
    this.Gro = ((List)new ArrayList());
    this.Grp = com.tencent.mm.ci.a.fromDPToPix(this.context, 16);
    this.padding = com.tencent.mm.ci.a.fromDPToPix(this.context, 3);
    this.byi = new Rect();
    paramContext = this.context.getResources();
    int i = a.h.icons_filled_transform;
    Resources localResources = this.context.getResources();
    p.j(localResources, "context.resources");
    this.Grq = new BitmapDrawable(paramContext, BitmapUtil.getBitmapNative(i, localResources.getDisplayMetrics().density));
    paramContext = androidx.core.content.a.m(this.context, a.e.vlog_transition_mark_bg);
    if (paramContext == null) {
      p.iCn();
    }
    p.j(paramContext, "ContextCompat.getDrawabl…log_transition_mark_bg)!!");
    this.Grr = paramContext;
    this.Grs = new PorterDuffColorFilter(androidx.core.content.a.w(this.context, a.c.Orange), PorterDuff.Mode.SRC_ATOP);
    this.Grt = new PorterDuffColorFilter(androidx.core.content.a.w(this.context, a.c.BW_50), PorterDuff.Mode.SRC_ATOP);
    this.Gru = new LinkedList();
    this.Grv = true;
    this.Grw = true;
    this.Grr.setBounds(0, 0, this.iconSize, this.iconSize);
    this.Grq.setBounds(this.padding, this.padding, this.iconSize - this.padding, this.iconSize - this.padding);
    AppMethodBeat.o(243992);
  }
  
  static boolean isAvailable()
  {
    AppMethodBeat.i(243989);
    a.a locala = com.tencent.mm.plugin.mv.model.a.GaP;
    if (!((Map)com.tencent.mm.plugin.mv.model.a.ffQ()).isEmpty())
    {
      AppMethodBeat.o(243989);
      return true;
    }
    AppMethodBeat.o(243989);
    return false;
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int i = 0;
    AppMethodBeat.i(243990);
    p.k(paramCanvas, "canvas");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    super.b(paramCanvas, paramRecyclerView, params);
    if ((!this.Grv) || (!isAvailable()))
    {
      AppMethodBeat.o(243990);
      return;
    }
    params = paramRecyclerView.getAdapter();
    if (params == null)
    {
      paramCanvas = new t("null cannot be cast to non-null type com.tencent.mm.plugin.mv.ui.widget.MvTracksAdapter");
      AppMethodBeat.o(243990);
      throw paramCanvas;
    }
    int j = ((c)params).GqD.getTracks().size();
    this.offset = 0;
    int k = paramRecyclerView.getChildCount();
    if (i < k)
    {
      params = paramRecyclerView.getChildAt(i);
      int m = c.ZV(RecyclerView.bh(params));
      RecyclerView.getDecoratedBoundsWithMargins(params, this.byi);
      if ((this.Grw) || (m != j - 1))
      {
        if (m < 0) {}
        while (j <= m)
        {
          i += 1;
          break;
        }
        p.j(params, "childView");
        float f3 = (params.getTop() + params.getBottom() - this.iconSize) / 2.0F;
        int n = this.byi.right;
        float f1 = (params.getRight() + n) / 2 - this.iconSize / 2.0F;
        float f2 = f1 + this.iconSize;
        paramCanvas.save();
        paramCanvas.translate(f1, f3);
        this.Grr.draw(paramCanvas);
        boolean bool = this.Gru.contains(Integer.valueOf(m));
        BitmapDrawable localBitmapDrawable = this.Grq;
        if (bool)
        {
          params = (ColorFilter)this.Grs;
          label296:
          localBitmapDrawable.setColorFilter(params);
          this.Grq.draw(paramCanvas);
          paramCanvas.restore();
          if (this.offset >= this.Gro.size()) {
            break label409;
          }
          params = (a)this.Gro.get(this.offset);
          f3 = this.Grp;
          float f4 = this.Grp;
          params.index = m;
          params.left = (f1 - f3);
          params.right = (f4 + f2);
        }
        for (;;)
        {
          this.offset += 1;
          break;
          params = (ColorFilter)this.Grt;
          break label296;
          label409:
          this.Gro.add(new a(m, f1 - this.Grp, f2 + this.Grp));
        }
      }
    }
    AppMethodBeat.o(243990);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTransitionMarkDecoration$Range;", "", "index", "", "left", "", "right", "(Lcom/tencent/mm/plugin/mv/ui/widget/MvTransitionMarkDecoration;IFF)V", "getIndex", "()I", "setIndex", "(I)V", "getLeft", "()F", "setLeft", "(F)V", "getRight", "setRight", "contains", "", "value", "set", "", "plugin-mv_release"})
  public final class a
  {
    int index;
    float left;
    float right;
    
    public a(float paramFloat1, float paramFloat2)
    {
      this.index = paramFloat1;
      this.left = paramFloat2;
      Object localObject;
      this.right = localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */