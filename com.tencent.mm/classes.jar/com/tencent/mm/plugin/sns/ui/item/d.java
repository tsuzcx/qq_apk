package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.b.g;
import com.tencent.mm.plugin.sns.storage.b.g.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private p xHc;
  boolean zci;
  private View.OnClickListener zcp;
  private View.OnClickListener zcq;
  protected SnsAdTouchProgressView.a zcr;
  volatile boolean zeB;
  Handler zeV;
  a zeW;
  private au zeX;
  private boolean zeY;
  private boolean zeZ;
  boolean zfa;
  
  public d()
  {
    AppMethodBeat.i(176422);
    this.zeV = new Handler(Looper.getMainLooper());
    this.zeB = false;
    this.zci = false;
    this.zeY = false;
    this.zeZ = false;
    this.zfa = false;
    this.zcp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176421);
        ac.i("MicroMsg.FullCardAdTimeLineItem", "ProxyCardClickListener onClick");
        try
        {
          d.this.xZJ.xZe.zgZ.onClick(paramAnonymousView);
          if (d.c(d.this)) {
            SnsAdCardVideoEndView.h(d.d(d.this), 1);
          }
          AppMethodBeat.o(176421);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ac.e("MicroMsg.FullCardAdTimeLineItem", "ProxyCardClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.zcq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179368);
        ac.i("MicroMsg.FullCardAdTimeLineItem", "ProxySightClickListener onClick");
        try
        {
          d.this.xZJ.xZe.zgM.onClick(paramAnonymousView);
          if (d.c(d.this)) {
            SnsAdCardVideoEndView.h(d.d(d.this), 1);
          }
          AppMethodBeat.o(179368);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ac.e("MicroMsg.FullCardAdTimeLineItem", "mProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.zcr = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179359);
        try
        {
          ac.i("MicroMsg.FullCardAdTimeLineItem", "SnsAdTouchProgressView onClick");
          d.f(d.this).zbE.yFc.performClick();
          AppMethodBeat.o(179359);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          ac.e("MicroMsg.FullCardAdTimeLineItem", "SnsAdTouchProgressView onClick exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(179359);
        }
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179360);
        d.this.xZJ.ySd.yyg.i(d.f(d.this));
        q.d(new long[] { 20L, 100L });
        c.a(d.this.mActivity, d.f(d.this).yGK, d.d(d.this), 1);
        if (d.d(d.this) != null)
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(1, 1, q.atd(d.d(d.this).dLV().Id), 28, 21);
          if ((d.this.mActivity instanceof SnsTimeLineUI)) {
            com.tencent.mm.plugin.sns.data.j.a(localSnsAdClick, ((SnsTimeLineUI)d.this.mActivity).dQE(), d.d(d.this), 28);
          }
          q.a(localSnsAdClick);
          ac.i("MicroMsg.FullCardAdTimeLineItem", "onFinish report MMOCAD_CLICKPOS_AD_FULL_CARD_LONGPRESS");
          AppMethodBeat.o(179360);
          return;
        }
        ac.e("MicroMsg.FullCardAdTimeLineItem", "onFinish report, mSnsinfo==null");
        AppMethodBeat.o(179360);
      }
      
      public final void onStart() {}
    };
    AppMethodBeat.o(176422);
  }
  
  private void S(p paramp)
  {
    AppMethodBeat.i(200659);
    if ((this.xZJ != null) && (this.xZJ.ySd != null) && (this.xZJ.ySd.yxP != null) && (paramp != null)) {
      this.xZJ.ySd.yxP.wQ(paramp.field_snsId);
    }
    AppMethodBeat.o(200659);
  }
  
  private boolean dRL()
  {
    AppMethodBeat.i(177695);
    if ((this.zeW.timeLineObject.FQo.Ety == 5) || (this.zeW.timeLineObject.FQo.Ety == 15))
    {
      ac.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd doPause", new Object[] { this });
      if ((this.zeW != null) && (this.zeW.zbE != null))
      {
        if (!this.zfa) {
          break label133;
        }
        this.zeW.zbE.yFe.pause();
        this.zeW.zbE.yFe.setShouldPlayWhenPrepared(false);
        this.zeX.dPg();
      }
      for (;;)
      {
        S(this.xHc);
        this.zeB = false;
        AppMethodBeat.o(177695);
        return true;
        label133:
        this.zeW.zbE.yFd.pause();
      }
    }
    AppMethodBeat.o(177695);
    return false;
  }
  
  private void dRM()
  {
    AppMethodBeat.i(176427);
    ac.i("MicroMsg.FullCardAdTimeLineItem", "try show play btn");
    if ((this.zeW != null) && (this.zeW.zbE != null) && (!this.zeB))
    {
      ac.i("MicroMsg.FullCardAdTimeLineItem", "show play btn");
      this.zeW.zbE.yoI.setVisibility(0);
      this.zeW.zbE.yFg.setVisibility(8);
      this.zeW.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
      this.zeW.zbE.yoI.setContentDescription(this.mActivity.getString(2131761939));
    }
    AppMethodBeat.o(176427);
  }
  
  protected final void a(be parambe, com.tencent.mm.plugin.sns.ui.bf parambf, final b.g paramg, int paramInt)
  {
    AppMethodBeat.i(179370);
    ac.i("MicroMsg.FullCardAdTimeLineItem", "doOnVideoCompletion, ret=".concat(String.valueOf(paramInt)));
    if (paramInt != -1)
    {
      if ((parambe == null) || (parambe.ySd == null) || (parambe.ySd.yxP == null))
      {
        AppMethodBeat.o(179370);
        return;
      }
      parambe.ySd.yxP.A(parambf.yUS, false);
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179361);
        d locald = d.this;
        b.g localg = paramg;
        if (localg != null) {
          for (;;)
          {
            try
            {
              if ((localg.yhg == null) || (!locald.zeB)) {
                break;
              }
              if (locald.zfa)
              {
                locald.zeW.zch.setBlurBkg(locald.zeW.zbE.yFe.getInnerVideoView());
                locald.zeW.zch.aQP();
                locald.zeW.zch.dSy();
                locald.zci = true;
                if (locald.zfa)
                {
                  locald.zeW.zbE.yFe.setShouldPlayWhenPrepared(false);
                  locald.zeW.zbE.yFe.pause();
                  locald.a(locald.zeW);
                  locald.zeV.postDelayed(new d.11(locald), localg.yhg.duration);
                  AppMethodBeat.o(179361);
                }
              }
              else
              {
                locald.zeW.zch.setBlurBkg(locald.zeW.yGK);
                continue;
              }
              localException.zeW.zbE.yFd.pause();
            }
            catch (Exception localException)
            {
              ac.e("MicroMsg.FullCardAdTimeLineItem", "handleVideoCompletion, exp" + localException.toString());
              AppMethodBeat.o(179361);
              return;
            }
          }
        }
        localException.zeW.zch.dT(false);
        AppMethodBeat.o(179361);
      }
    });
    AppMethodBeat.o(179370);
  }
  
  protected final void a(final com.tencent.mm.plugin.sns.ui.bf parambf, b.g paramg, final p paramp, long paramLong, int paramInt)
  {
    AppMethodBeat.i(179371);
    if ((this.xZJ == null) || (this.xZJ.ySd == null) || (this.xZJ.ySd.yxP == null))
    {
      AppMethodBeat.o(179371);
      return;
    }
    if (((paramg == null) || (paramg.yhg == null)) && (this.zeW.zch.getVisibility() == 0)) {
      this.zeW.zch.dT(false);
    }
    if (paramp != null)
    {
      this.xZJ.ySd.yxP.wP(paramp.field_snsId);
      this.xZJ.ySd.yxP.ah(paramp.field_snsId, 1000L * paramLong);
    }
    if (!this.xZJ.ySd.yxP.wM(parambf.yUS))
    {
      this.xZJ.ySd.yxP.d(parambf.yUS, bs.Gn(), false);
      this.xZJ.ySd.yxP.e(parambf.yUS, paramInt, false);
      this.xZJ.ySd.yxP.ag(parambf.yUS, parambf.yUS);
    }
    ac.d("MicroMsg.FullCardAdTimeLineItem", "doOnVideoPlaying, currentTime=" + paramLong + ", duration=" + paramInt);
    paramInt = (int)paramLong;
    parambf = this.zeW;
    int i = paramInt * 1000;
    final b.g.a locala = paramg.yhb;
    if ((!bs.isNullOrNil(paramp.dFR().dJT())) && (locala != null) && (locala.startTime >= 0L) && (locala.endTime > locala.startTime))
    {
      ac.i("MicroMsg.FullCardAdTimeLineItem", "%d-%d,%d", new Object[] { Long.valueOf(locala.startTime), Long.valueOf(locala.endTime), Integer.valueOf(i) });
      if ((locala.startTime > i) || (locala.endTime < i)) {
        break label426;
      }
      if (a.b(parambf).getOnGestureListener() == null) {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100080);
            d.a.b(parambf).setVisibility(0);
            d.a.b(parambf).dSK();
            d.a.b(parambf).setPaintColor(locala.color);
            d.a.b(parambf).setOnGestureListener(new SnsDrawGestureView.a()
            {
              public final void dRJ()
              {
                AppMethodBeat.i(179364);
                q.qH(false);
                d.a.b(d.7.this.zfc).setBackgroundColor(d.this.mActivity.getResources().getColor(2131100894));
                AppMethodBeat.o(179364);
              }
              
              public final void fR(List<PointF> paramAnonymous2List)
              {
                int i = 1;
                AppMethodBeat.i(179365);
                q.qH(true);
                Object localObject = q.atf(d.7.this.zcx.yhj);
                d.a.b(d.7.this.zfc).setBackgroundColor(0);
                if ((((List)localObject).size() > 0) && (paramAnonymous2List.size() > 0)) {
                  try
                  {
                    double d1 = com.tencent.mm.ui.tools.a.a.H((List)localObject, paramAnonymous2List);
                    String str = q.ft((List)localObject);
                    Collections.reverse((List)localObject);
                    double d2 = com.tencent.mm.ui.tools.a.a.H((List)localObject, paramAnonymous2List);
                    float f = (float)Math.min(d1, d2);
                    ac.i("MicroMsg.FullCardAdTimeLineItem", "similarity: %f,%f, distance:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Float.valueOf(f) });
                    if (f <= d.7.this.zcx.yhi)
                    {
                      d.this.xZJ.ySd.yyg.i(d.7.this.zfc);
                      q.d(new long[] { 20L, 100L });
                      c.a(d.this.mActivity, d.7.this.zfc.yGK, d.7.this.yyo, 1);
                      localObject = new SnsAdClick(1, 1, q.atd(d.7.this.yyo.dLV().Id), 25, 21);
                      if ((d.this.mActivity instanceof SnsTimeLineUI)) {
                        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject, ((SnsTimeLineUI)d.this.mActivity).dQE(), d.7.this.yyo, 25);
                      }
                      q.a((SnsAdClick)localObject);
                      i = 2;
                    }
                    h.wUl.f(16552, new Object[] { d.7.this.yyo.dLV().Id, str, q.ft(com.tencent.mm.ui.tools.a.a.iw(paramAnonymous2List)), Integer.valueOf((int)(100.0F * f)), Integer.valueOf(i), Long.valueOf(bs.aLz(d.7.this.yyo.dMz())), d.7.this.yyo.dFQ().dtx });
                    c.a(i, f, d.7.this.zcx.yhi, d.7.this.yyo.dFQ().dtx, d.7.this.yyo.dLV().Id, 1);
                    return;
                  }
                  catch (Exception paramAnonymous2List)
                  {
                    ac.printErrStackTrace("MicroMsg.FullCardAdTimeLineItem", paramAnonymous2List, "recog gesture error!", new Object[0]);
                    return;
                  }
                  finally
                  {
                    d.a.b(d.7.this.zfc).dSK();
                    AppMethodBeat.o(179365);
                  }
                }
                AppMethodBeat.o(179365);
              }
              
              public final void onClick()
              {
                AppMethodBeat.i(179366);
                q.qH(true);
                d.a.b(d.7.this.zfc).setBackgroundColor(0);
                d.7.this.zfc.zbE.yFc.performClick();
                AppMethodBeat.o(179366);
              }
            });
            AppMethodBeat.o(100080);
          }
        });
      }
    }
    for (;;)
    {
      c.a(paramg, paramInt * 1000, this.zeW.zcf, this.zeW.zcg);
      AppMethodBeat.o(179371);
      return;
      label426:
      a(parambf);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176423);
    if ((paramBaseViewHolder.timeLineObject.FQo.Ety == 5) || (paramBaseViewHolder.timeLineObject.FQo.Ety == 15))
    {
      ac.i("MicroMsg.FullCardAdTimeLineItem", "play: hash=" + hashCode() + ", pos=" + paramInt + ", isEndViewShow=" + this.zci + ", isPlayingSight=" + this.zeB);
      com.tencent.mm.plugin.sns.ui.video.d.dSq().crK();
      com.tencent.mm.plugin.sns.ui.video.b.dSj().a(this);
      if (!this.zci)
      {
        if (!this.zfa) {
          break label265;
        }
        paramBaseViewHolder.zbE.yFe.setShouldPlayWhenPrepared(true);
        paramBaseViewHolder.zbE.yFe.start();
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.FullCardAdTimeLineItem", "try hide play btn");
      if ((this.zeW != null) && (this.zeW.zbE != null))
      {
        ac.i("MicroMsg.FullCardAdTimeLineItem", "hide play btn");
        this.zeW.zbE.yoI.setVisibility(8);
        this.zeW.zbE.yFg.setVisibility(8);
      }
      this.zeB = true;
      if ((paramBaseViewHolder instanceof a)) {
        ((a)paramBaseViewHolder).zeO = false;
      }
      if ((!this.zci) && (this.zeW.zch.getVisibility() == 0)) {
        this.zeW.zch.dT(true);
      }
      AppMethodBeat.o(176423);
      return;
      label265:
      paramBaseViewHolder.zbE.yFd.start();
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final com.tencent.mm.plugin.sns.ui.bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, final be parambe)
  {
    AppMethodBeat.i(100082);
    ac.i("MicroMsg.FullCardAdTimeLineItem", "fillItem, hash=" + hashCode() + ", pos=" + paramInt1 + ", objId=" + paramTimeLineObject.Id);
    if (paramBaseViewHolder.fYC)
    {
      ac.i("MicroMsg.FullCardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(100082);
      return;
    }
    final a locala = (a)paramBaseViewHolder;
    final p localp = parambf.xHc;
    this.xHc = localp;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (localp != null)
    {
      localObject2 = localObject1;
      if (localp.dFR() != null) {
        localObject2 = localp.dFR().ygn;
      }
    }
    localObject1 = (WindowManager)this.mActivity.getSystemService("window");
    paramInt2 = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    localObject1 = null;
    locala.rXY.setVisibility(8);
    locala.zbX.setVisibility(8);
    locala.zbY.setVisibility(8);
    locala.zbW.setVisibility(8);
    locala.zbZ.setVisibility(8);
    locala.zca.setVisibility(8);
    locala.zcb.setVisibility(8);
    a.b(locala).setVisibility(8);
    locala.zcj.setVisibility(8);
    locala.zck.setVisibility(8);
    locala.zbE.yFd.setOnCompletionListener(null);
    locala.zbE.yFd.setOnDecodeDurationListener(null);
    locala.zbE.yFe.setVideoCallback(null);
    a(locala);
    Object localObject3;
    boolean bool;
    label478:
    int i;
    label501:
    Object localObject4;
    if (localObject2 != null)
    {
      locala.zch.a(((b.g)localObject2).yhg, 1);
      if ((localp != null) && (locala.zch.T(localp)))
      {
        this.zeV.removeCallbacksAndMessages(null);
        this.zci = false;
      }
      localObject3 = locala.zbE.yFd;
      if (((b.g)localObject2).yhg != null)
      {
        bool = true;
        ((VideoSightView)localObject3).setIsForbidLoopAnim(bool);
        paramInt2 = paramInt2 - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
        if (((b.g)localObject2).ygY != 0) {
          break label1601;
        }
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
        i = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 54);
        if (localObject1 == null) {
          break label1643;
        }
        paramInt2 = ((ViewGroup.LayoutParams)localObject1).height;
        this.zeZ = this.zeX.a(this.xHc, ((b.g)localObject2).yhh, paramInt2 + i);
        if ((!this.zeY) && (!this.zeZ)) {
          break label1649;
        }
        bool = true;
        label543:
        this.zfa = bool;
        locala.zbE.yFl = this.zfa;
        localObject4 = new StringBuilder("fillItem, isExptUseNewPlayer=").append(this.zeY).append(", isLongPressGestureAd=").append(this.zeZ).append(", hash=").append(hashCode()).append(", snsId=");
        if (localp != null) {
          break label1655;
        }
        localObject3 = "";
        label622:
        ac.i("MicroMsg.FullCardAdTimeLineItem", localObject3);
        if (localObject1 != null)
        {
          localObject3 = locala.yGK.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.yGK.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((RoundedCornerFrameLayout)locala.yGK).setRadius(com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 8));
          localObject3 = locala.zcc.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.zcc.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = locala.zbE.yFc.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.zbE.yFc.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          locala.zbE.yFd.hf(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
          localObject3 = locala.zbE.yFe.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.zbE.yFe.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = locala.zcf.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.zcf.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = locala.zcg.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.zcg.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = locala.zch.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.zch.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
        if (((b.g)localObject2).yha != 0) {
          break label1668;
        }
        paramInt2 = Color.argb((int)(((b.g)localObject2).ygZ * 2.55F), 0, 0, 0);
        i = Color.argb(0, 0, 0, 0);
        localObject1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt2, i });
        ((GradientDrawable)localObject1).setGradientType(0);
        locala.rXY.setBackground((Drawable)localObject1);
        if ((!bs.isNullOrNil(((b.g)localObject2).title)) || (!bs.isNullOrNil(((b.g)localObject2).description))) {
          locala.rXY.setVisibility(0);
        }
        if (!bs.isNullOrNil(((b.g)localObject2).title))
        {
          locala.zbX.setVisibility(0);
          localObject1 = locala.zbX;
          localObject3 = g.eXw();
          locala.zbX.getContext();
          ((TextView)localObject1).setText(((g)localObject3).b(((b.g)localObject2).title, locala.zbX.getTextSize()));
        }
        if (!bs.isNullOrNil(((b.g)localObject2).description))
        {
          locala.zbY.setVisibility(0);
          localObject1 = locala.zbY;
          localObject3 = g.eXw();
          locala.zbY.getContext();
          ((TextView)localObject1).setText(((g)localObject3).b(((b.g)localObject2).description, locala.zbY.getTextSize()));
        }
        label1212:
        if (localp.dFQ().dJC())
        {
          paramInt2 = Color.argb((int)(((b.g)localObject2).ygZ * 2.55F), 0, 0, 0);
          i = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
          ((GradientDrawable)localObject1).setGradientType(0);
          locala.zbW.setVisibility(0);
          locala.zbW.setBackground((Drawable)localObject1);
          locala.zcb.setVisibility(0);
        }
        if ((paramTimeLineObject.FQo == null) || (paramTimeLineObject.FQo.Etz.size() <= 0)) {
          break label1999;
        }
      }
    }
    label1601:
    label1999:
    for (localObject1 = (btz)paramTimeLineObject.FQo.Etz.get(0);; localObject1 = null)
    {
      localObject3 = af.dHO();
      if ((paramBaseViewHolder.zbE.yFb != null) && (!bs.lr(paramBaseViewHolder.zbE.yFb.Id, paramTimeLineObject.Id)))
      {
        ac.i("MicroMsg.FullCardAdTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.zbE.yFb.Id });
        ((f)localObject3).a(paramBaseViewHolder.zbE.yFd, this.mActivity.hashCode(), paramInt1);
        ((f)localObject3).a(paramBaseViewHolder.zbE.yFe, this.mActivity.hashCode());
      }
      paramBaseViewHolder.zbE.a(paramTimeLineObject, paramInt1, parambf.yzm, parambf.yxA);
      paramBaseViewHolder.zbE.yoJ.setVisibility(8);
      if (localObject1 == null) {
        break label3207;
      }
      if (paramTimeLineObject.FQo.Ety != 1) {
        break label2005;
      }
      locala.zcc.setVisibility(0);
      locala.zbE.yFc.setVisibility(4);
      parambf = locala.zcc;
      paramInt1 = this.mActivity.hashCode();
      parambe = com.tencent.mm.storage.bf.fbk();
      parambe.gIh = paramTimeLineObject.CreateTime;
      ((f)localObject3).b((btz)localObject1, parambf, -1, paramInt1, parambe);
      locala.zcc.setTag(paramBaseViewHolder);
      locala.zcc.setOnClickListener(this.zcp);
      locala.zeO = false;
      AppMethodBeat.o(100082);
      return;
      bool = false;
      break;
      if (((b.g)localObject2).ygY != 1) {
        break label478;
      }
      localObject1 = new ViewGroup.LayoutParams(-2, -2);
      ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
      ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
      break label478;
      label1643:
      paramInt2 = 0;
      break label501;
      label1649:
      bool = false;
      break label543;
      label1655:
      localObject3 = Long.valueOf(localp.field_snsId);
      break label622;
      if (((b.g)localObject2).yha != 1) {
        break label1212;
      }
      paramInt2 = Color.argb((int)(((b.g)localObject2).ygZ * 2.55F), 0, 0, 0);
      i = Color.argb(0, 0, 0, 0);
      localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
      ((GradientDrawable)localObject1).setGradientType(0);
      locala.zbW.setBackground((Drawable)localObject1);
      if ((!bs.isNullOrNil(((b.g)localObject2).title)) || (!bs.isNullOrNil(((b.g)localObject2).description)))
      {
        locala.zbW.setVisibility(0);
        localObject1 = (RelativeLayout.LayoutParams)locala.zcb.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cc.a.fromDPToPix(locala.yGK.getContext(), 4);
        locala.zcb.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (!bs.isNullOrNil(((b.g)localObject2).title))
      {
        locala.zbZ.setVisibility(0);
        localObject1 = locala.zbZ;
        localObject3 = g.eXw();
        locala.zbZ.getContext();
        ((TextView)localObject1).setText(((g)localObject3).b(((b.g)localObject2).title, locala.zbZ.getTextSize()));
      }
      if (bs.isNullOrNil(((b.g)localObject2).description)) {
        break label1212;
      }
      locala.zca.setVisibility(0);
      localObject1 = locala.zca;
      localObject3 = g.eXw();
      locala.zca.getContext();
      ((TextView)localObject1).setText(((g)localObject3).b(((b.g)localObject2).description, locala.zca.getTextSize()));
      break label1212;
      ac.e("MicroMsg.FullCardAdTimeLineItem", "invalid full card");
      if (this.xHc == null) {}
      for (localObject1 = "";; localObject1 = q.wW(this.xHc.field_snsId))
      {
        com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.xNe, (String)localObject1, 1, 0, "");
        break;
      }
    }
    label1668:
    label2005:
    if ((paramTimeLineObject.FQo.Ety == 15) || (paramTimeLineObject.FQo.Ety == 5))
    {
      if (this.zfa)
      {
        locala.zbE.yFe.setVisibility(0);
        locala.zbE.yFd.setVisibility(8);
        locala.zbE.yFe.setVideoCallback(new OfflineVideoView.a()
        {
          public final boolean a(PString paramAnonymousPString)
          {
            AppMethodBeat.i(179355);
            ac.i("MicroMsg.FullCardAdTimeLineItem", "downloadVideo");
            AppMethodBeat.o(179355);
            return false;
          }
          
          public final void onCompletion()
          {
            AppMethodBeat.i(179357);
            ac.i("MicroMsg.FullCardAdTimeLineItem", "onCompletion");
            boolean bool = d.a(d.this).dPf();
            if ((d.b(d.this)) && (this.zfb.yhg == null) && (!bool)) {
              locala.zbE.yFe.restart();
            }
            d.this.a(parambe, parambf, this.zfb, 0);
            AppMethodBeat.o(179357);
          }
          
          public final void onStart(int paramAnonymousInt)
          {
            AppMethodBeat.i(179356);
            ac.i("MicroMsg.FullCardAdTimeLineItem", "onStart:".concat(String.valueOf(paramAnonymousInt)));
            AppMethodBeat.o(179356);
          }
          
          public final void sQ(int paramAnonymousInt)
          {
            AppMethodBeat.i(179358);
            int i = paramAnonymousInt / 1000;
            d.this.a(parambf, this.zfb, localp, i, locala.zbE.yFe.getDurationMs() / 1000);
            Object localObject2 = null;
            Object localObject1 = localObject2;
            if (parambe != null)
            {
              localObject1 = localObject2;
              if (parambe.ySd != null) {
                localObject1 = parambe.ySd.yxP;
              }
            }
            d.a(d.this).a((com.tencent.mm.plugin.sns.ad.d.i)localObject1, paramAnonymousInt, parambf.yUS);
            AppMethodBeat.o(179358);
          }
        });
        c.i(((b.g)localObject2).yhc, locala.zcf);
        c.i(((b.g)localObject2).yhe, locala.zcg);
        localObject4 = ((b.g)localObject2).yhb;
        final String str = localp.dFR().dJT();
        if ((!bs.isNullOrNil(str)) && (localObject4 != null) && (((b.g.a)localObject4).startTime >= 0L) && (((b.g.a)localObject4).endTime > ((b.g.a)localObject4).startTime)) {
          com.tencent.mm.sdk.g.b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100079);
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.dLO().f("adId", str, "adxml", 0);
              AppMethodBeat.o(100079);
            }
          }, "preDownloadFloatPage");
        }
        long l = System.nanoTime();
        bool = f.t((btz)localObject1);
        ac.i("MicroMsg.FullCardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
        localObject4 = locala.zbE;
        if (bool) {
          break label2769;
        }
        if (!((f)localObject3).w((btz)localObject1)) {
          break label2593;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFg.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFg.fuE();
        label2279:
        locala.zbE.yFc.setVisibility(0);
        locala.zcc.setVisibility(4);
        ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFd.setTagObject(localObject4);
        ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFe.setTag(localObject4);
        ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFf.setTag(paramBaseViewHolder);
        locala.zbE.yFc.setOnClickListener(this.zcp);
        if (!this.zfa) {
          break label3128;
        }
        paramBaseViewHolder = ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFe;
        paramInt1 = this.mActivity.hashCode();
        localObject4 = com.tencent.mm.storage.bf.fbk();
        ((com.tencent.mm.storage.bf)localObject4).gIh = paramTimeLineObject.CreateTime;
        ((f)localObject3).a(localp, (btz)localObject1, paramBaseViewHolder, paramInt1, (com.tencent.mm.storage.bf)localObject4, parambf.yxA);
        label2398:
        c.a((b.g)localObject2, 0, locala.zcf, locala.zcg);
        paramBaseViewHolder = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), ((btz)localObject1).Id);
        paramTimeLineObject = q.i((btz)localObject1);
        if (!com.tencent.mm.vfs.i.eA(paramBaseViewHolder + paramTimeLineObject)) {
          break label3182;
        }
        parambe.ySd.yxP.B(parambf.yUS, true);
        if (af.dHO().b(localp, null) != 5) {
          break label3201;
        }
      }
      for (bool = true;; bool = false)
      {
        parambe.ySd.yxP.c(parambf.yUS, bool, false);
        AppMethodBeat.o(100082);
        return;
        locala.zbE.yFe.setVisibility(8);
        locala.zbE.yFd.setVisibility(0);
        locala.zbE.yFd.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(179362);
            StringBuilder localStringBuilder = new StringBuilder("sight play completed, retCode=").append(paramAnonymousInt).append(", snsId=");
            if (localp == null) {}
            for (paramAnonymousb = "";; paramAnonymousb = Long.valueOf(localp.field_snsId))
            {
              ac.i("MicroMsg.FullCardAdTimeLineItem", paramAnonymousb);
              d.this.a(parambe, parambf, this.zfb, paramAnonymousInt);
              AppMethodBeat.o(179362);
              return;
            }
          }
        });
        locala.zbE.yFd.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(179363);
            ac.d("MicroMsg.FullCardAdTimeLineItem", "sight play %d", new Object[] { Long.valueOf(paramAnonymousLong) });
            d.this.a(parambf, this.zfb, localp, paramAnonymousLong, (int)paramAnonymousb.dED());
            AppMethodBeat.o(179363);
          }
        });
        break;
        if (((f)localObject3).b(localp, null) == 5)
        {
          ((f)localObject3).A((btz)localObject1);
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFg.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFg.fuE();
          break label2279;
        }
        if (((f)localObject3).x((btz)localObject1))
        {
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFg.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setImageResource(2131234034);
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setVisibility(0);
          break label2279;
        }
        ((f)localObject3).y((btz)localObject1);
        ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFg.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setContentDescription(this.mActivity.getString(2131761939));
        if (((f)localObject3).b(localp, null) != 4) {
          break label2279;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoJ.setVisibility(0);
        break label2279;
        if (((f)localObject3).u((btz)localObject1))
        {
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFg.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setContentDescription(this.mActivity.getString(2131761939));
          if (!this.zfa) {
            break label3112;
          }
        }
        for (bool = ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFe.isError();; bool = ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFd.xDG.dEA())
        {
          if (!bool) {
            break label3126;
          }
          ac.e("MicroMsg.FullCardAdTimeLineItem", "play video error " + ((btz)localObject1).Id + " " + ((btz)localObject1).Url + " " + ((btz)localObject1).Fjh + " " + paramInt1);
          ((f)localObject3).y((btz)localObject1);
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFg.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setContentDescription(this.mActivity.getString(2131761939));
          break;
          if (((f)localObject3).v((btz)localObject1))
          {
            ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFg.setVisibility(8);
            break label2832;
          }
          if (((f)localObject3).b(localp, null) <= 5)
          {
            if (locala.zeO) {
              break label2832;
            }
            ac.i("MicroMsg.FullCardAdTimeLineItem", "fillItem, showPlayBtn");
            dRM();
            break label2832;
          }
          ((f)localObject3).y((btz)localObject1);
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFg.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
          ((com.tencent.mm.plugin.sns.ui.an)localObject4).yoI.setContentDescription(this.mActivity.getString(2131761939));
          break label2832;
        }
        break label2279;
        paramBaseViewHolder = ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFd;
        paramInt2 = this.mActivity.hashCode();
        localObject4 = com.tencent.mm.storage.bf.fbk();
        ((com.tencent.mm.storage.bf)localObject4).gIh = paramTimeLineObject.CreateTime;
        ((f)localObject3).a(localp, (btz)localObject1, paramBaseViewHolder, paramInt2, paramInt1, (com.tencent.mm.storage.bf)localObject4, parambf.yxA, true);
        break label2398;
        label3182:
        parambe.ySd.yxP.B(parambf.yUS, false);
        break label2474;
      }
      ((f)localObject3).a(paramBaseViewHolder.zbE.yFd, this.mActivity.hashCode(), paramInt1);
      ((f)localObject3).a(paramBaseViewHolder.zbE.yFe, this.mActivity.hashCode());
      paramBaseViewHolder.zbE.yFh.setVisibility(8);
      paramBaseViewHolder.zbE.yFd.setOnSightCompletionAction(null);
      paramBaseViewHolder.zbE.yFd.setOnCompletionListener(null);
      paramBaseViewHolder.zbE.yFd.setOnDecodeDurationListener(null);
      paramBaseViewHolder.zbE.yFe.setVideoCallback(null);
    }
    label2474:
    label2769:
    AppMethodBeat.o(100082);
    label2593:
    label3112:
    label3126:
    label3128:
    return;
  }
  
  final void a(final a parama)
  {
    AppMethodBeat.i(100083);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179367);
        d.a.b(parama).setVisibility(8);
        d.a.b(parama).setBackgroundColor(0);
        d.a.b(parama).dSK();
        d.a.b(parama).setOnGestureListener(null);
        AppMethodBeat.o(179367);
      }
    });
    AppMethodBeat.o(100083);
  }
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100081);
    this.zeW = ((a)paramBaseViewHolder);
    if (paramBaseViewHolder.zdm != null)
    {
      paramBaseViewHolder.zdm.setLayoutResource(2131495603);
      if (!paramBaseViewHolder.zdn)
      {
        this.zeW.yGK = paramBaseViewHolder.zdm.inflate();
        paramBaseViewHolder.zdn = true;
      }
      this.zeW.rXY = this.zeW.sSS.findViewById(2131306008);
      this.zeW.zbW = this.zeW.sSS.findViewById(2131297449);
      this.zeW.zbX = ((TextView)this.zeW.sSS.findViewById(2131306010));
      this.zeW.zbY = ((TextView)this.zeW.sSS.findViewById(2131306009));
      this.zeW.zbZ = ((TextView)this.zeW.sSS.findViewById(2131297451));
      this.zeW.zca = ((TextView)this.zeW.sSS.findViewById(2131297450));
      this.zeW.zcc = ((MaskImageView)this.zeW.sSS.findViewById(2131300322));
      this.zeW.zcb = this.zeW.sSS.findViewById(2131297455);
      this.zeW.zcc.setScaleType(QImageView.a.JbU);
      this.zeW.zbE = new com.tencent.mm.plugin.sns.ui.an();
      this.zeW.zbE.yFf = this.zeW.yGK.findViewById(2131300324);
      this.zeW.zbE.yFc = this.zeW.zbE.yFf;
      this.zeW.zbE.yFf.setOnClickListener(this.zcq);
      this.zeW.zbE.yFd = ((VideoSightView)this.zeW.zbE.yFf.findViewById(2131300914));
      this.zeW.zbE.yFe = ((SnsAdTimelineVideoView)this.zeW.zbE.yFf.findViewById(2131302995));
      paramBaseViewHolder.zbE.yFd.setMute(true);
      paramBaseViewHolder.zbE.yFe.setMute(true);
      this.zeW.zbE.yoI = ((ImageView)this.zeW.yGK.findViewById(2131300323));
      this.zeW.zbE.yFg = ((MMPinProgressBtn)this.zeW.zbE.yFf.findViewById(2131303515));
      this.zeW.zbE.yFh = ((TextView)this.zeW.zbE.yFf.findViewById(2131299492));
      this.zeW.zbE.yoJ = ((TextView)this.zeW.zbE.yFf.findViewById(2131299517));
      this.zeW.zbE.yFd.xDO = true;
      this.zeW.zbE.yFd.setScaleType(QImageView.a.JbU);
      a.a(this.zeW, (SnsDrawGestureView)this.zeW.sSS.findViewById(2131304972));
      this.zeW.zcf = ((ImageView)this.zeW.sSS.findViewById(2131300311));
      this.zeW.zcg = ((ImageView)this.zeW.sSS.findViewById(2131299487));
      this.zeW.zch = ((SnsAdCardVideoEndView)this.zeW.sSS.findViewById(2131304975));
      this.zeW.zcj = ((SnsAdTouchProgressView)this.zeW.sSS.findViewById(2131305046));
      if (this.zeW.zck != null) {
        break label787;
      }
      paramBaseViewHolder = (ViewStub)this.zeW.zen.findViewById(2131304926);
      this.zeW.zck = ((SnsAdSphereAnimView)paramBaseViewHolder.inflate());
    }
    for (;;)
    {
      this.zeW.zck.setVisibility(8);
      this.zeX = new au(this.mActivity, this.zeW);
      this.zeX.yHW = this.zcr;
      this.zeY = c.dRN();
      AppMethodBeat.o(100081);
      return;
      if (paramBaseViewHolder.zdn) {
        break;
      }
      this.zeW.yGK = paramBaseViewHolder.sSS.findViewById(2131300321);
      paramBaseViewHolder.zdn = true;
      break;
      label787:
      ac.e("MicroMsg.FullCardAdTimeLineItem", "buildContent many times");
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(176426);
    if ((this.zeW != null) && (this.zeW.yGK != null))
    {
      Object localObject = new int[2];
      this.zeW.yGK.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.zeW.yGK.getMeasuredWidth() + i, this.zeW.yGK.getMeasuredHeight() + j);
      AppMethodBeat.o(176426);
      return localObject;
    }
    AppMethodBeat.o(176426);
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177694);
    ac.i("MicroMsg.FullCardAdTimeLineItem", "onUIPause");
    dRL();
    AppMethodBeat.o(177694);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176424);
    ac.i("MicroMsg.FullCardAdTimeLineItem", "pause");
    if (dRL()) {
      dRM();
    }
    AppMethodBeat.o(176424);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176425);
    ac.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd stop", new Object[] { this });
    if ((this.zeW != null) && (this.zeW.zbE != null))
    {
      if (!this.zfa) {
        break label71;
      }
      this.zeW.zbE.yFe.clear();
    }
    for (;;)
    {
      this.zeB = false;
      AppMethodBeat.o(176425);
      return;
      label71:
      this.zeW.zbE.yFd.xDG.clear();
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View rXY;
    public View yGK;
    public View zbW;
    public TextView zbX;
    public TextView zbY;
    public TextView zbZ;
    public TextView zca;
    public View zcb;
    public MaskImageView zcc;
    private SnsDrawGestureView zcd;
    public ImageView zcf;
    public ImageView zcg;
    public SnsAdCardVideoEndView zch;
    public SnsAdTouchProgressView zcj;
    public SnsAdSphereAnimView zck;
    public boolean zeO = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.d
 * JD-Core Version:    0.7.0.1
 */