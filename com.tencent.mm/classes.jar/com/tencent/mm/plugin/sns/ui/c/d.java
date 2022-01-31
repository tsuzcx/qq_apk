package com.tencent.mm.plugin.sns.ui.c;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
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
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.widget.RoundedCornerRelativeLayout;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public final class d
  extends a
{
  public final void a(a.c paramc, int paramInt1, ax paramax, bxk parambxk, int paramInt2, au paramau)
  {
    y.i("MicroMsg.FullCardAdTimeLineItem", "fill full card ad item %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramc.dCs)
    {
      y.i("MicroMsg.FullCardAdTimeLineItem", "holder is busy");
      return;
    }
    Object localObject4 = (d.a)paramc;
    Object localObject3 = paramax.oje;
    if ((localObject3 != null) && (((n)localObject3).bFZ() != null)) {}
    for (Object localObject2 = ((n)localObject3).bFZ().oBy;; localObject2 = null)
    {
      Object localObject1 = (WindowManager)this.mActivity.getSystemService("window");
      paramInt2 = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
      if (localObject2 != null)
      {
        paramInt2 = paramInt2 - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.SmallPadding);
        if (((b.c)localObject2).oBK == 0)
        {
          localObject1 = new ViewGroup.LayoutParams(-2, -2);
          ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
          ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject5 = ((d.a)localObject4).oUF.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject5).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject5).height = ((ViewGroup.LayoutParams)localObject1).height;
          ((d.a)localObject4).oUF.setLayoutParams((ViewGroup.LayoutParams)localObject5);
          ((RoundedCornerRelativeLayout)((d.a)localObject4).oUF).setRadius(8);
          localObject5 = ((d.a)localObject4).pmj.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject5).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject5).height = ((ViewGroup.LayoutParams)localObject1).height;
          ((d.a)localObject4).pmj.setLayoutParams((ViewGroup.LayoutParams)localObject5);
          localObject5 = ((d.a)localObject4).plQ.oTG.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject5).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject5).height = ((ViewGroup.LayoutParams)localObject1).height;
          ((d.a)localObject4).plQ.oTG.setLayoutParams((ViewGroup.LayoutParams)localObject5);
          ((d.a)localObject4).plQ.ogP.dL(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        }
        int i;
        if (((b.c)localObject2).oBM == 0)
        {
          paramInt2 = Color.argb((int)(((b.c)localObject2).oBL * 2.55F), 0, 0, 0);
          i = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt2, i });
          ((GradientDrawable)localObject1).setGradientType(0);
          ((d.a)localObject4).pmd.setBackground((Drawable)localObject1);
          if ((!bk.bl(((b.c)localObject2).title)) || (!bk.bl(((b.c)localObject2).description)))
          {
            ((d.a)localObject4).pmd.setVisibility(0);
            label485:
            ((d.a)localObject4).pme.setVisibility(8);
            if (bk.bl(((b.c)localObject2).title)) {
              break label864;
            }
            ((d.a)localObject4).pmf.setVisibility(0);
            ((d.a)localObject4).pmf.setText(((b.c)localObject2).title);
            label528:
            if (bk.bl(((b.c)localObject2).description)) {
              break label877;
            }
            ((d.a)localObject4).pmg.setVisibility(0);
            ((d.a)localObject4).pmg.setText(((b.c)localObject2).description);
            label561:
            if ((parambxk.tNr == null) || (parambxk.tNr.sPJ.size() <= 0)) {
              break label1150;
            }
          }
        }
        label864:
        label877:
        label1008:
        label1150:
        for (localObject1 = (awd)parambxk.tNr.sPJ.get(0);; localObject1 = null)
        {
          paramc.plQ.a(parambxk, paramInt1, paramax.oOM, paramax.oNn);
          paramc.plQ.oGU.setVisibility(8);
          localObject2 = af.bDC();
          if (localObject1 == null) {
            break label2024;
          }
          ((d.a)localObject4).plQ.ogP.setOnCompletionListener(new d.1(this, paramau, paramax));
          if (!paramau.pec.oNB.fG(paramax.pgP)) {
            ((d.a)localObject4).plQ.ogP.setOnDecodeDurationListener(new d.2(this, paramau, paramax, (d.a)localObject4));
          }
          if (parambxk.tNr.sPI != 1) {
            break label1156;
          }
          ((d.a)localObject4).pmj.setVisibility(0);
          ((d.a)localObject4).plQ.oTG.setVisibility(4);
          paramax = ((d.a)localObject4).pmj;
          paramInt1 = this.mActivity.hashCode();
          localObject3 = az.cuY();
          ((az)localObject3).time = parambxk.mPL;
          ((com.tencent.mm.plugin.sns.model.g)localObject2).b((awd)localObject1, paramax, -1, paramInt1, (az)localObject3);
          ((d.a)localObject4).pmj.setTag(paramc);
          ((d.a)localObject4).pmj.setOnClickListener(paramau.ovx.ppf);
          return;
          if (((b.c)localObject2).oBK != 1) {
            break label2096;
          }
          localObject1 = new ViewGroup.LayoutParams(-2, -2);
          ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
          ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
          break;
          ((d.a)localObject4).pmd.setVisibility(8);
          break label485;
          ((d.a)localObject4).pmf.setVisibility(8);
          break label528;
          ((d.a)localObject4).pmg.setVisibility(8);
          break label561;
          if (((b.c)localObject2).oBM == 1)
          {
            paramInt2 = Color.argb((int)(((b.c)localObject2).oBL * 2.55F), 0, 0, 0);
            i = Color.argb(0, 0, 0, 0);
            localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
            ((GradientDrawable)localObject1).setGradientType(0);
            ((d.a)localObject4).pmd.setVisibility(8);
            ((d.a)localObject4).pme.setBackground((Drawable)localObject1);
            if ((!bk.bl(((b.c)localObject2).title)) || (!bk.bl(((b.c)localObject2).description)))
            {
              ((d.a)localObject4).pme.setVisibility(0);
              if (bk.bl(((b.c)localObject2).title)) {
                break label1090;
              }
              ((d.a)localObject4).pmh.setVisibility(0);
              ((d.a)localObject4).pmh.setText(((b.c)localObject2).title);
            }
            for (;;)
            {
              if (bk.bl(((b.c)localObject2).description)) {
                break label1103;
              }
              ((d.a)localObject4).pmi.setVisibility(0);
              ((d.a)localObject4).pmi.setText(((b.c)localObject2).description);
              break;
              ((d.a)localObject4).pme.setVisibility(8);
              break label1008;
              ((d.a)localObject4).pmh.setVisibility(8);
            }
            ((d.a)localObject4).pmi.setVisibility(8);
            break label561;
          }
          ((d.a)localObject4).pmd.setVisibility(8);
          ((d.a)localObject4).pme.setVisibility(8);
          break label561;
          y.e("MicroMsg.FullCardAdTimeLineItem", "invalid full card");
          break label561;
        }
        label1090:
        label1103:
        if ((parambxk.tNr.sPI != 15) && (parambxk.tNr.sPI != 5)) {
          break;
        }
        label1156:
        long l = System.nanoTime();
        boolean bool = com.tencent.mm.plugin.sns.model.g.t((awd)localObject1);
        y.i("MicroMsg.FullCardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
        Object localObject5 = ((d.a)localObject4).plQ;
        if (!bool) {
          if (((com.tencent.mm.plugin.sns.model.g)localObject2).w((awd)localObject1))
          {
            ((aj)localObject5).oGT.setVisibility(8);
            ((aj)localObject5).oTI.setVisibility(0);
            ((aj)localObject5).oTI.cJO();
            ((d.a)localObject4).plQ.oTG.setVisibility(0);
            ((d.a)localObject4).pmj.setVisibility(4);
            ((aj)localObject5).ogP.setTagObject(localObject5);
            ((aj)localObject5).oTH.setTag(paramc);
            ((d.a)localObject4).plQ.oTG.setOnClickListener(paramau.ovx.ppf);
            paramc = ((aj)localObject5).ogP;
            paramInt2 = this.mActivity.hashCode();
            localObject4 = az.cuY();
            ((az)localObject4).time = parambxk.mPL;
            ((com.tencent.mm.plugin.sns.model.g)localObject2).a((n)localObject3, (awd)localObject1, paramc, paramInt2, paramInt1, (az)localObject4, paramax.oNn, true);
            paramc = an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK);
            parambxk = com.tencent.mm.plugin.sns.data.i.j((awd)localObject1);
            if (!e.bK(paramc + parambxk)) {
              break label1999;
            }
            paramau.pec.oNB.r(paramax.pgP, true);
            label1446:
            if (af.bDC().b((n)localObject3, null) != 5) {
              break label2018;
            }
          }
        }
        label1997:
        label1999:
        label2018:
        for (bool = true;; bool = false)
        {
          paramau.pec.oNB.a(paramax.pgP, bool, false);
          return;
          if (((com.tencent.mm.plugin.sns.model.g)localObject2).b((n)localObject3, null) == 5)
          {
            ((com.tencent.mm.plugin.sns.model.g)localObject2).A((awd)localObject1);
            ((aj)localObject5).oGT.setVisibility(8);
            ((aj)localObject5).oTI.setVisibility(0);
            ((aj)localObject5).oTI.cJO();
            break;
          }
          if (((com.tencent.mm.plugin.sns.model.g)localObject2).x((awd)localObject1))
          {
            ((aj)localObject5).oTI.setVisibility(8);
            ((aj)localObject5).oGT.setImageResource(i.e.sight_chat_error);
            ((aj)localObject5).oGT.setVisibility(0);
            break;
          }
          ((com.tencent.mm.plugin.sns.model.g)localObject2).y((awd)localObject1);
          ((aj)localObject5).oGT.setVisibility(0);
          ((aj)localObject5).oTI.setVisibility(8);
          ((aj)localObject5).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
          ((aj)localObject5).oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
          if (((com.tencent.mm.plugin.sns.model.g)localObject2).b((n)localObject3, null) != 4) {
            break;
          }
          ((aj)localObject5).oGU.setVisibility(0);
          break;
          if (((com.tencent.mm.plugin.sns.model.g)localObject2).u((awd)localObject1))
          {
            ((aj)localObject5).oGT.setVisibility(0);
            ((aj)localObject5).oTI.setVisibility(8);
            ((aj)localObject5).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
            ((aj)localObject5).oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
          }
          for (;;)
          {
            if (!((aj)localObject5).ogP.bAY()) {
              break label1997;
            }
            y.d("MicroMsg.FullCardAdTimeLineItem", "play video error " + ((awd)localObject1).lsK + " " + ((awd)localObject1).kSC + " " + ((awd)localObject1).trP + " " + paramInt1);
            ((com.tencent.mm.plugin.sns.model.g)localObject2).y((awd)localObject1);
            ((aj)localObject5).oGT.setVisibility(0);
            ((aj)localObject5).oTI.setVisibility(8);
            ((aj)localObject5).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
            ((aj)localObject5).oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
            break;
            if (((com.tencent.mm.plugin.sns.model.g)localObject2).v((awd)localObject1))
            {
              ((aj)localObject5).oGT.setVisibility(8);
              ((aj)localObject5).oTI.setVisibility(8);
            }
            else if (((com.tencent.mm.plugin.sns.model.g)localObject2).b((n)localObject3, null) <= 5)
            {
              ((aj)localObject5).oGT.setVisibility(8);
              ((aj)localObject5).oTI.setVisibility(8);
            }
            else
            {
              ((com.tencent.mm.plugin.sns.model.g)localObject2).y((awd)localObject1);
              ((aj)localObject5).oGT.setVisibility(0);
              ((aj)localObject5).oTI.setVisibility(8);
              ((aj)localObject5).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
              ((aj)localObject5).oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
            }
          }
          break;
          paramau.pec.oNB.r(paramax.pgP, false);
          break label1446;
        }
        label2024:
        ((com.tencent.mm.plugin.sns.model.g)localObject2).a(paramc.plQ.ogP, this.mActivity.hashCode());
        paramc.plQ.oTJ.setVisibility(8);
        paramc.plQ.ogP.setOnSightCompletionAction(null);
        paramc.plQ.ogP.setOnCompletionListener(null);
        paramc.plQ.ogP.setOnDecodeDurationListener(null);
        return;
        label2096:
        localObject1 = null;
      }
    }
  }
  
  public final void d(a.c paramc)
  {
    d.a locala = (d.a)paramc;
    if (paramc.pmI != null)
    {
      paramc.pmI.setLayoutResource(i.g.sns_timeline_ad_full_card);
      if (!paramc.pmJ)
      {
        locala.oUF = paramc.pmI.inflate();
        paramc.pmJ = true;
      }
    }
    for (;;)
    {
      locala.pmd = locala.kKz.findViewById(i.f.top_layer);
      locala.pme = locala.kKz.findViewById(i.f.bottom_layer);
      locala.pmf = ((TextView)locala.kKz.findViewById(i.f.top_layer_title));
      locala.pmg = ((TextView)locala.kKz.findViewById(i.f.top_layer_desc));
      locala.pmh = ((TextView)locala.kKz.findViewById(i.f.bottom_layer_title));
      locala.pmi = ((TextView)locala.kKz.findViewById(i.f.bottom_layer_desc));
      locala.pmj = ((MaskImageView)locala.kKz.findViewById(i.f.full_card_img));
      locala.pmj.setScaleType(QImageView.a.wkS);
      locala.plQ = new aj();
      locala.plQ.oTH = locala.oUF.findViewById(i.f.full_card_video);
      locala.plQ.oTG = locala.plQ.oTH;
      locala.plQ.oTH.setOnClickListener(this.owd.ovx.poW);
      locala.plQ.ogP = ((com.tencent.mm.plugin.sight.decode.a.a)locala.plQ.oTH.findViewById(i.f.image));
      locala.plQ.oGT = ((ImageView)locala.plQ.oTH.findViewById(i.f.status_btn));
      locala.plQ.oTI = ((MMPinProgressBtn)locala.plQ.oTH.findViewById(i.f.progress));
      locala.plQ.oTJ = ((TextView)locala.plQ.oTH.findViewById(i.f.endtv));
      locala.plQ.oGU = ((TextView)locala.plQ.oTH.findViewById(i.f.errorTv));
      ((SightPlayImageView)locala.plQ.ogP).ofL = true;
      ((SightPlayImageView)locala.plQ.ogP).setScaleType(QImageView.a.wkS);
      return;
      if (!paramc.pmJ)
      {
        locala.oUF = paramc.kKz.findViewById(i.f.full_card_container);
        paramc.pmJ = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.d
 * JD-Core Version:    0.7.0.1
 */