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
import com.tencent.mm.cf.g;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.b.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.ap.b;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private p xHc;
  private ar zeA;
  private boolean zeB = false;
  private a zey;
  private ap zez;
  
  private void S(p paramp)
  {
    AppMethodBeat.i(200657);
    if ((this.xZJ != null) && (this.xZJ.ySd != null) && (this.xZJ.ySd.yxP != null) && (paramp != null)) {
      this.xZJ.ySd.yxP.wQ(paramp.field_snsId);
    }
    AppMethodBeat.o(200657);
  }
  
  private boolean dRL()
  {
    AppMethodBeat.i(177693);
    if ((this.zey.timeLineObject.FQo.Ety == 5) || (this.zey.timeLineObject.FQo.Ety == 15))
    {
      ac.i("MiroMsg.CardAdTimeLineItem", "%s cardAd doPause", new Object[] { this });
      if ((this.zey != null) && (this.zey.zbE != null))
      {
        this.zey.zbE.yFd.pause();
        S(this.xHc);
      }
      this.zeB = false;
      AppMethodBeat.o(177693);
      return true;
    }
    AppMethodBeat.o(177693);
    return false;
  }
  
  private void dRM()
  {
    AppMethodBeat.i(176415);
    ac.i("MiroMsg.CardAdTimeLineItem", "try show play btn");
    if ((this.zey != null) && (this.zey.zbE != null) && (!this.zeB))
    {
      ac.i("MiroMsg.CardAdTimeLineItem", "show play btn");
      this.zey.zbE.yoI.setVisibility(0);
      this.zey.zbE.yFg.setVisibility(8);
      this.zey.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
      this.zey.zbE.yoI.setContentDescription(this.mActivity.getString(2131761939));
    }
    AppMethodBeat.o(176415);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176412);
    if ((paramBaseViewHolder.timeLineObject.FQo.Ety == 5) || (paramBaseViewHolder.timeLineObject.FQo.Ety == 15))
    {
      ac.i("MiroMsg.CardAdTimeLineItem", "%s cardAd autoPlay pos %d", new Object[] { this, Integer.valueOf(paramInt) });
      d.dSq().crK();
      com.tencent.mm.plugin.sns.ui.video.b.dSj().a(this);
      paramBaseViewHolder.zbE.yFd.start();
      ac.i("MiroMsg.CardAdTimeLineItem", "try hide play btn");
      if ((this.zey != null) && (this.zey.zbE != null))
      {
        ac.i("MiroMsg.CardAdTimeLineItem", "hide play btn");
        this.zey.zbE.yoI.setVisibility(8);
        this.zey.zbE.yFg.setVisibility(8);
      }
      this.zeB = true;
      if ((paramBaseViewHolder instanceof a)) {
        ((a)paramBaseViewHolder).zeO = false;
      }
    }
    AppMethodBeat.o(176412);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final com.tencent.mm.plugin.sns.ui.bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, final be parambe)
  {
    AppMethodBeat.i(100065);
    ac.i("MiroMsg.CardAdTimeLineItem", "%s, fill card ad item %d, snsId %s", new Object[] { this, Integer.valueOf(paramInt1), paramTimeLineObject.Id });
    if (paramBaseViewHolder.fYC)
    {
      ac.i("MiroMsg.CardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(100065);
      return;
    }
    paramBaseViewHolder.fYC = true;
    locala = (a)paramBaseViewHolder;
    localp = parambe.Pl(paramInt1);
    this.xHc = localp;
    locala.zeL.setVisibility(8);
    locala.zbH.setVisibility(8);
    locala.zeK.setVisibility(8);
    locala.zbN.setVisibility(8);
    locala.zbN.setTag("");
    this.zeA.dOG();
    if (paramBaseViewHolder.zdj != null) {
      paramBaseViewHolder.zdj.setVisibility(8);
    }
    Object localObject1 = (WindowManager)this.mActivity.getSystemService("window");
    paramInt2 = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    ((a)paramBaseViewHolder).zdl.setOnClickListener(parambe.xZe.zgZ);
    localObject3 = new LinearLayout.LayoutParams(paramInt2 - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(2131165490) - this.mActivity.getResources().getDimensionPixelSize(2131165516), -2);
    ((LinearLayout.LayoutParams)localObject3).topMargin = this.mActivity.getResources().getDimensionPixelSize(2131165500);
    ((LinearLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 2);
    ((a)paramBaseViewHolder).isM.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    parambe.dQx().c(paramBaseViewHolder.zdl, parambe.xZe.zgH, parambe.xZe.zgp);
    if (locala.zeN != null) {
      locala.zeN.setVisibility(0);
    }
    if (locala.zeM != null)
    {
      if (!bs.isNullOrNil(localp.dFR().ygh)) {
        locala.zeM.setVisibility(0);
      }
    }
    else
    {
      localObject1 = localp.dFQ();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).dJC()) && (!localp.dMH())) {
        locala.zeL.setVisibility(0);
      }
      if (!bs.isNullOrNil(localp.dFR().ygi)) {
        break label1472;
      }
      localObject1 = paramTimeLineObject.FQl;
      label440:
      if (bs.isNullOrNil((String)localObject1)) {
        break label1485;
      }
      localObject4 = g.eXw();
      locala.zeN.getContext();
      localObject1 = ((g)localObject4).b((CharSequence)localObject1, locala.zeN.getTextSize());
      locala.zeN.setText((CharSequence)localObject1);
      locala.zeN.setVisibility(0);
      label498:
      localObject1 = localp.dFR().ygh;
      if (!bs.isNullOrNil((String)localObject1)) {
        break label1498;
      }
      locala.zeM.setVisibility(8);
    }
    for (;;)
    {
      try
      {
        localObject1 = localp.getSnsId();
        if (com.tencent.mm.plugin.sns.ui.widget.b.jK(locala.zeK.getOriginSnsId(), (String)localObject1)) {
          continue;
        }
        locala.zeK.removeAllViews();
        if (localp.dFR().ygl.ygS.size() > 0)
        {
          locala.zeK.setVisibility(0);
          locala.zeK.setTagSpace(com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 8));
          locala.zeK.fX(localp.dFR().ygl.ygS);
        }
        locala.zeK.setOriginSnsId((String)localObject1);
      }
      catch (Exception localException)
      {
        int n;
        label1472:
        label1485:
        label1498:
        ac.e("MiroMsg.CardAdTimeLineItem", localException.toString());
        continue;
        locala.zeJ.setVisibility(4);
        continue;
        if (localp.dFR().yfV != 2) {
          continue;
        }
        int i = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 54);
        int j = this.mActivity.getResources().getDimensionPixelSize(2131165490);
        int k = this.mActivity.getResources().getDimensionPixelSize(2131165516);
        int m = this.mActivity.getResources().getDimensionPixelSize(2131165568);
        paramBaseViewHolder.zdj.setContentWidth(paramInt2 - i - j - k - m);
        paramBaseViewHolder.zdj.dNe();
        continue;
        locala.zeI.setVisibility(4);
        continue;
        this.zeA.dOG();
        locala.zbH.setVisibility(0);
        j = this.mActivity.getResources().getColor(2131100027);
        k = this.mActivity.getResources().getColor(2131099658);
        i = 1;
        paramInt2 = i;
        if (!localp.dFR().dJP()) {
          continue;
        }
        m = x.jF(localp.dFR().ygC.yht, localp.dMD());
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
        locala.zeH.setTextColor(k);
        locala.zeH.setText(localp.dFR().ygC.OF(1));
        locala.zeG.setTextColor(j);
        locala.zeG.setText(localp.dFR().ygC.OE(0));
        paramInt2 = 0;
        if (paramInt2 == 0) {
          continue;
        }
        locala.zeG.setTextColor(j);
        locala.zeH.setTextColor(j);
        locala.zeG.setText(localp.dFR().dJH());
        locala.zeH.setText(localp.dFR().dJI());
        continue;
        if (m != 2) {
          continue;
        }
        locala.zeG.setTextColor(k);
        locala.zeG.setText(localp.dFR().ygC.OF(0));
        locala.zeH.setTextColor(j);
        locala.zeH.setText(localp.dFR().ygC.OE(1));
        continue;
        Object localObject2 = null;
        continue;
        if ((paramBaseViewHolder.timeLineObject.FQo.Ety != 5) && (paramBaseViewHolder.timeLineObject.FQo.Ety != 15)) {
          continue;
        }
        locala.zbE.yFc.setVisibility(0);
        locala.zcc.setVisibility(4);
        parambe.dQx().c(locala.zbE.yFf, parambe.xZe.zgH, parambe.xZe.zgp);
        localObject3 = locala.zbE.yFc.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject3).height = i;
        locala.zbE.yFc.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        locala.zbE.yFd.hf(paramInt2, i);
        locala.zbE.yFd.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(100062);
            if (paramAnonymousInt != -1)
            {
              if ((parambe == null) || (parambe.ySd == null) || (parambe.ySd.yxP == null))
              {
                AppMethodBeat.o(100062);
                return;
              }
              parambe.ySd.yxP.A(parambf.yUS, false);
              ac.d("MiroMsg.CardAdTimeLineItem", "onCompletion, snsId=" + q.wW(localp.field_snsId));
            }
            AppMethodBeat.o(100062);
          }
        });
        locala.zbE.yFd.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(100063);
            if ((parambe == null) || (parambe.ySd == null) || (parambe.ySd.yxP == null))
            {
              AppMethodBeat.o(100063);
              return;
            }
            if (localp != null)
            {
              parambe.ySd.yxP.wP(localp.field_snsId);
              parambe.ySd.yxP.ah(localp.field_snsId, 1000L * paramAnonymousLong);
            }
            if (!parambe.ySd.yxP.wM(parambf.yUS))
            {
              int i = (int)paramAnonymousb.dED();
              parambe.ySd.yxP.d(parambf.yUS, bs.Gn(), false);
              parambe.ySd.yxP.e(parambf.yUS, i, false);
              parambe.ySd.yxP.ag(parambf.yUS, parambf.yUS);
            }
            ac.d("MiroMsg.CardAdTimeLineItem", "onDecodeProgress, currentTime=" + paramAnonymousLong + ", snsId=" + q.wW(localp.field_snsId));
            AppMethodBeat.o(100063);
          }
        });
        long l = System.nanoTime();
        boolean bool = com.tencent.mm.plugin.sns.model.f.t((btz)localObject2);
        ac.i("MiroMsg.CardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
        localObject3 = locala.zbE;
        if (bool) {
          continue;
        }
        if (!((com.tencent.mm.plugin.sns.model.f)localObject4).w((btz)localObject2)) {
          continue;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.fuE();
        locala.zeG.setTag(locala);
        locala.zeH.setTag(locala);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFd.setTagObject(localObject3);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFf.setTag(locala);
        localObject3 = ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFd;
        paramInt2 = this.mActivity.hashCode();
        com.tencent.mm.storage.bf localbf = com.tencent.mm.storage.bf.fbk();
        localbf.gIh = paramTimeLineObject.CreateTime;
        ((com.tencent.mm.plugin.sns.model.f)localObject4).a(localp, (btz)localObject2, (VideoSightView)localObject3, paramInt2, paramInt1, localbf, parambf.yxA, true);
        paramTimeLineObject = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), ((btz)localObject2).Id);
        localObject2 = q.i((btz)localObject2);
        if (!com.tencent.mm.vfs.i.eA(paramTimeLineObject + (String)localObject2)) {
          continue;
        }
        parambe.ySd.yxP.B(parambf.yUS, true);
        if (af.dHO().b(localp, null) != 5) {
          continue;
        }
        bool = true;
        parambe.ySd.yxP.c(parambf.yUS, bool, false);
        continue;
        if (((com.tencent.mm.plugin.sns.model.f)localObject4).b(localp, null) != 5) {
          continue;
        }
        ((com.tencent.mm.plugin.sns.model.f)localObject4).A((btz)localObject2);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.fuE();
        continue;
        if (!((com.tencent.mm.plugin.sns.model.f)localObject4).x((btz)localObject2)) {
          continue;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setImageResource(2131234034);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(0);
        continue;
        ((com.tencent.mm.plugin.sns.model.f)localObject4).y((btz)localObject2);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setContentDescription(this.mActivity.getString(2131761939));
        if (((com.tencent.mm.plugin.sns.model.f)localObject4).b(localp, null) != 4) {
          continue;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoJ.setVisibility(0);
        continue;
        if (!((com.tencent.mm.plugin.sns.model.f)localObject4).u((btz)localObject2)) {
          continue;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setContentDescription(this.mActivity.getString(2131761939));
        if (!((com.tencent.mm.plugin.sns.ui.an)localObject3).yFd.xDG.dEA()) {
          continue;
        }
        ac.e("MiroMsg.CardAdTimeLineItem", "play video error " + ((btz)localObject2).Id + " " + ((btz)localObject2).Url + " " + ((btz)localObject2).Fjh + " " + paramInt1);
        ((com.tencent.mm.plugin.sns.model.f)localObject4).y((btz)localObject2);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setContentDescription(this.mActivity.getString(2131761939));
        continue;
        if (!((com.tencent.mm.plugin.sns.model.f)localObject4).v((btz)localObject2)) {
          continue;
        }
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(8);
        continue;
        if (((com.tencent.mm.plugin.sns.model.f)localObject4).b(localp, null) > 5) {
          continue;
        }
        if (locala.zeO) {
          continue;
        }
        ac.i("MiroMsg.CardAdTimeLineItem", "fillItem, showPlayBtn");
        dRM();
        continue;
        ((com.tencent.mm.plugin.sns.model.f)localObject4).y((btz)localObject2);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setVisibility(0);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yFg.setVisibility(8);
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
        ((com.tencent.mm.plugin.sns.ui.an)localObject3).yoI.setContentDescription(this.mActivity.getString(2131761939));
        continue;
        continue;
        parambe.ySd.yxP.B(parambf.yUS, false);
        continue;
        bool = false;
        continue;
        ((com.tencent.mm.plugin.sns.model.f)localObject4).a(paramBaseViewHolder.zbE.yFd, this.mActivity.hashCode(), paramInt1);
        paramBaseViewHolder.zbE.yFh.setVisibility(8);
        paramBaseViewHolder.zbE.yFd.setOnSightCompletionAction(null);
        paramBaseViewHolder.zbE.yFd.setOnCompletionListener(null);
        paramBaseViewHolder.zbE.yFd.setOnDecodeDurationListener(null);
        continue;
        locala.zbQ.setVisibility(8);
        continue;
      }
      if (bs.isNullOrNil(localp.dFR().ygj)) {
        continue;
      }
      locala.zbN.setVisibility(0);
      locala.zeJ.setVisibility(0);
      locala.zeJ.setText(localp.dFR().ygj);
      if (localp.dFR().yfV != 1) {
        continue;
      }
      i = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 54);
      j = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 54);
      k = this.mActivity.getResources().getDimensionPixelSize(2131165490);
      m = this.mActivity.getResources().getDimensionPixelSize(2131165516);
      n = this.mActivity.getResources().getDimensionPixelSize(2131165568);
      paramBaseViewHolder.zdj.setContentWidth(paramInt2 - i - j - k - m - n);
      paramBaseViewHolder.zdj.dNe();
      locala.zbN.setTag(localp.dFR().ygk);
      if (bs.isNullOrNil(localp.dFR().ygk)) {
        continue;
      }
      h.a(localp.dFR().ygk, false, new f.a()
      {
        public final void asD(String paramAnonymousString)
        {
          AppMethodBeat.i(100061);
          ac.i("MiroMsg.CardAdTimeLineItem", "download img %s", new Object[] { paramAnonymousString });
          if ((!bs.T(new String[] { (String)locala.zbN.getTag(), paramAnonymousString })) && (paramAnonymousString.equals(h.js("adId", (String)locala.zbN.getTag()))))
          {
            paramAnonymousString = com.tencent.mm.sdk.platformtools.f.decodeFile(paramAnonymousString, null);
            if (paramAnonymousString != null)
            {
              locala.zbN.setVisibility(0);
              locala.zeI.setImageBitmap(paramAnonymousString);
              locala.zeI.setVisibility(0);
            }
          }
          AppMethodBeat.o(100061);
        }
        
        public final void dFC() {}
        
        public final void dFD() {}
      });
      if ((localp.dFR().dJN()) || (localp.dFR().dJP()))
      {
        if (!localp.dFR().dJO()) {
          continue;
        }
        this.zeA.dOF();
        this.zeA.a(localp, locala);
        locala.zbH.setVisibility(8);
        if (locala.zeN != null) {
          locala.zeN.setVisibility(8);
        }
        if (locala.zeM != null) {
          locala.zeM.setVisibility(8);
        }
      }
      locala.zcc.setScaleType(QImageView.a.JbU);
      locala.zbE.yFd.xDO = true;
      locala.zbE.yFd.setScaleType(QImageView.a.JbU);
      if ((paramTimeLineObject.FQo == null) || (paramTimeLineObject.FQo.Etz.size() <= 0)) {
        continue;
      }
      localObject1 = (btz)paramTimeLineObject.FQo.Etz.get(0);
      localObject4 = af.dHO();
      if ((paramBaseViewHolder.zbE.yFb != null) && (!bs.lr(paramBaseViewHolder.zbE.yFb.Id, paramTimeLineObject.Id)))
      {
        ac.i("MiroMsg.CardAdTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.zbE.yFb.Id });
        ((com.tencent.mm.plugin.sns.model.f)localObject4).a(paramBaseViewHolder.zbE.yFd, this.mActivity.hashCode(), paramInt1);
      }
      paramBaseViewHolder.zbE.a(paramTimeLineObject, paramInt1, parambf.yzm, parambf.yxA);
      paramBaseViewHolder.zbE.yoJ.setVisibility(8);
      if (localObject1 != null)
      {
        paramInt2 = ((LinearLayout.LayoutParams)localObject3).width - this.mActivity.getResources().getDimensionPixelSize(2131165568) - this.mActivity.getResources().getDimensionPixelSize(2131165568);
        i = (int)(paramInt2 * ((btz)localObject1).Fjk.FjZ / ((btz)localObject1).Fjk.FjY);
        if (paramBaseViewHolder.timeLineObject.FQo.Ety != 1) {
          continue;
        }
        locala.zcc.setVisibility(0);
        locala.zbE.yFc.setVisibility(4);
        parambf = locala.zcc.getLayoutParams();
        parambf.width = paramInt2;
        parambf.height = i;
        locala.zcc.setLayoutParams(parambf);
        parambf = af.dHO();
        localObject3 = locala.zcc;
        paramInt1 = this.mActivity.hashCode();
        localObject4 = com.tencent.mm.storage.bf.fbk();
        ((com.tencent.mm.storage.bf)localObject4).gIh = paramTimeLineObject.CreateTime;
        parambf.b((btz)localObject1, (View)localObject3, -1, paramInt1, (com.tencent.mm.storage.bf)localObject4);
        locala.zcc.setTag(locala);
        locala.zeG.setTag(locala);
        locala.zeH.setTag(locala);
        locala.zcc.setOnClickListener(parambe.xZe.yAf);
        parambe.dQx().c(locala.zcc, parambe.xZe.zgH, parambe.xZe.zgp);
        locala.zeO = false;
      }
      if (!localp.dFR().dJF()) {
        continue;
      }
      if (locala.zeN != null) {
        locala.zeN.setVisibility(8);
      }
      if (locala.zeM != null) {
        locala.zeM.setVisibility(8);
      }
      locala.zbQ.setVisibility(0);
      this.zez.N(localp);
      paramBaseViewHolder.fYC = false;
      AppMethodBeat.o(100065);
      return;
      locala.zeM.setVisibility(8);
      break;
      localObject1 = localp.dFR().ygi;
      break label440;
      locala.zeN.setVisibility(8);
      break label498;
      localObject4 = g.eXw();
      locala.zeM.getContext();
      localObject1 = ((g)localObject4).b((CharSequence)localObject1, locala.zeM.getTextSize());
      locala.zeM.setText((CharSequence)localObject1);
      locala.zeM.setVisibility(0);
      continue;
      if (localp.dFR().ygl.ygS.size() > 0) {
        locala.zeK.setVisibility(0);
      }
    }
  }
  
  public final void e(final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100064);
    this.zey = ((a)paramBaseViewHolder);
    if (paramBaseViewHolder.zdm != null)
    {
      paramBaseViewHolder.zdm.setLayoutResource(2131495488);
      if (!paramBaseViewHolder.zdn)
      {
        this.zey.isM = ((ViewGroup)paramBaseViewHolder.zdm.inflate());
        paramBaseViewHolder.zdn = true;
      }
    }
    for (;;)
    {
      this.zey.zeE = ((ViewGroup)this.zey.isM.findViewById(2131302206));
      if ((this.zey.zeE instanceof RoundedCornerFrameLayout)) {
        ((RoundedCornerFrameLayout)this.zey.zeE).setRadius(com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 4));
      }
      this.zey.zeF = ((ViewGroup)this.zey.isM.findViewById(2131303102));
      this.zey.zcc = ((MaskImageView)this.zey.isM.findViewById(2131304943));
      this.zey.zcc.setOnClickListener(this.xZJ.xZe.yAf);
      this.xZJ.dQx().c(this.zey.zcc, this.xZJ.xZe.zgD, this.xZJ.xZe.zgp);
      this.zey.zeN = ((TextView)this.zey.isM.findViewById(2131299000));
      this.zey.zeN.setClickable(false);
      this.zey.zeN.setLongClickable(false);
      this.zey.zeM = ((TextView)this.zey.isM.findViewById(2131298999));
      this.zey.zeM.setClickable(false);
      this.zey.zeM.setLongClickable(false);
      this.zey.zbE = new com.tencent.mm.plugin.sns.ui.an();
      this.zey.zbE.yFf = this.zey.isM.findViewById(2131304944);
      this.zey.zbE.yFc = this.zey.zbE.yFf;
      this.zey.zbE.yFf.setOnClickListener(this.xZJ.xZe.zgM);
      this.zey.zbE.yFd = ((VideoSightView)this.zey.zbE.yFf.findViewById(2131300914));
      this.zey.zbE.yFd.setMute(true);
      this.zey.zbE.yoI = ((ImageView)this.zey.zbE.yFf.findViewById(2131305196));
      this.zey.zbE.yFg = ((MMPinProgressBtn)this.zey.zbE.yFf.findViewById(2131303515));
      this.zey.zbE.yFh = ((TextView)this.zey.zbE.yFf.findViewById(2131299492));
      this.zey.zbE.yoJ = ((TextView)this.zey.zbE.yFf.findViewById(2131299517));
      this.zey.zbN = this.zey.isM.findViewById(2131304890);
      this.zey.zeI = ((ImageView)this.zey.isM.findViewById(2131304889));
      this.zey.zeJ = ((TextView)this.zey.isM.findViewById(2131304891));
      this.zey.zeL = this.zey.isM.findViewById(2131297919);
      this.zey.zbH = this.zey.isM.findViewById(2131297744);
      this.zey.zeG = ((Button)this.zey.isM.findViewById(2131297745));
      this.zey.zeH = ((Button)this.zey.isM.findViewById(2131297746));
      this.zey.zeG.setOnClickListener(this.xZJ.xZe.zgX);
      this.zey.zeH.setOnClickListener(this.xZJ.xZe.zgY);
      this.zey.zeK = ((SnsCardAdTagListView)this.zey.isM.findViewById(2131297725));
      this.zey.zeK.setActivityContext(this.mActivity);
      this.zey.zbQ = this.zey.isM.findViewById(2131296355);
      this.zez = new ap(this.mActivity, this.zey.isM, 0, this.xZJ.ySd.yxP, new ap.b()
      {
        public final void dOE()
        {
          AppMethodBeat.i(100060);
          a.this.xZJ.xZe.i(paramBaseViewHolder);
          AppMethodBeat.o(100060);
        }
      });
      this.zeA = new ar(this.mActivity, this.zey.isM, this.xZJ.xZe);
      if (aj.DT()) {
        ((ImageView)this.zey.isM.findViewById(2131306896)).setImageDrawable(this.mActivity.getResources().getDrawable(2131689524));
      }
      AppMethodBeat.o(100064);
      return;
      if (!paramBaseViewHolder.zdn)
      {
        this.zey.isM = ((ViewGroup)paramBaseViewHolder.sSS.findViewById(2131296428));
        paramBaseViewHolder.zdn = true;
      }
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(176416);
    if ((this.zey != null) && (this.zey.zeE != null))
    {
      Object localObject = new int[2];
      this.zey.zeE.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.zey.zeE.getMeasuredWidth() + i, this.zey.zeE.getMeasuredHeight() + j);
      AppMethodBeat.o(176416);
      return localObject;
    }
    AppMethodBeat.o(176416);
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177692);
    ac.i("MiroMsg.CardAdTimeLineItem", "onUIPause");
    dRL();
    AppMethodBeat.o(177692);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176413);
    ac.i("MiroMsg.CardAdTimeLineItem", "pause");
    if (dRL()) {
      dRM();
    }
    AppMethodBeat.o(176413);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176414);
    ac.i("MiroMsg.CardAdTimeLineItem", "%s cardAd stop", new Object[] { this });
    if ((this.zey != null) && (this.zey.zbE != null)) {
      this.zey.zbE.yFd.xDG.clear();
    }
    this.zeB = false;
    AppMethodBeat.o(176414);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public ViewGroup isM;
    public View zbH;
    public View zbN;
    public View zbQ;
    public MaskImageView zcc;
    public ViewGroup zeE;
    public ViewGroup zeF;
    public Button zeG;
    public Button zeH;
    public ImageView zeI;
    public TextView zeJ;
    public SnsCardAdTagListView zeK;
    public View zeL;
    public TextView zeM;
    public TextView zeN;
    public boolean zeO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a
 * JD-Core Version:    0.7.0.1
 */