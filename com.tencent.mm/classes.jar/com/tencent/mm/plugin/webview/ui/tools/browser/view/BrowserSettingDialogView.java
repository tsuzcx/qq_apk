package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.ui.tools.browser.e.a;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import com.tencent.mm.plugin.webview.ui.tools.browser.listener.c;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "browserRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "cancelButton", "Landroid/widget/TextView;", "confirmButton", "dialogTitle", "mBrowserDataList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mBrowserDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "mBrowserListAdapter", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter;", "mBrowserSettingDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserSettingDialogClickListener;", "mSelectedPosition", "attachDialog", "", "dialog", "init", "initConfirmButton", "release", "setBrowserList", "dataList", "setBrowserSettingDialogClickListener", "listener", "setSelectedBrowser", "index", "BrowserItemAdapter", "BrowserItemViewHolder", "Companion", "plugin-webview_release"})
public final class BrowserSettingDialogView
  extends RelativeLayout
{
  public static final d QjI;
  private int HXM;
  private TextView IUI;
  private TextView QjE;
  private b QjF;
  private c QjG;
  private List<f> QjH;
  private TextView Qjm;
  private RecyclerView Qjn;
  a Qjp;
  
  static
  {
    AppMethodBeat.i(262808);
    QjI = new d((byte)0);
    AppMethodBeat.o(262808);
  }
  
  public BrowserSettingDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(262800);
    AppMethodBeat.o(262800);
  }
  
  public BrowserSettingDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(262802);
    AppMethodBeat.o(262802);
  }
  
  public BrowserSettingDialogView(Context paramContext, final AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(262806);
    this.QjH = ((List)new ArrayList());
    this.HXM = -1;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(c.g.layout_browser_setting_dialog_view, (ViewGroup)this, true);
    Object localObject = paramAttributeSet.findViewById(c.f.browser_dialog_title);
    p.j(localObject, "view.findViewById(R.id.browser_dialog_title)");
    this.Qjm = ((TextView)localObject);
    localObject = paramAttributeSet.findViewById(c.f.browser_list);
    p.j(localObject, "view.findViewById(R.id.browser_list)");
    this.Qjn = ((RecyclerView)localObject);
    localObject = paramAttributeSet.findViewById(c.f.browser_dialog_setting_confirm);
    p.j(localObject, "view.findViewById(R.id.b…r_dialog_setting_confirm)");
    this.QjE = ((TextView)localObject);
    paramAttributeSet = paramAttributeSet.findViewById(c.f.browser_dialog_setting_cancel);
    p.j(paramAttributeSet, "view.findViewById(R.id.b…er_dialog_setting_cancel)");
    this.IUI = ((TextView)paramAttributeSet);
    paramAttributeSet = this.Qjm;
    if (paramAttributeSet == null) {
      p.bGy("dialogTitle");
    }
    ar.a((Paint)paramAttributeSet.getPaint(), 0.8F);
    this.QjF = new b(paramContext);
    paramAttributeSet = this.Qjn;
    if (paramAttributeSet == null) {
      p.bGy("browserRecyclerView");
    }
    paramAttributeSet.setItemAnimator(null);
    paramAttributeSet.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    paramAttributeSet.setAdapter((RecyclerView.a)this.QjF);
    paramAttributeSet.setOverScrollMode(2);
    paramAttributeSet.setVerticalFadingEdgeEnabled(false);
    paramAttributeSet.setNestedScrollingEnabled(false);
    localObject = new i(paramContext, 1);
    ((i)localObject).t((Drawable)new a(paramAttributeSet.getResources().getColor(c.c.divider_line_color), paramAttributeSet));
    paramAttributeSet.b((RecyclerView.h)localObject);
    if ((paramAttributeSet instanceof MaxHeightRecyclerView)) {
      ((MaxHeightRecyclerView)paramAttributeSet).setMaxHeight((int)(com.tencent.mm.ci.a.ks(paramContext) * 3.0F / 4.0F) - ((MaxHeightRecyclerView)paramAttributeSet).getResources().getDimensionPixelSize(c.d.Edge_8A) - ((MaxHeightRecyclerView)paramAttributeSet).getResources().getDimensionPixelSize(c.d.Edge_14A));
    }
    paramContext = this.QjE;
    if (paramContext == null) {
      p.bGy("confirmButton");
    }
    paramContext.setOnClickListener((View.OnClickListener)new f(this));
    paramContext = this.IUI;
    if (paramContext == null) {
      p.bGy("cancelButton");
    }
    paramContext.setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(262806);
  }
  
  public final void setBrowserList(List<f> paramList)
  {
    AppMethodBeat.i(262799);
    if (paramList == null)
    {
      AppMethodBeat.o(262799);
      return;
    }
    this.QjH.clear();
    this.QjH.add(0, new f(2));
    this.QjH.addAll((Collection)paramList);
    paramList = this.QjF;
    if (paramList != null)
    {
      List localList = this.QjH;
      p.k(localList, "dataList");
      paramList.mDataList.clear();
      paramList.mDataList.addAll((Collection)localList);
      AppMethodBeat.o(262799);
      return;
    }
    AppMethodBeat.o(262799);
  }
  
  public final void setBrowserSettingDialogClickListener(c paramc)
  {
    this.QjG = paramc;
  }
  
  public final void setSelectedBrowser(int paramInt)
  {
    if (paramInt < 0)
    {
      this.HXM = 0;
      return;
    }
    this.HXM = (paramInt + 1);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$init$1$1$1", "Landroid/graphics/drawable/ColorDrawable;", "getIntrinsicHeight", "", "plugin-webview_release"})
  public static final class a
    extends ColorDrawable
  {
    a(int paramInt, RecyclerView paramRecyclerView)
    {
      super();
    }
    
    public final int getIntrinsicHeight()
    {
      return 1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView;Landroid/content/Context;)V", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "setDataList", "dataList", "", "updateDisplayIcon", "item", "updateDisplayName", "updateSelectedIcon", "plugin-webview_release"})
  final class b
    extends RecyclerView.a<BrowserSettingDialogView.c>
  {
    private final Context context;
    final ArrayList<f> mDataList;
    
    public b()
    {
      AppMethodBeat.i(268003);
      this.context = localObject;
      this.mDataList = new ArrayList();
      AppMethodBeat.o(268003);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(268000);
      int i = this.mDataList.size();
      AppMethodBeat.o(268000);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(268001);
      f localf = (f)j.M((List)this.mDataList, paramInt);
      if (localf != null)
      {
        paramInt = localf.fNO;
        AppMethodBeat.o(268001);
        return paramInt;
      }
      AppMethodBeat.o(268001);
      return 0;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(BrowserSettingDialogView.b paramb, BrowserSettingDialogView.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(225455);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        BrowserSettingDialogView.a(this.QjL.QjK, this.QjM.md());
        paramView = BrowserSettingDialogView.b(this.QjL.QjK);
        if (paramView != null) {
          paramView.a(BrowserSettingDialogView.c(this.QjL.QjK), BrowserSettingDialogView.a(this.QjL.QjK), (f)j.M((List)BrowserSettingDialogView.b.a(this.QjL), BrowserSettingDialogView.a(this.QjL.QjK)));
        }
        this.QjL.notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(225455);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter$updateDisplayIcon$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "onLoadFinish", "", "drawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"})
    public static final class b
      implements e.a
    {
      b(f paramf, int paramInt) {}
      
      public final void H(Drawable paramDrawable)
      {
        AppMethodBeat.i(219376);
        this.Qju.Qjf = paramDrawable;
        this.QjL.cL(this.jEN);
        AppMethodBeat.o(219376);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "browserIcon", "Landroid/widget/ImageView;", "getBrowserIcon", "()Landroid/widget/ImageView;", "browserNotSetting", "Landroid/widget/TextView;", "getBrowserNotSetting", "()Landroid/widget/TextView;", "browserSelectedIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getBrowserSelectedIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "browserTitle", "getBrowserTitle", "container", "Landroid/widget/RelativeLayout;", "getContainer", "()Landroid/widget/RelativeLayout;", "plugin-webview_release"})
  static final class c
    extends RecyclerView.v
  {
    final RelativeLayout NwY;
    final WeImageView QjN;
    final TextView QjO;
    final ImageView Qjx;
    final TextView Qjy;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(219728);
      View localView = paramView.findViewById(c.f.browser_item_container);
      p.j(localView, "itemView.findViewById(R.id.browser_item_container)");
      this.NwY = ((RelativeLayout)localView);
      localView = paramView.findViewById(c.f.browser_icon);
      p.j(localView, "itemView.findViewById(R.id.browser_icon)");
      this.Qjx = ((ImageView)localView);
      localView = paramView.findViewById(c.f.browser_title);
      p.j(localView, "itemView.findViewById(R.id.browser_title)");
      this.Qjy = ((TextView)localView);
      localView = paramView.findViewById(c.f.browser_selected_icon);
      p.j(localView, "itemView.findViewById(R.id.browser_selected_icon)");
      this.QjN = ((WeImageView)localView);
      paramView = paramView.findViewById(c.f.browser_not_setting);
      p.j(paramView, "itemView.findViewById(R.id.browser_not_setting)");
      this.QjO = ((TextView)paramView);
      AppMethodBeat.o(219728);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class d {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(BrowserSettingDialogView paramBrowserSettingDialogView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(218528);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = BrowserSettingDialogView.b(this.QjK);
      if (paramView != null) {
        paramView.d(BrowserSettingDialogView.c(this.QjK));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(218528);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(BrowserSettingDialogView paramBrowserSettingDialogView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(264765);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$initConfirmButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = BrowserSettingDialogView.b(this.QjK);
      if (paramView != null) {
        paramView.c(BrowserSettingDialogView.c(this.QjK));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$initConfirmButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(264765);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserSettingDialogView
 * JD-Core Version:    0.7.0.1
 */