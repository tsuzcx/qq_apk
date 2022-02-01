package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.fap;
import com.tencent.mm.ui.base.m;

final class a$4
  implements View.OnClickListener
{
  a$4(a parama, m paramm, int paramInt1, int paramInt2, String paramString, q paramq, fap paramfap) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(224588);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/applet/AddContact$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.ReX.bYF();
    a.a(this.ReV, this.val$errType, this.val$errCode, this.val$errMsg, this.ftz, this.ReW.UAD);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/AddContact$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(224588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.a.4
 * JD-Core Version:    0.7.0.1
 */