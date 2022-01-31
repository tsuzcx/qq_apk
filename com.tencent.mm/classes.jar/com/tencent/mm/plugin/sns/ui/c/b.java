package com.tencent.mm.plugin.sns.ui.c;

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
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  public final void a(a.c paramc, int paramInt1, ax paramax, bxk parambxk, int paramInt2, au paramau)
  {
    y.i("MiroMsg.CardAdTimeLineItem", "fill card ad item %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramc.dCs)
    {
      y.i("MiroMsg.CardAdTimeLineItem", "holder is busy");
      return;
    }
    paramc.dCs = true;
    Object localObject2 = (a)paramc;
    Object localObject3 = paramau.yy(paramInt1);
    ((a)localObject2).pnT.setVisibility(8);
    ((a)localObject2).plT.setVisibility(8);
    ((a)localObject2).pnS.setVisibility(8);
    ((a)localObject2).plZ.setVisibility(8);
    ((a)localObject2).plZ.setTag("");
    if (paramc.pmF != null) {
      paramc.pmF.setVisibility(8);
    }
    Object localObject1 = (WindowManager)this.mActivity.getSystemService("window");
    int j = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    ((a)paramc).pmH.setOnClickListener(paramau.ovx.ppf);
    localObject1 = new LinearLayout.LayoutParams(j - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.SmallPadding), -2);
    ((LinearLayout.LayoutParams)localObject1).topMargin = this.mActivity.getResources().getDimensionPixelSize(i.d.MiddlePadding);
    ((LinearLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2);
    ((a)paramc).pnL.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramau.iep.c(paramc.pmH, paramau.ovx.poR, paramau.ovx.poz);
    localObject1 = (RelativeLayout.LayoutParams)((a)localObject2).pmj.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = com.tencent.mm.cb.a.aa(this.mActivity, i.d.MiddlePadding);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cb.a.aa(this.mActivity, i.d.MiddlePadding);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.aa(this.mActivity, i.d.MiddlePadding);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.aa(this.mActivity, i.d.MiddlePadding);
    ((a)localObject2).pmj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (RelativeLayout.LayoutParams)paramc.plQ.oTG.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = com.tencent.mm.cb.a.aa(this.mActivity, i.d.MiddlePadding);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cb.a.aa(this.mActivity, i.d.MiddlePadding);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.aa(this.mActivity, i.d.MiddlePadding);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.aa(this.mActivity, i.d.MiddlePadding);
    paramc.plQ.oTG.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (RelativeLayout.LayoutParams)((a)localObject2).plZ.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = com.tencent.mm.cb.a.aa(this.mActivity, i.d.MiddlePadding);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.tencent.mm.cb.a.aa(this.mActivity, i.d.MiddlePadding);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.aa(this.mActivity, i.d.MiddlePadding);
    ((a)localObject2).plZ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((a)localObject2).pnL.setBackgroundResource(i.e.sns_ad_pic_style_bg);
    if (((a)localObject2).pnV != null) {
      ((a)localObject2).pnV.setVisibility(0);
    }
    label666:
    label722:
    label750:
    int i;
    label864:
    int k;
    int m;
    int n;
    label974:
    int i1;
    label1025:
    label1222:
    label1386:
    Object localObject4;
    if (((a)localObject2).pnU != null)
    {
      if (!bk.bl(((n)localObject3).bFZ().oBs)) {
        ((a)localObject2).pnU.setVisibility(0);
      }
    }
    else
    {
      localObject1 = ((n)localObject3).bGb();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).bEC()) && (!((n)localObject3).bGQ())) {
        ((a)localObject2).pnT.setVisibility(0);
      }
      if (!bk.bl(((n)localObject3).bFZ().oBt)) {
        break label1740;
      }
      localObject1 = parambxk.tNo;
      if (bk.bl((String)localObject1)) {
        break label1753;
      }
      ((a)localObject2).pnV.setText((String)localObject1 + " ");
      j.h(((a)localObject2).pnV, 2);
      ((a)localObject2).pnV.setVisibility(0);
      localObject1 = ((n)localObject3).bFZ().oBs;
      if (!bk.bl((String)localObject1)) {
        break label1766;
      }
      ((a)localObject2).pnU.setVisibility(8);
      ((a)localObject2).pnS.removeAllViews();
      if (((n)localObject3).bFZ().oBw.size() > 0)
      {
        ((a)localObject2).pnS.setVisibility(0);
        ((a)localObject2).pnS.setTagSpace(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 6));
        ((a)localObject2).pnS.cL(((n)localObject3).bFZ().oBw);
      }
      if (bk.bl(((n)localObject3).bFZ().oBu)) {
        break label1817;
      }
      ((a)localObject2).plZ.setVisibility(0);
      ((a)localObject2).pnR.setVisibility(0);
      ((a)localObject2).pnR.setText(((n)localObject3).bFZ().oBu);
      if (((n)localObject3).bFZ().oBg != 1) {
        break label1829;
      }
      paramInt2 = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50);
      i = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50);
      k = this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding);
      m = this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding);
      n = this.mActivity.getResources().getDimensionPixelSize(i.d.SmallPadding);
      paramc.pmF.setContentWidth(j - paramInt2 - i - k - m - n);
      paramc.pmF.bHj();
      ((a)localObject2).plZ.setTag(((n)localObject3).bFZ().oBv);
      if (bk.bl(((n)localObject3).bFZ().oBv)) {
        break label1928;
      }
      h.a(((n)localObject3).bFZ().oBv, new b.1(this, (a)localObject2));
      if ((((n)localObject3).bFZ().bEL()) || (((n)localObject3).bFZ().bEM()))
      {
        ((a)localObject2).plT.setVisibility(0);
        k = i.e.sns_card_select_btn_solid_white;
        m = Color.parseColor("#cdcdcd");
        n = Color.parseColor("#ffffff");
        i = 1;
        paramInt2 = i;
        if (((n)localObject3).bFZ().bEM())
        {
          i1 = v.eY(((n)localObject3).bFZ().oBH.oBR, ((n)localObject3).bGM());
          paramInt2 = i;
          if (i1 > 0)
          {
            paramInt2 = i;
            if (i1 <= 2)
            {
              if (i1 != 1) {
                break label1940;
              }
              ((a)localObject2).pnP.setBackgroundColor(n);
              ((a)localObject2).pnP.setTextColor(m);
              ((a)localObject2).pnP.setText(((n)localObject3).bFZ().oBH.ya(1));
              ((a)localObject2).pnO.setBackgroundResource(k);
              ((a)localObject2).pnO.setTextColor(-16777216);
              ((a)localObject2).pnO.setText(((n)localObject3).bFZ().oBH.xZ(0));
              paramInt2 = 0;
            }
          }
        }
        if (paramInt2 != 0)
        {
          ((a)localObject2).pnO.setTextColor(-16777216);
          ((a)localObject2).pnO.setBackgroundResource(k);
          ((a)localObject2).pnP.setTextColor(-16777216);
          ((a)localObject2).pnP.setBackgroundResource(k);
          ((a)localObject2).pnO.setText(((n)localObject3).bFZ().bEF());
          ((a)localObject2).pnP.setText(((n)localObject3).bFZ().bEG());
        }
      }
      ((a)localObject2).pmj.setScaleType(QImageView.a.wkS);
      ((SightPlayImageView)((a)localObject2).plQ.ogP).ofL = true;
      ((SightPlayImageView)((a)localObject2).plQ.ogP).setScaleType(QImageView.a.wkS);
      if ((parambxk.tNr == null) || (parambxk.tNr.sPJ.size() <= 0)) {
        break label2030;
      }
      localObject1 = (awd)parambxk.tNr.sPJ.get(0);
      paramc.plQ.a(parambxk, paramInt1, paramax.oOM, paramax.oNn);
      paramc.plQ.oGU.setVisibility(8);
      localObject4 = af.bDC();
      if (localObject1 != null)
      {
        paramInt2 = j - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.SmallPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.MiddlePadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.MiddlePadding);
        i = (int)(paramInt2 * ((awd)localObject1).trS.tsG / ((awd)localObject1).trS.tsF);
        if (paramc.plP.tNr.sPI != 1) {
          break label2036;
        }
        ((a)localObject2).pmj.setVisibility(0);
        ((a)localObject2).plQ.oTG.setVisibility(4);
        paramax = ((a)localObject2).pmj.getLayoutParams();
        paramax.width = paramInt2;
        paramax.height = i;
        ((a)localObject2).pmj.setLayoutParams(paramax);
        paramax = af.bDC();
        localObject3 = ((a)localObject2).pmj;
        paramInt1 = this.mActivity.hashCode();
        localObject4 = az.cuY();
        ((az)localObject4).time = parambxk.mPL;
        paramax.b((awd)localObject1, (View)localObject3, -1, paramInt1, (az)localObject4);
        ((a)localObject2).pmj.setTag(localObject2);
        ((a)localObject2).pnO.setTag(localObject2);
        ((a)localObject2).pnP.setTag(localObject2);
        ((a)localObject2).pmj.setOnClickListener(paramau.ovx.oPK);
        paramau.iep.c(((a)localObject2).pmj, paramau.ovx.poR, paramau.ovx.poz);
      }
    }
    for (;;)
    {
      paramc.dCs = false;
      return;
      ((a)localObject2).pnU.setVisibility(8);
      break;
      label1740:
      localObject1 = ((n)localObject3).bFZ().oBt;
      break label666;
      label1753:
      ((a)localObject2).pnV.setVisibility(8);
      break label722;
      label1766:
      ((a)localObject2).pnU.setText((String)localObject1 + " ");
      j.h(((a)localObject2).pnU, 2);
      ((a)localObject2).pnU.setVisibility(0);
      break label750;
      label1817:
      ((a)localObject2).pnR.setVisibility(4);
      break label864;
      label1829:
      if (((n)localObject3).bFZ().oBg != 2) {
        break label974;
      }
      paramInt2 = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50);
      i = this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding);
      k = this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding);
      m = this.mActivity.getResources().getDimensionPixelSize(i.d.SmallPadding);
      paramc.pmF.setContentWidth(j - paramInt2 - i - k - m);
      paramc.pmF.bHj();
      break label974;
      label1928:
      ((a)localObject2).pnQ.setVisibility(4);
      break label1025;
      label1940:
      if (i1 != 2) {
        break label1222;
      }
      ((a)localObject2).pnO.setBackgroundColor(n);
      ((a)localObject2).pnO.setTextColor(m);
      ((a)localObject2).pnO.setText(((n)localObject3).bFZ().oBH.ya(0));
      ((a)localObject2).pnP.setBackgroundResource(k);
      ((a)localObject2).pnP.setTextColor(-16777216);
      ((a)localObject2).pnP.setText(((n)localObject3).bFZ().oBH.xZ(1));
      break label1222;
      label2030:
      localObject1 = null;
      break label1386;
      label2036:
      if ((paramc.plP.tNr.sPI == 5) || (paramc.plP.tNr.sPI == 15))
      {
        ((a)localObject2).plQ.oTG.setVisibility(0);
        ((a)localObject2).pmj.setVisibility(4);
        paramau.iep.c(((a)localObject2).plQ.oTH, paramau.ovx.poR, paramau.ovx.poz);
        Object localObject5 = ((a)localObject2).plQ.oTG.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject5).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject5).height = i;
        ((a)localObject2).plQ.oTG.setLayoutParams((ViewGroup.LayoutParams)localObject5);
        ((a)localObject2).plQ.ogP.dL(paramInt2, i);
        ((a)localObject2).plQ.ogP.setOnCompletionListener(new b.2(this, paramau, paramax));
        if (!paramau.pec.oNB.fG(paramax.pgP)) {
          ((a)localObject2).plQ.ogP.setOnDecodeDurationListener(new b.3(this, paramau, paramax, (a)localObject2));
        }
        long l = System.nanoTime();
        boolean bool = com.tencent.mm.plugin.sns.model.g.t((awd)localObject1);
        y.i("MiroMsg.CardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
        localObject5 = ((a)localObject2).plQ;
        if (!bool) {
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).w((awd)localObject1))
          {
            ((aj)localObject5).oGT.setVisibility(8);
            ((aj)localObject5).oTI.setVisibility(0);
            ((aj)localObject5).oTI.cJO();
            ((a)localObject2).pnO.setTag(localObject2);
            ((a)localObject2).pnP.setTag(localObject2);
            ((aj)localObject5).ogP.setTagObject(localObject5);
            ((aj)localObject5).oTH.setTag(localObject2);
            localObject2 = ((aj)localObject5).ogP;
            paramInt2 = this.mActivity.hashCode();
            localObject5 = az.cuY();
            ((az)localObject5).time = parambxk.mPL;
            ((com.tencent.mm.plugin.sns.model.g)localObject4).a((n)localObject3, (awd)localObject1, (com.tencent.mm.plugin.sight.decode.a.a)localObject2, paramInt2, paramInt1, (az)localObject5, paramax.oNn, true);
            parambxk = an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK);
            localObject1 = com.tencent.mm.plugin.sns.data.i.j((awd)localObject1);
            if (!e.bK(parambxk + (String)localObject1)) {
              break label3048;
            }
            paramau.pec.oNB.r(paramax.pgP, true);
            if (af.bDC().b((n)localObject3, null) != 5) {
              break label3067;
            }
          }
        }
        label3067:
        for (bool = true;; bool = false)
        {
          paramau.pec.oNB.a(paramax.pgP, bool, false);
          break;
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).b((n)localObject3, null) == 5)
          {
            ((com.tencent.mm.plugin.sns.model.g)localObject4).A((awd)localObject1);
            ((aj)localObject5).oGT.setVisibility(8);
            ((aj)localObject5).oTI.setVisibility(0);
            ((aj)localObject5).oTI.cJO();
            break label2336;
          }
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).x((awd)localObject1))
          {
            ((aj)localObject5).oTI.setVisibility(8);
            ((aj)localObject5).oGT.setImageResource(i.e.sight_chat_error);
            ((aj)localObject5).oGT.setVisibility(0);
            break label2336;
          }
          ((com.tencent.mm.plugin.sns.model.g)localObject4).y((awd)localObject1);
          ((aj)localObject5).oGT.setVisibility(0);
          ((aj)localObject5).oTI.setVisibility(8);
          ((aj)localObject5).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
          ((aj)localObject5).oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).b((n)localObject3, null) != 4) {
            break label2336;
          }
          ((aj)localObject5).oGU.setVisibility(0);
          break label2336;
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).u((awd)localObject1))
          {
            ((aj)localObject5).oGT.setVisibility(0);
            ((aj)localObject5).oTI.setVisibility(8);
            ((aj)localObject5).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
            ((aj)localObject5).oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
          }
          for (;;)
          {
            if (!((aj)localObject5).ogP.bAY()) {
              break label3046;
            }
            y.d("MiroMsg.CardAdTimeLineItem", "play video error " + ((awd)localObject1).lsK + " " + ((awd)localObject1).kSC + " " + ((awd)localObject1).trP + " " + paramInt1);
            ((com.tencent.mm.plugin.sns.model.g)localObject4).y((awd)localObject1);
            ((aj)localObject5).oGT.setVisibility(0);
            ((aj)localObject5).oTI.setVisibility(8);
            ((aj)localObject5).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
            ((aj)localObject5).oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
            break;
            if (((com.tencent.mm.plugin.sns.model.g)localObject4).v((awd)localObject1))
            {
              ((aj)localObject5).oGT.setVisibility(8);
              ((aj)localObject5).oTI.setVisibility(8);
            }
            else if (((com.tencent.mm.plugin.sns.model.g)localObject4).b((n)localObject3, null) <= 5)
            {
              ((aj)localObject5).oGT.setVisibility(8);
              ((aj)localObject5).oTI.setVisibility(8);
            }
            else
            {
              ((com.tencent.mm.plugin.sns.model.g)localObject4).y((awd)localObject1);
              ((aj)localObject5).oGT.setVisibility(0);
              ((aj)localObject5).oTI.setVisibility(8);
              ((aj)localObject5).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
              ((aj)localObject5).oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
            }
          }
          break label2336;
          paramau.pec.oNB.r(paramax.pgP, false);
          break label2493;
        }
      }
      label2336:
      label2493:
      label3046:
      label3048:
      ((com.tencent.mm.plugin.sns.model.g)localObject4).a(paramc.plQ.ogP, this.mActivity.hashCode());
      paramc.plQ.oTJ.setVisibility(8);
      paramc.plQ.ogP.setOnSightCompletionAction(null);
      paramc.plQ.ogP.setOnCompletionListener(null);
      paramc.plQ.ogP.setOnDecodeDurationListener(null);
    }
  }
  
  public final void d(a.c paramc)
  {
    a locala = (a)paramc;
    if (paramc.pmI != null)
    {
      paramc.pmI.setLayoutResource(i.g.sns_ad_card_layout_item);
      if (!paramc.pmJ)
      {
        locala.pnL = ((ViewGroup)paramc.pmI.inflate());
        paramc.pmJ = true;
      }
    }
    for (;;)
    {
      locala.pnM = ((ViewGroup)locala.pnL.findViewById(i.f.media_container));
      locala.pnN = ((ViewGroup)locala.pnL.findViewById(i.f.other_container));
      locala.pmj = ((MaskImageView)locala.pnL.findViewById(i.f.sns_card_ad_image));
      locala.pmj.setOnClickListener(this.owd.ovx.oPK);
      this.owd.iep.c(locala.pmj, this.owd.ovx.poN, this.owd.ovx.poz);
      locala.pnV = ((TextView)locala.pnL.findViewById(i.f.desc_collapse_pic_style_tv));
      locala.pnV.setClickable(false);
      locala.pnV.setLongClickable(false);
      locala.pnU = ((TextView)locala.pnL.findViewById(i.f.desc_collapse_pic_style_title_tv));
      locala.pnU.setClickable(false);
      locala.pnU.setLongClickable(false);
      locala.plQ = new aj();
      locala.plQ.oTH = locala.pnL.findViewById(i.f.sns_card_ad_sight);
      locala.plQ.oTG = locala.plQ.oTH;
      locala.plQ.oTH.setOnClickListener(this.owd.ovx.poW);
      locala.plQ.ogP = ((com.tencent.mm.plugin.sight.decode.a.a)locala.plQ.oTH.findViewById(i.f.image));
      locala.plQ.oGT = ((ImageView)locala.plQ.oTH.findViewById(i.f.status_btn));
      locala.plQ.oTI = ((MMPinProgressBtn)locala.plQ.oTH.findViewById(i.f.progress));
      locala.plQ.oTJ = ((TextView)locala.plQ.oTH.findViewById(i.f.endtv));
      locala.plQ.oGU = ((TextView)locala.plQ.oTH.findViewById(i.f.errorTv));
      locala.plZ = locala.pnL.findViewById(i.f.sns_ad_card_header_container);
      locala.pnQ = ((ImageView)locala.pnL.findViewById(i.f.sns_ad_card_header_avatar));
      locala.pnR = ((TextView)locala.pnL.findViewById(i.f.sns_ad_card_header_title));
      locala.pnT = locala.pnL.findViewById(i.f.card_weapp_tag);
      locala.plT = locala.pnL.findViewById(i.f.card_btn_container);
      locala.pnO = ((Button)locala.pnL.findViewById(i.f.card_btn_left));
      locala.pnP = ((Button)locala.pnL.findViewById(i.f.card_btn_right));
      locala.pnO.setOnClickListener(this.owd.ovx.ppd);
      locala.pnP.setOnClickListener(this.owd.ovx.ppe);
      locala.pnS = ((SnsCardAdTagListView)locala.pnL.findViewById(i.f.card_ad_tag_list));
      locala.pnS.setActivityContext(this.mActivity);
      return;
      if (!paramc.pmJ)
      {
        locala.pnL = ((ViewGroup)paramc.kKz.findViewById(i.f.ad_card_container));
        paramc.pmJ = true;
      }
    }
  }
  
  public static class a
    extends a.c
  {
    public View plT;
    public View plZ;
    public MaskImageView pmj;
    public ViewGroup pnL;
    public ViewGroup pnM;
    public ViewGroup pnN;
    public Button pnO;
    public Button pnP;
    public ImageView pnQ;
    public TextView pnR;
    public SnsCardAdTagListView pnS;
    public View pnT;
    public TextView pnU;
    public TextView pnV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.b
 * JD-Core Version:    0.7.0.1
 */