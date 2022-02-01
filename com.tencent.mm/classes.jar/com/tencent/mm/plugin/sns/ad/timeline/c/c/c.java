package com.tencent.mm.plugin.sns.ad.timeline.c.c;

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
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
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
  private static final int[] JKW;
  private static final Map<String, int[]> map;
  private com.tencent.mm.plugin.sns.ad.adxml.d JKT;
  private int[] JKU = JKW;
  private String JKV;
  private String JyZ;
  
  static
  {
    AppMethodBeat.i(196388);
    map = new ArrayMap();
    JKW = new int[] { 0, 1, 2 };
    AppMethodBeat.o(196388);
  }
  
  private static int[] ao(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(196383);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramInt < 3))
    {
      paramString1 = JKW;
      AppMethodBeat.o(196383);
      return paramString1;
    }
    int[] arrayOfInt2 = (int[])map.get(paramString1);
    int[] arrayOfInt1 = arrayOfInt2;
    if (com.tencent.mm.plugin.sns.ad.i.d.J(arrayOfInt2))
    {
      arrayOfInt1 = fV(paramString1 + paramString2 + paramInt, paramInt);
      map.put(paramString1, arrayOfInt1);
    }
    AppMethodBeat.o(196383);
    return arrayOfInt1;
  }
  
  private void b(StackUpLayout paramStackUpLayout, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(196372);
    if ((paramStackUpLayout == null) || (paramSnsInfo == null))
    {
      Log.w("SnsAd.Participants", "the input layout or sns information is null!!");
      AppMethodBeat.o(196372);
      return;
    }
    String str = t.w(paramSnsInfo);
    if ((TextUtils.isEmpty(str)) || (str.equals(this.JyZ)))
    {
      Log.w("SnsAd.Participants", "the sns id is empty or same as last one!!");
      AppMethodBeat.o(196372);
      return;
    }
    paramSnsInfo = p(paramSnsInfo);
    if (paramSnsInfo == null)
    {
      Log.w("SnsAd.Participants", "i think you are crazy!!!! Why is the topic-info null?");
      AppMethodBeat.o(196372);
      return;
    }
    this.JyZ = str;
    this.JKT = paramSnsInfo;
    if (paramSnsInfo.Jyl == null) {}
    for (int i = 0;; i = paramSnsInfo.Jyl.size())
    {
      fLH();
      this.JKU = ao(str, fLH(), i);
      if (paramStackUpLayout != null) {
        paramStackUpLayout.setAdapter(this);
      }
      AppMethodBeat.o(196372);
      return;
    }
  }
  
  private String fLH()
  {
    AppMethodBeat.i(196375);
    if (TextUtils.isEmpty(this.JKV))
    {
      h.aHE();
      this.JKV = b.aGq();
    }
    String str = this.JKV;
    AppMethodBeat.o(196375);
    return str;
  }
  
  private static int[] fV(String paramString, int paramInt)
  {
    AppMethodBeat.i(196387);
    if ((paramString == null) || (paramInt <= 0))
    {
      paramString = JKW;
      AppMethodBeat.o(196387);
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
        paramString = JKW;
        AppMethodBeat.o(196387);
        return paramString;
      }
      AppMethodBeat.o(196387);
      return new int[] { n, i, j };
    }
  }
  
  private static com.tencent.mm.plugin.sns.ad.adxml.d p(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(196377);
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      Log.w("SnsAd.Participants", "the sns info or ad xml is null!!");
      AppMethodBeat.o(196377);
      return null;
    }
    paramSnsInfo = paramSnsInfo.getAdXml().adFinderTopicInfo;
    AppMethodBeat.o(196377);
    return paramSnsInfo;
  }
  
  public final void a(StackUpLayout paramStackUpLayout, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(196367);
    try
    {
      b(paramStackUpLayout, paramSnsInfo);
      AppMethodBeat.o(196367);
      return;
    }
    catch (Throwable paramStackUpLayout)
    {
      Log.w("SnsAd.Participants", "injectAdapter error " + paramStackUpLayout.getMessage());
      AppMethodBeat.o(196367);
    }
  }
  
  public final void az(View paramView, int paramInt)
  {
    AppMethodBeat.i(196379);
    try
    {
      Object localObject = this.JKT;
      if (localObject == null)
      {
        AppMethodBeat.o(196379);
        return;
      }
      localObject = ((com.tencent.mm.plugin.sns.ad.adxml.d)localObject).Jyl;
      int[] arrayOfInt = this.JKU;
      if (!com.tencent.d.d.b.a.isEmpty((Collection)localObject))
      {
        boolean bool = com.tencent.mm.plugin.sns.ad.i.d.J(arrayOfInt);
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(196379);
        return;
      }
      if ((paramInt >= 0) && (paramInt < arrayOfInt.length) && (arrayOfInt[paramInt] >= 0) && (arrayOfInt[paramInt] < ((List)localObject).size()) && ((paramView instanceof ImageView))) {
        com.tencent.mm.plugin.sns.ad.i.c.a((String)((List)localObject).get(arrayOfInt[paramInt]), (ImageView)paramView, 2);
      }
      AppMethodBeat.o(196379);
      return;
    }
    catch (Throwable paramView)
    {
      Log.w("SnsAd.Participants", "fillChildView error ");
      AppMethodBeat.o(196379);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(196378);
    try
    {
      Object localObject = this.JKT;
      if (localObject == null)
      {
        AppMethodBeat.o(196378);
        return 0;
      }
      localObject = ((com.tencent.mm.plugin.sns.ad.adxml.d)localObject).Jyl;
      if (localObject == null)
      {
        AppMethodBeat.o(196378);
        return 0;
      }
      int i = Math.min(((List)localObject).size(), 3);
      AppMethodBeat.o(196378);
      return i;
    }
    catch (Throwable localThrowable)
    {
      Log.w("SnsAd.Participants", "getItemCount error ");
      AppMethodBeat.o(196378);
    }
    return 0;
  }
  
  public final View k(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196382);
    RoundCornerImageView localRoundCornerImageView = new RoundCornerImageView(paramContext);
    localRoundCornerImageView.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    localRoundCornerImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localRoundCornerImageView.mP(com.tencent.mm.ci.a.fromDPToPix(paramContext, 1), paramContext.getResources().getColor(i.c.BG_2));
    localRoundCornerImageView.mQ(paramInt1, paramInt2);
    localRoundCornerImageView.setBackgroundResource(i.e.sns_ad_finder_topic_sub_item_default_image);
    AppMethodBeat.o(196382);
    return localRoundCornerImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.c.c
 * JD-Core Version:    0.7.0.1
 */