package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.a.e;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements am.a
{
  c$1(c paramc) {}
  
  public final boolean tC()
  {
    long l1 = e.bJ(this.qSv.filename);
    long l2 = l1 - this.qSv.qSs;
    y.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", new Object[] { this.qSv.filename, Long.valueOf(l1), Integer.valueOf(this.qSv.qSs), Boolean.valueOf(this.qSv.eJS), Long.valueOf(l2) });
    if ((l2 < 3300L) && (!this.qSv.eJS)) {
      return true;
    }
    if ((this.qSv.eJS) && (l2 <= 0L)) {
      return false;
    }
    if (this.qSv.a(this.qSv.edc, this.qSv.dmL) == -1) {
      this.qSv.dmL.onSceneEnd(3, -1, "doScene failed", this.qSv);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.c.1
 * JD-Core Version:    0.7.0.1
 */