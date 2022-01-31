package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.kernel.b;
import com.tencent.mm.model.aj;
import com.tencent.mm.sdk.platformtools.y;

public final class a$2
  implements aj
{
  public a$2(a parama) {}
  
  public final void hK(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= 100))
    {
      b.a(null);
      this.nQF.eAp = false;
    }
    y.d("MicroMsg.FixToolsUplogModel", "ipxx progress:%d, isUploading:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.nQF.eAp) });
    a.nQD.xa(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.a.2
 * JD-Core Version:    0.7.0.1
 */