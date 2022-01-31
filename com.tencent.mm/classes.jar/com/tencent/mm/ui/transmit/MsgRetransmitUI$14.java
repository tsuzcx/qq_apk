package com.tencent.mm.ui.transmit;

import com.tencent.mm.ah.p;
import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvideo.h;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;

final class MsgRetransmitUI$14
  implements f.a
{
  MsgRetransmitUI$14(MsgRetransmitUI paramMsgRetransmitUI, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, int paramInt3) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    if ((paramd != null) && (paramd.field_exist_whencheck))
    {
      paramd.field_fileId = this.val$url;
      paramd.field_aesKey = this.vjg;
      paramd.field_thumbimgLength = this.eoA;
      paramd.field_fileLength = this.nug;
      paramd.field_toUser = this.bxX;
      paramd.field_filemd5 = this.grU;
      paramd.field_mp4identifymd5 = this.vjh;
      y.i("MicroMsg.MsgRetransmitUI", "support second!! sceneResult: %s", new Object[] { paramd });
      paramString = t.nR(q.Gj());
      o.Sr();
      paramc = t.nT(paramString);
      o.Sr();
      e.r(t.nT(this.wgG.fileName), paramc);
      paramc = "<msg><videomsg aeskey=\"" + this.vjg + "\" cdnthumbaeskey=\"" + this.vjg + "\" cdnvideourl=\"" + this.val$url + "\" ";
      paramc = paramc + "cdnthumburl=\"" + this.val$url + "\" ";
      paramc = paramc + "length=\"" + this.nug + "\" ";
      paramc = paramc + "cdnthumblength=\"" + this.eoA + "\"/></msg>";
      y.i("MicroMsg.MsgRetransmitUI", "cdn callback new build cdnInfo:%s", new Object[] { paramc });
      u.d(paramString, this.vji, this.bxX, paramc);
      g.Dk().a(new h(paramString, 0, paramd, new MsgRetransmitUI.14.1(this, paramString)), 0);
      this.wgG.finish();
      return 0;
    }
    y.i("MicroMsg.MsgRetransmitUI", "not support second!! dealDownloadVideo");
    MsgRetransmitUI.i(this.wgG);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.14
 * JD-Core Version:    0.7.0.1
 */