package com.tencent.mm.sandbox.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;

final class AppUpdaterUI$7
  implements Runnable
{
  AppUpdaterUI$7(AppUpdaterUI paramAppUpdaterUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(28822);
    h.a(this.ykv, AppUpdaterUI.e(this.ykv).desc, this.ykv.getString(2131297087), new AppUpdaterUI.7.1(this)).setOnCancelListener(new AppUpdaterUI.7.2(this));
    AppMethodBeat.o(28822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.7
 * JD-Core Version:    0.7.0.1
 */