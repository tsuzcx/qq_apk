package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.Set;

final class b$1
  extends c
{
  b$1(b paramb) {}
  
  public final void p(String paramString, Bitmap paramBitmap)
  {
    Iterator localIterator = b.a(this.ogK).iterator();
    while (localIterator.hasNext())
    {
      b.e locale = (b.e)localIterator.next();
      if ((locale.ogR != null) && (bk.aM(paramString, "").equals(locale.ogR.field_fileName))) {
        locale.ogP.setThumbBmp(paramBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b.1
 * JD-Core Version:    0.7.0.1
 */