package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.sdk.platformtools.ab;

final class i$1$1
  implements d.a
{
  i$1$1(i.1 param1, com.tencent.mm.plugin.record.a.i parami, d paramd) {}
  
  public final void ar(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135669);
    ab.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 callback [%d, %d], [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 == 102))
    {
      ab.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 MM_ERR_GET_AESKEY_FAILED old status[%d, %d, %d]", new Object[] { Integer.valueOf(this.pYD.field_status), Integer.valueOf(this.pYD.field_offset), Integer.valueOf(this.pYD.field_totalLen) });
      this.pYD.field_offset = 0;
      this.pYD.field_totalLen = 0;
      this.pYD.field_status = 0;
      ((a)g.G(a.class)).getRecordMsgCDNStorage().b(this.pYD, new String[] { "localId" });
      this.pYF.pYC.a(this.pYD, false);
      AppMethodBeat.o(135669);
      return;
    }
    this.pYD.field_cdnKey = paramString;
    this.pYD.field_cdnUrl = this.pYE.field_fileId;
    ((a)g.G(a.class)).getRecordMsgCDNStorage().b(this.pYD, new String[] { "localId" });
    this.pYF.pYC.cfS();
    AppMethodBeat.o(135669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.i.1.1
 * JD-Core Version:    0.7.0.1
 */