package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class m
  implements x.a
{
  public ImageView iQd;
  public n.a pwO;
  public TextView titleTv;
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(44138);
    if ((this.pwO == null) || (bo.isNullOrNil(this.pwO.iconUrl)))
    {
      AppMethodBeat.o(44138);
      return;
    }
    if (paramString.equals(this.pwO.iconUrl)) {
      this.iQd.post(new m.1(this, paramBitmap));
    }
    AppMethodBeat.o(44138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.m
 * JD-Core Version:    0.7.0.1
 */