package com.tencent.mm.plugin.profile.ui.tab.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.profile.ui.tab.data.a.a;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "(Ljava/util/List;)V", "brandService", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "getBrandService", "()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "brandService$delegate", "Lkotlin/Lazy;", "footerWording", "", "getFooterWording", "()Ljava/lang/String;", "setFooterWording", "(Ljava/lang/String;)V", "onLoadMore", "Lkotlin/Function0;", "", "getOnLoadMore", "()Lkotlin/jvm/functions/Function0;", "setOnLoadMore", "(Lkotlin/jvm/functions/Function0;)V", "value", "", "showLoading", "getShowLoading", "()Z", "setShowLoading", "(Z)V", "getItemCount", "", "getItemViewType", "position", "onBindVideoItem", "holder", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$BizProfileTabVideoVH;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onImageLoadFinish", "onImageLoadStart", "setNeatText", "neatText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "url", "scene", "setupCoverImage", "bizAppMsgDetailInfo", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "coverImageView", "Landroid/widget/ImageView;", "coverHeightForVideo", "firstNotEmpty", "", "([Ljava/lang/String;)Ljava/lang/String;", "BizProfileTabLoadingVH", "BizProfileTabNoMoreVH", "BizProfileTabVideoVH", "Companion", "app_release"})
public final class e
  extends RecyclerView.a<RecyclerView.v>
{
  public static final e.d Bnp;
  private final f Bkx;
  kotlin.g.a.a<x> BmU;
  private boolean Bno;
  private final List<ou> dataList;
  String footerWording;
  
  static
  {
    AppMethodBeat.i(230841);
    Bnp = new e.d((byte)0);
    AppMethodBeat.o(230841);
  }
  
  public e(List<? extends ou> paramList)
  {
    AppMethodBeat.i(230840);
    this.dataList = paramList;
    this.Bkx = g.ah((kotlin.g.a.a)e.e.Bnx);
    this.footerWording = "";
    AppMethodBeat.o(230840);
  }
  
  private static String L(String[] paramArrayOfString)
  {
    AppMethodBeat.i(230839);
    int i = 0;
    Object localObject;
    int j;
    if (i < 2)
    {
      localObject = paramArrayOfString[i];
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence == null) || (kotlin.n.n.aL(localCharSequence)))
      {
        j = 1;
        label37:
        if (j != 0) {
          break label70;
        }
        j = 1;
        label43:
        if (j == 0) {
          break label75;
        }
      }
    }
    for (paramArrayOfString = (String[])localObject;; paramArrayOfString = null)
    {
      localObject = paramArrayOfString;
      if (paramArrayOfString == null) {
        localObject = "";
      }
      AppMethodBeat.o(230839);
      return localObject;
      j = 0;
      break label37;
      label70:
      j = 0;
      break label43;
      label75:
      i += 1;
      break;
    }
  }
  
  private final com.tencent.mm.plugin.brandservice.a.b eFj()
  {
    AppMethodBeat.i(230833);
    com.tencent.mm.plugin.brandservice.a.b localb = (com.tencent.mm.plugin.brandservice.a.b)this.Bkx.getValue();
    AppMethodBeat.o(230833);
    return localb;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(230835);
    p.h(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493763, paramViewGroup, false);
      p.g(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new e.b(paramViewGroup);
      AppMethodBeat.o(230835);
      return paramViewGroup;
    case 0: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493745, paramViewGroup, false);
      p.g(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
      AppMethodBeat.o(230835);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493732, paramViewGroup, false);
    p.g(paramViewGroup, "view");
    paramViewGroup = (RecyclerView.v)new e.a(paramViewGroup);
    AppMethodBeat.o(230835);
    return paramViewGroup;
  }
  
  public final void a(final RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(230838);
    p.h(paramv, "holder");
    if ((paramv instanceof c))
    {
      c localc = (c)paramv;
      localObject1 = (ou)this.dataList.get(paramInt);
      Object localObject3 = (nh)((ou)localObject1).KVv.KSK.get(0);
      paramv = ((ou)localObject1).KVv.KSJ;
      com.tencent.mm.ui.tools.o.hp(localc.aus);
      localc.aus.setOnClickListener((View.OnClickListener)new f(localc, (nh)localObject3, paramv));
      Object localObject4;
      if ((((ou)localObject1).KVq.xKb == 49) && (eFj().CR(16)))
      {
        paramv = eFj();
        localObject1 = ((ou)localObject1).KVv.KSK;
        p.g(localObject1, "bizMessage.AppMsg.DetailInfo");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (nh)((Iterator)localObject2).next();
          ((Collection)localObject1).add(j.listOf(new String[] { ((nh)localObject4).KSj, String.valueOf(((nh)localObject4).iAb) }));
        }
        paramv.j((List)localObject1, 126);
      }
      paramv = (CharSequence)((nh)localObject3).KSy;
      label313:
      int i;
      if ((paramv == null) || (kotlin.n.n.aL(paramv)))
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label795;
        }
        localc.Bns.setVisibility(0);
        localc.Bnt.setVisibility(0);
        localc.Bns.setText((CharSequence)((nh)localObject3).KSy);
        localc.Bnr.setText((CharSequence)com.tencent.mm.ag.m.rJ(((nh)localObject3).KSx));
        p.g(localObject3, "bizAppMsgDetailInfo");
        localObject4 = localc.cxe;
        int j = ((Number)localc.Bnw.getValue()).intValue();
        paramv = (CharSequence)((nh)localObject3).KSy;
        if ((paramv != null) && (!kotlin.n.n.aL(paramv))) {
          break label818;
        }
        paramInt = 1;
        label387:
        if (paramInt == 0) {
          break label823;
        }
        paramInt = 2131234474;
        label395:
        ((ImageView)localObject4).setBackgroundResource(paramInt);
        paramv = (CharSequence)((nh)localObject3).Title;
        if ((paramv != null) && (paramv.length() != 0)) {
          break label830;
        }
        i = 1;
        label425:
        if (i == 0) {
          break label835;
        }
        paramv = kotlin.a.e.b(new Float[] { Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.eFy()), Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.eFy()), Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.eFy()), Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.eFy()) });
        label473:
        localObject2 = L(new String[] { ((nh)localObject3).KSl, ((nh)localObject3).KSn });
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject1 = com.tencent.mm.api.b.u((String)localObject1, 2);
        p.g(localObject1, "BizImageStrategy.getUrl(…rategy.SCENE_BIZ_PROFILE)");
        localObject2 = new g(this);
        ((ImageView)localObject4).setImageBitmap(null);
        ((ImageView)localObject4).setImageDrawable(null);
        ((ImageView)localObject4).setImageResource(paramInt);
        ((ImageView)localObject4).setTag(localObject1);
        i = com.tencent.mm.cb.a.jn(((ImageView)localObject4).getContext());
        int k = (int)(com.tencent.mm.cb.a.getDensity(((ImageView)localObject4).getContext()) * 24.0F);
        Object localObject5 = new c.a().bdp();
        StringBuilder localStringBuilder = new StringBuilder("radius_");
        String str = Arrays.toString(paramv);
        p.g(str, "java.util.Arrays.toString(this)");
        localObject5 = ((c.a)localObject5).OU(str).tz(paramInt).dr(i - k, j).a((com.tencent.mm.av.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.av.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).OS(s.bdu((String)localObject1)).bdv();
        paramv = new com.tencent.mm.pluginsdk.ui.applet.m(3, -1, -1, paramv, (m.a)localObject2);
        paramv.aG((Runnable)e.h.BnC);
        com.tencent.mm.av.q.bcV().a((String)localObject1, (ImageView)localObject4, (com.tencent.mm.av.a.a.c)localObject5, (com.tencent.mm.av.a.c.h)paramv);
        paramv = (CharSequence)((nh)localObject3).Title;
        if ((paramv != null) && (paramv.length() != 0)) {
          break label878;
        }
      }
      label795:
      label818:
      label823:
      label830:
      label835:
      label878:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label883;
        }
        localc.Bnu.setVisibility(8);
        localc.Bnv.setVisibility(8);
        AppMethodBeat.o(230838);
        return;
        paramInt = 0;
        break;
        localc.Bns.setVisibility(8);
        localc.Bnt.setVisibility(8);
        break label313;
        paramInt = 0;
        break label387;
        paramInt = 2131234475;
        break label395;
        i = 0;
        break label425;
        paramv = kotlin.a.e.b(new Float[] { Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.eFy()), Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.eFy()), Float.valueOf(0.0F), Float.valueOf(0.0F) });
        break label473;
      }
      label883:
      localc.Bnu.setVisibility(0);
      localc.Bnv.setVisibility(0);
      paramv = localc.Bnv;
      Object localObject2 = ((nh)localObject3).Title;
      p.g(localObject2, "bizAppMsgDetailInfo.Title");
      localObject1 = ((nh)localObject3).KSj;
      localObject2 = com.tencent.mm.pluginsdk.ui.span.l.c(paramv.getContext(), (CharSequence)localObject2);
      localObject3 = com.tencent.mm.plugin.brandservice.b.a.pmT;
      p.g(localObject2, "text");
      ((com.tencent.mm.plugin.brandservice.b.a)localObject3).a((CharSequence)localObject2, paramv, false, (String)localObject1, 4);
      paramv.setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.h((NeatTextView)paramv, (View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.o(paramv.getContext())));
      AppMethodBeat.o(230838);
      return;
    }
    if ((paramv instanceof e.a))
    {
      paramv = this.BmU;
      if (paramv != null)
      {
        paramv.invoke();
        AppMethodBeat.o(230838);
        return;
      }
      AppMethodBeat.o(230838);
      return;
    }
    if ((paramv instanceof e.b))
    {
      if (!kotlin.n.n.aL((CharSequence)this.footerWording)) {
        break label1117;
      }
      localObject1 = paramv.aus;
      p.g(localObject1, "holder.itemView");
    }
    label1117:
    for (Object localObject1 = ((View)localObject1).getContext().getText(2131756774);; localObject1 = (CharSequence)this.footerWording)
    {
      p.g(localObject1, "if (footerWording.isBlan…            footerWording");
      ((e.b)paramv).Bnq.setText((CharSequence)localObject1);
      AppMethodBeat.o(230838);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(230837);
    int i = this.dataList.size();
    AppMethodBeat.o(230837);
    return i + 1;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(230836);
    if (paramInt < this.dataList.size())
    {
      AppMethodBeat.o(230836);
      return 0;
    }
    if (this.Bno)
    {
      AppMethodBeat.o(230836);
      return 1;
    }
    AppMethodBeat.o(230836);
    return 2;
  }
  
  public final void sP(boolean paramBoolean)
  {
    AppMethodBeat.i(230834);
    if (this.Bno == paramBoolean)
    {
      AppMethodBeat.o(230834);
      return;
    }
    this.Bno = paramBoolean;
    ci(this.dataList.size());
    AppMethodBeat.o(230834);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$BizProfileTabVideoVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "coverHeightForVideo", "", "getCoverHeightForVideo", "()I", "coverHeightForVideo$delegate", "Lkotlin/Lazy;", "coverImageView", "Landroid/widget/ImageView;", "getCoverImageView", "()Landroid/widget/ImageView;", "setCoverImageView", "(Landroid/widget/ImageView;)V", "friendRelateInfoTextView", "Landroid/widget/TextView;", "getFriendRelateInfoTextView", "()Landroid/widget/TextView;", "setFriendRelateInfoTextView", "(Landroid/widget/TextView;)V", "shadowView", "getShadowView", "()Landroid/view/View;", "setShadowView", "titleLayout", "Landroid/view/ViewGroup;", "getTitleLayout", "()Landroid/view/ViewGroup;", "setTitleLayout", "(Landroid/view/ViewGroup;)V", "titleTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTextView", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setTitleTextView", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "videoDurationTextView", "getVideoDurationTextView", "setVideoDurationTextView", "app_release"})
  public static final class c
    extends RecyclerView.v
  {
    TextView Bnr;
    TextView Bns;
    View Bnt;
    ViewGroup Bnu;
    MMNeat7extView Bnv;
    final f Bnw;
    ImageView cxe;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(230826);
      View localView = paramView.findViewById(2131297463);
      p.g(localView, "itemView.findViewById(R.…profile_item_video_image)");
      this.cxe = ((ImageView)localView);
      localView = paramView.findViewById(2131297462);
      p.g(localView, "itemView.findViewById(R.…e_item_video_duration_tv)");
      this.Bnr = ((TextView)localView);
      localView = paramView.findViewById(2131297461);
      p.g(localView, "itemView.findViewById(R.…ofile_item_video_desc_tv)");
      this.Bns = ((TextView)localView);
      localView = paramView.findViewById(2131297460);
      p.g(localView, "itemView.findViewById(R.…e_item_video_desc_shadow)");
      this.Bnt = localView;
      localView = paramView.findViewById(2131297465);
      p.g(localView, "itemView.findViewById(R.…_item_video_title_layout)");
      this.Bnu = ((ViewGroup)localView);
      localView = paramView.findViewById(2131297466);
      p.g(localView, "itemView.findViewById(R.…file_item_video_title_tv)");
      this.Bnv = ((MMNeat7extView)localView);
      this.Bnw = g.ah((kotlin.g.a.a)new a(paramView));
      AppMethodBeat.o(230826);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Integer>
    {
      a(View paramView)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(e.c paramc, nh paramnh, ng paramng) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230829);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$onBindVideoItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.profile.ui.tab.data.a.BmH;
      paramView = this.Bny.aus;
      p.g(paramView, "holder.itemView");
      paramView = paramView.getContext();
      p.g(paramView, "holder.itemView.context");
      localObject = new a.a();
      ((a.a)localObject).BmK = this.Bnz;
      ((a.a)localObject).BmL = paramv;
      p.h("", "<set-?>");
      ((a.a)localObject).sPQ = "";
      p.h("", "<set-?>");
      ((a.a)localObject).BmI = "";
      ((a.a)localObject).BmJ = ((View)this.Bny.cxe);
      com.tencent.mm.plugin.profile.ui.tab.data.a.a(paramView, (a.a)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$onBindVideoItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230829);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$setupCoverImage$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
  public static final class g
    implements m.a
  {
    public final void onFinish()
    {
      AppMethodBeat.i(230830);
      e.eFN();
      AppMethodBeat.o(230830);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(230831);
      e.eFO();
      AppMethodBeat.o(230831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.e
 * JD-Core Version:    0.7.0.1
 */