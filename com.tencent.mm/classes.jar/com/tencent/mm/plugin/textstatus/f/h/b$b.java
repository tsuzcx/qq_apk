package com.tencent.mm.plugin.textstatus.f.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$uploadFileToCDN$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-textstatus_release"})
public final class b$b
  implements g.a
{
  b$b(b.a parama) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(216304);
    p.h(paramString, "mediaId");
    if (paramInt == -21005)
    {
      Log.d("MicroMsg.TxtStatus.TextStatusUploader", "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(216304);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode == 0))
    {
      Log.i("MicroMsg.TxtStatus.TextStatusUploader", "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      this.FZV.a(0, true, paramd);
      AppMethodBeat.o(216304);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode != 0))
    {
      Log.i("MicroMsg.TxtStatus.TextStatusUploader", "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      this.FZV.a(paramd.field_retCode, false, paramd);
      AppMethodBeat.o(216304);
      return 0;
    }
    if (paramInt != 0)
    {
      Log.i("MicroMsg.TxtStatus.TextStatusUploader", "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      this.FZV.a(paramInt, false, paramd);
      AppMethodBeat.o(216304);
      return 0;
    }
    Log.d("MicroMsg.TxtStatus.TextStatusUploader", "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    AppMethodBeat.o(216304);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(216305);
    p.h(paramString, "mediaId");
    p.h(paramByteArrayOutputStream, "buff");
    AppMethodBeat.o(216305);
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216306);
    p.h(paramString, "mediaId");
    p.h(paramArrayOfByte, "inbuf");
    AppMethodBeat.o(216306);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.h.b.b
 * JD-Core Version:    0.7.0.1
 */