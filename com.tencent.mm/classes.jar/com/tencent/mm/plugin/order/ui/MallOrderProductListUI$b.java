package com.tencent.mm.plugin.order.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.x.a;

final class MallOrderProductListUI$b
  implements x.a
{
  String ilp;
  ImageView iwn;
  TextView mQJ;
  TextView mQK;
  TextView mQL;
  TextView mQM;
  TextView mQN;
  
  private MallOrderProductListUI$b(MallOrderProductListUI paramMallOrderProductListUI) {}
  
  public final void l(String paramString, Bitmap paramBitmap)
  {
    if ((paramString != null) && (paramString.equals(this.ilp))) {
      this.iwn.post(new MallOrderProductListUI.b.1(this, paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderProductListUI.b
 * JD-Core Version:    0.7.0.1
 */