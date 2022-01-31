package com.tencent.mm.plugin.product.ui;

import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallProductUI$1$1
  implements Runnable
{
  MallProductUI$1$1(MallProductUI.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(44156);
    ScrollView localScrollView = (ScrollView)this.pxm.pxl.findViewById(2131826831);
    if (localScrollView != null) {
      localScrollView.pageScroll(33);
    }
    AppMethodBeat.o(44156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.1.1
 * JD-Core Version:    0.7.0.1
 */