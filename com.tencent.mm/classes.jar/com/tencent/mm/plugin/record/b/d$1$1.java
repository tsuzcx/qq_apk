package com.tencent.mm.plugin.record.b;

import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.pluginsdk.model.app.ab.a;
import com.tencent.mm.sdk.platformtools.y;

final class d$1$1
  implements ab.a
{
  d$1$1(d.1 param1, f paramf, com.tencent.mm.j.d paramd) {}
  
  public final void aa(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 callback [%d, %d], [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 4) && (paramInt2 == 102))
    {
      y.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 MM_ERR_GET_AESKEY_FAILED old status[%d, %d, %d]", new Object[] { Integer.valueOf(this.nsX.field_status), Integer.valueOf(this.nsX.field_offset), Integer.valueOf(this.nsX.field_totalLen) });
      this.nsX.field_offset = 0;
      this.nsX.field_totalLen = 0;
      this.nsX.field_status = 0;
      n.getRecordMsgCDNStorage().b(this.nsX, new String[] { "localId" });
      this.nsZ.nsW.a(this.nsX, false);
      return;
    }
    this.nsX.field_cdnKey = paramString;
    this.nsX.field_cdnUrl = this.nsY.field_fileId;
    n.getRecordMsgCDNStorage().b(this.nsX, new String[] { "localId" });
    this.nsZ.nsW.bvx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.d.1.1
 * JD-Core Version:    0.7.0.1
 */