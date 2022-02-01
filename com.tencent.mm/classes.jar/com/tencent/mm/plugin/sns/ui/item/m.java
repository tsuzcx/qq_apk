package com.tencent.mm.plugin.sns.ui.item;

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
import com.tencent.mm.plugin.sns.ad.timeline.helper.d;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends BaseTimeLineItem
{
  private MaskImageView RMW;
  private ImageView RMX;
  private List<ImageView> RMY;
  private ImageView RcO;
  private int RoU;
  private int RoV;
  
  public m()
  {
    AppMethodBeat.i(308980);
    this.RoV = 103;
    this.RMY = new ArrayList();
    AppMethodBeat.o(308980);
  }
  
  private void a(PhotosContent paramPhotosContent, int paramInt)
  {
    AppMethodBeat.i(308989);
    if ((paramPhotosContent == null) || (paramInt <= 1))
    {
      Log.e("MiroMsg.PhotoTimeLineItem", "photosContent == null or imgNums <= 1");
      AppMethodBeat.o(308989);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 20);
        i = 0;
        if (i < paramInt)
        {
          if (this.RMY.size() < paramInt)
          {
            Log.i("MiroMsg.PhotoTimeLineItem", "current index = " + i + ", weAppIcons current size = " + this.RMY.size() + ", total imgNums = " + paramInt);
            localImageView = d.a(this.mActivity, paramPhotosContent, i, j);
            if (localImageView != null)
            {
              localImageView.setVisibility(8);
              this.RMY.add(localImageView);
            }
          }
          if (paramPhotosContent.alP(i).getVisibility() == 8) {
            break label222;
          }
          ImageView localImageView = (ImageView)this.RMY.get(i);
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
      finally
      {
        Log.e("MiroMsg.PhotoTimeLineItem", paramPhotosContent.toString());
        AppMethodBeat.o(308989);
        return;
      }
      AppMethodBeat.o(308989);
      return;
      label222:
      i += 1;
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(100093);
    if (paramBaseViewHolder.RKZ == null)
    {
      AppMethodBeat.o(100093);
      return;
    }
    if ((parambo != null) && (paramTimeLineObject != null) && (parambo.Rbg)) {
      Log.i("MiroMsg.PhotoTimeLineItem", "ad fillItem, photoItem, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
    }
    paramBaseViewHolder.RKZ.setVisibility(0);
    LinkedList localLinkedList = new LinkedList();
    int i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
    if (this.RcO != null) {
      this.RcO.setVisibility(8);
    }
    SnsInfo localSnsInfo = parambo.PJQ;
    if (this.RMX != null) {
      this.RMX.setVisibility(8);
    }
    Object localObject1 = this.RMY.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ImageView)((Iterator)localObject1).next();
      ((ImageView)localObject2).setVisibility(8);
      paramBaseViewHolder.RKZ.removeView((View)localObject2);
    }
    float f2;
    float f1;
    if ((parambo.Rbg) && (paramInt2 == 2))
    {
      localObject1 = localSnsInfo.getAdXml();
      if ((localObject1 != null) && (((ADXml)localObject1).adMediaDisplayWidth > 0.0F) && (((ADXml)localObject1).adMediaDisplayHeight > 0.0F))
      {
        f2 = l.a(((ADXml)localObject1).adMediaDisplayWidth, 1, ((ADXml)localObject1).adBasicRemWidth, ((ADXml)localObject1).adBasicRootFontSize);
        f1 = l.a(((ADXml)localObject1).adMediaDisplayHeight, 1, ((ADXml)localObject1).adBasicRemWidth, ((ADXml)localObject1).adBasicRootFontSize);
        if (((ADXml)localObject1).adMediaDisplayMode != 0) {
          break label1090;
        }
        localObject2 = new dnb();
        ((dnb)localObject2).aaUb = f2;
        ((dnb)localObject2).aaUc = f1;
        if (f2 >= i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding))
        {
          ((dnb)localObject2).aaUb = (i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding));
          ((dnb)localObject2).aaUc = ((int)(((dnb)localObject2).aaUb * ((ADXml)localObject1).adMediaDisplayHeight / ((ADXml)localObject1).adMediaDisplayWidth));
        }
        ((dnb)localObject2).aaUd = (((dnb)localObject2).aaUb * ((dnb)localObject2).aaUc);
        localLinkedList.add(localObject2);
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (((ADXml)localObject1).isShowPlayIconOnCover()))
      {
        if (this.RcO == null) {
          this.RcO = ((ImageView)paramBaseViewHolder.RKZ.findViewById(b.f.status_icon));
        }
        if (this.RcO != null) {
          this.RcO.setVisibility(0);
        }
      }
      if ((com.tencent.mm.plugin.sns.data.m.c(localSnsInfo, 0)) && (!com.tencent.mm.plugin.sns.data.m.v(localSnsInfo)))
      {
        localObject2 = paramBaseViewHolder.RKZ;
        if (localObject2 == null) {}
      }
      try
      {
        if (this.RMX == null) {
          this.RMX = new ImageView(this.mActivity);
        }
        ((PhotosContent)localObject2).removeView(this.RMX);
        i = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 24);
        j = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 4);
        localObject4 = new FrameLayout.LayoutParams(i, i);
        ((FrameLayout.LayoutParams)localObject4).leftMargin = j;
        ((FrameLayout.LayoutParams)localObject4).topMargin = j;
        this.RMX.setImageDrawable(com.tencent.mm.cd.a.m(this.mActivity, b.e.we_app_icon));
        this.RMX.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        this.RMX.setVisibility(0);
        ((PhotosContent)localObject2).addView(this.RMX);
      }
      finally
      {
        for (;;)
        {
          int j;
          Object localObject4;
          boolean bool1;
          boolean bool2;
          Log.e("MiroMsg.PhotoTimeLineItem", localObject3.toString());
        }
      }
      if (!Util.isNullOrNil(((ADXml)localObject1).adMediaIconUrl))
      {
        localObject2 = paramBaseViewHolder.RKZ;
        localObject4 = paramBaseViewHolder.RKZ.alP(0);
        k.b("adId", ((ADXml)localObject1).adMediaIconUrl, new g.a()
        {
          public final void aWn(String paramAnonymousString)
          {
            AppMethodBeat.i(100091);
            m.a(m.this, (MaskImageView)this.RpN.findViewById(b.f.media_icon));
            if (m.a(m.this) != null)
            {
              m.a(m.this).setVisibility(0);
              paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
              m.a(m.this).setImageBitmap(paramAnonymousString);
              float f1 = l.a(this.RpO.adMediaIconWidth, 1, this.RpO.adBasicRemWidth, this.RpO.adBasicRootFontSize);
              float f2 = l.a(this.RpO.adMediaIconHeight, 1, this.RpO.adBasicRemWidth, this.RpO.adBasicRootFontSize);
              float f3 = l.a(this.RpO.adMediaIconPaddingRight, 1, this.RpO.adBasicRemWidth, this.RpO.adBasicRootFontSize);
              float f4 = l.a(this.RpO.adMediaIconPaddingBottom, 1, this.RpO.adBasicRemWidth, this.RpO.adBasicRootFontSize);
              paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
              paramAnonymousString.setMargins((int)(this.RpP.getRight() - f3 - f1), (int)(this.RpP.getBottom() - f4 - f2), 0, 0);
              m.a(m.this).setLayoutParams(paramAnonymousString);
            }
            AppMethodBeat.o(100091);
          }
          
          public final void gZM() {}
          
          public final void gZN() {}
        });
      }
      parambn = parambn.RoJ;
      localObject1 = paramBaseViewHolder.RKZ;
      localObject2 = parambo.Rdg;
      i = this.mActivity.hashCode();
      bool1 = parambo.Rbg;
      bool2 = this.Roa;
      localObject4 = br.jbh();
      ((br)localObject4).time = paramTimeLineObject.CreateTime;
      parambn.a((PhotosContent)localObject1, paramTimeLineObject, (String)localObject2, i, paramInt2, paramInt1, bool1, bool2, (br)localObject4, localLinkedList, parambo.PNx, localSnsInfo);
      paramBaseViewHolder.RKZ.alP(0).setScaleType(QImageView.a.afVc);
      if ((parambo.Rbg) && (this.viewType == 2)) {}
      try
      {
        paramTimeLineObject = parambo.PJQ.getAdXml();
        if ((paramTimeLineObject != null) && (paramTimeLineObject.isShowPlayIconOnCover()))
        {
          if (this.RcO == null) {
            this.RcO = ((ImageView)paramBaseViewHolder.RKZ.findViewById(b.f.status_icon));
          }
          if (this.RcO != null)
          {
            this.RcO.setVisibility(0);
            paramTimeLineObject = (FrameLayout.LayoutParams)paramBaseViewHolder.RKZ.alP(0).getLayoutParams();
            parambn = (FrameLayout.LayoutParams)this.RcO.getLayoutParams();
            paramInt1 = paramTimeLineObject.width / 2 - parambn.width / 2 + paramTimeLineObject.leftMargin;
            i = paramTimeLineObject.height / 2;
            j = parambn.height / 2;
            i = paramTimeLineObject.topMargin + (i - j);
            if ((paramInt1 != parambn.leftMargin) || (i != parambn.topMargin))
            {
              parambn.leftMargin = paramInt1;
              parambn.topMargin = i;
              this.RcO.setLayoutParams(parambn);
            }
          }
        }
      }
      finally
      {
        for (;;)
        {
          if (this.RcO != null) {
            this.RcO.setVisibility(8);
          }
          Log.e("MiroMsg.PhotoTimeLineItem", "checkShowStatusIcon exp=" + paramTimeLineObject.toString());
        }
      }
      if ((parambo.Rbg) && ((paramInt2 == 3) || (paramInt2 == 4) || (paramInt2 == 5)) && (com.tencent.mm.plugin.sns.data.m.c(localSnsInfo, 0)) && (!com.tencent.mm.plugin.sns.data.m.v(localSnsInfo)))
      {
        paramInt1 = bh.Run[paramInt2];
        a(paramBaseViewHolder.RKZ, paramInt1);
      }
      a(parambo, 1);
      AppMethodBeat.o(100093);
      return;
      label1090:
      if (((ADXml)localObject1).adMediaDisplayMode == 1)
      {
        i = i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding);
        j = (int)(i * ((ADXml)localObject1).adMediaDisplayHeight / ((ADXml)localObject1).adMediaDisplayWidth);
        localObject2 = new dnb();
        if (i > 0) {
          f2 = i;
        }
        ((dnb)localObject2).aaUb = f2;
        if (j > 0) {
          f1 = j;
        }
        for (;;)
        {
          ((dnb)localObject2).aaUc = f1;
          ((dnb)localObject2).aaUd = (((dnb)localObject2).aaUb * ((dnb)localObject2).aaUc);
          localLinkedList.add(localObject2);
          break;
        }
      }
      if (((ADXml)localObject1).adMediaDisplayMode == 2)
      {
        i = i - com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(b.d.NormalPadding);
        j = (int)(i * ((ADXml)localObject1).adMediaDisplayHeight / ((ADXml)localObject1).adMediaDisplayWidth);
        localObject2 = new dnb();
        if (i > 0) {
          f2 = i;
        }
        ((dnb)localObject2).aaUb = f2;
        if (j > 0) {
          f1 = j;
        }
        ((dnb)localObject2).aaUc = f1;
        ((dnb)localObject2).aaUd = (((dnb)localObject2).aaUb * ((dnb)localObject2).aaUc);
        localLinkedList.add(localObject2);
      }
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100092);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    Log.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.viewType);
    Point localPoint = new Point();
    localPoint.x = ((DisplayMetrics)localObject).widthPixels;
    localPoint.y = ((DisplayMetrics)localObject).heightPixels;
    al.m(localPoint);
    this.RoU = al.hgP();
    if ((paramBaseViewHolder.RKG != null) && (paramBaseViewHolder.RKG.getParent() != null) && ((paramBaseViewHolder.RKG.getParent() instanceof ViewGroup))) {
      if (this.viewType == 2)
      {
        paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_timeline_imagesline_one);
        if (!paramBaseViewHolder.RKH) {
          paramBaseViewHolder.RKZ = ((PhotosContent)paramBaseViewHolder.RKG.inflate());
        }
      }
    }
    for (paramBaseViewHolder.RKH = true;; paramBaseViewHolder.RKH = true)
    {
      paramBaseViewHolder.RKZ.RhU.clear();
      int i = 0;
      while (i < bh.Run[this.viewType])
      {
        localObject = (TagImageView)paramBaseViewHolder.RKZ.findViewById(bh.Rur[i]);
        paramBaseViewHolder.RKZ.a((TagImageView)localObject);
        ((TagImageView)localObject).setOnClickListener(this.QBJ.QBf.Rea);
        this.QBJ.hpB().c((View)localObject, this.QBJ.QBf.RQi, this.QBJ.QBf.RPU);
        i += 1;
      }
      if (this.viewType == 3)
      {
        paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_timeline_imagesline1);
        break;
      }
      if (this.viewType == 4)
      {
        paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_timeline_imagesline2);
        break;
      }
      if (this.viewType == 5)
      {
        paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_timeline_imagesline3);
        break;
      }
      Log.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.viewType);
      break;
      paramBaseViewHolder.RKZ = ((PhotosContent)paramBaseViewHolder.convertView.findViewById(b.f.photo_content));
    }
    paramBaseViewHolder.RKZ.setImageViewWidth(this.RoU);
    AppMethodBeat.o(100092);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.m
 * JD-Core Version:    0.7.0.1
 */