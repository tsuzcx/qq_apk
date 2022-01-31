package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class FakeSwitchAccountUI$1
  implements am.a
{
  FakeSwitchAccountUI$1(FakeSwitchAccountUI paramFakeSwitchAccountUI) {}
  
  public final boolean tC()
  {
    int i = FakeSwitchAccountUI.a(this.nRV);
    y.i("MicroMsg.FakeSwitchAccountUI", "oldPid %d, mm pid %d", new Object[] { Integer.valueOf(FakeSwitchAccountUI.b(this.nRV)), Integer.valueOf(i) });
    if ((FakeSwitchAccountUI.b(this.nRV) != 0) && (i != 0) && (FakeSwitchAccountUI.b(this.nRV) != i)) {
      if (FakeSwitchAccountUI.c(this.nRV) <= 0) {
        FakeSwitchAccountUI.d(this.nRV);
      }
    }
    do
    {
      return true;
      FakeSwitchAccountUI.e(this.nRV);
      return false;
      FakeSwitchAccountUI.d(this.nRV);
    } while (FakeSwitchAccountUI.c(this.nRV) <= 20);
    FakeSwitchAccountUI.e(this.nRV);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI.1
 * JD-Core Version:    0.7.0.1
 */