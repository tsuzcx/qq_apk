package com.tencent.mm.plugin.wepkg.ipc;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;

final class WepkgMainProcessService$2
  extends a.a
{
  WepkgMainProcessService$2(WepkgMainProcessService paramWepkgMainProcessService) {}
  
  public final void m(Message paramMessage)
  {
    WepkgMainProcessService.a(this.rOW).send(paramMessage);
  }
  
  public final void t(Bundle paramBundle)
  {
    WepkgMainProcessService.aj(paramBundle).Zu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService.2
 * JD-Core Version:    0.7.0.1
 */