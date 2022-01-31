package com.tencent.mm.plugin.sns.ui.item;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.LinkedList;

public final class g
  extends BaseTimeLineItem
{
  private int rOP;
  private int rOQ = 103;
  private MaskImageView sil;
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, aw paramaw, TimeLineObject paramTimeLineObject, int paramInt2, av paramav)
  {
    AppMethodBeat.i(40155);
    if (paramBaseViewHolder.shk == null)
    {
      AppMethodBeat.o(40155);
      return;
    }
    paramBaseViewHolder.shk.setVisibility(0);
    LinkedList localLinkedList = new LinkedList();
    int i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
    Object localObject1;
    float f2;
    float f1;
    Object localObject2;
    if ((paramaw.rEX) && (paramInt2 == 2))
    {
      localObject1 = paramaw.qXp.csb();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).rqr > 0.0F) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).rqs > 0.0F))
      {
        f2 = i.a(((com.tencent.mm.plugin.sns.storage.b)localObject1).rqr, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqt, ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqu);
        f1 = i.a(((com.tencent.mm.plugin.sns.storage.b)localObject1).rqs, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqt, ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqu);
        if (((com.tencent.mm.plugin.sns.storage.b)localObject1).rqq != 0) {
          break label473;
        }
        localObject2 = new bcu();
        ((bcu)localObject2).xsH = f2;
        ((bcu)localObject2).xsI = f1;
        if (f2 >= i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131427808) - this.mActivity.getResources().getDimensionPixelSize(2131427808))
        {
          ((bcu)localObject2).xsH = (i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131427808) - this.mActivity.getResources().getDimensionPixelSize(2131427808));
          ((bcu)localObject2).xsI = ((int)(((bcu)localObject2).xsH * ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqs / ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqr));
        }
        ((bcu)localObject2).xsJ = (((bcu)localObject2).xsH * ((bcu)localObject2).xsI);
        localLinkedList.add(localObject2);
      }
    }
    for (;;)
    {
      if (!bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject1).rqw))
      {
        localObject2 = paramBaseViewHolder.shk;
        localObject3 = paramBaseViewHolder.shk.EJ(0);
        h.c("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqw, false, 41, new g.1(this, (PhotosContent)localObject2, (com.tencent.mm.plugin.sns.storage.b)localObject1, (TagImageView)localObject3));
      }
      paramav = paramav.rOF;
      localObject1 = paramBaseViewHolder.shk;
      localObject2 = paramaw.rGx;
      i = this.mActivity.hashCode();
      boolean bool1 = paramaw.rEX;
      boolean bool2 = this.rNW;
      Object localObject3 = az.dxB();
      ((az)localObject3).oLs = paramTimeLineObject.CreateTime;
      paramav.a((PhotosContent)localObject1, paramTimeLineObject, (String)localObject2, i, paramInt2, paramInt1, bool1, bool2, (az)localObject3, localLinkedList, paramaw.rZv);
      paramBaseViewHolder.shk.EJ(0).setScaleType(QImageView.a.AED);
      AppMethodBeat.o(40155);
      return;
      label473:
      int j;
      if (((com.tencent.mm.plugin.sns.storage.b)localObject1).rqq == 1)
      {
        i = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131427808) - this.mActivity.getResources().getDimensionPixelSize(2131427808);
        j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqs / ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqr);
        localObject2 = new bcu();
        if (i > 0) {
          f2 = i;
        }
        ((bcu)localObject2).xsH = f2;
        if (j > 0) {
          f1 = j;
        }
        for (;;)
        {
          ((bcu)localObject2).xsI = f1;
          ((bcu)localObject2).xsJ = (((bcu)localObject2).xsH * ((bcu)localObject2).xsI);
          localLinkedList.add(localObject2);
          break;
        }
      }
      if (((com.tencent.mm.plugin.sns.storage.b)localObject1).rqq == 2)
      {
        i = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131427808) - this.mActivity.getResources().getDimensionPixelSize(2131427808);
        j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqs / ((com.tencent.mm.plugin.sns.storage.b)localObject1).rqr);
        localObject2 = new bcu();
        if (i > 0) {
          f2 = i;
        }
        ((bcu)localObject2).xsH = f2;
        if (j > 0) {
          f1 = j;
        }
        ((bcu)localObject2).xsI = f1;
        ((bcu)localObject2).xsJ = (((bcu)localObject2).xsH * ((bcu)localObject2).xsI);
        localLinkedList.add(localObject2);
      }
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40154);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    ab.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.kwo);
    this.rOP = ag.cpn();
    if ((paramBaseViewHolder.sgT != null) && (paramBaseViewHolder.sgT.getParent() != null) && ((paramBaseViewHolder.sgT.getParent() instanceof ViewGroup))) {
      if (this.kwo == 2)
      {
        paramBaseViewHolder.sgT.setLayoutResource(2130970885);
        if (!paramBaseViewHolder.sgU) {
          paramBaseViewHolder.shk = ((PhotosContent)paramBaseViewHolder.sgT.inflate());
        }
      }
    }
    for (paramBaseViewHolder.sgU = true;; paramBaseViewHolder.sgU = true)
    {
      paramBaseViewHolder.shk.rJU.clear();
      int i = 0;
      while (i < aq.rTg[this.kwo])
      {
        localObject = (TagImageView)paramBaseViewHolder.shk.findViewById(aq.rTk[i]);
        paramBaseViewHolder.shk.a((TagImageView)localObject);
        ((TagImageView)localObject).setOnClickListener(this.rkX.rks.rHw);
        this.rkX.jVd.c((View)localObject, this.rkX.rks.sjF, this.rkX.rks.sjr);
        i += 1;
      }
      if (this.kwo == 3)
      {
        paramBaseViewHolder.sgT.setLayoutResource(2130970882);
        break;
      }
      if (this.kwo == 4)
      {
        paramBaseViewHolder.sgT.setLayoutResource(2130970883);
        break;
      }
      if (this.kwo == 5)
      {
        paramBaseViewHolder.sgT.setLayoutResource(2130970884);
        break;
      }
      ab.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.kwo);
      break;
      paramBaseViewHolder.shk = ((PhotosContent)paramBaseViewHolder.ngZ.findViewById(2131828130));
    }
    paramBaseViewHolder.shk.setImageViewWidth(this.rOP);
    AppMethodBeat.o(40154);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.g
 * JD-Core Version:    0.7.0.1
 */