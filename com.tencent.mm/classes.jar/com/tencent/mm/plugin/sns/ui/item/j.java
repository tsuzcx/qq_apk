package com.tencent.mm.plugin.sns.ui.item;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends BaseTimeLineItem
{
  private MaskImageView AOu;
  private ImageView AOv;
  private List<ImageView> AOw;
  private ImageView Ahu;
  private int Asl;
  private int Asm;
  
  public j()
  {
    AppMethodBeat.i(220092);
    this.Asm = 103;
    this.AOw = new ArrayList();
    AppMethodBeat.o(220092);
  }
  
  private void a(PhotosContent paramPhotosContent, int paramInt)
  {
    AppMethodBeat.i(220093);
    if ((paramPhotosContent == null) || (paramInt <= 1))
    {
      ae.e("MiroMsg.PhotoTimeLineItem", "photosContent == null or imgNums <= 1");
      AppMethodBeat.o(220093);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 20);
        i = 0;
        if (i < paramInt)
        {
          if (this.AOw.size() < paramInt)
          {
            ae.i("MiroMsg.PhotoTimeLineItem", "current index = " + i + ", weAppIcons current size = " + this.AOw.size() + ", total imgNums = " + paramInt);
            localImageView = com.tencent.mm.plugin.sns.ad.timeline.a.b.a(this.mActivity, paramPhotosContent, i, j);
            if (localImageView != null)
            {
              localImageView.setVisibility(8);
              this.AOw.add(localImageView);
            }
          }
          if (paramPhotosContent.RH(i).getVisibility() == 8) {
            break label222;
          }
          ImageView localImageView = (ImageView)this.AOw.get(i);
          if (localImageView != null)
          {
            paramPhotosContent.addView(localImageView);
            localImageView.setVisibility(0);
          }
          else
          {
            ae.e("MiroMsg.PhotoTimeLineItem", "weAppIcons get weAppIv is null");
          }
        }
      }
      catch (Throwable paramPhotosContent)
      {
        ae.e("MiroMsg.PhotoTimeLineItem", paramPhotosContent.toString());
        AppMethodBeat.o(220093);
        return;
      }
      AppMethodBeat.o(220093);
      return;
      label222:
      i += 1;
    }
  }
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(100093);
    if (paramBaseViewHolder.AMM == null)
    {
      AppMethodBeat.o(100093);
      return;
    }
    if ((parambi != null) && (paramTimeLineObject != null) && (parambi.AfT)) {
      ae.i("MiroMsg.PhotoTimeLineItem", "ad fillItem, photoItem, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
    }
    paramBaseViewHolder.AMM.setVisibility(0);
    LinkedList localLinkedList = new LinkedList();
    int i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
    if (this.Ahu != null) {
      this.Ahu.setVisibility(8);
    }
    p localp = parambi.zlW;
    if (this.AOv != null) {
      this.AOv.setVisibility(8);
    }
    Object localObject1 = this.AOw.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ImageView)((Iterator)localObject1).next();
      ((ImageView)localObject2).setVisibility(8);
      paramBaseViewHolder.AMM.removeView((View)localObject2);
    }
    float f2;
    float f1;
    if ((parambi.AfT) && (paramInt2 == 2))
    {
      localObject1 = localp.dVj();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).zNt > 0.0F) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).zNu > 0.0F))
      {
        f2 = i.a(((com.tencent.mm.plugin.sns.storage.b)localObject1).zNt, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject1).zNv, ((com.tencent.mm.plugin.sns.storage.b)localObject1).zNw);
        f1 = i.a(((com.tencent.mm.plugin.sns.storage.b)localObject1).zNu, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject1).zNv, ((com.tencent.mm.plugin.sns.storage.b)localObject1).zNw);
        if (((com.tencent.mm.plugin.sns.storage.b)localObject1).zNs != 0) {
          break label1088;
        }
        localObject2 = new bzj();
        ((bzj)localObject2).Hna = f2;
        ((bzj)localObject2).Hnb = f1;
        if (f2 >= i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516))
        {
          ((bzj)localObject2).Hna = (i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516));
          ((bzj)localObject2).Hnb = ((int)(((bzj)localObject2).Hna * ((com.tencent.mm.plugin.sns.storage.b)localObject1).zNu / ((com.tencent.mm.plugin.sns.storage.b)localObject1).zNt));
        }
        ((bzj)localObject2).Hnc = (((bzj)localObject2).Hna * ((bzj)localObject2).Hnb);
        localLinkedList.add(localObject2);
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).dZM()))
      {
        if (this.Ahu == null) {
          this.Ahu = ((ImageView)paramBaseViewHolder.AMM.findViewById(2131305201));
        }
        if (this.Ahu != null) {
          this.Ahu.setVisibility(0);
        }
      }
      if ((k.a(localp, 0)) && (!k.m(localp)))
      {
        localObject2 = paramBaseViewHolder.AMM;
        if (localObject2 == null) {}
      }
      try
      {
        if (this.AOv == null) {
          this.AOv = new ImageView(this.mActivity);
        }
        ((PhotosContent)localObject2).removeView(this.AOv);
        i = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 24);
        j = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 4);
        localObject3 = new FrameLayout.LayoutParams(i, i);
        ((FrameLayout.LayoutParams)localObject3).leftMargin = j;
        ((FrameLayout.LayoutParams)localObject3).topMargin = j;
        this.AOv.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131235087));
        this.AOv.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.AOv.setVisibility(0);
        ((PhotosContent)localObject2).addView(this.AOv);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          int j;
          Object localObject3;
          boolean bool1;
          boolean bool2;
          ae.e("MiroMsg.PhotoTimeLineItem", localThrowable.toString());
        }
      }
      if (!bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject1).zNy))
      {
        localObject2 = paramBaseViewHolder.AMM;
        localObject3 = paramBaseViewHolder.AMM.RH(0);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject1).zNy, false, 41, new f.a()
        {
          public final void ayY(String paramAnonymousString)
          {
            AppMethodBeat.i(100091);
            j.a(j.this, (MaskImageView)this.Atg.findViewById(2131302209));
            if (j.a(j.this) != null)
            {
              j.a(j.this).setVisibility(0);
              paramAnonymousString = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString);
              j.a(j.this).setImageBitmap(paramAnonymousString);
              float f1 = i.a(this.Ath.zNz, 1, this.Ath.zNv, this.Ath.zNw);
              float f2 = i.a(this.Ath.zNA, 1, this.Ath.zNv, this.Ath.zNw);
              float f3 = i.a(this.Ath.zNB, 1, this.Ath.zNv, this.Ath.zNw);
              float f4 = i.a(this.Ath.zNC, 1, this.Ath.zNv, this.Ath.zNw);
              paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
              paramAnonymousString.setMargins((int)(this.Ati.getRight() - f3 - f1), (int)(this.Ati.getBottom() - f4 - f2), 0, 0);
              j.a(j.this).setLayoutParams(paramAnonymousString);
            }
            AppMethodBeat.o(100091);
          }
          
          public final void dVu() {}
          
          public final void dVv() {}
        });
      }
      parambh = parambh.Asa;
      localObject1 = paramBaseViewHolder.AMM;
      localObject2 = parambi.AhK;
      i = this.mActivity.hashCode();
      bool1 = parambi.AfT;
      bool2 = this.Arr;
      localObject3 = bk.fvn();
      ((bk)localObject3).heF = paramTimeLineObject.CreateTime;
      parambh.a((PhotosContent)localObject1, paramTimeLineObject, (String)localObject2, i, paramInt2, paramInt1, bool1, bool2, (bk)localObject3, localLinkedList, parambi.ADO, localp);
      paramBaseViewHolder.AMM.RH(0).setScaleType(QImageView.a.Lpz);
      if ((parambi.AfT) && (this.oOD == 2)) {}
      try
      {
        paramTimeLineObject = parambi.zlW.dVj();
        if ((paramTimeLineObject != null) && (paramTimeLineObject.dZM()))
        {
          if (this.Ahu == null) {
            this.Ahu = ((ImageView)paramBaseViewHolder.AMM.findViewById(2131305201));
          }
          if (this.Ahu != null)
          {
            this.Ahu.setVisibility(0);
            paramTimeLineObject = (FrameLayout.LayoutParams)paramBaseViewHolder.AMM.RH(0).getLayoutParams();
            parambh = (FrameLayout.LayoutParams)this.Ahu.getLayoutParams();
            paramInt1 = paramTimeLineObject.width / 2 - parambh.width / 2 + paramTimeLineObject.leftMargin;
            i = paramTimeLineObject.height / 2;
            j = parambh.height / 2;
            i = paramTimeLineObject.topMargin + (i - j);
            if ((paramInt1 != parambh.leftMargin) || (i != parambh.topMargin))
            {
              parambh.leftMargin = paramInt1;
              parambh.topMargin = i;
              this.Ahu.setLayoutParams(parambh);
            }
          }
        }
      }
      catch (Throwable paramTimeLineObject)
      {
        for (;;)
        {
          label1088:
          if (this.Ahu != null) {
            this.Ahu.setVisibility(8);
          }
          ae.e("MiroMsg.PhotoTimeLineItem", "checkShowStatusIcon exp=" + paramTimeLineObject.toString());
        }
      }
      if ((parambi.AfT) && ((paramInt2 == 3) || (paramInt2 == 4) || (paramInt2 == 5)) && (k.a(localp, 0)) && (!k.m(localp)))
      {
        paramInt1 = bb.Axf[paramInt2];
        a(paramBaseViewHolder.AMM, paramInt1);
      }
      AppMethodBeat.o(100093);
      return;
      if (((com.tencent.mm.plugin.sns.storage.b)localObject1).zNs == 1)
      {
        i = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
        j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject1).zNu / ((com.tencent.mm.plugin.sns.storage.b)localObject1).zNt);
        localObject2 = new bzj();
        if (i > 0) {
          f2 = i;
        }
        ((bzj)localObject2).Hna = f2;
        if (j > 0) {
          f1 = j;
        }
        for (;;)
        {
          ((bzj)localObject2).Hnb = f1;
          ((bzj)localObject2).Hnc = (((bzj)localObject2).Hna * ((bzj)localObject2).Hnb);
          localLinkedList.add(localObject2);
          break;
        }
      }
      if (((com.tencent.mm.plugin.sns.storage.b)localObject1).zNs == 2)
      {
        i = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
        j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject1).zNu / ((com.tencent.mm.plugin.sns.storage.b)localObject1).zNt);
        localObject2 = new bzj();
        if (i > 0) {
          f2 = i;
        }
        ((bzj)localObject2).Hna = f2;
        if (j > 0) {
          f1 = j;
        }
        ((bzj)localObject2).Hnb = f1;
        ((bzj)localObject2).Hnc = (((bzj)localObject2).Hna * ((bzj)localObject2).Hnb);
        localLinkedList.add(localObject2);
      }
    }
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100092);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    ae.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.oOD);
    Point localPoint = new Point();
    localPoint.x = ((DisplayMetrics)localObject).widthPixels;
    localPoint.y = ((DisplayMetrics)localObject).heightPixels;
    ah.j(localPoint);
    this.Asl = ah.dXP();
    if ((paramBaseViewHolder.AMs != null) && (paramBaseViewHolder.AMs.getParent() != null) && ((paramBaseViewHolder.AMs.getParent() instanceof ViewGroup))) {
      if (this.oOD == 2)
      {
        paramBaseViewHolder.AMs.setLayoutResource(2131495611);
        if (!paramBaseViewHolder.AMt) {
          paramBaseViewHolder.AMM = ((PhotosContent)paramBaseViewHolder.AMs.inflate());
        }
      }
    }
    for (paramBaseViewHolder.AMt = true;; paramBaseViewHolder.AMt = true)
    {
      paramBaseViewHolder.AMM.AlR.clear();
      int i = 0;
      while (i < bb.Axf[this.oOD])
      {
        localObject = (TagImageView)paramBaseViewHolder.AMM.findViewById(bb.Axj[i]);
        paramBaseViewHolder.AMM.a((TagImageView)localObject);
        ((TagImageView)localObject).setOnClickListener(this.zGX.zGs.AiC);
        this.zGX.egu().c((View)localObject, this.zGX.zGs.AQa, this.zGX.zGs.APL);
        i += 1;
      }
      if (this.oOD == 3)
      {
        paramBaseViewHolder.AMs.setLayoutResource(2131495608);
        break;
      }
      if (this.oOD == 4)
      {
        paramBaseViewHolder.AMs.setLayoutResource(2131495609);
        break;
      }
      if (this.oOD == 5)
      {
        paramBaseViewHolder.AMs.setLayoutResource(2131495610);
        break;
      }
      ae.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.oOD);
      break;
      paramBaseViewHolder.AMM = ((PhotosContent)paramBaseViewHolder.uan.findViewById(2131303243));
    }
    paramBaseViewHolder.AMM.setImageViewWidth(this.Asl);
    AppMethodBeat.o(100092);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.j
 * JD-Core Version:    0.7.0.1
 */