package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements am.a
{
  b$1(b paramb) {}
  
  public final boolean tC()
  {
    g localg = h.PB(this.pvx.fileName);
    if ((localg == null) || (!localg.Tk()))
    {
      y.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.pvx.fileName);
      this.pvx.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      this.pvx.dmL.onSceneEnd(3, -1, "doScene failed", this.pvx);
    }
    do
    {
      return false;
      if ((3 != localg.field_status) && (8 != localg.field_status))
      {
        long l = System.currentTimeMillis();
        if (l / 1000L - localg.field_lastmodifytime > 30L)
        {
          y.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + this.pvx.fileName);
          this.pvx.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          this.pvx.dmL.onSceneEnd(3, -1, "doScene failed", this.pvx);
          return false;
        }
        if (l - this.pvx.eJX < 2000L)
        {
          y.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + this.pvx.fileName + " but last send time:" + (l - this.pvx.eJX));
          return true;
        }
        c.a locala = h.PC(this.pvx.fileName).zm(localg.field_offset);
        y.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + this.pvx.fileName + " readByte:" + locala.bDu + " stat:" + localg.field_status);
        if (locala.bDu < 2000) {
          return true;
        }
      }
    } while (this.pvx.a(this.pvx.edc, this.pvx.dmL) != -1);
    this.pvx.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
    this.pvx.dmL.onSceneEnd(3, -1, "doScene failed", this.pvx);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.b.1
 * JD-Core Version:    0.7.0.1
 */