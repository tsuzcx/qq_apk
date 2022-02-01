package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
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
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.plugin.sns.ui.item.e;
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

public final class c
  extends a
{
  com.tencent.mm.plugin.sns.ad.g.k EBv;
  private View.OnClickListener EVA;
  protected SnsAdTouchProgressView.a EVB;
  protected TwistCoverView.a EVC;
  private boolean EVf;
  public View EVh;
  private TextView EVi;
  private TextView EVj;
  private TextView EVk;
  public View EVl;
  public MaskImageView EVm;
  SnsDrawGestureView EVn;
  ADXml.g EVo;
  ImageView EVp;
  ImageView EVq;
  SnsAdCardVideoEndView EVr;
  boolean EVs;
  private SnsAdSphereAnimView EVt;
  ba EVu;
  private boolean EVv;
  private boolean EVw;
  boolean EVx;
  public TwistCoverView EVy;
  private View.OnClickListener EVz;
  public View ExX;
  Context context;
  boolean mIsPaused;
  private TextView uXS;
  public View wnX;
  
  public c(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ui.d.c paramc, com.tencent.mm.plugin.sns.ad.g.k paramk)
  {
    AppMethodBeat.i(176410);
    this.EVs = false;
    this.EVv = false;
    this.EVw = false;
    this.EVx = false;
    this.EVz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176408);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "ProxyCardClickListener onClick");
        try
        {
          c.this.Dyw.Fbd.onClick(paramAnonymousView);
          if (c.this.EVs) {
            SnsAdCardVideoEndView.i(c.this.DsC, 2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(176408);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "ProxyCardClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.EVA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176409);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "ProxySightClickListener onClick");
        try
        {
          c.this.Dyw.FaQ.onClick(paramAnonymousView);
          if (c.this.EVs) {
            SnsAdCardVideoEndView.i(c.this.DsC, 2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(176409);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "ProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.EVf = false;
    this.mIsPaused = false;
    this.EVB = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203891);
        try
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onClick");
          c.this.EUK.Ewr.performClick();
          AppMethodBeat.o(203891);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onClick exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(203891);
        }
      }
      
      public final void onFinish()
      {
        int i = 1;
        AppMethodBeat.i(203892);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onFinish");
        for (;;)
        {
          try
          {
            c.this.Dyw.a(c.this, null);
            com.tencent.mm.plugin.sns.data.r.e(new long[] { 20L, 100L });
            if (!(c.this.context instanceof SnsCommentDetailUI)) {
              break label198;
            }
            i = ((SnsCommentDetailUI)c.this.context).getSource();
          }
          catch (Exception localException)
          {
            SnsAdClick localSnsAdClick;
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onFinish, exp=" + localException.toString());
            AppMethodBeat.o(203892);
            return;
          }
          e.a(c.this.context, c.this.contentView, c.this.DsC, i);
          localSnsAdClick = new SnsAdClick(1, 2, com.tencent.mm.plugin.sns.data.r.aOw(c.this.DsC.getTimeLine().Id), 28, 21);
          com.tencent.mm.plugin.sns.data.k.a(localSnsAdClick, c.this.EBv, c.this.DsC, 28);
          com.tencent.mm.plugin.sns.data.r.a(localSnsAdClick);
          AppMethodBeat.o(203892);
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
    this.EVC = new TwistCoverView.a()
    {
      public final void eYQ()
      {
        AppMethodBeat.i(203889);
        if ((c.this.context instanceof SnsCommentDetailUI)) {}
        for (int i = ((SnsCommentDetailUI)c.this.context).getSource();; i = 1)
        {
          if (i == 2) {}
          for (i = 16;; i = 2)
          {
            if (c.this.DsC == null)
            {
              AppMethodBeat.o(203889);
              return;
            }
            Object localObject = c.this.DsC.getAdXml().adTwistInfo;
            Bundle localBundle = new Bundle();
            localBundle.putBoolean("isFromTwist", true);
            if (localObject != null)
            {
              localBundle.putBoolean("isSimpleTwistAnim", ((ADXml.k)localObject).DWW);
              localBundle.putBoolean("isTwistClockwise", ((ADXml.k)localObject).DWV);
              if (((ADXml.k)localObject).DWW) {
                com.tencent.mm.plugin.sns.data.r.e(new long[] { 0L, 80L });
              }
            }
            c.this.Dyw.a(c.this, localBundle);
            e.a(c.this.context, c.this.contentView, c.this.DsC, i);
            try
            {
              localObject = new SnsAdClick(1, 2, com.tencent.mm.plugin.sns.data.r.aOw(c.this.DsC.getTimeLine().Id), 29, 21);
              com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject, c.this.EBv, c.this.DsC, 29);
              com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "onTwist report MMOCAD_CLICKPOS_AD_FULL_CARD_TWIST");
              AppMethodBeat.o(203889);
              return;
            }
            catch (Throwable localThrowable)
            {
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "twist click report exp=" + localThrowable.toString());
              AppMethodBeat.o(203889);
              return;
            }
          }
        }
      }
    };
    this.timeLineObject = paramTimeLineObject;
    this.DsC = paramSnsInfo;
    this.Dyw = paramc;
    this.EBv = paramk;
    AppMethodBeat.o(176410);
  }
  
  private void fkl()
  {
    AppMethodBeat.i(176411);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(100019);
        c.this.EVn.setVisibility(8);
        c.this.EVn.setBackgroundColor(0);
        c.this.EVn.flk();
        c.this.EVn.setOnGestureListener(null);
        AppMethodBeat.o(100019);
      }
    });
    AppMethodBeat.o(176411);
  }
  
  public final void d(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(203893);
    try
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "initLongPressView");
      SnsAdTouchProgressView localSnsAdTouchProgressView = (SnsAdTouchProgressView)paramFrameLayout.findViewById(2131308062);
      localSnsAdTouchProgressView.setVisibility(8);
      this.EVu = new ba(this.context, localSnsAdTouchProgressView, this.EVt, this.EUK, paramFrameLayout);
      this.EVu.EzC = this.EVB;
      AppMethodBeat.o(203893);
      return;
    }
    catch (Exception paramFrameLayout)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "initLongPressView exp=" + android.util.Log.getStackTraceString(paramFrameLayout));
      AppMethodBeat.o(203893);
    }
  }
  
  public final void fkm()
  {
    AppMethodBeat.i(179349);
    for (;;)
    {
      try
      {
        if ((this.EVo == null) || (this.EVo.DWE == null)) {
          break;
        }
        if (this.EVx)
        {
          this.EVr.setBlurBkg(this.EUK.Ewt.getInnerVideoView());
          this.EVr.bpn();
          this.EVr.fkZ();
          this.EVs = true;
          if (this.EVx)
          {
            this.EUK.Ewt.setShouldPlayWhenPrepared(false);
            this.EUK.Ewt.pause();
            fkl();
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(203890);
                if (((c.this.context instanceof Activity)) && (!((Activity)c.this.context).isFinishing()))
                {
                  c.this.EVr.eQ(true);
                  c.this.EVs = false;
                  if (!c.this.mIsPaused)
                  {
                    if (c.this.EVx)
                    {
                      c.this.EUK.Ewt.restart();
                      AppMethodBeat.o(203890);
                      return;
                    }
                    c.this.EUK.Ews.start();
                    AppMethodBeat.o(203890);
                    return;
                  }
                  com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "activity isPaused");
                  AppMethodBeat.o(203890);
                  return;
                }
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "onCompletion, postDelayed-run activity isFinished");
                AppMethodBeat.o(203890);
              }
            }, this.EVo.DWE.duration);
            AppMethodBeat.o(179349);
          }
        }
        else
        {
          this.EVr.setBlurBkg(this.contentView);
          continue;
        }
        this.EUK.Ews.pause();
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "handleVideoCompletion, exp" + localException.toString());
        AppMethodBeat.o(179349);
        return;
      }
    }
    this.EVr.eQ(false);
    AppMethodBeat.o(179349);
  }
  
  public final void n(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100020);
    this.contentView = paramView1;
    this.EAV = paramView2;
    this.context = paramView1.getContext();
    this.ExX = paramView1.findViewById(2131301817);
    this.wnX = paramView1.findViewById(2131309318);
    this.EVh = paramView1.findViewById(2131297679);
    this.uXS = ((TextView)paramView1.findViewById(2131309320));
    this.EVi = ((TextView)paramView1.findViewById(2131309319));
    this.EVj = ((TextView)paramView1.findViewById(2131297681));
    this.EVk = ((TextView)paramView1.findViewById(2131297680));
    this.EVl = paramView1.findViewById(2131297688);
    this.EVm = ((MaskImageView)paramView1.findViewById(2131301818));
    this.EVn = ((SnsDrawGestureView)paramView1.findViewById(2131308112));
    this.EVm.setScaleType(QImageView.a.QEL);
    this.EVp = ((ImageView)paramView1.findViewById(2131301803));
    this.EVq = ((ImageView)paramView1.findViewById(2131300122));
    this.EVy = ((TwistCoverView)paramView1.findViewById(2131308249));
    this.EVy.setTwistActionListener(this.EVC);
    this.EUK = new at();
    this.EUK.Ewu = paramView1.findViewById(2131301820);
    this.EUK.Ewr = this.EUK.Ewu;
    this.EUK.Ewu.setOnClickListener(this.EVA);
    this.EUK.Ews = ((VideoSightView)this.EUK.Ewu.findViewById(2131302526));
    this.EUK.Ewt = ((SnsAdTimelineVideoView)this.EUK.Ewu.findViewById(2131305588));
    this.EUK.Ews.setMute(true);
    this.EUK.Ewt.setMute(true);
    this.EUK.EeS = ((ImageView)paramView1.findViewById(2131301819));
    this.EUK.Ewv = ((MMPinProgressBtn)this.EUK.Ewu.findViewById(2131306281));
    this.EUK.Eww = ((TextView)this.EUK.Ewu.findViewById(2131300128));
    this.EUK.EeT = ((TextView)this.EUK.Ewu.findViewById(2131300154));
    this.EUK.Ews.Dnz = true;
    this.EUK.Ews.setScaleType(QImageView.a.QEL);
    this.EVr = ((SnsAdCardVideoEndView)paramView1.findViewById(2131308115));
    if (this.EVt == null) {
      this.EVt = ((SnsAdSphereAnimView)((ViewStub)this.lJI.findViewById(2131308064)).inflate());
    }
    for (;;)
    {
      this.EVt.setVisibility(8);
      this.EVv = e.fkr();
      AppMethodBeat.o(100020);
      return;
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "initView many times");
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(179350);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "onPause, hasPlayedVideo=" + this.EVf);
    this.mIsPaused = true;
    try
    {
      if ((this.EVf) && (this.EUK != null) && (this.EUK.Ews != null))
      {
        if (!this.EVx) {
          break label161;
        }
        this.EUK.Ewt.pause();
        this.EUK.Ewt.setShouldPlayWhenPrepared(false);
        if (this.EVu != null) {
          this.EVu.fhy();
        }
      }
      for (;;)
      {
        if ((this.EBv != null) && (this.DsC != null)) {
          this.EBv.IU(this.DsC.field_snsId);
        }
        if ((this.DsC != null) && (this.DsC.isTwistAd())) {
          this.EVy.onPlayerPaused();
        }
        AppMethodBeat.o(179350);
        return;
        label161:
        this.EUK.Ews.pause();
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "onPause, exp=" + localException.toString());
      AppMethodBeat.o(179350);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100021);
    this.DsC = f.aQl(this.DsC.getSnsId());
    this.EVo = null;
    if ((this.DsC != null) && (this.DsC.getAdXml() != null)) {
      this.EVo = this.DsC.getAdXml().adFullCardInfo;
    }
    Object localObject1 = (WindowManager)this.context.getSystemService("window");
    int j = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    this.wnX.setVisibility(8);
    this.uXS.setVisibility(8);
    this.EVi.setVisibility(8);
    this.EVh.setVisibility(8);
    this.EVj.setVisibility(8);
    this.EVk.setVisibility(8);
    this.EVl.setVisibility(8);
    this.EVf = false;
    this.mIsPaused = false;
    int k = com.tencent.mm.cb.a.aG(this.context, 2131166954);
    int m = com.tencent.mm.cb.a.aG(this.context, 2131165277);
    int n = this.context.getResources().getDimensionPixelSize(2131165534);
    int i;
    if (this.EVo != null)
    {
      i = j - k - m - n - n;
      if (this.EVo.DWw == 0)
      {
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
      }
    }
    label971:
    label1104:
    label2130:
    label2515:
    for (;;)
    {
      int i1;
      if (localObject1 != null)
      {
        localObject2 = this.contentView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((RoundedCornerFrameLayout)this.contentView).setRadius(com.tencent.mm.cb.a.fromDPToPix(this.context, 8));
        localObject2 = this.EVm.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.EVm.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.EUK.Ewr.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.EUK.Ewr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.EUK.Ews.im(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        localObject2 = this.EUK.Ewt.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.EUK.Ewt.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.EVp.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.EVp.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.EVq.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.EVq.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.EVr.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.EVr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (this.EVo.DWy != 0) {
          break label1509;
        }
        i = Color.argb((int)(this.EVo.DWx * 2.55F), 0, 0, 0);
        i1 = Color.argb(0, 0, 0, 0);
        localObject2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, i1 });
        ((GradientDrawable)localObject2).setGradientType(0);
        this.wnX.setBackground((Drawable)localObject2);
        if ((!Util.isNullOrNil(this.EVo.title)) || (!Util.isNullOrNil(this.EVo.description))) {
          this.wnX.setVisibility(0);
        }
        this.EVh.setVisibility(8);
        if (!Util.isNullOrNil(this.EVo.title))
        {
          this.uXS.setVisibility(0);
          this.uXS.setText(com.tencent.mm.ce.g.gxZ().a(this.uXS.getContext(), this.EVo.title, this.uXS.getTextSize()));
        }
        if (!Util.isNullOrNil(this.EVo.description))
        {
          this.EVi.setVisibility(0);
          this.EVi.setText(com.tencent.mm.ce.g.gxZ().a(this.EVi.getContext(), this.EVo.description, this.EVi.getTextSize()));
        }
      }
      Object localObject3;
      Object localObject4;
      boolean bool;
      final long l1;
      for (;;)
      {
        if (this.DsC.getAdInfo().isWeapp())
        {
          i = Color.argb((int)(this.EVo.DWx * 2.55F), 0, 0, 0);
          i1 = Color.argb(0, 0, 0, 0);
          localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, i1 });
          ((GradientDrawable)localObject2).setGradientType(0);
          this.EVh.setVisibility(0);
          this.EVh.setBackground((Drawable)localObject2);
          this.EVl.setVisibility(0);
        }
        localObject2 = localObject1;
        if ((this.timeLineObject.ContentObj == null) || (this.timeLineObject.ContentObj.LoV.size() <= 0)) {
          break label1866;
        }
        localObject1 = (cnb)this.timeLineObject.ContentObj.LoV.get(0);
        this.EUK.a(this.timeLineObject, 0, this.DsC.getLocalid(), true);
        this.EUK.EeT.setVisibility(8);
        localObject3 = aj.faL();
        if (localObject1 == null) {
          break label3209;
        }
        this.EVr.a(this.EVo.DWE, 2);
        if (this.EVr.ac(this.DsC)) {
          this.EVs = false;
        }
        if (this.EUK.Ews != null)
        {
          localObject4 = this.EUK.Ews;
          if (this.EVo.DWE == null) {
            break label1872;
          }
          bool = true;
          ((VideoSightView)localObject4).setIsForbidLoopAnim(bool);
        }
        if (this.EVu != null)
        {
          if (localObject2 == null) {
            break label1878;
          }
          i = ((ViewGroup.LayoutParams)localObject2).height;
          localObject2 = new Rect(k + m, k, j - n, i + k);
          this.EVw = this.EVu.a(this.DsC, this.EVo.DWF, (Rect)localObject2);
        }
        this.EVy.a(this.DsC, this.DsC.getAdXml().adTwistInfo, 2);
        if (!this.DsC.isTwistAd()) {
          break label1883;
        }
        this.EUK.Ewt.setTimerInterval(300);
        if ((!this.EVv) && (!this.EVw)) {
          break label1906;
        }
        bool = true;
        this.EVx = bool;
        this.EUK.EwA = this.EVx;
        localObject4 = new StringBuilder("refreshView, isExptUseNewPlayer=").append(this.EVv).append(", isLongPressGestureAd=").append(this.EVw).append(", hash=").append(hashCode()).append(", snsId=");
        if (this.DsC != null) {
          break label1912;
        }
        localObject2 = "";
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", localObject2);
        l1 = this.DsC.field_snsId;
        if (this.timeLineObject.ContentObj.LoU != 1) {
          break label1927;
        }
        this.EVm.setVisibility(0);
        this.EVm.setTag(this);
        this.EVm.setOnClickListener(this.EVz);
        localObject2 = this.EVm;
        i = this.context.hashCode();
        localObject4 = bp.gCU();
        ((bp)localObject4).hXs = this.timeLineObject.CreateTime;
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a((cnb)localObject1, (View)localObject2, -1, i, (bp)localObject4, 3);
        AppMethodBeat.o(100021);
        return;
        if (this.EVo.DWw != 1) {
          break label3321;
        }
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
        break;
        localObject3 = new StringBuilder("mediaLayout==null, snsId=");
        if (this.DsC == null) {}
        for (localObject2 = "";; localObject2 = Long.valueOf(this.DsC.field_snsId))
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", localObject2);
          break;
        }
        label1509:
        if (this.EVo.DWy == 1)
        {
          i = Color.argb((int)(this.EVo.DWx * 2.55F), 0, 0, 0);
          i1 = Color.argb(0, 0, 0, 0);
          localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, i1 });
          ((GradientDrawable)localObject2).setGradientType(0);
          this.wnX.setVisibility(8);
          this.EVh.setBackground((Drawable)localObject2);
          if ((!Util.isNullOrNil(this.EVo.title)) || (!Util.isNullOrNil(this.EVo.description)))
          {
            this.EVh.setVisibility(0);
            localObject2 = (RelativeLayout.LayoutParams)this.EVl.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 4);
            this.EVl.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          if (!Util.isNullOrNil(this.EVo.title))
          {
            this.EVj.setVisibility(0);
            this.EVj.setText(com.tencent.mm.ce.g.gxZ().a(this.EVj.getContext(), this.EVo.title, this.EVj.getTextSize()));
          }
          if (!Util.isNullOrNil(this.EVo.description))
          {
            this.EVk.setVisibility(0);
            this.EVk.setText(com.tencent.mm.ce.g.gxZ().a(this.EVk.getContext(), this.EVo.description, this.EVk.getTextSize()));
          }
        }
      }
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "invalid full card");
      if (this.DsC == null)
      {
        localObject1 = "";
        i = 0;
        if (this.DsC == null) {
          break label3313;
        }
        if (!this.DsC.isFullCardAd()) {
          break label1861;
        }
        i = 1;
      }
      label1878:
      label1883:
      label2278:
      label2792:
      label3184:
      label3313:
      for (Object localObject2 = this.DsC.getUxinfo();; localObject2 = "")
      {
        j.b(j.DDX, (String)localObject1, 0, i, (String)localObject2);
        localObject2 = null;
        break;
        localObject1 = com.tencent.mm.plugin.sns.data.r.Jb(this.DsC.field_snsId);
        break label1798;
        i = 0;
        break label1819;
        localObject1 = null;
        break label971;
        bool = false;
        break label1079;
        i = 0;
        break label1104;
        this.EUK.Ewt.setTimerInterval(1000);
        this.EVy.clear();
        break label1194;
        label1906:
        bool = false;
        break label1211;
        label1912:
        localObject2 = Long.valueOf(this.DsC.field_snsId);
        break label1291;
        bp localbp;
        if ((this.timeLineObject.ContentObj.LoU == 15) || (this.timeLineObject.ContentObj.LoU == 5))
        {
          if (!this.EVx) {
            break label2440;
          }
          com.tencent.mm.plugin.sns.ad.e.b.a(this.DsC, (cnb)localObject1);
          long l2 = System.nanoTime();
          bool = com.tencent.mm.plugin.sns.model.g.u((cnb)localObject1);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l2) });
          if (!this.EVx) {
            break label2449;
          }
          this.EUK.Ewt.setVisibility(0);
          this.EUK.Ews.setVisibility(8);
          this.EUK.Ewt.setVideoCallback(new OfflineVideoView.a()
          {
            public final boolean a(PString paramAnonymousPString)
            {
              AppMethodBeat.i(179334);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "downloadVideo");
              AppMethodBeat.o(179334);
              return false;
            }
            
            public final void onCompletion()
            {
              AppMethodBeat.i(179336);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "onCompletion");
              if (c.this.EVu != null) {}
              for (boolean bool = c.this.EVu.fhx();; bool = false)
              {
                if ((c.this.EVo.DWE == null) && (!bool)) {
                  c.this.EUK.Ewt.restart();
                }
                c.this.EBv.I(l1, false);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(176407);
                    c.this.fkm();
                    AppMethodBeat.o(176407);
                  }
                });
                AppMethodBeat.o(179336);
                return;
              }
            }
            
            public final void onStart(int paramAnonymousInt)
            {
              AppMethodBeat.i(179335);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "onStart:".concat(String.valueOf(paramAnonymousInt)));
              AppMethodBeat.o(179335);
            }
            
            public final void xv(int paramAnonymousInt)
            {
              AppMethodBeat.i(179337);
              int i = paramAnonymousInt / 1000;
              com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.FullCardAdDetailItem", "updateTime %d", new Object[] { Integer.valueOf(i) });
              if (c.this.EBv != null)
              {
                if (c.this.DsC != null)
                {
                  c.this.EBv.IT(c.this.DsC.field_snsId);
                  c.this.EBv.ao(c.this.DsC.field_snsId, paramAnonymousInt);
                }
                if (!c.this.EBv.IQ(l1))
                {
                  int j = c.this.EUK.Ewt.getDurationMs() / 1000;
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(j)));
                  c.this.EBv.c(l1, Util.currentTicks(), false);
                  c.this.EBv.e(l1, j, false);
                  c.this.EBv.an(l1, l1);
                }
              }
              c.a(c.this, c.this.EVo, c.this.DsC, i * 1000);
              e.a(c.this.EVo, i * 1000, c.this.EVp, c.this.EVq);
              if ((c.this.DsC != null) && (c.this.DsC.isTwistAd())) {
                c.this.EVy.IW(i * 1000);
              }
              if (c.this.EVu != null) {
                c.this.EVu.a(c.this.EBv, paramAnonymousInt, l1);
              }
              AppMethodBeat.o(179337);
            }
          });
          e.a(this.EVo, 0, this.EVp, this.EVq);
          if (bool) {
            break label2719;
          }
          if (!((com.tencent.mm.plugin.sns.model.g)localObject3).x((cnb)localObject1)) {
            break label2515;
          }
          this.EUK.EeS.setVisibility(8);
          this.EUK.Ewv.setVisibility(0);
          this.EUK.Ewv.gYN();
          this.EUK.Ewr.setVisibility(0);
          this.EUK.Ews.setTagObject(this.EUK);
          this.EUK.Ewt.setTag(this.EUK);
          this.EUK.Ewu.setTag(this);
          this.EUK.Ewr.setOnClickListener(this.EVz);
          if (!this.EVx) {
            break label3112;
          }
          localObject2 = this.DsC;
          localObject4 = this.EUK.Ewt;
          i = this.context.hashCode();
          localbp = bp.gCU();
          localbp.hXs = this.timeLineObject.CreateTime;
          ((com.tencent.mm.plugin.sns.model.g)localObject3).a((SnsInfo)localObject2, (cnb)localObject1, (SnsAdTimelineVideoView)localObject4, i, localbp, true);
          this.EUK.Ewt.start();
          this.EUK.Ewt.setShouldPlayWhenPrepared(true);
          this.EVf = true;
          localObject2 = ar.ki(aj.getAccSnsPath(), ((cnb)localObject1).Id);
          localObject3 = com.tencent.mm.plugin.sns.data.r.j((cnb)localObject1);
          localObject2 = (String)localObject2 + (String)localObject3;
          if (this.EBv != null)
          {
            if (!s.YS((String)localObject2)) {
              break label3184;
            }
            this.EBv.f(l1, (int)((cnb)localObject1).MsT, true);
            if (com.tencent.mm.plugin.sns.ad.e.b.KB())
            {
              bool = com.tencent.mm.modelvideo.r.isH265Video((String)localObject2);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "AdH265Helper, fileExists, isH265File=" + bool + ", path=" + (String)localObject2);
            }
            if (aj.faL().b(this.DsC, null) != 5) {
              break label3203;
            }
          }
        }
        for (bool = true;; bool = false)
        {
          this.EBv.d(l1, bool, false);
          AppMethodBeat.o(100021);
          return;
          com.tencent.mm.plugin.sns.ad.e.b.a((cnb)localObject1, false);
          break;
          this.EUK.Ewt.setVisibility(8);
          this.EUK.Ews.setVisibility(0);
          this.EUK.Ews.setOnCompletionListener(new b.e()
          {
            public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              AppMethodBeat.i(179341);
              StringBuilder localStringBuilder = new StringBuilder("sight play completed, retCode=").append(paramAnonymousInt).append(", snsId=");
              if (c.this.DsC == null) {}
              for (paramAnonymousb = "";; paramAnonymousb = Long.valueOf(c.this.DsC.field_snsId))
              {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", paramAnonymousb);
                if (paramAnonymousInt != -1) {
                  c.this.EBv.I(l1, false);
                }
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179340);
                    c.this.fkm();
                    AppMethodBeat.o(179340);
                  }
                });
                AppMethodBeat.o(179341);
                return;
              }
            }
          });
          this.EUK.Ews.setOnDecodeDurationListener(new b.f()
          {
            public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
            {
              AppMethodBeat.i(179342);
              com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.FullCardAdDetailItem", "sight play %d", new Object[] { Long.valueOf(paramAnonymousLong) });
              if (c.this.EBv != null)
              {
                if (c.this.DsC != null)
                {
                  c.this.EBv.IT(c.this.DsC.field_snsId);
                  c.this.EBv.ao(c.this.DsC.field_snsId, 1000L * paramAnonymousLong);
                }
                if (!c.this.EBv.IQ(l1))
                {
                  i = (int)paramAnonymousb.eVC();
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                  c.this.EBv.c(l1, Util.currentTicks(), false);
                  c.this.EBv.e(l1, i, false);
                  c.this.EBv.an(l1, l1);
                }
              }
              int i = (int)paramAnonymousLong;
              c.a(c.this, c.this.EVo, c.this.DsC, i * 1000);
              e.a(c.this.EVo, i * 1000, c.this.EVp, c.this.EVq);
              if ((c.this.DsC != null) && (c.this.DsC.isTwistAd())) {
                c.this.EVy.IW(i * 1000);
              }
              AppMethodBeat.o(179342);
            }
          });
          break label2066;
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(this.DsC, null) == 5)
          {
            ((com.tencent.mm.plugin.sns.model.g)localObject3).B((cnb)localObject1);
            this.EUK.EeS.setVisibility(8);
            this.EUK.Ewv.setVisibility(0);
            this.EUK.Ewv.gYN();
            break label2130;
          }
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).y((cnb)localObject1))
          {
            this.EUK.Ewv.setVisibility(8);
            this.EUK.EeS.setImageResource(2131691482);
            this.EUK.EeS.setVisibility(0);
            break label2130;
          }
          ((com.tencent.mm.plugin.sns.model.g)localObject3).z((cnb)localObject1);
          this.EUK.EeS.setVisibility(0);
          this.EUK.Ewv.setVisibility(8);
          this.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
          this.EUK.EeS.setContentDescription(this.context.getString(2131763945));
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(this.DsC, null) != 4) {
            break label2130;
          }
          this.EUK.EeT.setVisibility(0);
          break label2130;
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).v((cnb)localObject1))
          {
            this.EUK.EeS.setVisibility(0);
            this.EUK.Ewv.setVisibility(8);
            this.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
            this.EUK.EeS.setContentDescription(this.context.getString(2131763945));
            if (!this.EVx) {
              break label3094;
            }
          }
          for (bool = this.EUK.Ewt.isError();; bool = this.EUK.Ews.Dnr.eVz())
          {
            if (!bool) {
              break label3110;
            }
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.FullCardAdDetailItem", "play video error " + ((cnb)localObject1).Id + " " + ((cnb)localObject1).Url + " " + ((cnb)localObject1).Msz);
            ((com.tencent.mm.plugin.sns.model.g)localObject3).z((cnb)localObject1);
            this.EUK.EeS.setVisibility(0);
            this.EUK.Ewv.setVisibility(8);
            this.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
            this.EUK.EeS.setContentDescription(this.context.getString(2131763945));
            break;
            if (((com.tencent.mm.plugin.sns.model.g)localObject3).w((cnb)localObject1))
            {
              this.EUK.EeS.setVisibility(8);
              this.EUK.Ewv.setVisibility(8);
              break label2792;
            }
            if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(this.DsC, null) <= 5)
            {
              this.EUK.EeS.setVisibility(8);
              this.EUK.Ewv.setVisibility(8);
              break label2792;
            }
            ((com.tencent.mm.plugin.sns.model.g)localObject3).z((cnb)localObject1);
            this.EUK.EeS.setVisibility(0);
            this.EUK.Ewv.setVisibility(8);
            this.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691480));
            this.EUK.EeS.setContentDescription(this.context.getString(2131763945));
            break label2792;
          }
          break label2130;
          localObject2 = this.DsC;
          localObject4 = this.EUK.Ews;
          i = this.context.hashCode();
          localbp = bp.gCU();
          localbp.hXs = this.timeLineObject.CreateTime;
          ((com.tencent.mm.plugin.sns.model.g)localObject3).a((SnsInfo)localObject2, (cnb)localObject1, (VideoSightView)localObject4, i, 0, localbp, true, true);
          this.EUK.Ews.start();
          break label2278;
          this.EBv.f(l1, (int)((cnb)localObject1).MsT, false);
          break label2403;
        }
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(this.EUK.Ews, this.context.hashCode(), 0);
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(this.EUK.Ewt, this.context.hashCode());
        this.EUK.Eww.setVisibility(8);
        this.EUK.Ews.setOnSightCompletionAction(null);
        this.EUK.Ews.setOnCompletionListener(null);
        this.EUK.Ews.setOnDecodeDurationListener(null);
        this.EUK.Ewt.setVideoCallback(null);
        AppMethodBeat.o(100021);
        return;
      }
      label2403:
      label3321:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.c
 * JD-Core Version:    0.7.0.1
 */