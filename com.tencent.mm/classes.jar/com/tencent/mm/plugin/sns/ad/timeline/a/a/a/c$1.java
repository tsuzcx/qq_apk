package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;

final class c$1
  implements b.a
{
  c$1(c paramc, Context paramContext) {}
  
  public final void b(String paramString, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(311404);
    Log.i("SnsAd.AdFinderLiveRoomClick.AdFinderLiveClick", "showLivingRoom, snsId=" + paramString + ", errCode=" + paramInt2 + ", actionType=" + paramInt1);
    if (paramInt2 != 0)
    {
      paramString = this.val$context;
      try
      {
        aa.dc(paramString, "进入直播间失败");
        AppMethodBeat.o(311404);
        return;
      }
      finally {}
    }
    AppMethodBeat.o(311404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.c.1
 * JD-Core Version:    0.7.0.1
 */