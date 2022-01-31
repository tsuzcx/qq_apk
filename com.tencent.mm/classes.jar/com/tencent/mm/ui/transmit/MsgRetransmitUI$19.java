package com.tencent.mm.ui.transmit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.z.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class MsgRetransmitUI$19
  implements z.a
{
  MsgRetransmitUI$19(MsgRetransmitUI paramMsgRetransmitUI, j.b paramb1, j.b paramb2, String paramString, byte[] paramArrayOfByte) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    AppMethodBeat.i(35083);
    ab.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", new Object[] { paramString1, bo.aqg(paramString2), bo.aqg(paramString3), bo.aqg(this.iaj.ewj), bo.aqg(paramString4), bo.aqg(paramString5) });
    if (!bo.isNullOrNil(paramString3))
    {
      l.a(this.AzD, this.iaj.appId, this.iaj.appName, this.bZZ, "", this.AzE, MsgRetransmitUI.a(this.Azx), paramString3);
      AppMethodBeat.o(35083);
      return;
    }
    h.b(this.Azx, this.Azx.getString(2131298861), "", true);
    this.Azx.finish();
    AppMethodBeat.o(35083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.19
 * JD-Core Version:    0.7.0.1
 */