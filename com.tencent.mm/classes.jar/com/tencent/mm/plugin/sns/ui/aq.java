package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class aq
{
  public static int[] paC = { 0, 0, 1, 3, 6, 9 };
  public static int[] paD = { i.f.album_img_0 };
  public static int[] paE = { i.f.album_img_0, i.f.album_img_1, i.f.album_img_2 };
  public static int[] paF = { i.f.album_img_0, i.f.album_img_1, i.f.album_img_2, i.f.album_img_3, i.f.album_img_4, i.f.album_img_5 };
  public static int[] paG = { i.f.album_img_0, i.f.album_img_1, i.f.album_img_2, i.f.album_img_3, i.f.album_img_4, i.f.album_img_5, i.f.album_img_6, i.f.album_img_7, i.f.album_img_8 };
  static double paH = -1.0D;
  static double paI = -1.0D;
  static double paJ = -1.0D;
  static double paK = -1.0D;
  static double paL = -1.0D;
  private Context context;
  private LinkedList<LinearLayout> paM = new LinkedList();
  
  public aq(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public aq(Context paramContext, byte paramByte)
  {
    this.context = paramContext;
  }
  
  private static void a(awd paramawd, QFadeImageView paramQFadeImageView, int paramInt, az paramaz)
  {
    af.bDC().b(paramawd, paramQFadeImageView, paramInt, paramaz);
  }
  
  private static void a(awd paramawd, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, az paramaz, int paramInt3, boolean paramBoolean2)
  {
    a(paramawd, paramQFadeImageView, paramString, paramInt1, paramInt2, paramBoolean1, paramaz, paramInt3, paramBoolean2, new awf());
  }
  
  private static void a(awd paramawd, QFadeImageView paramQFadeImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, az paramaz, int paramInt3, boolean paramBoolean2, awf paramawf)
  {
    if (paramQFadeImageView == null) {
      y.e("MicroMsg.SnsMultiLineImageLineMgr", "");
    }
    label298:
    label439:
    label452:
    label457:
    for (;;)
    {
      return;
      ao localao = new ao();
      localao.bMB = paramString;
      localao.index = 0;
      paramString = new ArrayList();
      paramString.add(paramQFadeImageView);
      localao.oYz = paramString;
      localao.oVB = paramBoolean1;
      localao.position = paramInt2;
      paramQFadeImageView.setTag(localao);
      double d2 = 0.0D;
      double d1 = 0.0D;
      label104:
      double d3;
      if ((paramInt3 == 10) && (paramBoolean2))
      {
        af.bDC().c(paramawd, paramQFadeImageView, paramInt1, paramaz);
        if (paramawd.trS != null)
        {
          d2 = paramawd.trS.tsF;
          d1 = paramawd.trS.tsG;
        }
        if ((d2 <= 0.0D) || (d1 <= 0.0D)) {
          break label439;
        }
        double d4 = Math.min(paI / d2, paI / d1);
        d3 = d2 * d4;
        d4 = d1 * d4;
        d1 = d4;
        d2 = d3;
        if (d3 < paJ)
        {
          d1 = 1.0D * paJ / d3;
          d2 = d3 * d1;
          d1 = d4 * d1;
        }
        d3 = d1;
        d4 = d2;
        if (d1 < paJ)
        {
          d3 = 1.0D * paJ / d1;
          d4 = d2 * d3;
          d3 = d1 * d3;
        }
        d1 = d4;
        if (d4 > paI) {
          d1 = paI;
        }
        d2 = d3;
        if (d3 > paI) {
          d2 = paI;
        }
        d3 = d1;
        d1 = d3;
        if (d3 < 1.0D) {
          d1 = 1.0D;
        }
        d3 = d2;
        if (d2 < 1.0D) {
          d3 = 1.0D;
        }
        if ((paramawf == null) || (paramawf.tsF <= 0.0F) || (paramawf.tsG <= 0.0F)) {
          break label452;
        }
        d1 = paramawf.tsF;
      }
      for (d2 = paramawf.tsG;; d2 = d3)
      {
        if (!(paramQFadeImageView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
          break label457;
        }
        paramawd = (FrameLayout.LayoutParams)paramQFadeImageView.getLayoutParams();
        if ((paramawd.width == d1) && (paramawd.height == d2)) {
          break;
        }
        paramQFadeImageView.setLayoutParams(new FrameLayout.LayoutParams((int)d1, (int)d2));
        return;
        af.bDC().a(paramawd, paramQFadeImageView, paramInt1, paramaz);
        break label104;
        d3 = paH;
        d2 = paH;
        break label298;
      }
    }
  }
  
  public final void a(PhotosContent paramPhotosContent, bxk parambxk, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, az paramaz, List<awf> paramList)
  {
    Object localObject1 = paG;
    if ((paramInt2 == 2) || (paramInt2 == 10) || (paramInt2 == 13)) {
      localObject1 = paD;
    }
    int i;
    for (;;)
    {
      parambxk = parambxk.tNr.sPJ;
      if (paH < 0.0D)
      {
        paH = BackwardSupportUtil.b.b(this.context, 160.0F);
        paI = BackwardSupportUtil.b.b(this.context, 200.0F);
        paJ = BackwardSupportUtil.b.b(this.context, 44.0F);
        paK = BackwardSupportUtil.b.b(this.context, 66.0F);
        paL = BackwardSupportUtil.b.b(this.context, 300.0F);
      }
      i = parambxk.size();
      if (i != 0) {
        break label216;
      }
      paramInt1 = 0;
      while (paramInt1 < localObject1.length)
      {
        af.bDC().cM(paramPhotosContent.yD(paramInt1));
        paramPhotosContent.yD(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        localObject1 = paE;
      } else if (paramInt2 == 4) {
        localObject1 = paF;
      } else if (paramInt2 == 5) {
        localObject1 = paG;
      }
    }
    paramPhotosContent.setVisibility(8);
    return;
    label216:
    paramPhotosContent.setImageViewWidth(af.bDN());
    paramPhotosContent.setVisibility(0);
    Object localObject2;
    if (i == 1)
    {
      i = 1;
      while (i < localObject1.length)
      {
        localObject2 = paramPhotosContent.yD(i);
        ((QFadeImageView)localObject2).setVisibility(8);
        af.bDC().cM((View)localObject2);
        paramPhotosContent.yD(i).setPosition(paramInt3);
        i += 1;
      }
      paramPhotosContent.yD(0).setVisibility(0);
      if ((paramList != null) && (paramList.size() > 0))
      {
        a((awd)parambxk.get(0), paramPhotosContent.yD(0), paramString, paramInt1, paramInt3, paramBoolean, paramaz, paramInt2, false, (awf)paramList.get(0));
        return;
      }
      a((awd)parambxk.get(0), paramPhotosContent.yD(0), paramString, paramInt1, paramInt3, paramBoolean, paramaz, paramInt2, false);
      return;
    }
    if (i == 4)
    {
      paramList = new ArrayList();
      paramInt2 = localObject1.length - 1;
      i = 3;
      label410:
      if (paramInt2 >= 0)
      {
        localObject1 = paramPhotosContent.yD(paramInt2);
        ((TagImageView)localObject1).setPosition(paramInt3);
        if ((paramInt2 != 0) && (paramInt2 != 1) && (paramInt2 != 3) && (paramInt2 != 4)) {
          break label557;
        }
        ((TagImageView)localObject1).setVisibility(0);
        paramList.add(localObject1);
        localObject2 = new ao();
        ((ao)localObject2).bMB = paramString;
        ((ao)localObject2).index = i;
        ((ao)localObject2).oYz = paramList;
        ((ao)localObject2).oVB = paramBoolean;
        ((ao)localObject2).position = paramInt3;
        ((TagImageView)localObject1).setTag(localObject2);
        a((awd)parambxk.get(((ao)localObject2).index), (QFadeImageView)localObject1, paramInt1, paramaz);
        i -= 1;
      }
      for (;;)
      {
        paramInt2 -= 1;
        break label410;
        break;
        label557:
        ((TagImageView)localObject1).setVisibility(8);
        af.bDC().cM((View)localObject1);
      }
    }
    paramList = new ArrayList();
    paramInt2 = localObject1.length - 1;
    label591:
    if (paramInt2 >= 0)
    {
      localObject1 = paramPhotosContent.yD(paramInt2);
      ((TagImageView)localObject1).setPosition(paramInt3);
      if (paramInt2 >= parambxk.size()) {
        break label720;
      }
      ((TagImageView)localObject1).setVisibility(0);
      paramList.add(localObject1);
      localObject2 = new ao();
      ((ao)localObject2).bMB = paramString;
      ((ao)localObject2).index = paramInt2;
      ((ao)localObject2).oYz = paramList;
      ((ao)localObject2).oVB = paramBoolean;
      ((ao)localObject2).position = paramInt3;
      ((TagImageView)localObject1).setTag(localObject2);
      a((awd)parambxk.get(((ao)localObject2).index), (QFadeImageView)localObject1, paramInt1, paramaz);
    }
    for (;;)
    {
      paramInt2 -= 1;
      break label591;
      break;
      label720:
      ((TagImageView)localObject1).setVisibility(8);
      af.bDC().cM((View)localObject1);
    }
  }
  
  public final void a(PhotosContent paramPhotosContent, bxk parambxk, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, az paramaz, boolean paramBoolean2)
  {
    int[] arrayOfInt = paG;
    if ((paramInt2 == 2) || (paramInt2 == 10)) {
      arrayOfInt = paD;
    }
    for (;;)
    {
      parambxk = parambxk.tNr.sPJ;
      if (paH < 0.0D)
      {
        paH = BackwardSupportUtil.b.b(this.context, 160.0F);
        paI = BackwardSupportUtil.b.b(this.context, 200.0F);
        paJ = BackwardSupportUtil.b.b(this.context, 44.0F);
        paK = BackwardSupportUtil.b.b(this.context, 66.0F);
        paL = BackwardSupportUtil.b.b(this.context, 300.0F);
      }
      i = parambxk.size();
      if (i != 0) {
        break label209;
      }
      paramInt1 = 0;
      while (paramInt1 < arrayOfInt.length)
      {
        af.bDC().cM(paramPhotosContent.yD(paramInt1));
        paramPhotosContent.yD(paramInt1).setPosition(paramInt3);
        paramInt1 += 1;
      }
      if (paramInt2 == 3) {
        arrayOfInt = paE;
      } else if (paramInt2 == 4) {
        arrayOfInt = paF;
      } else if (paramInt2 == 5) {
        arrayOfInt = paG;
      }
    }
    paramPhotosContent.setVisibility(8);
    label209:
    do
    {
      return;
      paramPhotosContent.setVisibility(0);
    } while (i != 1);
    int i = 1;
    while (i < arrayOfInt.length)
    {
      TagImageView localTagImageView = paramPhotosContent.yD(i);
      localTagImageView.setVisibility(8);
      af.bDC().cM(localTagImageView);
      paramPhotosContent.yD(i).setPosition(paramInt3);
      i += 1;
    }
    paramPhotosContent.yD(0).setVisibility(0);
    a((awd)parambxk.get(0), paramPhotosContent.yD(0), paramString, paramInt1, paramInt3, paramBoolean1, paramaz, paramInt2, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aq
 * JD-Core Version:    0.7.0.1
 */