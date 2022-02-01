package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.io.ByteArrayOutputStream;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask$2", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-recordvideo_release"})
public final class b$1
  implements g.a
{
  b$1(String paramString1, String paramString2) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(75406);
    k.h(paramString, "mediaId");
    String str2 = this.wrD.TAG;
    Object localObject;
    if (paramc != null)
    {
      localObject = paramc.toString();
      paramc = (c)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramc = "null";
    }
    if (paramd != null)
    {
      String str1 = paramd.toString();
      localObject = str1;
      if (str1 != null) {}
    }
    else
    {
      localObject = "null";
    }
    ac.d(str2, "AudioDownloadTask on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramString, Integer.valueOf(paramInt), paramc, localObject });
    if (paramd != null) {
      if (paramd.field_retCode == 0)
      {
        ac.i(this.wrD.TAG, "download success " + paramString + ' ' + this.kaI);
        i.ma(this.wrE, this.kaI);
        b.a(this.wrD, true, this.kaI);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(75406);
      return 0;
      ac.w(this.wrD.TAG, "download fail sceneResult " + paramd.field_retCode);
      b.a(this.wrD, false, null);
      continue;
      if (paramInt != 0)
      {
        ac.w(this.wrD.TAG, "download fail startRet ".concat(String.valueOf(paramInt)));
        b.a(this.wrD, false, null);
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(75407);
    k.h(paramString, "mediaId");
    k.h(paramByteArrayOutputStream, "buff");
    AppMethodBeat.o(75407);
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75408);
    k.h(paramString, "mediaId");
    k.h(paramArrayOfByte, "inbuf");
    AppMethodBeat.o(75408);
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.b.1
 * JD-Core Version:    0.7.0.1
 */