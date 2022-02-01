package com.tencent.mm.plugin.taskbar.ui.section;

import android.annotation.SuppressLint;
import android.content.Context;
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
import android.widget.FrameLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.d.d;
import com.tencent.mm.plugin.taskbar.d.e;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "getCallback", "()Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "containerView", "getContainerView", "()Landroid/widget/FrameLayout;", "root", "Landroid/view/ViewGroup;", "getRoot", "()Landroid/view/ViewGroup;", "getSectionType", "()I", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "getViewModel", "()Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "setViewModel", "(Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;)V", "addContentView", "", "view", "Landroid/view/View;", "canAddToMinimize", "", "pos", "configItemViewHolderOnBind", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getClickedTaskBarItem", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "notifyDataSetChanged", "onViewAttachedToWindow", "multiTaskInfo", "removeItem", "titleName", "", "tryCloseOnPause", "Callback", "Companion", "plugin-taskbar_release"})
public abstract class b
  extends FrameLayout
{
  public static final b.b MqN = new b.b((byte)0);
  d MqJ;
  private final FrameLayout MqK;
  private final a MqL;
  private final int MqM;
  private HashMap _$_findViewCache;
  private final TextView jMg;
  private final ViewGroup kiF;
  
  public b(Context paramContext, a parama, int paramInt1, AttributeSet paramAttributeSet, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt2);
    this.MqL = parama;
    this.MqM = paramInt1;
    parama = d.MqY;
    this.MqJ = d.gkh();
    switch (this.MqM)
    {
    case 4: 
    default: 
      paramInt1 = d.e.MmE;
    }
    for (;;)
    {
      paramContext = LayoutInflater.from(paramContext).inflate(paramInt1, (ViewGroup)this, false);
      if (paramContext != null) {
        break;
      }
      throw new t("null cannot be cast to non-null type android.view.ViewGroup");
      paramInt1 = d.e.MmH;
      continue;
      paramInt1 = d.e.MmF;
      continue;
      paramInt1 = d.e.MmG;
    }
    this.kiF = ((ViewGroup)paramContext);
    if (((CharSequence)gkg()).length() > 0)
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label243;
      }
      this.jMg = ((TextView)this.kiF.findViewById(d.d.title));
      paramContext = this.jMg;
      p.j(paramContext, "title");
      paramContext.setText((CharSequence)gkg());
    }
    for (;;)
    {
      addView((View)this.kiF);
      paramContext = this.kiF.findViewById(d.d.container);
      p.j(paramContext, "root.findViewById(R.id.container)");
      this.MqK = ((FrameLayout)paramContext);
      return;
      paramInt1 = 0;
      break;
      label243:
      this.jMg = null;
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void ae(final RecyclerView.v paramv)
  {
    p.k(paramv, "viewHolder");
    Log.i("MicroMsg.TaskBarSectionBaseView", "configItemViewHolderOnBind %d %d", new Object[] { Integer.valueOf(paramv.md()), Integer.valueOf(this.MqM) });
    View localView = paramv.amk;
    localView.setTag(d.d.desktop_pop_menu, new com.tencent.mm.ui.widget.b.a(getContext(), localView));
    localView.setOnClickListener((View.OnClickListener)new c(this, paramv));
    localView.setOnLongClickListener((View.OnLongClickListener)new d(this, paramv));
  }
  
  public boolean aja(int paramInt)
  {
    return true;
  }
  
  protected boolean ajb(int paramInt)
  {
    return false;
  }
  
  protected final a getCallback()
  {
    return this.MqL;
  }
  
  protected final FrameLayout getContainerView()
  {
    return this.MqK;
  }
  
  protected final ViewGroup getRoot()
  {
    return this.kiF;
  }
  
  protected final int getSectionType()
  {
    return this.MqM;
  }
  
  protected final TextView getTitle()
  {
    return this.jMg;
  }
  
  public final d getViewModel()
  {
    return this.MqJ;
  }
  
  public abstract String gkg();
  
  public abstract void notifyDataSetChanged();
  
  public final void o(MultiTaskInfo paramMultiTaskInfo)
  {
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    this.MqL.n(paramMultiTaskInfo);
  }
  
  protected void removeItem(int paramInt) {}
  
  public final void setViewModel(d paramd)
  {
    p.k(paramd, "<set-?>");
    this.MqJ = paramd;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "", "disableScroll", "", "disable", "", "getTaskBarContainerBottom", "", "isLandscape", "onItemClicked", "tryCloseOnPause", "onSearchClick", "onSectionHeightChange", "sectionType", "reportOnItemAppear", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "reportOnItemClicked", "pos", "plugin-taskbar_release"})
  public static abstract interface a
  {
    public abstract void a(MultiTaskInfo paramMultiTaskInfo, int paramInt);
    
    public abstract void aiX(int paramInt);
    
    public abstract void gjI();
    
    public abstract void n(MultiTaskInfo paramMultiTaskInfo);
    
    public abstract void zV(boolean paramBoolean);
    
    public abstract void zW(boolean paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(b paramb, RecyclerView.v paramv) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(214910);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      int i = paramv.md();
      if ((i < 0) || (i >= this.MqO.getViewModel().MqV.size()))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(214910);
        return;
      }
      this.MqO.getCallback().zW(this.MqO.ajb(i));
      this.MqO.getCallback().a((MultiTaskInfo)this.MqO.getViewModel().MqV.get(i), i);
      ((PluginTaskBar)h.ag(PluginTaskBar.class)).notifyClickTaskBarItem$plugin_taskbar_release((MultiTaskInfo)this.MqO.MqJ.MqV.get(i));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(214910);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$1$2"})
  static final class d
    implements View.OnLongClickListener
  {
    d(b paramb, RecyclerView.v paramv) {}
    
    public final boolean onLongClick(final View paramView)
    {
      AppMethodBeat.i(215312);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (com.tencent.mm.plugin.taskbar.ui.c.b.iq(this.MqO.getContext()))
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(215312);
        return false;
      }
      final int i = paramv.md();
      if ((i < 0) || (i >= this.MqO.getViewModel().MqV.size()))
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(215312);
        return false;
      }
      localObject = (com.tencent.mm.ui.widget.b.a)paramView.getTag(d.d.desktop_pop_menu);
      if ((ar.isMultiTaskMode()) && (this.MqO.aja(i))) {}
      for (final boolean bool = true;; bool = false)
      {
        final View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(215724);
            if ((this.MqP) && (paramAnonymousContextMenu != null)) {
              paramAnonymousContextMenu.add(0, 0, 0, d.g.MmJ);
            }
            if (paramAnonymousContextMenu != null)
            {
              paramAnonymousContextMenu.add(0, 1, 0, d.g.MmQ);
              AppMethodBeat.o(215724);
              return;
            }
            AppMethodBeat.o(215724);
          }
        };
        final q.g localg = (q.g)new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(215674);
            if (bool) {
              switch (paramAnonymousInt)
              {
              }
            }
            for (;;)
            {
              AppMethodBeat.o(215674);
              return;
              paramAnonymousInt = 1;
              break;
              paramAnonymousMenuItem = (PluginTaskBar)h.ag(PluginTaskBar.class);
              String str = ((MultiTaskInfo)this.MqQ.MqO.getViewModel().MqV.get(i)).field_id;
              p.j(str, "viewModel.showDataList[pos].field_id");
              paramAnonymousMenuItem.addToMultiTask(str);
              w.cR(this.MqQ.MqO.getContext(), com.tencent.mm.ci.a.ba(this.MqQ.MqO.getContext(), d.g.MmM));
              AppMethodBeat.o(215674);
              return;
              this.MqQ.MqO.removeItem(i);
            }
          }
        };
        if (localObject != null)
        {
          ((com.tencent.mm.ui.widget.b.a)localObject).setOnDismissListener((PopupWindow.OnDismissListener)new PopupWindow.OnDismissListener()
          {
            public final void onDismiss()
            {
              AppMethodBeat.i(214342);
              this.MqQ.MqO.getCallback().zV(false);
              AppMethodBeat.o(214342);
            }
          });
          this.MqO.getCallback().zV(true);
          ((com.tencent.mm.ui.widget.b.a)localObject).a(paramView, localOnCreateContextMenuListener, localg, 0, 0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$configItemViewHolderOnBind$$inlined$let$lambda$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(215312);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.b
 * JD-Core Version:    0.7.0.1
 */