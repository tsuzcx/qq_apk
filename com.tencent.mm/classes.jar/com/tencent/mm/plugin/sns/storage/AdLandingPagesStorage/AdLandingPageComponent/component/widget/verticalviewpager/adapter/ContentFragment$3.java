package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.lucky.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import java.util.Map;

final class ContentFragment$3
  implements Runnable
{
  ContentFragment$3(ContentFragment paramContentFragment, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    float f = 1.0F;
    Object localObject3 = null;
    AppMethodBeat.i(37618);
    ab.i("ContentFragment", "download bg ok path %s ", new Object[] { this.val$path });
    for (;;)
    {
      try
      {
        Bitmap localBitmap1;
        if (ContentFragment.d(this.rzA).rCf)
        {
          ContentFragment.e(this.rzA);
          String str = h.gy(this.rzB, this.hZk + "_blurimg");
          if (!e.cN(str))
          {
            Bitmap localBitmap2 = d.decodeFile(this.val$path, null);
            Object localObject1 = localObject3;
            int i;
            int j;
            int k;
            int m;
            if (localBitmap2 != null)
            {
              if ((localBitmap2.getHeight() < ContentFragment.f(this.rzA)) || (localBitmap2.getWidth() < ContentFragment.g(this.rzA))) {
                f = Math.max(ContentFragment.g(this.rzA) * 1.0F / localBitmap2.getWidth(), 1.0F * ContentFragment.f(this.rzA) / localBitmap2.getHeight());
              }
              localObject1 = d.b(localBitmap2, 0.0F, f, f);
              i = ((Bitmap)localObject1).getWidth();
              j = ContentFragment.g(this.rzA);
              k = ((Bitmap)localObject1).getHeight();
              m = ContentFragment.f(this.rzA);
            }
            try
            {
              localObject1 = Bitmap.createBitmap((Bitmap)localObject1, i - j >>> 1, k - m >>> 1, ContentFragment.g(this.rzA), ContentFragment.f(this.rzA));
              if (localObject1 == null) {
                break label382;
              }
              localObject1 = a.a((Bitmap)localObject1, str, Color.argb(140, 0, 0, 0), 180);
              break label385;
              al.d(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(37617);
                  if (this.rzC == null)
                  {
                    ab.i("ContentFragment", "decode img fail, set bg color %s", new Object[] { ContentFragment.3.this.hZk });
                    ContentFragment.h(ContentFragment.3.this.rzA);
                    AppMethodBeat.o(37617);
                    return;
                  }
                  ab.i("ContentFragment", "set bg with bitmap");
                  ContentFragment.i(ContentFragment.3.this.rzA).put(ContentFragment.3.this.hZk, this.rzC);
                  ContentFragment.a(ContentFragment.3.this.rzA, this.rzC);
                  AppMethodBeat.o(37617);
                }
              });
              AppMethodBeat.o(37618);
              return;
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              ab.printErrStackTrace("ContentFragment", localOutOfMemoryError, "", new Object[0]);
              localBitmap1 = null;
              continue;
            }
            localBitmap1 = localBitmap1.XT();
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
          localBitmap1 = d.decodeFile(this.val$path, null);
          continue;
        }
        localObject2 = null;
      }
      catch (Exception localException)
      {
        ab.e("ContentFragment", "the backgroundCoverUrl is set error ,because " + localException.toString());
        AppMethodBeat.o(37618);
        return;
      }
      label382:
      Object localObject2;
      label385:
      if (localObject2 == null) {
        localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.3
 * JD-Core Version:    0.7.0.1
 */