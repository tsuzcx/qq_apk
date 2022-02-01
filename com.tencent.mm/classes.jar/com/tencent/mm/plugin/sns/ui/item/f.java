package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.az;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.e;
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
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.LinkedList;

public class f
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ad.g.d, com.tencent.mm.plugin.sns.ui.video.a
{
  protected SnsInfo PJQ;
  private Handler PRJ;
  private ADXml.g QbN;
  protected com.tencent.mm.plugin.sns.ad.timeline.b.b.a RJB;
  protected com.tencent.mm.plugin.sns.ui.item.a.a.d RJC;
  private View.OnClickListener RJD;
  protected a.c RJE;
  protected a RMD;
  protected volatile boolean RME;
  private boolean RMF;
  protected int RMG;
  boolean RMH;
  
  public f()
  {
    AppMethodBeat.i(309020);
    this.PRJ = new Handler(Looper.getMainLooper());
    this.RME = false;
    this.RMF = false;
    this.RJB = new com.tencent.mm.plugin.sns.ad.timeline.b.b.a();
    this.RJD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(309032);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItemNew$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.FullCardAdTimeLineItemNew", "ProxyCardClickListener onClick");
        try
        {
          f.this.QBJ.QBf.RQG.onClick(paramAnonymousView);
          if (f.a(f.this)) {
            SnsAdCardVideoEndView.k(f.this.PJQ, 1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItemNew$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(309032);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            Log.e("MicroMsg.FullCardAdTimeLineItemNew", "ProxyCardClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.RMH = false;
    this.RJE = new a.c()
    {
      public final void Dw(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(309044);
        Log.i("MicroMsg.FullCardAdTimeLineItemNew", "onCompletion, isOnlineVideoView=" + paramAnonymousBoolean + ", hash=" + f.this.hashCode());
        if (f.this.b(f.d(f.this))) {
          f.this.RJB.Dv(paramAnonymousBoolean);
        }
        f localf = f.this;
        bn localbn = f.this.QBJ;
        long l = f.this.PJQ.field_snsId;
        ADXml.g localg = f.d(f.this);
        Log.i("MicroMsg.FullCardAdTimeLineItemNew", "doOnVideoCompletion, ret=0");
        if ((localbn == null) || (localbn.Ryp == null) || (localbn.Ryp.Rbv == null))
        {
          AppMethodBeat.o(309044);
          return;
        }
        localbn.Ryp.Rbv.S(l, false);
        MMHandlerThread.postToMainThread(new f.5(localf, localg));
        AppMethodBeat.o(309044);
      }
      
      public final void bC(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(309040);
        Log.i("MicroMsg.FullCardAdTimeLineItemNew", "onStart, isOnlineVideoView=" + paramAnonymousBoolean + ", duration=" + paramAnonymousInt + ", hash=" + f.this.hashCode());
        AppMethodBeat.o(309040);
      }
      
      public final void bD(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(309051);
        if (paramAnonymousBoolean) {}
        for (int i = f.this.RMD.RMK.Qcr.getDuration() / 1000;; i = f.this.RMD.RMK.Qcj.RjN.getDurationMs() / 1000)
        {
          f.a(f.this, f.this.PJQ.field_snsId, f.d(f.this), f.this.PJQ, paramAnonymousInt, i, paramAnonymousBoolean);
          AppMethodBeat.o(309051);
          return;
        }
      }
      
      public final void hcb()
      {
        AppMethodBeat.i(309035);
        f.c(f.this);
        AppMethodBeat.o(309035);
      }
    };
    AppMethodBeat.o(309020);
  }
  
  private void ae(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309030);
    if ((this.QBJ != null) && (this.QBJ.Ryp != null) && (this.QBJ.Ryp.Rbv != null) && (paramSnsInfo != null)) {
      this.QBJ.Ryp.Rbv.uu(paramSnsInfo.field_snsId);
    }
    AppMethodBeat.o(309030);
  }
  
  private void hcb()
  {
    AppMethodBeat.i(309025);
    if ((this.PJQ != null) && (this.PJQ.isBreakFrameAd())) {}
    for (int i = 1;; i = 0)
    {
      Log.d("MicroMsg.FullCardAdTimeLineItemNew", "try show play btn");
      if ((this.RMD != null) && (this.RMD.RMK.Qcj != null) && (!this.RME) && (!this.RMD.RMK.Qcx.QbV) && (i == 0))
      {
        Log.d("MicroMsg.FullCardAdTimeLineItemNew", "show play btn");
        this.RMD.RMK.Qcj.PQu.setVisibility(0);
        this.RMD.RMK.Qcj.RjP.setVisibility(8);
        this.RMD.RMK.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
        this.RMD.RMK.Qcj.PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
      }
      AppMethodBeat.o(309025);
      return;
    }
  }
  
  private boolean hqV()
  {
    AppMethodBeat.i(309021);
    if ((this.RMD.timeLineObject.ContentObj.Zpq == 5) || (this.RMD.timeLineObject.ContentObj.Zpq == 15))
    {
      Log.i("MicroMsg.FullCardAdTimeLineItemNew", "doPause, hash=" + hashCode());
      if ((this.RMD != null) && (this.RMD.RMK.Qcj != null))
      {
        this.RJB.Dt(this.RMD.RMK.Qcx.QbW);
        ae(this.PJQ);
        onVideoPause();
      }
      this.RME = false;
      AppMethodBeat.o(309021);
      return true;
    }
    AppMethodBeat.o(309021);
    return false;
  }
  
  private void onVideoPause()
  {
    AppMethodBeat.i(309034);
    if (this.RJC != null) {
      this.RJC.onVideoPause();
    }
    AppMethodBeat.o(309034);
  }
  
  public final void a(ADXml.g paramg)
  {
    AppMethodBeat.i(309116);
    for (;;)
    {
      try
      {
        if (this.RMD.RMK.Qck == null)
        {
          Log.i("MicroMsg.FullCardAdTimeLineItemNew", "checkShowEndView, videoEndView==null");
          AppMethodBeat.o(309116);
          return;
        }
        if ((paramg == null) || (paramg.QHM == null) || (!this.RME)) {
          break;
        }
        if (this.RMD.RMK.Qcx.QbW)
        {
          this.RMD.RMK.Qck.setBlurBkg(this.RMD.RMK.Qcr.getInnerVideoView());
          this.RMD.RMK.Qck.bYl();
          this.RMD.RMK.Qck.hsH();
          this.RMF = true;
          if (this.RMD.RMK.Qcx.QbW) {
            break label276;
          }
          this.RMD.Qcj.RjN.bJ(0, false);
          this.RJB.Du(this.RMD.RMK.Qcx.QbW);
          hqX();
          this.PRJ.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(309038);
              if ((f.this.mActivity != null) && (!f.this.mActivity.isFinishing()))
              {
                f.b(f.this);
                if (f.this.RME)
                {
                  f.this.RMD.RMK.Qck.gc(true);
                  f.this.RJB.Dv(f.this.RMD.RMK.Qcx.QbW);
                  AppMethodBeat.o(309038);
                }
              }
              else
              {
                Log.e("MicroMsg.FullCardAdTimeLineItemNew", "onCompletion, postDelayed-run activity isFinished");
              }
              AppMethodBeat.o(309038);
            }
          }, paramg.QHM.duration);
          AppMethodBeat.o(309116);
          return;
        }
      }
      catch (Exception paramg)
      {
        Log.e("MicroMsg.FullCardAdTimeLineItemNew", "handleVideoCompletion, exp" + paramg.toString());
        AppMethodBeat.o(309116);
        return;
      }
      this.RMD.RMK.Qck.setBlurBkg(this.RMD.RMK.Qcj.RjN.getInnerVideoView());
      continue;
      label276:
      if ((this.RMD.RMK.Qcr.getInnerVideoView() instanceof ThumbPlayerVideoView))
      {
        this.RMD.RMK.Qcr.bJ(0, false);
        this.RMD.RMK.Qcr.bck();
      }
    }
    this.RMD.RMK.Qck.gc(false);
    AppMethodBeat.o(309116);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(309086);
    if ((paramBaseViewHolder.timeLineObject.ContentObj.Zpq == 5) || (paramBaseViewHolder.timeLineObject.ContentObj.Zpq == 15))
    {
      Log.i("MicroMsg.FullCardAdTimeLineItemNew", "play: hash=" + hashCode() + ", pos=" + paramInt + ", isEndViewShow=" + this.RMF + ", isPlayingSight=" + this.RME);
      e.hsu().bck();
      com.tencent.mm.plugin.sns.ui.video.b.hsi().a(this);
      if ((!this.RMF) && ((paramBaseViewHolder instanceof a)))
      {
        a locala = (a)paramBaseViewHolder;
        this.RJB.Dh(locala.RMK.Qcx.QbW);
        if (this.RJC != null) {
          this.RJC.hqY();
        }
      }
      Log.d("MicroMsg.FullCardAdTimeLineItemNew", "try hide play btn");
      if ((this.RMD != null) && (this.RMD.RMK.Qcj != null))
      {
        Log.d("MicroMsg.FullCardAdTimeLineItemNew", "hide play btn");
        this.RMD.RMK.Qcj.PQu.setVisibility(8);
        this.RMD.RMK.Qcj.RjP.setVisibility(8);
      }
      this.RME = true;
      if ((paramBaseViewHolder instanceof a)) {
        ((a)paramBaseViewHolder).RMK.Qcx.QbV = false;
      }
      if ((!this.RMF) && (this.RMD.RMK.Qck != null) && (this.RMD.RMK.Qck.getVisibility() == 0)) {
        this.RMD.RMK.Qck.gc(true);
      }
    }
    AppMethodBeat.o(309086);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(309077);
    long l1 = System.currentTimeMillis();
    Log.i("MicroMsg.FullCardAdTimeLineItemNew", "ad fillItem, fullCardAd, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
    final a locala = (a)paramBaseViewHolder;
    if (locala.RMK.Qcx.mtE)
    {
      Log.i("MicroMsg.FullCardAdTimeLineItemNew", "holder is busy");
      AppMethodBeat.o(309077);
      return;
    }
    Object localObject3 = parambo.PJQ;
    this.PJQ = ((SnsInfo)localObject3);
    if (this.PJQ == null) {}
    Object localObject2;
    Object localObject1;
    for (String str = "";; str = t.uA(this.PJQ.field_snsId))
    {
      localObject2 = null;
      this.QbN = null;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((SnsInfo)localObject3).getAdXml() != null)
        {
          localObject1 = ((SnsInfo)localObject3).getAdXml();
          this.QbN = ((ADXml)localObject1).adFullCardInfo;
        }
      }
      locala.RMK.Qcx.QbW = e((ADXml)localObject1);
      Log.i("MicroMsg.FullCardAdTimeLineItemNew", "ad fillItem, useOnlineVideo=" + locala.RMK.Qcx.QbW);
      this.RJB.a(locala.RMK, this.QbN, (SnsInfo)localObject3, paramTimeLineObject, this.mActivity, parambn.Ryp.Rbv);
      localObject1 = locala.RMK;
      if ((((a.b)localObject1).Cxb instanceof AdRoundedCornerFrameLayout)) {
        ((AdRoundedCornerFrameLayout)((a.b)localObject1).Cxb).l(this.PJQ, 1);
      }
      com.tencent.mm.plugin.sns.ad.widget.adsocial.a.a((a.b)localObject1, (SnsInfo)localObject3, parambn.QBf, locala);
      ((a.b)localObject1).Qcj.RjN.setVideoCallback(null);
      if (((a.b)localObject1).Qcr != null) {
        ((a.b)localObject1).Qcr.setVideoCallback(null);
      }
      if (this.QbN == null) {
        break;
      }
      parambn = this.RJB.ajK(this.RMG);
      if (((a.b)localObject1).Qck != null)
      {
        ((a.b)localObject1).Qck.a(this.QbN.QHM, 1);
        if ((localObject3 != null) && (((a.b)localObject1).Qck.ah((SnsInfo)localObject3)))
        {
          this.PRJ.removeCallbacksAndMessages(null);
          this.RMF = false;
        }
      }
      localObject2 = ((SnsTimeLineUI)this.mActivity).hpK();
      if ((localObject2 != null) && (this.PJQ != null))
      {
        localObject3 = t.uA(this.PJQ.field_snsId);
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((com.tencent.mm.plugin.sns.ad.g.l)localObject2).a((String)localObject3, this);
        }
      }
      if (this.RJC != null) {
        this.RJC.a(paramInt1, this.PJQ, this.QbN, parambn);
      }
      localObject2 = al.hgy();
      if ((((a.b)localObject1).Qcj.RjK != null) && (!Util.isEqual(((a.b)localObject1).Qcj.RjK.Id, paramTimeLineObject.Id)))
      {
        Log.i("MicroMsg.FullCardAdTimeLineItemNew", "need clear sightView %s", new Object[] { ((a.b)localObject1).Qcj.RjK.Id });
        if (!locala.RMK.Qcx.QbW) {
          ((g)localObject2).a(((a.b)localObject1).Qcj.RjN, this.mActivity.hashCode());
        }
      }
      ((a.b)localObject1).Qcj.a(paramTimeLineObject, paramInt1, parambo.Rdg, parambo.Rbg);
      ((a.b)localObject1).Qcj.QRC.setVisibility(8);
      if ((paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.Zpr.size() <= 0)) {
        break label827;
      }
      parambn = (dmz)paramTimeLineObject.ContentObj.Zpr.get(0);
      label646:
      if (parambn == null) {
        break label909;
      }
      this.RJB.a(parambn, (g)localObject2, paramInt1, locala.RMK.Qcx.QbW);
      if (paramTimeLineObject.ContentObj.Zpq != 1) {
        break label833;
      }
      ((a.b)localObject1).QbZ.setTag(paramBaseViewHolder);
      ((a.b)localObject1).QbZ.setOnClickListener(this.RJD);
      label707:
      long l2 = System.currentTimeMillis();
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(309033);
          String str = com.tencent.mm.plugin.sns.data.l.QnC;
          if (locala.RMK.Qcx.QbW) {}
          for (int i = 1;; i = 2)
          {
            com.tencent.mm.plugin.sns.data.l.a(str, "1", i, 2, String.valueOf(this.IAg));
            AppMethodBeat.o(309033);
            return;
          }
        }
      });
      a(parambo, 3);
      AppMethodBeat.o(309077);
      return;
    }
    paramInt2 = 0;
    if (localObject3 != null) {
      if (((SnsInfo)localObject3).isFullCardAd()) {
        paramInt2 = 1;
      }
    }
    label782:
    for (parambn = ((SnsInfo)localObject3).getUxinfo();; parambn = "")
    {
      Log.e("MicroMsg.FullCardAdTimeLineItemNew", "invalid full card info, snsId=".concat(String.valueOf(str)));
      com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.Qnm, str, 1, paramInt2, parambn);
      break;
      paramInt2 = 0;
      break label782;
      label827:
      parambn = null;
      break label646;
      label833:
      if ((paramTimeLineObject.ContentObj.Zpq != 15) && (paramTimeLineObject.ContentObj.Zpq != 5)) {
        break label707;
      }
      ((a.b)localObject1).Qcj.RjL.setTag(paramBaseViewHolder);
      ((a.b)localObject1).Qcq.setTag(paramBaseViewHolder);
      ((a.b)localObject1).Qcj.RjL.setOnClickListener(this.RJD);
      ((a.b)localObject1).Qcq.setOnClickListener(this.RJD);
      break label707;
      if (locala.RMK.Qcx.QbW) {
        if (((a.b)localObject1).Qcr != null) {
          ((a.b)localObject1).Qcr.setVideoCallback(null);
        }
      }
      for (;;)
      {
        ((a.b)localObject1).Qcj.RjQ.setVisibility(8);
        Log.e("MicroMsg.FullCardAdTimeLineItemNew", "invalid full card media, snsId=".concat(String.valueOf(str)));
        break;
        ((g)localObject2).a(((a.b)localObject1).Qcj.RjN, this.mActivity.hashCode());
        ((a.b)localObject1).Qcj.RjN.setVideoCallback(null);
      }
    }
  }
  
  public final void aWD(String paramString)
  {
    AppMethodBeat.i(309135);
    if (this.RJC != null) {
      this.RJC.hqZ();
    }
    AppMethodBeat.o(309135);
  }
  
  protected final boolean b(ADXml.g paramg)
  {
    return (this.RME) && (paramg != null) && (paramg.QHM == null);
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(309063);
    long l1 = System.currentTimeMillis();
    this.RMD = ((a)paramBaseViewHolder);
    View localView = null;
    if (paramBaseViewHolder.RKG != null)
    {
      paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_timeline_ad_full_card_new);
      if (!paramBaseViewHolder.RKH)
      {
        localView = paramBaseViewHolder.RKG.inflate();
        paramBaseViewHolder.RKH = true;
      }
    }
    for (;;)
    {
      this.RMD.RMK = com.tencent.mm.plugin.sns.ad.timeline.b.b.a.jj(this.RMD.convertView);
      this.RMD.RMK.Cxb = localView;
      this.RMD.RMK.Qcx.source = 0;
      this.RMD.RMK.Qcs = this.RMD.Qcs;
      this.RMD.Qcj = this.RMD.RMK.Qcj;
      paramBaseViewHolder = (WindowManager)this.mActivity.getSystemService("window");
      this.RMG = (Math.min(paramBaseViewHolder.getDefaultDisplay().getWidth(), paramBaseViewHolder.getDefaultDisplay().getHeight()) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 56) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 14) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding));
      this.RJB.QbS = this.RJE;
      com.tencent.mm.plugin.sns.ad.timeline.b.b.a.a(this.RMD.RMK);
      if (this.RJC == null)
      {
        this.RJC = hqW();
        if (this.RJC != null)
        {
          paramBaseViewHolder = ((SnsTimeLineUI)this.mActivity).hpK();
          this.RJC.a(this.mActivity, paramBaseViewHolder, this.QBJ.Ryp.RbM, this.RMD.RMK, this.RJB);
        }
      }
      this.RMD.RMK.Qcx.QbX = this.RJC;
      long l2 = System.currentTimeMillis();
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(309027);
          com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.QnC, "1", 1, 1, String.valueOf(this.IAg));
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1697, 2);
          AppMethodBeat.o(309027);
        }
      });
      AppMethodBeat.o(309063);
      return;
      if (!paramBaseViewHolder.RKH)
      {
        localView = paramBaseViewHolder.convertView.findViewById(b.f.full_card_container);
        paramBaseViewHolder.RKH = true;
      }
    }
  }
  
  public boolean e(ADXml paramADXml)
  {
    AppMethodBeat.i(309124);
    boolean bool = com.tencent.mm.plugin.sns.ad.timeline.b.b.a.e(paramADXml);
    if (!this.RMH)
    {
      this.RMH = true;
      paramADXml = com.tencent.mm.plugin.report.service.h.OAn;
      if (!bool) {
        break label49;
      }
    }
    label49:
    for (int i = 4;; i = 3)
    {
      paramADXml.kJ(1697, i);
      AppMethodBeat.o(309124);
      return bool;
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(309110);
    if ((this.RMD != null) && (this.RMD.RMK.Cxb != null))
    {
      Object localObject = new int[2];
      this.RMD.RMK.Cxb.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.RMD.RMK.Cxb.getMeasuredWidth() + i, this.RMD.RMK.Cxb.getMeasuredHeight() + j);
      AppMethodBeat.o(309110);
      return localObject;
    }
    AppMethodBeat.o(309110);
    return null;
  }
  
  protected com.tencent.mm.plugin.sns.ui.item.a.a.d hqW()
  {
    return null;
  }
  
  protected void hqX() {}
  
  public final void onUIPause()
  {
    AppMethodBeat.i(309099);
    Log.i("MicroMsg.FullCardAdTimeLineItemNew", "onUIPause");
    hqV();
    AppMethodBeat.o(309099);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(309093);
    Log.i("MicroMsg.FullCardAdTimeLineItemNew", "pause");
    if (hqV()) {
      hcb();
    }
    AppMethodBeat.o(309093);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(309102);
    Log.i("MicroMsg.FullCardAdTimeLineItemNew", "stop, hash=" + hashCode());
    if ((this.RMD != null) && (this.RMD.RMK.Qcj != null))
    {
      if (!this.RMD.RMK.Qcx.QbW) {
        this.RMD.RMK.Qcj.RjN.clear();
      }
      if (this.RJC != null) {
        this.RJC.onUIDestroy();
      }
    }
    this.RME = false;
    AppMethodBeat.o(309102);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public a.b RMK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.f
 * JD-Core Version:    0.7.0.1
 */