package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.h;
import com.tencent.mm.plugin.profile.ui.newbizinfo.d.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.y;

public final class c
{
  public static final void K(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(193322);
    Object localObject = com.tencent.mm.plugin.profile.c.dAf().auS(paramString);
    if (localObject != null) {}
    for (localObject = ((h)localObject).field_decryptUserName;; localObject = "")
    {
      ad.d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d decryptUserName:%s, enterTimestamp: %d", new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(4), localObject, Long.valueOf(paramLong) });
      g.yhR.f(13307, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(4), localObject, Integer.valueOf(y.getSessionId()), Integer.valueOf(0), Long.valueOf(paramLong) });
      AppMethodBeat.o(193322);
      return;
    }
  }
  
  public static final void b(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(193323);
    Object localObject = com.tencent.mm.plugin.profile.c.dAf().auS(paramString);
    if (localObject != null) {}
    for (localObject = ((h)localObject).field_decryptUserName;; localObject = "")
    {
      ad.d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d decryptUserName:%s, profileScene: %d, enterTimestamp: %s", new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt1), Integer.valueOf(4), localObject, Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      g.yhR.f(13307, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt1), Integer.valueOf(4), localObject, Integer.valueOf(y.getSessionId()), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      AppMethodBeat.o(193323);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.c
 * JD-Core Version:    0.7.0.1
 */