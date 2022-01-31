package com.tencent.mm.plugin.webview.fts.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class FtsWebVideoView$10
  extends BroadcastReceiver
{
  FtsWebVideoView$10(FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (FtsWebVideoView.d(this.raW).isPlaying()) {
      FtsWebVideoView.a(this.raW, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.10
 * JD-Core Version:    0.7.0.1
 */