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
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.d;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.d.n;
import com.tencent.mm.plugin.sns.ad.j.f;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.ad.timeline.video.online.d;
import com.tencent.mm.plugin.sns.ad.widget.countdown.PromotionBarLayout;
import com.tencent.mm.plugin.sns.ad.widget.living.FinderLivingAnimWrapper;
import com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.c;
import com.tencent.mm.plugin.sns.storage.ADXml.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.plugin.sns.ui.widget.ad.AdRoundedCornerFrameLayout;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.smiley.u;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private SnsInfo PJQ;
  private c.b PYj;
  private com.tencent.mm.plugin.sns.ad.widget.living.c QbR;
  private String Qbe;
  private com.tencent.mm.plugin.sns.ad.timeline.helper.g RJu;
  private a RLV;
  private ay RLW;
  private ba RLX;
  private boolean RLY;
  
  public a()
  {
    AppMethodBeat.i(309029);
    this.RLY = false;
    this.Qbe = "";
    this.PYj = new c.b()
    {
      public final void hbt()
      {
        AppMethodBeat.i(308948);
        a.this.QBJ.QBf.m(a.a(a.this));
        AppMethodBeat.o(308948);
      }
      
      public final ViewGroup hbu()
      {
        return null;
      }
    };
    AppMethodBeat.o(309029);
  }
  
  private void ae(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309042);
    if ((this.QBJ != null) && (this.QBJ.Ryp != null) && (this.QBJ.Ryp.Rbv != null) && (paramSnsInfo != null)) {
      this.QBJ.Ryp.Rbv.uu(paramSnsInfo.field_snsId);
    }
    AppMethodBeat.o(309042);
  }
  
  private void hcb()
  {
    AppMethodBeat.i(176415);
    com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "try show play btn");
    if ((this.RLV != null) && (this.RLV.Qcj != null) && (!this.RLY))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "show play btn");
      this.RLV.Qcj.PQu.setVisibility(0);
      this.RLV.Qcj.RjP.setVisibility(8);
      this.RLV.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
      this.RLV.Qcj.PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
    }
    AppMethodBeat.o(176415);
  }
  
  private boolean hqV()
  {
    AppMethodBeat.i(177693);
    if ((this.RLV.timeLineObject.ContentObj.Zpq == 5) || (this.RLV.timeLineObject.ContentObj.Zpq == 15))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "%s cardAd doPause", new Object[] { this });
      if ((this.RLV != null) && (this.RLV.Qcj != null))
      {
        this.RLV.Qcj.RjM.pause();
        ae(this.PJQ);
      }
      this.RLY = false;
      AppMethodBeat.o(177693);
      return true;
    }
    AppMethodBeat.o(177693);
    return false;
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176412);
    if ((paramBaseViewHolder.timeLineObject.ContentObj.Zpq == 5) || (paramBaseViewHolder.timeLineObject.ContentObj.Zpq == 15))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", new Object[] { this, Integer.valueOf(paramInt) });
      if (!(paramBaseViewHolder instanceof a)) {
        break label391;
      }
    }
    label391:
    for (boolean bool = ((a)paramBaseViewHolder).QbW;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "In the card ad item, the useOnlineVideo is ".concat(String.valueOf(bool)));
      if (!bool)
      {
        com.tencent.mm.plugin.sns.ui.video.e.hsu().bck();
        com.tencent.mm.plugin.sns.ui.video.b.hsi().a(this);
        paramBaseViewHolder.Qcj.RjM.start();
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "try hide play btn");
        if ((this.RLV != null) && (this.RLV.Qcj != null))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "hide play btn");
          this.RLV.Qcj.PQu.setVisibility(8);
          this.RLV.Qcj.RjP.setVisibility(8);
        }
        this.RLY = true;
        if ((paramBaseViewHolder instanceof a)) {
          ((a)paramBaseViewHolder).QbV = false;
        }
        AppMethodBeat.o(176412);
        return;
        com.tencent.mm.plugin.sns.ui.video.b.hsi().pause();
        com.tencent.mm.sdk.platformtools.Log.w("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", new Object[] { this, Integer.valueOf(paramInt) });
        SnsInfo localSnsInfo = this.PJQ;
        dmz localdmz = com.tencent.mm.plugin.sns.ad.timeline.helper.j.a(paramBaseViewHolder);
        String str1 = com.tencent.mm.plugin.sns.ad.timeline.helper.j.c(paramBaseViewHolder);
        com.tencent.mm.plugin.sns.ad.g.l locall = com.tencent.mm.plugin.sns.ad.timeline.helper.j.a(this.QBJ);
        ViewGroup localViewGroup = ((a)paramBaseViewHolder).Qcq;
        String str2 = paramBaseViewHolder.hES;
        if ((localSnsInfo != null) && (localdmz != null) && (localViewGroup != null))
        {
          com.tencent.mm.sdk.platformtools.Log.w("MiroMsg.CardAdTimeLineItem", "the sns info is " + localSnsInfo + " the media is " + localdmz);
          d locald = new d("MiroMsg.CardAdTimeLineItem");
          locald.mContainer = localViewGroup;
          locald.QcU = localdmz;
          locald.PJQ = localSnsInfo;
          locald.yqW = str2;
          locald.Qbe = str1;
          locald.PYh = locall;
          locald.a(3, new SnsTimelineVideoView.b()
          {
            public final void ZW(String paramAnonymousString)
            {
              AppMethodBeat.i(308949);
              com.tencent.mm.sdk.platformtools.Log.w("MiroMsg.CardAdTimeLineItem", "timelineVideoView setUICallback onDestroy, the tlId is " + paramAnonymousString + ", the timelineId is " + a.b(a.this));
              if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(a.b(a.this))))
              {
                a.c(a.this);
                a.d(a.this);
              }
              AppMethodBeat.o(308949);
            }
          });
        }
      }
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, final bn parambn)
  {
    AppMethodBeat.i(100065);
    if (paramBaseViewHolder.mtE)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(100065);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "ad fillItem, cardAd, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
    paramBaseViewHolder.mtE = true;
    Object localObject1;
    final a locala;
    final SnsInfo localSnsInfo;
    int i;
    Object localObject2;
    if (paramTimeLineObject.Id == null)
    {
      localObject1 = "";
      this.Qbe = ((String)localObject1);
      locala = (a)paramBaseViewHolder;
      localSnsInfo = parambn.alF(paramInt1);
      this.PJQ = localSnsInfo;
      locala.RMh.setVisibility(8);
      locala.RJc.setVisibility(8);
      locala.RMg.setVisibility(8);
      locala.RJj.setVisibility(8);
      locala.RJj.setTag("");
      if (this.RLX != null) {
        this.RLX.hno();
      }
      if ((locala.pzi instanceof AdRoundedCornerFrameLayout)) {
        ((AdRoundedCornerFrameLayout)locala.pzi).l(this.PJQ, 1);
      }
      if (paramBaseViewHolder.RKD != null) {
        paramBaseViewHolder.RKD.setVisibility(8);
      }
      localObject1 = (WindowManager)this.mActivity.getSystemService("window");
      paramInt2 = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
      ((a)paramBaseViewHolder).RKF.setOnClickListener(parambn.QBf.RQG);
      i = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 14);
      localObject2 = new LinearLayout.LayoutParams(paramInt2 - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 56) - i - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding), -2);
      if ((!com.tencent.mm.ui.aw.jkS()) || (ag.aAk(this.mActivity.getTaskId()))) {
        break label5284;
      }
      localObject2 = new LinearLayout.LayoutParams(bd.bs(MMApplicationContext.getContext(), b.d.sns_timeline_item_large_screen_width), -2);
      label375:
      ((LinearLayout.LayoutParams)localObject2).topMargin = this.mActivity.getResources().getDimensionPixelSize(b.d.MiddlePadding);
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 2);
      ((a)paramBaseViewHolder).pzi.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      parambn.hpB().c(paramBaseViewHolder.RKF, parambn.QBf.RQm, parambn.QBf.RPU);
      if (locala.RMl != null) {
        locala.RMl.setVisibility(0);
      }
      if (locala.RMk != null)
      {
        if (Util.isNullOrNil(localSnsInfo.getAdXml().adCardTitle)) {
          break label2446;
        }
        locala.RMk.setVisibility(0);
      }
      label494:
      locala.QbW = com.tencent.mm.plugin.sns.ad.timeline.helper.b.b(paramTimeLineObject, localSnsInfo.getAdXml());
      locala.RJg.setTag("");
      if (locala.RJg.getVisibility() == 0) {
        locala.RJg.setVisibility(4);
      }
      localObject1 = localSnsInfo.getAdInfo();
      if ((localObject1 == null) || (!((ADInfo)localObject1).isWeapp()) || (localSnsInfo.isTurnCardAd())) {
        break label2459;
      }
      locala.RMh.setVisibility(0);
      locala.RMi.setText(b.j.sns_ad_card_weapp_tag);
      com.tencent.mm.plugin.sns.ad.d.i.a(((ADInfo)localObject1).actionExtWeApp.appUserName, locala.RJg, (ADInfo)localObject1);
      label605:
      if (locala.RMh.getVisibility() == 0)
      {
        if (!com.tencent.mm.ui.aw.isDarkMode()) {
          break label2509;
        }
        if (!n.a(this.PJQ.getAdXml(), this.PJQ.getAdInfo())) {
          break label2495;
        }
        locala.RMj.setImageResource(b.i.album_ad_finder_link_dark_icon);
      }
      label653:
      if (!Util.isNullOrNil(localSnsInfo.getAdXml().adCardDesc)) {
        break label2557;
      }
      localObject1 = paramTimeLineObject.ContentDesc;
      label674:
      if (Util.isNullOrNil((String)localObject1)) {
        break label2570;
      }
      localObject1 = u.iVt().a(locala.RMl.getContext(), (CharSequence)localObject1, locala.RMl.getTextSize());
      locala.RMl.setText((CharSequence)localObject1);
      locala.RMl.setVisibility(0);
      label727:
      localObject1 = localSnsInfo.getAdXml().adCardTitle;
      if (!Util.isNullOrNil((String)localObject1)) {
        break label2583;
      }
      locala.RMk.setVisibility(8);
    }
    try
    {
      label755:
      localObject1 = locala.RMg.getTag();
      if (localSnsInfo.getAdXml().adCardTagInfo.QHu.equals(localObject1)) {
        break label2631;
      }
      locala.RMg.removeAllViews();
      if (localSnsInfo.getAdXml().adCardTagInfo.QHu.size() > 0)
      {
        locala.RMg.setVisibility(0);
        locala.RMg.setTagSpace(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8));
        locala.RMg.lc(localSnsInfo.getAdXml().adCardTagInfo.QHu);
        com.tencent.mm.sdk.platformtools.Log.d("MiroMsg.CardAdTimeLineItem", "adCardTagList refreshed");
      }
      locala.RMg.setTag(localSnsInfo.getAdXml().adCardTagInfo.QHu);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label885:
        Object localObject3;
        Object localObject4;
        label1567:
        label2495:
        label2509:
        label2557:
        com.tencent.mm.sdk.platformtools.Log.e("MiroMsg.CardAdTimeLineItem", localException.toString());
        label2446:
        label2459:
        label2631:
        continue;
        label2570:
        label2583:
        locala.RMf.setVisibility(4);
        continue;
        label2697:
        if (localSnsInfo.getAdXml().adMediaDisplayMode == 2)
        {
          i = paramInt2 - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(b.d.LittlePadding) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(b.d.SmallPadding);
          paramInt2 = i;
          if (com.tencent.mm.ui.aw.jkS())
          {
            paramInt2 = i;
            if (!ag.aAk(this.mActivity.getTaskId())) {
              paramInt2 = bd.bs(MMApplicationContext.getContext(), b.d.sns_timeline_item_large_screen_width);
            }
          }
          paramBaseViewHolder.RKD.setContentWidth(paramInt2);
          paramBaseViewHolder.RKD.hlw();
          continue;
          locala.RMe.setVisibility(4);
          continue;
          label2834:
          if (this.RLX != null) {
            this.RLX.hno();
          }
          locala.RJc.setVisibility(0);
          j = this.mActivity.getResources().getColor(b.c.blue_text_color);
          k = this.mActivity.getResources().getColor(b.c.BW_0_Alpha_0_2);
          i = 1;
          paramInt2 = i;
          if (localSnsInfo.getAdXml().hasVoteInfo())
          {
            m = ai.mS(localSnsInfo.getAdXml().adVoteInfo.QIe, localSnsInfo.getUxinfo());
            paramInt2 = i;
            if (m > 0)
            {
              paramInt2 = i;
              if (m <= 2)
              {
                if (m != 1) {
                  break label3074;
                }
                locala.RMd.setTextColor(k);
                locala.RMd.setText(localSnsInfo.getAdXml().adVoteInfo.alb(1));
                locala.RMc.setTextColor(j);
                locala.RMc.setText(localSnsInfo.getAdXml().adVoteInfo.ala(0));
              }
            }
          }
          for (;;)
          {
            paramInt2 = 0;
            if (paramInt2 == 0) {
              break;
            }
            locala.RMc.setTextColor(j);
            locala.RMd.setTextColor(j);
            locala.RMc.setText(localSnsInfo.getAdXml().getCardSelectLeftTitle());
            locala.RMd.setText(localSnsInfo.getAdXml().getCardSelectRightTitle());
            break;
            if (m == 2)
            {
              locala.RMc.setTextColor(k);
              locala.RMc.setText(localSnsInfo.getAdXml().adVoteInfo.alb(0));
              locala.RMd.setTextColor(j);
              locala.RMd.setText(localSnsInfo.getAdXml().adVoteInfo.ala(1));
            }
          }
          label3143:
          localdmz = null;
          continue;
          label3149:
          if (((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).PJU == null) {
            com.tencent.mm.sdk.platformtools.Log.e(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mTag, "OnlineVideoChecker: the timeline object is null");
          }
        }
        label2822:
        label3292:
        label3688:
        label3946:
        label4463:
        label4465:
        try
        {
          localViewGroup = ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mContainer;
          localTimeLineObject = ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).PJU;
          bool = ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).QcS;
          if (com.tencent.mm.plugin.sns.ad.j.l.X(localViewGroup))
          {
            if (bool)
            {
              localView = localViewGroup.getChildAt(0);
              if ((!(localView instanceof SnsTimelineVideoView)) || (Util.isEqual(((SnsTimelineVideoView)localView).Rcp, localTimeLineObject.Id))) {
                continue;
              }
              com.tencent.mm.sdk.platformtools.Log.i(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mTag, "OnlineVideoChecker: the online video container has child, but the time line id is different!!");
              com.tencent.mm.plugin.sns.ad.j.l.W(localViewGroup);
              continue;
            }
            com.tencent.mm.sdk.platformtools.Log.i(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mTag, "OnlineVideoChecker: it doesn't use online video container!!");
            com.tencent.mm.plugin.sns.ad.j.l.W(localViewGroup);
            continue;
          }
          com.tencent.mm.sdk.platformtools.Log.i(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mTag, "OnlineVideoChecker: there is no child video view in container!!");
          continue;
        }
        finally {}
        label3074:
        if ((paramBaseViewHolder.timeLineObject.ContentObj.Zpq == 5) || (paramBaseViewHolder.timeLineObject.ContentObj.Zpq == 15))
        {
          locala.Qcj.RjL.setVisibility(0);
          locala.QbZ.setVisibility(4);
          parambn.hpB().c(locala.Qcj.RjO, parambn.QBf.RQm, parambn.QBf.RPU);
          localObject2 = locala.Qcj.RjL.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = paramInt2;
          ((ViewGroup.LayoutParams)localObject2).height = i;
          locala.Qcj.RjL.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          locala.Qcj.RjM.ld(paramInt2, i);
          locala.Qcj.RjM.setOnCompletionListener(new SightPlayController.d()
          {
            public final void c(SightPlayController paramAnonymousSightPlayController, int paramAnonymousInt)
            {
              AppMethodBeat.i(308946);
              if (paramAnonymousInt != -1)
              {
                if ((parambn == null) || (parambn.Ryp == null) || (parambn.Ryp.Rbv == null))
                {
                  AppMethodBeat.o(308946);
                  return;
                }
                parambn.Ryp.Rbv.S(parambo.RBq, false);
                com.tencent.mm.sdk.platformtools.Log.d("MiroMsg.CardAdTimeLineItem", "onCompletion, snsId=" + t.uA(localSnsInfo.field_snsId));
              }
              AppMethodBeat.o(308946);
            }
          });
          locala.Qcj.RjM.setOnDecodeDurationListener(new SightPlayController.e()
          {
            public final void b(SightPlayController paramAnonymousSightPlayController, long paramAnonymousLong)
            {
              AppMethodBeat.i(308947);
              if ((parambn == null) || (parambn.Ryp == null) || (parambn.Ryp.Rbv == null))
              {
                AppMethodBeat.o(308947);
                return;
              }
              if (localSnsInfo != null)
              {
                parambn.Ryp.Rbv.ut(localSnsInfo.field_snsId);
                parambn.Ryp.Rbv.bj(localSnsInfo.field_snsId, 1000L * paramAnonymousLong);
              }
              if (!parambn.Ryp.Rbv.uq(parambo.RBq))
              {
                int i = (int)paramAnonymousSightPlayController.gYy();
                parambn.Ryp.Rbv.c(parambo.RBq, Util.currentTicks(), false);
                parambn.Ryp.Rbv.f(parambo.RBq, i, false);
                parambn.Ryp.Rbv.bi(parambo.RBq, parambo.RBq);
              }
              com.tencent.mm.sdk.platformtools.Log.d("MiroMsg.CardAdTimeLineItem", "onDecodeProgress, currentTime=" + paramAnonymousLong + ", snsId=" + t.uA(localSnsInfo.field_snsId));
              AppMethodBeat.o(308947);
            }
          });
          if (locala.QbW)
          {
            com.tencent.mm.plugin.sns.ad.d.e.a(localSnsInfo, localdmz);
            label3492:
            l = System.nanoTime();
            bool = com.tencent.mm.plugin.sns.model.g.u(localdmz);
            com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
            localObject2 = locala.Qcj;
            if (bool) {
              break label4124;
            }
            if (!((com.tencent.mm.plugin.sns.model.g)localObject3).x(localdmz)) {
              break label3946;
            }
            ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjP.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjP.jEN();
            locala.RMc.setTag(locala);
            locala.RMd.setTag(locala);
            ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjM.setTagObject(localObject2);
            ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjO.setTag(locala);
            if (!locala.QbW) {
              break label4465;
            }
            localObject2 = ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjM;
            j = this.mActivity.hashCode();
            localObject4 = br.jbh();
            ((br)localObject4).time = paramTimeLineObject.CreateTime;
            ((com.tencent.mm.plugin.sns.model.g)localObject3).a(localSnsInfo, localdmz, (VideoSightView)localObject2, -1, j, paramInt1, (br)localObject4, parambo.Rbg, true, false);
            localObject2 = as.mg(al.getAccSnsPath(), localdmz.Id);
            localObject3 = t.i(localdmz);
            localObject2 = (String)localObject2 + (String)localObject3;
            if (!com.tencent.mm.vfs.y.ZC((String)localObject2)) {
              break label4521;
            }
            parambn.Ryp.Rbv.g(parambo.RBq, (int)localdmz.aaTF, true);
            if (com.tencent.mm.plugin.sns.ad.d.e.anH())
            {
              bool = com.tencent.mm.modelvideo.y.isH265Video((String)localObject2);
              com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "AdH265Helper, fileExists, isH265File=" + bool + ", path=" + (String)localObject2);
            }
            label3807:
            if (al.hgy().b(localSnsInfo, null) != 5) {
              break label4546;
            }
          }
          label4124:
          label4521:
          label4546:
          for (bool = true;; bool = false)
          {
            parambn.Ryp.Rbv.e(parambo.RBq, bool, false);
            if (!locala.QbW) {
              break;
            }
            com.tencent.mm.sdk.platformtools.Log.d("MiroMsg.CardAdTimeLineItem", "in fillitem, the user online video is true");
            com.tencent.mm.plugin.sns.ad.j.l.z(locala.Qcq, paramInt2, i);
            localObject2 = locala.Qcq;
            localObject3 = new com.tencent.mm.plugin.sns.ad.timeline.video.online.c("MiroMsg.CardAdTimeLineItem");
            ((com.tencent.mm.plugin.sns.ad.timeline.video.online.c)localObject3).uwW = ((ViewGroup)localObject2);
            ((com.tencent.mm.plugin.sns.ad.timeline.video.online.c)localObject3).QcU = localdmz;
            ((com.tencent.mm.plugin.sns.ad.timeline.video.online.c)localObject3).QcT = paramTimeLineObject;
            ((com.tencent.mm.plugin.sns.ad.timeline.video.online.c)localObject3).yqW = paramBaseViewHolder.hES;
            ((com.tencent.mm.plugin.sns.ad.timeline.video.online.c)localObject3).CY();
            com.tencent.mm.plugin.sns.ad.j.l.C(locala.Qcj.RjP, false);
            break;
            com.tencent.mm.plugin.sns.ad.d.e.a(localdmz, false);
            break label3492;
            if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localSnsInfo, null) == 5)
            {
              ((com.tencent.mm.plugin.sns.model.g)localObject3).B(localdmz);
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjP.setVisibility(0);
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjP.jEN();
              break label3585;
            }
            if (((com.tencent.mm.plugin.sns.model.g)localObject3).y(localdmz))
            {
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjP.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setImageResource(b.i.shortvideo_play_icon_err);
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setVisibility(0);
              break label3585;
            }
            ((com.tencent.mm.plugin.sns.model.g)localObject3).z(localdmz);
            ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjP.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
            ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
            if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localSnsInfo, null) != 4) {
              break label3585;
            }
            ((com.tencent.mm.plugin.sns.ui.aw)localObject2).QRC.setVisibility(0);
            break label3585;
            if (((com.tencent.mm.plugin.sns.model.g)localObject3).v(localdmz))
            {
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setVisibility(0);
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjP.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
            }
            for (;;)
            {
              if (!((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjM.PGy.gYv()) {
                break label4463;
              }
              com.tencent.mm.sdk.platformtools.Log.e("MiroMsg.CardAdTimeLineItem", "play video error " + localdmz.Id + " " + localdmz.Url + " " + localdmz.aaTl + " " + paramInt1);
              ((com.tencent.mm.plugin.sns.model.g)localObject3).z(localdmz);
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setVisibility(0);
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjP.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
              ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
              break;
              if (((com.tencent.mm.plugin.sns.model.g)localObject3).w(localdmz))
              {
                ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setVisibility(8);
                ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjP.setVisibility(8);
              }
              else if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localSnsInfo, null) <= 5)
              {
                if (!locala.QbV)
                {
                  com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "fillItem, showPlayBtn");
                  hcb();
                }
              }
              else
              {
                ((com.tencent.mm.plugin.sns.model.g)localObject3).z(localdmz);
                ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setVisibility(0);
                ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjP.setVisibility(8);
                ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
                ((com.tencent.mm.plugin.sns.ui.aw)localObject2).PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
              }
            }
            break label3585;
            localObject2 = ((com.tencent.mm.plugin.sns.ui.aw)localObject2).RjM;
            j = this.mActivity.hashCode();
            localObject4 = br.jbh();
            ((br)localObject4).time = paramTimeLineObject.CreateTime;
            ((com.tencent.mm.plugin.sns.model.g)localObject3).a(localSnsInfo, localdmz, (VideoSightView)localObject2, j, paramInt1, (br)localObject4, parambo.Rbg, true);
            break label3688;
            parambn.Ryp.Rbv.g(parambo.RBq, (int)localdmz.aaTF, false);
            break label3807;
          }
        }
        label3585:
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(paramBaseViewHolder.Qcj.RjM, this.mActivity.hashCode(), paramInt1);
        paramBaseViewHolder.Qcj.RjQ.setVisibility(8);
        paramBaseViewHolder.Qcj.RjM.setOnSightCompletionAction(null);
        paramBaseViewHolder.Qcj.RjM.setOnCompletionListener(null);
        paramBaseViewHolder.Qcj.RjM.setOnDecodeDurationListener(null);
        continue;
        label4621:
        locala.RJm.setVisibility(8);
        continue;
        paramTimeLineObject = localSnsInfo.getAdXml().adPromotionInfo;
        if ((paramTimeLineObject == null) || (!f.bk(paramTimeLineObject.startTime, paramTimeLineObject.endTime)) || (m.jP(this.mActivity))) {
          break;
        }
        paramInt1 = 1;
        continue;
        if (this.RLV.RJn != null) {
          this.RLV.RJn.setVisibility(8);
        }
      }
    }
    if (m.jP(this.mActivity)) {
      locala.RMg.setVisibility(8);
    }
    if (!Util.isNullOrNil(localSnsInfo.getAdXml().adCard3dHeadTitle))
    {
      locala.RJj.setVisibility(0);
      locala.RMf.setVisibility(0);
      locala.RMf.setText(localSnsInfo.getAdXml().adCard3dHeadTitle);
      if (localSnsInfo.getAdXml().adMediaDisplayMode != 1) {
        break label2697;
      }
      i = paramInt2 - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 54) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(b.d.LittlePadding) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(b.d.SmallPadding);
      paramInt2 = i;
      if (com.tencent.mm.ui.aw.jkS())
      {
        paramInt2 = i;
        if (!ag.aAk(this.mActivity.getTaskId())) {
          paramInt2 = bd.bs(MMApplicationContext.getContext(), b.d.sns_timeline_item_large_screen_width);
        }
      }
      paramBaseViewHolder.RKD.setContentWidth(paramInt2);
      paramBaseViewHolder.RKD.hlw();
      locala.RJj.setTag(localSnsInfo.getAdXml().adCard3dHeadUrl);
      if (Util.isNullOrNil(localSnsInfo.getAdXml().adCard3dHeadUrl)) {
        break label2822;
      }
      k.a(localSnsInfo.getAdXml().adCard3dHeadUrl, false, new g.a()
      {
        public final void aWn(String paramAnonymousString)
        {
          AppMethodBeat.i(308968);
          com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
          if ((!Util.isNullOrNil(new String[] { (String)locala.RJj.getTag(), paramAnonymousString })) && (paramAnonymousString.equals(k.mC("adId", (String)locala.RJj.getTag()))))
          {
            paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              locala.RJj.setVisibility(0);
              locala.RMe.setImageBitmap(paramAnonymousString);
              locala.RMe.setVisibility(0);
            }
          }
          AppMethodBeat.o(308968);
        }
        
        public final void gZM() {}
        
        public final void gZN() {}
      });
      if ((localSnsInfo.getAdXml().hasSelectInfo()) || (localSnsInfo.getAdXml().hasVoteInfo()))
      {
        if (!localSnsInfo.getAdXml().isNewStyleVote()) {
          break label2834;
        }
        if (this.RLX == null)
        {
          localObject1 = (ViewStub)locala.pzi.findViewById(b.f.sns_ad_card_vote_layout_stub);
          if (localObject1 != null)
          {
            localObject1 = com.tencent.mm.plugin.sns.ad.j.l.c((ViewStub)localObject1);
            com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "inflate new style vote button");
            if (localObject1 != null)
            {
              this.RLX = new ba(this.mActivity, locala.pzi, parambn.QBf);
              com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "initialize SnsAdCardVoteCtrl");
            }
          }
        }
        if (this.RLX != null)
        {
          this.RLX.hnn();
          this.RLX.a(localSnsInfo, locala);
        }
        locala.RJc.setVisibility(8);
        if (locala.RMl != null) {
          locala.RMl.setVisibility(8);
        }
        if (locala.RMk != null) {
          locala.RMk.setVisibility(8);
        }
      }
      locala.QbZ.setScaleType(QImageView.a.afVc);
      locala.Qcj.RjM.PGE = true;
      locala.Qcj.RjM.setScaleType(QImageView.a.afVc);
      if ((paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.Zpr.size() <= 0)) {
        break label3143;
      }
      localObject1 = (dmz)paramTimeLineObject.ContentObj.Zpr.get(0);
      localObject3 = al.hgy();
      if ((paramBaseViewHolder.Qcj.RjK != null) && (!Util.isEqual(paramBaseViewHolder.Qcj.RjK.Id, paramTimeLineObject.Id)))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.Qcj.RjK.Id });
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(paramBaseViewHolder.Qcj.RjM, this.mActivity.hashCode(), paramInt1);
      }
      paramBaseViewHolder.Qcj.a(paramTimeLineObject, paramInt1, parambo.Rdg, parambo.Rbg);
      paramBaseViewHolder.Qcj.QRC.setVisibility(8);
      localObject4 = new com.tencent.mm.plugin.sns.ad.timeline.video.online.b("MiroMsg.CardAdTimeLineItem");
      ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mContainer = locala.Qcq;
      ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).PJU = paramTimeLineObject;
      ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).QcS = locala.QbW;
      if (((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mContainer != null) {
        break label3149;
      }
      com.tencent.mm.sdk.platformtools.Log.e(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject4).mTag, "OnlineVideoChecker: the container is null");
      if (localObject1 != null)
      {
        paramInt2 = ((LinearLayout.LayoutParams)localObject2).width - this.mActivity.getResources().getDimensionPixelSize(b.d.SmallPadding) - this.mActivity.getResources().getDimensionPixelSize(b.d.SmallPadding);
        i = (int)(paramInt2 * ((dmz)localObject1).aaTn.aaUc / ((dmz)localObject1).aaTn.aaUb);
        if (paramBaseViewHolder.timeLineObject.ContentObj.Zpq != 1) {
          break label3292;
        }
        locala.QbZ.setVisibility(0);
        locala.Qcj.RjL.setVisibility(4);
        localObject2 = locala.QbZ.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject2).height = i;
        locala.QbZ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = al.hgy();
        localObject3 = locala.QbZ;
        paramInt1 = this.mActivity.hashCode();
        localObject4 = br.jbh();
        ((br)localObject4).time = paramTimeLineObject.CreateTime;
        ((com.tencent.mm.plugin.sns.model.g)localObject2).b((dmz)localObject1, (View)localObject3, -1, paramInt1, (br)localObject4);
        locala.QbZ.setTag(locala);
        locala.RMc.setTag(locala);
        locala.RMd.setTag(locala);
        locala.QbZ.setOnClickListener(parambn.QBf.Rea);
        parambn.hpB().c(locala.QbZ, parambn.QBf.RQm, parambn.QBf.RPU);
        locala.QbV = false;
      }
      if (!localSnsInfo.getAdXml().hasActionBtn()) {
        break label4621;
      }
      if (locala.RMl != null) {
        locala.RMl.setVisibility(8);
      }
      if (locala.RMk != null) {
        locala.RMk.setVisibility(8);
      }
      locala.RJm.setVisibility(0);
      if (this.RLW == null) {
        this.RLW = new ay(this.mActivity, locala.pzi, 0, parambn.Ryp.Rbv, this.PYj);
      }
      this.RLW.Y(localSnsInfo);
      if (localSnsInfo == null) {
        break label5287;
      }
    }
    for (;;)
    {
      try
      {
        if (localSnsInfo.getAdXml() != null) {
          continue;
        }
      }
      finally
      {
        continue;
        paramInt1 = 1;
        continue;
        if (this.QbR != null) {
          continue;
        }
        this.QbR = new com.tencent.mm.plugin.sns.ad.widget.living.c(this.RLV.Qcn, this.RLV.RJr, this.RLW);
        if ((paramTimeLineObject == null) || (this.QbR == null)) {
          continue;
        }
        parambn = localSnsInfo.getAdXml().adLiveInfo;
        paramInt1 = com.tencent.mm.plugin.sns.ad.widget.living.b.gQ(paramTimeLineObject.Id, parambn.liveType);
        this.QbR.a(paramTimeLineObject.Id, parambn);
        this.QbR.setLiveStatus(paramInt1);
        com.tencent.mm.plugin.sns.ad.widget.living.b.a(paramTimeLineObject.Id, this.QbR);
        com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.hbB().d(0, localSnsInfo);
        bool = com.tencent.mm.plugin.sns.ad.widget.living.c.ajZ(paramInt1);
        paramTimeLineObject = paramTimeLineObject.Id;
        if (!FinderLivingAnimWrapper.a(parambn, bool)) {
          break label5065;
        }
        if (this.RLV.Qcp != null) {
          continue;
        }
        this.RLV.Qcp = ((FinderLivingAnimWrapper)this.RLV.Qco.inflate());
        com.tencent.mm.sdk.platformtools.Log.d("MiroMsg.CardAdTimeLineItem", "checkShowLivingAnim, snsId=".concat(String.valueOf(paramTimeLineObject)));
        if (this.RLV.Qcp == null) {
          continue;
        }
        paramInt1 = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 60);
        paramInt2 = this.RLV.pzi.getHeight();
        i = this.RLV.xFi.getHeight();
        if ((paramInt2 <= 0) || (i <= 0)) {
          break label5054;
        }
        j = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8);
        this.RLV.Qcp.a(parambn, paramTimeLineObject, paramInt1, paramInt2 - i + j);
        this.RLV.Qcp.setVisibility(0);
        if (!m.jP(this.mActivity)) {
          continue;
        }
        this.RLV.RJr.setVisibility(8);
        continue;
      }
      if (paramInt1 != 0)
      {
        paramTimeLineObject = localSnsInfo.getAdXml().adPromotionInfo;
        if (this.RLV.RJn == null)
        {
          parambn = (ViewStub)this.RLV.pzi.findViewById(b.f.ad_promotion_bar_stub);
          if (parambn != null)
          {
            this.RLV.RJn = ((PromotionBarLayout)com.tencent.mm.plugin.sns.ad.j.l.c(parambn));
            com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "inflate the promotionBar");
          }
        }
        if (this.RLV.RJn != null)
        {
          this.RLV.RJn.setVisibility(0);
          this.RLV.RJn.setPromotionalPrice(paramTimeLineObject.PMU);
          this.RLV.RJn.setRightTitle(paramTimeLineObject.PMV);
          com.tencent.mm.plugin.sns.ad.j.l.i(this.RLV.RJn, com.tencent.mm.plugin.sns.ad.j.e.lP(paramTimeLineObject.PMS, paramTimeLineObject.qWk));
          this.RLV.RJn.b(new com.tencent.mm.plugin.sns.ad.widget.countdown.b(paramTimeLineObject.startTime, paramTimeLineObject.endTime));
        }
        if (localSnsInfo == null) {}
      }
      else
      {
        try
        {
          if (localSnsInfo.getAdXml() == null) {
            break label5292;
          }
          if (localSnsInfo.getAdXml().adLiveInfo != null) {
            continue;
          }
        }
        finally
        {
          com.tencent.mm.sdk.platformtools.Log.e("MiroMsg.CardAdTimeLineItem", "fillLivingViewInfo, exp=" + android.util.Log.getStackTraceString(paramTimeLineObject));
          continue;
          label5054:
          com.tencent.mm.sdk.platformtools.Log.w("MiroMsg.CardAdTimeLineItem", "checkShowLivingAnim, contentH==0");
          continue;
          label5065:
          if (this.RLV.Qcp == null) {
            continue;
          }
          this.RLV.Qcp.setVisibility(8);
          continue;
          if (this.RLV.Qcn == null) {
            break label5112;
          }
          this.RLV.Qcn.setVisibility(8);
          label5112:
          if (this.RLV.RJr == null) {
            break label5134;
          }
          this.RLV.RJr.setVisibility(8);
          label5134:
          if (this.RLV.Qcp == null) {
            continue;
          }
          this.RLV.Qcp.setVisibility(8);
          continue;
          label5159:
          paramInt1 = 0;
          continue;
          label5164:
          if (this.RJu != null) {
            break label5189;
          }
          this.RJu = new com.tencent.mm.plugin.sns.ad.timeline.helper.g(this.RLV.RJt);
          label5189:
          this.RJu.Qaw = paramTimeLineObject;
          this.RJu.hbU();
          this.RJu.hbR();
          this.RJu.hbS();
          if (!m.jP(this.mActivity)) {
            continue;
          }
          this.RLV.RJt.setVisibility(8);
          continue;
        }
        if (paramInt1 != 0)
        {
          paramTimeLineObject = localSnsInfo.getTimeLine();
          if (this.RLV.Qcn == null)
          {
            parambn = (ViewStub)this.RLV.pzi.findViewById(b.f.ad_live_status_layout_stub);
            if (parambn != null)
            {
              this.RLV.Qcn = ((ViewGroup)com.tencent.mm.plugin.sns.ad.j.l.c(parambn));
              com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "inflate the living status");
            }
          }
          if (this.RLV.RJr == null)
          {
            parambn = (ViewStub)this.RLV.pzi.findViewById(b.f.ad_live_desc_layout_stub);
            if (parambn != null)
            {
              this.RLV.RJr = ((LivingDescBarLayout)com.tencent.mm.plugin.sns.ad.j.l.c(parambn));
              com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "inflate the living des bar");
            }
          }
          if ((this.RLV.Qcn == null) || (this.RLV.RJr == null))
          {
            com.tencent.mm.sdk.platformtools.Log.e("MiroMsg.CardAdTimeLineItem", "the livingStatusLayout or livingDescBar is null!!");
            if (localSnsInfo == null) {
              break label5159;
            }
          }
        }
        try
        {
          if ((localSnsInfo.getAdXml() == null) || (localSnsInfo.getAdXml().adRollInfo == null)) {
            break label5159;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label5259;
          }
          paramTimeLineObject = localSnsInfo.getAdXml().adRollInfo;
          if (this.RLV.RJt == null)
          {
            parambn = (ViewStub)this.RLV.pzi.findViewById(b.f.ad_roll_layout_stub);
            if (parambn != null)
            {
              this.RLV.RJt = ((LivingDescBarLayout)com.tencent.mm.plugin.sns.ad.j.l.c(parambn));
              com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "inflate the rollTextBar");
            }
          }
          if ((this.RLV.RJt != null) && (paramTimeLineObject != null)) {
            break label5164;
          }
          com.tencent.mm.sdk.platformtools.Log.e("MiroMsg.CardAdTimeLineItem", "the rollingBar or adRollInfo is null!!");
        }
        finally
        {
          int j;
          int k;
          int m;
          dmz localdmz;
          ViewGroup localViewGroup;
          TimeLineObject localTimeLineObject;
          boolean bool;
          View localView;
          long l;
          com.tencent.mm.sdk.platformtools.Log.e("MiroMsg.CardAdTimeLineItem", paramTimeLineObject.toString());
          continue;
          if (this.RLV.RJt == null) {
            continue;
          }
          this.RLV.RJt.setVisibility(8);
          continue;
        }
        paramBaseViewHolder.mtE = false;
        a(parambo, 3);
        AppMethodBeat.o(100065);
        return;
        localObject1 = paramTimeLineObject.Id;
        break;
        locala.RMk.setVisibility(8);
        break label494;
        if (!n.a(localSnsInfo.getAdXml(), (ADInfo)localObject1)) {
          break label605;
        }
        locala.RMh.setVisibility(0);
        locala.RMi.setText(b.j.finder_app_name);
        break label605;
        locala.RMj.setImageResource(b.i.album_ad_link_tag_weapp_dark);
        break label653;
        if (n.a(this.PJQ.getAdXml(), this.PJQ.getAdInfo()))
        {
          locala.RMj.setImageResource(b.i.album_ad_finder_link_icon);
          break label653;
        }
        locala.RMj.setImageResource(b.i.album_ad_link_tag_weapp);
        break label653;
        localObject1 = localSnsInfo.getAdXml().adCardDesc;
        break label674;
        locala.RMl.setVisibility(8);
        break label727;
        localObject1 = u.iVt().a(locala.RMk.getContext(), (CharSequence)localObject1, locala.RMk.getTextSize());
        locala.RMk.setText((CharSequence)localObject1);
        locala.RMk.setVisibility(0);
        break label755;
        if (localSnsInfo.getAdXml().adCardTagInfo.QHu.size() <= 0) {
          break label885;
        }
        locala.RMg.setVisibility(0);
        com.tencent.mm.sdk.platformtools.Log.d("MiroMsg.CardAdTimeLineItem", "adCardTagList not refreshed");
        break label885;
        label5259:
        label5284:
        break label375;
        label5287:
        paramInt1 = 0;
        continue;
      }
      label5292:
      paramInt1 = 0;
      continue;
      break label1567;
      paramInt1 = 0;
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100064);
    this.RLV = ((a)paramBaseViewHolder);
    if (paramBaseViewHolder.RKG != null)
    {
      paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_ad_card_layout_item);
      if (!paramBaseViewHolder.RKH)
      {
        this.RLV.pzi = ((ViewGroup)paramBaseViewHolder.RKG.inflate());
        paramBaseViewHolder.RKH = true;
      }
    }
    for (;;)
    {
      this.RLV.xFi = ((ViewGroup)this.RLV.pzi.findViewById(b.f.media_container));
      if ((this.RLV.xFi instanceof RoundedCornerFrameLayout)) {
        ((RoundedCornerFrameLayout)this.RLV.xFi).setRadius(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 4));
      }
      this.RLV.RMb = ((ViewGroup)this.RLV.pzi.findViewById(b.f.other_container));
      this.RLV.QbZ = ((MaskImageView)this.RLV.pzi.findViewById(b.f.sns_card_ad_image));
      this.RLV.QbZ.setOnClickListener(this.QBJ.QBf.Rea);
      this.QBJ.hpB().c(this.RLV.QbZ, this.QBJ.QBf.RQi, this.QBJ.QBf.RPU);
      this.RLV.RMl = ((TextView)this.RLV.pzi.findViewById(b.f.desc_collapse_pic_style_tv));
      this.RLV.RMl.setClickable(false);
      this.RLV.RMl.setLongClickable(false);
      this.RLV.RMk = ((TextView)this.RLV.pzi.findViewById(b.f.desc_collapse_pic_style_title_tv));
      this.RLV.RMk.setClickable(false);
      this.RLV.RMk.setLongClickable(false);
      this.RLV.Qcj = new com.tencent.mm.plugin.sns.ui.aw();
      this.RLV.Qcj.RjO = this.RLV.pzi.findViewById(b.f.sns_card_ad_sight);
      this.RLV.Qcj.RjL = this.RLV.Qcj.RjO;
      this.RLV.Qcj.RjO.setOnClickListener(this.QBJ.QBf.RQt);
      this.RLV.Qcj.RjM = ((VideoSightView)this.RLV.Qcj.RjO.findViewById(b.f.image));
      this.RLV.Qcj.RjM.setMute(true);
      this.RLV.Qcj.PQu = ((ImageView)this.RLV.Qcj.RjO.findViewById(b.f.status_btn));
      this.RLV.Qcj.RjP = ((MMPinProgressBtn)this.RLV.Qcj.RjO.findViewById(b.f.progress));
      this.RLV.Qcj.RjQ = ((TextView)this.RLV.Qcj.RjO.findViewById(b.f.endtv));
      this.RLV.Qcj.QRC = ((TextView)this.RLV.Qcj.RjO.findViewById(b.f.errorTv));
      this.RLV.RJj = this.RLV.pzi.findViewById(b.f.sns_ad_card_header_container);
      this.RLV.RMe = ((ImageView)this.RLV.pzi.findViewById(b.f.sns_ad_card_header_avatar));
      this.RLV.RMf = ((TextView)this.RLV.pzi.findViewById(b.f.sns_ad_card_header_title));
      this.RLV.RMh = this.RLV.pzi.findViewById(b.f.card_weapp_tag);
      this.RLV.RJg = ((ImageView)this.RLV.pzi.findViewById(b.f.weapp_auth_icon_iv));
      this.RLV.RMj = ((ImageView)this.RLV.pzi.findViewById(b.f.weapp_icon_iv));
      this.RLV.RMi = ((TextView)this.RLV.pzi.findViewById(b.f.weapp_tag_name));
      this.RLV.RJc = this.RLV.pzi.findViewById(b.f.card_btn_container);
      this.RLV.RMc = ((Button)this.RLV.pzi.findViewById(b.f.card_btn_left));
      this.RLV.RMd = ((Button)this.RLV.pzi.findViewById(b.f.card_btn_right));
      this.RLV.RMc.setOnClickListener(this.QBJ.QBf.RQE);
      this.RLV.RMd.setOnClickListener(this.QBJ.QBf.RQF);
      this.RLV.RMg = ((SnsCardAdTagListView)this.RLV.pzi.findViewById(b.f.card_ad_tag_list));
      this.RLV.RMg.setActivityContext(this.mActivity);
      this.RLV.Qcq = ((ViewGroup)this.RLV.pzi.findViewById(b.f.sns_card_ad_online_video_container));
      this.RLV.RJm = this.RLV.pzi.findViewById(b.f.action_btn_container);
      this.RLV.Qco = ((ViewStub)this.RLV.pzi.findViewById(b.f.ad_live_anim_layout_stub));
      com.tencent.mm.sdk.platformtools.Log.d("MiroMsg.CardAdTimeLineItem", "the card ad build layout is end");
      AppMethodBeat.o(100064);
      return;
      if (!paramBaseViewHolder.RKH)
      {
        this.RLV.pzi = ((ViewGroup)paramBaseViewHolder.convertView.findViewById(b.f.ad_card_container));
        paramBaseViewHolder.RKH = true;
      }
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(176416);
    if ((this.RLV != null) && (this.RLV.xFi != null))
    {
      Object localObject = new int[2];
      this.RLV.xFi.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.RLV.xFi.getMeasuredWidth() + i, this.RLV.xFi.getMeasuredHeight() + j);
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
    hqV();
    AppMethodBeat.o(177692);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176413);
    com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "pause");
    if (hqV()) {
      hcb();
    }
    AppMethodBeat.o(176413);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176414);
    com.tencent.mm.sdk.platformtools.Log.i("MiroMsg.CardAdTimeLineItem", "%s cardAd stop", new Object[] { this });
    if ((this.RLV != null) && (this.RLV.Qcj != null)) {
      this.RLV.Qcj.RjM.PGy.clear();
    }
    this.RLY = false;
    AppMethodBeat.o(176414);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public boolean QbV;
    public boolean QbW;
    public MaskImageView QbZ;
    public ViewGroup Qcn;
    public ViewStub Qco;
    public FinderLivingAnimWrapper Qcp;
    public ViewGroup Qcq;
    public View RJc;
    public ImageView RJg;
    public View RJj;
    public View RJm;
    public PromotionBarLayout RJn;
    public LivingDescBarLayout RJr;
    public LivingDescBarLayout RJt;
    public ViewGroup RMb;
    public Button RMc;
    public Button RMd;
    public ImageView RMe;
    public TextView RMf;
    public SnsCardAdTagListView RMg;
    public View RMh;
    public TextView RMi;
    public ImageView RMj;
    public TextView RMk;
    public TextView RMl;
    public ViewGroup pzi;
    public ViewGroup xFi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a
 * JD-Core Version:    0.7.0.1
 */