package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class FakeSwitchAccountUI$1
  implements ap.a
{
  FakeSwitchAccountUI$1(FakeSwitchAccountUI paramFakeSwitchAccountUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(126954);
    int i = FakeSwitchAccountUI.a(this.qFT);
    ab.i("MicroMsg.FakeSwitchAccountUI", "oldPid %d, mm pid %d", new Object[] { Integer.valueOf(FakeSwitchAccountUI.b(this.qFT)), Integer.valueOf(i) });
    if ((FakeSwitchAccountUI.b(this.qFT) != 0) && (i != 0) && (FakeSwitchAccountUI.b(this.qFT) != i))
    {
      if (FakeSwitchAccountUI.c(this.qFT) <= 0)
      {
        FakeSwitchAccountUI.d(this.qFT);
        AppMethodBeat.o(126954);
        return true;
      }
      FakeSwitchAccountUI.e(this.qFT);
      AppMethodBeat.o(126954);
      return false;
    }
    FakeSwitchAccountUI.d(this.qFT);
    if (FakeSwitchAccountUI.c(this.qFT) <= 20)
    {
      AppMethodBeat.o(126954);
      return true;
    }
    FakeSwitchAccountUI.e(this.qFT);
    AppMethodBeat.o(126954);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI.1
 * JD-Core Version:    0.7.0.1
 */