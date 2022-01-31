package com.tencent.mm.plugin.sns.ui.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends a
{
  private int oWr;
  private int oWs = 103;
  MaskImageView pnY;
  
  @TargetApi(16)
  public final void a(a.c paramc, int paramInt1, ax paramax, bxk parambxk, int paramInt2, au paramau)
  {
    paramc.pmZ.setVisibility(0);
    Object localObject1;
    boolean bool;
    label58:
    int i;
    Object localObject2;
    float f2;
    float f1;
    Object localObject3;
    if (parambxk.tNq == null)
    {
      localObject1 = null;
      if (!bk.bl((String)localObject1))
      {
        if (!paramau.pen.containsKey(localObject1)) {
          break label532;
        }
        bool = ((Boolean)paramau.pen.get(localObject1)).booleanValue();
        if (bool) {
          com.tencent.mm.plugin.sns.c.a.eUS.a((String)localObject1, parambxk.hPY, parambxk.tNv, paramax.pgP);
        }
      }
      localObject1 = new LinkedList();
      i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
      if ((paramax.oNn) && (paramInt2 == 2))
      {
        localObject2 = paramax.oje.bFZ();
        if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh > 0.0F) && (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi > 0.0F))
        {
          f2 = i.a(((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBj, ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBk);
          f1 = i.a(((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBj, ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBk);
          if (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBg != 0) {
            break label566;
          }
          localObject3 = new awf();
          ((awf)localObject3).tsF = f2;
          ((awf)localObject3).tsG = f1;
          if (f2 >= i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding))
          {
            ((awf)localObject3).tsF = (i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding));
            ((awf)localObject3).tsG = ((int)(((awf)localObject3).tsF * ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi / ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh));
          }
          ((awf)localObject3).tsH = (((awf)localObject3).tsF * ((awf)localObject3).tsG);
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
    for (;;)
    {
      if (!bk.bl(((com.tencent.mm.plugin.sns.storage.b)localObject2).oBm))
      {
        localObject3 = paramc.pmZ;
        TagImageView localTagImageView = paramc.pmZ.yD(0);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBm, false, 41, new h.1(this, (PhotosContent)localObject3, (com.tencent.mm.plugin.sns.storage.b)localObject2, localTagImageView));
      }
      paramau = paramau.oWh;
      localObject2 = paramc.pmZ;
      paramax = paramax.oOM;
      i = this.mActivity.hashCode();
      bool = this.oVB;
      localObject3 = az.cuY();
      ((az)localObject3).time = parambxk.mPL;
      paramau.a((PhotosContent)localObject2, parambxk, paramax, i, paramInt2, paramInt1, bool, (az)localObject3, (List)localObject1);
      paramc.pmZ.yD(0).setScaleType(QImageView.a.wkS);
      return;
      localObject1 = parambxk.tNq.lsK;
      break;
      label532:
      bool = com.tencent.mm.plugin.sns.c.a.eUS.cu((String)localObject1);
      paramau.pen.put(localObject1, Boolean.valueOf(bool));
      bool = true;
      break label58;
      label566:
      int j;
      if (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBg == 1)
      {
        i = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding);
        j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi / ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh);
        localObject3 = new awf();
        if (i > 0) {
          f2 = i;
        }
        ((awf)localObject3).tsF = f2;
        if (j > 0) {
          f1 = j;
        }
        for (;;)
        {
          ((awf)localObject3).tsG = f1;
          ((awf)localObject3).tsH = (((awf)localObject3).tsF * ((awf)localObject3).tsG);
          ((LinkedList)localObject1).add(localObject3);
          break;
        }
      }
      if (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBg == 2)
      {
        i = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding);
        j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi / ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh);
        localObject3 = new awf();
        if (i > 0) {
          f2 = i;
        }
        ((awf)localObject3).tsF = f2;
        if (j > 0) {
          f1 = j;
        }
        ((awf)localObject3).tsG = f1;
        ((awf)localObject3).tsH = (((awf)localObject3).tsF * ((awf)localObject3).tsG);
        ((LinkedList)localObject1).add(localObject3);
      }
    }
  }
  
  public final void d(a.c paramc)
  {
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    y.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.ivk);
    this.oWr = af.bDN();
    if (paramc.pmI != null) {
      if (this.ivk == 2)
      {
        paramc.pmI.setLayoutResource(i.g.sns_timeline_imagesline_one);
        if (!paramc.pmJ) {
          paramc.pmZ = ((PhotosContent)paramc.pmI.inflate());
        }
      }
    }
    for (paramc.pmJ = true;; paramc.pmJ = true)
    {
      paramc.pmZ.oSb.clear();
      int i = 0;
      while (i < aq.paC[this.ivk])
      {
        localObject = (TagImageView)paramc.pmZ.findViewById(aq.paG[i]);
        paramc.pmZ.a((TagImageView)localObject);
        ((TagImageView)localObject).setOnClickListener(this.owd.ovx.oPK);
        this.owd.iep.c((View)localObject, this.owd.ovx.poN, this.owd.ovx.poz);
        i += 1;
      }
      if (this.ivk == 3)
      {
        paramc.pmI.setLayoutResource(i.g.sns_timeline_imagesline1);
        break;
      }
      if (this.ivk == 4)
      {
        paramc.pmI.setLayoutResource(i.g.sns_timeline_imagesline2);
        break;
      }
      if (this.ivk == 5)
      {
        paramc.pmI.setLayoutResource(i.g.sns_timeline_imagesline3);
        break;
      }
      y.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.ivk);
      break;
      paramc.pmZ = ((PhotosContent)paramc.kKz.findViewById(i.f.photo_content));
    }
    paramc.pmZ.setImageViewWidth(this.oWr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.h
 * JD-Core Version:    0.7.0.1
 */