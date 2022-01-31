package com.tencent.mm.ui.transmit;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;

final class MsgRetransmitUI$20
  implements f.a
{
  MsgRetransmitUI$20(MsgRetransmitUI paramMsgRetransmitUI, b paramb, String paramString1, bi parambi, g.a parama, String paramString2, byte[] paramArrayOfByte) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, d paramd, boolean paramBoolean)
  {
    this.vjs.field_fileFullPath = this.wgO;
    if ((paramInt == 0) && (paramc != null))
    {
      this.vjs.field_offset = paramc.field_finishedLength;
      ap.avh().c(this.vjs, new String[0]);
    }
    if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0))
    {
      this.vjs.field_status = 199L;
      this.vjs.field_offset = this.vjs.field_totalLen;
      ap.avh().c(this.vjs, new String[0]);
      this.dUy.setStatus(3);
      au.Hx();
      com.tencent.mm.model.c.Fy().a(this.dUy.field_msgId, this.dUy);
      l.a(this.gBQ, this.gBQ.appId, this.gBQ.appName, this.bxX, this.wgO, this.wgN, MsgRetransmitUI.a(this.wgG));
    }
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.20
 * JD-Core Version:    0.7.0.1
 */