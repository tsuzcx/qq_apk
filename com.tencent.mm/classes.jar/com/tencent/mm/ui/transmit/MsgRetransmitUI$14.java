package com.tencent.mm.ui.transmit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.h;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;

final class MsgRetransmitUI$14
  implements g.a
{
  MsgRetransmitUI$14(MsgRetransmitUI paramMsgRetransmitUI, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, int paramInt3) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(35078);
    if (paramd != null)
    {
      if (!paramd.field_exist_whencheck) {
        break label348;
      }
      paramd.field_fileId = this.val$url;
      paramd.field_aesKey = this.vkd;
      paramd.field_thumbimgLength = this.fEX;
      paramd.field_fileLength = this.pZP;
      paramd.field_toUser = this.bZZ;
      paramd.field_filemd5 = this.iiy;
      paramd.field_mp4identifymd5 = this.zyg;
      ab.i("MicroMsg.MsgRetransmitUI", "support second!! sceneResult: %s", new Object[] { paramd });
      paramString = t.ve(r.Zn());
      o.alE();
      paramc = t.vg(paramString);
      o.alE();
      e.C(t.vg(this.Azx.fileName), paramc);
      paramc = "<msg><videomsg aeskey=\"" + this.vkd + "\" cdnthumbaeskey=\"" + this.vkd + "\" cdnvideourl=\"" + this.val$url + "\" ";
      paramc = paramc + "cdnthumburl=\"" + this.val$url + "\" ";
      paramc = paramc + "length=\"" + this.pZP + "\" ";
      paramc = paramc + "cdnthumblength=\"" + this.fEX + "\"/></msg>";
      ab.i("MicroMsg.MsgRetransmitUI", "cdn callback new build cdnInfo:%s", new Object[] { paramc });
      u.d(paramString, this.zyh, this.bZZ, paramc);
      g.Rc().a(new h(paramString, 0, paramd, new MsgRetransmitUI.14.1(this, paramString)), 0);
      this.Azx.finish();
    }
    for (;;)
    {
      AppMethodBeat.o(35078);
      return 0;
      label348:
      ab.i("MicroMsg.MsgRetransmitUI", "not support second!! dealDownloadVideo");
      MsgRetransmitUI.i(this.Azx);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.14
 * JD-Core Version:    0.7.0.1
 */