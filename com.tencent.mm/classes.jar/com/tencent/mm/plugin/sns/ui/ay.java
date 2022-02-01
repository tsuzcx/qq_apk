package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.c;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ay
{
  public static int[] xBJ = { 0, 0, 1, 3, 6, 9 };
  public static int[] xBK = { 2131296575 };
  public static int[] xBL = { 2131296575, 2131296576, 2131296577 };
  public static int[] xBM = { 2131296575, 2131296576, 2131296577, 2131296578, 2131296579, 2131296580 };
  public static int[] xBN = { 2131296575, 2131296576, 2131296577, 2131296578, 2131296579, 2131296580, 2131296581, 2131296582, 2131296583 };
  static double xBO = -1.0D;
  static double xBP = -1.0D;
  static double xBQ = -1.0D;
  static double xBR = -1.0D;
  static double xBS = -1.0D;
  private static boolean xBU;
  public static int xBV = -1;
  private Context context;
  private LinkedList<LinearLayout> xBT;
  
  public ay(Context paramContext)
  {
    AppMethodBeat.i(98907);
    this.xBT = new LinkedList();
    this.context = paramContext;
    if ((this.context instanceof Activity))
    {
      paramContext = new DisplayMetrics();
      ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(paramContext);
      Point localPoint = new Point();
      localPoint.x = paramContext.widthPixels;
      localPoint.y = paramContext.heightPixels;
      af.f(localPoint);
    }
    if (1 == ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwF, 0)) {}
    for (boolean bool = true;; bool = false)
    {
      xBU = bool;
      if ((h.IS_FLAVOR_RED) || (h.DEBUG)) {
        xBU = true;
      }
      AppMethodBeat.o(98907);
      return;
    }
  }
  
  private static void a(bpi parambpi, QFadeImageView paramQFadeImageView, int paramInt, bc parambc)
  {
    AppMethodBeat.i(98911);
    af.dtr().b(parambpi, paramQFadeImageView, paramInt, parambc);
    AppMethodBeat.o(98911);
  }
  
  private static void a(bpi parambpi, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, bc parambc, int paramInt3, boolean paramBoolean2)
  {
    AppMethodBeat.i(98914);
    a(parambpi, paramQFadeImageView, paramString, paramInt1, paramInt2, paramBoolean1, parambc, paramInt3, paramBoolean2, new bpk());
    AppMethodBeat.o(98914);
  }
  
  private static void a(bpi parambpi, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, bc parambc, int paramInt3, boolean paramBoolean2, bpk parambpk)
  {
    AppMethodBeat.i(98913);
    if (paramQFadeImageView == null)
    {
      ad.e("MicroMsg.SnsMultiLineImageLineMgr", "");
      AppMethodBeat.o(98913);
      return;
    }
    aw localaw = new aw();
    localaw.diQ = paramString;
    localaw.index = 0;
    paramString = new ArrayList();
    paramString.add(paramQFadeImageView);
    localaw.xzo = paramString;
    localaw.xvU = paramBoolean1;
    localaw.position = paramInt2;
    paramQFadeImageView.setTag(localaw);
    double d2 = 0.0D;
    double d1 = 0.0D;
    double d3;
    if ((paramInt3 == 10) && (paramBoolean2))
    {
      af.dtr().c(parambpi, paramQFadeImageView, paramInt1, parambc);
      if (parambpi.DMT != null)
      {
        d2 = parambpi.DMT.DNH;
        d1 = parambpi.DMT.DNI;
      }
      if ((d2 <= 0.0D) || (d1 <= 0.0D)) {
        break label437;
      }
      double d4 = Math.min(xBP / d2, xBP / d1);
      d3 = d2 * d4;
      d4 = d1 * d4;
      d1 = d4;
      d2 = d3;
      if (d3 < xBQ)
      {
        d1 = 1.0D * xBQ / d3;
        d2 = d3 * d1;
        d1 = d4 * d1;
      }
      d3 = d1;
      d4 = d2;
      if (d1 < xBQ)
      {
        d3 = 1.0D * xBQ / d1;
        d4 = d2 * d3;
        d3 = d1 * d3;
      }
      d1 = d4;
      if (d4 > xBP) {
        d1 = xBP;
      }
      d2 = d3;
      if (d3 > xBP) {
        d2 = xBP;
      }
      d3 = d1;
      label308:
      d1 = d3;
      if (d3 < 1.0D) {
        d1 = 1.0D;
      }
      d3 = d2;
      if (d2 < 1.0D) {
        d3 = 1.0D;
      }
      if ((parambpk == null) || (parambpk.DNH <= 0.0F) || (parambpk.DNI <= 0.0F)) {
        break label473;
      }
      d1 = parambpk.DNH;
    }
    label437:
    label473:
    for (d2 = parambpk.DNI;; d2 = d3)
    {
      if ((paramQFadeImageView.getLayoutParams() instanceof FrameLayout.LayoutParams))
      {
        parambpi = (FrameLayout.LayoutParams)paramQFadeImageView.getLayoutParams();
        if ((parambpi.width == d1) && (parambpi.height == d2))
        {
          AppMethodBeat.o(98913);
          return;
          af.dtr().a(parambpi, paramQFadeImageView, paramInt1, parambc);
          break;
          d3 = xBO;
          d2 = xBO;
          break label308;
        }
        paramQFadeImageView.setLayoutParams(new FrameLayout.LayoutParams((int)d1, (int)d2));
      }
      AppMethodBeat.o(98913);
      return;
    }
  }
  
  private static void a(String paramString, SparseArray<bpi> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, bc parambc, int paramInt2)
  {
    AppMethodBeat.i(98912);
    af.dtr().a(paramString, paramSparseArray, paramSparseArray1, paramInt1, parambc, paramInt2);
    AppMethodBeat.o(98912);
  }
  
  public static boolean dBA()
  {
    AppMethodBeat.i(98910);
    ad.d("MicroMsg.SnsMultiLineImageLineMgr", "enableGroupDownload_cmd: %d.", new Object[] { Integer.valueOf(xBV) });
    switch (xBV)
    {
    default: 
      boolean bool = CdnLogic.allowBatchImageDownload();
      ad.d("MicroMsg.SnsMultiLineImageLineMgr", "allowGroupDownload: %s, enableGroupDownload: %s.", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(xBU) });
      if ((bool) && (xBU))
      {
        AppMethodBeat.o(98910);
        return true;
      }
      break;
    case 1: 
      ad.d("MicroMsg.SnsMultiLineImageLineMgr", "enforce group download.");
      CdnLogic.setSnsImagePrivateProtocolAvalible(true);
      CdnLogic.setSnsImageStreamProtocolAvalible(true);
      AppMethodBeat.o(98910);
      return true;
    case 2: 
      ad.d("MicroMsg.SnsMultiLineImageLineMgr", "enforce single download.");
      AppMethodBeat.o(98910);
      return false;
    }
    ad.i("MicroMsg.SnsMultiLineImageLineMgr", "groupDownloadDisable!!!");
    AppMethodBeat.o(98910);
    return false;
  }
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, bc parambc, boolean paramBoolean2)
  {
    AppMethodBeat.i(98908);
    int[] arrayOfInt = xBN;
    if ((paramInt2 == 2) || (paramInt2 == 10)) {
      arrayOfInt = xBK;
    }
    int i;
    for (;;)
    {
      paramTimeLineObject = paramTimeLineObject.Etm.DaC;
      if (xBO < 0.0D)
      {
        xBO = BackwardSupportUtil.b.g(this.context, 160.0F);
        xBP = BackwardSupportUtil.b.g(this.context, 200.0F);
        xBQ = BackwardSupportUtil.b.g(this.context, 44.0F);
        xBR = BackwardSupportUtil.b.g(this.context, 66.0F);
        xBS = BackwardSupportUtil.b.g(this.context, 300.0F);
      }
      i = paramTimeLineObject.size();
      if (i != 0) {
        break label226;
      }
      paramInt1 = 0;
      while (paramInt1 < arrayOfInt.length)
      {
        af.dtr().eo(paramPhotosContent.No(paramInt1));
        paramPhotosContent.No(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        arrayOfInt = xBL;
      } else if (paramInt2 == 4) {
        arrayOfInt = xBM;
      } else if (paramInt2 == 5) {
        arrayOfInt = xBN;
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
        TagImageView localTagImageView = paramPhotosContent.No(i);
        localTagImageView.setVisibility(8);
        af.dtr().eo(localTagImageView);
        paramPhotosContent.No(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.No(0).setVisibility(0);
      a((bpi)paramTimeLineObject.get(0), paramPhotosContent.No(0), paramString, paramInt1, paramInt3, paramBoolean1, parambc, paramInt2, paramBoolean2);
      AppMethodBeat.o(98908);
      return;
    }
    AppMethodBeat.o(98908);
  }
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, bc parambc, List<bpk> paramList, String paramString2)
  {
    AppMethodBeat.i(98909);
    Object localObject = xBN;
    if ((paramInt2 == 2) || (paramInt2 == 10) || (paramInt2 == 13)) {
      localObject = xBK;
    }
    LinkedList localLinkedList;
    int j;
    for (;;)
    {
      localLinkedList = paramTimeLineObject.Etm.DaC;
      if (xBO < 0.0D)
      {
        xBO = BackwardSupportUtil.b.g(this.context, 160.0F);
        xBP = BackwardSupportUtil.b.g(this.context, 200.0F);
        xBQ = BackwardSupportUtil.b.g(this.context, 44.0F);
        xBR = BackwardSupportUtil.b.g(this.context, 66.0F);
        xBS = BackwardSupportUtil.b.g(this.context, 300.0F);
      }
      j = localLinkedList.size();
      if (j != 0) {
        break label235;
      }
      paramInt1 = 0;
      while (paramInt1 < localObject.length)
      {
        af.dtr().eo(paramPhotosContent.No(paramInt1));
        paramPhotosContent.No(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        localObject = xBL;
      } else if (paramInt2 == 4) {
        localObject = xBM;
      } else if (paramInt2 == 5) {
        localObject = xBN;
      }
    }
    paramPhotosContent.setVisibility(8);
    AppMethodBeat.o(98909);
    return;
    label235:
    paramPhotosContent.setImageViewWidth(af.dtE());
    paramPhotosContent.setVisibility(0);
    int i;
    if (j == 1)
    {
      i = 1;
      while (i < localObject.length)
      {
        paramTimeLineObject = paramPhotosContent.No(i);
        paramTimeLineObject.setVisibility(8);
        af.dtr().eo(paramTimeLineObject);
        paramPhotosContent.No(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.No(0).setVisibility(0);
      if ((paramList != null) && (paramList.size() > 0))
      {
        a((bpi)localLinkedList.get(0), paramPhotosContent.No(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambc, paramInt2, false, (bpk)paramList.get(0));
        AppMethodBeat.o(98909);
        return;
      }
      a((bpi)localLinkedList.get(0), paramPhotosContent.No(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambc, paramInt2, false);
      AppMethodBeat.o(98909);
      return;
    }
    if (!dBA()) {}
    for (paramTimeLineObject = new b.c(paramString2, j);; paramTimeLineObject = null)
    {
      aw localaw;
      bpi localbpi;
      if (j == 4)
      {
        paramList = new ArrayList();
        localSparseArray1 = new SparseArray();
        localSparseArray2 = new SparseArray();
        paramInt2 = localObject.length - 1;
        i = 3;
        if (paramInt2 >= 0)
        {
          localObject = paramPhotosContent.No(paramInt2);
          ((TagImageView)localObject).setPosition(paramInt3);
          if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3) || (paramInt2 == 4))
          {
            ((TagImageView)localObject).setVisibility(0);
            paramList.add(localObject);
            localaw = new aw();
            localaw.diQ = paramString1;
            localaw.index = i;
            localaw.xzo = paramList;
            localaw.xvU = paramBoolean2;
            localaw.position = paramInt3;
            ((TagImageView)localObject).setTag(localaw);
            if ((paramBoolean1) || (!dBA()))
            {
              localbpi = (bpi)localLinkedList.get(localaw.index);
              af.dtp().a(localbpi.Id, paramTimeLineObject);
              af.dtp().aop(localbpi.Id);
              a(localbpi, (QFadeImageView)localObject, paramInt1, parambc);
            }
            localSparseArray1.put(localaw.index, localLinkedList.get(localaw.index));
            localSparseArray2.put(localaw.index, localObject);
            i -= 1;
          }
          for (;;)
          {
            paramInt2 -= 1;
            break;
            ((TagImageView)localObject).setVisibility(8);
            af.dtr().eo((View)localObject);
          }
        }
        if ((!paramBoolean1) && (dBA()) && (localSparseArray1.size() > 0)) {
          a(paramString2, localSparseArray1, localSparseArray2, paramInt1, parambc, j);
        }
        AppMethodBeat.o(98909);
        return;
      }
      paramList = new ArrayList();
      SparseArray localSparseArray1 = new SparseArray();
      SparseArray localSparseArray2 = new SparseArray();
      paramInt2 = localObject.length - 1;
      if (paramInt2 >= 0)
      {
        localObject = paramPhotosContent.No(paramInt2);
        ((TagImageView)localObject).setPosition(paramInt3);
        if (paramInt2 < localLinkedList.size())
        {
          ((TagImageView)localObject).setVisibility(0);
          paramList.add(localObject);
          localaw = new aw();
          localaw.diQ = paramString1;
          localaw.index = paramInt2;
          localaw.xzo = paramList;
          localaw.xvU = paramBoolean2;
          localaw.position = paramInt3;
          ((TagImageView)localObject).setTag(localaw);
          if ((paramBoolean1) || (!dBA()))
          {
            localbpi = (bpi)localLinkedList.get(localaw.index);
            af.dtp().a(localbpi.Id, paramTimeLineObject);
            af.dtp().aop(localbpi.Id);
            a(localbpi, (QFadeImageView)localObject, paramInt1, parambc);
          }
          localSparseArray1.put(localaw.index, localLinkedList.get(localaw.index));
          localSparseArray2.put(localaw.index, localObject);
        }
        for (;;)
        {
          paramInt2 -= 1;
          break;
          ((TagImageView)localObject).setVisibility(8);
          af.dtr().eo((View)localObject);
        }
      }
      if ((!paramBoolean1) && (dBA()) && (localSparseArray1.size() > 0)) {
        a(paramString2, localSparseArray1, localSparseArray2, paramInt1, parambc, j);
      }
      AppMethodBeat.o(98909);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ay
 * JD-Core Version:    0.7.0.1
 */