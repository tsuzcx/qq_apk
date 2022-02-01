package com.tencent.mm.plugin.webview.fts.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FtsWebVideoView$10
  extends BroadcastReceiver
{
  FtsWebVideoView$10(FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(78048);
    if (FtsWebVideoView.d(this.WCO).isPlaying()) {
      FtsWebVideoView.a(this.WCO, paramContext);
    }
    AppMethodBeat.o(78048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.10
 * JD-Core Version:    0.7.0.1
 */