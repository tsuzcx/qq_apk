package com.tencent.mm.plugin.profile.ui.tab.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.profile.ui.tab.data.a.a;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.acj;
import com.tencent.mm.protocal.protobuf.mx;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.protocal.protobuf.oo;
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
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "(Ljava/util/List;)V", "brandService", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "getBrandService", "()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "brandService$delegate", "Lkotlin/Lazy;", "footerWording", "", "getFooterWording", "()Ljava/lang/String;", "setFooterWording", "(Ljava/lang/String;)V", "onLoadMore", "Lkotlin/Function0;", "", "getOnLoadMore", "()Lkotlin/jvm/functions/Function0;", "setOnLoadMore", "(Lkotlin/jvm/functions/Function0;)V", "value", "", "showLoading", "getShowLoading", "()Z", "setShowLoading", "(Z)V", "getItemCount", "", "getItemViewType", "position", "onBindVideoItem", "holder", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$BizProfileTabVideoVH;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onImageLoadFinish", "onImageLoadStart", "setNeatText", "neatText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "url", "scene", "setupCoverImage", "bizAppMsgDetailInfo", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "coverImageView", "Landroid/widget/ImageView;", "coverHeightForVideo", "firstNotEmpty", "", "([Ljava/lang/String;)Ljava/lang/String;", "BizProfileTabLoadingVH", "BizProfileTabNoMoreVH", "BizProfileTabVideoVH", "Companion", "app_release"})
public final class d
  extends RecyclerView.a<RecyclerView.v>
{
  public static final d.d HhL;
  private final f HeK;
  private boolean HhK;
  kotlin.g.a.a<x> Hhp;
  private final List<oo> dataList;
  String footerWording;
  
  static
  {
    AppMethodBeat.i(292423);
    HhL = new d.d((byte)0);
    AppMethodBeat.o(292423);
  }
  
  public d(List<? extends oo> paramList)
  {
    AppMethodBeat.i(292422);
    this.dataList = paramList;
    this.HeK = g.ar((kotlin.g.a.a)d.e.HhT);
    this.footerWording = "";
    AppMethodBeat.o(292422);
  }
  
  private static String M(String[] paramArrayOfString)
  {
    AppMethodBeat.i(292421);
    int i = 0;
    Object localObject;
    int j;
    if (i < 3)
    {
      localObject = paramArrayOfString[i];
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence == null) || (kotlin.n.n.ba(localCharSequence)))
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
      AppMethodBeat.o(292421);
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
  
  private final com.tencent.mm.plugin.brandservice.a.c fra()
  {
    AppMethodBeat.i(292415);
    com.tencent.mm.plugin.brandservice.a.c localc = (com.tencent.mm.plugin.brandservice.a.c)this.HeK.getValue();
    AppMethodBeat.o(292415);
    return localc;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(292417);
    kotlin.g.b.p.k(paramViewGroup, "parent");
    switch (paramInt)
    {
    default: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.efn, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new d.b(paramViewGroup);
      AppMethodBeat.o(292417);
      return paramViewGroup;
    case 0: 
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.eff, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new d.c(paramViewGroup);
      AppMethodBeat.o(292417);
      return paramViewGroup;
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.efa, paramViewGroup, false);
    kotlin.g.b.p.j(paramViewGroup, "view");
    paramViewGroup = (RecyclerView.v)new d.a(paramViewGroup);
    AppMethodBeat.o(292417);
    return paramViewGroup;
  }
  
  public final void d(final RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(292420);
    kotlin.g.b.p.k(paramv, "holder");
    if ((paramv instanceof d.c))
    {
      Object localObject2 = (d.c)paramv;
      Object localObject3 = (oo)this.dataList.get(paramInt);
      localObject1 = (my)((oo)localObject3).RWB.RTM.get(0);
      paramv = ((oo)localObject3).RWB.RTK;
      com.tencent.mm.ui.tools.p.iF(((d.c)localObject2).amk);
      ((d.c)localObject2).amk.setOnClickListener((View.OnClickListener)new f((d.c)localObject2, (my)localObject1, paramv));
      Object localObject4;
      Object localObject5;
      if ((((oo)localObject3).RWw.COi == 49) && (fra().Gw(16)))
      {
        paramv = fra();
        localObject3 = ((oo)localObject3).RWB.RTM;
        kotlin.g.b.p.j(localObject3, "bizMessage.AppMsg.DetailInfo");
        localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (my)((Iterator)localObject4).next();
          ((Collection)localObject3).add(j.listOf(new String[] { ((my)localObject5).RTk, String.valueOf(((my)localObject5).lpx) }));
        }
        paramv.j((List)localObject3, 126);
      }
      paramv = (CharSequence)((my)localObject1).RTz;
      label313:
      int i;
      if ((paramv == null) || (kotlin.n.n.ba(paramv)))
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label802;
        }
        ((d.c)localObject2).HhO.setVisibility(0);
        ((d.c)localObject2).HhP.setVisibility(0);
        ((d.c)localObject2).HhO.setText((CharSequence)((my)localObject1).RTz);
        ((d.c)localObject2).HhN.setText((CharSequence)com.tencent.mm.aj.m.uD(((my)localObject1).RTy));
        kotlin.g.b.p.j(localObject1, "bizAppMsgDetailInfo");
        localObject3 = ((d.c)localObject2).cvK;
        int j = ((Number)((d.c)localObject2).HhS.getValue()).intValue();
        paramv = (CharSequence)((my)localObject1).RTz;
        if ((paramv != null) && (!kotlin.n.n.ba(paramv))) {
          break label825;
        }
        paramInt = 1;
        label387:
        if (paramInt == 0) {
          break label830;
        }
        paramInt = R.g.doo;
        label395:
        ((ImageView)localObject3).setBackgroundResource(paramInt);
        paramv = (CharSequence)((my)localObject1).fwr;
        if ((paramv != null) && (paramv.length() != 0)) {
          break label837;
        }
        i = 1;
        label425:
        if (i == 0) {
          break label842;
        }
        paramv = kotlin.a.e.b(new Float[] { Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.frs()), Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.frs()), Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.frs()), Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.frs()) });
        label473:
        localObject4 = com.tencent.mm.api.b.M(M(new String[] { ((my)localObject1).RTI, ((my)localObject1).RTm, ((my)localObject1).RTo }), 2);
        kotlin.g.b.p.j(localObject4, "BizImageStrategy.getUrl(…rategy.SCENE_BIZ_PROFILE)");
        localObject5 = new g(this);
        Object localObject6 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.sKW;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.G(((my)localObject1).RTk, 5, "");
        ((ImageView)localObject3).setImageBitmap(null);
        ((ImageView)localObject3).setImageDrawable(null);
        ((ImageView)localObject3).setImageResource(paramInt);
        ((ImageView)localObject3).setTag(localObject4);
        i = com.tencent.mm.ci.a.kr(((ImageView)localObject3).getContext());
        int k = (int)(com.tencent.mm.ci.a.getDensity(((ImageView)localObject3).getContext()) * 24.0F);
        localObject6 = new c.a().bmF();
        StringBuilder localStringBuilder = new StringBuilder("radius_");
        String str = Arrays.toString(paramv);
        kotlin.g.b.p.j(str, "java.util.Arrays.toString(this)");
        localObject6 = ((c.a)localObject6).Ws(str).wz(paramInt).dO(i - k, j).a((com.tencent.mm.ay.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.ay.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).Wq(w.bpO((String)localObject4)).bmL();
        paramv = new com.tencent.mm.pluginsdk.ui.applet.m(3, -1, -1, paramv, (m.a)localObject5);
        paramv.aM((Runnable)d.h.HhY);
        q.bml().a((String)localObject4, (ImageView)localObject3, (com.tencent.mm.ay.a.a.c)localObject6, (com.tencent.mm.ay.a.c.h)paramv);
        paramv = (CharSequence)((my)localObject1).fwr;
        if ((paramv != null) && (paramv.length() != 0)) {
          break label885;
        }
      }
      label802:
      label825:
      label830:
      label837:
      label842:
      label885:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label890;
        }
        ((d.c)localObject2).HhQ.setVisibility(8);
        ((d.c)localObject2).HhR.setVisibility(8);
        AppMethodBeat.o(292420);
        return;
        paramInt = 0;
        break;
        ((d.c)localObject2).HhO.setVisibility(8);
        ((d.c)localObject2).HhP.setVisibility(8);
        break label313;
        paramInt = 0;
        break label387;
        paramInt = R.g.dop;
        break label395;
        i = 0;
        break label425;
        paramv = kotlin.a.e.b(new Float[] { Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.frs()), Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.frs()), Float.valueOf(0.0F), Float.valueOf(0.0F) });
        break label473;
      }
      label890:
      ((d.c)localObject2).HhQ.setVisibility(0);
      ((d.c)localObject2).HhR.setVisibility(0);
      paramv = ((d.c)localObject2).HhR;
      localObject2 = ((my)localObject1).fwr;
      kotlin.g.b.p.j(localObject2, "bizAppMsgDetailInfo.Title");
      localObject1 = ((my)localObject1).RTk;
      localObject2 = com.tencent.mm.pluginsdk.ui.span.l.c(paramv.getContext(), (CharSequence)localObject2);
      localObject3 = com.tencent.mm.plugin.brandservice.b.b.svR;
      kotlin.g.b.p.j(localObject2, "text");
      ((com.tencent.mm.plugin.brandservice.b.b)localObject3).a((CharSequence)localObject2, paramv, false, (String)localObject1, 4);
      paramv.setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.h((NeatTextView)paramv, (View.OnTouchListener)new o(paramv.getContext())));
      AppMethodBeat.o(292420);
      return;
    }
    if ((paramv instanceof d.a))
    {
      paramv = this.Hhp;
      if (paramv != null)
      {
        paramv.invoke();
        AppMethodBeat.o(292420);
        return;
      }
      AppMethodBeat.o(292420);
      return;
    }
    if ((paramv instanceof d.b))
    {
      if (!kotlin.n.n.ba((CharSequence)this.footerWording)) {
        break label1124;
      }
      localObject1 = paramv.amk;
      kotlin.g.b.p.j(localObject1, "holder.itemView");
    }
    label1124:
    for (Object localObject1 = ((View)localObject1).getContext().getText(R.l.esR);; localObject1 = (CharSequence)this.footerWording)
    {
      kotlin.g.b.p.j(localObject1, "if (footerWording.isBlan…            footerWording");
      ((d.b)paramv).HhM.setText((CharSequence)localObject1);
      AppMethodBeat.o(292420);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(292419);
    int i = this.dataList.size();
    AppMethodBeat.o(292419);
    return i + 1;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(292418);
    if (paramInt < this.dataList.size())
    {
      AppMethodBeat.o(292418);
      return 0;
    }
    if (this.HhK)
    {
      AppMethodBeat.o(292418);
      return 1;
    }
    AppMethodBeat.o(292418);
    return 2;
  }
  
  public final void wj(boolean paramBoolean)
  {
    AppMethodBeat.i(292416);
    if (this.HhK == paramBoolean)
    {
      AppMethodBeat.o(292416);
      return;
    }
    this.HhK = paramBoolean;
    cL(this.dataList.size());
    AppMethodBeat.o(292416);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(d.c paramc, my parammy, mx parammx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(281833);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$onBindVideoItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.plugin.profile.ui.tab.data.a.Hhb;
      paramView = this.HhU.amk;
      kotlin.g.b.p.j(paramView, "holder.itemView");
      paramView = paramView.getContext();
      kotlin.g.b.p.j(paramView, "holder.itemView.context");
      localObject = new a.a();
      ((a.a)localObject).Hhd = this.HhV;
      ((a.a)localObject).Hhe = paramv;
      kotlin.g.b.p.k("", "<set-?>");
      ((a.a)localObject).wvK = "";
      kotlin.g.b.p.k("", "<set-?>");
      ((a.a)localObject).fvZ = "";
      ((a.a)localObject).Hhc = ((View)this.HhU.cvK);
      com.tencent.mm.plugin.profile.ui.tab.data.a.a(paramView, (a.a)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$onBindVideoItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(281833);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$setupCoverImage$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
  public static final class g
    implements m.a
  {
    public final void onFinish()
    {
      AppMethodBeat.i(208129);
      d.frM();
      AppMethodBeat.o(208129);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(208131);
      d.frN();
      AppMethodBeat.o(208131);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.d
 * JD-Core Version:    0.7.0.1
 */