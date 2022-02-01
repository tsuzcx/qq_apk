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
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.b.c;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class bb
{
  public static int[] AfT = { 0, 0, 1, 3, 6, 9 };
  public static int[] AfU = { 2131296575 };
  public static int[] AfV = { 2131296575, 2131296576, 2131296577 };
  public static int[] AfW = { 2131296575, 2131296576, 2131296577, 2131296578, 2131296579, 2131296580 };
  public static int[] AfX = { 2131296575, 2131296576, 2131296577, 2131296578, 2131296579, 2131296580, 2131296581, 2131296582, 2131296583 };
  static double AfY = -1.0D;
  static double AfZ = -1.0D;
  static double Aga = -1.0D;
  static double Agb = -1.0D;
  static double Agc = -1.0D;
  private static boolean Age;
  public static int Agf = -1;
  private LinkedList<LinearLayout> Agd;
  private Context context;
  
  public bb(Context paramContext)
  {
    AppMethodBeat.i(98907);
    this.Agd = new LinkedList();
    this.context = paramContext;
    if ((this.context instanceof Activity))
    {
      paramContext = new DisplayMetrics();
      ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(paramContext);
      Point localPoint = new Point();
      localPoint.x = paramContext.widthPixels;
      localPoint.y = paramContext.heightPixels;
      ag.i(localPoint);
    }
    if (1 == ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGt, 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Age = bool;
      if ((i.IS_FLAVOR_RED) || (i.DEBUG)) {
        Age = true;
      }
      AppMethodBeat.o(98907);
      return;
    }
  }
  
  private static void a(byn parambyn, QFadeImageView paramQFadeImageView, int paramInt, bj parambj)
  {
    AppMethodBeat.i(98911);
    ag.dUb().b(parambyn, paramQFadeImageView, paramInt, parambj);
    AppMethodBeat.o(98911);
  }
  
  private static void a(byn parambyn, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, bj parambj, int paramInt3, boolean paramBoolean2)
  {
    AppMethodBeat.i(98914);
    a(parambyn, paramQFadeImageView, paramString, paramInt1, paramInt2, paramBoolean1, parambj, paramInt3, paramBoolean2, new byp());
    AppMethodBeat.o(98914);
  }
  
  private static void a(byn parambyn, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, bj parambj, int paramInt3, boolean paramBoolean2, byp parambyp)
  {
    AppMethodBeat.i(98913);
    if (paramQFadeImageView == null)
    {
      ad.e("MicroMsg.SnsMultiLineImageLineMgr", "");
      AppMethodBeat.o(98913);
      return;
    }
    az localaz = new az();
    localaz.drH = paramString;
    localaz.index = 0;
    paramString = new ArrayList();
    paramString.add(paramQFadeImageView);
    localaz.Ady = paramString;
    localaz.Aae = paramBoolean1;
    localaz.position = paramInt2;
    paramQFadeImageView.setTag(localaz);
    double d2 = 0.0D;
    double d1 = 0.0D;
    double d3;
    if ((paramInt3 == 10) && (paramBoolean2))
    {
      ag.dUb().c(parambyn, paramQFadeImageView, paramInt1, parambj);
      if (parambyn.GSL != null)
      {
        d2 = parambyn.GSL.GTz;
        d1 = parambyn.GSL.GTA;
      }
      if ((d2 <= 0.0D) || (d1 <= 0.0D)) {
        break label437;
      }
      double d4 = Math.min(AfZ / d2, AfZ / d1);
      d3 = d2 * d4;
      d4 = d1 * d4;
      d1 = d4;
      d2 = d3;
      if (d3 < Aga)
      {
        d1 = 1.0D * Aga / d3;
        d2 = d3 * d1;
        d1 = d4 * d1;
      }
      d3 = d1;
      d4 = d2;
      if (d1 < Aga)
      {
        d3 = 1.0D * Aga / d1;
        d4 = d2 * d3;
        d3 = d1 * d3;
      }
      d1 = d4;
      if (d4 > AfZ) {
        d1 = AfZ;
      }
      d2 = d3;
      if (d3 > AfZ) {
        d2 = AfZ;
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
      if ((parambyp == null) || (parambyp.GTz <= 0.0F) || (parambyp.GTA <= 0.0F)) {
        break label473;
      }
      d1 = parambyp.GTz;
    }
    label437:
    label473:
    for (d2 = parambyp.GTA;; d2 = d3)
    {
      if ((paramQFadeImageView.getLayoutParams() instanceof FrameLayout.LayoutParams))
      {
        parambyn = (FrameLayout.LayoutParams)paramQFadeImageView.getLayoutParams();
        if ((parambyn.width == d1) && (parambyn.height == d2))
        {
          AppMethodBeat.o(98913);
          return;
          ag.dUb().a(parambyn, paramQFadeImageView, paramInt1, parambj);
          break;
          d3 = AfY;
          d2 = AfY;
          break label308;
        }
        paramQFadeImageView.setLayoutParams(new FrameLayout.LayoutParams((int)d1, (int)d2));
      }
      AppMethodBeat.o(98913);
      return;
    }
  }
  
  private static void a(String paramString, SparseArray<byn> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, bj parambj, int paramInt2)
  {
    AppMethodBeat.i(98912);
    ag.dUb().a(paramString, paramSparseArray, paramSparseArray1, paramInt1, parambj, paramInt2);
    AppMethodBeat.o(98912);
  }
  
  public static boolean eco()
  {
    AppMethodBeat.i(98910);
    ad.d("MicroMsg.SnsMultiLineImageLineMgr", "enableGroupDownload_cmd: %d.", new Object[] { Integer.valueOf(Agf) });
    switch (Agf)
    {
    default: 
      boolean bool = CdnLogic.allowBatchImageDownload();
      ad.d("MicroMsg.SnsMultiLineImageLineMgr", "allowGroupDownload: %s, enableGroupDownload: %s.", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(Age) });
      if ((bool) && (Age))
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
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, bj parambj, boolean paramBoolean2)
  {
    AppMethodBeat.i(98908);
    int[] arrayOfInt = AfX;
    if ((paramInt2 == 2) || (paramInt2 == 10)) {
      arrayOfInt = AfU;
    }
    int i;
    for (;;)
    {
      paramTimeLineObject = paramTimeLineObject.HAT.GaQ;
      if (AfY < 0.0D)
      {
        AfY = BackwardSupportUtil.b.g(this.context, 160.0F);
        AfZ = BackwardSupportUtil.b.g(this.context, 200.0F);
        Aga = BackwardSupportUtil.b.g(this.context, 44.0F);
        Agb = BackwardSupportUtil.b.g(this.context, 66.0F);
        Agc = BackwardSupportUtil.b.g(this.context, 300.0F);
      }
      i = paramTimeLineObject.size();
      if (i != 0) {
        break label226;
      }
      paramInt1 = 0;
      while (paramInt1 < arrayOfInt.length)
      {
        ag.dUb().eR(paramPhotosContent.Ra(paramInt1));
        paramPhotosContent.Ra(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        arrayOfInt = AfV;
      } else if (paramInt2 == 4) {
        arrayOfInt = AfW;
      } else if (paramInt2 == 5) {
        arrayOfInt = AfX;
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
        TagImageView localTagImageView = paramPhotosContent.Ra(i);
        localTagImageView.setVisibility(8);
        ag.dUb().eR(localTagImageView);
        paramPhotosContent.Ra(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.Ra(0).setVisibility(0);
      a((byn)paramTimeLineObject.get(0), paramPhotosContent.Ra(0), paramString, paramInt1, paramInt3, paramBoolean1, parambj, paramInt2, paramBoolean2);
      AppMethodBeat.o(98908);
      return;
    }
    AppMethodBeat.o(98908);
  }
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, bj parambj, List<byp> paramList, String paramString2)
  {
    AppMethodBeat.i(98909);
    Object localObject = AfX;
    if ((paramInt2 == 2) || (paramInt2 == 10) || (paramInt2 == 13)) {
      localObject = AfU;
    }
    LinkedList localLinkedList;
    int j;
    for (;;)
    {
      localLinkedList = paramTimeLineObject.HAT.GaQ;
      if (AfY < 0.0D)
      {
        AfY = BackwardSupportUtil.b.g(this.context, 160.0F);
        AfZ = BackwardSupportUtil.b.g(this.context, 200.0F);
        Aga = BackwardSupportUtil.b.g(this.context, 44.0F);
        Agb = BackwardSupportUtil.b.g(this.context, 66.0F);
        Agc = BackwardSupportUtil.b.g(this.context, 300.0F);
      }
      j = localLinkedList.size();
      if (j != 0) {
        break label235;
      }
      paramInt1 = 0;
      while (paramInt1 < localObject.length)
      {
        ag.dUb().eR(paramPhotosContent.Ra(paramInt1));
        paramPhotosContent.Ra(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        localObject = AfV;
      } else if (paramInt2 == 4) {
        localObject = AfW;
      } else if (paramInt2 == 5) {
        localObject = AfX;
      }
    }
    paramPhotosContent.setVisibility(8);
    AppMethodBeat.o(98909);
    return;
    label235:
    paramPhotosContent.setImageViewWidth(ag.dUp());
    paramPhotosContent.setVisibility(0);
    int i;
    if (j == 1)
    {
      i = 1;
      while (i < localObject.length)
      {
        paramTimeLineObject = paramPhotosContent.Ra(i);
        paramTimeLineObject.setVisibility(8);
        ag.dUb().eR(paramTimeLineObject);
        paramPhotosContent.Ra(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.Ra(0).setVisibility(0);
      if ((paramList != null) && (paramList.size() > 0))
      {
        a((byn)localLinkedList.get(0), paramPhotosContent.Ra(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambj, paramInt2, false, (byp)paramList.get(0));
        AppMethodBeat.o(98909);
        return;
      }
      a((byn)localLinkedList.get(0), paramPhotosContent.Ra(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambj, paramInt2, false);
      AppMethodBeat.o(98909);
      return;
    }
    if (!eco()) {}
    for (paramTimeLineObject = new b.c(paramString2, j);; paramTimeLineObject = null)
    {
      az localaz;
      byn localbyn;
      if (j == 4)
      {
        paramList = new ArrayList();
        localSparseArray1 = new SparseArray();
        localSparseArray2 = new SparseArray();
        paramInt2 = localObject.length - 1;
        i = 3;
        if (paramInt2 >= 0)
        {
          localObject = paramPhotosContent.Ra(paramInt2);
          ((TagImageView)localObject).setPosition(paramInt3);
          if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3) || (paramInt2 == 4))
          {
            ((TagImageView)localObject).setVisibility(0);
            paramList.add(localObject);
            localaz = new az();
            localaz.drH = paramString1;
            localaz.index = i;
            localaz.Ady = paramList;
            localaz.Aae = paramBoolean2;
            localaz.position = paramInt3;
            ((TagImageView)localObject).setTag(localaz);
            if ((paramBoolean1) || (!eco()))
            {
              localbyn = (byn)localLinkedList.get(localaz.index);
              ag.dTZ().a(localbyn.Id, paramTimeLineObject);
              ag.dTZ().ayG(localbyn.Id);
              a(localbyn, (QFadeImageView)localObject, paramInt1, parambj);
            }
            localSparseArray1.put(localaz.index, localLinkedList.get(localaz.index));
            localSparseArray2.put(localaz.index, localObject);
            i -= 1;
          }
          for (;;)
          {
            paramInt2 -= 1;
            break;
            ((TagImageView)localObject).setVisibility(8);
            ag.dUb().eR((View)localObject);
          }
        }
        if ((!paramBoolean1) && (eco()) && (localSparseArray1.size() > 0)) {
          a(paramString2, localSparseArray1, localSparseArray2, paramInt1, parambj, j);
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
        localObject = paramPhotosContent.Ra(paramInt2);
        ((TagImageView)localObject).setPosition(paramInt3);
        if (paramInt2 < localLinkedList.size())
        {
          ((TagImageView)localObject).setVisibility(0);
          paramList.add(localObject);
          localaz = new az();
          localaz.drH = paramString1;
          localaz.index = paramInt2;
          localaz.Ady = paramList;
          localaz.Aae = paramBoolean2;
          localaz.position = paramInt3;
          ((TagImageView)localObject).setTag(localaz);
          if ((paramBoolean1) || (!eco()))
          {
            localbyn = (byn)localLinkedList.get(localaz.index);
            ag.dTZ().a(localbyn.Id, paramTimeLineObject);
            ag.dTZ().ayG(localbyn.Id);
            a(localbyn, (QFadeImageView)localObject, paramInt1, parambj);
          }
          localSparseArray1.put(localaz.index, localLinkedList.get(localaz.index));
          localSparseArray2.put(localaz.index, localObject);
        }
        for (;;)
        {
          paramInt2 -= 1;
          break;
          ((TagImageView)localObject).setVisibility(8);
          ag.dUb().eR((View)localObject);
        }
      }
      if ((!paramBoolean1) && (eco()) && (localSparseArray1.size() > 0)) {
        a(paramString2, localSparseArray1, localSparseArray2, paramInt1, parambj, j);
      }
      AppMethodBeat.o(98909);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bb
 * JD-Core Version:    0.7.0.1
 */