package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;

final class WebView$9
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(54930);
    if (WebView.h() == null)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
      AppMethodBeat.o(54930);
      return;
    }
    g localg = g.a(true);
    if (g.b)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
      AppMethodBeat.o(54930);
      return;
    }
    n localn = n.a(WebView.h());
    int i = localn.c();
    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = ".concat(String.valueOf(i)));
    if (i == 2)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
      localg.a(String.valueOf(localn.b()));
      localg.b(true);
      AppMethodBeat.o(54930);
      return;
    }
    int j = localn.b("copy_status");
    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = ".concat(String.valueOf(j)));
    if (j == 1)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
      localg.a(String.valueOf(localn.c("copy_core_ver")));
      localg.b(true);
      AppMethodBeat.o(54930);
      return;
    }
    if ((!x.a().b()) && ((i == 3) || (j == 3)))
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
      localg.a(String.valueOf(g.d()));
      localg.b(true);
    }
    AppMethodBeat.o(54930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.9
 * JD-Core Version:    0.7.0.1
 */