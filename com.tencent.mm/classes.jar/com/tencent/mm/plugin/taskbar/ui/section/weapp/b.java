package com.tencent.mm.plugin.taskbar.ui.section.weapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "value", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;", "itemClickListener", "getItemClickListener", "()Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;", "setItemClickListener", "(Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$SectionWeAppCallback;)V", "moreArea", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "recentView", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView;", "getShowCount", "getShowLines", "getShowList", "", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$AppBrandItem;", "", "notifyDataSetChanged", "", "setDataList", "list", "titleName", "", "tryCloseOnPause", "", "pos", "AppBrandItem", "Companion", "plugin-taskbar_release"})
@SuppressLint({"ViewConstructor"})
public final class b
  extends com.tencent.mm.plugin.taskbar.ui.section.b
{
  public static final b.b FWe;
  private final TaskBarSectionWeAppRecyclerView FWb;
  private final RelativeLayout FWc;
  private TaskBarSectionWeAppRecyclerView.b FWd;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(238564);
    FWe = new b.b((byte)0);
    AppMethodBeat.o(238564);
  }
  
  private b(Context paramContext, com.tencent.mm.plugin.taskbar.ui.section.b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(238563);
    this.FWb = new TaskBarSectionWeAppRecyclerView(paramContext);
    this.FWc = ((RelativeLayout)getRoot().findViewById(2131304873));
    fS((View)this.FWb);
    this.FWc.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(238554);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = new int[2];
        b.a(this.FWf).getLocationOnScreen((int[])localObject);
        paramAnonymousView = this.FWf.getItemClickListener();
        if (paramAnonymousView != null)
        {
          int i = localObject[0];
          RelativeLayout localRelativeLayout = b.a(this.FWf);
          p.g(localRelativeLayout, "moreArea");
          int j = localRelativeLayout.getWidth() / 2;
          int k = localObject[1];
          localObject = b.a(this.FWf);
          p.g(localObject, "moreArea");
          paramAnonymousView.l(new Point(i + j, k + ((RelativeLayout)localObject).getHeight() / 2));
        }
        a.a(this, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(238554);
      }
    });
    AppMethodBeat.o(238563);
  }
  
  public b(Context paramContext, com.tencent.mm.plugin.taskbar.ui.section.b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
  }
  
  public final boolean abI(int paramInt)
  {
    return true;
  }
  
  public final View ewN()
  {
    AppMethodBeat.i(238565);
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
    AppMethodBeat.o(238565);
    return localView1;
  }
  
  public final String fvi()
  {
    AppMethodBeat.i(238557);
    String str = getContext().getString(2131755734);
    p.g(str, "context.getString(R.stri…nd_taskbar_section_weapp)");
    AppMethodBeat.o(238557);
    return str;
  }
  
  public final TaskBarSectionWeAppRecyclerView.b getItemClickListener()
  {
    return this.FWd;
  }
  
  public final int getShowCount()
  {
    AppMethodBeat.i(238559);
    int i = this.FWb.getShowCount();
    AppMethodBeat.o(238559);
    return i;
  }
  
  public final int getShowLines()
  {
    AppMethodBeat.i(238561);
    int i = this.FWb.getShowLines();
    AppMethodBeat.o(238561);
    return i;
  }
  
  public final List<a> getShowList()
  {
    AppMethodBeat.i(238560);
    List localList = this.FWb.getShowList();
    AppMethodBeat.o(238560);
    return localList;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(238558);
    this.FWb.cax();
    AppMethodBeat.o(238558);
  }
  
  public final void setDataList(List<a> paramList)
  {
    AppMethodBeat.i(238562);
    this.FWb.setDataList(paramList);
    AppMethodBeat.o(238562);
  }
  
  public final void setItemClickListener(TaskBarSectionWeAppRecyclerView.b paramb)
  {
    AppMethodBeat.i(238556);
    this.FWd = paramb;
    this.FWb.setOnItemClickListener(paramb);
    AppMethodBeat.o(238556);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$AppBrandItem;", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "(Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;)V", "getInfo", "()Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "isDuplicated", "", "item", "plugin-taskbar_release"})
  public static final class a
  {
    public final LocalUsageInfo ooj;
    int position;
    
    public a(LocalUsageInfo paramLocalUsageInfo)
    {
      AppMethodBeat.i(238555);
      this.ooj = paramLocalUsageInfo;
      AppMethodBeat.o(238555);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.weapp.b
 * JD-Core Version:    0.7.0.1
 */