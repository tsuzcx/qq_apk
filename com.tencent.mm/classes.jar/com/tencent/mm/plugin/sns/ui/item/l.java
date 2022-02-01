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
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.video.c;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.LinkedList;

public final class l
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private int mScreenHeight;
  private int mScreenWidth;
  private p xHc;
  private View.OnClickListener zcq;
  private boolean zeB;
  private boolean zfL;
  private b.e zfM;
  private BaseTimeLineItem.BaseViewHolder zfN;
  View zfO;
  private String zfP;
  View zfQ;
  private boolean zfR;
  
  public l()
  {
    AppMethodBeat.i(100124);
    this.zfL = false;
    this.zfM = new b.e()
    {
      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt) {}
    };
    this.zfO = null;
    this.zfP = "";
    this.zfQ = null;
    this.zfR = false;
    this.zcq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(177696);
        ac.i("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick");
        try
        {
          l.this.xZJ.xZe.zgM.onClick(paramAnonymousView);
          l.b(l.this);
          AppMethodBeat.o(177696);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          ac.e("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(177696);
        }
      }
    };
    AppMethodBeat.o(100124);
  }
  
  private void S(p paramp)
  {
    AppMethodBeat.i(200660);
    if ((this.xZJ != null) && (this.xZJ.ySd != null) && (this.xZJ.ySd.yxP != null) && (paramp != null)) {
      this.xZJ.ySd.yxP.wQ(paramp.field_snsId);
    }
    AppMethodBeat.o(200660);
  }
  
  private static void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(100127);
    if (paramBoolean)
    {
      ac.i("MicroMsg.VideoTimeLineItem", "lxl setVideoStatusIvVisibility %s, but isPlaying", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(100127);
      return;
    }
    paramBaseViewHolder.zbE.yoI.setVisibility(paramInt);
    AppMethodBeat.o(100127);
  }
  
  private void dRM()
  {
    AppMethodBeat.i(176430);
    ac.i("MicroMsg.VideoTimeLineItem", "try show play btn");
    if ((this.zfN != null) && (this.zfN.zbE != null) && (!this.zeB))
    {
      ac.i("MicroMsg.VideoTimeLineItem", "show play btn");
      this.zfN.zbE.yoI.setVisibility(0);
      this.zfN.zbE.yFg.setVisibility(8);
      this.zfN.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
      this.zfN.zbE.yoI.setContentDescription(this.mActivity.getString(2131761939));
    }
    AppMethodBeat.o(176430);
  }
  
  private void dRO()
  {
    AppMethodBeat.i(177698);
    ac.i("MicroMsg.VideoTimeLineItem", "%s Ad Video doPause", new Object[] { this });
    if ((this.zfN != null) && (this.zfN.zbE != null))
    {
      this.zfN.zbE.yFd.pause();
      S(this.xHc);
    }
    this.zeB = false;
    AppMethodBeat.o(177698);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176431);
    Object localObject2 = af.dHR().auT(paramBaseViewHolder.ddB);
    if (localObject2 == null)
    {
      ac.w("MicroMsg.VideoTimeLineItem", "play error, snsId:%s", new Object[] { paramBaseViewHolder.ddB });
      AppMethodBeat.o(176431);
      return;
    }
    TimeLineObject localTimeLineObject = ((p)localObject2).dLV();
    if ((localTimeLineObject.FQo != null) && (localTimeLineObject.FQo.Etz.size() > 0)) {}
    for (Object localObject1 = (btz)localTimeLineObject.FQo.Etz.get(0); localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(176431);
      return;
    }
    if (((p)localObject2).Pe(32))
    {
      ac.i("MicroMsg.VideoTimeLineItem", "%s Ad autoPlay", new Object[] { this });
      final long l = ((p)localObject2).field_snsId;
      if (!this.zfR)
      {
        this.zfR = true;
        paramBaseViewHolder.zbE.yFd.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(100121);
            if (paramAnonymousInt != -1)
            {
              if ((this.yyo == null) || (!this.yyo.Pe(32)))
              {
                ac.e("MicroMsg.VideoTimeLineItem", "onCompletion, !isAd,  snsId=" + com.tencent.mm.plugin.sns.data.q.wW(l));
                AppMethodBeat.o(100121);
                return;
              }
              if ((l.this.xZJ == null) || (l.this.xZJ.ySd == null) || (l.this.xZJ.ySd.yxP == null))
              {
                AppMethodBeat.o(100121);
                return;
              }
              l.this.xZJ.ySd.yxP.A(l, false);
              ac.d("MicroMsg.VideoTimeLineItem", "onCompletion, retCode=" + paramAnonymousInt + ", snsId=" + com.tencent.mm.plugin.sns.data.q.wW(l));
            }
            AppMethodBeat.o(100121);
          }
        });
        paramBaseViewHolder.zbE.yFd.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(100122);
            if ((this.yyo == null) || (!this.yyo.Pe(32)))
            {
              ac.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, !isAd, currentTime=" + paramAnonymousLong + ", snsId=" + com.tencent.mm.plugin.sns.data.q.wW(l));
              AppMethodBeat.o(100122);
              return;
            }
            if ((l.this.xZJ == null) || (l.this.xZJ.ySd == null) || (l.this.xZJ.ySd.yxP == null))
            {
              AppMethodBeat.o(100122);
              return;
            }
            if (this.yyo != null)
            {
              l.this.xZJ.ySd.yxP.wP(this.yyo.field_snsId);
              l.this.xZJ.ySd.yxP.ah(this.yyo.field_snsId, 1000L * paramAnonymousLong);
            }
            if (!l.this.xZJ.ySd.yxP.wM(l))
            {
              int i = (int)paramAnonymousb.dED();
              l.this.xZJ.ySd.yxP.d(l, bs.Gn(), false);
              l.this.xZJ.ySd.yxP.e(l, i, false);
              l.this.xZJ.ySd.yxP.ag(l, l);
              ac.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, addPlay3s, snsId=" + com.tencent.mm.plugin.sns.data.q.wW(l));
            }
            ac.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, currentTime=" + paramAnonymousLong + ", snsId=" + com.tencent.mm.plugin.sns.data.q.wW(l));
            AppMethodBeat.o(100122);
          }
        });
      }
      for (;;)
      {
        d.dSq().crK();
        com.tencent.mm.plugin.sns.ui.video.b.dSj().a(this);
        this.zfN.zbE.yFd.start();
        ac.i("MicroMsg.VideoTimeLineItem", "try hide play btn");
        if ((this.zfN != null) && (this.zfN.zbE != null))
        {
          ac.i("MicroMsg.VideoTimeLineItem", "hide play btn");
          this.zfN.zbE.yoI.setVisibility(8);
          this.zfN.zbE.yFg.setVisibility(8);
        }
        this.zeB = true;
        this.zfL = false;
        AppMethodBeat.o(176431);
        return;
        ac.d("MicroMsg.VideoTimeLineItem", "play, hasSetListener=true");
      }
    }
    com.tencent.mm.plugin.sns.ui.video.b.dSj().pause();
    c localc = new c();
    localc.dwE = ((btz)localObject1);
    localc.ddB = paramBaseViewHolder.ddB;
    localc.dnn = com.tencent.mm.plugin.sns.data.q.wW(((p)localObject2).field_snsId);
    localObject1 = af.dHR().auS(paramBaseViewHolder.dnn);
    if (localObject1 != null)
    {
      localc.hGU = ((p)localObject1).field_createTime;
      localObject2 = (FrameLayout)paramBaseViewHolder.zbE.yFc.findViewById(2131305105);
      localObject1 = null;
      if (((FrameLayout)localObject2).getChildCount() > 0) {
        localObject1 = (SnsTimelineVideoView)((FrameLayout)localObject2).getChildAt(0);
      }
      if ((localObject1 == null) || (((SnsTimelineVideoView)localObject1).ziW == null) || (((SnsTimelineVideoView)localObject1).zja) || (!bs.lr(localTimeLineObject.Id, ((SnsTimelineVideoView)localObject1).ziX)) || (!bs.lr(((SnsTimelineVideoView)localObject1).ziW.dwE.Id, localc.dwE.Id))) {
        break label612;
      }
      ac.i("MicroMsg.VideoTimeLineItem", "reuse videoview:%s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
    }
    for (;;)
    {
      ((SnsTimelineVideoView)localObject1).setVisibility(0);
      ((SnsTimelineVideoView)localObject1).setVideoScaleType(h.e.DnK);
      paramBaseViewHolder.zbE.yFc.findViewById(2131305799).setVisibility(8);
      if (paramBaseViewHolder.zbE.yoI != null) {
        paramBaseViewHolder.zbE.yoI.setVisibility(8);
      }
      ((SnsTimelineVideoView)localObject1).setUICallback(new SnsTimelineVideoView.b()
      {
        public final void LP(String paramAnonymousString)
        {
          AppMethodBeat.i(100123);
          ac.i("MicroMsg.VideoTimeLineItem", "onDestroy UICallback %s, %s", new Object[] { paramAnonymousString, l.a(l.this) });
          if ((!bs.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(l.a(l.this))) && (l.this.zfQ != null))
          {
            l.this.zfQ.setVisibility(0);
            ac.i("MicroMsg.VideoTimeLineItem", "onDestroy show videoStatusIv");
          }
          AppMethodBeat.o(100123);
        }
      });
      d.dSq().a((OnlineVideoView)localObject1, localc, localTimeLineObject.Id);
      AppMethodBeat.o(176431);
      return;
      localc.hGU = ((int)(System.currentTimeMillis() / 1000L));
      break;
      label612:
      if (localObject1 != null) {
        ((FrameLayout)localObject2).removeViewAt(0);
      }
      localObject1 = d.dSq().gj(((FrameLayout)localObject2).getContext());
      if (((SnsTimelineVideoView)localObject1).getParent() != null)
      {
        ((SnsTimelineVideoView)localObject1).dSo();
        ((SnsTimelineVideoView)localObject1).zjb = true;
        ((ViewGroup)((SnsTimelineVideoView)localObject1).getParent()).removeView((View)localObject1);
      }
      ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      ((SnsTimelineVideoView)localObject1).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, com.tencent.mm.plugin.sns.ui.bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe)
  {
    AppMethodBeat.i(100126);
    this.xHc = parambf.xHc;
    btz localbtz;
    Object localObject1;
    Object localObject2;
    if ((paramTimeLineObject.FQo != null) && (paramTimeLineObject.FQo.Etz.size() > 0))
    {
      localbtz = (btz)paramTimeLineObject.FQo.Etz.get(0);
      ac.i("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", new Object[] { Integer.valueOf(paramInt1) });
      localObject1 = d.dSq();
      localObject2 = paramTimeLineObject.Id;
      if ((!bs.isNullOrNil(((d)localObject1).zjp)) && (!bs.isNullOrNil((String)localObject2))) {
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
      this.zfP = paramTimeLineObject.Id;
      this.zfQ = paramBaseViewHolder.zbE.yoI;
      f localf = af.dHO();
      if (!parambf.yxA)
      {
        paramBaseViewHolder.zbE.yFd.setOnSightCompletionAction(null);
        paramBaseViewHolder.zbE.yFd.setOnCompletionListener(null);
        paramBaseViewHolder.zbE.yFd.setOnDecodeDurationListener(null);
      }
      paramBaseViewHolder.zbE.yFd.setIsAdVideo(parambf.yxA);
      if ((paramBaseViewHolder.zbE.yFb != null) && (!bs.lr(paramBaseViewHolder.zbE.yFb.Id, paramTimeLineObject.Id)))
      {
        ac.i("MicroMsg.VideoTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.zbE.yFb.Id });
        localf.a(paramBaseViewHolder.zbE.yFd, this.mActivity.hashCode(), 0);
      }
      paramBaseViewHolder.zbE.a(paramTimeLineObject, paramInt1, parambf.yzm, parambf.yxA);
      paramBaseViewHolder.zbE.yoJ.setVisibility(8);
      long l;
      Object localObject3;
      label473:
      int i;
      float f2;
      float f1;
      if ((paramTimeLineObject.FQo != null) && (paramTimeLineObject.FQo.Etz.size() > 0))
      {
        l = System.nanoTime();
        boolean bool2 = f.t(localbtz);
        ac.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
        if (!bool2) {
          if (localf.w(localbtz))
          {
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.zbE.yFg.setVisibility(0);
            paramBaseViewHolder.zbE.yFg.fuE();
            if ((!parambf.yxA) || (!j.d(paramBaseViewHolder.timeLineObject))) {
              break label2186;
            }
            paramInt2 = 1;
            localObject2 = com.tencent.mm.modelsns.g.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.zbE.yFd.getUIContext(), false);
            localObject3 = new StringBuilder("isVerticalAdVideo=true, snsId=");
            if (parambf.xHc != null) {
              break label2171;
            }
            localObject1 = "";
            ac.i("MicroMsg.VideoTimeLineItem", localObject1 + ", showW=" + ((Pair)localObject2).first + ", showH=" + ((Pair)localObject2).second);
            localObject1 = localObject2;
            if (parambf.yxA)
            {
              localObject3 = parambf.xHc.dFR();
              i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject1 = localObject2;
                if (((com.tencent.mm.plugin.sns.storage.b)localObject3).yfW > 0.0F)
                {
                  localObject1 = localObject2;
                  if (((com.tencent.mm.plugin.sns.storage.b)localObject3).yfX > 0.0F)
                  {
                    f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).yfW, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfY, ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfZ);
                    f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).yfX, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfY, ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfZ);
                    if (((com.tencent.mm.plugin.sns.storage.b)localObject3).yfV != 0) {
                      break label2215;
                    }
                    if (f2 < i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12)) {
                      break label2641;
                    }
                    f2 = i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12);
                    f1 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject3).yfX * f2 / ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfW);
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
        if ((paramBaseViewHolder.zbE.yFd instanceof SightPlayImageView))
        {
          if (!parambf.yxA)
          {
            paramBaseViewHolder.zbE.yFd.setScaleMode(1);
            paramBaseViewHolder.zbE.yFd.setScaleType(QImageView.a.JbU);
          }
        }
        else
        {
          paramBaseViewHolder.zbE.yFd.hf(i, j);
          if ((paramBaseViewHolder.zbE.yFd instanceof SightPlayImageView))
          {
            if (paramInt2 == 0) {
              break label2474;
            }
            paramBaseViewHolder.zbE.yFd.xDO = true;
          }
          label870:
          paramBaseViewHolder.zbE.yFd.setVisibility(0);
          localObject2 = paramBaseViewHolder.zbE.yFh.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = i;
          ((ViewGroup.LayoutParams)localObject2).height = j;
          paramBaseViewHolder.zbE.yFh.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = (FrameLayout)paramBaseViewHolder.zbE.yFc.findViewById(2131305105);
          localObject3 = (FrameLayout.LayoutParams)((FrameLayout)localObject1).getLayoutParams();
          ((FrameLayout.LayoutParams)localObject3).width = i;
          ((FrameLayout.LayoutParams)localObject3).height = j;
          ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = paramBaseViewHolder.zbE.yFc.findViewById(2131305799);
          ((View)localObject3).setLayoutParams(new FrameLayout.LayoutParams((ViewGroup.LayoutParams)localObject2));
          ((View)localObject3).setVisibility(4);
          this.zfO = ((View)localObject1);
          localObject2 = d.dSq().awc(paramTimeLineObject.Id);
          ac.i("MicroMsg.VideoTimeLineItem", "lxl fill itemview check videoView reAttach, tlObjId:%s, vv:%s, count:%s", new Object[] { paramTimeLineObject.Id, localObject2, Integer.valueOf(((FrameLayout)localObject1).getChildCount()) });
          if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof ImageView)))
          {
            ((FrameLayout)localObject1).removeAllViews();
            ac.i("MicroMsg.VideoTimeLineItem", "find thumbView thne remove it %s", new Object[] { paramTimeLineObject.Id });
          }
          if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof SnsTimelineVideoView)))
          {
            localObject3 = (SnsTimelineVideoView)((FrameLayout)localObject1).getChildAt(0);
            if (!paramTimeLineObject.Id.equals(((SnsTimelineVideoView)localObject3).ziX))
            {
              ((FrameLayout)localObject1).removeAllViews();
              ac.i("MicroMsg.VideoTimeLineItem", "find diff id then remove it %s %s", new Object[] { paramTimeLineObject.Id, ((SnsTimelineVideoView)localObject3).ziX });
            }
          }
          if ((localObject2 == null) || (((FrameLayout)localObject1).getChildCount() != 0)) {
            break label2488;
          }
          if ((((SnsTimelineVideoView)localObject2).getParent() != null) && (((SnsTimelineVideoView)localObject2).getParent() != localObject1))
          {
            ((SnsTimelineVideoView)localObject2).zjb = true;
            ((ViewGroup)((SnsTimelineVideoView)localObject2).getParent()).removeView((View)localObject2);
            ((SnsTimelineVideoView)localObject2).setVisibility(0);
            ((SnsTimelineVideoView)localObject2).setVideoScaleType(h.e.DnK);
            ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
            ac.i("MicroMsg.VideoTimeLineItem", "lxl reAttach succ");
          }
          label1273:
          if (localObject2 != null)
          {
            localObject1 = paramBaseViewHolder.ddB;
            if (paramBaseViewHolder.timeLineObject != null) {
              break label2553;
            }
            paramInt2 = 0;
            ((SnsTimelineVideoView)localObject2).a(localbtz, (String)localObject1, paramInt2);
          }
          paramBaseViewHolder.zbE.yFd.setTagObject(paramBaseViewHolder.zbE);
          localObject1 = parambf.xHc;
          localObject2 = paramBaseViewHolder.zbE.yFd;
          paramInt2 = this.mActivity.hashCode();
          localObject3 = com.tencent.mm.storage.bf.fbk();
          ((com.tencent.mm.storage.bf)localObject3).gIh = paramTimeLineObject.CreateTime;
          localf.a((p)localObject1, localbtz, (VideoSightView)localObject2, paramInt2, paramInt1, (com.tencent.mm.storage.bf)localObject3, parambf.yxA, true);
          paramBaseViewHolder.zbE.yFf.setTag(paramBaseViewHolder.zbE);
          paramTimeLineObject = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), localbtz.Id);
          localObject1 = com.tencent.mm.plugin.sns.data.q.i(localbtz);
          if (!com.tencent.mm.vfs.i.eA(paramTimeLineObject + (String)localObject1)) {
            break label2565;
          }
          parambe.ySd.yxP.B(parambf.yUS, true);
          if (!parambf.yxA) {
            break label2590;
          }
          if (af.dHO().b(parambf.xHc, null) != 5) {
            break label2584;
          }
          bool1 = true;
          parambe.ySd.yxP.c(parambf.yUS, bool1, false);
        }
        for (;;)
        {
          if ((parambf.xHc != null) && (!parambf.xHc.dJL())) {
            parambe.dQx().c(paramBaseViewHolder.zbE.yFf, parambe.xZe.zgF, parambe.xZe.zgp);
          }
          AppMethodBeat.o(100126);
          return;
          localbtz = null;
          break;
          bool1 = ((d)localObject1).zjp.equals(localObject2);
          break label106;
          if ((parambf.yxA) && (localf.b(parambf.xHc, null) == 5))
          {
            localf.A(localbtz);
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.zbE.yFg.setVisibility(0);
            paramBaseViewHolder.zbE.yFg.fuE();
            break label410;
          }
          if (localf.x(localbtz))
          {
            paramBaseViewHolder.zbE.yFg.setVisibility(8);
            paramBaseViewHolder.zbE.yoI.setImageResource(2131234034);
            a(paramBaseViewHolder, 0, bool1);
            break label410;
          }
          localf.y(localbtz);
          a(paramBaseViewHolder, 0, bool1);
          paramBaseViewHolder.zbE.yFg.setVisibility(8);
          paramBaseViewHolder.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
          paramBaseViewHolder.zbE.yoI.setContentDescription(this.mActivity.getString(2131761939));
          if ((!parambf.yxA) && (localf.a(parambf.xHc, null) == 4))
          {
            paramBaseViewHolder.zbE.yoJ.setVisibility(0);
            break label410;
          }
          if ((!parambf.yxA) || (localf.b(parambf.xHc, null) != 4)) {
            break label410;
          }
          paramBaseViewHolder.zbE.yoJ.setVisibility(0);
          break label410;
          if (localf.u(localbtz))
          {
            a(paramBaseViewHolder, 0, bool1);
            paramBaseViewHolder.zbE.yFg.setVisibility(8);
            paramBaseViewHolder.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
            paramBaseViewHolder.zbE.yoI.setContentDescription(this.mActivity.getString(2131761939));
          }
          for (;;)
          {
            if (!paramBaseViewHolder.zbE.yFd.xDG.dEA()) {
              break label2169;
            }
            ac.e("MicroMsg.VideoTimeLineItem", "play video error " + localbtz.Id + " " + localbtz.Url + " " + localbtz.Fjh + " " + paramInt1);
            localf.y(localbtz);
            a(paramBaseViewHolder, 0, bool1);
            paramBaseViewHolder.zbE.yFg.setVisibility(8);
            paramBaseViewHolder.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
            paramBaseViewHolder.zbE.yoI.setContentDescription(this.mActivity.getString(2131761939));
            break;
            if (localf.v(localbtz))
            {
              a(paramBaseViewHolder, 8, bool1);
              paramBaseViewHolder.zbE.yFg.setVisibility(8);
            }
            else if ((parambf.yxA) && (localf.b(parambf.xHc, null) <= 5))
            {
              if (!this.zfL)
              {
                ac.i("MicroMsg.VideoTimeLineItem", "fillItem, showPlayBtn");
                dRM();
              }
            }
            else
            {
              localf.y(localbtz);
              a(paramBaseViewHolder, 0, bool1);
              paramBaseViewHolder.zbE.yFg.setVisibility(8);
              paramBaseViewHolder.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
              paramBaseViewHolder.zbE.yoI.setContentDescription(this.mActivity.getString(2131761939));
            }
          }
          label2169:
          break label410;
          label2171:
          localObject1 = Long.valueOf(parambf.xHc.field_snsId);
          break label473;
          localObject2 = com.tencent.mm.modelsns.g.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.zbE.yFd.getUIContext(), parambf.yxA);
          paramInt2 = 0;
          break label516;
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).yfV == 1)
          {
            i = i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12);
            localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfX / ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfW)));
            paramBaseViewHolder.zdj.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
            break label757;
          }
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).yfV != 2) {
            break label757;
          }
          i = i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12);
          localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfX / ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfW)));
          paramBaseViewHolder.zdj.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
          break label757;
          if (paramInt2 != 0)
          {
            paramBaseViewHolder.zbE.yFd.setScaleMode(1);
            paramBaseViewHolder.zbE.yFd.setScaleType(QImageView.a.JbU);
            break label827;
          }
          paramBaseViewHolder.zbE.yFd.setScaleMode(0);
          paramBaseViewHolder.zbE.yFd.setScaleType(QImageView.a.JbP);
          break label827;
          paramBaseViewHolder.zbE.yFd.setDrawWidthAndHeightFix(false);
          break label870;
          if ((bool1) || (((FrameLayout)localObject1).getChildCount() <= 0) || (d.dSq().awa(paramTimeLineObject.Id))) {
            break label1273;
          }
          l = System.currentTimeMillis();
          ((FrameLayout)localObject1).removeViewAt(0);
          ac.i("MicroMsg.VideoTimeLineItem", "lxl item remove videoview cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          break label1273;
          label2553:
          paramInt2 = paramBaseViewHolder.timeLineObject.CreateTime;
          break label1294;
          parambe.ySd.yxP.B(parambf.yUS, false);
          break label1456;
          bool1 = false;
          break label1481;
          if (af.dHO().a(parambf.xHc, null) == 5)
          {
            bool1 = true;
            break label1481;
          }
          bool1 = false;
          break label1481;
          localf.a(paramBaseViewHolder.zbE.yFd, this.mActivity.hashCode(), paramInt1);
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
    this.zfN = paramBaseViewHolder;
    if (paramBaseViewHolder.zdm != null)
    {
      paramBaseViewHolder.zdm.setLayoutResource(2131495566);
      paramBaseViewHolder.zed = ((ViewStub)paramBaseViewHolder.sSS.findViewById(2131300969));
      if (!paramBaseViewHolder.zee) {
        paramBaseViewHolder.zbE.yFc = paramBaseViewHolder.zed.inflate();
      }
    }
    for (paramBaseViewHolder.zee = true;; paramBaseViewHolder.zee = true)
    {
      paramBaseViewHolder.zbE.yFf = paramBaseViewHolder.zbE.yFc.findViewById(2131298069);
      paramBaseViewHolder.zbE.yFd = ((VideoSightView)paramBaseViewHolder.zbE.yFc.findViewById(2131300914));
      paramBaseViewHolder.zbE.yFd.setMute(true);
      paramBaseViewHolder.zbE.yFf.setOnClickListener(this.zcq);
      paramBaseViewHolder.zbE.yoI = ((ImageView)paramBaseViewHolder.zbE.yFc.findViewById(2131305196));
      paramBaseViewHolder.zbE.yFg = ((MMPinProgressBtn)paramBaseViewHolder.zbE.yFc.findViewById(2131303515));
      paramBaseViewHolder.zbE.yFh = ((TextView)paramBaseViewHolder.zbE.yFc.findViewById(2131299492));
      paramBaseViewHolder.zbE.yoJ = ((TextView)paramBaseViewHolder.zbE.yFc.findViewById(2131299517));
      com.tencent.mm.kernel.g.agS();
      if (((Boolean)com.tencent.mm.kernel.g.agR().agA().get(344065, Boolean.FALSE)).booleanValue())
      {
        localObject = (TextView)((ViewStub)paramBaseViewHolder.zbE.yFc.findViewById(2131304813)).inflate();
        paramBaseViewHolder.zbE.yFd.setSightInfoView((TextView)localObject);
      }
      AppMethodBeat.o(100125);
      return;
      paramBaseViewHolder.zbE.yFc = paramBaseViewHolder.sSS.findViewById(2131305005);
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(100129);
    if (this.zfO != null)
    {
      Object localObject = new int[2];
      this.zfO.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.zfO.getMeasuredWidth() + i, this.zfO.getMeasuredHeight() + j);
      AppMethodBeat.o(100129);
      return localObject;
    }
    AppMethodBeat.o(100129);
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177697);
    ac.i("MicroMsg.VideoTimeLineItem", "onUIPause");
    dRO();
    AppMethodBeat.o(177697);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176432);
    ac.i("MicroMsg.VideoTimeLineItem", "pause");
    dRO();
    dRM();
    AppMethodBeat.o(176432);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176433);
    ac.i("MicroMsg.VideoTimeLineItem", "%s Ad Video stop", new Object[] { this });
    if ((this.zfN != null) && (this.zfN.zbE != null)) {
      this.zfN.zbE.yFd.xDG.clear();
    }
    this.zeB = false;
    AppMethodBeat.o(176433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.l
 * JD-Core Version:    0.7.0.1
 */