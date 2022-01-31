package com.tencent.mm.plugin.normsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.io.File;

final class PluginNormsg$1
  implements g.a
{
  PluginNormsg$1(PluginNormsg paramPluginNormsg, File paramFile1, File paramFile2) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(10350);
    if (paramInt == -21006)
    {
      ab.w("MicroMsg.PluginNormsg", "uccek: duplicate request to download meta, ignore this request.");
      AppMethodBeat.o(10350);
      return 0;
    }
    if (paramInt != 0)
    {
      ab.e("MicroMsg.PluginNormsg", "uccek: start failed : %d", new Object[] { Integer.valueOf(paramInt) });
      h.qsU.j(876L, 3L, 1L);
      AppMethodBeat.o(10350);
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode == 0) {
        break label158;
      }
      ab.e("MicroMsg.PluginNormsg", "uccek: download failure, sceneResult.retCode:%d sceneResult[%s]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd });
      if ((paramc != null) && (paramc.field_finishedLength > 0))
      {
        ab.w("MicroMsg.PluginNormsg", "uccek: download interrupt, clear broken file.");
        this.pgN.delete();
      }
      h.qsU.j(876L, 4L, 1L);
    }
    for (;;)
    {
      AppMethodBeat.o(10350);
      return 0;
      label158:
      ab.i("MicroMsg.PluginNormsg", "uccek: cdn trans suceess.");
      this.pgN.renameTo(this.pgO);
      h.qsU.j(876L, 2L, 1L);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.PluginNormsg.1
 * JD-Core Version:    0.7.0.1
 */