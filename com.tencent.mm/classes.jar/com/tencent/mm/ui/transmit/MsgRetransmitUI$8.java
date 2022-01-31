package com.tencent.mm.ui.transmit;

import com.tencent.mm.as.e;
import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;

final class MsgRetransmitUI$8
  implements f.a
{
  MsgRetransmitUI$8(MsgRetransmitUI paramMsgRetransmitUI, bi parambi, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, e parame) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    if ((paramd != null) && (paramd.field_exist_whencheck))
    {
      y.i("MicroMsg.MsgRetransmitUI", "support second !! sceneResult:[%s]", new Object[] { paramd });
      MsgRetransmitUI.a(this.wgG, paramd, this.dUy, this.nkj, this.egy, this.vjd, this.vje, this.grU, this.eoK);
      return 0;
    }
    y.i("MicroMsg.MsgRetransmitUI", "not support second !! dealDownLoadImg");
    MsgRetransmitUI.a(this.wgG, this.epf, this.dUy, this.vje, this.nkj, this.egy, this.vjd);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.8
 * JD-Core Version:    0.7.0.1
 */