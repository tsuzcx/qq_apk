package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.d;
import com.tencent.mm.plugin.profile.ui.newbizinfo.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;

public final class c
{
  public static final void I(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(231964);
    Object localObject = d.eDO().aKz(paramString);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.h)localObject).field_decryptUserName;; localObject = "")
    {
      Log.d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d decryptUserName:%s, enterTimestamp: %d", new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(4), localObject, Long.valueOf(paramLong) });
      com.tencent.mm.plugin.report.service.h.CyF.a(13307, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(4), localObject, Integer.valueOf(ab.getSessionId()), Integer.valueOf(0), Long.valueOf(paramLong) });
      AppMethodBeat.o(231964);
      return;
    }
  }
  
  public static final void c(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(231965);
    Object localObject = d.eDO().aKz(paramString);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.h)localObject).field_decryptUserName;; localObject = "")
    {
      Log.d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d decryptUserName:%s, profileScene: %d, enterTimestamp: %s", new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt1), Integer.valueOf(4), localObject, Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      com.tencent.mm.plugin.report.service.h.CyF.a(13307, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt1), Integer.valueOf(4), localObject, Integer.valueOf(ab.getSessionId()), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      AppMethodBeat.o(231965);
      return;
    }
  }
  
  public static final ArrayList<String> fd(String paramString, final int paramInt)
  {
    AppMethodBeat.i(231966);
    Object localObject = d.eDO().aKz(paramString);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.h)localObject).field_decryptUserName;; localObject = "")
    {
      int i = ab.getSessionId();
      Log.d("MicroMsg.Kv13307", "getArgs username:%s scene::%s optype:%d opscene:%d decryptUserName:%s profileScene:%d", new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(1302), Integer.valueOf(4), localObject, Integer.valueOf(paramInt) });
      paramString = new ArrayList() {};
      AppMethodBeat.o(231966);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.c
 * JD-Core Version:    0.7.0.1
 */