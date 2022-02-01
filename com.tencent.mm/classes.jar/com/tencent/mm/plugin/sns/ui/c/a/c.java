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
import android.util.Log;
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
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.b.g;
import com.tencent.mm.plugin.sns.storage.b.g.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.item.d;
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

public final class c
  extends a
{
  com.tencent.mm.plugin.sns.ad.d.i Abd;
  private boolean AtL;
  public View AtN;
  private TextView AtO;
  private TextView AtP;
  private TextView AtQ;
  private TextView AtR;
  public View AtS;
  public MaskImageView AtT;
  SnsDrawGestureView AtU;
  b.g AtV;
  ImageView AtW;
  ImageView AtX;
  SnsAdCardVideoEndView AtY;
  boolean AtZ;
  private SnsAdSphereAnimView Aua;
  ax Aub;
  private boolean Auc;
  private boolean Aud;
  boolean Aue;
  private View.OnClickListener Auf;
  private View.OnClickListener Aug;
  protected SnsAdTouchProgressView.a Auh;
  Context context;
  boolean mIsPaused;
  public View sUS;
  public View zYc;
  
  public c(TimeLineObject paramTimeLineObject, p paramp, com.tencent.mm.plugin.sns.ui.d.c paramc, com.tencent.mm.plugin.sns.ad.d.i parami)
  {
    AppMethodBeat.i(176410);
    this.AtZ = false;
    this.Auc = false;
    this.Aud = false;
    this.Aue = false;
    this.Auf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176409);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.FullCardAdDetailItem", "ProxyCardClickListener onClick");
        try
        {
          c.this.zaU.Azc.onClick(paramAnonymousView);
          if (c.this.AtZ) {
            SnsAdCardVideoEndView.i(c.this.yXF, 2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    this.Aug = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179347);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.FullCardAdDetailItem", "ProxySightClickListener onClick");
        try
        {
          c.this.zaU.AyP.onClick(paramAnonymousView);
          if (c.this.AtZ) {
            SnsAdCardVideoEndView.i(c.this.yXF, 2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    this.AtL = false;
    this.mIsPaused = false;
    this.Auh = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179338);
        try
        {
          ad.i("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onClick");
          c.this.Atv.zWx.performClick();
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
            c.this.zaU.a(c.this);
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
          d.a(c.this.context, c.this.contentView, c.this.yXF, i);
          localSnsAdClick = new SnsAdClick(1, 2, q.ayi(c.this.yXF.dYl().Id), 28, 21);
          com.tencent.mm.plugin.sns.data.j.a(localSnsAdClick, c.this.Abd, c.this.yXF, 28);
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
    this.yXF = paramp;
    this.zaU = paramc;
    this.Abd = parami;
    AppMethodBeat.o(176410);
  }
  
  private void eeb()
  {
    AppMethodBeat.i(176411);
    com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179346);
        c.this.AtU.setVisibility(8);
        c.this.AtU.setBackgroundColor(0);
        c.this.AtU.efd();
        c.this.AtU.setOnGestureListener(null);
        AppMethodBeat.o(179346);
      }
    });
    AppMethodBeat.o(176411);
  }
  
  public final void c(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(198531);
    try
    {
      ad.i("MicroMsg.FullCardAdDetailItem", "initLongPressView");
      SnsAdTouchProgressView localSnsAdTouchProgressView = (SnsAdTouchProgressView)paramFrameLayout.findViewById(2131308213);
      localSnsAdTouchProgressView.setVisibility(8);
      this.Aub = new ax(this.context, localSnsAdTouchProgressView, this.Aua, this.Atv, paramFrameLayout);
      this.Aub.zZq = this.Auh;
      AppMethodBeat.o(198531);
      return;
    }
    catch (Exception paramFrameLayout)
    {
      ad.e("MicroMsg.FullCardAdDetailItem", "initLongPressView exp=" + Log.getStackTraceString(paramFrameLayout));
      AppMethodBeat.o(198531);
    }
  }
  
  public final void eec()
  {
    AppMethodBeat.i(179349);
    for (;;)
    {
      try
      {
        if ((this.AtV == null) || (this.AtV.zxn == null)) {
          break;
        }
        if (this.Aue)
        {
          this.AtY.setBlurBkg(this.Atv.zWz.getInnerVideoView());
          this.AtY.aUb();
          this.AtY.eeS();
          this.AtZ = true;
          if (this.Aue)
          {
            this.Atv.zWz.setShouldPlayWhenPrepared(false);
            this.Atv.zWz.pause();
            eeb();
            com.tencent.mm.sdk.platformtools.aq.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(179348);
                if (((c.this.context instanceof Activity)) && (!((Activity)c.this.context).isFinishing()))
                {
                  c.this.AtY.dV(true);
                  c.this.AtZ = false;
                  if (!c.this.mIsPaused)
                  {
                    if (c.this.Aue)
                    {
                      c.this.Atv.zWz.restart();
                      AppMethodBeat.o(179348);
                      return;
                    }
                    c.this.Atv.zWy.start();
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
            }, this.AtV.zxn.duration);
            AppMethodBeat.o(179349);
          }
        }
        else
        {
          this.AtY.setBlurBkg(this.contentView);
          continue;
        }
        this.Atv.zWy.pause();
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.FullCardAdDetailItem", "handleVideoCompletion, exp" + localException.toString());
        AppMethodBeat.o(179349);
        return;
      }
    }
    this.AtY.dV(false);
    AppMethodBeat.o(179349);
  }
  
  public final void m(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100020);
    this.contentView = paramView1;
    this.AaE = paramView2;
    this.context = paramView1.getContext();
    this.zYc = paramView1.findViewById(2131300321);
    this.sUS = paramView1.findViewById(2131306008);
    this.AtN = paramView1.findViewById(2131297449);
    this.AtO = ((TextView)paramView1.findViewById(2131306010));
    this.AtP = ((TextView)paramView1.findViewById(2131306009));
    this.AtQ = ((TextView)paramView1.findViewById(2131297451));
    this.AtR = ((TextView)paramView1.findViewById(2131297450));
    this.AtS = paramView1.findViewById(2131297455);
    this.AtT = ((MaskImageView)paramView1.findViewById(2131300322));
    this.AtU = ((SnsDrawGestureView)paramView1.findViewById(2131304972));
    this.AtT.setScaleType(QImageView.a.KTb);
    this.AtW = ((ImageView)paramView1.findViewById(2131300311));
    this.AtX = ((ImageView)paramView1.findViewById(2131299487));
    this.Atv = new com.tencent.mm.plugin.sns.ui.aq();
    this.Atv.zWA = paramView1.findViewById(2131300324);
    this.Atv.zWx = this.Atv.zWA;
    this.Atv.zWA.setOnClickListener(this.Aug);
    this.Atv.zWy = ((VideoSightView)this.Atv.zWA.findViewById(2131300914));
    this.Atv.zWz = ((SnsAdTimelineVideoView)this.Atv.zWA.findViewById(2131302995));
    this.Atv.zWy.setMute(true);
    this.Atv.zWz.setMute(true);
    this.Atv.zFD = ((ImageView)paramView1.findViewById(2131300323));
    this.Atv.zWB = ((MMPinProgressBtn)this.Atv.zWA.findViewById(2131303515));
    this.Atv.zWC = ((TextView)this.Atv.zWA.findViewById(2131299492));
    this.Atv.zFE = ((TextView)this.Atv.zWA.findViewById(2131299517));
    this.Atv.zWy.ySy = true;
    this.Atv.zWy.setScaleType(QImageView.a.KTb);
    this.AtY = ((SnsAdCardVideoEndView)paramView1.findViewById(2131304975));
    if (this.Aua == null) {
      this.Aua = ((SnsAdSphereAnimView)((ViewStub)this.kBS.findViewById(2131304926)).inflate());
    }
    for (;;)
    {
      this.Aua.setVisibility(8);
      this.Auc = d.eeh();
      AppMethodBeat.o(100020);
      return;
      ad.e("MicroMsg.FullCardAdDetailItem", "initView many times");
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(179350);
    ad.i("MicroMsg.FullCardAdDetailItem", "onPause, hasPlayedVideo=" + this.AtL);
    this.mIsPaused = true;
    try
    {
      if ((this.AtL) && (this.Atv != null) && (this.Atv.zWy != null))
      {
        if (!this.Aue) {
          break label137;
        }
        this.Atv.zWz.pause();
        this.Atv.zWz.setShouldPlayWhenPrepared(false);
        if (this.Aub != null) {
          this.Aub.ebx();
        }
      }
      for (;;)
      {
        if ((this.Abd != null) && (this.yXF != null)) {
          this.Abd.zq(this.yXF.field_snsId);
        }
        AppMethodBeat.o(179350);
        return;
        label137:
        this.Atv.zWy.pause();
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
    this.yXF = h.azZ(this.yXF.getSnsId());
    this.AtV = null;
    if ((this.yXF != null) && (this.yXF.dRL() != null)) {
      this.AtV = this.yXF.dRL().zwp;
    }
    Object localObject1 = (WindowManager)this.context.getSystemService("window");
    int j = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    this.sUS.setVisibility(8);
    this.AtO.setVisibility(8);
    this.AtP.setVisibility(8);
    this.AtN.setVisibility(8);
    this.AtQ.setVisibility(8);
    this.AtR.setVisibility(8);
    this.AtS.setVisibility(8);
    this.AtL = false;
    this.mIsPaused = false;
    int k = com.tencent.mm.cc.a.ax(this.context, 2131166827);
    int m = com.tencent.mm.cc.a.ax(this.context, 2131165274);
    int n = this.context.getResources().getDimensionPixelSize(2131165516);
    int i;
    if (this.AtV != null)
    {
      i = j - k - m - n - n;
      if (this.AtV.zxf == 0)
      {
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
      }
    }
    label3072:
    for (;;)
    {
      int i1;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = this.contentView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((RoundedCornerFrameLayout)this.contentView).setRadius(com.tencent.mm.cc.a.fromDPToPix(this.context, 8));
        localObject2 = this.AtT.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.AtT.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.Atv.zWx.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.Atv.zWx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.Atv.zWy.hw(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        localObject2 = this.Atv.zWz.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.Atv.zWz.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.AtW.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.AtW.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.AtX.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.AtX.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.AtY.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.AtY.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (this.AtV.zxh != 0) {
          break label1482;
        }
        i = Color.argb((int)(this.AtV.zxg * 2.55F), 0, 0, 0);
        i1 = Color.argb(0, 0, 0, 0);
        localObject2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, i1 });
        ((GradientDrawable)localObject2).setGradientType(0);
        this.sUS.setBackground((Drawable)localObject2);
        if ((!bt.isNullOrNil(this.AtV.title)) || (!bt.isNullOrNil(this.AtV.description))) {
          this.sUS.setVisibility(0);
        }
        this.AtN.setVisibility(8);
        if (!bt.isNullOrNil(this.AtV.title))
        {
          this.AtO.setVisibility(0);
          localObject2 = this.AtO;
          localObject3 = com.tencent.mm.cf.g.fng();
          this.AtO.getContext();
          ((TextView)localObject2).setText(((com.tencent.mm.cf.g)localObject3).b(this.AtV.title, this.AtO.getTextSize()));
        }
        if (!bt.isNullOrNil(this.AtV.description))
        {
          this.AtP.setVisibility(0);
          localObject2 = this.AtP;
          localObject3 = com.tencent.mm.cf.g.fng();
          this.AtP.getContext();
          ((TextView)localObject2).setText(((com.tencent.mm.cf.g)localObject3).b(this.AtV.description, this.AtP.getTextSize()));
        }
      }
      label989:
      Object localObject4;
      boolean bool;
      label1097:
      label1122:
      label1264:
      final long l1;
      for (;;)
      {
        if (this.yXF.dRK().dVQ())
        {
          i = Color.argb((int)(this.AtV.zxg * 2.55F), 0, 0, 0);
          i1 = Color.argb(0, 0, 0, 0);
          localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, i1 });
          ((GradientDrawable)localObject2).setGradientType(0);
          this.AtN.setVisibility(0);
          this.AtN.setBackground((Drawable)localObject2);
          this.AtS.setVisibility(0);
        }
        localObject2 = localObject1;
        if ((this.timeLineObject.HAT == null) || (this.timeLineObject.HAT.GaQ.size() <= 0)) {
          break label1857;
        }
        localObject1 = (byn)this.timeLineObject.HAT.GaQ.get(0);
        this.Atv.a(this.timeLineObject, 0, this.yXF.dYK(), true);
        this.Atv.zFE.setVisibility(8);
        localObject3 = ag.dUb();
        if (localObject1 == null) {
          break label3163;
        }
        this.AtY.a(this.AtV.zxn, 2);
        if (this.AtY.V(this.yXF)) {
          this.AtZ = false;
        }
        if (this.Atv.zWy != null)
        {
          localObject4 = this.Atv.zWy;
          if (this.AtV.zxn == null) {
            break label1863;
          }
          bool = true;
          ((VideoSightView)localObject4).setIsForbidLoopAnim(bool);
        }
        if (this.Aub != null)
        {
          if (localObject2 == null) {
            break label1869;
          }
          i = ((ViewGroup.LayoutParams)localObject2).height;
          localObject2 = new Rect(k + m, k, j - n, i + k);
          this.Aud = this.Aub.a(this.yXF, this.AtV.zxo, (Rect)localObject2);
        }
        if ((!this.Auc) && (!this.Aud)) {
          break label1874;
        }
        bool = true;
        label1184:
        this.Aue = bool;
        this.Atv.zWG = this.Aue;
        localObject4 = new StringBuilder("refreshView, isExptUseNewPlayer=").append(this.Auc).append(", isLongPressGestureAd=").append(this.Aud).append(", hash=").append(hashCode()).append(", snsId=");
        if (this.yXF != null) {
          break label1880;
        }
        localObject2 = "";
        ad.i("MicroMsg.FullCardAdDetailItem", localObject2);
        l1 = this.yXF.field_snsId;
        if (this.timeLineObject.HAT.GaP != 1) {
          break label1895;
        }
        this.AtT.setVisibility(0);
        this.AtT.setTag(this);
        this.AtT.setOnClickListener(this.Auf);
        localObject2 = this.AtT;
        i = this.context.hashCode();
        localObject4 = bj.frn();
        ((bj)localObject4).hbR = this.timeLineObject.CreateTime;
        ((f)localObject3).a((byn)localObject1, (View)localObject2, -1, i, (bj)localObject4, 3);
        AppMethodBeat.o(100021);
        return;
        if (this.AtV.zxf != 1) {
          break label3275;
        }
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
        break;
        localObject3 = new StringBuilder("mediaLayout==null, snsId=");
        if (this.yXF == null) {}
        for (localObject2 = "";; localObject2 = Long.valueOf(this.yXF.field_snsId))
        {
          ad.e("MicroMsg.FullCardAdDetailItem", localObject2);
          break;
        }
        label1482:
        if (this.AtV.zxh == 1)
        {
          i = Color.argb((int)(this.AtV.zxg * 2.55F), 0, 0, 0);
          i1 = Color.argb(0, 0, 0, 0);
          localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, i1 });
          ((GradientDrawable)localObject2).setGradientType(0);
          this.sUS.setVisibility(8);
          this.AtN.setBackground((Drawable)localObject2);
          if ((!bt.isNullOrNil(this.AtV.title)) || (!bt.isNullOrNil(this.AtV.description)))
          {
            this.AtN.setVisibility(0);
            localObject2 = (RelativeLayout.LayoutParams)this.AtS.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cc.a.fromDPToPix(this.context, 4);
            this.AtS.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          if (!bt.isNullOrNil(this.AtV.title))
          {
            this.AtQ.setVisibility(0);
            localObject2 = this.AtQ;
            localObject3 = com.tencent.mm.cf.g.fng();
            this.AtQ.getContext();
            ((TextView)localObject2).setText(((com.tencent.mm.cf.g)localObject3).b(this.AtV.title, this.AtQ.getTextSize()));
          }
          if (!bt.isNullOrNil(this.AtV.description))
          {
            this.AtR.setVisibility(0);
            localObject2 = this.AtR;
            localObject3 = com.tencent.mm.cf.g.fng();
            this.AtR.getContext();
            ((TextView)localObject2).setText(((com.tencent.mm.cf.g)localObject3).b(this.AtV.description, this.AtR.getTextSize()));
          }
        }
      }
      ad.e("MicroMsg.FullCardAdDetailItem", "invalid full card");
      if (this.yXF == null)
      {
        localObject1 = "";
        label1789:
        i = 0;
        if (this.yXF == null) {
          break label3267;
        }
        if (!this.yXF.dWa()) {
          break label1852;
        }
        i = 1;
      }
      label1810:
      label1852:
      label1857:
      label3267:
      for (Object localObject2 = this.yXF.dYT();; localObject2 = "")
      {
        com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.zcX, (String)localObject1, 0, i, (String)localObject2);
        localObject2 = null;
        break;
        localObject1 = q.zw(this.yXF.field_snsId);
        break label1789;
        i = 0;
        break label1810;
        localObject1 = null;
        break label989;
        label1863:
        bool = false;
        break label1097;
        label1869:
        i = 0;
        break label1122;
        label1874:
        bool = false;
        break label1184;
        label1880:
        localObject2 = Long.valueOf(this.yXF.field_snsId);
        break label1264;
        label1895:
        label2156:
        bj localbj;
        if ((this.timeLineObject.HAT.GaP == 15) || (this.timeLineObject.HAT.GaP == 5))
        {
          long l2 = System.nanoTime();
          bool = f.t((byn)localObject1);
          ad.i("MicroMsg.FullCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l2) });
          if (!this.Aue) {
            break label2409;
          }
          this.Atv.zWz.setVisibility(0);
          this.Atv.zWy.setVisibility(8);
          this.Atv.zWz.setVideoCallback(new OfflineVideoView.a()
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
              if (c.this.Aub != null) {}
              for (boolean bool = c.this.Aub.ebw();; bool = false)
              {
                if ((c.this.AtV.zxn == null) && (!bool)) {
                  c.this.Atv.zWz.restart();
                }
                c.this.Abd.A(l1, false);
                com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(176407);
                    c.this.eec();
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
              ad.i("MicroMsg.FullCardAdDetailItem", "onStart:".concat(String.valueOf(paramAnonymousInt)));
              AppMethodBeat.o(179335);
            }
            
            public final void tt(int paramAnonymousInt)
            {
              AppMethodBeat.i(179337);
              int i = paramAnonymousInt / 1000;
              ad.d("MicroMsg.FullCardAdDetailItem", "updateTime %d", new Object[] { Integer.valueOf(i) });
              if (c.this.Abd != null)
              {
                if (c.this.yXF != null)
                {
                  c.this.Abd.zp(c.this.yXF.field_snsId);
                  c.this.Abd.ak(c.this.yXF.field_snsId, paramAnonymousInt);
                }
                if (!c.this.Abd.zm(l1))
                {
                  int j = c.this.Atv.zWz.getDurationMs() / 1000;
                  ad.i("MicroMsg.FullCardAdDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(j)));
                  c.this.Abd.d(l1, bt.HI(), false);
                  c.this.Abd.e(l1, j, false);
                  c.this.Abd.aj(l1, l1);
                }
              }
              c.a(c.this, c.this.AtV, c.this.yXF, i * 1000);
              d.a(c.this.AtV, i * 1000, c.this.AtW, c.this.AtX);
              if (c.this.Aub != null) {
                c.this.Aub.a(c.this.Abd, paramAnonymousInt, l1);
              }
              AppMethodBeat.o(179337);
            }
          });
          d.a(this.AtV, 0, this.AtW, this.AtX);
          localObject2 = this.AtV.zxi;
          localObject4 = this.yXF.dRL().dWj();
          if ((!bt.isNullOrNil((String)localObject4)) && (localObject2 != null) && (((b.g.a)localObject2).startTime >= 0L) && (((b.g.a)localObject2).endTime > ((b.g.a)localObject2).startTime)) {
            com.tencent.mm.sdk.g.b.c(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100018);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.dYe().f("adId", this.Aum, "adxml", 0);
                AppMethodBeat.o(100018);
              }
            }, "preDownloadFloatPage");
          }
          if (bool) {
            break label2679;
          }
          if (!((f)localObject3).w((byn)localObject1)) {
            break label2475;
          }
          this.Atv.zFD.setVisibility(8);
          this.Atv.zWB.setVisibility(0);
          this.Atv.zWB.fLr();
          this.Atv.zWx.setVisibility(0);
          this.Atv.zWy.setTagObject(this.Atv);
          this.Atv.zWz.setTag(this.Atv);
          this.Atv.zWA.setTag(this);
          this.Atv.zWx.setOnClickListener(this.Auf);
          if (!this.Aue) {
            break label3072;
          }
          localObject2 = this.yXF;
          localObject4 = this.Atv.zWz;
          i = this.context.hashCode();
          localbj = bj.frn();
          localbj.hbR = this.timeLineObject.CreateTime;
          ((f)localObject3).a((p)localObject2, (byn)localObject1, (SnsAdTimelineVideoView)localObject4, i, localbj, true);
          this.Atv.zWz.start();
          this.Atv.zWz.setShouldPlayWhenPrepared(true);
          this.AtL = true;
          localObject2 = ao.jo(ag.getAccSnsPath(), ((byn)localObject1).Id);
          localObject1 = q.i((byn)localObject1);
          if (this.Abd != null)
          {
            if (!com.tencent.mm.vfs.i.fv((String)localObject2 + (String)localObject1)) {
              break label3144;
            }
            this.Abd.B(l1, true);
            label2372:
            if (ag.dUb().b(this.yXF, null) != 5) {
              break label3157;
            }
          }
        }
        label3144:
        label3157:
        for (bool = true;; bool = false)
        {
          this.Abd.c(l1, bool, false);
          AppMethodBeat.o(100021);
          return;
          label2409:
          this.Atv.zWz.setVisibility(8);
          this.Atv.zWy.setVisibility(0);
          this.Atv.zWy.setOnCompletionListener(new b.e()
          {
            public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              AppMethodBeat.i(179341);
              StringBuilder localStringBuilder = new StringBuilder("sight play completed, retCode=").append(paramAnonymousInt).append(", snsId=");
              if (c.this.yXF == null) {}
              for (paramAnonymousb = "";; paramAnonymousb = Long.valueOf(c.this.yXF.field_snsId))
              {
                ad.i("MicroMsg.FullCardAdDetailItem", paramAnonymousb);
                if (paramAnonymousInt != -1) {
                  c.this.Abd.A(l1, false);
                }
                com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179340);
                    c.this.eec();
                    AppMethodBeat.o(179340);
                  }
                });
                AppMethodBeat.o(179341);
                return;
              }
            }
          });
          this.Atv.zWy.setOnDecodeDurationListener(new b.f()
          {
            public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
            {
              AppMethodBeat.i(179342);
              ad.d("MicroMsg.FullCardAdDetailItem", "sight play %d", new Object[] { Long.valueOf(paramAnonymousLong) });
              if (c.this.Abd != null)
              {
                if (c.this.yXF != null)
                {
                  c.this.Abd.zp(c.this.yXF.field_snsId);
                  c.this.Abd.ak(c.this.yXF.field_snsId, 1000L * paramAnonymousLong);
                }
                if (!c.this.Abd.zm(l1))
                {
                  i = (int)paramAnonymousb.dQg();
                  ad.i("MicroMsg.FullCardAdDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                  c.this.Abd.d(l1, bt.HI(), false);
                  c.this.Abd.e(l1, i, false);
                  c.this.Abd.aj(l1, l1);
                }
              }
              int i = (int)paramAnonymousLong;
              c.a(c.this, c.this.AtV, c.this.yXF, i * 1000);
              d.a(c.this.AtV, i * 1000, c.this.AtW, c.this.AtX);
              AppMethodBeat.o(179342);
            }
          });
          break;
          if (((f)localObject3).b(this.yXF, null) == 5)
          {
            ((f)localObject3).A((byn)localObject1);
            this.Atv.zFD.setVisibility(8);
            this.Atv.zWB.setVisibility(0);
            this.Atv.zWB.fLr();
            break label2156;
          }
          if (((f)localObject3).x((byn)localObject1))
          {
            this.Atv.zWB.setVisibility(8);
            this.Atv.zFD.setImageResource(2131691612);
            this.Atv.zFD.setVisibility(0);
            break label2156;
          }
          ((f)localObject3).y((byn)localObject1);
          this.Atv.zFD.setVisibility(0);
          this.Atv.zWB.setVisibility(8);
          this.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
          this.Atv.zFD.setContentDescription(this.context.getString(2131761939));
          if (((f)localObject3).b(this.yXF, null) != 4) {
            break label2156;
          }
          this.Atv.zFE.setVisibility(0);
          break label2156;
          label2679:
          if (((f)localObject3).u((byn)localObject1))
          {
            this.Atv.zFD.setVisibility(0);
            this.Atv.zWB.setVisibility(8);
            this.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
            this.Atv.zFD.setContentDescription(this.context.getString(2131761939));
            if (!this.Aue) {
              break label3054;
            }
          }
          label3054:
          for (bool = this.Atv.zWz.isError();; bool = this.Atv.zWy.ySq.dQd())
          {
            if (!bool) {
              break label3070;
            }
            ad.d("MicroMsg.FullCardAdDetailItem", "play video error " + ((byn)localObject1).Id + " " + ((byn)localObject1).Url + " " + ((byn)localObject1).GSI);
            ((f)localObject3).y((byn)localObject1);
            this.Atv.zFD.setVisibility(0);
            this.Atv.zWB.setVisibility(8);
            this.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
            this.Atv.zFD.setContentDescription(this.context.getString(2131761939));
            break;
            if (((f)localObject3).v((byn)localObject1))
            {
              this.Atv.zFD.setVisibility(8);
              this.Atv.zWB.setVisibility(8);
              break label2752;
            }
            if (((f)localObject3).b(this.yXF, null) <= 5)
            {
              this.Atv.zFD.setVisibility(8);
              this.Atv.zWB.setVisibility(8);
              break label2752;
            }
            ((f)localObject3).y((byn)localObject1);
            this.Atv.zFD.setVisibility(0);
            this.Atv.zWB.setVisibility(8);
            this.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
            this.Atv.zFD.setContentDescription(this.context.getString(2131761939));
            break label2752;
          }
          label3070:
          break label2156;
          localObject2 = this.yXF;
          localObject4 = this.Atv.zWy;
          i = this.context.hashCode();
          localbj = bj.frn();
          localbj.hbR = this.timeLineObject.CreateTime;
          ((f)localObject3).a((p)localObject2, (byn)localObject1, (VideoSightView)localObject4, i, 0, localbj, true, true);
          this.Atv.zWy.start();
          break label2304;
          this.Abd.B(l1, false);
          break label2372;
        }
        label3163:
        ((f)localObject3).a(this.Atv.zWy, this.context.hashCode(), 0);
        ((f)localObject3).a(this.Atv.zWz, this.context.hashCode());
        this.Atv.zWC.setVisibility(8);
        this.Atv.zWy.setOnSightCompletionAction(null);
        this.Atv.zWy.setOnCompletionListener(null);
        this.Atv.zWy.setOnDecodeDurationListener(null);
        this.Atv.zWz.setVideoCallback(null);
        AppMethodBeat.o(100021);
        return;
      }
      label2304:
      label2475:
      label2752:
      label3275:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.c
 * JD-Core Version:    0.7.0.1
 */