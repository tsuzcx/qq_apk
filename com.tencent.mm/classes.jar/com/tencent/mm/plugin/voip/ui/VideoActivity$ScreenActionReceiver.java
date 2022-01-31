package com.tencent.mm.plugin.voip.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

public class VideoActivity$ScreenActionReceiver
  extends BroadcastReceiver
{
  public VideoActivity$ScreenActionReceiver(VideoActivity paramVideoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.intent.action.SCREEN_OFF")))
    {
      y.i("MicroMsg.Voip.VideoActivity", "receive action screen off");
      this.pWM.bRV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity.ScreenActionReceiver
 * JD-Core Version:    0.7.0.1
 */