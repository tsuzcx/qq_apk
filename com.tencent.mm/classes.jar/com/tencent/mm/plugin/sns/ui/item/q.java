package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.d;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.video.b;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.LinkedList;

public class q
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private SnsInfo PJQ;
  private boolean RLY;
  private boolean RNE;
  private SightPlayController.d RNF;
  private BaseTimeLineItem.BaseViewHolder RNG;
  View RNH;
  private String RNI;
  View RNJ;
  private boolean RNK;
  private View.OnClickListener RNL;
  private int mScreenHeight;
  private int mScreenWidth;
  
  public q()
  {
    AppMethodBeat.i(100124);
    this.RNE = false;
    this.RNF = new SightPlayController.d()
    {
      public final void c(SightPlayController paramAnonymousSightPlayController, int paramAnonymousInt) {}
    };
    this.RNH = null;
    this.RNI = "";
    this.RNJ = null;
    this.RNK = false;
    this.RNL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(177696);
        Log.i("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick");
        try
        {
          if (q.this.QBJ.Ryp.hlA() == 0) {
            q.this.QBJ.QBf.RQt.onClick(paramAnonymousView);
          }
          for (;;)
          {
            q.b(q.this);
            AppMethodBeat.o(177696);
            return;
            if (q.this.QBJ.Ryp.hlA() == 1) {
              q.this.QBJ.QBf.RQt.onClick(paramAnonymousView);
            }
          }
          return;
        }
        catch (Exception paramAnonymousView)
        {
          Log.e("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(177696);
        }
      }
    };
    AppMethodBeat.o(100124);
  }
  
  private static void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(100127);
    if (paramBoolean)
    {
      Log.i("MicroMsg.VideoTimeLineItem", "lxl setVideoStatusIvVisibility %s, but isPlaying", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(100127);
      return;
    }
    paramBaseViewHolder.Qcj.PQu.setVisibility(paramInt);
    AppMethodBeat.o(100127);
  }
  
  private void ae(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309013);
    if ((this.QBJ != null) && (this.QBJ.Ryp != null) && (this.QBJ.Ryp.Rbv != null) && (paramSnsInfo != null)) {
      this.QBJ.Ryp.Rbv.uu(paramSnsInfo.field_snsId);
    }
    AppMethodBeat.o(309013);
  }
  
  private void doPause()
  {
    AppMethodBeat.i(177698);
    Log.i("MicroMsg.VideoTimeLineItem", "%s Ad Video doPause", new Object[] { this });
    if ((this.RNG != null) && (this.RNG.Qcj != null))
    {
      this.RNG.Qcj.RjM.pause();
      ae(this.PJQ);
    }
    this.RLY = false;
    AppMethodBeat.o(177698);
  }
  
  public void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176431);
    Object localObject2 = al.hgB().aZL(paramBaseViewHolder.hES);
    if (localObject2 == null)
    {
      Log.w("MicroMsg.VideoTimeLineItem", "play error, snsId:%s", new Object[] { paramBaseViewHolder.hES });
      AppMethodBeat.o(176431);
      return;
    }
    TimeLineObject localTimeLineObject = ((SnsInfo)localObject2).getTimeLine();
    if ((localTimeLineObject.ContentObj != null) && (localTimeLineObject.ContentObj.Zpr.size() > 0)) {}
    for (Object localObject1 = (dmz)localTimeLineObject.ContentObj.Zpr.get(0); localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(176431);
      return;
    }
    if (((SnsInfo)localObject2).isAd())
    {
      Log.i("MicroMsg.VideoTimeLineItem", "%s Ad autoPlay", new Object[] { this });
      final long l = ((SnsInfo)localObject2).field_snsId;
      if (!this.RNK)
      {
        this.RNK = true;
        paramBaseViewHolder.Qcj.RjM.setOnCompletionListener(new SightPlayController.d()
        {
          public final void c(SightPlayController paramAnonymousSightPlayController, int paramAnonymousInt)
          {
            AppMethodBeat.i(100121);
            if (paramAnonymousInt != -1)
            {
              if ((this.PNW == null) || (!this.PNW.isAd()))
              {
                Log.e("MicroMsg.VideoTimeLineItem", "onCompletion, !isAd,  snsId=" + t.uA(l));
                AppMethodBeat.o(100121);
                return;
              }
              if ((q.this.QBJ == null) || (q.this.QBJ.Ryp == null) || (q.this.QBJ.Ryp.Rbv == null))
              {
                AppMethodBeat.o(100121);
                return;
              }
              q.this.QBJ.Ryp.Rbv.S(l, false);
              Log.d("MicroMsg.VideoTimeLineItem", "onCompletion, retCode=" + paramAnonymousInt + ", snsId=" + t.uA(l));
            }
            AppMethodBeat.o(100121);
          }
        });
        paramBaseViewHolder.Qcj.RjM.setOnDecodeDurationListener(new SightPlayController.e()
        {
          public final void b(SightPlayController paramAnonymousSightPlayController, long paramAnonymousLong)
          {
            AppMethodBeat.i(100122);
            if ((this.PNW == null) || (!this.PNW.isAd()))
            {
              Log.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, !isAd, currentTime=" + paramAnonymousLong + ", snsId=" + t.uA(l));
              AppMethodBeat.o(100122);
              return;
            }
            if ((q.this.QBJ == null) || (q.this.QBJ.Ryp == null) || (q.this.QBJ.Ryp.Rbv == null))
            {
              AppMethodBeat.o(100122);
              return;
            }
            if (this.PNW != null)
            {
              q.this.QBJ.Ryp.Rbv.ut(this.PNW.field_snsId);
              q.this.QBJ.Ryp.Rbv.bj(this.PNW.field_snsId, 1000L * paramAnonymousLong);
            }
            if (!q.this.QBJ.Ryp.Rbv.uq(l))
            {
              int i = (int)paramAnonymousSightPlayController.gYy();
              q.this.QBJ.Ryp.Rbv.c(l, Util.currentTicks(), false);
              q.this.QBJ.Ryp.Rbv.f(l, i, false);
              q.this.QBJ.Ryp.Rbv.bi(l, l);
              Log.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, addPlay3s, snsId=" + t.uA(l));
            }
            Log.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, currentTime=" + paramAnonymousLong + ", snsId=" + t.uA(l));
            AppMethodBeat.o(100122);
          }
        });
      }
      for (;;)
      {
        com.tencent.mm.plugin.sns.ui.video.e.hsu().bck();
        b.hsi().a(this);
        this.RNG.Qcj.RjM.start();
        hce();
        this.RLY = true;
        this.RNE = false;
        AppMethodBeat.o(176431);
        return;
        Log.d("MicroMsg.VideoTimeLineItem", "play, hasSetListener=true");
      }
    }
    b.hsi().pause();
    d locald = new d();
    locald.ibT = ((dmz)localObject1);
    locald.hES = paramBaseViewHolder.hES;
    locald.hQX = t.uA(((SnsInfo)localObject2).field_snsId);
    localObject1 = al.hgB().aZK(paramBaseViewHolder.hQX);
    if (localObject1 != null)
    {
      locald.createTime = ((SnsInfo)localObject1).getCreateTime();
      localObject2 = (FrameLayout)paramBaseViewHolder.Qcj.RjL.findViewById(b.f.sns_video_container);
      if (((FrameLayout)localObject2).getChildCount() <= 0) {
        break label685;
      }
    }
    label685:
    for (localObject1 = (SnsTimelineVideoView)((FrameLayout)localObject2).getChildAt(0);; localObject1 = null)
    {
      if ((localObject1 != null) && (((SnsTimelineVideoView)localObject1).RUz != null) && (!((SnsTimelineVideoView)localObject1).RUB) && (Util.isEqual(localTimeLineObject.Id, ((SnsTimelineVideoView)localObject1).Rcp)) && (Util.isEqual(((SnsTimelineVideoView)localObject1).RUz.ibT.Id, locald.ibT.Id))) {
        Log.i("MicroMsg.VideoTimeLineItem", "reuse videoview:%s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
      }
      for (;;)
      {
        ((SnsTimelineVideoView)localObject1).setVisibility(0);
        ((SnsTimelineVideoView)localObject1).setVideoScaleType(i.e.XYN);
        paramBaseViewHolder.Qcj.RjL.findViewById(b.f.thumb_mask).setVisibility(8);
        if (paramBaseViewHolder.Qcj.PQu != null) {
          paramBaseViewHolder.Qcj.PQu.setVisibility(8);
        }
        ((SnsTimelineVideoView)localObject1).setUICallback(new SnsTimelineVideoView.b()
        {
          public final void ZW(String paramAnonymousString)
          {
            AppMethodBeat.i(100123);
            Log.i("MicroMsg.VideoTimeLineItem", "onDestroy UICallback %s, %s", new Object[] { paramAnonymousString, q.a(q.this) });
            if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(q.a(q.this))) && (q.this.RNJ != null))
            {
              q.this.RNJ.setVisibility(0);
              Log.i("MicroMsg.VideoTimeLineItem", "onDestroy show videoStatusIv");
            }
            AppMethodBeat.o(100123);
          }
        });
        ((SnsTimelineVideoView)localObject1).setVideoCallback(null);
        com.tencent.mm.plugin.sns.ui.video.e.hsu().a((OnlineVideoView)localObject1, locald, localTimeLineObject.Id);
        AppMethodBeat.o(176431);
        return;
        locald.createTime = ((int)(System.currentTimeMillis() / 1000L));
        break;
        com.tencent.mm.plugin.sns.ui.video.e.hsu();
        if ((com.tencent.mm.plugin.sns.ui.video.e.hsw()) && (localObject1 != null) && (((SnsTimelineVideoView)localObject1).RUz == null))
        {
          Log.i("MicroMsg.VideoTimeLineItem", "reuse videoview by precreate View:%s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
        }
        else
        {
          if (localObject1 != null) {
            ((FrameLayout)localObject2).removeViewAt(0);
          }
          localObject1 = com.tencent.mm.plugin.sns.ui.video.e.hsu().jU(((FrameLayout)localObject2).getContext());
          if (((SnsTimelineVideoView)localObject1).getParent() != null)
          {
            ((SnsTimelineVideoView)localObject1).hsm();
            ((SnsTimelineVideoView)localObject1).RUC = true;
            ((ViewGroup)((SnsTimelineVideoView)localObject1).getParent()).removeView((View)localObject1);
          }
          ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
          ((SnsTimelineVideoView)localObject1).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        }
      }
    }
  }
  
  public void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(100126);
    this.PJQ = parambo.PJQ;
    dmz localdmz;
    if ((paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Zpr.size() > 0))
    {
      localdmz = (dmz)paramTimeLineObject.ContentObj.Zpr.get(0);
      if ((this.PJQ == null) || (!this.PJQ.isAd())) {
        break label1782;
      }
      Log.i("MicroMsg.VideoTimeLineItem", "ad fillItem, videoItem, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
      label119:
      if (!com.tencent.mm.plugin.sns.ui.video.e.hsu().bbn(paramTimeLineObject.Id)) {
        break label3001;
      }
    }
    label527:
    label1698:
    label2476:
    label3001:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.RNI = paramTimeLineObject.Id;
      this.RNJ = paramBaseViewHolder.Qcj.PQu;
      g localg = al.hgy();
      if (!parambo.Rbg)
      {
        paramBaseViewHolder.Qcj.RjM.setOnSightCompletionAction(null);
        paramBaseViewHolder.Qcj.RjM.setOnCompletionListener(null);
        paramBaseViewHolder.Qcj.RjM.setOnDecodeDurationListener(null);
      }
      paramBaseViewHolder.Qcj.RjM.setIsAdVideo(parambo.Rbg);
      if ((paramBaseViewHolder.Qcj.RjK != null) && (!Util.isEqual(paramBaseViewHolder.Qcj.RjK.Id, paramTimeLineObject.Id)))
      {
        Log.i("MicroMsg.VideoTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.Qcj.RjK.Id });
        localg.a(paramBaseViewHolder.Qcj.RjM, this.mActivity.hashCode(), 0);
      }
      paramBaseViewHolder.Qcj.a(paramTimeLineObject, paramInt1, parambo.Rdg, parambo.Rbg);
      paramBaseViewHolder.Qcj.QRC.setVisibility(8);
      paramBaseViewHolder.Qcj.RjR.setVisibility(8);
      long l;
      label444:
      Object localObject1;
      label504:
      Object localObject3;
      Object localObject2;
      label577:
      int i;
      if ((paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Zpr.size() > 0))
      {
        l = System.nanoTime();
        boolean bool2 = g.u(localdmz);
        Log.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
        if (!bool2) {
          if (localg.x(localdmz))
          {
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.Qcj.RjP.setVisibility(0);
            paramBaseViewHolder.Qcj.RjP.jEN();
            if ((!parambo.Rbg) || (!m.d(paramBaseViewHolder.timeLineObject))) {
              break label2476;
            }
            paramInt2 = 0;
            if (this.PJQ != null) {
              paramInt2 = this.PJQ.getAdXml().verticalVideoDisplayType;
            }
            if (paramInt2 != 1) {
              break label2438;
            }
            localObject1 = o.dV(paramBaseViewHolder.Qcj.RjM.getUIContext());
            localObject3 = new StringBuilder("isVerticalAdVideo=true, snsId=");
            if (parambo.PJQ != null) {
              break label2461;
            }
            localObject2 = "";
            Log.i("MicroMsg.VideoTimeLineItem", localObject2 + ", showW=" + ((Pair)localObject1).first + ", showH=" + ((Pair)localObject1).second);
            paramInt2 = 1;
            localObject2 = localObject1;
            localObject3 = localObject2;
            if (parambo.Rbg)
            {
              SnsInfo localSnsInfo = parambo.PJQ;
              localObject3 = localSnsInfo.getAdXml();
              i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject1 = localObject2;
                if (((ADXml)localObject3).adMediaDisplayWidth > 0.0F)
                {
                  localObject1 = localObject2;
                  if (((ADXml)localObject3).adMediaDisplayHeight > 0.0F)
                  {
                    float f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(((ADXml)localObject3).adMediaDisplayWidth, 1, ((ADXml)localObject3).adBasicRemWidth, ((ADXml)localObject3).adBasicRootFontSize);
                    float f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(((ADXml)localObject3).adMediaDisplayHeight, 1, ((ADXml)localObject3).adBasicRemWidth, ((ADXml)localObject3).adBasicRootFontSize);
                    if (((ADXml)localObject3).adMediaDisplayMode != 0) {
                      break label2505;
                    }
                    float f1 = f3;
                    if (f3 >= i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12))
                    {
                      f1 = i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12);
                      f2 = (int)(((ADXml)localObject3).adMediaDisplayHeight * f1 / ((ADXml)localObject3).adMediaDisplayWidth);
                    }
                    localObject1 = Pair.create(Integer.valueOf((int)f1), Integer.valueOf((int)f2));
                  }
                }
              }
              label826:
              localObject3 = localObject1;
              if (!localSnsInfo.getAdXml().isLandingPagesAd())
              {
                localObject3 = localObject1;
                if (localSnsInfo.getAdInfo().isWeapp())
                {
                  paramBaseViewHolder.Qcj.RjR.setVisibility(0);
                  paramBaseViewHolder.Qcj.RjR.setImageResource(b.e.we_app_icon);
                  localObject3 = localObject1;
                }
              }
            }
            i = ((Integer)((Pair)localObject3).first).intValue();
            int j = ((Integer)((Pair)localObject3).second).intValue();
            if ((paramBaseViewHolder.Qcj.RjM instanceof SightPlayImageView))
            {
              if (parambo.Rbg) {
                break label2705;
              }
              paramBaseViewHolder.Qcj.RjM.setScaleMode(1);
              paramBaseViewHolder.Qcj.RjM.setScaleType(QImageView.a.afVc);
            }
            label954:
            paramBaseViewHolder.Qcj.RjM.ld(i, j);
            if ((paramBaseViewHolder.Qcj.RjM instanceof SightPlayImageView))
            {
              if (paramInt2 == 0) {
                break label2764;
              }
              paramBaseViewHolder.Qcj.RjM.PGE = true;
            }
            label997:
            paramBaseViewHolder.Qcj.RjM.setVisibility(0);
            localObject2 = paramBaseViewHolder.Qcj.RjQ.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject2).width = i;
            ((ViewGroup.LayoutParams)localObject2).height = j;
            paramBaseViewHolder.Qcj.RjQ.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localObject1 = (FrameLayout)paramBaseViewHolder.Qcj.RjL.findViewById(b.f.sns_video_container);
            localObject3 = (FrameLayout.LayoutParams)((FrameLayout)localObject1).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject3).width = i;
            ((FrameLayout.LayoutParams)localObject3).height = j;
            ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
            localObject3 = paramBaseViewHolder.Qcj.RjL.findViewById(b.f.thumb_mask);
            ((View)localObject3).setLayoutParams(new FrameLayout.LayoutParams((ViewGroup.LayoutParams)localObject2));
            ((View)localObject3).setVisibility(4);
            this.RNH = ((View)localObject1);
            localObject2 = com.tencent.mm.plugin.sns.ui.video.e.hsu().bbq(paramTimeLineObject.Id);
            Log.i("MicroMsg.VideoTimeLineItem", "lxl fill itemview check videoView reAttach, tlObjId:%s, vv:%s, count:%s", new Object[] { paramTimeLineObject.Id, localObject2, Integer.valueOf(((FrameLayout)localObject1).getChildCount()) });
            if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof ImageView)))
            {
              ((FrameLayout)localObject1).removeAllViews();
              Log.i("MicroMsg.VideoTimeLineItem", "find thumbView thne remove it %s", new Object[] { paramTimeLineObject.Id });
            }
            if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof SnsTimelineVideoView)))
            {
              localObject3 = (SnsTimelineVideoView)((FrameLayout)localObject1).getChildAt(0);
              if (!paramTimeLineObject.Id.equals(((SnsTimelineVideoView)localObject3).Rcp))
              {
                ((FrameLayout)localObject1).removeAllViews();
                Log.i("MicroMsg.VideoTimeLineItem", "find diff id then remove it %s %s", new Object[] { paramTimeLineObject.Id, ((SnsTimelineVideoView)localObject3).Rcp });
              }
            }
            if ((localObject2 == null) || (((FrameLayout)localObject1).getChildCount() != 0)) {
              break label2778;
            }
            if ((((SnsTimelineVideoView)localObject2).getParent() != null) && (((SnsTimelineVideoView)localObject2).getParent() != localObject1))
            {
              ((SnsTimelineVideoView)localObject2).RUC = true;
              ((ViewGroup)((SnsTimelineVideoView)localObject2).getParent()).removeView((View)localObject2);
              ((SnsTimelineVideoView)localObject2).setVisibility(0);
              ((SnsTimelineVideoView)localObject2).setVideoScaleType(i.e.XYN);
              ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
              Log.i("MicroMsg.VideoTimeLineItem", "lxl reAttach succ");
            }
            label1400:
            if (localObject2 != null)
            {
              localObject1 = paramBaseViewHolder.hES;
              if (paramBaseViewHolder.timeLineObject != null) {
                break label2843;
              }
              paramInt2 = 0;
              ((SnsTimelineVideoView)localObject2).a(localdmz, (String)localObject1, paramInt2);
            }
            paramBaseViewHolder.Qcj.RjM.setTagObject(paramBaseViewHolder.Qcj);
            if ((parambo.PJQ == null) || (!parambo.PJQ.isAd()) || (!hbX())) {
              break label2855;
            }
            localObject1 = parambo.PJQ;
            localObject2 = paramBaseViewHolder.Qcj.RjM;
            paramInt2 = this.mActivity.hashCode();
            localObject3 = br.jbh();
            ((br)localObject3).time = paramTimeLineObject.CreateTime;
            localg.a((SnsInfo)localObject1, localdmz, (VideoSightView)localObject2, -1, paramInt2, paramInt1, (br)localObject3, parambo.Rbg, true, false);
            label1533:
            paramBaseViewHolder.Qcj.RjO.setTag(paramBaseViewHolder.Qcj);
            paramTimeLineObject = as.mg(al.getAccSnsPath(), localdmz.Id);
            localObject1 = t.i(localdmz);
            paramTimeLineObject = paramTimeLineObject + (String)localObject1;
            if (!com.tencent.mm.vfs.y.ZC(paramTimeLineObject)) {
              break label2919;
            }
            parambn.Ryp.Rbv.g(parambo.RBq, (int)localdmz.aaTF, true);
            if ((com.tencent.mm.plugin.sns.ad.d.e.anH()) && (parambo.Rbg))
            {
              bool1 = com.tencent.mm.modelvideo.y.isH265Video(paramTimeLineObject);
              Log.i("MicroMsg.VideoTimeLineItem", "AdH265Helper, fileExists, isH265File=" + bool1 + ", path=" + paramTimeLineObject);
            }
            if (!parambo.Rbg) {
              break label2950;
            }
            if (al.hgy().b(parambo.PJQ, null) != 5) {
              break label2944;
            }
            bool1 = true;
            parambn.Ryp.Rbv.e(parambo.RBq, bool1, false);
          }
        }
      }
      for (;;)
      {
        if ((parambo.PJQ != null) && (!parambo.PJQ.isCardAd())) {
          parambn.hpB().c(paramBaseViewHolder.Qcj.RjO, parambn.QBf.RQk, parambn.QBf.RPU);
        }
        a(parambo, 1);
        AppMethodBeat.o(100126);
        return;
        localdmz = null;
        break;
        label1782:
        Log.i("MicroMsg.VideoTimeLineItem", "videoTImeline, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
        break label119;
        if ((parambo.Rbg) && (localg.b(parambo.PJQ, null) == 5))
        {
          localg.B(localdmz);
          a(paramBaseViewHolder, 8, bool1);
          paramBaseViewHolder.Qcj.RjP.setVisibility(0);
          paramBaseViewHolder.Qcj.RjP.jEN();
          break label444;
        }
        if (localg.y(localdmz))
        {
          paramBaseViewHolder.Qcj.RjP.setVisibility(8);
          paramBaseViewHolder.Qcj.PQu.setImageResource(b.i.shortvideo_play_icon_err);
          a(paramBaseViewHolder, 0, bool1);
          break label444;
        }
        localg.z(localdmz);
        a(paramBaseViewHolder, 0, bool1);
        paramBaseViewHolder.Qcj.RjP.setVisibility(8);
        paramBaseViewHolder.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
        paramBaseViewHolder.Qcj.PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
        if ((!parambo.Rbg) && (localg.a(parambo.PJQ, null) == 4))
        {
          paramBaseViewHolder.Qcj.QRC.setVisibility(0);
          break label444;
        }
        if ((!parambo.Rbg) || (localg.b(parambo.PJQ, null) != 4)) {
          break label444;
        }
        paramBaseViewHolder.Qcj.QRC.setVisibility(0);
        break label444;
        if (localg.v(localdmz))
        {
          a(paramBaseViewHolder, 0, bool1);
          paramBaseViewHolder.Qcj.RjP.setVisibility(8);
          paramBaseViewHolder.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
          paramBaseViewHolder.Qcj.PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
        }
        for (;;)
        {
          if (!paramBaseViewHolder.Qcj.RjM.PGy.gYv()) {
            break label2436;
          }
          Log.e("MicroMsg.VideoTimeLineItem", "play video error " + localdmz.Id + " " + localdmz.Url + " " + localdmz.aaTl + " " + paramInt1);
          localg.z(localdmz);
          a(paramBaseViewHolder, 0, bool1);
          paramBaseViewHolder.Qcj.RjP.setVisibility(8);
          paramBaseViewHolder.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
          paramBaseViewHolder.Qcj.PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
          break;
          if (localg.w(localdmz))
          {
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.Qcj.RjP.setVisibility(8);
          }
          else if ((parambo.Rbg) && (localg.b(parambo.PJQ, null) <= 5))
          {
            if (!this.RNE)
            {
              Log.i("MicroMsg.VideoTimeLineItem", "fillItem, showPlayBtn");
              hcb();
            }
          }
          else
          {
            localg.z(localdmz);
            a(paramBaseViewHolder, 0, bool1);
            paramBaseViewHolder.Qcj.RjP.setVisibility(8);
            paramBaseViewHolder.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
            paramBaseViewHolder.Qcj.PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
          }
        }
        break label444;
        localObject1 = o.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.Qcj.RjM.getUIContext(), false);
        break label504;
        localObject2 = Long.valueOf(parambo.PJQ.field_snsId);
        break label527;
        localObject2 = o.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.Qcj.RjM.getUIContext(), parambo.Rbg);
        paramInt2 = 0;
        break label577;
        label2505:
        if (((ADXml)localObject3).adMediaDisplayMode == 1)
        {
          i = i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12);
          localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((ADXml)localObject3).adMediaDisplayHeight / ((ADXml)localObject3).adMediaDisplayWidth)));
          paramBaseViewHolder.RKD.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
          break label826;
        }
        localObject1 = localObject2;
        if (((ADXml)localObject3).adMediaDisplayMode != 2) {
          break label826;
        }
        i = i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12);
        localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((ADXml)localObject3).adMediaDisplayHeight / ((ADXml)localObject3).adMediaDisplayWidth)));
        paramBaseViewHolder.RKD.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
        break label826;
        if (paramInt2 != 0)
        {
          paramBaseViewHolder.Qcj.RjM.setScaleMode(1);
          paramBaseViewHolder.Qcj.RjM.setScaleType(QImageView.a.afVc);
          break label954;
        }
        paramBaseViewHolder.Qcj.RjM.setScaleMode(0);
        paramBaseViewHolder.Qcj.RjM.setScaleType(QImageView.a.afUX);
        break label954;
        label2764:
        paramBaseViewHolder.Qcj.RjM.setDrawWidthAndHeightFix(false);
        break label997;
        label2778:
        if ((bool1) || (((FrameLayout)localObject1).getChildCount() <= 0) || (com.tencent.mm.plugin.sns.ui.video.e.hsu().bbo(paramTimeLineObject.Id))) {
          break label1400;
        }
        l = System.currentTimeMillis();
        ((FrameLayout)localObject1).removeViewAt(0);
        Log.i("MicroMsg.VideoTimeLineItem", "lxl item remove videoview cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        break label1400;
        paramInt2 = paramBaseViewHolder.timeLineObject.CreateTime;
        break label1421;
        localObject1 = parambo.PJQ;
        localObject2 = paramBaseViewHolder.Qcj.RjM;
        paramInt2 = this.mActivity.hashCode();
        localObject3 = br.jbh();
        ((br)localObject3).time = paramTimeLineObject.CreateTime;
        localg.a((SnsInfo)localObject1, localdmz, (VideoSightView)localObject2, paramInt2, paramInt1, (br)localObject3, parambo.Rbg, true);
        break label1533;
        label2919:
        parambn.Ryp.Rbv.g(parambo.RBq, (int)localdmz.aaTF, false);
        break label1673;
        bool1 = false;
        break label1698;
        if (al.hgy().a(parambo.PJQ, null) == 5)
        {
          bool1 = true;
          break label1698;
        }
        bool1 = false;
        break label1698;
        localg.a(paramBaseViewHolder.Qcj.RjM, this.mActivity.hashCode(), paramInt1);
      }
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100125);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.mScreenWidth = ((DisplayMetrics)localObject).widthPixels;
    this.mScreenHeight = ((DisplayMetrics)localObject).heightPixels;
    this.RNG = paramBaseViewHolder;
    if (paramBaseViewHolder.RKG != null)
    {
      paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_media_sight_item);
      paramBaseViewHolder.RLw = ((ViewStub)paramBaseViewHolder.convertView.findViewById(b.f.images_keeper_li));
      if (!paramBaseViewHolder.RLx) {
        paramBaseViewHolder.Qcj.RjL = paramBaseViewHolder.RLw.inflate();
      }
    }
    for (paramBaseViewHolder.RLx = true;; paramBaseViewHolder.RLx = true)
    {
      paramBaseViewHolder.Qcj.RjO = paramBaseViewHolder.Qcj.RjL.findViewById(b.f.chatting_click_area);
      paramBaseViewHolder.Qcj.RjM = ((VideoSightView)paramBaseViewHolder.Qcj.RjL.findViewById(b.f.image));
      paramBaseViewHolder.Qcj.RjM.setMute(true);
      paramBaseViewHolder.Qcj.RjO.setOnClickListener(this.RNL);
      paramBaseViewHolder.Qcj.PQu = ((ImageView)paramBaseViewHolder.Qcj.RjL.findViewById(b.f.status_btn));
      paramBaseViewHolder.Qcj.RjP = ((MMPinProgressBtn)paramBaseViewHolder.Qcj.RjL.findViewById(b.f.progress));
      paramBaseViewHolder.Qcj.RjQ = ((TextView)paramBaseViewHolder.Qcj.RjL.findViewById(b.f.endtv));
      paramBaseViewHolder.Qcj.QRC = ((TextView)paramBaseViewHolder.Qcj.RjL.findViewById(b.f.errorTv));
      paramBaseViewHolder.Qcj.RjR = ((ImageView)paramBaseViewHolder.Qcj.RjL.findViewById(b.f.sns_sight_biz_icon));
      h.baF();
      if (((Boolean)h.baE().ban().d(344065, Boolean.FALSE)).booleanValue())
      {
        localObject = (TextView)((ViewStub)paramBaseViewHolder.Qcj.RjL.findViewById(b.f.sight_info_viewstub)).inflate();
        paramBaseViewHolder.Qcj.RjM.setSightInfoView((TextView)localObject);
      }
      AppMethodBeat.o(100125);
      return;
      paramBaseViewHolder.Qcj.RjL = paramBaseViewHolder.convertView.findViewById(b.f.sns_media_sight_item);
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(100129);
    if (this.RNH != null)
    {
      Object localObject = new int[2];
      this.RNH.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.RNH.getMeasuredWidth() + i, this.RNH.getMeasuredHeight() + j);
      AppMethodBeat.o(100129);
      return localObject;
    }
    AppMethodBeat.o(100129);
    return null;
  }
  
  protected boolean hbX()
  {
    return false;
  }
  
  public final void hcb()
  {
    AppMethodBeat.i(176430);
    Log.i("MicroMsg.VideoTimeLineItem", "try show play btn");
    if ((this.RNG != null) && (this.RNG.Qcj != null) && (!this.RLY))
    {
      Log.i("MicroMsg.VideoTimeLineItem", "show play btn");
      this.RNG.Qcj.PQu.setVisibility(0);
      this.RNG.Qcj.RjP.setVisibility(8);
      this.RNG.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.i.shortvideo_play_btn));
      this.RNG.Qcj.PQu.setContentDescription(this.mActivity.getString(b.j.play_sight_desc));
    }
    AppMethodBeat.o(176430);
  }
  
  protected final void hce()
  {
    AppMethodBeat.i(309101);
    Log.i("MicroMsg.VideoTimeLineItem", "try hide play btn");
    if ((this.RNG != null) && (this.RNG.Qcj != null))
    {
      Log.i("MicroMsg.VideoTimeLineItem", "hide play btn");
      this.RNG.Qcj.PQu.setVisibility(8);
      this.RNG.Qcj.RjP.setVisibility(8);
    }
    AppMethodBeat.o(309101);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177697);
    Log.i("MicroMsg.VideoTimeLineItem", "onUIPause");
    doPause();
    AppMethodBeat.o(177697);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176432);
    Log.i("MicroMsg.VideoTimeLineItem", "pause");
    doPause();
    hcb();
    AppMethodBeat.o(176432);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176433);
    Log.i("MicroMsg.VideoTimeLineItem", "%s Ad Video stop", new Object[] { this });
    if ((this.RNG != null) && (this.RNG.Qcj != null)) {
      this.RNG.Qcj.RjM.PGy.clear();
    }
    this.RLY = false;
    AppMethodBeat.o(176433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.q
 * JD-Core Version:    0.7.0.1
 */