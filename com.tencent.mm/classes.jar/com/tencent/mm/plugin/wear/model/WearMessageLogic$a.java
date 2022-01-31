package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.sdk.platformtools.y;

final class WearMessageLogic$a
  extends d
{
  public int igH;
  public int qRZ;
  public int qSa;
  public byte[] qSb;
  
  private WearMessageLogic$a(WearMessageLogic paramWearMessageLogic) {}
  
  protected final void execute()
  {
    y.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", new Object[] { toString() });
    com.tencent.mm.plugin.wear.model.e.a locala = a.bYL().qRs.Bj(this.qSa);
    if (locala != null) {
      locala.b(this.qRZ, this.igH, this.qSa, this.qSb);
    }
  }
  
  public final String getName()
  {
    return "HttpMessageTask";
  }
  
  public final String toString()
  {
    return String.format("connectType=%d funId=%d sessionId=%d", new Object[] { Integer.valueOf(this.qRZ), Integer.valueOf(this.qSa), Integer.valueOf(this.igH) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.WearMessageLogic.a
 * JD-Core Version:    0.7.0.1
 */