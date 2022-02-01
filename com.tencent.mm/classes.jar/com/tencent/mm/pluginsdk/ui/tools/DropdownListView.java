package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView;", "Landroid/widget/LinearLayout;", "Landroid/widget/AdapterView$OnItemClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter;", "color", "Landroid/support/annotation/ColorRes;", "inAnim", "", "<set-?>", "isExpanded", "()Z", "listView", "Landroid/widget/ListView;", "listener", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$IOnListItemSelected;", "mOnItemStateChanged", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "getMOnItemStateChanged", "()Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "setMOnItemStateChanged", "(Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;)V", "mainContainer", "Landroid/widget/FrameLayout;", "selectedItemName", "", "getSelectedItemName", "()Ljava/lang/String;", "directlyClose", "", "expand", "initView", "onItemClick", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "pushDown", "pushUp", "setColor", "setItems", "items", "", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "setListener", "setOnItemStateChanged", "onItemStateChanged", "triggerExpand", "Companion", "DropdownListAdapter", "DropdownListItem", "IOnListItemSelected", "OnItemStateChanged", "app_release"})
public final class DropdownListView
  extends LinearLayout
  implements AdapterView.OnItemClickListener
{
  public static final DropdownListView.a KtB;
  e KtA;
  private d Ktx;
  private DropdownListView.b Kty;
  private android.support.annotation.a Ktz;
  private ListView krb;
  boolean qkb;
  FrameLayout xpS;
  boolean xpW;
  
  static
  {
    AppMethodBeat.i(231043);
    KtB = new DropdownListView.a((byte)0);
    AppMethodBeat.o(231043);
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
    AppMethodBeat.i(231041);
    setOrientation(1);
    this.xpS = new FrameLayout(getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    paramAttributeSet = this.xpS;
    if (paramAttributeSet == null) {
      p.hyc();
    }
    paramAttributeSet.setVisibility(8);
    addView((View)this.xpS, (ViewGroup.LayoutParams)paramContext);
    paramContext = new FrameLayout(getContext());
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -1);
    Object localObject = getContext();
    p.g(localObject, "context");
    paramContext.setBackgroundColor(((Context)localObject).getResources().getColor(2131099834));
    paramContext.setOnClickListener((View.OnClickListener)new DropdownListView.f(this));
    localObject = this.xpS;
    if (localObject == null) {
      p.hyc();
    }
    ((FrameLayout)localObject).addView((View)paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = new RoundedCornerFrameLayout(getContext());
    paramContext.s(0.0F, 0.0F, at.fromDPToPix(getContext(), 8), at.fromDPToPix(getContext(), 8));
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 48;
    localObject = this.xpS;
    if (localObject == null) {
      p.hyc();
    }
    ((FrameLayout)localObject).addView((View)paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    this.krb = new ListView(getContext());
    paramAttributeSet = this.krb;
    if (paramAttributeSet == null) {
      p.hyc();
    }
    paramAttributeSet.setCacheColorHint(0);
    paramAttributeSet = this.krb;
    if (paramAttributeSet == null) {
      p.hyc();
    }
    paramAttributeSet.setOnItemClickListener((AdapterView.OnItemClickListener)this);
    paramAttributeSet = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addView((View)this.krb, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = getContext();
    p.g(paramContext, "context");
    this.Kty = new DropdownListView.b(paramContext);
    paramContext = this.krb;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setAdapter((ListAdapter)this.Kty);
    AppMethodBeat.o(231041);
  }
  
  public final void dSg()
  {
    AppMethodBeat.i(231039);
    if (!this.qkb) {}
    for (boolean bool = true; this.qkb == bool; bool = false)
    {
      Log.d("MicroMsg.DropdownListView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.qkb) });
      AppMethodBeat.o(231039);
      return;
    }
    if (this.xpW)
    {
      Log.d("MicroMsg.DropdownListView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(231039);
      return;
    }
    if (this.qkb)
    {
      this.xpW = true;
      localObject = AnimationUtils.loadAnimation(getContext(), 2130772133);
      ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new h(this));
      localListView = this.krb;
      if (localListView == null) {
        p.hyc();
      }
      localListView.startAnimation((Animation)localObject);
      AppMethodBeat.o(231039);
      return;
    }
    this.xpW = true;
    Object localObject = this.xpS;
    if (localObject == null) {
      p.hyc();
    }
    ((FrameLayout)localObject).setVisibility(0);
    localObject = AnimationUtils.loadAnimation(getContext(), 2130772129);
    ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new g(this));
    ListView localListView = this.krb;
    if (localListView == null) {
      p.hyc();
    }
    localListView.startAnimation((Animation)localObject);
    AppMethodBeat.o(231039);
  }
  
  public final e getMOnItemStateChanged()
  {
    return this.KtA;
  }
  
  public final String getSelectedItemName()
  {
    AppMethodBeat.i(231038);
    Object localObject = this.Kty;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((DropdownListView.b)localObject).KtD;
    if (localObject == null) {
      p.hyc();
    }
    AppMethodBeat.o(231038);
    return localObject;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(231040);
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    p.h(paramView, "view");
    paramAdapterView = this.Kty;
    if (paramAdapterView == null) {
      p.hyc();
    }
    paramAdapterView = paramAdapterView.aiO(paramInt);
    if (paramAdapterView == null)
    {
      Log.d("MicroMsg.DropdownListView", "get item failed:".concat(String.valueOf(paramInt)));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(231040);
      return;
    }
    if (this.Ktx != null)
    {
      paramView = this.Ktx;
      if (paramView == null) {
        p.hyc();
      }
      paramView.a(paramAdapterView);
    }
    paramView = this.Kty;
    if (paramView == null) {
      p.hyc();
    }
    paramView.bfp(paramAdapterView.name);
    paramAdapterView = this.Kty;
    if (paramAdapterView == null) {
      p.hyc();
    }
    paramAdapterView.notifyDataSetChanged();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(231040);
  }
  
  public final void setColor(android.support.annotation.a parama)
  {
    AppMethodBeat.i(231036);
    p.h(parama, "color");
    this.Ktz = parama;
    AppMethodBeat.o(231036);
  }
  
  public final void setItems(List<DropdownListView.c> paramList)
  {
    AppMethodBeat.i(231037);
    p.h(paramList, "items");
    DropdownListView.b localb = this.Kty;
    if (localb == null) {
      p.hyc();
    }
    p.h(paramList, "items");
    localb.KtC = paramList;
    if (paramList.isEmpty()) {}
    for (paramList = "";; paramList = ((DropdownListView.c)paramList.get(0)).name)
    {
      localb.bfp(paramList);
      AppMethodBeat.o(231037);
      return;
    }
  }
  
  public final void setListener(d paramd)
  {
    this.Ktx = paramd;
  }
  
  public final void setMOnItemStateChanged(e parame)
  {
    this.KtA = parame;
  }
  
  public final void setOnItemStateChanged(e parame)
  {
    this.KtA = parame;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$IOnListItemSelected;", "", "selected", "", "item", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "app_release"})
  public static abstract interface d
  {
    public abstract void a(DropdownListView.c paramc);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "", "onItemStateChanged", "", "expanded", "", "app_release"})
  public static abstract interface e {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/pluginsdk/ui/tools/DropdownListView$pushDown$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"})
  public static final class g
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(231032);
      p.h(paramAnimation, "animation");
      DropdownListView.a(this.KtG, true);
      DropdownListView.a(this.KtG);
      if ((this.KtG.getMOnItemStateChanged() != null) && (this.KtG.getMOnItemStateChanged() == null)) {
        p.hyc();
      }
      AppMethodBeat.o(231032);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(231031);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(231031);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(231030);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(231030);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/pluginsdk/ui/tools/DropdownListView$pushUp$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"})
  public static final class h
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(231035);
      p.h(paramAnimation, "animation");
      paramAnimation = DropdownListView.b(this.KtG);
      if (paramAnimation == null) {
        p.hyc();
      }
      paramAnimation.setVisibility(8);
      DropdownListView.a(this.KtG, false);
      DropdownListView.a(this.KtG);
      if ((this.KtG.getMOnItemStateChanged() != null) && (this.KtG.getMOnItemStateChanged() == null)) {
        p.hyc();
      }
      AppMethodBeat.o(231035);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(231034);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(231034);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(231033);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(231033);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.DropdownListView
 * JD-Core Version:    0.7.0.1
 */