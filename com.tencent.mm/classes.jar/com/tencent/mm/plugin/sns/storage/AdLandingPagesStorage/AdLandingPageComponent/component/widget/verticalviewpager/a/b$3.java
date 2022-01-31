package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.lucky.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class b$3
  implements Runnable
{
  b$3(b paramb, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    float f = 1.0F;
    Object localObject3 = null;
    y.i("ContentFragment", "download bg ok path %s ", new Object[] { this.dlh });
    for (;;)
    {
      try
      {
        Bitmap localBitmap1;
        if (b.d(this.oJz).oKw)
        {
          b.e(this.oJz);
          String str = h.eS(this.oJA, this.gBp + "_blurimg");
          if (!e.bK(str))
          {
            Bitmap localBitmap2 = c.decodeFile(this.dlh, null);
            Object localObject1 = localObject3;
            int i;
            int j;
            int k;
            int m;
            if (localBitmap2 != null)
            {
              if ((localBitmap2.getHeight() < b.f(this.oJz)) || (localBitmap2.getWidth() < b.g(this.oJz))) {
                f = Math.max(b.g(this.oJz) * 1.0F / localBitmap2.getWidth(), 1.0F * b.f(this.oJz) / localBitmap2.getHeight());
              }
              localObject1 = c.a(localBitmap2, f, f);
              i = ((Bitmap)localObject1).getWidth();
              j = b.g(this.oJz);
              k = ((Bitmap)localObject1).getHeight();
              m = b.f(this.oJz);
            }
            try
            {
              localObject1 = Bitmap.createBitmap((Bitmap)localObject1, i - j >>> 1, k - m >>> 1, b.g(this.oJz), b.f(this.oJz));
              if (localObject1 == null) {
                break label366;
              }
              localObject1 = a.a((Bitmap)localObject1, str, Color.argb(140, 0, 0, 0), 180);
              break label369;
              ai.d(new b.3.1(this, (Bitmap)localObject1));
              return;
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              y.printErrStackTrace("ContentFragment", localOutOfMemoryError, "", new Object[0]);
              localBitmap1 = null;
              continue;
            }
            localBitmap1 = localBitmap1.Fe();
            continue;
          }
          else
          {
            localBitmap1 = BitmapFactory.decodeFile(str);
            continue;
          }
        }
        else
        {
          localBitmap1 = c.decodeFile(this.dlh, null);
          continue;
        }
        localObject2 = null;
      }
      catch (Exception localException)
      {
        y.e("ContentFragment", "the backgroundCoverUrl is set error ,because " + localException.toString());
        return;
      }
      label366:
      Object localObject2;
      label369:
      if (localObject2 == null) {
        localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.3
 * JD-Core Version:    0.7.0.1
 */