package com.tencent.mm.plugin.sns.ui.item.a.a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCoverView;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCoverView.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import org.libpag.PAGView;

public final class f
  extends a
{
  private ShakeCoverView.a QiQ;
  private ShakeCoverView ROe;
  
  public f()
  {
    AppMethodBeat.i(309064);
    this.QiQ = new ShakeCoverView.a()
    {
      public final void hat()
      {
        AppMethodBeat.i(309072);
        if (f.this.PJQ == null)
        {
          Log.e("ShakeAdBusiness", "onShake, mSnsInfo==null");
          AppMethodBeat.o(309072);
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("ad_no_click_anim", true);
        f.this.be(localBundle);
        f.this.hra();
        f.this.amt(36);
        AppMethodBeat.o(309072);
      }
    };
    AppMethodBeat.o(309064);
  }
  
  public final void a(int paramInt, SnsInfo paramSnsInfo, ADXml.g paramg, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(309075);
    super.a(paramInt, paramSnsInfo, paramg, paramLayoutParams);
    if ((this.PJQ != null) && (this.ROe != null)) {
      if (this.xOq != 0) {
        break label189;
      }
    }
    label189:
    for (paramInt = 1;; paramInt = 2)
    {
      paramSnsInfo = this.ROe;
      paramg = this.PJQ;
      if (paramg != null)
      {
        paramSnsInfo.mScene = paramInt;
        paramSnsInfo.PJQ = paramg;
        paramSnsInfo.QiG = paramg.getAdXml().adShakeInfo;
        if (paramSnsInfo.QiG != null)
        {
          paramSnsInfo.QiC.setText(paramSnsInfo.QiG.title);
          paramSnsInfo.QiD.setText(paramSnsInfo.QiG.desc);
        }
        if (paramLayoutParams != null)
        {
          paramg = paramSnsInfo.QiB.getLayoutParams();
          paramInt = (int)(paramLayoutParams.height * 0.53D);
          if ((paramInt > 0) && (paramg.height != paramInt))
          {
            paramg.height = paramInt;
            paramg.width = paramInt;
            paramSnsInfo.QiB.setLayoutParams(paramg);
          }
        }
        paramSnsInfo.mIsDestroyed = false;
      }
      this.RIM.Qcj.RjN.setTimerInterval(300);
      AppMethodBeat.o(309075);
      return;
    }
  }
  
  public final void a(Activity paramActivity, l paraml, c paramc, a.b paramb, com.tencent.mm.plugin.sns.ad.timeline.b.b.a parama)
  {
    AppMethodBeat.i(309068);
    super.a(paramActivity, paraml, paramc, paramb, parama);
    if (this.ROe == null)
    {
      paramActivity = (ViewStub)this.RIM.Cxb.findViewById(b.f.sns_shake_ad_cover_stub);
      if (paramActivity != null)
      {
        this.ROe = ((ShakeCoverView)paramActivity.inflate());
        this.ROe.setVisibility(0);
        this.ROe.setOnShakeListener(this.QiQ);
        AppMethodBeat.o(309068);
        return;
      }
      Log.e("ShakeAdBusiness", "coverStub==null");
    }
    AppMethodBeat.o(309068);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(309092);
    super.onUIDestroy();
    if (this.ROe != null) {
      this.ROe.clear();
    }
    AppMethodBeat.o(309092);
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(309085);
    super.onVideoPause();
    if ((this.PJQ != null) && (this.ROe != null)) {
      this.ROe.hdx();
    }
    AppMethodBeat.o(309085);
  }
  
  public final void vA(long paramLong)
  {
    AppMethodBeat.i(309080);
    if ((this.PYh == null) || (this.PJQ == null))
    {
      AppMethodBeat.o(309080);
      return;
    }
    if (this.ROe != null)
    {
      ShakeCoverView localShakeCoverView = this.ROe;
      Log.d("ShakeCoverView", "checkShow:".concat(String.valueOf(paramLong)));
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.arg1 = ((int)paramLong);
      localShakeCoverView.PRJ.removeMessages(1);
      localShakeCoverView.PRJ.sendMessageDelayed(localMessage, 50L);
    }
    AppMethodBeat.o(309080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.a.f
 * JD-Core Version:    0.7.0.1
 */