package com.tencent.mm.plugin.voip.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class VideoActivity$ScreenActionReceiver
  extends BroadcastReceiver
{
  public VideoActivity$ScreenActionReceiver(VideoActivity paramVideoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(115322);
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.intent.action.SCREEN_OFF")))
    {
      ad.i("MicroMsg.Voip.VideoActivity", "receive action screen off, mActivityStatus:%s", new Object[] { Integer.valueOf(VideoActivity.g(this.zro)) });
      VideoActivity.g(this.zro);
    }
    AppMethodBeat.o(115322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity.ScreenActionReceiver
 * JD-Core Version:    0.7.0.1
 */