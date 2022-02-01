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
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.LinkedList;

public final class j
  extends BaseTimeLineItem
{
  private int AaY;
  private int AaZ = 103;
  private MaskImageView Axc;
  private ImageView Axd;
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(100093);
    if (paramBaseViewHolder.Avw == null)
    {
      AppMethodBeat.o(100093);
      return;
    }
    paramBaseViewHolder.Avw.setVisibility(0);
    LinkedList localLinkedList = new LinkedList();
    int i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
    if (this.Axd != null) {
      this.Axd.setVisibility(8);
    }
    Object localObject2;
    Object localObject1;
    float f2;
    float f1;
    Object localObject3;
    if ((parambi.zOM) && (paramInt2 == 2))
    {
      localObject2 = parambi.yVM;
      localObject1 = ((p)localObject2).dRL();
      if ((localObject1 != null) && (((b)localObject1).zvY > 0.0F) && (((b)localObject1).zvZ > 0.0F))
      {
        f2 = i.a(((b)localObject1).zvY, 1, ((b)localObject1).zwa, ((b)localObject1).zwb);
        f1 = i.a(((b)localObject1).zvZ, 1, ((b)localObject1).zwa, ((b)localObject1).zwb);
        if (((b)localObject1).zvX != 0) {
          break label642;
        }
        localObject3 = new byp();
        ((byp)localObject3).GTz = f2;
        ((byp)localObject3).GTA = f1;
        if (f2 >= i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516))
        {
          ((byp)localObject3).GTz = (i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516));
          ((byp)localObject3).GTA = ((int)(((byp)localObject3).GTz * ((b)localObject1).zvZ / ((b)localObject1).zvY));
        }
        ((byp)localObject3).GTB = (((byp)localObject3).GTz * ((byp)localObject3).GTA);
        localLinkedList.add(localObject3);
      }
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.sns.data.j.a((p)localObject2, 0)) && (!com.tencent.mm.plugin.sns.data.j.l((p)localObject2)))
      {
        localObject2 = paramBaseViewHolder.Avw;
        if (localObject2 == null) {}
      }
      try
      {
        if (this.Axd == null) {
          this.Axd = new ImageView(this.mActivity);
        }
        ((PhotosContent)localObject2).removeView(this.Axd);
        i = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 24);
        j = com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 4);
        localObject3 = new FrameLayout.LayoutParams(i, i);
        ((FrameLayout.LayoutParams)localObject3).leftMargin = j;
        ((FrameLayout.LayoutParams)localObject3).topMargin = j;
        this.Axd.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131235087));
        this.Axd.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.Axd.setVisibility(0);
        ((PhotosContent)localObject2).addView(this.Axd);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          int j;
          boolean bool1;
          boolean bool2;
          ad.e("MiroMsg.PhotoTimeLineItem", localThrowable.toString());
        }
      }
      if (!bt.isNullOrNil(((b)localObject1).zwd))
      {
        localObject2 = paramBaseViewHolder.Avw;
        localObject3 = paramBaseViewHolder.Avw.Ra(0);
        h.c("adId", ((b)localObject1).zwd, false, 41, new f.a()
        {
          public final void axG(String paramAnonymousString)
          {
            AppMethodBeat.i(100091);
            j.a(j.this, (MaskImageView)this.AbT.findViewById(2131302209));
            if (j.a(j.this) != null)
            {
              j.a(j.this).setVisibility(0);
              paramAnonymousString = g.decodeFile(paramAnonymousString);
              j.a(j.this).setImageBitmap(paramAnonymousString);
              float f1 = i.a(this.AbU.zwe, 1, this.AbU.zwa, this.AbU.zwb);
              float f2 = i.a(this.AbU.zwf, 1, this.AbU.zwa, this.AbU.zwb);
              float f3 = i.a(this.AbU.zwg, 1, this.AbU.zwa, this.AbU.zwb);
              float f4 = i.a(this.AbU.zwh, 1, this.AbU.zwa, this.AbU.zwb);
              paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
              paramAnonymousString.setMargins((int)(this.AbV.getRight() - f3 - f1), (int)(this.AbV.getBottom() - f4 - f2), 0, 0);
              j.a(j.this).setLayoutParams(paramAnonymousString);
            }
            AppMethodBeat.o(100091);
          }
          
          public final void dRW() {}
          
          public final void dRX() {}
        });
      }
      parambh = parambh.AaN;
      localObject1 = paramBaseViewHolder.Avw;
      localObject2 = parambi.zQD;
      i = this.mActivity.hashCode();
      bool1 = parambi.zOM;
      bool2 = this.Aae;
      localObject3 = bj.frn();
      ((bj)localObject3).hbR = paramTimeLineObject.CreateTime;
      parambh.a((PhotosContent)localObject1, paramTimeLineObject, (String)localObject2, i, paramInt2, paramInt1, bool1, bool2, (bj)localObject3, localLinkedList, parambi.AmA);
      paramBaseViewHolder.Avw.Ra(0).setScaleType(QImageView.a.KTb);
      AppMethodBeat.o(100093);
      return;
      label642:
      if (((b)localObject1).zvX == 1)
      {
        i = i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
        j = (int)(i * ((b)localObject1).zvZ / ((b)localObject1).zvY);
        localObject3 = new byp();
        if (i > 0) {
          f2 = i;
        }
        ((byp)localObject3).GTz = f2;
        if (j > 0) {
          f1 = j;
        }
        for (;;)
        {
          ((byp)localObject3).GTA = f1;
          ((byp)localObject3).GTB = (((byp)localObject3).GTz * ((byp)localObject3).GTA);
          localLinkedList.add(localObject3);
          break;
        }
      }
      if (((b)localObject1).zvX == 2)
      {
        i = i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
        j = (int)(i * ((b)localObject1).zvZ / ((b)localObject1).zvY);
        localObject3 = new byp();
        if (i > 0) {
          f2 = i;
        }
        ((byp)localObject3).GTz = f2;
        if (j > 0) {
          f1 = j;
        }
        ((byp)localObject3).GTA = f1;
        ((byp)localObject3).GTB = (((byp)localObject3).GTz * ((byp)localObject3).GTA);
        localLinkedList.add(localObject3);
      }
    }
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100092);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    ad.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.oIb);
    Point localPoint = new Point();
    localPoint.x = ((DisplayMetrics)localObject).widthPixels;
    localPoint.y = ((DisplayMetrics)localObject).heightPixels;
    ag.i(localPoint);
    this.AaY = ag.dUp();
    if ((paramBaseViewHolder.Avc != null) && (paramBaseViewHolder.Avc.getParent() != null) && ((paramBaseViewHolder.Avc.getParent() instanceof ViewGroup))) {
      if (this.oIb == 2)
      {
        paramBaseViewHolder.Avc.setLayoutResource(2131495611);
        if (!paramBaseViewHolder.Avd) {
          paramBaseViewHolder.Avw = ((PhotosContent)paramBaseViewHolder.Avc.inflate());
        }
      }
    }
    for (paramBaseViewHolder.Avd = true;; paramBaseViewHolder.Avd = true)
    {
      paramBaseViewHolder.Avw.zUJ.clear();
      int i = 0;
      while (i < bb.AfT[this.oIb])
      {
        localObject = (TagImageView)paramBaseViewHolder.Avw.findViewById(bb.AfX[i]);
        paramBaseViewHolder.Avw.a((TagImageView)localObject);
        ((TagImageView)localObject).setOnClickListener(this.zpI.zpd.zRv);
        this.zpI.ecN().c((View)localObject, this.zpI.zpd.AyE, this.zpI.zpd.Ayq);
        i += 1;
      }
      if (this.oIb == 3)
      {
        paramBaseViewHolder.Avc.setLayoutResource(2131495608);
        break;
      }
      if (this.oIb == 4)
      {
        paramBaseViewHolder.Avc.setLayoutResource(2131495609);
        break;
      }
      if (this.oIb == 5)
      {
        paramBaseViewHolder.Avc.setLayoutResource(2131495610);
        break;
      }
      ad.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.oIb);
      break;
      paramBaseViewHolder.Avw = ((PhotosContent)paramBaseViewHolder.tPw.findViewById(2131303243));
    }
    paramBaseViewHolder.Avw.setImageViewWidth(this.AaY);
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