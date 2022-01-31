package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.io.File;

final class k$1$1
  implements Runnable
{
  k$1$1(k.1 param1, String paramString) {}
  
  public final void run()
  {
    if (bk.bl(this.gBs))
    {
      h.h(this.vxA.vxz.vuf.vtJ, R.l.video_file_play_faile, R.l.chatting_play_err);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(new File(this.gBs)), "video/*");
    try
    {
      this.vxA.vxz.vuf.vtJ.startActivity(Intent.createChooser(localIntent, this.vxA.vxz.vuf.vtJ.mController.uMN.getString(R.l.favorite_video)));
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
      h.h(this.vxA.vxz.vuf.vtJ, R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.1.1
 * JD-Core Version:    0.7.0.1
 */