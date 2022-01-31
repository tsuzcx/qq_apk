package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
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
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.LinkedList;

public final class k
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private int mScreenHeight;
  private int mScreenWidth;
  private b.e siQ;
  View siR;
  private String siS;
  View siT;
  
  public k()
  {
    AppMethodBeat.i(40169);
    this.siQ = new k.1(this);
    this.siR = null;
    this.siS = "";
    this.siT = null;
    AppMethodBeat.o(40169);
  }
  
  private static void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(145742);
    if (paramBoolean)
    {
      ab.i("MicroMsg.VideoTimeLineItem", "lxl setVideoStatusIvVisibility %s, but isPlaying", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(145742);
      return;
    }
    paramBaseViewHolder.sfG.rwJ.setVisibility(paramInt);
    AppMethodBeat.o(145742);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, aw paramaw, TimeLineObject paramTimeLineObject, int paramInt2, av paramav)
  {
    AppMethodBeat.i(40171);
    bcs localbcs;
    Object localObject1;
    Object localObject2;
    if ((paramTimeLineObject.xTS != null) && (paramTimeLineObject.xTS.wOa.size() > 0))
    {
      localbcs = (bcs)paramTimeLineObject.xTS.wOa.get(0);
      ab.i("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", new Object[] { Integer.valueOf(paramInt1) });
      localObject1 = c.cxv();
      localObject2 = paramTimeLineObject.Id;
      if ((!bo.isNullOrNil(((c)localObject1).smj)) && (!bo.isNullOrNil((String)localObject2))) {
        break label1390;
      }
      bool1 = false;
      label96:
      if (!bool1) {
        break label2464;
      }
    }
    label1293:
    label2461:
    label2464:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.siS = paramTimeLineObject.Id;
      this.siT = paramBaseViewHolder.sfG.rwJ;
      localObject2 = ag.cpf().abu(paramBaseViewHolder.czw);
      long l;
      label219:
      com.tencent.mm.plugin.sns.model.g localg;
      label363:
      Object localObject3;
      if ((paramaw.rEX) && (localbcs != null))
      {
        l = paramaw.rZw;
        paramBaseViewHolder.sfG.qVe.setOnCompletionListener(new k.2(this, paramav, l));
        if (!paramav.rWP.rFk.lj(l)) {
          paramBaseViewHolder.sfG.qVe.setOnDecodeDurationListener(new k.3(this, paramav, l, paramBaseViewHolder));
        }
        paramBaseViewHolder.sfG.a(paramTimeLineObject, paramInt1, paramaw.rGx, paramaw.rEX);
        paramBaseViewHolder.sfG.rwK.setVisibility(8);
        localg = ag.cpc();
        if ((paramTimeLineObject.xTS == null) || (paramTimeLineObject.xTS.wOa.size() <= 0)) {
          break label2438;
        }
        l = System.nanoTime();
        boolean bool2 = com.tencent.mm.plugin.sns.model.g.t(localbcs);
        ab.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
        if (bool2) {
          break label1721;
        }
        if (!localg.w(localbcs)) {
          break label1486;
        }
        a(paramBaseViewHolder, 8, bool1);
        paramBaseViewHolder.sfG.rLF.setVisibility(0);
        paramBaseViewHolder.sfG.rLF.dOF();
        localObject1 = com.tencent.mm.modelsns.e.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.sfG.qVe.getUIContext(), paramaw.rEX);
        if (!paramaw.rEX) {
          break label2461;
        }
        localObject3 = paramaw.qXp.csb();
        paramInt2 = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
        if ((localObject3 == null) || (((com.tencent.mm.plugin.sns.storage.b)localObject3).rqr <= 0.0F) || (((com.tencent.mm.plugin.sns.storage.b)localObject3).rqs <= 0.0F)) {
          break label2461;
        }
        float f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).rqr, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).rqt, ((com.tencent.mm.plugin.sns.storage.b)localObject3).rqu);
        float f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).rqs, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).rqt, ((com.tencent.mm.plugin.sns.storage.b)localObject3).rqu);
        if (((com.tencent.mm.plugin.sns.storage.b)localObject3).rqq != 0) {
          break label2082;
        }
        float f1 = f3;
        if (f3 >= paramInt2 - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12))
        {
          f1 = paramInt2 - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
          f2 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject3).rqs * f1 / ((com.tencent.mm.plugin.sns.storage.b)localObject3).rqr);
        }
        localObject1 = Pair.create(Integer.valueOf((int)f1), Integer.valueOf((int)f2));
      }
      for (;;)
      {
        label617:
        paramInt2 = ((Integer)((Pair)localObject1).first).intValue();
        int i = ((Integer)((Pair)localObject1).second).intValue();
        if ((paramBaseViewHolder.sfG.qVe instanceof SightPlayImageView))
        {
          if (!paramaw.rEX)
          {
            ((SightPlayImageView)paramBaseViewHolder.sfG.qVe).setScaleMode(1);
            ((SightPlayImageView)paramBaseViewHolder.sfG.qVe).setScaleType(QImageView.a.AED);
          }
        }
        else
        {
          label693:
          paramBaseViewHolder.sfG.qVe.ft(paramInt2, i);
          ((View)paramBaseViewHolder.sfG.qVe).setVisibility(0);
          localObject3 = paramBaseViewHolder.sfG.rLG.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = paramInt2;
          ((ViewGroup.LayoutParams)localObject3).height = i;
          paramBaseViewHolder.sfG.rLG.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject1 = (FrameLayout)paramBaseViewHolder.sfG.rLD.findViewById(2131828027);
          Object localObject4 = (FrameLayout.LayoutParams)((FrameLayout)localObject1).getLayoutParams();
          ((FrameLayout.LayoutParams)localObject4).width = paramInt2;
          ((FrameLayout.LayoutParams)localObject4).height = i;
          ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          localObject4 = paramBaseViewHolder.sfG.rLD.findViewById(2131828026);
          ((View)localObject4).setLayoutParams(new FrameLayout.LayoutParams((ViewGroup.LayoutParams)localObject3));
          ((View)localObject4).setVisibility(4);
          this.siR = ((View)localObject1);
          localObject3 = c.cxv().acu(paramTimeLineObject.Id);
          ab.i("MicroMsg.VideoTimeLineItem", "lxl fill itemview check videoView reAttach, tlObjId:%s, vv:%s, count:%s", new Object[] { paramTimeLineObject.Id, localObject3, Integer.valueOf(((FrameLayout)localObject1).getChildCount()) });
          if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof ImageView)))
          {
            ((FrameLayout)localObject1).removeAllViews();
            ab.i("MicroMsg.VideoTimeLineItem", "find thumbView thne remove it %s", new Object[] { paramTimeLineObject.Id });
          }
          if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof SnsTimelineVideoView)))
          {
            localObject4 = (SnsTimelineVideoView)((FrameLayout)localObject1).getChildAt(0);
            if (!paramTimeLineObject.Id.equals(((SnsTimelineVideoView)localObject4).slU))
            {
              ((FrameLayout)localObject1).removeAllViews();
              ab.i("MicroMsg.VideoTimeLineItem", "find diff id then remove it %s %s", new Object[] { paramTimeLineObject.Id, ((SnsTimelineVideoView)localObject4).slU });
            }
          }
          if ((localObject3 == null) || (((FrameLayout)localObject1).getChildCount() != 0)) {
            break label2311;
          }
          if ((((SnsTimelineVideoView)localObject3).getParent() != null) && (((SnsTimelineVideoView)localObject3).getParent() != localObject1))
          {
            ((SnsTimelineVideoView)localObject3).slY = true;
            ((ViewGroup)((SnsTimelineVideoView)localObject3).getParent()).removeView((View)localObject3);
            ((SnsTimelineVideoView)localObject3).setVisibility(0);
            ((SnsTimelineVideoView)localObject3).setVideoScaleType(h.d.vQL);
            ((FrameLayout)localObject1).addView((View)localObject3, new FrameLayout.LayoutParams(-1, -1));
            ab.i("MicroMsg.VideoTimeLineItem", "lxl reAttach succ");
          }
          label1115:
          if (localObject3 != null)
          {
            localObject1 = paramBaseViewHolder.crk;
            if (paramBaseViewHolder.timeLineObject != null) {
              break label2376;
            }
            paramInt2 = 0;
            label1136:
            ((SnsTimelineVideoView)localObject3).a(localbcs, (String)localObject1, paramInt2);
          }
          paramBaseViewHolder.sfG.qVe.setTagObject(paramBaseViewHolder.sfG);
          localObject1 = paramBaseViewHolder.sfG.qVe;
          paramInt2 = this.mActivity.hashCode();
          localObject3 = az.dxB();
          ((az)localObject3).oLs = paramTimeLineObject.CreateTime;
          localg.a((n)localObject2, localbcs, (com.tencent.mm.plugin.sight.decode.a.a)localObject1, paramInt2, paramInt1, (az)localObject3, paramaw.rEX);
          paramBaseViewHolder.sfG.rLE.setTag(paramBaseViewHolder.sfG);
          paramTimeLineObject = ao.gl(ag.getAccSnsPath(), localbcs.Id);
          localObject1 = com.tencent.mm.plugin.sns.data.i.j(localbcs);
          if (!com.tencent.mm.vfs.e.cN(paramTimeLineObject + (String)localObject1)) {
            break label2388;
          }
          paramav.rWP.rFk.w(paramaw.rZw, true);
          if (!paramaw.rEX) {
            break label2413;
          }
          if (ag.cpc().b((n)localObject2, null) != 5) {
            break label2407;
          }
          bool1 = true;
          label1316:
          paramav.rWP.rFk.c(paramaw.rZw, bool1, false);
        }
        for (;;)
        {
          if ((localObject2 != null) && (!((n)localObject2).cqp())) {
            paramav.jVd.c(paramBaseViewHolder.sfG.rLE, paramav.rks.sjH, paramav.rks.sjr);
          }
          AppMethodBeat.o(40171);
          return;
          localbcs = null;
          break;
          label1390:
          bool1 = ((c)localObject1).smj.equals(localObject2);
          break label96;
          if (paramBaseViewHolder.sfG == null) {
            break label219;
          }
          if (paramBaseViewHolder.sfG.rLG != null) {
            paramBaseViewHolder.sfG.rLG.setVisibility(8);
          }
          if (paramBaseViewHolder.sfG.qVe == null) {
            break label219;
          }
          paramBaseViewHolder.sfG.qVe.setOnSightCompletionAction(null);
          paramBaseViewHolder.sfG.qVe.setOnCompletionListener(null);
          paramBaseViewHolder.sfG.qVe.setOnDecodeDurationListener(null);
          break label219;
          label1486:
          if ((paramaw.rEX) && (localg.b((n)localObject2, null) == 5))
          {
            localg.A(localbcs);
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.sfG.rLF.setVisibility(0);
            paramBaseViewHolder.sfG.rLF.dOF();
            break label363;
          }
          if (localg.x(localbcs))
          {
            paramBaseViewHolder.sfG.rLF.setVisibility(8);
            paramBaseViewHolder.sfG.rwJ.setImageResource(2130840321);
            a(paramBaseViewHolder, 0, bool1);
            break label363;
          }
          localg.y(localbcs);
          a(paramBaseViewHolder, 0, bool1);
          paramBaseViewHolder.sfG.rLF.setVisibility(8);
          paramBaseViewHolder.sfG.rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
          paramBaseViewHolder.sfG.rwJ.setContentDescription(this.mActivity.getString(2131302100));
          if ((!paramaw.rEX) && (localg.a((n)localObject2, null) == 4))
          {
            paramBaseViewHolder.sfG.rwK.setVisibility(0);
            break label363;
          }
          if ((!paramaw.rEX) || (localg.b((n)localObject2, null) != 4)) {
            break label363;
          }
          paramBaseViewHolder.sfG.rwK.setVisibility(0);
          break label363;
          label1721:
          if (localg.u(localbcs))
          {
            a(paramBaseViewHolder, 0, bool1);
            paramBaseViewHolder.sfG.rLF.setVisibility(8);
            paramBaseViewHolder.sfG.rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
            paramBaseViewHolder.sfG.rwJ.setContentDescription(this.mActivity.getString(2131302100));
          }
          for (;;)
          {
            if (!paramBaseViewHolder.sfG.qVe.cmy()) {
              break label2080;
            }
            ab.d("MicroMsg.VideoTimeLineItem", "play video error " + localbcs.Id + " " + localbcs.Url + " " + localbcs.xrS + " " + paramInt1);
            localg.y(localbcs);
            a(paramBaseViewHolder, 0, bool1);
            paramBaseViewHolder.sfG.rLF.setVisibility(8);
            paramBaseViewHolder.sfG.rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
            paramBaseViewHolder.sfG.rwJ.setContentDescription(this.mActivity.getString(2131302100));
            break;
            if (localg.v(localbcs))
            {
              a(paramBaseViewHolder, 8, bool1);
              paramBaseViewHolder.sfG.rLF.setVisibility(8);
            }
            else if ((paramaw.rEX) && (localg.b((n)localObject2, null) <= 5))
            {
              a(paramBaseViewHolder, 8, bool1);
              paramBaseViewHolder.sfG.rLF.setVisibility(8);
            }
            else
            {
              localg.y(localbcs);
              a(paramBaseViewHolder, 0, bool1);
              paramBaseViewHolder.sfG.rLF.setVisibility(8);
              paramBaseViewHolder.sfG.rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
              paramBaseViewHolder.sfG.rwJ.setContentDescription(this.mActivity.getString(2131302100));
            }
          }
          label2080:
          break label363;
          label2082:
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).rqq == 1)
          {
            paramInt2 = paramInt2 - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
            localObject1 = Pair.create(Integer.valueOf(paramInt2), Integer.valueOf((int)(paramInt2 * ((com.tencent.mm.plugin.sns.storage.b)localObject3).rqs / ((com.tencent.mm.plugin.sns.storage.b)localObject3).rqr)));
            paramBaseViewHolder.sgQ.setLayoutParams(new LinearLayout.LayoutParams(paramInt2, -2));
            break label617;
          }
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).rqq != 2) {
            break label2461;
          }
          paramInt2 = paramInt2 - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
          localObject1 = Pair.create(Integer.valueOf(paramInt2), Integer.valueOf((int)(paramInt2 * ((com.tencent.mm.plugin.sns.storage.b)localObject3).rqs / ((com.tencent.mm.plugin.sns.storage.b)localObject3).rqr)));
          paramBaseViewHolder.sgQ.setLayoutParams(new LinearLayout.LayoutParams(paramInt2, -2));
          break label617;
          ((SightPlayImageView)paramBaseViewHolder.sfG.qVe).setScaleMode(0);
          ((SightPlayImageView)paramBaseViewHolder.sfG.qVe).setScaleType(QImageView.a.AEy);
          break label693;
          if ((bool1) || (((FrameLayout)localObject1).getChildCount() <= 0) || (c.cxv().acs(paramTimeLineObject.Id))) {
            break label1115;
          }
          l = System.currentTimeMillis();
          ((FrameLayout)localObject1).removeViewAt(0);
          ab.i("MicroMsg.VideoTimeLineItem", "lxl item remove videoview cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          break label1115;
          label2376:
          paramInt2 = paramBaseViewHolder.timeLineObject.CreateTime;
          break label1136;
          label2388:
          paramav.rWP.rFk.w(paramaw.rZw, false);
          break label1293;
          label2407:
          bool1 = false;
          break label1316;
          label2413:
          if (ag.cpc().a((n)localObject2, null) == 5)
          {
            bool1 = true;
            break label1316;
          }
          bool1 = false;
          break label1316;
          localg.a(paramBaseViewHolder.sfG.qVe, this.mActivity.hashCode());
        }
      }
    }
  }
  
  public final Rect cwV()
  {
    AppMethodBeat.i(145744);
    if (this.siR != null)
    {
      Object localObject = new int[2];
      this.siR.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.siR.getMeasuredWidth() + i, this.siR.getMeasuredHeight() + j);
      AppMethodBeat.o(145744);
      return localObject;
    }
    AppMethodBeat.o(145744);
    return null;
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40170);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.mScreenWidth = ((DisplayMetrics)localObject).widthPixels;
    this.mScreenHeight = ((DisplayMetrics)localObject).heightPixels;
    if (paramBaseViewHolder.sgT != null)
    {
      paramBaseViewHolder.sgT.setLayoutResource(2130970842);
      paramBaseViewHolder.shH = ((ViewStub)paramBaseViewHolder.ngZ.findViewById(2131827945));
      if (!paramBaseViewHolder.shI) {
        paramBaseViewHolder.sfG.rLD = paramBaseViewHolder.shH.inflate();
      }
    }
    for (paramBaseViewHolder.shI = true;; paramBaseViewHolder.shI = true)
    {
      paramBaseViewHolder.sfG.rLE = paramBaseViewHolder.sfG.rLD.findViewById(2131822580);
      paramBaseViewHolder.sfG.qVe = ((com.tencent.mm.plugin.sight.decode.a.a)paramBaseViewHolder.sfG.rLD.findViewById(2131820629));
      paramBaseViewHolder.sfG.rLE.setOnClickListener(this.rkX.rks.sjO);
      paramBaseViewHolder.sfG.rwJ = ((ImageView)paramBaseViewHolder.sfG.rLD.findViewById(2131820996));
      paramBaseViewHolder.sfG.rLF = ((MMPinProgressBtn)paramBaseViewHolder.sfG.rLD.findViewById(2131821404));
      paramBaseViewHolder.sfG.rLG = ((TextView)paramBaseViewHolder.sfG.rLD.findViewById(2131827795));
      paramBaseViewHolder.sfG.rwK = ((TextView)paramBaseViewHolder.sfG.rLD.findViewById(2131827796));
      com.tencent.mm.kernel.g.RM();
      if (((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(344065, Boolean.FALSE)).booleanValue())
      {
        localObject = (TextView)((ViewStub)paramBaseViewHolder.sfG.rLD.findViewById(2131822685)).inflate();
        paramBaseViewHolder.sfG.qVe.setSightInfoView((TextView)localObject);
      }
      AppMethodBeat.o(40170);
      return;
      paramBaseViewHolder.sfG.rLD = paramBaseViewHolder.ngZ.findViewById(2131828025);
    }
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    Object localObject2 = null;
    AppMethodBeat.i(145743);
    Object localObject3 = ag.cpf().abv(paramBaseViewHolder.crk);
    TimeLineObject localTimeLineObject = ((n)localObject3).csh();
    if ((localTimeLineObject.xTS != null) && (localTimeLineObject.xTS.wOa.size() > 0)) {}
    for (Object localObject1 = (bcs)localTimeLineObject.xTS.wOa.get(0); localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(145743);
      return;
    }
    com.tencent.mm.plugin.sns.ui.video.b localb = new com.tencent.mm.plugin.sns.ui.video.b();
    localb.cIc = ((bcs)localObject1);
    localb.crk = paramBaseViewHolder.crk;
    localb.czw = com.tencent.mm.plugin.sns.data.i.lq(((n)localObject3).field_snsId);
    localObject1 = ag.cpf().abu(paramBaseViewHolder.czw);
    if (localObject1 != null)
    {
      localb.fDT = ((n)localObject1).field_createTime;
      localObject3 = (FrameLayout)paramBaseViewHolder.sfG.rLD.findViewById(2131828027);
      localObject1 = localObject2;
      if (((FrameLayout)localObject3).getChildCount() > 0) {
        localObject1 = (SnsTimelineVideoView)((FrameLayout)localObject3).getChildAt(0);
      }
      if ((localObject1 == null) || (((SnsTimelineVideoView)localObject1).slT == null) || (((SnsTimelineVideoView)localObject1).slX) || (!bo.isEqual(localTimeLineObject.Id, ((SnsTimelineVideoView)localObject1).slU)) || (!bo.isEqual(((SnsTimelineVideoView)localObject1).slT.cIc.Id, localb.cIc.Id))) {
        break label360;
      }
      ab.i("MicroMsg.VideoTimeLineItem", "reuse videoview:%s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
    }
    for (;;)
    {
      ((SnsTimelineVideoView)localObject1).setVisibility(0);
      ((SnsTimelineVideoView)localObject1).setVideoScaleType(h.d.vQL);
      paramBaseViewHolder.sfG.rLD.findViewById(2131828026).setVisibility(8);
      if (paramBaseViewHolder.sfG.rwJ != null) {
        paramBaseViewHolder.sfG.rwJ.setVisibility(8);
      }
      ((SnsTimelineVideoView)localObject1).setUICallback(new k.4(this));
      c.cxv().a((OnlineVideoView)localObject1, localb, localTimeLineObject.Id);
      AppMethodBeat.o(145743);
      return;
      localb.fDT = ((int)(System.currentTimeMillis() / 1000L));
      break;
      label360:
      if (localObject1 != null) {
        ((FrameLayout)localObject3).removeViewAt(0);
      }
      localObject1 = c.cxv().eX(((FrameLayout)localObject3).getContext());
      if (((SnsTimelineVideoView)localObject1).getParent() != null) {
        ((ViewGroup)((SnsTimelineVideoView)localObject1).getParent()).removeView((View)localObject1);
      }
      ((FrameLayout)localObject3).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      ((SnsTimelineVideoView)localObject1).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.k
 * JD-Core Version:    0.7.0.1
 */