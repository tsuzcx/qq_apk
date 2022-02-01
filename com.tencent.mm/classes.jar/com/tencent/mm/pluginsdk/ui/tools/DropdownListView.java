package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView;", "Landroid/widget/LinearLayout;", "Landroid/widget/AdapterView$OnItemClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter;", "color", "Landroidx/annotation/ColorRes;", "inAnim", "", "<set-?>", "isExpanded", "()Z", "listView", "Landroid/widget/ListView;", "listener", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$IOnListItemSelected;", "mOnFolderAlbumDialogDismiss", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnFolderAlbumDialogDismiss;", "getMOnFolderAlbumDialogDismiss", "()Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnFolderAlbumDialogDismiss;", "setMOnFolderAlbumDialogDismiss", "(Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnFolderAlbumDialogDismiss;)V", "mOnItemStateChanged", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "getMOnItemStateChanged", "()Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "setMOnItemStateChanged", "(Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;)V", "mainContainer", "Landroid/widget/FrameLayout;", "selectedItemName", "", "getSelectedItemName", "()Ljava/lang/String;", "directlyClose", "", "expand", "initView", "onItemClick", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "pushDown", "pushUp", "setColor", "setFolderAlbumDialogDismiss", "onFolderAlbumDialogDismiss", "setItems", "items", "", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "setListener", "setOnItemStateChanged", "onItemStateChanged", "triggerExpand", "Companion", "DropdownListAdapter", "DropdownListItem", "IOnListItemSelected", "OnFolderAlbumDialogDismiss", "OnItemStateChanged", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DropdownListView
  extends LinearLayout
  implements AdapterView.OnItemClickListener
{
  public static final DropdownListView.a YqZ;
  FrameLayout HOp;
  boolean HOt;
  private d Yra;
  private DropdownListView.b Yrb;
  private androidx.annotation.a Yrc;
  DropdownListView.f Yrd;
  private e Yre;
  private ListView qgc;
  boolean wJw;
  
  static
  {
    AppMethodBeat.i(245498);
    YqZ = new DropdownListView.a((byte)0);
    AppMethodBeat.o(245498);
  }
  
  public DropdownListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 12);
  }
  
  public DropdownListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 8);
  }
  
  private DropdownListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(245478);
    setOrientation(1);
    this.HOp = new FrameLayout(getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    paramAttributeSet = this.HOp;
    s.checkNotNull(paramAttributeSet);
    paramAttributeSet.setVisibility(8);
    addView((View)this.HOp, (ViewGroup.LayoutParams)paramContext);
    paramContext = new FrameLayout(getContext());
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -1);
    paramContext.setBackgroundColor(getContext().getResources().getColor(R.e.UN_BW_0_Alpha_0_3));
    paramContext.setOnClickListener(new DropdownListView..ExternalSyntheticLambda0(this));
    FrameLayout localFrameLayout = this.HOp;
    s.checkNotNull(localFrameLayout);
    localFrameLayout.addView((View)paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = new RoundedCornerFrameLayout(getContext());
    paramContext.A(0.0F, 0.0F, bd.fromDPToPix(getContext(), 8), bd.fromDPToPix(getContext(), 8));
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 48;
    localFrameLayout = this.HOp;
    s.checkNotNull(localFrameLayout);
    localFrameLayout.addView((View)paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    this.qgc = new ListView(getContext());
    paramAttributeSet = this.qgc;
    s.checkNotNull(paramAttributeSet);
    paramAttributeSet.setCacheColorHint(0);
    paramAttributeSet = this.qgc;
    s.checkNotNull(paramAttributeSet);
    paramAttributeSet.setOnItemClickListener((AdapterView.OnItemClickListener)this);
    paramAttributeSet = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addView((View)this.qgc, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = getContext();
    s.s(paramContext, "context");
    this.Yrb = new DropdownListView.b(paramContext);
    paramContext = this.qgc;
    s.checkNotNull(paramContext);
    paramContext.setAdapter((ListAdapter)this.Yrb);
    AppMethodBeat.o(245478);
  }
  
  private static final void a(DropdownListView paramDropdownListView, View paramView)
  {
    AppMethodBeat.i(245495);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramDropdownListView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramDropdownListView, "this$0");
    if ((!paramDropdownListView.wJw) || (paramDropdownListView.HOt))
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245495);
      return;
    }
    paramDropdownListView.fBC();
    paramDropdownListView = paramDropdownListView.getMOnFolderAlbumDialogDismiss();
    s.checkNotNull(paramDropdownListView);
    paramDropdownListView.fBy();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(245495);
  }
  
  public final void fBC()
  {
    AppMethodBeat.i(245552);
    if (!this.wJw) {}
    for (boolean bool = true; this.wJw == bool; bool = false)
    {
      Log.d("MicroMsg.DropdownListView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.wJw) });
      AppMethodBeat.o(245552);
      return;
    }
    if (this.HOt)
    {
      Log.d("MicroMsg.DropdownListView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(245552);
      return;
    }
    if (this.wJw)
    {
      this.HOt = true;
      localObject = AnimationUtils.loadAnimation(getContext(), b.a.push_up_out);
      ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new h(this));
      localListView = this.qgc;
      s.checkNotNull(localListView);
      localListView.startAnimation((Animation)localObject);
      AppMethodBeat.o(245552);
      return;
    }
    this.HOt = true;
    Object localObject = this.HOp;
    s.checkNotNull(localObject);
    ((FrameLayout)localObject).setVisibility(0);
    localObject = AnimationUtils.loadAnimation(getContext(), b.a.push_down_in);
    ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new g(this));
    ListView localListView = this.qgc;
    s.checkNotNull(localListView);
    localListView.startAnimation((Animation)localObject);
    AppMethodBeat.o(245552);
  }
  
  public final e getMOnFolderAlbumDialogDismiss()
  {
    return this.Yre;
  }
  
  public final DropdownListView.f getMOnItemStateChanged()
  {
    return this.Yrd;
  }
  
  public final String getSelectedItemName()
  {
    AppMethodBeat.i(245545);
    Object localObject = this.Yrb;
    s.checkNotNull(localObject);
    localObject = ((DropdownListView.b)localObject).Yrh;
    s.checkNotNull(localObject);
    AppMethodBeat.o(245545);
    return localObject;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(245554);
    b localb = new b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    s.u(paramView, "view");
    paramAdapterView = this.Yrb;
    s.checkNotNull(paramAdapterView);
    paramAdapterView = paramAdapterView.axb(paramInt);
    if (paramAdapterView == null)
    {
      Log.d("MicroMsg.DropdownListView", s.X("get item failed:", Integer.valueOf(paramInt)));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(245554);
      return;
    }
    if (this.Yra != null)
    {
      paramView = this.Yra;
      s.checkNotNull(paramView);
      paramView.a(paramAdapterView);
    }
    paramView = this.Yrb;
    s.checkNotNull(paramView);
    paramView.brz(paramAdapterView.name);
    paramAdapterView = this.Yrb;
    s.checkNotNull(paramAdapterView);
    paramAdapterView.notifyDataSetChanged();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(245554);
  }
  
  public final void setColor(androidx.annotation.a parama)
  {
    AppMethodBeat.i(245513);
    s.u(parama, "color");
    this.Yrc = parama;
    AppMethodBeat.o(245513);
  }
  
  public final void setFolderAlbumDialogDismiss(e parame)
  {
    this.Yre = parame;
  }
  
  public final void setItems(List<DropdownListView.c> paramList)
  {
    AppMethodBeat.i(245520);
    s.u(paramList, "items");
    DropdownListView.b localb = this.Yrb;
    s.checkNotNull(localb);
    s.u(paramList, "items");
    localb.Yrg = paramList;
    if (paramList.isEmpty()) {}
    for (paramList = "";; paramList = ((DropdownListView.c)paramList.get(0)).name)
    {
      localb.brz(paramList);
      AppMethodBeat.o(245520);
      return;
    }
  }
  
  public final void setListener(d paramd)
  {
    this.Yra = paramd;
  }
  
  public final void setMOnFolderAlbumDialogDismiss(e parame)
  {
    this.Yre = parame;
  }
  
  public final void setMOnItemStateChanged(DropdownListView.f paramf)
  {
    this.Yrd = paramf;
  }
  
  public final void setOnItemStateChanged(DropdownListView.f paramf)
  {
    this.Yrd = paramf;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$IOnListItemSelected;", "", "selected", "", "item", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void a(DropdownListView.c paramc);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnFolderAlbumDialogDismiss;", "", "onChooseAlbumDialogDismiss", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface e
  {
    public abstract void fBy();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/DropdownListView$pushDown$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements Animation.AnimationListener
  {
    g(DropdownListView paramDropdownListView) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(245654);
      s.u(paramAnimation, "animation");
      DropdownListView.a(this.Yri, true);
      DropdownListView.a(this.Yri);
      if (this.Yri.getMOnItemStateChanged() != null) {
        s.checkNotNull(this.Yri.getMOnItemStateChanged());
      }
      AppMethodBeat.o(245654);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(245649);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(245649);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(245646);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(245646);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/DropdownListView$pushUp$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements Animation.AnimationListener
  {
    h(DropdownListView paramDropdownListView) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(245648);
      s.u(paramAnimation, "animation");
      paramAnimation = DropdownListView.b(this.Yri);
      s.checkNotNull(paramAnimation);
      paramAnimation.setVisibility(8);
      DropdownListView.a(this.Yri, false);
      DropdownListView.a(this.Yri);
      if (this.Yri.getMOnItemStateChanged() != null) {
        s.checkNotNull(this.Yri.getMOnItemStateChanged());
      }
      AppMethodBeat.o(245648);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(245642);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(245642);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(245640);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(245640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.DropdownListView
 * JD-Core Version:    0.7.0.1
 */