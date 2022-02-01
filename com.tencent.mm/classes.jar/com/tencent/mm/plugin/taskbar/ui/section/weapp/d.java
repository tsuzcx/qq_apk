package com.tencent.mm.plugin.taskbar.ui.section.weapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.a;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.ui.section.b;
import com.tencent.mm.plugin.taskbar.ui.section.b.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "moreView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "getMoreView", "()Landroid/widget/RelativeLayout;", "recyclerView", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView;", "value", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;", "weAppCallback", "getWeAppCallback", "()Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;", "setWeAppCallback", "(Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;)V", "createRecyclerView", "getShowCount", "getShowLines", "getShowList", "", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "", "isInLongPress", "", "notifyDataSetChanged", "", "notifyTaskBarClosed", "inDesktop", "onClickMore", "onWeAppMarginUpdate", "margin", "", "setDataList", "list", "titleName", "", "tryCloseOnPause", "pos", "updateMoreView", "Companion", "SectionWeAppCallbackWrap", "plugin-taskbar_release"})
@SuppressLint({"ViewConstructor"})
public class d
  extends b
{
  public static final d.b MrU;
  public final TaskBarSectionWeAppRecyclerView MrR;
  private final RelativeLayout MrS;
  private TaskBarSectionWeAppRecyclerView.b MrT;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(215278);
    MrU = new d.b((byte)0);
    AppMethodBeat.o(215278);
  }
  
  public d(Context paramContext, b.a parama, int paramInt, byte paramByte)
  {
    this(paramContext, parama, paramInt);
  }
  
  public d(Context paramContext, b.a parama, int paramInt1, AttributeSet paramAttributeSet, int paramInt2)
  {
    super(paramContext, parama, paramInt1, null, 0);
    AppMethodBeat.i(215274);
    this.MrR = gkl();
    paramContext = getRoot().findViewById(com.tencent.mm.plugin.taskbar.d.d.srX);
    parama = (RelativeLayout)paramContext;
    parama.setOnClickListener((View.OnClickListener)new d.a(this));
    parama.setOnLongClickListener((View.OnLongClickListener)new d.d(parama));
    this.MrS = ((RelativeLayout)paramContext);
    ((FrameLayout)_$_findCachedViewById(com.tencent.mm.plugin.taskbar.d.d.container)).addView((View)this.MrR, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(215274);
  }
  
  public static final String il(List<? extends AppBrandDesktopView.a> paramList)
  {
    AppMethodBeat.i(215281);
    p.k(paramList, "items");
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      AppBrandDesktopView.a locala = (AppBrandDesktopView.a)paramList.next();
      localStringBuilder.append(locala.cnz().nickname + ',');
    }
    paramList = localStringBuilder.toString();
    p.j(paramList, "result.toString()");
    AppMethodBeat.o(215281);
    return paramList;
  }
  
  public final void Ab(boolean paramBoolean)
  {
    AppMethodBeat.i(215263);
    if (!paramBoolean) {
      this.MrR.gko();
    }
    AppMethodBeat.o(215263);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(215280);
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
    AppMethodBeat.o(215280);
    return localView1;
  }
  
  public final boolean ajb(int paramInt)
  {
    return true;
  }
  
  public void cm(float paramFloat) {}
  
  protected final RelativeLayout getMoreView()
  {
    return this.MrS;
  }
  
  protected final TaskBarSectionWeAppRecyclerView getRecyclerView()
  {
    return this.MrR;
  }
  
  public final int getShowCount()
  {
    AppMethodBeat.i(215266);
    int i = this.MrR.getShowCount();
    AppMethodBeat.o(215266);
    return i;
  }
  
  public final int getShowLines()
  {
    AppMethodBeat.i(215269);
    int i = this.MrR.getShowLines();
    AppMethodBeat.o(215269);
    return i;
  }
  
  public final List<AppBrandDesktopView.a> getShowList()
  {
    AppMethodBeat.i(215267);
    List localList = this.MrR.getShowList();
    AppMethodBeat.o(215267);
    return localList;
  }
  
  public final TaskBarSectionWeAppRecyclerView.b getWeAppCallback()
  {
    return this.MrT;
  }
  
  public String gkg()
  {
    AppMethodBeat.i(215258);
    String str = getContext().getString(d.g.Mnb);
    p.j(str, "context.getString(R.stri…nd_taskbar_section_weapp)");
    AppMethodBeat.o(215258);
    return str;
  }
  
  public TaskBarSectionWeAppRecyclerView gkl()
  {
    AppMethodBeat.i(215256);
    TaskBarSectionWeAppRecyclerView localTaskBarSectionWeAppRecyclerView = new TaskBarSectionWeAppRecyclerView(getContext());
    AppMethodBeat.o(215256);
    return localTaskBarSectionWeAppRecyclerView;
  }
  
  public void gkm()
  {
    AppMethodBeat.i(215255);
    TaskBarSectionWeAppRecyclerView.b localb = this.MrT;
    if (localb != null)
    {
      localb.gjL();
      AppMethodBeat.o(215255);
      return;
    }
    AppMethodBeat.o(215255);
  }
  
  public final void gkp()
  {
    int i = 8;
    AppMethodBeat.i(215260);
    RelativeLayout localRelativeLayout = this.MrS;
    p.j(localRelativeLayout, "moreView");
    if (this.MrR.getDataList().size() > 8) {
      i = 0;
    }
    localRelativeLayout.setVisibility(i);
    AppMethodBeat.o(215260);
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(215265);
    gkp();
    this.MrR.cnv();
    AppMethodBeat.o(215265);
  }
  
  public final void setDataList(List<? extends AppBrandDesktopView.a> paramList)
  {
    AppMethodBeat.i(215270);
    this.MrR.setDataList(paramList);
    AppMethodBeat.o(215270);
  }
  
  public final void setWeAppCallback(TaskBarSectionWeAppRecyclerView.b paramb)
  {
    AppMethodBeat.i(215253);
    if (paramb != null)
    {
      this.MrT = ((TaskBarSectionWeAppRecyclerView.b)new c(paramb));
      this.MrR.setWeAppCallback(this.MrT);
      AppMethodBeat.o(215253);
      return;
    }
    AppMethodBeat.o(215253);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$SectionWeAppCallbackWrap;", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;", "delegate", "(Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView;Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;)V", "getDelegate", "()Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;", "notifyMyWeAppChanged", "", "pos", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "kotlin.jvm.PlatformType", "onClick", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "position", "isMyWeApp", "", "onDragStateChange", "isStart", "onDragToPosition", "x", "", "y", "onMyWeAppClick", "onMyWeAppDeleted", "onRecentWeAppClick", "onViewAttachedToWindow", "onWeAppDeleted", "onWeAppMarginUpdate", "margin", "plugin-taskbar_release"})
  public final class c
    implements TaskBarSectionWeAppRecyclerView.b
  {
    private final TaskBarSectionWeAppRecyclerView.b MrW;
    
    public c()
    {
      AppMethodBeat.i(215241);
      this.MrW = localObject;
      AppMethodBeat.o(215241);
    }
    
    public final void a(int paramInt, AppBrandDesktopView.a parama)
    {
      AppMethodBeat.i(215243);
      this.MrW.a(paramInt, parama);
      AppMethodBeat.o(215243);
    }
    
    public final void a(RecyclerView.v paramv, View paramView, AppBrandDesktopView.a parama, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(215245);
      this.MrW.a(paramv, paramView, parama, paramInt, paramBoolean);
      AppMethodBeat.o(215245);
    }
    
    public final void a(AppBrandDesktopView.a parama, int paramInt)
    {
      AppMethodBeat.i(215239);
      this.MrW.a(parama, paramInt);
      d.this.gkp();
      AppMethodBeat.o(215239);
    }
    
    public final void a(AppBrandDesktopView.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(215250);
      this.MrW.a(parama, paramBoolean);
      AppMethodBeat.o(215250);
    }
    
    public final boolean ar(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(215247);
      boolean bool = this.MrW.ar(paramFloat1, paramFloat2);
      AppMethodBeat.o(215247);
      return bool;
    }
    
    public final void b(AppBrandDesktopView.a parama, int paramInt)
    {
      AppMethodBeat.i(215240);
      this.MrW.b(parama, paramInt);
      d.this.gkp();
      AppMethodBeat.o(215240);
    }
    
    public final void cm(float paramFloat)
    {
      AppMethodBeat.i(215238);
      d.this.cm(paramFloat);
      AppMethodBeat.o(215238);
    }
    
    public final void gjK()
    {
      AppMethodBeat.i(215248);
      this.MrW.gjK();
      AppMethodBeat.o(215248);
    }
    
    public final void gjL()
    {
      AppMethodBeat.i(215249);
      this.MrW.gjL();
      AppMethodBeat.o(215249);
    }
    
    public final void zX(boolean paramBoolean)
    {
      AppMethodBeat.i(215246);
      this.MrW.zX(paramBoolean);
      AppMethodBeat.o(215246);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.weapp.d
 * JD-Core Version:    0.7.0.1
 */