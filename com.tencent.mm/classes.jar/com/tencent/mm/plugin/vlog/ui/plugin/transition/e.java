package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.vlog.a.c;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.ui.thumb.f;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "getContext", "()Landroid/content/Context;", "halfMarkWidth", "", "markRange", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration$Range;", "markWidth", "offset", "selectIndex", "getSelectIndex", "()I", "setSelectIndex", "(I)V", "touchExtend", "transMarkStatusList", "", "checkClick", "", "x", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "createTransitionMarkView", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "hasTransition", "onDrawOver", "c", "Landroid/graphics/Canvas;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "reset", "updateTransMarkStatus", "", "width", "Range", "plugin-vlog_release"})
public final class e
  extends RecyclerView.h
{
  public int ARl;
  private final List<a> Gro;
  private final int Grp;
  public final int NBI;
  private final int NBJ;
  public final List<Boolean> NBK;
  private final f NBL;
  private final Context context;
  private int offset;
  
  public e(Context paramContext, f paramf)
  {
    AppMethodBeat.i(233291);
    this.context = paramContext;
    this.NBL = paramf;
    this.NBI = a.fromDPToPix(this.context, 22);
    this.NBJ = (this.NBI / 2);
    this.Gro = ((List)new ArrayList());
    this.NBK = ((List)new ArrayList());
    this.Grp = a.fromDPToPix(this.context, 16);
    this.ARl = -1;
    AppMethodBeat.o(233291);
  }
  
  public final void a(float paramFloat, b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(233289);
    p.k(paramb, "callback");
    int k = this.offset;
    int i = 0;
    while (i < k)
    {
      a locala = (a)this.Gro.get(i);
      float f1 = locala.left;
      float f2 = locala.right;
      if ((paramFloat >= f1) && (paramFloat <= f2)) {}
      for (int j = 1; j != 0; j = 0)
      {
        paramb.invoke(Integer.valueOf(((a)this.Gro.get(i)).position));
        AppMethodBeat.o(233289);
        return;
      }
      i += 1;
    }
    paramb.invoke(Integer.valueOf(-1));
    AppMethodBeat.o(233289);
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(233287);
    p.k(paramCanvas, "c");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    super.b(paramCanvas, paramRecyclerView, params);
    int k = this.NBL.getItemCount();
    this.offset = 0;
    int m = paramRecyclerView.getChildCount();
    int i = 0;
    if (i < m)
    {
      params = paramRecyclerView.getChildAt(i);
      int n = RecyclerView.bh(params);
      int j;
      if ((n > 1) && (n < k - 1))
      {
        if (this.ARl < 0) {
          break label134;
        }
        j = this.ARl;
        i1 = this.ARl;
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
      p.j(params, "childView");
      int i1 = params.getLeft();
      params = (Boolean)j.M(this.NBK, n - 2);
      boolean bool;
      label171:
      label232:
      float f1;
      float f2;
      if (params != null)
      {
        bool = params.booleanValue();
        params = LayoutInflater.from(this.context).inflate(a.g.vlog_transition_mark_view, (ViewGroup)paramRecyclerView, false);
        ImageView localImageView = (ImageView)params.findViewById(a.f.vlog_transition_mark_icon);
        Context localContext = this.context;
        int i2 = a.h.icons_filled_transform;
        Resources localResources = this.context.getResources();
        if (!bool) {
          break label434;
        }
        j = a.c.Orange;
        localImageView.setImageDrawable(au.o(localContext, i2, localResources.getColor(j)));
        params.measure(this.NBI, this.NBI);
        params.layout(0, 0, this.NBI, this.NBI);
        p.j(params, "view");
        float f3 = (paramRecyclerView.getHeight() - this.NBI) / 2.0F;
        f1 = i1 - this.NBJ;
        f2 = i1 + this.NBJ;
        paramCanvas.save();
        paramCanvas.translate(f1, f3);
        params.draw(paramCanvas);
        paramCanvas.restore();
        if (this.offset >= this.Gro.size()) {
          break label442;
        }
        params = (a)this.Gro.get(this.offset);
        f3 = this.Grp;
        float f4 = this.Grp;
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
        label434:
        j = a.c.BW_50;
        break label232;
        label442:
        this.Gro.add(new a(n - 2, f1 - this.Grp, f2 + this.Grp));
      }
    }
    AppMethodBeat.o(233287);
  }
  
  public final void iH(List<Boolean> paramList)
  {
    AppMethodBeat.i(233290);
    p.k(paramList, "transMarkStatusList");
    this.NBK.clear();
    this.NBK.addAll((Collection)paramList);
    AppMethodBeat.o(233290);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration$Range;", "", "position", "", "left", "", "right", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration;IFF)V", "getLeft", "()F", "setLeft", "(F)V", "getPosition", "()I", "setPosition", "(I)V", "getRight", "setRight", "contains", "", "value", "set", "", "plugin-vlog_release"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.e
 * JD-Core Version:    0.7.0.1
 */