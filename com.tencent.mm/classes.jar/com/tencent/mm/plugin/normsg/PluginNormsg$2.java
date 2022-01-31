package com.tencent.mm.plugin.normsg;

import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.File;

final class PluginNormsg$2
  implements f.a
{
  PluginNormsg$2(PluginNormsg paramPluginNormsg, File paramFile1, File paramFile2) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    if (paramInt == -21006) {
      y.w("MicroMsg.PluginNormsg", "urqtk: duplicate request to download meta, ignore this request.");
    }
    do
    {
      return 0;
      if (paramInt != 0)
      {
        y.e("MicroMsg.PluginNormsg", "urqtk: start failed : %d", new Object[] { Integer.valueOf(paramInt) });
        h.nFQ.h(876L, 30L, 1L);
        return 0;
      }
    } while (paramd == null);
    if (paramd.field_retCode != 0)
    {
      y.e("MicroMsg.PluginNormsg", "urqtk: download failure, sceneResult.retCode:%d sceneResult[%s]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd });
      if ((paramc != null) && (paramc.field_finishedLength > 0))
      {
        y.w("MicroMsg.PluginNormsg", "urqtk: download interrupt, clear broken file.");
        this.mGH.delete();
      }
      h.nFQ.h(876L, 31L, 1L);
      return 0;
    }
    y.i("MicroMsg.PluginNormsg", "urqtk: cdn trans suceess.");
    this.mGH.renameTo(this.mGI);
    h.nFQ.h(876L, 29L, 1L);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.PluginNormsg.2
 * JD-Core Version:    0.7.0.1
 */