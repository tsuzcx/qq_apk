package com.tencent.mm.plugin.sns.ad.timeline.a.c;

import android.view.View;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.timeline.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public abstract class a
  implements c
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    int j = 1;
    int i = 1;
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
        bool = a(paramView, paramInt, paramSnsInfo, (ADXml)localObject);
        if (!bool) {
          break label190;
        }
        if (paramd == null)
        {
          paramView = null;
          if (paramView == null) {
            break label190;
          }
          r.a(paramView);
          break label190;
        }
        localObject = (com.tencent.mm.plugin.sns.ad.g.k)paramd.z("snsAdStatistic", null);
        if (localObject == null)
        {
          paramView = null;
          continue;
        }
        if (paramd.containsKey("flipStatus"))
        {
          j = ((Integer)paramd.z("flipStatus", Integer.valueOf(0))).intValue();
          if (paramInt != 0) {
            break label193;
          }
          paramView = new SnsAdClick(paramInt, i, paramSnsInfo.field_snsId, eXH(), j, (byte)0);
          com.tencent.mm.plugin.sns.data.k.a(paramView, (com.tencent.mm.plugin.sns.ad.g.k)localObject, paramSnsInfo, 22);
          continue;
        }
        if (paramInt == 0)
        {
          i = j;
          paramView = new SnsAdClick(paramInt, i, paramSnsInfo.field_snsId, 22, eXH());
          continue;
        }
        i = 2;
      }
      catch (Throwable paramView)
      {
        return false;
      }
      continue;
      label190:
      return bool;
      label193:
      i = 2;
    }
  }
  
  protected abstract boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, ADXml paramADXml);
  
  protected abstract int eXH();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.c.a
 * JD-Core Version:    0.7.0.1
 */