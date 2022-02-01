package com.tencent.mm.plugin.sns.ad.timeline.a.a;

import android.view.View;
import com.tencent.mm.plugin.sns.ad.timeline.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  implements c
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      Log.w("SnsAd.AdActionButtonClick", "the sns info or adxml is null!!!");
      return false;
    }
    ADXml.AdCardActionBtnInfo localAdCardActionBtnInfo = paramSnsInfo.getAdXml().adCardActionBtnInfo;
    if (localAdCardActionBtnInfo != null) {
      try
      {
        boolean bool = a(paramView, paramInt, paramSnsInfo, localAdCardActionBtnInfo, paramd);
        return bool;
      }
      catch (Throwable paramView) {}
    }
    return false;
  }
  
  protected abstract boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, ADXml.AdCardActionBtnInfo paramAdCardActionBtnInfo, d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a
 * JD-Core Version:    0.7.0.1
 */