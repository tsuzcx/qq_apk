package com.tencent.mm.plugin.topstory.ui.home;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class TopStoryUploadUI$2
  implements g
{
  TopStoryUploadUI$2(TopStoryUploadUI paramTopStoryUploadUI) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(1681);
    if ((paramb == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
    {
      ab.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap bitmap is null");
      AppMethodBeat.o(1681);
      return null;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap url is null");
      AppMethodBeat.o(1681);
      return null;
    }
    if (!(paramView instanceof ImageView))
    {
      ab.w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap view not ImageView");
      AppMethodBeat.o(1681);
      return null;
    }
    if (paramb.bitmap.getWidth() < paramb.bitmap.getHeight()) {
      ((ImageView)paramView).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    for (;;)
    {
      AppMethodBeat.o(1681);
      return null;
      ((ImageView)paramView).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public final void b(String paramString, View paramView, b paramb) {}
  
  public final void tF(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI.2
 * JD-Core Version:    0.7.0.1
 */