package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bw;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Queue;

public final class b
  implements c, com.tencent.mm.plugin.zero.b.b
{
  private bw rRX;
  private o rRY;
  
  public final o Pm()
  {
    g.DQ();
    g.DN().CX();
    if (this.rRY == null) {
      this.rRY = new o();
    }
    return this.rRY;
  }
  
  public final bw ckh()
  {
    g.DQ();
    g.DN().CX();
    if (this.rRX == null) {
      this.rRX = new bw(new b.1(this));
    }
    return this.rRX;
  }
  
  public final void onAccountInitialized(e.c paramc) {}
  
  public final void onAccountRelease()
  {
    if (this.rRY != null)
    {
      o localo = this.rRY;
      y.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", new Object[] { Integer.valueOf(localo.etI.size()), Integer.valueOf(localo.etJ.size()), localo.etL });
      localo.etI.clear();
      localo.etJ.clear();
    }
    if (this.rRX != null) {
      this.rRX.Im();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.b
 * JD-Core Version:    0.7.0.1
 */