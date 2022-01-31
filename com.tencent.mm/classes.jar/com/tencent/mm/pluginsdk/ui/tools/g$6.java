package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class g$6
  implements x.a
{
  g$6(g paramg) {}
  
  public final void l(String paramString, final Bitmap paramBitmap)
  {
    boolean bool = false;
    if (paramBitmap == null) {
      bool = true;
    }
    y.v("MicroMsg.ImageEngine", "on get picture finish, notifyKey[%s], bitmap is null[%B]", new Object[] { paramString, Boolean.valueOf(bool) });
    if (paramBitmap == null) {
      return;
    }
    this.smn.smh.put(paramString, paramBitmap);
    final ImageView localImageView = (ImageView)this.smn.smf.get(paramString);
    if (localImageView != null)
    {
      this.smn.smg.remove(localImageView);
      this.smn.dPi.post(new Runnable()
      {
        public final void run()
        {
          g.d.b(localImageView, paramBitmap);
        }
      });
    }
    this.smn.smf.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g.6
 * JD-Core Version:    0.7.0.1
 */