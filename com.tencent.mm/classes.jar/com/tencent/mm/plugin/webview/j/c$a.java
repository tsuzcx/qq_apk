package com.tencent.mm.plugin.webview.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class c$a
  implements g.a
{
  private c$a(c paramc) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(82372);
    ae.d("MicroMsg.VestImgUploadEngine", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    paramc = this.ELz;
    if (paramd != null) {}
    try
    {
      if ((paramd.field_retCode != 0) || (paramInt != 0)) {
        return 0;
      }
      paramString = (String)this.ELz.ELw.get(paramString);
      if (!this.ELz.lmo.equals(paramString))
      {
        ae.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after CDNTaskCallback", new Object[] { this.ELz.lmo, paramString });
        return 0;
      }
      ae.i("MicroMsg.VestImgUploadEngine", "CDN upload success, file url = %s", new Object[] { paramd.field_fileUrl });
      paramString = new k(paramd.field_fileUrl, this.ELz.appId, paramString);
      g.ajj().a(paramString, 0);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.j.c.a
 * JD-Core Version:    0.7.0.1
 */