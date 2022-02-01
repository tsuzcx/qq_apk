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
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.b.g;
import com.tencent.mm.plugin.sns.storage.b.g.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.d.c;
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
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  boolean AtZ;
  private View.OnClickListener Auf;
  private View.OnClickListener Aug;
  protected SnsAdTouchProgressView.a Auh;
  Handler AwR;
  a AwS;
  private ax AwT;
  private boolean AwU;
  private boolean AwV;
  boolean AwW;
  volatile boolean Awr;
  private p yVM;
  
  public e()
  {
    AppMethodBeat.i(176422);
    this.AwR = new Handler(Looper.getMainLooper());
    this.Awr = false;
    this.AtZ = false;
    this.AwU = false;
    this.AwV = false;
    this.AwW = false;
    this.Auf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176421);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.FullCardAdTimeLineItem", "ProxyCardClickListener onClick");
        try
        {
          e.this.zpI.zpd.Azc.onClick(paramAnonymousView);
          if (e.c(e.this)) {
            SnsAdCardVideoEndView.i(e.d(e.this), 1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    this.Aug = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179368);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.FullCardAdTimeLineItem", "ProxySightClickListener onClick");
        try
        {
          e.this.zpI.zpd.AyP.onClick(paramAnonymousView);
          if (e.c(e.this)) {
            SnsAdCardVideoEndView.i(e.d(e.this), 1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    this.Auh = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179359);
        try
        {
          ad.i("MicroMsg.FullCardAdTimeLineItem", "SnsAdTouchProgressView onClick");
          e.f(e.this).Atv.zWx.performClick();
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
        e.this.zpI.AjE.zPs.m(e.f(e.this));
        q.d(new long[] { 20L, 100L });
        d.a(e.this.mActivity, e.f(e.this).zYc, e.d(e.this), 1);
        if (e.d(e.this) != null)
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(1, 1, q.ayi(e.d(e.this).dYl().Id), 28, 21);
          if ((e.this.mActivity instanceof SnsTimeLineUI)) {
            com.tencent.mm.plugin.sns.data.j.a(localSnsAdClick, ((SnsTimeLineUI)e.this.mActivity).ecW(), e.d(e.this), 28);
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
  
  private void U(p paramp)
  {
    AppMethodBeat.i(198547);
    if ((this.zpI != null) && (this.zpI.AjE != null) && (this.zpI.AjE.zPb != null) && (paramp != null)) {
      this.zpI.AjE.zPb.zq(paramp.field_snsId);
    }
    AppMethodBeat.o(198547);
  }
  
  private boolean eef()
  {
    AppMethodBeat.i(177695);
    if ((this.AwS.timeLineObject.HAT.GaP == 5) || (this.AwS.timeLineObject.HAT.GaP == 15))
    {
      ad.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd doPause", new Object[] { this });
      if ((this.AwS != null) && (this.AwS.Atv != null))
      {
        if (!this.AwW) {
          break label133;
        }
        this.AwS.Atv.zWz.pause();
        this.AwS.Atv.zWz.setShouldPlayWhenPrepared(false);
        this.AwT.ebx();
      }
      for (;;)
      {
        U(this.yVM);
        this.Awr = false;
        AppMethodBeat.o(177695);
        return true;
        label133:
        this.AwS.Atv.zWy.pause();
      }
    }
    AppMethodBeat.o(177695);
    return false;
  }
  
  private void eeg()
  {
    AppMethodBeat.i(176427);
    ad.i("MicroMsg.FullCardAdTimeLineItem", "try show play btn");
    if ((this.AwS != null) && (this.AwS.Atv != null) && (!this.Awr))
    {
      ad.i("MicroMsg.FullCardAdTimeLineItem", "show play btn");
      this.AwS.Atv.zFD.setVisibility(0);
      this.AwS.Atv.zWB.setVisibility(8);
      this.AwS.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
      this.AwS.Atv.zFD.setContentDescription(this.mActivity.getString(2131761939));
    }
    AppMethodBeat.o(176427);
  }
  
  protected final void a(bh parambh, bi parambi, final b.g paramg, int paramInt)
  {
    AppMethodBeat.i(179370);
    ad.i("MicroMsg.FullCardAdTimeLineItem", "doOnVideoCompletion, ret=".concat(String.valueOf(paramInt)));
    if (paramInt != -1)
    {
      if ((parambh == null) || (parambh.AjE == null) || (parambh.AjE.zPb == null))
      {
        AppMethodBeat.o(179370);
        return;
      }
      parambh.AjE.zPb.A(parambi.AmB, false);
    }
    com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179361);
        e locale = e.this;
        b.g localg = paramg;
        if (localg != null) {
          for (;;)
          {
            try
            {
              if ((localg.zxn == null) || (!locale.Awr)) {
                break;
              }
              if (locale.AwW)
              {
                locale.AwS.AtY.setBlurBkg(locale.AwS.Atv.zWz.getInnerVideoView());
                locale.AwS.AtY.aUb();
                locale.AwS.AtY.eeS();
                locale.AtZ = true;
                if (locale.AwW)
                {
                  locale.AwS.Atv.zWz.setShouldPlayWhenPrepared(false);
                  locale.AwS.Atv.zWz.pause();
                  locale.a(locale.AwS);
                  locale.AwR.postDelayed(new e.11(locale), localg.zxn.duration);
                  AppMethodBeat.o(179361);
                }
              }
              else
              {
                locale.AwS.AtY.setBlurBkg(locale.AwS.zYc);
                continue;
              }
              localException.AwS.Atv.zWy.pause();
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.FullCardAdTimeLineItem", "handleVideoCompletion, exp" + localException.toString());
              AppMethodBeat.o(179361);
              return;
            }
          }
        }
        localException.AwS.AtY.dV(false);
        AppMethodBeat.o(179361);
      }
    });
    AppMethodBeat.o(179370);
  }
  
  protected final void a(final bi parambi, b.g paramg, final p paramp, long paramLong, int paramInt)
  {
    AppMethodBeat.i(179371);
    if ((this.zpI == null) || (this.zpI.AjE == null) || (this.zpI.AjE.zPb == null))
    {
      AppMethodBeat.o(179371);
      return;
    }
    if (((paramg == null) || (paramg.zxn == null)) && (this.AwS.AtY.getVisibility() == 0)) {
      this.AwS.AtY.dV(false);
    }
    if (paramp != null)
    {
      this.zpI.AjE.zPb.zp(paramp.field_snsId);
      this.zpI.AjE.zPb.ak(paramp.field_snsId, 1000L * paramLong);
    }
    if (!this.zpI.AjE.zPb.zm(parambi.AmB))
    {
      this.zpI.AjE.zPb.d(parambi.AmB, bt.HI(), false);
      this.zpI.AjE.zPb.e(parambi.AmB, paramInt, false);
      this.zpI.AjE.zPb.aj(parambi.AmB, parambi.AmB);
    }
    ad.d("MicroMsg.FullCardAdTimeLineItem", "doOnVideoPlaying, currentTime=" + paramLong + ", duration=" + paramInt);
    paramInt = (int)paramLong;
    final a locala = this.AwS;
    int i = paramInt * 1000;
    if (paramg == null)
    {
      parambi = null;
      if ((!bt.isNullOrNil(paramp.dRL().dWj())) && (parambi != null) && (parambi.startTime >= 0L) && (parambi.endTime > parambi.startTime))
      {
        ad.i("MicroMsg.FullCardAdTimeLineItem", "%d-%d,%d", new Object[] { Long.valueOf(parambi.startTime), Long.valueOf(parambi.endTime), Integer.valueOf(i) });
        if ((parambi.startTime > i) || (parambi.endTime < i)) {
          break label428;
        }
        if (a.b(locala).getOnGestureListener() == null) {
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100080);
              e.a.b(locala).setVisibility(0);
              e.a.b(locala).efd();
              e.a.b(locala).setPaintColor(parambi.color);
              e.a.b(locala).setOnGestureListener(new SnsDrawGestureView.a()
              {
                public final void eed()
                {
                  AppMethodBeat.i(179364);
                  q.rk(false);
                  e.a.b(e.7.this.AwY).setBackgroundColor(e.this.mActivity.getResources().getColor(2131100894));
                  AppMethodBeat.o(179364);
                }
                
                public final void gc(List<PointF> paramAnonymous2List)
                {
                  int i = 1;
                  AppMethodBeat.i(179365);
                  q.rk(true);
                  Object localObject = q.ayk(e.7.this.Aun.zxq);
                  e.a.b(e.7.this.AwY).setBackgroundColor(0);
                  if ((((List)localObject).size() > 0) && (paramAnonymous2List.size() > 0)) {
                    try
                    {
                      paramAnonymous2List = com.tencent.mm.ui.tools.a.a.iK(paramAnonymous2List);
                      double d1 = com.tencent.mm.ui.tools.a.a.J((List)localObject, paramAnonymous2List);
                      String str = q.fG((List)localObject);
                      Collections.reverse((List)localObject);
                      double d2 = com.tencent.mm.ui.tools.a.a.J((List)localObject, paramAnonymous2List);
                      float f = (float)Math.min(d1, d2);
                      ad.i("MicroMsg.FullCardAdTimeLineItem", "similarity: %f,%f, distance:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Float.valueOf(f) });
                      if (f <= e.7.this.Aun.zxp)
                      {
                        e.this.zpI.AjE.zPs.m(e.7.this.AwY);
                        q.d(new long[] { 20L, 100L });
                        d.a(e.this.mActivity, e.7.this.AwY.zYc, e.7.this.zPy, 1);
                        localObject = new SnsAdClick(1, 1, q.ayi(e.7.this.zPy.dYl().Id), 25, 21);
                        if ((e.this.mActivity instanceof SnsTimeLineUI)) {
                          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject, ((SnsTimeLineUI)e.this.mActivity).ecW(), e.7.this.zPy, 25);
                        }
                        q.a((SnsAdClick)localObject);
                        i = 2;
                      }
                      com.tencent.mm.plugin.report.service.g.yhR.f(16552, new Object[] { e.7.this.zPy.dYl().Id, str, q.fG(com.tencent.mm.ui.tools.a.a.iI(paramAnonymous2List)), Integer.valueOf((int)(100.0F * f)), Integer.valueOf(i), Long.valueOf(bt.aRf(e.7.this.zPy.dYP())), e.7.this.zPy.dRK().dFy });
                      d.a(i, f, e.7.this.Aun.zxp, e.7.this.zPy.dRK().dFy, e.7.this.zPy.dYl().Id, 1);
                      return;
                    }
                    catch (Exception paramAnonymous2List)
                    {
                      ad.printErrStackTrace("MicroMsg.FullCardAdTimeLineItem", paramAnonymous2List, "recog gesture error!", new Object[0]);
                      return;
                    }
                    finally
                    {
                      e.a.b(e.7.this.AwY).efd();
                      AppMethodBeat.o(179365);
                    }
                  }
                  AppMethodBeat.o(179365);
                }
                
                public final void onClick()
                {
                  AppMethodBeat.i(179366);
                  q.rk(true);
                  e.a.b(e.7.this.AwY).setBackgroundColor(0);
                  e.7.this.AwY.Atv.zWx.performClick();
                  AppMethodBeat.o(179366);
                }
              });
              AppMethodBeat.o(100080);
            }
          });
        }
      }
    }
    for (;;)
    {
      d.a(paramg, paramInt * 1000, this.AwS.AtW, this.AwS.AtX);
      AppMethodBeat.o(179371);
      return;
      parambi = paramg.zxi;
      break;
      label428:
      a(locala);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176423);
    if ((paramBaseViewHolder.timeLineObject.HAT.GaP == 5) || (paramBaseViewHolder.timeLineObject.HAT.GaP == 15))
    {
      ad.i("MicroMsg.FullCardAdTimeLineItem", "play: hash=" + hashCode() + ", pos=" + paramInt + ", isEndViewShow=" + this.AtZ + ", isPlayingSight=" + this.Awr);
      com.tencent.mm.plugin.sns.ui.video.d.eeK().cxw();
      com.tencent.mm.plugin.sns.ui.video.b.eeD().a(this);
      if (!this.AtZ)
      {
        if (!this.AwW) {
          break label265;
        }
        paramBaseViewHolder.Atv.zWz.setShouldPlayWhenPrepared(true);
        paramBaseViewHolder.Atv.zWz.start();
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.FullCardAdTimeLineItem", "try hide play btn");
      if ((this.AwS != null) && (this.AwS.Atv != null))
      {
        ad.i("MicroMsg.FullCardAdTimeLineItem", "hide play btn");
        this.AwS.Atv.zFD.setVisibility(8);
        this.AwS.Atv.zWB.setVisibility(8);
      }
      this.Awr = true;
      if ((paramBaseViewHolder instanceof a)) {
        ((a)paramBaseViewHolder).AwE = false;
      }
      if ((!this.AtZ) && (this.AwS.AtY.getVisibility() == 0)) {
        this.AwS.AtY.dV(true);
      }
      AppMethodBeat.o(176423);
      return;
      label265:
      paramBaseViewHolder.Atv.zWy.start();
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, final bh parambh)
  {
    AppMethodBeat.i(100082);
    ad.i("MicroMsg.FullCardAdTimeLineItem", "fillItem, hash=" + hashCode() + ", pos=" + paramInt1 + ", objId=" + paramTimeLineObject.Id);
    if (paramBaseViewHolder.grY)
    {
      ad.i("MicroMsg.FullCardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(100082);
      return;
    }
    final a locala = (a)paramBaseViewHolder;
    final p localp = parambi.yVM;
    this.yVM = localp;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (localp != null)
    {
      localObject2 = localObject1;
      if (localp.dRL() != null) {
        localObject2 = localp.dRL().zwp;
      }
    }
    localObject1 = (WindowManager)this.mActivity.getSystemService("window");
    int i = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    localObject1 = null;
    locala.sUS.setVisibility(8);
    locala.AtO.setVisibility(8);
    locala.AtP.setVisibility(8);
    locala.AtN.setVisibility(8);
    locala.AtQ.setVisibility(8);
    locala.AtR.setVisibility(8);
    locala.AtS.setVisibility(8);
    a.b(locala).setVisibility(8);
    locala.Axb.setVisibility(8);
    locala.Aua.setVisibility(8);
    locala.Atv.zWy.setOnCompletionListener(null);
    locala.Atv.zWy.setOnDecodeDurationListener(null);
    locala.Atv.zWz.setVideoCallback(null);
    a(locala);
    boolean bool;
    label490:
    label502:
    Object localObject4;
    if (localObject2 != null)
    {
      locala.AtY.a(((b.g)localObject2).zxn, 1);
      if ((localp != null) && (locala.AtY.V(localp)))
      {
        this.AwR.removeCallbacksAndMessages(null);
        this.AtZ = false;
      }
      localObject3 = locala.Atv.zWy;
      if (((b.g)localObject2).zxn != null)
      {
        bool = true;
        ((VideoSightView)localObject3).setIsForbidLoopAnim(bool);
        int j = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 56);
        int k = this.mActivity.getResources().getDimensionPixelSize(2131165490);
        int m = this.mActivity.getResources().getDimensionPixelSize(2131165516);
        paramInt2 = i - j - k - m;
        if (((b.g)localObject2).zxf != 0) {
          break label1631;
        }
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
        if (localObject1 == null) {
          break label1673;
        }
        paramInt2 = ((ViewGroup.LayoutParams)localObject1).height;
        localObject3 = new Rect(k + j, j - m, i - m, paramInt2 + (j - m));
        this.AwV = this.AwT.a(this.yVM, ((b.g)localObject2).zxo, (Rect)localObject3);
        if ((!this.AwU) && (!this.AwV)) {
          break label1679;
        }
        bool = true;
        label573:
        this.AwW = bool;
        locala.Atv.zWG = this.AwW;
        localObject4 = new StringBuilder("fillItem, isExptUseNewPlayer=").append(this.AwU).append(", isLongPressGestureAd=").append(this.AwV).append(", hash=").append(hashCode()).append(", snsId=");
        if (localp != null) {
          break label1685;
        }
        localObject3 = "";
        label652:
        ad.i("MicroMsg.FullCardAdTimeLineItem", localObject3);
        if (localObject1 == null) {
          break label1698;
        }
        localObject3 = locala.zYc.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.zYc.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((RoundedCornerFrameLayout)locala.zYc).setRadius(com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 8));
        localObject3 = locala.AtT.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.AtT.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.Atv.zWx.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.Atv.zWx.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        locala.Atv.zWy.hw(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        localObject3 = locala.Atv.zWz.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.Atv.zWz.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.AtW.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.AtW.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.AtX.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.AtX.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.AtY.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.AtY.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        if (((b.g)localObject2).zxh != 0) {
          break label1755;
        }
        paramInt2 = Color.argb((int)(((b.g)localObject2).zxg * 2.55F), 0, 0, 0);
        i = Color.argb(0, 0, 0, 0);
        localObject1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt2, i });
        ((GradientDrawable)localObject1).setGradientType(0);
        locala.sUS.setBackground((Drawable)localObject1);
        if ((!bt.isNullOrNil(((b.g)localObject2).title)) || (!bt.isNullOrNil(((b.g)localObject2).description))) {
          locala.sUS.setVisibility(0);
        }
        if (!bt.isNullOrNil(((b.g)localObject2).title))
        {
          locala.AtO.setVisibility(0);
          localObject1 = locala.AtO;
          localObject3 = com.tencent.mm.cf.g.fng();
          locala.AtO.getContext();
          ((TextView)localObject1).setText(((com.tencent.mm.cf.g)localObject3).b(((b.g)localObject2).title, locala.AtO.getTextSize()));
        }
        if (!bt.isNullOrNil(((b.g)localObject2).description))
        {
          locala.AtP.setVisibility(0);
          localObject1 = locala.AtP;
          localObject3 = com.tencent.mm.cf.g.fng();
          locala.AtP.getContext();
          ((TextView)localObject1).setText(((com.tencent.mm.cf.g)localObject3).b(((b.g)localObject2).description, locala.AtP.getTextSize()));
        }
      }
      for (;;)
      {
        if (localp.dRK().dVQ())
        {
          paramInt2 = Color.argb((int)(((b.g)localObject2).zxg * 2.55F), 0, 0, 0);
          i = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
          ((GradientDrawable)localObject1).setGradientType(0);
          locala.AtN.setVisibility(0);
          locala.AtN.setBackground((Drawable)localObject1);
          locala.AtS.setVisibility(0);
        }
        if ((paramTimeLineObject.HAT == null) || (paramTimeLineObject.HAT.GaQ.size() <= 0)) {
          break label2118;
        }
        localObject1 = (byn)paramTimeLineObject.HAT.GaQ.get(0);
        label1379:
        localObject4 = ag.dUb();
        if ((paramBaseViewHolder.Atv.zWw != null) && (!bt.lQ(paramBaseViewHolder.Atv.zWw.Id, paramTimeLineObject.Id)))
        {
          ad.i("MicroMsg.FullCardAdTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.Atv.zWw.Id });
          ((f)localObject4).a(paramBaseViewHolder.Atv.zWy, this.mActivity.hashCode(), paramInt1);
          ((f)localObject4).a(paramBaseViewHolder.Atv.zWz, this.mActivity.hashCode());
        }
        paramBaseViewHolder.Atv.a(paramTimeLineObject, paramInt1, parambi.zQD, parambi.zOM);
        paramBaseViewHolder.Atv.zFE.setVisibility(8);
        if (localObject1 == null) {
          break label3342;
        }
        if (paramTimeLineObject.HAT.GaP != 1) {
          break label2124;
        }
        locala.AtT.setVisibility(0);
        locala.Atv.zWx.setVisibility(4);
        parambi = locala.AtT;
        paramInt1 = this.mActivity.hashCode();
        parambh = bj.frn();
        parambh.hbR = paramTimeLineObject.CreateTime;
        ((f)localObject4).b((byn)localObject1, parambi, -1, paramInt1, parambh);
        locala.AtT.setTag(paramBaseViewHolder);
        locala.AtT.setOnClickListener(this.Auf);
        locala.AwE = false;
        AppMethodBeat.o(100082);
        return;
        bool = false;
        break;
        label1631:
        if (((b.g)localObject2).zxf != 1) {
          break label490;
        }
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
        break label490;
        label1673:
        paramInt2 = 0;
        break label502;
        label1679:
        bool = false;
        break label573;
        label1685:
        localObject3 = Long.valueOf(localp.field_snsId);
        break label652;
        label1698:
        localObject3 = new StringBuilder("mediaLayout==null, snsId=");
        if (this.yVM == null) {}
        for (localObject1 = "";; localObject1 = Long.valueOf(this.yVM.field_snsId))
        {
          ad.e("MicroMsg.FullCardAdTimeLineItem", localObject1);
          break;
        }
        label1755:
        if (((b.g)localObject2).zxh == 1)
        {
          paramInt2 = Color.argb((int)(((b.g)localObject2).zxg * 2.55F), 0, 0, 0);
          i = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
          ((GradientDrawable)localObject1).setGradientType(0);
          locala.AtN.setBackground((Drawable)localObject1);
          if ((!bt.isNullOrNil(((b.g)localObject2).title)) || (!bt.isNullOrNil(((b.g)localObject2).description)))
          {
            locala.AtN.setVisibility(0);
            localObject1 = (RelativeLayout.LayoutParams)locala.AtS.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cc.a.fromDPToPix(locala.zYc.getContext(), 4);
            locala.AtS.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          if (!bt.isNullOrNil(((b.g)localObject2).title))
          {
            locala.AtQ.setVisibility(0);
            localObject1 = locala.AtQ;
            localObject3 = com.tencent.mm.cf.g.fng();
            locala.AtQ.getContext();
            ((TextView)localObject1).setText(((com.tencent.mm.cf.g)localObject3).b(((b.g)localObject2).title, locala.AtQ.getTextSize()));
          }
          if (!bt.isNullOrNil(((b.g)localObject2).description))
          {
            locala.AtR.setVisibility(0);
            localObject1 = locala.AtR;
            localObject3 = com.tencent.mm.cf.g.fng();
            locala.AtR.getContext();
            ((TextView)localObject1).setText(((com.tencent.mm.cf.g)localObject3).b(((b.g)localObject2).description, locala.AtR.getTextSize()));
          }
        }
      }
    }
    ad.e("MicroMsg.FullCardAdTimeLineItem", "invalid full card");
    if (this.yVM == null)
    {
      localObject1 = "";
      label2055:
      paramInt2 = 0;
      if (localp == null) {
        break label3446;
      }
      if (!localp.dWa()) {
        break label2112;
      }
      paramInt2 = 1;
    }
    label2074:
    label2112:
    label2118:
    label2124:
    label2404:
    label3317:
    label3446:
    for (Object localObject3 = localp.dYT();; localObject3 = "")
    {
      com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.zcX, (String)localObject1, 1, paramInt2, (String)localObject3);
      break;
      localObject1 = q.zw(this.yVM.field_snsId);
      break label2055;
      paramInt2 = 0;
      break label2074;
      localObject1 = null;
      break label1379;
      if ((paramTimeLineObject.HAT.GaP == 15) || (paramTimeLineObject.HAT.GaP == 5))
      {
        if (this.AwW)
        {
          locala.Atv.zWz.setVisibility(0);
          locala.Atv.zWy.setVisibility(8);
          locala.Atv.zWz.setVideoCallback(new OfflineVideoView.a()
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
              boolean bool = e.a(e.this).ebw();
              if ((e.b(e.this)) && (this.AwX != null) && (this.AwX.zxn == null) && (!bool)) {
                locala.Atv.zWz.restart();
              }
              e.this.a(parambh, parambi, this.AwX, 0);
              AppMethodBeat.o(179357);
            }
            
            public final void onStart(int paramAnonymousInt)
            {
              AppMethodBeat.i(179356);
              ad.i("MicroMsg.FullCardAdTimeLineItem", "onStart:".concat(String.valueOf(paramAnonymousInt)));
              AppMethodBeat.o(179356);
            }
            
            public final void tt(int paramAnonymousInt)
            {
              AppMethodBeat.i(179358);
              int i = paramAnonymousInt / 1000;
              e.this.a(parambi, this.AwX, localp, i, locala.Atv.zWz.getDurationMs() / 1000);
              Object localObject2 = null;
              Object localObject1 = localObject2;
              if (parambh != null)
              {
                localObject1 = localObject2;
                if (parambh.AjE != null) {
                  localObject1 = parambh.AjE.zPb;
                }
              }
              e.a(e.this).a((com.tencent.mm.plugin.sns.ad.d.i)localObject1, paramAnonymousInt, parambi.AmB);
              AppMethodBeat.o(179358);
            }
          });
          if (localObject2 != null)
          {
            d.j(((b.g)localObject2).zxj, locala.AtW);
            d.j(((b.g)localObject2).zxl, locala.AtX);
          }
          if (localObject2 != null) {
            break label2718;
          }
          localObject3 = null;
          final String str = localp.dRL().dWj();
          if ((!bt.isNullOrNil(str)) && (localObject3 != null) && (((b.g.a)localObject3).startTime >= 0L) && (((b.g.a)localObject3).endTime > ((b.g.a)localObject3).startTime)) {
            com.tencent.mm.sdk.g.b.c(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100079);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.dYe().f("adId", str, "adxml", 0);
                AppMethodBeat.o(100079);
              }
            }, "preDownloadFloatPage");
          }
          long l = System.nanoTime();
          bool = f.t((byn)localObject1);
          ad.i("MicroMsg.FullCardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
          localObject3 = locala.Atv;
          if (bool) {
            break label2904;
          }
          if (!((f)localObject4).w((byn)localObject1)) {
            break label2728;
          }
          ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWB.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWB.fLr();
          locala.Atv.zWx.setVisibility(0);
          locala.AtT.setVisibility(4);
          ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWy.setTagObject(localObject3);
          ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWz.setTag(localObject3);
          ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWA.setTag(paramBaseViewHolder);
          locala.Atv.zWx.setOnClickListener(this.Auf);
          if (!this.AwW) {
            break label3263;
          }
          paramBaseViewHolder = ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWz;
          paramInt1 = this.mActivity.hashCode();
          localObject3 = bj.frn();
          ((bj)localObject3).hbR = paramTimeLineObject.CreateTime;
          ((f)localObject4).a(localp, (byn)localObject1, paramBaseViewHolder, paramInt1, (bj)localObject3, parambi.zOM);
          d.a((b.g)localObject2, 0, locala.AtW, locala.AtX);
          paramBaseViewHolder = ao.jo(ag.getAccSnsPath(), ((byn)localObject1).Id);
          paramTimeLineObject = q.i((byn)localObject1);
          if (!com.tencent.mm.vfs.i.fv(paramBaseViewHolder + paramTimeLineObject)) {
            break label3317;
          }
          parambh.AjE.zPb.B(parambi.AmB, true);
          if (ag.dUb().b(localp, null) != 5) {
            break label3336;
          }
        }
        for (bool = true;; bool = false)
        {
          parambh.AjE.zPb.c(parambi.AmB, bool, false);
          AppMethodBeat.o(100082);
          return;
          locala.Atv.zWz.setVisibility(8);
          locala.Atv.zWy.setVisibility(0);
          locala.Atv.zWy.setOnCompletionListener(new b.e()
          {
            public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              AppMethodBeat.i(179362);
              StringBuilder localStringBuilder = new StringBuilder("sight play completed, retCode=").append(paramAnonymousInt).append(", snsId=");
              if (localp == null) {}
              for (paramAnonymousb = "";; paramAnonymousb = Long.valueOf(localp.field_snsId))
              {
                ad.i("MicroMsg.FullCardAdTimeLineItem", paramAnonymousb);
                e.this.a(parambh, parambi, this.AwX, paramAnonymousInt);
                AppMethodBeat.o(179362);
                return;
              }
            }
          });
          locala.Atv.zWy.setOnDecodeDurationListener(new b.f()
          {
            public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
            {
              AppMethodBeat.i(179363);
              ad.d("MicroMsg.FullCardAdTimeLineItem", "sight play %d", new Object[] { Long.valueOf(paramAnonymousLong) });
              e.this.a(parambi, this.AwX, localp, paramAnonymousLong, (int)paramAnonymousb.dQg());
              AppMethodBeat.o(179363);
            }
          });
          break;
          localObject3 = ((b.g)localObject2).zxi;
          break label2248;
          if (((f)localObject4).b(localp, null) == 5)
          {
            ((f)localObject4).A((byn)localObject1);
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWB.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWB.fLr();
            break label2404;
          }
          if (((f)localObject4).x((byn)localObject1))
          {
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWB.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setImageResource(2131691612);
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setVisibility(0);
            break label2404;
          }
          ((f)localObject4).y((byn)localObject1);
          ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setVisibility(0);
          ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWB.setVisibility(8);
          ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
          ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setContentDescription(this.mActivity.getString(2131761939));
          if (((f)localObject4).b(localp, null) != 4) {
            break label2404;
          }
          ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFE.setVisibility(0);
          break label2404;
          if (((f)localObject4).u((byn)localObject1))
          {
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWB.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setContentDescription(this.mActivity.getString(2131761939));
            if (!this.AwW) {
              break label3247;
            }
          }
          for (bool = ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWz.isError();; bool = ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWy.ySq.dQd())
          {
            if (!bool) {
              break label3261;
            }
            ad.e("MicroMsg.FullCardAdTimeLineItem", "play video error " + ((byn)localObject1).Id + " " + ((byn)localObject1).Url + " " + ((byn)localObject1).GSI + " " + paramInt1);
            ((f)localObject4).y((byn)localObject1);
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWB.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setContentDescription(this.mActivity.getString(2131761939));
            break;
            if (((f)localObject4).v((byn)localObject1))
            {
              ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWB.setVisibility(8);
              break label2967;
            }
            if (((f)localObject4).b(localp, null) <= 5)
            {
              if (locala.AwE) {
                break label2967;
              }
              ad.i("MicroMsg.FullCardAdTimeLineItem", "fillItem, showPlayBtn");
              eeg();
              break label2967;
            }
            ((f)localObject4).y((byn)localObject1);
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setVisibility(0);
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWB.setVisibility(8);
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
            ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zFD.setContentDescription(this.mActivity.getString(2131761939));
            break label2967;
          }
          break label2404;
          paramBaseViewHolder = ((com.tencent.mm.plugin.sns.ui.aq)localObject3).zWy;
          paramInt2 = this.mActivity.hashCode();
          localObject3 = bj.frn();
          ((bj)localObject3).hbR = paramTimeLineObject.CreateTime;
          ((f)localObject4).a(localp, (byn)localObject1, paramBaseViewHolder, paramInt2, paramInt1, (bj)localObject3, parambi.zOM, true);
          break label2523;
          parambh.AjE.zPb.B(parambi.AmB, false);
          break label2599;
        }
        ((f)localObject4).a(paramBaseViewHolder.Atv.zWy, this.mActivity.hashCode(), paramInt1);
        ((f)localObject4).a(paramBaseViewHolder.Atv.zWz, this.mActivity.hashCode());
        paramBaseViewHolder.Atv.zWC.setVisibility(8);
        paramBaseViewHolder.Atv.zWy.setOnSightCompletionAction(null);
        paramBaseViewHolder.Atv.zWy.setOnCompletionListener(null);
        paramBaseViewHolder.Atv.zWy.setOnDecodeDurationListener(null);
        paramBaseViewHolder.Atv.zWz.setVideoCallback(null);
      }
      AppMethodBeat.o(100082);
      return;
    }
  }
  
  final void a(final a parama)
  {
    AppMethodBeat.i(100083);
    com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179367);
        e.a.b(parama).setVisibility(8);
        e.a.b(parama).setBackgroundColor(0);
        e.a.b(parama).efd();
        e.a.b(parama).setOnGestureListener(null);
        AppMethodBeat.o(179367);
      }
    });
    AppMethodBeat.o(100083);
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(176426);
    if ((this.AwS != null) && (this.AwS.zYc != null))
    {
      Object localObject = new int[2];
      this.AwS.zYc.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.AwS.zYc.getMeasuredWidth() + i, this.AwS.zYc.getMeasuredHeight() + j);
      AppMethodBeat.o(176426);
      return localObject;
    }
    AppMethodBeat.o(176426);
    return null;
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100081);
    this.AwS = ((a)paramBaseViewHolder);
    if (paramBaseViewHolder.Avc != null)
    {
      paramBaseViewHolder.Avc.setLayoutResource(2131495603);
      if (!paramBaseViewHolder.Avd)
      {
        this.AwS.zYc = paramBaseViewHolder.Avc.inflate();
        paramBaseViewHolder.Avd = true;
      }
      this.AwS.sUS = this.AwS.tPw.findViewById(2131306008);
      this.AwS.AtN = this.AwS.tPw.findViewById(2131297449);
      this.AwS.AtO = ((TextView)this.AwS.tPw.findViewById(2131306010));
      this.AwS.AtP = ((TextView)this.AwS.tPw.findViewById(2131306009));
      this.AwS.AtQ = ((TextView)this.AwS.tPw.findViewById(2131297451));
      this.AwS.AtR = ((TextView)this.AwS.tPw.findViewById(2131297450));
      this.AwS.AtT = ((MaskImageView)this.AwS.tPw.findViewById(2131300322));
      this.AwS.AtS = this.AwS.tPw.findViewById(2131297455);
      this.AwS.AtT.setScaleType(QImageView.a.KTb);
      this.AwS.Atv = new com.tencent.mm.plugin.sns.ui.aq();
      this.AwS.Atv.zWA = this.AwS.zYc.findViewById(2131300324);
      this.AwS.Atv.zWx = this.AwS.Atv.zWA;
      this.AwS.Atv.zWA.setOnClickListener(this.Aug);
      this.AwS.Atv.zWy = ((VideoSightView)this.AwS.Atv.zWA.findViewById(2131300914));
      this.AwS.Atv.zWz = ((SnsAdTimelineVideoView)this.AwS.Atv.zWA.findViewById(2131302995));
      paramBaseViewHolder.Atv.zWy.setMute(true);
      paramBaseViewHolder.Atv.zWz.setMute(true);
      this.AwS.Atv.zFD = ((ImageView)this.AwS.zYc.findViewById(2131300323));
      this.AwS.Atv.zWB = ((MMPinProgressBtn)this.AwS.Atv.zWA.findViewById(2131303515));
      this.AwS.Atv.zWC = ((TextView)this.AwS.Atv.zWA.findViewById(2131299492));
      this.AwS.Atv.zFE = ((TextView)this.AwS.Atv.zWA.findViewById(2131299517));
      this.AwS.Atv.zWy.ySy = true;
      this.AwS.Atv.zWy.setScaleType(QImageView.a.KTb);
      a.a(this.AwS, (SnsDrawGestureView)this.AwS.tPw.findViewById(2131304972));
      this.AwS.AtW = ((ImageView)this.AwS.tPw.findViewById(2131300311));
      this.AwS.AtX = ((ImageView)this.AwS.tPw.findViewById(2131299487));
      this.AwS.AtY = ((SnsAdCardVideoEndView)this.AwS.tPw.findViewById(2131304975));
      if (this.AwS.Aua != null) {
        break label806;
      }
      paramBaseViewHolder = ((ViewStub)this.AwS.Awd.findViewById(2131304926)).inflate();
      this.AwS.Aua = ((SnsAdSphereAnimView)paramBaseViewHolder.findViewById(2131304925));
      this.AwS.Axb = ((SnsAdTouchProgressView)paramBaseViewHolder.findViewById(2131308213));
    }
    for (;;)
    {
      this.AwS.Aua.setVisibility(8);
      this.AwS.Axb.setVisibility(8);
      this.AwT = new ax(this.mActivity, this.AwS, this.AwS.Awd);
      this.AwT.zZq = this.Auh;
      this.AwU = d.eeh();
      AppMethodBeat.o(100081);
      return;
      if (paramBaseViewHolder.Avd) {
        break;
      }
      this.AwS.zYc = paramBaseViewHolder.tPw.findViewById(2131300321);
      paramBaseViewHolder.Avd = true;
      break;
      label806:
      ad.e("MicroMsg.FullCardAdTimeLineItem", "buildContent many times");
    }
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177694);
    ad.i("MicroMsg.FullCardAdTimeLineItem", "onUIPause");
    eef();
    AppMethodBeat.o(177694);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176424);
    ad.i("MicroMsg.FullCardAdTimeLineItem", "pause");
    if (eef()) {
      eeg();
    }
    AppMethodBeat.o(176424);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176425);
    ad.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd stop", new Object[] { this });
    if ((this.AwS != null) && (this.AwS.Atv != null))
    {
      if (!this.AwW) {
        break label71;
      }
      this.AwS.Atv.zWz.clear();
    }
    for (;;)
    {
      this.Awr = false;
      AppMethodBeat.o(176425);
      return;
      label71:
      this.AwS.Atv.zWy.ySq.clear();
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View AtN;
    public TextView AtO;
    public TextView AtP;
    public TextView AtQ;
    public TextView AtR;
    public View AtS;
    public MaskImageView AtT;
    private SnsDrawGestureView AtU;
    public ImageView AtW;
    public ImageView AtX;
    public SnsAdCardVideoEndView AtY;
    public SnsAdSphereAnimView Aua;
    public boolean AwE = false;
    public SnsAdTouchProgressView Axb;
    public View sUS;
    public View zYc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.e
 * JD-Core Version:    0.7.0.1
 */