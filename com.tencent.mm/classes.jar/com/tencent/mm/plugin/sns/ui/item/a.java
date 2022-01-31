package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.b.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, aw paramaw, TimeLineObject paramTimeLineObject, int paramInt2, av paramav)
  {
    AppMethodBeat.i(40132);
    ab.i("MiroMsg.CardAdTimeLineItem", "fill card ad item %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramBaseViewHolder.ezJ)
    {
      ab.i("MiroMsg.CardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(40132);
      return;
    }
    paramBaseViewHolder.ezJ = true;
    Object localObject2 = (a.a)paramBaseViewHolder;
    Object localObject3 = paramav.EE(paramInt1);
    ((a.a)localObject2).sie.setVisibility(8);
    ((a.a)localObject2).sfJ.setVisibility(8);
    ((a.a)localObject2).sic.setVisibility(8);
    ((a.a)localObject2).sfP.setVisibility(8);
    ((a.a)localObject2).sfP.setTag("");
    if (paramBaseViewHolder.sgQ != null) {
      paramBaseViewHolder.sgQ.setVisibility(8);
    }
    Object localObject1 = (WindowManager)this.mActivity.getSystemService("window");
    int j = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    ((a.a)paramBaseViewHolder).sgS.setOnClickListener(paramav.rks.sjX);
    localObject1 = new LinearLayout.LayoutParams(j - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131427782) - this.mActivity.getResources().getDimensionPixelSize(2131427808) - this.mActivity.getResources().getDimensionPixelSize(2131427854), -2);
    ((LinearLayout.LayoutParams)localObject1).topMargin = this.mActivity.getResources().getDimensionPixelSize(2131427792);
    ((LinearLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2);
    ((a.a)paramBaseViewHolder).shV.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramav.jVd.c(paramBaseViewHolder.sgS, paramav.rks.sjJ, paramav.rks.sjr);
    localObject1 = (RelativeLayout.LayoutParams)((a.a)localObject2).sga.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = com.tencent.mm.cb.a.ao(this.mActivity, 2131427792);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cb.a.ao(this.mActivity, 2131427792);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.ao(this.mActivity, 2131427792);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.ao(this.mActivity, 2131427792);
    ((a.a)localObject2).sga.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (RelativeLayout.LayoutParams)paramBaseViewHolder.sfG.rLD.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = com.tencent.mm.cb.a.ao(this.mActivity, 2131427792);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cb.a.ao(this.mActivity, 2131427792);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.ao(this.mActivity, 2131427792);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.ao(this.mActivity, 2131427792);
    paramBaseViewHolder.sfG.rLD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (RelativeLayout.LayoutParams)((a.a)localObject2).sfP.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = com.tencent.mm.cb.a.ao(this.mActivity, 2131427792);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cb.a.ao(this.mActivity, 2131427792);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.ao(this.mActivity, 2131427792);
    ((a.a)localObject2).sfP.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((a.a)localObject2).shV.setBackgroundResource(2130840375);
    if (((a.a)localObject2).sig != null) {
      ((a.a)localObject2).sig.setVisibility(0);
    }
    label660:
    label716:
    label744:
    int i;
    label858:
    int k;
    int m;
    int n;
    label965:
    label1016:
    Object localObject4;
    if (((a.a)localObject2).sif != null)
    {
      if (!bo.isNullOrNil(((n)localObject3).csb().rqC)) {
        ((a.a)localObject2).sif.setVisibility(0);
      }
    }
    else
    {
      localObject1 = ((n)localObject3).csd();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).cqi()) && (!((n)localObject3).csT())) {
        ((a.a)localObject2).sie.setVisibility(0);
      }
      if (!bo.isNullOrNil(((n)localObject3).csb().rqD)) {
        break label1729;
      }
      localObject1 = paramTimeLineObject.xTP;
      if (bo.isNullOrNil((String)localObject1)) {
        break label1742;
      }
      ((a.a)localObject2).sig.setText((String)localObject1 + " ");
      j.k(((a.a)localObject2).sig, 2);
      ((a.a)localObject2).sig.setVisibility(0);
      localObject1 = ((n)localObject3).csb().rqC;
      if (!bo.isNullOrNil((String)localObject1)) {
        break label1755;
      }
      ((a.a)localObject2).sif.setVisibility(8);
      ((a.a)localObject2).sic.removeAllViews();
      if (((n)localObject3).csb().rqG.size() > 0)
      {
        ((a.a)localObject2).sic.setVisibility(0);
        ((a.a)localObject2).sic.setTagSpace(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 6));
        ((a.a)localObject2).sic.dx(((n)localObject3).csb().rqG);
      }
      if (bo.isNullOrNil(((n)localObject3).csb().rqE)) {
        break label1806;
      }
      ((a.a)localObject2).sfP.setVisibility(0);
      ((a.a)localObject2).sib.setVisibility(0);
      ((a.a)localObject2).sib.setText(((n)localObject3).csb().rqE);
      if (((n)localObject3).csb().rqq != 1) {
        break label1818;
      }
      paramInt2 = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54);
      i = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54);
      k = this.mActivity.getResources().getDimensionPixelSize(2131427782);
      m = this.mActivity.getResources().getDimensionPixelSize(2131427808);
      n = this.mActivity.getResources().getDimensionPixelSize(2131427854);
      paramBaseViewHolder.sgQ.setContentWidth(j - paramInt2 - i - k - m - n);
      paramBaseViewHolder.sgQ.ctn();
      ((a.a)localObject2).sfP.setTag(((n)localObject3).csb().rqF);
      if (bo.isNullOrNil(((n)localObject3).csb().rqF)) {
        break label1914;
      }
      h.a(((n)localObject3).csb().rqF, new a.1(this, (a.a)localObject2));
      if ((((n)localObject3).csb().cqr()) || (((n)localObject3).csb().cqs()))
      {
        ((a.a)localObject2).sfJ.setVisibility(0);
        k = Color.parseColor("#cdcdcd");
        m = Color.parseColor("#ffffff");
        i = 1;
        paramInt2 = i;
        if (((n)localObject3).csb().cqs())
        {
          n = v.gG(((n)localObject3).csb().rqS.rrk, ((n)localObject3).csP());
          paramInt2 = i;
          if (n > 0)
          {
            paramInt2 = i;
            if (n <= 2)
            {
              if (n != 1) {
                break label1926;
              }
              ((a.a)localObject2).shZ.setBackgroundColor(m);
              ((a.a)localObject2).shZ.setTextColor(k);
              ((a.a)localObject2).shZ.setText(((n)localObject3).csb().rqS.Eb(1));
              ((a.a)localObject2).shY.setBackgroundResource(2130840379);
              ((a.a)localObject2).shY.setTextColor(-16777216);
              ((a.a)localObject2).shY.setText(((n)localObject3).csb().rqS.Ea(0));
              label1209:
              paramInt2 = 0;
            }
          }
        }
        if (paramInt2 != 0)
        {
          ((a.a)localObject2).shY.setTextColor(-16777216);
          ((a.a)localObject2).shY.setBackgroundResource(2130840379);
          ((a.a)localObject2).shZ.setTextColor(-16777216);
          ((a.a)localObject2).shZ.setBackgroundResource(2130840379);
          ((a.a)localObject2).shY.setText(((n)localObject3).csb().cql());
          ((a.a)localObject2).shZ.setText(((n)localObject3).csb().cqm());
        }
      }
      ((a.a)localObject2).sga.setScaleType(QImageView.a.AED);
      ((SightPlayImageView)((a.a)localObject2).sfG.qVe).qTZ = true;
      ((SightPlayImageView)((a.a)localObject2).sfG.qVe).setScaleType(QImageView.a.AED);
      if ((paramTimeLineObject.xTS == null) || (paramTimeLineObject.xTS.wOa.size() <= 0)) {
        break label2017;
      }
      localObject1 = (bcs)paramTimeLineObject.xTS.wOa.get(0);
      label1375:
      paramBaseViewHolder.sfG.a(paramTimeLineObject, paramInt1, paramaw.rGx, paramaw.rEX);
      paramBaseViewHolder.sfG.rwK.setVisibility(8);
      localObject4 = ag.cpc();
      if (localObject1 != null)
      {
        paramInt2 = j - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131427808) - this.mActivity.getResources().getDimensionPixelSize(2131427808) - this.mActivity.getResources().getDimensionPixelSize(2131427854) - this.mActivity.getResources().getDimensionPixelSize(2131427792) - this.mActivity.getResources().getDimensionPixelSize(2131427792);
        i = (int)(paramInt2 * ((bcs)localObject1).xrV.xsI / ((bcs)localObject1).xrV.xsH);
        if (paramBaseViewHolder.timeLineObject.xTS.wNZ != 1) {
          break label2023;
        }
        ((a.a)localObject2).sga.setVisibility(0);
        ((a.a)localObject2).sfG.rLD.setVisibility(4);
        paramaw = ((a.a)localObject2).sga.getLayoutParams();
        paramaw.width = paramInt2;
        paramaw.height = i;
        ((a.a)localObject2).sga.setLayoutParams(paramaw);
        paramaw = ag.cpc();
        localObject3 = ((a.a)localObject2).sga;
        paramInt1 = this.mActivity.hashCode();
        localObject4 = az.dxB();
        ((az)localObject4).oLs = paramTimeLineObject.CreateTime;
        paramaw.b((bcs)localObject1, (View)localObject3, -1, paramInt1, (az)localObject4);
        ((a.a)localObject2).sga.setTag(localObject2);
        ((a.a)localObject2).shY.setTag(localObject2);
        ((a.a)localObject2).shZ.setTag(localObject2);
        ((a.a)localObject2).sga.setOnClickListener(paramav.rks.rHw);
        paramav.jVd.c(((a.a)localObject2).sga, paramav.rks.sjJ, paramav.rks.sjr);
      }
    }
    for (;;)
    {
      paramBaseViewHolder.ezJ = false;
      AppMethodBeat.o(40132);
      return;
      ((a.a)localObject2).sif.setVisibility(8);
      break;
      label1729:
      localObject1 = ((n)localObject3).csb().rqD;
      break label660;
      label1742:
      ((a.a)localObject2).sig.setVisibility(8);
      break label716;
      label1755:
      ((a.a)localObject2).sif.setText((String)localObject1 + " ");
      j.k(((a.a)localObject2).sif, 2);
      ((a.a)localObject2).sif.setVisibility(0);
      break label744;
      label1806:
      ((a.a)localObject2).sib.setVisibility(4);
      break label858;
      label1818:
      if (((n)localObject3).csb().rqq != 2) {
        break label965;
      }
      paramInt2 = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54);
      i = this.mActivity.getResources().getDimensionPixelSize(2131427782);
      k = this.mActivity.getResources().getDimensionPixelSize(2131427808);
      m = this.mActivity.getResources().getDimensionPixelSize(2131427854);
      paramBaseViewHolder.sgQ.setContentWidth(j - paramInt2 - i - k - m);
      paramBaseViewHolder.sgQ.ctn();
      break label965;
      label1914:
      ((a.a)localObject2).sia.setVisibility(4);
      break label1016;
      label1926:
      if (n != 2) {
        break label1209;
      }
      ((a.a)localObject2).shY.setBackgroundColor(m);
      ((a.a)localObject2).shY.setTextColor(k);
      ((a.a)localObject2).shY.setText(((n)localObject3).csb().rqS.Eb(0));
      ((a.a)localObject2).shZ.setBackgroundResource(2130840379);
      ((a.a)localObject2).shZ.setTextColor(-16777216);
      ((a.a)localObject2).shZ.setText(((n)localObject3).csb().rqS.Ea(1));
      break label1209;
      label2017:
      localObject1 = null;
      break label1375;
      label2023:
      if ((paramBaseViewHolder.timeLineObject.xTS.wNZ == 5) || (paramBaseViewHolder.timeLineObject.xTS.wNZ == 15))
      {
        ((a.a)localObject2).sfG.rLD.setVisibility(0);
        ((a.a)localObject2).sga.setVisibility(4);
        paramav.jVd.c(((a.a)localObject2).sfG.rLE, paramav.rks.sjJ, paramav.rks.sjr);
        Object localObject5 = ((a.a)localObject2).sfG.rLD.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject5).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject5).height = i;
        ((a.a)localObject2).sfG.rLD.setLayoutParams((ViewGroup.LayoutParams)localObject5);
        ((a.a)localObject2).sfG.qVe.ft(paramInt2, i);
        ((a.a)localObject2).sfG.qVe.setOnCompletionListener(new a.2(this, paramav, paramaw));
        if (!paramav.rWP.rFk.lj(paramaw.rZw)) {
          ((a.a)localObject2).sfG.qVe.setOnDecodeDurationListener(new a.3(this, paramav, paramaw, (a.a)localObject2));
        }
        long l = System.nanoTime();
        boolean bool = com.tencent.mm.plugin.sns.model.g.t((bcs)localObject1);
        ab.i("MiroMsg.CardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
        localObject5 = ((a.a)localObject2).sfG;
        if (!bool) {
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).w((bcs)localObject1))
          {
            ((aj)localObject5).rwJ.setVisibility(8);
            ((aj)localObject5).rLF.setVisibility(0);
            ((aj)localObject5).rLF.dOF();
            ((a.a)localObject2).shY.setTag(localObject2);
            ((a.a)localObject2).shZ.setTag(localObject2);
            ((aj)localObject5).qVe.setTagObject(localObject5);
            ((aj)localObject5).rLE.setTag(localObject2);
            localObject2 = ((aj)localObject5).qVe;
            paramInt2 = this.mActivity.hashCode();
            localObject5 = az.dxB();
            ((az)localObject5).oLs = paramTimeLineObject.CreateTime;
            ((com.tencent.mm.plugin.sns.model.g)localObject4).a((n)localObject3, (bcs)localObject1, (com.tencent.mm.plugin.sight.decode.a.a)localObject2, paramInt2, paramInt1, (az)localObject5, paramaw.rEX, true);
            paramTimeLineObject = ao.gl(ag.getAccSnsPath(), ((bcs)localObject1).Id);
            localObject1 = com.tencent.mm.plugin.sns.data.i.j((bcs)localObject1);
            if (!e.cN(paramTimeLineObject + (String)localObject1)) {
              break label3035;
            }
            paramav.rWP.rFk.w(paramaw.rZw, true);
            if (ag.cpc().b((n)localObject3, null) != 5) {
              break label3054;
            }
          }
        }
        label3054:
        for (bool = true;; bool = false)
        {
          paramav.rWP.rFk.c(paramaw.rZw, bool, false);
          break;
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).b((n)localObject3, null) == 5)
          {
            ((com.tencent.mm.plugin.sns.model.g)localObject4).A((bcs)localObject1);
            ((aj)localObject5).rwJ.setVisibility(8);
            ((aj)localObject5).rLF.setVisibility(0);
            ((aj)localObject5).rLF.dOF();
            break label2323;
          }
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).x((bcs)localObject1))
          {
            ((aj)localObject5).rLF.setVisibility(8);
            ((aj)localObject5).rwJ.setImageResource(2130840321);
            ((aj)localObject5).rwJ.setVisibility(0);
            break label2323;
          }
          ((com.tencent.mm.plugin.sns.model.g)localObject4).y((bcs)localObject1);
          ((aj)localObject5).rwJ.setVisibility(0);
          ((aj)localObject5).rLF.setVisibility(8);
          ((aj)localObject5).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
          ((aj)localObject5).rwJ.setContentDescription(this.mActivity.getString(2131302100));
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).b((n)localObject3, null) != 4) {
            break label2323;
          }
          ((aj)localObject5).rwK.setVisibility(0);
          break label2323;
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).u((bcs)localObject1))
          {
            ((aj)localObject5).rwJ.setVisibility(0);
            ((aj)localObject5).rLF.setVisibility(8);
            ((aj)localObject5).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
            ((aj)localObject5).rwJ.setContentDescription(this.mActivity.getString(2131302100));
          }
          for (;;)
          {
            if (!((aj)localObject5).qVe.cmy()) {
              break label3033;
            }
            ab.d("MiroMsg.CardAdTimeLineItem", "play video error " + ((bcs)localObject1).Id + " " + ((bcs)localObject1).Url + " " + ((bcs)localObject1).xrS + " " + paramInt1);
            ((com.tencent.mm.plugin.sns.model.g)localObject4).y((bcs)localObject1);
            ((aj)localObject5).rwJ.setVisibility(0);
            ((aj)localObject5).rLF.setVisibility(8);
            ((aj)localObject5).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
            ((aj)localObject5).rwJ.setContentDescription(this.mActivity.getString(2131302100));
            break;
            if (((com.tencent.mm.plugin.sns.model.g)localObject4).v((bcs)localObject1))
            {
              ((aj)localObject5).rwJ.setVisibility(8);
              ((aj)localObject5).rLF.setVisibility(8);
            }
            else if (((com.tencent.mm.plugin.sns.model.g)localObject4).b((n)localObject3, null) <= 5)
            {
              ((aj)localObject5).rwJ.setVisibility(8);
              ((aj)localObject5).rLF.setVisibility(8);
            }
            else
            {
              ((com.tencent.mm.plugin.sns.model.g)localObject4).y((bcs)localObject1);
              ((aj)localObject5).rwJ.setVisibility(0);
              ((aj)localObject5).rLF.setVisibility(8);
              ((aj)localObject5).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
              ((aj)localObject5).rwJ.setContentDescription(this.mActivity.getString(2131302100));
            }
          }
          break label2323;
          paramav.rWP.rFk.w(paramaw.rZw, false);
          break label2480;
        }
      }
      label2323:
      label2480:
      label3033:
      label3035:
      ((com.tencent.mm.plugin.sns.model.g)localObject4).a(paramBaseViewHolder.sfG.qVe, this.mActivity.hashCode());
      paramBaseViewHolder.sfG.rLG.setVisibility(8);
      paramBaseViewHolder.sfG.qVe.setOnSightCompletionAction(null);
      paramBaseViewHolder.sfG.qVe.setOnCompletionListener(null);
      paramBaseViewHolder.sfG.qVe.setOnDecodeDurationListener(null);
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40131);
    a.a locala = (a.a)paramBaseViewHolder;
    if (paramBaseViewHolder.sgT != null)
    {
      paramBaseViewHolder.sgT.setLayoutResource(2130970772);
      if (!paramBaseViewHolder.sgU)
      {
        locala.shV = ((ViewGroup)paramBaseViewHolder.sgT.inflate());
        paramBaseViewHolder.sgU = true;
      }
    }
    for (;;)
    {
      locala.shW = ((ViewGroup)locala.shV.findViewById(2131827828));
      locala.shX = ((ViewGroup)locala.shV.findViewById(2131827831));
      locala.sga = ((MaskImageView)locala.shV.findViewById(2131827829));
      locala.sga.setOnClickListener(this.rkX.rks.rHw);
      this.rkX.jVd.c(locala.sga, this.rkX.rks.sjF, this.rkX.rks.sjr);
      locala.sig = ((TextView)locala.shV.findViewById(2131827833));
      locala.sig.setClickable(false);
      locala.sig.setLongClickable(false);
      locala.sif = ((TextView)locala.shV.findViewById(2131827832));
      locala.sif.setClickable(false);
      locala.sif.setLongClickable(false);
      locala.sfG = new aj();
      locala.sfG.rLE = locala.shV.findViewById(2131827830);
      locala.sfG.rLD = locala.sfG.rLE;
      locala.sfG.rLE.setOnClickListener(this.rkX.rks.sjO);
      locala.sfG.qVe = ((com.tencent.mm.plugin.sight.decode.a.a)locala.sfG.rLE.findViewById(2131820629));
      locala.sfG.rwJ = ((ImageView)locala.sfG.rLE.findViewById(2131820996));
      locala.sfG.rLF = ((MMPinProgressBtn)locala.sfG.rLE.findViewById(2131821404));
      locala.sfG.rLG = ((TextView)locala.sfG.rLE.findViewById(2131827795));
      locala.sfG.rwK = ((TextView)locala.sfG.rLE.findViewById(2131827796));
      locala.sfP = locala.shV.findViewById(2131828110);
      locala.sia = ((ImageView)locala.shV.findViewById(2131828111));
      locala.sib = ((TextView)locala.shV.findViewById(2131828112));
      locala.sie = locala.shV.findViewById(2131827838);
      locala.sfJ = locala.shV.findViewById(2131827835);
      locala.shY = ((Button)locala.shV.findViewById(2131827836));
      locala.shZ = ((Button)locala.shV.findViewById(2131827837));
      locala.shY.setOnClickListener(this.rkX.rks.sjV);
      locala.shZ.setOnClickListener(this.rkX.rks.sjW);
      locala.sic = ((SnsCardAdTagListView)locala.shV.findViewById(2131827834));
      locala.sic.setActivityContext(this.mActivity);
      AppMethodBeat.o(40131);
      return;
      if (!paramBaseViewHolder.sgU)
      {
        locala.shV = ((ViewGroup)paramBaseViewHolder.ngZ.findViewById(2131827827));
        paramBaseViewHolder.sgU = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a
 * JD-Core Version:    0.7.0.1
 */