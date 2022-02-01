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
import com.tencent.mm.cg.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.b.f.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
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

public final class c
  extends a
{
  Context context;
  boolean mIsPaused;
  public View qXs;
  private View.OnClickListener xPA;
  protected SnsAdTouchProgressView.a xPB;
  private boolean xPe;
  public View xPg;
  private TextView xPh;
  private TextView xPi;
  private TextView xPj;
  private TextView xPk;
  public View xPl;
  public MaskImageView xPm;
  SnsDrawGestureView xPn;
  com.tencent.mm.plugin.sns.storage.b.f xPo;
  ImageView xPp;
  ImageView xPq;
  SnsAdCardVideoEndView xPr;
  boolean xPs;
  private SnsAdTouchProgressView xPt;
  private SnsAdSphereAnimView xPu;
  au xPv;
  private boolean xPw;
  private boolean xPx;
  boolean xPy;
  private View.OnClickListener xPz;
  public View xtU;
  com.tencent.mm.plugin.sns.a.b.i xwT;
  
  public c(TimeLineObject paramTimeLineObject, p paramp, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.a.b.i parami)
  {
    AppMethodBeat.i(176410);
    this.xPs = false;
    this.xPw = false;
    this.xPx = false;
    this.xPy = false;
    this.xPz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176409);
        ad.i("MicroMsg.FullCardAdDetailItem", "ProxyCardClickListener onClick");
        try
        {
          c.this.xta.xUd.onClick(paramAnonymousView);
          if (c.this.xPs) {
            SnsAdCardVideoEndView.h(c.this.wwP, 2);
          }
          AppMethodBeat.o(176409);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ad.e("MicroMsg.FullCardAdDetailItem", "ProxyCardClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.xPA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179347);
        ad.i("MicroMsg.FullCardAdDetailItem", "ProxySightClickListener onClick");
        try
        {
          c.this.xta.xTQ.onClick(paramAnonymousView);
          if (c.this.xPs) {
            SnsAdCardVideoEndView.h(c.this.wwP, 2);
          }
          AppMethodBeat.o(179347);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ad.e("MicroMsg.FullCardAdDetailItem", "ProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.xPe = false;
    this.mIsPaused = false;
    this.xPB = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179338);
        try
        {
          ad.i("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onClick");
          c.this.xOO.xsm.performClick();
          AppMethodBeat.o(179338);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          ad.e("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onClick exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(179338);
        }
      }
      
      public final void onFinish()
      {
        int i = 1;
        AppMethodBeat.i(179339);
        ad.i("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onFinish");
        for (;;)
        {
          try
          {
            c.this.xta.a(c.this);
            q.d(new long[] { 20L, 100L });
            if (!(c.this.context instanceof SnsCommentDetailUI)) {
              break label197;
            }
            i = ((SnsCommentDetailUI)c.this.context).getSource();
          }
          catch (Exception localException)
          {
            SnsAdClick localSnsAdClick;
            ad.e("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onFinish, exp=" + localException.toString());
            AppMethodBeat.o(179339);
            return;
          }
          com.tencent.mm.plugin.sns.ui.item.c.a(c.this.context, c.this.contentView, c.this.wwP, i);
          localSnsAdClick = new SnsAdClick(1, 2, q.anR(c.this.wwP.dxy().Id), 28, 21);
          com.tencent.mm.plugin.sns.data.j.a(localSnsAdClick, c.this.xwT, c.this.wwP, 28);
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
    this.wwP = paramp;
    this.xta = paramb;
    this.xwT = parami;
    AppMethodBeat.o(176410);
  }
  
  private void dDk()
  {
    AppMethodBeat.i(176411);
    com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179346);
        c.this.xPn.setVisibility(8);
        c.this.xPn.setBackgroundColor(0);
        c.this.xPn.dEm();
        c.this.xPn.setOnGestureListener(null);
        AppMethodBeat.o(179346);
      }
    });
    AppMethodBeat.o(176411);
  }
  
  public final void dDl()
  {
    AppMethodBeat.i(179349);
    for (;;)
    {
      try
      {
        if ((this.xPo == null) || (this.xPo.wUs == null)) {
          break;
        }
        if (this.xPy)
        {
          this.xPr.setBlurBkg(this.xOO.xso.getInnerVideoView());
          this.xPr.aJY();
          this.xPr.dEa();
          this.xPs = true;
          if (this.xPy)
          {
            this.xOO.xso.setShouldPlayWhenPrepared(false);
            this.xOO.xso.pause();
            dDk();
            com.tencent.mm.sdk.platformtools.aq.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(179348);
                if (((c.this.context instanceof Activity)) && (!((Activity)c.this.context).isFinishing()))
                {
                  c.this.xPr.hH(true);
                  c.this.xPs = false;
                  if (!c.this.mIsPaused)
                  {
                    if (c.this.xPy)
                    {
                      c.this.xOO.xso.restart();
                      AppMethodBeat.o(179348);
                      return;
                    }
                    c.this.xOO.xsn.start();
                    AppMethodBeat.o(179348);
                    return;
                  }
                  ad.e("MicroMsg.FullCardAdDetailItem", "activity isPaused");
                  AppMethodBeat.o(179348);
                  return;
                }
                ad.e("MicroMsg.FullCardAdDetailItem", "onCompletion, postDelayed-run activity isFinished");
                AppMethodBeat.o(179348);
              }
            }, this.xPo.wUs.duration);
            AppMethodBeat.o(179349);
          }
        }
        else
        {
          this.xPr.setBlurBkg(this.contentView);
          continue;
        }
        this.xOO.xsn.pause();
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.FullCardAdDetailItem", "handleVideoCompletion, exp" + localException.toString());
        AppMethodBeat.o(179349);
        return;
      }
    }
    this.xPr.hH(false);
    AppMethodBeat.o(179349);
  }
  
  public final void k(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100020);
    this.contentView = paramView1;
    this.xwu = paramView2;
    this.context = paramView1.getContext();
    this.xtU = paramView1.findViewById(2131300321);
    this.qXs = paramView1.findViewById(2131306008);
    this.xPg = paramView1.findViewById(2131297449);
    this.xPh = ((TextView)paramView1.findViewById(2131306010));
    this.xPi = ((TextView)paramView1.findViewById(2131306009));
    this.xPj = ((TextView)paramView1.findViewById(2131297451));
    this.xPk = ((TextView)paramView1.findViewById(2131297450));
    this.xPl = paramView1.findViewById(2131297455);
    this.xPm = ((MaskImageView)paramView1.findViewById(2131300322));
    this.xPn = ((SnsDrawGestureView)paramView1.findViewById(2131304972));
    this.xPm.setScaleType(QImageView.a.HBy);
    this.xPp = ((ImageView)paramView1.findViewById(2131300311));
    this.xPq = ((ImageView)paramView1.findViewById(2131299487));
    this.xOO = new com.tencent.mm.plugin.sns.ui.an();
    this.xOO.xsp = paramView1.findViewById(2131300324);
    this.xOO.xsm = this.xOO.xsp;
    this.xOO.xsp.setOnClickListener(this.xPA);
    this.xOO.xsn = ((VideoSightView)this.xOO.xsp.findViewById(2131300914));
    this.xOO.xso = ((SnsAdTimelineVideoView)this.xOO.xsp.findViewById(2131302995));
    this.xOO.xsn.setMute(true);
    this.xOO.xso.setMute(true);
    this.xOO.xbT = ((ImageView)paramView1.findViewById(2131300323));
    this.xOO.xsq = ((MMPinProgressBtn)this.xOO.xsp.findViewById(2131303515));
    this.xOO.xsr = ((TextView)this.xOO.xsp.findViewById(2131299492));
    this.xOO.xbU = ((TextView)this.xOO.xsp.findViewById(2131299517));
    this.xOO.xsn.wsy = true;
    this.xOO.xsn.setScaleType(QImageView.a.HBy);
    this.xPr = ((SnsAdCardVideoEndView)paramView1.findViewById(2131304975));
    this.xPt = ((SnsAdTouchProgressView)paramView1.findViewById(2131305046));
    if (this.xPu == null) {
      this.xPu = ((SnsAdSphereAnimView)((ViewStub)this.jGG.findViewById(2131304926)).inflate());
    }
    for (;;)
    {
      this.xPu.setVisibility(8);
      this.xPv = new au(this.context, this.xPt, this.xPu, this.xOO);
      this.xPv.xvg = this.xPB;
      this.xPw = com.tencent.mm.plugin.sns.ui.item.c.dDp();
      AppMethodBeat.o(100020);
      return;
      ad.e("MicroMsg.FullCardAdDetailItem", "initView many times");
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(179350);
    ad.i("MicroMsg.FullCardAdDetailItem", "onPause, hasPlayedVideo=" + this.xPe);
    this.mIsPaused = true;
    try
    {
      if ((this.xPe) && (this.xOO != null) && (this.xOO.xsn != null))
      {
        if (!this.xPy) {
          break label130;
        }
        this.xOO.xso.pause();
        this.xOO.xso.setShouldPlayWhenPrepared(false);
        this.xPv.dAJ();
      }
      for (;;)
      {
        if ((this.xwT != null) && (this.wwP != null)) {
          this.xwT.sn(this.wwP.field_snsId);
        }
        AppMethodBeat.o(179350);
        return;
        label130:
        this.xOO.xsn.pause();
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.FullCardAdDetailItem", "onPause, exp=" + localException.toString());
      AppMethodBeat.o(179350);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100021);
    this.wwP = com.tencent.mm.plugin.sns.storage.h.apJ(this.wwP.getSnsId());
    this.xPo = null;
    if ((this.wwP != null) && (this.wwP.dxs() != null)) {
      this.xPo = this.wwP.dxs().wTD;
    }
    Object localObject1 = null;
    Object localObject2 = (WindowManager)this.context.getSystemService("window");
    int i = Math.min(((WindowManager)localObject2).getDefaultDisplay().getWidth(), ((WindowManager)localObject2).getDefaultDisplay().getHeight());
    this.qXs.setVisibility(8);
    this.xPh.setVisibility(8);
    this.xPi.setVisibility(8);
    this.xPg.setVisibility(8);
    this.xPj.setVisibility(8);
    this.xPk.setVisibility(8);
    this.xPl.setVisibility(8);
    this.xPe = false;
    this.mIsPaused = false;
    int j;
    Object localObject3;
    label845:
    label989:
    Object localObject4;
    if (this.xPo != null)
    {
      i = i - com.tencent.mm.cd.a.ao(this.context, 2131166827) - com.tencent.mm.cd.a.ao(this.context, 2131165274) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516);
      if (this.xPo.wUk == 0)
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
          ((RoundedCornerFrameLayout)this.contentView).setRadius(com.tencent.mm.cd.a.fromDPToPix(this.context, 8));
          localObject2 = this.xPm.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.xPm.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = this.xOO.xsm.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.xOO.xsm.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.xOO.xsn.gW(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
          localObject2 = this.xOO.xso.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.xOO.xso.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = this.xPp.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.xPp.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = this.xPq.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.xPq.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = this.xPr.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.xPr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        if (this.xPo.wUm != 0) {
          break label1404;
        }
        i = Color.argb((int)(this.xPo.wUl * 2.55F), 0, 0, 0);
        j = Color.argb(0, 0, 0, 0);
        localObject2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j });
        ((GradientDrawable)localObject2).setGradientType(0);
        this.qXs.setBackground((Drawable)localObject2);
        if ((!bt.isNullOrNil(this.xPo.title)) || (!bt.isNullOrNil(this.xPo.description))) {
          this.qXs.setVisibility(0);
        }
        this.xPg.setVisibility(8);
        if (!bt.isNullOrNil(this.xPo.title))
        {
          this.xPh.setVisibility(0);
          localObject2 = this.xPh;
          localObject3 = g.eIa();
          this.xPh.getContext();
          ((TextView)localObject2).setText(((g)localObject3).b(this.xPo.title, this.xPh.getTextSize()));
        }
        if (!bt.isNullOrNil(this.xPo.description))
        {
          this.xPi.setVisibility(0);
          localObject2 = this.xPi;
          localObject3 = g.eIa();
          this.xPi.getContext();
          ((TextView)localObject2).setText(((g)localObject3).b(this.xPo.description, this.xPi.getTextSize()));
        }
        if (this.wwP.dxu().dvd())
        {
          i = Color.argb((int)(this.xPo.wUl * 2.55F), 0, 0, 0);
          j = Color.argb(0, 0, 0, 0);
          localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, j });
          ((GradientDrawable)localObject2).setGradientType(0);
          this.xPg.setVisibility(0);
          this.xPg.setBackground((Drawable)localObject2);
          this.xPl.setVisibility(0);
        }
        localObject2 = localObject1;
        if ((this.timeLineObject.Etm == null) || (this.timeLineObject.Etm.DaC.size() <= 0)) {
          break label1743;
        }
        localObject1 = (bpi)this.timeLineObject.Etm.DaC.get(0);
        this.xOO.a(this.timeLineObject, 0, this.wwP.dxX(), true);
        this.xOO.xbU.setVisibility(8);
        localObject3 = af.dtr();
        if (localObject1 == null) {
          break label3022;
        }
        this.xPr.a(this.xPo.wUs, 2);
        if (this.xPr.S(this.wwP)) {
          this.xPs = false;
        }
        if (this.xOO.xsn != null)
        {
          localObject4 = this.xOO.xsn;
          if (this.xPo.wUs == null) {
            break label1749;
          }
          bool = true;
          label1096:
          ((VideoSightView)localObject4).setIsForbidLoopAnim(bool);
        }
        j = com.tencent.mm.cd.a.fromDPToPix(this.context, 52);
        if (localObject2 == null) {
          break label1754;
        }
        i = ((ViewGroup.LayoutParams)localObject2).height;
        label1123:
        this.xPx = this.xPv.a(this.wwP, this.xPo.wUt, i + j);
        if ((!this.xPw) && (!this.xPx)) {
          break label1759;
        }
        bool = true;
        label1164:
        this.xPy = bool;
        this.xOO.xsv = this.xPy;
        localObject4 = new StringBuilder("refreshView, isExptUseNewPlayer=").append(this.xPw).append(", isLongPressGestureAd=").append(this.xPx).append(", hash=").append(hashCode()).append(", snsId=");
        if (this.wwP != null) {
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
    for (localObject2 = "";; localObject2 = Long.valueOf(this.wwP.field_snsId))
    {
      ad.i("MicroMsg.FullCardAdDetailItem", localObject2);
      l1 = this.wwP.field_snsId;
      if (this.timeLineObject.Etm.DaB != 1) {
        break label1779;
      }
      this.xPm.setVisibility(0);
      this.xPm.setTag(this);
      this.xPm.setOnClickListener(this.xPz);
      localObject2 = this.xPm;
      i = this.context.hashCode();
      localObject4 = bc.eLG();
      ((bc)localObject4).tGD = this.timeLineObject.CreateTime;
      ((f)localObject3).a((bpi)localObject1, (View)localObject2, -1, i, (bc)localObject4, 3);
      AppMethodBeat.o(100021);
      return;
      if (this.xPo.wUk != 1) {
        break;
      }
      localObject1 = new ViewGroup.LayoutParams(-2, -2);
      ((ViewGroup.LayoutParams)localObject1).width = i;
      ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
      break;
      label1404:
      if (this.xPo.wUm != 1) {
        break label845;
      }
      i = Color.argb((int)(this.xPo.wUl * 2.55F), 0, 0, 0);
      j = Color.argb(0, 0, 0, 0);
      localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, j });
      ((GradientDrawable)localObject2).setGradientType(0);
      this.qXs.setVisibility(8);
      this.xPg.setBackground((Drawable)localObject2);
      if ((!bt.isNullOrNil(this.xPo.title)) || (!bt.isNullOrNil(this.xPo.description)))
      {
        this.xPg.setVisibility(0);
        localObject2 = (RelativeLayout.LayoutParams)this.xPl.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 4);
        this.xPl.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (!bt.isNullOrNil(this.xPo.title))
      {
        this.xPj.setVisibility(0);
        localObject2 = this.xPj;
        localObject3 = g.eIa();
        this.xPj.getContext();
        ((TextView)localObject2).setText(((g)localObject3).b(this.xPo.title, this.xPj.getTextSize()));
      }
      if (bt.isNullOrNil(this.xPo.description)) {
        break label845;
      }
      this.xPk.setVisibility(0);
      localObject2 = this.xPk;
      localObject3 = g.eIa();
      this.xPk.getContext();
      ((TextView)localObject2).setText(((g)localObject3).b(this.xPo.description, this.xPk.getTextSize()));
      break label845;
      ad.e("MicroMsg.FullCardAdDetailItem", "invalid full card");
      if (this.wwP == null) {}
      for (localObject1 = "";; localObject1 = q.st(this.wwP.field_snsId))
      {
        com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.wAK, (String)localObject1, 0, 0, "");
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
    bc localbc;
    if ((this.timeLineObject.Etm.DaB == 15) || (this.timeLineObject.Etm.DaB == 5))
    {
      long l2 = System.nanoTime();
      bool = f.t((bpi)localObject1);
      ad.i("MicroMsg.FullCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l2) });
      if (!this.xPy) {
        break label2272;
      }
      this.xOO.xso.setVisibility(0);
      this.xOO.xsn.setVisibility(8);
      this.xOO.xso.setVideoCallback(new OfflineVideoView.a()
      {
        public final boolean a(PString paramAnonymousPString)
        {
          AppMethodBeat.i(179334);
          ad.i("MicroMsg.FullCardAdDetailItem", "downloadVideo");
          AppMethodBeat.o(179334);
          return false;
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(179336);
          ad.i("MicroMsg.FullCardAdDetailItem", "onCompletion");
          boolean bool = c.this.xPv.dAI();
          if ((c.this.xPo.wUs == null) && (!bool)) {
            c.this.xOO.xso.restart();
          }
          c.this.xwT.A(l1, false);
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(176407);
              c.this.dDl();
              AppMethodBeat.o(176407);
            }
          });
          AppMethodBeat.o(179336);
        }
        
        public final void onStart(int paramAnonymousInt)
        {
          AppMethodBeat.i(179335);
          ad.i("MicroMsg.FullCardAdDetailItem", "onStart:".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(179335);
        }
        
        public final void sa(int paramAnonymousInt)
        {
          AppMethodBeat.i(179337);
          int i = paramAnonymousInt / 1000;
          ad.d("MicroMsg.FullCardAdDetailItem", "updateTime %d", new Object[] { Integer.valueOf(i) });
          if (c.this.xwT != null)
          {
            if (c.this.wwP != null)
            {
              c.this.xwT.sm(c.this.wwP.field_snsId);
              c.this.xwT.ak(c.this.wwP.field_snsId, paramAnonymousInt);
            }
            if (!c.this.xwT.sj(l1))
            {
              int j = c.this.xOO.xso.getDurationMs() / 1000;
              ad.i("MicroMsg.FullCardAdDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(j)));
              c.this.xwT.d(l1, bt.GC(), false);
              c.this.xwT.e(l1, j, false);
              c.this.xwT.aj(l1, l1);
            }
          }
          c.a(c.this, c.this.xPo, c.this.wwP, i * 1000);
          com.tencent.mm.plugin.sns.ui.item.c.a(c.this.xPo, i * 1000, c.this.xPp, c.this.xPq);
          c.this.xPv.a(c.this.xwT, paramAnonymousInt, l1);
          AppMethodBeat.o(179337);
        }
      });
      localObject2 = this.xPo.wUn;
      localObject4 = this.wwP.dxs().dvu();
      if ((!bt.isNullOrNil((String)localObject4)) && (localObject2 != null) && (((b.f.a)localObject2).startTime >= 0L) && (((b.f.a)localObject2).endTime > ((b.f.a)localObject2).startTime)) {
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100018);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.dxp().f("adId", this.xPG, "adxml", 0);
            AppMethodBeat.o(100018);
          }
        }, "preDownloadFloatPage");
      }
      if (bool) {
        break label2542;
      }
      if (!((f)localObject3).w((bpi)localObject1)) {
        break label2338;
      }
      this.xOO.xbT.setVisibility(8);
      this.xOO.xsq.setVisibility(0);
      this.xOO.xsq.feJ();
      label2021:
      this.xOO.xsm.setVisibility(0);
      this.xOO.xsn.setTagObject(this.xOO);
      this.xOO.xso.setTag(this.xOO);
      this.xOO.xsp.setTag(this);
      this.xOO.xsm.setOnClickListener(this.xPz);
      if (!this.xPy) {
        break label2932;
      }
      localObject2 = this.wwP;
      localObject4 = this.xOO.xso;
      i = this.context.hashCode();
      localbc = bc.eLG();
      localbc.tGD = this.timeLineObject.CreateTime;
      ((f)localObject3).a((p)localObject2, (bpi)localObject1, (SnsAdTimelineVideoView)localObject4, i, localbc, true);
      this.xOO.xso.start();
      this.xOO.xso.setShouldPlayWhenPrepared(true);
      label2169:
      this.xPe = true;
      localObject2 = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), ((bpi)localObject1).Id);
      localObject1 = q.i((bpi)localObject1);
      if (this.xwT != null)
      {
        if (!com.tencent.mm.vfs.i.eK((String)localObject2 + (String)localObject1)) {
          break label3004;
        }
        this.xwT.B(l1, true);
        label2237:
        if (af.dtr().b(this.wwP, null) != 5) {
          break label3017;
        }
      }
    }
    label2338:
    label2615:
    label3004:
    label3017:
    for (boolean bool = true;; bool = false)
    {
      this.xwT.e(l1, bool, false);
      AppMethodBeat.o(100021);
      return;
      label2272:
      this.xOO.xso.setVisibility(8);
      this.xOO.xsn.setVisibility(0);
      this.xOO.xsn.setOnCompletionListener(new b.e()
      {
        public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
        {
          AppMethodBeat.i(179341);
          StringBuilder localStringBuilder = new StringBuilder("sight play completed, retCode=").append(paramAnonymousInt).append(", snsId=");
          if (c.this.wwP == null) {}
          for (paramAnonymousb = "";; paramAnonymousb = Long.valueOf(c.this.wwP.field_snsId))
          {
            ad.i("MicroMsg.FullCardAdDetailItem", paramAnonymousb);
            if (paramAnonymousInt != -1) {
              c.this.xwT.A(l1, false);
            }
            com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(179340);
                c.this.dDl();
                AppMethodBeat.o(179340);
              }
            });
            AppMethodBeat.o(179341);
            return;
          }
        }
      });
      this.xOO.xsn.setOnDecodeDurationListener(new com.tencent.mm.plugin.sight.decode.a.b.f()
      {
        public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
        {
          AppMethodBeat.i(179342);
          ad.d("MicroMsg.FullCardAdDetailItem", "sight play %d", new Object[] { Long.valueOf(paramAnonymousLong) });
          if (c.this.xwT != null)
          {
            if (c.this.wwP != null)
            {
              c.this.xwT.sm(c.this.wwP.field_snsId);
              c.this.xwT.ak(c.this.wwP.field_snsId, 1000L * paramAnonymousLong);
            }
            if (!c.this.xwT.sj(l1))
            {
              i = (int)paramAnonymousb.dqu();
              ad.i("MicroMsg.FullCardAdDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
              c.this.xwT.d(l1, bt.GC(), false);
              c.this.xwT.e(l1, i, false);
              c.this.xwT.aj(l1, l1);
            }
          }
          int i = (int)paramAnonymousLong;
          c.a(c.this, c.this.xPo, c.this.wwP, i * 1000);
          com.tencent.mm.plugin.sns.ui.item.c.a(c.this.xPo, i * 1000, c.this.xPp, c.this.xPq);
          AppMethodBeat.o(179342);
        }
      });
      break;
      if (((f)localObject3).b(this.wwP, null) == 5)
      {
        ((f)localObject3).A((bpi)localObject1);
        this.xOO.xbT.setVisibility(8);
        this.xOO.xsq.setVisibility(0);
        this.xOO.xsq.feJ();
        break label2021;
      }
      if (((f)localObject3).x((bpi)localObject1))
      {
        this.xOO.xsq.setVisibility(8);
        this.xOO.xbT.setImageResource(2131234034);
        this.xOO.xbT.setVisibility(0);
        break label2021;
      }
      ((f)localObject3).y((bpi)localObject1);
      this.xOO.xbT.setVisibility(0);
      this.xOO.xsq.setVisibility(8);
      this.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
      this.xOO.xbT.setContentDescription(this.context.getString(2131761939));
      if (((f)localObject3).b(this.wwP, null) != 4) {
        break label2021;
      }
      this.xOO.xbU.setVisibility(0);
      break label2021;
      label2542:
      if (((f)localObject3).u((bpi)localObject1))
      {
        this.xOO.xbT.setVisibility(0);
        this.xOO.xsq.setVisibility(8);
        this.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
        this.xOO.xbT.setContentDescription(this.context.getString(2131761939));
        if (!this.xPy) {
          break label2915;
        }
      }
      label2915:
      for (bool = this.xOO.xso.isError();; bool = this.xOO.xsn.wsq.dqr())
      {
        if (!bool) {
          break label2930;
        }
        ad.d("MicroMsg.FullCardAdDetailItem", "play video error " + ((bpi)localObject1).Id + " " + ((bpi)localObject1).Url + " " + ((bpi)localObject1).DMQ);
        ((f)localObject3).y((bpi)localObject1);
        this.xOO.xbT.setVisibility(0);
        this.xOO.xsq.setVisibility(8);
        this.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
        this.xOO.xbT.setContentDescription(this.context.getString(2131761939));
        break;
        if (((f)localObject3).v((bpi)localObject1))
        {
          this.xOO.xbT.setVisibility(8);
          this.xOO.xsq.setVisibility(8);
          break label2615;
        }
        if (((f)localObject3).b(this.wwP, null) <= 5)
        {
          this.xOO.xbT.setVisibility(8);
          this.xOO.xsq.setVisibility(8);
          break label2615;
        }
        ((f)localObject3).y((bpi)localObject1);
        this.xOO.xbT.setVisibility(0);
        this.xOO.xsq.setVisibility(8);
        this.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
        this.xOO.xbT.setContentDescription(this.context.getString(2131761939));
        break label2615;
      }
      label2930:
      break label2021;
      label2932:
      localObject2 = this.wwP;
      localObject4 = this.xOO.xsn;
      i = this.context.hashCode();
      localbc = bc.eLG();
      localbc.tGD = this.timeLineObject.CreateTime;
      ((f)localObject3).a((p)localObject2, (bpi)localObject1, (VideoSightView)localObject4, i, 0, localbc, true, true);
      this.xOO.xsn.start();
      break label2169;
      this.xwT.B(l1, false);
      break label2237;
    }
    label3022:
    ((f)localObject3).a(this.xOO.xsn, this.context.hashCode(), 0);
    ((f)localObject3).a(this.xOO.xso, this.context.hashCode());
    this.xOO.xsr.setVisibility(8);
    this.xOO.xsn.setOnSightCompletionAction(null);
    this.xOO.xsn.setOnCompletionListener(null);
    this.xOO.xsn.setOnDecodeDurationListener(null);
    this.xOO.xso.setVideoCallback(null);
    AppMethodBeat.o(100021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.c
 * JD-Core Version:    0.7.0.1
 */