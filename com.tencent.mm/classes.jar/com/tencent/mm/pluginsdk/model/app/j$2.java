package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;

final class j$2
  implements g.a
{
  WeakReference<j.a> vLo;
  
  j$2(j paramj, j.a parama, String paramString)
  {
    AppMethodBeat.i(27313);
    this.vLo = new WeakReference(this.vLp);
    AppMethodBeat.o(27313);
  }
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(27314);
    ab.i("MicroMsg.AppMessageExtension", "getThumbByCdn start callback: field_mediaId:%s thumbUrl:%s", new Object[] { paramString, this.fEW });
    if (paramInt != 0)
    {
      ab.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: startRet:%d thumbUrl:%s", new Object[] { Integer.valueOf(paramInt), this.fEW });
      AppMethodBeat.o(27314);
      return paramInt;
    }
    if (paramd == null)
    {
      AppMethodBeat.o(27314);
      return 0;
    }
    if (paramd.field_retCode != 0) {
      ab.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Integer.valueOf(paramd.field_retCode), this.fEW });
    }
    for (;;)
    {
      o.ahC().doNotify();
      paramString = (j.a)this.vLo.get();
      if (paramString != null) {
        paramString.dlE();
      }
      AppMethodBeat.o(27314);
      return 0;
      ab.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished thumbUrl:%s", new Object[] { this.fEW });
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.j.2
 * JD-Core Version:    0.7.0.1
 */