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
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.x;
import com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.protocal.protobuf.cdr;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.mo;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.h.a;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import d.a.j;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter$Interpolator;", "ui", "Lcom/tencent/mm/ui/MMActivity;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "orginAdapter", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;", "footer", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;[Ljava/lang/String;)V", "adapter", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;)V", "brandService", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "getBrandService", "()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "brandService$delegate", "Lkotlin/Lazy;", "changedPlayId", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExpandSet", "()Ljava/util/HashSet;", "getFooter", "()[Ljava/lang/String;", "[Ljava/lang/String;", "isBizPayOpen", "", "()Z", "originalCount", "getOriginalCount", "()I", "setOriginalCount", "(I)V", "getUi", "()Lcom/tencent/mm/ui/MMActivity;", "getWidget", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "getCount", "getFooterCount", "getItem", "", "position", "getRelativePosition", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "isInterpolated", "onMusicStateChanged", "", "event", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "preloadPage", "fromPosition", "toPosition", "update", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "notifyInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "BizMsgViewHolder", "CommonSlotViewModel", "Companion", "SlotType", "SlotViewModel", "TopSlotViewModel", "VideoChannelViewHolder", "ViewHolder", "app_release"})
public final class c
  implements h.a
{
  private static final String TAG = "MicroMsg.NewBizInfoAdapter";
  public static final c.c xmC;
  public final com.tencent.mm.ui.base.preference.h xmA;
  private final String[] xmB;
  public a xms;
  public String xmt;
  public int xmu;
  private final d.f xmv;
  final boolean xmw;
  private final HashSet<Integer> xmx;
  final MMActivity xmy;
  public final ContactWidgetNewBizInfo xmz;
  
  static
  {
    AppMethodBeat.i(39720);
    xmC = new c.c((byte)0);
    TAG = "MicroMsg.NewBizInfoAdapter";
    AppMethodBeat.o(39720);
  }
  
  public c(MMActivity paramMMActivity, ContactWidgetNewBizInfo paramContactWidgetNewBizInfo, com.tencent.mm.ui.base.preference.h paramh, String[] paramArrayOfString)
  {
    AppMethodBeat.i(39727);
    this.xmy = paramMMActivity;
    this.xmz = paramContactWidgetNewBizInfo;
    this.xmA = paramh;
    this.xmB = paramArrayOfString;
    com.tencent.mm.plugin.brandservice.b.c.init();
    this.xms = new a();
    this.xmt = "none";
    this.xmv = d.g.O((d.g.a.a)c.i.xnG);
    paramMMActivity = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
    p.g(paramMMActivity, "MMKernel.service(IBrandService::class.java)");
    this.xmw = ((com.tencent.mm.plugin.brandservice.a.b)paramMMActivity).bOf();
    this.xmx = new HashSet();
    AppMethodBeat.o(39727);
  }
  
  public final int NI(int paramInt)
  {
    AppMethodBeat.i(39722);
    this.xmu = paramInt;
    a locala = this.xms;
    int i = locala.fXm.size();
    int j = locala.xlY.size();
    AppMethodBeat.o(39722);
    return j + i + paramInt;
  }
  
  public final boolean NJ(int paramInt)
  {
    AppMethodBeat.i(39723);
    int i = dEM();
    if ((paramInt >= this.xmu - i) && (paramInt < this.xmA.getCount() - i))
    {
      AppMethodBeat.o(39723);
      return true;
    }
    AppMethodBeat.o(39723);
    return false;
  }
  
  public final int NK(int paramInt)
  {
    AppMethodBeat.i(39724);
    int i = this.xmA.getCount();
    if (paramInt >= i - dEM())
    {
      int j = this.xmu;
      AppMethodBeat.o(39724);
      return j + paramInt - i;
    }
    AppMethodBeat.o(39724);
    return paramInt;
  }
  
  public final int dEM()
  {
    AppMethodBeat.i(39721);
    String[] arrayOfString = this.xmB;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      int k = this.xmA.aXg(str);
      if (k != -1)
      {
        i = this.xmu;
        AppMethodBeat.o(39721);
        return i - k;
      }
      i += 1;
    }
    AppMethodBeat.o(39721);
    return 0;
  }
  
  public final com.tencent.mm.plugin.brandservice.a.b dEN()
  {
    AppMethodBeat.i(39725);
    com.tencent.mm.plugin.brandservice.a.b localb = (com.tencent.mm.plugin.brandservice.a.b)this.xmv.getValue();
    AppMethodBeat.o(39725);
    return localb;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39726);
    paramInt = paramInt - this.xmu + dEM();
    Object localObject1 = this.xms.NF(paramInt);
    Object localObject2;
    Object localObject3;
    switch (f.cqt[localObject1.ordinal()])
    {
    default: 
      paramView = LayoutInflater.from((Context)this.xmy.getContext()).inflate(2131493610, paramViewGroup, false);
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      break;
    case 1: 
      paramView = LayoutInflater.from((Context)this.xmy.getContext()).inflate(2131493612, paramViewGroup, false);
      this.xmz.cli();
      AppMethodBeat.o(39726);
      return paramView;
    case 2: 
      localObject1 = this.xms.getItem(paramInt);
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      localObject1 = (oa)localObject1;
      if ((((oa)localObject1).Gbs.urJ == 49) && (dEN().zl(16)))
      {
        localObject2 = dEN();
        localObject3 = ((oa)localObject1).Gbx.FYQ;
        p.g(localObject3, "bizMessage.AppMsg.DetailInfo");
        Object localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          mp localmp = (mp)((Iterator)localObject4).next();
          ((Collection)localObject3).add(j.listOf(new String[] { localmp.FYs, String.valueOf(localmp.hFR) }));
        }
        ((com.tencent.mm.plugin.brandservice.a.b)localObject2).j((List)localObject3, 126);
      }
      paramView = new a(this, paramView, paramViewGroup, (oa)localObject1, this.xmx, paramInt / 2).view;
      AppMethodBeat.o(39726);
      return paramView;
    case 3: 
      localObject1 = this.xmy.getContext();
      p.g(localObject1, "ui.context");
      localObject1 = (Context)localObject1;
      localObject2 = this.xmz;
      localObject3 = this.xms.getItem(paramInt);
      if (localObject3 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ProfileNotifyInfo");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      paramView = new g((Context)localObject1, (ContactWidgetNewBizInfo)localObject2, paramView, paramViewGroup, (cne)localObject3).view;
      AppMethodBeat.o(39726);
      return paramView;
    }
    paramView = (ViewGroup)paramView;
    paramViewGroup = (TextView)paramView.findViewById(2131297310);
    if (paramViewGroup != null)
    {
      localObject2 = this.xms;
      localObject1 = ak.getContext();
      ((a)localObject2).NF(paramInt);
      localObject2 = ((a)localObject2).getItem(paramInt);
      if (localObject2 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      long l = 1000L * ((oa)localObject2).Gbs.GrG;
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTime(new Date(l));
      p.g(localObject2, "Calendar.getInstance().apply { time = Date(date) }");
      DateFormat.format((CharSequence)((Context)localObject1).getString(2131759528), l);
      paramViewGroup.setText((CharSequence)i.c((Context)localObject1, l, false).toString());
    }
    paramView = (View)paramView;
    AppMethodBeat.o(39726);
    return paramView;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "interpolator", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "bizMsg", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "position", "(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;Landroid/view/View;Landroid/view/ViewGroup;Lcom/tencent/mm/protocal/protobuf/BizMessage;Ljava/util/HashSet;I)V", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "isBizPayOpen", "", "()Z", "setBizPayOpen", "(Z)V", "view", "getView", "()Landroid/view/View;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "fillCommonSlot", "", "container", "detail", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "base", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "fillSingleText", "text", "Lcom/tencent/mm/protocal/protobuf/BizTextMsgInfo;", "Lcom/tencent/mm/protocal/protobuf/CommMsgBaseInfo;", "fillSlotTarget", "fillTopSlot", "commBase", "getPlayId", "", "isPlaying", "playId", "firstNotEmpty", "", "([Ljava/lang/String;)Ljava/lang/String;", "app_release"})
  static final class a
    extends c.h
  {
    Context context;
    Intent intent;
    final View view;
    private boolean xmw;
    private HashSet<Integer> xmx;
    ContactWidgetNewBizInfo xmz;
    
    public a(c paramc, View paramView, ViewGroup paramViewGroup, oa paramoa, HashSet<Integer> paramHashSet, int paramInt)
    {
      AppMethodBeat.i(39645);
      this.xmw = true;
      Object localObject1 = paramc.xmy.getContext();
      p.g(localObject1, "interpolator.ui.context");
      this.context = ((Context)localObject1);
      this.xmz = paramc.xmz;
      localObject1 = paramc.xmy.getIntent();
      p.g(localObject1, "interpolator.ui.intent");
      this.intent = ((Intent)localObject1);
      this.xmx = paramHashSet;
      this.xmw = paramc.xmw;
      if (paramView != null) {
        paramHashSet = paramView.getTag();
      }
      Object localObject2;
      int i;
      while (p.i(paramHashSet, paramoa))
      {
        localObject2 = paramoa.Gbx;
        paramHashSet = this;
        localObject1 = paramView;
        if (localObject2 != null)
        {
          localObject2 = ((mq)localObject2).FYQ;
          paramHashSet = this;
          localObject1 = paramView;
          if (localObject2 != null)
          {
            i = 0;
            paramHashSet = ((Iterable)localObject2).iterator();
            for (;;)
            {
              if (paramHashSet.hasNext())
              {
                localObject1 = (mp)paramHashSet.next();
                p.g(localObject1, "detail");
                if (p.i(a((mp)localObject1), c.a(paramc)))
                {
                  c.a(paramc, "none");
                  i = 1;
                  continue;
                  paramHashSet = null;
                  break;
                }
              }
            }
            if (i == 1) {
              break;
            }
            localObject1 = paramView;
            paramHashSet = this;
          }
        }
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
      switch (paramoa.Gbs.urJ)
      {
      }
      int j;
      label654:
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
            paramc = paramoa.Gbt;
            p.g(paramc, "bizMsg.Text");
            paramoa = paramoa.Gbs;
            p.g(paramoa, "bizMsg.BaseInfo");
            paramViewGroup = new c.f(10, c.d.xmU, paramView);
            paramInt = paramoa.xri;
            paramoa = this.xmx;
            paramc = paramc.hFS;
            p.g(paramc, "text.Content");
            paramViewGroup.a(paramInt, paramoa, paramc);
          }
          j = paramoa.Gbx.FYQ.size();
          if (j <= 1) {
            break label1006;
          }
          paramc = c.d.xmR;
          if (paramoa.Gbx.FYP.FYp == 0) {
            break label1375;
          }
          paramViewGroup = paramoa.Gbx.FYQ.get(0);
          p.g(paramViewGroup, "bizMsg.AppMsg.DetailInfo[0]");
          paramViewGroup = (mp)paramViewGroup;
          paramHashSet = paramoa.Gbx.FYP;
          p.g(paramHashSet, "bizMsg.AppMsg.BaseInfo");
          localObject2 = paramoa.Gbs;
          p.g(localObject2, "bizMsg.BaseInfo");
          localObject1 = c.xmC;
          ae.v(c.access$getTAG$cp(), "fillTopSlot:" + paramViewGroup.FYs);
          localObject1 = new c.f(paramViewGroup.hFR, paramc, paramView);
          if ((paramViewGroup.hFR != 8) && (paramViewGroup.hFR != 10))
          {
            ((c.f)localObject1).xmP = paramViewGroup.FYO;
            ((c.f)localObject1).url = paramViewGroup.FYs;
            String str = paramViewGroup.Title;
            p.g(str, "detail.Title");
            ((c.f)localObject1).setTitle(str);
          }
          if (paramc == c.d.xmU)
          {
            paramc = (CharSequence)paramViewGroup.FYq;
            if ((paramc != null) && (!d.n.n.aD(paramc))) {
              break label1013;
            }
            i = 1;
            if (i == 0) {
              ((MMNeat7extView)((c.f)localObject1).xnv.getValue()).aq((CharSequence)paramViewGroup.FYq);
            }
          }
          paramc = (CharSequence)paramViewGroup.FYH;
          if ((paramc != null) && (!d.n.n.aD(paramc))) {
            break label1019;
          }
          i = 1;
          if (i == 0)
          {
            paramc = ((c.f)localObject1).dER();
            p.g(paramc, "view.showDescTv");
            paramc.setText((CharSequence)paramViewGroup.FYH);
          }
          paramc = ((c.f)localObject1).dER();
          if (paramc != null)
          {
            if ((((c.f)localObject1).xmP != 1) || (this.xmw)) {
              break label1025;
            }
            i = 4;
            paramc.setVisibility(i);
          }
          switch (paramViewGroup.hFR)
          {
          case 6: 
          default: 
            switch (paramViewGroup.hFR)
            {
            case 8: 
            case 9: 
            default: 
              switch (paramViewGroup.hFR)
              {
              default: 
                paramc = new String[2];
                paramc[0] = paramViewGroup.FYu;
                paramc[1] = paramViewGroup.FYw;
                ((c.f)localObject1).setImageUrl(J(paramc));
                a((View)((c.f)localObject1).dES(), paramViewGroup, paramHashSet, paramInt);
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
      paramc = paramoa.Gbx.FYQ.get(i);
      label913:
      label922:
      p.g(paramc, "bizMsg.AppMsg.DetailInfo[i]");
      paramViewGroup = (mp)paramc;
      paramHashSet = paramoa.Gbx.FYP;
      p.g(paramHashSet, "bizMsg.AppMsg.BaseInfo");
      if (i == j - 1) {}
      for (paramc = c.d.xmT;; paramc = c.d.xmS)
      {
        a(paramView, paramViewGroup, paramHashSet, paramc, paramInt);
        i += 1;
        break label922;
        label1006:
        paramc = c.d.xmU;
        break;
        label1013:
        i = 0;
        break label654;
        label1019:
        i = 0;
        break label704;
        label1025:
        i = 0;
        break label762;
        paramc = (TextView)((c.f)localObject1).xnq.getValue();
        p.g(paramc, "view.videoDurationTv");
        paramc.setText((CharSequence)com.tencent.mm.ah.m.ol(paramViewGroup.FYG));
        break label804;
        paramc = (TextView)((c.f)localObject1).xnr.getValue();
        p.g(paramc, "view.voiceDurationTv");
        paramc.setText((CharSequence)com.tencent.mm.ah.m.ol(paramViewGroup.FYB));
        break label804;
        if (paramViewGroup.vGj <= 1) {
          break label804;
        }
        paramc = (TextView)((c.f)localObject1).xmM.getValue();
        p.g(paramc, "view.picCntTv");
        paramc.setText((CharSequence)String.valueOf(paramViewGroup.vGj));
        break label804;
        paramc = (CharSequence)paramViewGroup.FYq;
        label1175:
        boolean bool;
        if ((paramc == null) || (d.n.n.aD(paramc)))
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
          ((c.f)localObject1).dFa().setPadding(0, 0, 0, ((c.e)localObject1).xmY);
        }
        for (;;)
        {
          ((c.f)localObject1).xnx = bool;
          break;
          i = 0;
          break label1175;
          label1220:
          bool = false;
          break label1183;
          label1226:
          ((c.f)localObject1).dFa().setPadding(((c.e)localObject1).xnb, ((c.e)localObject1).xna, ((c.e)localObject1).xnb, ((c.e)localObject1).xmY);
        }
        i = ((aak)localObject2).xri;
        paramc = this.xmx;
        localObject2 = paramViewGroup.Title;
        p.g(localObject2, "detail.Title");
        ((c.f)localObject1).a(i, paramc, (String)localObject2);
        paramc = (CharSequence)paramViewGroup.FYH;
        if ((paramc == null) || (d.n.n.aD(paramc))) {}
        for (i = 1; i == 0; i = 0)
        {
          paramc = ((c.f)localObject1).dER();
          p.g(paramc, "view.showDescTv");
          paramc.setText((CharSequence)paramViewGroup.FYH);
          break;
        }
        paramc = new String[2];
        paramc[0] = paramViewGroup.FYw;
        paramc[1] = paramViewGroup.FYu;
        break label887;
        label1375:
        paramViewGroup = paramoa.Gbx.FYQ.get(0);
        p.g(paramViewGroup, "bizMsg.AppMsg.DetailInfo[0]");
        paramViewGroup = (mp)paramViewGroup;
        paramHashSet = paramoa.Gbx.FYP;
        p.g(paramHashSet, "bizMsg.AppMsg.BaseInfo");
        a(paramView, paramViewGroup, paramHashSet, paramc, paramInt);
        break label913;
      }
    }
    
    private static String J(String[] paramArrayOfString)
    {
      AppMethodBeat.i(39640);
      int i = 0;
      Object localObject;
      int j;
      if (i < 2)
      {
        localObject = paramArrayOfString[i];
        CharSequence localCharSequence = (CharSequence)localObject;
        if ((localCharSequence == null) || (d.n.n.aD(localCharSequence)))
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
    
    private static String a(mp parammp)
    {
      AppMethodBeat.i(39643);
      parammp = parammp.FYs;
      p.g(parammp, "detail.ContentUrl");
      parammp = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.XX(parammp);
      AppMethodBeat.o(39643);
      return parammp;
    }
    
    private final void a(final View paramView, final mp parammp, final mo parammo, final int paramInt)
    {
      AppMethodBeat.i(39644);
      ImageView localImageView;
      b localb;
      c localc;
      final String str;
      if (parammp.hFR == 7)
      {
        localImageView = (ImageView)paramView.findViewById(2131297327);
        if (localImageView != null)
        {
          localb = new b(localImageView);
          localc = new c(localImageView);
          str = a(parammp);
          if (!fY(str)) {
            break label121;
          }
          localb.invoke();
        }
      }
      for (;;)
      {
        localImageView.setOnClickListener((View.OnClickListener)new a(localb, str, this, parammp));
        paramView.setOnClickListener((View.OnClickListener)new d(this, parammp, parammo, paramView, paramInt));
        AppMethodBeat.o(39644);
        return;
        label121:
        localc.invoke();
      }
    }
    
    private final void a(ViewGroup paramViewGroup, mp parammp, mo parammo, c.d paramd, int paramInt)
    {
      AppMethodBeat.i(39641);
      c.c localc = c.xmC;
      ae.v(c.access$getTAG$cp(), "fillCommonSlot:" + parammp.FYs);
      paramd = new c.b(parammp.hFR, paramd, paramViewGroup);
      paramd.xmP = parammp.FYO;
      paramd.url = parammp.FYs;
      paramViewGroup = parammp.Title;
      p.g(paramViewGroup, "detail.Title");
      paramd.setTitle(paramViewGroup);
      paramViewGroup = (CharSequence)parammp.FYH;
      int i;
      if ((paramViewGroup == null) || (d.n.n.aD(paramViewGroup)))
      {
        i = 1;
        if (i == 0)
        {
          paramViewGroup = paramd.dER();
          p.g(paramViewGroup, "view.showDescTv");
          paramViewGroup.setText((CharSequence)parammp.FYH);
        }
        paramViewGroup = paramd.dER();
        if (paramViewGroup != null)
        {
          if ((paramd.xmP != 1) || (this.xmw)) {
            break label305;
          }
          i = 4;
          label169:
          paramViewGroup.setVisibility(i);
        }
        if ((parammp.hFR == 8) && (parammp.vGj > 1))
        {
          paramViewGroup = (TextView)paramd.xmM.getValue();
          p.g(paramViewGroup, "view.picCntTv");
          paramViewGroup.setText((CharSequence)String.valueOf(parammp.vGj));
        }
        switch (parammp.hFR)
        {
        default: 
          paramViewGroup = new String[2];
          paramViewGroup[0] = parammp.FYv;
          paramViewGroup[1] = parammp.FYu;
        }
      }
      for (;;)
      {
        paramd.setImageUrl(J(paramViewGroup));
        a((View)paramd.dES(), parammp, parammo, paramInt);
        AppMethodBeat.o(39641);
        return;
        i = 0;
        break;
        label305:
        i = 0;
        break label169;
        paramViewGroup = new String[2];
        paramViewGroup[0] = parammp.FYu;
        paramViewGroup[1] = parammp.FYv;
      }
    }
    
    private static boolean fY(String paramString)
    {
      AppMethodBeat.i(39642);
      com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aKc();
      if (localf != null)
      {
        if ((p.i(localf.ijZ, paramString)) && (localf.ijX == 0) && (com.tencent.mm.ay.a.aJZ()))
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$1$3"})
    static final class a
      implements View.OnClickListener
    {
      a(c.a.b paramb, String paramString, c.a parama, mp parammp) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(39634);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        this.xmD.invoke();
        localObject = new e.g();
        e.h localh = new e.h();
        localh.EHk = str;
        localh.url = parammp.FYs;
        localh.title = parammp.Title;
        localh.hGs = "";
        localh.playUrl = parammp.FYC;
        localh.coverUrl = parammp.FYu;
        ((e.g)localObject).Kxb = localh;
        paramView.setTag(localObject);
        s.gi(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39634);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"drawPlaying", "", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      b(ImageView paramImageView)
      {
        super();
      }
      
      public final void invoke()
      {
        AppMethodBeat.i(39636);
        this.tVb.setImageResource(2131231272);
        Object localObject = this.tVb.getDrawable();
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"drawPlay", "", "invoke"})
    static final class c
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      c(ImageView paramImageView)
      {
        super();
      }
      
      public final void invoke()
      {
        AppMethodBeat.i(39638);
        this.tVb.setImageResource(2131231271);
        AppMethodBeat.o(39638);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(c.a parama, mp parammp, mo parammo, View paramView, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(39639);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        paramView = c.xmC;
        ae.i(c.access$getTAG$cp(), "onClick jump to url:%s", new Object[] { parammp.FYs });
        int i = this.xmF.intent.getIntExtra("KOpenArticleSceneFromScene", -1);
        paramView = new Intent();
        localObject1 = com.tencent.mm.ah.m.d(parammp.FYs, 126, i, 0);
        paramView.putExtra("rawUrl", (String)localObject1);
        paramView.putExtra("useJs", true);
        paramView.putExtra("vertical_scroll", true);
        paramView.putExtra("geta8key_scene", 3);
        Object localObject2 = this.xmF.xmz.dEE();
        p.g(localObject2, "widget.contact");
        paramView.putExtra("geta8key_username", ((an)localObject2).getUsername());
        localObject2 = paramView.getStringExtra("prePublishId");
        int j;
        int k;
        if (!bu.isNullOrNil((String)localObject2))
        {
          paramView.putExtra("KPublisherId", (String)localObject2);
          paramView.putExtra("prePublishId", (String)localObject2);
          paramView.putExtra("preUsername", paramView.getStringExtra("preUsername"));
          paramView.putExtra("preChatName", paramView.getStringExtra("preChatName"));
          paramView.putExtra("preChatTYPE", paramView.getIntExtra("preChatTYPE", 0));
          i = paramView.getIntExtra("KOpenArticleSceneFromScene", 10000);
          if (parammp.hFR == 5)
          {
            localObject2 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
            p.g(localObject2, "MMKernel.service(IBrandService::class.java)");
            if (((com.tencent.mm.plugin.brandservice.a.b)localObject2).bOe())
            {
              paramView.putExtra(e.b.JoV, 126);
              paramView.putExtra(e.b.JoW, i);
              paramView.putExtra("biz_video_session_id", y.getSessionId());
              localObject2 = new x();
              ((x)localObject2).hFX = paramView.getStringExtra("KPublisherId");
              Object localObject3 = this.xmF.xmz.dEE();
              p.g(localObject3, "widget.contact");
              ((x)localObject2).dpP = ((an)localObject3).getUsername();
              localObject3 = this.xmF.xmz.dEE();
              p.g(localObject3, "widget.contact");
              ((x)localObject2).hFW = ((an)localObject3).adF();
              ((x)localObject2).hFY.url = ((String)localObject1);
              ((x)localObject2).hFY.title = parammp.Title;
              ((x)localObject2).hFY.hGg = "detail.videoDigest";
              ((x)localObject2).hFY.hGe = parammp.FYu;
              ((x)localObject2).hFY.type = parammp.hFR;
              ((x)localObject2).hFY.time = parammo.CreateTime;
              ((x)localObject2).hFY.hGi = parammp.FYG;
              ((x)localObject2).hFY.videoWidth = parammp.FYE;
              ((x)localObject2).hFY.videoHeight = parammp.FYF;
              ((x)localObject2).hFY.hCa = parammp.FYD;
              ((x)localObject2).t(paramView);
              localObject2 = c.xmC;
              ae.i(c.access$getTAG$cp(), "jump to native video");
              localObject2 = new int[2];
              localObject3 = (ImageView)paramView.findViewById(2131297312);
              if (localObject3 != null)
              {
                j = ((ImageView)localObject3).getWidth();
                k = ((ImageView)localObject3).getHeight();
                ((ImageView)localObject3).getLocationInWindow((int[])localObject2);
                paramView.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
              }
              paramView.addFlags(268435456);
            }
          }
          if ((!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(6)) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.xmF.context, (String)localObject1, parammp.hFR, 126, i, paramView))) {
            break label876;
          }
          paramView = c.xmC;
          ae.i(c.access$getTAG$cp(), "jump to TmplWebview");
        }
        for (;;)
        {
          paramView = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.xnQ;
          paramView = this.xmF.xmz.dEE();
          p.g(paramView, "widget.contact");
          paramView = paramView.getUsername();
          p.g(paramView, "widget.contact.username");
          long l = this.xmF.xmz.TJ();
          i = parammo.FYo;
          j = parammp.FYr;
          k = parammp.hFR;
          int m = paramInt;
          int n = parammo.CreateTime;
          int i1 = this.xmF.xmz.dEH();
          p.h(paramView, "userName");
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a(com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.xnP, paramView, l, i, j, k, m, n, i1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(39639);
          return;
          paramView.putExtra("prePublishId", "brand_profile");
          paramView.putExtra("KPublisherId", "brand_profile");
          break;
          label876:
          com.tencent.mm.br.d.b(this.xmF.context, "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$CommonSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "picCntTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "Lkotlin/Lazy;", "picInfo", "Landroid/support/constraint/ConstraintLayout;", "getPicInfo", "()Landroid/support/constraint/ConstraintLayout;", "picInfo$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "titleTv$delegate", "url", "getUrl", "setUrl", "weakPicInfo", "Ljava/lang/ref/WeakReference;", "getWeakPicInfo", "()Ljava/lang/ref/WeakReference;", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "app_release"})
  static final class b
    extends c.e
  {
    private String title;
    String url;
    private final int xmJ;
    private final d.f xmK;
    private final WeakReference<ConstraintLayout> xmL;
    final d.f xmM;
    private final d.f xmN;
    private final d.f xmO;
    int xmP;
    
    public b(int paramInt, c.d paramd, ViewGroup paramViewGroup)
    {
      super(paramd, paramViewGroup);
      AppMethodBeat.i(39658);
      this.xmJ = 2131233660;
      this.xmK = d.g.O((d.g.a.a)new b(this));
      this.xmL = new WeakReference((ConstraintLayout)this.xmK.getValue());
      this.xmM = d.g.O((d.g.a.a)new a(this));
      this.xmN = d.g.O((d.g.a.a)new c(this));
      this.xmO = d.g.O((d.g.a.a)new d(this));
      this.url = "";
      this.title = "";
      AppMethodBeat.o(39658);
    }
    
    protected final void a(View paramView, c.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(39653);
      p.h(paramView, "container");
      p.h(paramd, "slotType");
      switch (d.cqt[paramd.ordinal()])
      {
      default: 
        localObject = paramView.findViewById(2131297330);
        p.g(localObject, "container.findViewById<F…id.biz_slot_voice_layout)");
        ((FrameLayout)localObject).setVisibility(8);
        switch (this.hBV)
        {
        case 6: 
        case 9: 
        default: 
          localObject = paramView.findViewById(2131297312);
          p.g(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
          ((ImageView)localObject).setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        super.a(paramView, paramd, paramBoolean);
        AppMethodBeat.o(39653);
        return;
        localObject = paramView.findViewById(2131297307);
        p.g(localObject, "container.findViewById<V…d.biz_slot_common_line_v)");
        ((View)localObject).setVisibility(0);
        break;
        localObject = paramView.findViewById(2131297312);
        p.g(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject).setVisibility(0);
        localObject = paramView.findViewById(2131297326);
        p.g(localObject, "container.findViewById<I….biz_slot_video_play_img)");
        ((ImageView)localObject).setVisibility(0);
        continue;
        localObject = paramView.findViewById(2131297312);
        p.g(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject).setVisibility(0);
        localObject = paramView.findViewById(2131297303);
        p.g(localObject, "container.findViewById<C…slot_common_content_desc)");
        ((ConstraintLayout)localObject).setVisibility(0);
        continue;
        localObject = paramView.findViewById(2131297330);
        p.g(localObject, "container.findViewById<F…id.biz_slot_voice_layout)");
        ((FrameLayout)localObject).setVisibility(0);
      }
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)paramView.findViewById(2131297321);
      p.g(localMMNeat7extView, "tv");
      if ((localMMNeat7extView.getLayoutParams() instanceof ConstraintLayout.LayoutParams))
      {
        localObject = localMMNeat7extView.getLayoutParams();
        if (localObject == null)
        {
          paramView = new v("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
          AppMethodBeat.o(39653);
          throw paramView;
        }
      }
      for (Object localObject = (ViewGroup.MarginLayoutParams)localObject;; localObject = (ViewGroup.MarginLayoutParams)localObject)
      {
        if (localObject != null)
        {
          ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(0);
          localMMNeat7extView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        localObject = paramView.findViewById(2131297312);
        p.g(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject).setVisibility(8);
        break;
        ViewGroup.LayoutParams localLayoutParams = localMMNeat7extView.getLayoutParams();
        localObject = localLayoutParams;
        if (!(localLayoutParams instanceof LinearLayout.LayoutParams)) {
          localObject = null;
        }
      }
    }
    
    protected final ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39652);
      p.h(paramContext, "context");
      p.h(paramViewGroup, "container");
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
    
    protected final void dEO()
    {
      AppMethodBeat.i(39654);
      if (this.xmL == null)
      {
        AppMethodBeat.o(39654);
        return;
      }
      ConstraintLayout localConstraintLayout = (ConstraintLayout)this.xmL.get();
      if (localConstraintLayout != null)
      {
        localConstraintLayout.setBackgroundResource(2131231208);
        AppMethodBeat.o(39654);
        return;
      }
      AppMethodBeat.o(39654);
    }
    
    protected final float[] dEP()
    {
      AppMethodBeat.i(39655);
      float[] arrayOfFloat = d.a.e.b(new Float[] { Float.valueOf(bq(1.0F)), Float.valueOf(bq(1.0F)), Float.valueOf(bq(1.0F)), Float.valueOf(bq(1.0F)) });
      AppMethodBeat.o(39655);
      return arrayOfFloat;
    }
    
    protected final int dEQ()
    {
      return this.xmJ;
    }
    
    public final TextView dER()
    {
      AppMethodBeat.i(39656);
      TextView localTextView = (TextView)this.xmN.getValue();
      AppMethodBeat.o(39656);
      return localTextView;
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(39657);
      p.h(paramString, "value");
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.xmO.getValue();
      p.g(localMMNeat7extView, "titleTv");
      a(localMMNeat7extView, paramString, this.xmP, this.url, 5);
      AppMethodBeat.o(39657);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<TextView>
    {
      a(c.b paramb)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/support/constraint/ConstraintLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<ConstraintLayout>
    {
      b(c.b paramb)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c
      extends d.g.b.q
      implements d.g.a.a<TextView>
    {
      c(c.b paramb)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d
      extends d.g.b.q
      implements d.g.a.a<MMNeat7extView>
    {
      d(c.b paramb)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "", "(Ljava/lang/String;I)V", "TOP", "COMMON", "BOTTOM", "SINGLE", "app_release"})
  static enum d
  {
    static
    {
      AppMethodBeat.i(39659);
      d locald1 = new d("TOP", 0);
      xmR = locald1;
      d locald2 = new d("COMMON", 1);
      xmS = locald2;
      d locald3 = new d("BOTTOM", 2);
      xmT = locald3;
      d locald4 = new d("SINGLE", 3);
      xmU = locald4;
      xmV = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(39659);
    }
    
    private d() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "audioPadding", "getAudioPadding", "()I", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "imageDefaultRes", "getImageDefaultRes", "imageIv", "Landroid/widget/ImageView;", "getImageIv", "()Landroid/widget/ImageView;", "imageIv$delegate", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "value", "", "imageUrl", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "item", "getItem", "()Landroid/view/ViewGroup;", "item$delegate", "getItemShowType", "largePading", "getLargePading", "listPadding", "getListPadding", "normalPading", "getNormalPading", "getSlotType", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "smallPadding", "getSmallPadding", "dpToPixel", "", "getDpToPixel", "(F)F", "resFromRaw", "getResFromRaw", "(I)F", "resToPixel", "getResToPixel", "(I)I", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "onImageLoadFinish", "onImageLoadStart", "setNeatText", "neatText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "isPayMsg", "url", "scene", "app_release"})
  static class e
  {
    final int hBV;
    String hBa;
    private final d.f scS;
    private final int xmJ;
    private final d.f xmW;
    private final d.f xmX;
    final int xmY;
    private final int xmZ;
    final int xna;
    final int xnb;
    private final int xnc;
    private final float[] xnd;
    final c.d xne;
    
    public e(int paramInt, c.d paramd, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39679);
      this.hBV = paramInt;
      this.xne = paramd;
      this.xmW = d.g.O((d.g.a.a)new e(this, paramViewGroup));
      this.xmX = d.g.O((d.g.a.a)new b(this));
      this.scS = d.g.O((d.g.a.a)new a(this));
      this.xmY = ((int)bq(36.0F));
      this.xmZ = ak.getResources().getDimensionPixelSize(2131165489);
      this.xna = ak.getResources().getDimensionPixelSize(2131165516);
      this.xnb = ak.getResources().getDimensionPixelSize(2131165480);
      this.xnc = ak.getResources().getDimensionPixelSize(2131165568);
      this.xnd = d.a.e.b(new Float[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) });
      this.xmJ = 2131100141;
      this.hBa = "";
      AppMethodBeat.o(39679);
    }
    
    protected static float bq(float paramFloat)
    {
      AppMethodBeat.i(39678);
      Resources localResources = ak.getResources();
      p.g(localResources, "MMApplicationContext.getResources()");
      float f = localResources.getDisplayMetrics().density;
      AppMethodBeat.o(39678);
      return f * paramFloat + 0.5F;
    }
    
    protected void a(View paramView, c.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(39674);
      p.h(paramView, "container");
      p.h(paramd, "slotType");
      int i;
      switch (e.cqt[paramd.ordinal()])
      {
      default: 
        AppMethodBeat.o(39674);
        return;
      case 1: 
        paramView.setPadding(this.xnb, this.xnc, this.xnb, 0);
        if (paramBoolean) {}
        for (i = 2131231235;; i = 2131231233)
        {
          paramView.setBackgroundResource(i);
          AppMethodBeat.o(39674);
          return;
        }
      case 2: 
        paramView.setPadding(this.xnb, this.xnc, this.xnb, 0);
        i = 2131231229;
      }
      for (;;)
      {
        paramView.setBackgroundResource(i);
        break;
        paramView.setPadding(this.xnb, this.xnc, this.xnb, this.xnb);
        i = 2131231228;
        continue;
        paramView.setPadding(this.xnb, this.xnc, this.xnb, this.xnc);
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
      p.h(paramMMNeat7extView, "neatText");
      p.h(paramString1, "text");
      paramString1 = k.c(paramMMNeat7extView.getContext(), (CharSequence)paramString1);
      if ((this.hBV == 0) && (paramInt1 == 1)) {}
      for (;;)
      {
        com.tencent.mm.plugin.brandservice.b.a locala = com.tencent.mm.plugin.brandservice.b.a.obW;
        p.g(paramString1, "text");
        com.tencent.mm.plugin.brandservice.b.a.a((CharSequence)paramString1, paramMMNeat7extView, bool, paramString2, paramInt2);
        paramMMNeat7extView.setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.g((NeatTextView)paramMMNeat7extView, new com.tencent.mm.pluginsdk.ui.span.n(paramMMNeat7extView.getContext())));
        AppMethodBeat.o(39676);
        return;
        bool = false;
      }
    }
    
    protected ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39672);
      p.h(paramContext, "context");
      p.h(paramViewGroup, "container");
      paramContext = (Throwable)new d.n();
      AppMethodBeat.o(39672);
      throw paramContext;
    }
    
    protected void dEO() {}
    
    protected float[] dEP()
    {
      return this.xnd;
    }
    
    protected int dEQ()
    {
      return this.xmJ;
    }
    
    public final ViewGroup dES()
    {
      AppMethodBeat.i(39670);
      ViewGroup localViewGroup = (ViewGroup)this.xmW.getValue();
      AppMethodBeat.o(39670);
      return localViewGroup;
    }
    
    final ImageView dET()
    {
      AppMethodBeat.i(39671);
      ImageView localImageView = (ImageView)this.xmX.getValue();
      AppMethodBeat.o(39671);
      return localImageView;
    }
    
    protected void dEU() {}
    
    protected final Context getContext()
    {
      AppMethodBeat.i(39673);
      Context localContext = (Context)this.scS.getValue();
      AppMethodBeat.o(39673);
      return localContext;
    }
    
    public final void setImageUrl(final String paramString)
    {
      AppMethodBeat.i(39677);
      p.h(paramString, "value");
      if (d.n.n.aD((CharSequence)paramString)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(39677);
        return;
      }
      paramString = com.tencent.mm.api.b.t(paramString, 2);
      p.g(paramString, "BizImageStrategy.getUrl(…rategy.SCENE_BIZ_PROFILE)");
      this.hBa = paramString;
      paramString = c.xmC;
      ae.v(c.access$getTAG$cp(), "imageUrl:" + this.hBa);
      paramString = dEP();
      final String str = this.hBa;
      Object localObject1 = new com.tencent.mm.av.a.a.c.a().aJq();
      Object localObject2 = new StringBuilder("radius_");
      Object localObject3 = Arrays.toString(paramString);
      p.g(localObject3, "java.util.Arrays.toString(this)");
      localObject1 = ((com.tencent.mm.av.a.a.c.a)localObject1).Gi((String)localObject3).pL(dEQ()).a((com.tencent.mm.av.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.av.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).Gg(r.aMY(this.hBa)).aJu();
      localObject2 = new d(this);
      localObject3 = new com.tencent.mm.pluginsdk.ui.applet.m(3, -1, -1, paramString, (m.a)localObject2);
      ((com.tencent.mm.pluginsdk.ui.applet.m)localObject3).av((Runnable)new c(this, str, (com.tencent.mm.av.a.a.c)localObject1, paramString, (d)localObject2));
      com.tencent.mm.av.q.aJb().a(str, dET(), (com.tencent.mm.av.a.a.c)localObject1, (com.tencent.mm.av.a.c.h)localObject3);
      AppMethodBeat.o(39677);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<Context>
    {
      a(c.e parame)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<ImageView>
    {
      b(c.e parame)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel$imageUrl$imageLoaderListener$1$1"})
    static final class c
      implements Runnable
    {
      c(c.e parame, String paramString, com.tencent.mm.av.a.a.c paramc, float[] paramArrayOfFloat, c.e.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(39665);
        com.tencent.mm.av.a.a locala = com.tencent.mm.av.q.aJb();
        String str = str;
        ImageView localImageView1 = this.xnf.dET();
        com.tencent.mm.av.a.a.c localc = this.xng;
        ImageView localImageView2 = this.xnf.dET();
        p.g(localImageView2, "imageIv");
        int i = localImageView2.getMeasuredWidth();
        localImageView2 = this.xnf.dET();
        p.g(localImageView2, "imageIv");
        locala.a(str, localImageView1, localc, (com.tencent.mm.av.a.c.h)new com.tencent.mm.pluginsdk.ui.applet.m(3, i, localImageView2.getMeasuredHeight(), paramString, (m.a)this.xni));
        AppMethodBeat.o(39665);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel$imageUrl$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
    public static final class d
      implements m.a
    {
      public final void onFinish()
      {
        AppMethodBeat.i(39666);
        c.c localc = c.xmC;
        ae.v(c.access$getTAG$cp(), "imageUrl onFinish:" + this.xnf.hBa);
        this.xnf.dEO();
        AppMethodBeat.o(39666);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(39667);
        c.c localc = c.xmC;
        ae.v(c.access$getTAG$cp(), "imageUrl onStart:" + this.xnf.hBa);
        this.xnf.dEU();
        AppMethodBeat.o(39667);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
    static final class e
      extends d.g.b.q
      implements d.g.a.a<ViewGroup>
    {
      e(c.e parame, ViewGroup paramViewGroup)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$TopSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "collapseTextLayout", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "getCollapseTextLayout", "()Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "collapseTextLayout$delegate", "Lkotlin/Lazy;", "descMask", "Landroid/view/View;", "getDescMask", "()Landroid/view/View;", "descMask$delegate", "digestTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getDigestTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "digestTv$delegate", "value", "", "hasAudioDesc", "getHasAudioDesc", "()Z", "setHasAudioDesc", "(Z)V", "hasDesc", "setHasDesc", "hasSingleInfo", "hasTitle", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "isSingleImage", "picCntTv", "Landroid/widget/TextView;", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "singleDescLayout", "getSingleDescLayout", "singleDescLayout$delegate", "singleTitleTv", "getSingleTitleTv", "singleTitleTv$delegate", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleDescViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "titleTv", "getTitleTv", "titleTv$delegate", "topMask", "Landroid/widget/ImageView;", "getTopMask", "()Landroid/widget/ImageView;", "topMask$delegate", "url", "getUrl", "setUrl", "videPlayImg", "getVidePlayImg", "videPlayImg$delegate", "videoDurationTv", "getVideoDurationTv", "videoDurationTv$delegate", "voiceDurationTv", "getVoiceDurationTv", "voiceDurationTv$delegate", "fillBackground", "", "selector", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "onImageLoadStart", "setText", "id", "expandSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "text", "setTitleDescTextColor", "color", "app_release"})
  static final class f
    extends c.e
  {
    private String title;
    String url;
    final d.f xmM;
    private final d.f xmN;
    private final d.f xmO;
    int xmP;
    private boolean xnk;
    boolean xnl;
    boolean xnm;
    ArrayList<View> xnn;
    private final d.f xno;
    private final d.f xnp;
    final d.f xnq;
    final d.f xnr;
    private final d.f xns;
    private final d.f xnt;
    private final d.f xnu;
    final d.f xnv;
    private final d.f xnw;
    boolean xnx;
    
    public f(final int paramInt, c.d paramd, ViewGroup paramViewGroup)
    {
      super(paramd, paramViewGroup);
      AppMethodBeat.i(39713);
      this.url = "";
      this.xnn = new ArrayList();
      this.xno = d.g.O((d.g.a.a)new l(this));
      this.xnp = d.g.O((d.g.a.a)new b(this));
      this.xmN = d.g.O((d.g.a.a)new h(this));
      this.xnq = d.g.O((d.g.a.a)new n(this));
      this.xnr = d.g.O((d.g.a.a)new o(this));
      this.xmM = d.g.O((d.g.a.a)new e(this));
      this.xmO = d.g.O((d.g.a.a)new k(this, paramInt));
      this.xns = d.g.O((d.g.a.a)new m(this));
      this.xnt = d.g.O((d.g.a.a)new i(this));
      this.xnu = d.g.O((d.g.a.a)new j(this));
      this.xnv = d.g.O((d.g.a.a)new c(this));
      this.xnw = d.g.O((d.g.a.a)new a(this));
      this.title = "";
      AppMethodBeat.o(39713);
    }
    
    private final boolean dEW()
    {
      return (this.xne == c.d.xmU) && (!this.xnm);
    }
    
    private final ImageView dEX()
    {
      AppMethodBeat.i(39702);
      ImageView localImageView = (ImageView)this.xno.getValue();
      AppMethodBeat.o(39702);
      return localImageView;
    }
    
    private final MMNeat7extView dEY()
    {
      AppMethodBeat.i(39704);
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.xmO.getValue();
      AppMethodBeat.o(39704);
      return localMMNeat7extView;
    }
    
    private final ImageView dEZ()
    {
      AppMethodBeat.i(39705);
      ImageView localImageView = (ImageView)this.xns.getValue();
      AppMethodBeat.o(39705);
      return localImageView;
    }
    
    private MMCollapsibleTextView dFb()
    {
      AppMethodBeat.i(39707);
      MMCollapsibleTextView localMMCollapsibleTextView = (MMCollapsibleTextView)this.xnw.getValue();
      AppMethodBeat.o(39707);
      return localMMCollapsibleTextView;
    }
    
    final void NL(int paramInt)
    {
      AppMethodBeat.i(39712);
      Iterator localIterator = ((Iterable)this.xnn).iterator();
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
    
    public final void a(int paramInt, HashSet<Integer> paramHashSet, String paramString)
    {
      AppMethodBeat.i(39709);
      p.h(paramHashSet, "expandSet");
      p.h(paramString, "text");
      MMCollapsibleTextView localMMCollapsibleTextView = dFb();
      p.g(localMMCollapsibleTextView, "collapseTextLayout");
      paramString = k.g(localMMCollapsibleTextView.getContext(), (CharSequence)paramString, (int)dFb().getTextSize());
      localMMCollapsibleTextView = dFb();
      if (!paramHashSet.contains(Integer.valueOf(paramInt))) {}
      for (boolean bool = true;; bool = false)
      {
        localMMCollapsibleTextView.setCollapsed(bool);
        localMMCollapsibleTextView = dFb();
        p.g(paramString, "text");
        localMMCollapsibleTextView.setText((CharSequence)paramString);
        if (!(dFb().getContentText() instanceof MMNeat7extView)) {
          break label191;
        }
        paramString = dFb().getContentText();
        if (paramString != null) {
          break;
        }
        paramHashSet = new v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(39709);
        throw paramHashSet;
      }
      paramString = (MMNeat7extView)paramString;
      dFb().setOnTextTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.g((NeatTextView)paramString, new com.tencent.mm.pluginsdk.ui.span.n(paramString.getContext())));
      label191:
      dFb().setOnCollapse((d.g.a.a)new c.f.f(paramHashSet, paramInt));
      dFb().setOnExpand((d.g.a.a)new c.f.g(paramHashSet, paramInt));
      AppMethodBeat.o(39709);
    }
    
    protected final void a(View paramView, c.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(39698);
      p.h(paramView, "container");
      p.h(paramd, "slotType");
      switch (this.hBV)
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
        if (paramd == c.d.xmR)
        {
          View localView = paramView.findViewById(2131297323);
          p.g(localView, "container.findViewById<V…R.id.biz_slot_top_line_v)");
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
      p.h(paramContext, "context");
      p.h(paramViewGroup, "container");
      paramContext = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493613, paramViewGroup, false);
      if (paramContext == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(39697);
        throw paramContext;
      }
      paramContext = (ViewGroup)paramContext;
      int i;
      switch (this.hBV)
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
        dEV();
        i = 2131298602;
        continue;
        i = 2131298603;
        continue;
        i = 2131298600;
      }
    }
    
    protected final void dEO()
    {
      AppMethodBeat.i(39711);
      Object localObject = getContext();
      p.g(localObject, "context");
      NL(((Context)localObject).getResources().getColor(2131101182));
      if (this.xnk)
      {
        localObject = (View)this.xnp.getValue();
        if (!dEW()) {
          break label113;
        }
        if (this.xnl)
        {
          i = 2131233666;
          ((View)localObject).setBackgroundResource(i);
        }
      }
      else
      {
        localObject = dEX();
        if (this.xne != c.d.xmR) {
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
        if (this.xnl)
        {
          i = 2131233664;
          break;
        }
        i = 2131233663;
        break;
      }
    }
    
    protected final float[] dEP()
    {
      AppMethodBeat.i(39699);
      if (dEW())
      {
        arrayOfFloat = d.a.e.b(new Float[] { Float.valueOf(bq(8.0F)), Float.valueOf(bq(8.0F)), Float.valueOf(bq(8.0F)), Float.valueOf(bq(8.0F)) });
        AppMethodBeat.o(39699);
        return arrayOfFloat;
      }
      float[] arrayOfFloat = d.a.e.b(new Float[] { Float.valueOf(bq(8.0F)), Float.valueOf(bq(8.0F)), Float.valueOf(0.0F), Float.valueOf(0.0F) });
      AppMethodBeat.o(39699);
      return arrayOfFloat;
    }
    
    protected final int dEQ()
    {
      AppMethodBeat.i(39700);
      if (dEW())
      {
        AppMethodBeat.o(39700);
        return 2131233661;
      }
      AppMethodBeat.o(39700);
      return 2131233662;
    }
    
    public final TextView dER()
    {
      AppMethodBeat.i(39703);
      TextView localTextView = (TextView)this.xmN.getValue();
      AppMethodBeat.o(39703);
      return localTextView;
    }
    
    protected final void dEU()
    {
      AppMethodBeat.i(39710);
      com.tencent.mm.ac.c.h((d.g.a.a)new d(this));
      AppMethodBeat.o(39710);
    }
    
    final void dEV()
    {
      AppMethodBeat.i(39701);
      this.xnk = true;
      if (this.hBV == 5)
      {
        Object localObject = dEZ();
        p.g(localObject, "videPlayImg");
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
          ImageView localImageView = dEZ();
          p.g(localImageView, "videPlayImg");
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(39701);
    }
    
    final View dFa()
    {
      AppMethodBeat.i(39706);
      View localView = (View)this.xnt.getValue();
      AppMethodBeat.o(39706);
      return localView;
    }
    
    public final void setTitle(String paramString)
    {
      int i = 4;
      AppMethodBeat.i(39708);
      p.h(paramString, "value");
      MMNeat7extView localMMNeat7extView;
      int j;
      String str;
      switch (this.hBV)
      {
      default: 
        if (this.xne == c.d.xmU)
        {
          localMMNeat7extView = (MMNeat7extView)this.xnu.getValue();
          p.g(localMMNeat7extView, "if (slotType == SlotType…ingleTitleTv else titleTv");
          j = this.xmP;
          str = this.url;
          if (this.xne != c.d.xmU) {
            break label188;
          }
        }
        break;
      }
      for (;;)
      {
        a(localMMNeat7extView, paramString, j, str, i);
        AppMethodBeat.o(39708);
        return;
        localMMNeat7extView = dEY();
        p.g(localMMNeat7extView, "titleTv");
        a(localMMNeat7extView, paramString, this.xmP, this.url, 4);
        paramString = dEX();
        if (this.xne == c.d.xmR) {}
        for (i = 2131231243;; i = 2131231241)
        {
          paramString.setBackgroundResource(i);
          AppMethodBeat.o(39708);
          return;
        }
        localMMNeat7extView = dEY();
        break;
        label188:
        i = 41;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<MMCollapsibleTextView>
    {
      a(c.f paramf)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<View>
    {
      b(c.f paramf)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c
      extends d.g.b.q
      implements d.g.a.a<MMNeat7extView>
    {
      c(c.f paramf)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      d(c.f paramf)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e
      extends d.g.b.q
      implements d.g.a.a<TextView>
    {
      e(c.f paramf)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h
      extends d.g.b.q
      implements d.g.a.a<TextView>
    {
      h(c.f paramf)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i
      extends d.g.b.q
      implements d.g.a.a<View>
    {
      i(c.f paramf)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j
      extends d.g.b.q
      implements d.g.a.a<MMNeat7extView>
    {
      j(c.f paramf)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k
      extends d.g.b.q
      implements d.g.a.a<MMNeat7extView>
    {
      k(c.f paramf, int paramInt)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l
      extends d.g.b.q
      implements d.g.a.a<ImageView>
    {
      l(c.f paramf)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m
      extends d.g.b.q
      implements d.g.a.a<ImageView>
    {
      m(c.f paramf)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class n
      extends d.g.b.q
      implements d.g.a.a<TextView>
    {
      n(c.f paramf)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class o
      extends d.g.b.q
      implements d.g.a.a<TextView>
    {
      o(c.f paramf)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "context", "Landroid/content/Context;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "position", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Landroid/view/View;Landroid/view/ViewGroup;ILcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;)V", "coverSize", "radius", "", "view", "getView", "()Landroid/view/View;", "fillVideoChannel", "", "fillVideoItem", "videoItem", "Lcom/tencent/mm/protocal/protobuf/NotifyVideoInfo;", "itemView", "getDurationText", "", "app_release"})
  static final class g
    extends c.h
  {
    final Context context;
    private float radius;
    final View view;
    final ContactWidgetNewBizInfo xmz;
    private int xnB;
    
    public g(final Context paramContext, ContactWidgetNewBizInfo paramContactWidgetNewBizInfo, View paramView, ViewGroup paramViewGroup, final cne paramcne)
    {
      AppMethodBeat.i(169914);
      this.radius = 2.0F;
      this.context = paramContext;
      this.xmz = paramContactWidgetNewBizInfo;
      this.xnB = com.tencent.mm.cb.a.fromDPToPix(paramContext, 64);
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
        if (!p.i(paramContactWidgetNewBizInfo, paramcne)) {
          break label697;
        }
        this.view = paramView;
        paramContactWidgetNewBizInfo = (TextView)this.view.findViewById(2131306337);
        paramContext = (CharSequence)paramcne.Hzn;
        if ((paramContext != null) && (paramContext.length() != 0)) {
          break label735;
        }
        i = 1;
        if (i != 0) {
          break label741;
        }
        paramContext = (CharSequence)paramcne.Hzn;
        paramContactWidgetNewBizInfo.setText(paramContext);
        paramContext = com.tencent.mm.plugin.brandservice.ui.b.d.oyS;
        com.tencent.mm.plugin.brandservice.ui.b.d.h(paramContactWidgetNewBizInfo);
        paramContactWidgetNewBizInfo = (TextView)this.view.findViewById(2131306336);
        paramContext = (CharSequence)paramcne.dyI;
        if ((paramContext != null) && (paramContext.length() != 0)) {
          break label769;
        }
        i = 1;
        if (i != 0) {
          break label775;
        }
        paramContext = (CharSequence)paramcne.dyI;
        paramContactWidgetNewBizInfo.setText(paramContext);
        paramContext = paramcne.Hzm;
        paramContactWidgetNewBizInfo = c.xmC;
        ae.v(c.access$getTAG$cp(), "alvinluo fillVideoChannel size: %d", new Object[] { Integer.valueOf(paramContext.size()) });
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
          paramViewGroup = (cdr)paramView.next();
        } while (paramViewGroup == null);
        paramContext = c.xmC;
        ae.d(c.access$getTAG$cp(), "alvinluo videoItem url: %s, duration: %d", new Object[] { paramViewGroup.HqB, Integer.valueOf(paramViewGroup.duration) });
        localObject1 = LayoutInflater.from(this.context).inflate(2131493622, null, false);
        paramContactWidgetNewBizInfo.addView((View)localObject1);
        p.g(localObject1, "itemView");
        paramContext = ((View)localObject1).findViewById(2131306332);
        p.g(paramContext, "itemView.findViewById<Te…iew>(R.id.video_duration)");
        localObject2 = (TextView)paramContext;
        i = paramViewGroup.duration / 3600;
        j = (paramViewGroup.duration - i * 3600) / 60;
        k = paramViewGroup.duration % 60;
        paramContext = c.xmC;
        ae.i(c.access$getTAG$cp(), "alvinluo getDurationText " + i + ':' + j + ':' + k);
        if (i <= 0) {
          break label803;
        }
        paramContext = ad.Njc;
        paramContext = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }, 3));
        p.g(paramContext, "java.lang.String.format(format, *args)");
      }
      for (;;)
      {
        ((TextView)localObject2).setText((CharSequence)paramContext);
        paramContext = (ImageView)((View)localObject1).findViewById(2131306321);
        paramViewGroup = com.tencent.mm.api.b.t(paramViewGroup.HqB, 2);
        localObject1 = new com.tencent.mm.av.a.a.c.a().aJq().dh(this.xnB, this.xnB).Gi("radius_" + this.radius).pL(2131233660).a((com.tencent.mm.av.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.av.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).Gg(r.aMY(paramViewGroup)).aJu();
        localObject2 = new b(paramViewGroup, paramContext);
        localObject2 = new com.tencent.mm.pluginsdk.ui.applet.m(3, this.xnB, this.xnB, true, true, this.radius, (m.a)localObject2);
        com.tencent.mm.av.q.aJb().a(paramViewGroup, paramContext, (com.tencent.mm.av.a.a.c)localObject1, (com.tencent.mm.av.a.c.h)localObject2);
        break label261;
        paramContactWidgetNewBizInfo = null;
        break;
        label697:
        paramContext = LayoutInflater.from(paramContext).inflate(2131493621, paramViewGroup, false);
        p.g(paramContext, "LayoutInflater.from(cont…o_channel, parent, false)");
        this.view = paramContext;
        this.view.setTag(paramcne);
        break label76;
        label735:
        i = 0;
        break label114;
        label741:
        paramContext = paramContactWidgetNewBizInfo.getContext();
        p.g(paramContext, "context");
        paramContext = (CharSequence)paramContext.getResources().getString(2131756647);
        break label128;
        label769:
        i = 0;
        break label179;
        label775:
        paramContext = paramContactWidgetNewBizInfo.getContext();
        p.g(paramContext, "context");
        paramContext = (CharSequence)paramContext.getResources().getString(2131756646);
        break label193;
        label803:
        paramContext = ad.Njc;
        paramContext = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(j), Integer.valueOf(k) }, 2));
        p.g(paramContext, "java.lang.String.format(format, *args)");
      }
      label848:
      paramContext = this.view.findViewById(2131304246);
      if (paramContext != null)
      {
        paramContext.setOnClickListener((View.OnClickListener)new a(this, paramcne));
        AppMethodBeat.o(169914);
        return;
      }
      AppMethodBeat.o(169914);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(c.g paramg, cne paramcne) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(169911);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder$fillVideoChannel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramView = (CharSequence)paramcne.oGf;
        if ((paramView == null) || (paramView.length() == 0)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            paramView = new Intent();
            paramView.putExtra("rawUrl", paramcne.oGf);
            localObject = this.xnC.xmz.dEE();
            p.g(localObject, "widget.contact");
            paramView.putExtra("geta8key_username", ((an)localObject).getUsername());
            com.tencent.mm.br.d.b(this.xnC.context, "webview", ".ui.tools.WebViewUI", paramView);
            paramView = this.xnC.xmz.dEE();
            p.g(paramView, "widget.contact");
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(paramView.getUsername(), 1402, this.xnC.xmz.dEH(), this.xnC.xmz.TJ());
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder$fillVideoChannel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169911);
          return;
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder$fillVideoItem$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
    public static final class b
      implements m.a
    {
      b(String paramString, ImageView paramImageView) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(169912);
        c.c localc = c.xmC;
        ae.v(c.access$getTAG$cp(), "imageUrl onFinish:" + this.xnE);
        paramContext.setBackgroundResource(2131233299);
        AppMethodBeat.o(169912);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(169913);
        c.c localc = c.xmC;
        ae.v(c.access$getTAG$cp(), "imageUrl onStart:" + this.xnE);
        AppMethodBeat.o(169913);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "", "()V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "app_release"})
  static abstract class h {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.c
 * JD-Core Version:    0.7.0.1
 */