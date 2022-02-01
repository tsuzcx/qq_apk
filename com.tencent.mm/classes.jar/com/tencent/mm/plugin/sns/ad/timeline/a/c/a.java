package com.tencent.mm.plugin.sns.ad.timeline.a.c;

import android.view.View;
import com.tencent.mm.modelsns.SnsAdClick;
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
    if (paramSnsInfo == null) {
      return false;
    }
    Object localObject = paramSnsInfo.getAdXml();
    if (localObject == null) {
      return false;
    }
    for (;;)
    {
      boolean bool;
      try
      {
        bool = a(paramView, paramInt, paramSnsInfo, (ADXml)localObject, paramd);
        if (!bool) {
          break label188;
        }
        if (paramd == null)
        {
          paramView = null;
          if (paramView == null) {
            break label188;
          }
          t.a(paramView);
          break label188;
        }
        localObject = (l)paramd.K("snsAdStatistic", null);
        if (localObject == null)
        {
          paramView = null;
          continue;
        }
        if (paramd.containsKey("flipStatus"))
        {
          int j = ((Integer)paramd.K("flipStatus", Integer.valueOf(0))).intValue();
          if (paramInt != 0) {
            break label191;
          }
          i = 1;
          paramView = new SnsAdClick(paramInt, i, paramSnsInfo.field_snsId, fKt(), j, (byte)0);
          m.a(paramView, (l)localObject, paramSnsInfo, 22);
          continue;
        }
        if (paramInt == 0)
        {
          i = 1;
          paramView = new SnsAdClick(paramInt, i, paramSnsInfo.field_snsId, 22, fKt());
          continue;
        }
        i = 2;
      }
      finally
      {
        return false;
      }
      continue;
      label188:
      return bool;
      label191:
      int i = 2;
    }
  }
  
  protected abstract boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, ADXml paramADXml, d paramd);
  
  protected abstract int fKt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.c.a
 * JD-Core Version:    0.7.0.1
 */