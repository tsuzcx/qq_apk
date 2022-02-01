package com.tencent.mm.plugin.sns.ad.timeline.a.a;

import android.view.View;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.timeline.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  implements c
{
  protected AdClickActionInfo PYe;
  
  protected abstract boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, AdClickActionInfo paramAdClickActionInfo, d paramd);
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      Log.w("SnsAd.AdActionButtonClick", "the sns info or adxml is null!!!");
      return false;
    }
    if (this.PYe != null) {
      try
      {
        boolean bool = a(paramView, paramInt, paramSnsInfo, this.PYe, paramd);
        return bool;
      }
      finally {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a
 * JD-Core Version:    0.7.0.1
 */