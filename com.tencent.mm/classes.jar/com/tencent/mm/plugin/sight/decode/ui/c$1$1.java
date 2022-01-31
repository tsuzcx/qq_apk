package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.tencent.mm.plugin.ai.a.e;
import com.tencent.mm.plugin.ai.a.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.io.File;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, Bitmap paramBitmap, String paramString) {}
  
  public final void run()
  {
    Object localObject = (ImageView)this.ofX.ofW.findViewById(a.e.videoplayer_maskview);
    ((ImageView)localObject).setImageBitmap(this.nui);
    ((ImageView)localObject).setVisibility(0);
    localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setDataAndType(Uri.fromFile(new File(this.gBs)), "video/*");
    try
    {
      this.ofX.ofW.getContext().startActivity(Intent.createChooser((Intent)localObject, this.ofX.ofW.getContext().getString(a.h.app_video_for_icon)));
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
      h.h(this.ofX.ofW.getContext(), a.h.no_match_application_msg, a.h.no_match_application_title);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.c.1.1
 * JD-Core Version:    0.7.0.1
 */