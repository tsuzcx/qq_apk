package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.timeline.a.f;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.a.b;
import com.tencent.mm.plugin.sns.storage.b.d;
import com.tencent.mm.plugin.sns.storage.b.l;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.as.b;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private a ANF;
  private as ANG;
  private au ANH;
  private boolean ANI = false;
  private p zlW;
  private String zrS = "";
  
  private void U(p paramp)
  {
    AppMethodBeat.i(220084);
    if ((this.zGX != null) && (this.zGX.AAQ != null) && (this.zGX.AAQ.Agi != null) && (paramp != null)) {
      this.zGX.AAQ.Agi.zP(paramp.field_snsId);
    }
    AppMethodBeat.o(220084);
  }
  
  private boolean ehM()
  {
    AppMethodBeat.i(177693);
    if ((this.ANF.timeLineObject.HUG.Gtw == 5) || (this.ANF.timeLineObject.HUG.Gtw == 15))
    {
      ae.i("MiroMsg.CardAdTimeLineItem", "%s cardAd doPause", new Object[] { this });
      if ((this.ANF != null) && (this.ANF.AKJ != null))
      {
        this.ANF.AKJ.AnH.pause();
        U(this.zlW);
      }
      this.ANI = false;
      AppMethodBeat.o(177693);
      return true;
    }
    AppMethodBeat.o(177693);
    return false;
  }
  
  private void ehN()
  {
    AppMethodBeat.i(176415);
    ae.i("MiroMsg.CardAdTimeLineItem", "try show play btn");
    if ((this.ANF != null) && (this.ANF.AKJ != null) && (!this.ANI))
    {
      ae.i("MiroMsg.CardAdTimeLineItem", "show play btn");
      this.ANF.AKJ.zWJ.setVisibility(0);
      this.ANF.AKJ.AnK.setVisibility(8);
      this.ANF.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
      this.ANF.AKJ.zWJ.setContentDescription(this.mActivity.getString(2131761939));
    }
    AppMethodBeat.o(176415);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176412);
    if ((paramBaseViewHolder.timeLineObject.HUG.Gtw == 5) || (paramBaseViewHolder.timeLineObject.HUG.Gtw == 15))
    {
      ae.i("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", new Object[] { this, Integer.valueOf(paramInt) });
      if (!(paramBaseViewHolder instanceof a)) {
        break label389;
      }
    }
    label389:
    for (boolean bool = ((a)paramBaseViewHolder).ANY;; bool = false)
    {
      ae.i("MiroMsg.CardAdTimeLineItem", "In the card ad item, the useOnlineVideo is ".concat(String.valueOf(bool)));
      if (!bool)
      {
        com.tencent.mm.plugin.sns.ui.video.d.eir().cyX();
        com.tencent.mm.plugin.sns.ui.video.b.eil().a(this);
        paramBaseViewHolder.AKJ.AnH.start();
      }
      for (;;)
      {
        ae.i("MiroMsg.CardAdTimeLineItem", "try hide play btn");
        if ((this.ANF != null) && (this.ANF.AKJ != null))
        {
          ae.i("MiroMsg.CardAdTimeLineItem", "hide play btn");
          this.ANF.AKJ.zWJ.setVisibility(8);
          this.ANF.AKJ.AnK.setVisibility(8);
        }
        this.ANI = true;
        if ((paramBaseViewHolder instanceof a)) {
          ((a)paramBaseViewHolder).ANW = false;
        }
        AppMethodBeat.o(176412);
        return;
        com.tencent.mm.plugin.sns.ui.video.b.eil().pause();
        ae.w("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", new Object[] { this, Integer.valueOf(paramInt) });
        p localp = this.zlW;
        bzh localbzh = f.a(paramBaseViewHolder);
        String str1 = f.c(paramBaseViewHolder);
        com.tencent.mm.plugin.sns.ad.e.j localj = f.a(this.zGX);
        ViewGroup localViewGroup = ((a)paramBaseViewHolder).ANX;
        String str2 = paramBaseViewHolder.dqc;
        if ((localp != null) && (localbzh != null) && (localViewGroup != null))
        {
          ae.w("MiroMsg.CardAdTimeLineItem", "the sns info is " + localp + " the media is " + localbzh);
          com.tencent.mm.plugin.sns.ad.timeline.c.a.d locald = new com.tencent.mm.plugin.sns.ad.timeline.c.a.d("MiroMsg.CardAdTimeLineItem");
          locald.mContainer = localViewGroup;
          locald.zrY = localbzh;
          locald.zlW = localp;
          locald.qiw = str2;
          locald.zrS = str1;
          locald.zrZ = localj;
          locald.a(3, new a.5(this));
        }
      }
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, final bh parambh)
  {
    AppMethodBeat.i(100065);
    if (paramBaseViewHolder.guz)
    {
      ae.i("MiroMsg.CardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(100065);
      return;
    }
    ae.i("MiroMsg.CardAdTimeLineItem", "ad fillItem, cardAd, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
    paramBaseViewHolder.guz = true;
    Object localObject1;
    if (paramTimeLineObject.Id == null) {
      localObject1 = "";
    }
    for (;;)
    {
      this.zrS = ((String)localObject1);
      locala = (a)paramBaseViewHolder;
      localp = parambh.RA(paramInt1);
      this.zlW = localp;
      locala.ANS.setVisibility(8);
      locala.AKM.setVisibility(8);
      locala.ANR.setVisibility(8);
      locala.AKT.setVisibility(8);
      locala.AKT.setTag("");
      this.ANH.eeA();
      if (paramBaseViewHolder.AMp != null) {
        paramBaseViewHolder.AMp.setVisibility(8);
      }
      localObject1 = (WindowManager)this.mActivity.getSystemService("window");
      paramInt2 = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
      ((a)paramBaseViewHolder).AMr.setOnClickListener(parambh.zGs.AQy);
      localObject3 = new LinearLayout.LayoutParams(paramInt2 - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516), -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = this.mActivity.getResources().getDimensionPixelSize(2131165500);
      ((LinearLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 2);
      ((a)paramBaseViewHolder).iOI.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      parambh.egu().c(paramBaseViewHolder.AMr, parambh.zGs.AQe, parambh.zGs.APL);
      if (locala.ANV != null) {
        locala.ANV.setVisibility(0);
      }
      if (locala.ANU != null)
      {
        if (!bu.isNullOrNil(localp.dVj().zNE)) {
          locala.ANU.setVisibility(0);
        }
      }
      else {
        label421:
        localObject1 = localp.dVj();
      }
      try
      {
        if ((com.tencent.mm.plugin.sns.ad.timeline.a.a.c(paramTimeLineObject)) && (com.tencent.mm.plugin.sns.ad.timeline.a.a.a((com.tencent.mm.plugin.sns.storage.b)localObject1)) && (com.tencent.mm.plugin.sns.ad.timeline.a.a.dVs())) {}
        for (locala.ANY = true;; locala.ANY = false)
        {
          locala.AKQ.setTag("");
          if (locala.AKQ.getVisibility() == 0) {
            locala.AKQ.setVisibility(4);
          }
          localObject1 = localp.dVi();
          if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).dZr()) && (!localp.ecB()))
          {
            locala.ANS.setVisibility(0);
            com.tencent.mm.plugin.sns.ad.c.c.e(((com.tencent.mm.plugin.sns.storage.a)localObject1).zMn.duJ, locala.AKQ);
          }
          if (!bu.isNullOrNil(localp.dVj().zNF)) {
            break label1674;
          }
          localObject1 = paramTimeLineObject.HUD;
          if (bu.isNullOrNil((String)localObject1)) {
            break label1687;
          }
          localObject4 = com.tencent.mm.ce.g.fqZ();
          locala.ANV.getContext();
          localObject1 = ((com.tencent.mm.ce.g)localObject4).b((CharSequence)localObject1, locala.ANV.getTextSize());
          locala.ANV.setText((CharSequence)localObject1);
          locala.ANV.setVisibility(0);
          localObject1 = localp.dVj().zNE;
          if (!bu.isNullOrNil((String)localObject1)) {
            break label1700;
          }
          locala.ANU.setVisibility(8);
          try
          {
            localObject1 = localp.getSnsId();
            if (com.tencent.mm.plugin.sns.ui.widget.b.ke(locala.ANR.getOriginSnsId(), (String)localObject1)) {
              break label1753;
            }
            locala.ANR.removeAllViews();
            if (localp.dVj().zNI.zOy.size() > 0)
            {
              locala.ANR.setVisibility(0);
              locala.ANR.setTagSpace(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8));
              locala.ANR.gr(localp.dVj().zNI.zOy);
            }
            locala.ANR.setOriginSnsId((String)localObject1);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              int i;
              int j;
              int k;
              int m;
              int n;
              Object localObject5;
              Object localObject2;
              ae.e("MiroMsg.CardAdTimeLineItem", localException.toString());
              continue;
              locala.ANQ.setVisibility(4);
              continue;
              if (localp.dVj().zNs == 2)
              {
                i = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54);
                j = this.mActivity.getResources().getDimensionPixelSize(2131165490);
                k = this.mActivity.getResources().getDimensionPixelSize(2131165516);
                m = this.mActivity.getResources().getDimensionPixelSize(2131165568);
                paramBaseViewHolder.AMp.setContentWidth(paramInt2 - i - j - k - m);
                paramBaseViewHolder.AMp.ecY();
                continue;
                locala.ANP.setVisibility(4);
                continue;
                this.ANH.eeA();
                locala.AKM.setVisibility(0);
                j = this.mActivity.getResources().getColor(2131100027);
                k = this.mActivity.getResources().getColor(2131099658);
                i = 1;
                paramInt2 = i;
                if (localp.dVj().dZG())
                {
                  m = x.jZ(localp.dVj().zOe.zOZ, localp.ecx());
                  paramInt2 = i;
                  if (m > 0)
                  {
                    paramInt2 = i;
                    if (m <= 2)
                    {
                      if (m != 1) {
                        break label2155;
                      }
                      locala.ANO.setTextColor(k);
                      locala.ANO.setText(localp.dVj().zOe.QU(1));
                      locala.ANN.setTextColor(j);
                      locala.ANN.setText(localp.dVj().zOe.QT(0));
                    }
                  }
                }
                for (;;)
                {
                  paramInt2 = 0;
                  if (paramInt2 == 0) {
                    break;
                  }
                  locala.ANN.setTextColor(j);
                  locala.ANO.setTextColor(j);
                  locala.ANN.setText(localp.dVj().dZw());
                  locala.ANO.setText(localp.dVj().dZx());
                  break;
                  if (m == 2)
                  {
                    locala.ANN.setTextColor(k);
                    locala.ANN.setText(localp.dVj().zOe.QU(0));
                    locala.ANO.setTextColor(j);
                    locala.ANO.setText(localp.dVj().zOe.QT(1));
                  }
                }
                bzh localbzh = null;
                continue;
                if (((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).zma == null)
                {
                  ae.e(((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mTag, "OnlineVideoChecker: the timeline object is null");
                }
                else
                {
                  boolean bool;
                  try
                  {
                    ViewGroup localViewGroup = ((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mContainer;
                    TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).zma;
                    bool = ((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).zrW;
                    if (com.tencent.mm.plugin.sns.ad.f.j.x(localViewGroup))
                    {
                      if (bool)
                      {
                        View localView = localViewGroup.getChildAt(0);
                        if ((!(localView instanceof SnsTimelineVideoView)) || (bu.lX(((SnsTimelineVideoView)localView).ASs, localTimeLineObject.Id))) {
                          continue;
                        }
                        ae.i(((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mTag, "OnlineVideoChecker: the online video container has child, but the time line id is different!!");
                        com.tencent.mm.plugin.sns.ad.f.j.w(localViewGroup);
                        continue;
                      }
                      ae.i(((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mTag, "OnlineVideoChecker: it doesn't use online video container!!");
                      com.tencent.mm.plugin.sns.ad.f.j.w(localViewGroup);
                      continue;
                    }
                    ae.i(((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mTag, "OnlineVideoChecker: there is no child video view in container!!");
                  }
                  catch (Throwable localThrowable2) {}
                  if ((paramBaseViewHolder.timeLineObject.HUG.Gtw == 5) || (paramBaseViewHolder.timeLineObject.HUG.Gtw == 15))
                  {
                    locala.AKJ.AnG.setVisibility(0);
                    locala.ALi.setVisibility(4);
                    parambh.egu().c(locala.AKJ.AnJ, parambh.zGs.AQe, parambh.zGs.APL);
                    localObject3 = locala.AKJ.AnG.getLayoutParams();
                    ((ViewGroup.LayoutParams)localObject3).width = paramInt2;
                    ((ViewGroup.LayoutParams)localObject3).height = i;
                    locala.AKJ.AnG.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                    locala.AKJ.AnH.hy(paramInt2, i);
                    locala.AKJ.AnH.setOnCompletionListener(new b.e()
                    {
                      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(100062);
                        if (paramAnonymousInt != -1)
                        {
                          if ((parambh == null) || (parambh.AAQ == null) || (parambh.AAQ.Agi == null))
                          {
                            AppMethodBeat.o(100062);
                            return;
                          }
                          parambh.AAQ.Agi.C(parambi.ADP, false);
                          ae.d("MiroMsg.CardAdTimeLineItem", "onCompletion, snsId=" + r.zV(localp.field_snsId));
                        }
                        AppMethodBeat.o(100062);
                      }
                    });
                    locala.AKJ.AnH.setOnDecodeDurationListener(new b.f()
                    {
                      public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                      {
                        AppMethodBeat.i(100063);
                        if ((parambh == null) || (parambh.AAQ == null) || (parambh.AAQ.Agi == null))
                        {
                          AppMethodBeat.o(100063);
                          return;
                        }
                        if (localp != null)
                        {
                          parambh.AAQ.Agi.zO(localp.field_snsId);
                          parambh.AAQ.Agi.aj(localp.field_snsId, 1000L * paramAnonymousLong);
                        }
                        if (!parambh.AAQ.Agi.zL(parambi.ADP))
                        {
                          int i = (int)paramAnonymousb.dTD();
                          parambh.AAQ.Agi.d(parambi.ADP, bu.HQ(), false);
                          parambh.AAQ.Agi.e(parambi.ADP, i, false);
                          parambh.AAQ.Agi.ai(parambi.ADP, parambi.ADP);
                        }
                        ae.d("MiroMsg.CardAdTimeLineItem", "onDecodeProgress, currentTime=" + paramAnonymousLong + ", snsId=" + r.zV(localp.field_snsId));
                        AppMethodBeat.o(100063);
                      }
                    });
                    long l = System.nanoTime();
                    bool = com.tencent.mm.plugin.sns.model.g.t(localbzh);
                    ae.i("MiroMsg.CardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
                    localObject3 = locala.AKJ;
                    if (!bool) {
                      if (((com.tencent.mm.plugin.sns.model.g)localObject4).w(localbzh))
                      {
                        ((aq)localObject3).zWJ.setVisibility(8);
                        ((aq)localObject3).AnK.setVisibility(0);
                        ((aq)localObject3).AnK.fPL();
                        locala.ANN.setTag(locala);
                        locala.ANO.setTag(locala);
                        ((aq)localObject3).AnH.setTagObject(localObject3);
                        ((aq)localObject3).AnJ.setTag(locala);
                        localObject3 = ((aq)localObject3).AnH;
                        j = this.mActivity.hashCode();
                        localObject5 = bk.fvn();
                        ((bk)localObject5).heF = paramTimeLineObject.CreateTime;
                        ((com.tencent.mm.plugin.sns.model.g)localObject4).a(localp, localbzh, (VideoSightView)localObject3, j, paramInt1, (bk)localObject5, parambi.AfT, true);
                        localObject3 = ap.jv(ah.getAccSnsPath(), localbzh.Id);
                        localObject4 = r.i(localbzh);
                        if (!o.fB((String)localObject3 + (String)localObject4)) {
                          break label3445;
                        }
                        parambh.AAQ.Agi.D(parambi.ADP, true);
                        if (ah.dXB().b(localp, null) != 5) {
                          break label3464;
                        }
                      }
                    }
                    for (bool = true;; bool = false)
                    {
                      parambh.AAQ.Agi.c(parambi.ADP, bool, false);
                      if (!locala.ANY) {
                        break;
                      }
                      ae.d("MiroMsg.CardAdTimeLineItem", "in fillitem, the user online video is true");
                      com.tencent.mm.plugin.sns.ad.f.j.u(locala.ANX, paramInt2, i);
                      parambi = locala.ANX;
                      parambh = new com.tencent.mm.plugin.sns.ad.timeline.c.a.c("MiroMsg.CardAdTimeLineItem");
                      parambh.mXH = parambi;
                      parambh.zrY = localbzh;
                      parambh.zrX = paramTimeLineObject;
                      parambh.qiw = paramBaseViewHolder.dqc;
                      parambh.layout();
                      com.tencent.mm.plugin.sns.ad.f.j.t(locala.AKJ.AnK, false);
                      break;
                      if (((com.tencent.mm.plugin.sns.model.g)localObject4).b(localp, null) == 5)
                      {
                        ((com.tencent.mm.plugin.sns.model.g)localObject4).A(localbzh);
                        ((aq)localObject3).zWJ.setVisibility(8);
                        ((aq)localObject3).AnK.setVisibility(0);
                        ((aq)localObject3).AnK.fPL();
                        break label2651;
                      }
                      if (((com.tencent.mm.plugin.sns.model.g)localObject4).x(localbzh))
                      {
                        ((aq)localObject3).AnK.setVisibility(8);
                        ((aq)localObject3).zWJ.setImageResource(2131691612);
                        ((aq)localObject3).zWJ.setVisibility(0);
                        break label2651;
                      }
                      ((com.tencent.mm.plugin.sns.model.g)localObject4).y(localbzh);
                      ((aq)localObject3).zWJ.setVisibility(0);
                      ((aq)localObject3).AnK.setVisibility(8);
                      ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
                      ((aq)localObject3).zWJ.setContentDescription(this.mActivity.getString(2131761939));
                      if (((com.tencent.mm.plugin.sns.model.g)localObject4).b(localp, null) != 4) {
                        break label2651;
                      }
                      ((aq)localObject3).zWK.setVisibility(0);
                      break label2651;
                      if (((com.tencent.mm.plugin.sns.model.g)localObject4).u(localbzh))
                      {
                        ((aq)localObject3).zWJ.setVisibility(0);
                        ((aq)localObject3).AnK.setVisibility(8);
                        ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
                        ((aq)localObject3).zWJ.setContentDescription(this.mActivity.getString(2131761939));
                      }
                      for (;;)
                      {
                        if (!((aq)localObject3).AnH.ziA.dTA()) {
                          break label3443;
                        }
                        ae.e("MiroMsg.CardAdTimeLineItem", "play video error " + localbzh.Id + " " + localbzh.Url + " " + localbzh.Hmj + " " + paramInt1);
                        ((com.tencent.mm.plugin.sns.model.g)localObject4).y(localbzh);
                        ((aq)localObject3).zWJ.setVisibility(0);
                        ((aq)localObject3).AnK.setVisibility(8);
                        ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
                        ((aq)localObject3).zWJ.setContentDescription(this.mActivity.getString(2131761939));
                        break;
                        if (((com.tencent.mm.plugin.sns.model.g)localObject4).v(localbzh))
                        {
                          ((aq)localObject3).zWJ.setVisibility(8);
                          ((aq)localObject3).AnK.setVisibility(8);
                        }
                        else if (((com.tencent.mm.plugin.sns.model.g)localObject4).b(localp, null) <= 5)
                        {
                          if (!locala.ANW)
                          {
                            ae.i("MiroMsg.CardAdTimeLineItem", "fillItem, showPlayBtn");
                            ehN();
                          }
                        }
                        else
                        {
                          ((com.tencent.mm.plugin.sns.model.g)localObject4).y(localbzh);
                          ((aq)localObject3).zWJ.setVisibility(0);
                          ((aq)localObject3).AnK.setVisibility(8);
                          ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
                          ((aq)localObject3).zWJ.setContentDescription(this.mActivity.getString(2131761939));
                        }
                      }
                      break label2651;
                      parambh.AAQ.Agi.D(parambi.ADP, false);
                      break label2806;
                    }
                  }
                  ((com.tencent.mm.plugin.sns.model.g)localObject4).a(paramBaseViewHolder.AKJ.AnH, this.mActivity.hashCode(), paramInt1);
                  paramBaseViewHolder.AKJ.AnL.setVisibility(8);
                  paramBaseViewHolder.AKJ.AnH.setOnSightCompletionAction(null);
                  paramBaseViewHolder.AKJ.AnH.setOnCompletionListener(null);
                  paramBaseViewHolder.AKJ.AnH.setOnDecodeDurationListener(null);
                  continue;
                  locala.AKW.setVisibility(8);
                }
              }
            }
          }
          if (bu.isNullOrNil(localp.dVj().zNG)) {
            break label1799;
          }
          locala.AKT.setVisibility(0);
          locala.ANQ.setVisibility(0);
          locala.ANQ.setText(localp.dVj().zNG);
          if (localp.dVj().zNs != 1) {
            break label1811;
          }
          i = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54);
          j = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54);
          k = this.mActivity.getResources().getDimensionPixelSize(2131165490);
          m = this.mActivity.getResources().getDimensionPixelSize(2131165516);
          n = this.mActivity.getResources().getDimensionPixelSize(2131165568);
          paramBaseViewHolder.AMp.setContentWidth(paramInt2 - i - j - k - m - n);
          paramBaseViewHolder.AMp.ecY();
          locala.AKT.setTag(localp.dVj().zNH);
          if (bu.isNullOrNil(localp.dVj().zNH)) {
            break label1910;
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localp.dVj().zNH, false, new f.a()
          {
            public final void ayY(String paramAnonymousString)
            {
              AppMethodBeat.i(100061);
              ae.i("MiroMsg.CardAdTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
              if ((!bu.V(new String[] { (String)locala.AKT.getTag(), paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", (String)locala.AKT.getTag()))))
              {
                paramAnonymousString = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString, null);
                if (paramAnonymousString != null)
                {
                  locala.AKT.setVisibility(0);
                  locala.ANP.setImageBitmap(paramAnonymousString);
                  locala.ANP.setVisibility(0);
                }
              }
              AppMethodBeat.o(100061);
            }
            
            public final void dVu() {}
            
            public final void dVv() {}
          });
          if ((localp.dVj().dZE()) || (localp.dVj().dZG()))
          {
            if (!localp.dVj().dZF()) {
              break label1922;
            }
            this.ANH.eez();
            this.ANH.a(localp, locala);
            locala.AKM.setVisibility(8);
            if (locala.ANV != null) {
              locala.ANV.setVisibility(8);
            }
            if (locala.ANU != null) {
              locala.ANU.setVisibility(8);
            }
          }
          locala.ALi.setScaleType(QImageView.a.Lpz);
          locala.AKJ.AnH.ziI = true;
          locala.AKJ.AnH.setScaleType(QImageView.a.Lpz);
          if ((paramTimeLineObject.HUG == null) || (paramTimeLineObject.HUG.Gtx.size() <= 0)) {
            break label2224;
          }
          localObject1 = (bzh)paramTimeLineObject.HUG.Gtx.get(0);
          localObject4 = ah.dXB();
          if ((paramBaseViewHolder.AKJ.AnF != null) && (!bu.lX(paramBaseViewHolder.AKJ.AnF.Id, paramTimeLineObject.Id)))
          {
            ae.i("MiroMsg.CardAdTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.AKJ.AnF.Id });
            ((com.tencent.mm.plugin.sns.model.g)localObject4).a(paramBaseViewHolder.AKJ.AnH, this.mActivity.hashCode(), paramInt1);
          }
          paramBaseViewHolder.AKJ.a(paramTimeLineObject, paramInt1, parambi.AhK, parambi.AfT);
          paramBaseViewHolder.AKJ.zWK.setVisibility(8);
          localObject5 = new com.tencent.mm.plugin.sns.ad.timeline.c.a.b("MiroMsg.CardAdTimeLineItem");
          ((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mContainer = locala.ANX;
          ((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).zma = paramTimeLineObject;
          ((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).zrW = locala.ANY;
          if (((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mContainer != null) {
            break label2230;
          }
          ae.e(((com.tencent.mm.plugin.sns.ad.timeline.c.a.b)localObject5).mTag, "OnlineVideoChecker: the container is null");
          if (localObject1 != null)
          {
            paramInt2 = ((LinearLayout.LayoutParams)localObject3).width - this.mActivity.getResources().getDimensionPixelSize(2131165568) - this.mActivity.getResources().getDimensionPixelSize(2131165568);
            i = (int)(paramInt2 * ((bzh)localObject1).Hmm.Hnb / ((bzh)localObject1).Hmm.Hna);
            if (paramBaseViewHolder.timeLineObject.HUG.Gtw != 1) {
              break label2373;
            }
            locala.ALi.setVisibility(0);
            locala.AKJ.AnG.setVisibility(4);
            parambi = locala.ALi.getLayoutParams();
            parambi.width = paramInt2;
            parambi.height = i;
            locala.ALi.setLayoutParams(parambi);
            parambi = ah.dXB();
            localObject3 = locala.ALi;
            paramInt1 = this.mActivity.hashCode();
            localObject4 = bk.fvn();
            ((bk)localObject4).heF = paramTimeLineObject.CreateTime;
            parambi.b((bzh)localObject1, (View)localObject3, -1, paramInt1, (bk)localObject4);
            locala.ALi.setTag(locala);
            locala.ANN.setTag(locala);
            locala.ANO.setTag(locala);
            locala.ALi.setOnClickListener(parambh.zGs.AiC);
            parambh.egu().c(locala.ALi, parambh.zGs.AQe, parambh.zGs.APL);
            locala.ANW = false;
          }
          if (!localp.dVj().dZu()) {
            break label3539;
          }
          if (locala.ANV != null) {
            locala.ANV.setVisibility(8);
          }
          if (locala.ANU != null) {
            locala.ANU.setVisibility(8);
          }
          locala.AKW.setVisibility(0);
          this.ANG.P(localp);
          paramBaseViewHolder.guz = false;
          AppMethodBeat.o(100065);
          return;
          localObject1 = paramTimeLineObject.Id;
          break;
          locala.ANU.setVisibility(8);
          break label421;
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          continue;
          label1674:
          localObject2 = localp.dVj().zNF;
          continue;
          label1687:
          locala.ANV.setVisibility(8);
          continue;
          label1700:
          localObject4 = com.tencent.mm.ce.g.fqZ();
          locala.ANU.getContext();
          localObject2 = ((com.tencent.mm.ce.g)localObject4).b((CharSequence)localObject2, locala.ANU.getTextSize());
          locala.ANU.setText((CharSequence)localObject2);
          locala.ANU.setVisibility(0);
          continue;
          label1753:
          if (localp.dVj().zNI.zOy.size() > 0) {
            locala.ANR.setVisibility(0);
          }
        }
      }
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(176416);
    if ((this.ANF != null) && (this.ANF.ANL != null))
    {
      Object localObject = new int[2];
      this.ANF.ANL.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.ANF.ANL.getMeasuredWidth() + i, this.ANF.ANL.getMeasuredHeight() + j);
      AppMethodBeat.o(176416);
      return localObject;
    }
    AppMethodBeat.o(176416);
    return null;
  }
  
  public final void h(final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100064);
    this.ANF = ((a)paramBaseViewHolder);
    if (paramBaseViewHolder.AMs != null)
    {
      paramBaseViewHolder.AMs.setLayoutResource(2131495488);
      if (!paramBaseViewHolder.AMt)
      {
        this.ANF.iOI = ((ViewGroup)paramBaseViewHolder.AMs.inflate());
        paramBaseViewHolder.AMt = true;
      }
    }
    for (;;)
    {
      this.ANF.ANL = ((ViewGroup)this.ANF.iOI.findViewById(2131302206));
      if ((this.ANF.ANL instanceof RoundedCornerFrameLayout)) {
        ((RoundedCornerFrameLayout)this.ANF.ANL).setRadius(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 4));
      }
      this.ANF.ANM = ((ViewGroup)this.ANF.iOI.findViewById(2131303102));
      this.ANF.ALi = ((MaskImageView)this.ANF.iOI.findViewById(2131304943));
      this.ANF.ALi.setOnClickListener(this.zGX.zGs.AiC);
      this.zGX.egu().c(this.ANF.ALi, this.zGX.zGs.AQa, this.zGX.zGs.APL);
      this.ANF.ANV = ((TextView)this.ANF.iOI.findViewById(2131299000));
      this.ANF.ANV.setClickable(false);
      this.ANF.ANV.setLongClickable(false);
      this.ANF.ANU = ((TextView)this.ANF.iOI.findViewById(2131298999));
      this.ANF.ANU.setClickable(false);
      this.ANF.ANU.setLongClickable(false);
      this.ANF.AKJ = new aq();
      this.ANF.AKJ.AnJ = this.ANF.iOI.findViewById(2131304944);
      this.ANF.AKJ.AnG = this.ANF.AKJ.AnJ;
      this.ANF.AKJ.AnJ.setOnClickListener(this.zGX.zGs.AQl);
      this.ANF.AKJ.AnH = ((VideoSightView)this.ANF.AKJ.AnJ.findViewById(2131300914));
      this.ANF.AKJ.AnH.setMute(true);
      this.ANF.AKJ.zWJ = ((ImageView)this.ANF.AKJ.AnJ.findViewById(2131305196));
      this.ANF.AKJ.AnK = ((MMPinProgressBtn)this.ANF.AKJ.AnJ.findViewById(2131303515));
      this.ANF.AKJ.AnL = ((TextView)this.ANF.AKJ.AnJ.findViewById(2131299492));
      this.ANF.AKJ.zWK = ((TextView)this.ANF.AKJ.AnJ.findViewById(2131299517));
      this.ANF.AKT = this.ANF.iOI.findViewById(2131304890);
      this.ANF.ANP = ((ImageView)this.ANF.iOI.findViewById(2131304889));
      this.ANF.ANQ = ((TextView)this.ANF.iOI.findViewById(2131304891));
      this.ANF.ANS = this.ANF.iOI.findViewById(2131297919);
      this.ANF.AKQ = ((ImageView)this.ANF.iOI.findViewById(2131308526));
      this.ANF.ANT = ((ImageView)this.ANF.iOI.findViewById(2131306896));
      this.ANF.AKM = this.ANF.iOI.findViewById(2131297744);
      this.ANF.ANN = ((Button)this.ANF.iOI.findViewById(2131297745));
      this.ANF.ANO = ((Button)this.ANF.iOI.findViewById(2131297746));
      this.ANF.ANN.setOnClickListener(this.zGX.zGs.AQw);
      this.ANF.ANO.setOnClickListener(this.zGX.zGs.AQx);
      this.ANF.ANR = ((SnsCardAdTagListView)this.ANF.iOI.findViewById(2131297725));
      this.ANF.ANR.setActivityContext(this.mActivity);
      this.ANF.ANX = ((ViewGroup)this.ANF.iOI.findViewById(2131308422));
      this.ANF.AKW = this.ANF.iOI.findViewById(2131296355);
      this.ANG = new as(this.mActivity, this.ANF.iOI, 0, this.zGX.AAQ.Agi, new as.b()
      {
        public final void eey()
        {
          AppMethodBeat.i(100060);
          a.this.zGX.zGs.m(paramBaseViewHolder);
          AppMethodBeat.o(100060);
        }
      });
      this.ANH = new au(this.mActivity, this.ANF.iOI, this.zGX.zGs);
      if (!al.isDarkMode()) {
        break;
      }
      this.ANF.ANT.setImageResource(2131689524);
      this.ANF.AKQ.setImageResource(2131235014);
      AppMethodBeat.o(100064);
      return;
      if (!paramBaseViewHolder.AMt)
      {
        this.ANF.iOI = ((ViewGroup)paramBaseViewHolder.uan.findViewById(2131296428));
        paramBaseViewHolder.AMt = true;
      }
    }
    this.ANF.ANT.setImageResource(2131689523);
    this.ANF.AKQ.setImageResource(2131235015);
    AppMethodBeat.o(100064);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177692);
    ae.i("MiroMsg.CardAdTimeLineItem", "onUIPause");
    ehM();
    AppMethodBeat.o(177692);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176413);
    ae.i("MiroMsg.CardAdTimeLineItem", "pause");
    if (ehM()) {
      ehN();
    }
    AppMethodBeat.o(176413);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176414);
    ae.i("MiroMsg.CardAdTimeLineItem", "%s cardAd stop", new Object[] { this });
    if ((this.ANF != null) && (this.ANF.AKJ != null)) {
      this.ANF.AKJ.AnH.ziA.clear();
    }
    this.ANI = false;
    AppMethodBeat.o(176414);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View AKM;
    public ImageView AKQ;
    public View AKT;
    public View AKW;
    public MaskImageView ALi;
    public ViewGroup ANL;
    public ViewGroup ANM;
    public Button ANN;
    public Button ANO;
    public ImageView ANP;
    public TextView ANQ;
    public SnsCardAdTagListView ANR;
    public View ANS;
    public ImageView ANT;
    public TextView ANU;
    public TextView ANV;
    public boolean ANW;
    public ViewGroup ANX;
    public boolean ANY;
    public ViewGroup iOI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a
 * JD-Core Version:    0.7.0.1
 */