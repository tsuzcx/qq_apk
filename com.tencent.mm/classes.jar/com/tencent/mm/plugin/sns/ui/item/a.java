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
import com.tencent.mm.cg.g;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.plugin.sns.storage.b.j;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.ap.b;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private p wvM;
  private a xRD;
  private ap xRE;
  private ar xRF;
  private boolean xRG = false;
  
  private void R(p paramp)
  {
    AppMethodBeat.i(187786);
    if ((this.wNd != null) && (this.wNd.xFq != null) && (this.wNd.xFq.xkX != null) && (paramp != null)) {
      this.wNd.xFq.xkX.sn(paramp.field_snsId);
    }
    AppMethodBeat.o(187786);
  }
  
  private void csr()
  {
    AppMethodBeat.i(176415);
    ad.i("MiroMsg.CardAdTimeLineItem", "try show play btn");
    if ((this.xRD != null) && (this.xRD.xOO != null) && (!this.xRG))
    {
      ad.i("MiroMsg.CardAdTimeLineItem", "show play btn");
      this.xRD.xOO.xbT.setVisibility(0);
      this.xRD.xOO.xsq.setVisibility(8);
      this.xRD.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
      this.xRD.xOO.xbT.setContentDescription(this.mActivity.getString(2131761939));
    }
    AppMethodBeat.o(176415);
  }
  
  private boolean dDo()
  {
    AppMethodBeat.i(177693);
    if ((this.xRD.timeLineObject.Etm.DaB == 5) || (this.xRD.timeLineObject.Etm.DaB == 15))
    {
      ad.i("MiroMsg.CardAdTimeLineItem", "%s cardAd doPause", new Object[] { this });
      if ((this.xRD != null) && (this.xRD.xOO != null))
      {
        this.xRD.xOO.xsn.pause();
        R(this.wvM);
      }
      this.xRG = false;
      AppMethodBeat.o(177693);
      return true;
    }
    AppMethodBeat.o(177693);
    return false;
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176412);
    if ((paramBaseViewHolder.timeLineObject.Etm.DaB == 5) || (paramBaseViewHolder.timeLineObject.Etm.DaB == 15))
    {
      ad.i("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", new Object[] { this, Integer.valueOf(paramInt) });
      d.dDS().ckd();
      com.tencent.mm.plugin.sns.ui.video.b.dDL().a(this);
      paramBaseViewHolder.xOO.xsn.start();
      ad.i("MiroMsg.CardAdTimeLineItem", "try hide play btn");
      if ((this.xRD != null) && (this.xRD.xOO != null))
      {
        ad.i("MiroMsg.CardAdTimeLineItem", "hide play btn");
        this.xRD.xOO.xbT.setVisibility(8);
        this.xRD.xOO.xsq.setVisibility(8);
      }
      this.xRG = true;
      if ((paramBaseViewHolder instanceof a)) {
        ((a)paramBaseViewHolder).xRT = false;
      }
    }
    AppMethodBeat.o(176412);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, final be parambe)
  {
    AppMethodBeat.i(100065);
    ad.i("MiroMsg.CardAdTimeLineItem", "%s, fill card ad item %d, snsId %s", new Object[] { this, Integer.valueOf(paramInt1), paramTimeLineObject.Id });
    if (paramBaseViewHolder.fUH)
    {
      ad.i("MiroMsg.CardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(100065);
      return;
    }
    paramBaseViewHolder.fUH = true;
    locala = (a)paramBaseViewHolder;
    localp = parambe.Ni(paramInt1);
    this.wvM = localp;
    locala.xRQ.setVisibility(8);
    locala.xOR.setVisibility(8);
    locala.xRP.setVisibility(8);
    locala.xOX.setVisibility(8);
    locala.xOX.setTag("");
    this.xRF.dAj();
    if (paramBaseViewHolder.xQt != null) {
      paramBaseViewHolder.xQt.setVisibility(8);
    }
    Object localObject1 = (WindowManager)this.mActivity.getSystemService("window");
    paramInt2 = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    ((a)paramBaseViewHolder).xQv.setOnClickListener(parambe.wMy.xUd);
    localObject3 = new LinearLayout.LayoutParams(paramInt2 - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516), -2);
    ((LinearLayout.LayoutParams)localObject3).topMargin = this.mActivity.getResources().getDimensionPixelSize(2131165500);
    ((LinearLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 2);
    ((a)paramBaseViewHolder).hSH.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    parambe.dCa().c(paramBaseViewHolder.xQv, parambe.wMy.xTL, parambe.wMy.xTt);
    if (locala.xRS != null) {
      locala.xRS.setVisibility(0);
    }
    if (locala.xRR != null)
    {
      if (!bt.isNullOrNil(localp.dxs().wTx)) {
        locala.xRR.setVisibility(0);
      }
    }
    else
    {
      localObject1 = localp.dxu();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).dvd()) && (!localp.dyk())) {
        locala.xRQ.setVisibility(0);
      }
      if (!bt.isNullOrNil(localp.dxs().wTy)) {
        break label1471;
      }
      localObject1 = paramTimeLineObject.Etj;
      label440:
      if (bt.isNullOrNil((String)localObject1)) {
        break label1484;
      }
      localObject4 = g.eIa();
      locala.xRS.getContext();
      localObject1 = ((g)localObject4).b((CharSequence)localObject1, locala.xRS.getTextSize());
      locala.xRS.setText((CharSequence)localObject1);
      locala.xRS.setVisibility(0);
      label498:
      localObject1 = localp.dxs().wTx;
      if (!bt.isNullOrNil((String)localObject1)) {
        break label1497;
      }
      locala.xRR.setVisibility(8);
    }
    for (;;)
    {
      try
      {
        localObject1 = localp.getSnsId();
        if (com.tencent.mm.plugin.sns.ui.widget.b.jm(locala.xRP.getOriginSnsId(), (String)localObject1)) {
          continue;
        }
        locala.xRP.removeAllViews();
        if (localp.dxs().wTB.wUe.size() > 0)
        {
          locala.xRP.setVisibility(0);
          locala.xRP.setTagSpace(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8));
          locala.xRP.fP(localp.dxs().wTB.wUe);
        }
        locala.xRP.setOriginSnsId((String)localObject1);
      }
      catch (Exception localException)
      {
        int n;
        label1471:
        label1484:
        label1497:
        ad.e("MiroMsg.CardAdTimeLineItem", localException.toString());
        continue;
        locala.xRO.setVisibility(4);
        continue;
        if (localp.dxs().wTl != 2) {
          continue;
        }
        int i = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 54);
        int j = this.mActivity.getResources().getDimensionPixelSize(2131165490);
        int k = this.mActivity.getResources().getDimensionPixelSize(2131165516);
        int m = this.mActivity.getResources().getDimensionPixelSize(2131165568);
        paramBaseViewHolder.xQt.setContentWidth(paramInt2 - i - j - k - m);
        paramBaseViewHolder.xQt.dyH();
        continue;
        locala.xRN.setVisibility(4);
        continue;
        this.xRF.dAj();
        locala.xOR.setVisibility(0);
        j = this.mActivity.getResources().getColor(2131100027);
        k = this.mActivity.getResources().getColor(2131099658);
        i = 1;
        paramInt2 = i;
        if (!localp.dxs().dvq()) {
          continue;
        }
        m = x.jh(localp.dxs().wTR.wUF, localp.dyg());
        paramInt2 = i;
        if (m <= 0) {
          continue;
        }
        paramInt2 = i;
        if (m > 2) {
          continue;
        }
        if (m != 1) {
          continue;
        }
        locala.xRM.setTextColor(k);
        locala.xRM.setText(localp.dxs().wTR.MD(1));
        locala.xRL.setTextColor(j);
        locala.xRL.setText(localp.dxs().wTR.MC(0));
        paramInt2 = 0;
        if (paramInt2 == 0) {
          continue;
        }
        locala.xRL.setTextColor(j);
        locala.xRM.setTextColor(j);
        locala.xRL.setText(localp.dxs().dvi());
        locala.xRM.setText(localp.dxs().dvj());
        continue;
        if (m != 2) {
          continue;
        }
        locala.xRL.setTextColor(k);
        locala.xRL.setText(localp.dxs().wTR.MD(0));
        locala.xRM.setTextColor(j);
        locala.xRM.setText(localp.dxs().wTR.MC(1));
        continue;
        Object localObject2 = null;
        continue;
        if ((paramBaseViewHolder.timeLineObject.Etm.DaB != 5) && (paramBaseViewHolder.timeLineObject.Etm.DaB != 15)) {
          continue;
        }
        locala.xOO.xsm.setVisibility(0);
        locala.xPm.setVisibility(4);
        parambe.dCa().c(locala.xOO.xsp, parambe.wMy.xTL, parambe.wMy.xTt);
        localObject3 = locala.xOO.xsm.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject3).height = i;
        locala.xOO.xsm.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        locala.xOO.xsn.gW(paramInt2, i);
        locala.xOO.xsn.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(100062);
            if (paramAnonymousInt != -1)
            {
              if ((parambe == null) || (parambe.xFq == null) || (parambe.xFq.xkX == null))
              {
                AppMethodBeat.o(100062);
                return;
              }
              parambe.xFq.xkX.A(parambf.xIc, false);
            }
            AppMethodBeat.o(100062);
          }
        });
        locala.xOO.xsn.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(100063);
            if ((parambe == null) || (parambe.xFq == null) || (parambe.xFq.xkX == null))
            {
              AppMethodBeat.o(100063);
              return;
            }
            if (localp != null)
            {
              parambe.xFq.xkX.sm(localp.field_snsId);
              parambe.xFq.xkX.ak(localp.field_snsId, 1000L * paramAnonymousLong);
            }
            if (!parambe.xFq.xkX.sj(parambf.xIc))
            {
              int i = (int)paramAnonymousb.dqu();
              parambe.xFq.xkX.d(parambf.xIc, bt.GC(), false);
              parambe.xFq.xkX.e(parambf.xIc, i, false);
              parambe.xFq.xkX.aj(parambf.xIc, parambf.xIc);
              locala.xOO.xsn.setOnDecodeDurationListener(null);
            }
            AppMethodBeat.o(100063);
          }
        });
        long l = System.nanoTime();
        boolean bool = com.tencent.mm.plugin.sns.model.f.t((bpi)localObject2);
        ad.i("MiroMsg.CardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
        localObject3 = locala.xOO;
        if (bool) {
          continue;
        }
        if (!((com.tencent.mm.plugin.sns.model.f)localObject4).w((bpi)localObject2)) {
          continue;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.feJ();
        locala.xRL.setTag(locala);
        locala.xRM.setTag(locala);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsn.setTagObject(localObject3);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsp.setTag(locala);
        localObject3 = ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsn;
        paramInt2 = this.mActivity.hashCode();
        bc localbc = bc.eLG();
        localbc.tGD = paramTimeLineObject.CreateTime;
        ((com.tencent.mm.plugin.sns.model.f)localObject4).a(localp, (bpi)localObject2, (VideoSightView)localObject3, paramInt2, paramInt1, localbc, parambf.xkI, true);
        paramTimeLineObject = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), ((bpi)localObject2).Id);
        localObject2 = q.i((bpi)localObject2);
        if (!com.tencent.mm.vfs.i.eK(paramTimeLineObject + (String)localObject2)) {
          continue;
        }
        parambe.xFq.xkX.B(parambf.xIc, true);
        if (af.dtr().b(localp, null) != 5) {
          continue;
        }
        bool = true;
        parambe.xFq.xkX.e(parambf.xIc, bool, false);
        continue;
        if (((com.tencent.mm.plugin.sns.model.f)localObject4).b(localp, null) != 5) {
          continue;
        }
        ((com.tencent.mm.plugin.sns.model.f)localObject4).A((bpi)localObject2);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.feJ();
        continue;
        if (!((com.tencent.mm.plugin.sns.model.f)localObject4).x((bpi)localObject2)) {
          continue;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setImageResource(2131234034);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(0);
        continue;
        ((com.tencent.mm.plugin.sns.model.f)localObject4).y((bpi)localObject2);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setContentDescription(this.mActivity.getString(2131761939));
        if (((com.tencent.mm.plugin.sns.model.f)localObject4).b(localp, null) != 4) {
          continue;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbU.setVisibility(0);
        continue;
        if (!((com.tencent.mm.plugin.sns.model.f)localObject4).u((bpi)localObject2)) {
          continue;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setContentDescription(this.mActivity.getString(2131761939));
        if (!((com.tencent.mm.plugin.sns.ui.an)localObject3).xsn.wsq.dqr()) {
          continue;
        }
        ad.d("MiroMsg.CardAdTimeLineItem", "play video error " + ((bpi)localObject2).Id + " " + ((bpi)localObject2).Url + " " + ((bpi)localObject2).DMQ + " " + paramInt1);
        ((com.tencent.mm.plugin.sns.model.f)localObject4).y((bpi)localObject2);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setContentDescription(this.mActivity.getString(2131761939));
        continue;
        if (!((com.tencent.mm.plugin.sns.model.f)localObject4).v((bpi)localObject2)) {
          continue;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(8);
        continue;
        if (((com.tencent.mm.plugin.sns.model.f)localObject4).b(localp, null) > 5) {
          continue;
        }
        if (locala.xRT) {
          continue;
        }
        ad.i("MiroMsg.CardAdTimeLineItem", "fillItem, showPlayBtn");
        csr();
        continue;
        ((com.tencent.mm.plugin.sns.model.f)localObject4).y((bpi)localObject2);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xsq.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).xbT.setContentDescription(this.mActivity.getString(2131761939));
        continue;
        continue;
        parambe.xFq.xkX.B(parambf.xIc, false);
        continue;
        bool = false;
        continue;
        ((com.tencent.mm.plugin.sns.model.f)localObject4).a(paramBaseViewHolder.xOO.xsn, this.mActivity.hashCode(), paramInt1);
        paramBaseViewHolder.xOO.xsr.setVisibility(8);
        paramBaseViewHolder.xOO.xsn.setOnSightCompletionAction(null);
        paramBaseViewHolder.xOO.xsn.setOnCompletionListener(null);
        paramBaseViewHolder.xOO.xsn.setOnDecodeDurationListener(null);
        continue;
        locala.xPa.setVisibility(8);
        continue;
      }
      if (bt.isNullOrNil(localp.dxs().wTz)) {
        continue;
      }
      locala.xOX.setVisibility(0);
      locala.xRO.setVisibility(0);
      locala.xRO.setText(localp.dxs().wTz);
      if (localp.dxs().wTl != 1) {
        continue;
      }
      i = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 54);
      j = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 54);
      k = this.mActivity.getResources().getDimensionPixelSize(2131165490);
      m = this.mActivity.getResources().getDimensionPixelSize(2131165516);
      n = this.mActivity.getResources().getDimensionPixelSize(2131165568);
      paramBaseViewHolder.xQt.setContentWidth(paramInt2 - i - j - k - m - n);
      paramBaseViewHolder.xQt.dyH();
      locala.xOX.setTag(localp.dxs().wTA);
      if (bt.isNullOrNil(localp.dxs().wTA)) {
        continue;
      }
      h.a(localp.dxs().wTA, new f.a()
      {
        public final void apm(String paramAnonymousString)
        {
          AppMethodBeat.i(100061);
          ad.i("MiroMsg.CardAdTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
          if ((!bt.T(new String[] { (String)locala.xOX.getTag(), paramAnonymousString })) && (paramAnonymousString.equals(h.iU("adId", (String)locala.xOX.getTag()))))
          {
            paramAnonymousString = com.tencent.mm.sdk.platformtools.f.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              locala.xOX.setVisibility(0);
              locala.xRN.setImageBitmap(paramAnonymousString);
              locala.xRN.setVisibility(0);
            }
          }
          AppMethodBeat.o(100061);
        }
        
        public final void dsA() {}
        
        public final void duP() {}
      });
      if ((localp.dxs().dvo()) || (localp.dxs().dvq()))
      {
        if (!localp.dxs().dvp()) {
          continue;
        }
        this.xRF.dAi();
        this.xRF.a(localp, locala);
        locala.xOR.setVisibility(8);
        if (locala.xRS != null) {
          locala.xRS.setVisibility(8);
        }
        if (locala.xRR != null) {
          locala.xRR.setVisibility(8);
        }
      }
      locala.xPm.setScaleType(QImageView.a.HBy);
      locala.xOO.xsn.wsy = true;
      locala.xOO.xsn.setScaleType(QImageView.a.HBy);
      if ((paramTimeLineObject.Etm == null) || (paramTimeLineObject.Etm.DaC.size() <= 0)) {
        continue;
      }
      localObject1 = (bpi)paramTimeLineObject.Etm.DaC.get(0);
      localObject4 = af.dtr();
      if ((paramBaseViewHolder.xOO.xsl != null) && (!bt.kU(paramBaseViewHolder.xOO.xsl.Id, paramTimeLineObject.Id)))
      {
        ad.i("MiroMsg.CardAdTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.xOO.xsl.Id });
        ((com.tencent.mm.plugin.sns.model.f)localObject4).a(paramBaseViewHolder.xOO.xsn, this.mActivity.hashCode(), paramInt1);
      }
      paramBaseViewHolder.xOO.a(paramTimeLineObject, paramInt1, parambf.xmu, parambf.xkI);
      paramBaseViewHolder.xOO.xbU.setVisibility(8);
      if (localObject1 != null)
      {
        paramInt2 = ((LinearLayout.LayoutParams)localObject3).width - this.mActivity.getResources().getDimensionPixelSize(2131165568) - this.mActivity.getResources().getDimensionPixelSize(2131165568);
        i = (int)(paramInt2 * ((bpi)localObject1).DMT.DNI / ((bpi)localObject1).DMT.DNH);
        if (paramBaseViewHolder.timeLineObject.Etm.DaB != 1) {
          continue;
        }
        locala.xPm.setVisibility(0);
        locala.xOO.xsm.setVisibility(4);
        parambf = locala.xPm.getLayoutParams();
        parambf.width = paramInt2;
        parambf.height = i;
        locala.xPm.setLayoutParams(parambf);
        parambf = af.dtr();
        localObject3 = locala.xPm;
        paramInt1 = this.mActivity.hashCode();
        localObject4 = bc.eLG();
        ((bc)localObject4).tGD = paramTimeLineObject.CreateTime;
        parambf.b((bpi)localObject1, (View)localObject3, -1, paramInt1, (bc)localObject4);
        locala.xPm.setTag(locala);
        locala.xRL.setTag(locala);
        locala.xRM.setTag(locala);
        locala.xPm.setOnClickListener(parambe.wMy.xno);
        parambe.dCa().c(locala.xPm, parambe.wMy.xTL, parambe.wMy.xTt);
        locala.xRT = false;
      }
      if (!localp.dxs().dvg()) {
        continue;
      }
      if (locala.xRS != null) {
        locala.xRS.setVisibility(8);
      }
      if (locala.xRR != null) {
        locala.xRR.setVisibility(8);
      }
      locala.xPa.setVisibility(0);
      this.xRE.M(localp);
      paramBaseViewHolder.fUH = false;
      AppMethodBeat.o(100065);
      return;
      locala.xRR.setVisibility(8);
      break;
      localObject1 = localp.dxs().wTy;
      break label440;
      locala.xRS.setVisibility(8);
      break label498;
      localObject4 = g.eIa();
      locala.xRR.getContext();
      localObject1 = ((g)localObject4).b((CharSequence)localObject1, locala.xRR.getTextSize());
      locala.xRR.setText((CharSequence)localObject1);
      locala.xRR.setVisibility(0);
      continue;
      if (localp.dxs().wTB.wUe.size() > 0) {
        locala.xRP.setVisibility(0);
      }
    }
  }
  
  public final void e(final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100064);
    this.xRD = ((a)paramBaseViewHolder);
    if (paramBaseViewHolder.xQw != null)
    {
      paramBaseViewHolder.xQw.setLayoutResource(2131495488);
      if (!paramBaseViewHolder.xQx)
      {
        this.xRD.hSH = ((ViewGroup)paramBaseViewHolder.xQw.inflate());
        paramBaseViewHolder.xQx = true;
      }
    }
    for (;;)
    {
      this.xRD.xRJ = ((ViewGroup)this.xRD.hSH.findViewById(2131302206));
      if ((this.xRD.xRJ instanceof RoundedCornerFrameLayout)) {
        ((RoundedCornerFrameLayout)this.xRD.xRJ).setRadius(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 4));
      }
      this.xRD.xRK = ((ViewGroup)this.xRD.hSH.findViewById(2131303102));
      this.xRD.xPm = ((MaskImageView)this.xRD.hSH.findViewById(2131304943));
      this.xRD.xPm.setOnClickListener(this.wNd.wMy.xno);
      this.wNd.dCa().c(this.xRD.xPm, this.wNd.wMy.xTH, this.wNd.wMy.xTt);
      this.xRD.xRS = ((TextView)this.xRD.hSH.findViewById(2131299000));
      this.xRD.xRS.setClickable(false);
      this.xRD.xRS.setLongClickable(false);
      this.xRD.xRR = ((TextView)this.xRD.hSH.findViewById(2131298999));
      this.xRD.xRR.setClickable(false);
      this.xRD.xRR.setLongClickable(false);
      this.xRD.xOO = new com.tencent.mm.plugin.sns.ui.an();
      this.xRD.xOO.xsp = this.xRD.hSH.findViewById(2131304944);
      this.xRD.xOO.xsm = this.xRD.xOO.xsp;
      this.xRD.xOO.xsp.setOnClickListener(this.wNd.wMy.xTQ);
      this.xRD.xOO.xsn = ((VideoSightView)this.xRD.xOO.xsp.findViewById(2131300914));
      this.xRD.xOO.xsn.setMute(true);
      this.xRD.xOO.xbT = ((ImageView)this.xRD.xOO.xsp.findViewById(2131305196));
      this.xRD.xOO.xsq = ((MMPinProgressBtn)this.xRD.xOO.xsp.findViewById(2131303515));
      this.xRD.xOO.xsr = ((TextView)this.xRD.xOO.xsp.findViewById(2131299492));
      this.xRD.xOO.xbU = ((TextView)this.xRD.xOO.xsp.findViewById(2131299517));
      this.xRD.xOX = this.xRD.hSH.findViewById(2131304890);
      this.xRD.xRN = ((ImageView)this.xRD.hSH.findViewById(2131304889));
      this.xRD.xRO = ((TextView)this.xRD.hSH.findViewById(2131304891));
      this.xRD.xRQ = this.xRD.hSH.findViewById(2131297919);
      this.xRD.xOR = this.xRD.hSH.findViewById(2131297744);
      this.xRD.xRL = ((Button)this.xRD.hSH.findViewById(2131297745));
      this.xRD.xRM = ((Button)this.xRD.hSH.findViewById(2131297746));
      this.xRD.xRL.setOnClickListener(this.wNd.wMy.xUb);
      this.xRD.xRM.setOnClickListener(this.wNd.wMy.xUc);
      this.xRD.xRP = ((SnsCardAdTagListView)this.xRD.hSH.findViewById(2131297725));
      this.xRD.xRP.setActivityContext(this.mActivity);
      this.xRD.xPa = this.xRD.hSH.findViewById(2131296355);
      this.xRE = new ap(this.mActivity, this.xRD.hSH, 0, this.wNd.xFq.xkX, new ap.b()
      {
        public final void dAh()
        {
          AppMethodBeat.i(100060);
          a.this.wNd.wMy.i(paramBaseViewHolder);
          AppMethodBeat.o(100060);
        }
      });
      this.xRF = new ar(this.mActivity, this.xRD.hSH, this.wNd.wMy);
      if (ai.Eq()) {
        ((ImageView)this.xRD.hSH.findViewById(2131306896)).setImageDrawable(this.mActivity.getResources().getDrawable(2131689524));
      }
      AppMethodBeat.o(100064);
      return;
      if (!paramBaseViewHolder.xQx)
      {
        this.xRD.hSH = ((ViewGroup)paramBaseViewHolder.rLd.findViewById(2131296428));
        paramBaseViewHolder.xQx = true;
      }
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(176416);
    if ((this.xRD != null) && (this.xRD.xRJ != null))
    {
      Object localObject = new int[2];
      this.xRD.xRJ.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.xRD.xRJ.getMeasuredWidth() + i, this.xRD.xRJ.getMeasuredHeight() + j);
      AppMethodBeat.o(176416);
      return localObject;
    }
    AppMethodBeat.o(176416);
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177692);
    ad.i("MiroMsg.CardAdTimeLineItem", "onUIPause");
    dDo();
    AppMethodBeat.o(177692);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176413);
    ad.i("MiroMsg.CardAdTimeLineItem", "pause");
    if (dDo()) {
      csr();
    }
    AppMethodBeat.o(176413);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176414);
    ad.i("MiroMsg.CardAdTimeLineItem", "%s cardAd stop", new Object[] { this });
    if ((this.xRD != null) && (this.xRD.xOO != null)) {
      this.xRD.xOO.xsn.wsq.clear();
    }
    this.xRG = false;
    AppMethodBeat.o(176414);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public ViewGroup hSH;
    public View xOR;
    public View xOX;
    public View xPa;
    public MaskImageView xPm;
    public ViewGroup xRJ;
    public ViewGroup xRK;
    public Button xRL;
    public Button xRM;
    public ImageView xRN;
    public TextView xRO;
    public SnsCardAdTagListView xRP;
    public View xRQ;
    public TextView xRR;
    public TextView xRS;
    public boolean xRT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a
 * JD-Core Version:    0.7.0.1
 */