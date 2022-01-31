package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.sdk.platformtools.ah;

public final class m$6
  implements Runnable
{
  public m$6(m paramm, String paramString) {}
  
  public final void run()
  {
    if (this.sgS.cd(this.ezi))
    {
      this.sgS.mHandler.sendEmptyMessage(20003);
      return;
    }
    this.sgS.mHandler.removeMessages(20003);
    this.sgS.mHandler.sendEmptyMessage(20001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m.6
 * JD-Core Version:    0.7.0.1
 */