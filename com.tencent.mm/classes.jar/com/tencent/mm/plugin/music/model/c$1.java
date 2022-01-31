package com.tencent.mm.plugin.music.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.af;

final class c$1
  implements g
{
  c$1(c paramc) {}
  
  public final Bitmap a(String paramString, View paramView, com.tencent.mm.at.a.d.b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, com.tencent.mm.at.a.d.b paramb)
  {
    AppMethodBeat.i(104877);
    if (paramb.bitmap != null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.Music.MusicImageLoader", "onImageLoadFinish %s %b", new Object[] { paramString, Boolean.valueOf(bool) });
      paramString = (a)paramView.getTag();
      if ((paramb.bitmap != null) && (paramString != null))
      {
        this.oZA.a(paramString, paramb.bitmap);
        paramView = af.ao(paramb.bitmap);
        if (!paramString.y(paramView)) {
          e.bVM().ap(paramString.field_musicId, paramView[0], paramView[1]);
        }
        if (this.oZA.oZx != null) {
          al.d(new c.1.1(this, paramString, paramView));
        }
      }
      AppMethodBeat.o(104877);
      return;
    }
  }
  
  public final void tF(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.c.1
 * JD-Core Version:    0.7.0.1
 */