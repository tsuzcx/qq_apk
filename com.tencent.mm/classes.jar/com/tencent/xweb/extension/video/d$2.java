package com.tencent.xweb.extension.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.util.l;

final class d$2
  implements View.OnClickListener
{
  d$2(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212685);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/xweb/extension/video/XWebNativeInterface$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    l.kii();
    this.aihL.aa(1.0D);
    a.a(this, "com/tencent/xweb/extension/video/XWebNativeInterface$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.2
 * JD-Core Version:    0.7.0.1
 */