package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.product.model.m.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
  implements r.a
{
  public m.a MTm;
  public ImageView lPb;
  public TextView titleTv;
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(67045);
    if ((this.MTm == null) || (Util.isNullOrNil(this.MTm.iconUrl)))
    {
      AppMethodBeat.o(67045);
      return;
    }
    if (paramString.equals(this.MTm.iconUrl)) {
      this.lPb.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(67044);
          m.this.lPb.setImageBitmap(paramBitmap);
          AppMethodBeat.o(67044);
        }
      });
    }
    AppMethodBeat.o(67045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.m
 * JD-Core Version:    0.7.0.1
 */