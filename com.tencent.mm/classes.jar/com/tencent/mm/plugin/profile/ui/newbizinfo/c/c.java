package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.d;
import com.tencent.mm.plugin.profile.ui.newbizinfo.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ad;

public final class c
{
  public static final void a(String paramString, int paramInt1, int paramInt2, long paramLong, Intent paramIntent)
  {
    AppMethodBeat.i(305810);
    Object localObject = d.gAR().aSe(paramString);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.c)localObject).field_decryptUserName;; localObject = "")
    {
      Log.d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d decryptUserName:%s, profileScene: %d, enterTimestamp: %s", new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt1), Integer.valueOf(4), localObject, Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      paramIntent = com.tencent.mm.plugin.profile.c.bn(paramIntent);
      h.OAn.b(13307, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt1), Integer.valueOf(4), localObject, Integer.valueOf(ad.getSessionId()), Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramIntent, Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(305810);
      return;
    }
  }
  
  public static final void a(String paramString, int paramInt, long paramLong, Intent paramIntent)
  {
    AppMethodBeat.i(305804);
    Object localObject = d.gAR().aSe(paramString);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.c)localObject).field_decryptUserName;; localObject = "")
    {
      Log.d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d decryptUserName:%s, enterTimestamp: %d", new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(4), localObject, Long.valueOf(paramLong) });
      paramIntent = com.tencent.mm.plugin.profile.c.bn(paramIntent);
      h.OAn.b(13307, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(4), localObject, Integer.valueOf(ad.getSessionId()), Integer.valueOf(0), Long.valueOf(paramLong), paramIntent, Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(305804);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.c
 * JD-Core Version:    0.7.0.1
 */