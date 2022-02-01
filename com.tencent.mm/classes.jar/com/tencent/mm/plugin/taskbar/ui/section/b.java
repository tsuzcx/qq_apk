package com.tencent.mm.plugin.taskbar.ui.section;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.d.d;
import com.tencent.mm.plugin.taskbar.d.e;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "getCallback", "()Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "containerView", "getContainerView", "()Landroid/widget/FrameLayout;", "root", "Landroid/view/ViewGroup;", "getRoot", "()Landroid/view/ViewGroup;", "getSectionType", "()I", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "getViewModel", "()Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "setViewModel", "(Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;)V", "addContentView", "", "view", "Landroid/view/View;", "canAddToMinimize", "", "pos", "configItemViewHolderOnBind", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getClickedTaskBarItem", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "notifyDataSetChanged", "onViewAttachedToWindow", "multiTaskInfo", "removeItem", "titleName", "", "tryCloseOnPause", "Callback", "Companion", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  extends FrameLayout
{
  public static final b.b STV = new b.b((byte)0);
  private final a STW;
  private final int STX;
  private d STY;
  private final FrameLayout STZ;
  private final ViewGroup mJe;
  private final TextView mll;
  
  public b(Context paramContext, a parama, int paramInt1, AttributeSet paramAttributeSet, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt2);
    this.STW = parama;
    this.STX = paramInt1;
    parama = d.SUa;
    this.STY = d.hEg();
    switch (this.STX)
    {
    case 4: 
    default: 
      paramInt1 = d.e.SPW;
    }
    for (;;)
    {
      paramContext = LayoutInflater.from(paramContext).inflate(paramInt1, (ViewGroup)this, false);
      if (paramContext != null) {
        break;
      }
      throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      paramInt1 = d.e.SPZ;
      continue;
      paramInt1 = d.e.SPX;
      continue;
      paramInt1 = d.e.SPY;
    }
    this.mJe = ((ViewGroup)paramContext);
    if (((CharSequence)hEf()).length() > 0)
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label240;
      }
      this.mll = ((TextView)this.mJe.findViewById(d.d.title));
      this.mll.setText((CharSequence)hEf());
    }
    for (;;)
    {
      setImportantForAccessibility(2);
      addView((View)this.mJe);
      paramContext = this.mJe.findViewById(d.d.container);
      s.s(paramContext, "root.findViewById(R.id.container)");
      this.STZ = ((FrameLayout)paramContext);
      return;
      paramInt1 = 0;
      break;
      label240:
      this.mll = null;
    }
  }
  
  private static final void a(RecyclerView.v paramv, b paramb, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramv);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramv, "$viewHolder");
    s.u(paramb, "this$0");
    int i = paramv.KJ();
    if ((i < 0) || (i >= paramb.getViewModel().SUd.size()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
    paramb.getCallback().Fn(paramb.aod(i));
    paramb.getCallback().a((MultiTaskInfo)paramb.getViewModel().SUd.get(i), i);
    ((PluginTaskBar)h.az(PluginTaskBar.class)).notifyClickTaskBarItem$plugin_taskbar_release((MultiTaskInfo)paramb.STY.SUd.get(i));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final void a(b paramb)
  {
    s.u(paramb, "this$0");
    paramb.getCallback().Fm(false);
  }
  
  private static final void a(boolean paramBoolean, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if ((paramBoolean) && (paramContextMenu != null)) {
      paramContextMenu.add(0, 0, 0, d.g.SQb);
    }
    if (paramContextMenu != null) {
      paramContextMenu.add(0, 1, 0, d.g.SQj);
    }
  }
  
  private static final void a(boolean paramBoolean, b paramb, int paramInt1, MenuItem paramMenuItem, int paramInt2)
  {
    s.u(paramb, "this$0");
    if (paramBoolean) {}
    for (;;)
    {
      switch (paramInt2)
      {
      default: 
        return;
        paramInt2 = 1;
      }
    }
    paramMenuItem = (PluginTaskBar)h.az(PluginTaskBar.class);
    String str = ((MultiTaskInfo)paramb.getViewModel().SUd.get(paramInt1)).field_id;
    s.s(str, "viewModel.showDataList[pos].field_id");
    paramMenuItem.addToMultiTask(str);
    aa.db(paramb.getContext(), com.tencent.mm.cd.a.bt(paramb.getContext(), d.g.SQe));
    return;
    paramb.removeItem(paramInt1);
  }
  
  private static final boolean a(b paramb, RecyclerView.v paramv, View paramView)
  {
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramv);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramb, "this$0");
    s.u(paramv, "$viewHolder");
    localObject1 = paramb.getContext();
    if ((localObject1 instanceof Activity))
    {
      localObject1 = ((ViewGroup)((Activity)localObject1).getWindow().getDecorView()).findViewById(16908290);
      if (localObject1 != null)
      {
        localObject2 = new Rect();
        ((View)localObject1).getGlobalVisibleRect((Rect)localObject2);
        if (((Rect)localObject2).left <= 0) {}
      }
    }
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      return false;
    }
    i = paramv.KJ();
    if ((i < 0) || (i >= paramb.getViewModel().SUd.size()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      return false;
    }
    paramv = (com.tencent.mm.ui.widget.b.a)paramView.getTag(d.d.desktop_pop_menu);
    if ((aw.isMultiTaskMode()) && (paramb.aoc(i))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new b..ExternalSyntheticLambda1(bool);
      localObject2 = new b..ExternalSyntheticLambda4(bool, paramb, i);
      if (paramv != null)
      {
        paramv.afLp = new b..ExternalSyntheticLambda3(paramb);
        paramb.getCallback().Fm(true);
        paramv.a(paramView, (View.OnCreateContextMenuListener)localObject1, (u.i)localObject2, 0, 0);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      return true;
    }
  }
  
  public final void Z(RecyclerView.v paramv)
  {
    s.u(paramv, "viewHolder");
    Log.i("MicroMsg.TaskBarSectionBaseView", "configItemViewHolderOnBind %d %d", new Object[] { Integer.valueOf(paramv.KJ()), Integer.valueOf(this.STX) });
    View localView = paramv.caK;
    localView.setTag(d.d.desktop_pop_menu, new com.tencent.mm.ui.widget.b.a(getContext(), localView));
    localView.setOnClickListener(new b..ExternalSyntheticLambda0(paramv, this));
    localView.setOnLongClickListener(new b..ExternalSyntheticLambda2(this, paramv));
  }
  
  public boolean aoc(int paramInt)
  {
    return true;
  }
  
  protected boolean aod(int paramInt)
  {
    return false;
  }
  
  protected final a getCallback()
  {
    return this.STW;
  }
  
  protected final FrameLayout getContainerView()
  {
    return this.STZ;
  }
  
  protected final ViewGroup getRoot()
  {
    return this.mJe;
  }
  
  protected final int getSectionType()
  {
    return this.STX;
  }
  
  protected final TextView getTitle()
  {
    return this.mll;
  }
  
  public final d getViewModel()
  {
    return this.STY;
  }
  
  public abstract String hEf();
  
  public abstract void notifyDataSetChanged();
  
  public final void o(MultiTaskInfo paramMultiTaskInfo)
  {
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    this.STW.n(paramMultiTaskInfo);
  }
  
  protected void removeItem(int paramInt) {}
  
  public final void setViewModel(d paramd)
  {
    s.u(paramd, "<set-?>");
    this.STY = paramd;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "", "disableScroll", "", "disable", "", "getTaskBarContainerBottom", "", "isLandscape", "onItemClicked", "tryCloseOnPause", "onSearchClick", "onSectionHeightChange", "sectionType", "reportOnItemAppear", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "exp_type", "page_type", "page", "iconAppId", "", "reportOnItemClicked", "pos", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void Fm(boolean paramBoolean);
    
    public abstract void Fn(boolean paramBoolean);
    
    public abstract void a(MultiTaskInfo paramMultiTaskInfo, int paramInt);
    
    public abstract void anZ(int paramInt);
    
    public abstract void bdj(String paramString);
    
    public abstract void hDI();
    
    public abstract void n(MultiTaskInfo paramMultiTaskInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.b
 * JD-Core Version:    0.7.0.1
 */