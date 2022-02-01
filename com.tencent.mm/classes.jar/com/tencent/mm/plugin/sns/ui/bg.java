package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.c;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class bg
{
  private static boolean KUA;
  public static int KUB = -1;
  public static int[] KUp = { 0, 0, 1, 3, 6, 9 };
  public static int[] KUq = { i.f.album_img_0 };
  public static int[] KUr = { i.f.album_img_0, i.f.album_img_1, i.f.album_img_2 };
  public static int[] KUs = { i.f.album_img_0, i.f.album_img_1, i.f.album_img_2, i.f.album_img_3, i.f.album_img_4, i.f.album_img_5 };
  public static int[] KUt = { i.f.album_img_0, i.f.album_img_1, i.f.album_img_2, i.f.album_img_3, i.f.album_img_4, i.f.album_img_5, i.f.album_img_6, i.f.album_img_7, i.f.album_img_8 };
  static double KUu = -1.0D;
  static double KUv = -1.0D;
  static double KUw = -1.0D;
  static double KUx = -1.0D;
  static double KUy = -1.0D;
  private LinkedList<LinearLayout> KUz;
  private Context context;
  
  public bg(Context paramContext)
  {
    AppMethodBeat.i(98907);
    this.KUz = new LinkedList();
    this.context = paramContext;
    if ((this.context instanceof Activity))
    {
      paramContext = new DisplayMetrics();
      ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(paramContext);
      Point localPoint = new Point();
      localPoint.x = paramContext.widthPixels;
      localPoint.y = paramContext.heightPixels;
      aj.k(localPoint);
    }
    if (1 == ((b)h.ae(b.class)).a(b.a.vVE, 0)) {}
    for (boolean bool = true;; bool = false)
    {
      KUA = bool;
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
        KUA = true;
      }
      AppMethodBeat.o(98907);
      return;
    }
  }
  
  private static void a(cvt paramcvt, QFadeImageView paramQFadeImageView, int paramInt, bp parambp)
  {
    AppMethodBeat.i(98911);
    aj.fOF().b(paramcvt, paramQFadeImageView, paramInt, parambp);
    AppMethodBeat.o(98911);
  }
  
  private void a(cvt paramcvt, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, bp parambp, int paramInt3, boolean paramBoolean2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(203116);
    a(paramcvt, paramQFadeImageView, paramString, paramInt1, paramInt2, paramBoolean1, parambp, paramInt3, paramBoolean2, new cvv(), paramSnsInfo);
    AppMethodBeat.o(203116);
  }
  
  private void a(cvt paramcvt, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, bp parambp, int paramInt3, boolean paramBoolean2, cvv paramcvv, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(203115);
    if (paramQFadeImageView == null)
    {
      Log.e("MicroMsg.SnsMultiLineImageLineMgr", "");
      AppMethodBeat.o(203115);
      return;
    }
    be localbe = new be();
    localbe.fCM = paramString;
    localbe.index = 0;
    paramString = new ArrayList();
    paramString.add(paramQFadeImageView);
    localbe.KRL = paramString;
    localbe.KOn = paramBoolean1;
    localbe.position = paramInt2;
    paramQFadeImageView.setTag(localbe);
    double d2 = 0.0D;
    double d1 = 0.0D;
    if ((paramInt3 == 10) && (paramBoolean2))
    {
      aj.fOF().c(paramcvt, paramQFadeImageView, paramInt1, parambp);
      if (paramcvt.TDH != null)
      {
        d2 = paramcvt.TDH.TEu;
        d1 = paramcvt.TDH.TEv;
      }
      if ((paramInt3 != 2) || (paramSnsInfo == null) || (!paramSnsInfo.isFinderAd())) {
        break label263;
      }
      paramcvt = o.a((int)d2, (int)d1, this.context, false);
      d1 = ((Integer)paramcvt.first).intValue();
      d2 = ((Integer)paramcvt.second).intValue();
    }
    for (;;)
    {
      label263:
      double d3;
      if ((paramQFadeImageView.getLayoutParams() instanceof FrameLayout.LayoutParams))
      {
        paramcvt = (FrameLayout.LayoutParams)paramQFadeImageView.getLayoutParams();
        if ((paramcvt.width == d1) && (paramcvt.height == d2))
        {
          AppMethodBeat.o(203115);
          return;
          aj.fOF().a(paramcvt, paramQFadeImageView, paramInt1, parambp);
          break;
          if ((d2 > 0.0D) && (d1 > 0.0D))
          {
            double d4 = Math.min(KUv / d2, KUv / d1);
            d3 = d2 * d4;
            d4 = d1 * d4;
            d1 = d4;
            d2 = d3;
            if (d3 < KUw)
            {
              d1 = 1.0D * KUw / d3;
              d2 = d3 * d1;
              d1 = d4 * d1;
            }
            d3 = d1;
            d4 = d2;
            if (d1 < KUw)
            {
              d3 = 1.0D * KUw / d1;
              d4 = d2 * d3;
              d3 = d1 * d3;
            }
            d1 = d4;
            if (d4 > KUv) {
              d1 = KUv;
            }
            d2 = d3;
            if (d3 > KUv) {
              d2 = KUv;
            }
            d3 = d1;
          }
          for (;;)
          {
            d1 = d3;
            if (d3 < 1.0D) {
              d1 = 1.0D;
            }
            d3 = d2;
            if (d2 < 1.0D) {
              d3 = 1.0D;
            }
            if ((paramcvv == null) || (paramcvv.TEu <= 0.0F) || (paramcvv.TEv <= 0.0F)) {
              break label538;
            }
            d1 = paramcvv.TEu;
            d2 = paramcvv.TEv;
            break;
            d3 = KUu;
            d2 = KUu;
          }
        }
        paramQFadeImageView.setLayoutParams(new FrameLayout.LayoutParams((int)d1, (int)d2));
      }
      AppMethodBeat.o(203115);
      return;
      label538:
      d2 = d3;
    }
  }
  
  private static void a(String paramString, SparseArray<cvt> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, bp parambp, int paramInt2)
  {
    AppMethodBeat.i(98912);
    aj.fOF().a(paramString, paramSparseArray, paramSparseArray1, paramInt1, parambp, paramInt2);
    AppMethodBeat.o(98912);
  }
  
  public static boolean fWH()
  {
    AppMethodBeat.i(98910);
    Log.d("MicroMsg.SnsMultiLineImageLineMgr", "enableGroupDownload_cmd: %d.", new Object[] { Integer.valueOf(KUB) });
    switch (KUB)
    {
    default: 
      boolean bool = CdnLogic.allowBatchImageDownload();
      Log.d("MicroMsg.SnsMultiLineImageLineMgr", "allowGroupDownload: %s, enableGroupDownload: %s.", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(KUA) });
      if ((bool) && (KUA))
      {
        AppMethodBeat.o(98910);
        return true;
      }
      break;
    case 1: 
      Log.d("MicroMsg.SnsMultiLineImageLineMgr", "enforce group download.");
      CdnLogic.setSnsImagePrivateProtocolAvalible(true);
      CdnLogic.setSnsImageStreamProtocolAvalible(true);
      AppMethodBeat.o(98910);
      return true;
    case 2: 
      Log.d("MicroMsg.SnsMultiLineImageLineMgr", "enforce single download.");
      AppMethodBeat.o(98910);
      return false;
    }
    Log.i("MicroMsg.SnsMultiLineImageLineMgr", "groupDownloadDisable!!!");
    AppMethodBeat.o(98910);
    return false;
  }
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, bp parambp, boolean paramBoolean2)
  {
    AppMethodBeat.i(98908);
    int[] arrayOfInt = KUt;
    if ((paramInt2 == 2) || (paramInt2 == 10)) {
      arrayOfInt = KUq;
    }
    int i;
    for (;;)
    {
      paramTimeLineObject = paramTimeLineObject.ContentObj.Sqr;
      if (KUu < 0.0D)
      {
        KUu = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 160.0F);
        KUv = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 200.0F);
        KUw = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 44.0F);
        KUx = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 66.0F);
        KUy = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 300.0F);
      }
      i = paramTimeLineObject.size();
      if (i != 0) {
        break label226;
      }
      paramInt1 = 0;
      while (paramInt1 < arrayOfInt.length)
      {
        aj.fOF().gm(paramPhotosContent.agW(paramInt1));
        paramPhotosContent.agW(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        arrayOfInt = KUr;
      } else if (paramInt2 == 4) {
        arrayOfInt = KUs;
      } else if (paramInt2 == 5) {
        arrayOfInt = KUt;
      }
    }
    paramPhotosContent.setVisibility(8);
    AppMethodBeat.o(98908);
    return;
    label226:
    paramPhotosContent.setVisibility(0);
    if (i == 1)
    {
      i = 1;
      while (i < arrayOfInt.length)
      {
        TagImageView localTagImageView = paramPhotosContent.agW(i);
        localTagImageView.setVisibility(8);
        aj.fOF().gm(localTagImageView);
        paramPhotosContent.agW(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.agW(0).setVisibility(0);
      a((cvt)paramTimeLineObject.get(0), paramPhotosContent.agW(0), paramString, paramInt1, paramInt3, paramBoolean1, parambp, paramInt2, paramBoolean2, null);
      AppMethodBeat.o(98908);
      return;
    }
    AppMethodBeat.o(98908);
  }
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, bp parambp, List<cvv> paramList, String paramString2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(203099);
    Object localObject = KUt;
    if ((paramInt2 == 2) || (paramInt2 == 10) || (paramInt2 == 13)) {
      localObject = KUq;
    }
    LinkedList localLinkedList;
    int j;
    for (;;)
    {
      localLinkedList = paramTimeLineObject.ContentObj.Sqr;
      if (KUu < 0.0D)
      {
        KUu = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 160.0F);
        KUv = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 200.0F);
        KUw = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 44.0F);
        KUx = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 66.0F);
        KUy = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 300.0F);
      }
      j = localLinkedList.size();
      if (j != 0) {
        break label235;
      }
      paramInt1 = 0;
      while (paramInt1 < localObject.length)
      {
        aj.fOF().gm(paramPhotosContent.agW(paramInt1));
        paramPhotosContent.agW(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        localObject = KUr;
      } else if (paramInt2 == 4) {
        localObject = KUs;
      } else if (paramInt2 == 5) {
        localObject = KUt;
      }
    }
    paramPhotosContent.setVisibility(8);
    AppMethodBeat.o(203099);
    return;
    label235:
    paramPhotosContent.setImageViewWidth(aj.fOV());
    paramPhotosContent.setVisibility(0);
    int i;
    if (j == 1)
    {
      i = 1;
      while (i < localObject.length)
      {
        paramTimeLineObject = paramPhotosContent.agW(i);
        paramTimeLineObject.setVisibility(8);
        aj.fOF().gm(paramTimeLineObject);
        paramPhotosContent.agW(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.agW(0).setVisibility(0);
      if ((paramList != null) && (paramList.size() > 0))
      {
        a((cvt)localLinkedList.get(0), paramPhotosContent.agW(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambp, paramInt2, false, (cvv)paramList.get(0), paramSnsInfo);
        AppMethodBeat.o(203099);
        return;
      }
      a((cvt)localLinkedList.get(0), paramPhotosContent.agW(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambp, paramInt2, false, paramSnsInfo);
      AppMethodBeat.o(203099);
      return;
    }
    if (!fWH()) {}
    for (paramTimeLineObject = new c.c(paramString2, j);; paramTimeLineObject = null)
    {
      be localbe;
      cvt localcvt;
      if (j == 4)
      {
        paramList = new ArrayList();
        paramSnsInfo = new SparseArray();
        localSparseArray = new SparseArray();
        paramInt2 = localObject.length - 1;
        i = 3;
        if (paramInt2 >= 0)
        {
          localObject = paramPhotosContent.agW(paramInt2);
          ((TagImageView)localObject).setPosition(paramInt3);
          if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3) || (paramInt2 == 4))
          {
            ((TagImageView)localObject).setVisibility(0);
            paramList.add(localObject);
            localbe = new be();
            localbe.fCM = paramString1;
            localbe.index = i;
            localbe.KRL = paramList;
            localbe.KOn = paramBoolean2;
            localbe.position = paramInt3;
            ((TagImageView)localObject).setTag(localbe);
            if ((paramBoolean1) || (!fWH()))
            {
              localcvt = (cvt)localLinkedList.get(localbe.index);
              aj.fOD().a(localcvt.Id, paramTimeLineObject);
              aj.fOD().aZO(localcvt.Id);
              a(localcvt, (QFadeImageView)localObject, paramInt1, parambp);
            }
            paramSnsInfo.put(localbe.index, localLinkedList.get(localbe.index));
            localSparseArray.put(localbe.index, localObject);
            i -= 1;
          }
          for (;;)
          {
            paramInt2 -= 1;
            break;
            ((TagImageView)localObject).setVisibility(8);
            aj.fOF().gm((View)localObject);
          }
        }
        if ((!paramBoolean1) && (fWH()) && (paramSnsInfo.size() > 0)) {
          a(paramString2, paramSnsInfo, localSparseArray, paramInt1, parambp, j);
        }
        AppMethodBeat.o(203099);
        return;
      }
      paramList = new ArrayList();
      paramSnsInfo = new SparseArray();
      SparseArray localSparseArray = new SparseArray();
      paramInt2 = localObject.length - 1;
      if (paramInt2 >= 0)
      {
        localObject = paramPhotosContent.agW(paramInt2);
        ((TagImageView)localObject).setPosition(paramInt3);
        if (paramInt2 < localLinkedList.size())
        {
          ((TagImageView)localObject).setVisibility(0);
          paramList.add(localObject);
          localbe = new be();
          localbe.fCM = paramString1;
          localbe.index = paramInt2;
          localbe.KRL = paramList;
          localbe.KOn = paramBoolean2;
          localbe.position = paramInt3;
          ((TagImageView)localObject).setTag(localbe);
          if ((paramBoolean1) || (!fWH()))
          {
            localcvt = (cvt)localLinkedList.get(localbe.index);
            aj.fOD().a(localcvt.Id, paramTimeLineObject);
            aj.fOD().aZO(localcvt.Id);
            a(localcvt, (QFadeImageView)localObject, paramInt1, parambp);
          }
          paramSnsInfo.put(localbe.index, localLinkedList.get(localbe.index));
          localSparseArray.put(localbe.index, localObject);
        }
        for (;;)
        {
          paramInt2 -= 1;
          break;
          ((TagImageView)localObject).setVisibility(8);
          aj.fOF().gm((View)localObject);
        }
      }
      if ((!paramBoolean1) && (fWH()) && (paramSnsInfo.size() > 0)) {
        a(paramString2, paramSnsInfo, localSparseArray, paramInt1, parambp, j);
      }
      AppMethodBeat.o(203099);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bg
 * JD-Core Version:    0.7.0.1
 */