package com.tencent.mm.plugin.sns.ad.timeline.b.c;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.ad.adxml.f;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class c
  implements StackUpLayout.a
{
  private static final int[] QcF;
  private static final Map<String, int[]> map;
  private String PNx;
  private f QcC;
  private int[] QcD = QcF;
  private String QcE;
  
  static
  {
    AppMethodBeat.i(311312);
    map = new ArrayMap();
    QcF = new int[] { 0, 1, 2 };
    AppMethodBeat.o(311312);
  }
  
  private static int[] ax(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(311283);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramInt < 3))
    {
      paramString1 = QcF;
      AppMethodBeat.o(311283);
      return paramString1;
    }
    int[] arrayOfInt2 = (int[])map.get(paramString1);
    int[] arrayOfInt1 = arrayOfInt2;
    if (d.N(arrayOfInt2))
    {
      arrayOfInt1 = gO(paramString1 + paramString2 + paramInt, paramInt);
      map.put(paramString1, arrayOfInt1);
    }
    AppMethodBeat.o(311283);
    return arrayOfInt1;
  }
  
  private void b(StackUpLayout paramStackUpLayout, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(311237);
    if ((paramStackUpLayout == null) || (paramSnsInfo == null))
    {
      Log.w("SnsAd.Participants", "the input layout or sns information is null!!");
      AppMethodBeat.o(311237);
      return;
    }
    String str = t.x(paramSnsInfo);
    if ((TextUtils.isEmpty(str)) || (str.equals(this.PNx)))
    {
      Log.w("SnsAd.Participants", "the sns id is empty or same as last one!!");
      AppMethodBeat.o(311237);
      return;
    }
    paramSnsInfo = r(paramSnsInfo);
    if (paramSnsInfo == null)
    {
      Log.w("SnsAd.Participants", "i think you are crazy!!!! Why is the topic-info null?");
      AppMethodBeat.o(311237);
      return;
    }
    this.PNx = str;
    this.QcC = paramSnsInfo;
    if (paramSnsInfo.PMF == null) {}
    for (int i = 0;; i = paramSnsInfo.PMF.size())
    {
      hcd();
      this.QcD = ax(str, hcd(), i);
      if (paramStackUpLayout != null) {
        paramStackUpLayout.setAdapter(this);
      }
      AppMethodBeat.o(311237);
      return;
    }
  }
  
  private static int[] gO(String paramString, int paramInt)
  {
    AppMethodBeat.i(311297);
    if ((paramString == null) || (paramInt <= 0))
    {
      paramString = QcF;
      AppMethodBeat.o(311297);
      return paramString;
    }
    paramString = new Random(paramString.hashCode());
    int n = paramString.nextInt(paramInt);
    int i = 0;
    int j;
    int k;
    do
    {
      j = paramString.nextInt(paramInt);
      k = i + 1;
      if (n != j) {
        break;
      }
      i = k;
    } while (k < 3);
    if (k >= 3) {}
    for (i = (n + 1) % paramInt;; i = j)
    {
      j = 0;
      int m;
      do
      {
        m = paramString.nextInt(paramInt);
        k = j + 1;
        if ((m != i) && (m != n)) {
          break;
        }
        j = k;
      } while (k < 3);
      j = m;
      if (k >= 3) {
        j = (i + 1) % paramInt;
      }
      if ((n == i) || (n == j) || (i == j))
      {
        paramString = QcF;
        AppMethodBeat.o(311297);
        return paramString;
      }
      AppMethodBeat.o(311297);
      return new int[] { n, i, j };
    }
  }
  
  private String hcd()
  {
    AppMethodBeat.i(311251);
    if (TextUtils.isEmpty(this.QcE))
    {
      h.baC();
      this.QcE = b.aZs();
    }
    String str = this.QcE;
    AppMethodBeat.o(311251);
    return str;
  }
  
  private static f r(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(311265);
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      Log.w("SnsAd.Participants", "the sns info or ad xml is null!!");
      AppMethodBeat.o(311265);
      return null;
    }
    paramSnsInfo = paramSnsInfo.getAdXml().adFinderTopicInfo;
    AppMethodBeat.o(311265);
    return paramSnsInfo;
  }
  
  public final void a(StackUpLayout paramStackUpLayout, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(311322);
    try
    {
      b(paramStackUpLayout, paramSnsInfo);
      AppMethodBeat.o(311322);
      return;
    }
    finally
    {
      Log.w("SnsAd.Participants", "injectAdapter error " + paramStackUpLayout.getMessage());
      AppMethodBeat.o(311322);
    }
  }
  
  public final void aV(View paramView, int paramInt)
  {
    AppMethodBeat.i(311347);
    try
    {
      Object localObject = this.QcC;
      if (localObject == null)
      {
        AppMethodBeat.o(311347);
        return;
      }
      localObject = ((f)localObject).PMF;
      int[] arrayOfInt = this.QcD;
      if (!com.tencent.e.d.b.a.isEmpty((Collection)localObject))
      {
        boolean bool = d.N(arrayOfInt);
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(311347);
        return;
      }
      if ((paramInt >= 0) && (paramInt < arrayOfInt.length) && (arrayOfInt[paramInt] >= 0) && (arrayOfInt[paramInt] < ((List)localObject).size()) && ((paramView instanceof ImageView))) {
        com.tencent.mm.plugin.sns.ad.j.c.b((String)((List)localObject).get(arrayOfInt[paramInt]), (ImageView)paramView, 2);
      }
      AppMethodBeat.o(311347);
      return;
    }
    finally
    {
      Log.w("SnsAd.Participants", "fillChildView error ");
      AppMethodBeat.o(311347);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(311333);
    try
    {
      Object localObject1 = this.QcC;
      if (localObject1 == null)
      {
        AppMethodBeat.o(311333);
        return 0;
      }
      localObject1 = ((f)localObject1).PMF;
      if (localObject1 == null)
      {
        AppMethodBeat.o(311333);
        return 0;
      }
      int i = Math.min(((List)localObject1).size(), 3);
      AppMethodBeat.o(311333);
      return i;
    }
    finally
    {
      Log.w("SnsAd.Participants", "getItemCount error ");
      AppMethodBeat.o(311333);
    }
    return 0;
  }
  
  public final View o(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(311361);
    RoundCornerImageView localRoundCornerImageView = new RoundCornerImageView(paramContext);
    localRoundCornerImageView.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    localRoundCornerImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localRoundCornerImageView.oI(com.tencent.mm.cd.a.fromDPToPix(paramContext, 1), paramContext.getResources().getColor(b.c.BG_2));
    localRoundCornerImageView.oJ(paramInt1, paramInt2);
    localRoundCornerImageView.setBackgroundResource(b.e.sns_ad_finder_topic_sub_item_default_image);
    AppMethodBeat.o(311361);
    return localRoundCornerImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.c.c
 * JD-Core Version:    0.7.0.1
 */