package com.tencent.mm.plugin.sns.ad.timeline.a.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;

final class b$1
  implements b.a
{
  b$1(b paramb, Context paramContext) {}
  
  public final void b(String paramString, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(311371);
    Log.i("SnsAd.FinderLiveClick.AdFinderLiveClick", "showLivingRoom, the FinderLiveClick is called, snsId " + paramString + ", errorCode=" + paramInt2 + ", actType=" + paramInt1);
    if (paramInt2 != 0)
    {
      paramString = this.val$context;
      try
      {
        aa.dc(paramString, "进入直播间失败");
        AppMethodBeat.o(311371);
        return;
      }
      finally {}
    }
    AppMethodBeat.o(311371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.c.a.b.1
 * JD-Core Version:    0.7.0.1
 */