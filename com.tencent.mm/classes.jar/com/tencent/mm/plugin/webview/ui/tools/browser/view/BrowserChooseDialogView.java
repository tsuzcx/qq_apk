package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.ui.tools.browser.e.a;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "browserRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "closeButton", "Landroid/widget/ImageView;", "dialogTitle", "Landroid/widget/TextView;", "mBrowserChooseDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserChooseDialogClickListener;", "mBrowserDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "mBrowserListAdapter", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter;", "mItemPadding", "moreButton", "attachDialog", "", "dialog", "configItemPadding", "init", "release", "setBrowserClickListener", "listener", "setBrowserList", "dataList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "BrowserItemAdapter", "BrowserItemDecoration", "BrowserItemViewHolder", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BrowserChooseDialogView
  extends RelativeLayout
{
  public static final d Xbi;
  private ImageView CQi;
  private ImageView PdB;
  private RecyclerView Xbj;
  private a Xbk;
  a Xbl;
  private com.tencent.mm.plugin.webview.ui.tools.browser.listener.a Xbm;
  private TextView puE;
  private int vPy;
  
  static
  {
    AppMethodBeat.i(296617);
    Xbi = new d((byte)0);
    AppMethodBeat.o(296617);
  }
  
  public BrowserChooseDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(296558);
    AppMethodBeat.o(296558);
  }
  
  public BrowserChooseDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(296567);
    AppMethodBeat.o(296567);
  }
  
  public BrowserChooseDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(296585);
    setFitsSystemWindows(true);
    View localView = LayoutInflater.from(paramContext).inflate(c.g.layout_browser_choose_dialog_view, (ViewGroup)this, true);
    paramAttributeSet = localView.findViewById(c.f.browser_dialog_title);
    s.s(paramAttributeSet, "view.findViewById(R.id.browser_dialog_title)");
    this.puE = ((TextView)paramAttributeSet);
    paramAttributeSet = localView.findViewById(c.f.browser_dialog_close_btn);
    s.s(paramAttributeSet, "view.findViewById(R.id.browser_dialog_close_btn)");
    this.CQi = ((ImageView)paramAttributeSet);
    paramAttributeSet = localView.findViewById(c.f.browser_dialog_more_btn);
    s.s(paramAttributeSet, "view.findViewById(R.id.browser_dialog_more_btn)");
    this.PdB = ((ImageView)paramAttributeSet);
    paramAttributeSet = localView.findViewById(c.f.browser_list);
    s.s(paramAttributeSet, "view.findViewById(R.id.browser_list)");
    this.Xbj = ((RecyclerView)paramAttributeSet);
    Object localObject2 = this.puE;
    paramAttributeSet = (AttributeSet)localObject2;
    if (localObject2 == null)
    {
      s.bIx("dialogTitle");
      paramAttributeSet = null;
    }
    aw.a((Paint)paramAttributeSet.getPaint(), 0.8F);
    localObject2 = this.CQi;
    paramAttributeSet = (AttributeSet)localObject2;
    if (localObject2 == null)
    {
      s.bIx("closeButton");
      paramAttributeSet = null;
    }
    paramAttributeSet.setOnClickListener(new BrowserChooseDialogView..ExternalSyntheticLambda0(this, localView));
    localObject2 = this.PdB;
    paramAttributeSet = (AttributeSet)localObject2;
    if (localObject2 == null)
    {
      s.bIx("moreButton");
      paramAttributeSet = null;
    }
    paramAttributeSet.setOnClickListener(new BrowserChooseDialogView..ExternalSyntheticLambda1(this, localView));
    paramAttributeSet = getResources();
    if (paramAttributeSet == null)
    {
      paramAttributeSet = null;
      if (paramAttributeSet != null) {
        break label552;
      }
      paramInt = com.tencent.mm.cd.a.ms(getContext());
      label261:
      this.vPy = ((paramInt - getResources().getDimensionPixelSize(c.d.webview_browser_item_icon_width) * 4) / 5);
      Log.i("MicroMsg.BrowserChooseDialogView", "alvinluo configItemPadding width: %d, mItemPadding: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.vPy) });
      this.Xbk = new a(paramContext);
      localObject2 = this.Xbj;
      paramAttributeSet = (AttributeSet)localObject2;
      if (localObject2 == null)
      {
        s.bIx("browserRecyclerView");
        paramAttributeSet = null;
      }
      paramAttributeSet.setItemAnimator(null);
      paramAttributeSet.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(4));
      paramAttributeSet.setAdapter((RecyclerView.a)this.Xbk);
      paramAttributeSet.a((RecyclerView.h)new BrowserChooseDialogView.b(paramContext));
      paramAttributeSet.setOverScrollMode(2);
      paramAttributeSet.setVerticalFadingEdgeEnabled(false);
      paramAttributeSet.setNestedScrollingEnabled(false);
      if ((paramAttributeSet instanceof MaxHeightRecyclerView)) {
        ((MaxHeightRecyclerView)paramAttributeSet).setMaxHeight((int)(com.tencent.mm.cd.a.mt(paramContext) * 3.0F / 4.0F) - ((MaxHeightRecyclerView)paramAttributeSet).getResources().getDimensionPixelSize(c.d.Edge_8A) - ((MaxHeightRecyclerView)paramAttributeSet).getResources().getDimensionPixelSize(c.d.Edge_8A));
      }
      paramContext = this.Xbj;
      if (paramContext != null) {
        break label560;
      }
      s.bIx("browserRecyclerView");
      paramContext = localObject1;
    }
    label552:
    label560:
    for (;;)
    {
      paramContext = paramContext.getLayoutParams();
      if ((paramContext != null) && ((paramContext instanceof ViewGroup.MarginLayoutParams)))
      {
        ((ViewGroup.MarginLayoutParams)paramContext).leftMargin = (this.vPy / 2);
        ((ViewGroup.MarginLayoutParams)paramContext).rightMargin = (this.vPy / 2);
      }
      AppMethodBeat.o(296585);
      return;
      paramAttributeSet = paramAttributeSet.getDisplayMetrics();
      if (paramAttributeSet == null)
      {
        paramAttributeSet = null;
        break;
      }
      paramAttributeSet = Integer.valueOf(paramAttributeSet.widthPixels);
      break;
      paramInt = paramAttributeSet.intValue();
      break label261;
    }
  }
  
  private static final void a(BrowserChooseDialogView paramBrowserChooseDialogView, View paramView1, View paramView2)
  {
    AppMethodBeat.i(296595);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramBrowserChooseDialogView);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBrowserChooseDialogView, "this$0");
    paramView1 = paramBrowserChooseDialogView.Xbm;
    if (paramView1 != null) {
      paramView1.a(paramBrowserChooseDialogView.Xbl);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(296595);
  }
  
  private static final void b(BrowserChooseDialogView paramBrowserChooseDialogView, View paramView1, View paramView2)
  {
    AppMethodBeat.i(296602);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramBrowserChooseDialogView);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBrowserChooseDialogView, "this$0");
    paramView1 = paramBrowserChooseDialogView.Xbm;
    if (paramView1 != null) {
      paramView1.b(paramBrowserChooseDialogView.Xbl);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(296602);
  }
  
  public final void setBrowserClickListener(com.tencent.mm.plugin.webview.ui.tools.browser.listener.a parama)
  {
    this.Xbm = parama;
  }
  
  public final void setBrowserList(List<f> paramList)
  {
    AppMethodBeat.i(296640);
    if (paramList == null)
    {
      AppMethodBeat.o(296640);
      return;
    }
    a locala = this.Xbk;
    if (locala != null)
    {
      s.u(paramList, "dataList");
      locala.mDataList.clear();
      locala.mDataList.addAll((Collection)paramList);
    }
    AppMethodBeat.o(296640);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView;Landroid/content/Context;)V", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "setDataList", "dataList", "", "updateDisplayIcon", "item", "updateDisplayName", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
    extends RecyclerView.a<BrowserChooseDialogView.c>
  {
    private final Context context;
    final ArrayList<f> mDataList;
    
    public a()
    {
      AppMethodBeat.i(296568);
      this.context = localObject;
      this.mDataList = new ArrayList();
      AppMethodBeat.o(296568);
    }
    
    private static final void a(f paramf, BrowserChooseDialogView paramBrowserChooseDialogView, int paramInt, View paramView)
    {
      AppMethodBeat.i(296579);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramf);
      localb.cH(paramBrowserChooseDialogView);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramf, "$item");
      s.u(paramBrowserChooseDialogView, "this$0");
      if (paramf.qK != null)
      {
        paramView = BrowserChooseDialogView.a(paramBrowserChooseDialogView);
        if (paramView != null) {
          paramView.a(BrowserChooseDialogView.b(paramBrowserChooseDialogView), paramInt, paramf);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(296579);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(296592);
      int i = this.mDataList.size();
      AppMethodBeat.o(296592);
      return i;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter$updateDisplayIcon$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "onLoadFinish", "", "drawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements e.a
    {
      a(f paramf, BrowserChooseDialogView.a parama, int paramInt) {}
      
      public final void R(Drawable paramDrawable)
      {
        AppMethodBeat.i(296635);
        this.Xbo.Xbc = paramDrawable;
        this.Xbp.fV(this.qkg);
        AppMethodBeat.o(296635);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "browserIcon", "Landroid/widget/ImageView;", "getBrowserIcon", "()Landroid/widget/ImageView;", "browserTitle", "Landroid/widget/TextView;", "getBrowserTitle", "()Landroid/widget/TextView;", "container", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
    extends RecyclerView.v
  {
    final LinearLayout Api;
    final ImageView Xbs;
    final TextView Xbt;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(296575);
      View localView = paramView.findViewById(c.f.browser_item_container);
      s.s(localView, "itemView.findViewById(R.id.browser_item_container)");
      this.Api = ((LinearLayout)localView);
      localView = paramView.findViewById(c.f.browser_icon);
      s.s(localView, "itemView.findViewById(R.id.browser_icon)");
      this.Xbs = ((ImageView)localView);
      paramView = paramView.findViewById(c.f.browser_title);
      s.s(paramView, "itemView.findViewById(R.id.browser_title)");
      this.Xbt = ((TextView)paramView);
      AppMethodBeat.o(296575);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$Companion;", "", "()V", "BROWSER_LIST_GRID_SPAN_COUNT", "", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserChooseDialogView
 * JD-Core Version:    0.7.0.1
 */