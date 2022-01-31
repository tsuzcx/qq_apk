package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class k$3
  implements View.OnClickListener
{
  k$3(k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(32384);
    if (this.zNL.zKg != null)
    {
      ab.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", new Object[] { Integer.valueOf(this.zNL.hashCode()), Integer.valueOf(this.zNL.mPosition) });
      this.zNL.zKg.PV(this.zNL.mPosition);
    }
    AppMethodBeat.o(32384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.3
 * JD-Core Version:    0.7.0.1
 */