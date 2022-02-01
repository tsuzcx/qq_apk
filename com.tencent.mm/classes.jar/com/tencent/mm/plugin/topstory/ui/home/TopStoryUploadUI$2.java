package com.tencent.mm.plugin.topstory.ui.home;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.ay.a.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class TopStoryUploadUI$2
  implements h
{
  TopStoryUploadUI$2(TopStoryUploadUI paramTopStoryUploadUI) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(126038);
    if ((paramb == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
    {
      Log.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap bitmap is null");
      AppMethodBeat.o(126038);
      return null;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap url is null");
      AppMethodBeat.o(126038);
      return null;
    }
    if (!(paramView instanceof ImageView))
    {
      Log.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap view not ImageView");
      AppMethodBeat.o(126038);
      return null;
    }
    if (paramb.bitmap.getWidth() < paramb.bitmap.getHeight()) {
      ((ImageView)paramView).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    for (;;)
    {
      AppMethodBeat.o(126038);
      return null;
      ((ImageView)paramView).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public final void b(String paramString, View paramView) {}
  
  public final void b(String paramString, View paramView, b paramb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI.2
 * JD-Core Version:    0.7.0.1
 */