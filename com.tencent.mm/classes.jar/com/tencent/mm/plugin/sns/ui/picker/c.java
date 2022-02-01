package com.tencent.mm.plugin.sns.ui.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.g.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.MMNumberCheckbox;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter;", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterBase;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mCurScrollState", "", "mHelper", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterHelper;", "getMHelper", "()Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterHelper;", "mHelper$delegate", "Lkotlin/Lazy;", "mLoadDataFinishCallback", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$ISnsAlbumDataLoadCallback;", "getMLoadDataFinishCallback", "()Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$ISnsAlbumDataLoadCallback;", "setMLoadDataFinishCallback", "(Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$ISnsAlbumDataLoadCallback;)V", "mObjIdMediaInfoMap", "", "", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsPickerMediaInfo;", "getMObjIdMediaInfoMap", "()Ljava/util/Map;", "mObjIdMediaInfoMap$delegate", "mOnGridMediaClickListener", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$IOnGridMediaItemClickListener;", "getMOnGridMediaClickListener", "()Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$IOnGridMediaItemClickListener;", "setMOnGridMediaClickListener", "(Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$IOnGridMediaItemClickListener;)V", "mOnPreload", "Lkotlin/Function0;", "", "getMOnPreload", "()Lkotlin/jvm/functions/Function0;", "setMOnPreload", "(Lkotlin/jvm/functions/Function0;)V", "mOnSelectItemChangedCallback", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$IOnSelectItemChangedCallback;", "getMOnSelectItemChangedCallback", "()Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$IOnSelectItemChangedCallback;", "setMOnSelectItemChangedCallback", "(Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$IOnSelectItemChangedCallback;)V", "mOnShowLoadingFooter", "getMOnShowLoadingFooter", "setMOnShowLoadingFooter", "mPreloadItemCount", "getMPreloadItemCount", "()I", "setMPreloadItemCount", "(I)V", "mTimeHeaderPosSet", "", "getMTimeHeaderPosSet", "()Ljava/util/Set;", "mTimeHeaderPosSet$delegate", "mVisibleSnsMediaInfoList", "", "getMVisibleSnsMediaInfoList", "()Ljava/util/List;", "mVisibleSnsMediaInfoList$delegate", "selectedSnsInfoList", "getSelectedSnsInfoList", "selectedSnsInfoList$delegate", "checkPreload", "position", "getDataListRef", "getHeaderCount", "getItemCount", "getItemData", "pos", "getItemPos", "itemData", "getItemViewType", "getRealPosInTimeSection", "curPos", "getRealPosWithNoTimeHeader", "getSelectMediaObjIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSelectedCount", "getSelectedItemList", "", "getSelectedItemListByMediaId", "idList", "hideLoadingView", "initSnsAlbumAdapterHelper", "makeGalleryItems", "Lcom/tencent/mm/protocal/protobuf/FlipItem;", "snsLocalId", "mediaId", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "pullDataFromSnsStorage", "removeSelectedItemWithNotifyChanged", "itemInfo", "posInSelection", "select", "view", "Landroid/view/View;", "setDataLoadAll", "isAll", "", "showLoadingView", "updateAdapterData", "newData", "updateByDataSetChange", "updateSelectedState", "newSelectItemList", "Companion", "IOnGridMediaItemClickListener", "IOnSelectItemChangedCallback", "ISnsAlbumDataLoadCallback", "LoadingViewHolder", "SnsInfoViewHolder", "TimeHeaderViewHolder", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends d
{
  public static final c.a RRp;
  int RRA;
  private int RRB;
  private final j RRq;
  private final j RRr;
  private final j RRs;
  private final j RRt;
  private final j RRu;
  d RRv;
  c RRw;
  b RRx;
  kotlin.g.a.a<ah> RRy;
  kotlin.g.a.a<ah> RRz;
  final Context context;
  
  static
  {
    AppMethodBeat.i(308824);
    RRp = new c.a((byte)0);
    AppMethodBeat.o(308824);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(308786);
    this.context = paramContext;
    this.RRq = k.cm((kotlin.g.a.a)new i(this));
    this.RRr = k.cm((kotlin.g.a.a)c.n.RRO);
    this.RRs = k.cm((kotlin.g.a.a)c.l.RRN);
    this.RRt = k.cm((kotlin.g.a.a)c.j.RRL);
    this.RRu = k.cm((kotlin.g.a.a)c.k.RRM);
    AppMethodBeat.o(308786);
  }
  
  private final int a(g paramg)
  {
    AppMethodBeat.i(308789);
    int i = hro().indexOf(paramg);
    AppMethodBeat.o(308789);
    return i;
  }
  
  public final void Ev(boolean paramBoolean)
  {
    AppMethodBeat.i(308885);
    super.Ev(paramBoolean);
    if (paramBoolean) {
      fEC();
    }
    AppMethodBeat.o(308885);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(308848);
    s.u(paramViewGroup, "parent");
    switch (paramInt)
    {
    case 3: 
    default: 
      paramViewGroup = super.c(paramViewGroup, paramInt);
      s.s(paramViewGroup, "super.createViewHolder(parent, viewType)");
      AppMethodBeat.o(308848);
      return paramViewGroup;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.context).inflate(b.g.picker_sns_album_ui_item, paramViewGroup, false);
      s.s(paramViewGroup, "from(context).inflate(R.…m_ui_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new f(paramViewGroup);
      AppMethodBeat.o(308848);
      return paramViewGroup;
    case 2: 
      paramViewGroup = LayoutInflater.from(this.context).inflate(b.g.picker_sns_album_time_header_layout, paramViewGroup, false);
      s.s(paramViewGroup, "from(context).inflate(R.…er_layout, parent, false)");
      paramViewGroup = (RecyclerView.v)new g(paramViewGroup);
      AppMethodBeat.o(308848);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(this.context).inflate(b.g.picker_sns_album_text_item_divide_layout, paramViewGroup, false);
    s.s(paramViewGroup, "from(context).inflate(R.…de_layout, parent, false)");
    paramViewGroup = (RecyclerView.v)new e(paramViewGroup);
    AppMethodBeat.o(308848);
    return paramViewGroup;
  }
  
  public final List<g> bG(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(308870);
    s.u(paramArrayList, "idList");
    List localList = (List)new ArrayList();
    if (paramArrayList.isEmpty())
    {
      AppMethodBeat.o(308870);
      return localList;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (String)paramArrayList.next();
      localObject = (g)hrp().get(localObject);
      if (localObject != null) {
        localList.add(localObject);
      }
    }
    AppMethodBeat.o(308870);
    return localList;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(308853);
    s.u(paramv, "holder");
    Object localObject = this.RRy;
    if ((localObject != null) && (paramInt == Math.max(getItemCount() - 1 - this.RRA, 0)) && (this.RRB != 0)) {
      ((kotlin.g.a.a)localObject).invoke();
    }
    if ((paramv instanceof f))
    {
      ((f)paramv).amy(paramInt);
      AppMethodBeat.o(308853);
      return;
    }
    if ((paramv instanceof g))
    {
      paramv = (g)paramv;
      paramv.caK.setTag(b.f.sns_album_picker_item_position, Integer.valueOf(paramInt));
      paramv.caK.setTag(b.f.sns_album_picker_item_type, Integer.valueOf(2));
      localObject = ((g)paramv.RRD.hro().get(paramInt)).Qsr;
      ((TextView)paramv.caK.findViewById(b.f.picker_time_header_tv)).setText((CharSequence)((dmz)localObject).hAP);
      AppMethodBeat.o(308853);
      return;
    }
    if ((paramv instanceof e))
    {
      paramv = (e)paramv;
      paramv.getLoadingTv().setVisibility(0);
      paramv.getLoadingTv().setText((CharSequence)paramv.RRD.context.getResources().getString(b.j.app_loading));
    }
    AppMethodBeat.o(308853);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(308861);
    s.u(paramRecyclerView, "recyclerView");
    paramRecyclerView.a((RecyclerView.l)new m(this));
    super.d(paramRecyclerView);
    AppMethodBeat.o(308861);
  }
  
  public final void fEC()
  {
    AppMethodBeat.i(308881);
    if (!((Collection)hro()).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        hrm();
        if (e.c((g)p.oM(hro())))
        {
          fX(hro().size() - 1);
          hro().remove(hro().size() - 1);
        }
      }
      AppMethodBeat.o(308881);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(308866);
    int i = hro().size();
    AppMethodBeat.o(308866);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(308857);
    if (paramInt >= hro().size())
    {
      AppMethodBeat.o(308857);
      return -1;
    }
    g localg = (g)hro().get(paramInt);
    hrm();
    if (e.b(localg))
    {
      ((Set)this.RRu.getValue()).add(Integer.valueOf(paramInt));
      AppMethodBeat.o(308857);
      return 2;
    }
    hrm();
    if (e.c(localg))
    {
      AppMethodBeat.o(308857);
      return 4;
    }
    AppMethodBeat.o(308857);
    return 1;
  }
  
  final e hrm()
  {
    AppMethodBeat.i(308829);
    e locale = (e)this.RRq.getValue();
    AppMethodBeat.o(308829);
    return locale;
  }
  
  final List<g> hrn()
  {
    AppMethodBeat.i(308831);
    List localList = (List)this.RRr.getValue();
    AppMethodBeat.o(308831);
    return localList;
  }
  
  final List<g> hro()
  {
    AppMethodBeat.i(308834);
    List localList = (List)this.RRs.getValue();
    AppMethodBeat.o(308834);
    return localList;
  }
  
  final Map<String, g> hrp()
  {
    AppMethodBeat.i(308839);
    Map localMap = (Map)this.RRt.getValue();
    AppMethodBeat.o(308839);
    return localMap;
  }
  
  public final void hrq()
  {
    AppMethodBeat.i(308873);
    hrm().dk(hrz().RHs, hrz().RHt);
    AppMethodBeat.o(308873);
  }
  
  public final ArrayList<String> hrr()
  {
    AppMethodBeat.i(308879);
    if (hrn().isEmpty())
    {
      localArrayList = new ArrayList();
      AppMethodBeat.o(308879);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)hrn()).iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((g)localIterator.next()).Qsr.Id);
    }
    AppMethodBeat.o(308879);
    return localArrayList;
  }
  
  public final void kU(List<g> paramList)
  {
    AppMethodBeat.i(308876);
    s.u(paramList, "newSelectItemList");
    Set localSet = (Set)new LinkedHashSet();
    Iterator localIterator = hrn().iterator();
    int i;
    while (localIterator.hasNext())
    {
      i = a((g)localIterator.next());
      if (i != -1) {
        localSet.add(Integer.valueOf(i));
      }
    }
    localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      i = a((g)localIterator.next());
      if (i != -1) {
        localSet.add(Integer.valueOf(i));
      }
    }
    hrn().clear();
    hrn().addAll((Collection)paramList);
    paramList = ((Iterable)localSet).iterator();
    while (paramList.hasNext()) {
      fV(((Number)paramList.next()).intValue());
    }
    AppMethodBeat.o(308876);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$IOnGridMediaItemClickListener;", "", "onGridMediaItemClick", "", "itemData", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsPickerMediaInfo;", "itemView", "Landroid/view/View;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(g paramg, View paramView);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$IOnSelectItemChangedCallback;", "", "onSelectItemChanged", "", "selectedCount", "", "position", "selectPosition", "type", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void amx(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$ISnsAlbumDataLoadCallback;", "", "onLoadDataFinish", "", "list", "", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsPickerMediaInfo;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void kV(List<g> paramList);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$LoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter;Landroid/view/View;)V", "loadingTv", "Landroid/widget/TextView;", "getLoadingTv", "()Landroid/widget/TextView;", "loadingTv$delegate", "Lkotlin/Lazy;", "checkLoadingMoreView", "", "onBind", "position", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    extends RecyclerView.v
  {
    private final j RRC;
    
    public e()
    {
      super();
      AppMethodBeat.i(308664);
      this.RRC = k.cm((kotlin.g.a.a)new a(localObject));
      AppMethodBeat.o(308664);
    }
    
    final TextView getLoadingTv()
    {
      AppMethodBeat.i(308669);
      Object localObject = this.RRC.getValue();
      s.s(localObject, "<get-loadingTv>(...)");
      localObject = (TextView)localObject;
      AppMethodBeat.o(308669);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<TextView>
    {
      a(View paramView)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$SnsInfoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter;Landroid/view/View;)V", "checkbox", "Lcom/tencent/mm/ui/widget/MMNumberCheckbox;", "getCheckbox", "()Lcom/tencent/mm/ui/widget/MMNumberCheckbox;", "checkbox$delegate", "Lkotlin/Lazy;", "ivMaskType", "Landroid/widget/ImageView;", "getIvMaskType", "()Landroid/widget/ImageView;", "ivMaskType$delegate", "ivMediaMask", "getIvMediaMask", "ivMediaMask$delegate", "ivPrivacy", "getIvPrivacy", "ivPrivacy$delegate", "ivThumb", "getIvThumb", "ivThumb$delegate", "tvMaskDescription", "Landroid/widget/TextView;", "getTvMaskDescription", "()Landroid/widget/TextView;", "tvMaskDescription$delegate", "vMaskBottom", "getVMaskBottom", "()Landroid/view/View;", "vMaskBottom$delegate", "onBind", "", "pos", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class f
    extends RecyclerView.v
  {
    private final j RRE;
    private final j RRF;
    private final j RRG;
    private final j RRH;
    private final j RRI;
    private final j RRJ;
    private final j RRK;
    
    public f()
    {
      super();
      AppMethodBeat.i(308672);
      this.RRE = k.cm((kotlin.g.a.a)new e(localObject));
      this.RRF = k.cm((kotlin.g.a.a)new a(localObject));
      this.RRG = k.cm((kotlin.g.a.a)new f(localObject));
      this.RRH = k.cm((kotlin.g.a.a)new b(localObject));
      this.RRI = k.cm((kotlin.g.a.a)new d(localObject));
      this.RRJ = k.cm((kotlin.g.a.a)new c(localObject));
      this.RRK = k.cm((kotlin.g.a.a)new g(localObject));
      AppMethodBeat.o(308672);
    }
    
    private static final void a(f paramf, int paramInt)
    {
      AppMethodBeat.i(308727);
      s.u(paramf, "this$0");
      Util.expandViewTouchArea((View)paramf.hrt(), paramInt, paramInt, paramInt, paramInt);
      AppMethodBeat.o(308727);
    }
    
    private static final void a(c paramc, g paramg, f paramf, View paramView)
    {
      AppMethodBeat.i(308717);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramc);
      localb.cH(paramg);
      localb.cH(paramf);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$SnsInfoViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramc, "this$0");
      s.u(paramg, "$itemData");
      s.u(paramf, "this$1");
      paramc = paramc.RRx;
      if (paramc != null)
      {
        paramf = paramf.caK;
        s.s(paramf, "itemView");
        paramc.a(paramg, paramf);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$SnsInfoViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(308717);
    }
    
    private static final void b(c paramc, View paramView)
    {
      AppMethodBeat.i(308722);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramc);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$SnsInfoViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramc, "this$0");
      s.s(paramView, "it");
      c.a(paramc, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$SnsInfoViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(308722);
    }
    
    private ImageView hrs()
    {
      AppMethodBeat.i(308677);
      Object localObject = this.RRE.getValue();
      s.s(localObject, "<get-ivThumb>(...)");
      localObject = (ImageView)localObject;
      AppMethodBeat.o(308677);
      return localObject;
    }
    
    private MMNumberCheckbox hrt()
    {
      AppMethodBeat.i(308682);
      Object localObject = this.RRF.getValue();
      s.s(localObject, "<get-checkbox>(...)");
      localObject = (MMNumberCheckbox)localObject;
      AppMethodBeat.o(308682);
      return localObject;
    }
    
    private TextView hru()
    {
      AppMethodBeat.i(308690);
      Object localObject = this.RRG.getValue();
      s.s(localObject, "<get-tvMaskDescription>(...)");
      localObject = (TextView)localObject;
      AppMethodBeat.o(308690);
      return localObject;
    }
    
    private ImageView hrv()
    {
      AppMethodBeat.i(308695);
      Object localObject = this.RRH.getValue();
      s.s(localObject, "<get-ivMaskType>(...)");
      localObject = (ImageView)localObject;
      AppMethodBeat.o(308695);
      return localObject;
    }
    
    private ImageView hrw()
    {
      AppMethodBeat.i(308696);
      Object localObject = this.RRI.getValue();
      s.s(localObject, "<get-ivPrivacy>(...)");
      localObject = (ImageView)localObject;
      AppMethodBeat.o(308696);
      return localObject;
    }
    
    private ImageView hrx()
    {
      AppMethodBeat.i(308701);
      Object localObject = this.RRJ.getValue();
      s.s(localObject, "<get-ivMediaMask>(...)");
      localObject = (ImageView)localObject;
      AppMethodBeat.o(308701);
      return localObject;
    }
    
    private View hry()
    {
      AppMethodBeat.i(308707);
      Object localObject = this.RRK.getValue();
      s.s(localObject, "<get-vMaskBottom>(...)");
      localObject = (View)localObject;
      AppMethodBeat.o(308707);
      return localObject;
    }
    
    public final void amy(int paramInt)
    {
      AppMethodBeat.i(308754);
      if (c.a(c.this).size() <= paramInt)
      {
        AppMethodBeat.o(308754);
        return;
      }
      g localg = (g)c.a(c.this).get(paramInt);
      Object localObject = localg.Qsr;
      this.caK.setTag(b.f.sns_album_picker_item_position, Integer.valueOf(paramInt));
      this.caK.setTag(b.f.sns_album_picker_item_type, Integer.valueOf(1));
      this.caK.setOnClickListener(new c.f..ExternalSyntheticLambda1(c.this, localg, this));
      hrs().setScaleType(ImageView.ScaleType.CENTER_CROP);
      hrs().setBackgroundColor(c.this.context.getResources().getColor(b.c.sns_album_picker_item_placeholder_bg_color));
      al.hgy().a((dmz)localObject, (View)hrs(), hrs().getContext().hashCode(), g.a.QrR, br.jbj(), b.e.picker_sns_album_image_placeholder_gray_black);
      if (((dmz)localObject).vhJ == 6)
      {
        hry().setVisibility(0);
        hrv().setVisibility(0);
        hrv().setImageResource(b.i.video_icon_in_gird);
        hru().setVisibility(0);
        TextView localTextView = hru();
        c.b(c.this);
        localTextView.setText((CharSequence)e.ds(((dmz)localObject).aaTF));
        c.b(c.this);
        if (!e.h(localg.RSO, c.this.hrz().RdS)) {
          break label491;
        }
        hrw().setVisibility(0);
        localObject = bb.m(c.this.context, b.i.icons_filled_lock, c.this.context.getResources().getColor(b.c.White));
        hrw().setImageDrawable((Drawable)localObject);
        label311:
        hrt().setTag(b.f.sns_album_picker_item_position, Integer.valueOf(paramInt));
        hrt().setVisibility(0);
        hrt().setOnClickListener(new c.f..ExternalSyntheticLambda0(c.this));
        paramInt = com.tencent.mm.cd.a.fromDPToPix(c.this.context, 20);
        localObject = hrt().getParent();
        if (!(localObject instanceof View)) {
          break label502;
        }
      }
      label491:
      label502:
      for (localObject = (View)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((View)localObject).post(new c.f..ExternalSyntheticLambda2(this, paramInt));
        }
        if (!c.c(c.this).contains(localg)) {
          break label507;
        }
        hrt().setCheckedNumber(c.c(c.this).indexOf(localg) + 1);
        localObject = hrx();
        ((ImageView)localObject).setVisibility(0);
        ((ImageView)localObject).setBackgroundResource(b.c.UN_BW_0_Alpha_0_5);
        AppMethodBeat.o(308754);
        return;
        hry().setVisibility(4);
        hrv().setVisibility(4);
        hru().setVisibility(4);
        break;
        hrw().setVisibility(4);
        break label311;
      }
      label507:
      hrt().setChecked(false);
      localObject = hrx();
      ((ImageView)localObject).setBackground(null);
      ((ImageView)localObject).setVisibility(4);
      AppMethodBeat.o(308754);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNumberCheckbox;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<MMNumberCheckbox>
    {
      a(View paramView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ImageView>
    {
      b(View paramView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ImageView>
    {
      c(View paramView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.a<ImageView>
    {
      d(View paramView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends u
      implements kotlin.g.a.a<ImageView>
    {
      e(View paramView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class f
      extends u
      implements kotlin.g.a.a<TextView>
    {
      f(View paramView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class g
      extends u
      implements kotlin.g.a.a<View>
    {
      g(View paramView)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$TimeHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter;Landroid/view/View;)V", "onBind", "", "pos", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class g
    extends RecyclerView.v
  {
    public g()
    {
      super();
      AppMethodBeat.i(308666);
      AppMethodBeat.o(308666);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$initSnsAlbumAdapterHelper$1", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterHelper$OnSnsAlbumInfoDataCallback;", "onLoadDataFinish", "", "pickerMediaInfoList", "", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsPickerMediaInfo;", "onUpdateDbMinLimitSeq", "pullMinLimitSeq", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements e.b
  {
    h(c paramc) {}
    
    public final void bbg(String paramString)
    {
      AppMethodBeat.i(308673);
      s.u(paramString, "pullMinLimitSeq");
      this.RRD.hrz().bbj(paramString);
      AppMethodBeat.o(308673);
    }
    
    public final void kV(List<g> paramList)
    {
      AppMethodBeat.i(308680);
      s.u(paramList, "pickerMediaInfoList");
      Object localObject = this.RRD;
      s.u(paramList, "newData");
      int i;
      if (!paramList.isEmpty())
      {
        ((c)localObject).fEC();
        i = ((c)localObject).hro().size();
        ((c)localObject).hro().addAll((Collection)paramList);
        ((c)localObject).bA(i, ((c)localObject).hro().size() - i);
      }
      localObject = this.RRD.RRv;
      if (localObject != null) {
        ((c.d)localObject).kV(paramList);
      }
      if (!((Collection)c.a(this.RRD)).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label197;
        }
      }
      label197:
      for (long l = ((g)p.oM(c.a(this.RRD))).RSO.field_snsId;; l = 0L)
      {
        Log.d("MicroMsg.SnsAlbumPickerListAdapter", "PickAdapter getData onLoadDataFinish, curAdapterDataLastSnsId = " + l + " , curLimitSeq = " + this.RRD.hrz().RHs);
        AppMethodBeat.o(308680);
        return;
        i = 0;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapterHelper;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<e>
  {
    i(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$onAttachedToRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    extends RecyclerView.l
  {
    m(c paramc) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(308713);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$onAttachedToRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      c.a(this.RRD, paramInt);
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$onAttachedToRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(308713);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(308721);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$onAttachedToRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter$onAttachedToRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(308721);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.picker.c
 * JD-Core Version:    0.7.0.1
 */