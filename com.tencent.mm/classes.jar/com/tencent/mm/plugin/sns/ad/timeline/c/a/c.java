package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ad.a.d;
import com.tencent.mm.plugin.sns.ad.i.b;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout.a;
import com.tencent.mm.plugin.sns.data.r;
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
  private static final int[] Dzz;
  private static final Map<String, int[]> map;
  private String Dsr;
  private d Dzw;
  private int[] Dzx = Dzz;
  private String Dzy;
  
  static
  {
    AppMethodBeat.i(202283);
    map = new ArrayMap();
    Dzz = new int[] { 0, 1, 2 };
    AppMethodBeat.o(202283);
  }
  
  private static int[] ah(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(202281);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramInt < 3))
    {
      paramString1 = Dzz;
      AppMethodBeat.o(202281);
      return paramString1;
    }
    int[] arrayOfInt2 = (int[])map.get(paramString1);
    int[] arrayOfInt1 = arrayOfInt2;
    if (com.tencent.mm.plugin.sns.ad.i.c.K(arrayOfInt2))
    {
      arrayOfInt1 = fs(paramString1 + paramString2 + paramInt, paramInt);
      map.put(paramString1, arrayOfInt1);
    }
    AppMethodBeat.o(202281);
    return arrayOfInt1;
  }
  
  private void b(StackUpLayout paramStackUpLayout, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202275);
    if ((paramStackUpLayout == null) || (paramSnsInfo == null))
    {
      Log.w("SnsAd.Participants", "the input layout or sns information is null!!");
      AppMethodBeat.o(202275);
      return;
    }
    String str = r.v(paramSnsInfo);
    if ((TextUtils.isEmpty(str)) || (str.equals(this.Dsr)))
    {
      Log.w("SnsAd.Participants", "the sns id is empty or same as last one!!");
      AppMethodBeat.o(202275);
      return;
    }
    paramSnsInfo = o(paramSnsInfo);
    if (paramSnsInfo == null)
    {
      Log.w("SnsAd.Participants", "i think you are crazy!!!! Why is the topic-info null?");
      AppMethodBeat.o(202275);
      return;
    }
    this.Dsr = str;
    this.Dzw = paramSnsInfo;
    if (paramSnsInfo.DrR == null) {}
    for (int i = 0;; i = paramSnsInfo.DrR.size())
    {
      eYa();
      this.Dzx = ah(str, eYa(), i);
      if (paramStackUpLayout != null) {
        paramStackUpLayout.setAdapter(this);
      }
      AppMethodBeat.o(202275);
      return;
    }
  }
  
  private String eYa()
  {
    AppMethodBeat.i(202276);
    if (TextUtils.isEmpty(this.Dzy))
    {
      g.aAf();
      this.Dzy = com.tencent.mm.kernel.a.ayV();
    }
    String str = this.Dzy;
    AppMethodBeat.o(202276);
    return str;
  }
  
  private static int[] fs(String paramString, int paramInt)
  {
    AppMethodBeat.i(202282);
    if ((paramString == null) || (paramInt <= 0))
    {
      paramString = Dzz;
      AppMethodBeat.o(202282);
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
        k = paramString.nextInt(paramInt);
        m = j + 1;
        if ((k != i) && (k != n)) {
          break;
        }
        j = m;
      } while (m < 3);
      if (m >= 3) {}
      for (paramInt = (i + 1) % paramInt;; paramInt = k)
      {
        AppMethodBeat.o(202282);
        return new int[] { n, i, paramInt };
      }
    }
  }
  
  private static d o(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202277);
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      Log.w("SnsAd.Participants", "the sns info or ad xml is null!!");
      AppMethodBeat.o(202277);
      return null;
    }
    paramSnsInfo = paramSnsInfo.getAdXml().adFinderTopicInfo;
    AppMethodBeat.o(202277);
    return paramSnsInfo;
  }
  
  public final void a(StackUpLayout paramStackUpLayout, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202274);
    try
    {
      b(paramStackUpLayout, paramSnsInfo);
      AppMethodBeat.o(202274);
      return;
    }
    catch (Throwable paramStackUpLayout)
    {
      Log.w("SnsAd.Participants", "injectAdapter error " + paramStackUpLayout.getMessage());
      AppMethodBeat.o(202274);
    }
  }
  
  public final void av(View paramView, int paramInt)
  {
    AppMethodBeat.i(202279);
    try
    {
      Object localObject = this.Dzw;
      if (localObject == null)
      {
        AppMethodBeat.o(202279);
        return;
      }
      localObject = ((d)localObject).DrR;
      int[] arrayOfInt = this.Dzx;
      if (!com.tencent.e.d.b.a.isEmpty((Collection)localObject))
      {
        boolean bool = com.tencent.mm.plugin.sns.ad.i.c.K(arrayOfInt);
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(202279);
        return;
      }
      if ((paramInt >= 0) && (paramInt < arrayOfInt.length) && (arrayOfInt[paramInt] >= 0) && (arrayOfInt[paramInt] < ((List)localObject).size()) && ((paramView instanceof ImageView))) {
        b.a((String)((List)localObject).get(arrayOfInt[paramInt]), (ImageView)paramView, 2);
      }
      AppMethodBeat.o(202279);
      return;
    }
    catch (Throwable paramView)
    {
      Log.w("SnsAd.Participants", "fillChildView error ");
      AppMethodBeat.o(202279);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(202278);
    try
    {
      Object localObject = this.Dzw;
      if (localObject == null)
      {
        AppMethodBeat.o(202278);
        return 0;
      }
      localObject = ((d)localObject).DrR;
      if (localObject == null)
      {
        AppMethodBeat.o(202278);
        return 0;
      }
      int i = Math.min(((List)localObject).size(), 3);
      AppMethodBeat.o(202278);
      return i;
    }
    catch (Throwable localThrowable)
    {
      Log.w("SnsAd.Participants", "getItemCount error ");
      AppMethodBeat.o(202278);
    }
    return 0;
  }
  
  public final View j(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202280);
    RoundCornerImageView localRoundCornerImageView = new RoundCornerImageView(paramContext);
    localRoundCornerImageView.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    localRoundCornerImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localRoundCornerImageView.lx(com.tencent.mm.cb.a.fromDPToPix(paramContext, 1), paramContext.getResources().getColor(2131099650));
    localRoundCornerImageView.ly(paramInt1, paramInt2);
    localRoundCornerImageView.setBackgroundResource(2131234945);
    AppMethodBeat.o(202280);
    return localRoundCornerImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.c
 * JD-Core Version:    0.7.0.1
 */