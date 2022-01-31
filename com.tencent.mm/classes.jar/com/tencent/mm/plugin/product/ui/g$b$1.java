package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class g$b$1
  implements View.OnClickListener
{
  g$b$1(g.b paramb, g paramg) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
    if (this.mTW.mTU.mTT != null) {
      this.mTW.mTU.mTT.bsl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.g.b.1
 * JD-Core Version:    0.7.0.1
 */