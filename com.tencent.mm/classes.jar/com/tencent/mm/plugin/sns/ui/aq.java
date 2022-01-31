package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.model.b.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class aq
{
  public static int[] rTg = { 0, 0, 1, 3, 6, 9 };
  public static int[] rTh = { 2131827994 };
  public static int[] rTi = { 2131827994, 2131828131, 2131828132 };
  public static int[] rTj = { 2131827994, 2131828131, 2131828132, 2131828133, 2131828134, 2131828135 };
  public static int[] rTk = { 2131827994, 2131828131, 2131828132, 2131828133, 2131828134, 2131828135, 2131828136, 2131828137, 2131828138 };
  static double rTl = -1.0D;
  static double rTm = -1.0D;
  static double rTn = -1.0D;
  static double rTo = -1.0D;
  static double rTp = -1.0D;
  public static int rTs = -1;
  public static int rTt = -1;
  private Context context;
  private LinkedList<LinearLayout> rTq;
  private boolean rTr;
  
  public aq(Context paramContext)
  {
    AppMethodBeat.i(39115);
    this.rTq = new LinkedList();
    if (1 == com.tencent.mm.m.g.Nq().getInt("SnsGroupImageDownloadSwitch", 0)) {
      bool = true;
    }
    this.rTr = bool;
    this.context = paramContext;
    if (((f.IS_FLAVOR_RED) || (f.DEBUG)) && (-1 == rTs))
    {
      ab.i("MicroMsg.SnsMultiLineImageLineMgr", "inner version, open sns batch image download.");
      rTs = 1;
    }
    AppMethodBeat.o(39115);
  }
  
  private static void a(bcs parambcs, QFadeImageView paramQFadeImageView, int paramInt, az paramaz)
  {
    AppMethodBeat.i(39119);
    ag.cpc().b(parambcs, paramQFadeImageView, paramInt, paramaz);
    AppMethodBeat.o(39119);
  }
  
  private static void a(bcs parambcs, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, az paramaz, int paramInt3, boolean paramBoolean2)
  {
    AppMethodBeat.i(39122);
    a(parambcs, paramQFadeImageView, paramString, paramInt1, paramInt2, paramBoolean1, paramaz, paramInt3, paramBoolean2, new bcu());
    AppMethodBeat.o(39122);
  }
  
  private static void a(bcs parambcs, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, az paramaz, int paramInt3, boolean paramBoolean2, bcu parambcu)
  {
    AppMethodBeat.i(39121);
    if (paramQFadeImageView == null)
    {
      ab.e("MicroMsg.SnsMultiLineImageLineMgr", "");
      AppMethodBeat.o(39121);
      return;
    }
    ao localao = new ao();
    localao.ctV = paramString;
    localao.index = 0;
    paramString = new ArrayList();
    paramString.add(paramQFadeImageView);
    localao.rQS = paramString;
    localao.rNW = paramBoolean1;
    localao.position = paramInt2;
    paramQFadeImageView.setTag(localao);
    double d2 = 0.0D;
    double d1 = 0.0D;
    double d3;
    if ((paramInt3 == 10) && (paramBoolean2))
    {
      ag.cpc().c(parambcs, paramQFadeImageView, paramInt1, paramaz);
      if (parambcs.xrV != null)
      {
        d2 = parambcs.xrV.xsH;
        d1 = parambcs.xrV.xsI;
      }
      if ((d2 <= 0.0D) || (d1 <= 0.0D)) {
        break label437;
      }
      double d4 = Math.min(rTm / d2, rTm / d1);
      d3 = d2 * d4;
      d4 = d1 * d4;
      d1 = d4;
      d2 = d3;
      if (d3 < rTn)
      {
        d1 = 1.0D * rTn / d3;
        d2 = d3 * d1;
        d1 = d4 * d1;
      }
      d3 = d1;
      d4 = d2;
      if (d1 < rTn)
      {
        d3 = 1.0D * rTn / d1;
        d4 = d2 * d3;
        d3 = d1 * d3;
      }
      d1 = d4;
      if (d4 > rTm) {
        d1 = rTm;
      }
      d2 = d3;
      if (d3 > rTm) {
        d2 = rTm;
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
      if ((parambcu == null) || (parambcu.xsH <= 0.0F) || (parambcu.xsI <= 0.0F)) {
        break label473;
      }
      d1 = parambcu.xsH;
    }
    label437:
    label473:
    for (d2 = parambcu.xsI;; d2 = d3)
    {
      if ((paramQFadeImageView.getLayoutParams() instanceof FrameLayout.LayoutParams))
      {
        parambcs = (FrameLayout.LayoutParams)paramQFadeImageView.getLayoutParams();
        if ((parambcs.width == d1) && (parambcs.height == d2))
        {
          AppMethodBeat.o(39121);
          return;
          ag.cpc().a(parambcs, paramQFadeImageView, paramInt1, paramaz);
          break;
          d3 = rTl;
          d2 = rTl;
          break label308;
        }
        paramQFadeImageView.setLayoutParams(new FrameLayout.LayoutParams((int)d1, (int)d2));
      }
      AppMethodBeat.o(39121);
      return;
    }
  }
  
  private static void a(String paramString, SparseArray<bcs> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, az paramaz, int paramInt2)
  {
    AppMethodBeat.i(145550);
    ag.cpc().a(paramString, paramSparseArray, paramSparseArray1, paramInt1, paramaz, paramInt2);
    AppMethodBeat.o(145550);
  }
  
  private boolean cvD()
  {
    AppMethodBeat.i(39118);
    ab.i("MicroMsg.SnsMultiLineImageLineMgr", "enableGroupDownload_cmd: %d.", new Object[] { Integer.valueOf(rTs) });
    switch (rTs)
    {
    default: 
      if (-1 != rTt) {
        if (1 != rTt) {
          break label171;
        }
      }
      break;
    }
    label171:
    for (boolean bool = true;; bool = false)
    {
      this.rTr = bool;
      bool = CdnLogic.getSnsImagePrivateProtocolAvalible();
      ab.d("MicroMsg.SnsMultiLineImageLineMgr", "EnablePrivateProtocol: %s, SnsGroupImageDownloadSwitch: %s.", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.rTr) });
      if ((!bool) || (!this.rTr)) {
        break;
      }
      ab.d("MicroMsg.SnsMultiLineImageLineMgr", "groupDownloadEnable!!!");
      AppMethodBeat.o(39118);
      return true;
      ab.i("MicroMsg.SnsMultiLineImageLineMgr", "enforce group download.");
      if (!CdnLogic.getSnsImagePrivateProtocolAvalible()) {
        CdnLogic.setSnsImagePrivateProtocolAvalible(true);
      }
      AppMethodBeat.o(39118);
      return true;
      ab.i("MicroMsg.SnsMultiLineImageLineMgr", "enforce single download.");
      AppMethodBeat.o(39118);
      return false;
    }
    ab.d("MicroMsg.SnsMultiLineImageLineMgr", "groupDownloadDisable!!!");
    AppMethodBeat.o(39118);
    return false;
  }
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, az paramaz, boolean paramBoolean2)
  {
    AppMethodBeat.i(39116);
    int[] arrayOfInt = rTk;
    if ((paramInt2 == 2) || (paramInt2 == 10)) {
      arrayOfInt = rTh;
    }
    int i;
    for (;;)
    {
      paramTimeLineObject = paramTimeLineObject.xTS.wOa;
      if (rTl < 0.0D)
      {
        rTl = BackwardSupportUtil.b.b(this.context, 160.0F);
        rTm = BackwardSupportUtil.b.b(this.context, 200.0F);
        rTn = BackwardSupportUtil.b.b(this.context, 44.0F);
        rTo = BackwardSupportUtil.b.b(this.context, 66.0F);
        rTp = BackwardSupportUtil.b.b(this.context, 300.0F);
      }
      i = paramTimeLineObject.size();
      if (i != 0) {
        break label226;
      }
      paramInt1 = 0;
      while (paramInt1 < arrayOfInt.length)
      {
        ag.cpc().dC(paramPhotosContent.EJ(paramInt1));
        paramPhotosContent.EJ(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        arrayOfInt = rTi;
      } else if (paramInt2 == 4) {
        arrayOfInt = rTj;
      } else if (paramInt2 == 5) {
        arrayOfInt = rTk;
      }
    }
    paramPhotosContent.setVisibility(8);
    AppMethodBeat.o(39116);
    return;
    label226:
    paramPhotosContent.setVisibility(0);
    if (i == 1)
    {
      i = 1;
      while (i < arrayOfInt.length)
      {
        TagImageView localTagImageView = paramPhotosContent.EJ(i);
        localTagImageView.setVisibility(8);
        ag.cpc().dC(localTagImageView);
        paramPhotosContent.EJ(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.EJ(0).setVisibility(0);
      a((bcs)paramTimeLineObject.get(0), paramPhotosContent.EJ(0), paramString, paramInt1, paramInt3, paramBoolean1, paramaz, paramInt2, paramBoolean2);
      AppMethodBeat.o(39116);
      return;
    }
    AppMethodBeat.o(39116);
  }
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, az paramaz, List<bcu> paramList, String paramString2)
  {
    AppMethodBeat.i(39117);
    Object localObject = rTk;
    if ((paramInt2 == 2) || (paramInt2 == 10) || (paramInt2 == 13)) {
      localObject = rTh;
    }
    LinkedList localLinkedList;
    int j;
    for (;;)
    {
      localLinkedList = paramTimeLineObject.xTS.wOa;
      if (rTl < 0.0D)
      {
        rTl = BackwardSupportUtil.b.b(this.context, 160.0F);
        rTm = BackwardSupportUtil.b.b(this.context, 200.0F);
        rTn = BackwardSupportUtil.b.b(this.context, 44.0F);
        rTo = BackwardSupportUtil.b.b(this.context, 66.0F);
        rTp = BackwardSupportUtil.b.b(this.context, 300.0F);
      }
      j = localLinkedList.size();
      if (j != 0) {
        break label235;
      }
      paramInt1 = 0;
      while (paramInt1 < localObject.length)
      {
        ag.cpc().dC(paramPhotosContent.EJ(paramInt1));
        paramPhotosContent.EJ(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        localObject = rTi;
      } else if (paramInt2 == 4) {
        localObject = rTj;
      } else if (paramInt2 == 5) {
        localObject = rTk;
      }
    }
    paramPhotosContent.setVisibility(8);
    AppMethodBeat.o(39117);
    return;
    label235:
    paramPhotosContent.setImageViewWidth(ag.cpn());
    paramPhotosContent.setVisibility(0);
    int i;
    if (j == 1)
    {
      i = 1;
      while (i < localObject.length)
      {
        paramTimeLineObject = paramPhotosContent.EJ(i);
        paramTimeLineObject.setVisibility(8);
        ag.cpc().dC(paramTimeLineObject);
        paramPhotosContent.EJ(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.EJ(0).setVisibility(0);
      if ((paramList != null) && (paramList.size() > 0))
      {
        a((bcs)localLinkedList.get(0), paramPhotosContent.EJ(0), paramString1, paramInt1, paramInt3, paramBoolean2, paramaz, paramInt2, false, (bcu)paramList.get(0));
        AppMethodBeat.o(39117);
        return;
      }
      a((bcs)localLinkedList.get(0), paramPhotosContent.EJ(0), paramString1, paramInt1, paramInt3, paramBoolean2, paramaz, paramInt2, false);
      AppMethodBeat.o(39117);
      return;
    }
    if (!cvD()) {}
    for (paramTimeLineObject = new b.c(paramString2, j);; paramTimeLineObject = null)
    {
      ao localao;
      bcs localbcs;
      if (j == 4)
      {
        paramList = new ArrayList();
        localSparseArray1 = new SparseArray();
        localSparseArray2 = new SparseArray();
        paramInt2 = localObject.length - 1;
        i = 3;
        if (paramInt2 >= 0)
        {
          localObject = paramPhotosContent.EJ(paramInt2);
          ((TagImageView)localObject).setPosition(paramInt3);
          if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3) || (paramInt2 == 4))
          {
            ((TagImageView)localObject).setVisibility(0);
            paramList.add(localObject);
            localao = new ao();
            localao.ctV = paramString1;
            localao.index = i;
            localao.rQS = paramList;
            localao.rNW = paramBoolean2;
            localao.position = paramInt3;
            ((TagImageView)localObject).setTag(localao);
            if ((paramBoolean1) || (!cvD()))
            {
              localbcs = (bcs)localLinkedList.get(localao.index);
              ag.cpa().a(localbcs.Id, paramTimeLineObject);
              ag.cpa().aah(localbcs.Id);
              a(localbcs, (QFadeImageView)localObject, paramInt1, paramaz);
            }
            localSparseArray1.put(localao.index, localLinkedList.get(localao.index));
            localSparseArray2.put(localao.index, localObject);
            i -= 1;
          }
          for (;;)
          {
            paramInt2 -= 1;
            break;
            ((TagImageView)localObject).setVisibility(8);
            ag.cpc().dC((View)localObject);
          }
        }
        if ((!paramBoolean1) && (cvD()) && (localSparseArray1.size() > 0)) {
          a(paramString2, localSparseArray1, localSparseArray2, paramInt1, paramaz, j);
        }
        AppMethodBeat.o(39117);
        return;
      }
      paramList = new ArrayList();
      SparseArray localSparseArray1 = new SparseArray();
      SparseArray localSparseArray2 = new SparseArray();
      paramInt2 = localObject.length - 1;
      if (paramInt2 >= 0)
      {
        localObject = paramPhotosContent.EJ(paramInt2);
        ((TagImageView)localObject).setPosition(paramInt3);
        if (paramInt2 < localLinkedList.size())
        {
          ((TagImageView)localObject).setVisibility(0);
          paramList.add(localObject);
          localao = new ao();
          localao.ctV = paramString1;
          localao.index = paramInt2;
          localao.rQS = paramList;
          localao.rNW = paramBoolean2;
          localao.position = paramInt3;
          ((TagImageView)localObject).setTag(localao);
          if ((paramBoolean1) || (!cvD()))
          {
            localbcs = (bcs)localLinkedList.get(localao.index);
            ag.cpa().a(localbcs.Id, paramTimeLineObject);
            ag.cpa().aah(localbcs.Id);
            a(localbcs, (QFadeImageView)localObject, paramInt1, paramaz);
          }
          localSparseArray1.put(localao.index, localLinkedList.get(localao.index));
          localSparseArray2.put(localao.index, localObject);
        }
        for (;;)
        {
          paramInt2 -= 1;
          break;
          ((TagImageView)localObject).setVisibility(8);
          ag.cpc().dC((View)localObject);
        }
      }
      if ((!paramBoolean1) && (cvD()) && (localSparseArray1.size() > 0)) {
        a(paramString2, localSparseArray1, localSparseArray2, paramInt1, paramaz, j);
      }
      AppMethodBeat.o(39117);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aq
 * JD-Core Version:    0.7.0.1
 */