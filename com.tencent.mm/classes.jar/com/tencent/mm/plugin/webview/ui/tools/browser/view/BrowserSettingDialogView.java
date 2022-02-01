package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.w;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.webview.ui.tools.browser.e.a;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import com.tencent.mm.plugin.webview.ui.tools.browser.listener.c;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "browserRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "cancelButton", "Landroid/widget/TextView;", "confirmButton", "dialogTitle", "mBrowserDataList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mBrowserDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "mBrowserListAdapter", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter;", "mBrowserSettingDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserSettingDialogClickListener;", "mSelectedPosition", "attachDialog", "", "dialog", "init", "initConfirmButton", "release", "setBrowserList", "dataList", "setBrowserSettingDialogClickListener", "listener", "setSelectedBrowser", "index", "BrowserItemAdapter", "BrowserItemViewHolder", "Companion", "plugin-webview_release"})
public final class BrowserSettingDialogView
  extends RelativeLayout
{
  public static final BrowserSettingDialogView.d Jmr;
  private TextView CPg;
  private int CaW;
  private TextView JlU;
  private RecyclerView JlV;
  a JlX;
  private TextView Jmn;
  private b Jmo;
  private c Jmp;
  private List<f> Jmq;
  
  static
  {
    AppMethodBeat.i(210485);
    Jmr = new BrowserSettingDialogView.d((byte)0);
    AppMethodBeat.o(210485);
  }
  
  public BrowserSettingDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(210482);
    AppMethodBeat.o(210482);
  }
  
  public BrowserSettingDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(210483);
    AppMethodBeat.o(210483);
  }
  
  public BrowserSettingDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(210484);
    this.Jmq = ((List)new ArrayList());
    this.CaW = -1;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131495169, (ViewGroup)this, true);
    Object localObject = paramAttributeSet.findViewById(2131297792);
    p.g(localObject, "view.findViewById(R.id.browser_dialog_title)");
    this.JlU = ((TextView)localObject);
    localObject = paramAttributeSet.findViewById(2131297795);
    p.g(localObject, "view.findViewById(R.id.browser_list)");
    this.JlV = ((RecyclerView)localObject);
    localObject = paramAttributeSet.findViewById(2131297791);
    p.g(localObject, "view.findViewById(R.id.b…r_dialog_setting_confirm)");
    this.Jmn = ((TextView)localObject);
    paramAttributeSet = paramAttributeSet.findViewById(2131297790);
    p.g(paramAttributeSet, "view.findViewById(R.id.b…er_dialog_setting_cancel)");
    this.CPg = ((TextView)paramAttributeSet);
    paramAttributeSet = this.JlU;
    if (paramAttributeSet == null) {
      p.btv("dialogTitle");
    }
    ao.a((Paint)paramAttributeSet.getPaint(), 0.8F);
    this.Jmo = new b(paramContext);
    paramAttributeSet = this.JlV;
    if (paramAttributeSet == null) {
      p.btv("browserRecyclerView");
    }
    paramAttributeSet.setItemAnimator(null);
    paramAttributeSet.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    paramAttributeSet.setAdapter((RecyclerView.a)this.Jmo);
    paramAttributeSet.setOverScrollMode(2);
    paramAttributeSet.setVerticalFadingEdgeEnabled(false);
    paramAttributeSet.setNestedScrollingEnabled(false);
    localObject = new w(paramContext, 1);
    ((w)localObject).setDrawable((Drawable)new BrowserSettingDialogView.a(paramAttributeSet.getResources().getColor(2131100287), paramAttributeSet));
    paramAttributeSet.b((RecyclerView.h)localObject);
    if ((paramAttributeSet instanceof MaxHeightRecyclerView)) {
      ((MaxHeightRecyclerView)paramAttributeSet).setMaxHeight((int)(com.tencent.mm.cb.a.jo(paramContext) * 3.0F / 4.0F) - ((MaxHeightRecyclerView)paramAttributeSet).getResources().getDimensionPixelSize(2131165312) - ((MaxHeightRecyclerView)paramAttributeSet).getResources().getDimensionPixelSize(2131165283));
    }
    paramContext = this.Jmn;
    if (paramContext == null) {
      p.btv("confirmButton");
    }
    paramContext.setOnClickListener((View.OnClickListener)new f(this));
    paramContext = this.CPg;
    if (paramContext == null) {
      p.btv("cancelButton");
    }
    paramContext.setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(210484);
  }
  
  public final void setBrowserList(List<f> paramList)
  {
    AppMethodBeat.i(210481);
    if (paramList == null)
    {
      AppMethodBeat.o(210481);
      return;
    }
    this.Jmq.clear();
    this.Jmq.add(0, new f(2));
    this.Jmq.addAll((Collection)paramList);
    paramList = this.Jmo;
    if (paramList != null)
    {
      List localList = this.Jmq;
      p.h(localList, "dataList");
      paramList.mDataList.clear();
      paramList.mDataList.addAll((Collection)localList);
      AppMethodBeat.o(210481);
      return;
    }
    AppMethodBeat.o(210481);
  }
  
  public final void setBrowserSettingDialogClickListener(c paramc)
  {
    this.Jmp = paramc;
  }
  
  public final void setSelectedBrowser(int paramInt)
  {
    if (paramInt < 0)
    {
      this.CaW = 0;
      return;
    }
    this.CaW = (paramInt + 1);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView;Landroid/content/Context;)V", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "setDataList", "dataList", "", "updateDisplayIcon", "item", "updateDisplayName", "updateSelectedIcon", "plugin-webview_release"})
  final class b
    extends RecyclerView.a<BrowserSettingDialogView.c>
  {
    private final Context context;
    final ArrayList<f> mDataList;
    
    public b()
    {
      AppMethodBeat.i(210477);
      this.context = localObject;
      this.mDataList = new ArrayList();
      AppMethodBeat.o(210477);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(210474);
      int i = this.mDataList.size();
      AppMethodBeat.o(210474);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(210475);
      f localf = (f)j.L((List)this.mDataList, paramInt);
      if (localf != null)
      {
        paramInt = localf.dUm;
        AppMethodBeat.o(210475);
        return paramInt;
      }
      AppMethodBeat.o(210475);
      return 0;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(BrowserSettingDialogView.b paramb, BrowserSettingDialogView.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(210471);
        b localb = new b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        BrowserSettingDialogView.a(this.Jmu.Jmt, this.Jmv.lR());
        paramView = BrowserSettingDialogView.b(this.Jmu.Jmt);
        if (paramView != null) {
          paramView.a(BrowserSettingDialogView.c(this.Jmu.Jmt), BrowserSettingDialogView.a(this.Jmu.Jmt), (f)j.L((List)BrowserSettingDialogView.b.a(this.Jmu), BrowserSettingDialogView.a(this.Jmu.Jmt)));
        }
        this.Jmu.notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210471);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter$updateDisplayIcon$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "onLoadFinish", "", "drawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"})
    public static final class b
      implements e.a
    {
      b(f paramf, int paramInt) {}
      
      public final void B(Drawable paramDrawable)
      {
        AppMethodBeat.i(210472);
        this.Jmc.JlN = paramDrawable;
        this.Jmu.ci(this.gUj);
        AppMethodBeat.o(210472);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(BrowserSettingDialogView paramBrowserSettingDialogView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(210479);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = BrowserSettingDialogView.b(this.Jmt);
      if (paramView != null) {
        paramView.d(BrowserSettingDialogView.c(this.Jmt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(210479);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(BrowserSettingDialogView paramBrowserSettingDialogView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(210480);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$initConfirmButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = BrowserSettingDialogView.b(this.Jmt);
      if (paramView != null) {
        paramView.c(BrowserSettingDialogView.c(this.Jmt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$initConfirmButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(210480);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserSettingDialogView
 * JD-Core Version:    0.7.0.1
 */