package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import java.util.HashMap;

final class j$13
  implements Runnable
{
  j$13(j paramj, String paramString) {}
  
  public final void run()
  {
    if ((this.vwT.vtH == null) || (this.vwT.vtH.cFV() == null) || (j.l(this.vwT) == null)) {
      y.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
    }
    for (;;)
    {
      return;
      this.vwT.vtH.cFV().a(false, 0.0F);
      if (!bk.bl(this.kjY)) {
        y.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", new Object[] { this.kjY });
      }
      try
      {
        Object localObject = new Intent();
        ((Intent)localObject).setAction("android.intent.action.VIEW");
        ((Intent)localObject).setDataAndType(e.aeP(this.kjY), "video/*");
        this.vwT.vtH.vtJ.startActivity((Intent)localObject);
        localObject = (j.a)j.l(this.vwT).get(j.a(this.vwT));
        if ((localObject == null) || (((j.a)localObject).bFH == null)) {
          continue;
        }
        this.vwT.HE(((j.a)localObject).pos);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
          h.h(this.vwT.vtH.vtJ, R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.13
 * JD-Core Version:    0.7.0.1
 */