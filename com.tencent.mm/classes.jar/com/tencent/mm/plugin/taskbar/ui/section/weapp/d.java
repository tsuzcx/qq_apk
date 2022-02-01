package com.tencent.mm.plugin.taskbar.ui.section.weapp;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.ui.AppBrandDebugUI;
import com.tencent.mm.plugin.appbrand.ui.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.a;
import com.tencent.mm.plugin.taskbar.d.d;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.ui.section.b.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "moreView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "getMoreView", "()Landroid/widget/RelativeLayout;", "recyclerView", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView;", "value", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;", "weAppCallback", "getWeAppCallback", "()Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;", "setWeAppCallback", "(Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;)V", "createRecyclerView", "getShowCount", "getShowLines", "getShowList", "", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "", "isInLongPress", "", "notifyDataSetChanged", "", "notifyTaskBarClosed", "inDesktop", "onClickMore", "onWeAppMarginUpdate", "margin", "", "setDataList", "list", "titleName", "", "tryCloseOnPause", "pos", "updateMoreView", "Companion", "SectionWeAppCallbackWrap", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends com.tencent.mm.plugin.taskbar.ui.section.b
{
  public static final d.a SUP;
  public final TaskBarSectionWeAppRecyclerView SUQ;
  private final RelativeLayout SUR;
  private TaskBarSectionWeAppRecyclerView.b SUS;
  
  static
  {
    AppMethodBeat.i(264434);
    SUP = new d.a((byte)0);
    AppMethodBeat.o(264434);
  }
  
  public d(Context paramContext, b.a parama, int paramInt, byte paramByte)
  {
    this(paramContext, parama, paramInt);
    AppMethodBeat.i(264393);
    AppMethodBeat.o(264393);
  }
  
  public d(Context paramContext, b.a parama, int paramInt1, AttributeSet paramAttributeSet, int paramInt2)
  {
    super(paramContext, parama, paramInt1, null, 0);
    AppMethodBeat.i(264375);
    this.SUQ = hEj();
    parama = getRoot().findViewById(d.d.more);
    paramAttributeSet = (RelativeLayout)parama;
    paramAttributeSet.setContentDescription((CharSequence)s.X(com.tencent.mm.cd.a.bt(paramContext, d.g.SQg), com.tencent.mm.cd.a.bt(paramContext, d.g.appbrand_app_name)));
    paramAttributeSet.setOnClickListener(new d..ExternalSyntheticLambda0(this));
    paramAttributeSet.setOnLongClickListener(new d..ExternalSyntheticLambda1(paramAttributeSet));
    paramContext = ah.aiuX;
    this.SUR = ((RelativeLayout)parama);
    ((FrameLayout)findViewById(d.d.container)).addView((View)this.SUQ, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    this.SUQ.setId(d.d.SPS);
    if (Build.VERSION.SDK_INT >= 22) {
      this.SUR.setAccessibilityTraversalBefore(this.SUQ.getId());
    }
    AppMethodBeat.o(264375);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(264400);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.esl();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(264400);
  }
  
  private static final boolean d(RelativeLayout paramRelativeLayout, View paramView)
  {
    AppMethodBeat.i(264413);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRelativeLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    if (c.cKM())
    {
      paramView = new Intent(paramRelativeLayout.getContext(), AppBrandDebugUI.class);
      paramRelativeLayout = paramRelativeLayout.getContext();
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(paramRelativeLayout, paramView.aYi(), "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView", "moreView$lambda-2$lambda-1", "(Landroid/widget/RelativeLayout;Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramRelativeLayout.startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramRelativeLayout, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView", "moreView$lambda-2$lambda-1", "(Landroid/widget/RelativeLayout;Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(264413);
      return true;
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(264413);
    return false;
  }
  
  public static final String lr(List<? extends AppBrandDesktopView.a> paramList)
  {
    AppMethodBeat.i(264429);
    s.u(paramList, "items");
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(s.X(((AppBrandDesktopView.a)paramList.next()).uAl.nickname, ","));
    }
    paramList = localStringBuilder.toString();
    s.s(paramList, "result.toString()");
    AppMethodBeat.o(264429);
    return paramList;
  }
  
  public final void Fs(boolean paramBoolean)
  {
    AppMethodBeat.i(264510);
    if (!paramBoolean) {
      this.SUQ.hEm();
    }
    AppMethodBeat.o(264510);
  }
  
  public final boolean aod(int paramInt)
  {
    return true;
  }
  
  public void dy(float paramFloat) {}
  
  public void esl()
  {
    AppMethodBeat.i(264485);
    TaskBarSectionWeAppRecyclerView.b localb = this.SUS;
    if (localb != null) {
      localb.hDL();
    }
    AppMethodBeat.o(264485);
  }
  
  protected final RelativeLayout getMoreView()
  {
    return this.SUR;
  }
  
  protected final TaskBarSectionWeAppRecyclerView getRecyclerView()
  {
    return this.SUQ;
  }
  
  public final int getShowCount()
  {
    AppMethodBeat.i(264525);
    int i = this.SUQ.getShowCount();
    AppMethodBeat.o(264525);
    return i;
  }
  
  public final int getShowLines()
  {
    AppMethodBeat.i(264541);
    int i = this.SUQ.getShowLines();
    AppMethodBeat.o(264541);
    return i;
  }
  
  public final List<AppBrandDesktopView.a> getShowList()
  {
    AppMethodBeat.i(264534);
    List localList = this.SUQ.getShowList();
    AppMethodBeat.o(264534);
    return localList;
  }
  
  public final TaskBarSectionWeAppRecyclerView.b getWeAppCallback()
  {
    return this.SUS;
  }
  
  public String hEf()
  {
    AppMethodBeat.i(264499);
    String str = getContext().getString(d.g.SQu);
    s.s(str, "context.getString(R.stri…nd_taskbar_section_weapp)");
    AppMethodBeat.o(264499);
    return str;
  }
  
  public TaskBarSectionWeAppRecyclerView hEj()
  {
    AppMethodBeat.i(264493);
    TaskBarSectionWeAppRecyclerView localTaskBarSectionWeAppRecyclerView = new TaskBarSectionWeAppRecyclerView(getContext());
    AppMethodBeat.o(264493);
    return localTaskBarSectionWeAppRecyclerView;
  }
  
  public final void hEn()
  {
    AppMethodBeat.i(264503);
    Object localObject = this.SUR;
    if (this.SUQ.getDataList().size() > 8) {}
    for (int i = 0;; i = 4)
    {
      ((RelativeLayout)localObject).setVisibility(i);
      if (this.SUR.getVisibility() == 4)
      {
        localObject = (ImageView)findViewById(d.d.more_icon);
        if (localObject != null) {
          ((ImageView)localObject).setImageDrawable(null);
        }
      }
      AppMethodBeat.o(264503);
      return;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(264516);
    hEn();
    this.SUQ.cPy();
    AppMethodBeat.o(264516);
  }
  
  public final void setDataList(List<? extends AppBrandDesktopView.a> paramList)
  {
    AppMethodBeat.i(264549);
    this.SUQ.setDataList(paramList);
    AppMethodBeat.o(264549);
  }
  
  public final void setWeAppCallback(TaskBarSectionWeAppRecyclerView.b paramb)
  {
    AppMethodBeat.i(264478);
    if (paramb != null)
    {
      this.SUS = ((TaskBarSectionWeAppRecyclerView.b)new b(paramb));
      getRecyclerView().setWeAppCallback(this.SUS);
    }
    AppMethodBeat.o(264478);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$SectionWeAppCallbackWrap;", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;", "delegate", "(Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView;Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;)V", "getDelegate", "()Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;", "getMoreRootView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "notifyMyWeAppChanged", "", "pos", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "onClick", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "position", "isMyWeApp", "", "onDragStateChange", "isStart", "onDragToPosition", "x", "", "y", "onMyWeAppClick", "onMyWeAppDeleted", "onRecentWeAppClick", "onViewAttachedToWindow", "onWeAppDeleted", "onWeAppMarginUpdate", "margin", "reportOnItemReorderWeApp", "appItem", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "startPos", "endPos", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements TaskBarSectionWeAppRecyclerView.b
  {
    private final TaskBarSectionWeAppRecyclerView.b SUT;
    
    public b()
    {
      AppMethodBeat.i(264414);
      this.SUT = localObject;
      AppMethodBeat.o(264414);
    }
    
    public final void Fo(boolean paramBoolean)
    {
      AppMethodBeat.i(264447);
      this.SUT.Fo(paramBoolean);
      AppMethodBeat.o(264447);
    }
    
    public final void a(int paramInt, AppBrandDesktopView.a parama)
    {
      AppMethodBeat.i(264430);
      this.SUT.a(paramInt, parama);
      AppMethodBeat.o(264430);
    }
    
    public final void a(RecyclerView.v paramv, View paramView, AppBrandDesktopView.a parama, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(264438);
      this.SUT.a(paramv, paramView, parama, paramInt, paramBoolean);
      AppMethodBeat.o(264438);
    }
    
    public final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(264472);
      this.SUT.a(paramLocalUsageInfo, paramInt1, paramInt2);
      AppMethodBeat.o(264472);
    }
    
    public final void a(AppBrandDesktopView.a parama, int paramInt)
    {
      AppMethodBeat.i(264487);
      this.SUT.a(parama, paramInt);
      d.this.hEn();
      AppMethodBeat.o(264487);
    }
    
    public final boolean aX(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(264456);
      boolean bool = this.SUT.aX(paramFloat1, paramFloat2);
      AppMethodBeat.o(264456);
      return bool;
    }
    
    public final void b(AppBrandDesktopView.a parama, int paramInt)
    {
      AppMethodBeat.i(264494);
      this.SUT.b(parama, paramInt);
      d.this.hEn();
      AppMethodBeat.o(264494);
    }
    
    public final void dy(float paramFloat)
    {
      AppMethodBeat.i(264479);
      d.this.dy(paramFloat);
      AppMethodBeat.o(264479);
    }
    
    public final void hDK()
    {
      AppMethodBeat.i(264460);
      this.SUT.hDK();
      AppMethodBeat.o(264460);
    }
    
    public final void hDL()
    {
      AppMethodBeat.i(264465);
      this.SUT.hDL();
      AppMethodBeat.o(264465);
    }
    
    public final View hDM()
    {
      AppMethodBeat.i(264423);
      View localView = this.SUT.hDM();
      AppMethodBeat.o(264423);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.weapp.d
 * JD-Core Version:    0.7.0.1
 */