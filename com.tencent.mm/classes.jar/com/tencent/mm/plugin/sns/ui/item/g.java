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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.sns.ad.d.d;
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
import com.tencent.mm.plugin.sns.i.g;
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
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.video.e;
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

public final class g
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private com.tencent.mm.plugin.sns.ad.widget.living.c JKm;
  Handler JMp;
  private SnsInfo Jws;
  private View.OnClickListener LjD;
  private View.OnClickListener LjE;
  protected SnsAdTouchProgressView.a LjF;
  protected TwistCoverView.a LjG;
  boolean Ljx;
  a LmU;
  private bc LmV;
  volatile boolean Lmj;
  
  public g()
  {
    AppMethodBeat.i(176422);
    this.JMp = new Handler(Looper.getMainLooper());
    this.Lmj = false;
    this.Ljx = false;
    this.LjD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176420);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "ProxyCardClickListener onClick");
        try
        {
          g.this.Kee.Kdz.LpB.onClick(paramAnonymousView);
          if (g.c(g.this)) {
            SnsAdCardVideoEndView.j(g.d(g.this), 1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(176420);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdTimeLineItem", "ProxyCardClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.LjE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176421);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "ProxySightClickListener onClick");
        try
        {
          g.this.Kee.Kdz.Lpo.onClick(paramAnonymousView);
          if (g.c(g.this)) {
            SnsAdCardVideoEndView.j(g.d(g.this), 1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(176421);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdTimeLineItem", "mProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.LjF = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(214320);
        try
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "SnsAdTouchProgressView onClick");
          g.f(g.this).JKG.KKj.performClick();
          AppMethodBeat.o(214320);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdTimeLineItem", "SnsAdTouchProgressView onClick exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(214320);
        }
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(214323);
        g.this.Kee.KYo.KCe.a(g.f(g.this), null);
        t.e(new long[] { 20L, 100L });
        f.a(g.this.mActivity, g.f(g.this).xYJ, g.d(g.this), 1);
        if (g.d(g.this) != null)
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(1, 1, t.aZs(g.d(g.this).getTimeLine().Id), 28, 21);
          if ((g.this.mActivity instanceof SnsTimeLineUI)) {
            m.a(localSnsAdClick, ((SnsTimeLineUI)g.this.mActivity).fXs(), g.d(g.this), 28);
          }
          t.a(localSnsAdClick);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "onFinish report MMOCAD_CLICKPOS_AD_FULL_CARD_LONGPRESS");
          AppMethodBeat.o(214323);
          return;
        }
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdTimeLineItem", "onFinish report, mSnsinfo==null");
        AppMethodBeat.o(214323);
      }
      
      public final void onStart() {}
    };
    this.LjG = new TwistCoverView.a()
    {
      public final void fMH()
      {
        AppMethodBeat.i(260903);
        g.f(g.this).JKq = true;
        if (g.d(g.this) == null)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdTimeLineItem", "onTwist, mSnsInfo==null");
          AppMethodBeat.o(260903);
          return;
        }
        Object localObject = new Bundle();
        ((Bundle)localObject).putBoolean("isFromTwist", true);
        ADXml.k localk = g.d(g.this).getAdXml().adTwistInfo;
        if (localk != null)
        {
          ((Bundle)localObject).putBoolean("isSimpleTwistAnim", localk.Kkf);
          ((Bundle)localObject).putBoolean("isTwistClockwise", localk.Kke);
          if (localk.Kkf) {
            t.e(new long[] { 0L, 80L });
          }
        }
        g.this.Kee.KYo.KCe.a(g.f(g.this), (Bundle)localObject);
        f.a(g.this.mActivity, g.f(g.this).xYJ, g.d(g.this), 1);
        try
        {
          localObject = new SnsAdClick(1, 1, t.aZs(g.d(g.this).getTimeLine().Id), 29, 21);
          if ((g.this.mActivity instanceof SnsTimeLineUI)) {
            m.a((SnsAdClick)localObject, ((SnsTimeLineUI)g.this.mActivity).fXs(), g.d(g.this), 29);
          }
          t.a((SnsAdClick)localObject);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "onTwist report MMOCAD_CLICKPOS_AD_FULL_CARD_TWIST");
          AppMethodBeat.o(260903);
          return;
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdTimeLineItem", "twist click report exp=" + localThrowable.toString());
          AppMethodBeat.o(260903);
        }
      }
    };
    AppMethodBeat.o(176422);
  }
  
  private void ac(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(270667);
    if ((this.Kee != null) && (this.Kee.KYo != null) && (this.Kee.KYo.KBN != null) && (paramSnsInfo != null)) {
      this.Kee.KYo.KBN.Qn(paramSnsInfo.field_snsId);
    }
    AppMethodBeat.o(270667);
  }
  
  private void fLF()
  {
    AppMethodBeat.i(176427);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "try show play btn");
    if ((this.LmU != null) && (this.LmU.JKG != null) && (!this.Lmj))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "show play btn");
      this.LmU.JKG.JAL.setVisibility(0);
      this.LmU.JKG.KKn.setVisibility(8);
      this.LmU.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
      this.LmU.JKG.JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
    }
    AppMethodBeat.o(176427);
  }
  
  private boolean fYA()
  {
    AppMethodBeat.i(177695);
    if ((this.LmU.timeLineObject.ContentObj.Sqq == 5) || (this.LmU.timeLineObject.ContentObj.Sqq == 15))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd doPause", new Object[] { this });
      if ((this.LmU != null) && (this.LmU.JKG != null))
      {
        this.LmU.JKG.KKl.pause();
        this.LmU.JKG.KKl.setShouldPlayWhenPrepared(false);
        this.LmV.fVJ();
        ac(this.Jws);
        if ((this.Jws != null) && (this.Jws.isTwistAd())) {
          this.LmU.JKF.onPlayerPaused();
        }
      }
      this.Lmj = false;
      AppMethodBeat.o(177695);
      return true;
    }
    AppMethodBeat.o(177695);
    return false;
  }
  
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(270665);
    long l1 = System.currentTimeMillis();
    this.LmU = ((a)paramBaseViewHolder);
    if (paramBaseViewHolder.LkR != null)
    {
      paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_timeline_ad_full_card);
      if (!paramBaseViewHolder.LkS)
      {
        this.LmU.xYJ = paramBaseViewHolder.LkR.inflate();
        paramBaseViewHolder.LkS = true;
      }
      this.LmU.AZc = this.LmU.convertView.findViewById(i.f.top_layer);
      this.LmU.JKr = this.LmU.convertView.findViewById(i.f.bottom_layer);
      this.LmU.zOg = ((TextView)this.LmU.convertView.findViewById(i.f.top_layer_title));
      this.LmU.JKt = ((TextView)this.LmU.convertView.findViewById(i.f.top_layer_desc));
      this.LmU.JKu = ((TextView)this.LmU.convertView.findViewById(i.f.bottom_layer_title));
      this.LmU.JKv = ((TextView)this.LmU.convertView.findViewById(i.f.bottom_layer_desc));
      this.LmU.JKs = ((MaskImageView)this.LmU.convertView.findViewById(i.f.full_card_img));
      this.LmU.JKw = this.LmU.convertView.findViewById(i.f.bottom_mini_program);
      this.LmU.JKx = ((ImageView)this.LmU.convertView.findViewById(i.f.mini_program_icon));
      this.LmU.JKy = ((TextView)this.LmU.convertView.findViewById(i.f.mini_program_txt));
      this.LmU.JKs.setScaleType(QImageView.a.Ydm);
      this.LmU.JKG = new av();
      this.LmU.JKG.KKm = this.LmU.xYJ.findViewById(i.f.full_card_video);
      this.LmU.JKG.KKj = this.LmU.JKG.KKm;
      this.LmU.JKG.KKm.setOnClickListener(this.LjE);
      this.LmU.JKG.KKk = ((VideoSightView)this.LmU.JKG.KKm.findViewById(i.f.image));
      this.LmU.JKG.KKl = ((SnsAdTimelineVideoView)this.LmU.JKG.KKm.findViewById(i.f.offline_video));
      paramBaseViewHolder.JKG.KKl.setMute(true);
      this.LmU.JKG.JAL = ((ImageView)this.LmU.xYJ.findViewById(i.f.full_card_status_icon));
      this.LmU.JKG.KKn = ((MMPinProgressBtn)this.LmU.JKG.KKm.findViewById(i.f.progress));
      this.LmU.JKG.KKo = ((TextView)this.LmU.JKG.KKm.findViewById(i.f.endtv));
      this.LmU.JKG.Ktc = ((TextView)this.LmU.JKG.KKm.findViewById(i.f.errorTv));
      a.a(this.LmU, (SnsDrawGestureView)this.LmU.convertView.findViewById(i.f.sns_draw_gesture_view));
      this.LmU.JKA = ((ImageView)this.LmU.convertView.findViewById(i.f.front_cover));
      this.LmU.JKB = ((ImageView)this.LmU.convertView.findViewById(i.f.end_cover));
      this.LmU.JKC = ((SnsAdCardVideoEndView)this.LmU.convertView.findViewById(i.f.sns_end_cover_view));
      this.LmU.JKF = ((TwistCoverView)this.LmU.convertView.findViewById(i.f.sns_twist_ad_cover));
      this.LmU.JKF.setTwistActionListener(this.LjG);
      this.LmU.JKJ = ((ViewStub)this.LmU.xYJ.findViewById(i.f.ad_live_anim_layout_stub));
      if (this.LmU.JKE != null) {
        break label935;
      }
      paramViewStub = ((ViewStub)this.LmU.LlS.findViewById(i.f.sns_ad_sphere_anim_view_stub)).inflate();
      this.LmU.JKE = ((SnsAdSphereAnimView)paramViewStub.findViewById(i.f.sns_ad_sphere_anim_view));
      this.LmU.JKD = ((SnsAdTouchProgressView)paramViewStub.findViewById(i.f.sns_ad_progress_anim_view));
    }
    for (;;)
    {
      this.LmU.JKE.setVisibility(8);
      this.LmU.JKD.setVisibility(8);
      this.LmV = new bc(this.mActivity, this.LmU.JKD, this.LmU.JKE, this.LmU.JKG, 1, this.LmU.LlS);
      this.LmV.KNr = this.LjF;
      this.LmU.JKH = ((ViewStub)this.LmU.convertView.findViewById(i.f.ad_live_status_layout_stub));
      long l2 = System.currentTimeMillis();
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(225459);
          com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.JQW, "2", 2, 1, String.valueOf(this.CGc));
          com.tencent.mm.plugin.report.service.h.IzE.el(1697, 1);
          AppMethodBeat.o(225459);
        }
      });
      AppMethodBeat.o(270665);
      return;
      if (paramBaseViewHolder.LkS) {
        break;
      }
      this.LmU.xYJ = paramBaseViewHolder.convertView.findViewById(i.f.full_card_container);
      paramBaseViewHolder.LkS = true;
      break;
      label935:
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdTimeLineItem", "buildContent many times");
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176423);
    if ((paramBaseViewHolder.timeLineObject.ContentObj.Sqq == 5) || (paramBaseViewHolder.timeLineObject.ContentObj.Sqq == 15))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "play: hash=" + hashCode() + ", pos=" + paramInt + ", isEndViewShow=" + this.Ljx + ", isPlayingSight=" + this.Lmj);
      e.fZg().dmi();
      com.tencent.mm.plugin.sns.ui.video.b.fYX().a(this);
      if (!this.Ljx)
      {
        paramBaseViewHolder.JKG.KKl.setShouldPlayWhenPrepared(true);
        paramBaseViewHolder.JKG.KKl.start();
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "try hide play btn");
      if ((this.LmU != null) && (this.LmU.JKG != null))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "hide play btn");
        this.LmU.JKG.JAL.setVisibility(8);
        this.LmU.JKG.KKn.setVisibility(8);
      }
      this.Lmj = true;
      if ((paramBaseViewHolder instanceof a)) {
        ((a)paramBaseViewHolder).JKq = false;
      }
      if ((!this.Ljx) && (this.LmU.JKC.getVisibility() == 0)) {
        this.LmU.JKC.fv(true);
      }
    }
    AppMethodBeat.o(176423);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, final bm parambm)
  {
    AppMethodBeat.i(100082);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "ad fillItem, fullCardAd, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
    long l1 = System.currentTimeMillis();
    if (paramBaseViewHolder.jTm)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(100082);
      return;
    }
    final a locala = (a)paramBaseViewHolder;
    final SnsInfo localSnsInfo = parambn.Jws;
    this.Jws = localSnsInfo;
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
    locala.AZc.setVisibility(8);
    locala.zOg.setVisibility(8);
    locala.JKt.setVisibility(8);
    locala.JKr.setVisibility(8);
    locala.JKu.setVisibility(8);
    locala.JKv.setVisibility(8);
    locala.JKw.setVisibility(8);
    a.b(locala).setVisibility(8);
    locala.JKD.setVisibility(8);
    locala.JKE.setVisibility(8);
    locala.JKG.KKl.setVideoCallback(null);
    a(locala);
    label452:
    Object localObject3;
    Object localObject4;
    if (localObject2 != null)
    {
      locala.JKC.a(((ADXml.g)localObject2).KjP, 1);
      if ((localSnsInfo != null) && (locala.JKC.ad(localSnsInfo)))
      {
        this.JMp.removeCallbacksAndMessages(null);
        this.Ljx = false;
      }
      int j = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 56);
      int k = this.mActivity.getResources().getDimensionPixelSize(i.d.LittlePadding);
      int m = this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding);
      paramInt2 = i - j - k - m;
      if (((ADXml.g)localObject2).KjH == 0)
      {
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
        if (localObject1 == null) {
          break label1842;
        }
        paramInt2 = ((ViewGroup.LayoutParams)localObject1).height;
        localObject3 = new Rect(k + j, j - m, i - m, paramInt2 + (j - m));
        this.LmV.a(this.Jws, ((ADXml.g)localObject2).KjQ, (Rect)localObject3);
        localObject4 = new StringBuilder("fillItem, hash=").append(hashCode()).append(", snsId=");
        if (localSnsInfo != null) {
          break label1848;
        }
        localObject3 = "";
        label538:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", localObject3);
        if (localSnsInfo != null)
        {
          locala.JKF.a(localSnsInfo, localSnsInfo.getAdXml().adTwistInfo, 1);
          if (!localSnsInfo.isTwistAd()) {
            break label1861;
          }
          locala.JKG.KKl.setTimerInterval(300);
        }
        label599:
        if (localObject1 == null) {
          break label1886;
        }
        localObject3 = locala.xYJ.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.xYJ.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((RoundedCornerFrameLayout)locala.xYJ).setRadius(com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 8));
        localObject3 = locala.JKs.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.JKs.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.JKG.KKl.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.JKG.KKl.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.JKA.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.JKA.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.JKB.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.JKB.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.JKC.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.JKC.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        label871:
        if (((ADXml.g)localObject2).KjJ != 0) {
          break label1943;
        }
        paramInt2 = Color.argb((int)(((ADXml.g)localObject2).KjI * 2.55F), 0, 0, 0);
        i = Color.argb(0, 0, 0, 0);
        localObject1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt2, i });
        ((GradientDrawable)localObject1).setGradientType(0);
        locala.AZc.setBackground((Drawable)localObject1);
        if ((!Util.isNullOrNil(((ADXml.g)localObject2).title)) || (!Util.isNullOrNil(((ADXml.g)localObject2).description))) {
          locala.AZc.setVisibility(0);
        }
        if (!Util.isNullOrNil(((ADXml.g)localObject2).title))
        {
          locala.zOg.setVisibility(0);
          locala.zOg.setText(com.tencent.mm.cl.h.htZ().a(locala.zOg.getContext(), ((ADXml.g)localObject2).title, locala.zOg.getTextSize()));
        }
        if (!Util.isNullOrNil(((ADXml.g)localObject2).description))
        {
          locala.JKt.setVisibility(0);
          locala.JKt.setText(com.tencent.mm.cl.h.htZ().a(locala.JKt.getContext(), ((ADXml.g)localObject2).description, locala.JKt.getTextSize()));
        }
        label1089:
        if ((localSnsInfo.getAdInfo().isWeapp()) || (com.tencent.mm.plugin.sns.ad.d.l.a(localSnsInfo.getAdXml(), localSnsInfo.getAdInfo())))
        {
          paramInt2 = Color.argb((int)(((ADXml.g)localObject2).KjI * 2.55F), 0, 0, 0);
          i = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
          ((GradientDrawable)localObject1).setGradientType(0);
          locala.JKr.setBackground((Drawable)localObject1);
          locala.JKr.setVisibility(0);
          locala.JKw.setVisibility(0);
          if (!localSnsInfo.getAdInfo().isWeapp()) {
            break label2205;
          }
          locala.JKy.setText(i.j.sns_ad_card_weapp_tag);
          locala.JKx.setImageResource(i.e.mini_program_icon_white);
        }
        label1236:
        if ((paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.Sqr.size() <= 0)) {
          break label2313;
        }
        localObject1 = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
        label1275:
        localObject3 = aj.fOF();
        if ((paramBaseViewHolder.JKG.KKi != null) && (!Util.isEqual(paramBaseViewHolder.JKG.KKi.Id, paramTimeLineObject.Id)))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.JKG.KKi.Id });
          ((com.tencent.mm.plugin.sns.model.g)localObject3).a(paramBaseViewHolder.JKG.KKl, this.mActivity.hashCode());
        }
        paramBaseViewHolder.JKG.a(paramTimeLineObject, paramInt1, parambn.KDB, parambn.KBz);
        paramBaseViewHolder.JKG.Ktc.setVisibility(8);
        if (localObject1 == null) {
          break label3460;
        }
        if (paramTimeLineObject.ContentObj.Sqq != 1) {
          break label2319;
        }
        locala.JKs.setVisibility(0);
        locala.JKG.KKj.setVisibility(4);
        parambn = locala.JKs;
        paramInt1 = this.mActivity.hashCode();
        parambm = bp.hzh();
        parambm.time = paramTimeLineObject.CreateTime;
        ((com.tencent.mm.plugin.sns.model.g)localObject3).b((cvt)localObject1, parambn, -1, paramInt1, parambm);
        locala.JKs.setTag(paramBaseViewHolder);
        locala.JKs.setOnClickListener(this.LjD);
        locala.JKq = false;
        label1493:
        if (localSnsInfo == null) {
          break label3520;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (localSnsInfo.getAdXml() == null) {
          break label3520;
        }
        if (localSnsInfo.getAdXml().adLiveInfo != null) {
          continue;
        }
      }
      catch (Throwable paramBaseViewHolder)
      {
        boolean bool;
        long l2;
        label1842:
        label1848:
        label1861:
        label1886:
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdTimeLineItem", "fillLivingViewInfo, exp=" + android.util.Log.getStackTraceString(paramBaseViewHolder));
        label1943:
        label2205:
        continue;
        label2313:
        label2319:
        if (this.LmU.JKI == null) {
          continue;
        }
        this.LmU.JKI.setVisibility(8);
        if (this.LmU.JKK == null) {
          continue;
        }
        this.LmU.JKK.setVisibility(8);
        continue;
      }
      if (paramInt1 != 0)
      {
        parambn = localSnsInfo.getTimeLine();
        if (this.LmU.JKI == null) {
          this.LmU.JKI = ((ViewGroup)this.LmU.JKH.inflate());
        }
        if (this.JKm == null) {
          this.JKm = new com.tencent.mm.plugin.sns.ad.widget.living.c(this.LmU.JKI, null, null);
        }
        if ((parambn != null) && (this.JKm != null))
        {
          paramBaseViewHolder = localSnsInfo.getAdXml().adLiveInfo;
          paramInt1 = com.tencent.mm.plugin.sns.ad.widget.living.b.fX(parambn.Id, paramBaseViewHolder.liveType);
          this.JKm.a(parambn.Id, paramBaseViewHolder);
          this.JKm.setLiveStatus(paramInt1);
          com.tencent.mm.plugin.sns.ad.widget.living.b.a(parambn.Id, this.JKm);
          com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.fLk().b(0, localSnsInfo);
          bool = com.tencent.mm.plugin.sns.ad.widget.living.c.afn(paramInt1);
          parambn = parambn.Id;
          if (!FinderLivingAnimWrapper.a(paramBaseViewHolder, bool)) {
            continue;
          }
          if (this.LmU.JKK == null) {
            this.LmU.JKK = ((FinderLivingAnimWrapper)this.LmU.JKJ.inflate());
          }
          if (this.LmU.JKK != null)
          {
            paramInt1 = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 60);
            paramInt2 = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 35);
            this.LmU.JKK.a(paramBaseViewHolder, parambn, paramInt1, paramInt2);
            this.LmU.JKK.setVisibility(0);
          }
        }
        l2 = System.currentTimeMillis();
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(100075);
            com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.JQW, "2", 2, 2, String.valueOf(this.CGc));
            AppMethodBeat.o(100075);
          }
        });
        AppMethodBeat.o(100082);
        return;
        if (((ADXml.g)localObject2).KjH != 1) {
          break label3514;
        }
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
        break;
        paramInt2 = 0;
        break label452;
        localObject3 = Long.valueOf(localSnsInfo.field_snsId);
        break label538;
        locala.JKG.KKl.setTimerInterval(1000);
        locala.JKF.clear();
        break label599;
        localObject3 = new StringBuilder("mediaLayout==null, snsId=");
        if (this.Jws == null)
        {
          localObject1 = "";
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdTimeLineItem", localObject1);
          break label871;
        }
        localObject1 = Long.valueOf(this.Jws.field_snsId);
        continue;
        if (((ADXml.g)localObject2).KjJ != 1) {
          break label1089;
        }
        paramInt2 = Color.argb((int)(((ADXml.g)localObject2).KjI * 2.55F), 0, 0, 0);
        i = Color.argb(0, 0, 0, 0);
        localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
        ((GradientDrawable)localObject1).setGradientType(0);
        locala.JKr.setBackground((Drawable)localObject1);
        if ((!Util.isNullOrNil(((ADXml.g)localObject2).title)) || (!Util.isNullOrNil(((ADXml.g)localObject2).description)))
        {
          locala.JKr.setVisibility(0);
          localObject1 = (RelativeLayout.LayoutParams)locala.JKw.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.ci.a.fromDPToPix(locala.xYJ.getContext(), 4);
          locala.JKw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (!Util.isNullOrNil(((ADXml.g)localObject2).title))
        {
          locala.JKu.setVisibility(0);
          locala.JKu.setText(com.tencent.mm.cl.h.htZ().a(locala.JKu.getContext(), ((ADXml.g)localObject2).title, locala.JKu.getTextSize()));
        }
        if (Util.isNullOrNil(((ADXml.g)localObject2).description)) {
          break label1089;
        }
        locala.JKv.setVisibility(0);
        locala.JKv.setText(com.tencent.mm.cl.h.htZ().a(locala.JKv.getContext(), ((ADXml.g)localObject2).description, locala.JKv.getTextSize()));
        break label1089;
        locala.JKy.setText(i.j.finder_app_name);
        locala.JKx.setImageResource(i.e.ad_fullcard_finder_icon_white);
        break label1236;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdTimeLineItem", "invalid full card");
        if (this.Jws == null)
        {
          localObject1 = "";
          paramInt2 = 0;
          if (localSnsInfo == null) {
            break label3506;
          }
          if (!localSnsInfo.isFullCardAd()) {
            continue;
          }
          paramInt2 = 1;
          localObject3 = localSnsInfo.getUxinfo();
          com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.JQG, (String)localObject1, 1, paramInt2, (String)localObject3);
          break label1236;
        }
        localObject1 = t.Qu(this.Jws.field_snsId);
        continue;
        paramInt2 = 0;
        continue;
        localObject1 = null;
        break label1275;
        if ((paramTimeLineObject.ContentObj.Sqq != 15) && (paramTimeLineObject.ContentObj.Sqq != 5)) {
          break label1493;
        }
        locala.JKG.KKl.setVisibility(0);
        locala.JKG.KKk.setVisibility(8);
        locala.JKG.KKl.setVideoCallback(new OfflineVideoView.a()
        {
          public final void AS(int paramAnonymousInt)
          {
            AppMethodBeat.i(268222);
            g localg = g.this;
            Object localObject = parambn;
            ADXml.g localg1 = this.LmX;
            SnsInfo localSnsInfo = localSnsInfo;
            long l = paramAnonymousInt;
            int i = locala.JKG.KKl.getDurationMs() / 1000;
            if ((localg.Kee == null) || (localg.Kee.KYo == null) || (localg.Kee.KYo.KBN == null) || (localSnsInfo == null))
            {
              localg = null;
              localObject = localg;
              if (parambm != null)
              {
                localObject = localg;
                if (parambm.KYo != null) {
                  localObject = parambm.KYo.KBN;
                }
              }
              g.a(g.this).a((com.tencent.mm.plugin.sns.ad.f.l)localObject, paramAnonymousInt, parambn.Lbm);
              AppMethodBeat.o(268222);
              return;
            }
            if (((localg1 == null) || (localg1.KjP == null)) && (localg.LmU.JKC.getVisibility() == 0)) {
              localg.LmU.JKC.fv(false);
            }
            localg.Kee.KYo.KBN.Qm(localSnsInfo.field_snsId);
            localg.Kee.KYo.KBN.az(localSnsInfo.field_snsId, l);
            if (!localg.Kee.KYo.KBN.Qj(((bn)localObject).Lbm))
            {
              localg.Kee.KYo.KBN.c(((bn)localObject).Lbm, Util.currentTicks(), false);
              localg.Kee.KYo.KBN.e(((bn)localObject).Lbm, i, false);
              localg.Kee.KYo.KBN.ay(((bn)localObject).Lbm, ((bn)localObject).Lbm);
            }
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.FullCardAdTimeLineItem", "doOnVideoPlaying, currentTime=" + l + ", duration=" + i);
            g.a locala = localg.LmU;
            i = (int)l;
            if (localg1 == null)
            {
              localObject = null;
              label371:
              if ((!Util.isNullOrNil(localSnsInfo.getAdXml().getGestureCanvasInfo())) && (localObject != null) && (((ADXml.g.a)localObject).startTime >= 0L) && (((ADXml.g.a)localObject).endTime > ((ADXml.g.a)localObject).startTime))
              {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "%d-%d,%d", new Object[] { Long.valueOf(((ADXml.g.a)localObject).startTime), Long.valueOf(((ADXml.g.a)localObject).endTime), Integer.valueOf(i) });
                if ((((ADXml.g.a)localObject).startTime > i) || (((ADXml.g.a)localObject).endTime < i)) {
                  break label561;
                }
                if (g.a.b(locala).getOnGestureListener() == null) {
                  MMHandlerThread.postToMainThread(new g.6(localg, locala, (ADXml.g.a)localObject, localSnsInfo));
                }
              }
            }
            for (;;)
            {
              f.a(localg1, (int)l, localg.LmU.JKA, localg.LmU.JKB);
              if (!localSnsInfo.isTwistAd()) {
                break;
              }
              localg.LmU.JKF.Qp(l);
              break;
              localObject = localg1.KjK;
              break label371;
              label561:
              localg.a(locala);
            }
          }
          
          public final boolean a(PString paramAnonymousPString)
          {
            AppMethodBeat.i(268219);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "downloadVideo");
            AppMethodBeat.o(268219);
            return false;
          }
          
          public final void onCompletion()
          {
            AppMethodBeat.i(268221);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "onCompletion");
            boolean bool = g.a(g.this).fVI();
            if ((g.b(g.this)) && (this.LmX != null) && (this.LmX.KjP == null) && (!bool)) {
              locala.JKG.KKl.bgP();
            }
            g localg = g.this;
            bm localbm = parambm;
            bn localbn = parambn;
            ADXml.g localg1 = this.LmX;
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "doOnVideoCompletion, ret=0");
            if ((localbm == null) || (localbm.KYo == null) || (localbm.KYo.KBN == null))
            {
              AppMethodBeat.o(268221);
              return;
            }
            localbm.KYo.KBN.I(localbn.Lbm, false);
            MMHandlerThread.postToMainThread(new g.3(localg, localg1));
            AppMethodBeat.o(268221);
          }
          
          public final void onStart(int paramAnonymousInt)
          {
            AppMethodBeat.i(268220);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "onStart:".concat(String.valueOf(paramAnonymousInt)));
            AppMethodBeat.o(268220);
          }
        });
        if (localObject2 != null)
        {
          f.n(((ADXml.g)localObject2).KjL, locala.JKA);
          f.n(((ADXml.g)localObject2).KjN, locala.JKB);
        }
        d.a(localSnsInfo, (cvt)localObject1);
        l2 = System.nanoTime();
        bool = com.tencent.mm.plugin.sns.model.g.u((cvt)localObject1);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l2) });
        localObject4 = locala.JKG;
        if (!bool)
        {
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).x((cvt)localObject1))
          {
            ((av)localObject4).JAL.setVisibility(8);
            ((av)localObject4).KKn.setVisibility(0);
            ((av)localObject4).KKn.hZF();
            locala.JKG.KKj.setVisibility(0);
            locala.JKs.setVisibility(4);
            ((av)localObject4).KKl.setTag(localObject4);
            ((av)localObject4).KKm.setTag(paramBaseViewHolder);
            locala.JKG.KKj.setOnClickListener(this.LjD);
            paramBaseViewHolder = ((av)localObject4).KKl;
            paramInt1 = this.mActivity.hashCode();
            localObject4 = bp.hzh();
            ((bp)localObject4).time = paramTimeLineObject.CreateTime;
            ((com.tencent.mm.plugin.sns.model.g)localObject3).a(localSnsInfo, (cvt)localObject1, paramBaseViewHolder, paramInt1, (bp)localObject4, parambn.KBz);
            f.a((ADXml.g)localObject2, 0, locala.JKA, locala.JKB);
            paramBaseViewHolder = aq.kD(aj.getAccSnsPath(), ((cvt)localObject1).Id);
            paramTimeLineObject = t.i((cvt)localObject1);
            paramBaseViewHolder = paramBaseViewHolder + paramTimeLineObject;
            if (!u.agG(paramBaseViewHolder)) {
              continue;
            }
            parambm.KYo.KBN.f(parambn.Lbm, (int)((cvt)localObject1).TDZ, true);
            if (d.No())
            {
              bool = v.isH265Video(paramBaseViewHolder);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "AdH265Helper, fileExists, isH265File=" + bool + ", path=" + paramBaseViewHolder);
            }
            if (aj.fOF().b(localSnsInfo, null) != 5) {
              continue;
            }
            bool = true;
            parambm.KYo.KBN.d(parambn.Lbm, bool, false);
            break label1493;
          }
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localSnsInfo, null) == 5)
          {
            ((com.tencent.mm.plugin.sns.model.g)localObject3).B((cvt)localObject1);
            ((av)localObject4).JAL.setVisibility(8);
            ((av)localObject4).KKn.setVisibility(0);
            ((av)localObject4).KKn.hZF();
            continue;
          }
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).y((cvt)localObject1))
          {
            ((av)localObject4).KKn.setVisibility(8);
            ((av)localObject4).JAL.setImageResource(i.i.shortvideo_play_icon_err);
            ((av)localObject4).JAL.setVisibility(0);
            continue;
          }
          ((com.tencent.mm.plugin.sns.model.g)localObject3).z((cvt)localObject1);
          ((av)localObject4).JAL.setVisibility(0);
          ((av)localObject4).KKn.setVisibility(8);
          ((av)localObject4).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
          ((av)localObject4).JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localSnsInfo, null) != 4) {
            continue;
          }
          ((av)localObject4).Ktc.setVisibility(0);
          continue;
        }
        if (((com.tencent.mm.plugin.sns.model.g)localObject3).v((cvt)localObject1))
        {
          ((av)localObject4).JAL.setVisibility(0);
          ((av)localObject4).KKn.setVisibility(8);
          ((av)localObject4).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
          ((av)localObject4).JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
          if (((av)localObject4).KKl.isError())
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.FullCardAdTimeLineItem", "play video error " + ((cvt)localObject1).Id + " " + ((cvt)localObject1).Url + " " + ((cvt)localObject1).TDF + " " + paramInt1);
            ((com.tencent.mm.plugin.sns.model.g)localObject3).z((cvt)localObject1);
            ((av)localObject4).JAL.setVisibility(0);
            ((av)localObject4).KKn.setVisibility(8);
            ((av)localObject4).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
            ((av)localObject4).JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
            com.tencent.mm.plugin.report.service.h.IzE.el(1697, 20);
          }
        }
        else
        {
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).w((cvt)localObject1))
          {
            ((av)localObject4).JAL.setVisibility(8);
            ((av)localObject4).KKn.setVisibility(8);
            continue;
          }
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localSnsInfo, null) <= 5)
          {
            if (locala.JKq) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "fillItem, showPlayBtn");
            fLF();
            continue;
          }
          ((com.tencent.mm.plugin.sns.model.g)localObject3).z((cvt)localObject1);
          ((av)localObject4).JAL.setVisibility(0);
          ((av)localObject4).KKn.setVisibility(8);
          ((av)localObject4).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
          ((av)localObject4).JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
          continue;
        }
        continue;
        parambm.KYo.KBN.f(parambn.Lbm, (int)((cvt)localObject1).TDZ, false);
        continue;
        bool = false;
        continue;
        paramInt1 = 1;
        continue;
        if (this.LmU.JKK == null) {
          continue;
        }
        this.LmU.JKK.setVisibility(8);
        continue;
      }
      label3460:
      ((com.tencent.mm.plugin.sns.model.g)localObject3).a(paramBaseViewHolder.JKG.KKl, this.mActivity.hashCode());
      paramBaseViewHolder.JKG.KKo.setVisibility(8);
      paramBaseViewHolder.JKG.KKl.setVideoCallback(null);
      continue;
      label3506:
      localObject3 = "";
      continue;
      label3514:
      localObject1 = null;
      break;
      label3520:
      paramInt1 = 0;
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
        g.a.b(parama).setVisibility(8);
        g.a.b(parama).setBackgroundColor(0);
        g.a.b(parama).fZF();
        g.a.b(parama).setOnGestureListener(null);
        AppMethodBeat.o(100080);
      }
    });
    AppMethodBeat.o(100083);
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(176426);
    if ((this.LmU != null) && (this.LmU.xYJ != null))
    {
      Object localObject = new int[2];
      this.LmU.xYJ.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.LmU.xYJ.getMeasuredWidth() + i, this.LmU.xYJ.getMeasuredHeight() + j);
      AppMethodBeat.o(176426);
      return localObject;
    }
    AppMethodBeat.o(176426);
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177694);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "onUIPause");
    fYA();
    AppMethodBeat.o(177694);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176424);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "pause");
    if (fYA()) {
      fLF();
    }
    AppMethodBeat.o(176424);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176425);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd stop", new Object[] { this });
    if ((this.LmU != null) && (this.LmU.JKG != null))
    {
      this.LmU.JKG.KKl.clear();
      this.LmU.JKF.setSensorEnabled(false);
    }
    this.Lmj = false;
    AppMethodBeat.o(176425);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View AZc;
    public ImageView JKA;
    public ImageView JKB;
    public SnsAdCardVideoEndView JKC;
    public SnsAdTouchProgressView JKD;
    public SnsAdSphereAnimView JKE;
    public TwistCoverView JKF;
    public ViewStub JKH;
    public ViewGroup JKI;
    public ViewStub JKJ;
    public FinderLivingAnimWrapper JKK;
    public boolean JKq = false;
    public View JKr;
    public MaskImageView JKs;
    public TextView JKt;
    public TextView JKu;
    public TextView JKv;
    public View JKw;
    public ImageView JKx;
    public TextView JKy;
    private SnsDrawGestureView JKz;
    public View xYJ;
    public TextView zOg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.g
 * JD-Core Version:    0.7.0.1
 */