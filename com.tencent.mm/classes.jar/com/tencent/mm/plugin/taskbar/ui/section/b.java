package com.tencent.mm.plugin.taskbar.ui.section;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "getCallback", "()Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "containerView", "getContainerView", "()Landroid/widget/FrameLayout;", "root", "Landroid/view/ViewGroup;", "getRoot", "()Landroid/view/ViewGroup;", "getSectionType", "()I", "title", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTitle", "()Landroid/widget/TextView;", "titleContainer", "getTitleContainer", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "getViewModel", "()Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "setViewModel", "(Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;)V", "addContentView", "", "view", "Landroid/view/View;", "canAddToMinimize", "", "configItemViewHolderOnBind", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getClickedTaskBarItem", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "pos", "notifyDataSetChanged", "onViewAttachedToWindow", "multiTaskInfo", "removeItem", "titleName", "", "tryCloseOnPause", "Callback", "Companion", "plugin-taskbar_release"})
public abstract class b
  extends FrameLayout
{
  public static final b.b FVs = new b.b((byte)0);
  private g FVo;
  private final FrameLayout FVp;
  private final a FVq;
  private final int FVr;
  private HashMap _$_findViewCache;
  private final TextView hbb;
  private final ViewGroup hwr;
  private final ViewGroup xWo;
  
  public b(Context paramContext, a parama, int paramInt1, AttributeSet paramAttributeSet, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt2);
    this.FVq = parama;
    this.FVr = paramInt1;
    paramContext = LayoutInflater.from(paramContext);
    if (this.FVr == 1) {}
    for (paramInt1 = 2131496661;; paramInt1 = 2131496660)
    {
      paramContext = paramContext.inflate(paramInt1, (ViewGroup)this, false);
      if (paramContext != null) {
        break;
      }
      throw new t("null cannot be cast to non-null type android.view.ViewGroup");
    }
    this.hwr = ((ViewGroup)paramContext);
    this.hbb = ((TextView)this.hwr.findViewById(2131309195));
    this.xWo = ((ViewGroup)this.hwr.findViewById(2131309214));
    paramContext = g.FVL;
    this.FVo = g.fvl();
    if (((CharSequence)fvi()).length() == 0)
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label208;
      }
      paramContext = this.xWo;
      p.g(paramContext, "titleContainer");
      paramContext.setVisibility(8);
    }
    for (;;)
    {
      addView((View)this.hwr);
      paramContext = this.hwr.findViewById(2131299174);
      p.g(paramContext, "root.findViewById(R.id.container)");
      this.FVp = ((FrameLayout)paramContext);
      return;
      paramInt1 = 0;
      break;
      label208:
      paramContext = this.xWo;
      p.g(paramContext, "titleContainer");
      paramContext.setVisibility(0);
      paramContext = this.hbb;
      p.g(paramContext, "title");
      paramContext.setText((CharSequence)fvi());
    }
  }
  
  public MultiTaskInfo abH(int paramInt)
  {
    return (MultiTaskInfo)this.FVo.FVI.get(paramInt);
  }
  
  protected boolean abI(int paramInt)
  {
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected final void ad(final RecyclerView.v paramv)
  {
    p.h(paramv, "viewHolder");
    Log.i("MicroMsg.TaskBarSectionBaseView", "configItemViewHolderOnBind %d %d", new Object[] { Integer.valueOf(paramv.lR()), Integer.valueOf(this.FVr) });
    View localView = paramv.aus;
    localView.setTag(2131308919, new com.tencent.mm.ui.widget.b.a(getContext(), localView));
    localView.setOnClickListener((View.OnClickListener)new c(this, paramv));
    localView.setOnLongClickListener((View.OnLongClickListener)new d(this, paramv));
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
  
  public final void fS(View paramView)
  {
    p.h(paramView, "view");
    ((FrameLayout)ewN()).addView(paramView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
  }
  
  public abstract String fvi();
  
  public boolean fvj()
  {
    return true;
  }
  
  protected final a getCallback()
  {
    return this.FVq;
  }
  
  protected final FrameLayout getContainerView()
  {
    return this.FVp;
  }
  
  protected final ViewGroup getRoot()
  {
    return this.hwr;
  }
  
  protected final int getSectionType()
  {
    return this.FVr;
  }
  
  protected final TextView getTitle()
  {
    return this.hbb;
  }
  
  protected final ViewGroup getTitleContainer()
  {
    return this.xWo;
  }
  
  public final g getViewModel()
  {
    return this.FVo;
  }
  
  public abstract void notifyDataSetChanged();
  
  public final void o(MultiTaskInfo paramMultiTaskInfo)
  {
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    this.FVq.n(paramMultiTaskInfo);
  }
  
  protected void removeItem(int paramInt) {}
  
  public final void setViewModel(g paramg)
  {
    p.h(paramg, "<set-?>");
    this.FVo = paramg;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "", "disableScroll", "", "disable", "", "getTaskBarContainerBottom", "", "isLandscape", "onItemClicked", "tryCloseOnPause", "onLastItemRemoved", "sectionType", "onSectionHeightChange", "reportOnItemAppear", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "reportOnItemClicked", "pos", "plugin-taskbar_release"})
  public static abstract interface a
  {
    public abstract void a(MultiTaskInfo paramMultiTaskInfo, int paramInt);
    
    public abstract void abA(int paramInt);
    
    public abstract void abE(int paramInt);
    
    public abstract void jd(boolean paramBoolean);
    
    public abstract void n(MultiTaskInfo paramMultiTaskInfo);
    
    public abstract void wo(boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(b paramb, RecyclerView.v paramv) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(238494);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      int i = paramv.lR();
      if (i >= this.FVt.getViewModel().FVI.size())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(238494);
        return;
      }
      this.FVt.getCallback().jd(this.FVt.abI(i));
      this.FVt.getCallback().a((MultiTaskInfo)this.FVt.getViewModel().FVI.get(i), i);
      ((PluginTaskBar)com.tencent.mm.kernel.g.ah(PluginTaskBar.class)).notifyClickTaskBarItem$plugin_taskbar_release(this.FVt.abH(i));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(238494);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$1$2"})
  static final class d
    implements View.OnLongClickListener
  {
    d(b paramb, RecyclerView.v paramv) {}
    
    public final boolean onLongClick(final View paramView)
    {
      AppMethodBeat.i(238498);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (com.tencent.mm.plugin.taskbar.ui.c.b.hq(this.FVt.getContext()))
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(238498);
        return false;
      }
      final int i = paramv.lR();
      if (i >= this.FVt.getViewModel().FVI.size())
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(238498);
        return false;
      }
      localObject = (com.tencent.mm.ui.widget.b.a)paramView.getTag(2131308919);
      final View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(238495);
          if ((ao.isMultiTaskMode()) && (this.FVu.FVt.fvj()) && (paramAnonymousContextMenu != null)) {
            paramAnonymousContextMenu.add(0, 0, 0, 2131755720);
          }
          if (paramAnonymousContextMenu != null)
          {
            paramAnonymousContextMenu.add(0, 1, 0, 2131755727);
            AppMethodBeat.o(238495);
            return;
          }
          AppMethodBeat.o(238495);
        }
      };
      final o.g localg = (o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(238496);
          if ((ao.isMultiTaskMode()) && (this.FVu.FVt.fvj())) {
            switch (paramAnonymousInt)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(238496);
            return;
            paramAnonymousInt = 1;
            break;
            paramAnonymousMenuItem = (PluginTaskBar)com.tencent.mm.kernel.g.ah(PluginTaskBar.class);
            String str = ((MultiTaskInfo)this.FVu.FVt.getViewModel().FVI.get(i)).field_id;
            p.g(str, "viewModel.showDataList[pos].field_id");
            paramAnonymousMenuItem.addToMultiTask(str);
            u.cG(this.FVu.FVt.getContext(), com.tencent.mm.cb.a.aI(this.FVu.FVt.getContext(), 2131755722));
            AppMethodBeat.o(238496);
            return;
            this.FVu.FVt.removeItem(i);
          }
        }
      };
      if (localObject != null)
      {
        ((com.tencent.mm.ui.widget.b.a)localObject).setOnDismissListener((PopupWindow.OnDismissListener)new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(238497);
            this.FVu.FVt.getCallback().wo(false);
            AppMethodBeat.o(238497);
          }
        });
        this.FVt.getCallback().wo(true);
        ((com.tencent.mm.ui.widget.b.a)localObject).a(paramView, localOnCreateContextMenuListener, localg, 0, 0);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(238498);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.b
 * JD-Core Version:    0.7.0.1
 */