package com.tencent.mm.plugin.story.model.g;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.plugin.story.h.a;
import com.tencent.mm.plugin.story.model.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
public final class b$a
  implements com.tencent.mm.i.g.a
{
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(109443);
    j.q(paramString, "mediaId");
    if (paramInt == -21005)
    {
      ab.d(this.sAa.TAG, "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.sAa.fFo, Integer.valueOf(paramInt), paramc, paramd });
      this.sAa.szZ.a(0, true, (g)this.sAa);
      AppMethodBeat.o(109443);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode == 0))
    {
      ab.i(this.sAa.TAG, "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.sAa.fFo, Integer.valueOf(paramInt), paramc, paramd });
      b localb = this.sAa;
      String str = paramd.field_fileUrl;
      j.p(str, "sceneResult.field_fileUrl");
      paramString = a.sFV;
      paramInt = a.cDV();
      paramd = paramd.field_thumbUrl;
      j.p(paramd, "sceneResult.field_thumbUrl");
      paramString = a.sFV;
      int i = a.cDV();
      StringBuilder localStringBuilder = new StringBuilder("upload_ + ");
      paramc = this.sAa.fFo;
      paramString = paramc;
      if (paramc == null) {
        paramString = "null";
      }
      localb.a(str, paramInt, paramd, i, paramString);
      this.sAa.szZ.a(0, true, (g)this.sAa);
      AppMethodBeat.o(109443);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode != 0))
    {
      ab.i(this.sAa.TAG, "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.sAa.fFo, Integer.valueOf(paramInt), paramc, paramd });
      this.sAa.cCf();
      this.sAa.szZ.a(paramd.field_retCode, false, (g)this.sAa);
      AppMethodBeat.o(109443);
      return 0;
    }
    if (paramInt != 0)
    {
      ab.i(this.sAa.TAG, "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.sAa.fFo, Integer.valueOf(paramInt), paramc, paramd });
      this.sAa.cCf();
      this.sAa.szZ.a(paramInt, false, (g)this.sAa);
      AppMethodBeat.o(109443);
      return 0;
    }
    ab.d(this.sAa.TAG, "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.sAa.fFo, Integer.valueOf(paramInt), paramc, paramd });
    AppMethodBeat.o(109443);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(109444);
    j.q(paramString, "mediaId");
    j.q(paramByteArrayOutputStream, "buff");
    AppMethodBeat.o(109444);
  }
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109445);
    j.q(paramString, "mediaId");
    j.q(paramArrayOfByte, "inbuf");
    AppMethodBeat.o(109445);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.g.b.a
 * JD-Core Version:    0.7.0.1
 */