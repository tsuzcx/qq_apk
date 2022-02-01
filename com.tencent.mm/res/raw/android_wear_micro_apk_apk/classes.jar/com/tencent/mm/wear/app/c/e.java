package com.tencent.mm.wear.app.c;

import android.widget.ImageView;
import com.tencent.mm.wear.a.c.d;

final class e
  extends com.tencent.mm.wear.app.g.a
{
  private a agy;
  
  public e(b paramb, a parama)
  {
    this.agy = parama;
  }
  
  protected final void execute()
  {
    d.d("MicroMsg.MMImageLoader", "RenderImageViewInUIThread: execute-%d -%s", new Object[] { Integer.valueOf(this.agy.type), this.agy.agl });
    ImageView localImageView = this.agy.agm;
    if ((localImageView == null) || (!this.agy.agl.equals(localImageView.getTag())))
    {
      d.d("MicroMsg.MMImageLoader", "imageView is null or cacheKey problem", new Object[0]);
      return;
    }
    b.a(this.agx, this.agy);
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