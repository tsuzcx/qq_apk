package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class m
  implements u.a
{
  public ImageView fUN;
  public TextView titleTv;
  public n.a wOw;
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67045);
    if ((this.wOw == null) || (bt.isNullOrNil(this.wOw.iconUrl)))
    {
      AppMethodBeat.o(67045);
      return;
    }
    if (paramString.equals(this.wOw.iconUrl)) {
      this.fUN.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67044);
          m.this.fUN.setImageBitmap(paramBitmap);
          AppMethodBeat.o(67044);
        }
      });
    }
    AppMethodBeat.o(67045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.m
 * JD-Core Version:    0.7.0.1
 */