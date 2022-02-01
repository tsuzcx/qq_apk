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
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.b.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.as.b;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private a Awo;
  private as Awp;
  private au Awq;
  private boolean Awr = false;
  private p yVM;
  private String zbo = "";
  
  private void U(p paramp)
  {
    AppMethodBeat.i(198542);
    if ((this.zpI != null) && (this.zpI.AjE != null) && (this.zpI.AjE.zPb != null) && (paramp != null)) {
      this.zpI.AjE.zPb.zq(paramp.field_snsId);
    }
    AppMethodBeat.o(198542);
  }
  
  private boolean eef()
  {
    AppMethodBeat.i(177693);
    if ((this.Awo.timeLineObject.HAT.GaP == 5) || (this.Awo.timeLineObject.HAT.GaP == 15))
    {
      ad.i("MiroMsg.CardAdTimeLineItem", "%s cardAd doPause", new Object[] { this });
      if ((this.Awo != null) && (this.Awo.Atv != null))
      {
        this.Awo.Atv.zWy.pause();
        U(this.yVM);
      }
      this.Awr = false;
      AppMethodBeat.o(177693);
      return true;
    }
    AppMethodBeat.o(177693);
    return false;
  }
  
  private void eeg()
  {
    AppMethodBeat.i(176415);
    ad.i("MiroMsg.CardAdTimeLineItem", "try show play btn");
    if ((this.Awo != null) && (this.Awo.Atv != null) && (!this.Awr))
    {
      ad.i("MiroMsg.CardAdTimeLineItem", "show play btn");
      this.Awo.Atv.zFD.setVisibility(0);
      this.Awo.Atv.zWB.setVisibility(8);
      this.Awo.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
      this.Awo.Atv.zFD.setContentDescription(this.mActivity.getString(2131761939));
    }
    AppMethodBeat.o(176415);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176412);
    if ((paramBaseViewHolder.timeLineObject.HAT.GaP == 5) || (paramBaseViewHolder.timeLineObject.HAT.GaP == 15))
    {
      ad.i("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", new Object[] { this, Integer.valueOf(paramInt) });
      if (!(paramBaseViewHolder instanceof a)) {
        break label389;
      }
    }
    label389:
    for (boolean bool = ((a)paramBaseViewHolder).AwG;; bool = false)
    {
      ad.i("MiroMsg.CardAdTimeLineItem", "In the card ad item, the useOnlineVideo is ".concat(String.valueOf(bool)));
      if (!bool)
      {
        com.tencent.mm.plugin.sns.ui.video.d.eeK().cxw();
        com.tencent.mm.plugin.sns.ui.video.b.eeD().a(this);
        paramBaseViewHolder.Atv.zWy.start();
      }
      for (;;)
      {
        ad.i("MiroMsg.CardAdTimeLineItem", "try hide play btn");
        if ((this.Awo != null) && (this.Awo.Atv != null))
        {
          ad.i("MiroMsg.CardAdTimeLineItem", "hide play btn");
          this.Awo.Atv.zFD.setVisibility(8);
          this.Awo.Atv.zWB.setVisibility(8);
        }
        this.Awr = true;
        if ((paramBaseViewHolder instanceof a)) {
          ((a)paramBaseViewHolder).AwE = false;
        }
        AppMethodBeat.o(176412);
        return;
        com.tencent.mm.plugin.sns.ui.video.b.eeD().pause();
        ad.w("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", new Object[] { this, Integer.valueOf(paramInt) });
        p localp = this.yVM;
        byn localbyn = com.tencent.mm.plugin.sns.ad.timeline.a.d.a(paramBaseViewHolder);
        String str1 = com.tencent.mm.plugin.sns.ad.timeline.a.d.c(paramBaseViewHolder);
        com.tencent.mm.plugin.sns.ad.d.i locali = com.tencent.mm.plugin.sns.ad.timeline.a.d.a(this.zpI);
        ViewGroup localViewGroup = ((a)paramBaseViewHolder).AwF;
        String str2 = paramBaseViewHolder.doX;
        if ((localp != null) && (localbyn != null) && (localViewGroup != null))
        {
          ad.w("MiroMsg.CardAdTimeLineItem", "the sns info is " + localp + " the media is " + localbyn);
          com.tencent.mm.plugin.sns.ad.timeline.c.a.d locald = new com.tencent.mm.plugin.sns.ad.timeline.c.a.d("MiroMsg.CardAdTimeLineItem");
          locald.mContainer = localViewGroup;
          locald.zbu = localbyn;
          locald.yVM = localp;
          locald.qbR = str2;
          locald.zbo = str1;
          locald.zbv = locali;
          locald.a(3, new SnsTimelineVideoView.b()
          {
            public final void Pj(String paramAnonymousString)
            {
              AppMethodBeat.i(198541);
              ad.w("MiroMsg.CardAdTimeLineItem", "timelineVideoView setUICallback onDestroy, the tlId is " + paramAnonymousString + ", the timelineId is " + a.a(a.this));
              if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(a.a(a.this))))
              {
                a.b(a.this);
                a.c(a.this);
              }
              AppMethodBeat.o(198541);
            }
          });
        }
      }
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, final bh parambh)
  {
    AppMethodBeat.i(100065);
    ad.i("MiroMsg.CardAdTimeLineItem", "%s, fill card ad item %d, snsId %s", new Object[] { this, Integer.valueOf(paramInt1), paramTimeLineObject.Id });
    if (paramBaseViewHolder.grY)
    {
      ad.i("MiroMsg.CardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(100065);
      return;
    }
    paramBaseViewHolder.grY = true;
    Object localObject1;
    if (paramTimeLineObject.Id == null) {
      localObject1 = "";
    }
    for (;;)
    {
      this.zbo = ((String)localObject1);
      locala = (a)paramBaseViewHolder;
      localp = parambh.QT(paramInt1);
      this.yVM = localp;
      locala.AwB.setVisibility(8);
      locala.Aty.setVisibility(8);
      locala.AwA.setVisibility(8);
      locala.AtE.setVisibility(8);
      locala.AtE.setTag("");
      this.Awq.eaU();
      if (paramBaseViewHolder.AuZ != null) {
        paramBaseViewHolder.AuZ.setVisibility(8);
      }
      localObject1 = (WindowManager)this.mActivity.getSystemService("window");
      paramInt2 = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
      ((a)paramBaseViewHolder).Avb.setOnClickListener(parambh.zpd.Azc);
      localObject3 = new LinearLayout.LayoutParams(paramInt2 - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516), -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = this.mActivity.getResources().getDimensionPixelSize(2131165500);
      ((LinearLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 2);
      ((a)paramBaseViewHolder).iLP.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      parambh.ecN().c(paramBaseViewHolder.Avb, parambh.zpd.AyI, parambh.zpd.Ayq);
      if (locala.AwD != null) {
        locala.AwD.setVisibility(0);
      }
      if (locala.AwC != null)
      {
        if (!bt.isNullOrNil(localp.dRL().zwj)) {
          locala.AwC.setVisibility(0);
        }
      }
      else {
        label403:
        localObject1 = localp.dRL();
      }
      try
      {
        if ((com.tencent.mm.plugin.sns.ad.timeline.a.a.c(paramTimeLineObject)) && (com.tencent.mm.plugin.sns.ad.timeline.a.a.a((com.tencent.mm.plugin.sns.storage.b)localObject1)) && (com.tencent.mm.plugin.sns.ad.timeline.a.a.dRU())) {}
        for (locala.AwG = true;; locala.AwG = false)
        {
          localObject1 = localp.dRK();
          if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).dVQ()) && (!localp.dYX())) {
            locala.AwB.setVisibility(0);
          }
          if (!bt.isNullOrNil(localp.dRL().zwk)) {
            break label1610;
          }
          localObject1 = paramTimeLineObject.HAQ;
          if (bt.isNullOrNil((String)localObject1)) {
            break label1623;
          }
          localObject4 = com.tencent.mm.cf.g.fng();
          locala.AwD.getContext();
          localObject1 = ((com.tencent.mm.cf.g)localObject4).b((CharSequence)localObject1, locala.AwD.getTextSize());
          locala.AwD.setText((CharSequence)localObject1);
          locala.AwD.setVisibility(0);
          localObject1 = localp.dRL().zwj;
          if (!bt.isNullOrNil((String)localObject1)) {
            break label1636;
          }
          locala.AwC.setVisibility(8);
          try
          {
            localObject1 = localp.getSnsId();
            if (com.tencent.mm.plugin.sns.ui.widget.b.jX(locala.AwA.getOriginSnsId(), (String)localObject1)) {
              break label1689;
            }
            locala.AwA.removeAllViews();
            if (localp.dRL().zwn.zwZ.size() > 0)
            {
              locala.AwA.setVisibility(0);
              locala.AwA.setTagSpace(com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 8));
              locala.AwA.gi(localp.dRL().zwn.zwZ);
            }
            locala.AwA.setOriginSnsId((String)localObject1);
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
              Object localObject5;
              Object localObject2;
              ad.e("MiroMsg.CardAdTimeLineItem", localException.toString());
              continue;
              locala.Awz.setVisibility(4);
              continue;
              if (localp.dRL().zvX == 2)
              {
                i = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 54);
                j = this.mActivity.getResources().getDimensionPixelSize(2131165490);
                k = this.mActivity.getResources().getDimensionPixelSize(2131165516);
                m = this.mActivity.getResources().getDimensionPixelSize(2131165568);
                paramBaseViewHolder.AuZ.setContentWidth(paramInt2 - i - j - k - m);
                paramBaseViewHolder.AuZ.dZt();
                continue;
                locala.Awy.setVisibility(4);
                continue;
                this.Awq.eaU();
                locala.Aty.setVisibility(0);
                j = this.mActivity.getResources().getColor(2131100027);
                k = this.mActivity.getResources().getColor(2131099658);
                i = 1;
                paramInt2 = i;
                if (localp.dRL().dWf())
                {
                  m = x.jS(localp.dRL().zwG.zxA, localp.dYT());
                  paramInt2 = i;
                  if (m > 0)
                  {
                    paramInt2 = i;
                    if (m <= 2)
                    {
                      if (m != 1) {
                        break label2091;
                      }
                      locala.Awx.setTextColor(k);
                      locala.Awx.setText(localp.dRL().zwG.Qn(1));
                      locala.Aww.setTextColor(j);
                      locala.Aww.setText(localp.dRL().zwG.Qm(0));
                    }
                  }
                }
                for (;;)
                {
                  paramInt2 = 0;
                  if (paramInt2 == 0) {
                    break;
                  }
                  locala.Aww.setTextColor(j);
                  locala.Awx.setTextColor(j);
                  locala.Aww.setText(localp.dRL().dVV());
                  locala.Awx.setText(localp.dRL().dVW());
                  break;
                  if (m == 2)
                  {
                    locala.Aww.setTextColor(k);
                    locala.Aww.setText(localp.dRL().zwG.Qn(0));
                    locala.Awx.setTextColor(j);
                    locala.Awx.setText(localp.dRL().zwG.Qm(1));
                  }
                }
                byn localbyn = null;
                continue;
                if (((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).yVQ == null)
                {
                  ad.e(((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mTag, "OnlineVideoChecker: the timeline object is null");
                }
                else
                {
                  boolean bool;
                  try
                  {
                    ViewGroup localViewGroup = ((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mContainer;
                    TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).yVQ;
                    bool = ((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).zbs;
                    if (j.x(localViewGroup))
                    {
                      if (bool)
                      {
                        View localView = localViewGroup.getChildAt(0);
                        if ((!(localView instanceof SnsTimelineVideoView)) || (bt.lQ(((SnsTimelineVideoView)localView).AAX, localTimeLineObject.Id))) {
                          continue;
                        }
                        ad.i(((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mTag, "OnlineVideoChecker: the online video container has child, but the time line id is different!!");
                        j.w(localViewGroup);
                        continue;
                      }
                      ad.i(((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mTag, "OnlineVideoChecker: it doesn't use online video container!!");
                      j.w(localViewGroup);
                      continue;
                    }
                    ad.i(((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mTag, "OnlineVideoChecker: there is no child video view in container!!");
                  }
                  catch (Throwable localThrowable2) {}
                  if ((paramBaseViewHolder.timeLineObject.HAT.GaP == 5) || (paramBaseViewHolder.timeLineObject.HAT.GaP == 15))
                  {
                    locala.Atv.zWx.setVisibility(0);
                    locala.AtT.setVisibility(4);
                    parambh.ecN().c(locala.Atv.zWA, parambh.zpd.AyI, parambh.zpd.Ayq);
                    localObject3 = locala.Atv.zWx.getLayoutParams();
                    ((ViewGroup.LayoutParams)localObject3).width = paramInt2;
                    ((ViewGroup.LayoutParams)localObject3).height = i;
                    locala.Atv.zWx.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                    locala.Atv.zWy.hw(paramInt2, i);
                    locala.Atv.zWy.setOnCompletionListener(new b.e()
                    {
                      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(100062);
                        if (paramAnonymousInt != -1)
                        {
                          if ((parambh == null) || (parambh.AjE == null) || (parambh.AjE.zPb == null))
                          {
                            AppMethodBeat.o(100062);
                            return;
                          }
                          parambh.AjE.zPb.A(parambi.AmB, false);
                          ad.d("MiroMsg.CardAdTimeLineItem", "onCompletion, snsId=" + q.zw(localp.field_snsId));
                        }
                        AppMethodBeat.o(100062);
                      }
                    });
                    locala.Atv.zWy.setOnDecodeDurationListener(new b.f()
                    {
                      public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                      {
                        AppMethodBeat.i(100063);
                        if ((parambh == null) || (parambh.AjE == null) || (parambh.AjE.zPb == null))
                        {
                          AppMethodBeat.o(100063);
                          return;
                        }
                        if (localp != null)
                        {
                          parambh.AjE.zPb.zp(localp.field_snsId);
                          parambh.AjE.zPb.ak(localp.field_snsId, 1000L * paramAnonymousLong);
                        }
                        if (!parambh.AjE.zPb.zm(parambi.AmB))
                        {
                          int i = (int)paramAnonymousb.dQg();
                          parambh.AjE.zPb.d(parambi.AmB, bt.HI(), false);
                          parambh.AjE.zPb.e(parambi.AmB, i, false);
                          parambh.AjE.zPb.aj(parambi.AmB, parambi.AmB);
                        }
                        ad.d("MiroMsg.CardAdTimeLineItem", "onDecodeProgress, currentTime=" + paramAnonymousLong + ", snsId=" + q.zw(localp.field_snsId));
                        AppMethodBeat.o(100063);
                      }
                    });
                    long l = System.nanoTime();
                    bool = f.t(localbyn);
                    ad.i("MiroMsg.CardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
                    localObject3 = locala.Atv;
                    if (!bool) {
                      if (((f)localObject4).w(localbyn))
                      {
                        ((aq)localObject3).zFD.setVisibility(8);
                        ((aq)localObject3).zWB.setVisibility(0);
                        ((aq)localObject3).zWB.fLr();
                        locala.Aww.setTag(locala);
                        locala.Awx.setTag(locala);
                        ((aq)localObject3).zWy.setTagObject(localObject3);
                        ((aq)localObject3).zWA.setTag(locala);
                        localObject3 = ((aq)localObject3).zWy;
                        j = this.mActivity.hashCode();
                        localObject5 = bj.frn();
                        ((bj)localObject5).hbR = paramTimeLineObject.CreateTime;
                        ((f)localObject4).a(localp, localbyn, (VideoSightView)localObject3, j, paramInt1, (bj)localObject5, parambi.zOM, true);
                        localObject3 = ao.jo(ag.getAccSnsPath(), localbyn.Id);
                        localObject4 = q.i(localbyn);
                        if (!com.tencent.mm.vfs.i.fv((String)localObject3 + (String)localObject4)) {
                          break label3381;
                        }
                        parambh.AjE.zPb.B(parambi.AmB, true);
                        if (ag.dUb().b(localp, null) != 5) {
                          break label3400;
                        }
                      }
                    }
                    for (bool = true;; bool = false)
                    {
                      parambh.AjE.zPb.c(parambi.AmB, bool, false);
                      if (!locala.AwG) {
                        break;
                      }
                      ad.d("MiroMsg.CardAdTimeLineItem", "in fillitem, the user online video is true");
                      j.v(locala.AwF, paramInt2, i);
                      parambi = locala.AwF;
                      parambh = new com.tencent.mm.plugin.sns.ad.timeline.c.a.c("MiroMsg.CardAdTimeLineItem");
                      parambh.mSy = parambi;
                      parambh.zbu = localbyn;
                      parambh.zbt = paramTimeLineObject;
                      parambh.qbR = paramBaseViewHolder.doX;
                      parambh.layout();
                      j.O(locala.Atv.zWB, false);
                      break;
                      if (((f)localObject4).b(localp, null) == 5)
                      {
                        ((f)localObject4).A(localbyn);
                        ((aq)localObject3).zFD.setVisibility(8);
                        ((aq)localObject3).zWB.setVisibility(0);
                        ((aq)localObject3).zWB.fLr();
                        break label2587;
                      }
                      if (((f)localObject4).x(localbyn))
                      {
                        ((aq)localObject3).zWB.setVisibility(8);
                        ((aq)localObject3).zFD.setImageResource(2131691612);
                        ((aq)localObject3).zFD.setVisibility(0);
                        break label2587;
                      }
                      ((f)localObject4).y(localbyn);
                      ((aq)localObject3).zFD.setVisibility(0);
                      ((aq)localObject3).zWB.setVisibility(8);
                      ((aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
                      ((aq)localObject3).zFD.setContentDescription(this.mActivity.getString(2131761939));
                      if (((f)localObject4).b(localp, null) != 4) {
                        break label2587;
                      }
                      ((aq)localObject3).zFE.setVisibility(0);
                      break label2587;
                      if (((f)localObject4).u(localbyn))
                      {
                        ((aq)localObject3).zFD.setVisibility(0);
                        ((aq)localObject3).zWB.setVisibility(8);
                        ((aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
                        ((aq)localObject3).zFD.setContentDescription(this.mActivity.getString(2131761939));
                      }
                      for (;;)
                      {
                        if (!((aq)localObject3).zWy.ySq.dQd()) {
                          break label3379;
                        }
                        ad.e("MiroMsg.CardAdTimeLineItem", "play video error " + localbyn.Id + " " + localbyn.Url + " " + localbyn.GSI + " " + paramInt1);
                        ((f)localObject4).y(localbyn);
                        ((aq)localObject3).zFD.setVisibility(0);
                        ((aq)localObject3).zWB.setVisibility(8);
                        ((aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
                        ((aq)localObject3).zFD.setContentDescription(this.mActivity.getString(2131761939));
                        break;
                        if (((f)localObject4).v(localbyn))
                        {
                          ((aq)localObject3).zFD.setVisibility(8);
                          ((aq)localObject3).zWB.setVisibility(8);
                        }
                        else if (((f)localObject4).b(localp, null) <= 5)
                        {
                          if (!locala.AwE)
                          {
                            ad.i("MiroMsg.CardAdTimeLineItem", "fillItem, showPlayBtn");
                            eeg();
                          }
                        }
                        else
                        {
                          ((f)localObject4).y(localbyn);
                          ((aq)localObject3).zFD.setVisibility(0);
                          ((aq)localObject3).zWB.setVisibility(8);
                          ((aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
                          ((aq)localObject3).zFD.setContentDescription(this.mActivity.getString(2131761939));
                        }
                      }
                      break label2587;
                      parambh.AjE.zPb.B(parambi.AmB, false);
                      break label2742;
                    }
                  }
                  ((f)localObject4).a(paramBaseViewHolder.Atv.zWy, this.mActivity.hashCode(), paramInt1);
                  paramBaseViewHolder.Atv.zWC.setVisibility(8);
                  paramBaseViewHolder.Atv.zWy.setOnSightCompletionAction(null);
                  paramBaseViewHolder.Atv.zWy.setOnCompletionListener(null);
                  paramBaseViewHolder.Atv.zWy.setOnDecodeDurationListener(null);
                  continue;
                  locala.AtH.setVisibility(8);
                }
              }
            }
          }
          if (bt.isNullOrNil(localp.dRL().zwl)) {
            break label1735;
          }
          locala.AtE.setVisibility(0);
          locala.Awz.setVisibility(0);
          locala.Awz.setText(localp.dRL().zwl);
          if (localp.dRL().zvX != 1) {
            break label1747;
          }
          i = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 54);
          j = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 54);
          k = this.mActivity.getResources().getDimensionPixelSize(2131165490);
          m = this.mActivity.getResources().getDimensionPixelSize(2131165516);
          n = this.mActivity.getResources().getDimensionPixelSize(2131165568);
          paramBaseViewHolder.AuZ.setContentWidth(paramInt2 - i - j - k - m - n);
          paramBaseViewHolder.AuZ.dZt();
          locala.AtE.setTag(localp.dRL().zwm);
          if (bt.isNullOrNil(localp.dRL().zwm)) {
            break label1846;
          }
          h.a(localp.dRL().zwm, false, new f.a()
          {
            public final void axG(String paramAnonymousString)
            {
              AppMethodBeat.i(100061);
              ad.i("MiroMsg.CardAdTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
              if ((!bt.V(new String[] { (String)locala.AtE.getTag(), paramAnonymousString })) && (paramAnonymousString.equals(h.jF("adId", (String)locala.AtE.getTag()))))
              {
                paramAnonymousString = com.tencent.mm.sdk.platformtools.g.decodeFile(paramAnonymousString, null);
                if (paramAnonymousString != null)
                {
                  locala.AtE.setVisibility(0);
                  locala.Awy.setImageBitmap(paramAnonymousString);
                  locala.Awy.setVisibility(0);
                }
              }
              AppMethodBeat.o(100061);
            }
            
            public final void dRW() {}
            
            public final void dRX() {}
          });
          if ((localp.dRL().dWd()) || (localp.dRL().dWf()))
          {
            if (!localp.dRL().dWe()) {
              break label1858;
            }
            this.Awq.eaT();
            this.Awq.a(localp, locala);
            locala.Aty.setVisibility(8);
            if (locala.AwD != null) {
              locala.AwD.setVisibility(8);
            }
            if (locala.AwC != null) {
              locala.AwC.setVisibility(8);
            }
          }
          locala.AtT.setScaleType(QImageView.a.KTb);
          locala.Atv.zWy.ySy = true;
          locala.Atv.zWy.setScaleType(QImageView.a.KTb);
          if ((paramTimeLineObject.HAT == null) || (paramTimeLineObject.HAT.GaQ.size() <= 0)) {
            break label2160;
          }
          localObject1 = (byn)paramTimeLineObject.HAT.GaQ.get(0);
          localObject4 = ag.dUb();
          if ((paramBaseViewHolder.Atv.zWw != null) && (!bt.lQ(paramBaseViewHolder.Atv.zWw.Id, paramTimeLineObject.Id)))
          {
            ad.i("MiroMsg.CardAdTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.Atv.zWw.Id });
            ((f)localObject4).a(paramBaseViewHolder.Atv.zWy, this.mActivity.hashCode(), paramInt1);
          }
          paramBaseViewHolder.Atv.a(paramTimeLineObject, paramInt1, parambi.zQD, parambi.zOM);
          paramBaseViewHolder.Atv.zFE.setVisibility(8);
          localObject5 = new com.tencent.mm.plugin.sns.ad.timeline.c.a.b("MiroMsg.CardAdTimeLineItem");
          ((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mContainer = locala.AwF;
          ((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).yVQ = paramTimeLineObject;
          ((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).zbs = locala.AwG;
          if (((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mContainer != null) {
            break label2166;
          }
          ad.e(((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mTag, "OnlineVideoChecker: the container is null");
          if (localObject1 != null)
          {
            paramInt2 = ((LinearLayout.LayoutParams)localObject3).width - this.mActivity.getResources().getDimensionPixelSize(2131165568) - this.mActivity.getResources().getDimensionPixelSize(2131165568);
            i = (int)(paramInt2 * ((byn)localObject1).GSL.GTA / ((byn)localObject1).GSL.GTz);
            if (paramBaseViewHolder.timeLineObject.HAT.GaP != 1) {
              break label2309;
            }
            locala.AtT.setVisibility(0);
            locala.Atv.zWx.setVisibility(4);
            parambi = locala.AtT.getLayoutParams();
            parambi.width = paramInt2;
            parambi.height = i;
            locala.AtT.setLayoutParams(parambi);
            parambi = ag.dUb();
            localObject3 = locala.AtT;
            paramInt1 = this.mActivity.hashCode();
            localObject4 = bj.frn();
            ((bj)localObject4).hbR = paramTimeLineObject.CreateTime;
            parambi.b((byn)localObject1, (View)localObject3, -1, paramInt1, (bj)localObject4);
            locala.AtT.setTag(locala);
            locala.Aww.setTag(locala);
            locala.Awx.setTag(locala);
            locala.AtT.setOnClickListener(parambh.zpd.zRv);
            parambh.ecN().c(locala.AtT, parambh.zpd.AyI, parambh.zpd.Ayq);
            locala.AwE = false;
          }
          if (!localp.dRL().dVT()) {
            break label3475;
          }
          if (locala.AwD != null) {
            locala.AwD.setVisibility(8);
          }
          if (locala.AwC != null) {
            locala.AwC.setVisibility(8);
          }
          locala.AtH.setVisibility(0);
          this.Awp.P(localp);
          paramBaseViewHolder.grY = false;
          AppMethodBeat.o(100065);
          return;
          localObject1 = paramTimeLineObject.Id;
          break;
          locala.AwC.setVisibility(8);
          break label403;
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          continue;
          label1610:
          localObject2 = localp.dRL().zwk;
          continue;
          label1623:
          locala.AwD.setVisibility(8);
          continue;
          label1636:
          localObject4 = com.tencent.mm.cf.g.fng();
          locala.AwC.getContext();
          localObject2 = ((com.tencent.mm.cf.g)localObject4).b((CharSequence)localObject2, locala.AwC.getTextSize());
          locala.AwC.setText((CharSequence)localObject2);
          locala.AwC.setVisibility(0);
          continue;
          label1689:
          if (localp.dRL().zwn.zwZ.size() > 0) {
            locala.AwA.setVisibility(0);
          }
        }
      }
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(176416);
    if ((this.Awo != null) && (this.Awo.Awu != null))
    {
      Object localObject = new int[2];
      this.Awo.Awu.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.Awo.Awu.getMeasuredWidth() + i, this.Awo.Awu.getMeasuredHeight() + j);
      AppMethodBeat.o(176416);
      return localObject;
    }
    AppMethodBeat.o(176416);
    return null;
  }
  
  public final void h(final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100064);
    this.Awo = ((a)paramBaseViewHolder);
    if (paramBaseViewHolder.Avc != null)
    {
      paramBaseViewHolder.Avc.setLayoutResource(2131495488);
      if (!paramBaseViewHolder.Avd)
      {
        this.Awo.iLP = ((ViewGroup)paramBaseViewHolder.Avc.inflate());
        paramBaseViewHolder.Avd = true;
      }
    }
    for (;;)
    {
      this.Awo.Awu = ((ViewGroup)this.Awo.iLP.findViewById(2131302206));
      if ((this.Awo.Awu instanceof RoundedCornerFrameLayout)) {
        ((RoundedCornerFrameLayout)this.Awo.Awu).setRadius(com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 4));
      }
      this.Awo.Awv = ((ViewGroup)this.Awo.iLP.findViewById(2131303102));
      this.Awo.AtT = ((MaskImageView)this.Awo.iLP.findViewById(2131304943));
      this.Awo.AtT.setOnClickListener(this.zpI.zpd.zRv);
      this.zpI.ecN().c(this.Awo.AtT, this.zpI.zpd.AyE, this.zpI.zpd.Ayq);
      this.Awo.AwD = ((TextView)this.Awo.iLP.findViewById(2131299000));
      this.Awo.AwD.setClickable(false);
      this.Awo.AwD.setLongClickable(false);
      this.Awo.AwC = ((TextView)this.Awo.iLP.findViewById(2131298999));
      this.Awo.AwC.setClickable(false);
      this.Awo.AwC.setLongClickable(false);
      this.Awo.Atv = new aq();
      this.Awo.Atv.zWA = this.Awo.iLP.findViewById(2131304944);
      this.Awo.Atv.zWx = this.Awo.Atv.zWA;
      this.Awo.Atv.zWA.setOnClickListener(this.zpI.zpd.AyP);
      this.Awo.Atv.zWy = ((VideoSightView)this.Awo.Atv.zWA.findViewById(2131300914));
      this.Awo.Atv.zWy.setMute(true);
      this.Awo.Atv.zFD = ((ImageView)this.Awo.Atv.zWA.findViewById(2131305196));
      this.Awo.Atv.zWB = ((MMPinProgressBtn)this.Awo.Atv.zWA.findViewById(2131303515));
      this.Awo.Atv.zWC = ((TextView)this.Awo.Atv.zWA.findViewById(2131299492));
      this.Awo.Atv.zFE = ((TextView)this.Awo.Atv.zWA.findViewById(2131299517));
      this.Awo.AtE = this.Awo.iLP.findViewById(2131304890);
      this.Awo.Awy = ((ImageView)this.Awo.iLP.findViewById(2131304889));
      this.Awo.Awz = ((TextView)this.Awo.iLP.findViewById(2131304891));
      this.Awo.AwB = this.Awo.iLP.findViewById(2131297919);
      this.Awo.Aty = this.Awo.iLP.findViewById(2131297744);
      this.Awo.Aww = ((Button)this.Awo.iLP.findViewById(2131297745));
      this.Awo.Awx = ((Button)this.Awo.iLP.findViewById(2131297746));
      this.Awo.Aww.setOnClickListener(this.zpI.zpd.Aza);
      this.Awo.Awx.setOnClickListener(this.zpI.zpd.Azb);
      this.Awo.AwA = ((SnsCardAdTagListView)this.Awo.iLP.findViewById(2131297725));
      this.Awo.AwA.setActivityContext(this.mActivity);
      this.Awo.AwF = ((ViewGroup)this.Awo.iLP.findViewById(2131308422));
      this.Awo.AtH = this.Awo.iLP.findViewById(2131296355);
      this.Awp = new as(this.mActivity, this.Awo.iLP, 0, this.zpI.AjE.zPb, new as.b()
      {
        public final void eaS()
        {
          AppMethodBeat.i(100060);
          a.this.zpI.zpd.m(paramBaseViewHolder);
          AppMethodBeat.o(100060);
        }
      });
      this.Awq = new au(this.mActivity, this.Awo.iLP, this.zpI.zpd);
      if (al.isDarkMode()) {
        ((ImageView)this.Awo.iLP.findViewById(2131306896)).setImageDrawable(this.mActivity.getResources().getDrawable(2131689524));
      }
      AppMethodBeat.o(100064);
      return;
      if (!paramBaseViewHolder.Avd)
      {
        this.Awo.iLP = ((ViewGroup)paramBaseViewHolder.tPw.findViewById(2131296428));
        paramBaseViewHolder.Avd = true;
      }
    }
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177692);
    ad.i("MiroMsg.CardAdTimeLineItem", "onUIPause");
    eef();
    AppMethodBeat.o(177692);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176413);
    ad.i("MiroMsg.CardAdTimeLineItem", "pause");
    if (eef()) {
      eeg();
    }
    AppMethodBeat.o(176413);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176414);
    ad.i("MiroMsg.CardAdTimeLineItem", "%s cardAd stop", new Object[] { this });
    if ((this.Awo != null) && (this.Awo.Atv != null)) {
      this.Awo.Atv.zWy.ySq.clear();
    }
    this.Awr = false;
    AppMethodBeat.o(176414);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View AtE;
    public View AtH;
    public MaskImageView AtT;
    public View Aty;
    public SnsCardAdTagListView AwA;
    public View AwB;
    public TextView AwC;
    public TextView AwD;
    public boolean AwE;
    public ViewGroup AwF;
    public boolean AwG;
    public ViewGroup Awu;
    public ViewGroup Awv;
    public Button Aww;
    public Button Awx;
    public ImageView Awy;
    public TextView Awz;
    public ViewGroup iLP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a
 * JD-Core Version:    0.7.0.1
 */