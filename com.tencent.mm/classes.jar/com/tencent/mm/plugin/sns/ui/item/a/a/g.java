package com.tencent.mm.plugin.sns.ui.item.a.a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.b.d;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.ADXml.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends a
{
  public TwistCoverView ROg;
  protected TwistCoverView.a ROh;
  
  public g()
  {
    AppMethodBeat.i(309059);
    this.ROh = new TwistCoverView.a()
    {
      public final void hdO()
      {
        AppMethodBeat.i(309057);
        g.this.RIM.Qcx.QbV = true;
        if (g.this.PJQ == null)
        {
          Log.e("TwistAdBusiness", "onTwist, mSnsInfo==null");
          AppMethodBeat.o(309057);
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("ad_no_click_anim", true);
        ADXml.k localk = g.this.PJQ.getAdXml().adTwistInfo;
        if (localk != null)
        {
          localBundle.putBoolean("isSimpleTwistAnim", localk.QId);
          localBundle.putBoolean("isTwistClockwise", localk.QIc);
          if (localk.QId) {
            t.g(new long[] { 0L, 80L });
          }
        }
        g.this.be(localBundle);
        g.this.hra();
        g.this.amt(29);
        AppMethodBeat.o(309057);
      }
    };
    AppMethodBeat.o(309059);
  }
  
  public final void a(int paramInt, SnsInfo paramSnsInfo, ADXml.g paramg, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = true;
    AppMethodBeat.i(309073);
    super.a(paramInt, paramSnsInfo, paramg, paramLayoutParams);
    if ((this.PJQ != null) && (this.ROg != null))
    {
      if (this.RIM.Qcx.source != 0) {
        break label253;
      }
      paramInt = 1;
      paramSnsInfo = this.ROg;
      paramg = this.PJQ;
      paramSnsInfo.Qjv = this.PJQ.getAdXml().adTwistInfo;
      paramSnsInfo.PJQ = paramg;
      paramSnsInfo.mScene = paramInt;
      if ((paramSnsInfo.Qjv != null) && (paramg != null))
      {
        Log.i("TwistCoverView", "initData, id=" + t.uA(paramg.field_snsId) + ", twistInfo=" + paramSnsInfo.Qjv + ", scene=" + paramInt);
        paramSnsInfo.getContext();
        if (paramSnsInfo.Qjw == null)
        {
          paramSnsInfo.Qjw = new d();
          paramg = paramSnsInfo.Qjw;
          paramLayoutParams = paramSnsInfo.QjF;
          if (paramg.PPz != null) {
            paramg.PPz.a(paramLayoutParams);
          }
          if (paramSnsInfo.Qjw.PPz == null) {
            break label258;
          }
        }
      }
    }
    for (;;)
    {
      paramSnsInfo.QjD = bool;
      Log.i("TwistCoverView", "initSensor, isSensorOk=" + paramSnsInfo.QjD);
      this.RIM.Qcj.RjN.setTimerInterval(300);
      AppMethodBeat.o(309073);
      return;
      label253:
      paramInt = 2;
      break;
      label258:
      bool = false;
    }
  }
  
  public final void a(Activity paramActivity, l paraml, c paramc, a.b paramb, com.tencent.mm.plugin.sns.ad.timeline.b.b.a parama)
  {
    AppMethodBeat.i(309067);
    super.a(paramActivity, paraml, paramc, paramb, parama);
    if (this.ROg == null)
    {
      paramActivity = (ViewStub)paramb.Cxb.findViewById(b.f.sns_twist_ad_cover_stub);
      if (paramActivity == null) {
        break label77;
      }
      this.ROg = ((TwistCoverView)paramActivity.inflate());
    }
    for (;;)
    {
      if (this.ROg != null) {
        this.ROg.setTwistActionListener(this.ROh);
      }
      AppMethodBeat.o(309067);
      return;
      label77:
      Log.e("TwistAdBusiness", "coverStub==null");
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(309095);
    super.onUIDestroy();
    if (this.ROg != null) {
      this.ROg.setSensorEnabled(false);
    }
    AppMethodBeat.o(309095);
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(309090);
    super.onVideoPause();
    if ((this.PJQ != null) && (this.ROg != null))
    {
      TwistCoverView localTwistCoverView = this.ROg;
      if (localTwistCoverView.Qjv != null)
      {
        Log.i("TwistCoverView", "onPlayerPaused");
        localTwistCoverView.Qjy = true;
        localTwistCoverView.setSensorEnabled(false);
        localTwistCoverView.hdL();
        localTwistCoverView.PRJ.removeMessages(1);
      }
    }
    AppMethodBeat.o(309090);
  }
  
  public final void vA(long paramLong)
  {
    AppMethodBeat.i(309083);
    if ((this.PYh == null) || (this.PJQ == null))
    {
      AppMethodBeat.o(309083);
      return;
    }
    if (this.ROg != null)
    {
      TwistCoverView localTwistCoverView = this.ROg;
      Log.d("TwistCoverView", "checkShow:".concat(String.valueOf(paramLong)));
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.arg1 = ((int)paramLong);
      localTwistCoverView.PRJ.removeMessages(1);
      localTwistCoverView.PRJ.sendMessageDelayed(localMessage, 50L);
    }
    AppMethodBeat.o(309083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.a.g
 * JD-Core Version:    0.7.0.1
 */