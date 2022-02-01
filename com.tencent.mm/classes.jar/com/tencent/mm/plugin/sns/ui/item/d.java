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
import com.tencent.mm.cg.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.b.f.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bf;
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
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
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
  private p wvM;
  private View.OnClickListener xPA;
  protected SnsAdTouchProgressView.a xPB;
  boolean xPs;
  private View.OnClickListener xPz;
  volatile boolean xRG;
  Handler xSa;
  a xSb;
  private au xSc;
  private boolean xSd;
  private boolean xSe;
  boolean xSf;
  
  public d()
  {
    AppMethodBeat.i(176422);
    this.xSa = new Handler(Looper.getMainLooper());
    this.xRG = false;
    this.xPs = false;
    this.xSd = false;
    this.xSe = false;
    this.xSf = false;
    this.xPz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176421);
        ad.i("MicroMsg.FullCardAdTimeLineItem", "ProxyCardClickListener onClick");
        try
        {
          d.this.wNd.wMy.xUd.onClick(paramAnonymousView);
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
            ad.e("MicroMsg.FullCardAdTimeLineItem", "ProxyCardClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.xPA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179368);
        ad.i("MicroMsg.FullCardAdTimeLineItem", "ProxySightClickListener onClick");
        try
        {
          d.this.wNd.wMy.xTQ.onClick(paramAnonymousView);
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
            ad.e("MicroMsg.FullCardAdTimeLineItem", "mProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.xPB = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179359);
        try
        {
          ad.i("MicroMsg.FullCardAdTimeLineItem", "SnsAdTouchProgressView onClick");
          d.f(d.this).xOO.xsm.performClick();
          AppMethodBeat.o(179359);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          ad.e("MicroMsg.FullCardAdTimeLineItem", "SnsAdTouchProgressView onClick exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(179359);
        }
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179360);
        d.this.wNd.xFq.xlo.i(d.f(d.this));
        q.d(new long[] { 20L, 100L });
        c.a(d.this.mActivity, d.f(d.this).xtU, d.d(d.this), 1);
        if (d.d(d.this) != null)
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(1, 1, q.anR(d.d(d.this).dxy().Id), 28, 21);
          if ((d.this.mActivity instanceof SnsTimeLineUI)) {
            com.tencent.mm.plugin.sns.data.j.a(localSnsAdClick, ((SnsTimeLineUI)d.this.mActivity).dCh(), d.d(d.this), 28);
          }
          q.a(localSnsAdClick);
          ad.i("MicroMsg.FullCardAdTimeLineItem", "onFinish report MMOCAD_CLICKPOS_AD_FULL_CARD_LONGPRESS");
          AppMethodBeat.o(179360);
          return;
        }
        ad.e("MicroMsg.FullCardAdTimeLineItem", "onFinish report, mSnsinfo==null");
        AppMethodBeat.o(179360);
      }
      
      public final void onStart() {}
    };
    AppMethodBeat.o(176422);
  }
  
  private void R(p paramp)
  {
    AppMethodBeat.i(187787);
    if ((this.wNd != null) && (this.wNd.xFq != null) && (this.wNd.xFq.xkX != null) && (paramp != null)) {
      this.wNd.xFq.xkX.sn(paramp.field_snsId);
    }
    AppMethodBeat.o(187787);
  }
  
  private void csr()
  {
    AppMethodBeat.i(176427);
    ad.i("MicroMsg.FullCardAdTimeLineItem", "try show play btn");
    if ((this.xSb != null) && (this.xSb.xOO != null) && (!this.xRG))
    {
      ad.i("MicroMsg.FullCardAdTimeLineItem", "show play btn");
      this.xSb.xOO.xbT.setVisibility(0);
      this.xSb.xOO.xsq.setVisibility(8);
      this.xSb.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
      this.xSb.xOO.xbT.setContentDescription(this.mActivity.getString(2131761939));
    }
    AppMethodBeat.o(176427);
  }
  
  private boolean dDo()
  {
    AppMethodBeat.i(177695);
    if ((this.xSb.timeLineObject.Etm.DaB == 5) || (this.xSb.timeLineObject.Etm.DaB == 15))
    {
      ad.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd doPause", new Object[] { this });
      if ((this.xSb != null) && (this.xSb.xOO != null))
      {
        if (!this.xSf) {
          break label133;
        }
        this.xSb.xOO.xso.pause();
        this.xSb.xOO.xso.setShouldPlayWhenPrepared(false);
        this.xSc.dAJ();
      }
      for (;;)
      {
        R(this.wvM);
        this.xRG = false;
        AppMethodBeat.o(177695);
        return true;
        label133:
        this.xSb.xOO.xsn.pause();
      }
    }
    AppMethodBeat.o(177695);
    return false;
  }
  
  protected final void a(be parambe, bf parambf, final com.tencent.mm.plugin.sns.storage.b.f paramf, int paramInt)
  {
    AppMethodBeat.i(179370);
    ad.i("MicroMsg.FullCardAdTimeLineItem", "doOnVideoCompletion, ret=".concat(String.valueOf(paramInt)));
    if (paramInt != -1)
    {
      if ((parambe == null) || (parambe.xFq == null) || (parambe.xFq.xkX == null))
      {
        AppMethodBeat.o(179370);
        return;
      }
      parambe.xFq.xkX.A(parambf.xIc, false);
    }
    com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179361);
        d locald = d.this;
        com.tencent.mm.plugin.sns.storage.b.f localf = paramf;
        if (localf != null) {
          for (;;)
          {
            try
            {
              if ((localf.wUs == null) || (!locald.xRG)) {
                break;
              }
              if (locald.xSf)
              {
                locald.xSb.xPr.setBlurBkg(locald.xSb.xOO.xso.getInnerVideoView());
                locald.xSb.xPr.aJY();
                locald.xSb.xPr.dEa();
                locald.xPs = true;
                if (locald.xSf)
                {
                  locald.xSb.xOO.xso.setShouldPlayWhenPrepared(false);
                  locald.xSb.xOO.xso.pause();
                  locald.a(locald.xSb);
                  locald.xSa.postDelayed(new d.11(locald), localf.wUs.duration);
                  AppMethodBeat.o(179361);
                }
              }
              else
              {
                locald.xSb.xPr.setBlurBkg(locald.xSb.xtU);
                continue;
              }
              localException.xSb.xOO.xsn.pause();
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.FullCardAdTimeLineItem", "handleVideoCompletion, exp" + localException.toString());
              AppMethodBeat.o(179361);
              return;
            }
          }
        }
        localException.xSb.xPr.hH(false);
        AppMethodBeat.o(179361);
      }
    });
    AppMethodBeat.o(179370);
  }
  
  protected final void a(final bf parambf, com.tencent.mm.plugin.sns.storage.b.f paramf, final p paramp, long paramLong, int paramInt)
  {
    AppMethodBeat.i(179371);
    if ((this.wNd == null) || (this.wNd.xFq == null) || (this.wNd.xFq.xkX == null))
    {
      AppMethodBeat.o(179371);
      return;
    }
    if (((paramf == null) || (paramf.wUs == null)) && (this.xSb.xPr.getVisibility() == 0)) {
      this.xSb.xPr.hH(false);
    }
    if (paramp != null)
    {
      this.wNd.xFq.xkX.sm(paramp.field_snsId);
      this.wNd.xFq.xkX.ak(paramp.field_snsId, 1000L * paramLong);
    }
    if (!this.wNd.xFq.xkX.sj(parambf.xIc))
    {
      this.wNd.xFq.xkX.d(parambf.xIc, bt.GC(), false);
      this.wNd.xFq.xkX.e(parambf.xIc, paramInt, false);
      this.wNd.xFq.xkX.aj(parambf.xIc, parambf.xIc);
    }
    ad.d("MicroMsg.FullCardAdTimeLineItem", "doOnVideoPlaying, currentTime=" + paramLong + ", duration=" + paramInt);
    paramInt = (int)paramLong;
    parambf = this.xSb;
    int i = paramInt * 1000;
    final b.f.a locala = paramf.wUn;
    if ((!bt.isNullOrNil(paramp.dxs().dvu())) && (locala != null) && (locala.startTime >= 0L) && (locala.endTime > locala.startTime))
    {
      ad.i("MicroMsg.FullCardAdTimeLineItem", "%d-%d,%d", new Object[] { Long.valueOf(locala.startTime), Long.valueOf(locala.endTime), Integer.valueOf(i) });
      if ((locala.startTime > i) || (locala.endTime < i)) {
        break label426;
      }
      if (a.b(parambf).getOnGestureListener() == null) {
        com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100080);
            d.a.b(parambf).setVisibility(0);
            d.a.b(parambf).dEm();
            d.a.b(parambf).setPaintColor(locala.color);
            d.a.b(parambf).setOnGestureListener(new SnsDrawGestureView.a()
            {
              public final void dDm()
              {
                AppMethodBeat.i(179364);
                q.pI(false);
                d.a.b(d.7.this.xSh).setBackgroundColor(d.this.mActivity.getResources().getColor(2131100894));
                AppMethodBeat.o(179364);
              }
              
              public final void fJ(List<PointF> paramAnonymous2List)
              {
                int i = 1;
                AppMethodBeat.i(179365);
                q.pI(true);
                Object localObject = q.anT(d.7.this.xPH.wUv);
                d.a.b(d.7.this.xSh).setBackgroundColor(0);
                if ((((List)localObject).size() > 0) && (paramAnonymous2List.size() > 0)) {
                  try
                  {
                    double d1 = com.tencent.mm.ui.tools.a.a.H((List)localObject, paramAnonymous2List);
                    String str = q.fl((List)localObject);
                    Collections.reverse((List)localObject);
                    double d2 = com.tencent.mm.ui.tools.a.a.H((List)localObject, paramAnonymous2List);
                    float f = (float)Math.min(d1, d2);
                    ad.i("MicroMsg.FullCardAdTimeLineItem", "similarity: %f,%f, distance:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Float.valueOf(f) });
                    if (f <= d.7.this.xPH.wUu)
                    {
                      d.this.wNd.xFq.xlo.i(d.7.this.xSh);
                      q.d(new long[] { 20L, 100L });
                      c.a(d.this.mActivity, d.7.this.xSh.xtU, d.7.this.xlw, 1);
                      localObject = new SnsAdClick(1, 1, q.anR(d.7.this.xlw.dxy().Id), 25, 21);
                      if ((d.this.mActivity instanceof SnsTimeLineUI)) {
                        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject, ((SnsTimeLineUI)d.this.mActivity).dCh(), d.7.this.xlw, 25);
                      }
                      q.a((SnsAdClick)localObject);
                      i = 2;
                    }
                    h.vKh.f(16552, new Object[] { d.7.this.xlw.dxy().Id, str, q.fl(com.tencent.mm.ui.tools.a.a.ij(paramAnonymous2List)), Integer.valueOf((int)(100.0F * f)), Integer.valueOf(i), Long.valueOf(bt.aGi(d.7.this.xlw.dyc())), d.7.this.xlw.dxu().dvK });
                    c.a(i, f, d.7.this.xPH.wUu, d.7.this.xlw.dxu().dvK, d.7.this.xlw.dxy().Id, 1);
                    return;
                  }
                  catch (Exception paramAnonymous2List)
                  {
                    ad.printErrStackTrace("MicroMsg.FullCardAdTimeLineItem", paramAnonymous2List, "recog gesture error!", new Object[0]);
                    return;
                  }
                  finally
                  {
                    d.a.b(d.7.this.xSh).dEm();
                    AppMethodBeat.o(179365);
                  }
                }
                AppMethodBeat.o(179365);
              }
              
              public final void onClick()
              {
                AppMethodBeat.i(179366);
                q.pI(true);
                d.a.b(d.7.this.xSh).setBackgroundColor(0);
                d.7.this.xSh.xOO.xsm.performClick();
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
      c.a(paramf, paramInt * 1000, this.xSb.xPp, this.xSb.xPq);
      AppMethodBeat.o(179371);
      return;
      label426:
      a(parambf);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176423);
    if ((paramBaseViewHolder.timeLineObject.Etm.DaB == 5) || (paramBaseViewHolder.timeLineObject.Etm.DaB == 15))
    {
      ad.i("MicroMsg.FullCardAdTimeLineItem", "play: hash=" + hashCode() + ", pos=" + paramInt + ", isEndViewShow=" + this.xPs + ", isPlayingSight=" + this.xRG);
      com.tencent.mm.plugin.sns.ui.video.d.dDS().ckd();
      com.tencent.mm.plugin.sns.ui.video.b.dDL().a(this);
      if (!this.xPs)
      {
        if (!this.xSf) {
          break label265;
        }
        paramBaseViewHolder.xOO.xso.setShouldPlayWhenPrepared(true);
        paramBaseViewHolder.xOO.xso.start();
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.FullCardAdTimeLineItem", "try hide play btn");
      if ((this.xSb != null) && (this.xSb.xOO != null))
      {
        ad.i("MicroMsg.FullCardAdTimeLineItem", "hide play btn");
        this.xSb.xOO.xbT.setVisibility(8);
        this.xSb.xOO.xsq.setVisibility(8);
      }
      this.xRG = true;
      if ((paramBaseViewHolder instanceof a)) {
        ((a)paramBaseViewHolder).xRT = false;
      }
      if ((!this.xPs) && (this.xSb.xPr.getVisibility() == 0)) {
        this.xSb.xPr.hH(true);
      }
      AppMethodBeat.o(176423);
      return;
      label265:
      paramBaseViewHolder.xOO.xsn.start();
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, final be parambe)
  {
    AppMethodBeat.i(100082);
    ad.i("MicroMsg.FullCardAdTimeLineItem", "fillItem, hash=" + hashCode() + ", pos=" + paramInt1 + ", objId=" + paramTimeLineObject.Id);
    if (paramBaseViewHolder.fUH)
    {
      ad.i("MicroMsg.FullCardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(100082);
      return;
    }
    final a locala = (a)paramBaseViewHolder;
    final p localp = parambf.wvM;
    this.wvM = localp;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (localp != null)
    {
      localObject2 = localObject1;
      if (localp.dxs() != null) {
        localObject2 = localp.dxs().wTD;
      }
    }
    localObject1 = (WindowManager)this.mActivity.getSystemService("window");
    paramInt2 = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    localObject1 = null;
    locala.qXs.setVisibility(8);
    locala.xPh.setVisibility(8);
    locala.xPi.setVisibility(8);
    locala.xPg.setVisibility(8);
    locala.xPj.setVisibility(8);
    locala.xPk.setVisibility(8);
    locala.xPl.setVisibility(8);
    a.b(locala).setVisibility(8);
    locala.xPt.setVisibility(8);
    locala.xPu.setVisibility(8);
    locala.xOO.xsn.setOnCompletionListener(null);
    locala.xOO.xsn.setOnDecodeDurationListener(null);
    locala.xOO.xso.setVideoCallback(null);
    a(locala);
    Object localObject3;
    boolean bool;
    label478:
    int i;
    label501:
    Object localObject4;
    if (localObject2 != null)
    {
      locala.xPr.a(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).wUs, 1);
      if ((localp != null) && (locala.xPr.S(localp)))
      {
        this.xSa.removeCallbacksAndMessages(null);
        this.xPs = false;
      }
      localObject3 = locala.xOO.xsn;
      if (((com.tencent.mm.plugin.sns.storage.b.f)localObject2).wUs != null)
      {
        bool = true;
        ((VideoSightView)localObject3).setIsForbidLoopAnim(bool);
        paramInt2 = paramInt2 - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
        if (((com.tencent.mm.plugin.sns.storage.b.f)localObject2).wUk != 0) {
          break label1601;
        }
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
        i = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 54);
        if (localObject1 == null) {
          break label1643;
        }
        paramInt2 = ((ViewGroup.LayoutParams)localObject1).height;
        this.xSe = this.xSc.a(this.wvM, ((com.tencent.mm.plugin.sns.storage.b.f)localObject2).wUt, paramInt2 + i);
        if ((!this.xSd) && (!this.xSe)) {
          break label1649;
        }
        bool = true;
        label543:
        this.xSf = bool;
        locala.xOO.xsv = this.xSf;
        localObject4 = new StringBuilder("fillItem, isExptUseNewPlayer=").append(this.xSd).append(", isLongPressGestureAd=").append(this.xSe).append(", hash=").append(hashCode()).append(", snsId=");
        if (localp != null) {
          break label1655;
        }
        localObject3 = "";
        label622:
        ad.i("MicroMsg.FullCardAdTimeLineItem", localObject3);
        if (localObject1 != null)
        {
          localObject3 = locala.xtU.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.xtU.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((RoundedCornerFrameLayout)locala.xtU).setRadius(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8));
          localObject3 = locala.xPm.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.xPm.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = locala.xOO.xsm.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.xOO.xsm.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          locala.xOO.xsn.gW(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
          localObject3 = locala.xOO.xso.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.xOO.xso.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = locala.xPp.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.xPp.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = locala.xPq.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.xPq.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = locala.xPr.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
          locala.xPr.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
        if (((com.tencent.mm.plugin.sns.storage.b.f)localObject2).wUm != 0) {
          break label1668;
        }
        paramInt2 = Color.argb((int)(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).wUl * 2.55F), 0, 0, 0);
        i = Color.argb(0, 0, 0, 0);
        localObject1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt2, i });
        ((GradientDrawable)localObject1).setGradientType(0);
        locala.qXs.setBackground((Drawable)localObject1);
        if ((!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).title)) || (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).description))) {
          locala.qXs.setVisibility(0);
        }
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).title))
        {
          locala.xPh.setVisibility(0);
          localObject1 = locala.xPh;
          localObject3 = g.eIa();
          locala.xPh.getContext();
          ((TextView)localObject1).setText(((g)localObject3).b(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).title, locala.xPh.getTextSize()));
        }
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).description))
        {
          locala.xPi.setVisibility(0);
          localObject1 = locala.xPi;
          localObject3 = g.eIa();
          locala.xPi.getContext();
          ((TextView)localObject1).setText(((g)localObject3).b(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).description, locala.xPi.getTextSize()));
        }
        label1212:
        if (localp.dxu().dvd())
        {
          paramInt2 = Color.argb((int)(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).wUl * 2.55F), 0, 0, 0);
          i = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
          ((GradientDrawable)localObject1).setGradientType(0);
          locala.xPg.setVisibility(0);
          locala.xPg.setBackground((Drawable)localObject1);
          locala.xPl.setVisibility(0);
        }
        if ((paramTimeLineObject.Etm == null) || (paramTimeLineObject.Etm.DaC.size() <= 0)) {
          break label1999;
        }
      }
    }
    label1601:
    label1999:
    for (localObject1 = (bpi)paramTimeLineObject.Etm.DaC.get(0);; localObject1 = null)
    {
      localObject3 = af.dtr();
      if ((paramBaseViewHolder.xOO.xsl != null) && (!bt.kU(paramBaseViewHolder.xOO.xsl.Id, paramTimeLineObject.Id)))
      {
        ad.i("MicroMsg.FullCardAdTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.xOO.xsl.Id });
        ((f)localObject3).a(paramBaseViewHolder.xOO.xsn, this.mActivity.hashCode(), paramInt1);
        ((f)localObject3).a(paramBaseViewHolder.xOO.xso, this.mActivity.hashCode());
      }
      paramBaseViewHolder.xOO.a(paramTimeLineObject, paramInt1, parambf.xmu, parambf.xkI);
      paramBaseViewHolder.xOO.xbU.setVisibility(8);
      if (localObject1 == null) {
        break label3191;
      }
      if (paramTimeLineObject.Etm.DaB != 1) {
        break label2005;
      }
      locala.xPm.setVisibility(0);
      locala.xOO.xsm.setVisibility(4);
      parambf = locala.xPm;
      paramInt1 = this.mActivity.hashCode();
      parambe = bc.eLG();
      parambe.tGD = paramTimeLineObject.CreateTime;
      ((f)localObject3).b((bpi)localObject1, parambf, -1, paramInt1, parambe);
      locala.xPm.setTag(paramBaseViewHolder);
      locala.xPm.setOnClickListener(this.xPz);
      locala.xRT = false;
      AppMethodBeat.o(100082);
      return;
      bool = false;
      break;
      if (((com.tencent.mm.plugin.sns.storage.b.f)localObject2).wUk != 1) {
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
      if (((com.tencent.mm.plugin.sns.storage.b.f)localObject2).wUm != 1) {
        break label1212;
      }
      paramInt2 = Color.argb((int)(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).wUl * 2.55F), 0, 0, 0);
      i = Color.argb(0, 0, 0, 0);
      localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
      ((GradientDrawable)localObject1).setGradientType(0);
      locala.xPg.setBackground((Drawable)localObject1);
      if ((!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).title)) || (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).description)))
      {
        locala.xPg.setVisibility(0);
        localObject1 = (RelativeLayout.LayoutParams)locala.xPl.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cd.a.fromDPToPix(locala.xtU.getContext(), 4);
        locala.xPl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).title))
      {
        locala.xPj.setVisibility(0);
        localObject1 = locala.xPj;
        localObject3 = g.eIa();
        locala.xPj.getContext();
        ((TextView)localObject1).setText(((g)localObject3).b(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).title, locala.xPj.getTextSize()));
      }
      if (bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).description)) {
        break label1212;
      }
      locala.xPk.setVisibility(0);
      localObject1 = locala.xPk;
      localObject3 = g.eIa();
      locala.xPk.getContext();
      ((TextView)localObject1).setText(((g)localObject3).b(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).description, locala.xPk.getTextSize()));
      break label1212;
      ad.e("MicroMsg.FullCardAdTimeLineItem", "invalid full card");
      if (this.wvM == null) {}
      for (localObject1 = "";; localObject1 = q.st(this.wvM.field_snsId))
      {
        com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.wAK, (String)localObject1, 1, 0, "");
        break;
      }
    }
    label1668:
    label2005:
    if ((paramTimeLineObject.Etm.DaB == 15) || (paramTimeLineObject.Etm.DaB == 5))
    {
      if (this.xSf)
      {
        locala.xOO.xso.setVisibility(0);
        locala.xOO.xsn.setVisibility(8);
        locala.xOO.xso.setVideoCallback(new OfflineVideoView.a()
        {
          public final boolean a(PString paramAnonymousPString)
          {
            AppMethodBeat.i(179355);
            ad.i("MicroMsg.FullCardAdTimeLineItem", "downloadVideo");
            AppMethodBeat.o(179355);
            return false;
          }
          
          public final void onCompletion()
          {
            AppMethodBeat.i(179357);
            ad.i("MicroMsg.FullCardAdTimeLineItem", "onCompletion");
            boolean bool = d.a(d.this).dAI();
            if ((d.b(d.this)) && (this.xSg.wUs == null) && (!bool)) {
              locala.xOO.xso.restart();
            }
            d.this.a(parambe, parambf, this.xSg, 0);
            AppMethodBeat.o(179357);
          }
          
          public final void onStart(int paramAnonymousInt)
          {
            AppMethodBeat.i(179356);
            ad.i("MicroMsg.FullCardAdTimeLineItem", "onStart:".concat(String.valueOf(paramAnonymousInt)));
            AppMethodBeat.o(179356);
          }
          
          public final void sa(int paramAnonymousInt)
          {
            AppMethodBeat.i(179358);
            int i = paramAnonymousInt / 1000;
            d.this.a(parambf, this.xSg, localp, i, locala.xOO.xso.getDurationMs() / 1000);
            Object localObject2 = null;
            Object localObject1 = localObject2;
            if (parambe != null)
            {
              localObject1 = localObject2;
              if (parambe.xFq != null) {
                localObject1 = parambe.xFq.xkX;
              }
            }
            d.a(d.this).a((com.tencent.mm.plugin.sns.a.b.i)localObject1, paramAnonymousInt, parambf.xIc);
            AppMethodBeat.o(179358);
          }
        });
        c.i(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).wUo, locala.xPp);
        c.i(((com.tencent.mm.plugin.sns.storage.b.f)localObject2).wUq, locala.xPq);
        localObject2 = ((com.tencent.mm.plugin.sns.storage.b.f)localObject2).wUn;
        localObject4 = localp.dxs().dvu();
        if ((!bt.isNullOrNil((String)localObject4)) && (localObject2 != null) && (((b.f.a)localObject2).startTime >= 0L) && (((b.f.a)localObject2).endTime > ((b.f.a)localObject2).startTime)) {
          com.tencent.mm.sdk.g.b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100079);
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.dxp().f("adId", this.xPG, "adxml", 0);
              AppMethodBeat.o(100079);
            }
          }, "preDownloadFloatPage");
        }
        long l = System.nanoTime();
        bool = f.t((bpi)localObject1);
        ad.i("MicroMsg.FullCardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
        localObject2 = locala.xOO;
        if (bool) {
          break label2753;
        }
        if (!((f)localObject3).w((bpi)localObject1)) {
          break label2577;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq.feJ();
        label2279:
        locala.xOO.xsm.setVisibility(0);
        locala.xPm.setVisibility(4);
        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsn.setTagObject(localObject2);
        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xso.setTag(localObject2);
        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsp.setTag(paramBaseViewHolder);
        locala.xOO.xsm.setOnClickListener(this.xPz);
        if (!this.xSf) {
          break label3112;
        }
        paramBaseViewHolder = ((com.tencent.mm.plugin.sns.ui.an)localObject2).xso;
        paramInt1 = this.mActivity.hashCode();
        localObject2 = bc.eLG();
        ((bc)localObject2).tGD = paramTimeLineObject.CreateTime;
        ((f)localObject3).a(localp, (bpi)localObject1, paramBaseViewHolder, paramInt1, (bc)localObject2, parambf.xkI);
        label2398:
        paramBaseViewHolder = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), ((bpi)localObject1).Id);
        paramTimeLineObject = q.i((bpi)localObject1);
        if (!com.tencent.mm.vfs.i.eK(paramBaseViewHolder + paramTimeLineObject)) {
          break label3166;
        }
        parambe.xFq.xkX.B(parambf.xIc, true);
        if (af.dtr().b(localp, null) != 5) {
          break label3185;
        }
      }
      label3166:
      label3185:
      for (bool = true;; bool = false)
      {
        parambe.xFq.xkX.e(parambf.xIc, bool, false);
        AppMethodBeat.o(100082);
        return;
        locala.xOO.xso.setVisibility(8);
        locala.xOO.xsn.setVisibility(0);
        locala.xOO.xsn.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(179362);
            StringBuilder localStringBuilder = new StringBuilder("sight play completed, retCode=").append(paramAnonymousInt).append(", snsId=");
            if (localp == null) {}
            for (paramAnonymousb = "";; paramAnonymousb = Long.valueOf(localp.field_snsId))
            {
              ad.i("MicroMsg.FullCardAdTimeLineItem", paramAnonymousb);
              d.this.a(parambe, parambf, this.xSg, paramAnonymousInt);
              AppMethodBeat.o(179362);
              return;
            }
          }
        });
        locala.xOO.xsn.setOnDecodeDurationListener(new com.tencent.mm.plugin.sight.decode.a.b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(179363);
            ad.d("MicroMsg.FullCardAdTimeLineItem", "sight play %d", new Object[] { Long.valueOf(paramAnonymousLong) });
            d.this.a(parambf, this.xSg, localp, paramAnonymousLong, (int)paramAnonymousb.dqu());
            AppMethodBeat.o(179363);
          }
        });
        break;
        if (((f)localObject3).b(localp, null) == 5)
        {
          ((f)localObject3).A((bpi)localObject1);
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq.feJ();
          break label2279;
        }
        if (((f)localObject3).x((bpi)localObject1))
        {
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setImageResource(2131234034);
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setVisibility(0);
          break label2279;
        }
        ((f)localObject3).y((bpi)localObject1);
        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setContentDescription(this.mActivity.getString(2131761939));
        if (((f)localObject3).b(localp, null) != 4) {
          break label2279;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbU.setVisibility(0);
        break label2279;
        if (((f)localObject3).u((bpi)localObject1))
        {
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setContentDescription(this.mActivity.getString(2131761939));
          if (!this.xSf) {
            break label3096;
          }
        }
        for (bool = ((com.tencent.mm.plugin.sns.ui.an)localObject2).xso.isError();; bool = ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsn.wsq.dqr())
        {
          if (!bool) {
            break label3110;
          }
          ad.d("MicroMsg.FullCardAdTimeLineItem", "play video error " + ((bpi)localObject1).Id + " " + ((bpi)localObject1).Url + " " + ((bpi)localObject1).DMQ + " " + paramInt1);
          ((f)localObject3).y((bpi)localObject1);
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setContentDescription(this.mActivity.getString(2131761939));
          break;
          if (((f)localObject3).v((bpi)localObject1))
          {
            ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq.setVisibility(8);
            break label2816;
          }
          if (((f)localObject3).b(localp, null) <= 5)
          {
            if (locala.xRT) {
              break label2816;
            }
            ad.i("MicroMsg.FullCardAdTimeLineItem", "fillItem, showPlayBtn");
            csr();
            break label2816;
          }
          ((f)localObject3).y((bpi)localObject1);
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
          ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setContentDescription(this.mActivity.getString(2131761939));
          break label2816;
        }
        break label2279;
        paramBaseViewHolder = ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsn;
        paramInt2 = this.mActivity.hashCode();
        localObject2 = bc.eLG();
        ((bc)localObject2).tGD = paramTimeLineObject.CreateTime;
        ((f)localObject3).a(localp, (bpi)localObject1, paramBaseViewHolder, paramInt2, paramInt1, (bc)localObject2, parambf.xkI, true);
        break label2398;
        parambe.xFq.xkX.B(parambf.xIc, false);
        break label2458;
      }
      label3191:
      ((f)localObject3).a(paramBaseViewHolder.xOO.xsn, this.mActivity.hashCode(), paramInt1);
      ((f)localObject3).a(paramBaseViewHolder.xOO.xso, this.mActivity.hashCode());
      paramBaseViewHolder.xOO.xsr.setVisibility(8);
      paramBaseViewHolder.xOO.xsn.setOnSightCompletionAction(null);
      paramBaseViewHolder.xOO.xsn.setOnCompletionListener(null);
      paramBaseViewHolder.xOO.xsn.setOnDecodeDurationListener(null);
      paramBaseViewHolder.xOO.xso.setVideoCallback(null);
    }
    label2458:
    label2753:
    AppMethodBeat.o(100082);
    label2577:
    label3096:
    label3110:
    label3112:
    return;
  }
  
  final void a(final a parama)
  {
    AppMethodBeat.i(100083);
    com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179367);
        d.a.b(parama).setVisibility(8);
        d.a.b(parama).setBackgroundColor(0);
        d.a.b(parama).dEm();
        d.a.b(parama).setOnGestureListener(null);
        AppMethodBeat.o(179367);
      }
    });
    AppMethodBeat.o(100083);
  }
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100081);
    this.xSb = ((a)paramBaseViewHolder);
    if (paramBaseViewHolder.xQw != null)
    {
      paramBaseViewHolder.xQw.setLayoutResource(2131495603);
      if (!paramBaseViewHolder.xQx)
      {
        this.xSb.xtU = paramBaseViewHolder.xQw.inflate();
        paramBaseViewHolder.xQx = true;
      }
      this.xSb.qXs = this.xSb.rLd.findViewById(2131306008);
      this.xSb.xPg = this.xSb.rLd.findViewById(2131297449);
      this.xSb.xPh = ((TextView)this.xSb.rLd.findViewById(2131306010));
      this.xSb.xPi = ((TextView)this.xSb.rLd.findViewById(2131306009));
      this.xSb.xPj = ((TextView)this.xSb.rLd.findViewById(2131297451));
      this.xSb.xPk = ((TextView)this.xSb.rLd.findViewById(2131297450));
      this.xSb.xPm = ((MaskImageView)this.xSb.rLd.findViewById(2131300322));
      this.xSb.xPl = this.xSb.rLd.findViewById(2131297455);
      this.xSb.xPm.setScaleType(QImageView.a.HBy);
      this.xSb.xOO = new com.tencent.mm.plugin.sns.ui.an();
      this.xSb.xOO.xsp = this.xSb.xtU.findViewById(2131300324);
      this.xSb.xOO.xsm = this.xSb.xOO.xsp;
      this.xSb.xOO.xsp.setOnClickListener(this.xPA);
      this.xSb.xOO.xsn = ((VideoSightView)this.xSb.xOO.xsp.findViewById(2131300914));
      this.xSb.xOO.xso = ((SnsAdTimelineVideoView)this.xSb.xOO.xsp.findViewById(2131302995));
      paramBaseViewHolder.xOO.xsn.setMute(true);
      paramBaseViewHolder.xOO.xso.setMute(true);
      this.xSb.xOO.xbT = ((ImageView)this.xSb.xtU.findViewById(2131300323));
      this.xSb.xOO.xsq = ((MMPinProgressBtn)this.xSb.xOO.xsp.findViewById(2131303515));
      this.xSb.xOO.xsr = ((TextView)this.xSb.xOO.xsp.findViewById(2131299492));
      this.xSb.xOO.xbU = ((TextView)this.xSb.xOO.xsp.findViewById(2131299517));
      this.xSb.xOO.xsn.wsy = true;
      this.xSb.xOO.xsn.setScaleType(QImageView.a.HBy);
      a.a(this.xSb, (SnsDrawGestureView)this.xSb.rLd.findViewById(2131304972));
      this.xSb.xPp = ((ImageView)this.xSb.rLd.findViewById(2131300311));
      this.xSb.xPq = ((ImageView)this.xSb.rLd.findViewById(2131299487));
      this.xSb.xPr = ((SnsAdCardVideoEndView)this.xSb.rLd.findViewById(2131304975));
      this.xSb.xPt = ((SnsAdTouchProgressView)this.xSb.rLd.findViewById(2131305046));
      if (this.xSb.xPu != null) {
        break label787;
      }
      paramBaseViewHolder = (ViewStub)this.xSb.xRx.findViewById(2131304926);
      this.xSb.xPu = ((SnsAdSphereAnimView)paramBaseViewHolder.inflate());
    }
    for (;;)
    {
      this.xSb.xPu.setVisibility(8);
      this.xSc = new au(this.mActivity, this.xSb);
      this.xSc.xvg = this.xPB;
      this.xSd = c.dDp();
      AppMethodBeat.o(100081);
      return;
      if (paramBaseViewHolder.xQx) {
        break;
      }
      this.xSb.xtU = paramBaseViewHolder.rLd.findViewById(2131300321);
      paramBaseViewHolder.xQx = true;
      break;
      label787:
      ad.e("MicroMsg.FullCardAdTimeLineItem", "buildContent many times");
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(176426);
    if ((this.xSb != null) && (this.xSb.xtU != null))
    {
      Object localObject = new int[2];
      this.xSb.xtU.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.xSb.xtU.getMeasuredWidth() + i, this.xSb.xtU.getMeasuredHeight() + j);
      AppMethodBeat.o(176426);
      return localObject;
    }
    AppMethodBeat.o(176426);
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177694);
    ad.i("MicroMsg.FullCardAdTimeLineItem", "onUIPause");
    dDo();
    AppMethodBeat.o(177694);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176424);
    ad.i("MicroMsg.FullCardAdTimeLineItem", "pause");
    if (dDo()) {
      csr();
    }
    AppMethodBeat.o(176424);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176425);
    ad.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd stop", new Object[] { this });
    if ((this.xSb != null) && (this.xSb.xOO != null))
    {
      if (!this.xSf) {
        break label71;
      }
      this.xSb.xOO.xso.clear();
    }
    for (;;)
    {
      this.xRG = false;
      AppMethodBeat.o(176425);
      return;
      label71:
      this.xSb.xOO.xsn.wsq.clear();
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View qXs;
    public View xPg;
    public TextView xPh;
    public TextView xPi;
    public TextView xPj;
    public TextView xPk;
    public View xPl;
    public MaskImageView xPm;
    private SnsDrawGestureView xPn;
    public ImageView xPp;
    public ImageView xPq;
    public SnsAdCardVideoEndView xPr;
    public SnsAdTouchProgressView xPt;
    public SnsAdSphereAnimView xPu;
    public boolean xRT = false;
    public View xtU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.d
 * JD-Core Version:    0.7.0.1
 */