package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$checkCDNImage$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "p1", "Ljava/io/ByteArrayOutputStream;", "plugin-scan_release"})
public final class a$b
  implements g.a
{
  a$b(e parame, g paramg) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    String str = null;
    AppMethodBeat.i(223208);
    if (paramInt != 0)
    {
      Log.e("MicroMsg.AIScanImageCdnUploadUtil", "checkCDNImage AIScanImageCdnUploader upload start fail: ".concat(String.valueOf(paramInt)));
      this.IJg.a(new h(3, 402));
      AppMethodBeat.o(223208);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder("checkCDNImage callback, mediaId:").append(paramString).append(" len:");
    if (paramc != null)
    {
      paramString = Long.valueOf(paramc.field_finishedLength);
      localStringBuilder = localStringBuilder.append(paramString).append(", totalLen:");
      if (paramc == null) {
        break label222;
      }
      paramString = Long.valueOf(paramc.field_toltalLength);
      label110:
      paramc = localStringBuilder.append(paramString).append(", sceneResult.retCode: ");
      paramString = str;
      if (paramd != null) {
        paramString = Integer.valueOf(paramd.field_retCode);
      }
      Log.i("MicroMsg.AIScanImageCdnUploadUtil", paramString);
      if (paramd != null)
      {
        if (paramd.field_retCode == 0) {
          break label227;
        }
        Log.e("MicroMsg.AIScanImageCdnUploadUtil", "checkCDNImage result fail: " + paramd.field_retCode);
        this.IJg.a(new h(3, 403));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(223208);
      return 0;
      paramString = null;
      break;
      label222:
      paramString = null;
      break label110;
      label227:
      Log.i("MicroMsg.AIScanImageCdnUploadUtil", "checkCDNImage success");
      paramString = this.IJg;
      paramc = new h(0, 0);
      paramc.IJN = true;
      paramc.lNK = this.IJh.lNK;
      str = paramd.field_fileId;
      p.j(str, "sceneResult.field_fileId");
      p.k(str, "<set-?>");
      paramc.fileId = str;
      paramd = paramd.field_aesKey;
      p.j(paramd, "sceneResult.field_aesKey");
      p.k(paramd, "<set-?>");
      paramc.aesKey = paramd;
      paramString.a(paramc);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(223203);
    Log.i("MicroMsg.AIScanImageCdnUploadUtil", "checkCDNImage getCdnAuthInfo, mediaId = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(223203);
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(223209);
    Log.i("MicroMsg.AIScanImageCdnUploadUtil", "decodePrepareResponse, mediaId = %s", new Object[] { paramString });
    AppMethodBeat.o(223209);
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a.b
 * JD-Core Version:    0.7.0.1
 */