package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.ao;
import d.a.j;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "getContext", "()Landroid/content/Context;", "halfMarkWidth", "", "markRange", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration$Range;", "markWidth", "offset", "selectIndex", "getSelectIndex", "()I", "setSelectIndex", "(I)V", "touchExtend", "transMarkStatusList", "", "checkClick", "", "x", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "createTransitionMarkView", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "hasTransition", "onDrawOver", "c", "Landroid/graphics/Canvas;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "updateTransMarkStatus", "", "width", "Range", "plugin-vlog_release"})
public final class e
  extends RecyclerView.h
{
  public final List<Boolean> BTA;
  private final int BTB;
  private final com.tencent.mm.plugin.vlog.ui.thumb.b BTC;
  public final int BTx;
  private final int BTy;
  private final List<a> BTz;
  private final Context context;
  private int offset;
  public int sQX;
  
  public e(Context paramContext, com.tencent.mm.plugin.vlog.ui.thumb.b paramb)
  {
    AppMethodBeat.i(196815);
    this.context = paramContext;
    this.BTC = paramb;
    this.BTx = a.fromDPToPix(this.context, 22);
    this.BTy = (this.BTx / 2);
    this.BTz = ((List)new ArrayList());
    this.BTA = ((List)new ArrayList());
    this.BTB = a.fromDPToPix(this.context, 16);
    this.sQX = -1;
    AppMethodBeat.o(196815);
  }
  
  public final void a(float paramFloat, d.g.a.b<? super Integer, z> paramb)
  {
    AppMethodBeat.i(196814);
    p.h(paramb, "callback");
    int k = this.offset;
    int i = 0;
    while (i < k)
    {
      a locala = (a)this.BTz.get(i);
      float f1 = locala.left;
      float f2 = locala.right;
      if ((paramFloat >= f1) && (paramFloat <= f2)) {}
      for (int j = 1; j != 0; j = 0)
      {
        paramb.invoke(Integer.valueOf(((a)this.BTz.get(i)).position));
        AppMethodBeat.o(196814);
        return;
      }
      i += 1;
    }
    paramb.invoke(Integer.valueOf(-1));
    AppMethodBeat.o(196814);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    AppMethodBeat.i(196813);
    p.h(paramCanvas, "c");
    p.h(paramRecyclerView, "parent");
    p.h(paramt, "state");
    super.b(paramCanvas, paramRecyclerView, paramt);
    int k = this.BTC.getItemCount();
    this.offset = 0;
    int m = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < m)
    {
      paramt = paramRecyclerView.getChildAt(i);
      int n = RecyclerView.bw(paramt);
      int j;
      if ((n > 1) && (n < k - 1))
      {
        if (this.sQX < 0) {
          break label134;
        }
        j = this.sQX;
        i1 = this.sQX;
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
      p.g(paramt, "childView");
      int i1 = paramt.getLeft();
      paramt = (Boolean)j.E(this.BTA, n - 2);
      boolean bool;
      label171:
      label224:
      float f1;
      float f2;
      if (paramt != null)
      {
        bool = paramt.booleanValue();
        paramt = LayoutInflater.from(this.context).inflate(2131496502, (ViewGroup)paramRecyclerView, false);
        ImageView localImageView = (ImageView)paramt.findViewById(2131308466);
        Context localContext = this.context;
        Resources localResources = this.context.getResources();
        if (!bool) {
          break label425;
        }
        j = 2131099777;
        localImageView.setImageDrawable(ao.k(localContext, 2131691605, localResources.getColor(j)));
        paramt.measure(this.BTx, this.BTx);
        paramt.layout(0, 0, this.BTx, this.BTx);
        p.g(paramt, "view");
        float f3 = (paramRecyclerView.getHeight() - this.BTx) / 2.0F;
        f1 = i1 - this.BTy;
        f2 = i1 + this.BTy;
        paramCanvas.save();
        paramCanvas.translate(f1, f3);
        paramt.draw(paramCanvas);
        paramCanvas.restore();
        if (this.offset >= this.BTz.size()) {
          break label433;
        }
        paramt = (a)this.BTz.get(this.offset);
        f3 = this.BTB;
        float f4 = this.BTB;
        paramt.position = (n - 2);
        paramt.left = (f1 - f3);
        paramt.right = (f2 + f4);
      }
      for (;;)
      {
        this.offset += 1;
        break;
        bool = false;
        break label171;
        label425:
        j = 2131099676;
        break label224;
        label433:
        this.BTz.add(new a(n - 2, f1 - this.BTB, f2 + this.BTB));
      }
    }
    AppMethodBeat.o(196813);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration$Range;", "", "position", "", "left", "", "right", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration;IFF)V", "getLeft", "()F", "setLeft", "(F)V", "getPosition", "()I", "setPosition", "(I)V", "getRight", "setRight", "contains", "", "value", "set", "", "plugin-vlog_release"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.e
 * JD-Core Version:    0.7.0.1
 */