package com.tencent.mm.plugin.sns.ui.c;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.ckw;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.az;
import java.util.LinkedList;

public final class g
  extends a
{
  public final void a(a.c paramc, int paramInt1, ax paramax, bxk parambxk, int paramInt2, au paramau)
  {
    paramc.pmL.setPosition(paramInt1);
    Object localObject1 = paramax.oOM;
    Object localObject2 = paramax.oje;
    paramInt1 = 0;
    int i;
    if (paramax.oNn)
    {
      if (((n)localObject2).bFZ().oBr == 2)
      {
        paramInt1 = 1;
        paramc.pci.setTag(paramc);
        paramc.pci.setOnClickListener(paramau.ovx.ppk);
      }
      i = 0;
    }
    for (;;)
    {
      label101:
      int j;
      if (paramInt1 != 0)
      {
        paramau.iep.c(paramc.pci, paramau.ovx.poS, paramau.ovx.poz);
        if (parambxk.tNr.sPI != 9) {
          break label1179;
        }
        j = 1;
        label117:
        if (j == 0) {
          break label1199;
        }
        paramax = au.Pq(parambxk.tNr.kSC);
        label134:
        if ((parambxk.tNr.sPI != 9) && (parambxk.tNr.sPI != 14) && (parambxk.tNr.sPI != 12) && (parambxk.tNr.sPI != 13) && (paramInt1 == 0)) {
          break label1621;
        }
      }
      label385:
      label410:
      label1179:
      label1199:
      label1621:
      for (paramau = parambxk.tNr.kRN;; paramau = paramax)
      {
        paramax = parambxk.tNr.bGw;
        if ((paramax != null) && (paramax.length() > 40)) {
          paramax = paramax.substring(0, 40) + "...";
        }
        for (;;)
        {
          paramc.oNr.setVisibility(8);
          TagImageView localTagImageView;
          az localaz;
          if (!parambxk.tNr.sPJ.isEmpty())
          {
            paramc.pmL.setVisibility(0);
            localObject1 = (awd)parambxk.tNr.sPJ.get(0);
            if (parambxk.tNr.sPI == 5)
            {
              paramax = ((awd)localObject1).bGw;
              paramc.oNr.setImageResource(i.e.video_playicon_normal);
              paramc.oNr.setVisibility(0);
              localObject2 = af.bDC();
              localTagImageView = paramc.pmL;
              paramInt1 = i.i.app_attach_file_icon_video;
              j = this.mActivity.hashCode();
              localaz = az.cuY();
              localaz.time = parambxk.mPL;
              ((com.tencent.mm.plugin.sns.model.g)localObject2).a((awd)localObject1, localTagImageView, paramInt1, j, localaz);
              if (bk.bl(paramau)) {
                break label1530;
              }
              paramc.pmM.setVisibility(0);
              paramc.pmM.setText(paramau);
              if (bk.bl(paramax)) {
                break label1575;
              }
              if (paramc.pmM.getVisibility() != 8) {
                break label1542;
              }
              if (paramc.pmN != 2) {
                paramc.eXr.setMaxLines(2);
              }
            }
          }
          for (paramc.pmN = 2;; paramc.pmN = 1)
          {
            paramc.eXr.setVisibility(0);
            if (i == 0) {
              break label1566;
            }
            paramc.eXr.setText(i.a(paramax, this.mActivity, paramc.eXr));
            return;
            if (parambxk.tNr.sPI == 9)
            {
              if (parambxk.tNr.sPJ.size() <= 0) {
                break label1627;
              }
              paramc.pci.setTag(new q(parambxk, (String)localObject1));
              paramc.pci.setOnClickListener(paramau.oWp.pjU);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (parambxk.tNr.sPI == 10)
            {
              if (parambxk.tNr.sPJ.size() <= 0) {
                break label1627;
              }
              paramc.pci.setTag(new q(parambxk, (String)localObject1));
              paramc.pci.setOnClickListener(paramau.oWp.pjW);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (parambxk.tNr.sPI == 17)
            {
              if (parambxk.tNr.sPJ.size() <= 0) {
                break label1627;
              }
              paramc.pci.setTag(new q(parambxk, (String)localObject1));
              paramc.pci.setOnClickListener(paramau.oWp.pjX);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (parambxk.tNr.sPI == 22)
            {
              if (parambxk.tNr.sPJ.size() <= 0) {
                break label1627;
              }
              paramc.pci.setTag(new q(parambxk, (String)localObject1));
              paramc.pci.setOnClickListener(paramau.oWp.pjY);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (parambxk.tNr.sPI == 23)
            {
              if (parambxk.tNr.sPJ.size() <= 0) {
                break label1627;
              }
              paramc.pci.setTag(new q(parambxk, (String)localObject1));
              paramc.pci.setOnClickListener(paramau.oWp.pjZ);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (parambxk.tNr.sPI == 14)
            {
              if (parambxk.tNr.sPJ.size() <= 0) {
                break label1627;
              }
              paramc.pci.setTag(new q(parambxk, (String)localObject1));
              paramc.pci.setOnClickListener(paramau.oWp.pjV);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (parambxk.tNr.sPI == 12)
            {
              if (parambxk.tNr.sPJ.size() <= 0) {
                break label1627;
              }
              paramc.pci.setTag(new q(parambxk, (String)localObject1));
              paramc.pci.setOnClickListener(paramau.oWp.pkd);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (parambxk.tNr.sPI == 13)
            {
              if (parambxk.tNr.sPJ.size() > 0)
              {
                paramc.pci.setTag(new q(parambxk, (String)localObject1));
                paramc.pci.setOnClickListener(paramau.oWp.pke);
                paramInt1 = 0;
                i = 0;
                break;
              }
              paramc.pci.setOnClickListener(null);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (parambxk.tNr.sPI == 26)
            {
              paramc.pci.setTag(new q(parambxk, (String)localObject1));
              paramc.pci.setOnClickListener(paramau.oWp.pkf);
              paramInt1 = 0;
              i = 0;
              break;
            }
            paramc.pci.setTag(new q(parambxk, (String)localObject1));
            paramc.pci.setOnClickListener(paramau.oWp.pbU);
            if ((parambxk.dQA & 0x1) <= 0) {
              break label1627;
            }
            paramInt1 = 0;
            i = 1;
            break;
            paramau.iep.c(paramc.pci, paramau.ovx.poO, paramau.ovx.poz);
            break label101;
            if ((am.a.bEf() & 0x1) <= 0)
            {
              j = 1;
              break label117;
            }
            j = 0;
            break label117;
            paramax = "";
            break label134;
            if (parambxk.tNr.sPI == 18)
            {
              paramc.oNr.setVisibility(0);
              paramc.oNr.setImageResource(i.e.video_playicon_normal);
              paramc.pmL.setVisibility(0);
              localObject2 = af.bDC();
              localTagImageView = paramc.pmL;
              paramInt1 = i.i.app_attach_file_icon_video;
              j = this.mActivity.hashCode();
              localaz = az.cuY();
              localaz.time = parambxk.mPL;
              ((com.tencent.mm.plugin.sns.model.g)localObject2).a((awd)localObject1, localTagImageView, paramInt1, j, localaz);
              break label385;
            }
            if ((parambxk.ouE != null) && (!bk.bl(parambxk.ouE.qTY)))
            {
              paramc.oNr.setImageResource(i.e.video_playicon_normal);
              paramc.oNr.setVisibility(0);
            }
            localObject2 = af.bDC();
            localTagImageView = paramc.pmL;
            paramInt1 = this.mActivity.hashCode();
            localaz = az.cuY();
            localaz.time = parambxk.mPL;
            ((com.tencent.mm.plugin.sns.model.g)localObject2).b((awd)localObject1, localTagImageView, paramInt1, localaz);
            break label385;
            if (parambxk.tNr.sPI == 18)
            {
              paramc.oNr.setVisibility(0);
              paramc.oNr.setImageResource(i.e.video_playicon_normal);
              paramc.pmL.setVisibility(0);
              af.bDC().a(paramc.pmL, -1, i.i.app_attach_file_icon_video, this.mActivity.hashCode());
              break label385;
            }
            if (parambxk.tNr.sPI == 26)
            {
              paramc.pmL.setVisibility(0);
              af.bDC().a(paramc.pmL, -1, i.i.note_sns_link_default, this.mActivity.hashCode());
              break label385;
            }
            paramc.pmL.setVisibility(0);
            af.bDC().a(paramc.pmL, -1, i.i.app_attach_file_icon_webpage, this.mActivity.hashCode());
            break label385;
            label1530:
            paramc.pmM.setVisibility(8);
            break label410;
            if (paramc.pmN != 1) {
              paramc.eXr.setMaxLines(1);
            }
          }
          paramc.eXr.setText(paramax);
          return;
          if (paramInt2 == 1)
          {
            paramc.eXr.setText(au.Pq(parambxk.tNr.kSC));
            paramc.eXr.setVisibility(0);
            return;
          }
          paramc.eXr.setVisibility(8);
          return;
        }
      }
      label1542:
      label1566:
      label1575:
      label1627:
      paramInt1 = 0;
      i = 0;
    }
  }
  
  public final void d(a.c paramc)
  {
    if ((paramc.pmI != null) && (paramc.pmI.getParent() != null))
    {
      paramc.pmI.setLayoutResource(i.g.sns_media_sub_item2);
      if (!paramc.pns) {
        paramc.pnt = paramc.pmI.inflate();
      }
    }
    for (paramc.pns = true;; paramc.pns = true)
    {
      paramc.pci = paramc.pnt;
      paramc.pmL = ((TagImageView)paramc.pci.findViewById(i.f.image_left));
      paramc.oNr = ((ImageView)paramc.pci.findViewById(i.f.state));
      paramc.pmM = ((TextView)paramc.pci.findViewById(i.f.righttext));
      paramc.eXr = ((TextView)paramc.pci.findViewById(i.f.titletext));
      paramc.eXr.setTextColor(this.mActivity.getResources().getColor(i.c.black));
      i.b(paramc.pmL, this.mActivity);
      return;
      paramc.pnt = paramc.kKz.findViewById(i.f.media_content_rl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.g
 * JD-Core Version:    0.7.0.1
 */