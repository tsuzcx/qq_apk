package com.tencent.mm.plugin.taskbar.ui.section;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.view.recyclerview.h;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView$Adapter;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "initView", "", "notifyDataSetChanged", "onBindViewHolder", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView$BaseViewHolder;", "pos", "onCreateViewHolder", "view", "Landroid/view/ViewGroup;", "onFinderViewAttachedToWindow", "holder", "removeItem", "Adapter", "BaseViewHolder", "plugin-taskbar_release"})
public abstract class d
  extends b
{
  private final a FVy;
  private HashMap _$_findViewCache;
  private final RecyclerView hak;
  private final LinearLayoutManager vKp;
  
  public d(Context paramContext, b.a parama, int paramInt1, AttributeSet paramAttributeSet, int paramInt2)
  {
    super(paramContext, parama, paramInt1, null, 0);
    this.hak = new RecyclerView(paramContext);
    this.vKp = new LinearLayoutManager();
    this.FVy = new a();
    fS((View)this.hak);
    paramContext = this.hak;
    parama = this.vKp;
    parama.setOrientation(0);
    paramContext.setLayoutManager((RecyclerView.LayoutManager)parama);
    this.hak.setAdapter((RecyclerView.a)this.FVy);
    this.hak.b((RecyclerView.h)new c(this));
    this.hak.setOverScrollMode(2);
    new f().f(this.hak);
  }
  
  public abstract b J(ViewGroup paramViewGroup);
  
  public final void a(b paramb)
  {
    p.h(paramb, "holder");
    super.o((MultiTaskInfo)getViewModel().FVI.get(paramb.lR()));
  }
  
  public abstract void a(b paramb, int paramInt);
  
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
  
  public final void notifyDataSetChanged()
  {
    this.FVy.notifyDataSetChanged();
    RecyclerView localRecyclerView = this.hak;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.axQ(), "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView", "notifyDataSetChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView", "notifyDataSetChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
  }
  
  protected void removeItem(int paramInt)
  {
    MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)getViewModel().FVI.remove(paramInt);
    ((PluginTaskBar)com.tencent.mm.kernel.g.ah(PluginTaskBar.class)).notifyRemoveTaskBarItem$plugin_taskbar_release(localMultiTaskInfo);
    ((com.tencent.mm.plugin.taskbar.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.taskbar.d.class)).removeTaskInfo(localMultiTaskInfo.field_id, true, 3);
    if (getViewModel().FVI.size() != 0) {
      this.FVy.ck(paramInt);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView$Adapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView$BaseViewHolder;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView;)V", "getItemCount", "", "onBindViewHolder", "", "p0", "p1", "onCreateViewHolder", "Landroid/view/ViewGroup;", "plugin-taskbar_release"})
  public final class a
    extends RecyclerView.a<d.b>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(238503);
      int i = this.FVz.getViewModel().FVI.size();
      AppMethodBeat.o(238503);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView$BaseViewHolder;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "plugin-taskbar_release"})
  public static class b
    extends h
  {
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(238504);
      AppMethodBeat.o(238504);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionFinderView$initView$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-taskbar_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(238505);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      int j = RecyclerView.bw(paramView);
      int i = j;
      if (j == -1)
      {
        paramView = paramRecyclerView.bi(paramView);
        p.g(paramView, "parent.getChildViewHolder(view)");
        i = paramView.lS();
      }
      if (i > 0) {
        paramRect.left = com.tencent.mm.cb.a.aH(this.FVz.getContext(), 2131165586);
      }
      if (i == 0) {
        paramRect.left = com.tencent.mm.cb.a.aH(this.FVz.getContext(), 2131165299);
      }
      if (i == this.FVz.getViewModel().FVI.size() - 1) {
        paramRect.right = com.tencent.mm.cb.a.aH(this.FVz.getContext(), 2131165299);
      }
      AppMethodBeat.o(238505);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.d
 * JD-Core Version:    0.7.0.1
 */