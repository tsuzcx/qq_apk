package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.u.a.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

final class a$1$1$4
  implements Runnable
{
  a$1$1$4(a.1.1 param1, Bitmap paramBitmap) {}
  
  public final void run()
  {
    this.mpy.mpx.mpw.dnV = h.b(this.mpy.mpx.mpw.bER, this.mpy.mpx.mpw.bER.getString(a.h.mmsight_video_edit_processing), false, null);
    this.mpy.mpx.mpw.mlw.pause();
    a.a(this.mpy.mpx.mpw, this.ara);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.a.1.1.4
 * JD-Core Version:    0.7.0.1
 */