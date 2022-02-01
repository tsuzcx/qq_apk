package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.u;

public final class c
{
  public static final void L(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27596);
    Object localObject = com.tencent.mm.plugin.profile.c.dbU().akN(paramString);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.h)localObject).field_decryptUserName;; localObject = "")
    {
      ad.d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d decryptUserName:%s, profileScene: %d", new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt1), Integer.valueOf(4), localObject, Integer.valueOf(paramInt2) });
      com.tencent.mm.plugin.report.service.h.vKh.f(13307, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt1), Integer.valueOf(4), localObject, Integer.valueOf(u.getSessionId()), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(27596);
      return;
    }
  }
  
  public static final void bO(String paramString, int paramInt)
  {
    AppMethodBeat.i(27595);
    Object localObject = com.tencent.mm.plugin.profile.c.dbU().akN(paramString);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.h)localObject).field_decryptUserName;; localObject = "")
    {
      ad.d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d decryptUserName:%s", new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(4), localObject });
      com.tencent.mm.plugin.report.service.h.vKh.f(13307, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(4), localObject, Integer.valueOf(u.getSessionId()) });
      AppMethodBeat.o(27595);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.c
 * JD-Core Version:    0.7.0.1
 */