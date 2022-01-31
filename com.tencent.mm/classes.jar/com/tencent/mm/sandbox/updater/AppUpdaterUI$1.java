package com.tencent.mm.sandbox.updater;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class AppUpdaterUI$1
  implements g
{
  AppUpdaterUI$1(AppUpdaterUI paramAppUpdaterUI) {}
  
  public final void a(com.tencent.mm.sandbox.monitor.c paramc)
  {
    AppMethodBeat.i(28814);
    if (this.ykv.isFinishing())
    {
      AppMethodBeat.o(28814);
      return;
    }
    if ((paramc instanceof c))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 67L, 1L, true);
      ab.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
      if (AppUpdaterUI.b(this.ykv) != null) {
        AppUpdaterUI.b(this.ykv).setMessage(this.ykv.getString(2131300106, new Object[] { AppUpdaterUI.e(this.ykv).desc, this.ykv.getString(2131304427), bo.hk(AppUpdaterUI.e(this.ykv).size) }));
      }
      if (AppUpdaterUI.e(this.ykv).ylE)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 68L, 1L, true);
        AppUpdaterUI.a(this.ykv, paramc);
      }
      AppMethodBeat.o(28814);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 69L, 1L, true);
    com.tencent.mm.ui.base.h.a(this.ykv, 2131304428, 2131297087, new AppUpdaterUI.1.1(this), new AppUpdaterUI.1.2(this));
    AppMethodBeat.o(28814);
  }
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(28813);
    if (AppUpdaterUI.b(this.ykv) != null) {
      AppUpdaterUI.b(this.ykv).dismiss();
    }
    if (this.ykv.isFinishing())
    {
      AppMethodBeat.o(28813);
      return;
    }
    ab.d("MicroMsg.AppUpdaterUI", paramString);
    if (paramString != null)
    {
      AppUpdaterUI.a(this.ykv, paramString);
      AppUpdaterUI.a(this.ykv).setEnabled(false);
    }
    AppMethodBeat.o(28813);
  }
  
  public final void cqU()
  {
    AppMethodBeat.i(28812);
    if (this.ykv.isFinishing())
    {
      AppMethodBeat.o(28812);
      return;
    }
    AppUpdaterUI.a(this.ykv).setText(2131304430);
    AppUpdaterUI.a(this.ykv).setEnabled(false);
    AppMethodBeat.o(28812);
  }
  
  public final void dW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28809);
    if (paramInt1 <= 0) {}
    for (long l = 0L;; l = paramInt2 * 100L / paramInt1)
    {
      paramInt1 = (int)l;
      if (paramInt1 != 100) {
        break;
      }
      AppUpdaterUI.a(this.ykv).setText(this.ykv.getString(2131304432));
      AppMethodBeat.o(28809);
      return;
    }
    AppUpdaterUI.a(this.ykv).setText(this.ykv.getString(2131304430) + paramInt1 + "%");
    AppMethodBeat.o(28809);
  }
  
  public final void drA()
  {
    AppMethodBeat.i(28810);
    ab.e("MicroMsg.AppUpdaterUI", "no sdcard.");
    if (AppUpdaterUI.b(this.ykv) != null) {
      AppUpdaterUI.b(this.ykv).dismiss();
    }
    if (this.ykv.isFinishing())
    {
      AppMethodBeat.o(28810);
      return;
    }
    AppUpdaterUI.c(this.ykv);
    AppMethodBeat.o(28810);
  }
  
  public final void drB()
  {
    AppMethodBeat.i(28811);
    if (AppUpdaterUI.b(this.ykv) != null) {
      AppUpdaterUI.b(this.ykv).dismiss();
    }
    if (this.ykv.isFinishing())
    {
      AppMethodBeat.o(28811);
      return;
    }
    AppUpdaterUI.d(this.ykv);
    AppMethodBeat.o(28811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.1
 * JD-Core Version:    0.7.0.1
 */