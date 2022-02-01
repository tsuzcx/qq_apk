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
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class be
{
  static double EGA = -1.0D;
  static double EGB = -1.0D;
  static double EGC = -1.0D;
  static double EGD = -1.0D;
  static double EGE = -1.0D;
  private static boolean EGG;
  public static int EGH = -1;
  public static int[] EGv = { 0, 0, 1, 3, 6, 9 };
  public static int[] EGw = { 2131296652 };
  public static int[] EGx = { 2131296652, 2131296653, 2131296654 };
  public static int[] EGy = { 2131296652, 2131296653, 2131296654, 2131296655, 2131296656, 2131296657 };
  public static int[] EGz = { 2131296652, 2131296653, 2131296654, 2131296655, 2131296656, 2131296657, 2131296658, 2131296659, 2131296660 };
  private LinkedList<LinearLayout> EGF;
  private Context context;
  
  public be(Context paramContext)
  {
    AppMethodBeat.i(98907);
    this.EGF = new LinkedList();
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
    if (1 == ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.slb, 0)) {}
    for (boolean bool = true;; bool = false)
    {
      EGG = bool;
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
        EGG = true;
      }
      AppMethodBeat.o(98907);
      return;
    }
  }
  
  private static void a(cnb paramcnb, QFadeImageView paramQFadeImageView, int paramInt, bp parambp)
  {
    AppMethodBeat.i(98911);
    aj.faL().b(paramcnb, paramQFadeImageView, paramInt, parambp);
    AppMethodBeat.o(98911);
  }
  
  private void a(cnb paramcnb, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, bp parambp, int paramInt3, boolean paramBoolean2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(203618);
    a(paramcnb, paramQFadeImageView, paramString, paramInt1, paramInt2, paramBoolean1, parambp, paramInt3, paramBoolean2, new cnd(), paramSnsInfo);
    AppMethodBeat.o(203618);
  }
  
  private void a(cnb paramcnb, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, bp parambp, int paramInt3, boolean paramBoolean2, cnd paramcnd, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(203617);
    if (paramQFadeImageView == null)
    {
      Log.e("MicroMsg.SnsMultiLineImageLineMgr", "");
      AppMethodBeat.o(203617);
      return;
    }
    bc localbc = new bc();
    localbc.dJX = paramString;
    localbc.index = 0;
    paramString = new ArrayList();
    paramString.add(paramQFadeImageView);
    localbc.EDW = paramString;
    localbc.EAv = paramBoolean1;
    localbc.position = paramInt2;
    paramQFadeImageView.setTag(localbc);
    double d2 = 0.0D;
    double d1 = 0.0D;
    if ((paramInt3 == 10) && (paramBoolean2))
    {
      aj.faL().c(paramcnb, paramQFadeImageView, paramInt1, parambp);
      if (paramcnb.MsB != null)
      {
        d2 = paramcnb.MsB.Mto;
        d1 = paramcnb.MsB.Mtp;
      }
      if ((paramInt3 != 2) || (paramSnsInfo == null) || (!paramSnsInfo.isFinderAd())) {
        break label263;
      }
      paramcnb = n.a((int)d2, (int)d1, this.context, false);
      d1 = ((Integer)paramcnb.first).intValue();
      d2 = ((Integer)paramcnb.second).intValue();
    }
    for (;;)
    {
      label263:
      double d3;
      if ((paramQFadeImageView.getLayoutParams() instanceof FrameLayout.LayoutParams))
      {
        paramcnb = (FrameLayout.LayoutParams)paramQFadeImageView.getLayoutParams();
        if ((paramcnb.width == d1) && (paramcnb.height == d2))
        {
          AppMethodBeat.o(203617);
          return;
          aj.faL().a(paramcnb, paramQFadeImageView, paramInt1, parambp);
          break;
          if ((d2 > 0.0D) && (d1 > 0.0D))
          {
            double d4 = Math.min(EGB / d2, EGB / d1);
            d3 = d2 * d4;
            d4 = d1 * d4;
            d1 = d4;
            d2 = d3;
            if (d3 < EGC)
            {
              d1 = 1.0D * EGC / d3;
              d2 = d3 * d1;
              d1 = d4 * d1;
            }
            d3 = d1;
            d4 = d2;
            if (d1 < EGC)
            {
              d3 = 1.0D * EGC / d1;
              d4 = d2 * d3;
              d3 = d1 * d3;
            }
            d1 = d4;
            if (d4 > EGB) {
              d1 = EGB;
            }
            d2 = d3;
            if (d3 > EGB) {
              d2 = EGB;
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
            if ((paramcnd == null) || (paramcnd.Mto <= 0.0F) || (paramcnd.Mtp <= 0.0F)) {
              break label538;
            }
            d1 = paramcnd.Mto;
            d2 = paramcnd.Mtp;
            break;
            d3 = EGA;
            d2 = EGA;
          }
        }
        paramQFadeImageView.setLayoutParams(new FrameLayout.LayoutParams((int)d1, (int)d2));
      }
      AppMethodBeat.o(203617);
      return;
      label538:
      d2 = d3;
    }
  }
  
  private static void a(String paramString, SparseArray<cnb> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, bp parambp, int paramInt2)
  {
    AppMethodBeat.i(98912);
    aj.faL().a(paramString, paramSparseArray, paramSparseArray1, paramInt1, parambp, paramInt2);
    AppMethodBeat.o(98912);
  }
  
  public static boolean fiv()
  {
    AppMethodBeat.i(98910);
    Log.d("MicroMsg.SnsMultiLineImageLineMgr", "enableGroupDownload_cmd: %d.", new Object[] { Integer.valueOf(EGH) });
    switch (EGH)
    {
    default: 
      boolean bool = CdnLogic.allowBatchImageDownload();
      Log.d("MicroMsg.SnsMultiLineImageLineMgr", "allowGroupDownload: %s, enableGroupDownload: %s.", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(EGG) });
      if ((bool) && (EGG))
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
    int[] arrayOfInt = EGz;
    if ((paramInt2 == 2) || (paramInt2 == 10)) {
      arrayOfInt = EGw;
    }
    int i;
    for (;;)
    {
      paramTimeLineObject = paramTimeLineObject.ContentObj.LoV;
      if (EGA < 0.0D)
      {
        EGA = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 160.0F);
        EGB = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 200.0F);
        EGC = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 44.0F);
        EGD = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 66.0F);
        EGE = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 300.0F);
      }
      i = paramTimeLineObject.size();
      if (i != 0) {
        break label226;
      }
      paramInt1 = 0;
      while (paramInt1 < arrayOfInt.length)
      {
        aj.faL().ff(paramPhotosContent.ZD(paramInt1));
        paramPhotosContent.ZD(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        arrayOfInt = EGx;
      } else if (paramInt2 == 4) {
        arrayOfInt = EGy;
      } else if (paramInt2 == 5) {
        arrayOfInt = EGz;
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
        TagImageView localTagImageView = paramPhotosContent.ZD(i);
        localTagImageView.setVisibility(8);
        aj.faL().ff(localTagImageView);
        paramPhotosContent.ZD(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.ZD(0).setVisibility(0);
      a((cnb)paramTimeLineObject.get(0), paramPhotosContent.ZD(0), paramString, paramInt1, paramInt3, paramBoolean1, parambp, paramInt2, paramBoolean2, null);
      AppMethodBeat.o(98908);
      return;
    }
    AppMethodBeat.o(98908);
  }
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, bp parambp, List<cnd> paramList, String paramString2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(203616);
    Object localObject = EGz;
    if ((paramInt2 == 2) || (paramInt2 == 10) || (paramInt2 == 13)) {
      localObject = EGw;
    }
    LinkedList localLinkedList;
    int j;
    for (;;)
    {
      localLinkedList = paramTimeLineObject.ContentObj.LoV;
      if (EGA < 0.0D)
      {
        EGA = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 160.0F);
        EGB = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 200.0F);
        EGC = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 44.0F);
        EGD = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 66.0F);
        EGE = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 300.0F);
      }
      j = localLinkedList.size();
      if (j != 0) {
        break label235;
      }
      paramInt1 = 0;
      while (paramInt1 < localObject.length)
      {
        aj.faL().ff(paramPhotosContent.ZD(paramInt1));
        paramPhotosContent.ZD(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        localObject = EGx;
      } else if (paramInt2 == 4) {
        localObject = EGy;
      } else if (paramInt2 == 5) {
        localObject = EGz;
      }
    }
    paramPhotosContent.setVisibility(8);
    AppMethodBeat.o(203616);
    return;
    label235:
    paramPhotosContent.setImageViewWidth(aj.fbb());
    paramPhotosContent.setVisibility(0);
    int i;
    if (j == 1)
    {
      i = 1;
      while (i < localObject.length)
      {
        paramTimeLineObject = paramPhotosContent.ZD(i);
        paramTimeLineObject.setVisibility(8);
        aj.faL().ff(paramTimeLineObject);
        paramPhotosContent.ZD(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.ZD(0).setVisibility(0);
      if ((paramList != null) && (paramList.size() > 0))
      {
        a((cnb)localLinkedList.get(0), paramPhotosContent.ZD(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambp, paramInt2, false, (cnd)paramList.get(0), paramSnsInfo);
        AppMethodBeat.o(203616);
        return;
      }
      a((cnb)localLinkedList.get(0), paramPhotosContent.ZD(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambp, paramInt2, false, paramSnsInfo);
      AppMethodBeat.o(203616);
      return;
    }
    if (!fiv()) {}
    for (paramTimeLineObject = new c.c(paramString2, j);; paramTimeLineObject = null)
    {
      bc localbc;
      cnb localcnb;
      if (j == 4)
      {
        paramList = new ArrayList();
        paramSnsInfo = new SparseArray();
        localSparseArray = new SparseArray();
        paramInt2 = localObject.length - 1;
        i = 3;
        if (paramInt2 >= 0)
        {
          localObject = paramPhotosContent.ZD(paramInt2);
          ((TagImageView)localObject).setPosition(paramInt3);
          if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3) || (paramInt2 == 4))
          {
            ((TagImageView)localObject).setVisibility(0);
            paramList.add(localObject);
            localbc = new bc();
            localbc.dJX = paramString1;
            localbc.index = i;
            localbc.EDW = paramList;
            localbc.EAv = paramBoolean2;
            localbc.position = paramInt3;
            ((TagImageView)localObject).setTag(localbc);
            if ((paramBoolean1) || (!fiv()))
            {
              localcnb = (cnb)localLinkedList.get(localbc.index);
              aj.faJ().a(localcnb.Id, paramTimeLineObject);
              aj.faJ().aOT(localcnb.Id);
              a(localcnb, (QFadeImageView)localObject, paramInt1, parambp);
            }
            paramSnsInfo.put(localbc.index, localLinkedList.get(localbc.index));
            localSparseArray.put(localbc.index, localObject);
            i -= 1;
          }
          for (;;)
          {
            paramInt2 -= 1;
            break;
            ((TagImageView)localObject).setVisibility(8);
            aj.faL().ff((View)localObject);
          }
        }
        if ((!paramBoolean1) && (fiv()) && (paramSnsInfo.size() > 0)) {
          a(paramString2, paramSnsInfo, localSparseArray, paramInt1, parambp, j);
        }
        AppMethodBeat.o(203616);
        return;
      }
      paramList = new ArrayList();
      paramSnsInfo = new SparseArray();
      SparseArray localSparseArray = new SparseArray();
      paramInt2 = localObject.length - 1;
      if (paramInt2 >= 0)
      {
        localObject = paramPhotosContent.ZD(paramInt2);
        ((TagImageView)localObject).setPosition(paramInt3);
        if (paramInt2 < localLinkedList.size())
        {
          ((TagImageView)localObject).setVisibility(0);
          paramList.add(localObject);
          localbc = new bc();
          localbc.dJX = paramString1;
          localbc.index = paramInt2;
          localbc.EDW = paramList;
          localbc.EAv = paramBoolean2;
          localbc.position = paramInt3;
          ((TagImageView)localObject).setTag(localbc);
          if ((paramBoolean1) || (!fiv()))
          {
            localcnb = (cnb)localLinkedList.get(localbc.index);
            aj.faJ().a(localcnb.Id, paramTimeLineObject);
            aj.faJ().aOT(localcnb.Id);
            a(localcnb, (QFadeImageView)localObject, paramInt1, parambp);
          }
          paramSnsInfo.put(localbc.index, localLinkedList.get(localbc.index));
          localSparseArray.put(localbc.index, localObject);
        }
        for (;;)
        {
          paramInt2 -= 1;
          break;
          ((TagImageView)localObject).setVisibility(8);
          aj.faL().ff((View)localObject);
        }
      }
      if ((!paramBoolean1) && (fiv()) && (paramSnsInfo.size() > 0)) {
        a(paramString2, paramSnsInfo, localSparseArray, paramInt1, parambp, j);
      }
      AppMethodBeat.o(203616);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.be
 * JD-Core Version:    0.7.0.1
 */