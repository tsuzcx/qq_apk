package com.tencent.mm.ui.transmit;

import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.pluginsdk.model.app.aa.a;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class MsgRetransmitUI$19
  implements aa.a
{
  MsgRetransmitUI$19(MsgRetransmitUI paramMsgRetransmitUI, g.a parama1, g.a parama2, String paramString, byte[] paramArrayOfByte) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    y.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", new Object[] { paramString1, bk.aac(paramString2), bk.aac(paramString3), bk.aac(this.gBQ.dQR), bk.aac(paramString4), bk.aac(paramString5) });
    if (!bk.bl(paramString3))
    {
      l.a(this.wgM, this.gBQ.appId, this.gBQ.appName, this.bxX, "", this.wgN, MsgRetransmitUI.a(this.wgG), paramString3);
      return;
    }
    h.b(this.wgG, this.wgG.getString(R.l.contain_undownload_msg), "", true);
    this.wgG.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.19
 * JD-Core Version:    0.7.0.1
 */