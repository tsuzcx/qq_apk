package com.tencent.mm.plugin.music.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ak;

final class c$1
  implements g
{
  c$1(c paramc) {}
  
  public final Bitmap a(String paramString, View paramView, com.tencent.mm.as.a.d.b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, com.tencent.mm.as.a.d.b paramb)
  {
    if (paramb.bitmap != null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.Music.MusicImageLoader", "onImageLoadFinish %s %b", new Object[] { paramString, Boolean.valueOf(bool) });
      paramString = (a)paramView.getTag();
      if ((paramb.bitmap != null) && (paramString != null))
      {
        this.mzu.a(paramString, paramb.bitmap);
        paramView = ak.Y(paramb.bitmap);
        if (!paramString.o(paramView)) {
          e.bnq().Y(paramString.field_musicId, paramView[0], paramView[1]);
        }
        if (this.mzu.mzr != null) {
          ai.d(new c.1.1(this, paramString, paramView));
        }
      }
      return;
    }
  }
  
  public final void mv(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c.1
 * JD-Core Version:    0.7.0.1
 */