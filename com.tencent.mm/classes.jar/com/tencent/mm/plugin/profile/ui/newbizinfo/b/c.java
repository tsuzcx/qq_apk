package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.LayoutParams;
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
import com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.cty;
import com.tencent.mm.protocal.protobuf.dey;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.qe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.h.a;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter$Interpolator;", "ui", "Lcom/tencent/mm/ui/MMActivity;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "orginAdapter", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;", "footer", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;[Ljava/lang/String;)V", "adapter", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;)V", "brandService", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "getBrandService", "()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "brandService$delegate", "Lkotlin/Lazy;", "changedPlayId", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExpandSet", "()Ljava/util/HashSet;", "getFooter", "()[Ljava/lang/String;", "[Ljava/lang/String;", "isBizPayOpen", "", "()Z", "originalCount", "getOriginalCount", "()I", "setOriginalCount", "(I)V", "getUi", "()Lcom/tencent/mm/ui/MMActivity;", "getWidget", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "getCount", "getFooterCount", "getItem", "", "position", "getRelativePosition", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "isInterpolated", "onMusicStateChanged", "", "event", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "preloadPage", "fromPosition", "toPosition", "update", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "notifyInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "BizMsgViewHolder", "CommonSlotViewModel", "Companion", "SlotType", "SlotViewModel", "TopSlotViewModel", "VideoChannelViewHolder", "ViewHolder", "app_release"})
public final class c
  implements h.a
{
  public static final c.c BkE;
  private static final String TAG = "MicroMsg.NewBizInfoAdapter";
  final MMActivity BkA;
  public final ContactWidgetNewBizInfo BkB;
  public final com.tencent.mm.ui.base.preference.h BkC;
  private final String[] BkD;
  public a Bku;
  public String Bkv;
  public int Bkw;
  private final kotlin.f Bkx;
  final boolean Bky;
  private final HashSet<Integer> Bkz;
  
  static
  {
    AppMethodBeat.i(39720);
    BkE = new c.c((byte)0);
    TAG = "MicroMsg.NewBizInfoAdapter";
    AppMethodBeat.o(39720);
  }
  
  public c(MMActivity paramMMActivity, ContactWidgetNewBizInfo paramContactWidgetNewBizInfo, com.tencent.mm.ui.base.preference.h paramh, String[] paramArrayOfString)
  {
    AppMethodBeat.i(39727);
    this.BkA = paramMMActivity;
    this.BkB = paramContactWidgetNewBizInfo;
    this.BkC = paramh;
    this.BkD = paramArrayOfString;
    com.tencent.mm.plugin.brandservice.b.c.init();
    this.Bku = new a();
    this.Bkv = "none";
    this.Bkx = kotlin.g.ah((kotlin.g.a.a)c.i.BlH);
    paramMMActivity = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
    p.g(paramMMActivity, "MMKernel.service(IBrandService::class.java)");
    this.Bky = ((com.tencent.mm.plugin.brandservice.a.b)paramMMActivity).cle();
    this.Bkz = new HashSet();
    AppMethodBeat.o(39727);
  }
  
  public final int UX(int paramInt)
  {
    AppMethodBeat.i(39722);
    this.Bkw = paramInt;
    int i = this.Bku.getSize();
    AppMethodBeat.o(39722);
    return i + paramInt;
  }
  
  public final boolean UY(int paramInt)
  {
    AppMethodBeat.i(39723);
    int i = eFi();
    if ((paramInt >= this.Bkw - i) && (paramInt < this.BkC.getCount() - i))
    {
      AppMethodBeat.o(39723);
      return true;
    }
    AppMethodBeat.o(39723);
    return false;
  }
  
  public final int UZ(int paramInt)
  {
    AppMethodBeat.i(39724);
    int i = this.BkC.getCount();
    if (paramInt >= i - eFi())
    {
      int j = this.Bkw;
      AppMethodBeat.o(39724);
      return j + paramInt - i;
    }
    AppMethodBeat.o(39724);
    return paramInt;
  }
  
  public final int eFi()
  {
    AppMethodBeat.i(39721);
    String[] arrayOfString = this.BkD;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      int k = this.BkC.bmj(str);
      if (k != -1)
      {
        i = this.Bkw;
        AppMethodBeat.o(39721);
        return i - k;
      }
      i += 1;
    }
    AppMethodBeat.o(39721);
    return 0;
  }
  
  public final com.tencent.mm.plugin.brandservice.a.b eFj()
  {
    AppMethodBeat.i(39725);
    com.tencent.mm.plugin.brandservice.a.b localb = (com.tencent.mm.plugin.brandservice.a.b)this.Bkx.getValue();
    AppMethodBeat.o(39725);
    return localb;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39726);
    paramInt = paramInt - this.Bkw + eFi();
    Object localObject1 = this.Bku.UU(paramInt);
    Object localObject2;
    Object localObject3;
    switch (f.$EnumSwitchMapping$0[localObject1.ordinal()])
    {
    default: 
      paramView = LayoutInflater.from((Context)this.BkA.getContext()).inflate(2131493730, paramViewGroup, false);
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      break;
    case 1: 
      paramView = LayoutInflater.from((Context)this.BkA.getContext()).inflate(2131493732, paramViewGroup, false);
      this.BkB.cJk();
      AppMethodBeat.o(39726);
      return paramView;
    case 2: 
      localObject1 = this.Bku.getItem(paramInt);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      localObject1 = (ou)localObject1;
      if ((((ou)localObject1).KVq.xKb == 49) && (eFj().CR(16)))
      {
        localObject2 = eFj();
        localObject3 = ((ou)localObject1).KVv.KSK;
        p.g(localObject3, "bizMessage.AppMsg.DetailInfo");
        Object localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          nh localnh = (nh)((Iterator)localObject4).next();
          ((Collection)localObject3).add(j.listOf(new String[] { localnh.KSj, String.valueOf(localnh.iAb) }));
        }
        ((com.tencent.mm.plugin.brandservice.a.b)localObject2).j((List)localObject3, 126);
      }
      paramView = new a(this, paramView, paramViewGroup, (ou)localObject1, this.Bkz, paramInt / 2).view;
      AppMethodBeat.o(39726);
      return paramView;
    case 3: 
      localObject1 = this.BkA.getContext();
      p.g(localObject1, "ui.context");
      localObject1 = (Context)localObject1;
      localObject2 = this.BkB;
      localObject3 = this.Bku.getItem(paramInt);
      if (localObject3 == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ProfileNotifyInfo");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      paramView = new g((Context)localObject1, (ContactWidgetNewBizInfo)localObject2, paramView, paramViewGroup, (dey)localObject3).view;
      AppMethodBeat.o(39726);
      return paramView;
    }
    paramView = (ViewGroup)paramView;
    paramViewGroup = (TextView)paramView.findViewById(2131297513);
    if (paramViewGroup != null) {
      paramViewGroup.setText((CharSequence)this.Bku.UT(paramInt));
    }
    paramView = (View)paramView;
    AppMethodBeat.o(39726);
    return paramView;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "interpolator", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "bizMsg", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "position", "(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;Landroid/view/View;Landroid/view/ViewGroup;Lcom/tencent/mm/protocal/protobuf/BizMessage;Ljava/util/HashSet;I)V", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "isBizPayOpen", "", "()Z", "setBizPayOpen", "(Z)V", "view", "getView", "()Landroid/view/View;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "fillCommonSlot", "", "container", "detail", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "base", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "fillSingleText", "text", "Lcom/tencent/mm/protocal/protobuf/BizTextMsgInfo;", "Lcom/tencent/mm/protocal/protobuf/CommMsgBaseInfo;", "fillSlotTarget", "fillTopSlot", "commBase", "getPlayId", "", "isPlaying", "playId", "firstNotEmpty", "", "([Ljava/lang/String;)Ljava/lang/String;", "app_release"})
  static final class a
    extends c.h
  {
    ContactWidgetNewBizInfo BkB;
    private boolean Bky;
    private HashSet<Integer> Bkz;
    Context context;
    Intent intent;
    final View view;
    
    public a(c paramc, View paramView, ViewGroup paramViewGroup, ou paramou, HashSet<Integer> paramHashSet, int paramInt)
    {
      AppMethodBeat.i(39645);
      this.Bky = true;
      Object localObject1 = paramc.BkA.getContext();
      p.g(localObject1, "interpolator.ui.context");
      this.context = ((Context)localObject1);
      this.BkB = paramc.BkB;
      localObject1 = paramc.BkA.getIntent();
      p.g(localObject1, "interpolator.ui.intent");
      this.intent = ((Intent)localObject1);
      this.Bkz = paramHashSet;
      this.Bky = paramc.Bky;
      if (paramView != null) {
        paramHashSet = paramView.getTag();
      }
      Object localObject2;
      int i;
      while (p.j(paramHashSet, paramou))
      {
        localObject2 = paramou.KVv;
        paramHashSet = this;
        localObject1 = paramView;
        if (localObject2 != null)
        {
          localObject2 = ((ni)localObject2).KSK;
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
                localObject1 = (nh)paramHashSet.next();
                p.g(localObject1, "detail");
                if (p.j(a((nh)localObject1), c.a(paramc)))
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
      paramc = LayoutInflater.from(this.context).inflate(2131493728, paramViewGroup, false);
      if (paramc == null)
      {
        paramc = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(39645);
        throw paramc;
      }
      paramView = (ViewGroup)paramc;
      paramView.setTag(this);
      switch (paramou.KVq.xKb)
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
            paramc = paramou.KVr;
            p.g(paramc, "bizMsg.Text");
            paramou = paramou.KVq;
            p.g(paramou, "bizMsg.BaseInfo");
            paramViewGroup = new c.f(10, c.d.BkW, paramView);
            paramInt = paramou.Brl;
            paramou = this.Bkz;
            paramc = paramc.iAc;
            p.g(paramc, "text.Content");
            paramViewGroup.a(paramInt, paramou, paramc);
          }
          j = paramou.KVv.KSK.size();
          if (j <= 1) {
            break label1006;
          }
          paramc = c.d.BkT;
          if (paramou.KVv.KSJ.KSg == 0) {
            break label1375;
          }
          paramViewGroup = paramou.KVv.KSK.get(0);
          p.g(paramViewGroup, "bizMsg.AppMsg.DetailInfo[0]");
          paramViewGroup = (nh)paramViewGroup;
          paramHashSet = paramou.KVv.KSJ;
          p.g(paramHashSet, "bizMsg.AppMsg.BaseInfo");
          localObject2 = paramou.KVq;
          p.g(localObject2, "bizMsg.BaseInfo");
          localObject1 = c.BkE;
          Log.v(c.access$getTAG$cp(), "fillTopSlot:" + paramViewGroup.KSj);
          localObject1 = new c.f(paramViewGroup.iAb, paramc, paramView);
          if ((paramViewGroup.iAb != 8) && (paramViewGroup.iAb != 10))
          {
            ((c.f)localObject1).BkR = paramViewGroup.KSF;
            ((c.f)localObject1).url = paramViewGroup.KSj;
            String str = paramViewGroup.Title;
            p.g(str, "detail.Title");
            ((c.f)localObject1).setTitle(str);
          }
          if (paramc == c.d.BkW)
          {
            paramc = (CharSequence)paramViewGroup.KSh;
            if ((paramc != null) && (!kotlin.n.n.aL(paramc))) {
              break label1013;
            }
            i = 1;
            if (i == 0) {
              ((MMNeat7extView)((c.f)localObject1).Blx.getValue()).aw((CharSequence)paramViewGroup.KSh);
            }
          }
          paramc = (CharSequence)paramViewGroup.KSy;
          if ((paramc != null) && (!kotlin.n.n.aL(paramc))) {
            break label1019;
          }
          i = 1;
          if (i == 0)
          {
            paramc = ((c.f)localObject1).eFn();
            p.g(paramc, "view.showDescTv");
            paramc.setText((CharSequence)paramViewGroup.KSy);
          }
          paramc = ((c.f)localObject1).eFn();
          if (paramc != null)
          {
            if ((((c.f)localObject1).BkR != 1) || (this.Bky)) {
              break label1025;
            }
            i = 4;
            paramc.setVisibility(i);
          }
          switch (paramViewGroup.iAb)
          {
          case 6: 
          default: 
            switch (paramViewGroup.iAb)
            {
            case 8: 
            case 9: 
            default: 
              switch (paramViewGroup.iAb)
              {
              default: 
                paramc = new String[2];
                paramc[0] = paramViewGroup.KSl;
                paramc[1] = paramViewGroup.KSn;
                ((c.f)localObject1).setImageUrl(L(paramc));
                a((View)((c.f)localObject1).eFo(), paramViewGroup, paramHashSet, paramInt);
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
      paramc = paramou.KVv.KSK.get(i);
      label913:
      label922:
      p.g(paramc, "bizMsg.AppMsg.DetailInfo[i]");
      paramViewGroup = (nh)paramc;
      paramHashSet = paramou.KVv.KSJ;
      p.g(paramHashSet, "bizMsg.AppMsg.BaseInfo");
      if (i == j - 1) {}
      for (paramc = c.d.BkV;; paramc = c.d.BkU)
      {
        a(paramView, paramViewGroup, paramHashSet, paramc, paramInt);
        i += 1;
        break label922;
        label1006:
        paramc = c.d.BkW;
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
        paramc = (TextView)((c.f)localObject1).Bls.getValue();
        p.g(paramc, "view.videoDurationTv");
        paramc.setText((CharSequence)com.tencent.mm.ag.m.rJ(paramViewGroup.KSx));
        break label804;
        paramc = (TextView)((c.f)localObject1).Blt.getValue();
        p.g(paramc, "view.voiceDurationTv");
        paramc.setText((CharSequence)com.tencent.mm.ag.m.rJ(paramViewGroup.KSs));
        break label804;
        if (paramViewGroup.zbj <= 1) {
          break label804;
        }
        paramc = (TextView)((c.f)localObject1).BkO.getValue();
        p.g(paramc, "view.picCntTv");
        paramc.setText((CharSequence)String.valueOf(paramViewGroup.zbj));
        break label804;
        paramc = (CharSequence)paramViewGroup.KSh;
        label1175:
        boolean bool;
        if ((paramc == null) || (kotlin.n.n.aL(paramc)))
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
          ((c.f)localObject1).eFw().setPadding(0, 0, 0, ((c.e)localObject1).Bla);
        }
        for (;;)
        {
          ((c.f)localObject1).Blz = bool;
          break;
          i = 0;
          break label1175;
          label1220:
          bool = false;
          break label1183;
          label1226:
          ((c.f)localObject1).eFw().setPadding(((c.e)localObject1).Bld, ((c.e)localObject1).Blc, ((c.e)localObject1).Bld, ((c.e)localObject1).Bla);
        }
        i = ((acb)localObject2).Brl;
        paramc = this.Bkz;
        localObject2 = paramViewGroup.Title;
        p.g(localObject2, "detail.Title");
        ((c.f)localObject1).a(i, paramc, (String)localObject2);
        paramc = (CharSequence)paramViewGroup.KSy;
        if ((paramc == null) || (kotlin.n.n.aL(paramc))) {}
        for (i = 1; i == 0; i = 0)
        {
          paramc = ((c.f)localObject1).eFn();
          p.g(paramc, "view.showDescTv");
          paramc.setText((CharSequence)paramViewGroup.KSy);
          break;
        }
        paramc = new String[2];
        paramc[0] = paramViewGroup.KSn;
        paramc[1] = paramViewGroup.KSl;
        break label887;
        label1375:
        paramViewGroup = paramou.KVv.KSK.get(0);
        p.g(paramViewGroup, "bizMsg.AppMsg.DetailInfo[0]");
        paramViewGroup = (nh)paramViewGroup;
        paramHashSet = paramou.KVv.KSJ;
        p.g(paramHashSet, "bizMsg.AppMsg.BaseInfo");
        a(paramView, paramViewGroup, paramHashSet, paramc, paramInt);
        break label913;
      }
    }
    
    private static String L(String[] paramArrayOfString)
    {
      AppMethodBeat.i(39640);
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
    
    private static String a(nh paramnh)
    {
      AppMethodBeat.i(39643);
      paramnh = paramnh.KSj;
      p.g(paramnh, "detail.ContentUrl");
      paramnh = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(paramnh);
      AppMethodBeat.o(39643);
      return paramnh;
    }
    
    private final void a(final View paramView, final nh paramnh, final ng paramng, final int paramInt)
    {
      AppMethodBeat.i(39644);
      ImageView localImageView;
      b localb;
      c localc;
      final String str;
      if (paramnh.iAb == 7)
      {
        localImageView = (ImageView)paramView.findViewById(2131297530);
        if (localImageView != null)
        {
          localb = new b(localImageView);
          localc = new c(localImageView);
          str = a(paramnh);
          if (!gO(str)) {
            break label121;
          }
          localb.invoke();
        }
      }
      for (;;)
      {
        localImageView.setOnClickListener((View.OnClickListener)new a(localb, str, this, paramnh));
        paramView.setOnClickListener((View.OnClickListener)new d(this, paramnh, paramng, paramView, paramInt));
        AppMethodBeat.o(39644);
        return;
        label121:
        localc.invoke();
      }
    }
    
    private final void a(ViewGroup paramViewGroup, nh paramnh, ng paramng, c.d paramd, int paramInt)
    {
      AppMethodBeat.i(39641);
      c.c localc = c.BkE;
      Log.v(c.access$getTAG$cp(), "fillCommonSlot:" + paramnh.KSj);
      paramd = new c.b(paramnh.iAb, paramd, paramViewGroup);
      paramd.BkR = paramnh.KSF;
      paramd.url = paramnh.KSj;
      paramViewGroup = paramnh.Title;
      p.g(paramViewGroup, "detail.Title");
      paramd.setTitle(paramViewGroup);
      paramViewGroup = (CharSequence)paramnh.KSy;
      int i;
      if ((paramViewGroup == null) || (kotlin.n.n.aL(paramViewGroup)))
      {
        i = 1;
        if (i == 0)
        {
          paramViewGroup = paramd.eFn();
          p.g(paramViewGroup, "view.showDescTv");
          paramViewGroup.setText((CharSequence)paramnh.KSy);
        }
        paramViewGroup = paramd.eFn();
        if (paramViewGroup != null)
        {
          if ((paramd.BkR != 1) || (this.Bky)) {
            break label305;
          }
          i = 4;
          label169:
          paramViewGroup.setVisibility(i);
        }
        if ((paramnh.iAb == 8) && (paramnh.zbj > 1))
        {
          paramViewGroup = (TextView)paramd.BkO.getValue();
          p.g(paramViewGroup, "view.picCntTv");
          paramViewGroup.setText((CharSequence)String.valueOf(paramnh.zbj));
        }
        switch (paramnh.iAb)
        {
        default: 
          paramViewGroup = new String[2];
          paramViewGroup[0] = paramnh.KSm;
          paramViewGroup[1] = paramnh.KSl;
        }
      }
      for (;;)
      {
        paramd.setImageUrl(L(paramViewGroup));
        a((View)paramd.eFo(), paramnh, paramng, paramInt);
        AppMethodBeat.o(39641);
        return;
        i = 0;
        break;
        label305:
        i = 0;
        break label169;
        paramViewGroup = new String[2];
        paramViewGroup[0] = paramnh.KSl;
        paramViewGroup[1] = paramnh.KSm;
      }
    }
    
    private static boolean gO(String paramString)
    {
      AppMethodBeat.i(39642);
      com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.bef();
      if (localf != null)
      {
        if ((p.j(localf.jeV, paramString)) && (localf.jeT == 0) && (com.tencent.mm.ay.a.bec()))
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
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$1$3"})
    static final class a
      implements View.OnClickListener
    {
      a(c.a.b paramb, String paramString, c.a parama, nh paramnh) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(39634);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        this.BkF.invoke();
        localObject = new e.g();
        e.h localh = new e.h();
        localh.JwO = str;
        localh.url = paramnh.KSj;
        localh.title = paramnh.Title;
        localh.iAA = "";
        localh.playUrl = paramnh.KSt;
        localh.coverUrl = paramnh.KSl;
        ((e.g)localObject).PJr = localh;
        paramView.setTag(localObject);
        com.tencent.mm.ui.chatting.s.gA(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39634);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"drawPlaying", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      b(ImageView paramImageView)
      {
        super();
      }
      
      public final void invoke()
      {
        AppMethodBeat.i(39636);
        this.tqC.setImageResource(2131231332);
        Object localObject = this.tqC.getDrawable();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
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
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"drawPlay", "", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      c(ImageView paramImageView)
      {
        super();
      }
      
      public final void invoke()
      {
        AppMethodBeat.i(39638);
        this.tqC.setImageResource(2131231331);
        AppMethodBeat.o(39638);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(c.a parama, nh paramnh, ng paramng, View paramView, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(39639);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        paramView = c.BkE;
        Log.i(c.access$getTAG$cp(), "onClick jump to url:%s", new Object[] { paramnh.KSj });
        int i = this.BkH.intent.getIntExtra("KOpenArticleSceneFromScene", -1);
        paramView = new Intent();
        localObject1 = com.tencent.mm.ag.m.d(paramnh.KSj, 126, i, 0);
        paramView.putExtra("rawUrl", (String)localObject1);
        paramView.putExtra("useJs", true);
        paramView.putExtra("vertical_scroll", true);
        paramView.putExtra("geta8key_scene", 3);
        Object localObject2 = this.BkH.BkB.eFa();
        p.g(localObject2, "widget.contact");
        paramView.putExtra("geta8key_username", ((as)localObject2).getUsername());
        localObject2 = paramView.getStringExtra("prePublishId");
        if (!Util.isNullOrNil((String)localObject2))
        {
          paramView.putExtra("KPublisherId", (String)localObject2);
          paramView.putExtra("prePublishId", (String)localObject2);
          paramView.putExtra("preUsername", paramView.getStringExtra("preUsername"));
          paramView.putExtra("preChatName", paramView.getStringExtra("preChatName"));
          paramView.putExtra("preChatTYPE", paramView.getIntExtra("preChatTYPE", 0));
          i = paramView.getIntExtra("KOpenArticleSceneFromScene", 10000);
          if (paramnh.iAb == 5)
          {
            localObject2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
            p.g(localObject2, "MMKernel.service(IBrandService::class.java)");
            if (((com.tencent.mm.plugin.brandservice.a.b)localObject2).cld())
            {
              paramView.putExtra(e.b.OyQ, 126);
              paramView.putExtra(e.b.OyR, i);
              paramView.putExtra("biz_video_session_id", ab.getSessionId());
              localObject2 = new com.tencent.mm.ag.x();
              ((com.tencent.mm.ag.x)localObject2).iAh = paramView.getStringExtra("KPublisherId");
              Object localObject3 = this.BkH.BkB.eFa();
              p.g(localObject3, "widget.contact");
              ((com.tencent.mm.ag.x)localObject2).dHc = ((as)localObject3).getUsername();
              localObject3 = this.BkH.BkB.eFa();
              p.g(localObject3, "widget.contact");
              ((com.tencent.mm.ag.x)localObject2).iAg = ((as)localObject3).arI();
              ((com.tencent.mm.ag.x)localObject2).iAi.url = ((String)localObject1);
              ((com.tencent.mm.ag.x)localObject2).iAi.title = paramnh.Title;
              ((com.tencent.mm.ag.x)localObject2).iAi.iAq = "detail.videoDigest";
              ((com.tencent.mm.ag.x)localObject2).iAi.iAo = paramnh.KSl;
              ((com.tencent.mm.ag.x)localObject2).iAi.type = paramnh.iAb;
              ((com.tencent.mm.ag.x)localObject2).iAi.time = paramng.CreateTime;
              ((com.tencent.mm.ag.x)localObject2).iAi.iAs = paramnh.KSx;
              ((com.tencent.mm.ag.x)localObject2).iAi.videoWidth = paramnh.KSv;
              ((com.tencent.mm.ag.x)localObject2).iAi.videoHeight = paramnh.KSw;
              ((com.tencent.mm.ag.x)localObject2).iAi.vid = paramnh.KSu;
              ((com.tencent.mm.ag.x)localObject2).t(paramView);
              localObject2 = c.BkE;
              Log.i(c.access$getTAG$cp(), "jump to native video");
              localObject2 = new int[2];
              localObject3 = (ImageView)paramView.findViewById(2131297515);
              if (localObject3 != null)
              {
                int j = ((ImageView)localObject3).getWidth();
                int k = ((ImageView)localObject3).getHeight();
                ((ImageView)localObject3).getLocationInWindow((int[])localObject2);
                paramView.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
              }
              paramView.addFlags(268435456);
            }
          }
          if ((!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(6)) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.BkH.context, (String)localObject1, paramnh.iAb, 126, i, paramView))) {
            break label842;
          }
          paramView = c.BkE;
          Log.i(c.access$getTAG$cp(), "jump to TmplWebview");
        }
        for (;;)
        {
          paramView = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.BlR;
          paramView = this.BkH.BkB.eFa();
          p.g(paramView, "widget.contact");
          paramView = paramView.getUsername();
          p.g(paramView, "widget.contact.username");
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.b(paramView, this.BkH.BkB.ahy(), paramng.KSf, paramnh.KSi, paramnh.iAb, paramInt, paramng.CreateTime, this.BkH.BkB.eFd());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(39639);
          return;
          paramView.putExtra("prePublishId", "brand_profile");
          paramView.putExtra("KPublisherId", "brand_profile");
          break;
          label842:
          com.tencent.mm.br.c.b(this.BkH.context, "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$CommonSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "picCntTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "Lkotlin/Lazy;", "picInfo", "Landroid/support/constraint/ConstraintLayout;", "getPicInfo", "()Landroid/support/constraint/ConstraintLayout;", "picInfo$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "titleTv$delegate", "url", "getUrl", "setUrl", "weakPicInfo", "Ljava/lang/ref/WeakReference;", "getWeakPicInfo", "()Ljava/lang/ref/WeakReference;", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "app_release"})
  static final class b
    extends c.e
  {
    private final int BkL;
    private final kotlin.f BkM;
    private final WeakReference<ConstraintLayout> BkN;
    final kotlin.f BkO;
    private final kotlin.f BkP;
    private final kotlin.f BkQ;
    int BkR;
    private String title;
    String url;
    
    public b(int paramInt, c.d paramd, ViewGroup paramViewGroup)
    {
      super(paramd, paramViewGroup);
      AppMethodBeat.i(39658);
      this.BkL = 2131234473;
      this.BkM = kotlin.g.ah((kotlin.g.a.a)new b(this));
      this.BkN = new WeakReference((ConstraintLayout)this.BkM.getValue());
      this.BkO = kotlin.g.ah((kotlin.g.a.a)new a(this));
      this.BkP = kotlin.g.ah((kotlin.g.a.a)new c(this));
      this.BkQ = kotlin.g.ah((kotlin.g.a.a)new d(this));
      this.url = "";
      this.title = "";
      AppMethodBeat.o(39658);
    }
    
    protected final void a(View paramView, c.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(39653);
      p.h(paramView, "container");
      p.h(paramd, "slotType");
      switch (d.$EnumSwitchMapping$0[paramd.ordinal()])
      {
      default: 
        localObject = paramView.findViewById(2131297533);
        p.g(localObject, "container.findViewById<F…id.biz_slot_voice_layout)");
        ((FrameLayout)localObject).setVisibility(8);
        switch (this.iwc)
        {
        case 6: 
        case 9: 
        default: 
          localObject = paramView.findViewById(2131297515);
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
        localObject = paramView.findViewById(2131297510);
        p.g(localObject, "container.findViewById<V…d.biz_slot_common_line_v)");
        ((View)localObject).setVisibility(0);
        break;
        localObject = paramView.findViewById(2131297515);
        p.g(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject).setVisibility(0);
        localObject = paramView.findViewById(2131297529);
        p.g(localObject, "container.findViewById<I….biz_slot_video_play_img)");
        ((ImageView)localObject).setVisibility(0);
        continue;
        localObject = paramView.findViewById(2131297515);
        p.g(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject).setVisibility(0);
        localObject = paramView.findViewById(2131297506);
        p.g(localObject, "container.findViewById<C…slot_common_content_desc)");
        ((ConstraintLayout)localObject).setVisibility(0);
        continue;
        localObject = paramView.findViewById(2131297533);
        p.g(localObject, "container.findViewById<F…id.biz_slot_voice_layout)");
        ((FrameLayout)localObject).setVisibility(0);
      }
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)paramView.findViewById(2131297524);
      p.g(localMMNeat7extView, "tv");
      if ((localMMNeat7extView.getLayoutParams() instanceof ConstraintLayout.LayoutParams))
      {
        localObject = localMMNeat7extView.getLayoutParams();
        if (localObject == null)
        {
          paramView = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
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
        localObject = paramView.findViewById(2131297515);
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
      paramContext = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493729, paramViewGroup, false);
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(39652);
        throw paramContext;
      }
      paramContext = (ViewGroup)paramContext;
      paramViewGroup.addView((View)paramContext);
      AppMethodBeat.o(39652);
      return paramContext;
    }
    
    protected final void eFk()
    {
      AppMethodBeat.i(39654);
      if (this.BkN == null)
      {
        AppMethodBeat.o(39654);
        return;
      }
      ConstraintLayout localConstraintLayout = (ConstraintLayout)this.BkN.get();
      if (localConstraintLayout != null)
      {
        localConstraintLayout.setBackgroundResource(2131231265);
        AppMethodBeat.o(39654);
        return;
      }
      AppMethodBeat.o(39654);
    }
    
    protected final float[] eFl()
    {
      AppMethodBeat.i(39655);
      float[] arrayOfFloat = kotlin.a.e.b(new Float[] { Float.valueOf(bJ(1.0F)), Float.valueOf(bJ(1.0F)), Float.valueOf(bJ(1.0F)), Float.valueOf(bJ(1.0F)) });
      AppMethodBeat.o(39655);
      return arrayOfFloat;
    }
    
    protected final int eFm()
    {
      return this.BkL;
    }
    
    public final TextView eFn()
    {
      AppMethodBeat.i(39656);
      TextView localTextView = (TextView)this.BkP.getValue();
      AppMethodBeat.o(39656);
      return localTextView;
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(39657);
      p.h(paramString, "value");
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.BkQ.getValue();
      p.g(localMMNeat7extView, "titleTv");
      a(localMMNeat7extView, paramString, this.BkR, this.url, 5);
      AppMethodBeat.o(39657);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      a(c.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/constraint/ConstraintLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ConstraintLayout>
    {
      b(c.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      c(c.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMNeat7extView>
    {
      d(c.b paramb)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "", "(Ljava/lang/String;I)V", "TOP", "COMMON", "BOTTOM", "SINGLE", "app_release"})
  static enum d
  {
    static
    {
      AppMethodBeat.i(39659);
      d locald1 = new d("TOP", 0);
      BkT = locald1;
      d locald2 = new d("COMMON", 1);
      BkU = locald2;
      d locald3 = new d("BOTTOM", 2);
      BkV = locald3;
      d locald4 = new d("SINGLE", 3);
      BkW = locald4;
      BkX = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(39659);
    }
    
    private d() {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "audioPadding", "getAudioPadding", "()I", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "imageDefaultRes", "getImageDefaultRes", "imageIv", "Landroid/widget/ImageView;", "getImageIv", "()Landroid/widget/ImageView;", "imageIv$delegate", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "value", "", "imageUrl", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "item", "getItem", "()Landroid/view/ViewGroup;", "item$delegate", "getItemShowType", "largePading", "getLargePading", "listPadding", "getListPadding", "normalPading", "getNormalPading", "getSlotType", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "smallPadding", "getSmallPadding", "dpToPixel", "", "getDpToPixel", "(F)F", "resFromRaw", "getResFromRaw", "(I)F", "resToPixel", "getResToPixel", "(I)I", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "onImageLoadFinish", "onImageLoadStart", "setNeatText", "neatText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "isPayMsg", "url", "scene", "app_release"})
  static class e
  {
    private final int BkL;
    private final kotlin.f BkY;
    private final kotlin.f BkZ;
    final int Bla;
    private final int Blb;
    final int Blc;
    final int Bld;
    private final int Ble;
    private final float[] Blf;
    final c.d Blg;
    String imageUrl;
    final int iwc;
    private final kotlin.f tMy;
    
    public e(int paramInt, c.d paramd, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39679);
      this.iwc = paramInt;
      this.Blg = paramd;
      this.BkY = kotlin.g.ah((kotlin.g.a.a)new e(this, paramViewGroup));
      this.BkZ = kotlin.g.ah((kotlin.g.a.a)new b(this));
      this.tMy = kotlin.g.ah((kotlin.g.a.a)new a(this));
      this.Bla = ((int)bJ(36.0F));
      this.Blb = MMApplicationContext.getResources().getDimensionPixelSize(2131165507);
      this.Blc = MMApplicationContext.getResources().getDimensionPixelSize(2131165534);
      this.Bld = MMApplicationContext.getResources().getDimensionPixelSize(2131165498);
      this.Ble = MMApplicationContext.getResources().getDimensionPixelSize(2131165586);
      this.Blf = kotlin.a.e.b(new Float[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) });
      this.BkL = 2131100173;
      this.imageUrl = "";
      AppMethodBeat.o(39679);
    }
    
    protected static float bJ(float paramFloat)
    {
      AppMethodBeat.i(39678);
      Resources localResources = MMApplicationContext.getResources();
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
      switch (e.$EnumSwitchMapping$0[paramd.ordinal()])
      {
      default: 
        AppMethodBeat.o(39674);
        return;
      case 1: 
        paramView.setPadding(this.Bld, this.Ble, this.Bld, 0);
        if (paramBoolean) {}
        for (i = 2131231292;; i = 2131231290)
        {
          paramView.setBackgroundResource(i);
          AppMethodBeat.o(39674);
          return;
        }
      case 2: 
        paramView.setPadding(this.Bld, this.Ble, this.Bld, 0);
        i = 2131231286;
      }
      for (;;)
      {
        paramView.setBackgroundResource(i);
        break;
        paramView.setPadding(this.Bld, this.Ble, this.Bld, this.Bld);
        i = 2131231285;
        continue;
        paramView.setPadding(this.Bld, this.Ble, this.Bld, this.Ble);
        if (paramBoolean) {
          i = 2131231289;
        } else {
          i = 2131231287;
        }
      }
    }
    
    protected final void a(MMNeat7extView paramMMNeat7extView, String paramString1, int paramInt1, String paramString2, int paramInt2)
    {
      boolean bool = true;
      AppMethodBeat.i(39676);
      p.h(paramMMNeat7extView, "neatText");
      p.h(paramString1, "text");
      paramString1 = com.tencent.mm.pluginsdk.ui.span.l.c(paramMMNeat7extView.getContext(), (CharSequence)paramString1);
      if ((this.iwc == 0) && (paramInt1 == 1)) {}
      for (;;)
      {
        com.tencent.mm.plugin.brandservice.b.a locala = com.tencent.mm.plugin.brandservice.b.a.pmT;
        p.g(paramString1, "text");
        locala.a((CharSequence)paramString1, paramMMNeat7extView, bool, paramString2, paramInt2);
        paramMMNeat7extView.setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.h((NeatTextView)paramMMNeat7extView, (View.OnTouchListener)new o(paramMMNeat7extView.getContext())));
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
      paramContext = (Throwable)new kotlin.n();
      AppMethodBeat.o(39672);
      throw paramContext;
    }
    
    protected void eFk() {}
    
    protected float[] eFl()
    {
      return this.Blf;
    }
    
    protected int eFm()
    {
      return this.BkL;
    }
    
    public final ViewGroup eFo()
    {
      AppMethodBeat.i(39670);
      ViewGroup localViewGroup = (ViewGroup)this.BkY.getValue();
      AppMethodBeat.o(39670);
      return localViewGroup;
    }
    
    final ImageView eFp()
    {
      AppMethodBeat.i(39671);
      ImageView localImageView = (ImageView)this.BkZ.getValue();
      AppMethodBeat.o(39671);
      return localImageView;
    }
    
    protected void eFq() {}
    
    protected final Context getContext()
    {
      AppMethodBeat.i(39673);
      Context localContext = (Context)this.tMy.getValue();
      AppMethodBeat.o(39673);
      return localContext;
    }
    
    public final void setImageUrl(final String paramString)
    {
      AppMethodBeat.i(39677);
      p.h(paramString, "value");
      if (kotlin.n.n.aL((CharSequence)paramString)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(39677);
        return;
      }
      paramString = com.tencent.mm.api.b.u(paramString, 2);
      p.g(paramString, "BizImageStrategy.getUrl(…rategy.SCENE_BIZ_PROFILE)");
      this.imageUrl = paramString;
      paramString = c.BkE;
      Log.v(c.access$getTAG$cp(), "imageUrl:" + this.imageUrl);
      paramString = eFl();
      final String str = this.imageUrl;
      Object localObject1 = new com.tencent.mm.av.a.a.c.a().bdp();
      Object localObject2 = new StringBuilder("radius_");
      Object localObject3 = Arrays.toString(paramString);
      p.g(localObject3, "java.util.Arrays.toString(this)");
      localObject1 = ((com.tencent.mm.av.a.a.c.a)localObject1).OU((String)localObject3).tz(eFm()).a((com.tencent.mm.av.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.av.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).OS(com.tencent.mm.pluginsdk.model.s.bdu(this.imageUrl)).bdv();
      localObject2 = new d(this);
      localObject3 = new com.tencent.mm.pluginsdk.ui.applet.m(3, -1, -1, paramString, (m.a)localObject2);
      ((com.tencent.mm.pluginsdk.ui.applet.m)localObject3).aG((Runnable)new c(this, str, (com.tencent.mm.av.a.a.c)localObject1, paramString, (d)localObject2));
      com.tencent.mm.av.q.bcV().a(str, eFp(), (com.tencent.mm.av.a.a.c)localObject1, (com.tencent.mm.av.a.c.h)localObject3);
      AppMethodBeat.o(39677);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Context>
    {
      a(c.e parame)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ImageView>
    {
      b(c.e parame)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel$imageUrl$imageLoaderListener$1$1"})
    static final class c
      implements Runnable
    {
      c(c.e parame, String paramString, com.tencent.mm.av.a.a.c paramc, float[] paramArrayOfFloat, c.e.d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(39665);
        com.tencent.mm.av.a.a locala = com.tencent.mm.av.q.bcV();
        String str = str;
        ImageView localImageView1 = this.Blh.eFp();
        com.tencent.mm.av.a.a.c localc = this.Bli;
        ImageView localImageView2 = this.Blh.eFp();
        p.g(localImageView2, "imageIv");
        int i = localImageView2.getMeasuredWidth();
        localImageView2 = this.Blh.eFp();
        p.g(localImageView2, "imageIv");
        locala.a(str, localImageView1, localc, (com.tencent.mm.av.a.c.h)new com.tencent.mm.pluginsdk.ui.applet.m(3, i, localImageView2.getMeasuredHeight(), paramString, (m.a)this.Blk));
        AppMethodBeat.o(39665);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel$imageUrl$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
    public static final class d
      implements m.a
    {
      public final void onFinish()
      {
        AppMethodBeat.i(39666);
        c.c localc = c.BkE;
        Log.v(c.access$getTAG$cp(), "imageUrl onFinish:" + this.Blh.imageUrl);
        this.Blh.eFk();
        AppMethodBeat.o(39666);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(39667);
        c.c localc = c.BkE;
        Log.v(c.access$getTAG$cp(), "imageUrl onStart:" + this.Blh.imageUrl);
        this.Blh.eFq();
        AppMethodBeat.o(39667);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
    static final class e
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ViewGroup>
    {
      e(c.e parame, ViewGroup paramViewGroup)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$TopSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "collapseTextLayout", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "getCollapseTextLayout", "()Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "collapseTextLayout$delegate", "Lkotlin/Lazy;", "descMask", "Landroid/view/View;", "getDescMask", "()Landroid/view/View;", "descMask$delegate", "digestTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getDigestTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "digestTv$delegate", "value", "", "hasAudioDesc", "getHasAudioDesc", "()Z", "setHasAudioDesc", "(Z)V", "hasDesc", "setHasDesc", "hasSingleInfo", "hasTitle", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "isSingleImage", "picCntTv", "Landroid/widget/TextView;", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "singleDescLayout", "getSingleDescLayout", "singleDescLayout$delegate", "singleTitleTv", "getSingleTitleTv", "singleTitleTv$delegate", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleDescViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "titleTv", "getTitleTv", "titleTv$delegate", "topMask", "Landroid/widget/ImageView;", "getTopMask", "()Landroid/widget/ImageView;", "topMask$delegate", "url", "getUrl", "setUrl", "videPlayImg", "getVidePlayImg", "videPlayImg$delegate", "videoDurationTv", "getVideoDurationTv", "videoDurationTv$delegate", "voiceDurationTv", "getVoiceDurationTv", "voiceDurationTv$delegate", "fillBackground", "", "selector", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "onImageLoadStart", "setText", "id", "expandSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "text", "setTitleDescTextColor", "color", "app_release"})
  static final class f
    extends c.e
  {
    final kotlin.f BkO;
    private final kotlin.f BkP;
    private final kotlin.f BkQ;
    int BkR;
    private boolean Blm;
    boolean Bln;
    boolean Blo;
    ArrayList<View> Blp;
    private final kotlin.f Blq;
    private final kotlin.f Blr;
    final kotlin.f Bls;
    final kotlin.f Blt;
    private final kotlin.f Blu;
    private final kotlin.f Blv;
    private final kotlin.f Blw;
    final kotlin.f Blx;
    private final kotlin.f Bly;
    boolean Blz;
    private String title;
    String url;
    
    public f(final int paramInt, c.d paramd, ViewGroup paramViewGroup)
    {
      super(paramd, paramViewGroup);
      AppMethodBeat.i(39713);
      this.url = "";
      this.Blp = new ArrayList();
      this.Blq = kotlin.g.ah((kotlin.g.a.a)new l(this));
      this.Blr = kotlin.g.ah((kotlin.g.a.a)new b(this));
      this.BkP = kotlin.g.ah((kotlin.g.a.a)new h(this));
      this.Bls = kotlin.g.ah((kotlin.g.a.a)new n(this));
      this.Blt = kotlin.g.ah((kotlin.g.a.a)new o(this));
      this.BkO = kotlin.g.ah((kotlin.g.a.a)new e(this));
      this.BkQ = kotlin.g.ah((kotlin.g.a.a)new k(this, paramInt));
      this.Blu = kotlin.g.ah((kotlin.g.a.a)new m(this));
      this.Blv = kotlin.g.ah((kotlin.g.a.a)new i(this));
      this.Blw = kotlin.g.ah((kotlin.g.a.a)new j(this));
      this.Blx = kotlin.g.ah((kotlin.g.a.a)new c(this));
      this.Bly = kotlin.g.ah((kotlin.g.a.a)new a(this));
      this.title = "";
      AppMethodBeat.o(39713);
    }
    
    private final boolean eFs()
    {
      return (this.Blg == c.d.BkW) && (!this.Blo);
    }
    
    private final ImageView eFt()
    {
      AppMethodBeat.i(39702);
      ImageView localImageView = (ImageView)this.Blq.getValue();
      AppMethodBeat.o(39702);
      return localImageView;
    }
    
    private final MMNeat7extView eFu()
    {
      AppMethodBeat.i(39704);
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.BkQ.getValue();
      AppMethodBeat.o(39704);
      return localMMNeat7extView;
    }
    
    private final ImageView eFv()
    {
      AppMethodBeat.i(39705);
      ImageView localImageView = (ImageView)this.Blu.getValue();
      AppMethodBeat.o(39705);
      return localImageView;
    }
    
    private MMCollapsibleTextView eFx()
    {
      AppMethodBeat.i(39707);
      MMCollapsibleTextView localMMCollapsibleTextView = (MMCollapsibleTextView)this.Bly.getValue();
      AppMethodBeat.o(39707);
      return localMMCollapsibleTextView;
    }
    
    final void Va(int paramInt)
    {
      AppMethodBeat.i(39712);
      Iterator localIterator = ((Iterable)this.Blp).iterator();
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
    
    public final void a(final int paramInt, HashSet<Integer> paramHashSet, String paramString)
    {
      AppMethodBeat.i(39709);
      p.h(paramHashSet, "expandSet");
      p.h(paramString, "text");
      MMCollapsibleTextView localMMCollapsibleTextView = eFx();
      p.g(localMMCollapsibleTextView, "collapseTextLayout");
      paramString = com.tencent.mm.pluginsdk.ui.span.l.j(localMMCollapsibleTextView.getContext(), (CharSequence)paramString, (int)eFx().getTextSize());
      localMMCollapsibleTextView = eFx();
      if (!paramHashSet.contains(Integer.valueOf(paramInt))) {}
      for (boolean bool = true;; bool = false)
      {
        localMMCollapsibleTextView.setCollapsed(bool);
        localMMCollapsibleTextView = eFx();
        p.g(paramString, "text");
        localMMCollapsibleTextView.setText((CharSequence)paramString);
        if (!(eFx().getContentText() instanceof MMNeat7extView)) {
          break label194;
        }
        paramString = eFx().getContentText();
        if (paramString != null) {
          break;
        }
        paramHashSet = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(39709);
        throw paramHashSet;
      }
      paramString = (MMNeat7extView)paramString;
      eFx().setOnTextTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.h((NeatTextView)paramString, (View.OnTouchListener)new o(paramString.getContext())));
      label194:
      eFx().setOnCollapse((kotlin.g.a.a)new f(paramHashSet, paramInt));
      eFx().setOnExpand((kotlin.g.a.a)new g(paramHashSet, paramInt));
      AppMethodBeat.o(39709);
    }
    
    protected final void a(View paramView, c.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(39698);
      p.h(paramView, "container");
      p.h(paramd, "slotType");
      switch (this.iwc)
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
        if (paramd == c.d.BkT)
        {
          View localView = paramView.findViewById(2131297526);
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
      paramContext = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493733, paramViewGroup, false);
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(39697);
        throw paramContext;
      }
      paramContext = (ViewGroup)paramContext;
      int i;
      switch (this.iwc)
      {
      case 9: 
      default: 
        i = 2131299038;
      }
      for (;;)
      {
        ((ViewStub)paramContext.findViewById(i)).inflate();
        paramViewGroup.addView((View)paramContext);
        AppMethodBeat.o(39697);
        return paramContext;
        i = 2131299041;
        continue;
        eFr();
        i = 2131299039;
        continue;
        i = 2131299040;
        continue;
        i = 2131299037;
      }
    }
    
    protected final void eFk()
    {
      AppMethodBeat.i(39711);
      Object localObject = getContext();
      p.g(localObject, "context");
      Va(((Context)localObject).getResources().getColor(2131101427));
      if (this.Blm)
      {
        localObject = (View)this.Blr.getValue();
        if (!eFs()) {
          break label113;
        }
        if (this.Bln)
        {
          i = 2131234479;
          ((View)localObject).setBackgroundResource(i);
        }
      }
      else
      {
        localObject = eFt();
        if (this.Blg != c.d.BkT) {
          break label134;
        }
      }
      label134:
      for (int i = 2131231301;; i = 2131231303)
      {
        ((ImageView)localObject).setBackgroundResource(i);
        AppMethodBeat.o(39711);
        return;
        i = 2131234478;
        break;
        label113:
        if (this.Bln)
        {
          i = 2131234477;
          break;
        }
        i = 2131234476;
        break;
      }
    }
    
    protected final float[] eFl()
    {
      AppMethodBeat.i(39699);
      if (eFs())
      {
        arrayOfFloat = kotlin.a.e.b(new Float[] { Float.valueOf(bJ(8.0F)), Float.valueOf(bJ(8.0F)), Float.valueOf(bJ(8.0F)), Float.valueOf(bJ(8.0F)) });
        AppMethodBeat.o(39699);
        return arrayOfFloat;
      }
      float[] arrayOfFloat = kotlin.a.e.b(new Float[] { Float.valueOf(bJ(8.0F)), Float.valueOf(bJ(8.0F)), Float.valueOf(0.0F), Float.valueOf(0.0F) });
      AppMethodBeat.o(39699);
      return arrayOfFloat;
    }
    
    protected final int eFm()
    {
      AppMethodBeat.i(39700);
      if (eFs())
      {
        AppMethodBeat.o(39700);
        return 2131234474;
      }
      AppMethodBeat.o(39700);
      return 2131234475;
    }
    
    public final TextView eFn()
    {
      AppMethodBeat.i(39703);
      TextView localTextView = (TextView)this.BkP.getValue();
      AppMethodBeat.o(39703);
      return localTextView;
    }
    
    protected final void eFq()
    {
      AppMethodBeat.i(39710);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new d(this));
      AppMethodBeat.o(39710);
    }
    
    final void eFr()
    {
      AppMethodBeat.i(39701);
      this.Blm = true;
      if (this.iwc == 5)
      {
        Object localObject = eFv();
        p.g(localObject, "videPlayImg");
        localObject = ((ImageView)localObject).getLayoutParams();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
          AppMethodBeat.o(39701);
          throw ((Throwable)localObject);
        }
        localObject = (ConstraintLayout.LayoutParams)localObject;
        if (((ConstraintLayout.LayoutParams)localObject).verticalBias != 0.56F)
        {
          ((ConstraintLayout.LayoutParams)localObject).verticalBias = 0.56F;
          ImageView localImageView = eFv();
          p.g(localImageView, "videPlayImg");
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(39701);
    }
    
    final View eFw()
    {
      AppMethodBeat.i(39706);
      View localView = (View)this.Blv.getValue();
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
      switch (this.iwc)
      {
      default: 
        if (this.Blg == c.d.BkW)
        {
          localMMNeat7extView = (MMNeat7extView)this.Blw.getValue();
          p.g(localMMNeat7extView, "if (slotType == SlotType…ingleTitleTv else titleTv");
          j = this.BkR;
          str = this.url;
          if (this.Blg != c.d.BkW) {
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
        localMMNeat7extView = eFu();
        p.g(localMMNeat7extView, "titleTv");
        a(localMMNeat7extView, paramString, this.BkR, this.url, 4);
        paramString = eFt();
        if (this.Blg == c.d.BkT) {}
        for (i = 2131231303;; i = 2131231301)
        {
          paramString.setBackgroundResource(i);
          AppMethodBeat.o(39708);
          return;
        }
        localMMNeat7extView = eFu();
        break;
        label188:
        i = 41;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMCollapsibleTextView>
    {
      a(c.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<View>
    {
      b(c.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMNeat7extView>
    {
      c(c.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class d
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      d(c.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      e(c.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class f
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      f(HashSet paramHashSet, int paramInt)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class g
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      g(HashSet paramHashSet, int paramInt)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      h(c.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i
      extends kotlin.g.b.q
      implements kotlin.g.a.a<View>
    {
      i(c.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMNeat7extView>
    {
      j(c.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMNeat7extView>
    {
      k(c.f paramf, int paramInt)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ImageView>
    {
      l(c.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ImageView>
    {
      m(c.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class n
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      n(c.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class o
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      o(c.f paramf)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "context", "Landroid/content/Context;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "position", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Landroid/view/View;Landroid/view/ViewGroup;ILcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;)V", "coverSize", "radius", "", "view", "getView", "()Landroid/view/View;", "fillVideoChannel", "", "fillVideoItem", "videoItem", "Lcom/tencent/mm/protocal/protobuf/NotifyVideoInfo;", "itemView", "getDurationText", "", "app_release"})
  static final class g
    extends c.h
  {
    final ContactWidgetNewBizInfo BkB;
    private int BlD;
    final Context context;
    private float radius;
    final View view;
    
    public g(final Context paramContext, ContactWidgetNewBizInfo paramContactWidgetNewBizInfo, View paramView, ViewGroup paramViewGroup, final dey paramdey)
    {
      AppMethodBeat.i(169914);
      this.radius = 2.0F;
      this.context = paramContext;
      this.BkB = paramContactWidgetNewBizInfo;
      this.BlD = com.tencent.mm.cb.a.fromDPToPix(paramContext, 64);
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
        if (!p.j(paramContactWidgetNewBizInfo, paramdey)) {
          break label697;
        }
        this.view = paramView;
        paramContactWidgetNewBizInfo = (TextView)this.view.findViewById(2131309761);
        paramContext = (CharSequence)paramdey.MJZ;
        if ((paramContext != null) && (paramContext.length() != 0)) {
          break label735;
        }
        i = 1;
        if (i != 0) {
          break label741;
        }
        paramContext = (CharSequence)paramdey.MJZ;
        paramContactWidgetNewBizInfo.setText(paramContext);
        paramContext = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
        com.tencent.mm.plugin.brandservice.ui.b.d.i(paramContactWidgetNewBizInfo);
        paramContactWidgetNewBizInfo = (TextView)this.view.findViewById(2131309760);
        paramContext = (CharSequence)paramdey.dQx;
        if ((paramContext != null) && (paramContext.length() != 0)) {
          break label769;
        }
        i = 1;
        if (i != 0) {
          break label775;
        }
        paramContext = (CharSequence)paramdey.dQx;
        paramContactWidgetNewBizInfo.setText(paramContext);
        paramContext = paramdey.MJY;
        paramContactWidgetNewBizInfo = c.BkE;
        Log.v(c.access$getTAG$cp(), "alvinluo fillVideoChannel size: %d", new Object[] { Integer.valueOf(paramContext.size()) });
        paramContactWidgetNewBizInfo = (LinearLayout)this.view.findViewById(2131309733);
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
          paramViewGroup = (cty)paramView.next();
        } while (paramViewGroup == null);
        paramContext = c.BkE;
        Log.d(c.access$getTAG$cp(), "alvinluo videoItem url: %s, duration: %d", new Object[] { paramViewGroup.Mzi, Integer.valueOf(paramViewGroup.duration) });
        localObject1 = LayoutInflater.from(this.context).inflate(2131493749, null, false);
        paramContactWidgetNewBizInfo.addView((View)localObject1);
        p.g(localObject1, "itemView");
        paramContext = ((View)localObject1).findViewById(2131309754);
        p.g(paramContext, "itemView.findViewById<Te…iew>(R.id.video_duration)");
        localObject2 = (TextView)paramContext;
        i = paramViewGroup.duration / 3600;
        j = (paramViewGroup.duration - i * 3600) / 60;
        k = paramViewGroup.duration % 60;
        paramContext = c.BkE;
        Log.i(c.access$getTAG$cp(), "alvinluo getDurationText " + i + ':' + j + ':' + k);
        if (i <= 0) {
          break label803;
        }
        paramContext = ae.SYK;
        paramContext = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }, 3));
        p.g(paramContext, "java.lang.String.format(format, *args)");
      }
      for (;;)
      {
        ((TextView)localObject2).setText((CharSequence)paramContext);
        paramContext = (ImageView)((View)localObject1).findViewById(2131309740);
        paramViewGroup = com.tencent.mm.api.b.u(paramViewGroup.Mzi, 2);
        localObject1 = new com.tencent.mm.av.a.a.c.a().bdp().dr(this.BlD, this.BlD).OU("radius_" + this.radius).tz(2131234473).a((com.tencent.mm.av.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.av.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).OS(com.tencent.mm.pluginsdk.model.s.bdu(paramViewGroup)).bdv();
        localObject2 = new b(paramViewGroup, paramContext);
        localObject2 = new com.tencent.mm.pluginsdk.ui.applet.m(3, this.BlD, this.BlD, true, true, this.radius, (m.a)localObject2);
        com.tencent.mm.av.q.bcV().a(paramViewGroup, paramContext, (com.tencent.mm.av.a.a.c)localObject1, (com.tencent.mm.av.a.c.h)localObject2);
        break label261;
        paramContactWidgetNewBizInfo = null;
        break;
        label697:
        paramContext = LayoutInflater.from(paramContext).inflate(2131493748, paramViewGroup, false);
        p.g(paramContext, "LayoutInflater.from(cont…o_channel, parent, false)");
        this.view = paramContext;
        this.view.setTag(paramdey);
        break label76;
        label735:
        i = 0;
        break label114;
        label741:
        paramContext = paramContactWidgetNewBizInfo.getContext();
        p.g(paramContext, "context");
        paramContext = (CharSequence)paramContext.getResources().getString(2131756802);
        break label128;
        label769:
        i = 0;
        break label179;
        label775:
        paramContext = paramContactWidgetNewBizInfo.getContext();
        p.g(paramContext, "context");
        paramContext = (CharSequence)paramContext.getResources().getString(2131756801);
        break label193;
        label803:
        paramContext = ae.SYK;
        paramContext = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(j), Integer.valueOf(k) }, 2));
        p.g(paramContext, "java.lang.String.format(format, *args)");
      }
      label848:
      paramContext = this.view.findViewById(2131307165);
      if (paramContext != null)
      {
        paramContext.setOnClickListener((View.OnClickListener)new a(this, paramdey));
        AppMethodBeat.o(169914);
        return;
      }
      AppMethodBeat.o(169914);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(c.g paramg, dey paramdey) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(169911);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder$fillVideoChannel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramView = (CharSequence)paramdey.pTL;
        if ((paramView == null) || (paramView.length() == 0)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            paramView = new Intent();
            paramView.putExtra("rawUrl", paramdey.pTL);
            localObject = this.BlE.BkB.eFa();
            p.g(localObject, "widget.contact");
            paramView.putExtra("geta8key_username", ((as)localObject).getUsername());
            com.tencent.mm.br.c.b(this.BlE.context, "webview", ".ui.tools.WebViewUI", paramView);
            paramView = this.BlE.BkB.eFa();
            p.g(paramView, "widget.contact");
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(paramView.getUsername(), 1402, this.BlE.BkB.eFd(), this.BlE.BkB.ahy());
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder$fillVideoChannel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169911);
          return;
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder$fillVideoItem$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
    public static final class b
      implements m.a
    {
      b(String paramString, ImageView paramImageView) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(169912);
        c.c localc = c.BkE;
        Log.v(c.access$getTAG$cp(), "imageUrl onFinish:" + this.tra);
        paramContext.setBackgroundResource(2131233974);
        AppMethodBeat.o(169912);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(169913);
        c.c localc = c.BkE;
        Log.v(c.access$getTAG$cp(), "imageUrl onStart:" + this.tra);
        AppMethodBeat.o(169913);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "", "()V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "app_release"})
  static abstract class h {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.c
 * JD-Core Version:    0.7.0.1
 */