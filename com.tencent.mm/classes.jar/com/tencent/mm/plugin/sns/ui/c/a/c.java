package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
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
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.au;
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
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends a
{
  Context context;
  boolean mIsPaused;
  public View rXY;
  public View yGK;
  com.tencent.mm.plugin.sns.ad.d.i yJJ;
  private boolean zbU;
  public View zbW;
  private TextView zbX;
  private TextView zbY;
  private TextView zbZ;
  private TextView zca;
  public View zcb;
  public MaskImageView zcc;
  SnsDrawGestureView zcd;
  b.g zce;
  ImageView zcf;
  ImageView zcg;
  SnsAdCardVideoEndView zch;
  boolean zci;
  private SnsAdTouchProgressView zcj;
  private SnsAdSphereAnimView zck;
  au zcl;
  private boolean zcm;
  private boolean zcn;
  boolean zco;
  private View.OnClickListener zcp;
  private View.OnClickListener zcq;
  protected SnsAdTouchProgressView.a zcr;
  
  public c(TimeLineObject paramTimeLineObject, p paramp, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.ad.d.i parami)
  {
    AppMethodBeat.i(176410);
    this.zci = false;
    this.zcm = false;
    this.zcn = false;
    this.zco = false;
    this.zcp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176409);
        ac.i("MicroMsg.FullCardAdDetailItem", "ProxyCardClickListener onClick");
        try
        {
          c.this.xLF.zgZ.onClick(paramAnonymousView);
          if (c.this.zci) {
            SnsAdCardVideoEndView.h(c.this.xIq, 2);
          }
          AppMethodBeat.o(176409);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ac.e("MicroMsg.FullCardAdDetailItem", "ProxyCardClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.zcq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179347);
        ac.i("MicroMsg.FullCardAdDetailItem", "ProxySightClickListener onClick");
        try
        {
          c.this.xLF.zgM.onClick(paramAnonymousView);
          if (c.this.zci) {
            SnsAdCardVideoEndView.h(c.this.xIq, 2);
          }
          AppMethodBeat.o(179347);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ac.e("MicroMsg.FullCardAdDetailItem", "ProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.zbU = false;
    this.mIsPaused = false;
    this.zcr = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179338);
        try
        {
          ac.i("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onClick");
          c.this.zbE.yFc.performClick();
          AppMethodBeat.o(179338);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          ac.e("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onClick exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(179338);
        }
      }
      
      public final void onFinish()
      {
        int i = 1;
        AppMethodBeat.i(179339);
        ac.i("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onFinish");
        for (;;)
        {
          try
          {
            c.this.xLF.a(c.this);
            q.d(new long[] { 20L, 100L });
            if (!(c.this.context instanceof SnsCommentDetailUI)) {
              break label197;
            }
            i = ((SnsCommentDetailUI)c.this.context).getSource();
          }
          catch (Exception localException)
          {
            SnsAdClick localSnsAdClick;
            ac.e("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onFinish, exp=" + localException.toString());
            AppMethodBeat.o(179339);
            return;
          }
          com.tencent.mm.plugin.sns.ui.item.c.a(c.this.context, c.this.contentView, c.this.xIq, i);
          localSnsAdClick = new SnsAdClick(1, 2, q.atd(c.this.xIq.dLV().Id), 28, 21);
          com.tencent.mm.plugin.sns.data.j.a(localSnsAdClick, c.this.yJJ, c.this.xIq, 28);
          q.a(localSnsAdClick);
          AppMethodBeat.o(179339);
          return;
          label197:
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
    this.timeLineObject = paramTimeLineObject;
    this.xIq = paramp;
    this.xLF = paramb;
    this.yJJ = parami;
    AppMethodBeat.o(176410);
  }
  
  private void dRH()
  {
    AppMethodBeat.i(176411);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179346);
        c.this.zcd.setVisibility(8);
        c.this.zcd.setBackgroundColor(0);
        c.this.zcd.dSK();
        c.this.zcd.setOnGestureListener(null);
        AppMethodBeat.o(179346);
      }
    });
    AppMethodBeat.o(176411);
  }
  
  public final void dRI()
  {
    AppMethodBeat.i(179349);
    for (;;)
    {
      try
      {
        if ((this.zce == null) || (this.zce.yhg == null)) {
          break;
        }
        if (this.zco)
        {
          this.zch.setBlurBkg(this.zbE.yFe.getInnerVideoView());
          this.zch.aQP();
          this.zch.dSy();
          this.zci = true;
          if (this.zco)
          {
            this.zbE.yFe.setShouldPlayWhenPrepared(false);
            this.zbE.yFe.pause();
            dRH();
            ap.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(179348);
                if (((c.this.context instanceof Activity)) && (!((Activity)c.this.context).isFinishing()))
                {
                  c.this.zch.dT(true);
                  c.this.zci = false;
                  if (!c.this.mIsPaused)
                  {
                    if (c.this.zco)
                    {
                      c.this.zbE.yFe.restart();
                      AppMethodBeat.o(179348);
                      return;
                    }
                    c.this.zbE.yFd.start();
                    AppMethodBeat.o(179348);
                    return;
                  }
                  ac.e("MicroMsg.FullCardAdDetailItem", "activity isPaused");
                  AppMethodBeat.o(179348);
                  return;
                }
                ac.e("MicroMsg.FullCardAdDetailItem", "onCompletion, postDelayed-run activity isFinished");
                AppMethodBeat.o(179348);
              }
            }, this.zce.yhg.duration);
            AppMethodBeat.o(179349);
          }
        }
        else
        {
          this.zch.setBlurBkg(this.contentView);
          continue;
        }
        this.zbE.yFd.pause();
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.FullCardAdDetailItem", "handleVideoCompletion, exp" + localException.toString());
        AppMethodBeat.o(179349);
        return;
      }
    }
    this.zch.dT(false);
    AppMethodBeat.o(179349);
  }
  
  public final void l(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100020);
    this.contentView = paramView1;
    this.yJk = paramView2;
    this.context = paramView1.getContext();
    this.yGK = paramView1.findViewById(2131300321);
    this.rXY = paramView1.findViewById(2131306008);
    this.zbW = paramView1.findViewById(2131297449);
    this.zbX = ((TextView)paramView1.findViewById(2131306010));
    this.zbY = ((TextView)paramView1.findViewById(2131306009));
    this.zbZ = ((TextView)paramView1.findViewById(2131297451));
    this.zca = ((TextView)paramView1.findViewById(2131297450));
    this.zcb = paramView1.findViewById(2131297455);
    this.zcc = ((MaskImageView)paramView1.findViewById(2131300322));
    this.zcd = ((SnsDrawGestureView)paramView1.findViewById(2131304972));
    this.zcc.setScaleType(QImageView.a.JbU);
    this.zcf = ((ImageView)paramView1.findViewById(2131300311));
    this.zcg = ((ImageView)paramView1.findViewById(2131299487));
    this.zbE = new com.tencent.mm.plugin.sns.ui.an();
    this.zbE.yFf = paramView1.findViewById(2131300324);
    this.zbE.yFc = this.zbE.yFf;
    this.zbE.yFf.setOnClickListener(this.zcq);
    this.zbE.yFd = ((VideoSightView)this.zbE.yFf.findViewById(2131300914));
    this.zbE.yFe = ((SnsAdTimelineVideoView)this.zbE.yFf.findViewById(2131302995));
    this.zbE.yFd.setMute(true);
    this.zbE.yFe.setMute(true);
    this.zbE.yoI = ((ImageView)paramView1.findViewById(2131300323));
    this.zbE.yFg = ((MMPinProgressBtn)this.zbE.yFf.findViewById(2131303515));
    this.zbE.yFh = ((TextView)this.zbE.yFf.findViewById(2131299492));
    this.zbE.yoJ = ((TextView)this.zbE.yFf.findViewById(2131299517));
    this.zbE.yFd.xDO = true;
    this.zbE.yFd.setScaleType(QImageView.a.JbU);
    this.zch = ((SnsAdCardVideoEndView)paramView1.findViewById(2131304975));
    this.zcj = ((SnsAdTouchProgressView)paramView1.findViewById(2131305046));
    if (this.zck == null) {
      this.zck = ((SnsAdSphereAnimView)((ViewStub)this.khe.findViewById(2131304926)).inflate());
    }
    for (;;)
    {
      this.zck.setVisibility(8);
      this.zcl = new au(this.context, this.zcj, this.zck, this.zbE);
      this.zcl.yHW = this.zcr;
      this.zcm = com.tencent.mm.plugin.sns.ui.item.c.dRN();
      AppMethodBeat.o(100020);
      return;
      ac.e("MicroMsg.FullCardAdDetailItem", "initView many times");
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(179350);
    ac.i("MicroMsg.FullCardAdDetailItem", "onPause, hasPlayedVideo=" + this.zbU);
    this.mIsPaused = true;
    try
    {
      if ((this.zbU) && (this.zbE != null) && (this.zbE.yFd != null))
      {
        if (!this.zco) {
          break label130;
        }
        this.zbE.yFe.pause();
        this.zbE.yFe.setShouldPlayWhenPrepared(false);
        this.zcl.dPg();
      }
      for (;;)
      {
        if ((this.yJJ != null) && (this.xIq != null)) {
          this.yJJ.wQ(this.xIq.field_snsId);
        }
        AppMethodBeat.o(179350);
        return;
        label130:
        this.zbE.yFd.pause();
      }
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.FullCardAdDetailItem", "onPause, exp=" + localException.toString());
      AppMethodBeat.o(179350);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100021);
    this.xIq = com.tencent.mm.plugin.sns.storage.h.auS(this.xIq.getSnsId());
    this.zce = null;
    if ((this.xIq != null) && (this.xIq.dFR() != null)) {
      this.zce = this.xIq.dFR().ygn;
    }
    Object localObject1 = null;
    Object localObject2 = (WindowManager)this.context.getSystemService("window");
    int i = Math.min(((WindowManager)localObject2).getDefaultDisplay().getWidth(), ((WindowManager)localObject2).getDefaultDisplay().getHeight());
    this.rXY.setVisibility(8);
    this.zbX.setVisibility(8);
    this.zbY.setVisibility(8);
    this.zbW.setVisibility(8);
    this.zbZ.setVisibility(8);
    this.zca.setVisibility(8);
    this.zcb.setVisibility(8);
    this.zbU = false;
    this.mIsPaused = false;
    int j;
    Object localObject3;
    label845:
    label989:
    Object localObject4;
    if (this.zce != null)
    {
      i = i - com.tencent.mm.cc.a.au(this.context, 2131166827) - com.tencent.mm.cc.a.au(this.context, 2131165274) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516);
      if (this.zce.ygY == 0)
      {
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
        if (localObject1 != null)
        {
          localObject2 = this.contentView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((RoundedCornerFrameLayout)this.contentView).setRadius(com.tencent.mm.cc.a.fromDPToPix(this.context, 8));
          localObject2 = this.zcc.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.zcc.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = this.zbE.yFc.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.zbE.yFc.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.zbE.yFd.hf(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
          localObject2 = this.zbE.yFe.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.zbE.yFe.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = this.zcf.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.zcf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = this.zcg.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.zcg.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = this.zch.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.zch.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        if (this.zce.yha != 0) {
          break label1404;
        }
        i = Color.argb((int)(this.zce.ygZ * 2.55F), 0, 0, 0);
        j = Color.argb(0, 0, 0, 0);
        localObject2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j });
        ((GradientDrawable)localObject2).setGradientType(0);
        this.rXY.setBackground((Drawable)localObject2);
        if ((!bs.isNullOrNil(this.zce.title)) || (!bs.isNullOrNil(this.zce.description))) {
          this.rXY.setVisibility(0);
        }
        this.zbW.setVisibility(8);
        if (!bs.isNullOrNil(this.zce.title))
        {
          this.zbX.setVisibility(0);
          localObject2 = this.zbX;
          localObject3 = g.eXw();
          this.zbX.getContext();
          ((TextView)localObject2).setText(((g)localObject3).b(this.zce.title, this.zbX.getTextSize()));
        }
        if (!bs.isNullOrNil(this.zce.description))
        {
          this.zbY.setVisibility(0);
          localObject2 = this.zbY;
          localObject3 = g.eXw();
          this.zbY.getContext();
          ((TextView)localObject2).setText(((g)localObject3).b(this.zce.description, this.zbY.getTextSize()));
        }
        if (this.xIq.dFQ().dJC())
        {
          i = Color.argb((int)(this.zce.ygZ * 2.55F), 0, 0, 0);
          j = Color.argb(0, 0, 0, 0);
          localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, j });
          ((GradientDrawable)localObject2).setGradientType(0);
          this.zbW.setVisibility(0);
          this.zbW.setBackground((Drawable)localObject2);
          this.zcb.setVisibility(0);
        }
        localObject2 = localObject1;
        if ((this.timeLineObject.FQo == null) || (this.timeLineObject.FQo.Etz.size() <= 0)) {
          break label1743;
        }
        localObject1 = (btz)this.timeLineObject.FQo.Etz.get(0);
        this.zbE.a(this.timeLineObject, 0, this.xIq.dMu(), true);
        this.zbE.yoJ.setVisibility(8);
        localObject3 = af.dHO();
        if (localObject1 == null) {
          break label3038;
        }
        this.zch.a(this.zce.yhg, 2);
        if (this.zch.T(this.xIq)) {
          this.zci = false;
        }
        if (this.zbE.yFd != null)
        {
          localObject4 = this.zbE.yFd;
          if (this.zce.yhg == null) {
            break label1749;
          }
          bool = true;
          label1096:
          ((VideoSightView)localObject4).setIsForbidLoopAnim(bool);
        }
        j = com.tencent.mm.cc.a.fromDPToPix(this.context, 52);
        if (localObject2 == null) {
          break label1754;
        }
        i = ((ViewGroup.LayoutParams)localObject2).height;
        label1123:
        this.zcn = this.zcl.a(this.xIq, this.zce.yhh, i + j);
        if ((!this.zcm) && (!this.zcn)) {
          break label1759;
        }
        bool = true;
        label1164:
        this.zco = bool;
        this.zbE.yFl = this.zco;
        localObject4 = new StringBuilder("refreshView, isExptUseNewPlayer=").append(this.zcm).append(", isLongPressGestureAd=").append(this.zcn).append(", hash=").append(hashCode()).append(", snsId=");
        if (this.xIq != null) {
          break label1764;
        }
      }
    }
    final long l1;
    label1743:
    label1749:
    label1754:
    label1759:
    label1764:
    for (localObject2 = "";; localObject2 = Long.valueOf(this.xIq.field_snsId))
    {
      ac.i("MicroMsg.FullCardAdDetailItem", localObject2);
      l1 = this.xIq.field_snsId;
      if (this.timeLineObject.FQo.Ety != 1) {
        break label1779;
      }
      this.zcc.setVisibility(0);
      this.zcc.setTag(this);
      this.zcc.setOnClickListener(this.zcp);
      localObject2 = this.zcc;
      i = this.context.hashCode();
      localObject4 = bf.fbk();
      ((bf)localObject4).gIh = this.timeLineObject.CreateTime;
      ((f)localObject3).a((btz)localObject1, (View)localObject2, -1, i, (bf)localObject4, 3);
      AppMethodBeat.o(100021);
      return;
      if (this.zce.ygY != 1) {
        break;
      }
      localObject1 = new ViewGroup.LayoutParams(-2, -2);
      ((ViewGroup.LayoutParams)localObject1).width = i;
      ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
      break;
      label1404:
      if (this.zce.yha != 1) {
        break label845;
      }
      i = Color.argb((int)(this.zce.ygZ * 2.55F), 0, 0, 0);
      j = Color.argb(0, 0, 0, 0);
      localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, j });
      ((GradientDrawable)localObject2).setGradientType(0);
      this.rXY.setVisibility(8);
      this.zbW.setBackground((Drawable)localObject2);
      if ((!bs.isNullOrNil(this.zce.title)) || (!bs.isNullOrNil(this.zce.description)))
      {
        this.zbW.setVisibility(0);
        localObject2 = (RelativeLayout.LayoutParams)this.zcb.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 4);
        this.zcb.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (!bs.isNullOrNil(this.zce.title))
      {
        this.zbZ.setVisibility(0);
        localObject2 = this.zbZ;
        localObject3 = g.eXw();
        this.zbZ.getContext();
        ((TextView)localObject2).setText(((g)localObject3).b(this.zce.title, this.zbZ.getTextSize()));
      }
      if (bs.isNullOrNil(this.zce.description)) {
        break label845;
      }
      this.zca.setVisibility(0);
      localObject2 = this.zca;
      localObject3 = g.eXw();
      this.zca.getContext();
      ((TextView)localObject2).setText(((g)localObject3).b(this.zce.description, this.zca.getTextSize()));
      break label845;
      ac.e("MicroMsg.FullCardAdDetailItem", "invalid full card");
      if (this.xIq == null) {}
      for (localObject1 = "";; localObject1 = q.wW(this.xIq.field_snsId))
      {
        com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.xNe, (String)localObject1, 0, 0, "");
        localObject2 = null;
        break;
      }
      localObject1 = null;
      break label989;
      bool = false;
      break label1096;
      i = 0;
      break label1123;
      bool = false;
      break label1164;
    }
    label1779:
    label2037:
    bf localbf;
    if ((this.timeLineObject.FQo.Ety == 15) || (this.timeLineObject.FQo.Ety == 5))
    {
      long l2 = System.nanoTime();
      bool = f.t((btz)localObject1);
      ac.i("MicroMsg.FullCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l2) });
      if (!this.zco) {
        break label2288;
      }
      this.zbE.yFe.setVisibility(0);
      this.zbE.yFd.setVisibility(8);
      this.zbE.yFe.setVideoCallback(new OfflineVideoView.a()
      {
        public final boolean a(PString paramAnonymousPString)
        {
          AppMethodBeat.i(179334);
          ac.i("MicroMsg.FullCardAdDetailItem", "downloadVideo");
          AppMethodBeat.o(179334);
          return false;
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(179336);
          ac.i("MicroMsg.FullCardAdDetailItem", "onCompletion");
          boolean bool = c.this.zcl.dPf();
          if ((c.this.zce.yhg == null) && (!bool)) {
            c.this.zbE.yFe.restart();
          }
          c.this.yJJ.A(l1, false);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(176407);
              c.this.dRI();
              AppMethodBeat.o(176407);
            }
          });
          AppMethodBeat.o(179336);
        }
        
        public final void onStart(int paramAnonymousInt)
        {
          AppMethodBeat.i(179335);
          ac.i("MicroMsg.FullCardAdDetailItem", "onStart:".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(179335);
        }
        
        public final void sQ(int paramAnonymousInt)
        {
          AppMethodBeat.i(179337);
          int i = paramAnonymousInt / 1000;
          ac.d("MicroMsg.FullCardAdDetailItem", "updateTime %d", new Object[] { Integer.valueOf(i) });
          if (c.this.yJJ != null)
          {
            if (c.this.xIq != null)
            {
              c.this.yJJ.wP(c.this.xIq.field_snsId);
              c.this.yJJ.ah(c.this.xIq.field_snsId, paramAnonymousInt);
            }
            if (!c.this.yJJ.wM(l1))
            {
              int j = c.this.zbE.yFe.getDurationMs() / 1000;
              ac.i("MicroMsg.FullCardAdDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(j)));
              c.this.yJJ.d(l1, bs.Gn(), false);
              c.this.yJJ.e(l1, j, false);
              c.this.yJJ.ag(l1, l1);
            }
          }
          c.a(c.this, c.this.zce, c.this.xIq, i * 1000);
          com.tencent.mm.plugin.sns.ui.item.c.a(c.this.zce, i * 1000, c.this.zcf, c.this.zcg);
          c.this.zcl.a(c.this.yJJ, paramAnonymousInt, l1);
          AppMethodBeat.o(179337);
        }
      });
      com.tencent.mm.plugin.sns.ui.item.c.a(this.zce, 0, this.zcf, this.zcg);
      localObject2 = this.zce.yhb;
      localObject4 = this.xIq.dFR().dJT();
      if ((!bs.isNullOrNil((String)localObject4)) && (localObject2 != null) && (((b.g.a)localObject2).startTime >= 0L) && (((b.g.a)localObject2).endTime > ((b.g.a)localObject2).startTime)) {
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100018);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.dLO().f("adId", this.zcw, "adxml", 0);
            AppMethodBeat.o(100018);
          }
        }, "preDownloadFloatPage");
      }
      if (bool) {
        break label2558;
      }
      if (!((f)localObject3).w((btz)localObject1)) {
        break label2354;
      }
      this.zbE.yoI.setVisibility(8);
      this.zbE.yFg.setVisibility(0);
      this.zbE.yFg.fuE();
      this.zbE.yFc.setVisibility(0);
      this.zbE.yFd.setTagObject(this.zbE);
      this.zbE.yFe.setTag(this.zbE);
      this.zbE.yFf.setTag(this);
      this.zbE.yFc.setOnClickListener(this.zcp);
      if (!this.zco) {
        break label2948;
      }
      localObject2 = this.xIq;
      localObject4 = this.zbE.yFe;
      i = this.context.hashCode();
      localbf = bf.fbk();
      localbf.gIh = this.timeLineObject.CreateTime;
      ((f)localObject3).a((p)localObject2, (btz)localObject1, (SnsAdTimelineVideoView)localObject4, i, localbf, true);
      this.zbE.yFe.start();
      this.zbE.yFe.setShouldPlayWhenPrepared(true);
      label2185:
      this.zbU = true;
      localObject2 = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), ((btz)localObject1).Id);
      localObject1 = q.i((btz)localObject1);
      if (this.yJJ != null)
      {
        if (!com.tencent.mm.vfs.i.eA((String)localObject2 + (String)localObject1)) {
          break label3020;
        }
        this.yJJ.B(l1, true);
        label2253:
        if (af.dHO().b(this.xIq, null) != 5) {
          break label3033;
        }
      }
    }
    label2354:
    label2631:
    label3020:
    label3033:
    for (boolean bool = true;; bool = false)
    {
      this.yJJ.c(l1, bool, false);
      AppMethodBeat.o(100021);
      return;
      label2288:
      this.zbE.yFe.setVisibility(8);
      this.zbE.yFd.setVisibility(0);
      this.zbE.yFd.setOnCompletionListener(new b.e()
      {
        public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
        {
          AppMethodBeat.i(179341);
          StringBuilder localStringBuilder = new StringBuilder("sight play completed, retCode=").append(paramAnonymousInt).append(", snsId=");
          if (c.this.xIq == null) {}
          for (paramAnonymousb = "";; paramAnonymousb = Long.valueOf(c.this.xIq.field_snsId))
          {
            ac.i("MicroMsg.FullCardAdDetailItem", paramAnonymousb);
            if (paramAnonymousInt != -1) {
              c.this.yJJ.A(l1, false);
            }
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(179340);
                c.this.dRI();
                AppMethodBeat.o(179340);
              }
            });
            AppMethodBeat.o(179341);
            return;
          }
        }
      });
      this.zbE.yFd.setOnDecodeDurationListener(new b.f()
      {
        public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
        {
          AppMethodBeat.i(179342);
          ac.d("MicroMsg.FullCardAdDetailItem", "sight play %d", new Object[] { Long.valueOf(paramAnonymousLong) });
          if (c.this.yJJ != null)
          {
            if (c.this.xIq != null)
            {
              c.this.yJJ.wP(c.this.xIq.field_snsId);
              c.this.yJJ.ah(c.this.xIq.field_snsId, 1000L * paramAnonymousLong);
            }
            if (!c.this.yJJ.wM(l1))
            {
              i = (int)paramAnonymousb.dED();
              ac.i("MicroMsg.FullCardAdDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
              c.this.yJJ.d(l1, bs.Gn(), false);
              c.this.yJJ.e(l1, i, false);
              c.this.yJJ.ag(l1, l1);
            }
          }
          int i = (int)paramAnonymousLong;
          c.a(c.this, c.this.zce, c.this.xIq, i * 1000);
          com.tencent.mm.plugin.sns.ui.item.c.a(c.this.zce, i * 1000, c.this.zcf, c.this.zcg);
          AppMethodBeat.o(179342);
        }
      });
      break;
      if (((f)localObject3).b(this.xIq, null) == 5)
      {
        ((f)localObject3).A((btz)localObject1);
        this.zbE.yoI.setVisibility(8);
        this.zbE.yFg.setVisibility(0);
        this.zbE.yFg.fuE();
        break label2037;
      }
      if (((f)localObject3).x((btz)localObject1))
      {
        this.zbE.yFg.setVisibility(8);
        this.zbE.yoI.setImageResource(2131234034);
        this.zbE.yoI.setVisibility(0);
        break label2037;
      }
      ((f)localObject3).y((btz)localObject1);
      this.zbE.yoI.setVisibility(0);
      this.zbE.yFg.setVisibility(8);
      this.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
      this.zbE.yoI.setContentDescription(this.context.getString(2131761939));
      if (((f)localObject3).b(this.xIq, null) != 4) {
        break label2037;
      }
      this.zbE.yoJ.setVisibility(0);
      break label2037;
      label2558:
      if (((f)localObject3).u((btz)localObject1))
      {
        this.zbE.yoI.setVisibility(0);
        this.zbE.yFg.setVisibility(8);
        this.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
        this.zbE.yoI.setContentDescription(this.context.getString(2131761939));
        if (!this.zco) {
          break label2931;
        }
      }
      label2931:
      for (bool = this.zbE.yFe.isError();; bool = this.zbE.yFd.xDG.dEA())
      {
        if (!bool) {
          break label2946;
        }
        ac.d("MicroMsg.FullCardAdDetailItem", "play video error " + ((btz)localObject1).Id + " " + ((btz)localObject1).Url + " " + ((btz)localObject1).Fjh);
        ((f)localObject3).y((btz)localObject1);
        this.zbE.yoI.setVisibility(0);
        this.zbE.yFg.setVisibility(8);
        this.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
        this.zbE.yoI.setContentDescription(this.context.getString(2131761939));
        break;
        if (((f)localObject3).v((btz)localObject1))
        {
          this.zbE.yoI.setVisibility(8);
          this.zbE.yFg.setVisibility(8);
          break label2631;
        }
        if (((f)localObject3).b(this.xIq, null) <= 5)
        {
          this.zbE.yoI.setVisibility(8);
          this.zbE.yFg.setVisibility(8);
          break label2631;
        }
        ((f)localObject3).y((btz)localObject1);
        this.zbE.yoI.setVisibility(0);
        this.zbE.yFg.setVisibility(8);
        this.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
        this.zbE.yoI.setContentDescription(this.context.getString(2131761939));
        break label2631;
      }
      break label2037;
      localObject2 = this.xIq;
      localObject4 = this.zbE.yFd;
      i = this.context.hashCode();
      localbf = bf.fbk();
      localbf.gIh = this.timeLineObject.CreateTime;
      ((f)localObject3).a((p)localObject2, (btz)localObject1, (VideoSightView)localObject4, i, 0, localbf, true, true);
      this.zbE.yFd.start();
      break label2185;
      this.yJJ.B(l1, false);
      break label2253;
    }
    label2946:
    label2948:
    label3038:
    ((f)localObject3).a(this.zbE.yFd, this.context.hashCode(), 0);
    ((f)localObject3).a(this.zbE.yFe, this.context.hashCode());
    this.zbE.yFh.setVisibility(8);
    this.zbE.yFd.setOnSightCompletionAction(null);
    this.zbE.yFd.setOnCompletionListener(null);
    this.zbE.yFd.setOnDecodeDurationListener(null);
    this.zbE.yFe.setVideoCallback(null);
    AppMethodBeat.o(100021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.c
 * JD-Core Version:    0.7.0.1
 */