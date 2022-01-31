package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$i
  implements View.OnClickListener
{
  b$i(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155235);
    ab.i("MicroMsg.TransVoiceDialog", "sendVoiceMsg onClick.");
    paramView = this.tqJ.tqz;
    if ((paramView != null) && (true == paramView.a(this.tqJ.tqh, Long.valueOf(this.tqJ.tqg)))) {
      b.E(this.tqJ);
    }
    b.b(this.tqJ, 7);
    AppMethodBeat.o(155235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.i
 * JD-Core Version:    0.7.0.1
 */