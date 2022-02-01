package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.d.n;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.c;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCoverView;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCoverView.a;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.ADXml.g.a;
import com.tencent.mm.plugin.sns.storage.ADXml.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView.a;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends b
{
  private ShakeCoverView.a JOb;
  com.tencent.mm.plugin.sns.ad.f.l KPn;
  private View.OnClickListener LjD;
  protected SnsAdTouchProgressView.a LjF;
  protected TwistCoverView.a LjG;
  public a.b LjM;
  protected com.tencent.mm.plugin.sns.ad.timeline.c.b.a LjN;
  public boolean LjO;
  protected a.c LjP;
  private boolean Ljt;
  ADXml.g Ljw;
  boolean Ljx;
  bc Ljy;
  Context context;
  boolean mIsPaused;
  
  public e(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, c paramc, com.tencent.mm.plugin.sns.ad.f.l paraml)
  {
    AppMethodBeat.i(249317);
    this.Ljx = false;
    this.LjN = new com.tencent.mm.plugin.sns.ad.timeline.c.b.a();
    this.LjD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(201045);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItemNew$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItemNew", "ProxyCardClickListener onClick");
        try
        {
          e.this.JIp.LpB.onClick(paramAnonymousView);
          if (e.this.Ljx) {
            SnsAdCardVideoEndView.j(e.this.Jzk, 2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItemNew$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(201045);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "ProxyCardClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.Ljt = false;
    this.mIsPaused = false;
    this.LjF = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(211714);
        try
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItemNew", "SnsAdTouchProgressView onClick");
          e.this.LjM.JKG.KKj.performClick();
          AppMethodBeat.o(211714);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "SnsAdTouchProgressView onClick exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(211714);
        }
      }
      
      public final void onFinish()
      {
        int i = 1;
        AppMethodBeat.i(211717);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItemNew", "SnsAdTouchProgressView onFinish");
        for (;;)
        {
          try
          {
            e.this.JIp.a(e.this, null);
            t.e(new long[] { 20L, 100L });
            if (!(e.this.context instanceof SnsCommentDetailUI)) {
              break label198;
            }
            i = ((SnsCommentDetailUI)e.this.context).getSource();
          }
          catch (Exception localException)
          {
            SnsAdClick localSnsAdClick;
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "SnsAdTouchProgressView onFinish, exp=" + localException.toString());
            AppMethodBeat.o(211717);
            return;
          }
          com.tencent.mm.plugin.sns.ui.item.f.a(e.this.context, e.this.contentView, e.this.Jzk, i);
          localSnsAdClick = new SnsAdClick(1, 2, t.aZs(e.this.Jzk.getTimeLine().Id), 28, 21);
          m.a(localSnsAdClick, e.this.KPn, e.this.Jzk, 28);
          t.a(localSnsAdClick);
          AppMethodBeat.o(211717);
          return;
          label198:
          while (i != 2)
          {
            i = 2;
            break;
          }
          i = 16;
        }
      }
      
      public final void onStart() {}
    };
    this.LjG = new TwistCoverView.a()
    {
      public final void fMH()
      {
        AppMethodBeat.i(246545);
        if ((e.this.context instanceof SnsCommentDetailUI)) {}
        for (int i = ((SnsCommentDetailUI)e.this.context).getSource();; i = 1)
        {
          if (i == 2) {}
          for (i = 16;; i = 2)
          {
            if (e.this.Jzk == null)
            {
              AppMethodBeat.o(246545);
              return;
            }
            Object localObject = e.this.Jzk.getAdXml().adTwistInfo;
            Bundle localBundle = new Bundle();
            localBundle.putBoolean("isFromTwist", true);
            if (localObject != null)
            {
              localBundle.putBoolean("isSimpleTwistAnim", ((ADXml.k)localObject).Kkf);
              localBundle.putBoolean("isTwistClockwise", ((ADXml.k)localObject).Kke);
              if (((ADXml.k)localObject).Kkf) {
                t.e(new long[] { 0L, 80L });
              }
            }
            e.this.JIp.a(e.this, localBundle);
            com.tencent.mm.plugin.sns.ui.item.f.a(e.this.context, e.this.contentView, e.this.Jzk, i);
            try
            {
              localObject = new SnsAdClick(1, 2, t.aZs(e.this.Jzk.getTimeLine().Id), 29, 21);
              m.a((SnsAdClick)localObject, e.this.KPn, e.this.Jzk, 29);
              t.a((SnsAdClick)localObject);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItemNew", "onTwist report MMOCAD_CLICKPOS_AD_FULL_CARD_TWIST");
              AppMethodBeat.o(246545);
              return;
            }
            catch (Throwable localThrowable)
            {
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "twist click report exp=" + localThrowable.toString());
              AppMethodBeat.o(246545);
              return;
            }
          }
        }
      }
    };
    this.JOb = new ShakeCoverView.a()
    {
      public final void onShake()
      {
        AppMethodBeat.i(258510);
        if (e.this.Jzk == null)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "onShake, snsInfo==null");
          AppMethodBeat.o(258510);
          return;
        }
        if ((e.this.context instanceof SnsCommentDetailUI)) {}
        for (int i = ((SnsCommentDetailUI)e.this.context).getSource();; i = 1)
        {
          if (i == 2) {}
          for (i = 16;; i = 2)
          {
            Object localObject = new Bundle();
            ((Bundle)localObject).putBoolean("isFromShake", true);
            e.this.JIp.a(e.this, (Bundle)localObject);
            com.tencent.mm.plugin.sns.ui.item.f.a(e.this.context, e.this.contentView, e.this.Jzk, i);
            try
            {
              localObject = new SnsAdClick(1, 2, t.aZs(e.this.Jzk.getTimeLine().Id), 36, 21);
              m.a((SnsAdClick)localObject, e.this.KPn, e.this.Jzk, 36);
              t.a((SnsAdClick)localObject);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItemNew", "onShake report MMOCAD_CLICKPOS_AD_FULL_CARD_TWIST");
              AppMethodBeat.o(258510);
              return;
            }
            catch (Throwable localThrowable)
            {
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "onShake click report exp=" + localThrowable.toString());
              AppMethodBeat.o(258510);
              return;
            }
          }
        }
      }
    };
    this.LjP = new a.c()
    {
      public final void aV(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(268167);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItemNew", "onStart, isOnlineVideoView=" + paramAnonymousBoolean + ", duration=" + paramAnonymousInt + ", hash=" + e.this.hashCode());
        AppMethodBeat.o(268167);
      }
      
      public final void aW(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(268169);
        int i;
        e locale;
        long l;
        if (paramAnonymousBoolean)
        {
          i = e.this.LjM.JKM.getDuration() / 1000;
          locale = e.this;
          l = locale.Jzk.field_snsId;
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.FullCardAdDetailItemNew", "doOnVideoPlaying, curTime=" + paramAnonymousInt + ", isOnlineVideo=" + paramAnonymousBoolean);
          if (locale.KPn != null)
          {
            if (locale.Jzk != null)
            {
              locale.KPn.Qm(l);
              locale.KPn.az(l, paramAnonymousInt);
            }
            if (!locale.KPn.Qj(l))
            {
              locale.KPn.c(l, Util.currentTicks(), false);
              locale.KPn.e(l, i, false);
              locale.KPn.ay(l, l);
            }
          }
          Object localObject = locale.Ljw;
          SnsInfo localSnsInfo = locale.Jzk;
          localObject = ((ADXml.g)localObject).KjK;
          if ((!Util.isNullOrNil(localSnsInfo.getAdXml().getGestureCanvasInfo())) && (localObject != null) && (((ADXml.g.a)localObject).startTime >= 0L) && (((ADXml.g.a)localObject).endTime > ((ADXml.g.a)localObject).startTime))
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItemNew", "%d-%d,%d", new Object[] { Long.valueOf(((ADXml.g.a)localObject).startTime), Long.valueOf(((ADXml.g.a)localObject).endTime), Integer.valueOf(paramAnonymousInt) });
            if ((((ADXml.g.a)localObject).startTime > paramAnonymousInt) || (((ADXml.g.a)localObject).endTime < paramAnonymousInt)) {
              break label495;
            }
            if ((locale.LjM.JKz != null) && (locale.LjM.JKz.getOnGestureListener() == null)) {
              MMHandlerThread.postToMainThread(new e.2(locale, (ADXml.g.a)localObject, localSnsInfo));
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.ui.item.f.a(locale.Ljw, paramAnonymousInt, locale.LjM.JKA, locale.LjM.JKB);
          if ((locale.Jzk != null) && (locale.Jzk.isTwistAd()) && (locale.LjM.JKF != null)) {
            locale.LjM.JKF.Qp(paramAnonymousInt);
          }
          if (locale.Ljy != null) {
            locale.Ljy.a(locale.KPn, paramAnonymousInt, l);
          }
          if ((locale.Jzk != null) && (locale.Jzk.isShakeAd()) && (locale.LjM.JKN != null)) {
            locale.LjM.JKN.Qp(paramAnonymousInt);
          }
          AppMethodBeat.o(268169);
          return;
          i = e.this.LjM.JKG.KKl.getDurationMs() / 1000;
          break;
          label495:
          locale.fYv();
        }
      }
      
      public final void fLF() {}
      
      public final void yr(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(268168);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItemNew", "onCompletion, isOnlineVideoView=" + paramAnonymousBoolean + ", hash=" + e.this.hashCode());
        e.this.fYx();
        AppMethodBeat.o(268168);
      }
    };
    this.timeLineObject = paramTimeLineObject;
    this.Jzk = paramSnsInfo;
    this.JIp = paramc;
    this.KPn = paraml;
    AppMethodBeat.o(249317);
  }
  
  final void fYv()
  {
    AppMethodBeat.i(249326);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264274);
        if (e.this.LjM.JKz == null)
        {
          AppMethodBeat.o(264274);
          return;
        }
        e.this.LjM.JKz.setVisibility(8);
        e.this.LjM.JKz.setBackgroundColor(0);
        e.this.LjM.JKz.fZF();
        e.this.LjM.JKz.setOnGestureListener(null);
        AppMethodBeat.o(264274);
      }
    });
    AppMethodBeat.o(249326);
  }
  
  protected final void fYx()
  {
    AppMethodBeat.i(249325);
    if (this.Ljy != null) {}
    for (boolean bool = this.Ljy.fVI();; bool = false)
    {
      if ((this.Ljw.KjP == null) && (!bool)) {
        this.LjN.yq(this.LjO);
      }
      this.KPn.I(this.Jzk.field_snsId, false);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(266697);
          e.this.fYy();
          AppMethodBeat.o(266697);
        }
      });
      AppMethodBeat.o(249325);
      return;
    }
  }
  
  public final void fYy()
  {
    AppMethodBeat.i(249328);
    for (;;)
    {
      try
      {
        if (this.LjM.JKC == null)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItemNew", "checkShowEndView, viewHolder.videoEndView==null");
          AppMethodBeat.o(249328);
          return;
        }
        if ((this.Ljw == null) || (this.Ljw.KjP == null)) {
          break;
        }
        if (this.LjO)
        {
          this.LjM.JKC.setBlurBkg(this.LjM.JKM.getInnerVideoView());
          this.LjM.JKC.bzz();
          this.LjM.JKC.equ();
          this.Ljx = true;
          if (this.LjO) {
            break label219;
          }
          this.LjM.JKG.KKl.bc(0, false);
          this.LjN.yp(this.LjO);
          fYv();
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(195350);
              if (((e.this.context instanceof Activity)) && (!((Activity)e.this.context).isFinishing()))
              {
                e.this.LjM.JKC.fv(true);
                e.this.Ljx = false;
                if (!e.this.mIsPaused)
                {
                  e.this.LjN.yq(e.this.LjO);
                  AppMethodBeat.o(195350);
                  return;
                }
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "activity isPaused");
                AppMethodBeat.o(195350);
                return;
              }
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "onCompletion, postDelayed-run activity isFinished");
              AppMethodBeat.o(195350);
            }
          }, this.Ljw.KjP.duration);
          AppMethodBeat.o(249328);
          return;
        }
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "handleVideoCompletion, exp" + localException.toString());
        AppMethodBeat.o(249328);
        return;
      }
      this.LjM.JKC.setBlurBkg(this.LjM.JKG.KKl.getInnerVideoView());
      continue;
      label219:
      if ((this.LjM.JKM.getInnerVideoView() instanceof ThumbPlayerVideoView))
      {
        this.LjM.JKM.bc(0, false);
        this.LjM.JKM.dmi();
      }
    }
    this.LjM.JKC.fv(false);
    AppMethodBeat.o(249328);
  }
  
  public final void h(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(249320);
    try
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItemNew", "initLongPressView");
      SnsAdTouchProgressView localSnsAdTouchProgressView = (SnsAdTouchProgressView)paramFrameLayout.findViewById(i.f.sns_ad_progress_anim_view);
      localSnsAdTouchProgressView.setVisibility(8);
      this.Ljy = new bc(this.context, localSnsAdTouchProgressView, this.LjM.JKE, this.LjM.JKG, 2, paramFrameLayout);
      this.Ljy.KNr = this.LjF;
      AppMethodBeat.o(249320);
      return;
    }
    catch (Exception paramFrameLayout)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "initLongPressView exp=" + android.util.Log.getStackTraceString(paramFrameLayout));
      AppMethodBeat.o(249320);
    }
  }
  
  public final void n(View paramView1, View paramView2)
  {
    AppMethodBeat.i(249319);
    this.contentView = paramView1;
    this.KON = paramView2;
    this.context = paramView1.getContext();
    this.LjM = com.tencent.mm.plugin.sns.ad.timeline.c.b.a.gg(paramView1);
    this.LjM.JKO.scene = 1;
    this.LjM.xYJ = paramView1.findViewById(i.f.full_card_container);
    this.JKG = this.LjM.JKG;
    if (this.LjM.JKE == null)
    {
      paramView1 = (ViewStub)this.oFW.findViewById(i.f.sns_ad_sphere_anim_view_stub);
      this.LjM.JKE = ((SnsAdSphereAnimView)paramView1.inflate());
      this.LjM.JKE.setVisibility(8);
      if (this.LjM.JKF == null)
      {
        paramView1 = (ViewStub)this.LjM.xYJ.findViewById(i.f.sns_twist_ad_cover_stub);
        if (paramView1 != null) {
          this.LjM.JKF = ((TwistCoverView)paramView1.inflate());
        }
        if (this.LjM.JKF != null) {
          this.LjM.JKF.setTwistActionListener(this.LjG);
        }
      }
      if (this.LjM.JKz == null)
      {
        paramView1 = (ViewStub)this.LjM.xYJ.findViewById(i.f.sns_twist_ad_gesture_stub);
        if (paramView1 != null) {
          this.LjM.JKz = ((SnsDrawGestureView)paramView1.inflate());
        }
      }
      if (this.LjM.JKN == null)
      {
        paramView1 = (ViewStub)this.LjM.xYJ.findViewById(i.f.sns_shake_ad_cover_stub);
        if (paramView1 == null) {
          break label330;
        }
        this.LjM.JKN = ((ShakeCoverView)paramView1.inflate());
      }
    }
    for (;;)
    {
      if (this.LjM.JKN != null) {
        this.LjM.JKN.setOnShakeListener(this.JOb);
      }
      this.LjN.JKn = this.LjP;
      AppMethodBeat.o(249319);
      return;
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "initView many times");
      break;
      label330:
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "coverStub==null");
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(249331);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItemNew", "onPause, hasPlayedVideo=" + this.Ljt);
    this.mIsPaused = true;
    try
    {
      if ((this.Ljt) && (this.LjM.JKG != null) && (this.LjM.JKG.KKl != null))
      {
        this.LjN.yp(this.LjO);
        if (this.Ljy != null) {
          this.Ljy.fVJ();
        }
        if ((this.KPn != null) && (this.Jzk != null)) {
          this.KPn.Qn(this.Jzk.field_snsId);
        }
        if ((this.Jzk != null) && (this.Jzk.isTwistAd()) && (this.LjM.JKF != null)) {
          this.LjM.JKF.onPlayerPaused();
        }
        if ((this.Jzk != null) && (this.Jzk.isShakeAd()) && (this.LjM.JKN != null)) {
          this.LjM.JKN.fMw();
        }
      }
      AppMethodBeat.o(249331);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "onPause, exp=" + localException.toString());
      AppMethodBeat.o(249331);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(249323);
    this.Jzk = com.tencent.mm.plugin.sns.storage.f.bbk(this.Jzk.getSnsId());
    this.Ljw = null;
    Object localObject1;
    if ((this.Jzk != null) && (this.Jzk.getAdXml() != null))
    {
      localObject1 = this.Jzk.getAdXml();
      this.Ljw = ((ADXml)localObject1).adFullCardInfo;
    }
    for (;;)
    {
      this.LjO = com.tencent.mm.plugin.sns.ad.timeline.c.b.a.d((ADXml)localObject1);
      this.LjN.a(this.LjM, this.Ljw, this.Jzk, this.timeLineObject, this.context, this.KPn);
      this.Ljt = false;
      this.mIsPaused = false;
      localObject1 = (WindowManager)this.context.getSystemService("window");
      int j = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
      int k = com.tencent.mm.ci.a.aY(this.context, i.d.sns_avatar_size);
      int m = com.tencent.mm.ci.a.aY(this.context, i.d.Edge_0_5_A);
      int n = this.context.getResources().getDimensionPixelSize(i.d.NormalPadding);
      Object localObject2;
      g localg;
      label303:
      int i;
      if (this.Ljw != null)
      {
        localObject2 = this.LjN.afb(j - k - m - n - n);
        this.LjM.JKG.a(this.timeLineObject, 0, this.Jzk.getLocalid(), true);
        this.LjM.JKG.Ktc.setVisibility(8);
        localg = aj.fOF();
        if ((this.timeLineObject.ContentObj != null) && (this.timeLineObject.ContentObj.Sqr.size() > 0))
        {
          localObject1 = (cvt)this.timeLineObject.ContentObj.Sqr.get(0);
          if (localObject1 == null) {
            break label973;
          }
          if (this.LjM.JKC != null)
          {
            this.LjM.JKC.a(this.Ljw.KjP, 2);
            if (this.LjM.JKC.ad(this.Jzk)) {
              this.Ljx = false;
            }
          }
          if (this.Ljy != null)
          {
            if (localObject2 == null) {
              break label767;
            }
            i = ((ViewGroup.LayoutParams)localObject2).height;
            label376:
            localObject2 = new Rect(m + k, k, j - n, i + k);
            this.Ljy.a(this.Jzk, this.Ljw.KjQ, (Rect)localObject2);
          }
          if (this.LjM.JKF != null) {
            this.LjM.JKF.a(this.Jzk, this.Jzk.getAdXml().adTwistInfo, 2);
          }
          if (!this.Jzk.isTwistAd()) {
            break label772;
          }
          this.LjM.JKG.KKl.setTimerInterval(300);
          label479:
          if ((this.Jzk != null) && (this.LjM.JKN != null))
          {
            this.LjM.JKN.a(this.Jzk, 2);
            if (!this.Jzk.isShakeAd()) {
              break label811;
            }
            this.LjM.JKN.setVisibility(0);
            this.LjM.JKG.KKl.setTimerInterval(300);
          }
          label548:
          StringBuilder localStringBuilder = new StringBuilder("refreshView, hash=").append(hashCode()).append(", snsId=");
          if (this.Jzk != null) {
            break label850;
          }
          localObject2 = "";
          label585:
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItemNew", localObject2 + ", useOnlineVideo=" + this.LjO);
          this.LjN.a((cvt)localObject1, localg, 0, this.LjO);
          if (this.timeLineObject.ContentObj.Sqq != 1) {
            break label865;
          }
          this.LjM.JKs.setTag(this);
          this.LjM.JKs.setOnClickListener(this.LjD);
          AppMethodBeat.o(249323);
        }
      }
      else
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItemNew", "invalid full card");
        if (this.Jzk == null)
        {
          localObject1 = "";
          label695:
          if (this.Jzk == null) {
            break label1053;
          }
          if (!this.Jzk.isFullCardAd()) {
            break label756;
          }
          i = 1;
          label714:
          localObject2 = this.Jzk.getUxinfo();
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.JQG, (String)localObject1, 0, i, (String)localObject2);
        localObject2 = null;
        break;
        localObject1 = t.Qu(this.Jzk.field_snsId);
        break label695;
        label756:
        i = 0;
        break label714;
        localObject1 = null;
        break label303;
        label767:
        i = 0;
        break label376;
        label772:
        this.LjM.JKG.KKl.setTimerInterval(1000);
        if (this.LjM.JKF == null) {
          break label479;
        }
        this.LjM.JKF.clear();
        break label479;
        label811:
        this.LjM.JKG.KKl.setTimerInterval(1000);
        if (this.LjM.JKN == null) {
          break label548;
        }
        this.LjM.JKN.clear();
        break label548;
        label850:
        localObject2 = Long.valueOf(this.Jzk.field_snsId);
        break label585;
        label865:
        if ((this.timeLineObject.ContentObj.Sqq == 15) || (this.timeLineObject.ContentObj.Sqq == 5))
        {
          this.LjM.JKG.KKj.setTag(this);
          this.LjM.JKL.setTag(this);
          this.LjM.JKG.KKj.setOnClickListener(this.LjD);
          this.LjM.JKL.setOnClickListener(this.LjD);
          this.LjN.yd(this.LjO);
          this.Ljt = true;
          AppMethodBeat.o(249323);
          return;
          localg.a(this.LjM.JKG.KKl, this.context.hashCode());
          this.LjM.JKG.KKo.setVisibility(8);
          this.LjM.JKG.KKl.setVideoCallback(null);
          if (this.LjM.JKM != null) {
            this.LjM.JKM.setVideoCallback(null);
          }
        }
        label973:
        AppMethodBeat.o(249323);
        return;
        label1053:
        localObject2 = "";
        i = 0;
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.e
 * JD-Core Version:    0.7.0.1
 */