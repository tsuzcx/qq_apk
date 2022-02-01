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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.vlog.a.c;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.ui.thumb.f;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "getContext", "()Landroid/content/Context;", "halfMarkWidth", "", "markRange", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration$Range;", "markWidth", "offset", "selectIndex", "getSelectIndex", "()I", "setSelectIndex", "(I)V", "touchExtend", "transMarkStatusList", "", "checkClick", "", "x", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "createTransitionMarkView", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "hasTransition", "onDrawOver", "c", "Landroid/graphics/Canvas;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "reset", "updateTransMarkStatus", "", "width", "Range", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RecyclerView.h
{
  public int Fjh;
  private final List<a> Mls;
  private final int Mlt;
  private final f Uop;
  public final int Uoq;
  private final int Uor;
  public final List<Boolean> Uos;
  private final Context context;
  private int offset;
  
  public e(Context paramContext, f paramf)
  {
    AppMethodBeat.i(282872);
    this.context = paramContext;
    this.Uop = paramf;
    this.Uoq = a.fromDPToPix(this.context, 22);
    this.Uor = (this.Uoq / 2);
    this.Mls = ((List)new ArrayList());
    this.Uos = ((List)new ArrayList());
    this.Mlt = a.fromDPToPix(this.context, 16);
    this.Fjh = -1;
    AppMethodBeat.o(282872);
  }
  
  public final void a(float paramFloat, b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(282891);
    s.u(paramb, "callback");
    int m = this.offset;
    if (m > 0) {}
    int k;
    for (int j = 0;; j = k)
    {
      k = j + 1;
      a locala = (a)this.Mls.get(j);
      float f = locala.left;
      int i;
      if (paramFloat <= locala.right) {
        if (f <= paramFloat) {
          i = 1;
        }
      }
      while (i != 0)
      {
        paramb.invoke(Integer.valueOf(((a)this.Mls.get(j)).position));
        AppMethodBeat.o(282891);
        return;
        i = 0;
        continue;
        i = 0;
      }
      if (k >= m)
      {
        paramb.invoke(Integer.valueOf(-1));
        AppMethodBeat.o(282891);
        return;
      }
    }
  }
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(282884);
    s.u(paramCanvas, "c");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    super.b(paramCanvas, paramRecyclerView, params);
    int k = this.Uop.getItemCount();
    this.offset = 0;
    int i = 0;
    int m = paramRecyclerView.getChildCount();
    if (m > 0) {}
    for (;;)
    {
      int j = i + 1;
      params = paramRecyclerView.getChildAt(i);
      int n = RecyclerView.bA(params);
      boolean bool;
      label161:
      label222:
      float f1;
      float f2;
      if ((n > 1) && (n < k - 1)) {
        if (this.Fjh >= 0)
        {
          i = this.Fjh;
          if (n > this.Fjh + 2) {
            break label434;
          }
          if (i + 1 > n) {
            break label428;
          }
          i = 1;
          if (i == 0) {}
        }
        else
        {
          int i1 = params.getLeft();
          params = (Boolean)p.ae(this.Uos, n - 2);
          if (params != null) {
            break label440;
          }
          bool = false;
          params = LayoutInflater.from(this.context).inflate(a.g.vlog_transition_mark_view, (ViewGroup)paramRecyclerView, false);
          ImageView localImageView = (ImageView)params.findViewById(a.f.vlog_transition_mark_icon);
          Context localContext = this.context;
          int i2 = a.h.icons_filled_transform;
          Resources localResources = this.context.getResources();
          if (!bool) {
            break label449;
          }
          i = a.c.Orange;
          localImageView.setImageDrawable(bb.m(localContext, i2, localResources.getColor(i)));
          params.measure(this.Uoq, this.Uoq);
          params.layout(0, 0, this.Uoq, this.Uoq);
          s.s(params, "view");
          float f3 = (paramRecyclerView.getHeight() - this.Uoq) / 2.0F;
          f1 = i1 - this.Uor;
          f2 = i1 + this.Uor;
          paramCanvas.save();
          paramCanvas.translate(f1, f3);
          params.draw(paramCanvas);
          paramCanvas.restore();
          if (this.offset >= this.Mls.size()) {
            break label457;
          }
          params = (a)this.Mls.get(this.offset);
          f3 = this.Mlt;
          float f4 = this.Mlt;
          params.position = (n - 2);
          params.left = (f1 - f3);
          params.right = (f2 + f4);
        }
      }
      for (;;)
      {
        this.offset += 1;
        if (j < m) {
          break label498;
        }
        AppMethodBeat.o(282884);
        return;
        label428:
        i = 0;
        break;
        label434:
        i = 0;
        break;
        label440:
        bool = params.booleanValue();
        break label161;
        label449:
        i = a.c.BW_50;
        break label222;
        label457:
        this.Mls.add(new a(n - 2, f1 - this.Mlt, f2 + this.Mlt));
      }
      label498:
      i = j;
    }
  }
  
  public final void lP(List<Boolean> paramList)
  {
    AppMethodBeat.i(282893);
    s.u(paramList, "transMarkStatusList");
    this.Uos.clear();
    this.Uos.addAll((Collection)paramList);
    AppMethodBeat.o(282893);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration$Range;", "", "position", "", "left", "", "right", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionMarkDecoration;IFF)V", "getLeft", "()F", "setLeft", "(F)V", "getPosition", "()I", "setPosition", "(I)V", "getRight", "setRight", "contains", "", "value", "set", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
  {
    float left;
    int position;
    float right;
    
    public a(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(282846);
      this.position = paramFloat1;
      this.left = paramFloat2;
      Object localObject;
      this.right = localObject;
      AppMethodBeat.o(282846);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.e
 * JD-Core Version:    0.7.0.1
 */