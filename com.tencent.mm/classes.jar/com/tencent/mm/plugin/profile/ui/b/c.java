package com.tencent.mm.plugin.profile.ui.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;

public final class c
  extends BitmapDrawable
  implements x.a
{
  private String url;
  
  public c(Resources paramResources, String paramString) {}
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(23970);
    Object localObject2 = x.a(new c.1(this));
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((Bitmap)localObject2).isRecycled()) {}
    }
    else
    {
      localObject1 = null;
    }
    localObject2 = getBounds();
    if (localObject1 != null) {
      paramCanvas.drawBitmap(localObject1, null, (Rect)localObject2, null);
    }
    AppMethodBeat.o(23970);
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(23971);
    if (this.url.equals(paramString)) {
      invalidateSelf();
    }
    AppMethodBeat.o(23971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.c
 * JD-Core Version:    0.7.0.1
 */