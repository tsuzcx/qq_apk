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
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.video.c;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.LinkedList;

public final class l
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private int mScreenHeight;
  private int mScreenWidth;
  private p wvM;
  private View.OnClickListener xPA;
  private boolean xRG;
  private boolean xSQ;
  private b.e xSR;
  private BaseTimeLineItem.BaseViewHolder xSS;
  View xST;
  private String xSU;
  View xSV;
  
  public l()
  {
    AppMethodBeat.i(100124);
    this.xSQ = false;
    this.xSR = new b.e()
    {
      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt) {}
    };
    this.xST = null;
    this.xSU = "";
    this.xSV = null;
    this.xPA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(177696);
        ad.i("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick");
        try
        {
          l.this.wNd.wMy.xTQ.onClick(paramAnonymousView);
          l.b(l.this);
          AppMethodBeat.o(177696);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          ad.e("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(177696);
        }
      }
    };
    AppMethodBeat.o(100124);
  }
  
  private void R(p paramp)
  {
    AppMethodBeat.i(187788);
    if ((this.wNd != null) && (this.wNd.xFq != null) && (this.wNd.xFq.xkX != null) && (paramp != null)) {
      this.wNd.xFq.xkX.sn(paramp.field_snsId);
    }
    AppMethodBeat.o(187788);
  }
  
  private static void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(100127);
    if (paramBoolean)
    {
      ad.i("MicroMsg.VideoTimeLineItem", "lxl setVideoStatusIvVisibility %s, but isPlaying", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(100127);
      return;
    }
    paramBaseViewHolder.xOO.xbT.setVisibility(paramInt);
    AppMethodBeat.o(100127);
  }
  
  private void csr()
  {
    AppMethodBeat.i(176430);
    ad.i("MicroMsg.VideoTimeLineItem", "try show play btn");
    if ((this.xSS != null) && (this.xSS.xOO != null) && (!this.xRG))
    {
      ad.i("MicroMsg.VideoTimeLineItem", "show play btn");
      this.xSS.xOO.xbT.setVisibility(0);
      this.xSS.xOO.xsq.setVisibility(8);
      this.xSS.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
      this.xSS.xOO.xbT.setContentDescription(this.mActivity.getString(2131761939));
    }
    AppMethodBeat.o(176430);
  }
  
  private void dDq()
  {
    AppMethodBeat.i(177698);
    ad.i("MicroMsg.VideoTimeLineItem", "%s Ad Video doPause", new Object[] { this });
    if ((this.xSS != null) && (this.xSS.xOO != null))
    {
      this.xSS.xOO.xsn.pause();
      R(this.wvM);
    }
    this.xRG = false;
    AppMethodBeat.o(177698);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176431);
    Object localObject2 = af.dtu().apK(paramBaseViewHolder.dgg);
    if (localObject2 == null)
    {
      ad.w("MicroMsg.VideoTimeLineItem", "play error, snsId:%s", new Object[] { paramBaseViewHolder.dgg });
      AppMethodBeat.o(176431);
      return;
    }
    TimeLineObject localTimeLineObject = ((p)localObject2).dxy();
    if ((localTimeLineObject.Etm != null) && (localTimeLineObject.Etm.DaC.size() > 0)) {}
    for (Object localObject1 = (bpi)localTimeLineObject.Etm.DaC.get(0); localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(176431);
      return;
    }
    if (((p)localObject2).Nb(32))
    {
      ad.i("MicroMsg.VideoTimeLineItem", "%s Ad autoPlay", new Object[] { this });
      final long l = ((p)localObject2).field_snsId;
      paramBaseViewHolder.xOO.xsn.setOnCompletionListener(new b.e()
      {
        public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
        {
          AppMethodBeat.i(100121);
          if (paramAnonymousInt != -1)
          {
            if ((l.this.wNd == null) || (l.this.wNd.xFq == null) || (l.this.wNd.xFq.xkX == null))
            {
              AppMethodBeat.o(100121);
              return;
            }
            l.this.wNd.xFq.xkX.A(l, false);
          }
          AppMethodBeat.o(100121);
        }
      });
      paramBaseViewHolder.xOO.xsn.setOnDecodeDurationListener(new b.f()
      {
        public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
        {
          AppMethodBeat.i(100122);
          if ((l.this.wNd == null) || (l.this.wNd.xFq == null) || (l.this.wNd.xFq.xkX == null))
          {
            AppMethodBeat.o(100122);
            return;
          }
          if (this.xlw != null)
          {
            l.this.wNd.xFq.xkX.sm(this.xlw.field_snsId);
            l.this.wNd.xFq.xkX.ak(this.xlw.field_snsId, 1000L * paramAnonymousLong);
          }
          if (!l.this.wNd.xFq.xkX.sj(l))
          {
            int i = (int)paramAnonymousb.dqu();
            l.this.wNd.xFq.xkX.d(l, bt.GC(), false);
            l.this.wNd.xFq.xkX.e(l, i, false);
            l.this.wNd.xFq.xkX.aj(l, l);
            this.xlx.xOO.xsn.setOnDecodeDurationListener(null);
          }
          AppMethodBeat.o(100122);
        }
      });
      d.dDS().ckd();
      com.tencent.mm.plugin.sns.ui.video.b.dDL().a(this);
      this.xSS.xOO.xsn.start();
      ad.i("MicroMsg.VideoTimeLineItem", "try hide play btn");
      if ((this.xSS != null) && (this.xSS.xOO != null))
      {
        ad.i("MicroMsg.VideoTimeLineItem", "hide play btn");
        this.xSS.xOO.xbT.setVisibility(8);
        this.xSS.xOO.xsq.setVisibility(8);
      }
      this.xRG = true;
      this.xSQ = false;
      AppMethodBeat.o(176431);
      return;
    }
    com.tencent.mm.plugin.sns.ui.video.b.dDL().pause();
    c localc = new c();
    localc.dyS = ((bpi)localObject1);
    localc.dgg = paramBaseViewHolder.dgg;
    localc.dpC = com.tencent.mm.plugin.sns.data.q.st(((p)localObject2).field_snsId);
    localObject1 = af.dtu().apJ(paramBaseViewHolder.dpC);
    if (localObject1 != null)
    {
      localc.hgr = ((p)localObject1).field_createTime;
      localObject2 = (FrameLayout)paramBaseViewHolder.xOO.xsm.findViewById(2131305105);
      localObject1 = null;
      if (((FrameLayout)localObject2).getChildCount() > 0) {
        localObject1 = (SnsTimelineVideoView)((FrameLayout)localObject2).getChildAt(0);
      }
      if ((localObject1 == null) || (((SnsTimelineVideoView)localObject1).xWa == null) || (((SnsTimelineVideoView)localObject1).xWe) || (!bt.kU(localTimeLineObject.Id, ((SnsTimelineVideoView)localObject1).xWb)) || (!bt.kU(((SnsTimelineVideoView)localObject1).xWa.dyS.Id, localc.dyS.Id))) {
        break label588;
      }
      ad.i("MicroMsg.VideoTimeLineItem", "reuse videoview:%s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
    }
    for (;;)
    {
      ((SnsTimelineVideoView)localObject1).setVisibility(0);
      ((SnsTimelineVideoView)localObject1).setVideoScaleType(h.e.BVt);
      paramBaseViewHolder.xOO.xsm.findViewById(2131305799).setVisibility(8);
      if (paramBaseViewHolder.xOO.xbT != null) {
        paramBaseViewHolder.xOO.xbT.setVisibility(8);
      }
      ((SnsTimelineVideoView)localObject1).setUICallback(new SnsTimelineVideoView.b()
      {
        public final void HL(String paramAnonymousString)
        {
          AppMethodBeat.i(100123);
          ad.i("MicroMsg.VideoTimeLineItem", "onDestroy UICallback %s, %s", new Object[] { paramAnonymousString, l.a(l.this) });
          if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(l.a(l.this))) && (l.this.xSV != null))
          {
            l.this.xSV.setVisibility(0);
            ad.i("MicroMsg.VideoTimeLineItem", "onDestroy show videoStatusIv");
          }
          AppMethodBeat.o(100123);
        }
      });
      d.dDS().a((OnlineVideoView)localObject1, localc, localTimeLineObject.Id);
      AppMethodBeat.o(176431);
      return;
      localc.hgr = ((int)(System.currentTimeMillis() / 1000L));
      break;
      label588:
      if (localObject1 != null) {
        ((FrameLayout)localObject2).removeViewAt(0);
      }
      localObject1 = d.dDS().fX(((FrameLayout)localObject2).getContext());
      if (((SnsTimelineVideoView)localObject1).getParent() != null)
      {
        ((SnsTimelineVideoView)localObject1).dDQ();
        ((SnsTimelineVideoView)localObject1).xWf = true;
        ((ViewGroup)((SnsTimelineVideoView)localObject1).getParent()).removeView((View)localObject1);
      }
      ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      ((SnsTimelineVideoView)localObject1).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe)
  {
    AppMethodBeat.i(100126);
    this.wvM = parambf.wvM;
    bpi localbpi;
    Object localObject1;
    Object localObject2;
    if ((paramTimeLineObject.Etm != null) && (paramTimeLineObject.Etm.DaC.size() > 0))
    {
      localbpi = (bpi)paramTimeLineObject.Etm.DaC.get(0);
      ad.i("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", new Object[] { Integer.valueOf(paramInt1) });
      localObject1 = d.dDS();
      localObject2 = paramTimeLineObject.Id;
      if ((!bt.isNullOrNil(((d)localObject1).xWt)) && (!bt.isNullOrNil((String)localObject2))) {
        break label1560;
      }
      bool1 = false;
      label106:
      if (!bool1) {
        break label2644;
      }
    }
    label410:
    label827:
    label1481:
    label2641:
    label2644:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.xSU = paramTimeLineObject.Id;
      this.xSV = paramBaseViewHolder.xOO.xbT;
      f localf = af.dtr();
      if (!parambf.xkI)
      {
        paramBaseViewHolder.xOO.xsn.setOnSightCompletionAction(null);
        paramBaseViewHolder.xOO.xsn.setOnCompletionListener(null);
        paramBaseViewHolder.xOO.xsn.setOnDecodeDurationListener(null);
      }
      paramBaseViewHolder.xOO.xsn.setIsAdVideo(parambf.xkI);
      if ((paramBaseViewHolder.xOO.xsl != null) && (!bt.kU(paramBaseViewHolder.xOO.xsl.Id, paramTimeLineObject.Id)))
      {
        ad.i("MicroMsg.VideoTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.xOO.xsl.Id });
        localf.a(paramBaseViewHolder.xOO.xsn, this.mActivity.hashCode(), 0);
      }
      paramBaseViewHolder.xOO.a(paramTimeLineObject, paramInt1, parambf.xmu, parambf.xkI);
      paramBaseViewHolder.xOO.xbU.setVisibility(8);
      long l;
      Object localObject3;
      label473:
      int i;
      float f2;
      float f1;
      if ((paramTimeLineObject.Etm != null) && (paramTimeLineObject.Etm.DaC.size() > 0))
      {
        l = System.nanoTime();
        boolean bool2 = f.t(localbpi);
        ad.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
        if (!bool2) {
          if (localf.w(localbpi))
          {
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.xOO.xsq.setVisibility(0);
            paramBaseViewHolder.xOO.xsq.feJ();
            if ((!parambf.xkI) || (!j.c(paramBaseViewHolder.timeLineObject))) {
              break label2186;
            }
            paramInt2 = 1;
            localObject2 = com.tencent.mm.modelsns.g.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.xOO.xsn.getUIContext(), false);
            localObject3 = new StringBuilder("isVerticalAdVideo=true, snsId=");
            if (parambf.wvM != null) {
              break label2171;
            }
            localObject1 = "";
            ad.i("MicroMsg.VideoTimeLineItem", localObject1 + ", showW=" + ((Pair)localObject2).first + ", showH=" + ((Pair)localObject2).second);
            localObject1 = localObject2;
            if (parambf.xkI)
            {
              localObject3 = parambf.wvM.dxs();
              i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject1 = localObject2;
                if (((com.tencent.mm.plugin.sns.storage.b)localObject3).wTm > 0.0F)
                {
                  localObject1 = localObject2;
                  if (((com.tencent.mm.plugin.sns.storage.b)localObject3).wTn > 0.0F)
                  {
                    f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).wTm, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTo, ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTp);
                    f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).wTn, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTo, ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTp);
                    if (((com.tencent.mm.plugin.sns.storage.b)localObject3).wTl != 0) {
                      break label2215;
                    }
                    if (f2 < i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12)) {
                      break label2641;
                    }
                    f2 = i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12);
                    f1 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject3).wTn * f2 / ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTm);
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
        label757:
        i = ((Integer)((Pair)localObject1).first).intValue();
        int j = ((Integer)((Pair)localObject1).second).intValue();
        if ((paramBaseViewHolder.xOO.xsn instanceof SightPlayImageView))
        {
          if (!parambf.xkI)
          {
            paramBaseViewHolder.xOO.xsn.setScaleMode(1);
            paramBaseViewHolder.xOO.xsn.setScaleType(QImageView.a.HBy);
          }
        }
        else
        {
          paramBaseViewHolder.xOO.xsn.gW(i, j);
          if ((paramBaseViewHolder.xOO.xsn instanceof SightPlayImageView))
          {
            if (paramInt2 == 0) {
              break label2474;
            }
            paramBaseViewHolder.xOO.xsn.wsy = true;
          }
          label870:
          paramBaseViewHolder.xOO.xsn.setVisibility(0);
          localObject2 = paramBaseViewHolder.xOO.xsr.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = i;
          ((ViewGroup.LayoutParams)localObject2).height = j;
          paramBaseViewHolder.xOO.xsr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = (FrameLayout)paramBaseViewHolder.xOO.xsm.findViewById(2131305105);
          localObject3 = (FrameLayout.LayoutParams)((FrameLayout)localObject1).getLayoutParams();
          ((FrameLayout.LayoutParams)localObject3).width = i;
          ((FrameLayout.LayoutParams)localObject3).height = j;
          ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = paramBaseViewHolder.xOO.xsm.findViewById(2131305799);
          ((View)localObject3).setLayoutParams(new FrameLayout.LayoutParams((ViewGroup.LayoutParams)localObject2));
          ((View)localObject3).setVisibility(4);
          this.xST = ((View)localObject1);
          localObject2 = d.dDS().aqT(paramTimeLineObject.Id);
          ad.i("MicroMsg.VideoTimeLineItem", "lxl fill itemview check videoView reAttach, tlObjId:%s, vv:%s, count:%s", new Object[] { paramTimeLineObject.Id, localObject2, Integer.valueOf(((FrameLayout)localObject1).getChildCount()) });
          if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof ImageView)))
          {
            ((FrameLayout)localObject1).removeAllViews();
            ad.i("MicroMsg.VideoTimeLineItem", "find thumbView thne remove it %s", new Object[] { paramTimeLineObject.Id });
          }
          if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof SnsTimelineVideoView)))
          {
            localObject3 = (SnsTimelineVideoView)((FrameLayout)localObject1).getChildAt(0);
            if (!paramTimeLineObject.Id.equals(((SnsTimelineVideoView)localObject3).xWb))
            {
              ((FrameLayout)localObject1).removeAllViews();
              ad.i("MicroMsg.VideoTimeLineItem", "find diff id then remove it %s %s", new Object[] { paramTimeLineObject.Id, ((SnsTimelineVideoView)localObject3).xWb });
            }
          }
          if ((localObject2 == null) || (((FrameLayout)localObject1).getChildCount() != 0)) {
            break label2488;
          }
          if ((((SnsTimelineVideoView)localObject2).getParent() != null) && (((SnsTimelineVideoView)localObject2).getParent() != localObject1))
          {
            ((SnsTimelineVideoView)localObject2).xWf = true;
            ((ViewGroup)((SnsTimelineVideoView)localObject2).getParent()).removeView((View)localObject2);
            ((SnsTimelineVideoView)localObject2).setVisibility(0);
            ((SnsTimelineVideoView)localObject2).setVideoScaleType(h.e.BVt);
            ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
            ad.i("MicroMsg.VideoTimeLineItem", "lxl reAttach succ");
          }
          label1273:
          if (localObject2 != null)
          {
            localObject1 = paramBaseViewHolder.dgg;
            if (paramBaseViewHolder.timeLineObject != null) {
              break label2553;
            }
            paramInt2 = 0;
            ((SnsTimelineVideoView)localObject2).a(localbpi, (String)localObject1, paramInt2);
          }
          paramBaseViewHolder.xOO.xsn.setTagObject(paramBaseViewHolder.xOO);
          localObject1 = parambf.wvM;
          localObject2 = paramBaseViewHolder.xOO.xsn;
          paramInt2 = this.mActivity.hashCode();
          localObject3 = bc.eLG();
          ((bc)localObject3).tGD = paramTimeLineObject.CreateTime;
          localf.a((p)localObject1, localbpi, (VideoSightView)localObject2, paramInt2, paramInt1, (bc)localObject3, parambf.xkI, true);
          paramBaseViewHolder.xOO.xsp.setTag(paramBaseViewHolder.xOO);
          paramTimeLineObject = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), localbpi.Id);
          localObject1 = com.tencent.mm.plugin.sns.data.q.i(localbpi);
          if (!com.tencent.mm.vfs.i.eK(paramTimeLineObject + (String)localObject1)) {
            break label2565;
          }
          parambe.xFq.xkX.B(parambf.xIc, true);
          if (!parambf.xkI) {
            break label2590;
          }
          if (af.dtr().b(parambf.wvM, null) != 5) {
            break label2584;
          }
          bool1 = true;
          parambe.xFq.xkX.e(parambf.xIc, bool1, false);
        }
        for (;;)
        {
          if ((parambf.wvM != null) && (!parambf.wvM.dvm())) {
            parambe.dCa().c(paramBaseViewHolder.xOO.xsp, parambe.wMy.xTJ, parambe.wMy.xTt);
          }
          AppMethodBeat.o(100126);
          return;
          localbpi = null;
          break;
          bool1 = ((d)localObject1).xWt.equals(localObject2);
          break label106;
          if ((parambf.xkI) && (localf.b(parambf.wvM, null) == 5))
          {
            localf.A(localbpi);
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.xOO.xsq.setVisibility(0);
            paramBaseViewHolder.xOO.xsq.feJ();
            break label410;
          }
          if (localf.x(localbpi))
          {
            paramBaseViewHolder.xOO.xsq.setVisibility(8);
            paramBaseViewHolder.xOO.xbT.setImageResource(2131234034);
            a(paramBaseViewHolder, 0, bool1);
            break label410;
          }
          localf.y(localbpi);
          a(paramBaseViewHolder, 0, bool1);
          paramBaseViewHolder.xOO.xsq.setVisibility(8);
          paramBaseViewHolder.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
          paramBaseViewHolder.xOO.xbT.setContentDescription(this.mActivity.getString(2131761939));
          if ((!parambf.xkI) && (localf.a(parambf.wvM, null) == 4))
          {
            paramBaseViewHolder.xOO.xbU.setVisibility(0);
            break label410;
          }
          if ((!parambf.xkI) || (localf.b(parambf.wvM, null) != 4)) {
            break label410;
          }
          paramBaseViewHolder.xOO.xbU.setVisibility(0);
          break label410;
          if (localf.u(localbpi))
          {
            a(paramBaseViewHolder, 0, bool1);
            paramBaseViewHolder.xOO.xsq.setVisibility(8);
            paramBaseViewHolder.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
            paramBaseViewHolder.xOO.xbT.setContentDescription(this.mActivity.getString(2131761939));
          }
          for (;;)
          {
            if (!paramBaseViewHolder.xOO.xsn.wsq.dqr()) {
              break label2169;
            }
            ad.d("MicroMsg.VideoTimeLineItem", "play video error " + localbpi.Id + " " + localbpi.Url + " " + localbpi.DMQ + " " + paramInt1);
            localf.y(localbpi);
            a(paramBaseViewHolder, 0, bool1);
            paramBaseViewHolder.xOO.xsq.setVisibility(8);
            paramBaseViewHolder.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
            paramBaseViewHolder.xOO.xbT.setContentDescription(this.mActivity.getString(2131761939));
            break;
            if (localf.v(localbpi))
            {
              a(paramBaseViewHolder, 8, bool1);
              paramBaseViewHolder.xOO.xsq.setVisibility(8);
            }
            else if ((parambf.xkI) && (localf.b(parambf.wvM, null) <= 5))
            {
              if (!this.xSQ)
              {
                ad.i("MicroMsg.VideoTimeLineItem", "fillItem, showPlayBtn");
                csr();
              }
            }
            else
            {
              localf.y(localbpi);
              a(paramBaseViewHolder, 0, bool1);
              paramBaseViewHolder.xOO.xsq.setVisibility(8);
              paramBaseViewHolder.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
              paramBaseViewHolder.xOO.xbT.setContentDescription(this.mActivity.getString(2131761939));
            }
          }
          label2169:
          break label410;
          label2171:
          localObject1 = Long.valueOf(parambf.wvM.field_snsId);
          break label473;
          localObject2 = com.tencent.mm.modelsns.g.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.xOO.xsn.getUIContext(), parambf.xkI);
          paramInt2 = 0;
          break label516;
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).wTl == 1)
          {
            i = i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12);
            localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTn / ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTm)));
            paramBaseViewHolder.xQt.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
            break label757;
          }
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).wTl != 2) {
            break label757;
          }
          i = i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12);
          localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTn / ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTm)));
          paramBaseViewHolder.xQt.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
          break label757;
          if (paramInt2 != 0)
          {
            paramBaseViewHolder.xOO.xsn.setScaleMode(1);
            paramBaseViewHolder.xOO.xsn.setScaleType(QImageView.a.HBy);
            break label827;
          }
          paramBaseViewHolder.xOO.xsn.setScaleMode(0);
          paramBaseViewHolder.xOO.xsn.setScaleType(QImageView.a.HBt);
          break label827;
          paramBaseViewHolder.xOO.xsn.setDrawWidthAndHeightFix(false);
          break label870;
          if ((bool1) || (((FrameLayout)localObject1).getChildCount() <= 0) || (d.dDS().aqR(paramTimeLineObject.Id))) {
            break label1273;
          }
          l = System.currentTimeMillis();
          ((FrameLayout)localObject1).removeViewAt(0);
          ad.i("MicroMsg.VideoTimeLineItem", "lxl item remove videoview cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          break label1273;
          label2553:
          paramInt2 = paramBaseViewHolder.timeLineObject.CreateTime;
          break label1294;
          parambe.xFq.xkX.B(parambf.xIc, false);
          break label1456;
          bool1 = false;
          break label1481;
          if (af.dtr().a(parambf.wvM, null) == 5)
          {
            bool1 = true;
            break label1481;
          }
          bool1 = false;
          break label1481;
          localf.a(paramBaseViewHolder.xOO.xsn, this.mActivity.hashCode(), paramInt1);
        }
      }
    }
  }
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100125);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.mScreenWidth = ((DisplayMetrics)localObject).widthPixels;
    this.mScreenHeight = ((DisplayMetrics)localObject).heightPixels;
    this.xSS = paramBaseViewHolder;
    if (paramBaseViewHolder.xQw != null)
    {
      paramBaseViewHolder.xQw.setLayoutResource(2131495566);
      paramBaseViewHolder.xRn = ((ViewStub)paramBaseViewHolder.rLd.findViewById(2131300969));
      if (!paramBaseViewHolder.xRo) {
        paramBaseViewHolder.xOO.xsm = paramBaseViewHolder.xRn.inflate();
      }
    }
    for (paramBaseViewHolder.xRo = true;; paramBaseViewHolder.xRo = true)
    {
      paramBaseViewHolder.xOO.xsp = paramBaseViewHolder.xOO.xsm.findViewById(2131298069);
      paramBaseViewHolder.xOO.xsn = ((VideoSightView)paramBaseViewHolder.xOO.xsm.findViewById(2131300914));
      paramBaseViewHolder.xOO.xsn.setMute(true);
      paramBaseViewHolder.xOO.xsp.setOnClickListener(this.xPA);
      paramBaseViewHolder.xOO.xbT = ((ImageView)paramBaseViewHolder.xOO.xsm.findViewById(2131305196));
      paramBaseViewHolder.xOO.xsq = ((MMPinProgressBtn)paramBaseViewHolder.xOO.xsm.findViewById(2131303515));
      paramBaseViewHolder.xOO.xsr = ((TextView)paramBaseViewHolder.xOO.xsm.findViewById(2131299492));
      paramBaseViewHolder.xOO.xbU = ((TextView)paramBaseViewHolder.xOO.xsm.findViewById(2131299517));
      com.tencent.mm.kernel.g.afC();
      if (((Boolean)com.tencent.mm.kernel.g.afB().afk().get(344065, Boolean.FALSE)).booleanValue())
      {
        localObject = (TextView)((ViewStub)paramBaseViewHolder.xOO.xsm.findViewById(2131304813)).inflate();
        paramBaseViewHolder.xOO.xsn.setSightInfoView((TextView)localObject);
      }
      AppMethodBeat.o(100125);
      return;
      paramBaseViewHolder.xOO.xsm = paramBaseViewHolder.rLd.findViewById(2131305005);
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(100129);
    if (this.xST != null)
    {
      Object localObject = new int[2];
      this.xST.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.xST.getMeasuredWidth() + i, this.xST.getMeasuredHeight() + j);
      AppMethodBeat.o(100129);
      return localObject;
    }
    AppMethodBeat.o(100129);
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177697);
    ad.i("MicroMsg.VideoTimeLineItem", "onUIPause");
    dDq();
    AppMethodBeat.o(177697);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176432);
    ad.i("MicroMsg.VideoTimeLineItem", "pause");
    dDq();
    csr();
    AppMethodBeat.o(176432);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176433);
    ad.i("MicroMsg.VideoTimeLineItem", "%s Ad Video stop", new Object[] { this });
    if ((this.xSS != null) && (this.xSS.xOO != null)) {
      this.xSS.xOO.xsn.wsq.clear();
    }
    this.xRG = false;
    AppMethodBeat.o(176433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.l
 * JD-Core Version:    0.7.0.1
 */