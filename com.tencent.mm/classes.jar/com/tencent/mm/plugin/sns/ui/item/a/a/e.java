package com.tencent.mm.plugin.sns.ui.item.a.a;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.bd;
import com.tencent.mm.plugin.sns.ui.bd.1;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class e
  extends a
{
  private SnsAdTouchProgressView RNY;
  private ImageView RNZ;
  private ViewGroup ROa;
  private bd ROb;
  protected SnsAdTouchProgressView.a ROc;
  
  public e()
  {
    AppMethodBeat.i(309060);
    this.ROc = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(309078);
        try
        {
          Log.i("LongPressAdBusiness", "SnsAdTouchProgressView onClick");
          e.this.RIM.Qcj.RjL.performClick();
          AppMethodBeat.o(309078);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          Log.e("LongPressAdBusiness", "SnsAdTouchProgressView onClick exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(309078);
        }
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(309089);
        e.this.RIM.Qcx.QbV = true;
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("ad_no_click_anim", true);
        e.this.be(localBundle);
        e.this.hra();
        e.this.amt(28);
        AppMethodBeat.o(309089);
      }
      
      public final void onStart() {}
    };
    AppMethodBeat.o(309060);
  }
  
  public final void a(int paramInt, SnsInfo paramSnsInfo, ADXml.g paramg, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(309071);
    super.a(paramInt, paramSnsInfo, paramg, paramLayoutParams);
    this.ROb.a(paramSnsInfo, paramg.QHN);
    AppMethodBeat.o(309071);
  }
  
  public final void a(Activity paramActivity, l paraml, c paramc, a.b paramb, com.tencent.mm.plugin.sns.ad.timeline.b.b.a parama)
  {
    AppMethodBeat.i(309069);
    super.a(paramActivity, paraml, paramc, paramb, parama);
    if (this.RNY == null)
    {
      this.RNY = ((SnsAdTouchProgressView)((ViewStub)paramb.Cxb.findViewById(b.f.sns_ad_sphere_anim_view_stub)).inflate());
      if (this.ROa != null) {
        break label176;
      }
      paramActivity = ((ViewStub)paramb.Cxb.findViewById(b.f.ad_longpress_cover_stub)).inflate();
      this.ROa = ((ViewGroup)paramActivity);
      this.RNZ = ((ImageView)paramActivity.findViewById(b.f.long_press_ad_icon));
      label94:
      this.RNY.setVisibility(8);
      paramActivity = this.mActivity;
      paraml = this.RNY;
      paramc = paramb.Qcj;
      if (this.xOq != 0) {
        break label186;
      }
    }
    label176:
    label186:
    for (int i = 1;; i = 2)
    {
      this.ROb = new bd(paramActivity, paraml, paramc, i, this.ROa);
      this.ROb.Rnd = this.ROc;
      AppMethodBeat.o(309069);
      return;
      Log.e("LongPressAdBusiness", "buildContent many times");
      break;
      Log.e("LongPressAdBusiness", "buildContent many times2");
      break label94;
    }
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(309081);
    super.onVideoPause();
    this.ROb.hnX();
    AppMethodBeat.o(309081);
  }
  
  public final void vA(long paramLong)
  {
    AppMethodBeat.i(309076);
    bd localbd = this.ROb;
    if (localbd.RmY) {
      h.ahAA.bk(new bd.1(localbd, paramLong));
    }
    AppMethodBeat.o(309076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.a.e
 * JD-Core Version:    0.7.0.1
 */