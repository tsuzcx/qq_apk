package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import androidx.recyclerview.widget.RecyclerView.s;
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
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "browserRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "closeButton", "Landroid/widget/ImageView;", "dialogTitle", "Landroid/widget/TextView;", "mBrowserChooseDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserChooseDialogClickListener;", "mBrowserDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "mBrowserListAdapter", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter;", "mItemPadding", "moreButton", "attachDialog", "", "dialog", "configItemPadding", "init", "release", "setBrowserClickListener", "listener", "setBrowserList", "dataList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "BrowserItemAdapter", "BrowserItemDecoration", "BrowserItemViewHolder", "Companion", "plugin-webview_release"})
public final class BrowserChooseDialogView
  extends RelativeLayout
{
  public static final d Qjr;
  private ImageView IUH;
  private ImageView IUJ;
  private TextView Qjm;
  private RecyclerView Qjn;
  private a Qjo;
  a Qjp;
  private com.tencent.mm.plugin.webview.ui.tools.browser.listener.a Qjq;
  private int sJu;
  
  static
  {
    AppMethodBeat.i(221691);
    Qjr = new d((byte)0);
    AppMethodBeat.o(221691);
  }
  
  public BrowserChooseDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(221668);
    AppMethodBeat.o(221668);
  }
  
  public BrowserChooseDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(221672);
    AppMethodBeat.o(221672);
  }
  
  public BrowserChooseDialogView(Context paramContext, final AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(221689);
    setFitsSystemWindows(true);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(c.g.layout_browser_choose_dialog_view, (ViewGroup)this, true);
    Object localObject = paramAttributeSet.findViewById(c.f.browser_dialog_title);
    p.j(localObject, "view.findViewById(R.id.browser_dialog_title)");
    this.Qjm = ((TextView)localObject);
    localObject = paramAttributeSet.findViewById(c.f.browser_dialog_close_btn);
    p.j(localObject, "view.findViewById(R.id.browser_dialog_close_btn)");
    this.IUH = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(c.f.browser_dialog_more_btn);
    p.j(localObject, "view.findViewById(R.id.browser_dialog_more_btn)");
    this.IUJ = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(c.f.browser_list);
    p.j(localObject, "view.findViewById(R.id.browser_list)");
    this.Qjn = ((RecyclerView)localObject);
    localObject = this.Qjm;
    if (localObject == null) {
      p.bGy("dialogTitle");
    }
    ar.a((Paint)((TextView)localObject).getPaint(), 0.8F);
    localObject = this.IUH;
    if (localObject == null) {
      p.bGy("closeButton");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new e(this, paramAttributeSet));
    localObject = this.IUJ;
    if (localObject == null) {
      p.bGy("moreButton");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new f(this, paramAttributeSet));
    paramAttributeSet = getResources();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramAttributeSet.getDisplayMetrics();
      if (paramAttributeSet == null) {}
    }
    for (paramInt = paramAttributeSet.widthPixels;; paramInt = com.tencent.mm.ci.a.kr(getContext()))
    {
      this.sJu = ((paramInt - getResources().getDimensionPixelSize(c.d.webview_browser_item_icon_width) * 4) / 5);
      Log.i("MicroMsg.BrowserChooseDialogView", "alvinluo configItemPadding width: %d, mItemPadding: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.sJu) });
      this.Qjo = new a(paramContext);
      paramAttributeSet = this.Qjn;
      if (paramAttributeSet == null) {
        p.bGy("browserRecyclerView");
      }
      paramAttributeSet.setItemAnimator(null);
      paramAttributeSet.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(4));
      paramAttributeSet.setAdapter((RecyclerView.a)this.Qjo);
      paramAttributeSet.b((RecyclerView.h)new b(paramContext));
      paramAttributeSet.setOverScrollMode(2);
      paramAttributeSet.setVerticalFadingEdgeEnabled(false);
      paramAttributeSet.setNestedScrollingEnabled(false);
      if ((paramAttributeSet instanceof MaxHeightRecyclerView)) {
        ((MaxHeightRecyclerView)paramAttributeSet).setMaxHeight((int)(com.tencent.mm.ci.a.ks(paramContext) * 3.0F / 4.0F) - ((MaxHeightRecyclerView)paramAttributeSet).getResources().getDimensionPixelSize(c.d.Edge_8A) - ((MaxHeightRecyclerView)paramAttributeSet).getResources().getDimensionPixelSize(c.d.Edge_8A));
      }
      paramContext = this.Qjn;
      if (paramContext == null) {
        p.bGy("browserRecyclerView");
      }
      paramContext = paramContext.getLayoutParams();
      if (paramContext == null) {
        break;
      }
      if ((paramContext instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)paramContext).leftMargin = (this.sJu / 2);
        ((ViewGroup.MarginLayoutParams)paramContext).rightMargin = (this.sJu / 2);
      }
      AppMethodBeat.o(221689);
      return;
    }
    AppMethodBeat.o(221689);
  }
  
  public final void setBrowserClickListener(com.tencent.mm.plugin.webview.ui.tools.browser.listener.a parama)
  {
    this.Qjq = parama;
  }
  
  public final void setBrowserList(List<f> paramList)
  {
    AppMethodBeat.i(221664);
    if (paramList == null)
    {
      AppMethodBeat.o(221664);
      return;
    }
    a locala = this.Qjo;
    if (locala != null)
    {
      p.k(paramList, "dataList");
      locala.mDataList.clear();
      locala.mDataList.addAll((Collection)paramList);
      AppMethodBeat.o(221664);
      return;
    }
    AppMethodBeat.o(221664);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView;Landroid/content/Context;)V", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "setDataList", "dataList", "", "updateDisplayIcon", "item", "updateDisplayName", "plugin-webview_release"})
  final class a
    extends RecyclerView.a<BrowserChooseDialogView.c>
  {
    private final Context context;
    final ArrayList<f> mDataList;
    
    public a()
    {
      AppMethodBeat.i(265155);
      this.context = localObject;
      this.mDataList = new ArrayList();
      AppMethodBeat.o(265155);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(265151);
      int i = this.mDataList.size();
      AppMethodBeat.o(265151);
      return i;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter$updateDisplayIcon$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "onLoadFinish", "", "drawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"})
    public static final class a
      implements e.a
    {
      a(f paramf, int paramInt) {}
      
      public final void H(Drawable paramDrawable)
      {
        AppMethodBeat.i(255448);
        this.Qju.Qjf = paramDrawable;
        this.Qjt.cL(this.jEN);
        AppMethodBeat.o(255448);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(BrowserChooseDialogView.a parama, f paramf, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(266771);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter$updateDisplayIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (this.Qju.pN != null)
        {
          paramView = BrowserChooseDialogView.a(this.Qjt.Qjs);
          if (paramView != null) {
            paramView.a(BrowserChooseDialogView.b(this.Qjt.Qjs), this.jEN, this.Qju);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter$updateDisplayIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(266771);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lastRowBottomMaxPadding", "", "lastRowBottomPadding", "topPadding", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-webview_release"})
  static final class b
    extends RecyclerView.h
  {
    private final int Cxu;
    private final int Qjv;
    private final int Qjw;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(242255);
      this.Cxu = paramContext.getResources().getDimensionPixelSize(c.d.Edge_3A);
      this.Qjv = paramContext.getResources().getDimensionPixelSize(c.d.Edge_3A);
      this.Qjw = paramContext.getResources().getDimensionPixelSize(c.d.Edge_8A);
      AppMethodBeat.o(242255);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(242254);
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      paramRect.top = this.Cxu;
      int j = RecyclerView.bh(paramView);
      paramView = paramRecyclerView.getAdapter();
      int i;
      if (paramView != null) {
        i = paramView.getItemCount();
      }
      while (j / 4 == (i - 1) / 4) {
        if (i <= 4)
        {
          paramRect.bottom = this.Qjw;
          AppMethodBeat.o(242254);
          return;
          i = 0;
        }
        else
        {
          paramRect.bottom = this.Qjv;
        }
      }
      AppMethodBeat.o(242254);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "browserIcon", "Landroid/widget/ImageView;", "getBrowserIcon", "()Landroid/widget/ImageView;", "browserTitle", "Landroid/widget/TextView;", "getBrowserTitle", "()Landroid/widget/TextView;", "container", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "plugin-webview_release"})
  static final class c
    extends RecyclerView.v
  {
    final ImageView Qjx;
    final TextView Qjy;
    final LinearLayout wSF;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(263153);
      View localView = paramView.findViewById(c.f.browser_item_container);
      p.j(localView, "itemView.findViewById(R.id.browser_item_container)");
      this.wSF = ((LinearLayout)localView);
      localView = paramView.findViewById(c.f.browser_icon);
      p.j(localView, "itemView.findViewById(R.id.browser_icon)");
      this.Qjx = ((ImageView)localView);
      paramView = paramView.findViewById(c.f.browser_title);
      p.j(paramView, "itemView.findViewById(R.id.browser_title)");
      this.Qjy = ((TextView)paramView);
      AppMethodBeat.o(263153);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$Companion;", "", "()V", "BROWSER_LIST_GRID_SPAN_COUNT", "", "TAG", "", "plugin-webview_release"})
  public static final class d {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(BrowserChooseDialogView paramBrowserChooseDialogView, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257519);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = BrowserChooseDialogView.a(this.Qjs);
      if (paramView != null) {
        paramView.a(BrowserChooseDialogView.b(this.Qjs));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257519);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(BrowserChooseDialogView paramBrowserChooseDialogView, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(264810);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = BrowserChooseDialogView.a(this.Qjs);
      if (paramView != null) {
        paramView.b(BrowserChooseDialogView.b(this.Qjs));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(264810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserChooseDialogView
 * JD-Core Version:    0.7.0.1
 */