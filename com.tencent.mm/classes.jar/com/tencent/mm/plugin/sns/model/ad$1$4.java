package com.tencent.mm.plugin.sns.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.sdk.platformtools.ah;

final class ad$1$4
  implements Runnable
{
  ad$1$4(ad.1 param1, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(145252);
    ah.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(this.Cq, true).commit();
    this.rgc.rgb.ibL.ad(this.Cq, this.qac);
    ag.cpa().aaa(this.Cq);
    AppMethodBeat.o(145252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ad.1.4
 * JD-Core Version:    0.7.0.1
 */