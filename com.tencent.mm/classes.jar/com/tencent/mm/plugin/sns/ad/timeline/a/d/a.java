package com.tencent.mm.plugin.sns.ad.timeline.a.d;

import android.view.View;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.ad.timeline.a.c;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public abstract class a
  implements c
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ad.timeline.a.d paramd)
  {
    if ((paramView == null) || (paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null)) {}
    com.tencent.mm.plugin.sns.ad.adxml.d locald;
    do
    {
      return false;
      locald = paramSnsInfo.getAdXml().adFinderTopicInfo;
    } while (locald == null);
    boolean bool = a(paramView, paramSnsInfo, locald);
    if (bool) {
      if (paramInt != 0) {
        break label111;
      }
    }
    label111:
    for (int i = 1;; i = 2)
    {
      paramView = new SnsAdClick(paramInt, i, paramSnsInfo.field_snsId, 32, 46);
      if (paramd != null)
      {
        paramd = (l)paramd.y("sns_ad_statistic", null);
        if (paramd != null) {
          m.a(paramView, paramd, paramSnsInfo, 32);
        }
      }
      t.a(paramView);
      return bool;
    }
  }
  
  protected abstract boolean a(View paramView, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ad.adxml.d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.d.a
 * JD-Core Version:    0.7.0.1
 */