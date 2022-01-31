package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.api.d;
import com.tencent.mm.api.p;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

final class a$5
  implements p
{
  a$5(a parama) {}
  
  public final void a(d paramd)
  {
    y.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", new Object[] { paramd.name() });
    if (paramd == d.buQ) {
      a.a(this.mpw);
    }
  }
  
  public final void a(d paramd, int paramInt)
  {
    y.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedDetailFeature] features:%s index:%s", new Object[] { paramd.name(), Integer.valueOf(paramInt) });
  }
  
  public final void aL(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mpw.bER.showVKB();
      return;
    }
    this.mpw.bER.hideVKB(this.mpw.mpj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.a.5
 * JD-Core Version:    0.7.0.1
 */