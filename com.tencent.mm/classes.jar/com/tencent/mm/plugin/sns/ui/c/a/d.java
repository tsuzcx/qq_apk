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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.h;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.sns.ad.d.n;
import com.tencent.mm.plugin.sns.ad.widget.living.FinderLivingAnimWrapper;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.ADXml.g.a;
import com.tencent.mm.plugin.sns.storage.ADXml.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.bc;
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
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends b
{
  public View AZc;
  ImageView JKA;
  ImageView JKB;
  SnsAdCardVideoEndView JKC;
  private SnsAdSphereAnimView JKE;
  public TwistCoverView JKF;
  private com.tencent.mm.plugin.sns.ad.widget.living.c JKm;
  public View JKr;
  public MaskImageView JKs;
  private TextView JKt;
  private TextView JKu;
  private TextView JKv;
  public View JKw;
  public ImageView JKx;
  public TextView JKy;
  SnsDrawGestureView JKz;
  com.tencent.mm.plugin.sns.ad.f.l KPn;
  private ViewStub LjA;
  public ViewStub LjB;
  public FinderLivingAnimWrapper LjC;
  private View.OnClickListener LjD;
  private View.OnClickListener LjE;
  protected SnsAdTouchProgressView.a LjF;
  protected TwistCoverView.a LjG;
  private boolean Ljt;
  ADXml.g Ljw;
  boolean Ljx;
  bc Ljy;
  private ViewGroup Ljz;
  Context context;
  boolean mIsPaused;
  public View xYJ;
  private TextView zOg;
  
  public d(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ui.d.c paramc, com.tencent.mm.plugin.sns.ad.f.l paraml)
  {
    AppMethodBeat.i(176410);
    this.Ljx = false;
    this.LjD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(218846);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "ProxyCardClickListener onClick");
        try
        {
          d.this.JIp.LpB.onClick(paramAnonymousView);
          if (d.this.Ljx) {
            SnsAdCardVideoEndView.j(d.this.Jzk, 2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218846);
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
    this.LjE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(256003);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "ProxySightClickListener onClick");
        try
        {
          d.this.JIp.Lpo.onClick(paramAnonymousView);
          if (d.this.Ljx) {
            SnsAdCardVideoEndView.j(d.this.Jzk, 2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(256003);
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
    this.Ljt = false;
    this.mIsPaused = false;
    this.LjF = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176409);
        try
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onClick");
          d.this.JKG.KKj.performClick();
          AppMethodBeat.o(176409);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onClick exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(176409);
        }
      }
      
      public final void onFinish()
      {
        int i = 1;
        AppMethodBeat.i(268045);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onFinish");
        for (;;)
        {
          try
          {
            d.this.JIp.a(d.this, null);
            t.e(new long[] { 20L, 100L });
            if (!(d.this.context instanceof SnsCommentDetailUI)) {
              break label198;
            }
            i = ((SnsCommentDetailUI)d.this.context).getSource();
          }
          catch (Exception localException)
          {
            SnsAdClick localSnsAdClick;
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onFinish, exp=" + localException.toString());
            AppMethodBeat.o(268045);
            return;
          }
          com.tencent.mm.plugin.sns.ui.item.f.a(d.this.context, d.this.contentView, d.this.Jzk, i);
          localSnsAdClick = new SnsAdClick(1, 2, t.aZs(d.this.Jzk.getTimeLine().Id), 28, 21);
          m.a(localSnsAdClick, d.this.KPn, d.this.Jzk, 28);
          t.a(localSnsAdClick);
          AppMethodBeat.o(268045);
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
        AppMethodBeat.i(193802);
        if ((d.this.context instanceof SnsCommentDetailUI)) {}
        for (int i = ((SnsCommentDetailUI)d.this.context).getSource();; i = 1)
        {
          if (i == 2) {}
          for (i = 16;; i = 2)
          {
            if (d.this.Jzk == null)
            {
              AppMethodBeat.o(193802);
              return;
            }
            Object localObject = d.this.Jzk.getAdXml().adTwistInfo;
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
            d.this.JIp.a(d.this, localBundle);
            com.tencent.mm.plugin.sns.ui.item.f.a(d.this.context, d.this.contentView, d.this.Jzk, i);
            try
            {
              localObject = new SnsAdClick(1, 2, t.aZs(d.this.Jzk.getTimeLine().Id), 29, 21);
              m.a((SnsAdClick)localObject, d.this.KPn, d.this.Jzk, 29);
              t.a((SnsAdClick)localObject);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "onTwist report MMOCAD_CLICKPOS_AD_FULL_CARD_TWIST");
              AppMethodBeat.o(193802);
              return;
            }
            catch (Throwable localThrowable)
            {
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "twist click report exp=" + localThrowable.toString());
              AppMethodBeat.o(193802);
              return;
            }
          }
        }
      }
    };
    this.timeLineObject = paramTimeLineObject;
    this.Jzk = paramSnsInfo;
    this.JIp = paramc;
    this.KPn = paraml;
    AppMethodBeat.o(176410);
  }
  
  final void fYv()
  {
    AppMethodBeat.i(176411);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(100014);
        d.this.JKz.setVisibility(8);
        d.this.JKz.setBackgroundColor(0);
        d.this.JKz.fZF();
        d.this.JKz.setOnGestureListener(null);
        AppMethodBeat.o(100014);
      }
    });
    AppMethodBeat.o(176411);
  }
  
  public final void h(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(264789);
    try
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "initLongPressView");
      SnsAdTouchProgressView localSnsAdTouchProgressView = (SnsAdTouchProgressView)paramFrameLayout.findViewById(i.f.sns_ad_progress_anim_view);
      localSnsAdTouchProgressView.setVisibility(8);
      this.Ljy = new bc(this.context, localSnsAdTouchProgressView, this.JKE, this.JKG, 2, paramFrameLayout);
      this.Ljy.KNr = this.LjF;
      AppMethodBeat.o(264789);
      return;
    }
    catch (Exception paramFrameLayout)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "initLongPressView exp=" + android.util.Log.getStackTraceString(paramFrameLayout));
      AppMethodBeat.o(264789);
    }
  }
  
  public final void n(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100020);
    this.contentView = paramView1;
    this.KON = paramView2;
    this.context = paramView1.getContext();
    this.xYJ = paramView1.findViewById(i.f.full_card_container);
    this.AZc = paramView1.findViewById(i.f.top_layer);
    this.JKr = paramView1.findViewById(i.f.bottom_layer);
    this.zOg = ((TextView)paramView1.findViewById(i.f.top_layer_title));
    this.JKt = ((TextView)paramView1.findViewById(i.f.top_layer_desc));
    this.JKu = ((TextView)paramView1.findViewById(i.f.bottom_layer_title));
    this.JKv = ((TextView)paramView1.findViewById(i.f.bottom_layer_desc));
    this.JKw = paramView1.findViewById(i.f.bottom_mini_program);
    this.JKx = ((ImageView)paramView1.findViewById(i.f.mini_program_icon));
    this.JKy = ((TextView)paramView1.findViewById(i.f.mini_program_txt));
    this.JKs = ((MaskImageView)paramView1.findViewById(i.f.full_card_img));
    this.JKz = ((SnsDrawGestureView)paramView1.findViewById(i.f.sns_draw_gesture_view));
    this.JKs.setScaleType(QImageView.a.Ydm);
    this.JKA = ((ImageView)paramView1.findViewById(i.f.front_cover));
    this.JKB = ((ImageView)paramView1.findViewById(i.f.end_cover));
    this.JKF = ((TwistCoverView)paramView1.findViewById(i.f.sns_twist_ad_cover));
    this.JKF.setTwistActionListener(this.LjG);
    this.JKG = new av();
    this.JKG.KKm = paramView1.findViewById(i.f.full_card_video);
    this.JKG.KKj = this.JKG.KKm;
    this.JKG.KKm.setOnClickListener(this.LjE);
    this.JKG.KKk = ((VideoSightView)this.JKG.KKm.findViewById(i.f.image));
    this.JKG.KKl = ((SnsAdTimelineVideoView)this.JKG.KKm.findViewById(i.f.offline_video));
    this.JKG.KKl.setMute(true);
    this.JKG.JAL = ((ImageView)paramView1.findViewById(i.f.full_card_status_icon));
    this.JKG.KKn = ((MMPinProgressBtn)this.JKG.KKm.findViewById(i.f.progress));
    this.JKG.KKo = ((TextView)this.JKG.KKm.findViewById(i.f.endtv));
    this.JKG.Ktc = ((TextView)this.JKG.KKm.findViewById(i.f.errorTv));
    this.JKC = ((SnsAdCardVideoEndView)paramView1.findViewById(i.f.sns_end_cover_view));
    if (this.JKE == null) {
      this.JKE = ((SnsAdSphereAnimView)((ViewStub)this.oFW.findViewById(i.f.sns_ad_sphere_anim_view_stub)).inflate());
    }
    for (;;)
    {
      this.JKE.setVisibility(8);
      this.LjA = ((ViewStub)paramView1.findViewById(i.f.ad_live_status_layout_stub));
      this.LjB = ((ViewStub)paramView1.findViewById(i.f.ad_live_anim_layout_stub));
      AppMethodBeat.o(100020);
      return;
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "initView many times");
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(179350);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "onPause, hasPlayedVideo=" + this.Ljt);
    this.mIsPaused = true;
    try
    {
      if ((this.Ljt) && (this.JKG != null) && (this.JKG.KKl != null))
      {
        this.JKG.KKl.pause();
        this.JKG.KKl.setShouldPlayWhenPrepared(false);
        if (this.Ljy != null) {
          this.Ljy.fVJ();
        }
        if ((this.KPn != null) && (this.Jzk != null)) {
          this.KPn.Qn(this.Jzk.field_snsId);
        }
        if ((this.Jzk != null) && (this.Jzk.isTwistAd())) {
          this.JKF.onPlayerPaused();
        }
      }
      AppMethodBeat.o(179350);
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
    this.Jzk = com.tencent.mm.plugin.sns.storage.f.bbk(this.Jzk.getSnsId());
    this.Ljw = null;
    if ((this.Jzk != null) && (this.Jzk.getAdXml() != null)) {
      this.Ljw = this.Jzk.getAdXml().adFullCardInfo;
    }
    Object localObject1 = (WindowManager)this.context.getSystemService("window");
    int j = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    this.AZc.setVisibility(8);
    this.zOg.setVisibility(8);
    this.JKt.setVisibility(8);
    this.JKr.setVisibility(8);
    this.JKu.setVisibility(8);
    this.JKv.setVisibility(8);
    this.JKw.setVisibility(8);
    this.Ljt = false;
    this.mIsPaused = false;
    int k = com.tencent.mm.ci.a.aY(this.context, i.d.sns_avatar_size);
    int m = com.tencent.mm.ci.a.aY(this.context, i.d.Edge_0_5_A);
    int n = this.context.getResources().getDimensionPixelSize(i.d.NormalPadding);
    int i;
    Object localObject3;
    label530:
    int i1;
    label761:
    Object localObject4;
    label911:
    label956:
    label1137:
    Object localObject5;
    label1050:
    final long l1;
    if (this.Ljw != null)
    {
      i = j - k - m - n - n;
      if (this.Ljw.KjH == 0)
      {
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
        if (localObject1 == null) {
          break label1595;
        }
        localObject3 = this.contentView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((RoundedCornerFrameLayout)this.contentView).setRadius(com.tencent.mm.ci.a.fromDPToPix(this.context, 8));
        localObject3 = this.JKs.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.JKs.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = this.JKG.KKl.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.JKG.KKl.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = this.JKA.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.JKA.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = this.JKB.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.JKB.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = this.JKC.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.JKC.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        if (this.Ljw.KjJ != 0) {
          break label1652;
        }
        i = Color.argb((int)(this.Ljw.KjI * 2.55F), 0, 0, 0);
        i1 = Color.argb(0, 0, 0, 0);
        localObject3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, i1 });
        ((GradientDrawable)localObject3).setGradientType(0);
        this.AZc.setBackground((Drawable)localObject3);
        if ((!Util.isNullOrNil(this.Ljw.title)) || (!Util.isNullOrNil(this.Ljw.description))) {
          this.AZc.setVisibility(0);
        }
        this.JKr.setVisibility(8);
        if (!Util.isNullOrNil(this.Ljw.title))
        {
          this.zOg.setVisibility(0);
          this.zOg.setText(h.htZ().a(this.zOg.getContext(), this.Ljw.title, this.zOg.getTextSize()));
        }
        if (!Util.isNullOrNil(this.Ljw.description))
        {
          this.JKt.setVisibility(0);
          this.JKt.setText(h.htZ().a(this.JKt.getContext(), this.Ljw.description, this.JKt.getTextSize()));
        }
        if ((!this.Jzk.getAdInfo().isWeapp()) && (!com.tencent.mm.plugin.sns.ad.d.l.a(this.Jzk.getAdXml(), this.Jzk.getAdInfo()))) {
          break label1941;
        }
        i = Color.argb((int)(this.Ljw.KjI * 2.55F), 0, 0, 0);
        i1 = Color.argb(0, 0, 0, 0);
        localObject3 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, i1 });
        ((GradientDrawable)localObject3).setGradientType(0);
        this.JKr.setBackground((Drawable)localObject3);
        this.JKr.setVisibility(0);
        this.JKw.setVisibility(0);
        if (!this.Jzk.getAdInfo().isWeapp()) {
          break label1921;
        }
        this.JKy.setText(i.j.sns_ad_card_weapp_tag);
        this.JKx.setImageResource(i.e.mini_program_icon_white);
        if ((this.timeLineObject.ContentObj == null) || (this.timeLineObject.ContentObj.Sqr.size() <= 0)) {
          break label2032;
        }
        localObject3 = (cvt)this.timeLineObject.ContentObj.Sqr.get(0);
        this.JKG.a(this.timeLineObject, 0, this.Jzk.getLocalid(), true);
        this.JKG.Ktc.setVisibility(8);
        localObject4 = aj.fOF();
        if (localObject3 == null) {
          break label3250;
        }
        this.JKC.a(this.Ljw.KjP, 2);
        if (this.JKC.ad(this.Jzk)) {
          this.Ljx = false;
        }
        if (this.Ljy != null)
        {
          if (localObject1 == null) {
            break label2038;
          }
          i = ((ViewGroup.LayoutParams)localObject1).height;
          localObject1 = new Rect(k + m, k, j - n, i + k);
          this.Ljy.a(this.Jzk, this.Ljw.KjQ, (Rect)localObject1);
        }
        this.JKF.a(this.Jzk, this.Jzk.getAdXml().adTwistInfo, 2);
        if (!this.Jzk.isTwistAd()) {
          break label2043;
        }
        this.JKG.KKl.setTimerInterval(300);
        localObject5 = new StringBuilder("refreshView, hash=").append(hashCode()).append(", snsId=");
        if (this.Jzk != null) {
          break label2066;
        }
        localObject1 = "";
        label1174:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", localObject1);
        l1 = this.Jzk.field_snsId;
        if (this.timeLineObject.ContentObj.Sqq != 1) {
          break label2081;
        }
        this.JKs.setVisibility(0);
        this.JKs.setTag(this);
        this.JKs.setOnClickListener(this.LjD);
        localObject1 = this.JKs;
        i = this.context.hashCode();
        localObject5 = bp.hzh();
        ((bp)localObject5).time = this.timeLineObject.CreateTime;
        ((com.tencent.mm.plugin.sns.model.g)localObject4).a((cvt)localObject3, (View)localObject1, -1, i, (bp)localObject5, 3);
        label1285:
        localObject3 = this.Jzk;
        if (localObject3 == null) {
          break label3314;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (((SnsInfo)localObject3).getAdXml() == null) {
          break label3314;
        }
        if (((SnsInfo)localObject3).getAdXml().adLiveInfo == null)
        {
          break label3314;
          if (i == 0) {
            break label3211;
          }
          localObject4 = ((SnsInfo)localObject3).getTimeLine();
          if (this.Ljz == null) {
            this.Ljz = ((ViewGroup)this.LjA.inflate());
          }
          if (this.JKm == null) {
            this.JKm = new com.tencent.mm.plugin.sns.ad.widget.living.c(this.Ljz, null, null);
          }
          if ((localObject4 == null) || (this.JKm == null)) {
            continue;
          }
          localObject1 = ((SnsInfo)localObject3).getAdXml().adLiveInfo;
          i = com.tencent.mm.plugin.sns.ad.widget.living.b.fX(((TimeLineObject)localObject4).Id, ((com.tencent.mm.plugin.sns.ad.adxml.g)localObject1).liveType);
          this.JKm.a(((TimeLineObject)localObject4).Id, (com.tencent.mm.plugin.sns.ad.adxml.g)localObject1);
          this.JKm.setLiveStatus(i);
          com.tencent.mm.plugin.sns.ad.widget.living.b.a(((TimeLineObject)localObject4).Id, this.JKm);
          com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.fLk().b(0, (SnsInfo)localObject3);
          boolean bool = com.tencent.mm.plugin.sns.ad.widget.living.c.afn(i);
          localObject3 = ((TimeLineObject)localObject4).Id;
          if (!FinderLivingAnimWrapper.a((com.tencent.mm.plugin.sns.ad.adxml.g)localObject1, bool)) {
            continue;
          }
          if (this.LjC == null) {
            this.LjC = ((FinderLivingAnimWrapper)this.LjB.inflate());
          }
          if (this.LjC == null) {
            continue;
          }
          i = com.tencent.mm.ci.a.fromDPToPix(this.context, 60);
          j = com.tencent.mm.ci.a.fromDPToPix(this.context, 35);
          this.LjC.a((com.tencent.mm.plugin.sns.ad.adxml.g)localObject1, (String)localObject3, i, j);
          this.LjC.setVisibility(0);
          AppMethodBeat.o(100021);
          return;
          if (this.Ljw.KjH != 1) {
            break label3308;
          }
          localObject1 = new ViewGroup.LayoutParams(-2, -2);
          ((ViewGroup.LayoutParams)localObject1).width = i;
          ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
          break;
          label1595:
          localObject4 = new StringBuilder("mediaLayout==null, snsId=");
          if (this.Jzk == null)
          {
            localObject3 = "";
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", localObject3);
            break label530;
          }
          localObject3 = Long.valueOf(this.Jzk.field_snsId);
          continue;
          label1652:
          if (this.Ljw.KjJ != 1) {
            break label761;
          }
          i = Color.argb((int)(this.Ljw.KjI * 2.55F), 0, 0, 0);
          i1 = Color.argb(0, 0, 0, 0);
          localObject3 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, i1 });
          ((GradientDrawable)localObject3).setGradientType(0);
          this.AZc.setVisibility(8);
          this.JKr.setBackground((Drawable)localObject3);
          if ((!Util.isNullOrNil(this.Ljw.title)) || (!Util.isNullOrNil(this.Ljw.description)))
          {
            this.JKr.setVisibility(0);
            localObject3 = (RelativeLayout.LayoutParams)this.JKw.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.ci.a.fromDPToPix(this.context, 4);
            this.JKw.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          }
          if (!Util.isNullOrNil(this.Ljw.title))
          {
            this.JKu.setVisibility(0);
            this.JKu.setText(h.htZ().a(this.JKu.getContext(), this.Ljw.title, this.JKu.getTextSize()));
          }
          if (Util.isNullOrNil(this.Ljw.description)) {
            break label761;
          }
          this.JKv.setVisibility(0);
          this.JKv.setText(h.htZ().a(this.JKv.getContext(), this.Ljw.description, this.JKv.getTextSize()));
          break label761;
          label1921:
          this.JKy.setText(i.j.finder_app_name);
          this.JKx.setImageResource(i.e.ad_fullcard_finder_icon_white);
          label1941:
          break label911;
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "invalid full card");
          if (this.Jzk == null)
          {
            localObject1 = "";
            i = 0;
            if (this.Jzk == null) {
              break label3300;
            }
            if (!this.Jzk.isFullCardAd()) {
              continue;
            }
            i = 1;
            localObject3 = this.Jzk.getUxinfo();
            com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.JQG, (String)localObject1, 0, i, (String)localObject3);
            localObject1 = null;
            break label911;
          }
          localObject1 = t.Qu(this.Jzk.field_snsId);
          continue;
          i = 0;
          continue;
          label2032:
          localObject3 = null;
          break label956;
          label2038:
          i = 0;
          break label1050;
          label2043:
          this.JKG.KKl.setTimerInterval(1000);
          this.JKF.clear();
          break label1137;
          label2066:
          localObject1 = Long.valueOf(this.Jzk.field_snsId);
          break label1174;
          label2081:
          if ((this.timeLineObject.ContentObj.Sqq != 15) && (this.timeLineObject.ContentObj.Sqq != 5)) {
            break label1285;
          }
          com.tencent.mm.plugin.sns.ad.d.d.a(this.Jzk, (cvt)localObject3);
          long l2 = System.nanoTime();
          bool = com.tencent.mm.plugin.sns.model.g.u((cvt)localObject3);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l2) });
          this.JKG.KKl.setVisibility(0);
          this.JKG.KKk.setVisibility(8);
          this.JKG.KKl.setVideoCallback(new OfflineVideoView.a()
          {
            public final void AS(int paramAnonymousInt)
            {
              AppMethodBeat.i(179337);
              int i = paramAnonymousInt / 1000;
              com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.FullCardAdDetailItem", "updateTime %d", new Object[] { Integer.valueOf(i) });
              if (d.this.KPn != null)
              {
                if (d.this.Jzk != null)
                {
                  d.this.KPn.Qm(d.this.Jzk.field_snsId);
                  d.this.KPn.az(d.this.Jzk.field_snsId, paramAnonymousInt);
                }
                if (!d.this.KPn.Qj(l1))
                {
                  j = d.this.JKG.KKl.getDurationMs() / 1000;
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(j)));
                  d.this.KPn.c(l1, Util.currentTicks(), false);
                  d.this.KPn.e(l1, j, false);
                  d.this.KPn.ay(l1, l1);
                }
              }
              d locald = d.this;
              Object localObject = d.this.Ljw;
              SnsInfo localSnsInfo = d.this.Jzk;
              int j = i * 1000;
              localObject = ((ADXml.g)localObject).KjK;
              if ((!Util.isNullOrNil(localSnsInfo.getAdXml().getGestureCanvasInfo())) && (localObject != null) && (((ADXml.g.a)localObject).startTime >= 0L) && (((ADXml.g.a)localObject).endTime > ((ADXml.g.a)localObject).startTime))
              {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "%d-%d,%d", new Object[] { Long.valueOf(((ADXml.g.a)localObject).startTime), Long.valueOf(((ADXml.g.a)localObject).endTime), Integer.valueOf(j) });
                if ((((ADXml.g.a)localObject).startTime > j) || (((ADXml.g.a)localObject).endTime < j)) {
                  break label468;
                }
                if (locald.JKz.getOnGestureListener() == null) {
                  MMHandlerThread.postToMainThread(new d.2(locald, (ADXml.g.a)localObject, localSnsInfo));
                }
              }
              for (;;)
              {
                com.tencent.mm.plugin.sns.ui.item.f.a(d.this.Ljw, i * 1000, d.this.JKA, d.this.JKB);
                if ((d.this.Jzk != null) && (d.this.Jzk.isTwistAd())) {
                  d.this.JKF.Qp(i * 1000);
                }
                if (d.this.Ljy != null) {
                  d.this.Ljy.a(d.this.KPn, paramAnonymousInt, l1);
                }
                AppMethodBeat.o(179337);
                return;
                label468:
                locald.fYv();
              }
            }
            
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
              if (d.this.Ljy != null) {}
              for (boolean bool = d.this.Ljy.fVI();; bool = false)
              {
                if ((d.this.Ljw.KjP == null) && (!bool)) {
                  d.this.JKG.KKl.bgP();
                }
                d.this.KPn.I(l1, false);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(176407);
                    d locald = d.this;
                    try
                    {
                      if ((locald.Ljw != null) && (locald.Ljw.KjP != null))
                      {
                        locald.JKC.setBlurBkg(locald.JKG.KKl.getInnerVideoView());
                        locald.JKC.bzz();
                        locald.JKC.equ();
                        locald.Ljx = true;
                        locald.JKG.KKl.bc(0, false);
                        locald.JKG.KKl.setShouldPlayWhenPrepared(false);
                        locald.JKG.KKl.pause();
                        locald.fYv();
                        MMHandlerThread.postToMainThreadDelayed(new d.6(locald), locald.Ljw.KjP.duration);
                        AppMethodBeat.o(176407);
                        return;
                      }
                      locald.JKC.fv(false);
                      AppMethodBeat.o(176407);
                      return;
                    }
                    catch (Exception localException)
                    {
                      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "handleVideoCompletion, exp" + localException.toString());
                      AppMethodBeat.o(176407);
                    }
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
          });
          com.tencent.mm.plugin.sns.ui.item.f.a(this.Ljw, 0, this.JKA, this.JKB);
          if (!bool)
          {
            if (((com.tencent.mm.plugin.sns.model.g)localObject4).x((cvt)localObject3))
            {
              this.JKG.JAL.setVisibility(8);
              this.JKG.KKn.setVisibility(0);
              this.JKG.KKn.hZF();
              this.JKG.KKj.setVisibility(0);
              this.JKG.KKl.setTag(this.JKG);
              this.JKG.KKm.setTag(this);
              this.JKG.KKj.setOnClickListener(this.LjD);
              localObject1 = this.Jzk;
              localObject5 = this.JKG.KKl;
              i = this.context.hashCode();
              bp localbp = bp.hzh();
              localbp.time = this.timeLineObject.CreateTime;
              ((com.tencent.mm.plugin.sns.model.g)localObject4).a((SnsInfo)localObject1, (cvt)localObject3, (SnsAdTimelineVideoView)localObject5, i, localbp, true);
              this.JKG.KKl.start();
              this.JKG.KKl.setShouldPlayWhenPrepared(true);
              this.Ljt = true;
              localObject1 = aq.kD(aj.getAccSnsPath(), ((cvt)localObject3).Id);
              localObject4 = t.i((cvt)localObject3);
              localObject1 = (String)localObject1 + (String)localObject4;
              if (this.KPn == null) {
                break label1285;
              }
              if (!u.agG((String)localObject1)) {
                continue;
              }
              this.KPn.f(l1, (int)((cvt)localObject3).TDZ, true);
              if (com.tencent.mm.plugin.sns.ad.d.d.No())
              {
                bool = v.isH265Video((String)localObject1);
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdDetailItem", "AdH265Helper, fileExists, isH265File=" + bool + ", path=" + (String)localObject1);
              }
              if (aj.fOF().b(this.Jzk, null) != 5) {
                continue;
              }
              bool = true;
              this.KPn.d(l1, bool, false);
              break label1285;
            }
            if (((com.tencent.mm.plugin.sns.model.g)localObject4).b(this.Jzk, null) == 5)
            {
              ((com.tencent.mm.plugin.sns.model.g)localObject4).B((cvt)localObject3);
              this.JKG.JAL.setVisibility(8);
              this.JKG.KKn.setVisibility(0);
              this.JKG.KKn.hZF();
              continue;
            }
            if (((com.tencent.mm.plugin.sns.model.g)localObject4).y((cvt)localObject3))
            {
              this.JKG.KKn.setVisibility(8);
              this.JKG.JAL.setImageResource(i.i.shortvideo_play_icon_err);
              this.JKG.JAL.setVisibility(0);
              continue;
            }
            ((com.tencent.mm.plugin.sns.model.g)localObject4).z((cvt)localObject3);
            this.JKG.JAL.setVisibility(0);
            this.JKG.KKn.setVisibility(8);
            this.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.shortvideo_play_btn));
            this.JKG.JAL.setContentDescription(this.context.getString(i.j.play_sight_desc));
            if (((com.tencent.mm.plugin.sns.model.g)localObject4).b(this.Jzk, null) != 4) {
              continue;
            }
            this.JKG.Ktc.setVisibility(0);
            continue;
          }
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).v((cvt)localObject3))
          {
            this.JKG.JAL.setVisibility(0);
            this.JKG.KKn.setVisibility(8);
            this.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.shortvideo_play_btn));
            this.JKG.JAL.setContentDescription(this.context.getString(i.j.play_sight_desc));
            if (this.JKG.KKl.isError())
            {
              com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.FullCardAdDetailItem", "play video error " + ((cvt)localObject3).Id + " " + ((cvt)localObject3).Url + " " + ((cvt)localObject3).TDF);
              ((com.tencent.mm.plugin.sns.model.g)localObject4).z((cvt)localObject3);
              this.JKG.JAL.setVisibility(0);
              this.JKG.KKn.setVisibility(8);
              this.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.shortvideo_play_btn));
              this.JKG.JAL.setContentDescription(this.context.getString(i.j.play_sight_desc));
            }
          }
          else
          {
            if (((com.tencent.mm.plugin.sns.model.g)localObject4).w((cvt)localObject3))
            {
              this.JKG.JAL.setVisibility(8);
              this.JKG.KKn.setVisibility(8);
              continue;
            }
            if (((com.tencent.mm.plugin.sns.model.g)localObject4).b(this.Jzk, null) <= 5)
            {
              this.JKG.JAL.setVisibility(8);
              this.JKG.KKn.setVisibility(8);
              continue;
            }
            ((com.tencent.mm.plugin.sns.model.g)localObject4).z((cvt)localObject3);
            this.JKG.JAL.setVisibility(0);
            this.JKG.KKn.setVisibility(8);
            this.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.shortvideo_play_btn));
            this.JKG.JAL.setContentDescription(this.context.getString(i.j.play_sight_desc));
            continue;
          }
          continue;
          this.KPn.f(l1, (int)((cvt)localObject3).TDZ, false);
          continue;
          bool = false;
          continue;
        }
        i = 1;
        continue;
        if (this.LjC != null) {
          this.LjC.setVisibility(8);
        }
        AppMethodBeat.o(100021);
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdDetailItem", "fillLivingViewInfo, exp=" + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(100021);
        return;
      }
      label3211:
      if (this.Ljz != null) {
        this.Ljz.setVisibility(8);
      }
      if (this.LjC != null) {
        this.LjC.setVisibility(8);
      }
      AppMethodBeat.o(100021);
      return;
      label3250:
      ((com.tencent.mm.plugin.sns.model.g)localObject4).a(this.JKG.KKl, this.context.hashCode());
      this.JKG.KKo.setVisibility(8);
      this.JKG.KKl.setVideoCallback(null);
      AppMethodBeat.o(100021);
      return;
      label3300:
      localObject3 = "";
      continue;
      label3308:
      Object localObject2 = null;
      break;
      label3314:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.d
 * JD-Core Version:    0.7.0.1
 */