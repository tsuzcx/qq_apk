package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.al;
import com.tencent.mm.sdk.platformtools.ab;

public final class a$2
  implements al
{
  public a$2(a parama) {}
  
  public final void kw(int paramInt)
  {
    AppMethodBeat.i(126837);
    if ((paramInt < 0) || (paramInt >= 100))
    {
      b.a(null);
      this.qEC.fQi = false;
    }
    ab.d("MicroMsg.FixToolsUplogModel", "ipxx progress:%d, isUploading:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.qEC.fQi) });
    a.qEA.CV(paramInt);
    AppMethodBeat.o(126837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.a.2
 * JD-Core Version:    0.7.0.1
 */