package com.tencent.mm.plugin.story.model.audio;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/model/audio/AudioDownloadTask$2", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
public final class b$1
  implements g.a
{
  b$1(String paramString1, String paramString2) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(109177);
    j.q(paramString, "mediaId");
    String str2 = this.swF.TAG;
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
    ab.d(str2, "AudioDownloadTask on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramString, Integer.valueOf(paramInt), paramc, localObject });
    if (paramd != null) {
      if (paramd.field_retCode == 0)
      {
        ab.i(this.swF.TAG, "download success " + paramString + ' ' + this.swG);
        e.aT(this.swH, this.swG);
        b.a(this.swF, true, this.swG);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(109177);
      return 0;
      ab.w(this.swF.TAG, "download fail sceneResult " + paramd.field_retCode);
      b.a(this.swF, false, null);
      continue;
      if (paramInt != 0)
      {
        ab.w(this.swF.TAG, "download fail startRet ".concat(String.valueOf(paramInt)));
        b.a(this.swF, false, null);
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(109178);
    j.q(paramString, "mediaId");
    j.q(paramByteArrayOutputStream, "buff");
    AppMethodBeat.o(109178);
  }
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109179);
    j.q(paramString, "mediaId");
    j.q(paramArrayOfByte, "inbuf");
    AppMethodBeat.o(109179);
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.audio.b.1
 * JD-Core Version:    0.7.0.1
 */