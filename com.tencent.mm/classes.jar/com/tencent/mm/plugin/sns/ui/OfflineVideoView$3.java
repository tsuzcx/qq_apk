package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;

final class OfflineVideoView$3
  implements Runnable
{
  OfflineVideoView$3(OfflineVideoView paramOfflineVideoView, String paramString) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(e.aeP(this.kjY), "video/*");
    try
    {
      this.oRp.getContext().startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.OfflineVideoView", "startActivity fail, activity not found");
      h.h(this.oRp.getContext(), i.j.favorite_no_match_msg, i.j.favorite_no_match_title);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView.3
 * JD-Core Version:    0.7.0.1
 */