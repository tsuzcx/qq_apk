package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;

final class by
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(139433);
    if (WebView.h() == null)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
      AppMethodBeat.o(139433);
      return;
    }
    o localo = o.a(true);
    if (o.b)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
      AppMethodBeat.o(139433);
      return;
    }
    aj localaj = aj.a(WebView.h());
    int i = localaj.c();
    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = ".concat(String.valueOf(i)));
    if (i == 2)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
      localo.a(String.valueOf(localaj.b()));
      localo.b(true);
      AppMethodBeat.o(139433);
      return;
    }
    int j = localaj.b("copy_status");
    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = ".concat(String.valueOf(j)));
    if (j == 1)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
      localo.a(String.valueOf(localaj.c("copy_core_ver")));
      localo.b(true);
      AppMethodBeat.o(139433);
      return;
    }
    if ((!bz.a().b()) && ((i == 3) || (j == 3)))
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
      localo.a(String.valueOf(o.d()));
      localo.b(true);
    }
    AppMethodBeat.o(139433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.by
 * JD-Core Version:    0.7.0.1
 */