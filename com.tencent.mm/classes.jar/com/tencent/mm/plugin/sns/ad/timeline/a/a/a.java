package com.tencent.mm.plugin.sns.ad.timeline.a.a;

import android.view.View;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.adxml.i;
import com.tencent.mm.plugin.sns.ad.adxml.j;
import com.tencent.mm.plugin.sns.ad.adxml.k;
import com.tencent.mm.plugin.sns.ad.adxml.l;
import com.tencent.mm.plugin.sns.ad.timeline.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public abstract class a
  implements c
{
  protected abstract boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, AdClickActionInfo paramAdClickActionInfo, d paramd);
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      Log.w("SnsAd.AdActionButtonClick", "the sns info or adxml is null!!!");
      return false;
    }
    if (paramd != null) {}
    for (int i = ((Integer)paramd.get("scene")).intValue();; i = 0)
    {
      Object localObject2 = null;
      ADXml localADXml = paramSnsInfo.getAdXml();
      Object localObject1;
      if (i == 1)
      {
        localObject1 = localObject2;
        if (localADXml.adCardActionBtnInfo != null) {
          localObject1 = localADXml.adCardActionBtnInfo.clickActionInfo;
        }
      }
      for (;;)
      {
        label77:
        if (localObject1 != null) {}
        try
        {
          boolean bool = a(paramView, paramInt, paramSnsInfo, (AdClickActionInfo)localObject1, paramd);
          return bool;
        }
        catch (Throwable paramView)
        {
          return false;
        }
        if (i == 2)
        {
          localObject1 = localObject2;
          if (localADXml.adTagBtnInfo != null) {
            localObject1 = localADXml.adTagBtnInfo.clickActionInfo;
          }
        }
        else if (i == 3)
        {
          localObject1 = localObject2;
          if (localADXml.adSliderFullCardInfo == null) {
            continue;
          }
          if (paramd == null) {
            break label273;
          }
        }
      }
      label273:
      for (i = ((Integer)paramd.get("subClickPos")).intValue();; i = 0)
      {
        localObject1 = ((i)localADXml.adSliderFullCardInfo.Jym.get(i)).clickActionInfo;
        break label77;
        localObject1 = localObject2;
        if (i != 4) {
          break label77;
        }
        localObject1 = localObject2;
        if (localADXml.adSliderFullCardInfo == null) {
          break label77;
        }
        if (paramd != null) {}
        for (i = ((Integer)paramd.get("subClickPos")).intValue();; i = 0)
        {
          localObject1 = ((i)localADXml.adSliderFullCardInfo.Jym.get(i)).JyD.JyK;
          break label77;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a
 * JD-Core Version:    0.7.0.1
 */