package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.acj;
import com.tencent.mm.protocal.protobuf.dda;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.protocal.protobuf.mx;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.h.a;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
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
import kotlin.g;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter$Interpolator;", "ui", "Lcom/tencent/mm/ui/MMActivity;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "orginAdapter", "Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;", "footer", "", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Lcom/tencent/mm/ui/base/preference/MMPreferenceAdapter;[Ljava/lang/String;)V", "adapter", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;)V", "brandService", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "getBrandService", "()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "brandService$delegate", "Lkotlin/Lazy;", "changedPlayId", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getExpandSet", "()Ljava/util/HashSet;", "getFooter", "()[Ljava/lang/String;", "[Ljava/lang/String;", "isBizPayOpen", "", "()Z", "originalCount", "getOriginalCount", "()I", "setOriginalCount", "(I)V", "getUi", "()Lcom/tencent/mm/ui/MMActivity;", "getWidget", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "getCount", "getFooterCount", "getItem", "", "position", "getRelativePosition", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "isInterpolated", "onMusicStateChanged", "", "event", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "preloadPage", "fromPosition", "toPosition", "update", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "notifyInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "BizMsgViewHolder", "CommonSlotViewModel", "Companion", "SlotType", "SlotViewModel", "TopSlotViewModel", "VideoChannelViewHolder", "ViewHolder", "app_release"})
public final class b
  implements h.a
{
  public static final b.c HeR;
  private static final String TAG = "MicroMsg.NewBizInfoAdapter";
  public a HeH;
  private String HeI;
  private int HeJ;
  private final kotlin.f HeK;
  final boolean HeL;
  private final HashSet<Integer> HeM;
  final MMActivity HeN;
  final ContactWidgetNewBizInfo HeO;
  public final com.tencent.mm.ui.base.preference.h HeP;
  private final String[] HeQ;
  
  static
  {
    AppMethodBeat.i(39720);
    HeR = new b.c((byte)0);
    TAG = "MicroMsg.NewBizInfoAdapter";
    AppMethodBeat.o(39720);
  }
  
  public b(MMActivity paramMMActivity, ContactWidgetNewBizInfo paramContactWidgetNewBizInfo, com.tencent.mm.ui.base.preference.h paramh, String[] paramArrayOfString)
  {
    AppMethodBeat.i(39727);
    this.HeN = paramMMActivity;
    this.HeO = paramContactWidgetNewBizInfo;
    this.HeP = paramh;
    this.HeQ = paramArrayOfString;
    com.tencent.mm.plugin.brandservice.b.d.init();
    this.HeH = new a();
    this.HeI = "none";
    this.HeK = g.ar((kotlin.g.a.a)b.i.HfS);
    paramMMActivity = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
    p.j(paramMMActivity, "MMKernel.service(IBrandService::class.java)");
    this.HeL = ((com.tencent.mm.plugin.brandservice.a.c)paramMMActivity).cyB();
    this.HeM = new HashSet();
    AppMethodBeat.o(39727);
  }
  
  private final int fqZ()
  {
    AppMethodBeat.i(39721);
    String[] arrayOfString = this.HeQ;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      int k = this.HeP.byJ(str);
      if (k != -1)
      {
        i = this.HeJ;
        AppMethodBeat.o(39721);
        return i - k;
      }
      i += 1;
    }
    AppMethodBeat.o(39721);
    return 0;
  }
  
  private final com.tencent.mm.plugin.brandservice.a.c fra()
  {
    AppMethodBeat.i(39725);
    com.tencent.mm.plugin.brandservice.a.c localc = (com.tencent.mm.plugin.brandservice.a.c)this.HeK.getValue();
    AppMethodBeat.o(39725);
    return localc;
  }
  
  public final int abD(int paramInt)
  {
    AppMethodBeat.i(39722);
    this.HeJ = paramInt;
    int i = this.HeH.getSize();
    AppMethodBeat.o(39722);
    return i + paramInt;
  }
  
  public final boolean abE(int paramInt)
  {
    AppMethodBeat.i(39723);
    int i = fqZ();
    if ((paramInt >= this.HeJ - i) && (paramInt < this.HeP.getCount() - i))
    {
      AppMethodBeat.o(39723);
      return true;
    }
    AppMethodBeat.o(39723);
    return false;
  }
  
  public final int abF(int paramInt)
  {
    AppMethodBeat.i(39724);
    int i = this.HeP.getCount();
    if (paramInt >= i - fqZ())
    {
      int j = this.HeJ;
      AppMethodBeat.o(39724);
      return j + paramInt - i;
    }
    AppMethodBeat.o(39724);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39726);
    paramInt = paramInt - this.HeJ + fqZ();
    Object localObject1 = this.HeH.abA(paramInt);
    Object localObject2;
    Object localObject3;
    switch (e.$EnumSwitchMapping$0[localObject1.ordinal()])
    {
    default: 
      paramView = LayoutInflater.from((Context)this.HeN.getContext()).inflate(R.i.eeZ, paramViewGroup, false);
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      break;
    case 1: 
      paramView = LayoutInflater.from((Context)this.HeN.getContext()).inflate(R.i.efa, paramViewGroup, false);
      this.HeO.aDi();
      AppMethodBeat.o(39726);
      return paramView;
    case 2: 
      localObject1 = this.HeH.getItem(paramInt);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      localObject1 = (oo)localObject1;
      if ((((oo)localObject1).RWw.COi == 49) && (fra().Gw(16)))
      {
        localObject2 = fra();
        localObject3 = ((oo)localObject1).RWB.RTM;
        p.j(localObject3, "bizMessage.AppMsg.DetailInfo");
        Object localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          my localmy = (my)((Iterator)localObject4).next();
          ((Collection)localObject3).add(j.listOf(new String[] { localmy.RTk, String.valueOf(localmy.lpx) }));
        }
        ((com.tencent.mm.plugin.brandservice.a.c)localObject2).j((List)localObject3, 126);
      }
      paramView = new a(this, paramView, paramViewGroup, (oo)localObject1, this.HeM, paramInt / 2).view;
      AppMethodBeat.o(39726);
      return paramView;
    case 3: 
      localObject1 = this.HeN.getContext();
      p.j(localObject1, "ui.context");
      localObject1 = (Context)localObject1;
      localObject2 = this.HeO;
      localObject3 = this.HeH.getItem(paramInt);
      if (localObject3 == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ProfileNotifyInfo");
        AppMethodBeat.o(39726);
        throw paramView;
      }
      paramView = new g((Context)localObject1, (ContactWidgetNewBizInfo)localObject2, paramView, paramViewGroup, (dor)localObject3).view;
      AppMethodBeat.o(39726);
      return paramView;
    }
    paramView = (ViewGroup)paramView;
    paramViewGroup = (TextView)paramView.findViewById(R.h.dtW);
    if (paramViewGroup != null) {
      paramViewGroup.setText((CharSequence)this.HeH.abz(paramInt));
    }
    paramView = (View)paramView;
    AppMethodBeat.o(39726);
    return paramView;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "interpolator", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "bizMsg", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "position", "(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator;Landroid/view/View;Landroid/view/ViewGroup;Lcom/tencent/mm/protocal/protobuf/BizMessage;Ljava/util/HashSet;I)V", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "isBizPayOpen", "", "()Z", "setBizPayOpen", "(Z)V", "view", "getView", "()Landroid/view/View;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "fillCommonSlot", "", "container", "detail", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "base", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "fillSingleText", "text", "Lcom/tencent/mm/protocal/protobuf/BizTextMsgInfo;", "Lcom/tencent/mm/protocal/protobuf/CommMsgBaseInfo;", "fillSlotTarget", "fillTopSlot", "commBase", "getPlayId", "", "isPlaying", "playId", "firstNotEmpty", "", "([Ljava/lang/String;)Ljava/lang/String;", "app_release"})
  static final class a
    extends b.h
  {
    private boolean HeL;
    private HashSet<Integer> HeM;
    ContactWidgetNewBizInfo HeO;
    Context context;
    Intent intent;
    final View view;
    
    public a(b paramb, View paramView, ViewGroup paramViewGroup, oo paramoo, HashSet<Integer> paramHashSet, int paramInt)
    {
      AppMethodBeat.i(39645);
      this.HeL = true;
      Object localObject1 = paramb.HeN.getContext();
      p.j(localObject1, "interpolator.ui.context");
      this.context = ((Context)localObject1);
      this.HeO = paramb.HeO;
      localObject1 = paramb.HeN.getIntent();
      p.j(localObject1, "interpolator.ui.intent");
      this.intent = ((Intent)localObject1);
      this.HeM = paramHashSet;
      this.HeL = paramb.HeL;
      if (paramView != null) {
        paramHashSet = paramView.getTag();
      }
      Object localObject2;
      int i;
      while (p.h(paramHashSet, paramoo))
      {
        localObject2 = paramoo.RWB;
        paramHashSet = this;
        localObject1 = paramView;
        if (localObject2 != null)
        {
          localObject2 = ((mz)localObject2).RTM;
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
                localObject1 = (my)paramHashSet.next();
                p.j(localObject1, "detail");
                if (p.h(a((my)localObject1), b.a(paramb)))
                {
                  b.a(paramb, "none");
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
      paramb = LayoutInflater.from(this.context).inflate(R.i.eeX, paramViewGroup, false);
      if (paramb == null)
      {
        paramb = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(39645);
        throw paramb;
      }
      paramView = (ViewGroup)paramb;
      paramView.setTag(this);
      switch (paramoo.RWw.COi)
      {
      }
      int j;
      label659:
      label709:
      label767:
      do
      {
        do
        {
          for (;;)
          {
            localObject1 = (View)paramView;
            paramHashSet = this;
            break;
            paramb = paramoo.RWx;
            p.j(paramb, "bizMsg.Text");
            paramoo = paramoo.RWw;
            p.j(paramoo, "bizMsg.BaseInfo");
            paramViewGroup = new b.f(10, b.d.Hfi, paramView);
            paramInt = paramoo.HlE;
            paramoo = this.HeM;
            paramb = paramb.lpy;
            p.j(paramb, "text.Content");
            paramViewGroup.a(paramInt, paramoo, paramb);
          }
          j = paramoo.RWB.RTM.size();
          if (j <= 1) {
            break label1010;
          }
          paramb = b.d.Hff;
          if (paramoo.RWB.RTK.RTh == 0) {
            break label1327;
          }
          paramViewGroup = paramoo.RWB.RTM.get(0);
          p.j(paramViewGroup, "bizMsg.AppMsg.DetailInfo[0]");
          paramViewGroup = (my)paramViewGroup;
          paramHashSet = paramoo.RWB.RTK;
          p.j(paramHashSet, "bizMsg.AppMsg.BaseInfo");
          localObject2 = paramoo.RWw;
          p.j(localObject2, "bizMsg.BaseInfo");
          localObject1 = b.HeR;
          Log.v(b.access$getTAG$cp(), "fillTopSlot:" + paramViewGroup.RTk);
          localObject1 = new b.f(paramViewGroup.lpx, paramb, paramView);
          if ((paramViewGroup.lpx != 8) && (paramViewGroup.lpx != 10))
          {
            ((b.f)localObject1).Hfd = paramViewGroup.RTG;
            ((b.f)localObject1).url = paramViewGroup.RTk;
            String str = paramViewGroup.fwr;
            p.j(str, "detail.Title");
            ((b.f)localObject1).setTitle(str);
          }
          if (paramb == b.d.Hfi)
          {
            paramb = (CharSequence)paramViewGroup.RTi;
            if ((paramb != null) && (!kotlin.n.n.ba(paramb))) {
              break label1017;
            }
            i = 1;
            if (i == 0) {
              ((MMNeat7extView)((b.f)localObject1).HfJ.getValue()).aL((CharSequence)paramViewGroup.RTi);
            }
          }
          paramb = (CharSequence)paramViewGroup.RTz;
          if ((paramb != null) && (!kotlin.n.n.ba(paramb))) {
            break label1023;
          }
          i = 1;
          if (i == 0)
          {
            paramb = ((b.f)localObject1).fre();
            p.j(paramb, "view.showDescTv");
            paramb.setText((CharSequence)paramViewGroup.RTz);
          }
          paramb = ((b.f)localObject1).fre();
          if (paramb != null)
          {
            if ((((b.f)localObject1).Hfd != 1) || (this.HeL)) {
              break label1029;
            }
            i = 4;
            paramb.setVisibility(i);
          }
          switch (paramViewGroup.lpx)
          {
          case 6: 
          default: 
            switch (paramViewGroup.lpx)
            {
            case 8: 
            case 9: 
            default: 
              switch (paramViewGroup.lpx)
              {
              default: 
                paramb = new String[2];
                paramb[0] = paramViewGroup.RTm;
                paramb[1] = paramViewGroup.RTo;
                ((b.f)localObject1).setImageUrl(M(paramb));
                a((View)((b.f)localObject1).frf(), paramViewGroup, paramHashSet, paramInt);
              }
              break;
            }
            break;
          }
        } while (j <= 1);
        i = 1;
      } while (i >= j);
      label808:
      label891:
      paramb = paramoo.RWB.RTM.get(i);
      label917:
      label926:
      p.j(paramb, "bizMsg.AppMsg.DetailInfo[i]");
      paramViewGroup = (my)paramb;
      paramHashSet = paramoo.RWB.RTK;
      p.j(paramHashSet, "bizMsg.AppMsg.BaseInfo");
      if (i == j - 1) {}
      for (paramb = b.d.Hfh;; paramb = b.d.Hfg)
      {
        a(paramView, paramViewGroup, paramHashSet, paramb, paramInt);
        i += 1;
        break label926;
        label1010:
        paramb = b.d.Hfi;
        break;
        label1017:
        i = 0;
        break label659;
        label1023:
        i = 0;
        break label709;
        label1029:
        i = 0;
        break label767;
        paramb = (TextView)((b.f)localObject1).HfE.getValue();
        p.j(paramb, "view.videoDurationTv");
        paramb.setText((CharSequence)com.tencent.mm.aj.m.uD(paramViewGroup.RTy));
        break label808;
        paramb = (TextView)((b.f)localObject1).HfF.getValue();
        p.j(paramb, "view.voiceDurationTv");
        paramb.setText((CharSequence)com.tencent.mm.aj.m.uD(paramViewGroup.RTt));
        break label808;
        if (paramViewGroup.EFG <= 1) {
          break label808;
        }
        paramb = (TextView)((b.f)localObject1).Hfb.getValue();
        p.j(paramb, "view.picCntTv");
        paramb.setText((CharSequence)String.valueOf(paramViewGroup.EFG));
        break label808;
        paramb = (CharSequence)paramViewGroup.RTi;
        if ((paramb == null) || (kotlin.n.n.ba(paramb)))
        {
          i = 1;
          label1179:
          if (i != 0) {
            break label1203;
          }
        }
        label1203:
        for (boolean bool = true;; bool = false)
        {
          ((b.f)localObject1).wg(bool);
          break;
          i = 0;
          break label1179;
        }
        i = ((acj)localObject2).HlE;
        paramb = this.HeM;
        localObject2 = paramViewGroup.fwr;
        p.j(localObject2, "detail.Title");
        ((b.f)localObject1).a(i, paramb, (String)localObject2);
        paramb = (CharSequence)paramViewGroup.RTz;
        if ((paramb == null) || (kotlin.n.n.ba(paramb))) {}
        for (i = 1; i == 0; i = 0)
        {
          paramb = ((b.f)localObject1).fre();
          p.j(paramb, "view.showDescTv");
          paramb.setText((CharSequence)paramViewGroup.RTz);
          break;
        }
        paramb = new String[2];
        paramb[0] = paramViewGroup.RTo;
        paramb[1] = paramViewGroup.RTm;
        break label891;
        label1327:
        paramViewGroup = paramoo.RWB.RTM.get(0);
        p.j(paramViewGroup, "bizMsg.AppMsg.DetailInfo[0]");
        paramViewGroup = (my)paramViewGroup;
        paramHashSet = paramoo.RWB.RTK;
        p.j(paramHashSet, "bizMsg.AppMsg.BaseInfo");
        a(paramView, paramViewGroup, paramHashSet, paramb, paramInt);
        break label917;
      }
    }
    
    private static String M(String[] paramArrayOfString)
    {
      AppMethodBeat.i(39640);
      int i = 0;
      Object localObject;
      int j;
      if (i < 2)
      {
        localObject = paramArrayOfString[i];
        CharSequence localCharSequence = (CharSequence)localObject;
        if ((localCharSequence == null) || (kotlin.n.n.ba(localCharSequence)))
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
    
    private static String a(my parammy)
    {
      AppMethodBeat.i(39643);
      parammy = parammy.RTk;
      p.j(parammy, "detail.ContentUrl");
      parammy = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.apJ(parammy);
      AppMethodBeat.o(39643);
      return parammy;
    }
    
    private final void a(View paramView, final my parammy, final mx parammx, final int paramInt)
    {
      AppMethodBeat.i(39644);
      ImageView localImageView;
      b localb;
      c localc;
      final String str;
      if (parammy.lpx == 7)
      {
        localImageView = (ImageView)paramView.findViewById(R.h.duk);
        if (localImageView != null)
        {
          localb = new b(localImageView);
          localc = new c(localImageView);
          str = a(parammy);
          if (!hA(str)) {
            break label120;
          }
          localb.invoke();
        }
      }
      for (;;)
      {
        localImageView.setOnClickListener((View.OnClickListener)new a(localb, str, this, parammy));
        paramView.setOnClickListener((View.OnClickListener)new d(this, parammy, parammx, paramInt));
        AppMethodBeat.o(39644);
        return;
        label120:
        localc.invoke();
      }
    }
    
    private final void a(ViewGroup paramViewGroup, my parammy, mx parammx, b.d paramd, int paramInt)
    {
      AppMethodBeat.i(39641);
      b.c localc = b.HeR;
      Log.v(b.access$getTAG$cp(), "fillCommonSlot:" + parammy.RTk);
      paramd = new b.b(parammy.lpx, paramd, paramViewGroup);
      paramd.Hfd = parammy.RTG;
      paramd.url = parammy.RTk;
      paramViewGroup = parammy.fwr;
      p.j(paramViewGroup, "detail.Title");
      paramd.setTitle(paramViewGroup);
      paramViewGroup = (CharSequence)parammy.RTz;
      int i;
      if ((paramViewGroup == null) || (kotlin.n.n.ba(paramViewGroup)))
      {
        i = 1;
        if (i == 0)
        {
          paramViewGroup = paramd.fre();
          p.j(paramViewGroup, "view.showDescTv");
          paramViewGroup.setText((CharSequence)parammy.RTz);
        }
        paramViewGroup = paramd.fre();
        if (paramViewGroup != null)
        {
          if ((paramd.Hfd != 1) || (this.HeL)) {
            break label305;
          }
          i = 4;
          label169:
          paramViewGroup.setVisibility(i);
        }
        if ((parammy.lpx == 8) && (parammy.EFG > 1))
        {
          paramViewGroup = (TextView)paramd.Hfb.getValue();
          p.j(paramViewGroup, "view.picCntTv");
          paramViewGroup.setText((CharSequence)String.valueOf(parammy.EFG));
        }
        switch (parammy.lpx)
        {
        default: 
          paramViewGroup = new String[2];
          paramViewGroup[0] = parammy.RTn;
          paramViewGroup[1] = parammy.RTm;
        }
      }
      for (;;)
      {
        paramd.setImageUrl(M(paramViewGroup));
        a((View)paramd.frf(), parammy, parammx, paramInt);
        AppMethodBeat.o(39641);
        return;
        i = 0;
        break;
        label305:
        i = 0;
        break label169;
        paramViewGroup = new String[2];
        paramViewGroup[0] = parammy.RTm;
        paramViewGroup[1] = parammy.RTn;
      }
    }
    
    private static boolean hA(String paramString)
    {
      AppMethodBeat.i(39642);
      com.tencent.mm.bb.f localf = com.tencent.mm.bb.a.bnA();
      if (localf != null)
      {
        if ((p.h(localf.lVt, paramString)) && (localf.lVr == 0) && (com.tencent.mm.bb.a.bnx()))
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
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$1$3"})
    static final class a
      implements View.OnClickListener
    {
      a(b.a.b paramb, String paramString, b.a parama, my parammy) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(39634);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        this.HeS.invoke();
        localObject = new e.g();
        e.h localh = new e.h();
        localh.QuD = str;
        localh.url = parammy.RTk;
        localh.title = parammy.fwr;
        localh.lpY = "";
        localh.playUrl = parammy.RTu;
        localh.coverUrl = parammy.RTm;
        ((e.g)localObject).XeN = localh;
        paramView.setTag(localObject);
        s.hL(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39634);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"drawPlaying", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(ImageView paramImageView)
      {
        super();
      }
      
      public final void invoke()
      {
        AppMethodBeat.i(39636);
        this.wXn.setImageResource(R.g.dmz);
        Object localObject = this.wXn.getDrawable();
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
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"drawPlay", "", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      c(ImageView paramImageView)
      {
        super();
      }
      
      public final void invoke()
      {
        AppMethodBeat.i(39638);
        this.wXn.setImageResource(R.g.dmy);
        AppMethodBeat.o(39638);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(b.a parama, my parammy, mx parammx, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(39639);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramView = b.HeR;
        Log.i(b.access$getTAG$cp(), "onClick jump to url:%s", new Object[] { parammy.RTk });
        int i = this.HeU.intent.getIntExtra("KOpenArticleSceneFromScene", -1);
        paramView = new Intent();
        localObject1 = com.tencent.mm.aj.m.e(parammy.RTk, 126, i, 0);
        paramView.putExtra("rawUrl", (String)localObject1);
        paramView.putExtra("useJs", true);
        paramView.putExtra("vertical_scroll", true);
        paramView.putExtra("geta8key_scene", 3);
        Object localObject2 = this.HeU.HeO.fqR();
        p.j(localObject2, "widget.contact");
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
          if ((!((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(6)) || (!((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(this.HeU.context, (String)localObject1, parammy.lpx, 126, i, paramView))) {
            break label436;
          }
          paramView = b.HeR;
          Log.i(b.access$getTAG$cp(), "jump to TmplWebview");
        }
        for (;;)
        {
          paramView = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.Hgc;
          paramView = this.HeU.HeO.fqR();
          p.j(paramView, "widget.contact");
          paramView = paramView.getUsername();
          p.j(paramView, "widget.contact.username");
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.a(paramView, this.HeU.HeO.amU(), parammx.RTg, parammy.RTj, parammy.lpx, paramInt, parammx.CreateTime, this.HeU.HeO.fqU());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$BizMsgViewHolder$fillSlotTarget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(39639);
          return;
          paramView.putExtra("prePublishId", "brand_profile");
          paramView.putExtra("KPublisherId", "brand_profile");
          break;
          label436:
          com.tencent.mm.by.c.b(this.HeU.context, "webview", ".ui.tools.WebViewUI", paramView);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$CommonSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "picCntTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "Lkotlin/Lazy;", "picInfo", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getPicInfo", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "picInfo$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "titleTv$delegate", "url", "getUrl", "setUrl", "weakPicInfo", "Ljava/lang/ref/WeakReference;", "getWeakPicInfo", "()Ljava/lang/ref/WeakReference;", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "app_release"})
  static final class b
    extends b.e
  {
    private final kotlin.f DHR;
    private final int HeY;
    private final kotlin.f HeZ;
    private final WeakReference<ConstraintLayout> Hfa;
    final kotlin.f Hfb;
    private final kotlin.f Hfc;
    int Hfd;
    private String title;
    String url;
    
    public b(int paramInt, b.d paramd, ViewGroup paramViewGroup)
    {
      super(paramd, paramViewGroup);
      AppMethodBeat.i(39658);
      this.HeY = R.g.don;
      this.HeZ = g.ar((kotlin.g.a.a)new b(this));
      this.Hfa = new WeakReference((ConstraintLayout)this.HeZ.getValue());
      this.Hfb = g.ar((kotlin.g.a.a)new a(this));
      this.Hfc = g.ar((kotlin.g.a.a)new c(this));
      this.DHR = g.ar((kotlin.g.a.a)new d(this));
      this.url = "";
      this.title = "";
      AppMethodBeat.o(39658);
    }
    
    protected final void a(View paramView, b.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(39653);
      p.k(paramView, "container");
      p.k(paramd, "slotType");
      switch (c.$EnumSwitchMapping$0[paramd.ordinal()])
      {
      default: 
        localObject = paramView.findViewById(R.h.dum);
        p.j(localObject, "container.findViewById<F…id.biz_slot_voice_layout)");
        ((FrameLayout)localObject).setVisibility(8);
        switch (getItemShowType())
        {
        case 6: 
        case 9: 
        default: 
          localObject = paramView.findViewById(R.h.dtY);
          p.j(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
          ((ImageView)localObject).setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        super.a(paramView, paramd, paramBoolean);
        AppMethodBeat.o(39653);
        return;
        localObject = paramView.findViewById(R.h.dtV);
        p.j(localObject, "container.findViewById<V…d.biz_slot_common_line_v)");
        ((View)localObject).setVisibility(0);
        break;
        localObject = paramView.findViewById(R.h.dtY);
        p.j(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject).setVisibility(0);
        localObject = paramView.findViewById(R.h.duj);
        p.j(localObject, "container.findViewById<I….biz_slot_video_play_img)");
        ((ImageView)localObject).setVisibility(0);
        continue;
        localObject = paramView.findViewById(R.h.dtY);
        p.j(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
        ((ImageView)localObject).setVisibility(0);
        localObject = paramView.findViewById(R.h.dtU);
        p.j(localObject, "container.findViewById<C…slot_common_content_desc)");
        ((ConstraintLayout)localObject).setVisibility(0);
        continue;
        localObject = paramView.findViewById(R.h.dum);
        p.j(localObject, "container.findViewById<F…id.biz_slot_voice_layout)");
        ((FrameLayout)localObject).setVisibility(0);
      }
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)paramView.findViewById(R.h.duf);
      p.j(localMMNeat7extView, "tv");
      if ((localMMNeat7extView.getLayoutParams() instanceof ConstraintLayout.LayoutParams))
      {
        localObject = localMMNeat7extView.getLayoutParams();
        if (localObject == null)
        {
          paramView = new t("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
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
        localObject = paramView.findViewById(R.h.dtY);
        p.j(localObject, "container.findViewById<I…iew>(R.id.biz_slot_image)");
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
      p.k(paramContext, "context");
      p.k(paramViewGroup, "container");
      paramContext = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.eeY, paramViewGroup, false);
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
    
    protected final void frb()
    {
      AppMethodBeat.i(39654);
      if (this.Hfa == null)
      {
        AppMethodBeat.o(39654);
        return;
      }
      ConstraintLayout localConstraintLayout = (ConstraintLayout)this.Hfa.get();
      if (localConstraintLayout != null)
      {
        localConstraintLayout.setBackgroundResource(R.g.biz_msg_cover_gradient_mask);
        AppMethodBeat.o(39654);
        return;
      }
      AppMethodBeat.o(39654);
    }
    
    protected final float[] frc()
    {
      AppMethodBeat.i(39655);
      float[] arrayOfFloat = kotlin.a.e.b(new Float[] { Float.valueOf(bP(1.0F)), Float.valueOf(bP(1.0F)), Float.valueOf(bP(1.0F)), Float.valueOf(bP(1.0F)) });
      AppMethodBeat.o(39655);
      return arrayOfFloat;
    }
    
    protected final int frd()
    {
      return this.HeY;
    }
    
    public final TextView fre()
    {
      AppMethodBeat.i(39656);
      TextView localTextView = (TextView)this.Hfc.getValue();
      AppMethodBeat.o(39656);
      return localTextView;
    }
    
    public final void setTitle(String paramString)
    {
      AppMethodBeat.i(39657);
      p.k(paramString, "value");
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.DHR.getValue();
      p.j(localMMNeat7extView, "titleTv");
      a(localMMNeat7extView, paramString, this.Hfd, this.url, 5);
      AppMethodBeat.o(39657);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      a(b.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/constraintlayout/widget/ConstraintLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ConstraintLayout>
    {
      b(b.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      c(b.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMNeat7extView>
    {
      d(b.b paramb)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "", "(Ljava/lang/String;I)V", "TOP", "COMMON", "BOTTOM", "SINGLE", "app_release"})
  static enum d
  {
    static
    {
      AppMethodBeat.i(39659);
      d locald1 = new d("TOP", 0);
      Hff = locald1;
      d locald2 = new d("COMMON", 1);
      Hfg = locald2;
      d locald3 = new d("BOTTOM", 2);
      Hfh = locald3;
      d locald4 = new d("SINGLE", 3);
      Hfi = locald4;
      Hfj = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(39659);
    }
    
    private d() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "audioPadding", "getAudioPadding", "()I", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "imageDefaultRes", "getImageDefaultRes", "imageIv", "Landroid/widget/ImageView;", "getImageIv", "()Landroid/widget/ImageView;", "imageIv$delegate", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "value", "", "imageUrl", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "item", "getItem", "()Landroid/view/ViewGroup;", "item$delegate", "getItemShowType", "largePading", "getLargePading", "listPadding", "getListPadding", "normalPading", "getNormalPading", "getSlotType", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "smallPadding", "getSmallPadding", "dpToPixel", "", "getDpToPixel", "(F)F", "resFromRaw", "getResFromRaw", "(I)F", "resToPixel", "getResToPixel", "(I)I", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "onImageLoadFinish", "onImageLoadStart", "setNeatText", "neatText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "isPayMsg", "url", "scene", "app_release"})
  static class e
  {
    private final int HeY;
    private final kotlin.f Hfk;
    private final kotlin.f Hfl;
    private final int Hfm;
    private final int Hfn;
    private final int Hfo;
    private final int Hfp;
    private final int Hfq;
    private final float[] Hfr;
    final b.d Hfs;
    String imageUrl;
    private final int llp;
    private final kotlin.f xwp;
    
    public e(int paramInt, b.d paramd, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39679);
      this.llp = paramInt;
      this.Hfs = paramd;
      this.Hfk = g.ar((kotlin.g.a.a)new e(this, paramViewGroup));
      this.Hfl = g.ar((kotlin.g.a.a)new b(this));
      this.xwp = g.ar((kotlin.g.a.a)new a(this));
      this.Hfm = ((int)bP(36.0F));
      paramInt = R.f.ListPadding;
      this.Hfn = MMApplicationContext.getResources().getDimensionPixelSize(paramInt);
      paramInt = R.f.NormalPadding;
      this.Hfo = MMApplicationContext.getResources().getDimensionPixelSize(paramInt);
      paramInt = R.f.LargePadding;
      this.Hfp = MMApplicationContext.getResources().getDimensionPixelSize(paramInt);
      paramInt = R.f.SmallPadding;
      this.Hfq = MMApplicationContext.getResources().getDimensionPixelSize(paramInt);
      this.Hfr = kotlin.a.e.b(new Float[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) });
      this.HeY = R.e.chatting_item_biz_default_bg;
      this.imageUrl = "";
      AppMethodBeat.o(39679);
    }
    
    protected static float bP(float paramFloat)
    {
      AppMethodBeat.i(39678);
      Resources localResources = MMApplicationContext.getResources();
      p.j(localResources, "MMApplicationContext.getResources()");
      float f = localResources.getDisplayMetrics().density;
      AppMethodBeat.o(39678);
      return f * paramFloat + 0.5F;
    }
    
    protected void a(View paramView, b.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(39674);
      p.k(paramView, "container");
      p.k(paramd, "slotType");
      int i;
      switch (d.$EnumSwitchMapping$0[paramd.ordinal()])
      {
      default: 
        AppMethodBeat.o(39674);
        return;
      case 1: 
        paramView.setPadding(this.Hfp, this.Hfq, this.Hfp, 0);
        if (paramBoolean) {}
        for (i = R.g.dmu;; i = R.g.dmt)
        {
          paramView.setBackgroundResource(i);
          AppMethodBeat.o(39674);
          return;
        }
      case 2: 
        paramView.setPadding(this.Hfp, this.Hfq, this.Hfp, 0);
        i = R.g.dmq;
      }
      for (;;)
      {
        paramView.setBackgroundResource(i);
        break;
        paramView.setPadding(this.Hfp, this.Hfq, this.Hfp, this.Hfp);
        i = R.g.dmp;
        continue;
        paramView.setPadding(this.Hfp, this.Hfq, this.Hfp, this.Hfq);
        if (paramBoolean) {
          i = R.g.dms;
        } else {
          i = R.g.dmr;
        }
      }
    }
    
    protected final void a(MMNeat7extView paramMMNeat7extView, String paramString1, int paramInt1, String paramString2, int paramInt2)
    {
      boolean bool = true;
      AppMethodBeat.i(39676);
      p.k(paramMMNeat7extView, "neatText");
      p.k(paramString1, "text");
      paramString1 = com.tencent.mm.pluginsdk.ui.span.l.c(paramMMNeat7extView.getContext(), (CharSequence)paramString1);
      if ((this.llp == 0) && (paramInt1 == 1)) {}
      for (;;)
      {
        com.tencent.mm.plugin.brandservice.b.b localb = com.tencent.mm.plugin.brandservice.b.b.svR;
        p.j(paramString1, "text");
        localb.a((CharSequence)paramString1, paramMMNeat7extView, bool, paramString2, paramInt2);
        paramMMNeat7extView.setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.h((NeatTextView)paramMMNeat7extView, (View.OnTouchListener)new o(paramMMNeat7extView.getContext())));
        AppMethodBeat.o(39676);
        return;
        bool = false;
      }
    }
    
    protected ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39672);
      p.k(paramContext, "context");
      p.k(paramViewGroup, "container");
      paramContext = (Throwable)new kotlin.n();
      AppMethodBeat.o(39672);
      throw paramContext;
    }
    
    protected void frb() {}
    
    protected float[] frc()
    {
      return this.Hfr;
    }
    
    protected int frd()
    {
      return this.HeY;
    }
    
    public final ViewGroup frf()
    {
      AppMethodBeat.i(39670);
      ViewGroup localViewGroup = (ViewGroup)this.Hfk.getValue();
      AppMethodBeat.o(39670);
      return localViewGroup;
    }
    
    final ImageView frg()
    {
      AppMethodBeat.i(39671);
      ImageView localImageView = (ImageView)this.Hfl.getValue();
      AppMethodBeat.o(39671);
      return localImageView;
    }
    
    protected final int frh()
    {
      return this.Hfm;
    }
    
    protected final int fri()
    {
      return this.Hfo;
    }
    
    protected final int frj()
    {
      return this.Hfp;
    }
    
    protected void frk() {}
    
    protected final Context getContext()
    {
      AppMethodBeat.i(39673);
      Context localContext = (Context)this.xwp.getValue();
      AppMethodBeat.o(39673);
      return localContext;
    }
    
    public final int getItemShowType()
    {
      return this.llp;
    }
    
    public final void setImageUrl(String paramString)
    {
      AppMethodBeat.i(39677);
      p.k(paramString, "value");
      if (kotlin.n.n.ba((CharSequence)paramString)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(39677);
        return;
      }
      paramString = com.tencent.mm.api.b.M(paramString, 2);
      p.j(paramString, "BizImageStrategy.getUrl(…rategy.SCENE_BIZ_PROFILE)");
      this.imageUrl = paramString;
      paramString = b.HeR;
      Log.v(b.access$getTAG$cp(), "imageUrl:" + this.imageUrl);
      paramString = frc();
      String str = this.imageUrl;
      Object localObject1 = new c.a().bmF();
      Object localObject2 = new StringBuilder("radius_");
      Object localObject3 = Arrays.toString(paramString);
      p.j(localObject3, "java.util.Arrays.toString(this)");
      localObject1 = ((c.a)localObject1).Ws((String)localObject3).wz(frd()).a((com.tencent.mm.ay.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.ay.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).Wq(w.bpO(this.imageUrl)).bmL();
      localObject2 = new d(this);
      localObject3 = new com.tencent.mm.pluginsdk.ui.applet.m(3, -1, -1, paramString, (m.a)localObject2);
      ((com.tencent.mm.pluginsdk.ui.applet.m)localObject3).aM((Runnable)new b.e.c(this, str, (com.tencent.mm.ay.a.a.c)localObject1, paramString, (d)localObject2));
      com.tencent.mm.ay.q.bml().a(str, frg(), (com.tencent.mm.ay.a.a.c)localObject1, (com.tencent.mm.ay.a.c.h)localObject3);
      AppMethodBeat.o(39677);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Context>
    {
      a(b.e parame)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ImageView>
    {
      b(b.e parame)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel$imageUrl$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
    public static final class d
      implements m.a
    {
      public final void onFinish()
      {
        AppMethodBeat.i(39666);
        b.c localc = b.HeR;
        Log.v(b.access$getTAG$cp(), "imageUrl onFinish:" + this.Hft.imageUrl);
        this.Hft.frb();
        AppMethodBeat.o(39666);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(39667);
        b.c localc = b.HeR;
        Log.v(b.access$getTAG$cp(), "imageUrl onStart:" + this.Hft.imageUrl);
        this.Hft.frk();
        AppMethodBeat.o(39667);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
    static final class e
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ViewGroup>
    {
      e(b.e parame, ViewGroup paramViewGroup)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$TopSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$SlotType;Landroid/view/ViewGroup;)V", "collapseTextLayout", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "getCollapseTextLayout", "()Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "collapseTextLayout$delegate", "Lkotlin/Lazy;", "descMask", "Landroid/view/View;", "getDescMask", "()Landroid/view/View;", "descMask$delegate", "digestTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getDigestTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "digestTv$delegate", "value", "", "hasAudioDesc", "getHasAudioDesc", "()Z", "setHasAudioDesc", "(Z)V", "hasDesc", "setHasDesc", "hasSingleInfo", "hasTitle", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "isSingleImage", "picCntTv", "Landroid/widget/TextView;", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "singleDescLayout", "getSingleDescLayout", "singleDescLayout$delegate", "singleTitleTv", "getSingleTitleTv", "singleTitleTv$delegate", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleDescViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "titleTv", "getTitleTv", "titleTv$delegate", "topMask", "Landroid/widget/ImageView;", "getTopMask", "()Landroid/widget/ImageView;", "topMask$delegate", "url", "getUrl", "setUrl", "videPlayImg", "getVidePlayImg", "videPlayImg$delegate", "videoDurationTv", "getVideoDurationTv", "videoDurationTv$delegate", "voiceDurationTv", "getVoiceDurationTv", "voiceDurationTv$delegate", "fillBackground", "", "selector", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "onImageLoadStart", "setText", "id", "expandSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "text", "setTitleDescTextColor", "color", "app_release"})
  static final class f
    extends b.e
  {
    private final kotlin.f DHR;
    boolean HfA;
    ArrayList<View> HfB;
    private final kotlin.f HfC;
    private final kotlin.f HfD;
    final kotlin.f HfE;
    final kotlin.f HfF;
    private final kotlin.f HfG;
    private final kotlin.f HfH;
    private final kotlin.f HfI;
    final kotlin.f HfJ;
    private final kotlin.f HfK;
    private boolean HfL;
    final kotlin.f Hfb;
    private final kotlin.f Hfc;
    int Hfd;
    private boolean Hfy;
    boolean Hfz;
    private String title;
    String url;
    
    public f(final int paramInt, b.d paramd, ViewGroup paramViewGroup)
    {
      super(paramd, paramViewGroup);
      AppMethodBeat.i(39713);
      this.url = "";
      this.HfB = new ArrayList();
      this.HfC = g.ar((kotlin.g.a.a)new l(this));
      this.HfD = g.ar((kotlin.g.a.a)new b(this));
      this.Hfc = g.ar((kotlin.g.a.a)new h(this));
      this.HfE = g.ar((kotlin.g.a.a)new n(this));
      this.HfF = g.ar((kotlin.g.a.a)new o(this));
      this.Hfb = g.ar((kotlin.g.a.a)new e(this));
      this.DHR = g.ar((kotlin.g.a.a)new k(this, paramInt));
      this.HfG = g.ar((kotlin.g.a.a)new m(this));
      this.HfH = g.ar((kotlin.g.a.a)new i(this));
      this.HfI = g.ar((kotlin.g.a.a)new j(this));
      this.HfJ = g.ar((kotlin.g.a.a)new c(this));
      this.HfK = g.ar((kotlin.g.a.a)new a(this));
      this.title = "";
      AppMethodBeat.o(39713);
    }
    
    private final boolean frm()
    {
      return (this.Hfs == b.d.Hfi) && (!this.HfA);
    }
    
    private final ImageView frn()
    {
      AppMethodBeat.i(39702);
      ImageView localImageView = (ImageView)this.HfC.getValue();
      AppMethodBeat.o(39702);
      return localImageView;
    }
    
    private final MMNeat7extView fro()
    {
      AppMethodBeat.i(39704);
      MMNeat7extView localMMNeat7extView = (MMNeat7extView)this.DHR.getValue();
      AppMethodBeat.o(39704);
      return localMMNeat7extView;
    }
    
    private final ImageView frp()
    {
      AppMethodBeat.i(39705);
      ImageView localImageView = (ImageView)this.HfG.getValue();
      AppMethodBeat.o(39705);
      return localImageView;
    }
    
    private MMCollapsibleTextView frr()
    {
      AppMethodBeat.i(39707);
      MMCollapsibleTextView localMMCollapsibleTextView = (MMCollapsibleTextView)this.HfK.getValue();
      AppMethodBeat.o(39707);
      return localMMCollapsibleTextView;
    }
    
    public final void a(int paramInt, HashSet<Integer> paramHashSet, String paramString)
    {
      AppMethodBeat.i(39709);
      p.k(paramHashSet, "expandSet");
      p.k(paramString, "text");
      MMCollapsibleTextView localMMCollapsibleTextView = frr();
      p.j(localMMCollapsibleTextView, "collapseTextLayout");
      paramString = com.tencent.mm.pluginsdk.ui.span.l.k(localMMCollapsibleTextView.getContext(), (CharSequence)paramString, (int)frr().getTextSize());
      localMMCollapsibleTextView = frr();
      if (!paramHashSet.contains(Integer.valueOf(paramInt))) {}
      for (boolean bool = true;; bool = false)
      {
        localMMCollapsibleTextView.setCollapsed(bool);
        localMMCollapsibleTextView = frr();
        p.j(paramString, "text");
        localMMCollapsibleTextView.setText((CharSequence)paramString);
        if (!(frr().getContentText() instanceof MMNeat7extView)) {
          break label194;
        }
        paramString = frr().getContentText();
        if (paramString != null) {
          break;
        }
        paramHashSet = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
        AppMethodBeat.o(39709);
        throw paramHashSet;
      }
      paramString = (MMNeat7extView)paramString;
      frr().setOnTextTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.h((NeatTextView)paramString, (View.OnTouchListener)new o(paramString.getContext())));
      label194:
      frr().setOnCollapse((kotlin.g.a.a)new b.f.f(paramHashSet, paramInt));
      frr().setOnExpand((kotlin.g.a.a)new b.f.g(paramHashSet, paramInt));
      AppMethodBeat.o(39709);
    }
    
    protected final void a(View paramView, b.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(39698);
      p.k(paramView, "container");
      p.k(paramd, "slotType");
      switch (getItemShowType())
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
        if (paramd == b.d.Hff)
        {
          View localView = paramView.findViewById(R.h.dug);
          p.j(localView, "container.findViewById<V…R.id.biz_slot_top_line_v)");
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
    
    final void abG(int paramInt)
    {
      AppMethodBeat.i(39712);
      Iterator localIterator = ((Iterable)this.HfB).iterator();
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
    
    protected final ViewGroup c(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39697);
      p.k(paramContext, "context");
      p.k(paramViewGroup, "container");
      paramContext = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.efb, paramViewGroup, false);
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(39697);
        throw paramContext;
      }
      paramContext = (ViewGroup)paramContext;
      int i;
      switch (getItemShowType())
      {
      case 9: 
      default: 
        i = R.h.dAO;
      }
      for (;;)
      {
        ((ViewStub)paramContext.findViewById(i)).inflate();
        paramViewGroup.addView((View)paramContext);
        AppMethodBeat.o(39697);
        return paramContext;
        i = R.h.dAR;
        continue;
        i = R.h.dAP;
        frl();
        continue;
        i = R.h.dAQ;
        continue;
        i = R.h.dAN;
      }
    }
    
    protected final void frb()
    {
      AppMethodBeat.i(39711);
      Object localObject = getContext();
      p.j(localObject, "context");
      abG(((Context)localObject).getResources().getColor(R.e.white_text_color));
      if (this.Hfy)
      {
        localObject = (View)this.HfD.getValue();
        if (!frm()) {
          break label113;
        }
        if (this.Hfz)
        {
          i = R.g.dou;
          ((View)localObject).setBackgroundResource(i);
        }
      }
      else
      {
        localObject = frn();
        if (this.Hfs != b.d.Hff) {
          break label134;
        }
      }
      label134:
      for (int i = R.g.dmv;; i = R.g.dmw)
      {
        ((ImageView)localObject).setBackgroundResource(i);
        AppMethodBeat.o(39711);
        return;
        i = R.g.dos;
        break;
        label113:
        if (this.Hfz)
        {
          i = R.g.dor;
          break;
        }
        i = R.g.doq;
        break;
      }
    }
    
    protected final float[] frc()
    {
      AppMethodBeat.i(39699);
      if (frm())
      {
        arrayOfFloat = kotlin.a.e.b(new Float[] { Float.valueOf(bP(8.0F)), Float.valueOf(bP(8.0F)), Float.valueOf(bP(8.0F)), Float.valueOf(bP(8.0F)) });
        AppMethodBeat.o(39699);
        return arrayOfFloat;
      }
      float[] arrayOfFloat = kotlin.a.e.b(new Float[] { Float.valueOf(bP(8.0F)), Float.valueOf(bP(8.0F)), Float.valueOf(0.0F), Float.valueOf(0.0F) });
      AppMethodBeat.o(39699);
      return arrayOfFloat;
    }
    
    protected final int frd()
    {
      AppMethodBeat.i(39700);
      if (frm())
      {
        i = R.g.doo;
        AppMethodBeat.o(39700);
        return i;
      }
      int i = R.g.dop;
      AppMethodBeat.o(39700);
      return i;
    }
    
    public final TextView fre()
    {
      AppMethodBeat.i(39703);
      TextView localTextView = (TextView)this.Hfc.getValue();
      AppMethodBeat.o(39703);
      return localTextView;
    }
    
    protected final void frk()
    {
      AppMethodBeat.i(39710);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
      AppMethodBeat.o(39710);
    }
    
    final void frl()
    {
      AppMethodBeat.i(39701);
      this.Hfy = true;
      if (getItemShowType() == 5)
      {
        Object localObject = frp();
        p.j(localObject, "videPlayImg");
        localObject = ((ImageView)localObject).getLayoutParams();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
          AppMethodBeat.o(39701);
          throw ((Throwable)localObject);
        }
        localObject = (ConstraintLayout.LayoutParams)localObject;
        if (((ConstraintLayout.LayoutParams)localObject).Fw != 0.56F)
        {
          ((ConstraintLayout.LayoutParams)localObject).Fw = 0.56F;
          ImageView localImageView = frp();
          p.j(localImageView, "videPlayImg");
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(39701);
    }
    
    final View frq()
    {
      AppMethodBeat.i(39706);
      View localView = (View)this.HfH.getValue();
      AppMethodBeat.o(39706);
      return localView;
    }
    
    public final void setTitle(String paramString)
    {
      int i = 4;
      AppMethodBeat.i(39708);
      p.k(paramString, "value");
      MMNeat7extView localMMNeat7extView;
      int j;
      String str;
      switch (getItemShowType())
      {
      default: 
        if (this.Hfs == b.d.Hfi)
        {
          localMMNeat7extView = (MMNeat7extView)this.HfI.getValue();
          p.j(localMMNeat7extView, "if (slotType == SlotType…ingleTitleTv else titleTv");
          j = this.Hfd;
          str = this.url;
          if (this.Hfs != b.d.Hfi) {
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
        localMMNeat7extView = fro();
        p.j(localMMNeat7extView, "titleTv");
        a(localMMNeat7extView, paramString, this.Hfd, this.url, 4);
        paramString = frn();
        if (this.Hfs == b.d.Hff) {}
        for (i = R.g.dmw;; i = R.g.dmv)
        {
          paramString.setBackgroundResource(i);
          AppMethodBeat.o(39708);
          return;
        }
        localMMNeat7extView = fro();
        break;
        label188:
        i = 41;
      }
    }
    
    public final void wg(boolean paramBoolean)
    {
      AppMethodBeat.i(275393);
      if (!paramBoolean) {
        frq().setPadding(0, 0, 0, frh());
      }
      for (;;)
      {
        this.HfL = paramBoolean;
        AppMethodBeat.o(275393);
        return;
        frq().setPadding(frj(), fri(), frj(), frh());
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMCollapsibleTextView>
    {
      a(b.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<View>
    {
      b(b.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMNeat7extView>
    {
      c(b.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class d
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      d(b.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      e(b.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      h(b.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i
      extends kotlin.g.b.q
      implements kotlin.g.a.a<View>
    {
      i(b.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMNeat7extView>
    {
      j(b.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k
      extends kotlin.g.b.q
      implements kotlin.g.a.a<MMNeat7extView>
    {
      k(b.f paramf, int paramInt)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ImageView>
    {
      l(b.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m
      extends kotlin.g.b.q
      implements kotlin.g.a.a<ImageView>
    {
      m(b.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class n
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      n(b.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class o
      extends kotlin.g.b.q
      implements kotlin.g.a.a<TextView>
    {
      o(b.f paramf)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$ViewHolder;", "context", "Landroid/content/Context;", "widget", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "position", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Landroid/view/View;Landroid/view/ViewGroup;ILcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;)V", "coverSize", "radius", "", "view", "getView", "()Landroid/view/View;", "fillVideoChannel", "", "fillVideoItem", "videoItem", "Lcom/tencent/mm/protocal/protobuf/NotifyVideoInfo;", "itemView", "getDurationText", "", "app_release"})
  static final class g
    extends b.h
  {
    final ContactWidgetNewBizInfo HeO;
    private int HfO;
    final Context context;
    private float radius;
    final View view;
    
    public g(final Context paramContext, ContactWidgetNewBizInfo paramContactWidgetNewBizInfo, View paramView, ViewGroup paramViewGroup, dor paramdor)
    {
      AppMethodBeat.i(169914);
      this.radius = 2.0F;
      this.context = paramContext;
      this.HeO = paramContactWidgetNewBizInfo;
      this.HfO = com.tencent.mm.ci.a.fromDPToPix(paramContext, 64);
      label76:
      int i;
      label115:
      Object localObject1;
      label129:
      label181:
      label195:
      Object localObject2;
      label264:
      int j;
      int k;
      if (paramView != null)
      {
        paramContactWidgetNewBizInfo = paramView.getTag();
        if (!p.h(paramContactWidgetNewBizInfo, paramdor)) {
          break label703;
        }
        this.view = paramView;
        paramContactWidgetNewBizInfo = (TextView)this.view.findViewById(R.h.dYO);
        paramContext = (CharSequence)paramdor.TVS;
        if ((paramContext != null) && (paramContext.length() != 0)) {
          break label741;
        }
        i = 1;
        if (i != 0) {
          break label747;
        }
        paramContext = (CharSequence)paramdor.TVS;
        paramContactWidgetNewBizInfo.setText(paramContext);
        paramContext = com.tencent.mm.plugin.brandservice.ui.b.d.sTw;
        com.tencent.mm.plugin.brandservice.ui.b.d.l(paramContactWidgetNewBizInfo);
        paramContactWidgetNewBizInfo = (TextView)this.view.findViewById(R.h.dYN);
        paramContext = (CharSequence)paramdor.wording;
        if ((paramContext != null) && (paramContext.length() != 0)) {
          break label775;
        }
        i = 1;
        if (i != 0) {
          break label781;
        }
        paramContext = (CharSequence)paramdor.wording;
        paramContactWidgetNewBizInfo.setText(paramContext);
        paramContext = paramdor.TVR;
        paramContactWidgetNewBizInfo = b.HeR;
        Log.v(b.access$getTAG$cp(), "alvinluo fillVideoChannel size: %d", new Object[] { Integer.valueOf(paramContext.size()) });
        paramContactWidgetNewBizInfo = (LinearLayout)this.view.findViewById(R.h.dYD);
        paramContactWidgetNewBizInfo.removeAllViews();
        if (paramContext == null) {
          break label854;
        }
        paramView = ((Iterable)paramContext).iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          paramViewGroup = (dda)paramView.next();
        } while (paramViewGroup == null);
        paramContext = b.HeR;
        Log.d(b.access$getTAG$cp(), "alvinluo videoItem url: %s, duration: %d", new Object[] { paramViewGroup.TKP, Integer.valueOf(paramViewGroup.duration) });
        localObject1 = LayoutInflater.from(this.context).inflate(R.i.efi, null, false);
        paramContactWidgetNewBizInfo.addView((View)localObject1);
        p.j(localObject1, "itemView");
        paramContext = ((View)localObject1).findViewById(R.h.video_duration);
        p.j(paramContext, "itemView.findViewById<Te…iew>(R.id.video_duration)");
        localObject2 = (TextView)paramContext;
        i = paramViewGroup.duration / 3600;
        j = (paramViewGroup.duration - i * 3600) / 60;
        k = paramViewGroup.duration % 60;
        paramContext = b.HeR;
        Log.i(b.access$getTAG$cp(), "alvinluo getDurationText " + i + ':' + j + ':' + k);
        if (i <= 0) {
          break label809;
        }
        paramContext = af.aaBG;
        paramContext = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }, 3));
        p.j(paramContext, "java.lang.String.format(format, *args)");
      }
      for (;;)
      {
        ((TextView)localObject2).setText((CharSequence)paramContext);
        paramContext = (ImageView)((View)localObject1).findViewById(R.h.dYH);
        paramViewGroup = com.tencent.mm.api.b.M(paramViewGroup.TKP, 2);
        localObject1 = new c.a().bmF().dO(this.HfO, this.HfO).Ws("radius_" + this.radius).wz(R.g.don).a((com.tencent.mm.ay.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(3)).a((com.tencent.mm.ay.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(3)).Wq(w.bpO(paramViewGroup)).bmL();
        localObject2 = new b(paramViewGroup, paramContext);
        localObject2 = new com.tencent.mm.pluginsdk.ui.applet.m(3, this.HfO, this.HfO, true, true, this.radius, (m.a)localObject2);
        com.tencent.mm.ay.q.bml().a(paramViewGroup, paramContext, (com.tencent.mm.ay.a.a.c)localObject1, (com.tencent.mm.ay.a.c.h)localObject2);
        break label264;
        paramContactWidgetNewBizInfo = null;
        break;
        label703:
        paramContext = LayoutInflater.from(paramContext).inflate(R.i.efh, paramViewGroup, false);
        p.j(paramContext, "LayoutInflater.from(cont…o_channel, parent, false)");
        this.view = paramContext;
        this.view.setTag(paramdor);
        break label76;
        label741:
        i = 0;
        break label115;
        label747:
        paramContext = paramContactWidgetNewBizInfo.getContext();
        p.j(paramContext, "context");
        paramContext = (CharSequence)paramContext.getResources().getString(R.l.esW);
        break label129;
        label775:
        i = 0;
        break label181;
        label781:
        paramContext = paramContactWidgetNewBizInfo.getContext();
        p.j(paramContext, "context");
        paramContext = (CharSequence)paramContext.getResources().getString(R.l.esV);
        break label195;
        label809:
        paramContext = af.aaBG;
        paramContext = String.format("%02d:%02d", Arrays.copyOf(new Object[] { Integer.valueOf(j), Integer.valueOf(k) }, 2));
        p.j(paramContext, "java.lang.String.format(format, *args)");
      }
      label854:
      paramContext = this.view.findViewById(R.h.root_layout);
      if (paramContext != null)
      {
        paramContext.setOnClickListener((View.OnClickListener)new b.g.a(this, paramdor));
        AppMethodBeat.o(169914);
        return;
      }
      AppMethodBeat.o(169914);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder$fillVideoItem$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
    public static final class b
      implements m.a
    {
      b(String paramString, ImageView paramImageView) {}
      
      public final void onFinish()
      {
        AppMethodBeat.i(169912);
        b.c localc = b.HeR;
        Log.v(b.access$getTAG$cp(), "imageUrl onFinish:" + this.wXO);
        paramContext.setBackgroundResource(R.g.mm_trans);
        AppMethodBeat.o(169912);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(169913);
        b.c localc = b.HeR;
        Log.v(b.access$getTAG$cp(), "imageUrl onStart:" + this.wXO);
        AppMethodBeat.o(169913);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.b
 * JD-Core Version:    0.7.0.1
 */