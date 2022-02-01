package com.tencent.mm.plugin.selectrecord.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class b$1
  implements g.a
{
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(207401);
    ad.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[] { paramString, Integer.valueOf(paramInt), paramd });
    if (paramd != null) {
      try
      {
        if (paramd.field_retCode == 0)
        {
          paramString = (Pair)b.access$000().get(paramString);
          if (paramString == null) {
            ad.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, pair is null??");
          }
          for (;;)
          {
            AppMethodBeat.o(207401);
            return 0;
            paramc = new String(i.aY((String)paramString.second, 0, -1));
            paramd = b.zg(((Long)paramString.first).longValue());
            if (i.fv(paramd)) {
              i.deleteFile(paramd);
            }
            long l = i.mz((String)paramString.second, paramd);
            paramBoolean = i.deleteFile((String)paramString.second);
            ad.d("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn callback, msgId:%s filePath:%s xml:%s result:%s delResult:%s", new Object[] { paramString.first, paramString.second, bt.aRp(paramc), Long.valueOf(l), Boolean.valueOf(paramBoolean) });
            paramd = (a)b.aaT().get(paramString.first);
            if (paramd != null) {
              paramd.B(((Long)paramString.first).longValue(), paramc);
            }
          }
          AppMethodBeat.o(207401);
        }
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "callback %s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      }
    }
    for (;;)
    {
      return 0;
      if (paramc != null) {
        ad.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "cdn process: %f", new Object[] { Double.valueOf(paramc.field_finishedLength / paramc.field_toltalLength) });
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(207399);
    ad.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "getCdnAuthInfo, mediaId = %s", new Object[] { paramString });
    AppMethodBeat.o(207399);
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207400);
    ad.i("MicroMsg.sysmsg.SysMsgTemplateLinkHandlerHistory", "decodePrepareResponse, mediaId = %s", new Object[] { paramString });
    AppMethodBeat.o(207400);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.d.b.1
 * JD-Core Version:    0.7.0.1
 */