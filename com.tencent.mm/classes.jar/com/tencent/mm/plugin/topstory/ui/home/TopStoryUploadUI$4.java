package com.tencent.mm.plugin.topstory.ui.home;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class TopStoryUploadUI$4
  implements h
{
  TopStoryUploadUI$4(TopStoryUploadUI paramTopStoryUploadUI) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(271759);
    Log.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap url = ".concat(String.valueOf(paramString)));
    if ((paramb == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
    {
      Log.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap bitmap is null");
      AppMethodBeat.o(271759);
      return null;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap url is null");
      AppMethodBeat.o(271759);
      return null;
    }
    if (!(paramView instanceof ImageView))
    {
      Log.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap view not ImageView");
      AppMethodBeat.o(271759);
      return null;
    }
    if (paramb.bitmap.getWidth() < paramb.bitmap.getHeight()) {
      ((ImageView)paramView).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    for (;;)
    {
      AppMethodBeat.o(271759);
      return null;
      ((ImageView)paramView).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public final void b(String paramString, View paramView, b paramb) {}
  
  public final void c(String paramString, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI.4
 * JD-Core Version:    0.7.0.1
 */