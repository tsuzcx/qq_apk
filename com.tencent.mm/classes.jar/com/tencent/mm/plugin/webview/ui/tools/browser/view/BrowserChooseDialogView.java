package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.webview.ui.tools.browser.e.a;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "browserRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "closeButton", "Landroid/widget/ImageView;", "dialogTitle", "Landroid/widget/TextView;", "mBrowserChooseDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserChooseDialogClickListener;", "mBrowserDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "mBrowserListAdapter", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter;", "mItemPadding", "moreButton", "attachDialog", "", "dialog", "configItemPadding", "init", "release", "setBrowserClickListener", "listener", "setBrowserList", "dataList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "BrowserItemAdapter", "BrowserItemDecoration", "BrowserItemViewHolder", "Companion", "plugin-webview_release"})
public final class BrowserChooseDialogView
  extends RelativeLayout
{
  public static final BrowserChooseDialogView.d JlZ;
  private ImageView CPf;
  private ImageView CPh;
  private TextView JlU;
  private RecyclerView JlV;
  private a JlW;
  a JlX;
  private com.tencent.mm.plugin.webview.ui.tools.browser.listener.a JlY;
  private int omS;
  
  static
  {
    AppMethodBeat.i(210463);
    JlZ = new BrowserChooseDialogView.d((byte)0);
    AppMethodBeat.o(210463);
  }
  
  public BrowserChooseDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(210460);
    AppMethodBeat.o(210460);
  }
  
  public BrowserChooseDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(210461);
    AppMethodBeat.o(210461);
  }
  
  public BrowserChooseDialogView(Context paramContext, final AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(210462);
    setFitsSystemWindows(true);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131495167, (ViewGroup)this, true);
    Object localObject = paramAttributeSet.findViewById(2131297792);
    p.g(localObject, "view.findViewById(R.id.browser_dialog_title)");
    this.JlU = ((TextView)localObject);
    localObject = paramAttributeSet.findViewById(2131297786);
    p.g(localObject, "view.findViewById(R.id.browser_dialog_close_btn)");
    this.CPf = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131297789);
    p.g(localObject, "view.findViewById(R.id.browser_dialog_more_btn)");
    this.CPh = ((ImageView)localObject);
    localObject = paramAttributeSet.findViewById(2131297795);
    p.g(localObject, "view.findViewById(R.id.browser_list)");
    this.JlV = ((RecyclerView)localObject);
    localObject = this.JlU;
    if (localObject == null) {
      p.btv("dialogTitle");
    }
    ao.a((Paint)((TextView)localObject).getPaint(), 0.8F);
    localObject = this.CPf;
    if (localObject == null) {
      p.btv("closeButton");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new e(this, paramAttributeSet));
    localObject = this.CPh;
    if (localObject == null) {
      p.btv("moreButton");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new f(this, paramAttributeSet));
    paramAttributeSet = getResources();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramAttributeSet.getDisplayMetrics();
      if (paramAttributeSet == null) {}
    }
    for (paramInt = paramAttributeSet.widthPixels;; paramInt = com.tencent.mm.cb.a.jn(getContext()))
    {
      this.omS = ((paramInt - getResources().getDimensionPixelSize(2131167155) * 4) / 5);
      Log.i("MicroMsg.BrowserChooseDialogView", "alvinluo configItemPadding width: %d, mItemPadding: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.omS) });
      this.JlW = new a(paramContext);
      paramAttributeSet = this.JlV;
      if (paramAttributeSet == null) {
        p.btv("browserRecyclerView");
      }
      paramAttributeSet.setItemAnimator(null);
      paramAttributeSet.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(4));
      paramAttributeSet.setAdapter((RecyclerView.a)this.JlW);
      paramAttributeSet.b((RecyclerView.h)new BrowserChooseDialogView.b(paramContext));
      paramAttributeSet.setOverScrollMode(2);
      paramAttributeSet.setVerticalFadingEdgeEnabled(false);
      paramAttributeSet.setNestedScrollingEnabled(false);
      if ((paramAttributeSet instanceof MaxHeightRecyclerView)) {
        ((MaxHeightRecyclerView)paramAttributeSet).setMaxHeight((int)(com.tencent.mm.cb.a.jo(paramContext) * 3.0F / 4.0F) - ((MaxHeightRecyclerView)paramAttributeSet).getResources().getDimensionPixelSize(2131165312) - ((MaxHeightRecyclerView)paramAttributeSet).getResources().getDimensionPixelSize(2131165312));
      }
      paramContext = this.JlV;
      if (paramContext == null) {
        p.btv("browserRecyclerView");
      }
      paramContext = paramContext.getLayoutParams();
      if (paramContext == null) {
        break;
      }
      if ((paramContext instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)paramContext).leftMargin = (this.omS / 2);
        ((ViewGroup.MarginLayoutParams)paramContext).rightMargin = (this.omS / 2);
      }
      AppMethodBeat.o(210462);
      return;
    }
    AppMethodBeat.o(210462);
  }
  
  public final void setBrowserClickListener(com.tencent.mm.plugin.webview.ui.tools.browser.listener.a parama)
  {
    this.JlY = parama;
  }
  
  public final void setBrowserList(List<f> paramList)
  {
    AppMethodBeat.i(210459);
    if (paramList == null)
    {
      AppMethodBeat.o(210459);
      return;
    }
    a locala = this.JlW;
    if (locala != null)
    {
      p.h(paramList, "dataList");
      locala.mDataList.clear();
      locala.mDataList.addAll((Collection)paramList);
      AppMethodBeat.o(210459);
      return;
    }
    AppMethodBeat.o(210459);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemViewHolder;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView;Landroid/content/Context;)V", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "setDataList", "dataList", "", "updateDisplayIcon", "item", "updateDisplayName", "plugin-webview_release"})
  final class a
    extends RecyclerView.a<BrowserChooseDialogView.c>
  {
    private final Context context;
    final ArrayList<f> mDataList;
    
    public a()
    {
      AppMethodBeat.i(210453);
      this.context = localObject;
      this.mDataList = new ArrayList();
      AppMethodBeat.o(210453);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(210451);
      int i = this.mDataList.size();
      AppMethodBeat.o(210451);
      return i;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter$updateDisplayIcon$1", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "onLoadFinish", "", "drawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"})
    public static final class a
      implements e.a
    {
      a(f paramf, int paramInt) {}
      
      public final void B(Drawable paramDrawable)
      {
        AppMethodBeat.i(210448);
        this.Jmc.JlN = paramDrawable;
        this.Jmb.ci(this.gUj);
        AppMethodBeat.o(210448);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(BrowserChooseDialogView.a parama, f paramf, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(210449);
        b localb = new b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter$updateDisplayIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (this.Jmc.resolveInfo != null)
        {
          paramView = BrowserChooseDialogView.a(this.Jmb.Jma);
          if (paramView != null) {
            paramView.a(BrowserChooseDialogView.b(this.Jmb.Jma), this.gUj, this.Jmc);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemAdapter$updateDisplayIcon$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210449);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(BrowserChooseDialogView paramBrowserChooseDialogView, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(210457);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = BrowserChooseDialogView.a(this.Jma);
      if (paramView != null) {
        paramView.a(BrowserChooseDialogView.b(this.Jma));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(210457);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(BrowserChooseDialogView paramBrowserChooseDialogView, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(210458);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = BrowserChooseDialogView.a(this.Jma);
      if (paramView != null) {
        paramView.b(BrowserChooseDialogView.b(this.Jma));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(210458);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserChooseDialogView
 * JD-Core Version:    0.7.0.1
 */