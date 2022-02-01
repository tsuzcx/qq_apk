package com.tencent.mm.plugin.sns.ui.item.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.b;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.ADXml.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.plugin.sns.ui.item.h;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends h
{
  private Handler JMp;
  protected TwistCoverView.a LjG;
  
  public d()
  {
    AppMethodBeat.i(268376);
    this.JMp = new Handler(Looper.getMainLooper());
    this.LjG = new TwistCoverView.a()
    {
      public final void fMH()
      {
        AppMethodBeat.i(194693);
        d.a(d.this).Lnh.JKO.JKq = true;
        if (d.b(d.this) == null)
        {
          Log.e("MicroMsg.FullCardAdTimeLineItemNew.TwistAd", "onTwist, mSnsInfo==null");
          AppMethodBeat.o(194693);
          return;
        }
        Object localObject = new Bundle();
        ((Bundle)localObject).putBoolean("isFromTwist", true);
        ADXml.k localk = d.c(d.this).getAdXml().adTwistInfo;
        if (localk != null)
        {
          ((Bundle)localObject).putBoolean("isSimpleTwistAnim", localk.Kkf);
          ((Bundle)localObject).putBoolean("isTwistClockwise", localk.Kke);
          if (localk.Kkf) {
            t.e(new long[] { 0L, 80L });
          }
        }
        d.e(d.this).KYo.KCe.a(d.d(d.this), (Bundle)localObject);
        f.a(d.f(d.this), d.g(d.this).Lnh.xYJ, d.h(d.this), 1);
        try
        {
          localObject = new SnsAdClick(1, 1, t.aZs(d.i(d.this).getTimeLine().Id), 29, 21);
          if ((d.j(d.this) instanceof SnsTimeLineUI)) {
            m.a((SnsAdClick)localObject, ((SnsTimeLineUI)d.k(d.this)).fXs(), d.l(d.this), 29);
          }
          t.a((SnsAdClick)localObject);
          Log.i("MicroMsg.FullCardAdTimeLineItemNew.TwistAd", "onTwist report MMOCAD_CLICKPOS_AD_FULL_CARD_TWIST");
          AppMethodBeat.o(194693);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.FullCardAdTimeLineItemNew.TwistAd", "twist click report exp=" + localThrowable.toString());
          AppMethodBeat.o(194693);
        }
      }
    };
    AppMethodBeat.o(268376);
  }
  
  public final void a(long paramLong1, ADXml.g paramg, SnsInfo paramSnsInfo, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(268380);
    super.a(paramLong1, paramg, paramSnsInfo, paramLong2, paramInt);
    if ((this.Kee == null) || (this.Kee.KYo == null) || (this.Kee.KYo.KBN == null) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(268380);
      return;
    }
    if ((paramSnsInfo.isTwistAd()) && (this.Lna.Lnh.JKF != null)) {
      this.Lna.Lnh.JKF.Qp(paramLong2);
    }
    AppMethodBeat.o(268380);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt, TimeLineObject paramTimeLineObject, ADXml.g paramg, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(268379);
    super.a(paramBaseViewHolder, paramInt, paramTimeLineObject, paramg, paramLayoutParams);
    if ((this.Jws != null) && (this.Lna.Lnh.JKF != null))
    {
      this.Lna.Lnh.JKF.a(this.Jws, this.Jws.getAdXml().adTwistInfo, 1);
      if (this.Jws.isTwistAd())
      {
        this.Lna.JKG.KKl.setTimerInterval(300);
        AppMethodBeat.o(268379);
        return;
      }
      this.Lna.JKG.KKl.setTimerInterval(1000);
      this.Lna.Lnh.JKF.clear();
    }
    AppMethodBeat.o(268379);
  }
  
  public final void b(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(268377);
    super.b(paramViewStub, paramBaseViewHolder);
    if (this.Lna.Lnh.JKF == null)
    {
      paramViewStub = (ViewStub)this.Lna.Lnh.xYJ.findViewById(i.f.sns_twist_ad_cover_stub);
      if (paramViewStub == null) {
        break label101;
      }
      this.Lna.Lnh.JKF = ((TwistCoverView)paramViewStub.inflate());
    }
    for (;;)
    {
      if (this.Lna.Lnh.JKF != null) {
        this.Lna.Lnh.JKF.setTwistActionListener(this.LjG);
      }
      AppMethodBeat.o(268377);
      return;
      label101:
      Log.e("MicroMsg.FullCardAdTimeLineItemNew.TwistAd", "coverStub==null");
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(268382);
    super.onUIDestroy();
    if (this.Lna.Lnh.JKF != null) {
      this.Lna.Lnh.JKF.setSensorEnabled(false);
    }
    AppMethodBeat.o(268382);
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(268381);
    super.onVideoPause();
    if ((this.Jws != null) && (this.Jws.isTwistAd()) && (this.Lna.Lnh.JKF != null)) {
      this.Lna.Lnh.JKF.onPlayerPaused();
    }
    AppMethodBeat.o(268381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.d
 * JD-Core Version:    0.7.0.1
 */