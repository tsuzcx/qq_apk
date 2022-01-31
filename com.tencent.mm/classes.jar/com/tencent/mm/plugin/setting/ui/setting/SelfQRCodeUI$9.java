package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import com.tencent.mm.bf.e;
import com.tencent.mm.br.d;
import com.tencent.mm.r.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class SelfQRCodeUI$9
  implements n.d
{
  SelfQRCodeUI$9(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        do
        {
          return;
          SelfQRCodeUI.e(this.nSB);
          return;
          SelfQRCodeUI.a(this.nSB, 0);
          return;
        } while (a.bj(this.nSB.mController.uMN));
        paramMenuItem = this.nSB.mController.uMN;
      } while (e.RS());
      d.x(this.nSB.mController.uMN, "scanner", ".ui.BaseScanUI");
      return;
    }
    SelfQRCodeUI.f(this.nSB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.9
 * JD-Core Version:    0.7.0.1
 */