package com.tencent.mm.wear.app.c;

import android.widget.ImageView;
import com.tencent.mm.wear.a.c.d;

final class e
  extends com.tencent.mm.wear.app.g.a
{
  private a acX;
  
  public e(b paramb, a parama)
  {
    this.acX = parama;
  }
  
  protected final void execute()
  {
    d.e("MicroMsg.MMImageLoader", "RenderImageViewInUIThread: execute-%d -%s", new Object[] { Integer.valueOf(this.acX.type), this.acX.acK });
    ImageView localImageView = this.acX.acL;
    if ((localImageView == null) || (!this.acX.acK.equals(localImageView.getTag())))
    {
      d.e("MicroMsg.MMImageLoader", "imageView is null or cacheKey problem", new Object[0]);
      return;
    }
    b.a(this.acW, this.acX);
  }
  
  protected final String getName()
  {
    return "RenderImageViewInUIThread";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.c.e
 * JD-Core Version:    0.7.0.1
 */