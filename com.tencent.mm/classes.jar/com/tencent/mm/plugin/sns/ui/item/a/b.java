package com.tencent.mm.plugin.sns.ui.item.a;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.b;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.plugin.sns.ui.item.h;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends h
{
  protected SnsAdTouchProgressView.a LjF;
  private bc LmV;
  
  public b()
  {
    AppMethodBeat.i(205197);
    this.LjF = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(265138);
        try
        {
          Log.i("MicroMsg.FullCardAdTimeLineItemNew.LongPress", "SnsAdTouchProgressView onClick");
          b.a(b.this).JKG.KKj.performClick();
          AppMethodBeat.o(265138);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          Log.e("MicroMsg.FullCardAdTimeLineItemNew.LongPress", "SnsAdTouchProgressView onClick exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(265138);
        }
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(265139);
        b.c(b.this).KYo.KCe.a(b.b(b.this), null);
        t.e(new long[] { 20L, 100L });
        f.a(b.d(b.this), b.e(b.this).Lnh.xYJ, b.f(b.this), 1);
        if (b.g(b.this) != null)
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(1, 1, t.aZs(b.h(b.this).getTimeLine().Id), 28, 21);
          if ((b.i(b.this) instanceof SnsTimeLineUI)) {
            m.a(localSnsAdClick, ((SnsTimeLineUI)b.j(b.this)).fXs(), b.k(b.this), 28);
          }
          t.a(localSnsAdClick);
          Log.i("MicroMsg.FullCardAdTimeLineItemNew.LongPress", "onFinish report MMOCAD_CLICKPOS_AD_FULL_CARD_LONGPRESS");
          AppMethodBeat.o(265139);
          return;
        }
        Log.e("MicroMsg.FullCardAdTimeLineItemNew.LongPress", "onFinish report, mSnsinfo==null");
        AppMethodBeat.o(265139);
      }
      
      public final void onStart() {}
    };
    AppMethodBeat.o(205197);
  }
  
  public final void a(long paramLong1, ADXml.g paramg, SnsInfo paramSnsInfo, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(205201);
    super.a(paramLong1, paramg, paramSnsInfo, paramLong2, paramInt);
    paramSnsInfo = null;
    paramg = paramSnsInfo;
    if (this.Kee != null)
    {
      paramg = paramSnsInfo;
      if (this.Kee.KYo != null) {
        paramg = this.Kee.KYo.KBN;
      }
    }
    this.LmV.a(paramg, paramLong2, paramLong1);
    AppMethodBeat.o(205201);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt, TimeLineObject paramTimeLineObject, ADXml.g paramg, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(205200);
    super.a(paramBaseViewHolder, paramInt, paramTimeLineObject, paramg, paramLayoutParams);
    paramBaseViewHolder = (WindowManager)this.mActivity.getSystemService("window");
    int i = Math.min(paramBaseViewHolder.getDefaultDisplay().getWidth(), paramBaseViewHolder.getDefaultDisplay().getHeight());
    int j = a.fromDPToPix(this.mActivity, 56);
    int k = this.mActivity.getResources().getDimensionPixelSize(i.d.LittlePadding);
    int m = this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding);
    if (paramLayoutParams != null) {}
    for (paramInt = paramLayoutParams.height;; paramInt = 0)
    {
      paramBaseViewHolder = new Rect(k + j, j - m, i - m, paramInt + (j - m));
      this.LmV.a(this.Jws, paramg.KjQ, paramBaseViewHolder);
      AppMethodBeat.o(205200);
      return;
    }
  }
  
  public final void b(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(205198);
    super.b(paramViewStub, paramBaseViewHolder);
    if (this.Lna.Lnh.JKE == null)
    {
      paramViewStub = ((ViewStub)this.Lna.LlS.findViewById(i.f.sns_ad_sphere_anim_view_stub)).inflate();
      this.Lna.Lnh.JKE = ((SnsAdSphereAnimView)paramViewStub.findViewById(i.f.sns_ad_sphere_anim_view));
      this.Lna.Lnh.JKD = ((SnsAdTouchProgressView)paramViewStub.findViewById(i.f.sns_ad_progress_anim_view));
    }
    for (;;)
    {
      this.Lna.Lnh.JKE.setVisibility(8);
      this.Lna.Lnh.JKD.setVisibility(8);
      this.LmV = new bc(this.mActivity, this.Lna.Lnh.JKD, this.Lna.Lnh.JKE, this.Lna.JKG, 1, this.Lna.LlS);
      this.LmV.KNr = this.LjF;
      this.LmV.KNr = this.LjF;
      AppMethodBeat.o(205198);
      return;
      Log.e("MicroMsg.FullCardAdTimeLineItemNew.LongPress", "buildContent many times");
    }
  }
  
  public final boolean b(ADXml.g paramg)
  {
    AppMethodBeat.i(205202);
    boolean bool = this.LmV.fVI();
    if ((super.b(paramg)) && (!bool))
    {
      AppMethodBeat.o(205202);
      return true;
    }
    AppMethodBeat.o(205202);
    return false;
  }
  
  public final boolean d(ADXml paramADXml)
  {
    return false;
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(205203);
    super.onVideoPause();
    this.LmV.fVJ();
    AppMethodBeat.o(205203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.b
 * JD-Core Version:    0.7.0.1
 */