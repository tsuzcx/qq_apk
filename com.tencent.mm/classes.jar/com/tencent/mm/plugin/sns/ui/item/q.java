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
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.timeline.b.f;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;

public class q
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private SnsInfo DqO;
  private View.OnClickListener EVA;
  private boolean EXV;
  private boolean EZH;
  private boolean EZI;
  private b.e EZJ;
  private BaseTimeLineItem.BaseViewHolder EZK;
  View EZL;
  private String EZM;
  View EZN;
  private boolean EZO;
  private int mScreenHeight;
  private int mScreenWidth;
  
  public q()
  {
    AppMethodBeat.i(100124);
    this.EZH = false;
    this.EZI = false;
    this.EZJ = new b.e()
    {
      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt) {}
    };
    this.EZL = null;
    this.EZM = "";
    this.EZN = null;
    this.EZO = false;
    this.EVA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203939);
        Log.i("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick");
        try
        {
          if (q.this.DQX.EKl.ffo() == 0) {
            q.this.DQX.DQs.FaQ.onClick(paramAnonymousView);
          }
          for (;;)
          {
            q.b(q.this);
            AppMethodBeat.o(203939);
            return;
            if (q.this.DQX.EKl.ffo() == 1) {
              q.this.DQX.DQs.FaQ.onClick(paramAnonymousView);
            }
          }
          return;
        }
        catch (Exception paramAnonymousView)
        {
          Log.e("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(203939);
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
    paramBaseViewHolder.EUK.EeS.setVisibility(paramInt);
    AppMethodBeat.o(100127);
  }
  
  private void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, com.tencent.mm.plugin.sns.model.g paramg, int paramInt)
  {
    AppMethodBeat.i(203944);
    Log.d("MicroMsg.VideoTimeLineItem", "cleanNewPlayerSnsSight is called, the position is ".concat(String.valueOf(paramInt)));
    if ((paramBaseViewHolder == null) || (paramBaseViewHolder.EUK == null) || (paramg == null))
    {
      AppMethodBeat.o(203944);
      return;
    }
    f.a(paramBaseViewHolder.EUK.Ewt, paramg, this.mActivity, paramInt);
    AppMethodBeat.o(203944);
  }
  
  private static void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, boolean paramBoolean)
  {
    AppMethodBeat.i(203942);
    if ((paramBaseViewHolder == null) || (paramBaseViewHolder.EUK == null))
    {
      AppMethodBeat.o(203942);
      return;
    }
    f.a(paramBaseViewHolder.EUK.Ewt, paramBoolean);
    AppMethodBeat.o(203942);
  }
  
  private void ab(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(203941);
    if ((this.DQX != null) && (this.DQX.EKl != null) && (this.DQX.EKl.EoE != null) && (paramSnsInfo != null)) {
      this.DQX.EKl.EoE.IU(paramSnsInfo.field_snsId);
    }
    AppMethodBeat.o(203941);
  }
  
  private void doPause()
  {
    AppMethodBeat.i(177698);
    Log.i("MicroMsg.VideoTimeLineItem", "%s Ad Video doPause", new Object[] { this });
    if ((this.EZK != null) && (this.EZK.EUK != null))
    {
      if (!eXX()) {
        break label73;
      }
      m(this.EZK);
    }
    for (;;)
    {
      ab(this.DqO);
      this.EXV = false;
      AppMethodBeat.o(177698);
      return;
      label73:
      this.EZK.EUK.Ews.pause();
    }
  }
  
  private static void m(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(203943);
    if ((paramBaseViewHolder == null) || (paramBaseViewHolder.EUK == null))
    {
      AppMethodBeat.o(203943);
      return;
    }
    f.c(paramBaseViewHolder.EUK.Ewt);
    AppMethodBeat.o(203943);
  }
  
  public void a(final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176431);
    Object localObject2 = aj.faO().aQm(paramBaseViewHolder.dHp);
    if (localObject2 == null)
    {
      Log.w("MicroMsg.VideoTimeLineItem", "play error, snsId:%s", new Object[] { paramBaseViewHolder.dHp });
      AppMethodBeat.o(176431);
      return;
    }
    TimeLineObject localTimeLineObject = ((SnsInfo)localObject2).getTimeLine();
    if ((localTimeLineObject.ContentObj != null) && (localTimeLineObject.ContentObj.LoV.size() > 0)) {}
    for (Object localObject1 = (cnb)localTimeLineObject.ContentObj.LoV.get(0); localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(176431);
      return;
    }
    if (((SnsInfo)localObject2).isAd())
    {
      Log.i("MicroMsg.VideoTimeLineItem", "%s Ad autoPlay", new Object[] { this });
      final long l = ((SnsInfo)localObject2).field_snsId;
      if (!this.EZO)
      {
        this.EZO = true;
        paramBaseViewHolder.EUK.Ews.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(100121);
            if (paramAnonymousInt != -1)
            {
              if ((this.DxI == null) || (!this.DxI.isAd()))
              {
                Log.e("MicroMsg.VideoTimeLineItem", "onCompletion, !isAd,  snsId=" + com.tencent.mm.plugin.sns.data.r.Jb(l));
                AppMethodBeat.o(100121);
                return;
              }
              if ((q.this.DQX == null) || (q.this.DQX.EKl == null) || (q.this.DQX.EKl.EoE == null))
              {
                AppMethodBeat.o(100121);
                return;
              }
              q.this.DQX.EKl.EoE.I(l, false);
              Log.d("MicroMsg.VideoTimeLineItem", "onCompletion, retCode=" + paramAnonymousInt + ", snsId=" + com.tencent.mm.plugin.sns.data.r.Jb(l));
            }
            AppMethodBeat.o(100121);
          }
        });
        paramBaseViewHolder.EUK.Ews.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(100122);
            if ((this.DxI == null) || (!this.DxI.isAd()))
            {
              Log.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, !isAd, currentTime=" + paramAnonymousLong + ", snsId=" + com.tencent.mm.plugin.sns.data.r.Jb(l));
              AppMethodBeat.o(100122);
              return;
            }
            if ((q.this.DQX == null) || (q.this.DQX.EKl == null) || (q.this.DQX.EKl.EoE == null))
            {
              AppMethodBeat.o(100122);
              return;
            }
            if (this.DxI != null)
            {
              q.this.DQX.EKl.EoE.IT(this.DxI.field_snsId);
              q.this.DQX.EKl.EoE.ao(this.DxI.field_snsId, 1000L * paramAnonymousLong);
            }
            if (!q.this.DQX.EKl.EoE.IQ(l))
            {
              int i = (int)paramAnonymousb.eVC();
              q.this.DQX.EKl.EoE.c(l, Util.currentTicks(), false);
              q.this.DQX.EKl.EoE.e(l, i, false);
              q.this.DQX.EKl.EoE.an(l, l);
              Log.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, addPlay3s, snsId=" + com.tencent.mm.plugin.sns.data.r.Jb(l));
            }
            Log.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, currentTime=" + paramAnonymousLong + ", snsId=" + com.tencent.mm.plugin.sns.data.r.Jb(l));
            AppMethodBeat.o(100122);
          }
        });
        paramBaseViewHolder.EUK.Ewt.setVideoCallback(new OfflineVideoView.a()
        {
          public final boolean a(PString paramAnonymousPString)
          {
            return false;
          }
          
          public final void onCompletion()
          {
            AppMethodBeat.i(203936);
            paramBaseViewHolder.EUK.Ewt.restart();
            q.a(q.this, paramBaseViewHolder, this.DxI);
            AppMethodBeat.o(203936);
          }
          
          public final void onStart(int paramAnonymousInt)
          {
            AppMethodBeat.i(203935);
            Log.d("MicroMsg.VideoTimeLineItem", "onStart is called , the duration second is ".concat(String.valueOf(paramAnonymousInt)));
            AppMethodBeat.o(203935);
          }
          
          public final void xv(int paramAnonymousInt)
          {
            AppMethodBeat.i(203937);
            long l = paramBaseViewHolder.EUK.Ewt.getDurationMs();
            q.a(q.this, paramBaseViewHolder, this.DxI, paramAnonymousInt, l);
            AppMethodBeat.o(203937);
          }
        });
        d.fkS().cXa();
        com.tencent.mm.plugin.sns.ui.video.b.fkM().a(this);
        if (!eXX()) {
          break label299;
        }
        paramBaseViewHolder = this.EZK;
        if ((paramBaseViewHolder != null) && (paramBaseViewHolder.EUK != null)) {
          break label286;
        }
      }
      for (;;)
      {
        eYc();
        this.EXV = true;
        this.EZH = false;
        AppMethodBeat.o(176431);
        return;
        Log.d("MicroMsg.VideoTimeLineItem", "play, hasSetListener=true");
        break;
        label286:
        f.b(paramBaseViewHolder.EUK.Ewt);
        continue;
        label299:
        this.EZK.EUK.Ews.start();
      }
    }
    com.tencent.mm.plugin.sns.ui.video.b.fkM().pause();
    com.tencent.mm.plugin.sns.ui.video.c localc = new com.tencent.mm.plugin.sns.ui.video.c();
    localc.ebR = ((cnb)localObject1);
    localc.dHp = paramBaseViewHolder.dHp;
    localc.dRS = com.tencent.mm.plugin.sns.data.r.Jb(((SnsInfo)localObject2).field_snsId);
    localObject1 = aj.faO().aQl(paramBaseViewHolder.dRS);
    if (localObject1 != null)
    {
      localc.iXu = ((SnsInfo)localObject1).getCreateTime();
      localObject2 = (FrameLayout)paramBaseViewHolder.EUK.Ewr.findViewById(2131308264);
      if (((FrameLayout)localObject2).getChildCount() <= 0) {
        break label752;
      }
    }
    label752:
    for (localObject1 = (SnsTimelineVideoView)((FrameLayout)localObject2).getChildAt(0);; localObject1 = null)
    {
      if ((localObject1 != null) && (((SnsTimelineVideoView)localObject1).FcY != null) && (!((SnsTimelineVideoView)localObject1).Fdb) && (Util.isEqual(localTimeLineObject.Id, ((SnsTimelineVideoView)localObject1).FcZ)) && (Util.isEqual(((SnsTimelineVideoView)localObject1).FcY.ebR.Id, localc.ebR.Id))) {
        Log.i("MicroMsg.VideoTimeLineItem", "reuse videoview:%s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
      }
      for (;;)
      {
        ((SnsTimelineVideoView)localObject1).setVisibility(0);
        ((SnsTimelineVideoView)localObject1).setVideoScaleType(i.e.Kcc);
        paramBaseViewHolder.EUK.Ewr.findViewById(2131309074).setVisibility(8);
        if (paramBaseViewHolder.EUK.EeS != null) {
          paramBaseViewHolder.EUK.EeS.setVisibility(8);
        }
        ((SnsTimelineVideoView)localObject1).setUICallback(new SnsTimelineVideoView.b()
        {
          public final void Zl(String paramAnonymousString)
          {
            AppMethodBeat.i(203938);
            Log.i("MicroMsg.VideoTimeLineItem", "onDestroy UICallback %s, %s", new Object[] { paramAnonymousString, q.a(q.this) });
            if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(q.a(q.this))) && (q.this.EZN != null))
            {
              q.this.EZN.setVisibility(0);
              Log.i("MicroMsg.VideoTimeLineItem", "onDestroy show videoStatusIv");
            }
            AppMethodBeat.o(203938);
          }
        });
        ((SnsTimelineVideoView)localObject1).setVideoCallback(null);
        d.fkS().a((OnlineVideoView)localObject1, localc, localTimeLineObject.Id);
        AppMethodBeat.o(176431);
        return;
        localc.iXu = ((int)(System.currentTimeMillis() / 1000L));
        break;
        d.fkS();
        if ((d.gcR()) && (localObject1 != null) && (((SnsTimelineVideoView)localObject1).FcY == null))
        {
          Log.i("MicroMsg.VideoTimeLineItem", "reuse videoview by precreate View:%s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
        }
        else
        {
          if (localObject1 != null) {
            ((FrameLayout)localObject2).removeViewAt(0);
          }
          localObject1 = d.fkS().hd(((FrameLayout)localObject2).getContext());
          if (((SnsTimelineVideoView)localObject1).getParent() != null)
          {
            ((SnsTimelineVideoView)localObject1).fkQ();
            ((SnsTimelineVideoView)localObject1).Fdc = true;
            ((ViewGroup)((SnsTimelineVideoView)localObject1).getParent()).removeView((View)localObject1);
          }
          ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
          ((SnsTimelineVideoView)localObject1).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        }
      }
    }
  }
  
  public void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(100126);
    this.DqO = parambl.DqO;
    cnb localcnb;
    if ((paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.LoV.size() > 0))
    {
      localcnb = (cnb)paramTimeLineObject.ContentObj.LoV.get(0);
      if ((this.DqO == null) || (!this.DqO.isAd())) {
        break label1702;
      }
      Log.i("MicroMsg.VideoTimeLineItem", "ad fillItem, videoItem, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
      label119:
      if (!d.fkS().aRu(paramTimeLineObject.Id)) {
        break label3118;
      }
    }
    label521:
    label544:
    label934:
    label3118:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.EZM = paramTimeLineObject.Id;
      this.EZN = paramBaseViewHolder.EUK.EeS;
      com.tencent.mm.plugin.sns.model.g localg = aj.faL();
      if (!parambl.Eoq)
      {
        paramBaseViewHolder.EUK.Ews.setOnSightCompletionAction(null);
        paramBaseViewHolder.EUK.Ews.setOnCompletionListener(null);
        paramBaseViewHolder.EUK.Ews.setOnDecodeDurationListener(null);
        if (paramBaseViewHolder.EUK.Ewt != null) {
          paramBaseViewHolder.EUK.Ewt.setVideoCallback(null);
        }
      }
      paramBaseViewHolder.EUK.Ews.setIsAdVideo(parambl.Eoq);
      if ((paramBaseViewHolder.EUK.Ewq != null) && (!Util.isEqual(paramBaseViewHolder.EUK.Ewq.Id, paramTimeLineObject.Id)))
      {
        Log.i("MicroMsg.VideoTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.EUK.Ewq.Id });
        localg.a(paramBaseViewHolder.EUK.Ews, this.mActivity.hashCode(), 0);
        a(paramBaseViewHolder, localg, 0);
      }
      paramBaseViewHolder.EUK.a(paramTimeLineObject, paramInt1, parambl.Eql, parambl.Eoq);
      paramBaseViewHolder.EUK.EeT.setVisibility(8);
      long l;
      label461:
      Object localObject1;
      Object localObject3;
      Object localObject2;
      label594:
      int i;
      label839:
      int j;
      if ((paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.LoV.size() > 0))
      {
        l = System.nanoTime();
        boolean bool2 = com.tencent.mm.plugin.sns.model.g.u(localcnb);
        Log.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
        if (!bool2) {
          if (localg.x(localcnb))
          {
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.EUK.Ewv.setVisibility(0);
            paramBaseViewHolder.EUK.Ewv.gYN();
            if ((!parambl.Eoq) || (!com.tencent.mm.plugin.sns.data.k.d(paramBaseViewHolder.timeLineObject))) {
              break label2366;
            }
            paramInt2 = 0;
            if (this.DqO != null) {
              paramInt2 = this.DqO.getAdXml().verticalVideoDisplayType;
            }
            if (paramInt2 != 1) {
              break label2328;
            }
            localObject1 = com.tencent.mm.modelsns.n.df(paramBaseViewHolder.EUK.Ews.getUIContext());
            localObject3 = new StringBuilder("isVerticalAdVideo=true, snsId=");
            if (parambl.DqO != null) {
              break label2351;
            }
            localObject2 = "";
            Log.i("MicroMsg.VideoTimeLineItem", localObject2 + ", showW=" + ((Pair)localObject1).first + ", showH=" + ((Pair)localObject1).second);
            paramInt2 = 1;
            localObject2 = localObject1;
            localObject1 = localObject2;
            if (parambl.Eoq)
            {
              localObject3 = parambl.DqO.getAdXml();
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
                    float f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((ADXml)localObject3).adMediaDisplayWidth, 1, ((ADXml)localObject3).adBasicRemWidth, ((ADXml)localObject3).adBasicRootFontSize);
                    float f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((ADXml)localObject3).adMediaDisplayHeight, 1, ((ADXml)localObject3).adBasicRemWidth, ((ADXml)localObject3).adBasicRootFontSize);
                    if (((ADXml)localObject3).adMediaDisplayMode != 0) {
                      break label2395;
                    }
                    float f1 = f3;
                    if (f3 >= i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12))
                    {
                      f1 = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
                      f2 = (int)(((ADXml)localObject3).adMediaDisplayHeight * f1 / ((ADXml)localObject3).adMediaDisplayWidth);
                    }
                    localObject1 = Pair.create(Integer.valueOf((int)f1), Integer.valueOf((int)f2));
                  }
                }
              }
            }
            i = ((Integer)((Pair)localObject1).first).intValue();
            j = ((Integer)((Pair)localObject1).second).intValue();
            if ((paramBaseViewHolder.EUK.Ews instanceof SightPlayImageView))
            {
              if (parambl.Eoq) {
                break label2595;
              }
              paramBaseViewHolder.EUK.Ews.setScaleMode(1);
              paramBaseViewHolder.EUK.Ews.setScaleType(QImageView.a.QEL);
            }
            paramBaseViewHolder.EUK.Ews.im(i, j);
            if ((paramBaseViewHolder != null) && (paramBaseViewHolder.EUK != null)) {
              break label2654;
            }
            if ((paramBaseViewHolder.EUK.Ews instanceof SightPlayImageView))
            {
              if (paramInt2 == 0) {
                break label2671;
              }
              paramBaseViewHolder.EUK.Ews.Dnz = true;
            }
            label963:
            if (!eXX()) {
              break label2685;
            }
            a(paramBaseViewHolder, true);
            paramBaseViewHolder.EUK.Ews.setVisibility(8);
            label987:
            localObject2 = paramBaseViewHolder.EUK.Eww.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject2).width = i;
            ((ViewGroup.LayoutParams)localObject2).height = j;
            paramBaseViewHolder.EUK.Eww.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localObject1 = (FrameLayout)paramBaseViewHolder.EUK.Ewr.findViewById(2131308264);
            localObject3 = (FrameLayout.LayoutParams)((FrameLayout)localObject1).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject3).width = i;
            ((FrameLayout.LayoutParams)localObject3).height = j;
            ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
            localObject3 = paramBaseViewHolder.EUK.Ewr.findViewById(2131309074);
            ((View)localObject3).setLayoutParams(new FrameLayout.LayoutParams((ViewGroup.LayoutParams)localObject2));
            ((View)localObject3).setVisibility(4);
            this.EZL = ((View)localObject1);
            localObject2 = d.fkS().aRx(paramTimeLineObject.Id);
            Log.i("MicroMsg.VideoTimeLineItem", "lxl fill itemview check videoView reAttach, tlObjId:%s, vv:%s, count:%s", new Object[] { paramTimeLineObject.Id, localObject2, Integer.valueOf(((FrameLayout)localObject1).getChildCount()) });
            if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof ImageView)))
            {
              ((FrameLayout)localObject1).removeAllViews();
              Log.i("MicroMsg.VideoTimeLineItem", "find thumbView thne remove it %s", new Object[] { paramTimeLineObject.Id });
            }
            if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof SnsTimelineVideoView)))
            {
              localObject3 = (SnsTimelineVideoView)((FrameLayout)localObject1).getChildAt(0);
              if (!paramTimeLineObject.Id.equals(((SnsTimelineVideoView)localObject3).FcZ))
              {
                ((FrameLayout)localObject1).removeAllViews();
                Log.i("MicroMsg.VideoTimeLineItem", "find diff id then remove it %s %s", new Object[] { paramTimeLineObject.Id, ((SnsTimelineVideoView)localObject3).FcZ });
              }
            }
            if ((localObject2 == null) || (((FrameLayout)localObject1).getChildCount() != 0)) {
              break label2704;
            }
            if ((((SnsTimelineVideoView)localObject2).getParent() != null) && (((SnsTimelineVideoView)localObject2).getParent() != localObject1))
            {
              ((SnsTimelineVideoView)localObject2).Fdc = true;
              ((ViewGroup)((SnsTimelineVideoView)localObject2).getParent()).removeView((View)localObject2);
              ((SnsTimelineVideoView)localObject2).setVisibility(0);
              ((SnsTimelineVideoView)localObject2).setVideoScaleType(i.e.Kcc);
              ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
              Log.i("MicroMsg.VideoTimeLineItem", "lxl reAttach succ");
            }
            label1379:
            if (localObject2 != null)
            {
              localObject1 = paramBaseViewHolder.dHp;
              if (paramBaseViewHolder.timeLineObject != null) {
                break label2769;
              }
              paramInt2 = 0;
              label1400:
              ((SnsTimelineVideoView)localObject2).a(localcnb, (String)localObject1, paramInt2);
            }
            if (!eXX()) {
              break label2850;
            }
            if ((paramBaseViewHolder != null) && (paramBaseViewHolder.EUK != null) && (paramBaseViewHolder.EUK.Ewt != null) && (localg != null) && (parambl != null) && (localcnb != null) && (paramTimeLineObject != null)) {
              break label2781;
            }
            label1458:
            paramBaseViewHolder.EUK.Ewu.setTag(paramBaseViewHolder.EUK);
            paramTimeLineObject = ar.ki(aj.getAccSnsPath(), localcnb.Id);
            localObject1 = com.tencent.mm.plugin.sns.data.r.j(localcnb);
            paramTimeLineObject = paramTimeLineObject + (String)localObject1;
            if (!s.YS(paramTimeLineObject)) {
              break label3018;
            }
            parambk.EKl.EoE.f(parambl.ENp, (int)localcnb.MsT, true);
            if ((com.tencent.mm.plugin.sns.ad.e.b.KB()) && (parambl.Eoq))
            {
              bool1 = com.tencent.mm.modelvideo.r.isH265Video(paramTimeLineObject);
              Log.i("MicroMsg.VideoTimeLineItem", "AdH265Helper, fileExists, isH265File=" + bool1 + ", path=" + paramTimeLineObject);
            }
            label1598:
            if (!parambl.Eoq) {
              break label3049;
            }
            if (aj.faL().b(parambl.DqO, null) != 5) {
              break label3043;
            }
            bool1 = true;
            label1623:
            parambk.EKl.EoE.d(parambl.ENp, bool1, false);
          }
        }
      }
      for (;;)
      {
        if ((parambl.DqO != null) && (!parambl.DqO.isCardAd())) {
          parambk.fiV().c(paramBaseViewHolder.EUK.Ewu, parambk.DQs.FaH, parambk.DQs.Far);
        }
        AppMethodBeat.o(100126);
        return;
        localcnb = null;
        break;
        Log.i("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", new Object[] { Integer.valueOf(paramInt1) });
        break label119;
        if ((parambl.Eoq) && (localg.b(parambl.DqO, null) == 5))
        {
          localg.B(localcnb);
          a(paramBaseViewHolder, 8, bool1);
          paramBaseViewHolder.EUK.Ewv.setVisibility(0);
          paramBaseViewHolder.EUK.Ewv.gYN();
          break label461;
        }
        if (localg.y(localcnb))
        {
          paramBaseViewHolder.EUK.Ewv.setVisibility(8);
          paramBaseViewHolder.EUK.EeS.setImageResource(2131691482);
          a(paramBaseViewHolder, 0, bool1);
          break label461;
        }
        localg.z(localcnb);
        a(paramBaseViewHolder, 0, bool1);
        paramBaseViewHolder.EUK.Ewv.setVisibility(8);
        paramBaseViewHolder.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
        paramBaseViewHolder.EUK.EeS.setContentDescription(this.mActivity.getString(2131763945));
        if ((!parambl.Eoq) && (localg.a(parambl.DqO, null) == 4))
        {
          paramBaseViewHolder.EUK.EeT.setVisibility(0);
          break label461;
        }
        if ((!parambl.Eoq) || (localg.b(parambl.DqO, null) != 4)) {
          break label461;
        }
        paramBaseViewHolder.EUK.EeT.setVisibility(0);
        break label461;
        if (localg.v(localcnb))
        {
          a(paramBaseViewHolder, 0, bool1);
          paramBaseViewHolder.EUK.Ewv.setVisibility(8);
          paramBaseViewHolder.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
          paramBaseViewHolder.EUK.EeS.setContentDescription(this.mActivity.getString(2131763945));
        }
        for (;;)
        {
          if (!paramBaseViewHolder.EUK.Ews.Dnr.eVz()) {
            break label2326;
          }
          Log.e("MicroMsg.VideoTimeLineItem", "play video error " + localcnb.Id + " " + localcnb.Url + " " + localcnb.Msz + " " + paramInt1);
          localg.z(localcnb);
          a(paramBaseViewHolder, 0, bool1);
          paramBaseViewHolder.EUK.Ewv.setVisibility(8);
          paramBaseViewHolder.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
          paramBaseViewHolder.EUK.EeS.setContentDescription(this.mActivity.getString(2131763945));
          break;
          if (localg.w(localcnb))
          {
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.EUK.Ewv.setVisibility(8);
          }
          else if ((parambl.Eoq) && (localg.b(parambl.DqO, null) <= 5))
          {
            if (!this.EZH)
            {
              Log.i("MicroMsg.VideoTimeLineItem", "fillItem, showPlayBtn");
              fkq();
            }
          }
          else
          {
            localg.z(localcnb);
            a(paramBaseViewHolder, 0, bool1);
            paramBaseViewHolder.EUK.Ewv.setVisibility(8);
            paramBaseViewHolder.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
            paramBaseViewHolder.EUK.EeS.setContentDescription(this.mActivity.getString(2131763945));
          }
        }
        break label461;
        localObject1 = com.tencent.mm.modelsns.n.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.EUK.Ews.getUIContext(), false);
        break label521;
        label2351:
        localObject2 = Long.valueOf(parambl.DqO.field_snsId);
        break label544;
        label2366:
        localObject2 = com.tencent.mm.modelsns.n.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.EUK.Ews.getUIContext(), parambl.Eoq);
        paramInt2 = 0;
        break label594;
        label2395:
        if (((ADXml)localObject3).adMediaDisplayMode == 1)
        {
          i = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
          localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((ADXml)localObject3).adMediaDisplayHeight / ((ADXml)localObject3).adMediaDisplayWidth)));
          paramBaseViewHolder.EWA.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
          break label839;
        }
        localObject1 = localObject2;
        if (((ADXml)localObject3).adMediaDisplayMode != 2) {
          break label839;
        }
        i = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
        localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((ADXml)localObject3).adMediaDisplayHeight / ((ADXml)localObject3).adMediaDisplayWidth)));
        paramBaseViewHolder.EWA.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
        break label839;
        if (paramInt2 != 0)
        {
          paramBaseViewHolder.EUK.Ews.setScaleMode(1);
          paramBaseViewHolder.EUK.Ews.setScaleType(QImageView.a.QEL);
          break label909;
        }
        paramBaseViewHolder.EUK.Ews.setScaleMode(0);
        paramBaseViewHolder.EUK.Ews.setScaleType(QImageView.a.QEG);
        break label909;
        label2654:
        f.a(paramBaseViewHolder.EUK.Ewt, i, j);
        break label934;
        label2671:
        paramBaseViewHolder.EUK.Ews.setDrawWidthAndHeightFix(false);
        break label963;
        label2685:
        a(paramBaseViewHolder, false);
        paramBaseViewHolder.EUK.Ews.setVisibility(0);
        break label987;
        if ((bool1) || (((FrameLayout)localObject1).getChildCount() <= 0) || (d.fkS().aRv(paramTimeLineObject.Id))) {
          break label1379;
        }
        l = System.currentTimeMillis();
        ((FrameLayout)localObject1).removeViewAt(0);
        Log.i("MicroMsg.VideoTimeLineItem", "lxl item remove videoview cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        break label1379;
        label2769:
        paramInt2 = paramBaseViewHolder.timeLineObject.CreateTime;
        break label1400;
        label2781:
        paramBaseViewHolder.EUK.Ewt.setTag(paramBaseViewHolder.EUK);
        localObject1 = paramBaseViewHolder.EUK.Ewt;
        localObject2 = parambl.DqO;
        localObject3 = this.mActivity;
        bp localbp = bp.gCU();
        localbp.hXs = paramTimeLineObject.CreateTime;
        f.a((SnsAdTimelineVideoView)localObject1, localg, (SnsInfo)localObject2, (Activity)localObject3, localcnb, paramInt1, localbp);
        break label1458;
        paramBaseViewHolder.EUK.Ews.setTagObject(paramBaseViewHolder.EUK);
        if ((parambl.DqO != null) && (parambl.DqO.isAd()) && (eXY()))
        {
          localObject1 = parambl.DqO;
          localObject2 = paramBaseViewHolder.EUK.Ews;
          paramInt2 = this.mActivity.hashCode();
          localObject3 = bp.gCU();
          ((bp)localObject3).hXs = paramTimeLineObject.CreateTime;
          localg.a((SnsInfo)localObject1, localcnb, (VideoSightView)localObject2, -1, paramInt2, paramInt1, (bp)localObject3, parambl.Eoq, true, false);
          break label1458;
        }
        localObject1 = parambl.DqO;
        localObject2 = paramBaseViewHolder.EUK.Ews;
        paramInt2 = this.mActivity.hashCode();
        localObject3 = bp.gCU();
        ((bp)localObject3).hXs = paramTimeLineObject.CreateTime;
        localg.a((SnsInfo)localObject1, localcnb, (VideoSightView)localObject2, paramInt2, paramInt1, (bp)localObject3, parambl.Eoq, true);
        break label1458;
        label3018:
        parambk.EKl.EoE.f(parambl.ENp, (int)localcnb.MsT, false);
        break label1598;
        label3043:
        bool1 = false;
        break label1623;
        label3049:
        if (aj.faL().a(parambl.DqO, null) == 5)
        {
          bool1 = true;
          break label1623;
        }
        bool1 = false;
        break label1623;
        if (eXX()) {
          a(paramBaseViewHolder, localg, paramInt1);
        } else {
          localg.a(paramBaseViewHolder.EUK.Ews, this.mActivity.hashCode(), paramInt1);
        }
      }
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100125);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.EZI = f.eXW();
    this.mScreenWidth = ((DisplayMetrics)localObject).widthPixels;
    this.mScreenHeight = ((DisplayMetrics)localObject).heightPixels;
    this.EZK = paramBaseViewHolder;
    if (paramBaseViewHolder.EWD != null)
    {
      paramBaseViewHolder.EWD.setLayoutResource(2131496459);
      paramBaseViewHolder.EXu = ((ViewStub)paramBaseViewHolder.convertView.findViewById(2131302605));
      if (!paramBaseViewHolder.EXv)
      {
        paramBaseViewHolder.EUK.Ewr = paramBaseViewHolder.EXu.inflate();
        paramBaseViewHolder.EXv = true;
      }
      paramBaseViewHolder.EUK.Ewu = paramBaseViewHolder.EUK.Ewr.findViewById(2131298411);
      paramBaseViewHolder.EUK.Ews = ((VideoSightView)paramBaseViewHolder.EUK.Ewr.findViewById(2131302526));
      paramBaseViewHolder.EUK.Ews.setMute(true);
      if ((paramBaseViewHolder != null) && (paramBaseViewHolder.EUK != null)) {
        break label383;
      }
    }
    for (;;)
    {
      paramBaseViewHolder.EUK.Ewu.setOnClickListener(this.EVA);
      paramBaseViewHolder.EUK.EeS = ((ImageView)paramBaseViewHolder.EUK.Ewr.findViewById(2131308392));
      paramBaseViewHolder.EUK.Ewv = ((MMPinProgressBtn)paramBaseViewHolder.EUK.Ewr.findViewById(2131306281));
      paramBaseViewHolder.EUK.Eww = ((TextView)paramBaseViewHolder.EUK.Ewr.findViewById(2131300128));
      paramBaseViewHolder.EUK.EeT = ((TextView)paramBaseViewHolder.EUK.Ewr.findViewById(2131300154));
      com.tencent.mm.kernel.g.aAi();
      if (((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(344065, Boolean.FALSE)).booleanValue())
      {
        localObject = (TextView)((ViewStub)paramBaseViewHolder.EUK.Ewr.findViewById(2131307896)).inflate();
        paramBaseViewHolder.EUK.Ews.setSightInfoView((TextView)localObject);
      }
      AppMethodBeat.o(100125);
      return;
      paramBaseViewHolder.EUK.Ewr = paramBaseViewHolder.convertView.findViewById(2131308156);
      paramBaseViewHolder.EXv = true;
      break;
      label383:
      paramBaseViewHolder.EUK.Ewt = ((SnsAdTimelineVideoView)paramBaseViewHolder.EUK.Ewr.findViewById(2131305364));
      f.a(paramBaseViewHolder.EUK.Ewt);
    }
  }
  
  protected boolean eXX()
  {
    AppMethodBeat.i(203945);
    boolean bool2 = false;
    SnsInfo localSnsInfo = this.DqO;
    boolean bool1 = bool2;
    if (this.EZI)
    {
      bool1 = bool2;
      if (localSnsInfo != null)
      {
        bool1 = bool2;
        if (localSnsInfo.isAd()) {
          bool1 = true;
        }
      }
    }
    Log.i("MicroMsg.VideoTimeLineItem", "the useNewPlayer return value is ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(203945);
    return bool1;
  }
  
  protected boolean eXY()
  {
    return false;
  }
  
  protected final void eYc()
  {
    AppMethodBeat.i(203940);
    Log.i("MicroMsg.VideoTimeLineItem", "try hide play btn");
    if ((this.EZK != null) && (this.EZK.EUK != null))
    {
      Log.i("MicroMsg.VideoTimeLineItem", "hide play btn");
      this.EZK.EUK.EeS.setVisibility(8);
      this.EZK.EUK.Ewv.setVisibility(8);
    }
    AppMethodBeat.o(203940);
  }
  
  public final void fkq()
  {
    AppMethodBeat.i(176430);
    Log.i("MicroMsg.VideoTimeLineItem", "try show play btn");
    if ((this.EZK != null) && (this.EZK.EUK != null) && (!this.EXV))
    {
      Log.i("MicroMsg.VideoTimeLineItem", "show play btn");
      this.EZK.EUK.EeS.setVisibility(0);
      this.EZK.EUK.Ewv.setVisibility(8);
      this.EZK.EUK.EeS.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691480));
      this.EZK.EUK.EeS.setContentDescription(this.mActivity.getString(2131763945));
    }
    AppMethodBeat.o(176430);
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(100129);
    if (this.EZL != null)
    {
      Object localObject = new int[2];
      this.EZL.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.EZL.getMeasuredWidth() + i, this.EZL.getMeasuredHeight() + j);
      AppMethodBeat.o(100129);
      return localObject;
    }
    AppMethodBeat.o(100129);
    return null;
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
    fkq();
    AppMethodBeat.o(176432);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176433);
    Log.i("MicroMsg.VideoTimeLineItem", "%s Ad Video stop", new Object[] { this });
    Object localObject;
    if ((this.EZK != null) && (this.EZK.EUK != null))
    {
      if (!eXX()) {
        break label110;
      }
      localObject = this.EZK;
      Log.d("MicroMsg.VideoTimeLineItem", "newPlayerClear is called");
      if ((localObject != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).EUK != null)) {
        break label82;
      }
    }
    for (;;)
    {
      this.EXV = false;
      AppMethodBeat.o(176433);
      return;
      label82:
      localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).EUK.Ewt;
      Log.d("NormalVideoAdHelper", "clear is called");
      if (localObject != null)
      {
        ((SnsAdTimelineVideoView)localObject).clear();
        continue;
        label110:
        this.EZK.EUK.Ews.Dnr.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.q
 * JD-Core Version:    0.7.0.1
 */