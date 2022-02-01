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
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ay
{
  public static int[] yOA = { 2131296575, 2131296576, 2131296577, 2131296578, 2131296579, 2131296580 };
  public static int[] yOB = { 2131296575, 2131296576, 2131296577, 2131296578, 2131296579, 2131296580, 2131296581, 2131296582, 2131296583 };
  static double yOC = -1.0D;
  static double yOD = -1.0D;
  static double yOE = -1.0D;
  static double yOF = -1.0D;
  static double yOG = -1.0D;
  private static boolean yOI;
  public static int yOJ = -1;
  public static int[] yOx = { 0, 0, 1, 3, 6, 9 };
  public static int[] yOy = { 2131296575 };
  public static int[] yOz = { 2131296575, 2131296576, 2131296577 };
  private Context context;
  private LinkedList<LinearLayout> yOH;
  
  public ay(Context paramContext)
  {
    AppMethodBeat.i(98907);
    this.yOH = new LinkedList();
    this.context = paramContext;
    if ((this.context instanceof Activity))
    {
      paramContext = new DisplayMetrics();
      ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(paramContext);
      Point localPoint = new Point();
      localPoint.x = paramContext.widthPixels;
      localPoint.y = paramContext.heightPixels;
      af.h(localPoint);
    }
    if (1 == ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qaU, 0)) {}
    for (boolean bool = true;; bool = false)
    {
      yOI = bool;
      if ((h.IS_FLAVOR_RED) || (h.DEBUG)) {
        yOI = true;
      }
      AppMethodBeat.o(98907);
      return;
    }
  }
  
  private static void a(btz parambtz, QFadeImageView paramQFadeImageView, int paramInt, bf parambf)
  {
    AppMethodBeat.i(98911);
    af.dHO().b(parambtz, paramQFadeImageView, paramInt, parambf);
    AppMethodBeat.o(98911);
  }
  
  private static void a(btz parambtz, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, bf parambf, int paramInt3, boolean paramBoolean2)
  {
    AppMethodBeat.i(98914);
    a(parambtz, paramQFadeImageView, paramString, paramInt1, paramInt2, paramBoolean1, parambf, paramInt3, paramBoolean2, new bub());
    AppMethodBeat.o(98914);
  }
  
  private static void a(btz parambtz, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, bf parambf, int paramInt3, boolean paramBoolean2, bub parambub)
  {
    AppMethodBeat.i(98913);
    if (paramQFadeImageView == null)
    {
      ac.e("MicroMsg.SnsMultiLineImageLineMgr", "");
      AppMethodBeat.o(98913);
      return;
    }
    aw localaw = new aw();
    localaw.dgl = paramString;
    localaw.index = 0;
    paramString = new ArrayList();
    paramString.add(paramQFadeImageView);
    localaw.yMc = paramString;
    localaw.yIK = paramBoolean1;
    localaw.position = paramInt2;
    paramQFadeImageView.setTag(localaw);
    double d2 = 0.0D;
    double d1 = 0.0D;
    double d3;
    if ((paramInt3 == 10) && (paramBoolean2))
    {
      af.dHO().c(parambtz, paramQFadeImageView, paramInt1, parambf);
      if (parambtz.Fjk != null)
      {
        d2 = parambtz.Fjk.FjY;
        d1 = parambtz.Fjk.FjZ;
      }
      if ((d2 <= 0.0D) || (d1 <= 0.0D)) {
        break label437;
      }
      double d4 = Math.min(yOD / d2, yOD / d1);
      d3 = d2 * d4;
      d4 = d1 * d4;
      d1 = d4;
      d2 = d3;
      if (d3 < yOE)
      {
        d1 = 1.0D * yOE / d3;
        d2 = d3 * d1;
        d1 = d4 * d1;
      }
      d3 = d1;
      d4 = d2;
      if (d1 < yOE)
      {
        d3 = 1.0D * yOE / d1;
        d4 = d2 * d3;
        d3 = d1 * d3;
      }
      d1 = d4;
      if (d4 > yOD) {
        d1 = yOD;
      }
      d2 = d3;
      if (d3 > yOD) {
        d2 = yOD;
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
      if ((parambub == null) || (parambub.FjY <= 0.0F) || (parambub.FjZ <= 0.0F)) {
        break label473;
      }
      d1 = parambub.FjY;
    }
    label437:
    label473:
    for (d2 = parambub.FjZ;; d2 = d3)
    {
      if ((paramQFadeImageView.getLayoutParams() instanceof FrameLayout.LayoutParams))
      {
        parambtz = (FrameLayout.LayoutParams)paramQFadeImageView.getLayoutParams();
        if ((parambtz.width == d1) && (parambtz.height == d2))
        {
          AppMethodBeat.o(98913);
          return;
          af.dHO().a(parambtz, paramQFadeImageView, paramInt1, parambf);
          break;
          d3 = yOC;
          d2 = yOC;
          break label308;
        }
        paramQFadeImageView.setLayoutParams(new FrameLayout.LayoutParams((int)d1, (int)d2));
      }
      AppMethodBeat.o(98913);
      return;
    }
  }
  
  private static void a(String paramString, SparseArray<btz> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, bf parambf, int paramInt2)
  {
    AppMethodBeat.i(98912);
    af.dHO().a(paramString, paramSparseArray, paramSparseArray1, paramInt1, parambf, paramInt2);
    AppMethodBeat.o(98912);
  }
  
  public static boolean dPX()
  {
    AppMethodBeat.i(98910);
    ac.d("MicroMsg.SnsMultiLineImageLineMgr", "enableGroupDownload_cmd: %d.", new Object[] { Integer.valueOf(yOJ) });
    switch (yOJ)
    {
    default: 
      boolean bool = CdnLogic.allowBatchImageDownload();
      ac.d("MicroMsg.SnsMultiLineImageLineMgr", "allowGroupDownload: %s, enableGroupDownload: %s.", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(yOI) });
      if ((bool) && (yOI))
      {
        AppMethodBeat.o(98910);
        return true;
      }
      break;
    case 1: 
      ac.d("MicroMsg.SnsMultiLineImageLineMgr", "enforce group download.");
      CdnLogic.setSnsImagePrivateProtocolAvalible(true);
      CdnLogic.setSnsImageStreamProtocolAvalible(true);
      AppMethodBeat.o(98910);
      return true;
    case 2: 
      ac.d("MicroMsg.SnsMultiLineImageLineMgr", "enforce single download.");
      AppMethodBeat.o(98910);
      return false;
    }
    ac.i("MicroMsg.SnsMultiLineImageLineMgr", "groupDownloadDisable!!!");
    AppMethodBeat.o(98910);
    return false;
  }
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, bf parambf, boolean paramBoolean2)
  {
    AppMethodBeat.i(98908);
    int[] arrayOfInt = yOB;
    if ((paramInt2 == 2) || (paramInt2 == 10)) {
      arrayOfInt = yOy;
    }
    int i;
    for (;;)
    {
      paramTimeLineObject = paramTimeLineObject.FQo.Etz;
      if (yOC < 0.0D)
      {
        yOC = BackwardSupportUtil.b.g(this.context, 160.0F);
        yOD = BackwardSupportUtil.b.g(this.context, 200.0F);
        yOE = BackwardSupportUtil.b.g(this.context, 44.0F);
        yOF = BackwardSupportUtil.b.g(this.context, 66.0F);
        yOG = BackwardSupportUtil.b.g(this.context, 300.0F);
      }
      i = paramTimeLineObject.size();
      if (i != 0) {
        break label226;
      }
      paramInt1 = 0;
      while (paramInt1 < arrayOfInt.length)
      {
        af.dHO().eB(paramPhotosContent.Pr(paramInt1));
        paramPhotosContent.Pr(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        arrayOfInt = yOz;
      } else if (paramInt2 == 4) {
        arrayOfInt = yOA;
      } else if (paramInt2 == 5) {
        arrayOfInt = yOB;
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
        TagImageView localTagImageView = paramPhotosContent.Pr(i);
        localTagImageView.setVisibility(8);
        af.dHO().eB(localTagImageView);
        paramPhotosContent.Pr(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.Pr(0).setVisibility(0);
      a((btz)paramTimeLineObject.get(0), paramPhotosContent.Pr(0), paramString, paramInt1, paramInt3, paramBoolean1, parambf, paramInt2, paramBoolean2);
      AppMethodBeat.o(98908);
      return;
    }
    AppMethodBeat.o(98908);
  }
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, bf parambf, List<bub> paramList, String paramString2)
  {
    AppMethodBeat.i(98909);
    Object localObject = yOB;
    if ((paramInt2 == 2) || (paramInt2 == 10) || (paramInt2 == 13)) {
      localObject = yOy;
    }
    LinkedList localLinkedList;
    int j;
    for (;;)
    {
      localLinkedList = paramTimeLineObject.FQo.Etz;
      if (yOC < 0.0D)
      {
        yOC = BackwardSupportUtil.b.g(this.context, 160.0F);
        yOD = BackwardSupportUtil.b.g(this.context, 200.0F);
        yOE = BackwardSupportUtil.b.g(this.context, 44.0F);
        yOF = BackwardSupportUtil.b.g(this.context, 66.0F);
        yOG = BackwardSupportUtil.b.g(this.context, 300.0F);
      }
      j = localLinkedList.size();
      if (j != 0) {
        break label235;
      }
      paramInt1 = 0;
      while (paramInt1 < localObject.length)
      {
        af.dHO().eB(paramPhotosContent.Pr(paramInt1));
        paramPhotosContent.Pr(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        localObject = yOz;
      } else if (paramInt2 == 4) {
        localObject = yOA;
      } else if (paramInt2 == 5) {
        localObject = yOB;
      }
    }
    paramPhotosContent.setVisibility(8);
    AppMethodBeat.o(98909);
    return;
    label235:
    paramPhotosContent.setImageViewWidth(af.dIc());
    paramPhotosContent.setVisibility(0);
    int i;
    if (j == 1)
    {
      i = 1;
      while (i < localObject.length)
      {
        paramTimeLineObject = paramPhotosContent.Pr(i);
        paramTimeLineObject.setVisibility(8);
        af.dHO().eB(paramTimeLineObject);
        paramPhotosContent.Pr(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.Pr(0).setVisibility(0);
      if ((paramList != null) && (paramList.size() > 0))
      {
        a((btz)localLinkedList.get(0), paramPhotosContent.Pr(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambf, paramInt2, false, (bub)paramList.get(0));
        AppMethodBeat.o(98909);
        return;
      }
      a((btz)localLinkedList.get(0), paramPhotosContent.Pr(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambf, paramInt2, false);
      AppMethodBeat.o(98909);
      return;
    }
    if (!dPX()) {}
    for (paramTimeLineObject = new b.c(paramString2, j);; paramTimeLineObject = null)
    {
      aw localaw;
      btz localbtz;
      if (j == 4)
      {
        paramList = new ArrayList();
        localSparseArray1 = new SparseArray();
        localSparseArray2 = new SparseArray();
        paramInt2 = localObject.length - 1;
        i = 3;
        if (paramInt2 >= 0)
        {
          localObject = paramPhotosContent.Pr(paramInt2);
          ((TagImageView)localObject).setPosition(paramInt3);
          if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3) || (paramInt2 == 4))
          {
            ((TagImageView)localObject).setVisibility(0);
            paramList.add(localObject);
            localaw = new aw();
            localaw.dgl = paramString1;
            localaw.index = i;
            localaw.yMc = paramList;
            localaw.yIK = paramBoolean2;
            localaw.position = paramInt3;
            ((TagImageView)localObject).setTag(localaw);
            if ((paramBoolean1) || (!dPX()))
            {
              localbtz = (btz)localLinkedList.get(localaw.index);
              af.dHM().a(localbtz.Id, paramTimeLineObject);
              af.dHM().atB(localbtz.Id);
              a(localbtz, (QFadeImageView)localObject, paramInt1, parambf);
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
            af.dHO().eB((View)localObject);
          }
        }
        if ((!paramBoolean1) && (dPX()) && (localSparseArray1.size() > 0)) {
          a(paramString2, localSparseArray1, localSparseArray2, paramInt1, parambf, j);
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
        localObject = paramPhotosContent.Pr(paramInt2);
        ((TagImageView)localObject).setPosition(paramInt3);
        if (paramInt2 < localLinkedList.size())
        {
          ((TagImageView)localObject).setVisibility(0);
          paramList.add(localObject);
          localaw = new aw();
          localaw.dgl = paramString1;
          localaw.index = paramInt2;
          localaw.yMc = paramList;
          localaw.yIK = paramBoolean2;
          localaw.position = paramInt3;
          ((TagImageView)localObject).setTag(localaw);
          if ((paramBoolean1) || (!dPX()))
          {
            localbtz = (btz)localLinkedList.get(localaw.index);
            af.dHM().a(localbtz.Id, paramTimeLineObject);
            af.dHM().atB(localbtz.Id);
            a(localbtz, (QFadeImageView)localObject, paramInt1, parambf);
          }
          localSparseArray1.put(localaw.index, localLinkedList.get(localaw.index));
          localSparseArray2.put(localaw.index, localObject);
        }
        for (;;)
        {
          paramInt2 -= 1;
          break;
          ((TagImageView)localObject).setVisibility(8);
          af.dHO().eB((View)localObject);
        }
      }
      if ((!paramBoolean1) && (dPX()) && (localSparseArray1.size() > 0)) {
        a(paramString2, localSparseArray1, localSparseArray2, paramInt1, parambf, j);
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