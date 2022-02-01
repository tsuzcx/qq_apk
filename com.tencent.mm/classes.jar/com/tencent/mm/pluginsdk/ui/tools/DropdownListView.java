package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView;", "Landroid/widget/LinearLayout;", "Landroid/widget/AdapterView$OnItemClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter;", "color", "Landroidx/annotation/ColorRes;", "inAnim", "", "<set-?>", "isExpanded", "()Z", "listView", "Landroid/widget/ListView;", "listener", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$IOnListItemSelected;", "mOnItemStateChanged", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "getMOnItemStateChanged", "()Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "setMOnItemStateChanged", "(Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;)V", "mainContainer", "Landroid/widget/FrameLayout;", "selectedItemName", "", "getSelectedItemName", "()Ljava/lang/String;", "directlyClose", "", "expand", "initView", "onItemClick", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "pushDown", "pushUp", "setColor", "setItems", "items", "", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "setListener", "setOnItemStateChanged", "onItemStateChanged", "triggerExpand", "Companion", "DropdownListAdapter", "DropdownListItem", "IOnListItemSelected", "OnItemStateChanged", "app_release"})
public final class DropdownListView
  extends LinearLayout
  implements AdapterView.OnItemClickListener
{
  public static final DropdownListView.a RuI;
  FrameLayout Ccn;
  boolean Ccr;
  private d RuE;
  private b RuF;
  private androidx.annotation.a RuG;
  DropdownListView.e RuH;
  private ListView niO;
  boolean tFX;
  
  static
  {
    AppMethodBeat.i(250660);
    RuI = new DropdownListView.a((byte)0);
    AppMethodBeat.o(250660);
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
    AppMethodBeat.i(250656);
    setOrientation(1);
    this.Ccn = new FrameLayout(getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    paramAttributeSet = this.Ccn;
    if (paramAttributeSet == null) {
      p.iCn();
    }
    paramAttributeSet.setVisibility(8);
    addView((View)this.Ccn, (ViewGroup.LayoutParams)paramContext);
    paramContext = new FrameLayout(getContext());
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -1);
    Object localObject = getContext();
    p.j(localObject, "context");
    paramContext.setBackgroundColor(((Context)localObject).getResources().getColor(R.e.UN_BW_0_Alpha_0_3));
    paramContext.setOnClickListener((View.OnClickListener)new DropdownListView.f(this));
    localObject = this.Ccn;
    if (localObject == null) {
      p.iCn();
    }
    ((FrameLayout)localObject).addView((View)paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = new RoundedCornerFrameLayout(getContext());
    paramContext.v(0.0F, 0.0F, aw.fromDPToPix(getContext(), 8), aw.fromDPToPix(getContext(), 8));
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 48;
    localObject = this.Ccn;
    if (localObject == null) {
      p.iCn();
    }
    ((FrameLayout)localObject).addView((View)paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    this.niO = new ListView(getContext());
    paramAttributeSet = this.niO;
    if (paramAttributeSet == null) {
      p.iCn();
    }
    paramAttributeSet.setCacheColorHint(0);
    paramAttributeSet = this.niO;
    if (paramAttributeSet == null) {
      p.iCn();
    }
    paramAttributeSet.setOnItemClickListener((AdapterView.OnItemClickListener)this);
    paramAttributeSet = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addView((View)this.niO, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = getContext();
    p.j(paramContext, "context");
    this.RuF = new b(paramContext);
    paramContext = this.niO;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setAdapter((ListAdapter)this.RuF);
    AppMethodBeat.o(250656);
  }
  
  public final void euH()
  {
    AppMethodBeat.i(250651);
    if (!this.tFX) {}
    for (boolean bool = true; this.tFX == bool; bool = false)
    {
      Log.d("MicroMsg.DropdownListView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.tFX) });
      AppMethodBeat.o(250651);
      return;
    }
    if (this.Ccr)
    {
      Log.d("MicroMsg.DropdownListView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(250651);
      return;
    }
    if (this.tFX)
    {
      this.Ccr = true;
      localObject = AnimationUtils.loadAnimation(getContext(), b.a.push_up_out);
      ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new h(this));
      localListView = this.niO;
      if (localListView == null) {
        p.iCn();
      }
      localListView.startAnimation((Animation)localObject);
      AppMethodBeat.o(250651);
      return;
    }
    this.Ccr = true;
    Object localObject = this.Ccn;
    if (localObject == null) {
      p.iCn();
    }
    ((FrameLayout)localObject).setVisibility(0);
    localObject = AnimationUtils.loadAnimation(getContext(), b.a.push_down_in);
    ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new g(this));
    ListView localListView = this.niO;
    if (localListView == null) {
      p.iCn();
    }
    localListView.startAnimation((Animation)localObject);
    AppMethodBeat.o(250651);
  }
  
  public final DropdownListView.e getMOnItemStateChanged()
  {
    return this.RuH;
  }
  
  public final String getSelectedItemName()
  {
    AppMethodBeat.i(250647);
    Object localObject = this.RuF;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((b)localObject).RuK;
    if (localObject == null) {
      p.iCn();
    }
    AppMethodBeat.o(250647);
    return localObject;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(250653);
    b localb = new b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    p.k(paramView, "view");
    paramAdapterView = this.RuF;
    if (paramAdapterView == null) {
      p.iCn();
    }
    paramAdapterView = paramAdapterView.aqV(paramInt);
    if (paramAdapterView == null)
    {
      Log.d("MicroMsg.DropdownListView", "get item failed:".concat(String.valueOf(paramInt)));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(250653);
      return;
    }
    if (this.RuE != null)
    {
      paramView = this.RuE;
      if (paramView == null) {
        p.iCn();
      }
      paramView.a(paramAdapterView);
    }
    paramView = this.RuF;
    if (paramView == null) {
      p.iCn();
    }
    paramView.brK(paramAdapterView.name);
    paramAdapterView = this.RuF;
    if (paramAdapterView == null) {
      p.iCn();
    }
    paramAdapterView.notifyDataSetChanged();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(250653);
  }
  
  public final void setColor(androidx.annotation.a parama)
  {
    AppMethodBeat.i(250643);
    p.k(parama, "color");
    this.RuG = parama;
    AppMethodBeat.o(250643);
  }
  
  public final void setItems(List<c> paramList)
  {
    AppMethodBeat.i(250644);
    p.k(paramList, "items");
    b localb = this.RuF;
    if (localb == null) {
      p.iCn();
    }
    p.k(paramList, "items");
    localb.RuJ = paramList;
    if (paramList.isEmpty()) {}
    for (paramList = "";; paramList = ((c)paramList.get(0)).name)
    {
      localb.brK(paramList);
      AppMethodBeat.o(250644);
      return;
    }
  }
  
  public final void setListener(d paramd)
  {
    this.RuE = paramd;
  }
  
  public final void setMOnItemStateChanged(DropdownListView.e parame)
  {
    this.RuH = parame;
  }
  
  public final void setOnItemStateChanged(DropdownListView.e parame)
  {
    this.RuH = parame;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter;", "Landroid/widget/BaseAdapter;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "listItems", "", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "selectItemName", "", "itemName", "selectedItemName", "getSelectedItemName", "()Ljava/lang/String;", "setSelectedItemName", "(Ljava/lang/String;)V", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setItems", "", "items", "Companion", "ViewHolder", "app_release"})
  public static final class b
    extends BaseAdapter
  {
    public static final DropdownListView.b.a RuL;
    List<DropdownListView.c> RuJ;
    String RuK;
    private final Context mContext;
    
    static
    {
      AppMethodBeat.i(278884);
      RuL = new DropdownListView.b.a((byte)0);
      AppMethodBeat.o(278884);
    }
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(278883);
      this.mContext = paramContext;
      this.RuK = "";
      this.RuJ = ((List)new ArrayList());
      AppMethodBeat.o(278883);
    }
    
    public final DropdownListView.c aqV(int paramInt)
    {
      AppMethodBeat.i(278879);
      DropdownListView.c localc = (DropdownListView.c)this.RuJ.get(paramInt);
      AppMethodBeat.o(278879);
      return localc;
    }
    
    public final void brK(String paramString)
    {
      AppMethodBeat.i(278877);
      paramString = Util.nullAs(paramString, "");
      p.j(paramString, "Util.nullAs(itemName, \"\")");
      this.RuK = paramString;
      AppMethodBeat.o(278877);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(278878);
      int i = this.RuJ.size();
      AppMethodBeat.o(278878);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(278882);
      p.k(paramViewGroup, "parent");
      Log.i("MicroMsg.DropdownListAdapter", "duanyi test getView:".concat(String.valueOf(paramInt)));
      DropdownListView.c localc = aqV(paramInt);
      Object localObject;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.mContext).inflate(R.i.efV, paramViewGroup, false);
        paramViewGroup = new b();
        paramViewGroup.jQn = ((WeImageView)paramView.findViewById(R.h.item_icon));
        paramViewGroup.mYd = ((TextView)paramView.findViewById(R.h.item_name));
        paramViewGroup.CbM = ((ImageView)paramView.findViewById(R.h.dTG));
        paramViewGroup.yVH = paramView.findViewById(R.h.dKj);
        p.j(paramView, "convertView");
        paramView.setTag(paramViewGroup);
        if (!p.h(this.RuK, localc.name)) {
          break label343;
        }
        localObject = paramViewGroup.CbM;
        if (localObject == null) {
          p.iCn();
        }
        ((ImageView)localObject).setVisibility(0);
        label159:
        if (paramInt >= getCount() - 1) {
          break label366;
        }
        localObject = paramViewGroup.yVH;
        if (localObject == null) {
          p.iCn();
        }
        ((View)localObject).setVisibility(0);
      }
      for (;;)
      {
        localObject = paramViewGroup.jQn;
        if (localObject == null) {
          p.iCn();
        }
        ((WeImageView)localObject).setImageDrawable(this.mContext.getResources().getDrawable(localc.qpN));
        localObject = paramViewGroup.jQn;
        if (localObject == null) {
          p.iCn();
        }
        ((WeImageView)localObject).setIconColor(this.mContext.getResources().getColor(localc.iconColor));
        localObject = paramViewGroup.mYd;
        if (localObject == null) {
          p.iCn();
        }
        ((TextView)localObject).setVisibility(0);
        paramViewGroup = paramViewGroup.mYd;
        if (paramViewGroup == null) {
          p.iCn();
        }
        paramViewGroup.setText((CharSequence)localc.name);
        AppMethodBeat.o(278882);
        return paramView;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.DropdownListView.DropdownListAdapter.ViewHolder");
          AppMethodBeat.o(278882);
          throw paramView;
        }
        paramViewGroup = (b)paramViewGroup;
        break;
        label343:
        localObject = paramViewGroup.CbM;
        if (localObject == null) {
          p.iCn();
        }
        ((ImageView)localObject).setVisibility(4);
        break label159;
        label366:
        localObject = paramViewGroup.yVH;
        if (localObject == null) {
          p.iCn();
        }
        ((View)localObject).setVisibility(8);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter$ViewHolder;", "", "()V", "iconIV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIV", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIV", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "line", "Landroid/view/View;", "getLine", "()Landroid/view/View;", "setLine", "(Landroid/view/View;)V", "nameTV", "Landroid/widget/TextView;", "getNameTV", "()Landroid/widget/TextView;", "setNameTV", "(Landroid/widget/TextView;)V", "selectedIV", "Landroid/widget/ImageView;", "getSelectedIV", "()Landroid/widget/ImageView;", "setSelectedIV", "(Landroid/widget/ImageView;)V", "app_release"})
    static final class b
    {
      ImageView CbM;
      WeImageView jQn;
      TextView mYd;
      View yVH;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "", "name", "", "iconResId", "", "iconColor", "type", "(Ljava/lang/String;III)V", "getIconColor", "()I", "setIconColor", "(I)V", "getIconResId", "setIconResId", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getType", "setType", "app_release"})
  public static final class c
  {
    int iconColor;
    String name;
    int qpN;
    int type;
    
    public c(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(286068);
      this.name = paramString;
      this.qpN = paramInt1;
      this.iconColor = paramInt2;
      this.type = paramInt3;
      AppMethodBeat.o(286068);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$IOnListItemSelected;", "", "selected", "", "item", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "app_release"})
  public static abstract interface d
  {
    public abstract void a(DropdownListView.c paramc);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/DropdownListView$pushDown$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"})
  public static final class g
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(292347);
      p.k(paramAnimation, "animation");
      DropdownListView.a(this.RuM, true);
      DropdownListView.a(this.RuM);
      if ((this.RuM.getMOnItemStateChanged() != null) && (this.RuM.getMOnItemStateChanged() == null)) {
        p.iCn();
      }
      AppMethodBeat.o(292347);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(292346);
      p.k(paramAnimation, "animation");
      AppMethodBeat.o(292346);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(292345);
      p.k(paramAnimation, "animation");
      AppMethodBeat.o(292345);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/DropdownListView$pushUp$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"})
  public static final class h
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(281393);
      p.k(paramAnimation, "animation");
      paramAnimation = DropdownListView.b(this.RuM);
      if (paramAnimation == null) {
        p.iCn();
      }
      paramAnimation.setVisibility(8);
      DropdownListView.a(this.RuM, false);
      DropdownListView.a(this.RuM);
      if ((this.RuM.getMOnItemStateChanged() != null) && (this.RuM.getMOnItemStateChanged() == null)) {
        p.iCn();
      }
      AppMethodBeat.o(281393);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(281392);
      p.k(paramAnimation, "animation");
      AppMethodBeat.o(281392);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(281391);
      p.k(paramAnimation, "animation");
      AppMethodBeat.o(281391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.DropdownListView
 * JD-Core Version:    0.7.0.1
 */