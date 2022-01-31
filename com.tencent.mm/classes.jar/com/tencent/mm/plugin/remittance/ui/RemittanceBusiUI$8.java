package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.protocal.c.yz;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.picker.d.b;

final class RemittanceBusiUI$8
  implements d.b
{
  RemittanceBusiUI$8(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void it(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = RemittanceBusiUI.A(this.nCA).nzH;
      if (localObject != null) {
        break label46;
      }
    }
    label46:
    for (Object localObject = "";; localObject = com.tencent.mm.plugin.remittance.model.a.a((yz)localObject))
    {
      y.i("MicroMsg.RemittanceBusiUI", "onFavorSelected %s ", new Object[] { localObject });
      RemittanceBusiUI.B(this.nCA);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.8
 * JD-Core Version:    0.7.0.1
 */