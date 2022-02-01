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
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.LinkedList;

public final class h
  extends BaseTimeLineItem
{
  private int yJE;
  private int yJF = 103;
  private MaskImageView zff;
  
  @TargetApi(16)
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, com.tencent.mm.plugin.sns.ui.bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe)
  {
    AppMethodBeat.i(100093);
    if (paramBaseViewHolder.zdG == null)
    {
      AppMethodBeat.o(100093);
      return;
    }
    paramBaseViewHolder.zdG.setVisibility(0);
    LinkedList localLinkedList = new LinkedList();
    int i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
    Object localObject1;
    float f2;
    float f1;
    Object localObject2;
    if ((parambf.yxA) && (paramInt2 == 2))
    {
      localObject1 = parambf.xHc.dFR();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).yfW > 0.0F) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).yfX > 0.0F))
      {
        f2 = i.a(((com.tencent.mm.plugin.sns.storage.b)localObject1).yfW, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject1).yfY, ((com.tencent.mm.plugin.sns.storage.b)localObject1).yfZ);
        f1 = i.a(((com.tencent.mm.plugin.sns.storage.b)localObject1).yfX, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject1).yfY, ((com.tencent.mm.plugin.sns.storage.b)localObject1).yfZ);
        if (((com.tencent.mm.plugin.sns.storage.b)localObject1).yfV != 0) {
          break label473;
        }
        localObject2 = new bub();
        ((bub)localObject2).FjY = f2;
        ((bub)localObject2).FjZ = f1;
        if (f2 >= i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516))
        {
          ((bub)localObject2).FjY = (i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516));
          ((bub)localObject2).FjZ = ((int)(((bub)localObject2).FjY * ((com.tencent.mm.plugin.sns.storage.b)localObject1).yfX / ((com.tencent.mm.plugin.sns.storage.b)localObject1).yfW));
        }
        ((bub)localObject2).Fka = (((bub)localObject2).FjY * ((bub)localObject2).FjZ);
        localLinkedList.add(localObject2);
      }
    }
    for (;;)
    {
      if (!bs.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject1).ygb))
      {
        localObject2 = paramBaseViewHolder.zdG;
        localObject3 = paramBaseViewHolder.zdG.Pr(0);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject1).ygb, false, 41, new f.a()
        {
          public final void asD(String paramAnonymousString)
          {
            AppMethodBeat.i(100091);
            h.a(h.this, (MaskImageView)this.yKy.findViewById(2131302209));
            if (h.a(h.this) != null)
            {
              h.a(h.this).setVisibility(0);
              paramAnonymousString = f.decodeFile(paramAnonymousString);
              h.a(h.this).setImageBitmap(paramAnonymousString);
              float f1 = i.a(this.yKz.ygc, 1, this.yKz.yfY, this.yKz.yfZ);
              float f2 = i.a(this.yKz.ygd, 1, this.yKz.yfY, this.yKz.yfZ);
              float f3 = i.a(this.yKz.yge, 1, this.yKz.yfY, this.yKz.yfZ);
              float f4 = i.a(this.yKz.ygf, 1, this.yKz.yfY, this.yKz.yfZ);
              paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
              paramAnonymousString.setMargins((int)(this.yKA.getRight() - f3 - f1), (int)(this.yKA.getBottom() - f4 - f2), 0, 0);
              h.a(h.this).setLayoutParams(paramAnonymousString);
            }
            AppMethodBeat.o(100091);
          }
          
          public final void dFC() {}
          
          public final void dFD() {}
        });
      }
      parambe = parambe.yJt;
      localObject1 = paramBaseViewHolder.zdG;
      localObject2 = parambf.yzm;
      i = this.mActivity.hashCode();
      boolean bool1 = parambf.yxA;
      boolean bool2 = this.yIK;
      Object localObject3 = com.tencent.mm.storage.bf.fbk();
      ((com.tencent.mm.storage.bf)localObject3).gIh = paramTimeLineObject.CreateTime;
      parambe.a((PhotosContent)localObject1, paramTimeLineObject, (String)localObject2, i, paramInt2, paramInt1, bool1, bool2, (com.tencent.mm.storage.bf)localObject3, localLinkedList, parambf.yUR);
      paramBaseViewHolder.zdG.Pr(0).setScaleType(QImageView.a.JbU);
      AppMethodBeat.o(100093);
      return;
      label473:
      int j;
      if (((com.tencent.mm.plugin.sns.storage.b)localObject1).yfV == 1)
      {
        i = i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
        j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject1).yfX / ((com.tencent.mm.plugin.sns.storage.b)localObject1).yfW);
        localObject2 = new bub();
        if (i > 0) {
          f2 = i;
        }
        ((bub)localObject2).FjY = f2;
        if (j > 0) {
          f1 = j;
        }
        for (;;)
        {
          ((bub)localObject2).FjZ = f1;
          ((bub)localObject2).Fka = (((bub)localObject2).FjY * ((bub)localObject2).FjZ);
          localLinkedList.add(localObject2);
          break;
        }
      }
      if (((com.tencent.mm.plugin.sns.storage.b)localObject1).yfV == 2)
      {
        i = i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(2131165516) - this.mActivity.getResources().getDimensionPixelSize(2131165516);
        j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject1).yfX / ((com.tencent.mm.plugin.sns.storage.b)localObject1).yfW);
        localObject2 = new bub();
        if (i > 0) {
          f2 = i;
        }
        ((bub)localObject2).FjY = f2;
        if (j > 0) {
          f1 = j;
        }
        ((bub)localObject2).FjZ = f1;
        ((bub)localObject2).Fka = (((bub)localObject2).FjY * ((bub)localObject2).FjZ);
        localLinkedList.add(localObject2);
      }
    }
  }
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100092);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    ac.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.oeH);
    Point localPoint = new Point();
    localPoint.x = ((DisplayMetrics)localObject).widthPixels;
    localPoint.y = ((DisplayMetrics)localObject).heightPixels;
    af.h(localPoint);
    this.yJE = af.dIc();
    if ((paramBaseViewHolder.zdm != null) && (paramBaseViewHolder.zdm.getParent() != null) && ((paramBaseViewHolder.zdm.getParent() instanceof ViewGroup))) {
      if (this.oeH == 2)
      {
        paramBaseViewHolder.zdm.setLayoutResource(2131495611);
        if (!paramBaseViewHolder.zdn) {
          paramBaseViewHolder.zdG = ((PhotosContent)paramBaseViewHolder.zdm.inflate());
        }
      }
    }
    for (paramBaseViewHolder.zdn = true;; paramBaseViewHolder.zdn = true)
    {
      paramBaseViewHolder.zdG.yDo.clear();
      int i = 0;
      while (i < ay.yOx[this.oeH])
      {
        localObject = (TagImageView)paramBaseViewHolder.zdG.findViewById(ay.yOB[i]);
        paramBaseViewHolder.zdG.a((TagImageView)localObject);
        ((TagImageView)localObject).setOnClickListener(this.xZJ.xZe.yAf);
        this.xZJ.dQx().c((View)localObject, this.xZJ.xZe.zgD, this.xZJ.xZe.zgp);
        i += 1;
      }
      if (this.oeH == 3)
      {
        paramBaseViewHolder.zdm.setLayoutResource(2131495608);
        break;
      }
      if (this.oeH == 4)
      {
        paramBaseViewHolder.zdm.setLayoutResource(2131495609);
        break;
      }
      if (this.oeH == 5)
      {
        paramBaseViewHolder.zdm.setLayoutResource(2131495610);
        break;
      }
      ac.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.oeH);
      break;
      paramBaseViewHolder.zdG = ((PhotosContent)paramBaseViewHolder.sSS.findViewById(2131303243));
    }
    paramBaseViewHolder.zdG.setImageViewWidth(this.yJE);
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