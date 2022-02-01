package com.tencent.xweb.extension.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$39
  implements View.OnClickListener
{
  d$39(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212703);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/xweb/extension/video/XWebNativeInterface$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.aihL.kgE();
    this.aihL.kgH();
    a.a(this, "com/tencent/xweb/extension/video/XWebNativeInterface$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.39
 * JD-Core Version:    0.7.0.1
 */