package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class f$a
  implements g.a
{
  private f$a(f paramf) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(82372);
    Log.d("MicroMsg.VestImgUploadEngine", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    paramc = this.QzU;
    if (paramd != null) {}
    try
    {
      if ((paramd.field_retCode != 0) || (paramInt != 0)) {
        return 0;
      }
      paramString = (String)this.QzU.QzR.get(paramString);
      if (!this.QzU.pqt.equals(paramString))
      {
        Log.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after CDNTaskCallback", new Object[] { this.QzU.pqt, paramString });
        return 0;
      }
      Log.i("MicroMsg.VestImgUploadEngine", "CDN upload success, file url = %s", new Object[] { paramd.field_fileUrl });
      paramString = new k(paramd.field_fileUrl, this.QzU.appId, paramString);
      h.aGY().a(paramString, 0);
      return 0;
    }
    finally
    {
      AppMethodBeat.o(82372);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.f.a
 * JD-Core Version:    0.7.0.1
 */