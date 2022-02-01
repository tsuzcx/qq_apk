package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.io.ByteArrayOutputStream;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/sticker/loader/StickerFileIdTask$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-sticker_release"})
public final class d$1
  implements g.a
{
  public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(105918);
    String str = this.IGM.TAG;
    StringBuilder localStringBuilder = new StringBuilder("callback: ").append(paramString).append(", ").append(paramInt).append("; progress ");
    if (paramc != null)
    {
      paramString = Long.valueOf(paramc.field_toltalLength);
      localStringBuilder = localStringBuilder.append(paramString).append(", ");
      if (paramc == null) {
        break label172;
      }
      paramString = Long.valueOf(paramc.field_finishedLength);
      label83:
      paramc = localStringBuilder.append(paramString).append("; result ");
      paramString = localObject;
      if (paramd != null) {
        paramString = Integer.valueOf(paramd.field_retCode);
      }
      ae.i(str, paramString);
      if (paramInt != 0) {
        break label177;
      }
      if (paramd != null)
      {
        if ((paramd.field_retCode != 0) || (!this.IGM.frW())) {
          break label177;
        }
        this.IGM.dg(true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(105918);
      return 0;
      paramString = null;
      break;
      label172:
      paramString = null;
      break label83;
      label177:
      this.IGM.dg(false);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.d.1
 * JD-Core Version:    0.7.0.1
 */