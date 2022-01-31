package com.tencent.mm.plugin.sns.ui.c;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.LinkedList;

public final class k
  extends a
{
  private int mScreenHeight;
  private int mScreenWidth;
  private b.e poo = new k.1(this);
  
  public final void a(a.c paramc, int paramInt1, ax paramax, bxk parambxk, int paramInt2, au paramau)
  {
    awd localawd;
    n localn;
    label152:
    com.tencent.mm.plugin.sns.model.g localg;
    boolean bool;
    label300:
    Object localObject1;
    Object localObject2;
    if ((parambxk.tNr != null) && (parambxk.tNr.sPJ.size() > 0))
    {
      localawd = (awd)parambxk.tNr.sPJ.get(0);
      y.v("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", new Object[] { Integer.valueOf(paramInt1) });
      localn = af.bDF().OA(paramc.bRV);
      if ((!paramax.oNn) || (localawd == null)) {
        break label871;
      }
      long l = paramax.pgP;
      paramc.plQ.ogP.setOnCompletionListener(new k.2(this, paramau, l));
      if (!paramau.pec.oNB.fG(l)) {
        paramc.plQ.ogP.setOnDecodeDurationListener(new k.3(this, paramau, l, paramc));
      }
      paramc.plQ.a(parambxk, paramInt1, paramax.oOM, paramax.oNn);
      paramc.plQ.oGU.setVisibility(8);
      localg = af.bDC();
      if ((parambxk.tNr == null) || (parambxk.tNr.sPJ.size() <= 0)) {
        break label1799;
      }
      l = System.nanoTime();
      bool = com.tencent.mm.plugin.sns.model.g.t(localawd);
      y.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
      if (bool) {
        break label1172;
      }
      if (!localg.w(localawd)) {
        break label925;
      }
      paramc.plQ.oGT.setVisibility(8);
      paramc.plQ.oTI.setVisibility(0);
      paramc.plQ.oTI.cJO();
      localObject1 = com.tencent.mm.modelsns.e.a(paramc.plP, paramc.plQ.ogP.getUIContext(), paramax.oNn);
      if (!paramax.oNn) {
        break label1822;
      }
      localObject2 = paramax.oje.bFZ();
      paramInt2 = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
      if ((localObject2 == null) || (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh <= 0.0F) || (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi <= 0.0F)) {
        break label1822;
      }
      float f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBj, ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBk);
      float f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBj, ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBk);
      if (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBg != 0) {
        break label1553;
      }
      float f1 = f3;
      if (f3 >= paramInt2 - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12))
      {
        f1 = paramInt2 - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
        f2 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi * f1 / ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh);
      }
      localObject1 = Pair.create(Integer.valueOf((int)f1), Integer.valueOf((int)f2));
    }
    label779:
    label925:
    label1822:
    for (;;)
    {
      label553:
      paramInt2 = ((Integer)((Pair)localObject1).first).intValue();
      int i = ((Integer)((Pair)localObject1).second).intValue();
      paramc.plQ.ogP.dL(paramInt2, i);
      localObject1 = paramc.plQ.oTJ.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
      ((ViewGroup.LayoutParams)localObject1).height = i;
      paramc.plQ.oTJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramc.plQ.ogP.setTagObject(paramc.plQ);
      localObject1 = paramc.plQ.ogP;
      paramInt2 = this.mActivity.hashCode();
      localObject2 = az.cuY();
      ((az)localObject2).time = parambxk.mPL;
      localg.a(localn, localawd, (com.tencent.mm.plugin.sight.decode.a.a)localObject1, paramInt2, paramInt1, (az)localObject2, paramax.oNn);
      paramc.plQ.oTH.setTag(paramc.plQ);
      parambxk = an.eJ(af.getAccSnsPath(), localawd.lsK);
      localObject1 = com.tencent.mm.plugin.sns.data.i.j(localawd);
      if (com.tencent.mm.vfs.e.bK(parambxk + (String)localObject1))
      {
        paramau.pec.oNB.r(paramax.pgP, true);
        if (!paramax.oNn) {
          break label1774;
        }
        if (af.bDC().b(localn, null) != 5) {
          break label1768;
        }
        bool = true;
        label802:
        paramau.pec.oNB.a(paramax.pgP, bool, false);
      }
      for (;;)
      {
        if ((localn != null) && (!localn.bEJ())) {
          paramau.iep.c(paramc.plQ.oTH, paramau.ovx.poP, paramau.ovx.poz);
        }
        return;
        localawd = null;
        break;
        label871:
        paramc.plQ.oTJ.setVisibility(8);
        paramc.plQ.ogP.setOnSightCompletionAction(null);
        paramc.plQ.ogP.setOnCompletionListener(null);
        paramc.plQ.ogP.setOnDecodeDurationListener(null);
        break label152;
        if ((paramax.oNn) && (localg.b(localn, null) == 5))
        {
          localg.A(localawd);
          paramc.plQ.oGT.setVisibility(8);
          paramc.plQ.oTI.setVisibility(0);
          paramc.plQ.oTI.cJO();
          break label300;
        }
        if (localg.x(localawd))
        {
          paramc.plQ.oTI.setVisibility(8);
          paramc.plQ.oGT.setImageResource(i.e.sight_chat_error);
          paramc.plQ.oGT.setVisibility(0);
          break label300;
        }
        localg.y(localawd);
        paramc.plQ.oGT.setVisibility(0);
        paramc.plQ.oTI.setVisibility(8);
        paramc.plQ.oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
        paramc.plQ.oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
        if ((!paramax.oNn) && (localg.a(localn, null) == 4))
        {
          paramc.plQ.oGU.setVisibility(0);
          break label300;
        }
        if ((!paramax.oNn) || (localg.b(localn, null) != 4)) {
          break label300;
        }
        paramc.plQ.oGU.setVisibility(0);
        break label300;
        if (localg.u(localawd))
        {
          paramc.plQ.oGT.setVisibility(0);
          paramc.plQ.oTI.setVisibility(8);
          paramc.plQ.oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
          paramc.plQ.oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
        }
        for (;;)
        {
          if (!paramc.plQ.ogP.bAY()) {
            break label1551;
          }
          y.d("MicroMsg.VideoTimeLineItem", "play video error " + localawd.lsK + " " + localawd.kSC + " " + localawd.trP + " " + paramInt1);
          localg.y(localawd);
          paramc.plQ.oGT.setVisibility(0);
          paramc.plQ.oTI.setVisibility(8);
          paramc.plQ.oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
          paramc.plQ.oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
          break;
          if (localg.v(localawd))
          {
            paramc.plQ.oGT.setVisibility(8);
            paramc.plQ.oTI.setVisibility(8);
          }
          else if ((paramax.oNn) && (localg.b(localn, null) <= 5))
          {
            paramc.plQ.oGT.setVisibility(8);
            paramc.plQ.oTI.setVisibility(8);
          }
          else
          {
            localg.y(localawd);
            paramc.plQ.oGT.setVisibility(0);
            paramc.plQ.oTI.setVisibility(8);
            paramc.plQ.oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
            paramc.plQ.oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
          }
        }
        break label300;
        if (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBg == 1)
        {
          paramInt2 = paramInt2 - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
          localObject1 = Pair.create(Integer.valueOf(paramInt2), Integer.valueOf((int)(paramInt2 * ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi / ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh)));
          paramc.pmF.setLayoutParams(new LinearLayout.LayoutParams(paramInt2, -2));
          break label553;
        }
        if (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBg != 2) {
          break label1822;
        }
        paramInt2 = paramInt2 - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12);
        localObject1 = Pair.create(Integer.valueOf(paramInt2), Integer.valueOf((int)(paramInt2 * ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi / ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh)));
        paramc.pmF.setLayoutParams(new LinearLayout.LayoutParams(paramInt2, -2));
        break label553;
        paramau.pec.oNB.r(paramax.pgP, false);
        break label779;
        label1768:
        bool = false;
        break label802;
        label1774:
        if (af.bDC().a(localn, null) == 5)
        {
          bool = true;
          break label802;
        }
        bool = false;
        break label802;
        localg.a(paramc.plQ.ogP, this.mActivity.hashCode());
      }
    }
  }
  
  public final void d(a.c paramc)
  {
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.mScreenWidth = ((DisplayMetrics)localObject).widthPixels;
    this.mScreenHeight = ((DisplayMetrics)localObject).heightPixels;
    if (paramc.pmI != null)
    {
      paramc.pmI.setLayoutResource(i.g.sns_media_sight_item);
      paramc.pnw = ((ViewStub)paramc.kKz.findViewById(i.f.images_keeper_li));
      if (!paramc.pnx) {
        paramc.plQ.oTG = paramc.pnw.inflate();
      }
    }
    for (paramc.pnx = true;; paramc.pnx = true)
    {
      paramc.plQ.oTH = paramc.plQ.oTG.findViewById(i.f.chatting_click_area);
      paramc.plQ.ogP = ((com.tencent.mm.plugin.sight.decode.a.a)paramc.plQ.oTG.findViewById(i.f.image));
      paramc.plQ.oTH.setOnClickListener(this.owd.ovx.poW);
      paramc.plQ.oGT = ((ImageView)paramc.plQ.oTG.findViewById(i.f.status_btn));
      paramc.plQ.oTI = ((MMPinProgressBtn)paramc.plQ.oTG.findViewById(i.f.progress));
      paramc.plQ.oTJ = ((TextView)paramc.plQ.oTG.findViewById(i.f.endtv));
      paramc.plQ.oGU = ((TextView)paramc.plQ.oTG.findViewById(i.f.errorTv));
      com.tencent.mm.kernel.g.DQ();
      if (((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(344065, Boolean.valueOf(false))).booleanValue())
      {
        localObject = (TextView)((ViewStub)paramc.plQ.oTG.findViewById(i.f.sight_info_viewstub)).inflate();
        paramc.plQ.ogP.setSightInfoView((TextView)localObject);
      }
      return;
      paramc.plQ.oTG = paramc.kKz.findViewById(i.f.sns_media_sight_item);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.k
 * JD-Core Version:    0.7.0.1
 */