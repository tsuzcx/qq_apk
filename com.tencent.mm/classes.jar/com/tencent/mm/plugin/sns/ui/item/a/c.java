package com.tencent.mm.plugin.sns.ui.item.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.b;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCoverView;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCoverView.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.plugin.sns.ui.item.h;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends h
{
  private Handler JMp;
  private ShakeCoverView.a JOb;
  
  public c()
  {
    AppMethodBeat.i(197701);
    this.JMp = new Handler(Looper.getMainLooper());
    this.JOb = new ShakeCoverView.a()
    {
      public final void onShake()
      {
        AppMethodBeat.i(252311);
        if (c.a(c.this) == null)
        {
          Log.e("MicroMsg.FullCardAdTimeLineItemNew.shakeAd", "onShake, mSnsInfo==null");
          AppMethodBeat.o(252311);
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isFromShake", true);
        c.c(c.this).KYo.KCe.a(c.b(c.this), localBundle);
        f.a(c.d(c.this), c.e(c.this).Lnh.xYJ, c.f(c.this), 1);
        c.g(c.this);
        AppMethodBeat.o(252311);
      }
    };
    AppMethodBeat.o(197701);
  }
  
  public final void a(long paramLong1, ADXml.g paramg, SnsInfo paramSnsInfo, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(197710);
    super.a(paramLong1, paramg, paramSnsInfo, paramLong2, paramInt);
    if ((this.Kee == null) || (this.Kee.KYo == null) || (this.Kee.KYo.KBN == null) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(197710);
      return;
    }
    if (this.Lna.Lnh.JKN != null) {
      this.Lna.Lnh.JKN.Qp(paramLong2);
    }
    AppMethodBeat.o(197710);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt, TimeLineObject paramTimeLineObject, ADXml.g paramg, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(197706);
    super.a(paramBaseViewHolder, paramInt, paramTimeLineObject, paramg, paramLayoutParams);
    if ((this.Jws != null) && (this.Lna.Lnh.JKN != null))
    {
      this.Lna.Lnh.JKN.a(this.Jws, 1);
      if (this.Jws.isShakeAd())
      {
        this.Lna.JKG.KKl.setTimerInterval(300);
        AppMethodBeat.o(197706);
        return;
      }
      this.Lna.JKG.KKl.setTimerInterval(1000);
      this.Lna.Lnh.JKN.clear();
    }
    AppMethodBeat.o(197706);
  }
  
  public final void b(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(197705);
    super.b(paramViewStub, paramBaseViewHolder);
    if (this.Lna.Lnh.JKN == null)
    {
      paramViewStub = (ViewStub)this.Lna.Lnh.xYJ.findViewById(i.f.sns_shake_ad_cover_stub);
      if (paramViewStub != null)
      {
        this.Lna.Lnh.JKN = ((ShakeCoverView)paramViewStub.inflate());
        this.Lna.Lnh.JKN.setVisibility(0);
        this.Lna.Lnh.JKN.setOnShakeListener(this.JOb);
        AppMethodBeat.o(197705);
        return;
      }
      Log.e("MicroMsg.FullCardAdTimeLineItemNew.shakeAd", "coverStub==null");
    }
    AppMethodBeat.o(197705);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(197717);
    super.onUIDestroy();
    if (this.Lna.Lnh.JKN != null) {
      this.Lna.Lnh.JKN.clear();
    }
    AppMethodBeat.o(197717);
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(197714);
    super.onVideoPause();
    if ((this.Jws != null) && (this.Jws.isShakeAd()) && (this.Lna.Lnh.JKN != null)) {
      this.Lna.Lnh.JKN.fMw();
    }
    AppMethodBeat.o(197714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.c
 * JD-Core Version:    0.7.0.1
 */