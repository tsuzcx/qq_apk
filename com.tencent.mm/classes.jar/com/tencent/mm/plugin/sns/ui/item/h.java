package com.tencent.mm.plugin.sns.ui.item;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.LinkedList;

public final class h
  extends BaseTimeLineItem
{
  private MaskImageView xSk;
  private int xwO;
  private int xwP = 103;
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe)
  {
    AppMethodBeat.i(100093);
    if (paramBaseViewHolder.xQQ == null)
    {
      AppMethodBeat.o(100093);
      return;
    }
    paramBaseViewHolder.xQQ.setVisibility(0);
    LinkedList localLinkedList = new LinkedList();
    int i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
    Object localObject1;
    float f2;
    float f1;
    Object localObject2;
    if ((parambf.xkI) && (paramInt2 == 2))
    {
      localObject1 = parambf.wvM.dxs();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).wTm > 0.0F) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).wTn > 0.0F))
      {
        f2 = i.a(((com.tencent.mm.plugin.sns.storage.b)localObject1).wTm, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject1).wTo, ((com.tencent.mm.plugin.sns.storage.b)localObject1).wTp);
        f1 = i.a(((com.tencent.mm.plugin.sns.storage.b)localObject1).wTn, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject1).wTo, ((com.tencent.mm.plugin.sns.storage.b)localObject1).wTp);
        if (((com.tencent.mm.plugin.sns.storage.b)localObject1).wTl != 0) {
          break label473;
        }
        localObject2 = new bpk();
        ((bpk)localObject2).DNH = f2;
        ((bpk)localObject2).DNI = f1;
        if (f2 >= i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516))
        {
          ((bpk)localObject2).DNH = (i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516));
          ((bpk)localObject2).DNI = ((int)(((bpk)localObject2).DNH * ((com.tencent.mm.plugin.sns.storage.b)localObject1).wTn / ((com.tencent.mm.plugin.sns.storage.b)localObject1).wTm));
        }
        ((bpk)localObject2).DNJ = (((bpk)localObject2).DNH * ((bpk)localObject2).DNI);
        localLinkedList.add(localObject2);
      }
    }
    for (;;)
    {
      if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject1).wTr))
      {
        localObject2 = paramBaseViewHolder.xQQ;
        localObject3 = paramBaseViewHolder.xQQ.No(0);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject1).wTr, false, 41, new f.a()
        {
          public final void apm(String paramAnonymousString)
          {
            AppMethodBeat.i(100091);
            h.a(h.this, (MaskImageView)this.xxI.findViewById(2131302209));
            if (h.a(h.this) != null)
            {
              h.a(h.this).setVisibility(0);
              paramAnonymousString = f.decodeFile(paramAnonymousString);
              h.a(h.this).setImageBitmap(paramAnonymousString);
              float f1 = i.a(this.xxJ.wTs, 1, this.xxJ.wTo, this.xxJ.wTp);
              float f2 = i.a(this.xxJ.wTt, 1, this.xxJ.wTo, this.xxJ.wTp);
              float f3 = i.a(this.xxJ.wTu, 1, this.xxJ.wTo, this.xxJ.wTp);
              float f4 = i.a(this.xxJ.wTv, 1, this.xxJ.wTo, this.xxJ.wTp);
              paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
              paramAnonymousString.setMargins((int)(this.xxK.getRight() - f3 - f1), (int)(this.xxK.getBottom() - f4 - f2), 0, 0);
              h.a(h.this).setLayoutParams(paramAnonymousString);
            }
            AppMethodBeat.o(100091);
          }
          
          public final void dsA() {}
          
          public final void duP() {}
        });
      }
      parambe = parambe.xwD;
      localObject1 = paramBaseViewHolder.xQQ;
      localObject2 = parambf.xmu;
      i = this.mActivity.hashCode();
      boolean bool1 = parambf.xkI;
      boolean bool2 = this.xvU;
      Object localObject3 = bc.eLG();
      ((bc)localObject3).tGD = paramTimeLineObject.CreateTime;
      parambe.a((PhotosContent)localObject1, paramTimeLineObject, (String)localObject2, i, paramInt2, paramInt1, bool1, bool2, (bc)localObject3, localLinkedList, parambf.xIb);
      paramBaseViewHolder.xQQ.No(0).setScaleType(QImageView.a.HBy);
      AppMethodBeat.o(100093);
      return;
      label473:
      int j;
      if (((com.tencent.mm.plugin.sns.storage.b)localObject1).wTl == 1)
      {
        i = i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
        j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject1).wTn / ((com.tencent.mm.plugin.sns.storage.b)localObject1).wTm);
        localObject2 = new bpk();
        if (i > 0) {
          f2 = i;
        }
        ((bpk)localObject2).DNH = f2;
        if (j > 0) {
          f1 = j;
        }
        for (;;)
        {
          ((bpk)localObject2).DNI = f1;
          ((bpk)localObject2).DNJ = (((bpk)localObject2).DNH * ((bpk)localObject2).DNI);
          localLinkedList.add(localObject2);
          break;
        }
      }
      if (((com.tencent.mm.plugin.sns.storage.b)localObject1).wTl == 2)
      {
        i = i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
        j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject1).wTn / ((com.tencent.mm.plugin.sns.storage.b)localObject1).wTm);
        localObject2 = new bpk();
        if (i > 0) {
          f2 = i;
        }
        ((bpk)localObject2).DNH = f2;
        if (j > 0) {
          f1 = j;
        }
        ((bpk)localObject2).DNI = f1;
        ((bpk)localObject2).DNJ = (((bpk)localObject2).DNH * ((bpk)localObject2).DNI);
        localLinkedList.add(localObject2);
      }
    }
  }
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100092);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    ad.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.nBH);
    Point localPoint = new Point();
    localPoint.x = ((DisplayMetrics)localObject).widthPixels;
    localPoint.y = ((DisplayMetrics)localObject).heightPixels;
    af.f(localPoint);
    this.xwO = af.dtE();
    if ((paramBaseViewHolder.xQw != null) && (paramBaseViewHolder.xQw.getParent() != null) && ((paramBaseViewHolder.xQw.getParent() instanceof ViewGroup))) {
      if (this.nBH == 2)
      {
        paramBaseViewHolder.xQw.setLayoutResource(2131495611);
        if (!paramBaseViewHolder.xQx) {
          paramBaseViewHolder.xQQ = ((PhotosContent)paramBaseViewHolder.xQw.inflate());
        }
      }
    }
    for (paramBaseViewHolder.xQx = true;; paramBaseViewHolder.xQx = true)
    {
      paramBaseViewHolder.xQQ.xqy.clear();
      int i = 0;
      while (i < ay.xBJ[this.nBH])
      {
        localObject = (TagImageView)paramBaseViewHolder.xQQ.findViewById(ay.xBN[i]);
        paramBaseViewHolder.xQQ.a((TagImageView)localObject);
        ((TagImageView)localObject).setOnClickListener(this.wNd.wMy.xno);
        this.wNd.dCa().c((View)localObject, this.wNd.wMy.xTH, this.wNd.wMy.xTt);
        i += 1;
      }
      if (this.nBH == 3)
      {
        paramBaseViewHolder.xQw.setLayoutResource(2131495608);
        break;
      }
      if (this.nBH == 4)
      {
        paramBaseViewHolder.xQw.setLayoutResource(2131495609);
        break;
      }
      if (this.nBH == 5)
      {
        paramBaseViewHolder.xQw.setLayoutResource(2131495610);
        break;
      }
      ad.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.nBH);
      break;
      paramBaseViewHolder.xQQ = ((PhotosContent)paramBaseViewHolder.rLd.findViewById(2131303243));
    }
    paramBaseViewHolder.xQQ.setImageViewWidth(this.xwO);
    AppMethodBeat.o(100092);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.h
 * JD-Core Version:    0.7.0.1
 */