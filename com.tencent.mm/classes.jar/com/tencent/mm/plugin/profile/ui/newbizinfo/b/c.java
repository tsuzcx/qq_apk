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
import com.tencent.mm.ai.x;
import com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.cmk;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.protocal.protobuf.mo;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.h.a;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import d.a.j;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter$Interpolator;", "ui", "Lcom/tencent/mm/ui/MMActivity;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "orginAdapter", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;", "footer", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;[Ljava/lang/String;)V", "adapter", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;)V", "brandService", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "getBrandService", "()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "brandService$delegate", "Lkotlin/Lazy;", "changedPlayId", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExpandSet", "()Ljava/util/HashSet;", "getFooter", "()[Ljava/lang/String;", "[Ljava/lang/String;", "isBizPayOpen", "", "()Z", "originalCount", "getOriginalCount", "()I", "setOriginalCount", "(I)V", "getUi", "()Lcom/tencent/mm/ui/MMActivity;", "getWidget", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "getCount", "getFooterCount", "getItem", "", "position", "getRelativePosition", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "isInterpolated", "onMusicStateChanged", "", "event", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "preloadPage", "fromPosition", "toPosition", "update", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "notifyInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "BizMsgViewHolder", "CommonSlotViewModel", "Companion", "SlotType", "SlotViewModel", "TopSlotViewModel", "VideoChannelViewHolder", "ViewHolder", "app_release"})
public final class c
  implements h.a
{
  private static final String TAG = "MicroMsg.NewBizInfoAdapter";
  public static final c.c wWL;
  public a wWB;
  public String wWC;
  public int wWD;
  private final d.f wWE;
  final boolean wWF;
  private final HashSet<Integer> wWG;
  final MMActivity wWH;
  public final ContactWidgetNewBizInfo wWI;
  public final com.tencent.mm.ui.base.preference.h wWJ;
  private final String[] wWK;
  
  static
  {
    AppMethodBeat.i(39720);
    wWL = new c.c((byte)0);
    TAG = "MicroMsg.NewBizInfoAdapter";
    AppMethodBeat.o(39720);
  }
  
  public c(MMActivity paramMMActivity, ContactWidgetNewBizInfo paramContactWidgetNewBizInfo, com.tencent.mm.ui.base.preference.h paramh, String[] paramArrayOfString)
  {
    AppMethodBeat.i(39727);
    this.wWH = paramMMActivity;
    this.wWI = paramContactWidgetNewBizInfo;
    this.wWJ = paramh;
    this.wWK = paramArrayOfString;
    com.tencent.mm.plugin.brandservice.b.c.init();
    this.wWB = new a();
    this.wWC = "none";
    this.wWE = d.g.O((d.g.a.a)c.i.wXP);
    paramMMActivity = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
    p.g(paramMMActivity, "MMKernel.service(IBrandService::class.java)");
    this.wWF = ((com.tencent.mm.plugin.brandservice.a.b)paramMMActivity).bNh();
    this.wWG = new HashSet();
    AppMethodBeat.o(39727);
  }
  
  public final int Nc(int paramInt)
  {
    AppMethodBeat.i(39722);
    this.wWD = paramInt;
    a locala = this.wWB;
    int i = locala.fVg.size();
    int j = locala.wWh.size();
    AppMethodBeat.o(39722);
    return j + i + paramInt;
  }
  
  public final boolean Nd(int paramInt)
  {
    AppMethodBeat.i(39723);
    int i = dBv();
    if ((paramInt >= this.wWD - i) && (paramInt < this.wWJ.getCount() - i))
    {
      AppMethodBeat.o(39723);
      return true;
    }
    AppMethodBeat.o(39723);
    return false;
  }
  
  public final int Ne(int paramInt)
  {
    AppMethodBeat.i(39724);
    int i = this.wWJ.getCount();
    if (paramInt >= i - dBv())
    {
      int j = this.wWD;
      AppMethodBeat.o(39724);
      return j + paramInt - i;
    }
    AppMethodBeat.o(39724);
    return paramInt;
  }
  
  public final int dBv()
  {
    AppMethodBeat.i(39721);
    String[] arrayOfString = this.wWK;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      int k = this.wWJ.aVF(str);
      if (k != -1)
      {
        i = this.wWD;
        AppMethodBeat.o(39721);
        return i - k;
      }
      i += 1;
    }
    AppMethodBeat.o(39721);
    return 0;
  }
  
  public final com.tencent.mm.plugin.brandservice.a.b dBw()
  {
    AppMethodBeat.i(39725);
    com.tencent.mm.plugin.brandservice.a.b localb = (com.tencent.mm.plugin.brandservice.a.b)this.wWE.getValue();
    AppMethodBeat.o(39725);
    return localb;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39726);
    paramInt = paramInt - this.wWD + dBv();
    Object localObject1 = this.wWB.MZ(paramInt);
    Object localObject2;
    Object localObject3;
    switch (f.cpQ[localObject1.ordinal()])
    {
    default: 
      paramView = LayoutInflater.from((Context)this.wWH.getContext()).inflate(2131493610, paramViewGroup, false);
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      break;
    case 1: 
      paramView = LayoutInflater.from((Context)this.wWH.getContext()).inflate(2131493612, paramViewGroup, false);
      this.wWI.cjS();
      AppMethodBeat.o(39726);
      return paramView;
    case 2: 
      localObject1 = this.wWB.getItem(paramInt);
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      localObject1 = (ny)localObject1;
      if ((((ny)localObject1).FIT.ugm == 49) && (dBw().zc(16)))
      {
        localObject2 = dBw();
        localObject3 = ((ny)localObject1).FIY.FGu;
        p.g(localObject3, "bizMessage.AppMsg.DetailInfo");
        Object localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          mn localmn = (mn)((Iterator)localObject4).next();
          ((Collection)localObject3).add(j.listOf(new String[] { localmn.FFW, String.valueOf(localmn.hCZ) }));
        }
        ((com.tencent.mm.plugin.brandservice.a.b)localObject2).j((List)localObject3, 126);
      }
      paramView = new a(this, paramView, paramViewGroup, (ny)localObject1, this.wWG, paramInt / 2).view;
      AppMethodBeat.o(39726);
      return paramView;
    case 3: 
      localObject1 = this.wWH.getContext();
      p.g(localObject1, "ui.context");
      localObject1 = (Context)localObject1;
      localObject2 = this.wWI;
      localObject3 = this.wWB.getItem(paramInt);
      if (localObject3 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ProfileNotifyInfo");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      paramView = new g((Context)localObject1, (ContactWidgetNewBizInfo)localObject2, paramView, paramViewGroup, (cmk)localObject3).view;
      AppMethodBeat.o(39726);
      return paramView;
    }
    paramView = (ViewGroup)paramView;
    paramViewGroup = (TextView)paramView.findViewById(2131297310);
    if (paramViewGroup != null)
    {
      localObject2 = this.wWB;
      localObject1 = aj.getContext();
      ((a)localObject2).MZ(paramInt);
      localObject2 = ((a)localObject2).getItem(paramInt);
      if (localObject2 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      long l = 1000L * ((ny)localObject2).FIT.FZg;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "interpolator", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "bizMsg", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "position", "(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;Landroid/view/View;Landroid/view/ViewGroup;Lcom/tencent/mm/protocal/protobuf/BizMessage;Ljava/util/HashSet;I)V", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "isBizPayOpen", "", "()Z", "setBizPayOpen", "(Z)V", "view", "getView", "()Landroid/view/View;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "fillCommonSlot", "", "container", "detail", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "base", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "fillSingleText", "text", "Lcom/tencent/mm/protocal/protobuf/BizTextMsgInfo;", "Lcom/tencent/mm/protocal/protobuf/CommMsgBaseInfo;", "fillSlotTarget", "fillTopSlot", "commBase", "getPlayId", "", "isPlaying", "playId", "firstNotEmpty", "", "([Ljava/lang/String;)Ljava/lang/String;", "app_release"})
  static final class a
    extends c.h
  {
    Context context;
    Intent intent;
    final View view;
    private boolean wWF;
    private HashSet<Integer> wWG;
    ContactWidgetNewBizInfo wWI;
    
    public a(c paramc, View paramView, ViewGroup paramViewGroup, ny paramny, HashSet<Integer> paramHashSet, int paramInt)
    {
      AppMethodBeat.i(39645);
      this.wWF = true;
      Object localObject1 = paramc.wWH.getContext();
      p.g(localObject1, "interpolator.ui.context");
      this.context = ((Context)localObject1);
      this.wWI = paramc.wWI;
      localObject1 = paramc.wWH.getIntent();
      p.g(localObject1, "interpolator.ui.intent");
      this.intent = ((Intent)localObject1);
      this.wWG = paramHashSet;
      this.wWF = paramc.wWF;
      if (paramView != null) {
        paramHashSet = paramView.getTag();
      }
      Object localObject2;
      int i;
      while (p.i(paramHashSet, paramny))
      {
        localObject2 = paramny.FIY;
        paramHashSet = this;
        localObject1 = paramView;
        if (localObject2 != null)
        {
          localObject2 = ((mo)localObject2).FGu;
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
                localObject1 = (mn)paramHashSet.next();
                p.g(localObject1, "detail");
                if (p.i(a((mn)localObject1), c.a(paramc)))
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
      switch (paramny.FIT.ugm)
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
            paramc = paramny.FIU;
            p.g(paramc, "bizMsg.Text");
            paramny = paramny.FIT;
            p.g(paramny, "bizMsg.BaseInfo");
            paramViewGroup = new c.f(10, c.d.wXd, paramView);
            paramInt = paramny.xbr;
            paramny = this.wWG;
            paramc = paramc.hDa;
            p.g(paramc, "text.Content");
            paramViewGroup.a(paramInt, paramny, paramc);
          }
          j = paramny.FIY.FGu.size();
          if (j <= 1) {
            break label1006;
          }
          paramc = c.d.wXa;
          if (paramny.FIY.FGt.FFT == 0) {
            break label1375;
          }
          paramViewGroup = paramny.FIY.FGu.get(0);
          p.g(paramViewGroup, "bizMsg.AppMsg.DetailInfo[0]");
          paramViewGroup = (mn)paramViewGroup;
          paramHashSet = paramny.FIY.FGt;
          p.g(paramHashSet, "bizMsg.AppMsg.BaseInfo");
          localObject2 = paramny.FIT;
          p.g(localObject2, "bizMsg.BaseInfo");
          localObject1 = c.wWL;
          com.tencent.mm.sdk.platformtools.ad.v(c.access$getTAG$cp(), "fillTopSlot:" + paramViewGroup.FFW);
          localObject1 = new c.f(paramViewGroup.hCZ, paramc, paramView);
          if ((paramViewGroup.hCZ != 8) && (paramViewGroup.hCZ != 10))
          {
            ((c.f)localObject1).wWY = paramViewGroup.FGs;
            ((c.f)localObject1).url = paramViewGroup.FFW;
            String str = paramViewGroup.Title;
            p.g(str, "detail.Title");
            ((c.f)localObject1).setTitle(str);
          }
          if (paramc == c.d.wXd)
          {
            paramc = (CharSequence)paramViewGroup.FFU;
            if ((paramc != null) && (!d.n.n.aE(paramc))) {
              break label1013;
            }
            i = 1;
            if (i == 0) {
              ((MMNeat7extView)((c.f)localObject1).wXE.getValue()).ar((CharSequence)paramViewGroup.FFU);
            }
          }
          paramc = (CharSequence)paramViewGroup.FGl;
          if ((paramc != null) && (!d.n.n.aE(paramc))) {
            break label1019;
          }
          i = 1;
          if (i == 0)
          {
            paramc = ((c.f)localObject1).dBA();
            p.g(paramc, "view.showDescTv");
            paramc.setText((CharSequence)paramViewGroup.FGl);
          }
          paramc = ((c.f)localObject1).dBA();
          if (paramc != null)
          {
            if ((((c.f)localObject1).wWY != 1) || (this.wWF)) {
              break label1025;
            }
            i = 4;
            paramc.setVisibility(i);
          }
          switch (paramViewGroup.hCZ)
          {
          case 6: 
          default: 
            switch (paramViewGroup.hCZ)
            {
            case 8: 
            case 9: 
            default: 
              switch (paramViewGroup.hCZ)
              {
              default: 
                paramc = new String[2];
                paramc[0] = paramViewGroup.FFY;
                paramc[1] = paramViewGroup.FGa;
                ((c.f)localObject1).setImageUrl(J(paramc));
                a((View)((c.f)localObject1).dBB(), paramViewGroup, paramHashSet, paramInt);
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
      paramc = paramny.FIY.FGu.get(i);
      label913:
      label922:
      p.g(paramc, "bizMsg.AppMsg.DetailInfo[i]");
      paramViewGroup = (mn)paramc;
      paramHashSet = paramny.FIY.FGt;
      p.g(paramHashSet, "bizMsg.AppMsg.BaseInfo");
      if (i == j - 1) {}
      for (paramc = c.d.wXc;; paramc = c.d.wXb)
      {
        a(paramView, paramViewGroup, paramHashSet, paramc, paramInt);
        i += 1;
        break label922;
        label1006:
        paramc = c.d.wXd;
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
        paramc = (TextView)((c.f)localObject1).wXz.getValue();
        p.g(paramc, "view.videoDurationTv");
        paramc.setText((CharSequence)com.tencent.mm.ai.m.oi(paramViewGroup.FGk));
        break label804;
        paramc = (TextView)((c.f)localObject1).wXA.getValue();
        p.g(paramc, "view.voiceDurationTv");
        paramc.setText((CharSequence)com.tencent.mm.ai.m.oi(paramViewGroup.FGf));
        break label804;
        if (paramViewGroup.vuf <= 1) {
          break label804;
        }
        paramc = (TextView)((c.f)localObject1).wWV.getValue();
        p.g(paramc, "view.picCntTv");
        paramc.setText((CharSequence)String.valueOf(paramViewGroup.vuf));
        break label804;
        paramc = (CharSequence)paramViewGroup.FFU;
        label1175:
        boolean bool;
        if ((paramc == null) || (d.n.n.aE(paramc)))
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
          ((c.f)localObject1).dBJ().setPadding(0, 0, 0, ((c.e)localObject1).wXh);
        }
        for (;;)
        {
          ((c.f)localObject1).wXG = bool;
          break;
          i = 0;
          break label1175;
          label1220:
          bool = false;
          break label1183;
          label1226:
          ((c.f)localObject1).dBJ().setPadding(((c.e)localObject1).wXk, ((c.e)localObject1).wXj, ((c.e)localObject1).wXk, ((c.e)localObject1).wXh);
        }
        i = ((aah)localObject2).xbr;
        paramc = this.wWG;
        localObject2 = paramViewGroup.Title;
        p.g(localObject2, "detail.Title");
        ((c.f)localObject1).a(i, paramc, (String)localObject2);
        paramc = (CharSequence)paramViewGroup.FGl;
        if ((paramc == null) || (d.n.n.aE(paramc))) {}
        for (i = 1; i == 0; i = 0)
        {
          paramc = ((c.f)localObject1).dBA();
          p.g(paramc, "view.showDescTv");
          paramc.setText((CharSequence)paramViewGroup.FGl);
          break;
        }
        paramc = new String[2];
        paramc[0] = paramViewGroup.FGa;
        paramc[1] = paramViewGroup.FFY;
        break label887;
        label1375:
        paramViewGroup = paramny.FIY.FGu.get(0);
        p.g(paramViewGroup, "bizMsg.AppMsg.DetailInfo[0]");
        paramViewGroup = (mn)paramViewGroup;
        paramHashSet = paramny.FIY.FGt;
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
        if ((localCharSequence == null) || (d.n.n.aE(localCharSequence)))
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
    
    private static String a(mn parammn)
    {
      AppMethodBeat.i(39643);
      parammn = parammn.FFW;
      p.g(parammn, "detail.ContentUrl");
      parammn = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Xl(parammn);
      AppMethodBeat.o(39643);
      return parammn;
    }
    
    private final void a(final View paramView, final mn parammn, final mm parammm, final int paramInt)
    {
      AppMethodBeat.i(39644);
      ImageView localImageView;
      b localb;
      c localc;
      final String str;
      if (parammn.hCZ == 7)
      {
        localImageView = (ImageView)paramView.findViewById(2131297327);
        if (localImageView != null)
        {
          localb = new b(localImageView);
          localc = new c(localImageView);
          str = a(parammn);
          if (!fS(str)) {
            break label121;
          }
          localb.invoke();
        }
      }
      for (;;)
      {
        localImageView.setOnClickListener((View.OnClickListener)new a(localb, str, this, parammn));
        paramView.setOnClickListener((View.OnClickListener)new d(this, parammn, parammm, paramView, paramInt));
        AppMethodBeat.o(39644);
        return;
        label121:
        localc.invoke();
      }
    }
    
    private final void a(ViewGroup paramViewGroup, mn parammn, mm parammm, c.d paramd, int paramInt)
    {
      AppMethodBeat.i(39641);
      c.c localc = c.wWL;
      com.tencent.mm.sdk.platformtools.ad.v(c.access$getTAG$cp(), "fillCommonSlot:" + parammn.FFW);
      paramd = new c.b(parammn.hCZ, paramd, paramViewGroup);
      paramd.wWY = parammn.FGs;
      paramd.url = parammn.FFW;
      paramViewGroup = parammn.Title;
      p.g(paramViewGroup, "detail.Title");
      paramd.setTitle(paramViewGroup);
      paramViewGroup = (CharSequence)parammn.FGl;
      int i;
      if ((paramViewGroup == null) || (d.n.n.aE(paramViewGroup)))
      {
        i = 1;
        if (i == 0)
        {
          paramViewGroup = paramd.dBA();
          p.g(paramViewGroup, "view.showDescTv");
          paramViewGroup.setText((CharSequence)parammn.FGl);
        }
        paramViewGroup = paramd.dBA();
        if (paramViewGroup != null)
        {
          if ((paramd.wWY != 1) || (this.wWF)) {
            break label305;
          }
          i = 4;
          label169:
          paramViewGroup.setVisibility(i);
        }
        if ((parammn.hCZ == 8) && (parammn.vuf > 1))
        {
          paramViewGroup = (TextView)paramd.wWV.getValue();
          p.g(paramViewGroup, "view.picCntTv");
          paramViewGroup.setText((CharSequence)String.valueOf(parammn.vuf));
        }
        switch (parammn.hCZ)
        {
        default: 
          paramViewGroup = new String[2];
          paramViewGroup[0] = parammn.FFZ;
          paramViewGroup[1] = parammn.FFY;
        }
      }
      for (;;)
      {
        paramd.setImageUrl(J(paramViewGroup));
        a((View)paramd.dBB(), parammn, parammm, paramInt);
        AppMethodBeat.o(39641);
        return;
        i = 0;
        break;
        label305:
        i = 0;
        break label169;
        paramViewGroup = new String[2];
        paramViewGroup[0] = parammn.FFY;
        paramViewGroup[1] = parammn.FFZ;
      }
    }
    
    private static boolean fS(String paramString)
    {
      AppMethodBeat.i(39642);
      com.tencent.mm.az.f localf = com.tencent.mm.az.a.aJJ();
      if (localf != null)
      {
        if ((p.i(localf.ihg, paramString)) && (localf.ihe == 0) && (com.tencent.mm.az.a.aJG()))
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
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$1$3"})
    static final class a
      implements View.OnClickListener
    {
      a(c.a.b paramb, String paramString, c.a parama, mn parammn) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(39634);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        this.wWM.invoke();
        localObject = new e.g();
        e.h localh = new e.h();
        localh.Epf = str;
        localh.url = parammn.FFW;
        localh.title = parammn.Title;
        localh.hDA = "";
        localh.playUrl = parammn.FGg;
        localh.coverUrl = parammn.FFY;
        ((e.g)localObject).KaI = localh;
        paramView.setTag(localObject);
        com.tencent.mm.ui.chatting.r.gj(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39634);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"drawPlaying", "", "invoke"})
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
        this.tKk.setImageResource(2131231272);
        Object localObject = this.tKk.getDrawable();
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
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"drawPlay", "", "invoke"})
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
        this.tKk.setImageResource(2131231271);
        AppMethodBeat.o(39638);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(c.a parama, mn parammn, mm parammm, View paramView, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(39639);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        paramView = c.wWL;
        com.tencent.mm.sdk.platformtools.ad.i(c.access$getTAG$cp(), "onClick jump to url:%s", new Object[] { parammn.FFW });
        int i = this.wWO.intent.getIntExtra("KOpenArticleSceneFromScene", -1);
        paramView = new Intent();
        localObject1 = com.tencent.mm.ai.m.d(parammn.FFW, 126, i, 0);
        paramView.putExtra("rawUrl", (String)localObject1);
        paramView.putExtra("useJs", true);
        paramView.putExtra("vertical_scroll", true);
        paramView.putExtra("geta8key_scene", 3);
        Object localObject2 = this.wWO.wWI.dBn();
        p.g(localObject2, "widget.contact");
        paramView.putExtra("geta8key_username", ((am)localObject2).getUsername());
        localObject2 = paramView.getStringExtra("prePublishId");
        int j;
        int k;
        if (!bt.isNullOrNil((String)localObject2))
        {
          paramView.putExtra("KPublisherId", (String)localObject2);
          paramView.putExtra("prePublishId", (String)localObject2);
          paramView.putExtra("preUsername", paramView.getStringExtra("preUsername"));
          paramView.putExtra("preChatName", paramView.getStringExtra("preChatName"));
          paramView.putExtra("preChatTYPE", paramView.getIntExtra("preChatTYPE", 0));
          i = paramView.getIntExtra("KOpenArticleSceneFromScene", 10000);
          if (parammn.hCZ == 5)
          {
            localObject2 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
            p.g(localObject2, "MMKernel.service(IBrandService::class.java)");
            if (((com.tencent.mm.plugin.brandservice.a.b)localObject2).bNg())
            {
              paramView.putExtra(e.b.IUn, 126);
              paramView.putExtra(e.b.IUo, i);
              paramView.putExtra("biz_video_session_id", y.getSessionId());
              localObject2 = new x();
              ((x)localObject2).hDf = paramView.getStringExtra("KPublisherId");
              Object localObject3 = this.wWO.wWI.dBn();
              p.g(localObject3, "widget.contact");
              ((x)localObject2).doK = ((am)localObject3).getUsername();
              localObject3 = this.wWO.wWI.dBn();
              p.g(localObject3, "widget.contact");
              ((x)localObject2).hDe = ((am)localObject3).adu();
              ((x)localObject2).hDg.url = ((String)localObject1);
              ((x)localObject2).hDg.title = parammn.Title;
              ((x)localObject2).hDg.hDo = "detail.videoDigest";
              ((x)localObject2).hDg.hDm = parammn.FFY;
              ((x)localObject2).hDg.type = parammn.hCZ;
              ((x)localObject2).hDg.time = parammm.CreateTime;
              ((x)localObject2).hDg.hDq = parammn.FGk;
              ((x)localObject2).hDg.videoWidth = parammn.FGi;
              ((x)localObject2).hDg.videoHeight = parammn.FGj;
              ((x)localObject2).hDg.hzm = parammn.FGh;
              ((x)localObject2).t(paramView);
              localObject2 = c.wWL;
              com.tencent.mm.sdk.platformtools.ad.i(c.access$getTAG$cp(), "jump to native video");
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
          if ((!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(6)) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.wWO.context, (String)localObject1, parammn.hCZ, 126, i, paramView))) {
            break label876;
          }
          paramView = c.wWL;
          com.tencent.mm.sdk.platformtools.ad.i(c.access$getTAG$cp(), "jump to TmplWebview");
        }
        for (;;)
        {
          paramView = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.wXZ;
          paramView = this.wWO.wWI.dBn();
          p.g(paramView, "widget.contact");
          paramView = paramView.getUsername();
          p.g(paramView, "widget.contact.username");
          long l = this.wWO.wWI.TD();
          i = parammm.FFS;
          j = parammn.FFV;
          k = parammn.hCZ;
          int m = paramInt;
          int n = parammm.CreateTime;
          int i1 = this.wWO.wWI.dBq();
          p.h(paramView, "userName");
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a(com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.wXY, paramView, l, i, j, k, m, n, i1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(39639);
          return;
          paramView.putExtra("prePublishId", "brand_profile");
          paramView.putExtra("KPublisherId", "brand_profile");
          break;
          label876:
          com.tencent.mm.bs.d.b(this.wWO.context, "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$CommonSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "picCntTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "Lkotlin/Lazy;", "picInfo", "Landroid/support/constraint/ConstraintLayout;", "getPicInfo", "()Landroid/support/constraint/ConstraintLayout;", "picInfo$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "titleTv$delegate", "url", "getUrl", "setUrl", "weakPicInfo", "Ljava/lang/ref/WeakReference;", "getWeakPicInfo", "()Ljava/lang/ref/WeakReference;", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "app_release"})
  static final class b
    extends c.e
  {
    private String title;
    String url;
    private final int wWS;
    private final d.f wWT;
    private final WeakReference<ConstraintLayout> wWU;
    final d.f wWV;
    private final d.f wWW;
    private final d.f wWX;
    int wWY;
    
    public b(int paramInt, c.d paramd, ViewGroup paramViewGroup)
    {
      super(paramd, paramViewGroup);
      AppMethodBeat.i(39658);
      this.wWS = 2131233660;
      this.wWT = d.g.O((d.g.a.a)new b(this));
      this.wWU = new WeakReference((ConstraintLayout)this.wWT.getValue());
      this.wWV = d.g.O((d.g.a.a)new a(this));
      this.wWW = d.g.O((d.g.a.a)new c(this));
      this.wWX = d.g.O((d.g.a.a)new d(this));
      this.url = "";
      this.title = "";
      AppMethodBeat.o(39658);
    }
    
    protected final void a(View paramView, c.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(39653);
      p.h(paramView, "container");
      p.h(paramd, "slotType");
      switch (d.cpQ[paramd.ordinal()])
      {
      default: 
        localObject = paramView.findViewById(2131297330);
        p.g(localObject, "container.findViewById<F…id.biz_slot_voice_layout)");
        ((FrameLayout)localObject).setVisibility(8);
        switch (this.hzh)
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
    
    public final TextView dBA()
    {
      AppMethodBeat.i(39656);
      TextView localTextView = (TextView)this.wWW.getValue();
      AppMethodBeat.o(39656);
      return localTextView;
    }
    
    protected final void dBx()
    {
      AppMethodBeat.i(39654);
      if (this.wWU == null)
      {
        AppMethodBeat.o(39654);
        return;
      }
      ConstraintLayout localConstraintLayout = (ConstraintLayout)this.wWU.get();
      if (localConstraintLayout != null)
      {
        localConstraintLayout.setBackgroundResource(2131231208);
        AppMethodBeat.o(39654);
        return;
      }
      AppMethodBeat.o(39654);
    }
    
    protected final float[] dBy()
    {
      AppMethodBeat.i(39655);
      float[] arrayOfFloat = d.a.e.b(new Float[] { Float.valueOf(bq(1.0F)), Float.valueOf(bq(1.0F)), Float.valueOf(bq(1.0F)), Float.valueOf(bq(1.0F)) });
      AppMethodBeat.o(39655);
      return arrayOfFloat;
    }
    
    protected final int dBz()
    {
      return this.wWS;
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(39657);
      p.h(paramString, "value");
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.wWX.getValue();
      p.g(localMMNeat7extView, "titleTv");
      a(localMMNeat7extView, paramString, this.wWY, this.url, 5);
      AppMethodBeat.o(39657);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<TextView>
    {
      a(c.b paramb)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/support/constraint/ConstraintLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<ConstraintLayout>
    {
      b(c.b paramb)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c
      extends d.g.b.q
      implements d.g.a.a<TextView>
    {
      c(c.b paramb)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "", "(Ljava/lang/String;I)V", "TOP", "COMMON", "BOTTOM", "SINGLE", "app_release"})
  static enum d
  {
    static
    {
      AppMethodBeat.i(39659);
      d locald1 = new d("TOP", 0);
      wXa = locald1;
      d locald2 = new d("COMMON", 1);
      wXb = locald2;
      d locald3 = new d("BOTTOM", 2);
      wXc = locald3;
      d locald4 = new d("SINGLE", 3);
      wXd = locald4;
      wXe = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(39659);
    }
    
    private d() {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "audioPadding", "getAudioPadding", "()I", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "imageDefaultRes", "getImageDefaultRes", "imageIv", "Landroid/widget/ImageView;", "getImageIv", "()Landroid/widget/ImageView;", "imageIv$delegate", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "value", "", "imageUrl", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "item", "getItem", "()Landroid/view/ViewGroup;", "item$delegate", "getItemShowType", "largePading", "getLargePading", "listPadding", "getListPadding", "normalPading", "getNormalPading", "getSlotType", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "smallPadding", "getSmallPadding", "dpToPixel", "", "getDpToPixel", "(F)F", "resFromRaw", "getResFromRaw", "(I)F", "resToPixel", "getResToPixel", "(I)I", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "onImageLoadFinish", "onImageLoadStart", "setNeatText", "neatText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "isPayMsg", "url", "scene", "app_release"})
  static class e
  {
    String hym;
    final int hzh;
    private final d.f rUo;
    private final int wWS;
    private final d.f wXf;
    private final d.f wXg;
    final int wXh;
    private final int wXi;
    final int wXj;
    final int wXk;
    private final int wXl;
    private final float[] wXm;
    final c.d wXn;
    
    public e(int paramInt, c.d paramd, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39679);
      this.hzh = paramInt;
      this.wXn = paramd;
      this.wXf = d.g.O((d.g.a.a)new e(this, paramViewGroup));
      this.wXg = d.g.O((d.g.a.a)new b(this));
      this.rUo = d.g.O((d.g.a.a)new a(this));
      this.wXh = ((int)bq(36.0F));
      this.wXi = aj.getResources().getDimensionPixelSize(2131165489);
      this.wXj = aj.getResources().getDimensionPixelSize(2131165516);
      this.wXk = aj.getResources().getDimensionPixelSize(2131165480);
      this.wXl = aj.getResources().getDimensionPixelSize(2131165568);
      this.wXm = d.a.e.b(new Float[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) });
      this.wWS = 2131100141;
      this.hym = "";
      AppMethodBeat.o(39679);
    }
    
    protected static float bq(float paramFloat)
    {
      AppMethodBeat.i(39678);
      Resources localResources = aj.getResources();
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
      switch (e.cpQ[paramd.ordinal()])
      {
      default: 
        AppMethodBeat.o(39674);
        return;
      case 1: 
        paramView.setPadding(this.wXk, this.wXl, this.wXk, 0);
        if (paramBoolean) {}
        for (i = 2131231235;; i = 2131231233)
        {
          paramView.setBackgroundResource(i);
          AppMethodBeat.o(39674);
          return;
        }
      case 2: 
        paramView.setPadding(this.wXk, this.wXl, this.wXk, 0);
        i = 2131231229;
      }
      for (;;)
      {
        paramView.setBackgroundResource(i);
        break;
        paramView.setPadding(this.wXk, this.wXl, this.wXk, this.wXk);
        i = 2131231228;
        continue;
        paramView.setPadding(this.wXk, this.wXl, this.wXk, this.wXl);
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
      if ((this.hzh == 0) && (paramInt1 == 1)) {}
      for (;;)
      {
        com.tencent.mm.plugin.brandservice.b.a locala = com.tencent.mm.plugin.brandservice.b.a.nWn;
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
    
    public final ViewGroup dBB()
    {
      AppMethodBeat.i(39670);
      ViewGroup localViewGroup = (ViewGroup)this.wXf.getValue();
      AppMethodBeat.o(39670);
      return localViewGroup;
    }
    
    final ImageView dBC()
    {
      AppMethodBeat.i(39671);
      ImageView localImageView = (ImageView)this.wXg.getValue();
      AppMethodBeat.o(39671);
      return localImageView;
    }
    
    protected void dBD() {}
    
    protected void dBx() {}
    
    protected float[] dBy()
    {
      return this.wXm;
    }
    
    protected int dBz()
    {
      return this.wWS;
    }
    
    protected final Context getContext()
    {
      AppMethodBeat.i(39673);
      Context localContext = (Context)this.rUo.getValue();
      AppMethodBeat.o(39673);
      return localContext;
    }
    
    public final void setImageUrl(final String paramString)
    {
      AppMethodBeat.i(39677);
      p.h(paramString, "value");
      if (d.n.n.aE((CharSequence)paramString)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(39677);
        return;
      }
      paramString = com.tencent.mm.api.b.s(paramString, 2);
      p.g(paramString, "BizImageStrategy.getUrl(…rategy.SCENE_BIZ_PROFILE)");
      this.hym = paramString;
      paramString = c.wWL;
      com.tencent.mm.sdk.platformtools.ad.v(c.access$getTAG$cp(), "imageUrl:" + this.hym);
      paramString = dBy();
      final String str = this.hym;
      Object localObject1 = new com.tencent.mm.aw.a.a.c.a().aIY();
      Object localObject2 = new StringBuilder("radius_");
      Object localObject3 = Arrays.toString(paramString);
      p.g(localObject3, "java.util.Arrays.toString(this)");
      localObject1 = ((com.tencent.mm.aw.a.a.c.a)localObject1).FG((String)localObject3).pI(dBz()).a((com.tencent.mm.aw.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.aw.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).FE(com.tencent.mm.pluginsdk.model.r.aLC(this.hym)).aJc();
      localObject2 = new d(this);
      localObject3 = new com.tencent.mm.pluginsdk.ui.applet.m(3, -1, -1, paramString, (m.a)localObject2);
      ((com.tencent.mm.pluginsdk.ui.applet.m)localObject3).ax((Runnable)new c(this, str, (com.tencent.mm.aw.a.a.c)localObject1, paramString, (d)localObject2));
      com.tencent.mm.aw.q.aIJ().a(str, dBC(), (com.tencent.mm.aw.a.a.c)localObject1, (com.tencent.mm.aw.a.c.h)localObject3);
      AppMethodBeat.o(39677);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<Context>
    {
      a(c.e parame)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<ImageView>
    {
      b(c.e parame)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel$imageUrl$imageLoaderListener$1$1"})
    static final class c
      implements Runnable
    {
      c(c.e parame, String paramString, com.tencent.mm.aw.a.a.c paramc, float[] paramArrayOfFloat, c.e.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(39665);
        com.tencent.mm.aw.a.a locala = com.tencent.mm.aw.q.aIJ();
        String str = str;
        ImageView localImageView1 = this.wXo.dBC();
        com.tencent.mm.aw.a.a.c localc = this.wXp;
        ImageView localImageView2 = this.wXo.dBC();
        p.g(localImageView2, "imageIv");
        int i = localImageView2.getMeasuredWidth();
        localImageView2 = this.wXo.dBC();
        p.g(localImageView2, "imageIv");
        locala.a(str, localImageView1, localc, (com.tencent.mm.aw.a.c.h)new com.tencent.mm.pluginsdk.ui.applet.m(3, i, localImageView2.getMeasuredHeight(), paramString, (m.a)this.wXr));
        AppMethodBeat.o(39665);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel$imageUrl$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
    public static final class d
      implements m.a
    {
      public final void onFinish()
      {
        AppMethodBeat.i(39666);
        c.c localc = c.wWL;
        com.tencent.mm.sdk.platformtools.ad.v(c.access$getTAG$cp(), "imageUrl onFinish:" + this.wXo.hym);
        this.wXo.dBx();
        AppMethodBeat.o(39666);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(39667);
        c.c localc = c.wWL;
        com.tencent.mm.sdk.platformtools.ad.v(c.access$getTAG$cp(), "imageUrl onStart:" + this.wXo.hym);
        this.wXo.dBD();
        AppMethodBeat.o(39667);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$TopSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "collapseTextLayout", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "getCollapseTextLayout", "()Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "collapseTextLayout$delegate", "Lkotlin/Lazy;", "descMask", "Landroid/view/View;", "getDescMask", "()Landroid/view/View;", "descMask$delegate", "digestTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getDigestTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "digestTv$delegate", "value", "", "hasAudioDesc", "getHasAudioDesc", "()Z", "setHasAudioDesc", "(Z)V", "hasDesc", "setHasDesc", "hasSingleInfo", "hasTitle", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "isSingleImage", "picCntTv", "Landroid/widget/TextView;", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "singleDescLayout", "getSingleDescLayout", "singleDescLayout$delegate", "singleTitleTv", "getSingleTitleTv", "singleTitleTv$delegate", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleDescViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "titleTv", "getTitleTv", "titleTv$delegate", "topMask", "Landroid/widget/ImageView;", "getTopMask", "()Landroid/widget/ImageView;", "topMask$delegate", "url", "getUrl", "setUrl", "videPlayImg", "getVidePlayImg", "videPlayImg$delegate", "videoDurationTv", "getVideoDurationTv", "videoDurationTv$delegate", "voiceDurationTv", "getVoiceDurationTv", "voiceDurationTv$delegate", "fillBackground", "", "selector", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "onImageLoadStart", "setText", "id", "expandSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "text", "setTitleDescTextColor", "color", "app_release"})
  static final class f
    extends c.e
  {
    private String title;
    String url;
    final d.f wWV;
    private final d.f wWW;
    private final d.f wWX;
    int wWY;
    final d.f wXA;
    private final d.f wXB;
    private final d.f wXC;
    private final d.f wXD;
    final d.f wXE;
    private final d.f wXF;
    boolean wXG;
    private boolean wXt;
    boolean wXu;
    boolean wXv;
    ArrayList<View> wXw;
    private final d.f wXx;
    private final d.f wXy;
    final d.f wXz;
    
    public f(final int paramInt, c.d paramd, ViewGroup paramViewGroup)
    {
      super(paramd, paramViewGroup);
      AppMethodBeat.i(39713);
      this.url = "";
      this.wXw = new ArrayList();
      this.wXx = d.g.O((d.g.a.a)new l(this));
      this.wXy = d.g.O((d.g.a.a)new b(this));
      this.wWW = d.g.O((d.g.a.a)new h(this));
      this.wXz = d.g.O((d.g.a.a)new n(this));
      this.wXA = d.g.O((d.g.a.a)new o(this));
      this.wWV = d.g.O((d.g.a.a)new e(this));
      this.wWX = d.g.O((d.g.a.a)new k(this, paramInt));
      this.wXB = d.g.O((d.g.a.a)new m(this));
      this.wXC = d.g.O((d.g.a.a)new i(this));
      this.wXD = d.g.O((d.g.a.a)new j(this));
      this.wXE = d.g.O((d.g.a.a)new c(this));
      this.wXF = d.g.O((d.g.a.a)new a(this));
      this.title = "";
      AppMethodBeat.o(39713);
    }
    
    private final boolean dBF()
    {
      return (this.wXn == c.d.wXd) && (!this.wXv);
    }
    
    private final ImageView dBG()
    {
      AppMethodBeat.i(39702);
      ImageView localImageView = (ImageView)this.wXx.getValue();
      AppMethodBeat.o(39702);
      return localImageView;
    }
    
    private final MMNeat7extView dBH()
    {
      AppMethodBeat.i(39704);
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.wWX.getValue();
      AppMethodBeat.o(39704);
      return localMMNeat7extView;
    }
    
    private final ImageView dBI()
    {
      AppMethodBeat.i(39705);
      ImageView localImageView = (ImageView)this.wXB.getValue();
      AppMethodBeat.o(39705);
      return localImageView;
    }
    
    private MMCollapsibleTextView dBK()
    {
      AppMethodBeat.i(39707);
      MMCollapsibleTextView localMMCollapsibleTextView = (MMCollapsibleTextView)this.wXF.getValue();
      AppMethodBeat.o(39707);
      return localMMCollapsibleTextView;
    }
    
    final void Nf(int paramInt)
    {
      AppMethodBeat.i(39712);
      Iterator localIterator = ((Iterable)this.wXw).iterator();
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
      MMCollapsibleTextView localMMCollapsibleTextView = dBK();
      p.g(localMMCollapsibleTextView, "collapseTextLayout");
      paramString = k.g(localMMCollapsibleTextView.getContext(), (CharSequence)paramString, (int)dBK().getTextSize());
      localMMCollapsibleTextView = dBK();
      if (!paramHashSet.contains(Integer.valueOf(paramInt))) {}
      for (boolean bool = true;; bool = false)
      {
        localMMCollapsibleTextView.setCollapsed(bool);
        localMMCollapsibleTextView = dBK();
        p.g(paramString, "text");
        localMMCollapsibleTextView.setText((CharSequence)paramString);
        if (!(dBK().getContentText() instanceof MMNeat7extView)) {
          break label191;
        }
        paramString = dBK().getContentText();
        if (paramString != null) {
          break;
        }
        paramHashSet = new v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(39709);
        throw paramHashSet;
      }
      paramString = (MMNeat7extView)paramString;
      dBK().setOnTextTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.g((NeatTextView)paramString, new com.tencent.mm.pluginsdk.ui.span.n(paramString.getContext())));
      label191:
      dBK().setOnCollapse((d.g.a.a)new c.f.f(paramHashSet, paramInt));
      dBK().setOnExpand((d.g.a.a)new c.f.g(paramHashSet, paramInt));
      AppMethodBeat.o(39709);
    }
    
    protected final void a(View paramView, c.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(39698);
      p.h(paramView, "container");
      p.h(paramd, "slotType");
      switch (this.hzh)
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
        if (paramd == c.d.wXa)
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
      switch (this.hzh)
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
        dBE();
        i = 2131298602;
        continue;
        i = 2131298603;
        continue;
        i = 2131298600;
      }
    }
    
    public final TextView dBA()
    {
      AppMethodBeat.i(39703);
      TextView localTextView = (TextView)this.wWW.getValue();
      AppMethodBeat.o(39703);
      return localTextView;
    }
    
    protected final void dBD()
    {
      AppMethodBeat.i(39710);
      com.tencent.mm.ad.c.g((d.g.a.a)new d(this));
      AppMethodBeat.o(39710);
    }
    
    final void dBE()
    {
      AppMethodBeat.i(39701);
      this.wXt = true;
      if (this.hzh == 5)
      {
        Object localObject = dBI();
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
          ImageView localImageView = dBI();
          p.g(localImageView, "videPlayImg");
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(39701);
    }
    
    final View dBJ()
    {
      AppMethodBeat.i(39706);
      View localView = (View)this.wXC.getValue();
      AppMethodBeat.o(39706);
      return localView;
    }
    
    protected final void dBx()
    {
      AppMethodBeat.i(39711);
      Object localObject = getContext();
      p.g(localObject, "context");
      Nf(((Context)localObject).getResources().getColor(2131101182));
      if (this.wXt)
      {
        localObject = (View)this.wXy.getValue();
        if (!dBF()) {
          break label113;
        }
        if (this.wXu)
        {
          i = 2131233666;
          ((View)localObject).setBackgroundResource(i);
        }
      }
      else
      {
        localObject = dBG();
        if (this.wXn != c.d.wXa) {
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
        if (this.wXu)
        {
          i = 2131233664;
          break;
        }
        i = 2131233663;
        break;
      }
    }
    
    protected final float[] dBy()
    {
      AppMethodBeat.i(39699);
      if (dBF())
      {
        arrayOfFloat = d.a.e.b(new Float[] { Float.valueOf(bq(8.0F)), Float.valueOf(bq(8.0F)), Float.valueOf(bq(8.0F)), Float.valueOf(bq(8.0F)) });
        AppMethodBeat.o(39699);
        return arrayOfFloat;
      }
      float[] arrayOfFloat = d.a.e.b(new Float[] { Float.valueOf(bq(8.0F)), Float.valueOf(bq(8.0F)), Float.valueOf(0.0F), Float.valueOf(0.0F) });
      AppMethodBeat.o(39699);
      return arrayOfFloat;
    }
    
    protected final int dBz()
    {
      AppMethodBeat.i(39700);
      if (dBF())
      {
        AppMethodBeat.o(39700);
        return 2131233661;
      }
      AppMethodBeat.o(39700);
      return 2131233662;
    }
    
    public final void setTitle(String paramString)
    {
      int i = 4;
      AppMethodBeat.i(39708);
      p.h(paramString, "value");
      MMNeat7extView localMMNeat7extView;
      int j;
      String str;
      switch (this.hzh)
      {
      default: 
        if (this.wXn == c.d.wXd)
        {
          localMMNeat7extView = (MMNeat7extView)this.wXD.getValue();
          p.g(localMMNeat7extView, "if (slotType == SlotType…ingleTitleTv else titleTv");
          j = this.wWY;
          str = this.url;
          if (this.wXn != c.d.wXd) {
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
        localMMNeat7extView = dBH();
        p.g(localMMNeat7extView, "titleTv");
        a(localMMNeat7extView, paramString, this.wWY, this.url, 4);
        paramString = dBG();
        if (this.wXn == c.d.wXa) {}
        for (i = 2131231243;; i = 2131231241)
        {
          paramString.setBackgroundResource(i);
          AppMethodBeat.o(39708);
          return;
        }
        localMMNeat7extView = dBH();
        break;
        label188:
        i = 41;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<MMCollapsibleTextView>
    {
      a(c.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<View>
    {
      b(c.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c
      extends d.g.b.q
      implements d.g.a.a<MMNeat7extView>
    {
      c(c.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      d(c.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e
      extends d.g.b.q
      implements d.g.a.a<TextView>
    {
      e(c.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h
      extends d.g.b.q
      implements d.g.a.a<TextView>
    {
      h(c.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i
      extends d.g.b.q
      implements d.g.a.a<View>
    {
      i(c.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j
      extends d.g.b.q
      implements d.g.a.a<MMNeat7extView>
    {
      j(c.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k
      extends d.g.b.q
      implements d.g.a.a<MMNeat7extView>
    {
      k(c.f paramf, int paramInt)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l
      extends d.g.b.q
      implements d.g.a.a<ImageView>
    {
      l(c.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m
      extends d.g.b.q
      implements d.g.a.a<ImageView>
    {
      m(c.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class n
      extends d.g.b.q
      implements d.g.a.a<TextView>
    {
      n(c.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "context", "Landroid/content/Context;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "position", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Landroid/view/View;Landroid/view/ViewGroup;ILcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;)V", "coverSize", "radius", "", "view", "getView", "()Landroid/view/View;", "fillVideoChannel", "", "fillVideoItem", "videoItem", "Lcom/tencent/mm/protocal/protobuf/NotifyVideoInfo;", "itemView", "getDurationText", "", "app_release"})
  static final class g
    extends c.h
  {
    final Context context;
    private float radius;
    final View view;
    final ContactWidgetNewBizInfo wWI;
    private int wXK;
    
    public g(final Context paramContext, ContactWidgetNewBizInfo paramContactWidgetNewBizInfo, View paramView, ViewGroup paramViewGroup, final cmk paramcmk)
    {
      AppMethodBeat.i(169914);
      this.radius = 2.0F;
      this.context = paramContext;
      this.wWI = paramContactWidgetNewBizInfo;
      this.wXK = com.tencent.mm.cc.a.fromDPToPix(paramContext, 64);
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
        if (!p.i(paramContactWidgetNewBizInfo, paramcmk)) {
          break label697;
        }
        this.view = paramView;
        paramContactWidgetNewBizInfo = (TextView)this.view.findViewById(2131306337);
        paramContext = (CharSequence)paramcmk.HfN;
        if ((paramContext != null) && (paramContext.length() != 0)) {
          break label735;
        }
        i = 1;
        if (i != 0) {
          break label741;
        }
        paramContext = (CharSequence)paramcmk.HfN;
        paramContactWidgetNewBizInfo.setText(paramContext);
        paramContext = com.tencent.mm.plugin.brandservice.ui.b.d.osr;
        com.tencent.mm.plugin.brandservice.ui.b.d.i(paramContactWidgetNewBizInfo);
        paramContactWidgetNewBizInfo = (TextView)this.view.findViewById(2131306336);
        paramContext = (CharSequence)paramcmk.dxD;
        if ((paramContext != null) && (paramContext.length() != 0)) {
          break label769;
        }
        i = 1;
        if (i != 0) {
          break label775;
        }
        paramContext = (CharSequence)paramcmk.dxD;
        paramContactWidgetNewBizInfo.setText(paramContext);
        paramContext = paramcmk.HfM;
        paramContactWidgetNewBizInfo = c.wWL;
        com.tencent.mm.sdk.platformtools.ad.v(c.access$getTAG$cp(), "alvinluo fillVideoChannel size: %d", new Object[] { Integer.valueOf(paramContext.size()) });
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
          paramViewGroup = (ccx)paramView.next();
        } while (paramViewGroup == null);
        paramContext = c.wWL;
        com.tencent.mm.sdk.platformtools.ad.d(c.access$getTAG$cp(), "alvinluo videoItem url: %s, duration: %d", new Object[] { paramViewGroup.GXb, Integer.valueOf(paramViewGroup.duration) });
        localObject1 = LayoutInflater.from(this.context).inflate(2131493622, null, false);
        paramContactWidgetNewBizInfo.addView((View)localObject1);
        p.g(localObject1, "itemView");
        paramContext = ((View)localObject1).findViewById(2131306332);
        p.g(paramContext, "itemView.findViewById<Te…iew>(R.id.video_duration)");
        localObject2 = (TextView)paramContext;
        i = paramViewGroup.duration / 3600;
        j = (paramViewGroup.duration - i * 3600) / 60;
        k = paramViewGroup.duration % 60;
        paramContext = c.wWL;
        com.tencent.mm.sdk.platformtools.ad.i(c.access$getTAG$cp(), "alvinluo getDurationText " + i + ':' + j + ':' + k);
        if (i <= 0) {
          break label803;
        }
        paramContext = d.g.b.ad.MLZ;
        paramContext = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }, 3));
        p.g(paramContext, "java.lang.String.format(format, *args)");
      }
      for (;;)
      {
        ((TextView)localObject2).setText((CharSequence)paramContext);
        paramContext = (ImageView)((View)localObject1).findViewById(2131306321);
        paramViewGroup = com.tencent.mm.api.b.s(paramViewGroup.GXb, 2);
        localObject1 = new com.tencent.mm.aw.a.a.c.a().aIY().dh(this.wXK, this.wXK).FG("radius_" + this.radius).pI(2131233660).a((com.tencent.mm.aw.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.aw.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).FE(com.tencent.mm.pluginsdk.model.r.aLC(paramViewGroup)).aJc();
        localObject2 = new b(paramViewGroup, paramContext);
        localObject2 = new com.tencent.mm.pluginsdk.ui.applet.m(3, this.wXK, this.wXK, true, true, this.radius, (m.a)localObject2);
        com.tencent.mm.aw.q.aIJ().a(paramViewGroup, paramContext, (com.tencent.mm.aw.a.a.c)localObject1, (com.tencent.mm.aw.a.c.h)localObject2);
        break label261;
        paramContactWidgetNewBizInfo = null;
        break;
        label697:
        paramContext = LayoutInflater.from(paramContext).inflate(2131493621, paramViewGroup, false);
        p.g(paramContext, "LayoutInflater.from(cont…o_channel, parent, false)");
        this.view = paramContext;
        this.view.setTag(paramcmk);
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
        paramContext = d.g.b.ad.MLZ;
        paramContext = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(j), Integer.valueOf(k) }, 2));
        p.g(paramContext, "java.lang.String.format(format, *args)");
      }
      label848:
      paramContext = this.view.findViewById(2131304246);
      if (paramContext != null)
      {
        paramContext.setOnClickListener((View.OnClickListener)new a(this, paramcmk));
        AppMethodBeat.o(169914);
        return;
      }
      AppMethodBeat.o(169914);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(c.g paramg, cmk paramcmk) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(169911);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder$fillVideoChannel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramView = (CharSequence)paramcmk.ozD;
        if ((paramView == null) || (paramView.length() == 0)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            paramView = new Intent();
            paramView.putExtra("rawUrl", paramcmk.ozD);
            localObject = this.wXL.wWI.dBn();
            p.g(localObject, "widget.contact");
            paramView.putExtra("geta8key_username", ((am)localObject).getUsername());
            com.tencent.mm.bs.d.b(this.wXL.context, "webview", ".ui.tools.WebViewUI", paramView);
            paramView = this.wXL.wWI.dBn();
            p.g(paramView, "widget.contact");
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.b(paramView.getUsername(), 1402, this.wXL.wWI.dBq(), this.wXL.wWI.TD());
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder$fillVideoChannel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169911);
          return;
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder$fillVideoItem$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
    public static final class b
      implements m.a
    {
      b(String paramString, ImageView paramImageView) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(169912);
        c.c localc = c.wWL;
        com.tencent.mm.sdk.platformtools.ad.v(c.access$getTAG$cp(), "imageUrl onFinish:" + this.wXN);
        paramContext.setBackgroundResource(2131233299);
        AppMethodBeat.o(169912);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(169913);
        c.c localc = c.wWL;
        com.tencent.mm.sdk.platformtools.ad.v(c.access$getTAG$cp(), "imageUrl onStart:" + this.wXN);
        AppMethodBeat.o(169913);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.c
 * JD-Core Version:    0.7.0.1
 */