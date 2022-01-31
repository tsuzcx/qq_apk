package com.tencent.mm.ui.transmit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;

final class MsgRetransmitUI$20
  implements g.a
{
  MsgRetransmitUI$20(MsgRetransmitUI paramMsgRetransmitUI, b paramb, String paramString1, bi parambi, j.b paramb1, String paramString2, byte[] paramArrayOfByte) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(35084);
    this.zyr.field_fileFullPath = this.AzF;
    if ((paramInt == 0) && (paramc != null))
    {
      this.zyr.field_offset = paramc.field_finishedLength;
      al.aUJ().a(this.zyr, new String[0]);
    }
    if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0))
    {
      this.zyr.field_status = 199L;
      this.zyr.field_offset = this.zyr.field_totalLen;
      al.aUJ().a(this.zyr, new String[0]);
      this.fkH.setStatus(3);
      aw.aaz();
      com.tencent.mm.model.c.YC().a(this.fkH.field_msgId, this.fkH);
      l.a(this.iaj, this.iaj.appId, this.iaj.appName, this.bZZ, this.AzF, this.AzE, MsgRetransmitUI.a(this.Azx));
    }
    AppMethodBeat.o(35084);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.20
 * JD-Core Version:    0.7.0.1
 */