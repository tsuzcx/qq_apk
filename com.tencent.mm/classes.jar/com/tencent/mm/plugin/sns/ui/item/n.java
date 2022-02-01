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
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;

public class n
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private View.OnClickListener ALv;
  private boolean ANI;
  private boolean APc;
  private boolean APd;
  private b.e APe;
  private BaseTimeLineItem.BaseViewHolder APf;
  View APg;
  private String APh;
  View APi;
  private boolean APj;
  private int mScreenHeight;
  private int mScreenWidth;
  private p zlW;
  
  public n()
  {
    AppMethodBeat.i(100124);
    this.APc = false;
    this.APd = false;
    this.APe = new b.e()
    {
      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt) {}
    };
    this.APg = null;
    this.APh = "";
    this.APi = null;
    this.APj = false;
    this.ALv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220099);
        ae.i("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick");
        try
        {
          n.this.zGX.zGs.AQl.onClick(paramAnonymousView);
          n.b(n.this);
          AppMethodBeat.o(220099);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          ae.e("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(220099);
        }
      }
    };
    AppMethodBeat.o(100124);
  }
  
  private void U(p paramp)
  {
    AppMethodBeat.i(220101);
    if ((this.zGX != null) && (this.zGX.AAQ != null) && (this.zGX.AAQ.Agi != null) && (paramp != null)) {
      this.zGX.AAQ.Agi.zP(paramp.field_snsId);
    }
    AppMethodBeat.o(220101);
  }
  
  private static void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(100127);
    if (paramBoolean)
    {
      ae.i("MicroMsg.VideoTimeLineItem", "lxl setVideoStatusIvVisibility %s, but isPlaying", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(100127);
      return;
    }
    paramBaseViewHolder.AKJ.zWJ.setVisibility(paramInt);
    AppMethodBeat.o(100127);
  }
  
  private void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, com.tencent.mm.plugin.sns.model.g paramg, int paramInt)
  {
    AppMethodBeat.i(220104);
    ae.d("MicroMsg.VideoTimeLineItem", "cleanNewPlayerSnsSight is called, the position is ".concat(String.valueOf(paramInt)));
    if ((paramBaseViewHolder == null) || (paramBaseViewHolder.AKJ == null) || (paramg == null))
    {
      AppMethodBeat.o(220104);
      return;
    }
    com.tencent.mm.plugin.sns.ad.timeline.a.e.a(paramBaseViewHolder.AKJ.AnI, paramg, this.mActivity, paramInt);
    AppMethodBeat.o(220104);
  }
  
  private static void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, boolean paramBoolean)
  {
    AppMethodBeat.i(220102);
    if ((paramBaseViewHolder == null) || (paramBaseViewHolder.AKJ == null))
    {
      AppMethodBeat.o(220102);
      return;
    }
    com.tencent.mm.plugin.sns.ad.timeline.a.e.a(paramBaseViewHolder.AKJ.AnI, paramBoolean);
    AppMethodBeat.o(220102);
  }
  
  private void ehQ()
  {
    AppMethodBeat.i(177698);
    ae.i("MicroMsg.VideoTimeLineItem", "%s Ad Video doPause", new Object[] { this });
    if ((this.APf != null) && (this.APf.AKJ != null))
    {
      if (!dVx()) {
        break label73;
      }
      l(this.APf);
    }
    for (;;)
    {
      U(this.zlW);
      this.ANI = false;
      AppMethodBeat.o(177698);
      return;
      label73:
      this.APf.AKJ.AnH.pause();
    }
  }
  
  private static void l(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(220103);
    if ((paramBaseViewHolder == null) || (paramBaseViewHolder.AKJ == null))
    {
      AppMethodBeat.o(220103);
      return;
    }
    com.tencent.mm.plugin.sns.ad.timeline.a.e.c(paramBaseViewHolder.AKJ.AnI);
    AppMethodBeat.o(220103);
  }
  
  public void a(final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176431);
    Object localObject2 = ah.dXE().aBr(paramBaseViewHolder.dqc);
    if (localObject2 == null)
    {
      ae.w("MicroMsg.VideoTimeLineItem", "play error, snsId:%s", new Object[] { paramBaseViewHolder.dqc });
      AppMethodBeat.o(176431);
      return;
    }
    TimeLineObject localTimeLineObject = ((p)localObject2).ebP();
    if ((localTimeLineObject.HUG != null) && (localTimeLineObject.HUG.Gtx.size() > 0)) {}
    for (Object localObject1 = (bzh)localTimeLineObject.HUG.Gtx.get(0); localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(176431);
      return;
    }
    if (((p)localObject2).Rt(32))
    {
      ae.i("MicroMsg.VideoTimeLineItem", "%s Ad autoPlay", new Object[] { this });
      final long l = ((p)localObject2).field_snsId;
      if (!this.APj)
      {
        this.APj = true;
        paramBaseViewHolder.AKJ.AnH.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(100121);
            if (paramAnonymousInt != -1)
            {
              if ((this.AgF == null) || (!this.AgF.Rt(32)))
              {
                ae.e("MicroMsg.VideoTimeLineItem", "onCompletion, !isAd,  snsId=" + r.zV(l));
                AppMethodBeat.o(100121);
                return;
              }
              if ((n.this.zGX == null) || (n.this.zGX.AAQ == null) || (n.this.zGX.AAQ.Agi == null))
              {
                AppMethodBeat.o(100121);
                return;
              }
              n.this.zGX.AAQ.Agi.C(l, false);
              ae.d("MicroMsg.VideoTimeLineItem", "onCompletion, retCode=" + paramAnonymousInt + ", snsId=" + r.zV(l));
            }
            AppMethodBeat.o(100121);
          }
        });
        paramBaseViewHolder.AKJ.AnH.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(100122);
            if ((this.AgF == null) || (!this.AgF.Rt(32)))
            {
              ae.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, !isAd, currentTime=" + paramAnonymousLong + ", snsId=" + r.zV(l));
              AppMethodBeat.o(100122);
              return;
            }
            if ((n.this.zGX == null) || (n.this.zGX.AAQ == null) || (n.this.zGX.AAQ.Agi == null))
            {
              AppMethodBeat.o(100122);
              return;
            }
            if (this.AgF != null)
            {
              n.this.zGX.AAQ.Agi.zO(this.AgF.field_snsId);
              n.this.zGX.AAQ.Agi.aj(this.AgF.field_snsId, 1000L * paramAnonymousLong);
            }
            if (!n.this.zGX.AAQ.Agi.zL(l))
            {
              int i = (int)paramAnonymousb.dTD();
              n.this.zGX.AAQ.Agi.d(l, bu.HQ(), false);
              n.this.zGX.AAQ.Agi.e(l, i, false);
              n.this.zGX.AAQ.Agi.ai(l, l);
              ae.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, addPlay3s, snsId=" + r.zV(l));
            }
            ae.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, currentTime=" + paramAnonymousLong + ", snsId=" + r.zV(l));
            AppMethodBeat.o(100122);
          }
        });
        paramBaseViewHolder.AKJ.AnI.setVideoCallback(new OfflineVideoView.a()
        {
          public final boolean a(PString paramAnonymousPString)
          {
            return false;
          }
          
          public final void onCompletion()
          {
            AppMethodBeat.i(220096);
            paramBaseViewHolder.AKJ.AnI.restart();
            n.a(n.this, paramBaseViewHolder, this.AgF);
            AppMethodBeat.o(220096);
          }
          
          public final void onStart(int paramAnonymousInt)
          {
            AppMethodBeat.i(220095);
            ae.d("MicroMsg.VideoTimeLineItem", "onStart is called , the duration second is ".concat(String.valueOf(paramAnonymousInt)));
            AppMethodBeat.o(220095);
          }
          
          public final void tx(int paramAnonymousInt)
          {
            AppMethodBeat.i(220097);
            long l = paramBaseViewHolder.AKJ.AnI.getDurationMs();
            n.a(n.this, paramBaseViewHolder, this.AgF, paramAnonymousInt, l);
            AppMethodBeat.o(220097);
          }
        });
        d.eir().cyX();
        com.tencent.mm.plugin.sns.ui.video.b.eil().a(this);
        if (!dVx()) {
          break label301;
        }
        paramBaseViewHolder = this.APf;
        if ((paramBaseViewHolder != null) && (paramBaseViewHolder.AKJ != null)) {
          break label288;
        }
      }
      for (;;)
      {
        ehP();
        this.ANI = true;
        this.APc = false;
        AppMethodBeat.o(176431);
        return;
        ae.d("MicroMsg.VideoTimeLineItem", "play, hasSetListener=true");
        break;
        label288:
        com.tencent.mm.plugin.sns.ad.timeline.a.e.b(paramBaseViewHolder.AKJ.AnI);
        continue;
        label301:
        this.APf.AKJ.AnH.start();
      }
    }
    com.tencent.mm.plugin.sns.ui.video.b.eil().pause();
    com.tencent.mm.plugin.sns.ui.video.c localc = new com.tencent.mm.plugin.sns.ui.video.c();
    localc.dKe = ((bzh)localObject1);
    localc.dqc = paramBaseViewHolder.dqc;
    localc.dAg = r.zV(((p)localObject2).field_snsId);
    localObject1 = ah.dXE().aBq(paramBaseViewHolder.dAg);
    if (localObject1 != null)
    {
      localc.icw = ((p)localObject1).field_createTime;
      localObject2 = (FrameLayout)paramBaseViewHolder.AKJ.AnG.findViewById(2131305105);
      localObject1 = null;
      if (((FrameLayout)localObject2).getChildCount() > 0) {
        localObject1 = (SnsTimelineVideoView)((FrameLayout)localObject2).getChildAt(0);
      }
      if ((localObject1 == null) || (((SnsTimelineVideoView)localObject1).ASr == null) || (((SnsTimelineVideoView)localObject1).ASv) || (!bu.lX(localTimeLineObject.Id, ((SnsTimelineVideoView)localObject1).ASs)) || (!bu.lX(((SnsTimelineVideoView)localObject1).ASr.dKe.Id, localc.dKe.Id))) {
        break label619;
      }
      ae.i("MicroMsg.VideoTimeLineItem", "reuse videoview:%s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
    }
    for (;;)
    {
      ((SnsTimelineVideoView)localObject1).setVisibility(0);
      ((SnsTimelineVideoView)localObject1).setVideoScaleType(i.e.Flk);
      paramBaseViewHolder.AKJ.AnG.findViewById(2131305799).setVisibility(8);
      if (paramBaseViewHolder.AKJ.zWJ != null) {
        paramBaseViewHolder.AKJ.zWJ.setVisibility(8);
      }
      ((SnsTimelineVideoView)localObject1).setUICallback(new SnsTimelineVideoView.b()
      {
        public final void PR(String paramAnonymousString)
        {
          AppMethodBeat.i(220098);
          ae.i("MicroMsg.VideoTimeLineItem", "onDestroy UICallback %s, %s", new Object[] { paramAnonymousString, n.a(n.this) });
          if ((!bu.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(n.a(n.this))) && (n.this.APi != null))
          {
            n.this.APi.setVisibility(0);
            ae.i("MicroMsg.VideoTimeLineItem", "onDestroy show videoStatusIv");
          }
          AppMethodBeat.o(220098);
        }
      });
      d.eir().a((OnlineVideoView)localObject1, localc, localTimeLineObject.Id);
      AppMethodBeat.o(176431);
      return;
      localc.icw = ((int)(System.currentTimeMillis() / 1000L));
      break;
      label619:
      if (localObject1 != null) {
        ((FrameLayout)localObject2).removeViewAt(0);
      }
      localObject1 = d.eir().gs(((FrameLayout)localObject2).getContext());
      if (((SnsTimelineVideoView)localObject1).getParent() != null)
      {
        ((SnsTimelineVideoView)localObject1).eip();
        ((SnsTimelineVideoView)localObject1).ASw = true;
        ((ViewGroup)((SnsTimelineVideoView)localObject1).getParent()).removeView((View)localObject1);
      }
      ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      ((SnsTimelineVideoView)localObject1).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(100126);
    this.zlW = parambi.zlW;
    bzh localbzh;
    if ((paramTimeLineObject.HUG != null) && (paramTimeLineObject.HUG.Gtx.size() > 0))
    {
      localbzh = (bzh)paramTimeLineObject.HUG.Gtx.get(0);
      if ((this.zlW == null) || (!this.zlW.Rt(32))) {
        break label1609;
      }
      ae.i("MicroMsg.VideoTimeLineItem", "ad fillItem, videoItem, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
      label121:
      if (!d.eir().aCy(paramTimeLineObject.Id)) {
        break label2909;
      }
    }
    label463:
    label1371:
    label2909:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.APh = paramTimeLineObject.Id;
      this.APi = paramBaseViewHolder.AKJ.zWJ;
      com.tencent.mm.plugin.sns.model.g localg = ah.dXB();
      if (!parambi.AfT)
      {
        paramBaseViewHolder.AKJ.AnH.setOnSightCompletionAction(null);
        paramBaseViewHolder.AKJ.AnH.setOnCompletionListener(null);
        paramBaseViewHolder.AKJ.AnH.setOnDecodeDurationListener(null);
        if (paramBaseViewHolder.AKJ.AnI != null) {
          paramBaseViewHolder.AKJ.AnI.setVideoCallback(null);
        }
      }
      paramBaseViewHolder.AKJ.AnH.setIsAdVideo(parambi.AfT);
      if ((paramBaseViewHolder.AKJ.AnF != null) && (!bu.lX(paramBaseViewHolder.AKJ.AnF.Id, paramTimeLineObject.Id)))
      {
        ae.i("MicroMsg.VideoTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.AKJ.AnF.Id });
        localg.a(paramBaseViewHolder.AKJ.AnH, this.mActivity.hashCode(), 0);
        a(paramBaseViewHolder, localg, 0);
      }
      paramBaseViewHolder.AKJ.a(paramTimeLineObject, paramInt1, parambi.AhK, parambi.AfT);
      paramBaseViewHolder.AKJ.zWK.setVisibility(8);
      long l;
      Object localObject2;
      Object localObject3;
      Object localObject1;
      int i;
      float f2;
      float f1;
      if ((paramTimeLineObject.HUG != null) && (paramTimeLineObject.HUG.Gtx.size() > 0))
      {
        l = System.nanoTime();
        boolean bool2 = com.tencent.mm.plugin.sns.model.g.t(localbzh);
        ae.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
        if (!bool2) {
          if (localg.w(localbzh))
          {
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.AKJ.AnK.setVisibility(0);
            paramBaseViewHolder.AKJ.AnK.fPL();
            if ((!parambi.AfT) || (!k.d(paramBaseViewHolder.timeLineObject))) {
              break label2250;
            }
            paramInt2 = 1;
            localObject2 = h.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.AKJ.AnH.getUIContext(), false);
            localObject3 = new StringBuilder("isVerticalAdVideo=true, snsId=");
            if (parambi.zlW != null) {
              break label2235;
            }
            localObject1 = "";
            ae.i("MicroMsg.VideoTimeLineItem", localObject1 + ", showW=" + ((Pair)localObject2).first + ", showH=" + ((Pair)localObject2).second);
            localObject1 = localObject2;
            if (parambi.AfT)
            {
              localObject3 = parambi.zlW.dVj();
              i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject1 = localObject2;
                if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zNt > 0.0F)
                {
                  localObject1 = localObject2;
                  if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zNu > 0.0F)
                  {
                    f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).zNt, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNv, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNw);
                    f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).zNu, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNv, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNw);
                    if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zNs != 0) {
                      break label2279;
                    }
                    if (f2 < i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12)) {
                      break label2906;
                    }
                    f2 = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
                    f1 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject3).zNu * f2 / ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNt);
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = Pair.create(Integer.valueOf((int)f2), Integer.valueOf((int)f1));
        i = ((Integer)((Pair)localObject1).first).intValue();
        int j = ((Integer)((Pair)localObject1).second).intValue();
        if ((paramBaseViewHolder.AKJ.AnH instanceof SightPlayImageView))
        {
          if (!parambi.AfT)
          {
            paramBaseViewHolder.AKJ.AnH.setScaleMode(1);
            paramBaseViewHolder.AKJ.AnH.setScaleType(QImageView.a.Lpz);
          }
        }
        else
        {
          label880:
          paramBaseViewHolder.AKJ.AnH.hy(i, j);
          if ((paramBaseViewHolder != null) && (paramBaseViewHolder.AKJ != null)) {
            break label2538;
          }
          if ((paramBaseViewHolder.AKJ.AnH instanceof SightPlayImageView))
          {
            if (paramInt2 == 0) {
              break label2555;
            }
            paramBaseViewHolder.AKJ.AnH.ziI = true;
          }
          if (!dVx()) {
            break label2569;
          }
          a(paramBaseViewHolder, true);
          paramBaseViewHolder.AKJ.AnH.setVisibility(8);
          localObject2 = paramBaseViewHolder.AKJ.AnL.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = i;
          ((ViewGroup.LayoutParams)localObject2).height = j;
          paramBaseViewHolder.AKJ.AnL.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = (FrameLayout)paramBaseViewHolder.AKJ.AnG.findViewById(2131305105);
          localObject3 = (FrameLayout.LayoutParams)((FrameLayout)localObject1).getLayoutParams();
          ((FrameLayout.LayoutParams)localObject3).width = i;
          ((FrameLayout.LayoutParams)localObject3).height = j;
          ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = paramBaseViewHolder.AKJ.AnG.findViewById(2131305799);
          ((View)localObject3).setLayoutParams(new FrameLayout.LayoutParams((ViewGroup.LayoutParams)localObject2));
          ((View)localObject3).setVisibility(4);
          this.APg = ((View)localObject1);
          localObject2 = d.eir().aCB(paramTimeLineObject.Id);
          ae.i("MicroMsg.VideoTimeLineItem", "lxl fill itemview check videoView reAttach, tlObjId:%s, vv:%s, count:%s", new Object[] { paramTimeLineObject.Id, localObject2, Integer.valueOf(((FrameLayout)localObject1).getChildCount()) });
          if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof ImageView)))
          {
            ((FrameLayout)localObject1).removeAllViews();
            ae.i("MicroMsg.VideoTimeLineItem", "find thumbView thne remove it %s", new Object[] { paramTimeLineObject.Id });
          }
          if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof SnsTimelineVideoView)))
          {
            localObject3 = (SnsTimelineVideoView)((FrameLayout)localObject1).getChildAt(0);
            if (!paramTimeLineObject.Id.equals(((SnsTimelineVideoView)localObject3).ASs))
            {
              ((FrameLayout)localObject1).removeAllViews();
              ae.i("MicroMsg.VideoTimeLineItem", "find diff id then remove it %s %s", new Object[] { paramTimeLineObject.Id, ((SnsTimelineVideoView)localObject3).ASs });
            }
          }
          if ((localObject2 == null) || (((FrameLayout)localObject1).getChildCount() != 0)) {
            break label2588;
          }
          if ((((SnsTimelineVideoView)localObject2).getParent() != null) && (((SnsTimelineVideoView)localObject2).getParent() != localObject1))
          {
            ((SnsTimelineVideoView)localObject2).ASw = true;
            ((ViewGroup)((SnsTimelineVideoView)localObject2).getParent()).removeView((View)localObject2);
            ((SnsTimelineVideoView)localObject2).setVisibility(0);
            ((SnsTimelineVideoView)localObject2).setVideoScaleType(i.e.Flk);
            ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
            ae.i("MicroMsg.VideoTimeLineItem", "lxl reAttach succ");
          }
          if (localObject2 != null)
          {
            localObject1 = paramBaseViewHolder.dqc;
            if (paramBaseViewHolder.timeLineObject != null) {
              break label2653;
            }
            paramInt2 = 0;
            ((SnsTimelineVideoView)localObject2).a(localbzh, (String)localObject1, paramInt2);
          }
          if (!dVx()) {
            break label2734;
          }
          if ((paramBaseViewHolder != null) && (paramBaseViewHolder.AKJ != null) && (paramBaseViewHolder.AKJ.AnI != null) && (localg != null) && (parambi != null) && (localbzh != null) && (paramTimeLineObject != null)) {
            break label2665;
          }
          paramBaseViewHolder.AKJ.AnJ.setTag(paramBaseViewHolder.AKJ);
          paramTimeLineObject = ap.jv(ah.getAccSnsPath(), localbzh.Id);
          localObject1 = r.i(localbzh);
          if (!o.fB(paramTimeLineObject + (String)localObject1)) {
            break label2812;
          }
          parambh.AAQ.Agi.D(parambi.ADP, true);
          label1505:
          if (!parambi.AfT) {
            break label2837;
          }
          if (ah.dXB().b(parambi.zlW, null) != 5) {
            break label2831;
          }
          bool1 = true;
          label1530:
          parambh.AAQ.Agi.c(parambi.ADP, bool1, false);
        }
        for (;;)
        {
          if ((parambi.zlW != null) && (!parambi.zlW.dZA())) {
            parambh.egu().c(paramBaseViewHolder.AKJ.AnJ, parambh.zGs.AQc, parambh.zGs.APL);
          }
          AppMethodBeat.o(100126);
          return;
          localbzh = null;
          break;
          ae.i("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", new Object[] { Integer.valueOf(paramInt1) });
          break label121;
          if ((parambi.AfT) && (localg.b(parambi.zlW, null) == 5))
          {
            localg.A(localbzh);
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.AKJ.AnK.setVisibility(0);
            paramBaseViewHolder.AKJ.AnK.fPL();
            break label463;
          }
          if (localg.x(localbzh))
          {
            paramBaseViewHolder.AKJ.AnK.setVisibility(8);
            paramBaseViewHolder.AKJ.zWJ.setImageResource(2131691612);
            a(paramBaseViewHolder, 0, bool1);
            break label463;
          }
          localg.y(localbzh);
          a(paramBaseViewHolder, 0, bool1);
          paramBaseViewHolder.AKJ.AnK.setVisibility(8);
          paramBaseViewHolder.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
          paramBaseViewHolder.AKJ.zWJ.setContentDescription(this.mActivity.getString(2131761939));
          if ((!parambi.AfT) && (localg.a(parambi.zlW, null) == 4))
          {
            paramBaseViewHolder.AKJ.zWK.setVisibility(0);
            break label463;
          }
          if ((!parambi.AfT) || (localg.b(parambi.zlW, null) != 4)) {
            break label463;
          }
          paramBaseViewHolder.AKJ.zWK.setVisibility(0);
          break label463;
          if (localg.u(localbzh))
          {
            a(paramBaseViewHolder, 0, bool1);
            paramBaseViewHolder.AKJ.AnK.setVisibility(8);
            paramBaseViewHolder.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
            paramBaseViewHolder.AKJ.zWJ.setContentDescription(this.mActivity.getString(2131761939));
          }
          for (;;)
          {
            if (!paramBaseViewHolder.AKJ.AnH.ziA.dTA()) {
              break label2233;
            }
            ae.e("MicroMsg.VideoTimeLineItem", "play video error " + localbzh.Id + " " + localbzh.Url + " " + localbzh.Hmj + " " + paramInt1);
            localg.y(localbzh);
            a(paramBaseViewHolder, 0, bool1);
            paramBaseViewHolder.AKJ.AnK.setVisibility(8);
            paramBaseViewHolder.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
            paramBaseViewHolder.AKJ.zWJ.setContentDescription(this.mActivity.getString(2131761939));
            break;
            if (localg.v(localbzh))
            {
              a(paramBaseViewHolder, 8, bool1);
              paramBaseViewHolder.AKJ.AnK.setVisibility(8);
            }
            else if ((parambi.AfT) && (localg.b(parambi.zlW, null) <= 5))
            {
              if (!this.APc)
              {
                ae.i("MicroMsg.VideoTimeLineItem", "fillItem, showPlayBtn");
                ehN();
              }
            }
            else
            {
              localg.y(localbzh);
              a(paramBaseViewHolder, 0, bool1);
              paramBaseViewHolder.AKJ.AnK.setVisibility(8);
              paramBaseViewHolder.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
              paramBaseViewHolder.AKJ.zWJ.setContentDescription(this.mActivity.getString(2131761939));
            }
          }
          break label463;
          localObject1 = Long.valueOf(parambi.zlW.field_snsId);
          break label526;
          localObject2 = h.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.AKJ.AnH.getUIContext(), parambi.AfT);
          paramInt2 = 0;
          break label569;
          label2279:
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zNs == 1)
          {
            i = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
            localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNu / ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNt)));
            paramBaseViewHolder.AMp.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
            break label810;
          }
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zNs != 2) {
            break label810;
          }
          i = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
          localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNu / ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNt)));
          paramBaseViewHolder.AMp.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
          break label810;
          if (paramInt2 != 0)
          {
            paramBaseViewHolder.AKJ.AnH.setScaleMode(1);
            paramBaseViewHolder.AKJ.AnH.setScaleType(QImageView.a.Lpz);
            break label880;
          }
          paramBaseViewHolder.AKJ.AnH.setScaleMode(0);
          paramBaseViewHolder.AKJ.AnH.setScaleType(QImageView.a.Lpu);
          break label880;
          label2538:
          com.tencent.mm.plugin.sns.ad.timeline.a.e.a(paramBaseViewHolder.AKJ.AnI, i, j);
          break label905;
          label2555:
          paramBaseViewHolder.AKJ.AnH.setDrawWidthAndHeightFix(false);
          break label934;
          a(paramBaseViewHolder, false);
          paramBaseViewHolder.AKJ.AnH.setVisibility(0);
          break label958;
          if ((bool1) || (((FrameLayout)localObject1).getChildCount() <= 0) || (d.eir().aCz(paramTimeLineObject.Id))) {
            break label1350;
          }
          l = System.currentTimeMillis();
          ((FrameLayout)localObject1).removeViewAt(0);
          ae.i("MicroMsg.VideoTimeLineItem", "lxl item remove videoview cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          break label1350;
          label2653:
          paramInt2 = paramBaseViewHolder.timeLineObject.CreateTime;
          break label1371;
          label2665:
          paramBaseViewHolder.AKJ.AnI.setTag(paramBaseViewHolder.AKJ);
          localObject1 = paramBaseViewHolder.AKJ.AnI;
          localObject2 = parambi.zlW;
          localObject3 = this.mActivity;
          bk localbk = bk.fvn();
          localbk.heF = paramTimeLineObject.CreateTime;
          com.tencent.mm.plugin.sns.ad.timeline.a.e.a((SnsAdTimelineVideoView)localObject1, localg, (p)localObject2, (Activity)localObject3, localbzh, paramInt1, localbk);
          break label1429;
          paramBaseViewHolder.AKJ.AnH.setTagObject(paramBaseViewHolder.AKJ);
          localObject1 = parambi.zlW;
          localObject2 = paramBaseViewHolder.AKJ.AnH;
          paramInt2 = this.mActivity.hashCode();
          localObject3 = bk.fvn();
          ((bk)localObject3).heF = paramTimeLineObject.CreateTime;
          localg.a((p)localObject1, localbzh, (VideoSightView)localObject2, paramInt2, paramInt1, (bk)localObject3, parambi.AfT, true);
          break label1429;
          label2812:
          parambh.AAQ.Agi.D(parambi.ADP, false);
          break label1505;
          bool1 = false;
          break label1530;
          if (ah.dXB().a(parambi.zlW, null) == 5)
          {
            bool1 = true;
            break label1530;
          }
          bool1 = false;
          break label1530;
          if (dVx()) {
            a(paramBaseViewHolder, localg, paramInt1);
          } else {
            localg.a(paramBaseViewHolder.AKJ.AnH, this.mActivity.hashCode(), paramInt1);
          }
        }
      }
    }
  }
  
  protected boolean dVx()
  {
    AppMethodBeat.i(220105);
    boolean bool2 = false;
    p localp = this.zlW;
    boolean bool1 = bool2;
    if (this.APd)
    {
      bool1 = bool2;
      if (localp != null)
      {
        bool1 = bool2;
        if (localp.Rt(32)) {
          bool1 = true;
        }
      }
    }
    ae.i("MicroMsg.VideoTimeLineItem", "the useNewPlayer return value is ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(220105);
    return bool1;
  }
  
  public final void ehN()
  {
    AppMethodBeat.i(176430);
    ae.i("MicroMsg.VideoTimeLineItem", "try show play btn");
    if ((this.APf != null) && (this.APf.AKJ != null) && (!this.ANI))
    {
      ae.i("MicroMsg.VideoTimeLineItem", "show play btn");
      this.APf.AKJ.zWJ.setVisibility(0);
      this.APf.AKJ.AnK.setVisibility(8);
      this.APf.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
      this.APf.AKJ.zWJ.setContentDescription(this.mActivity.getString(2131761939));
    }
    AppMethodBeat.o(176430);
  }
  
  protected final void ehP()
  {
    AppMethodBeat.i(220100);
    ae.i("MicroMsg.VideoTimeLineItem", "try hide play btn");
    if ((this.APf != null) && (this.APf.AKJ != null))
    {
      ae.i("MicroMsg.VideoTimeLineItem", "hide play btn");
      this.APf.AKJ.zWJ.setVisibility(8);
      this.APf.AKJ.AnK.setVisibility(8);
    }
    AppMethodBeat.o(220100);
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(100129);
    if (this.APg != null)
    {
      Object localObject = new int[2];
      this.APg.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.APg.getMeasuredWidth() + i, this.APg.getMeasuredHeight() + j);
      AppMethodBeat.o(100129);
      return localObject;
    }
    AppMethodBeat.o(100129);
    return null;
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100125);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.APd = com.tencent.mm.plugin.sns.ad.timeline.a.e.dVw();
    this.mScreenWidth = ((DisplayMetrics)localObject).widthPixels;
    this.mScreenHeight = ((DisplayMetrics)localObject).heightPixels;
    this.APf = paramBaseViewHolder;
    if (paramBaseViewHolder.AMs != null)
    {
      paramBaseViewHolder.AMs.setLayoutResource(2131495566);
      paramBaseViewHolder.ANk = ((ViewStub)paramBaseViewHolder.uan.findViewById(2131300969));
      if (!paramBaseViewHolder.ANl)
      {
        paramBaseViewHolder.AKJ.AnG = paramBaseViewHolder.ANk.inflate();
        paramBaseViewHolder.ANl = true;
      }
      paramBaseViewHolder.AKJ.AnJ = paramBaseViewHolder.AKJ.AnG.findViewById(2131298069);
      paramBaseViewHolder.AKJ.AnH = ((VideoSightView)paramBaseViewHolder.AKJ.AnG.findViewById(2131300914));
      paramBaseViewHolder.AKJ.AnH.setMute(true);
      if ((paramBaseViewHolder != null) && (paramBaseViewHolder.AKJ != null)) {
        break label383;
      }
    }
    for (;;)
    {
      paramBaseViewHolder.AKJ.AnJ.setOnClickListener(this.ALv);
      paramBaseViewHolder.AKJ.zWJ = ((ImageView)paramBaseViewHolder.AKJ.AnG.findViewById(2131305196));
      paramBaseViewHolder.AKJ.AnK = ((MMPinProgressBtn)paramBaseViewHolder.AKJ.AnG.findViewById(2131303515));
      paramBaseViewHolder.AKJ.AnL = ((TextView)paramBaseViewHolder.AKJ.AnG.findViewById(2131299492));
      paramBaseViewHolder.AKJ.zWK = ((TextView)paramBaseViewHolder.AKJ.AnG.findViewById(2131299517));
      com.tencent.mm.kernel.g.ajS();
      if (((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(344065, Boolean.FALSE)).booleanValue())
      {
        localObject = (TextView)((ViewStub)paramBaseViewHolder.AKJ.AnG.findViewById(2131304813)).inflate();
        paramBaseViewHolder.AKJ.AnH.setSightInfoView((TextView)localObject);
      }
      AppMethodBeat.o(100125);
      return;
      paramBaseViewHolder.AKJ.AnG = paramBaseViewHolder.uan.findViewById(2131305005);
      paramBaseViewHolder.ANl = true;
      break;
      label383:
      paramBaseViewHolder.AKJ.AnI = ((SnsAdTimelineVideoView)paramBaseViewHolder.AKJ.AnG.findViewById(2131308163));
      com.tencent.mm.plugin.sns.ad.timeline.a.e.a(paramBaseViewHolder.AKJ.AnI);
    }
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177697);
    ae.i("MicroMsg.VideoTimeLineItem", "onUIPause");
    ehQ();
    AppMethodBeat.o(177697);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176432);
    ae.i("MicroMsg.VideoTimeLineItem", "pause");
    ehQ();
    ehN();
    AppMethodBeat.o(176432);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176433);
    ae.i("MicroMsg.VideoTimeLineItem", "%s Ad Video stop", new Object[] { this });
    Object localObject;
    if ((this.APf != null) && (this.APf.AKJ != null))
    {
      if (!dVx()) {
        break label110;
      }
      localObject = this.APf;
      ae.d("MicroMsg.VideoTimeLineItem", "newPlayerClear is called");
      if ((localObject != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).AKJ != null)) {
        break label82;
      }
    }
    for (;;)
    {
      this.ANI = false;
      AppMethodBeat.o(176433);
      return;
      label82:
      localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).AKJ.AnI;
      ae.d("NormalVideoAdHelper", "clear is called");
      if (localObject != null)
      {
        ((SnsAdTimelineVideoView)localObject).clear();
        continue;
        label110:
        this.APf.AKJ.AnH.ziA.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.n
 * JD-Core Version:    0.7.0.1
 */