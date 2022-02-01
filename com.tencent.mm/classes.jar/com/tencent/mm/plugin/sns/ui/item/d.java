package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Message;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.d.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.bv;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem;", "Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem;", "()V", "TAG", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "refreshActivityIconJob", "Lkotlinx/coroutines/Job;", "bindActivityIcon", "", "holder", "Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$FinderLiveViewHolder;", "feedId", "", "nonceId", "buildContent", "imagesKeeper", "Landroid/view/ViewStub;", "Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder;", "checkLiveStatus", "tlObj", "Lcom/tencent/mm/protocal/protobuf/TimeLineObject;", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "fillItem", "position", "", "struct", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineVendingStruct;", "viewType", "adapter", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter;", "getOnClickListener", "Landroid/view/View$OnClickListener;", "updateLiveStatus", "finderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "updateLiveTag", "", "shareObject", "liveStatus", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "FinderLiveViewHolder", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends BaseTimeLineItem
{
  private cb RMm;
  private final String TAG;
  private aq coroutineScope;
  
  public d()
  {
    AppMethodBeat.i(309039);
    this.TAG = "FinderLiveTimeLineItem";
    this.coroutineScope = ar.kBZ();
    AppMethodBeat.o(309039);
  }
  
  private static final String f(bmr parambmr)
  {
    AppMethodBeat.i(309046);
    CharSequence localCharSequence = (CharSequence)parambmr.coverUrl;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
      i = 1;
    }
    while (i == 0)
    {
      parambmr = parambmr.coverUrl;
      if (parambmr == null)
      {
        AppMethodBeat.o(309046);
        return "";
        i = 0;
      }
      else
      {
        AppMethodBeat.o(309046);
        return parambmr;
      }
    }
    localCharSequence = (CharSequence)parambmr.headUrl;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
      i = 1;
    }
    while (i == 0)
    {
      parambmr = parambmr.headUrl;
      if (parambmr == null)
      {
        AppMethodBeat.o(309046);
        return "";
        i = 0;
      }
      else
      {
        AppMethodBeat.o(309046);
        return parambmr;
      }
    }
    AppMethodBeat.o(309046);
    return "";
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(309121);
    Object localObject1;
    if (paramTimeLineObject == null) {
      localObject1 = null;
    }
    a locala;
    bmr localbmr;
    label155:
    Object localObject2;
    label203:
    Object localObject3;
    label371:
    Object localObject4;
    for (;;)
    {
      if ((localObject1 != null) && (paramTimeLineObject.ContentObj.DHa != null)) {
        if (paramBaseViewHolder == null)
        {
          paramBaseViewHolder = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.sns.ui.item.FinderLiveTimeLineItem.FinderLiveViewHolder");
          AppMethodBeat.o(309121);
          throw paramBaseViewHolder;
          localObject1 = paramTimeLineObject.ContentObj;
        }
        else
        {
          locala = (a)paramBaseViewHolder;
          localbmr = paramTimeLineObject.ContentObj.DHa;
          localObject1 = String.valueOf(localbmr.nickName);
          s.u(localObject1, "<set-?>");
          locala.nickName = ((String)localObject1);
          localObject1 = paramTimeLineObject.ContentObj;
          if (localObject1 != null) {
            break label925;
          }
          localObject1 = "0";
          locala.liveId = Util.getLong((String)localObject1, 0L);
          s.s(localbmr, "finderShareObject");
          e(localbmr);
          localObject1 = locala.RMo;
          if (localObject1 != null) {
            break label967;
          }
          localObject1 = null;
          float f = BackwardSupportUtil.BitmapFactory.fromDPToPix((Context)localObject1, 225.0F);
          localObject2 = Pair.create(Integer.valueOf((int)(3.0F * f / 4.0F)), Integer.valueOf((int)f));
          localObject1 = locala.RMo;
          if (localObject1 != null) {
            break label977;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            localObject3 = ((Pair)localObject2).first;
            s.s(localObject3, "pair.first");
            ((ViewGroup.LayoutParams)localObject1).width = ((Number)localObject3).intValue();
          }
          if (localObject1 != null)
          {
            localObject3 = ((Pair)localObject2).second;
            s.s(localObject3, "pair.second");
            ((ViewGroup.LayoutParams)localObject1).height = ((Number)localObject3).intValue();
          }
          localObject3 = locala.RMo;
          if (localObject3 != null) {
            ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          localObject1 = locala.RMo;
          if (localObject1 != null) {
            ((View)localObject1).requestLayout();
          }
          localObject1 = locala.activityInfoIcon;
          if (localObject1 != null) {
            ((ImageView)localObject1).setVisibility(8);
          }
          localObject1 = locala.reasonTv;
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(8);
          }
          if (a(locala, paramTimeLineObject, localbmr, localbmr.liveStatus, localbmr.ZVm))
          {
            if (parambo != null) {
              break label987;
            }
            localObject1 = null;
            a(locala, paramTimeLineObject, (SnsInfo)localObject1);
          }
          localObject1 = (CharSequence)localbmr.ZVq;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label996;
          }
          paramInt1 = 1;
          label408:
          if ((paramInt1 != 0) || (localbmr.liveStatus == 2)) {
            break label1037;
          }
          localObject1 = ((a)paramBaseViewHolder).finderOlympicView;
          if (localObject1 != null)
          {
            localObject3 = ((View)localObject1).findViewById(b.f.finder_olympic_invite_bg);
            s.s(localObject3, "it.findViewById(R.id.finder_olympic_invite_bg)");
            localObject3 = (ImageView)localObject3;
            localObject4 = ((View)localObject1).findViewById(b.f.finder_olympic_invite_icon);
            s.s(localObject4, "it.findViewById(R.id.finder_olympic_invite_icon)");
            localObject4 = (ImageView)localObject4;
            ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).loadOlympicsImage((ImageView)localObject3, com.tencent.d.a.a.a.b.b.j.ahpn, b.e.finder_olympic_live_share_bg);
            ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).loadOlympicsImage((ImageView)localObject4, com.tencent.d.a.a.a.b.b.j.ahpo, b.e.finder_olympic_live_share_icon);
            localObject3 = ((View)localObject1).findViewById(b.f.finder_olympic_invite_text);
            s.s(localObject3, "it.findViewById(R.id.finder_olympic_invite_text)");
            localObject3 = (TextView)localObject3;
            ((TextView)localObject3).setTextSize(1, 14.0F);
            localObject4 = ((View)localObject1).findViewById(b.f.finder_olympic_invite_name);
            s.s(localObject4, "it.findViewById(R.id.finder_olympic_invite_name)");
            localObject4 = (TextView)localObject4;
            ((TextView)localObject4).setTextSize(1, 14.0F);
            localObject1 = ((View)localObject1).findViewById(b.f.finder_olympic_invite_you);
            s.s(localObject1, "it.findViewById(R.id.finder_olympic_invite_you)");
            localObject1 = (TextView)localObject1;
            ((TextView)localObject1).setTextSize(1, 15.0F);
            aw.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
            aw.a((Paint)((TextView)localObject4).getPaint(), 0.8F);
            aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
            localObject1 = (CharSequence)localbmr.ZVr;
            if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
              break label1001;
            }
            paramInt1 = 1;
            label700:
            if (paramInt1 == 0) {
              break label1006;
            }
            ((TextView)localObject4).setVisibility(8);
            label711:
            localObject1 = MMApplicationContext.getContext().getResources().getString(com.tencent.mm.plugin.sns.b.j.finder_olympic_invite_text_3, new Object[] { localbmr.ZVq });
            s.s(localObject1, "getContext().resources.g…erShareObject.relayIndex)");
            paramInt1 = ((Number)((Pair)localObject2).first).intValue();
            paramInt2 = a.fromDPToPix(MMApplicationContext.getContext(), 12);
            localObject2 = n.bV((String)localObject1, "\n", "");
            if (new StaticLayout((CharSequence)localObject2, 0, ((String)localObject2).length(), ((TextView)localObject3).getPaint(), paramInt1 - paramInt2 * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() > 1) {
              break label1078;
            }
            localObject1 = localObject2;
          }
        }
      }
    }
    label925:
    label1078:
    for (;;)
    {
      ((TextView)localObject3).setText((CharSequence)localObject1);
      localObject1 = ((a)paramBaseViewHolder).finderOlympicView;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      paramBaseViewHolder = ((a)paramBaseViewHolder).coverIv;
      if (paramBaseViewHolder != null) {
        paramBaseViewHolder.setVisibility(8);
      }
      for (;;)
      {
        paramBaseViewHolder = locala.RMo;
        if (paramBaseViewHolder != null) {
          paramBaseViewHolder.setTag(paramTimeLineObject);
        }
        paramBaseViewHolder = locala.RMo;
        if (paramBaseViewHolder != null)
        {
          s.checkNotNull(parambn);
          paramBaseViewHolder.setOnClickListener(c(parambn));
        }
        a(parambo, 1);
        AppMethodBeat.o(309121);
        return;
        localObject1 = ((agh)localObject1).DHa;
        if (localObject1 == null)
        {
          localObject1 = "0";
          break;
        }
        localObject2 = ((bmr)localObject1).liveId;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = "0";
        break;
        label967:
        localObject1 = ((View)localObject1).getContext();
        break label155;
        label977:
        localObject1 = ((View)localObject1).getLayoutParams();
        break label203;
        label987:
        localObject1 = parambo.PJQ;
        break label371;
        label996:
        paramInt1 = 0;
        break label408;
        label1001:
        paramInt1 = 0;
        break label700;
        label1006:
        ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)localbmr.ZVr));
        ((TextView)localObject4).setVisibility(0);
        break label711;
        localObject1 = ((a)paramBaseViewHolder).finderOlympicView;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        paramBaseViewHolder = ((a)paramBaseViewHolder).coverIv;
        if (paramBaseViewHolder != null) {
          paramBaseViewHolder.setVisibility(0);
        }
      }
    }
  }
  
  protected void a(a parama, TimeLineObject paramTimeLineObject, final SnsInfo paramSnsInfo)
  {
    final long l = 0L;
    AppMethodBeat.i(309145);
    s.u(parama, "holder");
    s.u(paramTimeLineObject, "tlObj");
    final ah.f localf = new ah.f();
    localf.aqH = paramTimeLineObject.ContentObj.DHa;
    Object localObject = ((bmr)localf.aqH).liveId;
    if (localObject == null)
    {
      localObject = new ah.d();
      ((ah.d)localObject).aixb = ((bmr)localf.aqH).liveStatus;
      paramSnsInfo = new d(parama, this, localf, l, paramTimeLineObject, paramSnsInfo, (ah.d)localObject);
      paramTimeLineObject = parama.RMo;
      if (paramTimeLineObject != null) {
        break label179;
      }
      paramTimeLineObject = null;
      label116:
      if (!(paramTimeLineObject instanceof SnsTimeLineUI)) {
        break label232;
      }
      parama = parama.RMo;
      if (parama != null) {
        break label187;
      }
    }
    label179:
    label187:
    for (parama = null;; parama = parama.getContext())
    {
      if (parama != null) {
        break label195;
      }
      parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
      AppMethodBeat.o(309145);
      throw parama;
      localObject = n.bJH((String)localObject);
      if (localObject == null) {
        break;
      }
      l = ((Long)localObject).longValue();
      break;
      paramTimeLineObject = paramTimeLineObject.getContext();
      break label116;
    }
    label195:
    label232:
    for (parama = (SnsTimeLineUI)parama;; parama = null)
    {
      ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).getLiveInfo(l, false, (com.tencent.mm.vending.e.b)parama, (b.d)paramSnsInfo);
      AppMethodBeat.o(309145);
      return;
    }
  }
  
  public final boolean a(a parama, TimeLineObject paramTimeLineObject, bmr parambmr, int paramInt, bip parambip)
  {
    AppMethodBeat.i(309096);
    s.u(parama, "holder");
    s.u(paramTimeLineObject, "tlObj");
    s.u(parambmr, "shareObject");
    String str1 = f(parambmr);
    boolean bool1;
    boolean bool2;
    label79:
    boolean bool3;
    label129:
    Object localObject;
    label190:
    boolean bool4;
    label259:
    label282:
    label290:
    int i;
    if (parambip != null)
    {
      bool1 = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isChargeLive(parambip);
      if (parambip == null) {
        break label639;
      }
      bool2 = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isReplayLive(parambip);
      if ((bool1) || (bool2) || (parambip == null) || ((parambmr.ZVl != 2) && (parambmr.ZVl != 6))) {
        break label660;
      }
      bool3 = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).producingReplay(parambip);
      String str2 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("updateLiveTag live:").append(parambmr.liveId).append('(').append(parambmr.nickName).append("),liveStatus:").append(paramInt).append('(');
      if (parambip != null) {
        break label666;
      }
      localObject = null;
      localObject = localStringBuilder.append(localObject).append("),chargFlag:").append(parambmr.ZVl).append(",isChargeLive:").append(bool1).append(",isLiveReplay:").append(bool2).append(",producingReplay:").append(bool3).append(",liveInfo null:");
      if (parambip != null) {
        break label679;
      }
      bool4 = true;
      localObject = ((StringBuilder)localObject).append(bool4).append(",purchaseInfo null:");
      if (parambip != null) {
        break label685;
      }
      parambip = null;
      if (parambip != null) {
        break label695;
      }
      bool4 = true;
      Log.i(str2, bool4);
      if ((!bool1) && (!bool2) && (paramInt != 1)) {
        break label701;
      }
      i = 1;
      label324:
      if (i == 0) {
        break label779;
      }
      parambip = parama.RMp;
      if (parambip != null) {
        parambip.setVisibility(0);
      }
      parambip = parama.RMq;
      if (parambip != null) {
        parambip.setVisibility(8);
      }
      if (!bool1) {
        break label707;
      }
      paramInt = 2;
      label372:
      ((cn)h.az(cn.class)).loadImage(f(parambmr), parama.coverIv);
      ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).setFinderLiveTagText(parama.RMp, paramInt);
      ((cn)h.az(cn.class)).loadImage(str1, parama.coverIv);
      parambmr = paramTimeLineObject.ContentObj;
      if (parambmr != null) {
        break label725;
      }
      parambmr = null;
      label445:
      long l = com.tencent.mm.ae.d.FK(parambmr);
      paramTimeLineObject = paramTimeLineObject.ContentObj;
      if (paramTimeLineObject != null) {
        break label747;
      }
      paramTimeLineObject = "";
      label463:
      parambmr = com.tencent.mm.ae.d.hF(l);
      Log.i(this.TAG, s.X("#bindActivityIcon feedId=", parambmr));
      parambmr = this.RMm;
      if (parambmr != null) {
        parambmr.a(null);
      }
      parambmr = parama.convertView;
      s.s(parambmr, "holder.convertView");
      f.a(parambmr, (e.b)new b(this));
      if (((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isFinderLiveActivityIconSharedEnable())
      {
        parambmr = parama.activityInfoIcon;
        if (parambmr != null) {
          this.RMm = j.a(this.coroutineScope, null, null, (m)new d.c(parambmr, l, paramTimeLineObject, null), 3);
        }
      }
      paramTimeLineObject = parama.RMp;
      if (paramTimeLineObject != null) {
        paramTimeLineObject.setContentDescription((CharSequence)parama.hqU());
      }
    }
    for (;;)
    {
      if ((i == 0) && (!bool3)) {
        break label891;
      }
      AppMethodBeat.o(309096);
      return true;
      if (parambmr.ZVl == 2)
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      label639:
      if (parambmr.ZVl == 6)
      {
        bool2 = true;
        break label79;
      }
      bool2 = false;
      break label79;
      label660:
      bool3 = false;
      break label129;
      label666:
      localObject = Integer.valueOf(parambip.liveStatus);
      break label190;
      label679:
      bool4 = false;
      break label259;
      label685:
      parambip = parambip.ZSc;
      break label282;
      label695:
      bool4 = false;
      break label290;
      label701:
      i = 0;
      break label324;
      label707:
      if (bool2)
      {
        paramInt = 6;
        break label372;
      }
      paramInt = 0;
      break label372;
      label725:
      parambmr = parambmr.DHa;
      if (parambmr == null)
      {
        parambmr = null;
        break label445;
      }
      parambmr = parambmr.feedId;
      break label445;
      label747:
      paramTimeLineObject = paramTimeLineObject.DHa;
      if (paramTimeLineObject == null)
      {
        paramTimeLineObject = "";
        break label463;
      }
      parambmr = paramTimeLineObject.objectNonceId;
      paramTimeLineObject = parambmr;
      if (parambmr != null) {
        break label463;
      }
      paramTimeLineObject = "";
      break label463;
      label779:
      if (paramInt == 2)
      {
        paramTimeLineObject = parama.RMp;
        if (paramTimeLineObject != null) {
          paramTimeLineObject.setVisibility(8);
        }
        paramTimeLineObject = parama.RMq;
        if (paramTimeLineObject != null) {
          paramTimeLineObject.setVisibility(0);
        }
        paramTimeLineObject = parama.RMq;
        if (paramTimeLineObject != null) {
          paramTimeLineObject.setContentDescription((CharSequence)parama.hqU());
        }
        ((cn)h.az(cn.class)).getFinderUtilApi().a(parama.coverIv, str1);
        paramTimeLineObject = parama.coverIv;
        if (paramTimeLineObject != null) {
          paramTimeLineObject.setVisibility(0);
        }
        parama = parama.finderOlympicView;
        if (parama != null) {
          parama.setVisibility(8);
        }
      }
    }
    label891:
    AppMethodBeat.o(309096);
    return false;
  }
  
  protected View.OnClickListener c(bn parambn)
  {
    AppMethodBeat.i(309129);
    s.u(parambn, "adapter");
    parambn = parambn.RoS.RFs;
    s.s(parambn, "adapter.timelineEvent.finderLiveListener");
    AppMethodBeat.o(309129);
    return parambn;
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    Object localObject = null;
    AppMethodBeat.i(309070);
    if (paramBaseViewHolder == null)
    {
      paramBaseViewHolder = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.sns.ui.item.FinderLiveTimeLineItem.FinderLiveViewHolder");
      AppMethodBeat.o(309070);
      throw paramBaseViewHolder;
    }
    a locala = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.RKG != null) && (paramBaseViewHolder.RKG.getParent() != null))
    {
      paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_finder_live_time_line_item);
      if (!locala.RMn)
      {
        locala.RMo = paramBaseViewHolder.RKG.inflate();
        locala.RMn = true;
      }
      paramBaseViewHolder = locala.RMo;
      if (paramBaseViewHolder != null) {
        break label213;
      }
      paramBaseViewHolder = null;
      label96:
      locala.coverIv = paramBaseViewHolder;
      paramBaseViewHolder = locala.RMo;
      if (paramBaseViewHolder != null) {
        break label227;
      }
      paramBaseViewHolder = null;
      label112:
      locala.RMp = paramBaseViewHolder;
      paramBaseViewHolder = locala.RMo;
      if (paramBaseViewHolder != null) {
        break label238;
      }
      paramBaseViewHolder = null;
      label128:
      locala.RMq = paramBaseViewHolder;
      paramBaseViewHolder = locala.RMo;
      if (paramBaseViewHolder != null) {
        break label249;
      }
      paramBaseViewHolder = null;
      label144:
      locala.activityInfoIcon = paramBaseViewHolder;
      paramBaseViewHolder = locala.RMo;
      if (paramBaseViewHolder != null) {
        break label263;
      }
      paramBaseViewHolder = null;
      label160:
      locala.reasonTv = paramBaseViewHolder;
      paramBaseViewHolder = locala.RMo;
      if (paramBaseViewHolder != null) {
        break label277;
      }
    }
    label263:
    label277:
    for (paramBaseViewHolder = localObject;; paramBaseViewHolder = paramBaseViewHolder.findViewById(b.f.finder_olympic_invite_view))
    {
      locala.finderOlympicView = paramBaseViewHolder;
      AppMethodBeat.o(309070);
      return;
      locala.RMo = ((a)paramBaseViewHolder).convertView.findViewById(b.f.sns_finder_media_content_rl);
      locala.RMn = true;
      break;
      label213:
      paramBaseViewHolder = (ImageView)paramBaseViewHolder.findViewById(b.f.sns_finder_media_thumb);
      break label96;
      label227:
      paramBaseViewHolder = paramBaseViewHolder.findViewById(b.f.finder_live_icon);
      break label112;
      label238:
      paramBaseViewHolder = paramBaseViewHolder.findViewById(b.f.finder_live_end_tag);
      break label128;
      label249:
      paramBaseViewHolder = (ImageView)paramBaseViewHolder.findViewById(b.f.iv_live_activity_info_icon);
      break label144;
      paramBaseViewHolder = (TextView)paramBaseViewHolder.findViewById(b.f.tv_reason);
      break label160;
    }
  }
  
  protected void e(bmr parambmr)
  {
    AppMethodBeat.i(309137);
    s.u(parambmr, "finderShareObject");
    AppMethodBeat.o(309137);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$FinderLiveViewHolder;", "Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder;", "()V", "activityInfoIcon", "Landroid/widget/ImageView;", "getActivityInfoIcon", "()Landroid/widget/ImageView;", "setActivityInfoIcon", "(Landroid/widget/ImageView;)V", "coverIv", "getCoverIv", "setCoverIv", "finderLiveEndTag", "Landroid/view/View;", "getFinderLiveEndTag", "()Landroid/view/View;", "setFinderLiveEndTag", "(Landroid/view/View;)V", "finderLiveTag", "getFinderLiveTag", "setFinderLiveTag", "finderMediaRoot", "getFinderMediaRoot", "setFinderMediaRoot", "finderMediaStubHas", "", "getFinderMediaStubHas", "()Z", "setFinderMediaStubHas", "(Z)V", "finderOlympicView", "getFinderOlympicView", "setFinderOlympicView", "liveId", "", "getLiveId", "()J", "setLiveId", "(J)V", "nickName", "", "getNickName", "()Ljava/lang/String;", "setNickName", "(Ljava/lang/String;)V", "reasonTv", "Landroid/widget/TextView;", "getReasonTv", "()Landroid/widget/TextView;", "setReasonTv", "(Landroid/widget/TextView;)V", "getAccessibilityDesc", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    boolean RMn;
    View RMo;
    View RMp;
    View RMq;
    ImageView activityInfoIcon;
    ImageView coverIv;
    View finderOlympicView;
    long liveId;
    String nickName = "";
    TextView reasonTv;
    
    public final String hqU()
    {
      AppMethodBeat.i(308973);
      Object localObject1 = this.convertView.getContext().getString(com.tencent.mm.plugin.sns.b.j.sns_live);
      s.s(localObject1, "convertView.context.getString(R.string.sns_live)");
      Object localObject2 = this.RMq;
      if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          localObject1 = this.convertView.getContext().getString(com.tencent.mm.plugin.sns.b.j.sns_finder_live_end);
          s.s(localObject1, "convertView.context.getS…ring.sns_finder_live_end)");
        }
        localObject1 = new StringBuilder("，").append((String)localObject1).append(65292);
        localObject2 = am.aixg;
        localObject2 = this.convertView.getContext().getString(com.tencent.mm.plugin.sns.b.j.sns_finderlive);
        s.s(localObject2, "convertView.context.getS…(R.string.sns_finderlive)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { this.nickName }, 1));
        s.s(localObject2, "java.lang.String.format(format, *args)");
        localObject1 = (String)localObject2;
        AppMethodBeat.o(308973);
        return localObject1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$bindActivityIcon$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends e.b
  {
    b(d paramd) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(308967);
      s.u(paramView, "view");
      if (!paramBoolean)
      {
        Log.i(d.a(this.RMr), "#bindActivityIcon onViewExposedListener false, cancel it");
        paramView = d.b(this.RMr);
        if (paramView != null) {
          paramView.a(null);
        }
      }
      AppMethodBeat.o(308967);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$checkLiveStatus$statusCallBack$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "liveId", "", "status", "", "liveInfo", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements b.d
  {
    d(d.a parama, d paramd, ah.f<bmr> paramf, long paramLong, TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, ah.d paramd1) {}
    
    public final void onLiveStatusCallback(long paramLong, int paramInt, Object paramObject)
    {
      Object localObject3 = null;
      AppMethodBeat.i(308983);
      if (this.RMs.liveId != paramLong)
      {
        Log.i(d.a(jdField_this), "#checkLiveStatus.onLiveStatusCallback not match, return");
        AppMethodBeat.o(308983);
        return;
      }
      ((bmr)localf.aqH).liveStatus = paramInt;
      Object localObject2 = (bmr)localf.aqH;
      Object localObject1;
      label87:
      label117:
      int i;
      if ((paramObject instanceof azl))
      {
        localObject1 = (azl)paramObject;
        if (localObject1 != null) {
          break label657;
        }
        localObject1 = null;
        ((bmr)localObject2).ZVm = ((bip)localObject1);
        localObject1 = ((bmr)localf.aqH).ZVm;
        if (localObject1 != null) {
          break label667;
        }
        localObject1 = null;
        Object localObject4 = d.a(jdField_this);
        StringBuilder localStringBuilder = new StringBuilder("[checkLiveStatus] thisLiveId:").append(l).append(",liveID:").append(paramLong).append(",desc:").append(((bmr)localf.aqH).desc).append(",share liveStatus:").append(((bmr)localf.aqH).liveStatus).append(", callback liveStatus:").append(paramInt).append(",purchaseInfo:[");
        if (localObject1 != null) {
          break label677;
        }
        localObject2 = null;
        label217:
        localObject2 = localStringBuilder.append(localObject2).append(',');
        if (localObject1 != null) {
          break label690;
        }
        localObject1 = localObject3;
        label240:
        Log.i((String)localObject4, localObject1 + ']');
        localObject1 = jdField_this;
        localObject2 = this.RMs;
        localObject3 = paramSnsInfo;
        localObject4 = localf.aqH;
        s.s(localObject4, "shareObject");
        ((d)localObject1).a((d.a)localObject2, (TimeLineObject)localObject3, (bmr)localObject4, paramInt, ((bmr)localf.aqH).ZVm);
        localObject1 = this.RMw;
        if (localObject1 != null)
        {
          localObject2 = this.RMx;
          localObject3 = localf;
          localObject4 = paramSnsInfo;
          if ((((ah.d)localObject2).aixb == 1) && (paramInt == 2))
          {
            ((bmr)((ah.f)localObject3).aqH).liveStatus = paramInt;
            ((SnsInfo)localObject1).setTimeLine((TimeLineObject)localObject4);
            localObject2 = i.QYv;
            s.u(localObject1, "snsinfo");
            localObject1 = i.getHandler().obtainMessage(i.QYw, localObject1);
            i.getHandler().sendMessage((Message)localObject1);
          }
        }
        localObject1 = "";
        if (!(paramObject instanceof azl)) {
          break label825;
        }
        localObject1 = ((azl)paramObject).liveInfo;
        if (localObject1 == null) {
          break label819;
        }
        localObject1 = ((bip)localObject1).ZSd;
        if (localObject1 == null) {
          break label819;
        }
        localObject1 = (Integer)kotlin.a.p.ae((List)localObject1, 0);
        if (localObject1 == null) {
          break label819;
        }
        localObject2 = jdField_this;
        i = ((Number)localObject1).intValue();
        Log.i(d.a((d)localObject2), s.X("#checkLiveStatus.onLiveStatusCallback actType=", Integer.valueOf(i)));
        i = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).getImageResFromActivityType(i);
        label528:
        localObject1 = ((azl)paramObject).recommend_reason;
        paramObject = localObject1;
        if (localObject1 != null) {}
      }
      for (paramObject = "";; paramObject = localObject1)
      {
        if ((i == 0) || (paramInt == 2))
        {
          localObject1 = this.RMs.activityInfoIcon;
          if (localObject1 != null) {
            ((ImageView)localObject1).setVisibility(8);
          }
          label582:
          if (((CharSequence)paramObject).length() != 0) {
            break label763;
          }
        }
        label657:
        label667:
        label677:
        label690:
        label763:
        for (i = 1;; i = 0)
        {
          if ((i == 0) && (paramInt != 2) && (((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isFinderLiveActivityIconSharedEnable())) {
            break label769;
          }
          paramObject = this.RMs.reasonTv;
          if (paramObject == null) {
            break label813;
          }
          paramObject.setVisibility(8);
          AppMethodBeat.o(308983);
          return;
          localObject1 = null;
          break;
          localObject1 = ((azl)localObject1).liveInfo;
          break label87;
          localObject1 = ((bip)localObject1).ZSc;
          break label117;
          localObject2 = Boolean.valueOf(((blf)localObject1).ZUj);
          break label217;
          localObject1 = Integer.valueOf(((blf)localObject1).ZGN);
          break label240;
          if (!((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isFinderLiveActivityIconSharedEnable()) {
            break label582;
          }
          localObject1 = this.RMs.activityInfoIcon;
          if (localObject1 != null) {
            ((ImageView)localObject1).setImageResource(i);
          }
          localObject1 = this.RMs.activityInfoIcon;
          if (localObject1 == null) {
            break label582;
          }
          ((ImageView)localObject1).setVisibility(0);
          break label582;
        }
        label769:
        localObject1 = this.RMs.reasonTv;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)paramObject);
        }
        paramObject = this.RMs.reasonTv;
        if (paramObject != null) {
          paramObject.setVisibility(0);
        }
        label813:
        AppMethodBeat.o(308983);
        return;
        label819:
        i = 0;
        break label528;
        label825:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.d
 * JD-Core Version:    0.7.0.1
 */