package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class bu
  extends Thread
{
  public final void run()
  {
    if (WebView.h() == null) {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
    }
    o localo;
    int i;
    int j;
    do
    {
      return;
      localo = o.a(true);
      if (o.a)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
        return;
      }
      ai localai = ai.a(WebView.h());
      i = localai.c();
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + i);
      if (i == 2)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
        localo.a(String.valueOf(localai.b()));
        localo.b(true);
        return;
      }
      j = localai.b("copy_status");
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + j);
      if (j == 1)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
        localo.a(String.valueOf(localai.c("copy_core_ver")));
        localo.b(true);
        return;
      }
    } while ((bv.a().b()) || ((i != 3) && (j != 3)));
    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
    localo.a(String.valueOf(o.d()));
    localo.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.bu
 * JD-Core Version:    0.7.0.1
 */