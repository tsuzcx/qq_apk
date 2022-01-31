package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.network.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class c$1
  implements f.a
{
  c$1(c paramc) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, d paramd, boolean paramBoolean)
  {
    paramInt = 2;
    if (paramd != null) {
      if (this.ovj.ouO != null) {}
    }
    float f;
    do
    {
      do
      {
        return 0;
        if (paramd.field_retCode != 0) {
          b.reportFailIp(paramd.field_serverIP);
        }
        for (;;)
        {
          this.ovj.b(paramd);
          af.aXq().post(new c.1.1(this, paramInt, paramd));
          return 0;
          this.ovj.ovi = paramd.field_fileLength;
          if (this.ovj.bEs()) {
            if (this.ovj.ouO.ouH) {
              paramInt = 3;
            } else {
              paramInt = 1;
            }
          }
        }
      } while (paramc == null);
      f = paramc.field_finishedLength / paramc.field_toltalLength;
    } while (this.ovj.ouO.ouL >= f);
    this.ovj.ouO.ouL = f;
    y.d("MicroMsg.SnsCdnDownloadBase", "Download sns image type: %d, mediaId: %s, progress: %f, url: %s", new Object[] { Integer.valueOf(this.ovj.ouO.ouJ), paramString, Float.valueOf(f), this.ovj.ouO.url });
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.c.1
 * JD-Core Version:    0.7.0.1
 */