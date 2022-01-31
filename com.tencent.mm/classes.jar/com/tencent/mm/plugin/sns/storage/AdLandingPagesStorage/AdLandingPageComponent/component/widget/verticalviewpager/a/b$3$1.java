package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class b$3$1
  implements Runnable
{
  b$3$1(b.3 param3, Bitmap paramBitmap) {}
  
  public final void run()
  {
    if (this.oJB == null)
    {
      y.i("ContentFragment", "decode img fail, set bg color %s", new Object[] { this.oJC.gBp });
      b.h(this.oJC.oJz);
      return;
    }
    y.i("ContentFragment", "set bg with bitmap");
    b.i(this.oJC.oJz).put(this.oJC.gBp, this.oJB);
    b.a(this.oJC.oJz, this.oJB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.3.1
 * JD-Core Version:    0.7.0.1
 */