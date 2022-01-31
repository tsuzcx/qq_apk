package com.tencent.mm.plugin.scanner.util;

import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class p$1
  implements f.a
{
  p$1(p paramp) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    String str;
    if (paramc == null)
    {
      paramc = "null";
      if (paramd != null) {
        break label109;
      }
      str = "null";
      label16:
      y.i("MicroMsg.ScannerCdnService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramString, Integer.valueOf(paramInt), paramc, str });
      paramc = new p.b(this.nPV);
      if (paramInt == 0) {
        break label119;
      }
      y.e("MicroMsg.ScannerCdnService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
      paramc.errCode = paramInt;
      p.a(this.nPV, paramString, paramc);
    }
    label109:
    label119:
    while (paramd == null)
    {
      return 0;
      paramc = paramc.toString();
      break;
      str = paramd.toString();
      break label16;
    }
    paramc.errCode = paramd.field_retCode;
    if (paramd.field_retCode != 0) {
      y.e("MicroMsg.ScannerCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramString, Integer.valueOf(paramd.field_retCode), paramd });
    }
    for (;;)
    {
      p.a(this.nPV, paramString, paramc);
      return 0;
      y.i("MicroMsg.ScannerCdnService", "cdn trans suceess, media id : %s", new Object[] { paramString });
      paramc.fileId = paramd.field_fileId;
      paramc.aeskey = paramd.field_aesKey;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    y.i("MicroMsg.ScannerCdnService", "getCdnAuthInfo, mediaId = %s", new Object[] { paramString });
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.ScannerCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramString });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.p.1
 * JD-Core Version:    0.7.0.1
 */