package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$checkCDNImage$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "p1", "Ljava/io/ByteArrayOutputStream;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  implements g.a
{
  a$b(e parame, g paramg) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(313675);
    if (paramInt != 0)
    {
      Log.e("MicroMsg.AIScanImageCdnUploadUtil", s.X("checkCDNImage AIScanImageCdnUploader upload start fail: ", Integer.valueOf(paramInt)));
      this.OPU.a(new h(3, 402));
      AppMethodBeat.o(313675);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder("checkCDNImage callback, mediaId:").append(paramString).append(" len:");
    if (paramc == null)
    {
      paramString = null;
      localStringBuilder = localStringBuilder.append(paramString).append(", totalLen:");
      if (paramc != null) {
        break label208;
      }
      paramString = null;
      label98:
      paramc = localStringBuilder.append(paramString).append(", sceneResult.retCode: ");
      if (paramd != null) {
        break label219;
      }
      paramString = (String)localObject;
      label118:
      Log.i("MicroMsg.AIScanImageCdnUploadUtil", paramString);
      if (paramd != null)
      {
        paramString = this.OPU;
        localObject = this.OPV;
        if (paramd.field_retCode == 0) {
          break label231;
        }
        Log.e("MicroMsg.AIScanImageCdnUploadUtil", s.X("checkCDNImage result fail: ", Integer.valueOf(paramd.field_retCode)));
        paramString.a(new h(3, 403));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(313675);
      return 0;
      paramString = Long.valueOf(paramc.field_finishedLength);
      break;
      label208:
      paramString = Long.valueOf(paramc.field_toltalLength);
      break label98;
      label219:
      paramString = Integer.valueOf(paramd.field_retCode);
      break label118;
      label231:
      Log.i("MicroMsg.AIScanImageCdnUploadUtil", "checkCDNImage success");
      paramc = new h(0, 0);
      paramc.OQA = true;
      paramc.oGu = ((g)localObject).oGu;
      localObject = paramd.field_fileId;
      s.s(localObject, "sceneResult.field_fileId");
      s.u(localObject, "<set-?>");
      paramc.fileId = ((String)localObject);
      paramd = paramd.field_aesKey;
      s.s(paramd, "sceneResult.field_aesKey");
      s.u(paramd, "<set-?>");
      paramc.aesKey = paramd;
      paramd = ah.aiuX;
      paramString.a(paramc);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(313664);
    Log.i("MicroMsg.AIScanImageCdnUploadUtil", s.X("checkCDNImage getCdnAuthInfo, mediaId = ", paramString));
    AppMethodBeat.o(313664);
  }
  
  public final byte[] h(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(313681);
    Log.i("MicroMsg.AIScanImageCdnUploadUtil", "decodePrepareResponse, mediaId = %s", new Object[] { paramString });
    AppMethodBeat.o(313681);
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a.b
 * JD-Core Version:    0.7.0.1
 */