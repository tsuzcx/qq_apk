package com.tencent.mm.plugin.order.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x.a;

final class MallOrderProductListUI$b
  implements x.a
{
  String kmm;
  ImageView kxr;
  TextView pqW;
  TextView pqX;
  TextView pqY;
  TextView pqZ;
  TextView pra;
  
  private MallOrderProductListUI$b(MallOrderProductListUI paramMallOrderProductListUI) {}
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(43841);
    if ((paramString != null) && (paramString.equals(this.kmm))) {
      this.kxr.post(new MallOrderProductListUI.b.1(this, paramBitmap));
    }
    AppMethodBeat.o(43841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderProductListUI.b
 * JD-Core Version:    0.7.0.1
 */