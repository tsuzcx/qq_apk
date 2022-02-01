package com.tencent.mm.plugin.sns.ad.timeline.a.d;

import android.view.View;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.adxml.f;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.timeline.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public abstract class a
  implements c
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    if ((paramView == null) || (paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null)) {}
    f localf;
    do
    {
      return false;
      localf = paramSnsInfo.getAdXml().adFinderTopicInfo;
    } while (localf == null);
    boolean bool = a(paramView, paramSnsInfo, localf);
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
        paramd = (l)paramd.K("sns_ad_statistic", null);
        if (paramd != null) {
          m.a(paramView, paramd, paramSnsInfo, 32);
        }
      }
      t.a(paramView);
      return bool;
    }
  }
  
  protected abstract boolean a(View paramView, SnsInfo paramSnsInfo, f paramf);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.d.a
 * JD-Core Version:    0.7.0.1
 */