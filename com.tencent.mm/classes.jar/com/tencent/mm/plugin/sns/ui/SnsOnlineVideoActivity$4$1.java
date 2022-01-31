package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;

final class SnsOnlineVideoActivity$4$1
  implements Runnable
{
  SnsOnlineVideoActivity$4$1(SnsOnlineVideoActivity.4 param4) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_update_preview_video_del", SnsOnlineVideoActivity.q(this.pbt.pbr));
    this.pbt.pbr.setResult(-1, localIntent);
    this.pbt.pbr.finish();
    this.pbt.pbr.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.4.1
 * JD-Core Version:    0.7.0.1
 */