package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.h;
import com.tencent.mm.modelvideo.h.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;

final class j$4
  implements g.a
{
  j$4(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, bi parambi, int paramInt3) {}
  
  public final int a(final String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(30536);
    if (paramd != null)
    {
      if (!paramd.field_exist_whencheck) {
        break label343;
      }
      paramd.field_fileId = this.val$url;
      paramd.field_aesKey = this.vkd;
      paramd.field_thumbimgLength = this.fEX;
      paramd.field_fileLength = this.pZP;
      paramd.field_toUser = this.bZZ;
      paramd.field_filemd5 = this.iiy;
      paramd.field_mp4identifymd5 = this.zyg;
      ab.i("MicroMsg.ChattingEditModeLogic", "support second!! sceneResult: %s", new Object[] { paramd });
      paramString = t.ve(r.Zn());
      o.alE();
      paramc = t.vg(paramString);
      o.alE();
      e.C(t.vg(this.fkH.field_imgPath), paramc);
      paramc = "<msg><videomsg aeskey=\"" + this.vkd + "\" cdnthumbaeskey=\"" + this.vkd + "\" cdnvideourl=\"" + this.val$url + "\" ";
      paramc = paramc + "cdnthumburl=\"" + this.val$url + "\" ";
      paramc = paramc + "length=\"" + this.pZP + "\" ";
      paramc = paramc + "cdnthumblength=\"" + this.fEX + "\"/></msg>";
      ab.i("MicroMsg.ChattingEditModeLogic", "cdn callback new build cdnInfo:%s", new Object[] { paramc });
      u.d(paramString, this.zyh, this.bZZ, paramc);
      g.Rc().a(new h(paramString, 0, paramd, new h.a()
      {
        public final void cG(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(30535);
          s locals = u.vr(paramString);
          locals.status = 111;
          locals.bsY = 256;
          o.alE().c(locals);
          ab.d("MicroMsg.ChattingEditModeLogic", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(30535);
        }
      }), 0);
    }
    for (;;)
    {
      AppMethodBeat.o(30536);
      return 0;
      label343:
      j.e(this.bZZ, this.fkH);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.4
 * JD-Core Version:    0.7.0.1
 */