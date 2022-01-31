package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import a.f;
import a.f.b.t;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.h.a;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.viewitems.d.f;
import com.tencent.mm.ui.chatting.viewitems.d.g;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter$Interpolator;", "ui", "Lcom/tencent/mm/ui/MMActivity;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "orginAdapter", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;", "footer", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;[Ljava/lang/String;)V", "adapter", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;)V", "brandService", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "getBrandService", "()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "brandService$delegate", "Lkotlin/Lazy;", "changedPlayId", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExpandSet", "()Ljava/util/HashSet;", "getFooter", "()[Ljava/lang/String;", "[Ljava/lang/String;", "originalCount", "getOriginalCount", "()I", "setOriginalCount", "(I)V", "getUi", "()Lcom/tencent/mm/ui/MMActivity;", "getWidget", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "getCount", "getFooterCount", "getItem", "", "position", "getRelativePosition", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "isInterpolated", "", "onMusicStateChanged", "", "event", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "preloadPage", "fromPosition", "toPosition", "update", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "BizMsgViewHolder", "CommonSlotViewModel", "Companion", "SlotType", "SlotViewModel", "TopSlotViewModel", "ViewHolder", "app_release"})
public final class c
  implements h.a
{
  private static final String TAG = "MicroMsg.NewBizInfoAdapter";
  public static final c.c pEB;
  private final String[] pEA;
  public a pEs;
  public String pEt;
  public int pEu;
  private final f pEv;
  private final HashSet<Integer> pEw;
  final MMActivity pEx;
  public final com.tencent.mm.plugin.profile.ui.newbizinfo.b pEy;
  public final com.tencent.mm.ui.base.preference.h pEz;
  
  static
  {
    AppMethodBeat.i(154131);
    eOJ = new a.j.k[] { (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(c.class), "brandService", "getBrandService()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;")) };
    pEB = new c.c((byte)0);
    TAG = "MicroMsg.NewBizInfoAdapter";
    AppMethodBeat.o(154131);
  }
  
  public c(MMActivity paramMMActivity, com.tencent.mm.plugin.profile.ui.newbizinfo.b paramb, com.tencent.mm.ui.base.preference.h paramh, String[] paramArrayOfString)
  {
    AppMethodBeat.i(154138);
    this.pEx = paramMMActivity;
    this.pEy = paramb;
    this.pEz = paramh;
    this.pEA = paramArrayOfString;
    this.pEs = new a();
    this.pEt = "none";
    this.pEv = a.g.j((a.f.a.a)c.h.pFA);
    this.pEw = new HashSet();
    AppMethodBeat.o(154138);
  }
  
  public final boolean BN(int paramInt)
  {
    AppMethodBeat.i(154134);
    int i = ccU();
    if ((paramInt >= this.pEu - i) && (paramInt < this.pEz.getCount() - i))
    {
      AppMethodBeat.o(154134);
      return true;
    }
    AppMethodBeat.o(154134);
    return false;
  }
  
  public final int BO(int paramInt)
  {
    AppMethodBeat.i(154135);
    int i = this.pEz.getCount();
    if (paramInt >= i - ccU())
    {
      int j = this.pEu;
      AppMethodBeat.o(154135);
      return j + paramInt - i;
    }
    AppMethodBeat.o(154135);
    return paramInt;
  }
  
  public final int ccU()
  {
    AppMethodBeat.i(154132);
    String[] arrayOfString = this.pEA;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      int k = this.pEz.atz(str);
      if (k != -1)
      {
        i = this.pEu;
        AppMethodBeat.o(154132);
        return i - k;
      }
      i += 1;
    }
    AppMethodBeat.o(154132);
    return 0;
  }
  
  public final com.tencent.mm.plugin.brandservice.a.b ccV()
  {
    AppMethodBeat.i(154136);
    com.tencent.mm.plugin.brandservice.a.b localb = (com.tencent.mm.plugin.brandservice.a.b)this.pEv.getValue();
    AppMethodBeat.o(154136);
    return localb;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(154137);
    paramInt = paramInt - this.pEu + ccU();
    Object localObject1 = this.pEs.BL(paramInt);
    Object localObject2;
    switch (f.bLo[localObject1.ordinal()])
    {
    default: 
      paramView = LayoutInflater.from((Context)this.pEx.getContext()).inflate(2130969224, paramViewGroup, false);
      if (paramView == null)
      {
        paramView = new a.v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(154137);
        throw paramView;
      }
      break;
    case 1: 
      paramView = LayoutInflater.from((Context)this.pEx.getContext()).inflate(2130969226, paramViewGroup, false);
      this.pEy.ccL();
      AppMethodBeat.o(154137);
      return paramView;
    case 2: 
      localObject1 = this.pEs.BM(paramInt);
      if ((((lf)localObject1).wzu.nqW == 49) && (ccV().rU(16)))
      {
        localObject2 = ccV();
        Object localObject3 = ((lf)localObject1).wzz.wxG;
        a.f.b.j.p(localObject3, "bizMessage.AppMsg.DetailInfo");
        Object localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject4));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          kf localkf = (kf)((Iterator)localObject4).next();
          ((Collection)localObject3).add(a.a.j.listOf(new String[] { localkf.wxi, String.valueOf(localkf.wqp) }));
        }
        ((com.tencent.mm.plugin.brandservice.a.b)localObject2).i((List)localObject3, 126);
      }
      paramView = new c.a(this, paramView, paramViewGroup, (lf)localObject1, this.pEw, paramInt / 2).view;
      AppMethodBeat.o(154137);
      return paramView;
    }
    paramView = (ViewGroup)paramView;
    paramViewGroup = (TextView)paramView.findViewById(2131823058);
    if (paramViewGroup != null)
    {
      localObject2 = this.pEs;
      localObject1 = ah.getContext();
      ((a)localObject2).BL(paramInt);
      long l = 1000L * ((a)localObject2).BM(paramInt).wzu.wMO;
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTime(new Date(l));
      a.f.b.j.p(localObject2, "Calendar.getInstance().apply { time = Date(date) }");
      DateFormat.format((CharSequence)((Context)localObject1).getString(2131300061), l);
      paramViewGroup.setText((CharSequence)com.tencent.mm.pluginsdk.f.h.c((Context)localObject1, l, false).toString());
    }
    paramView = (View)paramView;
    AppMethodBeat.o(154137);
    return paramView;
  }
  
  public final int ub(int paramInt)
  {
    AppMethodBeat.i(154133);
    this.pEu = paramInt;
    int i = this.pEs.elu.size();
    AppMethodBeat.o(154133);
    return i + paramInt;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$1$3"})
  static final class a$a
    implements View.OnClickListener
  {
    a$a(c.a.b paramb, String paramString, c.a parama, kf paramkf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(154050);
      this.pEC.ate();
      d.f localf = new d.f();
      d.g localg = new d.g();
      localg.zTg = this.pED;
      localg.url = this.pEF.wxi;
      localg.title = this.pEF.Title;
      localg.fjX = "";
      localg.playUrl = this.pEF.wxs;
      localg.lHo = this.pEF.wxk;
      localf.zTe = localg;
      paramView.setTag(localf);
      r.eQ(paramView);
      AppMethodBeat.o(154050);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"drawPlaying", "", "invoke"})
  static final class a$b
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    a$b(ImageView paramImageView)
    {
      super();
    }
    
    public final void ate()
    {
      AppMethodBeat.i(154052);
      this.pEG.setImageResource(2130837975);
      Object localObject = this.pEG.getDrawable();
      if (localObject == null)
      {
        localObject = new a.v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(154052);
        throw ((Throwable)localObject);
      }
      localObject = (AnimationDrawable)localObject;
      if (localObject != null)
      {
        ((AnimationDrawable)localObject).start();
        AppMethodBeat.o(154052);
        return;
      }
      AppMethodBeat.o(154052);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel$imageUrl$imageLoaderListener$1$1"})
  static final class e$c
    implements Runnable
  {
    e$c(c.e parame, String paramString, com.tencent.mm.at.a.a.c paramc, float[] paramArrayOfFloat, c.e.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(154080);
      com.tencent.mm.at.a.a locala = o.ahG();
      String str = this.kcQ;
      ImageView localImageView1 = c.e.b(this.pFe);
      com.tencent.mm.at.a.a.c localc = this.pFf;
      ImageView localImageView2 = c.e.b(this.pFe);
      a.f.b.j.p(localImageView2, "imageIv");
      int i = localImageView2.getMeasuredWidth();
      localImageView2 = c.e.b(this.pFe);
      a.f.b.j.p(localImageView2, "imageIv");
      locala.a(str, localImageView1, localc, (com.tencent.mm.at.a.c.g)new e(i, localImageView2.getMeasuredHeight(), this.pFg, (e.a)this.pFh));
      AppMethodBeat.o(154080);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel$imageUrl$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
  public static final class e$d
    implements e.a
  {
    public final void onFinish()
    {
      AppMethodBeat.i(154081);
      c.c localc = c.pEB;
      ab.v(c.access$getTAG$cp(), "imageUrl onFinish:" + c.e.a(this.pFe));
      this.pFe.ccW();
      AppMethodBeat.o(154081);
    }
    
    public final void onStart()
    {
      AppMethodBeat.i(154082);
      c.c localc = c.pEB;
      ab.v(c.access$getTAG$cp(), "imageUrl onStart:" + c.e.a(this.pFe));
      this.pFe.cdb();
      AppMethodBeat.o(154082);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f$h
    extends a.f.b.k
    implements a.f.a.a<View>
  {
    f$h(c.f paramf)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f$j
    extends a.f.b.k
    implements a.f.a.a<MMNeat7extView>
  {
    f$j(c.f paramf, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.c
 * JD-Core Version:    0.7.0.1
 */