package com.tencent.mm.plugin.profile.ui.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;

public final class a
  extends BitmapDrawable
  implements x.a
{
  private String url;
  
  public a(Resources paramResources, String paramString) {}
  
  public final void draw(Canvas paramCanvas)
  {
    Object localObject2 = x.a(new a.1(this));
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
  }
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if (this.url.equals(paramString)) {
      invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.a
 * JD-Core Version:    0.7.0.1
 */