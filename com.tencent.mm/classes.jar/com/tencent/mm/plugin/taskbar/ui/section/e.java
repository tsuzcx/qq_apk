package com.tencent.mm.plugin.taskbar.ui.section;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.d;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView$Adapter;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "recyclerView", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView$UnClipRecyclerView;", "thumbLoaderOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getThumbLoaderOption", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "initView", "", "notifyDataSetChanged", "onBindViewHolder", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView$BaseViewHolder;", "pos", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "removeItem", "reportViewAttachOnWindow", "Adapter", "BaseViewHolder", "UnClipRecyclerView", "plugin-taskbar_release"})
public abstract class e
  extends b
{
  private final com.tencent.mm.loader.c.e Aer;
  private final e.c FVA;
  private final a FVB;
  private HashMap _$_findViewCache;
  private final LinearLayoutManager vKp;
  
  public e(Context paramContext, b.a parama, int paramInt1, AttributeSet paramAttributeSet, int paramInt2)
  {
    super(paramContext, parama, paramInt1, null, 0);
    parama = new com.tencent.mm.loader.c.e.a();
    parama.hZJ = true;
    parama.hZI = true;
    this.Aer = parama.aJT();
    this.FVA = new e.c(paramContext);
    this.vKp = new LinearLayoutManager();
    this.FVB = new a();
    fS((View)this.FVA);
    paramContext = this.FVA;
    parama = this.vKp;
    parama.setOrientation(1);
    paramContext.setLayoutManager((RecyclerView.LayoutManager)parama);
    this.FVA.setAdapter((RecyclerView.a)this.FVB);
    this.FVA.setOverScrollMode(2);
    this.FVA.setItemAnimator(null);
    this.FVA.b((RecyclerView.h)new d(this));
  }
  
  public e.b K(ViewGroup paramViewGroup)
  {
    p.h(paramViewGroup, "p0");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496655, paramViewGroup, false);
    p.g(paramViewGroup, "LayoutInflater.from(p0.c…bar_list_item, p0, false)");
    return new e.b(paramViewGroup);
  }
  
  public abstract void a(e.b paramb, int paramInt);
  
  public final void abJ(int paramInt)
  {
    super.o((MultiTaskInfo)getViewModel().FVI.get(paramInt));
  }
  
  public View ewN()
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(2131299174));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(2131299174);
      this._$_findViewCache.put(Integer.valueOf(2131299174), localView1);
    }
    return localView1;
  }
  
  protected final com.tencent.mm.loader.c.e getThumbLoaderOption()
  {
    return this.Aer;
  }
  
  public final void notifyDataSetChanged()
  {
    this.FVB.notifyDataSetChanged();
  }
  
  protected final void removeItem(int paramInt)
  {
    MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)getViewModel().FVI.remove(paramInt);
    ((PluginTaskBar)com.tencent.mm.kernel.g.ah(PluginTaskBar.class)).notifyRemoveTaskBarItem$plugin_taskbar_release(localMultiTaskInfo);
    ((d)com.tencent.mm.kernel.g.ah(d.class)).removeTaskInfo(localMultiTaskInfo.field_id, true, 3);
    if (getViewModel().FVI.size() != 0)
    {
      this.FVB.ck(paramInt);
      getCallback().abE(getSectionType());
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView$Adapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView$BaseViewHolder;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView;)V", "getItemCount", "", "onBindViewHolder", "", "p0", "p1", "onCreateViewHolder", "Landroid/view/ViewGroup;", "plugin-taskbar_release"})
  public final class a
    extends RecyclerView.a<e.b>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(238508);
      int i = this.FVC.getViewModel().FVI.size();
      AppMethodBeat.o(238508);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView$initView$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "drawable", "Landroid/graphics/drawable/Drawable;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "plugin-taskbar_release"})
  public static final class d
    extends RecyclerView.h
  {
    private final Drawable drawable;
    
    d()
    {
      AppMethodBeat.i(238514);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(a.n(this.FVC.getContext(), 2131099674));
      localGradientDrawable.setShape(0);
      localGradientDrawable.setSize(0, 1);
      this.drawable = ((Drawable)localGradientDrawable);
      AppMethodBeat.o(238514);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(238513);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      int i = RecyclerView.bw(paramView);
      paramRect.top = this.drawable.getIntrinsicHeight();
      if (i == paramRecyclerView.getChildCount() - 1) {
        paramRect.bottom = this.drawable.getIntrinsicHeight();
      }
      AppMethodBeat.o(238513);
    }
    
    public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(238512);
      p.h(paramCanvas, "c");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      int k = paramRecyclerView.getChildCount();
      int i = 0;
      while (i < k)
      {
        params = this.FVC.getContext();
        if (i == 0) {}
        int m;
        for (int j = 2131165299;; j = 2131165280)
        {
          m = a.aG(params, j);
          j = paramRecyclerView.getWidth() - a.aG(this.FVC.getContext(), 2131165299);
          params = paramRecyclerView.getChildAt(i);
          p.g(params, "parent.getChildAt(i)");
          localObject = params.getLayoutParams();
          if (localObject != null) {
            break;
          }
          paramCanvas = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
          AppMethodBeat.o(238512);
          throw paramCanvas;
        }
        Object localObject = (RecyclerView.LayoutParams)localObject;
        int n = params.getTop() - ((RecyclerView.LayoutParams)localObject).topMargin - this.drawable.getIntrinsicHeight();
        int i1 = this.drawable.getIntrinsicHeight();
        this.drawable.setBounds(m, n, j, i1 + n);
        this.drawable.draw(paramCanvas);
        if (i == paramRecyclerView.getChildCount() - 1)
        {
          m = a.aG(this.FVC.getContext(), 2131165299);
          n = params.getBottom();
          n = ((RecyclerView.LayoutParams)localObject).bottomMargin + n;
          i1 = this.drawable.getIntrinsicHeight();
          this.drawable.setBounds(m, n, j, i1 + n);
          this.drawable.draw(paramCanvas);
        }
        i += 1;
      }
      AppMethodBeat.o(238512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.e
 * JD-Core Version:    0.7.0.1
 */