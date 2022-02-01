package com.tencent.xweb.extension.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.util.l;

final class d$3
  implements View.OnClickListener
{
  d$3(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212695);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/xweb/extension/video/XWebNativeInterface$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    l.kij();
    this.aihL.aa(1.5D);
    a.a(this, "com/tencent/xweb/extension/video/XWebNativeInterface$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.3
 * JD-Core Version:    0.7.0.1
 */