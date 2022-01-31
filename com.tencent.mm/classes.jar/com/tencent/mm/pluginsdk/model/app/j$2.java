package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.as.g;
import com.tencent.mm.as.o;
import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class j$2
  implements f.a
{
  j$2(j paramj, String paramString, j.a parama) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    y.i("MicroMsg.AppMessageExtension", "getThumbByCdn start callback: field_mediaId:%s thumbUrl:%s", new Object[] { paramString, this.eoz });
    if (paramInt != 0)
    {
      y.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: startRet:%d thumbUrl:%s", new Object[] { Integer.valueOf(paramInt), this.eoz });
      return paramInt;
    }
    if (paramd == null) {
      return 0;
    }
    if (paramd.field_retCode != 0) {
      y.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Integer.valueOf(paramd.field_retCode), this.eoz });
    }
    for (;;)
    {
      o.OJ().doNotify();
      if (this.rUr != null) {
        this.rUr.ckV();
      }
      return 0;
      y.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished thumbUrl:%s", new Object[] { this.eoz });
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.j.2
 * JD-Core Version:    0.7.0.1
 */