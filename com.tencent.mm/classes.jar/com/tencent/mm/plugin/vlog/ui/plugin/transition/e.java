package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.vlog.ui.thumb.f;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "getContext", "()Landroid/content/Context;", "halfMarkWidth", "", "markRange", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration$Range;", "markWidth", "offset", "selectIndex", "getSelectIndex", "()I", "setSelectIndex", "(I)V", "touchExtend", "transMarkStatusList", "", "checkClick", "", "x", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "createTransitionMarkView", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "hasTransition", "onDrawOver", "c", "Landroid/graphics/Canvas;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "updateTransMarkStatus", "", "width", "Range", "plugin-vlog_release"})
public final class e
  extends RecyclerView.h
{
  public final int GOa;
  private final int GOb;
  private final List<a> GOc;
  private final List<Boolean> GOd;
  private final int GOe;
  private final f GOf;
  private final Context context;
  private int offset;
  public int whv;
  
  public e(Context paramContext, f paramf)
  {
    AppMethodBeat.i(192018);
    this.context = paramContext;
    this.GOf = paramf;
    this.GOa = a.fromDPToPix(this.context, 22);
    this.GOb = (this.GOa / 2);
    this.GOc = ((List)new ArrayList());
    this.GOd = ((List)new ArrayList());
    this.GOe = a.fromDPToPix(this.context, 16);
    this.whv = -1;
    AppMethodBeat.o(192018);
  }
  
  public final void a(float paramFloat, b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(192016);
    p.h(paramb, "callback");
    int k = this.offset;
    int i = 0;
    while (i < k)
    {
      a locala = (a)this.GOc.get(i);
      float f1 = locala.left;
      float f2 = locala.right;
      if ((paramFloat >= f1) && (paramFloat <= f2)) {}
      for (int j = 1; j != 0; j = 0)
      {
        paramb.invoke(Integer.valueOf(((a)this.GOc.get(i)).position));
        AppMethodBeat.o(192016);
        return;
      }
      i += 1;
    }
    paramb.invoke(Integer.valueOf(-1));
    AppMethodBeat.o(192016);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(192015);
    p.h(paramCanvas, "c");
    p.h(paramRecyclerView, "parent");
    p.h(params, "state");
    super.b(paramCanvas, paramRecyclerView, params);
    int k = this.GOf.getItemCount();
    this.offset = 0;
    int m = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < m)
    {
      params = paramRecyclerView.getChildAt(i);
      int n = RecyclerView.bw(params);
      int j;
      if ((n > 1) && (n < k - 1))
      {
        if (this.whv < 0) {
          break label134;
        }
        j = this.whv;
        i1 = this.whv;
        if (j + 1 <= n) {
          break label125;
        }
      }
      label125:
      while (i1 + 2 < n)
      {
        i += 1;
        break;
      }
      label134:
      p.g(params, "childView");
      int i1 = params.getLeft();
      params = (Boolean)j.L(this.GOd, n - 2);
      boolean bool;
      label171:
      label224:
      float f1;
      float f2;
      if (params != null)
      {
        bool = params.booleanValue();
        params = LayoutInflater.from(this.context).inflate(2131496836, (ViewGroup)paramRecyclerView, false);
        ImageView localImageView = (ImageView)params.findViewById(2131309920);
        Context localContext = this.context;
        Resources localResources = this.context.getResources();
        if (!bool) {
          break label425;
        }
        j = 2131099792;
        localImageView.setImageDrawable(ar.m(localContext, 2131690698, localResources.getColor(j)));
        params.measure(this.GOa, this.GOa);
        params.layout(0, 0, this.GOa, this.GOa);
        p.g(params, "view");
        float f3 = (paramRecyclerView.getHeight() - this.GOa) / 2.0F;
        f1 = i1 - this.GOb;
        f2 = i1 + this.GOb;
        paramCanvas.save();
        paramCanvas.translate(f1, f3);
        params.draw(paramCanvas);
        paramCanvas.restore();
        if (this.offset >= this.GOc.size()) {
          break label433;
        }
        params = (a)this.GOc.get(this.offset);
        f3 = this.GOe;
        float f4 = this.GOe;
        params.position = (n - 2);
        params.left = (f1 - f3);
        params.right = (f2 + f4);
      }
      for (;;)
      {
        this.offset += 1;
        break;
        bool = false;
        break label171;
        label425:
        j = 2131099683;
        break label224;
        label433:
        this.GOc.add(new a(n - 2, f1 - this.GOe, f2 + this.GOe));
      }
    }
    AppMethodBeat.o(192015);
  }
  
  public final void hS(List<Boolean> paramList)
  {
    AppMethodBeat.i(192017);
    p.h(paramList, "transMarkStatusList");
    this.GOd.clear();
    this.GOd.addAll((Collection)paramList);
    AppMethodBeat.o(192017);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration$Range;", "", "position", "", "left", "", "right", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration;IFF)V", "getLeft", "()F", "setLeft", "(F)V", "getPosition", "()I", "setPosition", "(I)V", "getRight", "setRight", "contains", "", "value", "set", "", "plugin-vlog_release"})
  public final class a
  {
    float left;
    int position;
    float right;
    
    public a(float paramFloat1, float paramFloat2)
    {
      this.position = paramFloat1;
      this.left = paramFloat2;
      Object localObject;
      this.right = localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.e
 * JD-Core Version:    0.7.0.1
 */