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
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.c.c;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class bh
{
  public static int[] Run = { 0, 0, 1, 3, 6, 9 };
  public static int[] Ruo = { b.f.album_img_0 };
  public static int[] Rup = { b.f.album_img_0, b.f.album_img_1, b.f.album_img_2 };
  public static int[] Ruq = { b.f.album_img_0, b.f.album_img_1, b.f.album_img_2, b.f.album_img_3, b.f.album_img_4, b.f.album_img_5 };
  public static int[] Rur = { b.f.album_img_0, b.f.album_img_1, b.f.album_img_2, b.f.album_img_3, b.f.album_img_4, b.f.album_img_5, b.f.album_img_6, b.f.album_img_7, b.f.album_img_8 };
  static double Rus = -1.0D;
  static double Rut = -1.0D;
  static double Ruu = -1.0D;
  static double Ruv = -1.0D;
  static double Ruw = -1.0D;
  private static boolean Ruy;
  public static int Ruz = -1;
  private LinkedList<LinearLayout> Rux;
  private Context context;
  
  public bh(Context paramContext)
  {
    AppMethodBeat.i(98907);
    this.Rux = new LinkedList();
    this.context = paramContext;
    if ((this.context instanceof Activity))
    {
      paramContext = new DisplayMetrics();
      ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(paramContext);
      Point localPoint = new Point();
      localPoint.x = paramContext.widthPixels;
      localPoint.y = paramContext.heightPixels;
      al.m(localPoint);
    }
    if (1 == ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoi, 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Ruy = bool;
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
        Ruy = true;
      }
      AppMethodBeat.o(98907);
      return;
    }
  }
  
  private static void a(dmz paramdmz, QFadeImageView paramQFadeImageView, int paramInt, br parambr)
  {
    AppMethodBeat.i(98911);
    al.hgy().b(paramdmz, paramQFadeImageView, paramInt, parambr);
    AppMethodBeat.o(98911);
  }
  
  private void a(dmz paramdmz, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, br parambr, int paramInt3, boolean paramBoolean2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(308375);
    a(paramdmz, paramQFadeImageView, paramString, paramInt1, paramInt2, paramBoolean1, parambr, paramInt3, paramBoolean2, new dnb(), paramSnsInfo);
    AppMethodBeat.o(308375);
  }
  
  private void a(dmz paramdmz, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, br parambr, int paramInt3, boolean paramBoolean2, dnb paramdnb, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(308374);
    if (paramQFadeImageView == null)
    {
      Log.e("MicroMsg.SnsMultiLineImageLineMgr", "");
      AppMethodBeat.o(308374);
      return;
    }
    bf localbf = new bf();
    localbf.hHB = paramString;
    localbf.index = 0;
    paramString = new ArrayList();
    paramString.add(paramQFadeImageView);
    localbf.RrK = paramString;
    localbf.Roa = paramBoolean1;
    localbf.position = paramInt2;
    paramQFadeImageView.setTag(localbf);
    double d2 = 0.0D;
    double d1 = 0.0D;
    if ((paramInt3 == 10) && (paramBoolean2))
    {
      al.hgy().c(paramdmz, paramQFadeImageView, paramInt1, parambr);
      if (paramdmz.aaTn != null)
      {
        d2 = paramdmz.aaTn.aaUb;
        d1 = paramdmz.aaTn.aaUc;
      }
      if ((paramInt3 != 2) || (paramSnsInfo == null) || (!paramSnsInfo.isFinderAd())) {
        break label263;
      }
      paramdmz = o.a((int)d2, (int)d1, this.context, false);
      d1 = ((Integer)paramdmz.first).intValue();
      d2 = ((Integer)paramdmz.second).intValue();
    }
    for (;;)
    {
      label263:
      double d3;
      if ((paramQFadeImageView.getLayoutParams() instanceof FrameLayout.LayoutParams))
      {
        paramdmz = (FrameLayout.LayoutParams)paramQFadeImageView.getLayoutParams();
        if ((paramdmz.width == d1) && (paramdmz.height == d2))
        {
          AppMethodBeat.o(308374);
          return;
          al.hgy().a(paramdmz, paramQFadeImageView, paramInt1, parambr);
          break;
          if ((d2 > 0.0D) && (d1 > 0.0D))
          {
            double d4 = Math.min(Rut / d2, Rut / d1);
            d3 = d2 * d4;
            d4 = d1 * d4;
            d1 = d4;
            d2 = d3;
            if (d3 < Ruu)
            {
              d1 = 1.0D * Ruu / d3;
              d2 = d3 * d1;
              d1 = d4 * d1;
            }
            d3 = d1;
            d4 = d2;
            if (d1 < Ruu)
            {
              d3 = 1.0D * Ruu / d1;
              d4 = d2 * d3;
              d3 = d1 * d3;
            }
            d1 = d4;
            if (d4 > Rut) {
              d1 = Rut;
            }
            d2 = d3;
            if (d3 > Rut) {
              d2 = Rut;
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
            if ((paramdnb == null) || (paramdnb.aaUb <= 0.0F) || (paramdnb.aaUc <= 0.0F)) {
              break label538;
            }
            d1 = paramdnb.aaUb;
            d2 = paramdnb.aaUc;
            break;
            d3 = Rus;
            d2 = Rus;
          }
        }
        paramQFadeImageView.setLayoutParams(new FrameLayout.LayoutParams((int)d1, (int)d2));
      }
      AppMethodBeat.o(308374);
      return;
      label538:
      d2 = d3;
    }
  }
  
  private static void a(String paramString, SparseArray<dmz> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, br parambr, int paramInt2)
  {
    AppMethodBeat.i(98912);
    al.hgy().a(paramString, paramSparseArray, paramSparseArray1, paramInt1, parambr, paramInt2);
    AppMethodBeat.o(98912);
  }
  
  public static boolean hoY()
  {
    AppMethodBeat.i(98910);
    Log.d("MicroMsg.SnsMultiLineImageLineMgr", "enableGroupDownload_cmd: %d.", new Object[] { Integer.valueOf(Ruz) });
    switch (Ruz)
    {
    default: 
      boolean bool = CdnLogic.allowBatchImageDownload();
      Log.d("MicroMsg.SnsMultiLineImageLineMgr", "allowGroupDownload: %s, enableGroupDownload: %s.", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(Ruy) });
      if ((bool) && (Ruy))
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
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, br parambr, boolean paramBoolean2)
  {
    AppMethodBeat.i(98908);
    int[] arrayOfInt = Rur;
    if ((paramInt2 == 2) || (paramInt2 == 10)) {
      arrayOfInt = Ruo;
    }
    int i;
    for (;;)
    {
      paramTimeLineObject = paramTimeLineObject.ContentObj.Zpr;
      if (Rus < 0.0D)
      {
        Rus = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 160.0F);
        Rut = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 200.0F);
        Ruu = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 44.0F);
        Ruv = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 66.0F);
        Ruw = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 300.0F);
      }
      i = paramTimeLineObject.size();
      if (i != 0) {
        break label226;
      }
      paramInt1 = 0;
      while (paramInt1 < arrayOfInt.length)
      {
        al.hgy().jq(paramPhotosContent.alP(paramInt1));
        paramPhotosContent.alP(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        arrayOfInt = Rup;
      } else if (paramInt2 == 4) {
        arrayOfInt = Ruq;
      } else if (paramInt2 == 5) {
        arrayOfInt = Rur;
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
        TagImageView localTagImageView = paramPhotosContent.alP(i);
        localTagImageView.setVisibility(8);
        al.hgy().jq(localTagImageView);
        paramPhotosContent.alP(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.alP(0).setVisibility(0);
      a((dmz)paramTimeLineObject.get(0), paramPhotosContent.alP(0), paramString, paramInt1, paramInt3, paramBoolean1, parambr, paramInt2, paramBoolean2, null);
      AppMethodBeat.o(98908);
      return;
    }
    AppMethodBeat.o(98908);
  }
  
  public final void a(PhotosContent paramPhotosContent, TimeLineObject paramTimeLineObject, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, br parambr, List<dnb> paramList, String paramString2, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(308389);
    Object localObject = Rur;
    if ((paramInt2 == 2) || (paramInt2 == 10) || (paramInt2 == 13)) {
      localObject = Ruo;
    }
    LinkedList localLinkedList;
    int j;
    for (;;)
    {
      localLinkedList = paramTimeLineObject.ContentObj.Zpr;
      if (Rus < 0.0D)
      {
        Rus = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 160.0F);
        Rut = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 200.0F);
        Ruu = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 44.0F);
        Ruv = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 66.0F);
        Ruw = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 300.0F);
      }
      j = localLinkedList.size();
      if (j != 0) {
        break label235;
      }
      paramInt1 = 0;
      while (paramInt1 < localObject.length)
      {
        al.hgy().jq(paramPhotosContent.alP(paramInt1));
        paramPhotosContent.alP(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        localObject = Rup;
      } else if (paramInt2 == 4) {
        localObject = Ruq;
      } else if (paramInt2 == 5) {
        localObject = Rur;
      }
    }
    paramPhotosContent.setVisibility(8);
    AppMethodBeat.o(308389);
    return;
    label235:
    paramPhotosContent.setImageViewWidth(al.hgP());
    paramPhotosContent.setVisibility(0);
    int i;
    if (j == 1)
    {
      i = 1;
      while (i < localObject.length)
      {
        paramTimeLineObject = paramPhotosContent.alP(i);
        paramTimeLineObject.setVisibility(8);
        al.hgy().jq(paramTimeLineObject);
        paramPhotosContent.alP(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.alP(0).setVisibility(0);
      if ((paramList != null) && (paramList.size() > 0))
      {
        a((dmz)localLinkedList.get(0), paramPhotosContent.alP(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambr, paramInt2, false, (dnb)paramList.get(0), paramSnsInfo);
        AppMethodBeat.o(308389);
        return;
      }
      a((dmz)localLinkedList.get(0), paramPhotosContent.alP(0), paramString1, paramInt1, paramInt3, paramBoolean2, parambr, paramInt2, false, paramSnsInfo);
      AppMethodBeat.o(308389);
      return;
    }
    if (!hoY()) {}
    for (paramTimeLineObject = new c.c(paramString2, j);; paramTimeLineObject = null)
    {
      bf localbf;
      dmz localdmz;
      if (j == 4)
      {
        paramList = new ArrayList();
        paramSnsInfo = new SparseArray();
        localSparseArray = new SparseArray();
        paramInt2 = localObject.length - 1;
        i = 3;
        if (paramInt2 >= 0)
        {
          localObject = paramPhotosContent.alP(paramInt2);
          ((TagImageView)localObject).setPosition(paramInt3);
          if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3) || (paramInt2 == 4))
          {
            ((TagImageView)localObject).setVisibility(0);
            paramList.add(localObject);
            localbf = new bf();
            localbf.hHB = paramString1;
            localbf.index = i;
            localbf.RrK = paramList;
            localbf.Roa = paramBoolean2;
            localbf.position = paramInt3;
            ((TagImageView)localObject).setTag(localbf);
            if ((paramBoolean1) || (!hoY()))
            {
              localdmz = (dmz)localLinkedList.get(localbf.index);
              al.hgw().a(localdmz.Id, paramTimeLineObject);
              al.hgw().aYb(localdmz.Id);
              a(localdmz, (QFadeImageView)localObject, paramInt1, parambr);
            }
            paramSnsInfo.put(localbf.index, (dmz)localLinkedList.get(localbf.index));
            localSparseArray.put(localbf.index, localObject);
            i -= 1;
          }
          for (;;)
          {
            paramInt2 -= 1;
            break;
            ((TagImageView)localObject).setVisibility(8);
            al.hgy().jq((View)localObject);
          }
        }
        if ((!paramBoolean1) && (hoY()) && (paramSnsInfo.size() > 0)) {
          a(paramString2, paramSnsInfo, localSparseArray, paramInt1, parambr, j);
        }
        AppMethodBeat.o(308389);
        return;
      }
      paramList = new ArrayList();
      paramSnsInfo = new SparseArray();
      SparseArray localSparseArray = new SparseArray();
      paramInt2 = localObject.length - 1;
      if (paramInt2 >= 0)
      {
        localObject = paramPhotosContent.alP(paramInt2);
        ((TagImageView)localObject).setPosition(paramInt3);
        if (paramInt2 < localLinkedList.size())
        {
          ((TagImageView)localObject).setVisibility(0);
          paramList.add(localObject);
          localbf = new bf();
          localbf.hHB = paramString1;
          localbf.index = paramInt2;
          localbf.RrK = paramList;
          localbf.Roa = paramBoolean2;
          localbf.position = paramInt3;
          ((TagImageView)localObject).setTag(localbf);
          if ((paramBoolean1) || (!hoY()))
          {
            localdmz = (dmz)localLinkedList.get(localbf.index);
            al.hgw().a(localdmz.Id, paramTimeLineObject);
            al.hgw().aYb(localdmz.Id);
            a(localdmz, (QFadeImageView)localObject, paramInt1, parambr);
          }
          paramSnsInfo.put(localbf.index, (dmz)localLinkedList.get(localbf.index));
          localSparseArray.put(localbf.index, localObject);
        }
        for (;;)
        {
          paramInt2 -= 1;
          break;
          ((TagImageView)localObject).setVisibility(8);
          al.hgy().jq((View)localObject);
        }
      }
      if ((!paramBoolean1) && (hoY()) && (paramSnsInfo.size() > 0)) {
        a(paramString2, paramSnsInfo, localSparseArray, paramInt1, parambr, j);
      }
      AppMethodBeat.o(308389);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bh
 * JD-Core Version:    0.7.0.1
 */