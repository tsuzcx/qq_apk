package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class k$3
  implements View.OnClickListener
{
  k$3(k paramk) {}
  
  public final void onClick(View paramView)
  {
    if (this.vxz.vuf != null)
    {
      y.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", new Object[] { Integer.valueOf(this.vxz.hashCode()), Integer.valueOf(this.vxz.mPosition) });
      this.vxz.vuf.Ho(this.vxz.mPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.3
 * JD-Core Version:    0.7.0.1
 */