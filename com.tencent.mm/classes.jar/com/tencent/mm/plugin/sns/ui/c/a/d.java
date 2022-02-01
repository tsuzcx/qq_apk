package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.az;
import com.tencent.mm.plugin.sns.ui.item.a.a.e;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.ad.AdRoundedCornerFrameLayout;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class d
  extends b
  implements com.tencent.mm.plugin.sns.ad.g.d
{
  com.tencent.mm.plugin.sns.ad.g.l PYh;
  ADXml.g QbN;
  public a.b RJA;
  com.tencent.mm.plugin.sns.ad.timeline.b.b.a RJB;
  com.tencent.mm.plugin.sns.ui.item.a.a.d RJC;
  private View.OnClickListener RJD;
  protected a.c RJE;
  private boolean RJw;
  boolean RJz;
  Activity mContext;
  boolean mIsPaused;
  
  public d(Activity paramActivity, int paramInt, TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ui.listener.c paramc, com.tencent.mm.plugin.sns.ad.g.l paraml)
  {
    AppMethodBeat.i(308814);
    this.RJz = false;
    this.RJB = new com.tencent.mm.plugin.sns.ad.timeline.b.b.a();
    this.RJD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308871);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItemNew$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.FullCardAdDetailItemNew", "ProxyCardClickListener onClick");
        try
        {
          d.this.PZr.RQG.onClick(paramAnonymousView);
          if (d.this.RJz) {
            SnsAdCardVideoEndView.k(d.this.PNI, 2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItemNew$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308871);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            Log.e("MicroMsg.FullCardAdDetailItemNew", "ProxyCardClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.RJw = false;
    this.mIsPaused = false;
    this.RJE = new a.c()
    {
      public final void Dw(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(308872);
        Log.i("MicroMsg.FullCardAdDetailItemNew", "onCompletion, isOnlineVideoView=" + paramAnonymousBoolean + ", hash=" + d.this.hashCode());
        d locald = d.this;
        if (locald.QbN.QHM == null) {
          locald.RJB.Dv(locald.RJA.Qcx.QbW);
        }
        locald.PYh.S(locald.PNI.field_snsId, false);
        MMHandlerThread.postToMainThread(new d.1(locald));
        AppMethodBeat.o(308872);
      }
      
      public final void bC(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(308867);
        Log.i("MicroMsg.FullCardAdDetailItemNew", "onStart, isOnlineVideoView=" + paramAnonymousBoolean + ", duration=" + paramAnonymousInt + ", hash=" + d.this.hashCode());
        AppMethodBeat.o(308867);
      }
      
      public final void bD(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(308875);
        if (paramAnonymousBoolean) {}
        for (int i = d.this.RJA.Qcr.getDuration() / 1000;; i = d.this.RJA.Qcj.RjN.getDurationMs() / 1000)
        {
          d locald = d.this;
          long l = locald.PNI.field_snsId;
          Log.d("MicroMsg.FullCardAdDetailItemNew", "doOnVideoPlaying, curTime=" + paramAnonymousInt + ", isOnlineVideo=" + paramAnonymousBoolean);
          if (locald.PYh != null)
          {
            if (locald.PNI != null)
            {
              locald.PYh.ut(l);
              locald.PYh.bj(l, paramAnonymousInt);
            }
            if (!locald.PYh.uq(l))
            {
              locald.PYh.c(l, Util.currentTicks(), false);
              locald.PYh.f(l, i, false);
              locald.PYh.bi(l, l);
            }
          }
          com.tencent.mm.plugin.sns.ad.timeline.helper.f.a(locald.QbN, paramAnonymousInt, locald.RJA.Qch, locald.RJA.Qci);
          l = paramAnonymousInt;
          if (locald.RJC != null) {
            locald.RJC.vA(l);
          }
          AppMethodBeat.o(308875);
          return;
        }
      }
      
      public final void hcb() {}
    };
    this.mContext = paramActivity;
    this.timeLineObject = paramTimeLineObject;
    this.PNI = paramSnsInfo;
    this.PZr = paramc;
    this.PYh = paraml;
    paramTimeLineObject = null;
    paramActivity = paramTimeLineObject;
    switch (paramInt)
    {
    default: 
      paramActivity = paramTimeLineObject;
    }
    for (;;)
    {
      this.RJC = paramActivity;
      AppMethodBeat.o(308814);
      return;
      paramActivity = new com.tencent.mm.plugin.sns.ui.item.a.a.g();
      continue;
      paramActivity = new com.tencent.mm.plugin.sns.ui.item.a.a.c();
      continue;
      paramActivity = new e();
      continue;
      paramActivity = new com.tencent.mm.plugin.sns.ui.item.a.a.f();
      continue;
      paramActivity = new com.tencent.mm.plugin.sns.ui.item.a.a.a.a();
    }
  }
  
  public final void aWD(String paramString)
  {
    AppMethodBeat.i(308846);
    if (this.RJC != null) {
      this.RJC.hqZ();
    }
    AppMethodBeat.o(308846);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(308841);
    Log.i("MicroMsg.FullCardAdDetailItemNew", "onPause, hasPlayedVideo=" + this.RJw);
    this.mIsPaused = true;
    try
    {
      if ((this.RJw) && (this.RJA.Qcj != null) && (this.RJA.Qcj.RjN != null))
      {
        this.RJB.Dt(this.RJA.Qcx.QbW);
        if (this.RJC != null) {
          this.RJC.onVideoPause();
        }
        if ((this.PYh != null) && (this.PNI != null)) {
          this.PYh.uu(this.PNI.field_snsId);
        }
      }
      AppMethodBeat.o(308841);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.FullCardAdDetailItemNew", "onPause, exp=" + localException.toString());
      AppMethodBeat.o(308841);
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(308850);
    super.onUIDestroy();
    if (this.RJC != null) {
      this.RJC.onUIDestroy();
    }
    AppMethodBeat.o(308850);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(308833);
    Log.i("MicroMsg.FullCardAdDetailItemNew", "refreshView");
    this.PNI = com.tencent.mm.plugin.sns.storage.l.aZK(this.PNI.getSnsId());
    this.QbN = null;
    Object localObject1;
    if ((this.PNI != null) && (this.PNI.getAdXml() != null))
    {
      localObject1 = this.PNI.getAdXml();
      this.QbN = ((ADXml)localObject1).adFullCardInfo;
    }
    for (;;)
    {
      this.RJA.Qcx.QbW = com.tencent.mm.plugin.sns.ad.timeline.b.b.a.e((ADXml)localObject1);
      this.RJB.a(this.RJA, this.QbN, this.PNI, this.timeLineObject, this.mContext, this.PYh);
      com.tencent.mm.plugin.sns.ad.widget.adsocial.a.a(this.RJA, this.PNI, this.PZr, null);
      if ((this.RJA.Cxb instanceof AdRoundedCornerFrameLayout)) {
        ((AdRoundedCornerFrameLayout)this.RJA.Cxb).l(this.PNI, 2);
      }
      this.RJw = false;
      this.mIsPaused = false;
      localObject1 = (WindowManager)this.mContext.getSystemService("window");
      int i = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
      int j = this.mContext.getResources().getDimensionPixelSize(b.d.sns_avatar_size);
      int k = this.mContext.getResources().getDimensionPixelSize(b.d.Edge_0_5_A);
      int m = this.mContext.getResources().getDimensionPixelSize(b.d.NormalPadding);
      Object localObject2;
      com.tencent.mm.plugin.sns.model.g localg;
      if (this.QbN != null)
      {
        localObject2 = this.RJB.ajK(i - j - k - m - m);
        this.RJA.Qcj.a(this.timeLineObject, 0, this.PNI.getLocalid(), true);
        this.RJA.Qcj.QRC.setVisibility(8);
        localg = al.hgy();
        if ((this.timeLineObject.ContentObj != null) && (this.timeLineObject.ContentObj.Zpr.size() > 0))
        {
          localObject1 = (dmz)this.timeLineObject.ContentObj.Zpr.get(0);
          label365:
          if (localObject1 == null) {
            break label865;
          }
          if (this.RJA.Qck != null)
          {
            this.RJA.Qck.a(this.QbN.QHM, 2);
            if (this.RJA.Qck.ah(this.PNI)) {
              this.RJz = false;
            }
          }
          if (this.RJC != null)
          {
            if ((this.PYh != null) && (this.PNI != null))
            {
              localObject3 = t.uA(this.PNI.field_snsId);
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                this.PYh.a((String)localObject3, this);
              }
            }
            this.RJC.a(0, this.PNI, this.QbN, (ViewGroup.LayoutParams)localObject2);
          }
          Object localObject3 = new StringBuilder("refreshView, hash=").append(hashCode()).append(", snsId=");
          if (this.PNI != null) {
            break label721;
          }
          localObject2 = "";
          label528:
          Log.i("MicroMsg.FullCardAdDetailItemNew", localObject2 + ", useOnlineVideo=" + this.RJA.Qcx.QbW);
          this.RJB.a((dmz)localObject1, localg, 0, this.RJA.Qcx.QbW);
          if (this.timeLineObject.ContentObj.Zpq != 1) {
            break label736;
          }
          this.RJA.QbZ.setTag(this);
          this.RJA.QbZ.setOnClickListener(this.RJD);
          AppMethodBeat.o(308833);
        }
      }
      else
      {
        Log.e("MicroMsg.FullCardAdDetailItemNew", "invalid full card");
        if (this.PNI == null)
        {
          localObject1 = "";
          label649:
          if (this.PNI == null) {
            break label944;
          }
          if (!this.PNI.isFullCardAd()) {
            break label710;
          }
          i = 1;
          label668:
          localObject2 = this.PNI.getUxinfo();
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.Qnm, (String)localObject1, 0, i, (String)localObject2);
        localObject2 = null;
        break;
        localObject1 = t.uA(this.PNI.field_snsId);
        break label649;
        label710:
        i = 0;
        break label668;
        localObject1 = null;
        break label365;
        label721:
        localObject2 = Long.valueOf(this.PNI.field_snsId);
        break label528;
        label736:
        if ((this.timeLineObject.ContentObj.Zpq == 15) || (this.timeLineObject.ContentObj.Zpq == 5))
        {
          this.RJA.Qcj.RjL.setTag(this);
          this.RJA.Qcq.setTag(this);
          this.RJA.Qcj.RjL.setOnClickListener(this.RJD);
          this.RJA.Qcq.setOnClickListener(this.RJD);
          this.RJB.Dh(this.RJA.Qcx.QbW);
          if (this.RJC != null) {
            this.RJC.hqY();
          }
          this.RJw = true;
          AppMethodBeat.o(308833);
          return;
          label865:
          localg.a(this.RJA.Qcj.RjN, this.mContext.hashCode());
          this.RJA.Qcj.RjQ.setVisibility(8);
          this.RJA.Qcj.RjN.setVideoCallback(null);
          if (this.RJA.Qcr != null) {
            this.RJA.Qcr.setVideoCallback(null);
          }
        }
        AppMethodBeat.o(308833);
        return;
        label944:
        localObject2 = "";
        i = 0;
      }
      localObject1 = null;
    }
  }
  
  public final void t(View paramView1, View paramView2)
  {
    AppMethodBeat.i(308816);
    Log.i("MicroMsg.FullCardAdDetailItemNew", "initView");
    this.contentView = paramView1;
    this.RoA = paramView2;
    this.RJA = com.tencent.mm.plugin.sns.ad.timeline.b.b.a.jj(paramView1);
    this.RJA.Qcx.source = ((SnsCommentDetailUI)this.mContext).getSource();
    this.RJA.Qcx.QbX = this.RJC;
    this.RJA.Cxb = paramView1.findViewById(b.f.full_card_container);
    this.RJA.Qcs = this.Qcs;
    this.Qcj = this.RJA.Qcj;
    if (this.RJC != null) {
      this.RJC.a(this.mContext, this.PYh, this.PZr, this.RJA, this.RJB);
    }
    this.RJB.QbS = this.RJE;
    com.tencent.mm.plugin.sns.ad.timeline.b.b.a.a(this.RJA);
    AppMethodBeat.o(308816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.d
 * JD-Core Version:    0.7.0.1
 */