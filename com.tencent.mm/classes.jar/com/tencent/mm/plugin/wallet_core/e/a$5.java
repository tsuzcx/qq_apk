package com.tencent.mm.plugin.wallet_core.e;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.platformtools.bk;

final class a$5
  implements Runnable
{
  a$5(a parama, e parame, ImageView paramImageView, a.b paramb) {}
  
  public final void run()
  {
    if (!bk.bl(this.qJq.qtT))
    {
      localBitmap = x.a(new c(this.qJq.qtT));
      this.jxK.setImageBitmap(localBitmap);
      x.a(this.qJo);
    }
    while (this.qJq.qtX <= 0)
    {
      Bitmap localBitmap;
      return;
    }
    this.jxK.setImageResource(this.qJq.qtX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.e.a.5
 * JD-Core Version:    0.7.0.1
 */