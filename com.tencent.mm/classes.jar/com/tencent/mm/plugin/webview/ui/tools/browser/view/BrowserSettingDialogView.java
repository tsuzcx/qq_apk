package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.h;
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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "browserRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "cancelButton", "Landroid/widget/TextView;", "confirmButton", "dialogTitle", "mBrowserDataList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mBrowserDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "mBrowserListAdapter", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter;", "mBrowserSettingDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserSettingDialogClickListener;", "mSelectedPosition", "attachDialog", "", "dialog", "init", "initConfirmButton", "release", "setBrowserList", "dataList", "setBrowserSettingDialogClickListener", "listener", "setSelectedBrowser", "index", "BrowserItemAdapter", "BrowserItemViewHolder", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BrowserSettingDialogView
  extends RelativeLayout
{
  public static final c Xbz;
  private int NUv;
  private TextView PdA;
  private a XbA;
  private c XbB;
  private List<f> XbC;
  private RecyclerView Xbj;
  a Xbl;
  private TextView puE;
  private TextView pui;
  
  static
  {
    AppMethodBeat.i(296622);
    Xbz = new c((byte)0);
    AppMethodBeat.o(296622);
  }
  
  public BrowserSettingDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(296556);
    AppMethodBeat.o(296556);
  }
  
  public BrowserSettingDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(296564);
    AppMethodBeat.o(296564);
  }
  
  public BrowserSettingDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(296580);
    this.XbC = ((List)new ArrayList());
    this.NUv = -1;
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(c.g.layout_browser_setting_dialog_view, (ViewGroup)this, true);
    Object localObject2 = paramAttributeSet.findViewById(c.f.browser_dialog_title);
    s.s(localObject2, "view.findViewById(R.id.browser_dialog_title)");
    this.puE = ((TextView)localObject2);
    localObject2 = paramAttributeSet.findViewById(c.f.browser_list);
    s.s(localObject2, "view.findViewById(R.id.browser_list)");
    this.Xbj = ((RecyclerView)localObject2);
    localObject2 = paramAttributeSet.findViewById(c.f.browser_dialog_setting_confirm);
    s.s(localObject2, "view.findViewById(R.id.b…r_dialog_setting_confirm)");
    this.pui = ((TextView)localObject2);
    paramAttributeSet = paramAttributeSet.findViewById(c.f.browser_dialog_setting_cancel);
    s.s(paramAttributeSet, "view.findViewById(R.id.b…er_dialog_setting_cancel)");
    this.PdA = ((TextView)paramAttributeSet);
    localObject2 = this.puE;
    paramAttributeSet = (AttributeSet)localObject2;
    if (localObject2 == null)
    {
      s.bIx("dialogTitle");
      paramAttributeSet = null;
    }
    aw.a((Paint)paramAttributeSet.getPaint(), 0.8F);
    this.XbA = new a(paramContext);
    localObject2 = this.Xbj;
    paramAttributeSet = (AttributeSet)localObject2;
    if (localObject2 == null)
    {
      s.bIx("browserRecyclerView");
      paramAttributeSet = null;
    }
    paramAttributeSet.setItemAnimator(null);
    paramAttributeSet.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    paramAttributeSet.setAdapter((RecyclerView.a)this.XbA);
    paramAttributeSet.setOverScrollMode(2);
    paramAttributeSet.setVerticalFadingEdgeEnabled(false);
    paramAttributeSet.setNestedScrollingEnabled(false);
    localObject2 = new h(paramContext, 1);
    ((h)localObject2).w((Drawable)new d(paramAttributeSet.getResources().getColor(c.c.divider_line_color)));
    ah localah = ah.aiuX;
    paramAttributeSet.a((RecyclerView.h)localObject2);
    if ((paramAttributeSet instanceof MaxHeightRecyclerView)) {
      ((MaxHeightRecyclerView)paramAttributeSet).setMaxHeight((int)(com.tencent.mm.cd.a.mt(paramContext) * 3.0F / 4.0F) - ((MaxHeightRecyclerView)paramAttributeSet).getResources().getDimensionPixelSize(c.d.Edge_8A) - ((MaxHeightRecyclerView)paramAttributeSet).getResources().getDimensionPixelSize(c.d.Edge_14A));
    }
    paramAttributeSet = this.pui;
    paramContext = paramAttributeSet;
    if (paramAttributeSet == null)
    {
      s.bIx("confirmButton");
      paramContext = null;
    }
    paramContext.setOnClickListener(new BrowserSettingDialogView..ExternalSyntheticLambda1(this));
    paramContext = this.PdA;
    if (paramContext == null)
    {
      s.bIx("cancelButton");
      paramContext = localObject1;
    }
    for (;;)
    {
      paramContext.setOnClickListener(new BrowserSettingDialogView..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(296580);
      return;
    }
  }
  
  private static final void a(BrowserSettingDialogView paramBrowserSettingDialogView, View paramView)
  {
    AppMethodBeat.i(296590);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramBrowserSettingDialogView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBrowserSettingDialogView, "this$0");
    paramView = paramBrowserSettingDialogView.XbB;
    if (paramView != null) {
      paramView.d(paramBrowserSettingDialogView.Xbl);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(296590);
  }
  
  private static final void b(BrowserSettingDialogView paramBrowserSettingDialogView, View paramView)
  {
    AppMethodBeat.i(296598);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramBrowserSettingDialogView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBrowserSettingDialogView, "this$0");
    paramView = paramBrowserSettingDialogView.XbB;
    if (paramView != null) {
      paramView.c(paramBrowserSettingDialogView.Xbl);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(296598);
  }
  
  public final void setBrowserList(List<f> paramList)
  {
    AppMethodBeat.i(296638);
    if (paramList == null)
    {
      AppMethodBeat.o(296638);
      return;
    }
    this.XbC.clear();
    this.XbC.add(0, new f(2));
    this.XbC.addAll((Collection)paramList);
    paramList = this.XbA;
    if (paramList != null)
    {
      List localList = this.XbC;
      s.u(localList, "dataList");
      paramList.mDataList.clear();
      paramList.mDataList.addAll((Collection)localList);
    }
    AppMethodBeat.o(296638);
  }
  
  public final void setBrowserSettingDialogClickListener(c paramc)
  {
    this.XbB = paramc;
  }
  
  public final void setSelectedBrowser(int paramInt)
  {
    if (paramInt < 0)
    {
      this.NUv = 0;
      return;
    }
    this.NUv = (paramInt + 1);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView;Landroid/content/Context;)V", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "setDataList", "dataList", "", "updateDisplayIcon", "item", "updateDisplayName", "updateSelectedIcon", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
    extends RecyclerView.a<BrowserSettingDialogView.b>
  {
    private final Context context;
    final ArrayList<f> mDataList;
    
    public a()
    {
      AppMethodBeat.i(296633);
      this.context = localObject;
      this.mDataList = new ArrayList();
      AppMethodBeat.o(296633);
    }
    
    private static final void a(BrowserSettingDialogView paramBrowserSettingDialogView, BrowserSettingDialogView.b paramb, a parama, View paramView)
    {
      AppMethodBeat.i(296639);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramBrowserSettingDialogView);
      localb.cH(paramb);
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramBrowserSettingDialogView, "this$0");
      s.u(paramb, "$viewHolder");
      s.u(parama, "this$1");
      BrowserSettingDialogView.a(paramBrowserSettingDialogView, paramb.KJ());
      paramb = BrowserSettingDialogView.b(paramBrowserSettingDialogView);
      if (paramb != null) {
        paramb.a(BrowserSettingDialogView.c(paramBrowserSettingDialogView), BrowserSettingDialogView.a(paramBrowserSettingDialogView), (f)p.ae((List)parama.mDataList, BrowserSettingDialogView.a(paramBrowserSettingDialogView)));
      }
      parama.bZE.notifyChanged();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(296639);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(296646);
      int i = this.mDataList.size();
      AppMethodBeat.o(296646);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(296651);
      f localf = (f)p.ae((List)this.mDataList, paramInt);
      if (localf == null)
      {
        AppMethodBeat.o(296651);
        return 0;
      }
      paramInt = localf.itemType;
      AppMethodBeat.o(296651);
      return paramInt;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemAdapter$updateDisplayIcon$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "onLoadFinish", "", "drawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements e.a
    {
      a(f paramf, BrowserSettingDialogView.a parama, int paramInt) {}
      
      public final void R(Drawable paramDrawable)
      {
        AppMethodBeat.i(296629);
        this.Xbo.Xbc = paramDrawable;
        this.XbE.fV(this.qkg);
        AppMethodBeat.o(296629);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "browserIcon", "Landroid/widget/ImageView;", "getBrowserIcon", "()Landroid/widget/ImageView;", "browserNotSetting", "Landroid/widget/TextView;", "getBrowserNotSetting", "()Landroid/widget/TextView;", "browserSelectedIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getBrowserSelectedIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "browserTitle", "getBrowserTitle", "container", "Landroid/widget/RelativeLayout;", "getContainer", "()Landroid/widget/RelativeLayout;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    extends RecyclerView.v
  {
    final RelativeLayout LwF;
    final WeImageView XbF;
    final TextView XbG;
    final ImageView Xbs;
    final TextView Xbt;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(296615);
      View localView = paramView.findViewById(c.f.browser_item_container);
      s.s(localView, "itemView.findViewById(R.id.browser_item_container)");
      this.LwF = ((RelativeLayout)localView);
      localView = paramView.findViewById(c.f.browser_icon);
      s.s(localView, "itemView.findViewById(R.id.browser_icon)");
      this.Xbs = ((ImageView)localView);
      localView = paramView.findViewById(c.f.browser_title);
      s.s(localView, "itemView.findViewById(R.id.browser_title)");
      this.Xbt = ((TextView)localView);
      localView = paramView.findViewById(c.f.browser_selected_icon);
      s.s(localView, "itemView.findViewById(R.id.browser_selected_icon)");
      this.XbF = ((WeImageView)localView);
      paramView = paramView.findViewById(c.f.browser_not_setting);
      s.s(paramView, "itemView.findViewById(R.id.browser_not_setting)");
      this.XbG = ((TextView)paramView);
      AppMethodBeat.o(296615);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$Companion;", "", "()V", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$init$1$1$1", "Landroid/graphics/drawable/ColorDrawable;", "getIntrinsicHeight", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends ColorDrawable
  {
    d(int paramInt)
    {
      super();
    }
    
    public final int getIntrinsicHeight()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserSettingDialogView
 * JD-Core Version:    0.7.0.1
 */