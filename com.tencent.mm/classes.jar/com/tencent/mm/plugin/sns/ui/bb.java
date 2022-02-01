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
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.c;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class bb
{
  public static int[] Axf = { 0, 0, 1, 3, 6, 9 };
  public static int[] Axg = { 2131296575 };
  public static int[] Axh = { 2131296575, 2131296576, 2131296577 };
  public static int[] Axi = { 2131296575, 2131296576, 2131296577, 2131296578, 2131296579, 2131296580 };
  public static int[] Axj = { 2131296575, 2131296576, 2131296577, 2131296578, 2131296579, 2131296580, 2131296581, 2131296582, 2131296583 };
  static double Axk = -1.0D;
  static double Axl = -1.0D;
  static double Axm = -1.0D;
  static double Axn = -1.0D;
  static double Axo = -1.0D;
  private static boolean Axq;
  public static int Axr = -1;
  private LinkedList<LinearLayout> Axp;
  private Context context;
  
  public bb(Context paramContext)
  {
    AppMethodBeat.i(98907);
    this.Axp = new LinkedList();
    this.context = paramContext;
    if ((this.context instanceof Activity))
    {
      paramContext = new DisplayMetrics();
      ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(paramContext);
      Point localPoint = new Point();
      localPoint.x = paramContext.widthPixels;
      localPoint.y = paramContext.heightPixels;
      ah.j(localPoint);
    }
    if (1 == ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qNZ, 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Axq = bool;
      if ((j.IS_FLAVOR_RED) || (j.DEBUG)) {
        Axq = true;
      }
      AppMethodBeat.o(98907);
      return;
    }
  }
  
  private static void a(bzh parambzh, QFadeImageView paramQFadeImageView, int paramInt, bk parambk)
  {
    AppMethodBeat.i(98911);
    ah.dXB().b(parambzh, paramQFadeImageView, paramInt, parambk);
    AppMethodBeat.o(98911);
  }
  
  private void a(bzh parambzh, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, bk parambk, int paramInt3, boolean paramBoolean2, p paramp)
  {
    AppMethodBeat.i(219918);
    a(parambzh, paramQFadeImageView, paramString, paramInt1, paramInt2, paramBoolean1, parambk, paramInt3, paramBoolean2, new bzj(), paramp);
    AppMethodBeat.o(219918);
  }
  
  private void a(bzh parambzh, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, bk parambk, int paramInt3, boolean paramBoolean2, bzj parambzj, p paramp)
  {
    AppMethodBeat.i(219917);
    if (paramQFadeImageView == null)
    {
      ae.e("MicroMsg.SnsMultiLineImageLineMgr", "");
      AppMethodBeat.o(219917);
      return;
    }
    az localaz = new az();
    localaz.dsN = paramString;
    localaz.index = 0;
    paramString = new ArrayList();
    paramString.add(paramQFadeImageView);
    localaz.AuK = paramString;
    localaz.Arr = paramBoolean1;
    localaz.position = paramInt2;
    paramQFadeImageView.setTag(localaz);
    double d2 = 0.0D;
    double d1 = 0.0D;
    if ((paramInt3 == 10) && (paramBoolean2))
    {
      ah.dXB().c(parambzh, paramQFadeImageView, paramInt1, parambk);
      if (parambzh.Hmm != null)
      {
        d2 = parambzh.Hmm.Hna;
        d1 = parambzh.Hmm.Hnb;
      }
      if ((paramInt3 != 2) || (paramp == null) || (!paramp.ecC())) {
        break label263;
      }
      parambzh = h.a((int)d2, (int)d1, this.context, false);
      d1 = ((Integer)parambzh.first).intValue();
      d2 = ((Integer)parambzh.second).intValue();
    }
    for (;;)
    {
      label263:
      double d3;
      if ((paramQFadeImageView.getLayoutParams() instanceof FrameLayout.LayoutParams))
      {
        parambzh = (FrameLayout.LayoutParams)paramQFadeImageView.getLayoutParams();
        if ((parambzh.width == d1) && (parambzh.height == d2))
        {
          AppMethodBeat.o(219917);
          return;
          ah.dXB().a(parambzh, paramQFadeImageView, paramInt1, parambk);
          break;
          if ((d2 > 0.0D) && (d1 > 0.0D))
          {
            double d4 = Math.min(Axl / d2, Axl / d1);
            d3 = d2 * d4;
            d4 = d1 * d4;
            d1 = d4;
            d2 = d3;
            if (d3 < Axm)
            {
              d1 = 1.0D * Axm / d3;
              d2 = d3 * d1;
              d1 = d4 * d1;
            }
            d3 = d1;
            d4 = d2;
            if (d1 < Axm)
            {
              d3 = 1.0D * Axm / d1;
              d4 = d2 * d3;
              d3 = d1 * d3;
            }
            d1 = d4;
            if (d4 > Axl) {
              d1 = Axl;
            }
            d2 = d3;
            if (d3 > Axl) {
              d2 = Axl;
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
            if ((parambzj == null) || (parambzj.Hna <= 0.0F) || (parambzj.Hnb <= 0.0F)) {
              break label538;
            }
            d1 = parambzj.Hna;
            d2 = parambzj.Hnb;
            break;
            d3 = Axk;
            d2 = Axk;
          }
        }
        paramQFadeImageView.setLayoutParams(new FrameLayout.LayoutParams((int)d1, (int)d2));
      }
      AppMethodBeat.o(219917);
      return;
      label538:
      d2 = d3;
    }
  }
  
  private static void a(String paramString, SparseArray<bzh> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, bk parambk, int paramInt2)
  {
    AppMethodBeat.i(98912);
    ah.dXB().a(paramString, paramSparseArray, paramSparseArray1, paramInt1, parambk, paramInt2);
    AppMethodBeat.o(98912);
  }
  
  public static boolean efV()
  {
    AppMethodBeat.i(98910);
    ae.d("MicroMsg.SnsMultiLineImageLineMgr", "enableGroupDownload_cmd: %d.", new Object[] { Integer.valueOf(Axr) });
    switch (Axr)
    {
    default: 
      boolean bool = CdnLogic.allowBatchImageDownload();
      ae.d("MicroMsg.SnsMultiLineImageLineMgr", "allowGroupDownload: %s, enableGroupDownload: %s.", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(Axq) });
      if ((bool) && (Axq))
      {
        AppMethodBeat.o(98910);
        return true;
      }
      break;
    case 1: 
      ae.d("MicroMsg.SnsMultiLineImageLineMgr", "enforce group download.");
      CdnLogic.setSnsImagePrivateProtocolAvalible(true);
      CdnLogic.setSnsImageStreamProtocolAvalible(true);
      AppMethodBeat.o(98910);
      return true;
    case 2: 
      ae.d("MicroMsg.SnsMultiLineImageLineMgr", "enforce single download.");
      AppMethodBeat.o(98910);
      return false;
    }
    ae.i("MicroMsg.SnsMultiLineImageLineMgr", "groupDownloadDisable!!!");
    AppMethodBeat.o(98910);
    return false;
  }
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, bk parambk, boolean paramBoolean2)
  {
    AppMethodBeat.i(98908);
    int[] arrayOfInt = Axj;
    if ((paramInt2 == 2) || (paramInt2 == 10)) {
      arrayOfInt = Axg;
    }
    int i;
    for (;;)
    {
      paramTimeLineObject = paramTimeLineObject.HUG.Gtx;
      if (Axk < 0.0D)
      {
        Axk = BackwardSupportUtil.b.h(this.context, 160.0F);
        Axl = BackwardSupportUtil.b.h(this.context, 200.0F);
        Axm = BackwardSupportUtil.b.h(this.context, 44.0F);
        Axn = BackwardSupportUtil.b.h(this.context, 66.0F);
        Axo = BackwardSupportUtil.b.h(this.context, 300.0F);
      }
      i = paramTimeLineObject.size();
      if (i != 0) {
        break label226;
      }
      paramInt1 = 0;
      while (paramInt1 < arrayOfInt.length)
      {
        ah.dXB().eQ(paramPhotosContent.RH(paramInt1));
        paramPhotosContent.RH(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        arrayOfInt = Axh;
      } else if (paramInt2 == 4) {
        arrayOfInt = Axi;
      } else if (paramInt2 == 5) {
        arrayOfInt = Axj;
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
        TagImageView localTagImageView = paramPhotosContent.RH(i);
        localTagImageView.setVisibility(8);
        ah.dXB().eQ(localTagImageView);
        paramPhotosContent.RH(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.RH(0).setVisibility(0);
      a((bzh)paramTimeLineObject.get(0), paramPhotosContent.RH(0), paramString, paramInt1, paramInt3, paramBoolean1, parambk, paramInt2, paramBoolean2, null);
      AppMethodBeat.o(98908);
      return;
    }
    AppMethodBeat.o(98908);
  }
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, bk parambk, List<bzj> paramList, String paramString2, p paramp)
  {
    AppMethodBeat.i(219916);
    Object localObject = Axj;
    if ((paramInt2 == 2) || (paramInt2 == 10) || (paramInt2 == 13)) {
      localObject = Axg;
    }
    LinkedList localLinkedList;
    int j;
    for (;;)
    {
      localLinkedList = paramTimeLineObject.HUG.Gtx;
      if (Axk < 0.0D)
      {
        Axk = BackwardSupportUtil.b.h(this.context, 160.0F);
        Axl = BackwardSupportUtil.b.h(this.context, 200.0F);
        Axm = BackwardSupportUtil.b.h(this.context, 44.0F);
        Axn = BackwardSupportUtil.b.h(this.context, 66.0F);
        Axo = BackwardSupportUtil.b.h(this.context, 300.0F);
      }
      j = localLinkedList.size();
      if (j != 0) {
        break label235;
      }
      paramInt1 = 0;
      while (paramInt1 < localObject.length)
      {
        ah.dXB().eQ(paramPhotosContent.RH(paramInt1));
        paramPhotosContent.RH(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        localObject = Axh;
      } else if (paramInt2 == 4) {
        localObject = Axi;
      } else if (paramInt2 == 5) {
        localObject = Axj;
      }
    }
    paramPhotosContent.setVisibility(8);
    AppMethodBeat.o(219916);
    return;
    label235:
    paramPhotosContent.setImageViewWidth(ah.dXP());
    paramPhotosContent.setVisibility(0);
    int i;
    if (j == 1)
    {
      i = 1;
      while (i < localObject.length)
      {
        paramTimeLineObject = paramPhotosContent.RH(i);
        paramTimeLineObject.setVisibility(8);
        ah.dXB().eQ(paramTimeLineObject);
        paramPhotosContent.RH(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.RH(0).setVisibility(0);
      if ((paramList != null) && (paramList.size() > 0))
      {
        a((bzh)localLinkedList.get(0), paramPhotosContent.RH(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambk, paramInt2, false, (bzj)paramList.get(0), paramp);
        AppMethodBeat.o(219916);
        return;
      }
      a((bzh)localLinkedList.get(0), paramPhotosContent.RH(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambk, paramInt2, false, paramp);
      AppMethodBeat.o(219916);
      return;
    }
    if (!efV()) {}
    for (paramTimeLineObject = new c.c(paramString2, j);; paramTimeLineObject = null)
    {
      az localaz;
      bzh localbzh;
      if (j == 4)
      {
        paramList = new ArrayList();
        paramp = new SparseArray();
        localSparseArray = new SparseArray();
        paramInt2 = localObject.length - 1;
        i = 3;
        if (paramInt2 >= 0)
        {
          localObject = paramPhotosContent.RH(paramInt2);
          ((TagImageView)localObject).setPosition(paramInt3);
          if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3) || (paramInt2 == 4))
          {
            ((TagImageView)localObject).setVisibility(0);
            paramList.add(localObject);
            localaz = new az();
            localaz.dsN = paramString1;
            localaz.index = i;
            localaz.AuK = paramList;
            localaz.Arr = paramBoolean2;
            localaz.position = paramInt3;
            ((TagImageView)localObject).setTag(localaz);
            if ((paramBoolean1) || (!efV()))
            {
              localbzh = (bzh)localLinkedList.get(localaz.index);
              ah.dXz().a(localbzh.Id, paramTimeLineObject);
              ah.dXz().azX(localbzh.Id);
              a(localbzh, (QFadeImageView)localObject, paramInt1, parambk);
            }
            paramp.put(localaz.index, localLinkedList.get(localaz.index));
            localSparseArray.put(localaz.index, localObject);
            i -= 1;
          }
          for (;;)
          {
            paramInt2 -= 1;
            break;
            ((TagImageView)localObject).setVisibility(8);
            ah.dXB().eQ((View)localObject);
          }
        }
        if ((!paramBoolean1) && (efV()) && (paramp.size() > 0)) {
          a(paramString2, paramp, localSparseArray, paramInt1, parambk, j);
        }
        AppMethodBeat.o(219916);
        return;
      }
      paramList = new ArrayList();
      paramp = new SparseArray();
      SparseArray localSparseArray = new SparseArray();
      paramInt2 = localObject.length - 1;
      if (paramInt2 >= 0)
      {
        localObject = paramPhotosContent.RH(paramInt2);
        ((TagImageView)localObject).setPosition(paramInt3);
        if (paramInt2 < localLinkedList.size())
        {
          ((TagImageView)localObject).setVisibility(0);
          paramList.add(localObject);
          localaz = new az();
          localaz.dsN = paramString1;
          localaz.index = paramInt2;
          localaz.AuK = paramList;
          localaz.Arr = paramBoolean2;
          localaz.position = paramInt3;
          ((TagImageView)localObject).setTag(localaz);
          if ((paramBoolean1) || (!efV()))
          {
            localbzh = (bzh)localLinkedList.get(localaz.index);
            ah.dXz().a(localbzh.Id, paramTimeLineObject);
            ah.dXz().azX(localbzh.Id);
            a(localbzh, (QFadeImageView)localObject, paramInt1, parambk);
          }
          paramp.put(localaz.index, localLinkedList.get(localaz.index));
          localSparseArray.put(localaz.index, localObject);
        }
        for (;;)
        {
          paramInt2 -= 1;
          break;
          ((TagImageView)localObject).setVisibility(8);
          ah.dXB().eQ((View)localObject);
        }
      }
      if ((!paramBoolean1) && (efV()) && (paramp.size() > 0)) {
        a(paramString2, paramp, localSparseArray, paramInt1, parambk, j);
      }
      AppMethodBeat.o(219916);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bb
 * JD-Core Version:    0.7.0.1
 */