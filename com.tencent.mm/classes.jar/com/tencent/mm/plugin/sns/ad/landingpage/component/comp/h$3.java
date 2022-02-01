package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.util.Map;

final class h$3
  implements Runnable
{
  h$3(h paramh, String paramString, ImageView paramImageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(310675);
    final Bitmap localBitmap = AdLandingPagesProxy.getInstance().getAvatarByUserName(this.lzH, false);
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310744);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          h.3.this.PRl.setImageBitmap(localBitmap);
          ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(h.3.this.PRl, "alpha", new float[] { 0.5F, 1.0F });
          localObjectAnimator.setDuration(200L);
          localObjectAnimator.start();
          Log.i("AdLandingSocialCardComponent", "loadAvatarByUserName end, userName=" + h.3.this.lzH + ", w=" + localBitmap.getWidth() + ", h=" + localBitmap.getHeight());
          AppMethodBeat.o(310744);
          return;
        }
        if (h.3.this.PRL.PRI) {
          h.3.this.PRL.PRH.put(h.3.this.lzH, h.3.this.PRl);
        }
        Log.w("AdLandingSocialCardComponent", "loadAvatarByUserName end, userName=" + h.3.this.lzH + ", bmp=null, isNeedRetry=" + h.3.this.PRL.PRI);
        AppMethodBeat.o(310744);
      }
    });
    AppMethodBeat.o(310675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.h.3
 * JD-Core Version:    0.7.0.1
 */