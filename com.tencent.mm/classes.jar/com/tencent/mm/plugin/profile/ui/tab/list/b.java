package com.tencent.mm.plugin.profile.ui.tab.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.profile.ui.tab.data.a.a;
import com.tencent.mm.pluginsdk.model.y;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "(Ljava/util/List;)V", "brandService", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "getBrandService", "()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "brandService$delegate", "Lkotlin/Lazy;", "footerWording", "", "getFooterWording", "()Ljava/lang/String;", "setFooterWording", "(Ljava/lang/String;)V", "onLoadMore", "Lkotlin/Function0;", "", "getOnLoadMore", "()Lkotlin/jvm/functions/Function0;", "setOnLoadMore", "(Lkotlin/jvm/functions/Function0;)V", "value", "", "showLoading", "getShowLoading", "()Z", "setShowLoading", "(Z)V", "getItemCount", "", "getItemViewType", "position", "onBindVideoItem", "holder", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$BizProfileTabVideoVH;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onImageLoadFinish", "onImageLoadStart", "setNeatText", "neatText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "url", "scene", "setupCoverImage", "bizAppMsgDetailInfo", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "coverImageView", "Landroid/widget/ImageView;", "coverHeightForVideo", "firstNotEmpty", "", "([Ljava/lang/String;)Ljava/lang/String;", "BizProfileTabLoadingVH", "BizProfileTabNoMoreVH", "BizProfileTabVideoVH", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<RecyclerView.v>
{
  public static final b.d NfD;
  kotlin.g.a.a<ah> NeE;
  private final j NeF;
  private boolean NfE;
  private final List<px> dataList;
  String footerWording;
  
  static
  {
    AppMethodBeat.i(306227);
    NfD = new b.d((byte)0);
    AppMethodBeat.o(306227);
  }
  
  public b(List<? extends px> paramList)
  {
    AppMethodBeat.i(306170);
    this.dataList = paramList;
    this.NeF = k.cm((kotlin.g.a.a)b.e.NfM);
    this.footerWording = "";
    AppMethodBeat.o(306170);
  }
  
  private static String N(String[] paramArrayOfString)
  {
    AppMethodBeat.i(306190);
    int i = 0;
    String str;
    int j;
    if (i < 3)
    {
      str = paramArrayOfString[i];
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (kotlin.n.n.bp(localCharSequence)))
      {
        j = 1;
        label37:
        if (j != 0) {
          break label66;
        }
        j = 1;
        label43:
        if (j == 0) {
          break label71;
        }
      }
    }
    for (paramArrayOfString = str;; paramArrayOfString = null)
    {
      if (paramArrayOfString != null) {
        break label83;
      }
      AppMethodBeat.o(306190);
      return "";
      j = 0;
      break label37;
      label66:
      j = 0;
      break label43;
      label71:
      i += 1;
      break;
    }
    label83:
    AppMethodBeat.o(306190);
    return paramArrayOfString;
  }
  
  private static final void a(c paramc, od paramod, oc paramoc, View paramView)
  {
    AppMethodBeat.i(306207);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramod);
    localb.cH(paramoc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "$holder");
    paramView = com.tencent.mm.plugin.profile.ui.tab.data.a.Nen;
    paramView = paramc.caK.getContext();
    kotlin.g.b.s.s(paramView, "holder.itemView.context");
    localObject = new a.a();
    ((a.a)localObject).Nep = paramod;
    ((a.a)localObject).Neq = paramoc;
    kotlin.g.b.s.u("", "<set-?>");
    ((a.a)localObject).zRP = "";
    kotlin.g.b.s.u("", "<set-?>");
    ((a.a)localObject).hAw = "";
    ((a.a)localObject).Neo = ((View)paramc.enI);
    paramc = ah.aiuX;
    com.tencent.mm.plugin.profile.ui.tab.data.a.a(paramView, (a.a)localObject);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(306207);
  }
  
  private final com.tencent.mm.plugin.brandservice.api.c gCY()
  {
    AppMethodBeat.i(306182);
    com.tencent.mm.plugin.brandservice.api.c localc = (com.tencent.mm.plugin.brandservice.api.c)this.NeF.getValue();
    AppMethodBeat.o(306182);
    return localc;
  }
  
  public final void AJ(boolean paramBoolean)
  {
    AppMethodBeat.i(306244);
    if (this.NfE == paramBoolean)
    {
      AppMethodBeat.o(306244);
      return;
    }
    this.NfE = paramBoolean;
    fV(this.dataList.size());
    AppMethodBeat.o(306244);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(306253);
    kotlin.g.b.s.u(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gij, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new b(paramViewGroup);
      AppMethodBeat.o(306253);
      return paramViewGroup;
    case 0: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.ghZ, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
      AppMethodBeat.o(306253);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.ghU, paramViewGroup, false);
    kotlin.g.b.s.s(paramViewGroup, "view");
    paramViewGroup = (RecyclerView.v)new b.a(paramViewGroup);
    AppMethodBeat.o(306253);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(306286);
    kotlin.g.b.s.u(paramv, "holder");
    if ((paramv instanceof c))
    {
      Object localObject2 = (c)paramv;
      Object localObject3 = (px)this.dataList.get(paramInt);
      localObject1 = (od)((px)localObject3).YUh.YRm.get(0);
      paramv = ((px)localObject3).YUh.YRl;
      o.F(((c)localObject2).caK, 0.7F);
      ((c)localObject2).caK.setOnClickListener(new b..ExternalSyntheticLambda0((c)localObject2, (od)localObject1, paramv));
      Object localObject4;
      Object localObject5;
      if ((((px)localObject3).YUc.IIs == 49) && (gCY().GV(16)))
      {
        paramv = gCY();
        localObject3 = ((px)localObject3).YUh.YRm;
        kotlin.g.b.s.s(localObject3, "bizMessage.AppMsg.DetailInfo");
        localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (od)((Iterator)localObject4).next();
          ((Collection)localObject3).add(kotlin.a.p.listOf(new String[] { ((od)localObject5).YQK, String.valueOf(((od)localObject5).nUA) }));
        }
        paramv.s((List)localObject3, 126);
      }
      paramv = (CharSequence)((od)localObject1).YQZ;
      label315:
      int i;
      if ((paramv == null) || (kotlin.n.n.bp(paramv)))
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label784;
        }
        ((c)localObject2).NfH.setVisibility(0);
        ((c)localObject2).NfI.setVisibility(0);
        ((c)localObject2).NfH.setText((CharSequence)((od)localObject1).YQZ);
        ((c)localObject2).NfG.setText((CharSequence)com.tencent.mm.message.m.uD(((od)localObject1).YQY));
        kotlin.g.b.s.s(localObject1, "bizAppMsgDetailInfo");
        localObject3 = ((c)localObject2).enI;
        int j = ((Number)((c)localObject2).NfL.getValue()).intValue();
        paramv = (CharSequence)((od)localObject1).YQZ;
        if ((paramv != null) && (!kotlin.n.n.bp(paramv))) {
          break label807;
        }
        paramInt = 1;
        label389:
        if (paramInt == 0) {
          break label812;
        }
        paramInt = R.g.foM;
        label397:
        ((ImageView)localObject3).setBackgroundResource(paramInt);
        paramv = (CharSequence)((od)localObject1).hAP;
        if ((paramv != null) && (paramv.length() != 0)) {
          break label819;
        }
        i = 1;
        label427:
        if (i == 0) {
          break label824;
        }
        paramv = new c(com.tencent.mm.plugin.profile.ui.tab.a.gCw(), true, true);
        label444:
        localObject4 = com.tencent.mm.api.b.U(N(new String[] { ((od)localObject1).YRi, ((od)localObject1).YQM, ((od)localObject1).YQO }), 2);
        kotlin.g.b.s.s(localObject4, "getUrl(coverUrl, BizImag…rategy.SCENE_BIZ_PROFILE)");
        localObject5 = new f(this);
        Object localObject6 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.vQH;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.I(((od)localObject1).YQK, 5, "");
        ((ImageView)localObject3).setImageBitmap(null);
        ((ImageView)localObject3).setImageDrawable(null);
        ((ImageView)localObject3).setImageResource(paramInt);
        ((ImageView)localObject3).setTag(localObject4);
        i = com.tencent.mm.cd.a.ms(((ImageView)localObject3).getContext());
        int k = (int)(com.tencent.mm.cd.a.getDensity(((ImageView)localObject3).getContext()) * 24.0F);
        localObject6 = new c.a();
        ((c.a)localObject6).oKp = true;
        ((c.a)localObject6).oKG = String.valueOf(paramv.gDv());
        ((c.a)localObject6).oKE = paramInt;
        localObject6 = ((c.a)localObject6).eG(i - k, j);
        ((c.a)localObject6).oKJ = true;
        ((c.a)localObject6).oKe = ((com.tencent.mm.modelimage.loader.b.c)new com.tencent.mm.pluginsdk.ui.applet.n(3));
        ((c.a)localObject6).oKN = ((com.tencent.mm.modelimage.loader.b.a)new com.tencent.mm.pluginsdk.ui.applet.e(3));
        ((c.a)localObject6).fullPath = y.bpF((String)localObject4);
        localObject6 = ((c.a)localObject6).bKx();
        localObject5 = new com.tencent.mm.pluginsdk.ui.applet.m(3, -1, -1, (m.a)localObject5);
        com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.vtB;
        com.tencent.mm.plugin.bizui.a.a.a((View)localObject3, paramv.radius, paramv.NfQ, paramv.NfR);
        r.bKe().a((String)localObject4, (ImageView)localObject3, (com.tencent.mm.modelimage.loader.a.c)localObject6, (h)localObject5);
        paramv = (CharSequence)((od)localObject1).hAP;
        if ((paramv != null) && (paramv.length() != 0)) {
          break label840;
        }
      }
      label784:
      label807:
      label812:
      label819:
      label824:
      label840:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label845;
        }
        ((c)localObject2).NfJ.setVisibility(8);
        ((c)localObject2).NfK.setVisibility(8);
        AppMethodBeat.o(306286);
        return;
        paramInt = 0;
        break;
        ((c)localObject2).NfH.setVisibility(8);
        ((c)localObject2).NfI.setVisibility(8);
        break label315;
        paramInt = 0;
        break label389;
        paramInt = R.g.foN;
        break label397;
        i = 0;
        break label427;
        paramv = new c(com.tencent.mm.plugin.profile.ui.tab.a.gCw(), true, false);
        break label444;
      }
      label845:
      ((c)localObject2).NfJ.setVisibility(0);
      ((c)localObject2).NfK.setVisibility(0);
      paramv = ((c)localObject2).NfK;
      localObject2 = ((od)localObject1).hAP;
      kotlin.g.b.s.s(localObject2, "bizAppMsgDetailInfo.Title");
      localObject1 = ((od)localObject1).YQK;
      localObject2 = com.tencent.mm.pluginsdk.ui.span.p.b(paramv.getContext(), (CharSequence)localObject2);
      localObject3 = com.tencent.mm.plugin.brandservice.model.b.vBC;
      kotlin.g.b.s.s(localObject2, "text");
      ((com.tencent.mm.plugin.brandservice.model.b)localObject3).a((CharSequence)localObject2, paramv, false, (String)localObject1, 4);
      paramv.setOnTouchListener((View.OnTouchListener)new l((NeatTextView)paramv, (View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s(paramv.getContext())));
      AppMethodBeat.o(306286);
      return;
    }
    if ((paramv instanceof b.a))
    {
      paramv = this.NeE;
      if (paramv != null)
      {
        paramv.invoke();
        AppMethodBeat.o(306286);
      }
    }
    else if ((paramv instanceof b))
    {
      if (!kotlin.n.n.bp((CharSequence)this.footerWording)) {
        break label1064;
      }
    }
    label1064:
    for (Object localObject1 = paramv.caK.getContext().getText(R.l.biz_time_line_loading_no_more_tips);; localObject1 = (CharSequence)this.footerWording)
    {
      kotlin.g.b.s.s(localObject1, "if (footerWording.isBlan…            footerWording");
      ((b)paramv).NfF.setText((CharSequence)localObject1);
      AppMethodBeat.o(306286);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(306271);
    int i = this.dataList.size();
    AppMethodBeat.o(306271);
    return i + 1;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(306260);
    if (paramInt < this.dataList.size())
    {
      AppMethodBeat.o(306260);
      return 0;
    }
    if (this.NfE)
    {
      AppMethodBeat.o(306260);
      return 1;
    }
    AppMethodBeat.o(306260);
    return 2;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$BizProfileTabNoMoreVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "footerText", "Landroid/widget/TextView;", "getFooterText", "()Landroid/widget/TextView;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.v
  {
    final TextView NfF;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(306154);
      paramView = paramView.findViewById(R.h.ftY);
      kotlin.g.b.s.s(paramView, "itemView.findViewById(R.…rofile_list_no_more_text)");
      this.NfF = ((TextView)paramView);
      AppMethodBeat.o(306154);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$BizProfileTabVideoVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "coverHeightForVideo", "", "getCoverHeightForVideo", "()I", "coverHeightForVideo$delegate", "Lkotlin/Lazy;", "coverImageView", "Landroid/widget/ImageView;", "getCoverImageView", "()Landroid/widget/ImageView;", "setCoverImageView", "(Landroid/widget/ImageView;)V", "friendRelateInfoTextView", "Landroid/widget/TextView;", "getFriendRelateInfoTextView", "()Landroid/widget/TextView;", "setFriendRelateInfoTextView", "(Landroid/widget/TextView;)V", "shadowView", "getShadowView", "()Landroid/view/View;", "setShadowView", "titleLayout", "Landroid/view/ViewGroup;", "getTitleLayout", "()Landroid/view/ViewGroup;", "setTitleLayout", "(Landroid/view/ViewGroup;)V", "titleTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTextView", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setTitleTextView", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "videoDurationTextView", "getVideoDurationTextView", "setVideoDurationTextView", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.v
  {
    TextView NfG;
    TextView NfH;
    View NfI;
    ViewGroup NfJ;
    MMNeat7extView NfK;
    final j NfL;
    ImageView enI;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(306159);
      View localView = paramView.findViewById(R.h.ftV);
      kotlin.g.b.s.s(localView, "itemView.findViewById(R.…profile_item_video_image)");
      this.enI = ((ImageView)localView);
      localView = paramView.findViewById(R.h.ftU);
      kotlin.g.b.s.s(localView, "itemView.findViewById(R.…e_item_video_duration_tv)");
      this.NfG = ((TextView)localView);
      localView = paramView.findViewById(R.h.ftT);
      kotlin.g.b.s.s(localView, "itemView.findViewById(R.…ofile_item_video_desc_tv)");
      this.NfH = ((TextView)localView);
      localView = paramView.findViewById(R.h.ftS);
      kotlin.g.b.s.s(localView, "itemView.findViewById(R.…e_item_video_desc_shadow)");
      this.NfI = localView;
      localView = paramView.findViewById(R.h.ftW);
      kotlin.g.b.s.s(localView, "itemView.findViewById(R.…_item_video_title_layout)");
      this.NfJ = ((ViewGroup)localView);
      localView = paramView.findViewById(R.h.ftX);
      kotlin.g.b.s.s(localView, "itemView.findViewById(R.…file_item_video_title_tv)");
      this.NfK = ((MMNeat7extView)localView);
      this.NfL = k.cm((kotlin.g.a.a)new b.c.a(paramView));
      AppMethodBeat.o(306159);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$setupCoverImage$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements m.a
  {
    f(b paramb) {}
    
    public final void onFinish()
    {
      AppMethodBeat.i(306161);
      b.gDt();
      AppMethodBeat.o(306161);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(306167);
      b.gDu();
      AppMethodBeat.o(306167);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.b
 * JD-Core Version:    0.7.0.1
 */