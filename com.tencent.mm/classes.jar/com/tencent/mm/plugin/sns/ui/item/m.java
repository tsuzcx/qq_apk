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
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends BaseTimeLineItem
{
  private int EBq;
  private int EBr;
  private MaskImageView EYZ;
  private ImageView EZa;
  private List<ImageView> EZb;
  private ImageView EpU;
  
  public m()
  {
    AppMethodBeat.i(203933);
    this.EBr = 103;
    this.EZb = new ArrayList();
    AppMethodBeat.o(203933);
  }
  
  private void a(PhotosContent paramPhotosContent, int paramInt)
  {
    AppMethodBeat.i(203934);
    if ((paramPhotosContent == null) || (paramInt <= 1))
    {
      Log.e("MiroMsg.PhotoTimeLineItem", "photosContent == null or imgNums <= 1");
      AppMethodBeat.o(203934);
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
          if (this.EZb.size() < paramInt)
          {
            Log.i("MiroMsg.PhotoTimeLineItem", "current index = " + i + ", weAppIcons current size = " + this.EZb.size() + ", total imgNums = " + paramInt);
            localImageView = com.tencent.mm.plugin.sns.ad.timeline.b.c.a(this.mActivity, paramPhotosContent, i, j);
            if (localImageView != null)
            {
              localImageView.setVisibility(8);
              this.EZb.add(localImageView);
            }
          }
          if (paramPhotosContent.ZD(i).getVisibility() == 8) {
            break label222;
          }
          ImageView localImageView = (ImageView)this.EZb.get(i);
          if (localImageView != null)
          {
            paramPhotosContent.addView(localImageView);
            localImageView.setVisibility(0);
          }
          else
          {
            Log.e("MiroMsg.PhotoTimeLineItem", "weAppIcons get weAppIv is null");
          }
        }
      }
      catch (Throwable paramPhotosContent)
      {
        Log.e("MiroMsg.PhotoTimeLineItem", paramPhotosContent.toString());
        AppMethodBeat.o(203934);
        return;
      }
      AppMethodBeat.o(203934);
      return;
      label222:
      i += 1;
    }
  }
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(100093);
    if (paramBaseViewHolder.EWX == null)
    {
      AppMethodBeat.o(100093);
      return;
    }
    if ((parambl != null) && (paramTimeLineObject != null) && (parambl.Eoq)) {
      Log.i("MiroMsg.PhotoTimeLineItem", "ad fillItem, photoItem, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
    }
    paramBaseViewHolder.EWX.setVisibility(0);
    LinkedList localLinkedList = new LinkedList();
    int i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
    if (this.EpU != null) {
      this.EpU.setVisibility(8);
    }
    SnsInfo localSnsInfo = parambl.DqO;
    if (this.EZa != null) {
      this.EZa.setVisibility(8);
    }
    Object localObject1 = this.EZb.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ImageView)((Iterator)localObject1).next();
      ((ImageView)localObject2).setVisibility(8);
      paramBaseViewHolder.EWX.removeView((View)localObject2);
    }
    float f2;
    float f1;
    if ((parambl.Eoq) && (paramInt2 == 2))
    {
      localObject1 = localSnsInfo.getAdXml();
      if ((localObject1 != null) && (((ADXml)localObject1).adMediaDisplayWidth > 0.0F) && (((ADXml)localObject1).adMediaDisplayHeight > 0.0F))
      {
        f2 = i.a(((ADXml)localObject1).adMediaDisplayWidth, 1, ((ADXml)localObject1).adBasicRemWidth, ((ADXml)localObject1).adBasicRootFontSize);
        f1 = i.a(((ADXml)localObject1).adMediaDisplayHeight, 1, ((ADXml)localObject1).adBasicRemWidth, ((ADXml)localObject1).adBasicRootFontSize);
        if (((ADXml)localObject1).adMediaDisplayMode != 0) {
          break label1088;
        }
        localObject2 = new cnd();
        ((cnd)localObject2).Mto = f2;
        ((cnd)localObject2).Mtp = f1;
        if (f2 >= i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165534) - this.mActivity.getResources().getDimensionPixelSize(2131165534))
        {
          ((cnd)localObject2).Mto = (i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165534) - this.mActivity.getResources().getDimensionPixelSize(2131165534));
          ((cnd)localObject2).Mtp = ((int)(((cnd)localObject2).Mto * ((ADXml)localObject1).adMediaDisplayHeight / ((ADXml)localObject1).adMediaDisplayWidth));
        }
        ((cnd)localObject2).Mtq = (((cnd)localObject2).Mto * ((cnd)localObject2).Mtp);
        localLinkedList.add(localObject2);
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((ADXml)localObject1).isShowPlayIconOnCover()))
      {
        if (this.EpU == null) {
          this.EpU = ((ImageView)paramBaseViewHolder.EWX.findViewById(2131308398));
        }
        if (this.EpU != null) {
          this.EpU.setVisibility(0);
        }
      }
      if ((k.a(localSnsInfo, 0)) && (!k.t(localSnsInfo)))
      {
        localObject2 = paramBaseViewHolder.EWX;
        if (localObject2 == null) {}
      }
      try
      {
        if (this.EZa == null) {
          this.EZa = new ImageView(this.mActivity);
        }
        ((PhotosContent)localObject2).removeView(this.EZa);
        i = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 24);
        j = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 4);
        localObject3 = new FrameLayout.LayoutParams(i, i);
        ((FrameLayout.LayoutParams)localObject3).leftMargin = j;
        ((FrameLayout.LayoutParams)localObject3).topMargin = j;
        this.EZa.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131235696));
        this.EZa.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.EZa.setVisibility(0);
        ((PhotosContent)localObject2).addView(this.EZa);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          int j;
          Object localObject3;
          boolean bool1;
          boolean bool2;
          Log.e("MiroMsg.PhotoTimeLineItem", localThrowable.toString());
        }
      }
      if (!Util.isNullOrNil(((ADXml)localObject1).adMediaIconUrl))
      {
        localObject2 = paramBaseViewHolder.EWX;
        localObject3 = paramBaseViewHolder.EWX.ZD(0);
        h.a("adId", ((ADXml)localObject1).adMediaIconUrl, false, 41, new f.a()
        {
          public final void aNH(String paramAnonymousString)
          {
            AppMethodBeat.i(100091);
            m.a(m.this, (MaskImageView)this.ECl.findViewById(2131304558));
            if (m.a(m.this) != null)
            {
              m.a(m.this).setVisibility(0);
              paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
              m.a(m.this).setImageBitmap(paramAnonymousString);
              float f1 = i.a(this.ECm.adMediaIconWidth, 1, this.ECm.adBasicRemWidth, this.ECm.adBasicRootFontSize);
              float f2 = i.a(this.ECm.adMediaIconHeight, 1, this.ECm.adBasicRemWidth, this.ECm.adBasicRootFontSize);
              float f3 = i.a(this.ECm.adMediaIconPaddingRight, 1, this.ECm.adBasicRemWidth, this.ECm.adBasicRootFontSize);
              float f4 = i.a(this.ECm.adMediaIconPaddingBottom, 1, this.ECm.adBasicRemWidth, this.ECm.adBasicRootFontSize);
              paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
              paramAnonymousString.setMargins((int)(this.ECn.getRight() - f3 - f1), (int)(this.ECn.getBottom() - f4 - f2), 0, 0);
              m.a(m.this).setLayoutParams(paramAnonymousString);
            }
            AppMethodBeat.o(100091);
          }
          
          public final void eWN() {}
          
          public final void eWO() {}
        });
      }
      parambk = parambk.EBe;
      localObject1 = paramBaseViewHolder.EWX;
      localObject2 = parambl.Eql;
      i = this.mActivity.hashCode();
      bool1 = parambl.Eoq;
      bool2 = this.EAv;
      localObject3 = bp.gCU();
      ((bp)localObject3).hXs = paramTimeLineObject.CreateTime;
      parambk.a((PhotosContent)localObject1, paramTimeLineObject, (String)localObject2, i, paramInt2, paramInt1, bool1, bool2, (bp)localObject3, localLinkedList, parambl.Dsr, localSnsInfo);
      paramBaseViewHolder.EWX.ZD(0).setScaleType(QImageView.a.QEL);
      if ((parambl.Eoq) && (this.qcr == 2)) {}
      try
      {
        paramTimeLineObject = parambl.DqO.getAdXml();
        if ((paramTimeLineObject != null) && (paramTimeLineObject.isShowPlayIconOnCover()))
        {
          if (this.EpU == null) {
            this.EpU = ((ImageView)paramBaseViewHolder.EWX.findViewById(2131308398));
          }
          if (this.EpU != null)
          {
            this.EpU.setVisibility(0);
            paramTimeLineObject = (FrameLayout.LayoutParams)paramBaseViewHolder.EWX.ZD(0).getLayoutParams();
            parambk = (FrameLayout.LayoutParams)this.EpU.getLayoutParams();
            paramInt1 = paramTimeLineObject.width / 2 - parambk.width / 2 + paramTimeLineObject.leftMargin;
            i = paramTimeLineObject.height / 2;
            j = parambk.height / 2;
            i = paramTimeLineObject.topMargin + (i - j);
            if ((paramInt1 != parambk.leftMargin) || (i != parambk.topMargin))
            {
              parambk.leftMargin = paramInt1;
              parambk.topMargin = i;
              this.EpU.setLayoutParams(parambk);
            }
          }
        }
      }
      catch (Throwable paramTimeLineObject)
      {
        for (;;)
        {
          label1088:
          if (this.EpU != null) {
            this.EpU.setVisibility(8);
          }
          Log.e("MiroMsg.PhotoTimeLineItem", "checkShowStatusIcon exp=" + paramTimeLineObject.toString());
        }
      }
      if ((parambl.Eoq) && ((paramInt2 == 3) || (paramInt2 == 4) || (paramInt2 == 5)) && (k.a(localSnsInfo, 0)) && (!k.t(localSnsInfo)))
      {
        paramInt1 = be.EGv[paramInt2];
        a(paramBaseViewHolder.EWX, paramInt1);
      }
      AppMethodBeat.o(100093);
      return;
      if (((ADXml)localObject1).adMediaDisplayMode == 1)
      {
        i = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165534) - this.mActivity.getResources().getDimensionPixelSize(2131165534);
        j = (int)(i * ((ADXml)localObject1).adMediaDisplayHeight / ((ADXml)localObject1).adMediaDisplayWidth);
        localObject2 = new cnd();
        if (i > 0) {
          f2 = i;
        }
        ((cnd)localObject2).Mto = f2;
        if (j > 0) {
          f1 = j;
        }
        for (;;)
        {
          ((cnd)localObject2).Mtp = f1;
          ((cnd)localObject2).Mtq = (((cnd)localObject2).Mto * ((cnd)localObject2).Mtp);
          localLinkedList.add(localObject2);
          break;
        }
      }
      if (((ADXml)localObject1).adMediaDisplayMode == 2)
      {
        i = i - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165534) - this.mActivity.getResources().getDimensionPixelSize(2131165534);
        j = (int)(i * ((ADXml)localObject1).adMediaDisplayHeight / ((ADXml)localObject1).adMediaDisplayWidth);
        localObject2 = new cnd();
        if (i > 0) {
          f2 = i;
        }
        ((cnd)localObject2).Mto = f2;
        if (j > 0) {
          f1 = j;
        }
        ((cnd)localObject2).Mtp = f1;
        ((cnd)localObject2).Mtq = (((cnd)localObject2).Mto * ((cnd)localObject2).Mtp);
        localLinkedList.add(localObject2);
      }
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100092);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    Log.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.qcr);
    Point localPoint = new Point();
    localPoint.x = ((DisplayMetrics)localObject).widthPixels;
    localPoint.y = ((DisplayMetrics)localObject).heightPixels;
    aj.k(localPoint);
    this.EBq = aj.fbb();
    if ((paramBaseViewHolder.EWD != null) && (paramBaseViewHolder.EWD.getParent() != null) && ((paramBaseViewHolder.EWD.getParent() instanceof ViewGroup))) {
      if (this.qcr == 2)
      {
        paramBaseViewHolder.EWD.setLayoutResource(2131496510);
        if (!paramBaseViewHolder.EWE) {
          paramBaseViewHolder.EWX = ((PhotosContent)paramBaseViewHolder.EWD.inflate());
        }
      }
    }
    for (paramBaseViewHolder.EWE = true;; paramBaseViewHolder.EWE = true)
    {
      paramBaseViewHolder.EWX.EuD.clear();
      int i = 0;
      while (i < be.EGv[this.qcr])
      {
        localObject = (TagImageView)paramBaseViewHolder.EWX.findViewById(be.EGz[i]);
        paramBaseViewHolder.EWX.a((TagImageView)localObject);
        ((TagImageView)localObject).setOnClickListener(this.DQX.DQs.Erh);
        this.DQX.fiV().c((View)localObject, this.DQX.DQs.FaF, this.DQX.DQs.Far);
        i += 1;
      }
      if (this.qcr == 3)
      {
        paramBaseViewHolder.EWD.setLayoutResource(2131496507);
        break;
      }
      if (this.qcr == 4)
      {
        paramBaseViewHolder.EWD.setLayoutResource(2131496508);
        break;
      }
      if (this.qcr == 5)
      {
        paramBaseViewHolder.EWD.setLayoutResource(2131496509);
        break;
      }
      Log.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.qcr);
      break;
      paramBaseViewHolder.EWX = ((PhotosContent)paramBaseViewHolder.convertView.findViewById(2131305911));
    }
    paramBaseViewHolder.EWX.setImageViewWidth(this.EBq);
    AppMethodBeat.o(100092);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.m
 * JD-Core Version:    0.7.0.1
 */