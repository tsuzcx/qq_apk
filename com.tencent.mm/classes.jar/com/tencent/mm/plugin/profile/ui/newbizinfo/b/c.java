package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.protobuf.btp;
import com.tencent.mm.protocal.protobuf.ccj;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.protocal.protobuf.xq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.h.a;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import d.a.j;
import d.g.b.w;
import d.g.b.z;
import d.v;
import d.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter$Interpolator;", "ui", "Lcom/tencent/mm/ui/MMActivity;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "orginAdapter", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;", "footer", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;[Ljava/lang/String;)V", "adapter", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;)V", "brandService", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "getBrandService", "()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "brandService$delegate", "Lkotlin/Lazy;", "changedPlayId", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExpandSet", "()Ljava/util/HashSet;", "getFooter", "()[Ljava/lang/String;", "[Ljava/lang/String;", "isBizPayOpen", "", "()Z", "originalCount", "getOriginalCount", "()I", "setOriginalCount", "(I)V", "getUi", "()Lcom/tencent/mm/ui/MMActivity;", "getWidget", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "getCount", "getFooterCount", "getItem", "", "position", "getRelativePosition", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "isInterpolated", "onMusicStateChanged", "", "event", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "preloadPage", "fromPosition", "toPosition", "update", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "notifyInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "BizMsgViewHolder", "CommonSlotViewModel", "Companion", "SlotType", "SlotViewModel", "TopSlotViewModel", "VideoChannelViewHolder", "ViewHolder", "app_release"})
public final class c
  implements h.a
{
  private static final String TAG = "MicroMsg.NewBizInfoAdapter";
  public static final c uGJ;
  public String uGA;
  public int uGB;
  private final d.f uGC;
  final boolean uGD;
  private final HashSet<Integer> uGE;
  final MMActivity uGF;
  public final ContactWidgetNewBizInfo uGG;
  public final com.tencent.mm.ui.base.preference.h uGH;
  private final String[] uGI;
  public a uGz;
  
  static
  {
    AppMethodBeat.i(39720);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(c.class), "brandService", "getBrandService()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;")) };
    uGJ = new c((byte)0);
    TAG = "MicroMsg.NewBizInfoAdapter";
    AppMethodBeat.o(39720);
  }
  
  public c(MMActivity paramMMActivity, ContactWidgetNewBizInfo paramContactWidgetNewBizInfo, com.tencent.mm.ui.base.preference.h paramh, String[] paramArrayOfString)
  {
    AppMethodBeat.i(39727);
    this.uGF = paramMMActivity;
    this.uGG = paramContactWidgetNewBizInfo;
    this.uGH = paramh;
    this.uGI = paramArrayOfString;
    com.tencent.mm.plugin.brandservice.b.d.init();
    this.uGz = new a();
    this.uGA = "none";
    this.uGC = d.g.E((d.g.a.a)c.i.uHO);
    paramMMActivity = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
    d.g.b.k.g(paramMMActivity, "MMKernel.service(IBrandService::class.java)");
    this.uGD = ((com.tencent.mm.plugin.brandservice.a.b)paramMMActivity).bBS();
    this.uGE = new HashSet();
    AppMethodBeat.o(39727);
  }
  
  public final int JB(int paramInt)
  {
    AppMethodBeat.i(39722);
    this.uGB = paramInt;
    a locala = this.uGz;
    int i = locala.fyl.size();
    int j = locala.uGf.size();
    AppMethodBeat.o(39722);
    return j + i + paramInt;
  }
  
  public final boolean JC(int paramInt)
  {
    AppMethodBeat.i(39723);
    int i = ddl();
    if ((paramInt >= this.uGB - i) && (paramInt < this.uGH.getCount() - i))
    {
      AppMethodBeat.o(39723);
      return true;
    }
    AppMethodBeat.o(39723);
    return false;
  }
  
  public final int JD(int paramInt)
  {
    AppMethodBeat.i(39724);
    int i = this.uGH.getCount();
    if (paramInt >= i - ddl())
    {
      int j = this.uGB;
      AppMethodBeat.o(39724);
      return j + paramInt - i;
    }
    AppMethodBeat.o(39724);
    return paramInt;
  }
  
  public final int ddl()
  {
    AppMethodBeat.i(39721);
    String[] arrayOfString = this.uGI;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      int k = this.uGH.aKm(str);
      if (k != -1)
      {
        i = this.uGB;
        AppMethodBeat.o(39721);
        return i - k;
      }
      i += 1;
    }
    AppMethodBeat.o(39721);
    return 0;
  }
  
  public final com.tencent.mm.plugin.brandservice.a.b ddm()
  {
    AppMethodBeat.i(39725);
    com.tencent.mm.plugin.brandservice.a.b localb = (com.tencent.mm.plugin.brandservice.a.b)this.uGC.getValue();
    AppMethodBeat.o(39725);
    return localb;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39726);
    paramInt = paramInt - this.uGB + ddl();
    Object localObject1 = this.uGz.Jy(paramInt);
    Object localObject2;
    Object localObject3;
    switch (f.ciE[localObject1.ordinal()])
    {
    default: 
      paramView = LayoutInflater.from((Context)this.uGF.getContext()).inflate(2131493610, paramViewGroup, false);
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      break;
    case 1: 
      paramView = LayoutInflater.from((Context)this.uGF.getContext()).inflate(2131493612, paramViewGroup, false);
      this.uGG.bYc();
      AppMethodBeat.o(39726);
      return paramView;
    case 2: 
      localObject1 = this.uGz.getItem(paramInt);
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      localObject1 = (mv)localObject1;
      if ((((mv)localObject1).CKn.saz == 49) && (ddm().xA(16)))
      {
        localObject2 = ddm();
        localObject3 = ((mv)localObject1).CKs.CIj;
        d.g.b.k.g(localObject3, "bizMessage.AppMsg.DetailInfo");
        Object localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          lr locallr = (lr)((Iterator)localObject4).next();
          ((Collection)localObject3).add(j.listOf(new String[] { locallr.CHL, String.valueOf(locallr.gKq) }));
        }
        ((com.tencent.mm.plugin.brandservice.a.b)localObject2).i((List)localObject3, 126);
      }
      paramView = new a(this, paramView, paramViewGroup, (mv)localObject1, this.uGE, paramInt / 2).view;
      AppMethodBeat.o(39726);
      return paramView;
    case 3: 
      localObject1 = this.uGF.getContext();
      d.g.b.k.g(localObject1, "ui.context");
      localObject1 = (Context)localObject1;
      localObject2 = this.uGG;
      localObject3 = this.uGz.getItem(paramInt);
      if (localObject3 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ProfileNotifyInfo");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      paramView = new g((Context)localObject1, (ContactWidgetNewBizInfo)localObject2, paramView, paramViewGroup, (ccj)localObject3).view;
      AppMethodBeat.o(39726);
      return paramView;
    }
    paramView = (ViewGroup)paramView;
    paramViewGroup = (TextView)paramView.findViewById(2131297310);
    if (paramViewGroup != null)
    {
      localObject2 = this.uGz;
      localObject1 = aj.getContext();
      ((a)localObject2).Jy(paramInt);
      localObject2 = ((a)localObject2).getItem(paramInt);
      if (localObject2 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      long l = 1000L * ((mv)localObject2).CKn.CZk;
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTime(new Date(l));
      d.g.b.k.g(localObject2, "Calendar.getInstance().apply { time = Date(date) }");
      DateFormat.format((CharSequence)((Context)localObject1).getString(2131759528), l);
      paramViewGroup.setText((CharSequence)com.tencent.mm.pluginsdk.g.h.c((Context)localObject1, l, false).toString());
    }
    paramView = (View)paramView;
    AppMethodBeat.o(39726);
    return paramView;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "interpolator", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "bizMsg", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "position", "(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;Landroid/view/View;Landroid/view/ViewGroup;Lcom/tencent/mm/protocal/protobuf/BizMessage;Ljava/util/HashSet;I)V", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "isBizPayOpen", "", "()Z", "setBizPayOpen", "(Z)V", "view", "getView", "()Landroid/view/View;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "fillCommonSlot", "", "container", "detail", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "base", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "fillSingleText", "text", "Lcom/tencent/mm/protocal/protobuf/BizTextMsgInfo;", "Lcom/tencent/mm/protocal/protobuf/CommMsgBaseInfo;", "fillSlotTarget", "fillTopSlot", "commBase", "getPlayId", "", "isPlaying", "playId", "firstNotEmpty", "", "([Ljava/lang/String;)Ljava/lang/String;", "app_release"})
  static final class a
    extends c.h
  {
    Context context;
    Intent intent;
    private boolean uGD;
    private HashSet<Integer> uGE;
    ContactWidgetNewBizInfo uGG;
    final View view;
    
    public a(c paramc, View paramView, ViewGroup paramViewGroup, mv parammv, HashSet<Integer> paramHashSet, int paramInt)
    {
      AppMethodBeat.i(39645);
      this.uGD = true;
      Object localObject1 = paramc.uGF.getContext();
      d.g.b.k.g(localObject1, "interpolator.ui.context");
      this.context = ((Context)localObject1);
      this.uGG = paramc.uGG;
      localObject1 = paramc.uGF.getIntent();
      d.g.b.k.g(localObject1, "interpolator.ui.intent");
      this.intent = ((Intent)localObject1);
      this.uGE = paramHashSet;
      this.uGD = paramc.uGD;
      Object localObject2;
      int i;
      if (paramView != null)
      {
        paramHashSet = paramView.getTag();
        if (!d.g.b.k.g(paramHashSet, parammv)) {
          break label261;
        }
        localObject2 = parammv.CKs;
        paramHashSet = this;
        localObject1 = paramView;
        if (localObject2 == null) {
          break label248;
        }
        localObject2 = ((ls)localObject2).CIj;
        paramHashSet = this;
        localObject1 = paramView;
        if (localObject2 == null) {
          break label248;
        }
        i = 0;
        paramHashSet = ((Iterable)localObject2).iterator();
        label174:
        if (!paramHashSet.hasNext()) {
          break label236;
        }
        localObject1 = (lr)paramHashSet.next();
        d.g.b.k.g(localObject1, "detail");
        if (!d.g.b.k.g(a((lr)localObject1), c.a(paramc))) {
          break label1439;
        }
        c.a(paramc, "none");
        i = 1;
      }
      label261:
      label654:
      label913:
      label922:
      label1439:
      for (;;)
      {
        break label174;
        paramHashSet = null;
        break;
        label236:
        if (i != 1)
        {
          localObject1 = paramView;
          paramHashSet = this;
          label248:
          paramHashSet.view = ((View)localObject1);
          AppMethodBeat.o(39645);
          return;
        }
        paramc = LayoutInflater.from(this.context).inflate(2131493608, paramViewGroup, false);
        if (paramc == null)
        {
          paramc = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(39645);
          throw paramc;
        }
        paramView = (ViewGroup)paramc;
        paramView.setTag(this);
        switch (parammv.CKn.saz)
        {
        }
        int j;
        label704:
        label762:
        do
        {
          do
          {
            for (;;)
            {
              localObject1 = (View)paramView;
              paramHashSet = this;
              break;
              paramc = parammv.CKo;
              d.g.b.k.g(paramc, "bizMsg.Text");
              parammv = parammv.CKn;
              d.g.b.k.g(parammv, "bizMsg.BaseInfo");
              paramViewGroup = new c.f(10, c.d.uHc, paramView);
              paramInt = parammv.uKX;
              parammv = this.uGE;
              paramc = paramc.gKr;
              d.g.b.k.g(paramc, "text.Content");
              paramViewGroup.a(paramInt, parammv, paramc);
            }
            j = parammv.CKs.CIj.size();
            if (j <= 1) {
              break label1006;
            }
            paramc = c.d.uGZ;
            if (parammv.CKs.CIi.CHI == 0) {
              break label1375;
            }
            paramViewGroup = parammv.CKs.CIj.get(0);
            d.g.b.k.g(paramViewGroup, "bizMsg.AppMsg.DetailInfo[0]");
            paramViewGroup = (lr)paramViewGroup;
            paramHashSet = parammv.CKs.CIi;
            d.g.b.k.g(paramHashSet, "bizMsg.AppMsg.BaseInfo");
            localObject2 = parammv.CKn;
            d.g.b.k.g(localObject2, "bizMsg.BaseInfo");
            localObject1 = c.uGJ;
            ad.v(c.access$getTAG$cp(), "fillTopSlot:" + paramViewGroup.CHL);
            localObject1 = new c.f(paramViewGroup.gKq, paramc, paramView);
            if ((paramViewGroup.gKq != 8) && (paramViewGroup.gKq != 10))
            {
              ((c.f)localObject1).uGX = paramViewGroup.CIh;
              ((c.f)localObject1).url = paramViewGroup.CHL;
              String str = paramViewGroup.Title;
              d.g.b.k.g(str, "detail.Title");
              ((c.f)localObject1).setTitle(str);
            }
            if (paramc == c.d.uHc)
            {
              paramc = (CharSequence)paramViewGroup.CHJ;
              if ((paramc != null) && (!d.n.n.aC(paramc))) {
                break label1013;
              }
              i = 1;
              if (i == 0) {
                ((MMNeat7extView)((c.f)localObject1).uHD.getValue()).aq((CharSequence)paramViewGroup.CHJ);
              }
            }
            paramc = (CharSequence)paramViewGroup.CIa;
            if ((paramc != null) && (!d.n.n.aC(paramc))) {
              break label1019;
            }
            i = 1;
            if (i == 0)
            {
              paramc = ((c.f)localObject1).ddq();
              d.g.b.k.g(paramc, "view.showDescTv");
              paramc.setText((CharSequence)paramViewGroup.CIa);
            }
            paramc = ((c.f)localObject1).ddq();
            if (paramc != null)
            {
              if ((((c.f)localObject1).uGX != 1) || (this.uGD)) {
                break label1025;
              }
              i = 4;
              paramc.setVisibility(i);
            }
            switch (paramViewGroup.gKq)
            {
            case 6: 
            default: 
              switch (paramViewGroup.gKq)
              {
              case 8: 
              case 9: 
              default: 
                switch (paramViewGroup.gKq)
                {
                default: 
                  paramc = new String[2];
                  paramc[0] = paramViewGroup.CHN;
                  paramc[1] = paramViewGroup.CHP;
                  ((c.f)localObject1).setImageUrl(I(paramc));
                  a((View)((c.f)localObject1).ddr(), paramViewGroup, paramHashSet, paramInt);
                }
                break;
              }
              break;
            }
          } while (j <= 1);
          i = 1;
        } while (i >= j);
        label804:
        label887:
        paramc = parammv.CKs.CIj.get(i);
        d.g.b.k.g(paramc, "bizMsg.AppMsg.DetailInfo[i]");
        paramViewGroup = (lr)paramc;
        paramHashSet = parammv.CKs.CIi;
        d.g.b.k.g(paramHashSet, "bizMsg.AppMsg.BaseInfo");
        if (i == j - 1) {}
        for (paramc = c.d.uHb;; paramc = c.d.uHa)
        {
          a(paramView, paramViewGroup, paramHashSet, paramc, paramInt);
          i += 1;
          break label922;
          label1006:
          paramc = c.d.uHc;
          break;
          label1013:
          i = 0;
          break label654;
          label1019:
          i = 0;
          break label704;
          i = 0;
          break label762;
          paramc = (TextView)((c.f)localObject1).uHy.getValue();
          d.g.b.k.g(paramc, "view.videoDurationTv");
          paramc.setText((CharSequence)com.tencent.mm.ai.m.mV(paramViewGroup.CHZ));
          break label804;
          paramc = (TextView)((c.f)localObject1).uHz.getValue();
          d.g.b.k.g(paramc, "view.voiceDurationTv");
          paramc.setText((CharSequence)com.tencent.mm.ai.m.mV(paramViewGroup.CHU));
          break label804;
          if (paramViewGroup.tjj <= 1) {
            break label804;
          }
          paramc = (TextView)((c.f)localObject1).uGU.getValue();
          d.g.b.k.g(paramc, "view.picCntTv");
          paramc.setText((CharSequence)String.valueOf(paramViewGroup.tjj));
          break label804;
          paramc = (CharSequence)paramViewGroup.CHJ;
          boolean bool;
          if ((paramc == null) || (d.n.n.aC(paramc)))
          {
            i = 1;
            if (i != 0) {
              break label1220;
            }
            bool = true;
            label1183:
            if (bool) {
              break label1226;
            }
            ((c.f)localObject1).ddz().setPadding(0, 0, 0, ((c.e)localObject1).uHg);
          }
          for (;;)
          {
            ((c.f)localObject1).uHF = bool;
            break;
            i = 0;
            break label1175;
            label1220:
            bool = false;
            break label1183;
            label1226:
            ((c.f)localObject1).ddz().setPadding(((c.e)localObject1).uHj, ((c.e)localObject1).uHi, ((c.e)localObject1).uHj, ((c.e)localObject1).uHg);
          }
          i = ((xq)localObject2).uKX;
          paramc = this.uGE;
          localObject2 = paramViewGroup.Title;
          d.g.b.k.g(localObject2, "detail.Title");
          ((c.f)localObject1).a(i, paramc, (String)localObject2);
          paramc = (CharSequence)paramViewGroup.CIa;
          if ((paramc == null) || (d.n.n.aC(paramc))) {}
          for (i = 1; i == 0; i = 0)
          {
            paramc = ((c.f)localObject1).ddq();
            d.g.b.k.g(paramc, "view.showDescTv");
            paramc.setText((CharSequence)paramViewGroup.CIa);
            break;
          }
          paramc = new String[2];
          paramc[0] = paramViewGroup.CHP;
          paramc[1] = paramViewGroup.CHN;
          break label887;
          label1375:
          paramViewGroup = parammv.CKs.CIj.get(0);
          d.g.b.k.g(paramViewGroup, "bizMsg.AppMsg.DetailInfo[0]");
          paramViewGroup = (lr)paramViewGroup;
          paramHashSet = parammv.CKs.CIi;
          d.g.b.k.g(paramHashSet, "bizMsg.AppMsg.BaseInfo");
          a(paramView, paramViewGroup, paramHashSet, paramc, paramInt);
          break label913;
        }
      }
    }
    
    private static String I(String[] paramArrayOfString)
    {
      AppMethodBeat.i(39640);
      int i = 0;
      Object localObject;
      int j;
      if (i < 2)
      {
        localObject = paramArrayOfString[i];
        CharSequence localCharSequence = (CharSequence)localObject;
        if ((localCharSequence == null) || (d.n.n.aC(localCharSequence)))
        {
          j = 1;
          label38:
          if (j != 0) {
            break label73;
          }
          j = 1;
          label44:
          if (j == 0) {
            break label78;
          }
        }
      }
      for (paramArrayOfString = (String[])localObject;; paramArrayOfString = null)
      {
        localObject = paramArrayOfString;
        if (paramArrayOfString == null) {
          localObject = "";
        }
        AppMethodBeat.o(39640);
        return localObject;
        j = 0;
        break label38;
        label73:
        j = 0;
        break label44;
        label78:
        i += 1;
        break;
      }
    }
    
    private static String a(lr paramlr)
    {
      AppMethodBeat.i(39643);
      paramlr = paramlr.CHL;
      d.g.b.k.g(paramlr, "detail.ContentUrl");
      paramlr = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Ps(paramlr);
      AppMethodBeat.o(39643);
      return paramlr;
    }
    
    private final void a(final View paramView, final lr paramlr, final lq paramlq, final int paramInt)
    {
      AppMethodBeat.i(39644);
      ImageView localImageView;
      b localb;
      c localc;
      final String str;
      if (paramlr.gKq == 7)
      {
        localImageView = (ImageView)paramView.findViewById(2131297327);
        if (localImageView != null)
        {
          localb = new b(localImageView);
          localc = new c(localImageView);
          str = a(paramlr);
          if (!fh(str)) {
            break label121;
          }
          localb.invoke();
        }
      }
      for (;;)
      {
        localImageView.setOnClickListener((View.OnClickListener)new a(localb, str, this, paramlr));
        paramView.setOnClickListener((View.OnClickListener)new d(this, paramlr, paramlq, paramView, paramInt));
        AppMethodBeat.o(39644);
        return;
        label121:
        localc.invoke();
      }
    }
    
    private final void a(ViewGroup paramViewGroup, lr paramlr, lq paramlq, c.d paramd, int paramInt)
    {
      AppMethodBeat.i(39641);
      c.c localc = c.uGJ;
      ad.v(c.access$getTAG$cp(), "fillCommonSlot:" + paramlr.CHL);
      paramd = new c.b(paramlr.gKq, paramd, paramViewGroup);
      paramd.uGX = paramlr.CIh;
      paramd.url = paramlr.CHL;
      paramViewGroup = paramlr.Title;
      d.g.b.k.g(paramViewGroup, "detail.Title");
      paramd.setTitle(paramViewGroup);
      paramViewGroup = (CharSequence)paramlr.CIa;
      int i;
      if ((paramViewGroup == null) || (d.n.n.aC(paramViewGroup)))
      {
        i = 1;
        if (i == 0)
        {
          paramViewGroup = paramd.ddq();
          d.g.b.k.g(paramViewGroup, "view.showDescTv");
          paramViewGroup.setText((CharSequence)paramlr.CIa);
        }
        paramViewGroup = paramd.ddq();
        if (paramViewGroup != null)
        {
          if ((paramd.uGX != 1) || (this.uGD)) {
            break label305;
          }
          i = 4;
          label169:
          paramViewGroup.setVisibility(i);
        }
        if ((paramlr.gKq == 8) && (paramlr.tjj > 1))
        {
          paramViewGroup = (TextView)paramd.uGU.getValue();
          d.g.b.k.g(paramViewGroup, "view.picCntTv");
          paramViewGroup.setText((CharSequence)String.valueOf(paramlr.tjj));
        }
        switch (paramlr.gKq)
        {
        default: 
          paramViewGroup = new String[2];
          paramViewGroup[0] = paramlr.CHO;
          paramViewGroup[1] = paramlr.CHN;
        }
      }
      for (;;)
      {
        paramd.setImageUrl(I(paramViewGroup));
        a((View)paramd.ddr(), paramlr, paramlq, paramInt);
        AppMethodBeat.o(39641);
        return;
        i = 0;
        break;
        label305:
        i = 0;
        break label169;
        paramViewGroup = new String[2];
        paramViewGroup[0] = paramlr.CHN;
        paramViewGroup[1] = paramlr.CHO;
      }
    }
    
    private static boolean fh(String paramString)
    {
      AppMethodBeat.i(39642);
      com.tencent.mm.az.f localf = com.tencent.mm.az.a.azI();
      if (localf != null)
      {
        if ((d.g.b.k.g(localf.hnp, paramString)) && (localf.hnn == 0) && (com.tencent.mm.az.a.azF()))
        {
          AppMethodBeat.o(39642);
          return true;
        }
        AppMethodBeat.o(39642);
        return false;
      }
      AppMethodBeat.o(39642);
      return false;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$1$3"})
    static final class a
      implements View.OnClickListener
    {
      a(c.a.b paramb, String paramString, c.a parama, lr paramlr) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(39634);
        this.uGK.invoke();
        e.g localg = new e.g();
        e.h localh = new e.h();
        localh.Btj = str;
        localh.url = paramlr.CHL;
        localh.title = paramlr.Title;
        localh.gKR = "";
        localh.playUrl = paramlr.CHV;
        localh.coverUrl = paramlr.CHN;
        localg.GKn = localh;
        paramView.setTag(localg);
        com.tencent.mm.ui.chatting.r.fH(paramView);
        AppMethodBeat.o(39634);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"drawPlaying", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(ImageView paramImageView)
      {
        super();
      }
      
      public final void invoke()
      {
        AppMethodBeat.i(39636);
        this.rEK.setImageResource(2131231272);
        Object localObject = this.rEK.getDrawable();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(39636);
          throw ((Throwable)localObject);
        }
        localObject = (AnimationDrawable)localObject;
        if (localObject != null)
        {
          ((AnimationDrawable)localObject).start();
          AppMethodBeat.o(39636);
          return;
        }
        AppMethodBeat.o(39636);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"drawPlay", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(ImageView paramImageView)
      {
        super();
      }
      
      public final void invoke()
      {
        AppMethodBeat.i(39638);
        this.rEK.setImageResource(2131231271);
        AppMethodBeat.o(39638);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(c.a parama, lr paramlr, lq paramlq, View paramView, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(39639);
        paramView = c.uGJ;
        ad.i(c.access$getTAG$cp(), "onClick jump to url:%s", new Object[] { paramlr.CHL });
        int i = this.uGM.intent.getIntExtra("KOpenArticleSceneFromScene", -1);
        paramView = new Intent();
        String str = com.tencent.mm.ai.m.d(paramlr.CHL, 126, i, 0);
        paramView.putExtra("rawUrl", str);
        paramView.putExtra("useJs", true);
        paramView.putExtra("vertical_scroll", true);
        paramView.putExtra("geta8key_scene", 3);
        Object localObject1 = this.uGM.uGG.ddc();
        d.g.b.k.g(localObject1, "widget.contact");
        paramView.putExtra("geta8key_username", ((af)localObject1).getUsername());
        localObject1 = paramView.getStringExtra("prePublishId");
        int j;
        int k;
        if (!bt.isNullOrNil((String)localObject1))
        {
          paramView.putExtra("KPublisherId", (String)localObject1);
          paramView.putExtra("prePublishId", (String)localObject1);
          paramView.putExtra("preUsername", paramView.getStringExtra("preUsername"));
          paramView.putExtra("preChatName", paramView.getStringExtra("preChatName"));
          paramView.putExtra("preChatTYPE", paramView.getIntExtra("preChatTYPE", 0));
          i = paramView.getIntExtra("KOpenArticleSceneFromScene", 10000);
          if (paramlr.gKq == 5)
          {
            localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
            d.g.b.k.g(localObject1, "MMKernel.service(IBrandService::class.java)");
            if (((com.tencent.mm.plugin.brandservice.a.b)localObject1).bBR())
            {
              paramView.putExtra(e.b.FHP, 126);
              paramView.putExtra(e.b.FHQ, i);
              paramView.putExtra("biz_video_session_id", com.tencent.mm.storage.u.getSessionId());
              localObject1 = new x();
              ((x)localObject1).gKw = paramView.getStringExtra("KPublisherId");
              Object localObject2 = this.uGM.uGG.ddc();
              d.g.b.k.g(localObject2, "widget.contact");
              ((x)localObject1).dfT = ((af)localObject2).getUsername();
              localObject2 = this.uGM.uGG.ddc();
              d.g.b.k.g(localObject2, "widget.contact");
              ((x)localObject1).gKv = ((af)localObject2).ZW();
              ((x)localObject1).gKx.url = str;
              ((x)localObject1).gKx.title = paramlr.Title;
              ((x)localObject1).gKx.gKF = "detail.videoDigest";
              ((x)localObject1).gKx.gKD = paramlr.CHN;
              ((x)localObject1).gKx.type = paramlr.gKq;
              ((x)localObject1).gKx.time = paramlq.CreateTime;
              ((x)localObject1).gKx.gKH = paramlr.CHZ;
              ((x)localObject1).gKx.videoWidth = paramlr.CHX;
              ((x)localObject1).gKx.videoHeight = paramlr.CHY;
              ((x)localObject1).gKx.gGC = paramlr.CHW;
              ((x)localObject1).t(paramView);
              localObject1 = c.uGJ;
              ad.i(c.access$getTAG$cp(), "jump to native video");
              localObject1 = new int[2];
              localObject2 = (ImageView)paramView.findViewById(2131297312);
              if (localObject2 != null)
              {
                j = ((ImageView)localObject2).getWidth();
                k = ((ImageView)localObject2).getHeight();
                ((ImageView)localObject2).getLocationInWindow((int[])localObject1);
                paramView.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", localObject1[0]).putExtra("img_gallery_top", localObject1[1]);
              }
              paramView.addFlags(268435456);
            }
          }
          if ((!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xA(6)) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.uGM.context, str, paramlr.gKq, 126, i, paramView))) {
            break label832;
          }
          paramView = c.uGJ;
          ad.i(c.access$getTAG$cp(), "jump to TmplWebview");
        }
        for (;;)
        {
          paramView = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.uHY;
          paramView = this.uGM.uGG.ddc();
          d.g.b.k.g(paramView, "widget.contact");
          paramView = paramView.getUsername();
          d.g.b.k.g(paramView, "widget.contact.username");
          long l = this.uGM.uGG.QU();
          i = paramlq.CHH;
          j = paramlr.CHK;
          k = paramlr.gKq;
          int m = paramInt;
          int n = paramlq.CreateTime;
          int i1 = this.uGM.uGG.ddf();
          d.g.b.k.h(paramView, "userName");
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a(com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.uHX, paramView, l, i, j, k, m, n, i1);
          AppMethodBeat.o(39639);
          return;
          paramView.putExtra("prePublishId", "brand_profile");
          paramView.putExtra("KPublisherId", "brand_profile");
          break;
          label832:
          com.tencent.mm.bs.d.b(this.uGM.context, "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$CommonSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "picCntTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "Lkotlin/Lazy;", "picInfo", "Landroid/support/constraint/ConstraintLayout;", "getPicInfo", "()Landroid/support/constraint/ConstraintLayout;", "picInfo$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "titleTv$delegate", "url", "getUrl", "setUrl", "weakPicInfo", "Ljava/lang/ref/WeakReference;", "getWeakPicInfo", "()Ljava/lang/ref/WeakReference;", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "app_release"})
  static final class b
    extends c.e
  {
    private String title;
    private final int uGR;
    private final d.f uGS;
    private final WeakReference<ConstraintLayout> uGT;
    final d.f uGU;
    private final d.f uGV;
    private final d.f uGW;
    int uGX;
    String url;
    
    static
    {
      AppMethodBeat.i(39651);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(b.class), "picInfo", "getPicInfo()Landroid/support/constraint/ConstraintLayout;")), (d.l.k)w.a(new d.g.b.u(w.bk(b.class), "picCntTv", "getPicCntTv()Landroid/widget/TextView;")), (d.l.k)w.a(new d.g.b.u(w.bk(b.class), "showDescTv", "getShowDescTv()Landroid/widget/TextView;")), (d.l.k)w.a(new d.g.b.u(w.bk(b.class), "titleTv", "getTitleTv()Lcom/tencent/mm/ui/widget/MMNeat7extView;")) };
      AppMethodBeat.o(39651);
    }
    
    public b(int paramInt, c.d paramd, ViewGroup paramViewGroup)
    {
      super(paramd, paramViewGroup);
      AppMethodBeat.i(39658);
      this.uGR = 2131233660;
      this.uGS = d.g.E((d.g.a.a)new b(this));
      this.uGT = new WeakReference((ConstraintLayout)this.uGS.getValue());
      this.uGU = d.g.E((d.g.a.a)new a(this));
      this.uGV = d.g.E((d.g.a.a)new c(this));
      this.uGW = d.g.E((d.g.a.a)new d(this));
      this.url = "";
      this.title = "";
      AppMethodBeat.o(39658);
    }
    
    protected final void a(View paramView, c.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(39653);
      d.g.b.k.h(paramView, "container");
      d.g.b.k.h(paramd, "slotType");
      Object localObject1;
      switch (d.ciE[paramd.ordinal()])
      {
      default: 
        localObject1 = paramView.findViewById(2131297330);
        d.g.b.k.g(localObject1, "container.findViewById<F…id.biz_slot_voice_layout)");
        ((FrameLayout)localObject1).setVisibility(8);
        switch (this.gGx)
        {
        case 6: 
        case 9: 
        default: 
          localObject1 = paramView.findViewById(2131297312);
          d.g.b.k.g(localObject1, "container.findViewById<I…iew>(R.id.biz_slot_image)");
          ((ImageView)localObject1).setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        super.a(paramView, paramd, paramBoolean);
        AppMethodBeat.o(39653);
        return;
        localObject1 = paramView.findViewById(2131297307);
        d.g.b.k.g(localObject1, "container.findViewById<V…d.biz_slot_common_line_v)");
        ((View)localObject1).setVisibility(0);
        break;
        localObject1 = paramView.findViewById(2131297312);
        d.g.b.k.g(localObject1, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = paramView.findViewById(2131297326);
        d.g.b.k.g(localObject1, "container.findViewById<I….biz_slot_video_play_img)");
        ((ImageView)localObject1).setVisibility(0);
        continue;
        localObject1 = paramView.findViewById(2131297312);
        d.g.b.k.g(localObject1, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = paramView.findViewById(2131297303);
        d.g.b.k.g(localObject1, "container.findViewById<C…slot_common_content_desc)");
        ((ConstraintLayout)localObject1).setVisibility(0);
        continue;
        localObject1 = paramView.findViewById(2131297330);
        d.g.b.k.g(localObject1, "container.findViewById<F…id.biz_slot_voice_layout)");
        ((FrameLayout)localObject1).setVisibility(0);
        continue;
        localObject1 = (MMNeat7extView)paramView.findViewById(2131297321);
        d.g.b.k.g(localObject1, "tv");
        Object localObject2 = ((MMNeat7extView)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          paramView = new v("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
          AppMethodBeat.o(39653);
          throw paramView;
        }
        localObject2 = (ConstraintLayout.LayoutParams)localObject2;
        ((ConstraintLayout.LayoutParams)localObject2).setMarginEnd(0);
        ((MMNeat7extView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = paramView.findViewById(2131297312);
        d.g.b.k.g(localObject1, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject1).setVisibility(8);
      }
    }
    
    protected final ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39652);
      d.g.b.k.h(paramContext, "context");
      d.g.b.k.h(paramViewGroup, "container");
      paramContext = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493609, paramViewGroup, false);
      if (paramContext == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(39652);
        throw paramContext;
      }
      paramContext = (ViewGroup)paramContext;
      paramViewGroup.addView((View)paramContext);
      AppMethodBeat.o(39652);
      return paramContext;
    }
    
    protected final void ddn()
    {
      AppMethodBeat.i(39654);
      if (this.uGT == null)
      {
        AppMethodBeat.o(39654);
        return;
      }
      ConstraintLayout localConstraintLayout = (ConstraintLayout)this.uGT.get();
      if (localConstraintLayout != null)
      {
        localConstraintLayout.setBackgroundResource(2131231208);
        AppMethodBeat.o(39654);
        return;
      }
      AppMethodBeat.o(39654);
    }
    
    protected final float[] ddo()
    {
      AppMethodBeat.i(39655);
      float[] arrayOfFloat = d.a.e.b(new Float[] { Float.valueOf(bg(1.0F)), Float.valueOf(bg(1.0F)), Float.valueOf(bg(1.0F)), Float.valueOf(bg(1.0F)) });
      AppMethodBeat.o(39655);
      return arrayOfFloat;
    }
    
    protected final int ddp()
    {
      return this.uGR;
    }
    
    public final TextView ddq()
    {
      AppMethodBeat.i(39656);
      TextView localTextView = (TextView)this.uGV.getValue();
      AppMethodBeat.o(39656);
      return localTextView;
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(39657);
      d.g.b.k.h(paramString, "value");
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.uGW.getValue();
      d.g.b.k.g(localMMNeat7extView, "titleTv");
      a(localMMNeat7extView, paramString, this.uGX, this.url, 5);
      AppMethodBeat.o(39657);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<TextView>
    {
      a(c.b paramb)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/support/constraint/ConstraintLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<ConstraintLayout>
    {
      b(c.b paramb)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<TextView>
    {
      c(c.b paramb)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<MMNeat7extView>
    {
      d(c.b paramb)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "app_release"})
  public static final class c {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "", "(Ljava/lang/String;I)V", "TOP", "COMMON", "BOTTOM", "SINGLE", "app_release"})
  static enum d
  {
    static
    {
      AppMethodBeat.i(39659);
      d locald1 = new d("TOP", 0);
      uGZ = locald1;
      d locald2 = new d("COMMON", 1);
      uHa = locald2;
      d locald3 = new d("BOTTOM", 2);
      uHb = locald3;
      d locald4 = new d("SINGLE", 3);
      uHc = locald4;
      uHd = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(39659);
    }
    
    private d() {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "audioPadding", "getAudioPadding", "()I", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "imageDefaultRes", "getImageDefaultRes", "imageIv", "Landroid/widget/ImageView;", "getImageIv", "()Landroid/widget/ImageView;", "imageIv$delegate", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "value", "", "imageUrl", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "item", "getItem", "()Landroid/view/ViewGroup;", "item$delegate", "getItemShowType", "largePading", "getLargePading", "listPadding", "getListPadding", "normalPading", "getNormalPading", "getSlotType", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "smallPadding", "getSmallPadding", "dpToPixel", "", "getDpToPixel", "(F)F", "resFromRaw", "getResFromRaw", "(I)F", "resToPixel", "getResToPixel", "(I)I", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "onImageLoadFinish", "onImageLoadStart", "setNeatText", "neatText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "isPayMsg", "url", "scene", "app_release"})
  static class e
  {
    private String gFC;
    final int gGx;
    private final d.f qvt;
    private final int uGR;
    private final d.f uHe;
    private final d.f uHf;
    final int uHg;
    private final int uHh;
    final int uHi;
    final int uHj;
    private final int uHk;
    private final float[] uHl;
    final c.d uHm;
    
    static
    {
      AppMethodBeat.i(39669);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(e.class), "item", "getItem()Landroid/view/ViewGroup;")), (d.l.k)w.a(new d.g.b.u(w.bk(e.class), "imageIv", "getImageIv()Landroid/widget/ImageView;")), (d.l.k)w.a(new d.g.b.u(w.bk(e.class), "context", "getContext()Landroid/content/Context;")) };
      AppMethodBeat.o(39669);
    }
    
    public e(int paramInt, c.d paramd, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39679);
      this.gGx = paramInt;
      this.uHm = paramd;
      this.uHe = d.g.E((d.g.a.a)new e(this, paramViewGroup));
      this.uHf = d.g.E((d.g.a.a)new b(this));
      this.qvt = d.g.E((d.g.a.a)new a(this));
      this.uHg = ((int)bg(36.0F));
      this.uHh = aj.getResources().getDimensionPixelSize(2131165489);
      this.uHi = aj.getResources().getDimensionPixelSize(2131165516);
      this.uHj = aj.getResources().getDimensionPixelSize(2131165480);
      this.uHk = aj.getResources().getDimensionPixelSize(2131165568);
      this.uHl = d.a.e.b(new Float[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) });
      this.uGR = 2131100141;
      this.gFC = "";
      AppMethodBeat.o(39679);
    }
    
    protected static float bg(float paramFloat)
    {
      AppMethodBeat.i(39678);
      Resources localResources = aj.getResources();
      d.g.b.k.g(localResources, "MMApplicationContext.getResources()");
      float f = localResources.getDisplayMetrics().density;
      AppMethodBeat.o(39678);
      return f * paramFloat + 0.5F;
    }
    
    private final ImageView dds()
    {
      AppMethodBeat.i(39671);
      ImageView localImageView = (ImageView)this.uHf.getValue();
      AppMethodBeat.o(39671);
      return localImageView;
    }
    
    protected void a(View paramView, c.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(39674);
      d.g.b.k.h(paramView, "container");
      d.g.b.k.h(paramd, "slotType");
      int i;
      switch (e.ciE[paramd.ordinal()])
      {
      default: 
        AppMethodBeat.o(39674);
        return;
      case 1: 
        paramView.setPadding(this.uHj, this.uHk, this.uHj, 0);
        if (paramBoolean) {}
        for (i = 2131231235;; i = 2131231233)
        {
          paramView.setBackgroundResource(i);
          AppMethodBeat.o(39674);
          return;
        }
      case 2: 
        paramView.setPadding(this.uHj, this.uHk, this.uHj, 0);
        i = 2131231229;
      }
      for (;;)
      {
        paramView.setBackgroundResource(i);
        break;
        paramView.setPadding(this.uHj, this.uHk, this.uHj, this.uHj);
        i = 2131231228;
        continue;
        paramView.setPadding(this.uHj, this.uHk, this.uHj, this.uHk);
        if (paramBoolean) {
          i = 2131231232;
        } else {
          i = 2131231230;
        }
      }
    }
    
    protected final void a(MMNeat7extView paramMMNeat7extView, String paramString1, int paramInt1, String paramString2, int paramInt2)
    {
      boolean bool = true;
      AppMethodBeat.i(39676);
      d.g.b.k.h(paramMMNeat7extView, "neatText");
      d.g.b.k.h(paramString1, "text");
      paramString1 = com.tencent.mm.pluginsdk.ui.span.k.c(paramMMNeat7extView.getContext(), (CharSequence)paramString1);
      if ((this.gGx == 0) && (paramInt1 == 1)) {}
      for (;;)
      {
        com.tencent.mm.plugin.brandservice.b.b localb = com.tencent.mm.plugin.brandservice.b.b.mSC;
        d.g.b.k.g(paramString1, "text");
        com.tencent.mm.plugin.brandservice.b.b.a((CharSequence)paramString1, paramMMNeat7extView, bool, paramString2, paramInt2);
        paramMMNeat7extView.setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.g((NeatTextView)paramMMNeat7extView, new com.tencent.mm.pluginsdk.ui.span.n(paramMMNeat7extView.getContext())));
        AppMethodBeat.o(39676);
        return;
        bool = false;
      }
    }
    
    protected ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39672);
      d.g.b.k.h(paramContext, "context");
      d.g.b.k.h(paramViewGroup, "container");
      paramContext = (Throwable)new d.n();
      AppMethodBeat.o(39672);
      throw paramContext;
    }
    
    protected void ddn() {}
    
    protected float[] ddo()
    {
      return this.uHl;
    }
    
    protected int ddp()
    {
      return this.uGR;
    }
    
    public final ViewGroup ddr()
    {
      AppMethodBeat.i(39670);
      ViewGroup localViewGroup = (ViewGroup)this.uHe.getValue();
      AppMethodBeat.o(39670);
      return localViewGroup;
    }
    
    protected void ddt() {}
    
    protected final Context getContext()
    {
      AppMethodBeat.i(39673);
      Context localContext = (Context)this.qvt.getValue();
      AppMethodBeat.o(39673);
      return localContext;
    }
    
    public final void setImageUrl(final String paramString)
    {
      AppMethodBeat.i(39677);
      d.g.b.k.h(paramString, "value");
      if (d.n.n.aC((CharSequence)paramString)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(39677);
        return;
      }
      paramString = com.tencent.mm.api.b.q(paramString, 2);
      d.g.b.k.g(paramString, "BizImageStrategy.getUrl(…rategy.SCENE_BIZ_PROFILE)");
      this.gFC = paramString;
      paramString = c.uGJ;
      ad.v(c.access$getTAG$cp(), "imageUrl:" + this.gFC);
      paramString = ddo();
      final String str = this.gFC;
      Object localObject1 = new com.tencent.mm.aw.a.a.c.a().ayY();
      Object localObject2 = new StringBuilder("radius_");
      Object localObject3 = Arrays.toString(paramString);
      d.g.b.k.g(localObject3, "java.util.Arrays.toString(this)");
      localObject1 = ((com.tencent.mm.aw.a.a.c.a)localObject1).yx((String)localObject3).or(ddp()).a((com.tencent.mm.aw.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.aw.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).yv(com.tencent.mm.pluginsdk.model.r.aAK(this.gFC)).azc();
      localObject2 = new d(this);
      localObject3 = new com.tencent.mm.pluginsdk.ui.applet.m(3, -1, -1, paramString, (m.a)localObject2);
      ((com.tencent.mm.pluginsdk.ui.applet.m)localObject3).aw((Runnable)new c(this, str, (com.tencent.mm.aw.a.a.c)localObject1, paramString, (d)localObject2));
      o.ayJ().a(str, dds(), (com.tencent.mm.aw.a.a.c)localObject1, (com.tencent.mm.aw.a.c.h)localObject3);
      AppMethodBeat.o(39677);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<Context>
    {
      a(c.e parame)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<ImageView>
    {
      b(c.e parame)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel$imageUrl$imageLoaderListener$1$1"})
    static final class c
      implements Runnable
    {
      c(c.e parame, String paramString, com.tencent.mm.aw.a.a.c paramc, float[] paramArrayOfFloat, c.e.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(39665);
        com.tencent.mm.aw.a.a locala = o.ayJ();
        String str = str;
        ImageView localImageView1 = c.e.b(this.uHn);
        com.tencent.mm.aw.a.a.c localc = this.uHo;
        ImageView localImageView2 = c.e.b(this.uHn);
        d.g.b.k.g(localImageView2, "imageIv");
        int i = localImageView2.getMeasuredWidth();
        localImageView2 = c.e.b(this.uHn);
        d.g.b.k.g(localImageView2, "imageIv");
        locala.a(str, localImageView1, localc, (com.tencent.mm.aw.a.c.h)new com.tencent.mm.pluginsdk.ui.applet.m(3, i, localImageView2.getMeasuredHeight(), paramString, (m.a)this.uHq));
        AppMethodBeat.o(39665);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel$imageUrl$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
    public static final class d
      implements m.a
    {
      public final void onFinish()
      {
        AppMethodBeat.i(39666);
        c.c localc = c.uGJ;
        ad.v(c.access$getTAG$cp(), "imageUrl onFinish:" + c.e.a(this.uHn));
        this.uHn.ddn();
        AppMethodBeat.o(39666);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(39667);
        c.c localc = c.uGJ;
        ad.v(c.access$getTAG$cp(), "imageUrl onStart:" + c.e.a(this.uHn));
        this.uHn.ddt();
        AppMethodBeat.o(39667);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
    static final class e
      extends d.g.b.l
      implements d.g.a.a<ViewGroup>
    {
      e(c.e parame, ViewGroup paramViewGroup)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$TopSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "collapseTextLayout", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "getCollapseTextLayout", "()Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "collapseTextLayout$delegate", "Lkotlin/Lazy;", "descMask", "Landroid/view/View;", "getDescMask", "()Landroid/view/View;", "descMask$delegate", "digestTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getDigestTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "digestTv$delegate", "value", "", "hasAudioDesc", "getHasAudioDesc", "()Z", "setHasAudioDesc", "(Z)V", "hasDesc", "setHasDesc", "hasSingleInfo", "hasTitle", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "isSingleImage", "picCntTv", "Landroid/widget/TextView;", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "singleDescLayout", "getSingleDescLayout", "singleDescLayout$delegate", "singleTitleTv", "getSingleTitleTv", "singleTitleTv$delegate", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleDescViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "titleTv", "getTitleTv", "titleTv$delegate", "topMask", "Landroid/widget/ImageView;", "getTopMask", "()Landroid/widget/ImageView;", "topMask$delegate", "url", "getUrl", "setUrl", "videPlayImg", "getVidePlayImg", "videPlayImg$delegate", "videoDurationTv", "getVideoDurationTv", "videoDurationTv$delegate", "voiceDurationTv", "getVoiceDurationTv", "voiceDurationTv$delegate", "fillBackground", "", "selector", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "onImageLoadStart", "setText", "id", "expandSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "text", "setTitleDescTextColor", "color", "app_release"})
  static final class f
    extends c.e
  {
    private String title;
    final d.f uGU;
    private final d.f uGV;
    private final d.f uGW;
    int uGX;
    private final d.f uHA;
    private final d.f uHB;
    private final d.f uHC;
    final d.f uHD;
    private final d.f uHE;
    boolean uHF;
    private boolean uHs;
    private boolean uHt;
    private boolean uHu;
    private ArrayList<View> uHv;
    private final d.f uHw;
    private final d.f uHx;
    final d.f uHy;
    final d.f uHz;
    String url;
    
    static
    {
      AppMethodBeat.i(39696);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "topMask", "getTopMask()Landroid/widget/ImageView;")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "descMask", "getDescMask()Landroid/view/View;")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "showDescTv", "getShowDescTv()Landroid/widget/TextView;")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "videoDurationTv", "getVideoDurationTv()Landroid/widget/TextView;")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "voiceDurationTv", "getVoiceDurationTv()Landroid/widget/TextView;")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "picCntTv", "getPicCntTv()Landroid/widget/TextView;")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "titleTv", "getTitleTv()Lcom/tencent/mm/ui/widget/MMNeat7extView;")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "videPlayImg", "getVidePlayImg()Landroid/widget/ImageView;")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "singleDescLayout", "getSingleDescLayout()Landroid/view/View;")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "singleTitleTv", "getSingleTitleTv()Lcom/tencent/mm/ui/widget/MMNeat7extView;")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "digestTv", "getDigestTv()Lcom/tencent/mm/ui/widget/MMNeat7extView;")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "collapseTextLayout", "getCollapseTextLayout()Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;")) };
      AppMethodBeat.o(39696);
    }
    
    public f(final int paramInt, c.d paramd, ViewGroup paramViewGroup)
    {
      super(paramd, paramViewGroup);
      AppMethodBeat.i(39713);
      this.url = "";
      this.uHv = new ArrayList();
      this.uHw = d.g.E((d.g.a.a)new l(this));
      this.uHx = d.g.E((d.g.a.a)new b(this));
      this.uGV = d.g.E((d.g.a.a)new h(this));
      this.uHy = d.g.E((d.g.a.a)new n(this));
      this.uHz = d.g.E((d.g.a.a)new o(this));
      this.uGU = d.g.E((d.g.a.a)new e(this));
      this.uGW = d.g.E((d.g.a.a)new k(this, paramInt));
      this.uHA = d.g.E((d.g.a.a)new m(this));
      this.uHB = d.g.E((d.g.a.a)new i(this));
      this.uHC = d.g.E((d.g.a.a)new j(this));
      this.uHD = d.g.E((d.g.a.a)new c(this));
      this.uHE = d.g.E((d.g.a.a)new a(this));
      this.title = "";
      AppMethodBeat.o(39713);
    }
    
    private final void JE(int paramInt)
    {
      AppMethodBeat.i(39712);
      Iterator localIterator = ((Iterable)this.uHv).iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if ((localView instanceof TextView)) {
          ((TextView)localView).setTextColor(paramInt);
        } else if ((localView instanceof MMNeat7extView)) {
          ((MMNeat7extView)localView).setTextColor(paramInt);
        }
      }
      AppMethodBeat.o(39712);
    }
    
    private MMCollapsibleTextView ddA()
    {
      AppMethodBeat.i(39707);
      MMCollapsibleTextView localMMCollapsibleTextView = (MMCollapsibleTextView)this.uHE.getValue();
      AppMethodBeat.o(39707);
      return localMMCollapsibleTextView;
    }
    
    private final void ddu()
    {
      AppMethodBeat.i(39701);
      this.uHs = true;
      if (this.gGx == 5)
      {
        Object localObject = ddy();
        d.g.b.k.g(localObject, "videPlayImg");
        localObject = ((ImageView)localObject).getLayoutParams();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
          AppMethodBeat.o(39701);
          throw ((Throwable)localObject);
        }
        localObject = (ConstraintLayout.LayoutParams)localObject;
        if (((ConstraintLayout.LayoutParams)localObject).verticalBias != 0.56F)
        {
          ((ConstraintLayout.LayoutParams)localObject).verticalBias = 0.56F;
          ImageView localImageView = ddy();
          d.g.b.k.g(localImageView, "videPlayImg");
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(39701);
    }
    
    private final boolean ddv()
    {
      return (this.uHm == c.d.uHc) && (!this.uHu);
    }
    
    private final ImageView ddw()
    {
      AppMethodBeat.i(39702);
      ImageView localImageView = (ImageView)this.uHw.getValue();
      AppMethodBeat.o(39702);
      return localImageView;
    }
    
    private final MMNeat7extView ddx()
    {
      AppMethodBeat.i(39704);
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.uGW.getValue();
      AppMethodBeat.o(39704);
      return localMMNeat7extView;
    }
    
    private final ImageView ddy()
    {
      AppMethodBeat.i(39705);
      ImageView localImageView = (ImageView)this.uHA.getValue();
      AppMethodBeat.o(39705);
      return localImageView;
    }
    
    public final void a(final int paramInt, HashSet<Integer> paramHashSet, String paramString)
    {
      AppMethodBeat.i(39709);
      d.g.b.k.h(paramHashSet, "expandSet");
      d.g.b.k.h(paramString, "text");
      MMCollapsibleTextView localMMCollapsibleTextView = ddA();
      d.g.b.k.g(localMMCollapsibleTextView, "collapseTextLayout");
      paramString = com.tencent.mm.pluginsdk.ui.span.k.f(localMMCollapsibleTextView.getContext(), (CharSequence)paramString, (int)ddA().getTextSize());
      localMMCollapsibleTextView = ddA();
      if (!paramHashSet.contains(Integer.valueOf(paramInt))) {}
      for (boolean bool = true;; bool = false)
      {
        localMMCollapsibleTextView.setCollapsed(bool);
        localMMCollapsibleTextView = ddA();
        d.g.b.k.g(paramString, "text");
        localMMCollapsibleTextView.setText((CharSequence)paramString);
        if (!(ddA().getContentText() instanceof MMNeat7extView)) {
          break label190;
        }
        paramString = ddA().getContentText();
        if (paramString != null) {
          break;
        }
        paramHashSet = new v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(39709);
        throw paramHashSet;
      }
      paramString = (MMNeat7extView)paramString;
      ddA().setOnTextTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.g((NeatTextView)paramString, new com.tencent.mm.pluginsdk.ui.span.n(paramString.getContext())));
      label190:
      ddA().setOnCollapse((d.g.a.a)new f(paramHashSet, paramInt));
      ddA().setOnExpand((d.g.a.a)new g(paramHashSet, paramInt));
      AppMethodBeat.o(39709);
    }
    
    protected final void a(View paramView, c.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(39698);
      d.g.b.k.h(paramView, "container");
      d.g.b.k.h(paramd, "slotType");
      switch (this.gGx)
      {
      case 8: 
      case 9: 
      default: 
        paramView.setPadding(0, 0, 0, 0);
        paramView.setBackgroundResource(0);
        AppMethodBeat.o(39698);
        return;
      case 6: 
      case 7: 
        if (paramd == c.d.uGZ)
        {
          View localView = paramView.findViewById(2131297323);
          d.g.b.k.g(localView, "container.findViewById<V…R.id.biz_slot_top_line_v)");
          localView.setVisibility(0);
        }
        super.a(paramView, paramd, false);
        paramView.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(39698);
        return;
      }
      super.a(paramView, paramd, false);
      AppMethodBeat.o(39698);
    }
    
    protected final ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39697);
      d.g.b.k.h(paramContext, "context");
      d.g.b.k.h(paramViewGroup, "container");
      paramContext = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493613, paramViewGroup, false);
      if (paramContext == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(39697);
        throw paramContext;
      }
      paramContext = (ViewGroup)paramContext;
      int i;
      switch (this.gGx)
      {
      case 9: 
      default: 
        i = 2131298601;
      }
      for (;;)
      {
        ((ViewStub)paramContext.findViewById(i)).inflate();
        paramViewGroup.addView((View)paramContext);
        AppMethodBeat.o(39697);
        return paramContext;
        i = 2131298604;
        continue;
        ddu();
        i = 2131298602;
        continue;
        i = 2131298603;
        continue;
        i = 2131298600;
      }
    }
    
    protected final void ddn()
    {
      AppMethodBeat.i(39711);
      Object localObject = getContext();
      d.g.b.k.g(localObject, "context");
      JE(((Context)localObject).getResources().getColor(2131101182));
      if (this.uHs)
      {
        localObject = (View)this.uHx.getValue();
        if (!ddv()) {
          break label113;
        }
        if (this.uHt)
        {
          i = 2131233666;
          ((View)localObject).setBackgroundResource(i);
        }
      }
      else
      {
        localObject = ddw();
        if (this.uHm != c.d.uGZ) {
          break label134;
        }
      }
      label134:
      for (int i = 2131231241;; i = 2131231243)
      {
        ((ImageView)localObject).setBackgroundResource(i);
        AppMethodBeat.o(39711);
        return;
        i = 2131233665;
        break;
        label113:
        if (this.uHt)
        {
          i = 2131233664;
          break;
        }
        i = 2131233663;
        break;
      }
    }
    
    protected final float[] ddo()
    {
      AppMethodBeat.i(39699);
      if (ddv())
      {
        arrayOfFloat = d.a.e.b(new Float[] { Float.valueOf(bg(8.0F)), Float.valueOf(bg(8.0F)), Float.valueOf(bg(8.0F)), Float.valueOf(bg(8.0F)) });
        AppMethodBeat.o(39699);
        return arrayOfFloat;
      }
      float[] arrayOfFloat = d.a.e.b(new Float[] { Float.valueOf(bg(8.0F)), Float.valueOf(bg(8.0F)), Float.valueOf(0.0F), Float.valueOf(0.0F) });
      AppMethodBeat.o(39699);
      return arrayOfFloat;
    }
    
    protected final int ddp()
    {
      AppMethodBeat.i(39700);
      if (ddv())
      {
        AppMethodBeat.o(39700);
        return 2131233661;
      }
      AppMethodBeat.o(39700);
      return 2131233662;
    }
    
    public final TextView ddq()
    {
      AppMethodBeat.i(39703);
      TextView localTextView = (TextView)this.uGV.getValue();
      AppMethodBeat.o(39703);
      return localTextView;
    }
    
    protected final void ddt()
    {
      AppMethodBeat.i(39710);
      com.tencent.mm.ad.c.g((d.g.a.a)new d(this));
      AppMethodBeat.o(39710);
    }
    
    final View ddz()
    {
      AppMethodBeat.i(39706);
      View localView = (View)this.uHB.getValue();
      AppMethodBeat.o(39706);
      return localView;
    }
    
    public final void setTitle(String paramString)
    {
      int i = 4;
      AppMethodBeat.i(39708);
      d.g.b.k.h(paramString, "value");
      MMNeat7extView localMMNeat7extView;
      int j;
      String str;
      switch (this.gGx)
      {
      default: 
        if (this.uHm == c.d.uHc)
        {
          localMMNeat7extView = (MMNeat7extView)this.uHC.getValue();
          d.g.b.k.g(localMMNeat7extView, "if (slotType == SlotType…ingleTitleTv else titleTv");
          j = this.uGX;
          str = this.url;
          if (this.uHm != c.d.uHc) {
            break label187;
          }
        }
        break;
      }
      for (;;)
      {
        a(localMMNeat7extView, paramString, j, str, i);
        AppMethodBeat.o(39708);
        return;
        localMMNeat7extView = ddx();
        d.g.b.k.g(localMMNeat7extView, "titleTv");
        a(localMMNeat7extView, paramString, this.uGX, this.url, 4);
        paramString = ddw();
        if (this.uHm == c.d.uGZ) {}
        for (i = 2131231243;; i = 2131231241)
        {
          paramString.setBackgroundResource(i);
          AppMethodBeat.o(39708);
          return;
        }
        localMMNeat7extView = ddx();
        break;
        label187:
        i = 41;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<MMCollapsibleTextView>
    {
      a(c.f paramf)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<View>
    {
      b(c.f paramf)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<MMNeat7extView>
    {
      c(c.f paramf)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      d(c.f paramf)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e
      extends d.g.b.l
      implements d.g.a.a<TextView>
    {
      e(c.f paramf)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class f
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      f(HashSet paramHashSet, int paramInt)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class g
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      g(HashSet paramHashSet, int paramInt)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h
      extends d.g.b.l
      implements d.g.a.a<TextView>
    {
      h(c.f paramf)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i
      extends d.g.b.l
      implements d.g.a.a<View>
    {
      i(c.f paramf)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j
      extends d.g.b.l
      implements d.g.a.a<MMNeat7extView>
    {
      j(c.f paramf)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k
      extends d.g.b.l
      implements d.g.a.a<MMNeat7extView>
    {
      k(c.f paramf, int paramInt)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l
      extends d.g.b.l
      implements d.g.a.a<ImageView>
    {
      l(c.f paramf)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m
      extends d.g.b.l
      implements d.g.a.a<ImageView>
    {
      m(c.f paramf)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class n
      extends d.g.b.l
      implements d.g.a.a<TextView>
    {
      n(c.f paramf)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class o
      extends d.g.b.l
      implements d.g.a.a<TextView>
    {
      o(c.f paramf)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "context", "Landroid/content/Context;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "position", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Landroid/view/View;Landroid/view/ViewGroup;ILcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;)V", "coverSize", "radius", "", "view", "getView", "()Landroid/view/View;", "fillVideoChannel", "", "fillVideoItem", "videoItem", "Lcom/tencent/mm/protocal/protobuf/NotifyVideoInfo;", "itemView", "getDurationText", "", "app_release"})
  static final class g
    extends c.h
  {
    final Context context;
    private float radius;
    final ContactWidgetNewBizInfo uGG;
    private int uHJ;
    final View view;
    
    public g(final Context paramContext, ContactWidgetNewBizInfo paramContactWidgetNewBizInfo, View paramView, ViewGroup paramViewGroup, final ccj paramccj)
    {
      AppMethodBeat.i(169914);
      this.radius = 2.0F;
      this.context = paramContext;
      this.uGG = paramContactWidgetNewBizInfo;
      this.uHJ = com.tencent.mm.cd.a.fromDPToPix(paramContext, 64);
      label76:
      int i;
      label114:
      Object localObject1;
      label128:
      label179:
      label193:
      Object localObject2;
      label261:
      int j;
      int k;
      if (paramView != null)
      {
        paramContactWidgetNewBizInfo = paramView.getTag();
        if (!d.g.b.k.g(paramContactWidgetNewBizInfo, paramccj)) {
          break label697;
        }
        this.view = paramView;
        paramContactWidgetNewBizInfo = (TextView)this.view.findViewById(2131306337);
        paramContext = (CharSequence)paramccj.DYO;
        if ((paramContext != null) && (paramContext.length() != 0)) {
          break label735;
        }
        i = 1;
        if (i != 0) {
          break label741;
        }
        paramContext = (CharSequence)paramccj.DYO;
        paramContactWidgetNewBizInfo.setText(paramContext);
        paramContext = com.tencent.mm.plugin.brandservice.ui.b.d.nmK;
        com.tencent.mm.plugin.brandservice.ui.b.d.i(paramContactWidgetNewBizInfo);
        paramContactWidgetNewBizInfo = (TextView)this.view.findViewById(2131306336);
        paramContext = (CharSequence)paramccj.doh;
        if ((paramContext != null) && (paramContext.length() != 0)) {
          break label769;
        }
        i = 1;
        if (i != 0) {
          break label775;
        }
        paramContext = (CharSequence)paramccj.doh;
        paramContactWidgetNewBizInfo.setText(paramContext);
        paramContext = paramccj.DYN;
        paramContactWidgetNewBizInfo = c.uGJ;
        ad.v(c.access$getTAG$cp(), "alvinluo fillVideoChannel size: %d", new Object[] { Integer.valueOf(paramContext.size()) });
        paramContactWidgetNewBizInfo = (LinearLayout)this.view.findViewById(2131306314);
        paramContactWidgetNewBizInfo.removeAllViews();
        if (paramContext == null) {
          break label848;
        }
        paramView = ((Iterable)paramContext).iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          paramViewGroup = (btp)paramView.next();
        } while (paramViewGroup == null);
        paramContext = c.uGJ;
        ad.d(c.access$getTAG$cp(), "alvinluo videoItem url: %s, duration: %d", new Object[] { paramViewGroup.DRa, Integer.valueOf(paramViewGroup.duration) });
        localObject1 = LayoutInflater.from(this.context).inflate(2131493622, null, false);
        paramContactWidgetNewBizInfo.addView((View)localObject1);
        d.g.b.k.g(localObject1, "itemView");
        paramContext = ((View)localObject1).findViewById(2131306332);
        d.g.b.k.g(paramContext, "itemView.findViewById<Te…iew>(R.id.video_duration)");
        localObject2 = (TextView)paramContext;
        i = paramViewGroup.duration / 3600;
        j = (paramViewGroup.duration - i * 3600) / 60;
        k = paramViewGroup.duration % 60;
        paramContext = c.uGJ;
        ad.i(c.access$getTAG$cp(), "alvinluo getDurationText " + i + ':' + j + ':' + k);
        if (i <= 0) {
          break label803;
        }
        paramContext = z.Jhz;
        paramContext = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }, 3));
        d.g.b.k.g(paramContext, "java.lang.String.format(format, *args)");
      }
      for (;;)
      {
        ((TextView)localObject2).setText((CharSequence)paramContext);
        paramContext = (ImageView)((View)localObject1).findViewById(2131306321);
        paramViewGroup = com.tencent.mm.api.b.q(paramViewGroup.DRa, 2);
        localObject1 = new com.tencent.mm.aw.a.a.c.a().ayY().de(this.uHJ, this.uHJ).yx("radius_" + this.radius).or(2131233660).a((com.tencent.mm.aw.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.aw.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).yv(com.tencent.mm.pluginsdk.model.r.aAK(paramViewGroup)).azc();
        localObject2 = new b(paramViewGroup, paramContext);
        localObject2 = new com.tencent.mm.pluginsdk.ui.applet.m(3, this.uHJ, this.uHJ, true, true, this.radius, (m.a)localObject2);
        o.ayJ().a(paramViewGroup, paramContext, (com.tencent.mm.aw.a.a.c)localObject1, (com.tencent.mm.aw.a.c.h)localObject2);
        break label261;
        paramContactWidgetNewBizInfo = null;
        break;
        label697:
        paramContext = LayoutInflater.from(paramContext).inflate(2131493621, paramViewGroup, false);
        d.g.b.k.g(paramContext, "LayoutInflater.from(cont…o_channel, parent, false)");
        this.view = paramContext;
        this.view.setTag(paramccj);
        break label76;
        label735:
        i = 0;
        break label114;
        label741:
        paramContext = paramContactWidgetNewBizInfo.getContext();
        d.g.b.k.g(paramContext, "context");
        paramContext = (CharSequence)paramContext.getResources().getString(2131756647);
        break label128;
        label769:
        i = 0;
        break label179;
        label775:
        paramContext = paramContactWidgetNewBizInfo.getContext();
        d.g.b.k.g(paramContext, "context");
        paramContext = (CharSequence)paramContext.getResources().getString(2131756646);
        break label193;
        label803:
        paramContext = z.Jhz;
        paramContext = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(j), Integer.valueOf(k) }, 2));
        d.g.b.k.g(paramContext, "java.lang.String.format(format, *args)");
      }
      label848:
      paramContext = this.view.findViewById(2131304246);
      if (paramContext != null)
      {
        paramContext.setOnClickListener((View.OnClickListener)new a(this, paramccj));
        AppMethodBeat.o(169914);
        return;
      }
      AppMethodBeat.o(169914);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(c.g paramg, ccj paramccj) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(169911);
        paramView = (CharSequence)paramccj.ntj;
        if ((paramView == null) || (paramView.length() == 0)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            paramView = new Intent();
            paramView.putExtra("rawUrl", paramccj.ntj);
            af localaf = this.uHK.uGG.ddc();
            d.g.b.k.g(localaf, "widget.contact");
            paramView.putExtra("geta8key_username", localaf.getUsername());
            com.tencent.mm.bs.d.b(this.uHK.context, "webview", ".ui.tools.WebViewUI", paramView);
            paramView = this.uHK.uGG.ddc();
            d.g.b.k.g(paramView, "widget.contact");
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.L(paramView.getUsername(), 1402, this.uHK.uGG.ddf());
          }
          AppMethodBeat.o(169911);
          return;
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder$fillVideoItem$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
    public static final class b
      implements m.a
    {
      b(String paramString, ImageView paramImageView) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(169912);
        c.c localc = c.uGJ;
        ad.v(c.access$getTAG$cp(), "imageUrl onFinish:" + this.uHM);
        paramContext.setBackgroundResource(2131233299);
        AppMethodBeat.o(169912);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(169913);
        c.c localc = c.uGJ;
        ad.v(c.access$getTAG$cp(), "imageUrl onStart:" + this.uHM);
        AppMethodBeat.o(169913);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "", "()V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "app_release"})
  static abstract class h {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.c
 * JD-Core Version:    0.7.0.1
 */