package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.a;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.picker.d.b;

final class RemittanceBusiUI$11
  implements d.b
{
  RemittanceBusiUI$11(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void kx(boolean paramBoolean)
  {
    AppMethodBeat.i(142184);
    if (paramBoolean)
    {
      localObject = RemittanceBusiUI.H(this.qoF).qkU;
      if (localObject != null) {
        break label56;
      }
    }
    label56:
    for (Object localObject = "";; localObject = a.a((adg)localObject))
    {
      ab.i("MicroMsg.RemittanceBusiUI", "onFavorSelected %s ", new Object[] { localObject });
      RemittanceBusiUI.I(this.qoF);
      AppMethodBeat.o(142184);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.11
 * JD-Core Version:    0.7.0.1
 */