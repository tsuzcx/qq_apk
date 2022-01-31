package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwv;

final class n$b$1
  implements View.OnClickListener
{
  n$b$1(n.b paramb, bwv parambwv, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(79178);
    if (this.iBz.xJY == 2)
    {
      this.vbD.setImageResource(2131231594);
      this.iBz.xJY = 1;
      AppMethodBeat.o(79178);
      return;
    }
    if (this.iBz.xJY == 1)
    {
      this.vbD.setImageResource(2131231592);
      this.iBz.xJY = 2;
    }
    AppMethodBeat.o(79178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.b.1
 * JD-Core Version:    0.7.0.1
 */