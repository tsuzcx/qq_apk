package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.i.f;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.ad.widget.countdown.PromotionBarLayout;
import com.tencent.mm.plugin.sns.ad.widget.living.FinderLivingAnimWrapper;
import com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.c;
import com.tencent.mm.plugin.sns.storage.ADXml.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.az;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private c.b JHi;
  private String JJA;
  private com.tencent.mm.plugin.sns.ad.widget.living.c JKm;
  private SnsInfo Jws;
  private a Lmg;
  private ax Lmh;
  private az Lmi;
  private boolean Lmj;
  
  public a()
  {
    AppMethodBeat.i(245825);
    this.Lmj = false;
    this.JJA = "";
    this.JHi = new c.b()
    {
      public final void fLc()
      {
        AppMethodBeat.i(254503);
        a.this.Kee.Kdz.a(a.a(a.this), null);
        AppMethodBeat.o(254503);
      }
      
      public final ViewGroup fLd()
      {
        return null;
      }
    };
    AppMethodBeat.o(245825);
  }
  
  private void ac(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(245831);
    if ((this.Kee != null) && (this.Kee.KYo != null) && (this.Kee.KYo.KBN != null) && (paramSnsInfo != null)) {
      this.Kee.KYo.KBN.Qn(paramSnsInfo.field_snsId);
    }
    AppMethodBeat.o(245831);
  }
  
  private void fLF()
  {
    AppMethodBeat.i(176415);
    com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "try show play btn");
    if ((this.Lmg != null) && (this.Lmg.JKG != null) && (!this.Lmj))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "show play btn");
      this.Lmg.JKG.JAL.setVisibility(0);
      this.Lmg.JKG.KKn.setVisibility(8);
      this.Lmg.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
      this.Lmg.JKG.JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
    }
    AppMethodBeat.o(176415);
  }
  
  private boolean fYA()
  {
    AppMethodBeat.i(177693);
    if ((this.Lmg.timeLineObject.ContentObj.Sqq == 5) || (this.Lmg.timeLineObject.ContentObj.Sqq == 15))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "%s cardAd doPause", new Object[] { this });
      if ((this.Lmg != null) && (this.Lmg.JKG != null))
      {
        this.Lmg.JKG.KKk.pause();
        ac(this.Jws);
      }
      this.Lmj = false;
      AppMethodBeat.o(177693);
      return true;
    }
    AppMethodBeat.o(177693);
    return false;
  }
  
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(245826);
    this.Lmg = ((a)paramBaseViewHolder);
    if (paramBaseViewHolder.LkR != null)
    {
      paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_ad_card_layout_item);
      if (!paramBaseViewHolder.LkS)
      {
        this.Lmg.mCB = ((ViewGroup)paramBaseViewHolder.LkR.inflate());
        paramBaseViewHolder.LkS = true;
      }
    }
    for (;;)
    {
      this.Lmg.uyC = ((ViewGroup)this.Lmg.mCB.findViewById(i.f.media_container));
      if ((this.Lmg.uyC instanceof RoundedCornerFrameLayout)) {
        ((RoundedCornerFrameLayout)this.Lmg.uyC).setRadius(com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 4));
      }
      this.Lmg.Lmm = ((ViewGroup)this.Lmg.mCB.findViewById(i.f.other_container));
      this.Lmg.JKs = ((MaskImageView)this.Lmg.mCB.findViewById(i.f.sns_card_ad_image));
      this.Lmg.JKs.setOnClickListener(this.Kee.Kdz.KEA);
      this.Kee.fXi().c(this.Lmg.JKs, this.Kee.Kdz.Lpd, this.Kee.Kdz.LoP);
      this.Lmg.Lmw = ((TextView)this.Lmg.mCB.findViewById(i.f.desc_collapse_pic_style_tv));
      this.Lmg.Lmw.setClickable(false);
      this.Lmg.Lmw.setLongClickable(false);
      this.Lmg.Lmv = ((TextView)this.Lmg.mCB.findViewById(i.f.desc_collapse_pic_style_title_tv));
      this.Lmg.Lmv.setClickable(false);
      this.Lmg.Lmv.setLongClickable(false);
      this.Lmg.JKG = new av();
      this.Lmg.JKG.KKm = this.Lmg.mCB.findViewById(i.f.sns_card_ad_sight);
      this.Lmg.JKG.KKj = this.Lmg.JKG.KKm;
      this.Lmg.JKG.KKm.setOnClickListener(this.Kee.Kdz.Lpo);
      this.Lmg.JKG.KKk = ((VideoSightView)this.Lmg.JKG.KKm.findViewById(i.f.image));
      this.Lmg.JKG.KKk.setMute(true);
      this.Lmg.JKG.JAL = ((ImageView)this.Lmg.JKG.KKm.findViewById(i.f.status_btn));
      this.Lmg.JKG.KKn = ((MMPinProgressBtn)this.Lmg.JKG.KKm.findViewById(i.f.progress));
      this.Lmg.JKG.KKo = ((TextView)this.Lmg.JKG.KKm.findViewById(i.f.endtv));
      this.Lmg.JKG.Ktc = ((TextView)this.Lmg.JKG.KKm.findViewById(i.f.errorTv));
      this.Lmg.Ljh = this.Lmg.mCB.findViewById(i.f.sns_ad_card_header_container);
      this.Lmg.Lmp = ((ImageView)this.Lmg.mCB.findViewById(i.f.sns_ad_card_header_avatar));
      this.Lmg.Lmq = ((TextView)this.Lmg.mCB.findViewById(i.f.sns_ad_card_header_title));
      this.Lmg.Lms = this.Lmg.mCB.findViewById(i.f.card_weapp_tag);
      this.Lmg.Lje = ((ImageView)this.Lmg.mCB.findViewById(i.f.weapp_auth_icon_iv));
      this.Lmg.Lmu = ((ImageView)this.Lmg.mCB.findViewById(i.f.weapp_icon_iv));
      this.Lmg.Lmt = ((TextView)this.Lmg.mCB.findViewById(i.f.weapp_tag_name));
      this.Lmg.Lja = this.Lmg.mCB.findViewById(i.f.card_btn_container);
      this.Lmg.Lmn = ((Button)this.Lmg.mCB.findViewById(i.f.card_btn_left));
      this.Lmg.Lmo = ((Button)this.Lmg.mCB.findViewById(i.f.card_btn_right));
      this.Lmg.Lmn.setOnClickListener(this.Kee.Kdz.Lpz);
      this.Lmg.Lmo.setOnClickListener(this.Kee.Kdz.LpA);
      this.Lmg.Lmr = ((SnsCardAdTagListView)this.Lmg.mCB.findViewById(i.f.card_ad_tag_list));
      this.Lmg.Lmr.setActivityContext(this.mActivity);
      this.Lmg.JKL = ((ViewGroup)this.Lmg.mCB.findViewById(i.f.sns_card_ad_online_video_container));
      this.Lmg.Ljk = this.Lmg.mCB.findViewById(i.f.action_btn_container);
      this.Lmg.JKJ = ((ViewStub)this.Lmg.mCB.findViewById(i.f.ad_live_anim_layout_stub));
      com.tencent.mm.sdk.platformtools.Log.d("MiroMsg.CardAdTimeLineItem", "the card ad build layout is end");
      AppMethodBeat.o(245826);
      return;
      if (!paramBaseViewHolder.LkS)
      {
        this.Lmg.mCB = ((ViewGroup)paramBaseViewHolder.convertView.findViewById(i.f.ad_card_container));
        paramBaseViewHolder.LkS = true;
      }
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176412);
    if ((paramBaseViewHolder.timeLineObject.ContentObj.Sqq == 5) || (paramBaseViewHolder.timeLineObject.ContentObj.Sqq == 15))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", new Object[] { this, Integer.valueOf(paramInt) });
      if (!(paramBaseViewHolder instanceof a)) {
        break label396;
      }
    }
    label396:
    for (boolean bool = ((a)paramBaseViewHolder).Ljs;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "In the card ad item, the useOnlineVideo is ".concat(String.valueOf(bool)));
      if (!bool)
      {
        com.tencent.mm.plugin.sns.ui.video.e.fZg().dmi();
        com.tencent.mm.plugin.sns.ui.video.b.fYX().a(this);
        paramBaseViewHolder.JKG.KKk.start();
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "try hide play btn");
        if ((this.Lmg != null) && (this.Lmg.JKG != null))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "hide play btn");
          this.Lmg.JKG.JAL.setVisibility(8);
          this.Lmg.JKG.KKn.setVisibility(8);
        }
        this.Lmj = true;
        if ((paramBaseViewHolder instanceof a)) {
          ((a)paramBaseViewHolder).JKq = false;
        }
        AppMethodBeat.o(176412);
        return;
        com.tencent.mm.plugin.sns.ui.video.b.fYX().pause();
        com.tencent.mm.sdk.platformtools.Log.w("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", new Object[] { this, Integer.valueOf(paramInt) });
        SnsInfo localSnsInfo = this.Jws;
        cvt localcvt = com.tencent.mm.plugin.sns.ad.timeline.b.g.a(paramBaseViewHolder);
        String str1 = com.tencent.mm.plugin.sns.ad.timeline.b.g.c(paramBaseViewHolder);
        com.tencent.mm.plugin.sns.ad.f.l locall = com.tencent.mm.plugin.sns.ad.timeline.b.g.a(this.Kee);
        ViewGroup localViewGroup = ((a)paramBaseViewHolder).JKL;
        String str2 = paramBaseViewHolder.fAg;
        if ((localSnsInfo != null) && (localcvt != null) && (localViewGroup != null))
        {
          com.tencent.mm.sdk.platformtools.Log.w("MiroMsg.CardAdTimeLineItem", "the sns info is " + localSnsInfo + " the media is " + localcvt);
          com.tencent.mm.plugin.sns.ad.timeline.video.online.d locald = new com.tencent.mm.plugin.sns.ad.timeline.video.online.d("MiroMsg.CardAdTimeLineItem");
          locald.mContainer = localViewGroup;
          locald.JLl = localcvt;
          locald.Jws = localSnsInfo;
          locald.veZ = str2;
          locald.JJA = str1;
          locald.JHg = locall;
          locald.a(3, new SnsTimelineVideoView.b()
          {
            public final void agY(String paramAnonymousString)
            {
              AppMethodBeat.i(268359);
              com.tencent.mm.sdk.platformtools.Log.w("MiroMsg.CardAdTimeLineItem", "timelineVideoView setUICallback onDestroy, the tlId is " + paramAnonymousString + ", the timelineId is " + a.b(a.this));
              if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(a.b(a.this))))
              {
                a.c(a.this);
                a.d(a.this);
              }
              AppMethodBeat.o(268359);
            }
          });
        }
      }
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, final bm parambm)
  {
    AppMethodBeat.i(100065);
    if (paramBaseViewHolder.jTm)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(100065);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "ad fillItem, cardAd, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
    paramBaseViewHolder.jTm = true;
    Object localObject1;
    if (paramTimeLineObject.Id == null)
    {
      localObject1 = "";
      this.JJA = ((String)localObject1);
      locala = (a)paramBaseViewHolder;
      localSnsInfo = parambm.agM(paramInt1);
      this.Jws = localSnsInfo;
      locala.Lms.setVisibility(8);
      locala.Lja.setVisibility(8);
      locala.Lmr.setVisibility(8);
      locala.Ljh.setVisibility(8);
      locala.Ljh.setTag("");
      if (this.Lmi != null) {
        this.Lmi.fUX();
      }
      if (paramBaseViewHolder.LkO != null) {
        paramBaseViewHolder.LkO.setVisibility(8);
      }
      localObject1 = (WindowManager)this.mActivity.getSystemService("window");
      paramInt2 = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
      ((a)paramBaseViewHolder).LkQ.setOnClickListener(parambm.Kdz.LpB);
      localObject2 = new LinearLayout.LayoutParams(paramInt2 - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(i.d.LittlePadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding), -2);
      ((LinearLayout.LayoutParams)localObject2).topMargin = this.mActivity.getResources().getDimensionPixelSize(i.d.MiddlePadding);
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 2);
      ((a)paramBaseViewHolder).mCB.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      parambm.fXi().c(paramBaseViewHolder.LkQ, parambm.Kdz.Lph, parambm.Kdz.LoP);
      if (locala.Lmw != null) {
        locala.Lmw.setVisibility(0);
      }
      if (locala.Lmv != null)
      {
        if (Util.isNullOrNil(localSnsInfo.getAdXml().adCardTitle)) {
          break label2173;
        }
        locala.Lmv.setVisibility(0);
      }
      label428:
      locala.Ljs = com.tencent.mm.plugin.sns.ad.timeline.b.b.b(paramTimeLineObject, localSnsInfo.getAdXml());
      locala.Lje.setTag("");
      if (locala.Lje.getVisibility() == 0) {
        locala.Lje.setVisibility(4);
      }
      localObject1 = localSnsInfo.getAdInfo();
      if ((localObject1 == null) || (!((ADInfo)localObject1).isWeapp()) || (localSnsInfo.isTurnCardAd())) {
        break label2186;
      }
      locala.Lms.setVisibility(0);
      locala.Lmt.setText(i.j.sns_ad_card_weapp_tag);
      com.tencent.mm.plugin.sns.ad.d.g.f(((ADInfo)localObject1).actionExtWeApp.appUserName, locala.Lje);
      label537:
      if (locala.Lms.getVisibility() == 0)
      {
        if (!ar.isDarkMode()) {
          break label2247;
        }
        if (!com.tencent.mm.plugin.sns.ad.d.l.a(this.Jws.getAdXml(), this.Jws.getAdInfo())) {
          break label2222;
        }
        locala.Lmu.setImageResource(i.i.album_ad_finder_link_dark_icon);
      }
      label585:
      if (!Util.isNullOrNil(localSnsInfo.getAdXml().adCardDesc)) {
        break label2306;
      }
      localObject1 = paramTimeLineObject.ContentDesc;
      label606:
      if (Util.isNullOrNil((String)localObject1)) {
        break label2319;
      }
      localObject1 = com.tencent.mm.cl.h.htZ().a(locala.Lmw.getContext(), (CharSequence)localObject1, locala.Lmw.getTextSize());
      locala.Lmw.setText((CharSequence)localObject1);
      locala.Lmw.setVisibility(0);
      label659:
      localObject1 = localSnsInfo.getAdXml().adCardTitle;
      if (!Util.isNullOrNil((String)localObject1)) {
        break label2332;
      }
      locala.Lmv.setVisibility(8);
    }
    for (;;)
    {
      try
      {
        localObject1 = localSnsInfo.getSnsId();
        if (com.tencent.mm.plugin.sns.ui.widget.b.lo(locala.Lmr.getOriginSnsId(), (String)localObject1)) {
          continue;
        }
        locala.Lmr.removeAllViews();
        if (localSnsInfo.getAdXml().adCardTagInfo.Kjx.size() > 0)
        {
          locala.Lmr.setVisibility(0);
          locala.Lmr.setTagSpace(com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 8));
          locala.Lmr.hX(localSnsInfo.getAdXml().adCardTagInfo.Kjx);
        }
        locala.Lmr.setOriginSnsId((String)localObject1);
      }
      catch (Exception localException)
      {
        int n;
        label2173:
        com.tencent.mm.sdk.platformtools.Log.e("MiroMsg.CardAdTimeLineItem", localException.toString());
        label2186:
        label2222:
        label2247:
        continue;
        label2306:
        label2319:
        label2332:
        locala.Lmq.setVisibility(4);
        continue;
        if (localSnsInfo.getAdXml().adMediaDisplayMode != 2) {
          continue;
        }
        int i = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 54);
        int j = this.mActivity.getResources().getDimensionPixelSize(i.d.LittlePadding);
        int k = this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding);
        int m = this.mActivity.getResources().getDimensionPixelSize(i.d.SmallPadding);
        paramBaseViewHolder.LkO.setContentWidth(paramInt2 - i - j - k - m);
        paramBaseViewHolder.LkO.fTg();
        continue;
        locala.Lmp.setVisibility(4);
        continue;
        if (this.Lmi == null) {
          continue;
        }
        this.Lmi.fUX();
        locala.Lja.setVisibility(0);
        j = this.mActivity.getResources().getColor(i.c.blue_text_color);
        k = this.mActivity.getResources().getColor(i.c.BW_0_Alpha_0_2);
        i = 1;
        paramInt2 = i;
        if (!localSnsInfo.getAdXml().hasVoteInfo()) {
          continue;
        }
        m = y.lj(localSnsInfo.getAdXml().adVoteInfo.Kkg, localSnsInfo.getUxinfo());
        paramInt2 = i;
        if (m <= 0) {
          continue;
        }
        paramInt2 = i;
        if (m > 2) {
          continue;
        }
        if (m != 1) {
          continue;
        }
        locala.Lmo.setTextColor(k);
        locala.Lmo.setText(localSnsInfo.getAdXml().adVoteInfo.agj(1));
        locala.Lmn.setTextColor(j);
        locala.Lmn.setText(localSnsInfo.getAdXml().adVoteInfo.agi(0));
        paramInt2 = 0;
        if (paramInt2 == 0) {
          continue;
        }
        locala.Lmn.setTextColor(j);
        locala.Lmo.setTextColor(j);
        locala.Lmn.setText(localSnsInfo.getAdXml().getCardSelectLeftTitle());
        locala.Lmo.setText(localSnsInfo.getAdXml().getCardSelectRightTitle());
        continue;
        if (m != 2) {
          continue;
        }
        locala.Lmn.setTextColor(k);
        locala.Lmn.setText(localSnsInfo.getAdXml().adVoteInfo.agj(0));
        locala.Lmo.setTextColor(j);
        locala.Lmo.setText(localSnsInfo.getAdXml().adVoteInfo.agi(1));
        continue;
        localcvt = null;
        continue;
        if (((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).Jww != null) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.Log.e(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mTag, "OnlineVideoChecker: the timeline object is null");
        continue;
        try
        {
          localViewGroup = ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mContainer;
          localTimeLineObject = ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).Jww;
          bool = ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).JLj;
          if (com.tencent.mm.plugin.sns.ad.i.l.N(localViewGroup))
          {
            if (bool)
            {
              localView = localViewGroup.getChildAt(0);
              if ((!(localView instanceof SnsTimelineVideoView)) || (Util.isEqual(((SnsTimelineVideoView)localView).Lrv, localTimeLineObject.Id))) {
                continue;
              }
              com.tencent.mm.sdk.platformtools.Log.i(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mTag, "OnlineVideoChecker: the online video container has child, but the time line id is different!!");
              com.tencent.mm.plugin.sns.ad.i.l.M(localViewGroup);
              continue;
            }
            com.tencent.mm.sdk.platformtools.Log.i(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mTag, "OnlineVideoChecker: it doesn't use online video container!!");
            com.tencent.mm.plugin.sns.ad.i.l.M(localViewGroup);
            continue;
          }
          com.tencent.mm.sdk.platformtools.Log.i(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mTag, "OnlineVideoChecker: there is no child video view in container!!");
        }
        catch (Throwable localThrowable) {}
        if ((paramBaseViewHolder.timeLineObject.ContentObj.Sqq != 5) && (paramBaseViewHolder.timeLineObject.ContentObj.Sqq != 15)) {
          continue;
        }
        locala.JKG.KKj.setVisibility(0);
        locala.JKs.setVisibility(4);
        parambm.fXi().c(locala.JKG.KKm, parambm.Kdz.Lph, parambm.Kdz.LoP);
        localObject2 = locala.JKG.KKj.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject2).height = i;
        locala.JKG.KKj.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        locala.JKG.KKk.ju(paramInt2, i);
        locala.JKG.KKk.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(196185);
            if (paramAnonymousInt != -1)
            {
              if ((parambm == null) || (parambm.KYo == null) || (parambm.KYo.KBN == null))
              {
                AppMethodBeat.o(196185);
                return;
              }
              parambm.KYo.KBN.I(parambn.Lbm, false);
              com.tencent.mm.sdk.platformtools.Log.d("MiroMsg.CardAdTimeLineItem", "onCompletion, snsId=" + t.Qu(localSnsInfo.field_snsId));
            }
            AppMethodBeat.o(196185);
          }
        });
        locala.JKG.KKk.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(266713);
            if ((parambm == null) || (parambm.KYo == null) || (parambm.KYo.KBN == null))
            {
              AppMethodBeat.o(266713);
              return;
            }
            if (localSnsInfo != null)
            {
              parambm.KYo.KBN.Qm(localSnsInfo.field_snsId);
              parambm.KYo.KBN.az(localSnsInfo.field_snsId, 1000L * paramAnonymousLong);
            }
            if (!parambm.KYo.KBN.Qj(parambn.Lbm))
            {
              int i = (int)paramAnonymousb.fIF();
              parambm.KYo.KBN.c(parambn.Lbm, Util.currentTicks(), false);
              parambm.KYo.KBN.e(parambn.Lbm, i, false);
              parambm.KYo.KBN.ay(parambn.Lbm, parambn.Lbm);
            }
            com.tencent.mm.sdk.platformtools.Log.d("MiroMsg.CardAdTimeLineItem", "onDecodeProgress, currentTime=" + paramAnonymousLong + ", snsId=" + t.Qu(localSnsInfo.field_snsId));
            AppMethodBeat.o(266713);
          }
        });
        if (!locala.Ljs) {
          continue;
        }
        com.tencent.mm.plugin.sns.ad.d.d.a(localSnsInfo, localcvt);
        l = System.nanoTime();
        bool = com.tencent.mm.plugin.sns.model.g.u(localcvt);
        com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
        localObject2 = locala.JKG;
        if (bool) {
          continue;
        }
        if (!((com.tencent.mm.plugin.sns.model.g)localObject3).x(localcvt)) {
          continue;
        }
        ((av)localObject2).JAL.setVisibility(8);
        ((av)localObject2).KKn.setVisibility(0);
        ((av)localObject2).KKn.hZF();
        locala.Lmn.setTag(locala);
        locala.Lmo.setTag(locala);
        ((av)localObject2).KKk.setTagObject(localObject2);
        ((av)localObject2).KKm.setTag(locala);
        if (!locala.Ljs) {
          continue;
        }
        localObject2 = ((av)localObject2).KKk;
        j = this.mActivity.hashCode();
        Object localObject4 = bp.hzh();
        ((bp)localObject4).time = paramTimeLineObject.CreateTime;
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(localSnsInfo, localcvt, (VideoSightView)localObject2, -1, j, paramInt1, (bp)localObject4, parambn.KBz, true, false);
        localObject2 = aq.kD(aj.getAccSnsPath(), localcvt.Id);
        Object localObject3 = t.i(localcvt);
        localObject2 = (String)localObject2 + (String)localObject3;
        if (!u.agG((String)localObject2)) {
          continue;
        }
        parambm.KYo.KBN.f(parambn.Lbm, (int)localcvt.TDZ, true);
        if (!com.tencent.mm.plugin.sns.ad.d.d.No()) {
          continue;
        }
        bool = v.isH265Video((String)localObject2);
        com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "AdH265Helper, fileExists, isH265File=" + bool + ", path=" + (String)localObject2);
        if (aj.fOF().b(localSnsInfo, null) != 5) {
          continue;
        }
        bool = true;
        parambm.KYo.KBN.d(parambn.Lbm, bool, false);
        if (!locala.Ljs) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.Log.d("MiroMsg.CardAdTimeLineItem", "in fillitem, the user online video is true");
        com.tencent.mm.plugin.sns.ad.i.l.v(locala.JKL, paramInt2, i);
        parambn = locala.JKL;
        localObject2 = new com.tencent.mm.plugin.sns.ad.timeline.video.online.c("MiroMsg.CardAdTimeLineItem");
        ((com.tencent.mm.plugin.sns.ad.timeline.video.online.c)localObject2).rnd = parambn;
        ((com.tencent.mm.plugin.sns.ad.timeline.video.online.c)localObject2).JLl = localcvt;
        ((com.tencent.mm.plugin.sns.ad.timeline.video.online.c)localObject2).JLk = paramTimeLineObject;
        ((com.tencent.mm.plugin.sns.ad.timeline.video.online.c)localObject2).veZ = paramBaseViewHolder.fAg;
        ((com.tencent.mm.plugin.sns.ad.timeline.video.online.c)localObject2).fP();
        com.tencent.mm.plugin.sns.ad.i.l.w(locala.JKG.KKn, false);
        continue;
        com.tencent.mm.plugin.sns.ad.d.d.a(localcvt, false);
        continue;
        if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localSnsInfo, null) != 5) {
          continue;
        }
        ((com.tencent.mm.plugin.sns.model.g)localObject3).B(localcvt);
        ((av)localObject2).JAL.setVisibility(8);
        ((av)localObject2).KKn.setVisibility(0);
        ((av)localObject2).KKn.hZF();
        continue;
        if (!((com.tencent.mm.plugin.sns.model.g)localObject3).y(localcvt)) {
          continue;
        }
        ((av)localObject2).KKn.setVisibility(8);
        ((av)localObject2).JAL.setImageResource(i.i.shortvideo_play_icon_err);
        ((av)localObject2).JAL.setVisibility(0);
        continue;
        ((com.tencent.mm.plugin.sns.model.g)localObject3).z(localcvt);
        ((av)localObject2).JAL.setVisibility(0);
        ((av)localObject2).KKn.setVisibility(8);
        ((av)localObject2).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
        ((av)localObject2).JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
        if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localSnsInfo, null) != 4) {
          continue;
        }
        ((av)localObject2).Ktc.setVisibility(0);
        continue;
        if (!((com.tencent.mm.plugin.sns.model.g)localObject3).v(localcvt)) {
          continue;
        }
        ((av)localObject2).JAL.setVisibility(0);
        ((av)localObject2).KKn.setVisibility(8);
        ((av)localObject2).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
        ((av)localObject2).JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
        if (!((av)localObject2).KKk.JsW.fIC()) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.Log.e("MiroMsg.CardAdTimeLineItem", "play video error " + localcvt.Id + " " + localcvt.Url + " " + localcvt.TDF + " " + paramInt1);
        ((com.tencent.mm.plugin.sns.model.g)localObject3).z(localcvt);
        ((av)localObject2).JAL.setVisibility(0);
        ((av)localObject2).KKn.setVisibility(8);
        ((av)localObject2).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
        ((av)localObject2).JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
        continue;
        if (!((com.tencent.mm.plugin.sns.model.g)localObject3).w(localcvt)) {
          continue;
        }
        ((av)localObject2).JAL.setVisibility(8);
        ((av)localObject2).KKn.setVisibility(8);
        continue;
        if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localSnsInfo, null) > 5) {
          continue;
        }
        if (locala.JKq) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "fillItem, showPlayBtn");
        fLF();
        continue;
        ((com.tencent.mm.plugin.sns.model.g)localObject3).z(localcvt);
        ((av)localObject2).JAL.setVisibility(0);
        ((av)localObject2).KKn.setVisibility(8);
        ((av)localObject2).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
        ((av)localObject2).JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
        continue;
        continue;
        localObject2 = ((av)localObject2).KKk;
        j = this.mActivity.hashCode();
        localObject4 = bp.hzh();
        ((bp)localObject4).time = paramTimeLineObject.CreateTime;
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(localSnsInfo, localcvt, (VideoSightView)localObject2, j, paramInt1, (bp)localObject4, parambn.KBz, true);
        continue;
        parambm.KYo.KBN.f(parambn.Lbm, (int)localcvt.TDZ, false);
        continue;
        bool = false;
        continue;
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(paramBaseViewHolder.JKG.KKk, this.mActivity.hashCode(), paramInt1);
        paramBaseViewHolder.JKG.KKo.setVisibility(8);
        paramBaseViewHolder.JKG.KKk.setOnSightCompletionAction(null);
        paramBaseViewHolder.JKG.KKk.setOnCompletionListener(null);
        paramBaseViewHolder.JKG.KKk.setOnDecodeDurationListener(null);
        continue;
        locala.Ljk.setVisibility(8);
        continue;
        parambn = localSnsInfo.getAdXml().adPromotionInfo;
        if ((parambn == null) || (!f.aA(parambn.startTime, parambn.endTime))) {
          continue;
        }
        paramInt1 = 1;
        continue;
        if (this.Lmg.Ljl == null) {
          continue;
        }
        this.Lmg.Ljl.setVisibility(8);
        continue;
        paramInt1 = 0;
        continue;
        paramInt1 = 0;
        continue;
        continue;
        paramInt1 = 0;
        continue;
      }
      if (Util.isNullOrNil(localSnsInfo.getAdXml().adCard3dHeadTitle)) {
        continue;
      }
      locala.Ljh.setVisibility(0);
      locala.Lmq.setVisibility(0);
      locala.Lmq.setText(localSnsInfo.getAdXml().adCard3dHeadTitle);
      if (localSnsInfo.getAdXml().adMediaDisplayMode != 1) {
        continue;
      }
      i = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 54);
      j = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 54);
      k = this.mActivity.getResources().getDimensionPixelSize(i.d.LittlePadding);
      m = this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding);
      n = this.mActivity.getResources().getDimensionPixelSize(i.d.SmallPadding);
      paramBaseViewHolder.LkO.setContentWidth(paramInt2 - i - j - k - m - n);
      paramBaseViewHolder.LkO.fTg();
      locala.Ljh.setTag(localSnsInfo.getAdXml().adCard3dHeadUrl);
      if (Util.isNullOrNil(localSnsInfo.getAdXml().adCard3dHeadUrl)) {
        continue;
      }
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localSnsInfo.getAdXml().adCard3dHeadUrl, false, new f.a()
      {
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(269150);
          com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
          if ((!Util.isNullOrNil(new String[] { (String)locala.Ljh.getTag(), paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", (String)locala.Ljh.getTag()))))
          {
            paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              locala.Ljh.setVisibility(0);
              locala.Lmp.setImageBitmap(paramAnonymousString);
              locala.Lmp.setVisibility(0);
            }
          }
          AppMethodBeat.o(269150);
        }
        
        public final void fJU() {}
        
        public final void fJV() {}
      });
      if ((localSnsInfo.getAdXml().hasSelectInfo()) || (localSnsInfo.getAdXml().hasVoteInfo()))
      {
        if (!localSnsInfo.getAdXml().isNewStyleVote()) {
          continue;
        }
        if (this.Lmi == null)
        {
          localObject1 = (ViewStub)locala.mCB.findViewById(i.f.sns_ad_card_vote_layout_stub);
          if (localObject1 != null)
          {
            localObject1 = com.tencent.mm.plugin.sns.ad.i.l.c((ViewStub)localObject1);
            com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "inflate new style vote button");
            if (localObject1 != null)
            {
              this.Lmi = new az(this.mActivity, locala.mCB, parambm.Kdz);
              com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "initialize SnsAdCardVoteCtrl");
            }
          }
        }
        if (this.Lmi != null)
        {
          this.Lmi.fUW();
          this.Lmi.a(localSnsInfo, locala);
        }
        locala.Lja.setVisibility(8);
        if (locala.Lmw != null) {
          locala.Lmw.setVisibility(8);
        }
        if (locala.Lmv != null) {
          locala.Lmv.setVisibility(8);
        }
      }
      locala.JKs.setScaleType(QImageView.a.Ydm);
      locala.JKG.KKk.Jte = true;
      locala.JKG.KKk.setScaleType(QImageView.a.Ydm);
      if ((paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.Sqr.size() <= 0)) {
        continue;
      }
      localObject1 = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
      localObject3 = aj.fOF();
      if ((paramBaseViewHolder.JKG.KKi != null) && (!Util.isEqual(paramBaseViewHolder.JKG.KKi.Id, paramTimeLineObject.Id)))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.JKG.KKi.Id });
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(paramBaseViewHolder.JKG.KKk, this.mActivity.hashCode(), paramInt1);
      }
      paramBaseViewHolder.JKG.a(paramTimeLineObject, paramInt1, parambn.KDB, parambn.KBz);
      paramBaseViewHolder.JKG.Ktc.setVisibility(8);
      localObject4 = new com.tencent.mm.plugin.sns.ad.timeline.video.online.b("MiroMsg.CardAdTimeLineItem");
      ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mContainer = locala.JKL;
      ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).Jww = paramTimeLineObject;
      ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).JLj = locala.Ljs;
      if (((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mContainer != null) {
        continue;
      }
      com.tencent.mm.sdk.platformtools.Log.e(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mTag, "OnlineVideoChecker: the container is null");
      if (localObject1 != null)
      {
        paramInt2 = ((LinearLayout.LayoutParams)localObject2).width - this.mActivity.getResources().getDimensionPixelSize(i.d.SmallPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.SmallPadding);
        i = (int)(paramInt2 * ((cvt)localObject1).TDH.TEv / ((cvt)localObject1).TDH.TEu);
        if (paramBaseViewHolder.timeLineObject.ContentObj.Sqq != 1) {
          continue;
        }
        locala.JKs.setVisibility(0);
        locala.JKG.KKj.setVisibility(4);
        parambn = locala.JKs.getLayoutParams();
        parambn.width = paramInt2;
        parambn.height = i;
        locala.JKs.setLayoutParams(parambn);
        parambn = aj.fOF();
        localObject2 = locala.JKs;
        paramInt1 = this.mActivity.hashCode();
        localObject3 = bp.hzh();
        ((bp)localObject3).time = paramTimeLineObject.CreateTime;
        parambn.b((cvt)localObject1, (View)localObject2, -1, paramInt1, (bp)localObject3);
        locala.JKs.setTag(locala);
        locala.Lmn.setTag(locala);
        locala.Lmo.setTag(locala);
        locala.JKs.setOnClickListener(parambm.Kdz.KEA);
        parambm.fXi().c(locala.JKs, parambm.Kdz.Lph, parambm.Kdz.LoP);
        locala.JKq = false;
      }
      if (!localSnsInfo.getAdXml().hasActionBtn()) {
        continue;
      }
      if (locala.Lmw != null) {
        locala.Lmw.setVisibility(8);
      }
      if (locala.Lmv != null) {
        locala.Lmv.setVisibility(8);
      }
      locala.Ljk.setVisibility(0);
      if (this.Lmh == null) {
        this.Lmh = new ax(this.mActivity, locala.mCB, 0, parambm.KYo.KBN, this.JHi);
      }
      this.Lmh.W(localSnsInfo);
      if (localSnsInfo == null) {
        continue;
      }
      try
      {
        if (localSnsInfo.getAdXml() != null) {
          continue;
        }
      }
      catch (Throwable parambn)
      {
        continue;
        paramInt1 = 1;
        continue;
        if (this.JKm != null) {
          continue;
        }
        this.JKm = new com.tencent.mm.plugin.sns.ad.widget.living.c(this.Lmg.JKI, this.Lmg.Ljp, this.Lmh);
        if ((parambn == null) || (this.JKm == null)) {
          continue;
        }
        paramTimeLineObject = localSnsInfo.getAdXml().adLiveInfo;
        paramInt1 = com.tencent.mm.plugin.sns.ad.widget.living.b.fX(parambn.Id, paramTimeLineObject.liveType);
        this.JKm.a(parambn.Id, paramTimeLineObject);
        this.JKm.setLiveStatus(paramInt1);
        com.tencent.mm.plugin.sns.ad.widget.living.b.a(parambn.Id, this.JKm);
        com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.fLk().b(0, localSnsInfo);
        bool = com.tencent.mm.plugin.sns.ad.widget.living.c.afn(paramInt1);
        parambn = parambn.Id;
        if (!FinderLivingAnimWrapper.a(paramTimeLineObject, bool)) {
          continue;
        }
        if (this.Lmg.JKK != null) {
          continue;
        }
        this.Lmg.JKK = ((FinderLivingAnimWrapper)this.Lmg.JKJ.inflate());
        com.tencent.mm.sdk.platformtools.Log.d("MiroMsg.CardAdTimeLineItem", "checkShowLivingAnim, snsId=".concat(String.valueOf(parambn)));
        if (this.Lmg.JKK == null) {
          continue;
        }
        paramInt1 = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 60);
        paramInt2 = this.Lmg.mCB.getHeight();
        i = this.Lmg.uyC.getHeight();
        if ((paramInt2 <= 0) || (i <= 0)) {
          continue;
        }
        j = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 8);
        this.Lmg.JKK.a(paramTimeLineObject, parambn, paramInt1, paramInt2 - i + j);
        this.Lmg.JKK.setVisibility(0);
        continue;
      }
      if (paramInt1 == 0) {
        continue;
      }
      parambn = localSnsInfo.getAdXml().adPromotionInfo;
      if (this.Lmg.Ljl == null)
      {
        paramTimeLineObject = (ViewStub)this.Lmg.mCB.findViewById(i.f.ad_promotion_bar_stub);
        if (paramTimeLineObject != null)
        {
          this.Lmg.Ljl = ((PromotionBarLayout)com.tencent.mm.plugin.sns.ad.i.l.c(paramTimeLineObject));
          com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "inflate the promotionBar");
        }
      }
      if (this.Lmg.Ljl != null)
      {
        this.Lmg.Ljl.setVisibility(0);
        this.Lmg.Ljl.setPromotionalPrice(parambn.JyA);
        this.Lmg.Ljl.setRightTitle(parambn.JyB);
        com.tencent.mm.plugin.sns.ad.i.l.i(this.Lmg.Ljl, com.tencent.mm.plugin.sns.ad.i.e.kp(parambn.Jyy, parambn.nWx));
        this.Lmg.Ljl.b(new com.tencent.mm.plugin.sns.ad.widget.countdown.b(parambn.startTime, parambn.endTime));
      }
      if (localSnsInfo == null) {
        continue;
      }
      try
      {
        if (localSnsInfo.getAdXml() == null) {
          continue;
        }
        if (localSnsInfo.getAdXml().adLiveInfo != null) {
          continue;
        }
      }
      catch (Throwable parambn)
      {
        cvt localcvt;
        ViewGroup localViewGroup;
        TimeLineObject localTimeLineObject;
        boolean bool;
        View localView;
        long l;
        com.tencent.mm.sdk.platformtools.Log.e("MiroMsg.CardAdTimeLineItem", "fillLivingViewInfo, exp=" + android.util.Log.getStackTraceString(parambn));
        continue;
        com.tencent.mm.sdk.platformtools.Log.w("MiroMsg.CardAdTimeLineItem", "checkShowLivingAnim, contentH==0");
        continue;
        if (this.Lmg.JKK == null) {
          continue;
        }
        this.Lmg.JKK.setVisibility(8);
        continue;
        if (this.Lmg.JKI == null) {
          continue;
        }
        this.Lmg.JKI.setVisibility(8);
        if (this.Lmg.Ljp == null) {
          continue;
        }
        this.Lmg.Ljp.setVisibility(8);
        if (this.Lmg.JKK == null) {
          continue;
        }
        this.Lmg.JKK.setVisibility(8);
        continue;
      }
      if (paramInt1 == 0) {
        continue;
      }
      parambn = localSnsInfo.getTimeLine();
      if (this.Lmg.JKI == null)
      {
        paramTimeLineObject = (ViewStub)this.Lmg.mCB.findViewById(i.f.ad_live_status_layout_stub);
        if (paramTimeLineObject != null)
        {
          this.Lmg.JKI = ((ViewGroup)com.tencent.mm.plugin.sns.ad.i.l.c(paramTimeLineObject));
          com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "inflate the living status");
        }
      }
      if (this.Lmg.Ljp == null)
      {
        paramTimeLineObject = (ViewStub)this.Lmg.mCB.findViewById(i.f.ad_live_desc_layout_stub);
        if (paramTimeLineObject != null)
        {
          this.Lmg.Ljp = ((LivingDescBarLayout)com.tencent.mm.plugin.sns.ad.i.l.c(paramTimeLineObject));
          com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "inflate the living des bar");
        }
      }
      if ((this.Lmg.JKI != null) && (this.Lmg.Ljp != null)) {
        continue;
      }
      com.tencent.mm.sdk.platformtools.Log.e("MiroMsg.CardAdTimeLineItem", "the livingStatusLayout or livingDescBar is null!!");
      paramBaseViewHolder.jTm = false;
      AppMethodBeat.o(100065);
      return;
      localObject1 = paramTimeLineObject.Id;
      break;
      locala.Lmv.setVisibility(8);
      break label428;
      if (!com.tencent.mm.plugin.sns.ad.d.l.a(localSnsInfo.getAdXml(), (ADInfo)localObject1)) {
        break label537;
      }
      locala.Lms.setVisibility(0);
      locala.Lmt.setText(i.j.finder_app_name);
      break label537;
      locala.Lmu.setImageResource(i.i.album_ad_link_tag_weapp_dark);
      locala.Lje.setImageResource(i.e.ad_weapp_auth_dark_icon);
      break label585;
      if (com.tencent.mm.plugin.sns.ad.d.l.a(this.Jws.getAdXml(), this.Jws.getAdInfo()))
      {
        locala.Lmu.setImageResource(i.i.album_ad_finder_link_icon);
        break label585;
      }
      locala.Lmu.setImageResource(i.i.album_ad_link_tag_weapp);
      locala.Lje.setImageResource(i.e.ad_weapp_auth_icon);
      break label585;
      localObject1 = localSnsInfo.getAdXml().adCardDesc;
      break label606;
      locala.Lmw.setVisibility(8);
      break label659;
      localObject1 = com.tencent.mm.cl.h.htZ().a(locala.Lmv.getContext(), (CharSequence)localObject1, locala.Lmv.getTextSize());
      locala.Lmv.setText((CharSequence)localObject1);
      locala.Lmv.setVisibility(0);
      continue;
      if (localSnsInfo.getAdXml().adCardTagInfo.Kjx.size() > 0) {
        locala.Lmr.setVisibility(0);
      }
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(176416);
    if ((this.Lmg != null) && (this.Lmg.uyC != null))
    {
      Object localObject = new int[2];
      this.Lmg.uyC.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.Lmg.uyC.getMeasuredWidth() + i, this.Lmg.uyC.getMeasuredHeight() + j);
      AppMethodBeat.o(176416);
      return localObject;
    }
    AppMethodBeat.o(176416);
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177692);
    com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "onUIPause");
    fYA();
    AppMethodBeat.o(177692);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176413);
    com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "pause");
    if (fYA()) {
      fLF();
    }
    AppMethodBeat.o(176413);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176414);
    com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "%s cardAd stop", new Object[] { this });
    if ((this.Lmg != null) && (this.Lmg.JKG != null)) {
      this.Lmg.JKG.KKk.JsW.clear();
    }
    this.Lmj = false;
    AppMethodBeat.o(176414);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public ViewGroup JKI;
    public ViewStub JKJ;
    public FinderLivingAnimWrapper JKK;
    public ViewGroup JKL;
    public boolean JKq;
    public MaskImageView JKs;
    public View Lja;
    public ImageView Lje;
    public View Ljh;
    public View Ljk;
    public PromotionBarLayout Ljl;
    public LivingDescBarLayout Ljp;
    public boolean Ljs;
    public ViewGroup Lmm;
    public Button Lmn;
    public Button Lmo;
    public ImageView Lmp;
    public TextView Lmq;
    public SnsCardAdTagListView Lmr;
    public View Lms;
    public TextView Lmt;
    public ImageView Lmu;
    public TextView Lmv;
    public TextView Lmw;
    public ViewGroup mCB;
    public ViewGroup uyC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a
 * JD-Core Version:    0.7.0.1
 */