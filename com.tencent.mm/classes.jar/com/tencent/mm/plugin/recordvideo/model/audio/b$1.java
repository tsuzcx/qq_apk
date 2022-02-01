package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask$2", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$1
  implements g.a
{
  b$1(b paramb, String paramString1, String paramString2) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(75406);
    s.u(paramString, "mediaId");
    String str2 = b.a(this.NJc);
    Object localObject;
    if (paramc == null)
    {
      paramc = "null";
      if (paramd != null) {
        break label169;
      }
      localObject = "null";
      label36:
      Log.d(str2, "AudioDownloadTask on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramString, Integer.valueOf(paramInt), paramc, localObject });
      if (paramd == null) {
        break label227;
      }
      if (paramd.field_retCode != 0) {
        break label192;
      }
      Log.i(b.a(this.NJc), "download success " + paramString + ' ' + this.eWL);
      y.qn(this.NJd, this.eWL);
      b.a(this.NJc, true, this.eWL);
    }
    for (;;)
    {
      AppMethodBeat.o(75406);
      return 0;
      localObject = paramc.toString();
      paramc = (c)localObject;
      if (localObject != null) {
        break;
      }
      paramc = "null";
      break;
      label169:
      String str1 = paramd.toString();
      localObject = str1;
      if (str1 != null) {
        break label36;
      }
      localObject = "null";
      break label36;
      label192:
      Log.w(b.a(this.NJc), s.X("download fail sceneResult ", Integer.valueOf(paramd.field_retCode)));
      b.a(this.NJc, false, null);
      continue;
      label227:
      if (paramInt != 0)
      {
        Log.w(b.a(this.NJc), s.X("download fail startRet ", Integer.valueOf(paramInt)));
        b.a(this.NJc, false, null);
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(75407);
    s.u(paramString, "mediaId");
    s.u(paramByteArrayOutputStream, "buff");
    AppMethodBeat.o(75407);
  }
  
  public final byte[] h(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75408);
    s.u(paramString, "mediaId");
    s.u(paramArrayOfByte, "inbuf");
    AppMethodBeat.o(75408);
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.b.1
 * JD-Core Version:    0.7.0.1
 */