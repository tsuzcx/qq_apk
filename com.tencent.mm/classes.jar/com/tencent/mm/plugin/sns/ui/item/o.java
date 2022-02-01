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
import com.tencent.mm.plugin.sns.ad.timeline.b.d;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bg;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
  extends BaseTimeLineItem
{
  private ImageView KDh;
  private int KPi;
  private int KPj;
  private MaskImageView Lnt;
  private ImageView Lnu;
  private List<ImageView> Lnv;
  
  public o()
  {
    AppMethodBeat.i(212214);
    this.KPj = 103;
    this.Lnv = new ArrayList();
    AppMethodBeat.o(212214);
  }
  
  private void a(PhotosContent paramPhotosContent, int paramInt)
  {
    AppMethodBeat.i(212225);
    if ((paramPhotosContent == null) || (paramInt <= 1))
    {
      Log.e("MiroMsg.PhotoTimeLineItem", "photosContent == null or imgNums <= 1");
      AppMethodBeat.o(212225);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 20);
        i = 0;
        if (i < paramInt)
        {
          if (this.Lnv.size() < paramInt)
          {
            Log.i("MiroMsg.PhotoTimeLineItem", "current index = " + i + ", weAppIcons current size = " + this.Lnv.size() + ", total imgNums = " + paramInt);
            localImageView = d.a(this.mActivity, paramPhotosContent, i, j);
            if (localImageView != null)
            {
              localImageView.setVisibility(8);
              this.Lnv.add(localImageView);
            }
          }
          if (paramPhotosContent.agW(i).getVisibility() == 8) {
            break label222;
          }
          ImageView localImageView = (ImageView)this.Lnv.get(i);
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
        AppMethodBeat.o(212225);
        return;
      }
      AppMethodBeat.o(212225);
      return;
      label222:
      i += 1;
    }
  }
  
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(212216);
    paramViewStub = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(paramViewStub);
    Log.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.viewType);
    Point localPoint = new Point();
    localPoint.x = paramViewStub.widthPixels;
    localPoint.y = paramViewStub.heightPixels;
    aj.k(localPoint);
    this.KPi = aj.fOV();
    if ((paramBaseViewHolder.LkR != null) && (paramBaseViewHolder.LkR.getParent() != null) && ((paramBaseViewHolder.LkR.getParent() instanceof ViewGroup))) {
      if (this.viewType == 2)
      {
        paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_timeline_imagesline_one);
        if (!paramBaseViewHolder.LkS) {
          paramBaseViewHolder.Lll = ((PhotosContent)paramBaseViewHolder.LkR.inflate());
        }
      }
    }
    for (paramBaseViewHolder.LkS = true;; paramBaseViewHolder.LkS = true)
    {
      paramBaseViewHolder.Lll.KIu.clear();
      int i = 0;
      while (i < bg.KUp[this.viewType])
      {
        paramViewStub = (TagImageView)paramBaseViewHolder.Lll.findViewById(bg.KUt[i]);
        paramBaseViewHolder.Lll.a(paramViewStub);
        paramViewStub.setOnClickListener(this.Kee.Kdz.KEA);
        this.Kee.fXi().c(paramViewStub, this.Kee.Kdz.Lpd, this.Kee.Kdz.LoP);
        i += 1;
      }
      if (this.viewType == 3)
      {
        paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_timeline_imagesline1);
        break;
      }
      if (this.viewType == 4)
      {
        paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_timeline_imagesline2);
        break;
      }
      if (this.viewType == 5)
      {
        paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_timeline_imagesline3);
        break;
      }
      Log.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.viewType);
      break;
      paramBaseViewHolder.Lll = ((PhotosContent)paramBaseViewHolder.convertView.findViewById(i.f.photo_content));
    }
    paramBaseViewHolder.Lll.setImageViewWidth(this.KPi);
    AppMethodBeat.o(212216);
  }
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(100093);
    if (paramBaseViewHolder.Lll == null)
    {
      AppMethodBeat.o(100093);
      return;
    }
    if ((parambn != null) && (paramTimeLineObject != null) && (parambn.KBz)) {
      Log.i("MiroMsg.PhotoTimeLineItem", "ad fillItem, photoItem, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
    }
    paramBaseViewHolder.Lll.setVisibility(0);
    LinkedList localLinkedList = new LinkedList();
    int i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
    if (this.KDh != null) {
      this.KDh.setVisibility(8);
    }
    SnsInfo localSnsInfo = parambn.Jws;
    if (this.Lnu != null) {
      this.Lnu.setVisibility(8);
    }
    Object localObject1 = this.Lnv.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ImageView)((Iterator)localObject1).next();
      ((ImageView)localObject2).setVisibility(8);
      paramBaseViewHolder.Lll.removeView((View)localObject2);
    }
    float f2;
    float f1;
    if ((parambn.KBz) && (paramInt2 == 2))
    {
      localObject1 = localSnsInfo.getAdXml();
      if ((localObject1 != null) && (((ADXml)localObject1).adMediaDisplayWidth > 0.0F) && (((ADXml)localObject1).adMediaDisplayHeight > 0.0F))
      {
        f2 = i.a(((ADXml)localObject1).adMediaDisplayWidth, 1, ((ADXml)localObject1).adBasicRemWidth, ((ADXml)localObject1).adBasicRootFontSize);
        f1 = i.a(((ADXml)localObject1).adMediaDisplayHeight, 1, ((ADXml)localObject1).adBasicRemWidth, ((ADXml)localObject1).adBasicRootFontSize);
        if (((ADXml)localObject1).adMediaDisplayMode != 0) {
          break label1092;
        }
        localObject2 = new cvv();
        ((cvv)localObject2).TEu = f2;
        ((cvv)localObject2).TEv = f1;
        if (f2 >= i - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding))
        {
          ((cvv)localObject2).TEu = (i - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding));
          ((cvv)localObject2).TEv = ((int)(((cvv)localObject2).TEu * ((ADXml)localObject1).adMediaDisplayHeight / ((ADXml)localObject1).adMediaDisplayWidth));
        }
        ((cvv)localObject2).TEw = (((cvv)localObject2).TEu * ((cvv)localObject2).TEv);
        localLinkedList.add(localObject2);
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((ADXml)localObject1).isShowPlayIconOnCover()))
      {
        if (this.KDh == null) {
          this.KDh = ((ImageView)paramBaseViewHolder.Lll.findViewById(i.f.status_icon));
        }
        if (this.KDh != null) {
          this.KDh.setVisibility(0);
        }
      }
      if ((m.b(localSnsInfo, 0)) && (!m.t(localSnsInfo)))
      {
        localObject2 = paramBaseViewHolder.Lll;
        if (localObject2 == null) {}
      }
      try
      {
        if (this.Lnu == null) {
          this.Lnu = new ImageView(this.mActivity);
        }
        ((PhotosContent)localObject2).removeView(this.Lnu);
        i = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 24);
        j = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 4);
        localObject3 = new FrameLayout.LayoutParams(i, i);
        ((FrameLayout.LayoutParams)localObject3).leftMargin = j;
        ((FrameLayout.LayoutParams)localObject3).topMargin = j;
        this.Lnu.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.e.we_app_icon));
        this.Lnu.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.Lnu.setVisibility(0);
        ((PhotosContent)localObject2).addView(this.Lnu);
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
        localObject2 = paramBaseViewHolder.Lll;
        localObject3 = paramBaseViewHolder.Lll.agW(0);
        h.a("adId", ((ADXml)localObject1).adMediaIconUrl, new f.a()
        {
          public final void aYs(String paramAnonymousString)
          {
            AppMethodBeat.i(100091);
            o.a(o.this, (MaskImageView)this.KQc.findViewById(i.f.media_icon));
            if (o.a(o.this) != null)
            {
              o.a(o.this).setVisibility(0);
              paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
              o.a(o.this).setImageBitmap(paramAnonymousString);
              float f1 = i.a(this.KQd.adMediaIconWidth, 1, this.KQd.adBasicRemWidth, this.KQd.adBasicRootFontSize);
              float f2 = i.a(this.KQd.adMediaIconHeight, 1, this.KQd.adBasicRemWidth, this.KQd.adBasicRootFontSize);
              float f3 = i.a(this.KQd.adMediaIconPaddingRight, 1, this.KQd.adBasicRemWidth, this.KQd.adBasicRootFontSize);
              float f4 = i.a(this.KQd.adMediaIconPaddingBottom, 1, this.KQd.adBasicRemWidth, this.KQd.adBasicRootFontSize);
              paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
              paramAnonymousString.setMargins((int)(this.KQe.getRight() - f3 - f1), (int)(this.KQe.getBottom() - f4 - f2), 0, 0);
              o.a(o.this).setLayoutParams(paramAnonymousString);
            }
            AppMethodBeat.o(100091);
          }
          
          public final void fJU() {}
          
          public final void fJV() {}
        });
      }
      parambm = parambm.KOW;
      localObject1 = paramBaseViewHolder.Lll;
      localObject2 = parambn.KDB;
      i = this.mActivity.hashCode();
      bool1 = parambn.KBz;
      bool2 = this.KOn;
      localObject3 = bp.hzh();
      ((bp)localObject3).time = paramTimeLineObject.CreateTime;
      parambm.a((PhotosContent)localObject1, paramTimeLineObject, (String)localObject2, i, paramInt2, paramInt1, bool1, bool2, (bp)localObject3, localLinkedList, parambn.JyZ, localSnsInfo);
      paramBaseViewHolder.Lll.agW(0).setScaleType(QImageView.a.Ydm);
      if ((parambn.KBz) && (this.viewType == 2)) {}
      try
      {
        paramTimeLineObject = parambn.Jws.getAdXml();
        if ((paramTimeLineObject != null) && (paramTimeLineObject.isShowPlayIconOnCover()))
        {
          if (this.KDh == null) {
            this.KDh = ((ImageView)paramBaseViewHolder.Lll.findViewById(i.f.status_icon));
          }
          if (this.KDh != null)
          {
            this.KDh.setVisibility(0);
            paramTimeLineObject = (FrameLayout.LayoutParams)paramBaseViewHolder.Lll.agW(0).getLayoutParams();
            parambm = (FrameLayout.LayoutParams)this.KDh.getLayoutParams();
            paramInt1 = paramTimeLineObject.width / 2 - parambm.width / 2 + paramTimeLineObject.leftMargin;
            i = paramTimeLineObject.height / 2;
            j = parambm.height / 2;
            i = paramTimeLineObject.topMargin + (i - j);
            if ((paramInt1 != parambm.leftMargin) || (i != parambm.topMargin))
            {
              parambm.leftMargin = paramInt1;
              parambm.topMargin = i;
              this.KDh.setLayoutParams(parambm);
            }
          }
        }
      }
      catch (Throwable paramTimeLineObject)
      {
        for (;;)
        {
          label1092:
          if (this.KDh != null) {
            this.KDh.setVisibility(8);
          }
          Log.e("MiroMsg.PhotoTimeLineItem", "checkShowStatusIcon exp=" + paramTimeLineObject.toString());
        }
      }
      if ((parambn.KBz) && ((paramInt2 == 3) || (paramInt2 == 4) || (paramInt2 == 5)) && (m.b(localSnsInfo, 0)) && (!m.t(localSnsInfo)))
      {
        paramInt1 = bg.KUp[paramInt2];
        a(paramBaseViewHolder.Lll, paramInt1);
      }
      AppMethodBeat.o(100093);
      return;
      if (((ADXml)localObject1).adMediaDisplayMode == 1)
      {
        i = i - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding);
        j = (int)(i * ((ADXml)localObject1).adMediaDisplayHeight / ((ADXml)localObject1).adMediaDisplayWidth);
        localObject2 = new cvv();
        if (i > 0) {
          f2 = i;
        }
        ((cvv)localObject2).TEu = f2;
        if (j > 0) {
          f1 = j;
        }
        for (;;)
        {
          ((cvv)localObject2).TEv = f1;
          ((cvv)localObject2).TEw = (((cvv)localObject2).TEu * ((cvv)localObject2).TEv);
          localLinkedList.add(localObject2);
          break;
        }
      }
      if (((ADXml)localObject1).adMediaDisplayMode == 2)
      {
        i = i - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding);
        j = (int)(i * ((ADXml)localObject1).adMediaDisplayHeight / ((ADXml)localObject1).adMediaDisplayWidth);
        localObject2 = new cvv();
        if (i > 0) {
          f2 = i;
        }
        ((cvv)localObject2).TEu = f2;
        if (j > 0) {
          f1 = j;
        }
        ((cvv)localObject2).TEv = f1;
        ((cvv)localObject2).TEw = (((cvv)localObject2).TEu * ((cvv)localObject2).TEv);
        localLinkedList.add(localObject2);
      }
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.o
 * JD-Core Version:    0.7.0.1
 */