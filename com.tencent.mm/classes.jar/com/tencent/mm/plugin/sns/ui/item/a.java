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
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.i.e;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ad.widget.countdown.PromotionBarLayout;
import com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
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
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.av.b;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private SnsInfo DqO;
  private String Dzk = "";
  private a EXR;
  private av EXS;
  private ax EXT;
  private com.tencent.mm.plugin.sns.ad.widget.living.c EXU;
  private boolean EXV = false;
  
  private void ab(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(203916);
    if ((this.DQX != null) && (this.DQX.EKl != null) && (this.DQX.EKl.EoE != null) && (paramSnsInfo != null)) {
      this.DQX.EKl.EoE.IU(paramSnsInfo.field_snsId);
    }
    AppMethodBeat.o(203916);
  }
  
  private boolean fkp()
  {
    AppMethodBeat.i(177693);
    if ((this.EXR.timeLineObject.ContentObj.LoU == 5) || (this.EXR.timeLineObject.ContentObj.LoU == 15))
    {
      Log.i("MiroMsg.CardAdTimeLineItem", "%s cardAd doPause", new Object[] { this });
      if ((this.EXR != null) && (this.EXR.EUK != null))
      {
        this.EXR.EUK.Ews.pause();
        ab(this.DqO);
      }
      this.EXV = false;
      AppMethodBeat.o(177693);
      return true;
    }
    AppMethodBeat.o(177693);
    return false;
  }
  
  private void fkq()
  {
    AppMethodBeat.i(176415);
    Log.i("MiroMsg.CardAdTimeLineItem", "try show play btn");
    if ((this.EXR != null) && (this.EXR.EUK != null) && (!this.EXV))
    {
      Log.i("MiroMsg.CardAdTimeLineItem", "show play btn");
      this.EXR.EUK.EeS.setVisibility(0);
      this.EXR.EUK.Ewv.setVisibility(8);
      this.EXR.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
      this.EXR.EUK.EeS.setContentDescription(this.mActivity.getString(2131763945));
    }
    AppMethodBeat.o(176415);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176412);
    if ((paramBaseViewHolder.timeLineObject.ContentObj.LoU == 5) || (paramBaseViewHolder.timeLineObject.ContentObj.LoU == 15))
    {
      Log.i("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", new Object[] { this, Integer.valueOf(paramInt) });
      if (!(paramBaseViewHolder instanceof a)) {
        break label389;
      }
    }
    label389:
    for (boolean bool = ((a)paramBaseViewHolder).EYk;; bool = false)
    {
      Log.i("MiroMsg.CardAdTimeLineItem", "In the card ad item, the useOnlineVideo is ".concat(String.valueOf(bool)));
      if (!bool)
      {
        com.tencent.mm.plugin.sns.ui.video.d.fkS().cXa();
        com.tencent.mm.plugin.sns.ui.video.b.fkM().a(this);
        paramBaseViewHolder.EUK.Ews.start();
      }
      for (;;)
      {
        Log.i("MiroMsg.CardAdTimeLineItem", "try hide play btn");
        if ((this.EXR != null) && (this.EXR.EUK != null))
        {
          Log.i("MiroMsg.CardAdTimeLineItem", "hide play btn");
          this.EXR.EUK.EeS.setVisibility(8);
          this.EXR.EUK.Ewv.setVisibility(8);
        }
        this.EXV = true;
        if ((paramBaseViewHolder instanceof a)) {
          ((a)paramBaseViewHolder).EYi = false;
        }
        AppMethodBeat.o(176412);
        return;
        com.tencent.mm.plugin.sns.ui.video.b.fkM().pause();
        Log.w("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", new Object[] { this, Integer.valueOf(paramInt) });
        SnsInfo localSnsInfo = this.DqO;
        cnb localcnb = com.tencent.mm.plugin.sns.ad.timeline.b.g.a(paramBaseViewHolder);
        String str1 = com.tencent.mm.plugin.sns.ad.timeline.b.g.c(paramBaseViewHolder);
        k localk = com.tencent.mm.plugin.sns.ad.timeline.b.g.a(this.DQX);
        ViewGroup localViewGroup = ((a)paramBaseViewHolder).EYj;
        String str2 = paramBaseViewHolder.dHp;
        if ((localSnsInfo != null) && (localcnb != null) && (localViewGroup != null))
        {
          Log.w("MiroMsg.CardAdTimeLineItem", "the sns info is " + localSnsInfo + " the media is " + localcnb);
          com.tencent.mm.plugin.sns.ad.timeline.video.online.d locald = new com.tencent.mm.plugin.sns.ad.timeline.video.online.d("MiroMsg.CardAdTimeLineItem");
          locald.mContainer = localViewGroup;
          locald.DzV = localcnb;
          locald.DqO = localSnsInfo;
          locald.rzs = str2;
          locald.Dzk = str1;
          locald.DzW = localk;
          locald.a(3, new SnsTimelineVideoView.b()
          {
            public final void Zl(String paramAnonymousString)
            {
              AppMethodBeat.i(203915);
              Log.w("MiroMsg.CardAdTimeLineItem", "timelineVideoView setUICallback onDestroy, the tlId is " + paramAnonymousString + ", the timelineId is " + a.a(a.this));
              if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(a.a(a.this))))
              {
                a.b(a.this);
                a.c(a.this);
              }
              AppMethodBeat.o(203915);
            }
          });
        }
      }
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, final bk parambk)
  {
    AppMethodBeat.i(100065);
    if (paramBaseViewHolder.hho)
    {
      Log.i("MiroMsg.CardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(100065);
      return;
    }
    Log.i("MiroMsg.CardAdTimeLineItem", "ad fillItem, cardAd, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
    paramBaseViewHolder.hho = true;
    Object localObject1;
    if (paramTimeLineObject.Id == null) {
      localObject1 = "";
    }
    for (;;)
    {
      this.Dzk = ((String)localObject1);
      locala = (a)paramBaseViewHolder;
      localSnsInfo = parambk.Zv(paramInt1);
      this.DqO = localSnsInfo;
      locala.EYe.setVisibility(8);
      locala.EUN.setVisibility(8);
      locala.EYd.setVisibility(8);
      locala.EUU.setVisibility(8);
      locala.EUU.setTag("");
      this.EXT.fgR();
      if (paramBaseViewHolder.EWA != null) {
        paramBaseViewHolder.EWA.setVisibility(8);
      }
      localObject1 = (WindowManager)this.mActivity.getSystemService("window");
      paramInt2 = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
      ((a)paramBaseViewHolder).EWC.setOnClickListener(parambk.DQs.Fbd);
      localObject3 = new LinearLayout.LayoutParams(paramInt2 - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(2131165508) - this.mActivity.getResources().getDimensionPixelSize(2131165534), -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = this.mActivity.getResources().getDimensionPixelSize(2131165518);
      ((LinearLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2);
      ((a)paramBaseViewHolder).jLx.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      parambk.fiV().c(paramBaseViewHolder.EWC, parambk.DQs.FaJ, parambk.DQs.Far);
      if (locala.EYh != null) {
        locala.EYh.setVisibility(0);
      }
      if (locala.EYg != null)
      {
        if (!Util.isNullOrNil(localSnsInfo.getAdXml().adCardTitle)) {
          locala.EYg.setVisibility(0);
        }
      }
      else {
        label421:
        localObject1 = localSnsInfo.getAdXml();
      }
      try
      {
        if ((com.tencent.mm.plugin.sns.ad.timeline.b.a.c(paramTimeLineObject)) && (com.tencent.mm.plugin.sns.ad.timeline.b.a.a((ADXml)localObject1)) && (com.tencent.mm.plugin.sns.ad.timeline.b.a.eXU())) {}
        for (locala.EYk = true;; locala.EYk = false)
        {
          locala.EUR.setTag("");
          if (locala.EUR.getVisibility() == 0) {
            locala.EUR.setVisibility(4);
          }
          localObject1 = localSnsInfo.getAdInfo();
          if ((localObject1 != null) && (((ADInfo)localObject1).isWeapp()) && (!localSnsInfo.isTurnCardAd()))
          {
            locala.EYe.setVisibility(0);
            com.tencent.mm.plugin.sns.ad.e.d.f(((ADInfo)localObject1).actionExtWeApp.appUserName, locala.EUR);
          }
          if (!Util.isNullOrNil(localSnsInfo.getAdXml().adCardDesc)) {
            break label1905;
          }
          localObject1 = paramTimeLineObject.ContentDesc;
          if (Util.isNullOrNil((String)localObject1)) {
            break label1918;
          }
          localObject1 = com.tencent.mm.ce.g.gxZ().a(locala.EYh.getContext(), (CharSequence)localObject1, locala.EYh.getTextSize());
          locala.EYh.setText((CharSequence)localObject1);
          locala.EYh.setVisibility(0);
          localObject1 = localSnsInfo.getAdXml().adCardTitle;
          if (!Util.isNullOrNil((String)localObject1)) {
            break label1931;
          }
          locala.EYg.setVisibility(8);
          try
          {
            localObject1 = localSnsInfo.getSnsId();
            if (com.tencent.mm.plugin.sns.ui.widget.b.kS(locala.EYd.getOriginSnsId(), (String)localObject1)) {
              break label1979;
            }
            locala.EYd.removeAllViews();
            if (localSnsInfo.getAdXml().adCardTagInfo.DWm.size() > 0)
            {
              locala.EYd.setVisibility(0);
              locala.EYd.setTagSpace(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8));
              locala.EYd.ho(localSnsInfo.getAdXml().adCardTagInfo.DWm);
            }
            locala.EYd.setOriginSnsId((String)localObject1);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              int i;
              int j;
              int k;
              int m;
              int n;
              Object localObject4;
              Object localObject5;
              Log.e("MiroMsg.CardAdTimeLineItem", localException.toString());
              continue;
              locala.EYc.setVisibility(4);
              continue;
              if (localSnsInfo.getAdXml().adMediaDisplayMode == 2)
              {
                i = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54);
                j = this.mActivity.getResources().getDimensionPixelSize(2131165508);
                k = this.mActivity.getResources().getDimensionPixelSize(2131165534);
                m = this.mActivity.getResources().getDimensionPixelSize(2131165586);
                paramBaseViewHolder.EWA.setContentWidth(paramInt2 - i - j - k - m);
                paramBaseViewHolder.EWA.ffl();
                continue;
                locala.EYb.setVisibility(4);
                continue;
                this.EXT.fgR();
                locala.EUN.setVisibility(0);
                j = this.mActivity.getResources().getColor(2131100053);
                k = this.mActivity.getResources().getColor(2131099660);
                i = 1;
                paramInt2 = i;
                if (localSnsInfo.getAdXml().hasVoteInfo())
                {
                  m = y.kN(localSnsInfo.getAdXml().adVoteInfo.DWX, localSnsInfo.getUxinfo());
                  paramInt2 = i;
                  if (m > 0)
                  {
                    paramInt2 = i;
                    if (m <= 2)
                    {
                      if (m != 1) {
                        break label2381;
                      }
                      locala.EYa.setTextColor(k);
                      locala.EYa.setText(localSnsInfo.getAdXml().adVoteInfo.YS(1));
                      locala.EXZ.setTextColor(j);
                      locala.EXZ.setText(localSnsInfo.getAdXml().adVoteInfo.YR(0));
                    }
                  }
                }
                for (;;)
                {
                  paramInt2 = 0;
                  if (paramInt2 == 0) {
                    break;
                  }
                  locala.EXZ.setTextColor(j);
                  locala.EYa.setTextColor(j);
                  locala.EXZ.setText(localSnsInfo.getAdXml().getCardSelectLeftTitle());
                  locala.EYa.setText(localSnsInfo.getAdXml().getCardSelectRightTitle());
                  break;
                  if (m == 2)
                  {
                    locala.EXZ.setTextColor(k);
                    locala.EXZ.setText(localSnsInfo.getAdXml().adVoteInfo.YS(0));
                    locala.EYa.setTextColor(j);
                    locala.EYa.setText(localSnsInfo.getAdXml().adVoteInfo.YR(1));
                  }
                }
                localcnb = null;
                continue;
                if (((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject5).DqS == null)
                {
                  Log.e(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject5).mTag, "OnlineVideoChecker: the timeline object is null");
                }
                else
                {
                  try
                  {
                    localViewGroup = ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject5).mContainer;
                    localTimeLineObject = ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject5).DqS;
                    bool = ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject5).DzT;
                    if (m.G(localViewGroup))
                    {
                      if (bool)
                      {
                        localView = localViewGroup.getChildAt(0);
                        if ((!(localView instanceof SnsTimelineVideoView)) || (Util.isEqual(((SnsTimelineVideoView)localView).FcZ, localTimeLineObject.Id))) {
                          continue;
                        }
                        Log.i(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject5).mTag, "OnlineVideoChecker: the online video container has child, but the time line id is different!!");
                        m.F(localViewGroup);
                        continue;
                      }
                      Log.i(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject5).mTag, "OnlineVideoChecker: it doesn't use online video container!!");
                      m.F(localViewGroup);
                      continue;
                    }
                    Log.i(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject5).mTag, "OnlineVideoChecker: there is no child video view in container!!");
                  }
                  catch (Throwable localThrowable2) {}
                  if ((paramBaseViewHolder.timeLineObject.ContentObj.LoU == 5) || (paramBaseViewHolder.timeLineObject.ContentObj.LoU == 15))
                  {
                    locala.EUK.Ewr.setVisibility(0);
                    locala.EVm.setVisibility(4);
                    parambk.fiV().c(locala.EUK.Ewu, parambk.DQs.FaJ, parambk.DQs.Far);
                    localObject3 = locala.EUK.Ewr.getLayoutParams();
                    ((ViewGroup.LayoutParams)localObject3).width = paramInt2;
                    ((ViewGroup.LayoutParams)localObject3).height = i;
                    locala.EUK.Ewr.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                    locala.EUK.Ews.im(paramInt2, i);
                    locala.EUK.Ews.setOnCompletionListener(new b.e()
                    {
                      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(100062);
                        if (paramAnonymousInt != -1)
                        {
                          if ((parambk == null) || (parambk.EKl == null) || (parambk.EKl.EoE == null))
                          {
                            AppMethodBeat.o(100062);
                            return;
                          }
                          parambk.EKl.EoE.I(parambl.ENp, false);
                          Log.d("MiroMsg.CardAdTimeLineItem", "onCompletion, snsId=" + com.tencent.mm.plugin.sns.data.r.Jb(localSnsInfo.field_snsId));
                        }
                        AppMethodBeat.o(100062);
                      }
                    });
                    locala.EUK.Ews.setOnDecodeDurationListener(new b.f()
                    {
                      public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                      {
                        AppMethodBeat.i(100063);
                        if ((parambk == null) || (parambk.EKl == null) || (parambk.EKl.EoE == null))
                        {
                          AppMethodBeat.o(100063);
                          return;
                        }
                        if (localSnsInfo != null)
                        {
                          parambk.EKl.EoE.IT(localSnsInfo.field_snsId);
                          parambk.EKl.EoE.ao(localSnsInfo.field_snsId, 1000L * paramAnonymousLong);
                        }
                        if (!parambk.EKl.EoE.IQ(parambl.ENp))
                        {
                          int i = (int)paramAnonymousb.eVC();
                          parambk.EKl.EoE.c(parambl.ENp, Util.currentTicks(), false);
                          parambk.EKl.EoE.e(parambl.ENp, i, false);
                          parambk.EKl.EoE.an(parambl.ENp, parambl.ENp);
                        }
                        Log.d("MiroMsg.CardAdTimeLineItem", "onDecodeProgress, currentTime=" + paramAnonymousLong + ", snsId=" + com.tencent.mm.plugin.sns.data.r.Jb(localSnsInfo.field_snsId));
                        AppMethodBeat.o(100063);
                      }
                    });
                    if (locala.EYk)
                    {
                      com.tencent.mm.plugin.sns.ad.e.b.a(localSnsInfo, localcnb);
                      l = System.nanoTime();
                      bool = com.tencent.mm.plugin.sns.model.g.u(localcnb);
                      Log.i("MiroMsg.CardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
                      localObject3 = locala.EUK;
                      if (bool) {
                        break label3427;
                      }
                      if (!((com.tencent.mm.plugin.sns.model.g)localObject4).x(localcnb)) {
                        break label3251;
                      }
                      ((at)localObject3).EeS.setVisibility(8);
                      ((at)localObject3).Ewv.setVisibility(0);
                      ((at)localObject3).Ewv.gYN();
                      locala.EXZ.setTag(locala);
                      locala.EYa.setTag(locala);
                      ((at)localObject3).Ews.setTagObject(localObject3);
                      ((at)localObject3).Ewu.setTag(locala);
                      if (!locala.EYk) {
                        break label3762;
                      }
                      localObject3 = ((at)localObject3).Ews;
                      j = this.mActivity.hashCode();
                      localObject5 = bp.gCU();
                      ((bp)localObject5).hXs = paramTimeLineObject.CreateTime;
                      ((com.tencent.mm.plugin.sns.model.g)localObject4).a(localSnsInfo, localcnb, (VideoSightView)localObject3, -1, j, paramInt1, (bp)localObject5, parambl.Eoq, true, false);
                      localObject3 = ar.ki(aj.getAccSnsPath(), localcnb.Id);
                      localObject4 = com.tencent.mm.plugin.sns.data.r.j(localcnb);
                      localObject3 = (String)localObject3 + (String)localObject4;
                      if (!s.YS((String)localObject3)) {
                        break label3818;
                      }
                      parambk.EKl.EoE.f(parambl.ENp, (int)localcnb.MsT, true);
                      if (com.tencent.mm.plugin.sns.ad.e.b.KB())
                      {
                        bool = com.tencent.mm.modelvideo.r.isH265Video((String)localObject3);
                        Log.i("MiroMsg.CardAdTimeLineItem", "AdH265Helper, fileExists, isH265File=" + bool + ", path=" + (String)localObject3);
                      }
                      if (aj.faL().b(localSnsInfo, null) != 5) {
                        break label3843;
                      }
                    }
                    for (bool = true;; bool = false)
                    {
                      parambk.EKl.EoE.d(parambl.ENp, bool, false);
                      if (!locala.EYk) {
                        break;
                      }
                      Log.d("MiroMsg.CardAdTimeLineItem", "in fillitem, the user online video is true");
                      m.u(locala.EYj, paramInt2, i);
                      parambl = locala.EYj;
                      parambk = new com.tencent.mm.plugin.sns.ad.timeline.video.online.c("MiroMsg.CardAdTimeLineItem");
                      parambk.okL = parambl;
                      parambk.DzV = localcnb;
                      parambk.DzU = paramTimeLineObject;
                      parambk.rzs = paramBaseViewHolder.dHp;
                      parambk.layout();
                      m.u(locala.EUK.Ewv, false);
                      break;
                      com.tencent.mm.plugin.sns.ad.e.b.a(localcnb, false);
                      break label2799;
                      if (((com.tencent.mm.plugin.sns.model.g)localObject4).b(localSnsInfo, null) == 5)
                      {
                        ((com.tencent.mm.plugin.sns.model.g)localObject4).B(localcnb);
                        ((at)localObject3).EeS.setVisibility(8);
                        ((at)localObject3).Ewv.setVisibility(0);
                        ((at)localObject3).Ewv.gYN();
                        break label2892;
                      }
                      if (((com.tencent.mm.plugin.sns.model.g)localObject4).y(localcnb))
                      {
                        ((at)localObject3).Ewv.setVisibility(8);
                        ((at)localObject3).EeS.setImageResource(2131691482);
                        ((at)localObject3).EeS.setVisibility(0);
                        break label2892;
                      }
                      ((com.tencent.mm.plugin.sns.model.g)localObject4).z(localcnb);
                      ((at)localObject3).EeS.setVisibility(0);
                      ((at)localObject3).Ewv.setVisibility(8);
                      ((at)localObject3).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
                      ((at)localObject3).EeS.setContentDescription(this.mActivity.getString(2131763945));
                      if (((com.tencent.mm.plugin.sns.model.g)localObject4).b(localSnsInfo, null) != 4) {
                        break label2892;
                      }
                      ((at)localObject3).EeT.setVisibility(0);
                      break label2892;
                      if (((com.tencent.mm.plugin.sns.model.g)localObject4).v(localcnb))
                      {
                        ((at)localObject3).EeS.setVisibility(0);
                        ((at)localObject3).Ewv.setVisibility(8);
                        ((at)localObject3).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
                        ((at)localObject3).EeS.setContentDescription(this.mActivity.getString(2131763945));
                      }
                      for (;;)
                      {
                        if (!((at)localObject3).Ews.Dnr.eVz()) {
                          break label3760;
                        }
                        Log.e("MiroMsg.CardAdTimeLineItem", "play video error " + localcnb.Id + " " + localcnb.Url + " " + localcnb.Msz + " " + paramInt1);
                        ((com.tencent.mm.plugin.sns.model.g)localObject4).z(localcnb);
                        ((at)localObject3).EeS.setVisibility(0);
                        ((at)localObject3).Ewv.setVisibility(8);
                        ((at)localObject3).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
                        ((at)localObject3).EeS.setContentDescription(this.mActivity.getString(2131763945));
                        break;
                        if (((com.tencent.mm.plugin.sns.model.g)localObject4).w(localcnb))
                        {
                          ((at)localObject3).EeS.setVisibility(8);
                          ((at)localObject3).Ewv.setVisibility(8);
                        }
                        else if (((com.tencent.mm.plugin.sns.model.g)localObject4).b(localSnsInfo, null) <= 5)
                        {
                          if (!locala.EYi)
                          {
                            Log.i("MiroMsg.CardAdTimeLineItem", "fillItem, showPlayBtn");
                            fkq();
                          }
                        }
                        else
                        {
                          ((com.tencent.mm.plugin.sns.model.g)localObject4).z(localcnb);
                          ((at)localObject3).EeS.setVisibility(0);
                          ((at)localObject3).Ewv.setVisibility(8);
                          ((at)localObject3).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
                          ((at)localObject3).EeS.setContentDescription(this.mActivity.getString(2131763945));
                        }
                      }
                      break label2892;
                      localObject3 = ((at)localObject3).Ews;
                      j = this.mActivity.hashCode();
                      localObject5 = bp.gCU();
                      ((bp)localObject5).hXs = paramTimeLineObject.CreateTime;
                      ((com.tencent.mm.plugin.sns.model.g)localObject4).a(localSnsInfo, localcnb, (VideoSightView)localObject3, j, paramInt1, (bp)localObject5, parambl.Eoq, true);
                      break label2995;
                      parambk.EKl.EoE.f(parambl.ENp, (int)localcnb.MsT, false);
                      break label3114;
                    }
                  }
                  ((com.tencent.mm.plugin.sns.model.g)localObject4).a(paramBaseViewHolder.EUK.Ews, this.mActivity.hashCode(), paramInt1);
                  paramBaseViewHolder.EUK.Eww.setVisibility(8);
                  paramBaseViewHolder.EUK.Ews.setOnSightCompletionAction(null);
                  paramBaseViewHolder.EUK.Ews.setOnCompletionListener(null);
                  paramBaseViewHolder.EUK.Ews.setOnDecodeDurationListener(null);
                  continue;
                  locala.EUX.setVisibility(8);
                  continue;
                  parambl = localSnsInfo.getAdXml().adPromotionInfo;
                  if ((parambl != null) && (e.ap(parambl.startTime, parambl.endTime)))
                  {
                    paramInt1 = 1;
                    continue;
                    if (this.EXR.EUY != null)
                    {
                      this.EXR.EUY.setVisibility(8);
                      continue;
                      paramInt1 = 0;
                      continue;
                      paramInt1 = 0;
                    }
                  }
                  else
                  {
                    paramInt1 = 0;
                  }
                }
              }
            }
          }
          if (Util.isNullOrNil(localSnsInfo.getAdXml().adCard3dHeadTitle)) {
            break label2025;
          }
          locala.EUU.setVisibility(0);
          locala.EYc.setVisibility(0);
          locala.EYc.setText(localSnsInfo.getAdXml().adCard3dHeadTitle);
          if (localSnsInfo.getAdXml().adMediaDisplayMode != 1) {
            break label2037;
          }
          i = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54);
          j = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54);
          k = this.mActivity.getResources().getDimensionPixelSize(2131165508);
          m = this.mActivity.getResources().getDimensionPixelSize(2131165534);
          n = this.mActivity.getResources().getDimensionPixelSize(2131165586);
          paramBaseViewHolder.EWA.setContentWidth(paramInt2 - i - j - k - m - n);
          paramBaseViewHolder.EWA.ffl();
          locala.EUU.setTag(localSnsInfo.getAdXml().adCard3dHeadUrl);
          if (Util.isNullOrNil(localSnsInfo.getAdXml().adCard3dHeadUrl)) {
            break label2136;
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localSnsInfo.getAdXml().adCard3dHeadUrl, false, new f.a()
          {
            public final void aNH(String paramAnonymousString)
            {
              AppMethodBeat.i(100061);
              Log.i("MiroMsg.CardAdTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
              if ((!Util.isNullOrNil(new String[] { (String)locala.EUU.getTag(), paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", (String)locala.EUU.getTag()))))
              {
                paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
                if (paramAnonymousString != null)
                {
                  locala.EUU.setVisibility(0);
                  locala.EYb.setImageBitmap(paramAnonymousString);
                  locala.EYb.setVisibility(0);
                }
              }
              AppMethodBeat.o(100061);
            }
            
            public final void eWN() {}
            
            public final void eWO() {}
          });
          if ((localSnsInfo.getAdXml().hasSelectInfo()) || (localSnsInfo.getAdXml().hasVoteInfo()))
          {
            if (!localSnsInfo.getAdXml().isNewStyleVote()) {
              break label2148;
            }
            this.EXT.fgQ();
            this.EXT.a(localSnsInfo, locala);
            locala.EUN.setVisibility(8);
            if (locala.EYh != null) {
              locala.EYh.setVisibility(8);
            }
            if (locala.EYg != null) {
              locala.EYg.setVisibility(8);
            }
          }
          locala.EVm.setScaleType(QImageView.a.QEL);
          locala.EUK.Ews.Dnz = true;
          locala.EUK.Ews.setScaleType(QImageView.a.QEL);
          if ((paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.LoV.size() <= 0)) {
            break label2450;
          }
          localObject1 = (cnb)paramTimeLineObject.ContentObj.LoV.get(0);
          localObject4 = aj.faL();
          if ((paramBaseViewHolder.EUK.Ewq != null) && (!Util.isEqual(paramBaseViewHolder.EUK.Ewq.Id, paramTimeLineObject.Id)))
          {
            Log.i("MiroMsg.CardAdTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.EUK.Ewq.Id });
            ((com.tencent.mm.plugin.sns.model.g)localObject4).a(paramBaseViewHolder.EUK.Ews, this.mActivity.hashCode(), paramInt1);
          }
          paramBaseViewHolder.EUK.a(paramTimeLineObject, paramInt1, parambl.Eql, parambl.Eoq);
          paramBaseViewHolder.EUK.EeT.setVisibility(8);
          localObject5 = new com.tencent.mm.plugin.sns.ad.timeline.video.online.b("MiroMsg.CardAdTimeLineItem");
          ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject5).mContainer = locala.EYj;
          ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject5).DqS = paramTimeLineObject;
          ((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject5).DzT = locala.EYk;
          if (((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject5).mContainer != null) {
            break label2456;
          }
          Log.e(((com.tencent.mm.plugin.sns.ad.timeline.video.online.b)localObject5).mTag, "OnlineVideoChecker: the container is null");
          if (localObject1 != null)
          {
            paramInt2 = ((LinearLayout.LayoutParams)localObject3).width - this.mActivity.getResources().getDimensionPixelSize(2131165586) - this.mActivity.getResources().getDimensionPixelSize(2131165586);
            i = (int)(paramInt2 * ((cnb)localObject1).MsB.Mtp / ((cnb)localObject1).MsB.Mto);
            if (paramBaseViewHolder.timeLineObject.ContentObj.LoU != 1) {
              break label2599;
            }
            locala.EVm.setVisibility(0);
            locala.EUK.Ewr.setVisibility(4);
            parambl = locala.EVm.getLayoutParams();
            parambl.width = paramInt2;
            parambl.height = i;
            locala.EVm.setLayoutParams(parambl);
            parambl = aj.faL();
            localObject3 = locala.EVm;
            paramInt1 = this.mActivity.hashCode();
            localObject4 = bp.gCU();
            ((bp)localObject4).hXs = paramTimeLineObject.CreateTime;
            parambl.b((cnb)localObject1, (View)localObject3, -1, paramInt1, (bp)localObject4);
            locala.EVm.setTag(locala);
            locala.EXZ.setTag(locala);
            locala.EYa.setTag(locala);
            locala.EVm.setOnClickListener(parambk.DQs.Erh);
            parambk.fiV().c(locala.EVm, parambk.DQs.FaJ, parambk.DQs.Far);
            locala.EYi = false;
          }
          if (!localSnsInfo.getAdXml().hasActionBtn()) {
            break label3918;
          }
          if (locala.EYh != null) {
            locala.EYh.setVisibility(8);
          }
          if (locala.EYg != null) {
            locala.EYg.setVisibility(8);
          }
          locala.EUX.setVisibility(0);
          this.EXS.V(localSnsInfo);
          if (localSnsInfo == null) {
            break label4048;
          }
          try
          {
            if (localSnsInfo.getAdXml() != null) {
              break label3931;
            }
          }
          catch (Throwable parambl)
          {
            for (;;)
            {
              continue;
              paramInt1 = 1;
              continue;
              if (this.EXR.EVd != null) {
                this.EXR.EVd.setVisibility(8);
              }
              if (this.EXR.EVc != null) {
                this.EXR.EVc.setVisibility(8);
              }
            }
          }
          if (paramInt1 == 0) {
            break label3963;
          }
          parambl = localSnsInfo.getAdXml().adPromotionInfo;
          if (this.EXR.EUY != null)
          {
            this.EXR.EUY.setVisibility(0);
            this.EXR.EUY.setPromotionalPrice(parambl.Dse);
            this.EXR.EUY.setRightTitle(parambl.Dsf);
            m.f(this.EXR.EUY, com.tencent.mm.plugin.sns.ad.i.d.jV(parambl.Dsc, parambl.lco));
            this.EXR.EUY.b(new com.tencent.mm.plugin.sns.ad.widget.countdown.b(parambl.startTime, parambl.endTime));
          }
          if (localSnsInfo == null) {
            break label4053;
          }
          try
          {
            if (localSnsInfo.getAdXml() == null) {
              break label4053;
            }
            if (localSnsInfo.getAdXml().adLiveInfo != null) {
              break label3992;
            }
          }
          catch (Throwable parambl)
          {
            Object localObject2;
            cnb localcnb;
            ViewGroup localViewGroup;
            TimeLineObject localTimeLineObject;
            boolean bool;
            View localView;
            long l;
            break label1856;
          }
          if (paramInt1 == 0) {
            break label3997;
          }
          parambl = localSnsInfo.getTimeLine();
          if ((parambl != null) && (this.EXU != null))
          {
            paramTimeLineObject = localSnsInfo.getAdXml().adLiveInfo;
            paramInt1 = com.tencent.mm.plugin.sns.ad.widget.living.b.fu(parambl.Id, paramTimeLineObject.liveType);
            this.EXU.a(parambl.Id, paramTimeLineObject);
            this.EXU.setLiveStatus(paramInt1);
            com.tencent.mm.plugin.sns.ad.widget.living.b.a(parambl.Id, this.EXU);
            com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.eXI().b(0, localSnsInfo);
          }
          label1856:
          paramBaseViewHolder.hho = false;
          AppMethodBeat.o(100065);
          return;
          localObject1 = paramTimeLineObject.Id;
          break;
          locala.EYg.setVisibility(8);
          break label421;
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          continue;
          label1905:
          localObject2 = localSnsInfo.getAdXml().adCardDesc;
          continue;
          label1918:
          locala.EYh.setVisibility(8);
          continue;
          label1931:
          localObject2 = com.tencent.mm.ce.g.gxZ().a(locala.EYg.getContext(), (CharSequence)localObject2, locala.EYg.getTextSize());
          locala.EYg.setText((CharSequence)localObject2);
          locala.EYg.setVisibility(0);
          continue;
          label1979:
          if (localSnsInfo.getAdXml().adCardTagInfo.DWm.size() > 0) {
            locala.EYd.setVisibility(0);
          }
        }
      }
    }
  }
  
  public final void d(final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100064);
    this.EXR = ((a)paramBaseViewHolder);
    if (paramBaseViewHolder.EWD != null)
    {
      paramBaseViewHolder.EWD.setLayoutResource(2131496363);
      if (!paramBaseViewHolder.EWE)
      {
        this.EXR.jLx = ((ViewGroup)paramBaseViewHolder.EWD.inflate());
        paramBaseViewHolder.EWE = true;
      }
    }
    for (;;)
    {
      this.EXR.qVR = ((ViewGroup)this.EXR.jLx.findViewById(2131304552));
      if ((this.EXR.qVR instanceof RoundedCornerFrameLayout)) {
        ((RoundedCornerFrameLayout)this.EXR.qVR).setRadius(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 4));
      }
      this.EXR.EXY = ((ViewGroup)this.EXR.jLx.findViewById(2131305732));
      this.EXR.EVm = ((MaskImageView)this.EXR.jLx.findViewById(2131308082));
      this.EXR.EVm.setOnClickListener(this.DQX.DQs.Erh);
      this.DQX.fiV().c(this.EXR.EVm, this.DQX.DQs.FaF, this.DQX.DQs.Far);
      this.EXR.EYh = ((TextView)this.EXR.jLx.findViewById(2131299501));
      this.EXR.EYh.setClickable(false);
      this.EXR.EYh.setLongClickable(false);
      this.EXR.EYg = ((TextView)this.EXR.jLx.findViewById(2131299500));
      this.EXR.EYg.setClickable(false);
      this.EXR.EYg.setLongClickable(false);
      this.EXR.EUK = new at();
      this.EXR.EUK.Ewu = this.EXR.jLx.findViewById(2131308084);
      this.EXR.EUK.Ewr = this.EXR.EUK.Ewu;
      this.EXR.EUK.Ewu.setOnClickListener(this.DQX.DQs.FaQ);
      this.EXR.EUK.Ews = ((VideoSightView)this.EXR.EUK.Ewu.findViewById(2131302526));
      this.EXR.EUK.Ews.setMute(true);
      this.EXR.EUK.EeS = ((ImageView)this.EXR.EUK.Ewu.findViewById(2131308392));
      this.EXR.EUK.Ewv = ((MMPinProgressBtn)this.EXR.EUK.Ewu.findViewById(2131306281));
      this.EXR.EUK.Eww = ((TextView)this.EXR.EUK.Ewu.findViewById(2131300128));
      this.EXR.EUK.EeT = ((TextView)this.EXR.EUK.Ewu.findViewById(2131300154));
      this.EXR.EUU = this.EXR.jLx.findViewById(2131307977);
      this.EXR.EYb = ((ImageView)this.EXR.jLx.findViewById(2131307976));
      this.EXR.EYc = ((TextView)this.EXR.jLx.findViewById(2131307978));
      this.EXR.EYe = this.EXR.jLx.findViewById(2131298237);
      this.EXR.EUR = ((ImageView)this.EXR.jLx.findViewById(2131310365));
      this.EXR.EYf = ((ImageView)this.EXR.jLx.findViewById(2131310367));
      this.EXR.EUN = this.EXR.jLx.findViewById(2131298058);
      this.EXR.EXZ = ((Button)this.EXR.jLx.findViewById(2131298059));
      this.EXR.EYa = ((Button)this.EXR.jLx.findViewById(2131298060));
      this.EXR.EXZ.setOnClickListener(this.DQX.DQs.Fbb);
      this.EXR.EYa.setOnClickListener(this.DQX.DQs.Fbc);
      this.EXR.EYd = ((SnsCardAdTagListView)this.EXR.jLx.findViewById(2131298029));
      this.EXR.EYd.setActivityContext(this.mActivity);
      this.EXR.EYj = ((ViewGroup)this.EXR.jLx.findViewById(2131308083));
      this.EXR.EUX = this.EXR.jLx.findViewById(2131296378);
      this.EXR.EUY = ((PromotionBarLayout)this.EXR.jLx.findViewById(2131296503));
      this.EXS = new av(this.mActivity, this.EXR.jLx, 0, this.DQX.EKl.EoE, new av.b()
      {
        public final void fgP()
        {
          AppMethodBeat.i(100060);
          a.this.DQX.DQs.a(paramBaseViewHolder, null);
          AppMethodBeat.o(100060);
        }
      });
      this.EXT = new ax(this.mActivity, this.EXR.jLx, this.DQX.DQs);
      this.EXR.EVd = ((ViewGroup)this.EXR.jLx.findViewById(2131296502));
      this.EXR.EVc = ((LivingDescBarLayout)this.EXR.jLx.findViewById(2131296499));
      this.EXU = new com.tencent.mm.plugin.sns.ad.widget.living.c(this.EXR.EVd, this.EXR.EVc, this.EXS);
      if (!ao.isDarkMode()) {
        break;
      }
      this.EXR.EYf.setImageResource(2131689527);
      this.EXR.EUR.setImageResource(2131230909);
      AppMethodBeat.o(100064);
      return;
      if (!paramBaseViewHolder.EWE)
      {
        this.EXR.jLx = ((ViewGroup)paramBaseViewHolder.convertView.findViewById(2131296484));
        paramBaseViewHolder.EWE = true;
      }
    }
    this.EXR.EYf.setImageResource(2131689526);
    this.EXR.EUR.setImageResource(2131230910);
    AppMethodBeat.o(100064);
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(176416);
    if ((this.EXR != null) && (this.EXR.qVR != null))
    {
      Object localObject = new int[2];
      this.EXR.qVR.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.EXR.qVR.getMeasuredWidth() + i, this.EXR.qVR.getMeasuredHeight() + j);
      AppMethodBeat.o(176416);
      return localObject;
    }
    AppMethodBeat.o(176416);
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177692);
    Log.i("MiroMsg.CardAdTimeLineItem", "onUIPause");
    fkp();
    AppMethodBeat.o(177692);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176413);
    Log.i("MiroMsg.CardAdTimeLineItem", "pause");
    if (fkp()) {
      fkq();
    }
    AppMethodBeat.o(176413);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176414);
    Log.i("MiroMsg.CardAdTimeLineItem", "%s cardAd stop", new Object[] { this });
    if ((this.EXR != null) && (this.EXR.EUK != null)) {
      this.EXR.EUK.Ews.Dnr.clear();
    }
    this.EXV = false;
    AppMethodBeat.o(176414);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View EUN;
    public ImageView EUR;
    public View EUU;
    public View EUX;
    public PromotionBarLayout EUY;
    public LivingDescBarLayout EVc;
    public ViewGroup EVd;
    public MaskImageView EVm;
    public ViewGroup EXY;
    public Button EXZ;
    public Button EYa;
    public ImageView EYb;
    public TextView EYc;
    public SnsCardAdTagListView EYd;
    public View EYe;
    public ImageView EYf;
    public TextView EYg;
    public TextView EYh;
    public boolean EYi;
    public ViewGroup EYj;
    public boolean EYk;
    public ViewGroup jLx;
    public ViewGroup qVR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a
 * JD-Core Version:    0.7.0.1
 */