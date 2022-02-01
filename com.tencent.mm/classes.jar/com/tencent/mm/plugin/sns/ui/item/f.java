package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView.a;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.ADXml.g.a;
import com.tencent.mm.plugin.sns.storage.ADXml.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.video.d;
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
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  Handler DAC;
  private SnsInfo DqO;
  private View.OnClickListener EVA;
  protected SnsAdTouchProgressView.a EVB;
  protected TwistCoverView.a EVC;
  boolean EVs;
  private View.OnClickListener EVz;
  volatile boolean EXV;
  a EYE;
  private ba EYF;
  private boolean EYG;
  private boolean EYH;
  boolean EYI;
  
  public f()
  {
    AppMethodBeat.i(176422);
    this.DAC = new Handler(Looper.getMainLooper());
    this.EXV = false;
    this.EVs = false;
    this.EYG = false;
    this.EYH = false;
    this.EYI = false;
    this.EVz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176420);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.FullCardAdTimeLineItem", "ProxyCardClickListener onClick");
        try
        {
          f.this.DQX.DQs.Fbd.onClick(paramAnonymousView);
          if (f.c(f.this)) {
            SnsAdCardVideoEndView.i(f.d(f.this), 1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(176420);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            Log.e("MicroMsg.FullCardAdTimeLineItem", "ProxyCardClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.EVA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176421);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.FullCardAdTimeLineItem", "ProxySightClickListener onClick");
        try
        {
          f.this.DQX.DQs.FaQ.onClick(paramAnonymousView);
          if (f.c(f.this)) {
            SnsAdCardVideoEndView.i(f.d(f.this), 1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(176421);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            Log.e("MicroMsg.FullCardAdTimeLineItem", "mProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.EVB = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203923);
        try
        {
          Log.i("MicroMsg.FullCardAdTimeLineItem", "SnsAdTouchProgressView onClick");
          f.f(f.this).EUK.Ewr.performClick();
          AppMethodBeat.o(203923);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          Log.e("MicroMsg.FullCardAdTimeLineItem", "SnsAdTouchProgressView onClick exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(203923);
        }
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(203924);
        f.this.DQX.EKl.EoV.a(f.f(f.this), null);
        com.tencent.mm.plugin.sns.data.r.e(new long[] { 20L, 100L });
        e.a(f.this.mActivity, f.f(f.this).ExX, f.d(f.this), 1);
        if (f.d(f.this) != null)
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(1, 1, com.tencent.mm.plugin.sns.data.r.aOw(f.d(f.this).getTimeLine().Id), 28, 21);
          if ((f.this.mActivity instanceof SnsTimeLineUI)) {
            com.tencent.mm.plugin.sns.data.k.a(localSnsAdClick, ((SnsTimeLineUI)f.this.mActivity).fjf(), f.d(f.this), 28);
          }
          com.tencent.mm.plugin.sns.data.r.a(localSnsAdClick);
          Log.i("MicroMsg.FullCardAdTimeLineItem", "onFinish report MMOCAD_CLICKPOS_AD_FULL_CARD_LONGPRESS");
          AppMethodBeat.o(203924);
          return;
        }
        Log.e("MicroMsg.FullCardAdTimeLineItem", "onFinish report, mSnsinfo==null");
        AppMethodBeat.o(203924);
      }
      
      public final void onStart() {}
    };
    this.EVC = new TwistCoverView.a()
    {
      public final void eYQ()
      {
        AppMethodBeat.i(203921);
        f.f(f.this).EYi = true;
        if (f.d(f.this) == null)
        {
          Log.e("MicroMsg.FullCardAdTimeLineItem", "onTwist, mSnsInfo==null");
          AppMethodBeat.o(203921);
          return;
        }
        Object localObject = new Bundle();
        ((Bundle)localObject).putBoolean("isFromTwist", true);
        ADXml.k localk = f.d(f.this).getAdXml().adTwistInfo;
        if (localk != null)
        {
          ((Bundle)localObject).putBoolean("isSimpleTwistAnim", localk.DWW);
          ((Bundle)localObject).putBoolean("isTwistClockwise", localk.DWV);
          if (localk.DWW) {
            com.tencent.mm.plugin.sns.data.r.e(new long[] { 0L, 80L });
          }
        }
        f.this.DQX.EKl.EoV.a(f.f(f.this), (Bundle)localObject);
        e.a(f.this.mActivity, f.f(f.this).ExX, f.d(f.this), 1);
        try
        {
          localObject = new SnsAdClick(1, 1, com.tencent.mm.plugin.sns.data.r.aOw(f.d(f.this).getTimeLine().Id), 29, 21);
          if ((f.this.mActivity instanceof SnsTimeLineUI)) {
            com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject, ((SnsTimeLineUI)f.this.mActivity).fjf(), f.d(f.this), 29);
          }
          com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject);
          Log.i("MicroMsg.FullCardAdTimeLineItem", "onTwist report MMOCAD_CLICKPOS_AD_FULL_CARD_TWIST");
          AppMethodBeat.o(203921);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("MicroMsg.FullCardAdTimeLineItem", "twist click report exp=" + localThrowable.toString());
          AppMethodBeat.o(203921);
        }
      }
    };
    AppMethodBeat.o(176422);
  }
  
  private void ab(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(203925);
    if ((this.DQX != null) && (this.DQX.EKl != null) && (this.DQX.EKl.EoE != null) && (paramSnsInfo != null)) {
      this.DQX.EKl.EoE.IU(paramSnsInfo.field_snsId);
    }
    AppMethodBeat.o(203925);
  }
  
  private boolean fkp()
  {
    AppMethodBeat.i(177695);
    if ((this.EYE.timeLineObject.ContentObj.LoU == 5) || (this.EYE.timeLineObject.ContentObj.LoU == 15))
    {
      Log.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd doPause", new Object[] { this });
      if ((this.EYE != null) && (this.EYE.EUK != null))
      {
        if (!this.EYI) {
          break label160;
        }
        this.EYE.EUK.Ewt.pause();
        this.EYE.EUK.Ewt.setShouldPlayWhenPrepared(false);
        this.EYF.fhy();
      }
      for (;;)
      {
        ab(this.DqO);
        if ((this.DqO != null) && (this.DqO.isTwistAd())) {
          this.EYE.EVy.onPlayerPaused();
        }
        this.EXV = false;
        AppMethodBeat.o(177695);
        return true;
        label160:
        this.EYE.EUK.Ews.pause();
      }
    }
    AppMethodBeat.o(177695);
    return false;
  }
  
  private void fkq()
  {
    AppMethodBeat.i(176427);
    Log.i("MicroMsg.FullCardAdTimeLineItem", "try show play btn");
    if ((this.EYE != null) && (this.EYE.EUK != null) && (!this.EXV))
    {
      Log.i("MicroMsg.FullCardAdTimeLineItem", "show play btn");
      this.EYE.EUK.EeS.setVisibility(0);
      this.EYE.EUK.Ewv.setVisibility(8);
      this.EYE.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
      this.EYE.EUK.EeS.setContentDescription(this.mActivity.getString(2131763945));
    }
    AppMethodBeat.o(176427);
  }
  
  protected final void a(bk parambk, bl parambl, final ADXml.g paramg, int paramInt)
  {
    AppMethodBeat.i(179370);
    Log.i("MicroMsg.FullCardAdTimeLineItem", "doOnVideoCompletion, ret=".concat(String.valueOf(paramInt)));
    if (paramInt != -1)
    {
      if ((parambk == null) || (parambk.EKl == null) || (parambk.EKl.EoE == null))
      {
        AppMethodBeat.o(179370);
        return;
      }
      parambk.EKl.EoE.I(parambl.ENp, false);
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179361);
        f localf = f.this;
        ADXml.g localg = paramg;
        if (localg != null) {
          for (;;)
          {
            try
            {
              if ((localg.DWE == null) || (!localf.EXV)) {
                break;
              }
              if (localf.EYI)
              {
                localf.EYE.EVr.setBlurBkg(localf.EYE.EUK.Ewt.getInnerVideoView());
                localf.EYE.EVr.bpn();
                localf.EYE.EVr.fkZ();
                localf.EVs = true;
                if (localf.EYI)
                {
                  localf.EYE.EUK.Ewt.setShouldPlayWhenPrepared(false);
                  localf.EYE.EUK.Ewt.pause();
                  localf.a(localf.EYE);
                  localf.DAC.postDelayed(new f.10(localf), localg.DWE.duration);
                  AppMethodBeat.o(179361);
                }
              }
              else
              {
                localf.EYE.EVr.setBlurBkg(localf.EYE.ExX);
                continue;
              }
              localException.EYE.EUK.Ews.pause();
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.FullCardAdTimeLineItem", "handleVideoCompletion, exp" + localException.toString());
              AppMethodBeat.o(179361);
              return;
            }
          }
        }
        localException.EYE.EVr.eQ(false);
        AppMethodBeat.o(179361);
      }
    });
    AppMethodBeat.o(179370);
  }
  
  protected final void a(final bl parambl, ADXml.g paramg, final SnsInfo paramSnsInfo, long paramLong, int paramInt)
  {
    AppMethodBeat.i(179371);
    if ((this.DQX == null) || (this.DQX.EKl == null) || (this.DQX.EKl.EoE == null) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(179371);
      return;
    }
    if (((paramg == null) || (paramg.DWE == null)) && (this.EYE.EVr.getVisibility() == 0)) {
      this.EYE.EVr.eQ(false);
    }
    this.DQX.EKl.EoE.IT(paramSnsInfo.field_snsId);
    this.DQX.EKl.EoE.ao(paramSnsInfo.field_snsId, paramLong);
    if (!this.DQX.EKl.EoE.IQ(parambl.ENp))
    {
      this.DQX.EKl.EoE.c(parambl.ENp, Util.currentTicks(), false);
      this.DQX.EKl.EoE.e(parambl.ENp, paramInt, false);
      this.DQX.EKl.EoE.an(parambl.ENp, parambl.ENp);
    }
    Log.d("MicroMsg.FullCardAdTimeLineItem", "doOnVideoPlaying, currentTime=" + paramLong + ", duration=" + paramInt);
    final a locala = this.EYE;
    paramInt = (int)paramLong;
    if (paramg == null)
    {
      parambl = null;
      if ((!Util.isNullOrNil(paramSnsInfo.getAdXml().getGestureCanvasInfo())) && (parambl != null) && (parambl.startTime >= 0L) && (parambl.endTime > parambl.startTime))
      {
        Log.i("MicroMsg.FullCardAdTimeLineItem", "%d-%d,%d", new Object[] { Long.valueOf(parambl.startTime), Long.valueOf(parambl.endTime), Integer.valueOf(paramInt) });
        if ((parambl.startTime > paramInt) || (parambl.endTime < paramInt)) {
          break label432;
        }
        if (a.b(locala).getOnGestureListener() == null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100079);
              f.a.b(locala).setVisibility(0);
              f.a.b(locala).flk();
              f.a.b(locala).setPaintColor(parambl.color);
              f.a.b(locala).setOnGestureListener(new SnsDrawGestureView.a()
              {
                public final void fkn()
                {
                  AppMethodBeat.i(100076);
                  com.tencent.mm.plugin.sns.data.r.uN(false);
                  f.a.b(f.6.this.EYK).setBackgroundColor(f.this.mActivity.getResources().getColor(2131101102));
                  AppMethodBeat.o(100076);
                }
                
                public final void hi(List<PointF> paramAnonymous2List)
                {
                  int i = 1;
                  AppMethodBeat.i(100077);
                  com.tencent.mm.plugin.sns.data.r.uN(true);
                  Object localObject = com.tencent.mm.plugin.sns.data.r.aOy(f.6.this.EVH.DWH);
                  f.a.b(f.6.this.EYK).setBackgroundColor(0);
                  if ((((List)localObject).size() > 0) && (paramAnonymous2List.size() > 0)) {
                    try
                    {
                      paramAnonymous2List = com.tencent.mm.ui.tools.a.a.jX(paramAnonymous2List);
                      double d1 = com.tencent.mm.ui.tools.a.a.E((List)localObject, paramAnonymous2List);
                      String str = com.tencent.mm.plugin.sns.data.r.gO((List)localObject);
                      Collections.reverse((List)localObject);
                      double d2 = com.tencent.mm.ui.tools.a.a.E((List)localObject, paramAnonymous2List);
                      float f = (float)Math.min(d1, d2);
                      Log.i("MicroMsg.FullCardAdTimeLineItem", "similarity: %f,%f, distance:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Float.valueOf(f) });
                      if (f <= f.6.this.EVH.DWG)
                      {
                        f.this.DQX.EKl.EoV.a(f.6.this.EYK, null);
                        com.tencent.mm.plugin.sns.data.r.e(new long[] { 20L, 100L });
                        e.a(f.this.mActivity, f.6.this.EYK.ExX, f.6.this.DxI, 1);
                        localObject = new SnsAdClick(1, 1, com.tencent.mm.plugin.sns.data.r.aOw(f.6.this.DxI.getTimeLine().Id), 25, 21);
                        if ((f.this.mActivity instanceof SnsTimeLineUI)) {
                          com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject, ((SnsTimeLineUI)f.this.mActivity).fjf(), f.6.this.DxI, 25);
                        }
                        com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject);
                        i = 2;
                      }
                      h.CyF.a(16552, new Object[] { f.6.this.DxI.getTimeLine().Id, str, com.tencent.mm.plugin.sns.data.r.gO(com.tencent.mm.ui.tools.a.a.jV(paramAnonymous2List)), Integer.valueOf((int)(100.0F * f)), Integer.valueOf(i), Long.valueOf(Util.safeParseLong(f.6.this.DxI.getAid())), f.6.this.DxI.getAdInfo().uxInfo });
                      e.a(i, f, f.6.this.EVH.DWG, f.6.this.DxI.getAdInfo().uxInfo, f.6.this.DxI.getTimeLine().Id, 1);
                      return;
                    }
                    catch (Exception paramAnonymous2List)
                    {
                      Log.printErrStackTrace("MicroMsg.FullCardAdTimeLineItem", paramAnonymous2List, "recog gesture error!", new Object[0]);
                      return;
                    }
                    finally
                    {
                      f.a.b(f.6.this.EYK).flk();
                      AppMethodBeat.o(100077);
                    }
                  }
                  AppMethodBeat.o(100077);
                }
                
                public final void onClick()
                {
                  AppMethodBeat.i(100078);
                  com.tencent.mm.plugin.sns.data.r.uN(true);
                  f.a.b(f.6.this.EYK).setBackgroundColor(0);
                  f.6.this.EYK.EUK.Ewr.performClick();
                  AppMethodBeat.o(100078);
                }
              });
              AppMethodBeat.o(100079);
            }
          });
        }
      }
    }
    for (;;)
    {
      e.a(paramg, (int)paramLong, this.EYE.EVp, this.EYE.EVq);
      if (paramSnsInfo.isTwistAd()) {
        this.EYE.EVy.IW(paramLong);
      }
      AppMethodBeat.o(179371);
      return;
      parambl = paramg.DWz;
      break;
      label432:
      a(locala);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176423);
    if ((paramBaseViewHolder.timeLineObject.ContentObj.LoU == 5) || (paramBaseViewHolder.timeLineObject.ContentObj.LoU == 15))
    {
      Log.i("MicroMsg.FullCardAdTimeLineItem", "play: hash=" + hashCode() + ", pos=" + paramInt + ", isEndViewShow=" + this.EVs + ", isPlayingSight=" + this.EXV);
      d.fkS().cXa();
      com.tencent.mm.plugin.sns.ui.video.b.fkM().a(this);
      if (!this.EVs)
      {
        if (!this.EYI) {
          break label265;
        }
        paramBaseViewHolder.EUK.Ewt.setShouldPlayWhenPrepared(true);
        paramBaseViewHolder.EUK.Ewt.start();
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.FullCardAdTimeLineItem", "try hide play btn");
      if ((this.EYE != null) && (this.EYE.EUK != null))
      {
        Log.i("MicroMsg.FullCardAdTimeLineItem", "hide play btn");
        this.EYE.EUK.EeS.setVisibility(8);
        this.EYE.EUK.Ewv.setVisibility(8);
      }
      this.EXV = true;
      if ((paramBaseViewHolder instanceof a)) {
        ((a)paramBaseViewHolder).EYi = false;
      }
      if ((!this.EVs) && (this.EYE.EVr.getVisibility() == 0)) {
        this.EYE.EVr.eQ(true);
      }
      AppMethodBeat.o(176423);
      return;
      label265:
      paramBaseViewHolder.EUK.Ews.start();
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, final bk parambk)
  {
    AppMethodBeat.i(100082);
    Log.i("MicroMsg.FullCardAdTimeLineItem", "ad fillItem, fullCardAd, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
    if (paramBaseViewHolder.hho)
    {
      Log.i("MicroMsg.FullCardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(100082);
      return;
    }
    final a locala = (a)paramBaseViewHolder;
    final SnsInfo localSnsInfo = parambl.DqO;
    this.DqO = localSnsInfo;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (localSnsInfo != null)
    {
      localObject2 = localObject1;
      if (localSnsInfo.getAdXml() != null) {
        localObject2 = localSnsInfo.getAdXml().adFullCardInfo;
      }
    }
    localObject1 = (WindowManager)this.mActivity.getSystemService("window");
    int i = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    localObject1 = null;
    locala.wnX.setVisibility(8);
    locala.uXS.setVisibility(8);
    locala.EVi.setVisibility(8);
    locala.EVh.setVisibility(8);
    locala.EVj.setVisibility(8);
    locala.EVk.setVisibility(8);
    locala.EVl.setVisibility(8);
    a.b(locala).setVisibility(8);
    locala.EYN.setVisibility(8);
    locala.EVt.setVisibility(8);
    locala.EUK.Ews.setOnCompletionListener(null);
    locala.EUK.Ews.setOnDecodeDurationListener(null);
    locala.EUK.Ewt.setVideoCallback(null);
    a(locala);
    boolean bool;
    label490:
    label502:
    Object localObject4;
    if (localObject2 != null)
    {
      locala.EVr.a(((ADXml.g)localObject2).DWE, 1);
      if ((localSnsInfo != null) && (locala.EVr.ac(localSnsInfo)))
      {
        this.DAC.removeCallbacksAndMessages(null);
        this.EVs = false;
      }
      localObject3 = locala.EUK.Ews;
      if (((ADXml.g)localObject2).DWE != null)
      {
        bool = true;
        ((VideoSightView)localObject3).setIsForbidLoopAnim(bool);
        int j = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 56);
        int k = this.mActivity.getResources().getDimensionPixelSize(2131165508);
        int m = this.mActivity.getResources().getDimensionPixelSize(2131165534);
        paramInt2 = i - j - k - m;
        if (((ADXml.g)localObject2).DWw != 0) {
          break label1659;
        }
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
        if (localObject1 == null) {
          break label1701;
        }
        paramInt2 = ((ViewGroup.LayoutParams)localObject1).height;
        localObject3 = new Rect(k + j, j - m, i - m, paramInt2 + (j - m));
        this.EYH = this.EYF.a(this.DqO, ((ADXml.g)localObject2).DWF, (Rect)localObject3);
        if ((!this.EYG) && (!this.EYH)) {
          break label1707;
        }
        bool = true;
        label573:
        this.EYI = bool;
        locala.EUK.EwA = this.EYI;
        localObject4 = new StringBuilder("fillItem, isExptUseNewPlayer=").append(this.EYG).append(", isLongPressGestureAd=").append(this.EYH).append(", hash=").append(hashCode()).append(", snsId=");
        if (localSnsInfo != null) {
          break label1713;
        }
        localObject3 = "";
        label652:
        Log.i("MicroMsg.FullCardAdTimeLineItem", localObject3);
        if (localSnsInfo != null)
        {
          locala.EVy.a(localSnsInfo, localSnsInfo.getAdXml().adTwistInfo, 1);
          if (!localSnsInfo.isTwistAd()) {
            break label1726;
          }
          locala.EUK.Ewt.setTimerInterval(300);
        }
        label713:
        if (localObject1 == null) {
          break label1751;
        }
        localObject3 = locala.ExX.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.ExX.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((RoundedCornerFrameLayout)locala.ExX).setRadius(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8));
        localObject3 = locala.EVm.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.EVm.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.EUK.Ewr.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.EUK.Ewr.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        locala.EUK.Ews.im(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        localObject3 = locala.EUK.Ewt.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.EUK.Ewt.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.EVp.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.EVp.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.EVq.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.EVq.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.EVr.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.EVr.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        if (((ADXml.g)localObject2).DWy != 0) {
          break label1808;
        }
        paramInt2 = Color.argb((int)(((ADXml.g)localObject2).DWx * 2.55F), 0, 0, 0);
        i = Color.argb(0, 0, 0, 0);
        localObject1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt2, i });
        ((GradientDrawable)localObject1).setGradientType(0);
        locala.wnX.setBackground((Drawable)localObject1);
        if ((!Util.isNullOrNil(((ADXml.g)localObject2).title)) || (!Util.isNullOrNil(((ADXml.g)localObject2).description))) {
          locala.wnX.setVisibility(0);
        }
        if (!Util.isNullOrNil(((ADXml.g)localObject2).title))
        {
          locala.uXS.setVisibility(0);
          locala.uXS.setText(com.tencent.mm.ce.g.gxZ().a(locala.uXS.getContext(), ((ADXml.g)localObject2).title, locala.uXS.getTextSize()));
        }
        if (!Util.isNullOrNil(((ADXml.g)localObject2).description))
        {
          locala.EVi.setVisibility(0);
          locala.EVi.setText(com.tencent.mm.ce.g.gxZ().a(locala.EVi.getContext(), ((ADXml.g)localObject2).description, locala.EVi.getTextSize()));
        }
      }
      for (;;)
      {
        if (localSnsInfo.getAdInfo().isWeapp())
        {
          paramInt2 = Color.argb((int)(((ADXml.g)localObject2).DWx * 2.55F), 0, 0, 0);
          i = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
          ((GradientDrawable)localObject1).setGradientType(0);
          locala.EVh.setVisibility(0);
          locala.EVh.setBackground((Drawable)localObject1);
          locala.EVl.setVisibility(0);
        }
        if ((paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.LoV.size() <= 0)) {
          break label2153;
        }
        localObject1 = (cnb)paramTimeLineObject.ContentObj.LoV.get(0);
        label1407:
        localObject3 = aj.faL();
        if ((paramBaseViewHolder.EUK.Ewq != null) && (!Util.isEqual(paramBaseViewHolder.EUK.Ewq.Id, paramTimeLineObject.Id)))
        {
          Log.i("MicroMsg.FullCardAdTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.EUK.Ewq.Id });
          ((com.tencent.mm.plugin.sns.model.g)localObject3).a(paramBaseViewHolder.EUK.Ews, this.mActivity.hashCode(), paramInt1);
          ((com.tencent.mm.plugin.sns.model.g)localObject3).a(paramBaseViewHolder.EUK.Ewt, this.mActivity.hashCode());
        }
        paramBaseViewHolder.EUK.a(paramTimeLineObject, paramInt1, parambl.Eql, parambl.Eoq);
        paramBaseViewHolder.EUK.EeT.setVisibility(8);
        if (localObject1 == null) {
          break label3386;
        }
        if (paramTimeLineObject.ContentObj.LoU != 1) {
          break label2159;
        }
        locala.EVm.setVisibility(0);
        locala.EUK.Ewr.setVisibility(4);
        parambl = locala.EVm;
        paramInt1 = this.mActivity.hashCode();
        parambk = bp.gCU();
        parambk.hXs = paramTimeLineObject.CreateTime;
        ((com.tencent.mm.plugin.sns.model.g)localObject3).b((cnb)localObject1, parambl, -1, paramInt1, parambk);
        locala.EVm.setTag(paramBaseViewHolder);
        locala.EVm.setOnClickListener(this.EVz);
        locala.EYi = false;
        AppMethodBeat.o(100082);
        return;
        bool = false;
        break;
        label1659:
        if (((ADXml.g)localObject2).DWw != 1) {
          break label490;
        }
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
        break label490;
        label1701:
        paramInt2 = 0;
        break label502;
        label1707:
        bool = false;
        break label573;
        label1713:
        localObject3 = Long.valueOf(localSnsInfo.field_snsId);
        break label652;
        label1726:
        locala.EUK.Ewt.setTimerInterval(1000);
        locala.EVy.clear();
        break label713;
        label1751:
        localObject3 = new StringBuilder("mediaLayout==null, snsId=");
        if (this.DqO == null) {}
        for (localObject1 = "";; localObject1 = Long.valueOf(this.DqO.field_snsId))
        {
          Log.e("MicroMsg.FullCardAdTimeLineItem", localObject1);
          break;
        }
        label1808:
        if (((ADXml.g)localObject2).DWy == 1)
        {
          paramInt2 = Color.argb((int)(((ADXml.g)localObject2).DWx * 2.55F), 0, 0, 0);
          i = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
          ((GradientDrawable)localObject1).setGradientType(0);
          locala.EVh.setBackground((Drawable)localObject1);
          if ((!Util.isNullOrNil(((ADXml.g)localObject2).title)) || (!Util.isNullOrNil(((ADXml.g)localObject2).description)))
          {
            locala.EVh.setVisibility(0);
            localObject1 = (RelativeLayout.LayoutParams)locala.EVl.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(locala.ExX.getContext(), 4);
            locala.EVl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          if (!Util.isNullOrNil(((ADXml.g)localObject2).title))
          {
            locala.EVj.setVisibility(0);
            locala.EVj.setText(com.tencent.mm.ce.g.gxZ().a(locala.EVj.getContext(), ((ADXml.g)localObject2).title, locala.EVj.getTextSize()));
          }
          if (!Util.isNullOrNil(((ADXml.g)localObject2).description))
          {
            locala.EVk.setVisibility(0);
            locala.EVk.setText(com.tencent.mm.ce.g.gxZ().a(locala.EVk.getContext(), ((ADXml.g)localObject2).description, locala.EVk.getTextSize()));
          }
        }
      }
    }
    Log.e("MicroMsg.FullCardAdTimeLineItem", "invalid full card");
    if (this.DqO == null)
    {
      localObject1 = "";
      label2090:
      paramInt2 = 0;
      if (localSnsInfo == null) {
        break label3490;
      }
      if (!localSnsInfo.isFullCardAd()) {
        break label2147;
      }
      paramInt2 = 1;
    }
    label2109:
    label2501:
    label2758:
    for (Object localObject3 = localSnsInfo.getUxinfo();; localObject3 = "")
    {
      j.b(j.DDX, (String)localObject1, 1, paramInt2, (String)localObject3);
      break;
      localObject1 = com.tencent.mm.plugin.sns.data.r.Jb(this.DqO.field_snsId);
      break label2090;
      label2147:
      paramInt2 = 0;
      break label2109;
      label2153:
      localObject1 = null;
      break label1407;
      label2159:
      if ((paramTimeLineObject.ContentObj.LoU == 15) || (paramTimeLineObject.ContentObj.LoU == 5))
      {
        if (this.EYI)
        {
          locala.EUK.Ewt.setVisibility(0);
          locala.EUK.Ews.setVisibility(8);
          locala.EUK.Ewt.setVideoCallback(new OfflineVideoView.a()
          {
            public final boolean a(PString paramAnonymousPString)
            {
              AppMethodBeat.i(179355);
              Log.i("MicroMsg.FullCardAdTimeLineItem", "downloadVideo");
              AppMethodBeat.o(179355);
              return false;
            }
            
            public final void onCompletion()
            {
              AppMethodBeat.i(179357);
              Log.i("MicroMsg.FullCardAdTimeLineItem", "onCompletion");
              boolean bool = f.a(f.this).fhx();
              if ((f.b(f.this)) && (this.EYJ != null) && (this.EYJ.DWE == null) && (!bool)) {
                locala.EUK.Ewt.restart();
              }
              f.this.a(parambk, parambl, this.EYJ, 0);
              AppMethodBeat.o(179357);
            }
            
            public final void onStart(int paramAnonymousInt)
            {
              AppMethodBeat.i(179356);
              Log.i("MicroMsg.FullCardAdTimeLineItem", "onStart:".concat(String.valueOf(paramAnonymousInt)));
              AppMethodBeat.o(179356);
            }
            
            public final void xv(int paramAnonymousInt)
            {
              AppMethodBeat.i(179358);
              f.this.a(parambl, this.EYJ, localSnsInfo, paramAnonymousInt, locala.EUK.Ewt.getDurationMs() / 1000);
              Object localObject2 = null;
              Object localObject1 = localObject2;
              if (parambk != null)
              {
                localObject1 = localObject2;
                if (parambk.EKl != null) {
                  localObject1 = parambk.EKl.EoE;
                }
              }
              f.a(f.this).a((com.tencent.mm.plugin.sns.ad.g.k)localObject1, paramAnonymousInt, parambl.ENp);
              AppMethodBeat.o(179358);
            }
          });
          if (localObject2 != null)
          {
            e.l(((ADXml.g)localObject2).DWA, locala.EVp);
            e.l(((ADXml.g)localObject2).DWC, locala.EVq);
          }
          if (!this.EYI) {
            break label2749;
          }
          com.tencent.mm.plugin.sns.ad.e.b.a(localSnsInfo, (cnb)localObject1);
          label2289:
          long l = System.nanoTime();
          bool = com.tencent.mm.plugin.sns.model.g.u((cnb)localObject1);
          Log.i("MicroMsg.FullCardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
          localObject4 = locala.EUK;
          if (bool) {
            break label2936;
          }
          if (!((com.tencent.mm.plugin.sns.model.g)localObject3).x((cnb)localObject1)) {
            break label2758;
          }
          ((at)localObject4).EeS.setVisibility(8);
          ((at)localObject4).Ewv.setVisibility(0);
          ((at)localObject4).Ewv.gYN();
          locala.EUK.Ewr.setVisibility(0);
          locala.EVm.setVisibility(4);
          ((at)localObject4).Ews.setTagObject(localObject4);
          ((at)localObject4).Ewt.setTag(localObject4);
          ((at)localObject4).Ewu.setTag(paramBaseViewHolder);
          locala.EUK.Ewr.setOnClickListener(this.EVz);
          if (!this.EYI) {
            break label3301;
          }
          paramBaseViewHolder = ((at)localObject4).Ewt;
          paramInt1 = this.mActivity.hashCode();
          localObject4 = bp.gCU();
          ((bp)localObject4).hXs = paramTimeLineObject.CreateTime;
          ((com.tencent.mm.plugin.sns.model.g)localObject3).a(localSnsInfo, (cnb)localObject1, paramBaseViewHolder, paramInt1, (bp)localObject4, parambl.Eoq);
          e.a((ADXml.g)localObject2, 0, locala.EVp, locala.EVq);
          paramBaseViewHolder = ar.ki(aj.getAccSnsPath(), ((cnb)localObject1).Id);
          paramTimeLineObject = com.tencent.mm.plugin.sns.data.r.j((cnb)localObject1);
          paramBaseViewHolder = paramBaseViewHolder + paramTimeLineObject;
          if (!s.YS(paramBaseViewHolder)) {
            break label3355;
          }
          parambk.EKl.EoE.f(parambl.ENp, (int)((cnb)localObject1).MsT, true);
          if (com.tencent.mm.plugin.sns.ad.e.b.KB())
          {
            bool = com.tencent.mm.modelvideo.r.isH265Video(paramBaseViewHolder);
            Log.i("MicroMsg.FullCardAdTimeLineItem", "AdH265Helper, fileExists, isH265File=" + bool + ", path=" + paramBaseViewHolder);
          }
          if (aj.faL().b(localSnsInfo, null) != 5) {
            break label3380;
          }
        }
        for (bool = true;; bool = false)
        {
          parambk.EKl.EoE.d(parambl.ENp, bool, false);
          AppMethodBeat.o(100082);
          return;
          locala.EUK.Ewt.setVisibility(8);
          locala.EUK.Ews.setVisibility(0);
          locala.EUK.Ews.setOnCompletionListener(new b.e()
          {
            public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              AppMethodBeat.i(179362);
              StringBuilder localStringBuilder = new StringBuilder("sight play completed, retCode=").append(paramAnonymousInt).append(", snsId=");
              if (localSnsInfo == null) {}
              for (paramAnonymousb = "";; paramAnonymousb = Long.valueOf(localSnsInfo.field_snsId))
              {
                Log.i("MicroMsg.FullCardAdTimeLineItem", paramAnonymousb);
                f.this.a(parambk, parambl, this.EYJ, paramAnonymousInt);
                AppMethodBeat.o(179362);
                return;
              }
            }
          });
          locala.EUK.Ews.setOnDecodeDurationListener(new b.f()
          {
            public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
            {
              AppMethodBeat.i(179363);
              Log.d("MicroMsg.FullCardAdTimeLineItem", "sight play %d", new Object[] { Long.valueOf(paramAnonymousLong) });
              f.this.a(parambl, this.EYJ, localSnsInfo, 1000L * paramAnonymousLong, (int)paramAnonymousb.eVC());
              AppMethodBeat.o(179363);
            }
          });
          break;
          com.tencent.mm.plugin.sns.ad.e.b.a((cnb)localObject1, false);
          break label2289;
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localSnsInfo, null) == 5)
          {
            ((com.tencent.mm.plugin.sns.model.g)localObject3).B((cnb)localObject1);
            ((at)localObject4).EeS.setVisibility(8);
            ((at)localObject4).Ewv.setVisibility(0);
            ((at)localObject4).Ewv.gYN();
            break label2382;
          }
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).y((cnb)localObject1))
          {
            ((at)localObject4).Ewv.setVisibility(8);
            ((at)localObject4).EeS.setImageResource(2131691482);
            ((at)localObject4).EeS.setVisibility(0);
            break label2382;
          }
          ((com.tencent.mm.plugin.sns.model.g)localObject3).z((cnb)localObject1);
          ((at)localObject4).EeS.setVisibility(0);
          ((at)localObject4).Ewv.setVisibility(8);
          ((at)localObject4).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
          ((at)localObject4).EeS.setContentDescription(this.mActivity.getString(2131763945));
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localSnsInfo, null) != 4) {
            break label2382;
          }
          ((at)localObject4).EeT.setVisibility(0);
          break label2382;
          label2936:
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).v((cnb)localObject1))
          {
            ((at)localObject4).EeS.setVisibility(0);
            ((at)localObject4).Ewv.setVisibility(8);
            ((at)localObject4).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
            ((at)localObject4).EeS.setContentDescription(this.mActivity.getString(2131763945));
            if (!this.EYI) {
              break label3285;
            }
          }
          for (bool = ((at)localObject4).Ewt.isError();; bool = ((at)localObject4).Ews.Dnr.eVz())
          {
            if (!bool) {
              break label3299;
            }
            Log.e("MicroMsg.FullCardAdTimeLineItem", "play video error " + ((cnb)localObject1).Id + " " + ((cnb)localObject1).Url + " " + ((cnb)localObject1).Msz + " " + paramInt1);
            ((com.tencent.mm.plugin.sns.model.g)localObject3).z((cnb)localObject1);
            ((at)localObject4).EeS.setVisibility(0);
            ((at)localObject4).Ewv.setVisibility(8);
            ((at)localObject4).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
            ((at)localObject4).EeS.setContentDescription(this.mActivity.getString(2131763945));
            break;
            if (((com.tencent.mm.plugin.sns.model.g)localObject3).w((cnb)localObject1))
            {
              ((at)localObject4).EeS.setVisibility(8);
              ((at)localObject4).Ewv.setVisibility(8);
              break label3001;
            }
            if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localSnsInfo, null) <= 5)
            {
              if (locala.EYi) {
                break label3001;
              }
              Log.i("MicroMsg.FullCardAdTimeLineItem", "fillItem, showPlayBtn");
              fkq();
              break label3001;
            }
            ((com.tencent.mm.plugin.sns.model.g)localObject3).z((cnb)localObject1);
            ((at)localObject4).EeS.setVisibility(0);
            ((at)localObject4).Ewv.setVisibility(8);
            ((at)localObject4).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
            ((at)localObject4).EeS.setContentDescription(this.mActivity.getString(2131763945));
            break label3001;
          }
          break label2382;
          paramBaseViewHolder = ((at)localObject4).Ews;
          paramInt2 = this.mActivity.hashCode();
          localObject4 = bp.gCU();
          ((bp)localObject4).hXs = paramTimeLineObject.CreateTime;
          ((com.tencent.mm.plugin.sns.model.g)localObject3).a(localSnsInfo, (cnb)localObject1, paramBaseViewHolder, paramInt2, paramInt1, (bp)localObject4, parambl.Eoq, true);
          break label2501;
          parambk.EKl.EoE.f(parambl.ENp, (int)((cnb)localObject1).MsT, false);
          break label2630;
        }
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(paramBaseViewHolder.EUK.Ews, this.mActivity.hashCode(), paramInt1);
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(paramBaseViewHolder.EUK.Ewt, this.mActivity.hashCode());
        paramBaseViewHolder.EUK.Eww.setVisibility(8);
        paramBaseViewHolder.EUK.Ews.setOnSightCompletionAction(null);
        paramBaseViewHolder.EUK.Ews.setOnCompletionListener(null);
        paramBaseViewHolder.EUK.Ews.setOnDecodeDurationListener(null);
        paramBaseViewHolder.EUK.Ewt.setVideoCallback(null);
      }
      label2382:
      label3285:
      label3299:
      label3301:
      AppMethodBeat.o(100082);
      label2630:
      return;
    }
  }
  
  final void a(final a parama)
  {
    AppMethodBeat.i(100083);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(100080);
        f.a.b(parama).setVisibility(8);
        f.a.b(parama).setBackgroundColor(0);
        f.a.b(parama).flk();
        f.a.b(parama).setOnGestureListener(null);
        AppMethodBeat.o(100080);
      }
    });
    AppMethodBeat.o(100083);
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100081);
    this.EYE = ((a)paramBaseViewHolder);
    if (paramBaseViewHolder.EWD != null)
    {
      paramBaseViewHolder.EWD.setLayoutResource(2131496502);
      if (!paramBaseViewHolder.EWE)
      {
        this.EYE.ExX = paramBaseViewHolder.EWD.inflate();
        paramBaseViewHolder.EWE = true;
      }
      this.EYE.wnX = this.EYE.convertView.findViewById(2131309318);
      this.EYE.EVh = this.EYE.convertView.findViewById(2131297679);
      this.EYE.uXS = ((TextView)this.EYE.convertView.findViewById(2131309320));
      this.EYE.EVi = ((TextView)this.EYE.convertView.findViewById(2131309319));
      this.EYE.EVj = ((TextView)this.EYE.convertView.findViewById(2131297681));
      this.EYE.EVk = ((TextView)this.EYE.convertView.findViewById(2131297680));
      this.EYE.EVm = ((MaskImageView)this.EYE.convertView.findViewById(2131301818));
      this.EYE.EVl = this.EYE.convertView.findViewById(2131297688);
      this.EYE.EVm.setScaleType(QImageView.a.QEL);
      this.EYE.EUK = new at();
      this.EYE.EUK.Ewu = this.EYE.ExX.findViewById(2131301820);
      this.EYE.EUK.Ewr = this.EYE.EUK.Ewu;
      this.EYE.EUK.Ewu.setOnClickListener(this.EVA);
      this.EYE.EUK.Ews = ((VideoSightView)this.EYE.EUK.Ewu.findViewById(2131302526));
      this.EYE.EUK.Ewt = ((SnsAdTimelineVideoView)this.EYE.EUK.Ewu.findViewById(2131305588));
      paramBaseViewHolder.EUK.Ews.setMute(true);
      paramBaseViewHolder.EUK.Ewt.setMute(true);
      this.EYE.EUK.EeS = ((ImageView)this.EYE.ExX.findViewById(2131301819));
      this.EYE.EUK.Ewv = ((MMPinProgressBtn)this.EYE.EUK.Ewu.findViewById(2131306281));
      this.EYE.EUK.Eww = ((TextView)this.EYE.EUK.Ewu.findViewById(2131300128));
      this.EYE.EUK.EeT = ((TextView)this.EYE.EUK.Ewu.findViewById(2131300154));
      this.EYE.EUK.Ews.Dnz = true;
      this.EYE.EUK.Ews.setScaleType(QImageView.a.QEL);
      a.a(this.EYE, (SnsDrawGestureView)this.EYE.convertView.findViewById(2131308112));
      this.EYE.EVp = ((ImageView)this.EYE.convertView.findViewById(2131301803));
      this.EYE.EVq = ((ImageView)this.EYE.convertView.findViewById(2131300122));
      this.EYE.EVr = ((SnsAdCardVideoEndView)this.EYE.convertView.findViewById(2131308115));
      this.EYE.EVy = ((TwistCoverView)this.EYE.convertView.findViewById(2131308249));
      this.EYE.EVy.setTwistActionListener(this.EVC);
      if (this.EYE.EVt != null) {
        break label843;
      }
      paramBaseViewHolder = ((ViewStub)this.EYE.EXE.findViewById(2131308064)).inflate();
      this.EYE.EVt = ((SnsAdSphereAnimView)paramBaseViewHolder.findViewById(2131308063));
      this.EYE.EYN = ((SnsAdTouchProgressView)paramBaseViewHolder.findViewById(2131308062));
    }
    for (;;)
    {
      this.EYE.EVt.setVisibility(8);
      this.EYE.EYN.setVisibility(8);
      this.EYF = new ba(this.mActivity, this.EYE, this.EYE.EXE);
      this.EYF.EzC = this.EVB;
      this.EYG = e.fkr();
      AppMethodBeat.o(100081);
      return;
      if (paramBaseViewHolder.EWE) {
        break;
      }
      this.EYE.ExX = paramBaseViewHolder.convertView.findViewById(2131301817);
      paramBaseViewHolder.EWE = true;
      break;
      label843:
      Log.e("MicroMsg.FullCardAdTimeLineItem", "buildContent many times");
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(176426);
    if ((this.EYE != null) && (this.EYE.ExX != null))
    {
      Object localObject = new int[2];
      this.EYE.ExX.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.EYE.ExX.getMeasuredWidth() + i, this.EYE.ExX.getMeasuredHeight() + j);
      AppMethodBeat.o(176426);
      return localObject;
    }
    AppMethodBeat.o(176426);
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177694);
    Log.i("MicroMsg.FullCardAdTimeLineItem", "onUIPause");
    fkp();
    AppMethodBeat.o(177694);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176424);
    Log.i("MicroMsg.FullCardAdTimeLineItem", "pause");
    if (fkp()) {
      fkq();
    }
    AppMethodBeat.o(176424);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176425);
    Log.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd stop", new Object[] { this });
    if ((this.EYE != null) && (this.EYE.EUK != null))
    {
      if (!this.EYI) {
        break label82;
      }
      this.EYE.EUK.Ewt.clear();
    }
    for (;;)
    {
      this.EYE.EVy.setSensorEnabled(false);
      this.EXV = false;
      AppMethodBeat.o(176425);
      return;
      label82:
      this.EYE.EUK.Ews.Dnr.clear();
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View EVh;
    public TextView EVi;
    public TextView EVj;
    public TextView EVk;
    public View EVl;
    public MaskImageView EVm;
    private SnsDrawGestureView EVn;
    public ImageView EVp;
    public ImageView EVq;
    public SnsAdCardVideoEndView EVr;
    public SnsAdSphereAnimView EVt;
    public TwistCoverView EVy;
    public SnsAdTouchProgressView EYN;
    public boolean EYi = false;
    public View ExX;
    public TextView uXS;
    public View wnX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.f
 * JD-Core Version:    0.7.0.1
 */